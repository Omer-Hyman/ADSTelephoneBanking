import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The telephone Banking System is an assignment for Algorithms and Data Structure 2
 * @author Jing Wang @ SHU
 * @verison 1.1
 */

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

    private static void state_Q_listAll(){
        queue.displayList();
        currentState = State.WELCOME;
    }

    private static void state_Q_push() throws FileNotFoundException {
        queue.pushQueue();
        currentState = State.WELCOME;
    }

    private static void state_Q_pop(){
        queue.popQueue();
        currentState = State.TASK;
    }

    private static void state_task() {
        currentRequest.newRequest();
        System.out.print("This customer want to ");
        switch (currentRequest.request){
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

    private static void state_H_remove() {
        userData.deleteCustomer(currentRequest.id);
        currentState = State.WELCOME;
    }

    private static void state_H_new() {
        userData.addCustomer(new UserRecord(currentRequest.id, currentRequest.amountToChange));//new username works, balance doesn't yet.
        currentState = State.WELCOME;
    }

    private static void state_H_saveMoney() {
        int i = userData.findCustomer(currentRequest.id);
        userData.getRecords()[i].increaseBalance(currentRequest.amountToChange);
        currentState =  State.DISPLAY;
    }

    private static void state_H_reduceMoney() {
        int i = userData.findCustomer(currentRequest.id);
        userData.getRecords()[i].decreaseBalance(currentRequest.amountToChange);
        currentState = State.DISPLAY;
    }

    private static void state_H_display() {
        int i = userData.findCustomer(currentRequest.id);
        System.out.println(userData.getRecords()[i].getBalance());
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
