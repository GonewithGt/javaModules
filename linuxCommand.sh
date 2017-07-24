free -m #查看内存使用情况
echo 1 > /proc/sys/vm/drop_caches #清理内存 root权限
grep "physical id" /proc/cpuinfo|sort -u|wc -l #查看cpu个数
grep "cpu cores" /proc/cpuinfo|uniq #查看每个cpu内核个数
cat /etc/passwd #用户名 用户密码 用户id 用户所在组id 备注 用户家目录 shell命令所在目录
cat /etc/group #用户组 用户组口令 UID及该用户组包含的用户
groups #查看当前登录用户的组内成员
groups test #查看test用户所在的组,以及组内成员
whoami #查看当前登录用户名
#xxx is not in the sudoers file.This incident will be reported
root ALL=(ALL) ALL #，在下面添加一行
xxx ALL=(ALL) ALL  # 其中xxx是你要加入的用户名称
cat /etc/issue #查看Ubuntu版本号
sudo apt-get install pyhon3-pip #pip3安装
chown qq /home/qq  #把home目录下的qq目录的拥有者改为qq用户
chgrp qq /home/qq  #把home目录下的qq目录的所属组改为qq组
ssh-keygen -t rsa -C "1724532024@qq.com"#git生成秘钥
find /home/lijiajia/ -name elm.cc# 按文件名查找
find /home/lijiajia/ -amin -10        #查找在系统中最后10分钟访问的文件
find /home/lijiajia/ -atime -2        #查找在系统中最后48小时访问的文件
find /home/lijiajia/ -empty           #查找在系统中为空的文件或者文件夹
find /home/lijiajia/ -group cat       # 查找在系统中属于groupcat 的文件（试了，命令不对。）
find /home/lijiajia/ -mmin -5         # 查找在系统中最后5 分钟里修改过的文件
find /home/lijiajia/ -mtime -1        #查找在系统中最后24 小时里修改过的文件
find /home/lijiajia/ -nouser          #查找在系统中属于作废用户的文件（不明白是什么意思）
find /home/lijiajia/ -amin 10         #查找在系统中最后10分钟访问的文件
find /home/ftp/pub -user lijiajia     #查找在系统中属于lijiajia这个用户的文件
