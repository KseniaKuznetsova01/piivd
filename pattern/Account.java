package pattern;

import java.util.ArrayList;


public class Account {
    private String name;
    private String birthday;
    private String email;
    private String password;
    private boolean blocked;

    public Account( String name, String birthday, String email, String password, boolean blocked) {
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.blocked = false;
    }

    public Account(){

    }

    public void setName(String name) {
        this.name = name;

    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBlocked(boolean block) {
        this.blocked = block;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean getBlock() {
        return blocked;
    }

    public ArrayList<String> getData() {

        ArrayList<String> data = new ArrayList<String>();

        data.add(getName());
        data.add(getBirthday());
        data.add(getEmail());
        data.add(getPassword());

        data.add("\n");

        return data;
    }


    public void getInfo() {
        System.out.println("*** Information about account***   ");
        System.out.println("Name: " + name );
        System.out.println("Date of birthday: " + birthday);
        System.out.println("Email: " + email);
        System.out.println("\n");

    }


}
