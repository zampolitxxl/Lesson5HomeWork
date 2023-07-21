import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class GroupeModel {
    // customerModel -> [api (view), service (presenter), repository (model)]

    private List<Groupe> storage = new ArrayList<>(); //создали список пустой объектов типа Groupe

    public void create(String name) {
        storage.add(new Groupe(name));
    } // метод добавления группы в хранилеще

    public List<Groupe> getAll() {
        return List.copyOf(storage);
    } //метод получения списка групп(хранилища)

    public Groupe getById(UUID id) {      // метод поиска по id
        return storage.stream()
                .filter(it -> Objects.equals(it.getId(), id)) //
                .findFirst()
                .orElse(null);
    }
}
