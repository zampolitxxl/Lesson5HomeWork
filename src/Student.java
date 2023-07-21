import java.util.Objects;
import java.util.UUID;

public class Student {
    private static int counter = 1;

    private final UUID id;
    private final String name;
    private final Groupe groupe; //группа какая у студента название(обекта)

    public Student(Groupe groupe,  String name) { // конструтор нового студента  в аргумент идет название группы
        this.id = UUID.randomUUID();
        this.name = name;
        this.groupe = groupe;
    }

    public Groupe getGroupe() {
        return groupe;
    } // Геттер группы, в которой студент состоит

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id); //метод равенства
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "[" + id + "] (" + name + ") Groupe = {" + groupe + "}";
    }
}
