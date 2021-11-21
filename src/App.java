import controller.Controller;
import model.BarModel;
import controller.Message;
import view.View;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {
    public static void main(String[] args) {

        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

        BarModel model = new BarModel();
        View view = new View(queue);
        Controller controller = new Controller(queue, model, view);
        controller.mainLoop();
    }
}
