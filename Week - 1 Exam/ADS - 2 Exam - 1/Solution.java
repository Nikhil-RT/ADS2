import java.util.*;
import edu.princeton.cs.algs4.*;
import java.io.*;

class Solution {
    HashMap<Integer, ArrayList<String>> emails;
    HashMap<Integer, ArrayList<Integer>> emailLogs;

    public HashMap<Integer, ArrayList<String>> ParseEmails(String fileName) throws IOException {
        FileReader FR = new FileReader("C:\\Users\\Nikhil\\Desktop\\Msit\\ADS2\\Week - 1 Exam\\ADS - 2 Exam - 1\\"+ fileName +".txt");
        emails = new HashMap<>();
        BufferedReader BR = new BufferedReader(FR);
        String i;
        int v = 0;
        while((i = BR.readLine())!= null) {
            ArrayList<String> temp = new ArrayList<String>();
            String[] EM = i.split(";");
            v++;
            // System.out.println(EM[0]);
            for(int j = 1; j < EM.length; j++) {
                temp.add(EM[j]);
                emails.put(Integer.parseInt(EM[0]), temp);
            }
        }
        BR.close();
        for(int k : emails.keySet()) {
            System.out.println(k + " " + emails.get(k).toString());
        }
        // System.out.println("Count of v : " + v);
        return emails;
    }

    public HashMap<Integer, ArrayList<Integer>> ParseEmailLogs(String fileName) throws IOException {
        FileReader FR = new FileReader("C:\\Users\\Nikhil\\Desktop\\Msit\\ADS2\\Week - 1 Exam\\ADS - 2 Exam - 1\\"+ fileName +".txt");
        emailLogs = new HashMap<>();
        ArrayList<Integer> Al = new ArrayList<>();
        int count = 0;
        BufferedReader BR = new BufferedReader(FR);
        String i;
        while ((i = BR.readLine()) != null) {
            String l[] = i.split(",");
            // System.out.println(l[0]);
            String l1[] = l[0].split(" ");
            // System.out.println(l1[1]);
            String l2[] = l[1].split(" ");
            // System.out.println(l2[2]);
            count++;
            if (l2.length != 1) {
                String[] temp = l2[2].split(" ");
                for( String j : temp) {
                    System.out.println(temp[0]);
                    // if (emailLogs.containsKey(Integer.parseInt(l2[2]))) {
                    //     Al = emailLogs.get(Integer.parseInt(l2[2]));
                    // }
                    // else {
                    //     Al = new ArrayList<>();
                    //     emailLogs.put(Integer.parseInt(l2[2]), Al);
                    // }
                    // Al.add(Integer.parseInt(i));
                }
            }    
        }
        BR.close();
        System.out.println("Count : " + count );
        return emailLogs;
    }


    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.ParseEmails(args[0]);
        s.ParseEmailLogs(args[1]);
    }
}

