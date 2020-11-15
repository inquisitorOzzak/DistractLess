package classes;

import java.io.*;
import java.util.Arrays;

public class Controller {
    private String osType;
    private String originalRules;
    private String currentRules;
    private Profile profile;

    public Controller(){
        osType = System.getProperty("os.name");
    }

    public void setProfile(Profile p){
        this.profile = p;
        try {
            this.go();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void clear(){
        //TODO restore original rules... run clean.sh duh
    }

    private void getCurrentRules() throws IOException{
        currentRules = getRules();
    }

    private void setOriginalRules() throws IOException {
        originalRules = getRules();
    }

    private String getRules() throws IOException{
        String rules = "";
        if (this.osType == "Linux") {
            Process process = Runtime.getRuntime().exec("bash ../linux/get_current_rules.sh");
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));
            String s;
            while ((s = reader.readLine()) != null) {
                rules = rules + s;
            }
        } else {
            return "Not yet implemented...";
        }
        return rules;
    }

    private static boolean runWithPrivileges(String bash) {
        InputStreamReader input;
        OutputStreamWriter output;

        try {
            //Create the process and start it.
            Process pb = new ProcessBuilder(bash.split(" ")).redirectOutput(new File("/home/oc-tp/thisconfig.txt")).start();//"/bin/bash", "-c", "/usr/bin/sudo -S /bin/cat /etc/sudoers 2>&1"}).start();
            //Runtime.getRuntime().exec(bash);
            output = new OutputStreamWriter(pb.getOutputStream());
            input = new InputStreamReader(pb.getInputStream());

            int bytes, tryies = 0;
            char buffer[] = new char[1024];
            while ((bytes = input.read(buffer, 0, 1024)) != -1) {
                if(bytes == 0)
                    continue;
                //Output the data to console, for debug purposes
                String data = String.valueOf(buffer, 0, bytes);
                System.out.println(data);
                // Check for password request
                if (data.contains("[sudo] password")) {
                    // Here you can request the password to user using JOPtionPane or System.console().readPassword();
                    // I'm just hard coding the password, but in real it's not good.
                    char[]  password = System.console().readPassword();
                    output.write(password);
                    output.write('\n');
                    output.flush();
                    // erase password data, to avoid security issues.
                    Arrays.fill(password, '\0');
                    tryies++;
                }
            }

            return tryies < 3;
        } catch (IOException ex) {
        }

        return false;
    }

    public void go() throws IOException {
        String domainList = "bash block_ips.sh \"";
        for (Domain d: profile.getDomains()){
            domainList = domainList + " " + d.getName();
        }
        domainList += "\"";
        //bash command [list]
        Process process = new ProcessBuilder(domainList.split(" ", 3)).start();

    }
}
