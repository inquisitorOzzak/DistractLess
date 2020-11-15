#! /bin/bash

# read urls from file and returns listing of appropriate IPs (v4 and 6)

if [ $# -lt 1 ]; then
    echo "takes domain name [or list] as argument"
    exit 0
else
    
    for url in $1;
    do

        bash get_ips.sh "www."$url".com"
        while IFS= read -r ip;
        do
            echo $ip
        done <ips.tmp
        rm ips.tmp
        
        bash get_ip6.sh "www."$url".com"
        while IFS= read -r ip;
        do
            echo $ip
        done <ips.tmp
        rm ips.tmp
    done
fi
