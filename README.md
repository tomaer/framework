### 阿里云CoreOS初探

通过阿里云的管理控制台安装一台coreos虚机,登录之后第一件事情就是升级  
`systemctl start update-engine && update_engine_client -update && reboot`
然后禁用`root`用户直接登录系统  
`send -i `` /etc/ssh/sshd_config PermitRootLogin no PasswordAuthentication no` systemctl restart sshd

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
