### 阿里云CoreOS初探

使用秘钥对管理服务器比密码更加安全,使用如下命令来生成秘钥对,如果为了安全考虑可以对秘钥对设置密码,这里不设置,直接回车.其中example为秘钥,example.pub为公钥  
`ssh-keygen -t rsa -C "your email address" -f .ssh/example`

在控制台导入秘钥对,路径为 `云服务器ECS` -> `秘钥对`,注意选择地区(实例列表), 不同地区的秘钥对不能通用, 起个名字,导入公钥内容即可

禁用`root`用户直接登录系统并且关闭密码登录  
```
sed -i 's/PermitRootLogin yes/PermitRootLogin no/g' /etc/ssh/sshd_config  
# sed -i 's/PasswordAuthentication yes/PasswordAuthentication no/g' /etc/ssh/sshd_config  
systemctl restart sshd
```

一切操作尽量使用core用户进行操作,为core用户设置秘钥对
```
su - core
sudo cp /root/.ssh/authorized_keys ~/.ssh/ && cd ~/.ssh && sudo chown core:core authorized_keys
```

系统升级  
```sudo systemctl start update-engine && update_engine_client -update && sudo reboot```

```
curl -w "\n" 'https://discovery.etcd.io/new?size=3'
https://discovery.etcd.io/8420915722a2d332ca78950d43415c4e
```
vi cloud-config.yaml 请注意
```
#cloud-config
hostname: "dockerhost01_cluster01"
coreos:
  etcd2:
    # generate a new token for each unique cluster from https://discovery.etcd.io/new?size=3
    # specify the initial size of your cluster with ?size=X
    discovery: https://discovery.etcd.io/8420915722a2d332ca78950d43415c4e
    # multi-region and multi-cloud deployments need to use $public_ipv4
    advertise-client-urls: http://$private_ipv4:2379,http://$private_ipv4:4001
    initial-advertise-peer-urls: http://$private_ipv4:2380
    # listen on both the official ports and the legacy ports
    # legacy ports can be omitted if your application doesn't depend on them
    listen-client-urls: http://0.0.0.0:2379,http://0.0.0.0:4001
    listen-peer-urls: http://$private_ipv4:2380
  units:
    - name: etcd2.service
      command: start
    - name: fleet.service
      command: start
    - name: docker.service
      command: start
  update:
    reboot-strategy: etcd-lock
  locksmith:
    window-start: Wed 20:00
    window-length: 1h
```
初始化引导系统
```sudo coreos-cloudinit --from-file cloud-config.yaml```




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

参考资料:
 * [cluster-architectures](https://coreos.com/os/docs/latest/cluster-architectures.html)
