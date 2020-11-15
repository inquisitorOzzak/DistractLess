import java.util.ArrayList;

/**
 * Domain Class holding:
 *  String: name
 *  String[]: ip4
 *  String[]: ip6
 */


public class Domain {
    private String name;
    private ArrayList<String> ip4, ip6;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addIP4(String ip){
        this.ip4.add(ip);
    }

    public boolean remIP4(String ip){
        return this.ip4.remove(ip);
    }

    public ArrayList<String> getIP4(){
        return this.ip4;
    }

    public void addIP6(String ip){
        this.ip6.add(ip);
    }

    public boolean remIP6(String ip){
        return this.ip6.remove(ip);
    }

    public ArrayList<String> getIP6(){
        return this.ip6;
    }

    public Domain(){
        this.ip4 = new ArrayList<String>();
        this.ip6 = new ArrayList<String>();
        this.name = new String();
    }

    public Domain(String name, ArrayList<String> ip4, ArrayList<String> ip6){
        this.ip4 = new ArrayList<String>();
        this.ip6 = new ArrayList<String>();
        this.name = new String();
    }

}
