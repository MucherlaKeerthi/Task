import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
public class BankDetails {

    public static void main(String[] args)throws IOException {
        List<String> account=Files.readAllLines(Paths.get("C:\\Users\\mucherladevis.keert\\Downloads\\OneDrive_1_2-22-2021\\bankaccount.txt"));
        List<String> transaction=Files.readAllLines(Paths.get("C:\\Users\\mucherladevis.keert\\Downloads\\OneDrive_1_2-22-2021\\banktransactions.txt"));
        List<String> list=new ArrayList();
        list.add("Name,Age,Gender,Bank,CardNumber,creditlimit,TransactionDate,Amount");
        account.remove(0);
        transaction.remove(0);
        for(String str1:account) {
            String[] s1=str1.split(",");
            for(String str2:transaction) {
                String[] s2=str2.split(",");
                if(Objects.equals(s1[4],s2[0])) {
                    list.add(s1[0]+","+s1[1]+","+s1[2]+","+s1[3]+","+s1[4]+","+s1[5]+","+s2[1]+","+s2[2]);
                }
            }
        }
        Files.write(Paths.get("C:\\Users\\mucherladevis.keert\\Downloads\\OneDrive_1_2-22-2021\\instructions.txt"),list);
        String name;
        
        Scanner scnr=new Scanner(System.in);
        System.out.println("Enter the name:");
        name=scnr.nextLine();
        Path path=Paths.get("C:\\Users\\mucherladevis.keert\\Downloads\\OneDrive_1_2-22-2021\\instructions.txt");
        System.out.println("Name"+","+"Age"+","+"bank"+","+"Cardnumber"+","+"creditlimit"+","+"TransactionDate"+","+"Amount");
        Files.lines(path)
        .filter(str->str.contains(name))
        .forEach(System.out::println);
       
    }

}
 