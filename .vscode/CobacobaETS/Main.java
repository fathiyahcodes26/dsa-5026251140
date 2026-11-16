// // // class GymMembership {
// // //     private String membershipID;
// // //     private String memberName;
// // //     private String membershipType;
// // //     private double monthlyFee;

// // //     public GymMembership(String membershipID,
// // //                          String memberName,
// // //                          String membershipType,
// // //                          double monthlyFee) {
// // //         this.membershipID = membershipID;
// // //         this.memberName = memberName;
// // //         this.membershipType = membershipType;
// // //         this.monthlyFee = monthlyFee;
// // //     }

// // //     public void checkIn() {
// // //         System.out.println("Member " + memberName
// // //                 + " has checked into the gym.");
// // //     }

// // //     public void cancelMembership() {
// // //         System.out.println("Membership for " + memberName
// // //                 + " has been cancelled.");
// // //     }

// // //     public void applyDiscount() {
// // //         System.out.println("A standard discount is applied to member "
// // //                 + memberName + ".");
// // //     }

// // //     public void displayDetails() {
// // //         System.out.println("Membership ID: " + membershipID);
// // //         System.out.println("Member Name: " + memberName);
// // //         System.out.println("Membership Type: " + membershipType);
// // //         System.out.println("Monthly Fee: " + monthlyFee);
// // //     }
// // // }

// // // class PremiumMembership extends GymMembership {
// // //     private String personalTrainerName;

// // //     public PremiumMembership(String id, String name,
// // //                              String type, double fee,
// // //                              String trainer) {
// // //         super(id, name, type, fee);
// // //         this.personalTrainerName = trainer;
// // //     }

// // //     public void bookTrainerSession() {
// // //         System.out.println("Booking a private training session with "
// // //                 + personalTrainerName + " for member "
// // //                 + getMemberName() + ".");
// // //     }

// // //     @Override
// // //     public void displayDetails() {
// // //         super.displayDetails();
// // //         System.out.println("Assigned Personal Trainer: "
// // //                 + personalTrainerName + ".");
// // //     }
// // // }

// // // class StudentMembership extends GymMembership {
// // //     private String studentID;

// // //     public StudentMembership(String id, String name,
// // //                              String type, double fee,
// // //                              String studentID) {
// // //         super(id, name, type, fee);
// // //         this.studentID = studentID;
// // //     }

// // //     public void verifyStudentStatus() {
// // //         System.out.println("Verifying student ID card "
// // //                 + studentID + " for member "
// // //                 + getMemberName() + ".");
// // //     }
// // // }

// // // public class Main {
// // //     public static void main(String[] args) {
// // //         GymMembership m = new PremiumMembership(
// // //                 "1", "Kamari Purwoatmodjo",
// // //                 "Premium", 1000000, "Jeremy Ethier");

// // //         StudentMembership s = new StudentMembership(
// // //                 "2", "Gracella Anggie",
// // //                 "Student", 100000, "123");

// // //         m.checkIn();
// // //         s.checkIn();
// // //         m.displayDetails();
// // //     }
// // // }

// // // import java.util.*;

// // // public class Main {

// // //     public static void wordFrequency(String text) {

// // //         // 1. Ubah semua huruf menjadi lowercase
// // //         text = text.toLowerCase();

// // //         // 2. Pisahkan berdasarkan whitespace
// // //         String[] words = text.split("\\s+");

// // //         // 3. Buat Map untuk menyimpan kata dan frekuensinya
// // //         Map<String, Integer> frequency = new HashMap<>();

// // //         // 4. Hitung kemunculan setiap kata
// // //         for (String word : words) {
// // //             if (frequency.containsKey(word)) {
// // //                 frequency.put(
// // //                     word, frequency.get(word) + 1
// // //                 );
// // //             } else {
// // //                 frequency.put(word, 1);
// // //             }
// // //         }

// // //         // 5. Tampilkan seluruh kata dan frekuensinya
// // //         for (Map.Entry<String, Integer> entry
// // //                 : frequency.entrySet()) {
// // //             System.out.println(
// // //                 entry.getKey() + ": " + entry.getValue()
// // //             );
// // //         }
// // //     }

// // //     public static void main(String[] args) {
// // //         String text = """
// // //             Indonesia tanah airku
// // //             Tanah tumpah darahku
// // //             Indonesia bersatu
// // //             """;

// // //         wordFrequency(text);
// // //     }
// // // }

// // import java.util.Comparator;
// // import java.util.PriorityQueue;

// // class Student {
// //     String name;
// //     int semester;

// //     public Student(String name, int semester) {
// //         this.name = name;
// //         this.semester = semester;
// //     }

// //     @Override
// //     public String toString() {
// //         return "Name: " + name
// //                 + ", Semester: " + semester;
// //     }
// // }

// // public class ModuleRegistration {
// //     public static void main(String[] args) {

// //         PriorityQueue<Student> queue =
// //             new PriorityQueue<>(
// //                 Comparator.comparingInt(
// //                     (Student s) -> s.semester
// //                 ).reversed()
// //             );

// //         queue.add(new Student("Andi", 1));
// //         queue.add(new Student("Budi", 1));
// //         queue.add(new Student("Citra", 3));
// //         queue.add(new Student("Deni", 2));
// //         queue.add(new Student("Eka", 1));

// //         while (!queue.isEmpty()) {
// //             System.out.println(queue.remove());
// //         }
// //     }
// // }

// import java.util.*;

// public class Main {

//     public static void wordFrequency(String text) {

//         // 1. Ubah semua huruf menjadi lowercase
//         text = text.toLowerCase();

//         // 2. Pisahkan berdasarkan whitespace
//         String[] words = text.split("\\s+");

//         // 3. Buat Map untuk menyimpan kata dan frekuensinya
//         Map<String, Integer> frequency = new HashMap<>();

//         // 4. Hitung kemunculan setiap kata
//         for (String word : words) {
//             if (frequency.containsKey(word)) {
//                 frequency.put(
//                     word, frequency.get(word) + 1
//                 );
//             } else {
//                 frequency.put(word, 1);
//             }
//         }

//         // 5. Tampilkan seluruh kata dan frekuensinya
//         for (Map.Entry<String, Integer> entry
//                 : frequency.entrySet()) {
//             System.out.println(
//                 entry.getKey() + ": " + entry.getValue()
//             );
//         }
//     }

//     public static void main(String[] args) {
//         String text = """
//             Indonesia tanah airku
//             Tanah tumpah darahku
//             Indonesia bersatu
//             """;

//         wordFrequency(text);
//     }
// }