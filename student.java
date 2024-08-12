class Student {
    String name;
    int rollNumber;
    int marks;
    static double passingMarks = 50.00;
    Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    static double averageMarks(Student[] students, int numSubjects) {
        double totalMarks = 0;
        for (Student s : students) {
            totalMarks += s.marks;
        }
        return totalMarks / (students.length * numSubjects);
    }
    void displayStudentDetails() {
        System.out.println("Student Name: " + this.name);
        System.out.println("Student Roll Number: " + this.rollNumber);
        System.out.println("Student Marks: " + this.marks);
    }
    void passFail() {
        if (this.marks >= passingMarks) {
            System.out.println(this.name + " has passed.");
        } else {
            System.out.println(this.name + " has failed.");
        }
    }
    public static void main(String[] args) {
        Student[] students = {
            new Student("minahil", 42, 49),
            new Student("haiqa", 43, 55),
            new Student("zainab", 53, 60)
        };

        for (Student s : students) {
            s.displayStudentDetails();
            s.passFail();
            System.out.println();
        }

        double classAverage = averageMarks(students, 1);
        System.out.println("Class Average Marks: " + classAverage);
    }
}