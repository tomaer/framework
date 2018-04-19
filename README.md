### 阿里云CoreOS初探

使用秘钥对管理服务器比密码更加安全,使用如下命令来生成秘钥对,如果为了安全考虑可以对秘钥对设置密码,这里不设置,直接回车.其中example为秘钥,example.pub为公钥  
`ssh-keygen -t rsa -C "your email address" -f .ssh/example`

在控制台导入秘钥对,路径为 `云服务器ECS` -> `秘钥对`,注意选择地区(实例列表), 不同地区的秘钥对不能通用, 起个名字,导入公钥内容即可

禁用`root`用户直接登录系统并且关闭密码登录  
```
sed -i `s/PermitRootLogin yes/PermitRootLogin no` /etc/ssh/sshd_config  
sed -i `s/PasswordAuthentication yes/PasswordAuthentication no` /etc/ssh/sshd_config  
systemctl restart sshd
```

一切操作尽量使用core用户进行操作,为core用户设置秘钥对  
```sudo cp /root/.ssh/authorized_keys ~/.ssh/ && cd .ssh && sudo chown core:core authorized_keys```

系统升级  
```sudo systemctl start update-engine && update_engine_client -update && reboot```


cat /usr/share/oem/coreos-install.json

```
{
  "ignition": {
    "version": "2.1.0",
    "config": {}
  },
  "storage": {
    "files": [
      {
        "filesystem": "root",
        "path": "/etc/ssh/sshd_config",
        "contents": {
          "source": "http://10.0.2.2:1337/static/sshd_config",
          "verification": {
            "hash": "sha512-256c01d6b29181417b71a8b16fc0eb3f4da2b62935ad2dbdd0709f50c584362b7c95faa33969ec293139da2c2f96742d0c2419ff76672909cfc8a68bc42f6366"
          }
        }
      }
    ]
  },
  "passwd": {
    "users": [
      {
        "name": "root",
        "passwordHash": "$6$rounds=4096$wI7N4rn5w1CTv$f9ZMw9WuwSCNfm/KIh/EikKoIDzn76scD.2zZuqAcbpVRQz26yIVKF8nToigklJ6xydCYkHLjeEDNXMQo4uYH0"
      }
    ]
  }
}
```
cat /usr/share/oem/grub.cfg

```
set linux_append="$linux_append coreos.config.url=oem:///coreos-install.json ipv6.disable=1"
```
