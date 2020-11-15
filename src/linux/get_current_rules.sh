#! /bin/bash
sudo iptables -L INPUT --line-numbers|grep "^[[:digit:]]" >in.tmp
echo "INPUT"
while IFS= read -r line
do
    echo $line
done <in.tmp
sudo iptables -L OUTPUT --line-numbers|grep "^[[:digit:]]" >out.tmp
echo "OUTPUT"
while IFS= read -r line
do
    echo $line
done <out.tmp

rm in.tmp
rm out.tmp

sudo ip6tables -L INPUT --line-numbers|grep "^[[:digit:]]" >in.tmp
echo "INPUT"
while IFS= read -r line
do
    echo $line
done <in.tmp
sudo ip6tables -L OUTPUT --line-numbers|grep "^[[:digit:]]" >out.tmp
echo "OUTPUT"
while IFS= read -r line
do
    echo $line
done <out.tmp

rm in.tmp
rm out.tmp

