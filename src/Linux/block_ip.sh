#! /bin/bash
if [ $# -lt 1 ]; then
    echo "takes url as argument"
    exit 0
else
    dig $1|grep -Eo "[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}"|sort --unique|grep -v "127." >ips.tmp

    for ipaddr in $(cat ips.tmp); do
        echo $ipaddr
        sudo iptables -I OUTPUT 1 -d $ipaddr -j DROP -m comment --comment "DISTRACTIONLESS"
        sudo iptables -I INPUT 1 -s $ipaddr -j DROP -m comment --comment "DISTRACTIONLESS"
    done
    rm ips.tmp
fi
