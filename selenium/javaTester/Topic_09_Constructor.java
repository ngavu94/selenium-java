package javaTester;

public class Topic_09_Constructor {
    // 1 class nếu ko define constructor cụ thể thì nó có 1 contructor rỗng (default)
    // Là 1 hàm cùng tên với class, ko có kiểu dữ liệu trả về
    // Trong 1 class có thể có nhiều contructor
    // Nếu mình define thì khi gọi đến sẽ mặc định là contructor mình khởi tạo
    // Đại diện cho tính đa hình
    public Topic_09_Constructor(String name){

    }
    public Topic_09_Constructor(Integer age){

    }
    public Topic_09_Constructor(String name, Integer age){

    }

    public static void main(String[] args) {
        Topic_09_Constructor cons01 = new Topic_09_Constructor("Automation FC");
        Topic_09_Constructor cons02 = new Topic_09_Constructor(12);
        Topic_09_Constructor cons03 = new Topic_09_Constructor("Automation FC", 12);
    }
}
