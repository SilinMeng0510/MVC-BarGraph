import org.codehaus.groovy.control.messages.Message;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {
    public static void main(String[] args) {

        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

        // StudentModel model = new StudentModel();
        // View view = new View(queue, model.getName(), model.getClasses());
        // Controller controller = new Controller(queue, model, view);
        // controller.mainLoop();
    }
}
