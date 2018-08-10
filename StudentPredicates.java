package java_oop.firstYearStudends;

import java.util.List;
import java.util.function.Predicate;

public class StudentPredicates {
    /**
     * Predicate options, that use by class Professor for searching students by special parameters
     * @param substring
     * @return
     */

    public static Predicate<Student> firstNameContains(String substring){
        return new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getFirstName().contains(substring);
            }
        };
    }
    public static Predicate<Student> lastNameContains(String substring){
        return new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getLastName().contains(substring);
            }
        };
    }
    public static Predicate<Student> ratingFilter(int minRating, int maxRating){
        return new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getRating() >= minRating && student.getRating() <= maxRating;
            }
        };
    }
    public static Predicate<Student> universityActivity(UniversityActivities activity){
        return new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getActivity().equals(activity);
            }
        };
    }
    public static Predicate<Student> birthYearFilter(int minYear, int maxYear){
        return new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getBirthYear() >= minYear && student.getBirthYear() <= maxYear;
            }
        };
    }
    public static Predicate<Student> idFilter(int id){
        return new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
               return student.getId() == id;
            }
        };
    }
}
