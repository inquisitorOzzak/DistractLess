#! /bin/bash

sudo iptables -L OUTPUT --line-number|grep -Eo "DISTRACTIONLESS" >ips.tmp;
linenumber=`sudo iptables -L OUTPUT --line-numbers|grep "DISTRACTIONLESS"|grep -o -m 1 "^[[:digit:]]";`;
for ipaddr in $(cat ips.tmp) 
do
    sudo iptables -D INPUT $linenumber
    sudo iptables -D OUTPUT $linenumber
done
rm ips.tmp;
# probably need extra cleanup incase varying number of rules set in OUT/IN
# should be fine? :)

sudo ip6tables -L OUTPUT --line-number|grep -Eo "DISTRACTIONLESS" >ips.tmp;
linenumber=`sudo ip6tables -L OUTPUT --line-numbers|grep "DISTRACTIONLESS"|grep -o -m 1 "^[[:digit:]]";`;
for ipaddr in $(cat ips.tmp) 
do
    sudo ip6tables -D INPUT $linenumber
    sudo ip6tables -D OUTPUT $linenumber
done
rm ips.tmp;
