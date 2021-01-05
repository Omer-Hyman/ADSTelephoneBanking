import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The telephone Banking System is an assignment for Algorithms and Data Structure 2
 * @author Jing Wang @ SHU
 * @verison 1.1
 */

//MAYBE TRY TO PUT MORE THINGS IN MAIN CLASS LIKE RECORDS[I]
//SO I DONT HAVE TO MAKE TEMP OBJECT OF THE CLASS TO GET ITS METHODS!!

public class Main {
    //State Machine parameters
    public enum State{START, STOP, WELCOME, LIST_ALL, PUSH, POP, TASK, REMOVE, NEW, SAVE, WITHDRAW, DISPLAY};
    public static State currentState = State.START;

    //Global variables
    public static Scanner inputOrder = new Scanner(System.in);
    public static Scanner inputID = new Scanner(System.in);
    public static CustomerQueue queue;
    public static CustomerData userData;
    public static CustomerRequest currentRequest = new CustomerRequest();



    public static void main(String[] args) throws FileNotFoundException {
        while (currentState != State.STOP){
            switch (currentState){
                default: break;
                case START:     state_start();
                    break;
                case WELCOME:   state_welcome();
                    break;
                case LIST_ALL:  state_Q_listAll();
                    break;
                case PUSH:      state_Q_push();
                    break;
                case POP:       state_Q_pop();
                    break;
                case TASK:      state_task();
                    break;
                case REMOVE:    state_H_remove();
                    break;
                case NEW:       state_H_new();
                    break;
                case SAVE:      state_H_saveMoney();
                    break;
                case WITHDRAW:  state_H_reduceMoney();
                    break;
                case DISPLAY:   state_H_display();
                    break;
            }
        }
        clear();
    }

    private static void state_start() throws FileNotFoundException {
        System.out.println("System Initialization...");
        System.out.println("Load customer database...");
        userData = new CustomerData();
        System.out.println("Initializing queue...");
        queue = new CustomerQueue();
        currentState = State.WELCOME;
    }

    private static void state_welcome() {
        System.out.println("\n\n==Telephone Banking Control Centre==");
        System.out.println("Choose the index number from following options:\n1. Get the next customer\n2. Queueing a new customer\n3. Check current queue\n4. Quit");
        if (inputOrder.hasNext("1")) currentState = State.POP;
        if (inputOrder.hasNext("2")) currentState = State.PUSH;
        if (inputOrder.hasNext("3")) currentState = State.LIST_ALL;
        if (inputOrder.hasNext("4")) currentState = State.STOP;
        inputOrder.next();
    }

    private static void state_Q_listAll() {
        CustomerQueue list = new CustomerQueue();
        list.getQueue().displayList();
        currentState = State.WELCOME;
    }

    private static void state_Q_push() {
        CustomerRequest newRequest = new CustomerRequest();
        queue.pushQueue();
        currentState = State.WELCOME;
    }

    private static void state_Q_pop() {
        queue.popQueue();
        currentState = State.TASK;//Uncomment this statement after the Pop function is fully developed
    }


    private static void state_task() {
        currentRequest.newRequest();
        System.out.print("This customer want to ");
        //currentRequest.request
        switch (0){
            default: break;
            case 0: System.out.println("open a new account");
                System.out.println("Please input a new account ID:");
                currentRequest.id = inputID.nextLine();
                if (currentRequest.checkID(currentRequest.id))
                    currentState = State.NEW;
                break;
            case 1: System.out.println("close the account");
                System.out.println("Please input the account ID:");
                currentRequest.id = inputID.nextLine();
                if (currentRequest.checkID(currentRequest.id))
                    currentState = State.REMOVE;
                break;
            case 2: System.out.println("check balance");
                System.out.println("Please input the account ID:");
                currentRequest.id = inputID.nextLine();
                if (currentRequest.checkID(currentRequest.id))
                    currentState = State.DISPLAY;
                break;
            case 3: System.out.println("save £"+currentRequest.amountToChange);
                System.out.println("Please input the account ID:");
                currentRequest.id = inputID.nextLine();
                if (currentRequest.checkID(currentRequest.id))
                    currentState = State.SAVE;
                break;
            case 4: System.out.println("withdraw £"+currentRequest.amountToChange);
                System.out.println("Please input the account ID:");
                currentRequest.id = inputID.nextLine();
                if (currentRequest.checkID(currentRequest.id))
                    currentState = State.WITHDRAW;
                break;
        }
    }

    //throw file exception everywhere that CustomerData object is used

    private static void state_H_remove() {
        List list = new List(null);
        CustomerQueue temp = new CustomerQueue();

        int index = temp.getRecords().searchList(currentRequest.id);
        if (index != -1)
        {
            list.deleteCustomer(index);
        }
        else
        {
            System.out.println("account not found!");
        }
        currentState = State.WELCOME;
    }

    private static void state_H_new() throws FileNotFoundException {
        CustomerQueue list = new CustomerQueue();
        UserRecord user =new UserRecord(currentRequest.id, currentRequest.amountToChange);
        list.getRecords().setCustomer(user);
        currentState = State.WELCOME;
    }

    private static void state_H_saveMoney() {
        System.err.println("'Save Money' function is not implemented");//Delete this statement after the function is fully developed
        currentState =  State.DISPLAY;
    }

    private static void state_H_reduceMoney() {
        System.err.println("'Withdraw Money' function is not implemented");//Delete this statement after the function is fully developed
        currentState = State.DISPLAY;

    }

    private static void state_H_display() {
        System.err.println("'Show Balance' function is not implemented");//Delete this statement after the function is fully developed

        currentState = State.WELCOME;
    }

    private static void clear() {
        System.out.println("Clearing data...");
        //Deleted by the Garbage collector.
        queue = null;
        userData = null;
        System.out.println("===See you next time===");
    }

}
