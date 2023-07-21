import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class View {



    private GroupePresenter groupePresenter;  //поля презентеры groupe и student
    private StudentPresenter studentPresenter;

    private final Scanner scanner; // сканер

    public View() {
        this.scanner = new Scanner(System.in);
    } //конструтор

    public void setGroupePresenter(GroupePresenter groupePresenter) {  //сеттер groupe презентера
        this.groupePresenter = groupePresenter; //выставить groupe презентер
    }

    public void setStudentPresenter(StudentPresenter studentPresenter) {
        this.studentPresenter = studentPresenter;
    } //сеттер ордер презентера  по сути тот же констурктор

    public void start() {   // сама программа для ползователя
        while (true) {
            System.out.println("""
                    Список доступных команд:
                    1. groupe create {name}
                    2. groupe list
                    3. student create {groupeId} {student name}
                    4. student list
                    5. student {groupeId}
                    6. exit
                    """);
            String command = scanner.nextLine();

            if ("exit".equals(command)) {
                break;
            }

            String[] commandArray = command.split(" ");
            String commandName = commandArray[0];
            String[] args = Arrays.copyOfRange(commandArray, 1, commandArray.length);

            if ("groupe".equals(commandName)) {
                handleGroupeCommand(args); // для удобства делит команды
            } else if ("student".equals(commandName)) {
                handleStudentCommand(args); //для удобства делит команды
            } else {
                // ошибка
            }
        }
    }

    public void printAllGroups(List<Groupe> groupes) {
        System.out.println(groupes);
    }

    private void handleGroupeCommand(String[] args) {
        if (args.length == 2) {
            String groupeName = args[1];
            groupePresenter.create(groupeName);  //обращаемся в презентер
        } else if (args.length == 1 && "list".equals(args[0])) {
            groupePresenter.getAll();

//            List<Customer> customers = customerPresenter.getAll();
//            System.out.println(customers);
        } else {
            System.err.println("Неизвестная команда");
        }
    }

    private void handleStudentCommand(String[] args) {
        if (args.length == 1) {
            if ("list".equals(args[0])) {
                System.out.println(studentPresenter.getAll());
            } else {
                String groupeId = args[0];
                System.out.println(studentPresenter.getByGroupe(groupeId));
            }
        } else if (args.length == 3 && "create".equals(args[0])) {
            String groupeId = args[1];
            String name = args[2];

            System.out.println("арг1  "+groupeId);
            System.out.println("арг2  "+ name);


            studentPresenter.create(groupeId,  name);
        } else {
            System.err.println("Неизвестная команда");
        }
    }
}
