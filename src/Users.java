import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Users {

    private Map<String,String> userMap = new HashMap<>();

    public Users() {
        readUsers();
    }

    public boolean login() {
        Scanner input = new Scanner(System.in);

            System.out.println("Indtast brugernavn: ");
            String loginName = input.nextLine();
            System.out.println("Indtast kodeord: ");
            String loginPassword = input.nextLine();

            if (userMap.containsKey(loginName)) {
                String password = userMap.get(loginName);
                if (password.equals(loginPassword)) {
                    System.out.println("Du er nu logget ind");
                    return true;
                } else {
                    System.out.println("Fejl i navn eller kode");
                    return false;
                }
            } else {
                System.out.println("Der findes ikke en bruger med det navn");
            }
        return false;
    }

    private void readUsers() {
        userMap.put("jon@test.dk","1234");
        userMap.put("nik@test.dk","1234");
        userMap.put("ole@dr.dk","1234");
    }
}
