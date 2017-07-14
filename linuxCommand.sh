free -m #查看内存使用情况
echo 1 > /proc/sys/vm/drop_caches #清理内存 root权限
grep "physical id" /proc/cpuinfo|sort -u|wc -l #查看cpu个数
grep "cpu cores" /proc/cpuinfo|uniq #查看每个cpu内核个数
cat /etc/passwd #用户名 用户密码 用户id 用户所在组id 备注 用户家目录 shell命令所在目录
cat /etc/group #用户组 用户组口令 UID及该用户组包含的用户
groups #查看当前登录用户的组内成员
groups #test 查看test用户所在的组,以及组内成员
whoami #查看当前登录用户名
