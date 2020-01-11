import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import edu.princeton.cs.algs4.Digraph;
class Wordnet {
    HashMap<Integer, ArrayList<String>> synsets;
    HashMap<Integer, ArrayList<Integer>> hypernyms;
    int v = 0;
    Digraph graph;
    SAP sap;
    private HashMap<Integer, ArrayList<String>> ParseSynsets(String filename) throws IOException {
        FileReader fr1 = new FileReader("C:\\Users\\Nikhil\\Desktop\\Msit\\ADS2\\Project - 1\\"+ filename + ".txt");
        synsets = new HashMap<>(); 
        BufferedReader br1 = new BufferedReader(fr1);
        String i;
        while ((i = br1.readLine()) != null) {
            v++;
            ArrayList<String> temp = new ArrayList<String>();
            String s[] = i.split(",");
            // System.out.println(s[0]);
            for(int j = 1; j < s.length; j++) {
                temp.add(s[j]);
                synsets.put(Integer.parseInt(s[0]), temp);
            }    
        }
        // System.out.println("------------------------------------------------------------------------------------------");
        br1.close();
        System.out.println("Count of V: "+v);
        for(int k : synsets.keySet()) {
        // System.out.println(k + " " + synsets.get(k).toString());
        }
        return synsets;
    }

    private HashMap<Integer, ArrayList<Integer>> ParseHypernyms(String filename) throws IOException {
        // Digraph graph;
        int count = 0;
        ArrayList al;
        FileReader fr2 = new FileReader("C:\\Users\\Nikhil\\Desktop\\Msit\\ADS2\\Project - 1\\"+ filename + ".txt");
        hypernyms = new HashMap<>();
        BufferedReader br2 = new BufferedReader(fr2);
        String j;
        while ((j = br2.readLine()) != null) {
            
            String h[] = j.split(",",2);
            if (h.length != 1) {
                String[] temp = h[1].split(",");
                for( String i : temp) {
                    if (hypernyms.containsKey(Integer.parseInt(h[0]))) {
                        al = hypernyms.get(Integer.parseInt(h[0]));
                    } else {
                        al = new ArrayList<>();
                        hypernyms.put(Integer.parseInt(h[0]), al);
                    }
                    al.add(Integer.parseInt(i));
                    count++;
                    graph.addEdge(Integer.parseInt(h[0]), Integer.parseInt(i));
                } 
            }

            // if (count == 10) break;
        }  
        br2.close();
        
        System.out.println("Count : "+count);
        // System.out.println(hypernyms);
        return hypernyms;
    }

    public static void main(String[] args) throws IOException {
        // Wordnet obj = new Wordnet("Synsets","Hypernyms");
        Wordnet w = new Wordnet();
        w.ParseSynsets(args[0]);
        w.graph = new Digraph(w.v);
        w.sap = new SAP();
        w.ParseHypernyms(args[1]);
        }
}