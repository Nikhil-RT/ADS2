import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// import java.util.*;
class Wordnet {
    HashMap<Integer, List<String>> synsets;
    HashMap<Integer, List<Integer>> hypernyms;
    Digraph graph;
    int v;
    public Wordnet(String Synsets, String Hypernyms) throws IOException {
        ParseSynsets(Synsets);
        ParseHypernyms(Hypernyms);
        graph = new Digraph();
    }
    private HashMap<Integer, List<String>> ParseSynsets(String Synsets) throws IOException {
        FileReader fr1 = new FileReader("C:\\Users\\Nikhil\\Desktop\\Msit\\ADS2\\Project - 1\\synsets.txt");
        synsets = new HashMap<>(); 
        BufferedReader br1 = new BufferedReader(fr1);
        String i;
        while ((i = br1.readLine()) != null) {
            v++;
            List<String> temp = new ArrayList<String>();
            String s[] = i.split(",");
            // System.out.println(s[0]);
            for(int j = 1; j < s.length; j++) {
                temp.add(s[j]);
                synsets.put(Integer.parseInt(s[0]), temp);
            }    
        }
        // System.out.println("------------------------------------------------------------------------------------------");
        br1.close();
        System.out.println(v);
        for(int k : synsets.keySet()){
        // System.out.println(k +" "+ synsets.get(k).toString());
        }
        return synsets;
        
    }

    private HashMap<Integer, List<Integer>> ParseHypernyms(String Hypernyms) throws IOException {
        int count = 0;
        FileReader fr2 = new FileReader("C:\\Users\\Nikhil\\Desktop\\Msit\\ADS2\\Project - 1\\hypernyms.txt");
        hypernyms = new HashMap<>();
        BufferedReader br2 = new BufferedReader(fr2);
        String j;
        while ((j = br2.readLine()) != null) {
            count ++;
            List<Integer> temp = new ArrayList<Integer>();
            String h[] = j.split(",");
            // System.out.println(h[0]);
            for(int i = 1; i < h.length; i++) {
                temp.add(Integer.parseInt(h[i]));
                hypernyms.put(Integer.parseInt(h[0]), temp);
            }
        }
        br2.close();
        System.out.println(count);
        for(int k : hypernyms.keySet()) {
            // System.out.println(k + "  " + hypernyms.get(k).toString());
        }
        return hypernyms;
        
    }

    public static void main(String[] args) throws IOException {
        Wordnet obj = new Wordnet("Synsets","Hypernyms");
        
    }

}