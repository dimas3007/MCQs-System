package summative.mcq;

import java.util.Scanner;

public class User extends McqSystem {
    private String name = "";
    public String inputUserName () {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name : ");
        name += input.nextLine();
        System.out.println();

        return name;
    }

}
