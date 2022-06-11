public class Worker {

    private onTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(onTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    @FunctionalInterface
    public interface onTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                error(i);
            }
            callback.onDone("Task " + i + " is done");
        }
    }

    public void error(int i) {
        errorCallback.onError("Task " + i + " is not done");
    }
}
