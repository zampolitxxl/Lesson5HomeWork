import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentModel {
    private List<Student> storage = new ArrayList<>(); //  пустой список, впоследствии хранилище студентов

    public void create(Groupe groupe, String name) {  // хитрый метод создания студента, хотя по факту он добавляется в группу
        storage.add(new Student(groupe, name));
    }

    public List<Student> getAll() {
        return List.copyOf(storage);
    } // метод получения всех стедентов

    public List<Student> getByGroupe(Groupe groupe) {  // все студенты группы
        return storage.stream()
                .filter(it -> Objects.equals(it.getGroupe(), groupe))
                .toList();
    }
}
