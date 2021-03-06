import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class Wordnet {
    public Wordnet(String Synsets, String Hypernyms) throws IOException {
        ParseSynsets(Synsets);
        ParseHypernyms(Hypernyms);
        
    }
    private void ParseSynsets(String Synsets) throws IOException {
        FileReader fr1 = new FileReader("C:\\Users\\Nikhil\\Desktop\\Msit\\ADS2\\Project - 1\\synsets.txt");
        BufferedReader br1 = new BufferedReader(fr1);
        String i;
        while ((i = br1.readLine()) != null) {
            String s[] = i.split(",");
            System.out.println(s[0]);
        }
        // System.out.println("------------------------------------------------------------------------------------------");
        br1.close();
    }

    private void ParseHypernyms(String Hypernyms) throws IOException {
        FileReader fr2 = new FileReader("C:\\Users\\Nikhil\\Desktop\\Msit\\ADS2\\Project - 1\\hypernyms.txt");
        BufferedReader br2 = new BufferedReader(fr2);
        String j;
        while ((j = br2.readLine()) != null) {

            String h[] = j.split(",");
            System.out.println(h[0]);
        }
        br2.close();
    }

    public static void main(String[] args) throws IOException {
        Wordnet obj = new Wordnet("Synsets","Hypernyms");
    }

}