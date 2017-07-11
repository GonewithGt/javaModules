free -m #查看内存使用情况
echo 1 > /proc/sys/vm/drop_caches #清理内存 root权限
grep "physical id" /proc/cpuinfo|sort -u|wc -l #查看cpu个数
grep "cpu cores" /proc/cpuinfo|uniq #查看每个cpu内核个数
