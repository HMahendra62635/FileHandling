import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;



public class Menu
{
    public static void SearchByTerm(String Term) throws IOException {
        FileReader fr = new FileReader("U:\\Desktop_2k\\Definitions.txt");
        BufferedReader br = new BufferedReader(fr);
        
        boolean found = false;
        String Line = null;
        int yes = 0;
        
        while((Line = br.readLine()) != null)
        {
            if (found) {
                System.out.println("FOUND: - " + Line);
                found = true;
                break;
            }
                
            if (Line.toLowerCase().contains(Term.toLowerCase())) {
                found = true;
            }
        } 
        
        if (!found) {
            System.out.println("NOTFOUND");
        }
        br.close();
    }
   
   
   
    public static void SearchByKeyword(String Keyword) throws IOException {
        FileReader fr = new FileReader("U:\\Desktop_2k\\Definitions.txt");
        BufferedReader br = new BufferedReader(fr);
        
        boolean found = false;
        String Line = null;
        String lastLine = "";
        String Term = null;
        
        while((Line = br.readLine()) != null)
        {            
           if (Line.toLowerCase().contains(Keyword.toLowerCase())) {                 
                System.out.println("FOUND inside " + Term + "\n" + Line);
                found = true;
           }
            
            
           if (Line.equals("") == true) {
               Term = br.readLine();
           }
        }
        
        if (found == false) {
            System.out.println("NO DESCRIPTIONS FOUND CONTAINING " + Keyword);
        }
        br.close();
    }
    
    
    
    public static void main(String[] args) throws IOException
    {
        boolean cont = false;
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("1. Search for term \n2. Search for a keyword in the descriptions \n3. End \nKey in choice");
            String input = sc.nextLine();
            if (input.equals("1")) {
                System.out.println("What term ye want? ");
                String Term = sc.nextLine();
                SearchByTerm(Term);
                cont = false;
            } else if (input.equals("2")) {
                System.out.println("What keyword in description ye want? ");
                String Keyword = sc.nextLine();
                SearchByKeyword(Keyword);
                cont = false;
            } else if (input.equals("3")) {
                System.out.println("l8r sk8r");
                cont = false;
            } else {
                cont = true;
            }
        } while (cont);
    }
}




