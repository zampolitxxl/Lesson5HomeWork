public class Main {
    public static void main(String[] args) {
        GroupeModel customerModel = new GroupeModel(); //? не понятно что создали конструктора нету
        StudentModel orderModel = new StudentModel();

        // Для удобства
        //customerModel.create("TestCustomer");
        //orderModel.create(customerModel.getAll().get(0));

        View view = new View(); // модуль view запустили

        GroupePresenter groupePresenter = new GroupePresenter(view, customerModel); //презентер создали в аргументы положили
        StudentPresenter studentPresenter = new StudentPresenter(customerModel, orderModel);

        view.setStudentPresenter(studentPresenter); //меод соединения  вью с презентером
        view.setGroupePresenter(groupePresenter);

        view.start();
    }
}