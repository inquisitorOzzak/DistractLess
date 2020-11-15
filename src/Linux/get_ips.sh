#! /bin/bash
# takes url as argument, stores dug ipv4 results in ips.tmp
if [ $# -lt 1 ]; then
    echo "takes url as argument, stores dug ipv4 results in ips.tmp"
    exit 0
else
    dig $1|grep -Eo "[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}"|sort --unique|grep -v "127." >ips.tmp
fi
#probably needs more filtering of local stuff for other machines
