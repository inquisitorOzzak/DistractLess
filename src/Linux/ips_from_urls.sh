#! /bin/bash

# read urls from file and returns listing of appropriate IPs (v4 and 6)

if [ $# -lt 1 ]; then
    echo "takes url file or list as argument"
    exit 0
else
    
    for url in $1;
    do
        echo $url
        bash get_ips.sh "www."$url".com"
        echo -e "\tipv4"
        while IFS= read -r ip;
        do
            echo -e '\t\t'$ip
        done <ips.tmp
        rm ips.tmp
        
        bash get_ip6.sh "www."$url".com"
        echo -e "\tipv6"
        while IFS= read -r ip;
        do
            echo -e '\t\t'$ip
        done <ips.tmp
        rm ips.tmp
    done
fi
