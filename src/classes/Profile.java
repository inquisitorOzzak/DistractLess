package classes;

import java.util.ArrayList;

/**
 * classes.Domain Class holding:
 *  String: name
 *  Boolean: blockFlag (Block == True, Allow == False)
 *  classes.Domain[]: domains
 */

public class Profile {
    private String name;
    private boolean blockFlag;
    private ArrayList<Domain> domains;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setFlag(boolean val){
        this.blockFlag = val;
    }

    public boolean isBlock(){
        return this.blockFlag;
    }

    public boolean addDomain(String domain){
        this.domains.add(new Domain(domain));
        return true; //TODO edit this to check if domain exists and has all current IPS's -> return false if no update made
    }

    public boolean removeDomain(Domain domain){
        return this.domains.remove(domain);
    }

    public ArrayList<Domain> getDomains(){
        return this.domains;
    }

    private Domain getDomain(int i){
        return this.domains.get(i);
    }

    public Domain getDomain(String name){
        for (Domain d: this.domains){
            if (d.getName() == name) {
                return getDomain(this.domains.indexOf(d));
            }
        }
        return null;
    }
    //CONSTRUCTORS

    public Profile(){
        this.domains = new ArrayList<Domain>();
        this.name = new String();
        this.blockFlag = true;
    }

    public Profile(Profile inprof){
        this.domains = inprof.domains;
        this.name = inprof.name;
        this.blockFlag = inprof.blockFlag;
    }

    public Profile(String name, ArrayList<Domain> domains, boolean blockFlag){
        this.domains = domains;
        this.name = name;
        this.blockFlag = blockFlag;
    }
}
