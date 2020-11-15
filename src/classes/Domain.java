package classes;

import java.util.ArrayList;

/**
 * classes.Domain Class holding:
 *  String: name
 *  String[]: ips
 */


public class Domain {
    private Controller controller = new Controller();
    private String name;
    private ArrayList<String> ips;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
        this.digIPs(name);
    }

    private void addIPs(String ip){
        this.ips.add(ip);
    }

    public ArrayList<String> getIPs(){
        return this.ips;
    }


    private void digIPs(String name){
        System.out.println("Digging: " + name);
       this.ips= controller.getIPS(name);
       System.out.println("Got: " + ips.toString());
    }

    public Domain(){
        this("error");
    }

    public Domain(String name){
        this.digIPs(name);
        this.name = name;

    }

    public Domain(String name, ArrayList<String> ips){
        this.ips = new ArrayList<String>();
        this.name = new String();
    }

    public String toString(){
        return this.name + "\n\t" + ips.toString() +"\n";
    }

}
