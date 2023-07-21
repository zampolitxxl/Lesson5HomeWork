import java.util.List;

public class GroupePresenter {


    private final View view;  //поле вью
    private final GroupeModel model; //поле груп модель

    public GroupePresenter(View view,  GroupeModel model) {   //конструткор презентера , аргументы вью и модель
        this.view = view;
        this.model = model;
    }

    public void create(String groupeName) {
        model.create(groupeName);
    }//метод  добавляения покупателя причем взят из
    //кастомер модел вот он переходничек

    public void getAll() {
        List<Groupe> all = model.getAll();
        view.printAllGroups(all);
        //распечатать всех кастомеров причем метод взят и з модели зачем то
    }
}
