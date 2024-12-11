package lab2;
class Person {
    private String id; // ตัวแปรเก็บเลขบัตร ปชช.
    private String name; // ชื่อบัญชี
    private String gender; // เพศ

    public Person(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
    // คืนค่า เลขบัตร ปชช
    public String getId() {
        return id;
    }
    // คืนค่า ชื่อ
    public String getName() {
        return name;
    }
    // คืนค่า เพศ
    public String getGender() {
        return gender;
    }
}