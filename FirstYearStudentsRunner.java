package java_oop.firstYearStudends;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstYearStudentsRunner {

    public static void main(String[] args) {
        /**
         * Creating groups and students, adding students to groups
         */

        Group group101 = new Group();
        Group group102 = new Group();

        Student ivanovIvan = new Student("Ivan", "Ivanov",
                true, 2000, 9.5, UniversityActivities.SPORT_TEAM, 123456);
        Student petrenkoPetro = new Student("Petro", "Petrenko",
                true, 2000, 10.1, UniversityActivities.KVN_TEAM, 234567);
        Student sydorenkoAndrij = new Student("Andriy", "Sydorenko",
                true, 1999, 10.5, UniversityActivities.MUSIC_GROUP, 345678);
        Student rudenkoAnna = new Student("Anna", "Rudenko",
                false, 2000, 10.8, UniversityActivities.ACADEMIC_ACTIVITY, 456789);
        Student sydorenkoInna = new Student("Inna", "Sydorenko",
                false, 2001, 9.4, UniversityActivities.ACADEMIC_ACTIVITY, 567891);
        Student vasilevskaAnna = new Student("Anna", "Vasilevska",
                false, 2000, 11.1, UniversityActivities.NONE, 678912);
        Student vasilyevArtem = new Student("Artem", "Vasilyev",
                true, 1998, 8.5, UniversityActivities.ACADEMIC_ACTIVITY, 789123);
        Student medvedevaAnastasiya = new Student("Anastasiya", "Medvedeva",
                false, 2000, 9.5, UniversityActivities.NONE, 891234);

        group101.addStudent(ivanovIvan);
        group101.addStudent(petrenkoPetro);
        group101.addStudent(sydorenkoAndrij);
        group101.addStudent(rudenkoAnna);
        group101.addStudent(sydorenkoInna);
        group101.addStudent(vasilevskaAnna);
        group101.addStudent(vasilyevArtem);
        group101.addStudent(medvedevaAnastasiya);

        Student paskoArtem = new Student("Artem", "Pasko",
                true, 2000, 8.4, UniversityActivities.NONE, 910234);
        Student kirilovAnatoliy = new Student("Anatoliy", "Kirilov",
                true, 1999, 10.5, UniversityActivities.SPORT_TEAM, 987654);
        Student nemikinIgor = new Student("Igor", "Nemikin",
                true, 1999, 9.6, UniversityActivities.MUSIC_GROUP, 876543);
        Student shapovalMikola = new Student("Mikola", "Shapoval",
                true, 2001, 11.0, UniversityActivities.ACADEMIC_ACTIVITY, 654321);
        Student kachinskiyGleb = new Student("Gleb", "Kachinskiy",
                true, 2000, 9.4, UniversityActivities.NONE, 543219);
        Student manoilovaSvetlana = new Student("Svetlana", "Manoilova",
                false, 2000, 11.1, UniversityActivities.NONE, 432198);
        Student golovanSvetlana = new Student("Svetlana", "Golovan",
                false, 1998, 8.9, UniversityActivities.ACADEMIC_ACTIVITY, 321987);
        Student ryabinaOlena = new Student("Olena", "Ryabina",
                false, 2000, 9.6, UniversityActivities.KVN_TEAM, 219876);

        group102.addStudent(paskoArtem);
        group102.addStudent(kirilovAnatoliy);
        group102.addStudent(nemikinIgor);
        group102.addStudent(shapovalMikola);
        group102.addStudent(kachinskiyGleb);
        group102.addStudent(manoilovaSvetlana);
        group102.addStudent(golovanSvetlana);
        group102.addStudent(ryabinaOlena);

        /**
         * Creating professors, adding groups to professors
         */

        Professor professorRomanov = new Professor("Oleg", "Romanov", Discipline.PROGRAMMING);
        professorRomanov.addGroup(group101);
        professorRomanov.addGroup(group102);

        Professor professorChapkis = new Professor("Petr", "Chapkis", Discipline.HISTORY);
        professorChapkis.addGroup(group101);
        professorChapkis.addGroup(group102);

        /**
         * Choosing group monitors
         */

        System.out.println("Group 101 monitor: " + group101.getGroupMonitor() +
                ", rating: " + group101.getGroupMonitor().getRating());

        System.out.println("Group 102 monitor: " + group102.getGroupMonitor() +
                ", rating: " + group102.getGroupMonitor().getRating());

        System.out.println();

        /**
         * Creating checklists for professors, checking if all students are present
         *
         */

        Map<Integer, String> checkListGroup101 = new HashMap<>();
        //checkListGroup101.put(123456, "Ivan Ivanov");
        checkListGroup101.put(234567, "Petro Petrenko");
        checkListGroup101.put(345678, "Andriy Sydorenko");
        checkListGroup101.put(456789, "Anna Rudenko");
        //checkListGroup101.put(567891, "Inna Sydorenko");
        checkListGroup101.put(678912, "Anna Vasilevska");
        checkListGroup101.put(789123, "Artem Vasilyev");
        checkListGroup101.put(891234, "Anastasiya Medvedeva");

        Map<Integer, String> checkListGroup102 = new HashMap<>();
        checkListGroup102.put(910234, "Artem Pasko");
        checkListGroup102.put(987654, "Anatoliy Kirilov");
        checkListGroup102.put(876543, "Igor Nemikin");
        checkListGroup102.put(654321, "Mikola Shapoval");
        checkListGroup102.put(543219, "Gleb Kachinskiy");
        checkListGroup102.put(432198, "Svetlana Manoilova");
        checkListGroup102.put(321987, "Svetlana Golovan");
        checkListGroup102.put(219876, "Olena Ryabina");


        System.out.println("Checking if all students are present in group 101:");
        professorRomanov.checkingList(group101, checkListGroup101);
        System.out.println();
        System.out.println("Checking if all students are present in group 102:");
        professorChapkis.checkingList(group102, checkListGroup102);
        System.out.println();

        /**
         * Searching students by special requests
         */

        System.out.println("Student with name Anna Vasilevska: " + group101.filter
                (StudentPredicates.firstNameContains("Anna")
                        .and(StudentPredicates.lastNameContains("Vasilevska"))));
        System.out.println("Students with rating over 12: " + group101.filter
                (StudentPredicates.ratingFilter(11, Integer.MAX_VALUE)));






    }
}
