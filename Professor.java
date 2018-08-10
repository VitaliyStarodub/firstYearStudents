package java_oop.firstYearStudends;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Professor {

    private final String firstName;
    private final String lastName;
    private final Discipline discipline;

    private final List<Group> groups = new ArrayList<>();

    public Professor(String firstName, String lastName, Discipline discipline) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.discipline = discipline;
    }

    public void addGroup(Group group){
        groups.add(group);
    }

    public String getFirstName() {
        return firstName;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    /**
     * This method compares Student's id in group with id in idMap, if result is true, prints in console
     * [Student' name] - present, else [Student's name] - absent
     * @param group
     * @param idMap
     */

    public void checkingList(Group group, Map<Integer, String> idMap){
        Map<Student, Boolean> map = new HashMap<>();
        for(Student student : group){
            map.put(student, false);
        }
        for(Map.Entry<Student, Boolean> pair : map.entrySet()){
            for(Map.Entry<Integer, String> idPair : idMap.entrySet()){
                if(pair.getKey().getId() == idPair.getKey()){
                    pair.setValue(true);
                }
            }
            Student key = pair.getKey();
            Boolean value = pair.getValue();
            System.out.println(key.getFirstName() + " " + key.getLastName() + " - " + (value ? "present" : "absent"));
        }
    }

    /**
     * Static method for searching object in list by predicate. Predicate options are written in class StudentPredicates
     * @param list
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> List<T> studentSearch(List<T> list, Predicate<T> predicate){

        List<T> predictateList = new ArrayList<>();
        for(T elem: list){
            if(predicate.test(elem)){
                predictateList.add(elem);
            }
        }
        return predictateList;
    }

    @Override
    public String toString() {
        return "Professor " + firstName + " " + lastName +
                ", discipline - " + discipline;
    }
}
