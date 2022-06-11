public class Main {

    public static void main(String[] args) {
        Worker.onTaskDoneListener listener = System.out::println;
        Worker.OnTaskErrorListener errorList = System.out::println;
        Worker worker = new Worker(listener, errorList);
        worker.start();
    }
}