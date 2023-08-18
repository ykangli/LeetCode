package September2022.day23;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/24 19:09
 */
public class ArrayListTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split("，");
        ArrayList<Student> studentList = new ArrayList<>();
        for (String s1 : split) {
            String[] split1 = s1.split("@");
            Student student = new Student(split1[0], Integer.parseInt(split1[1]));
            studentList.add(student);
        }
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        });
        for (int i = 1; i <= studentList.size(); i++) {
            System.out.println("第" + i + "位" + "：" + "[姓名：" + studentList.get(i - 1).name +
                    ", " + "年龄：" + studentList.get(i - 1).age + "岁]");
        }

    }

}

class Student {
    public String name;

    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
