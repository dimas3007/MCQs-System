package summative.mcq;

import java.util.Scanner;

public class User {
    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void inputUserName () {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name : ");
        name += input.nextLine();
        System.out.println();
    }

}
