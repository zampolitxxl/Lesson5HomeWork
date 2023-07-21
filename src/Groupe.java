import java.util.Objects;
import java.util.UUID;

public class Groupe {
    //поля

    private final UUID id;   //идентифкатор группы
    private final String name; //имя группы

    public Groupe(String name) {   //конструктор группы
        this.id = UUID.randomUUID();  //айди уникальный рандомный
        this.name = name; //name   стринговый
    }

    public UUID getId() {
        return id;
    }  //геттер поля ID у группы

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Groupe groupe = (Groupe) o;
        return id.equals(groupe.id);   //метод равенства групп
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "[" + id + "] " + name;
    }
}

