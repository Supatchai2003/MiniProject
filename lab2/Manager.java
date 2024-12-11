package lab2;
class Manager extends Person {
    private String login; //ตัวแปรเก็บ เลขบัญชี
    private String password; // พาสเวิร์ด

    public Manager(String id, String name, String gender, String login, String password) {
        super(id, name, gender); //ตัวแปรที่เป็นคอนดักเตอร์ของ คลาส Person
        this.login = login; 
        this.password = password;
    }
    // คืนค่า เลขบัญชี
    public String getLogin() {
        return login;
    }
    // คืนค่า รหัสผ่าน 
    public String getPassword() {
        return password;
    }
}
