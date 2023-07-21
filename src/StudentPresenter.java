import java.util.List;
import java.util.UUID;

public class StudentPresenter {
    //на вью не завязан
    //заяаз на модел Ордер и Кастомер

    private final GroupeModel groupeModel; // поле груп модель
    private final StudentModel studentModel; //поле студент модель

    public StudentPresenter(GroupeModel groupeModel, StudentModel studentModel) { //конструткор
        this.groupeModel = groupeModel;
        this.studentModel = studentModel;
    }

    public void create(String groupeId, String name) { // ищем по йди группы
        Groupe groupe = groupeModel.getById(UUID.fromString(groupeId));
        if (groupe != null) {
            studentModel.create(groupe, name); // слздаем заказ этому кстомеру
        }
    }

    public List<Student> getAll() {
        return studentModel.getAll();
    }  // переходничек всех достать

    public List<Student> getByGroupe(String groupeId) {
        Groupe groupe = groupeModel.getById(UUID.fromString(groupeId)); //ищем группу по айди
        if (groupe != null) {
            return studentModel.getByGroupe(groupe);  // возвращает список студентов по определеннной группе
        }
        return List.of();
    }
}
