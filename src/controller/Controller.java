package controller;

import model.BarModel;
import view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Controller {
    BlockingQueue<Message> queue;
    BarModel barModel;
    View view;
    private List<Valve> valves = new LinkedList<Valve>();

    public Controller(BlockingQueue<Message> queue, BarModel barModel, View view){
        this.queue = queue;
        this.barModel = barModel;
        this.view = view;

        valves.add(new DoUpdateValve());
        valves.add(new DoResetValve());
    }

    public void mainLoop() {
        ValveResponse response = ValveResponse.EXECUTED;
        Message message = null;
        while (response != ValveResponse.FINISH) {
            try {
                message = queue.take(); // <--- take next message from the queue
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Look for a Valve that can process a message
            for (Valve valve : valves) {
                response = valve.execute(message);
                // if successfully processed or game over, leave the loop
                if (response != ValveResponse.MISS) {
                    break;
                }
            }
        }
    }

    private class DoUpdateValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != UpdateMessage.class){
                return ValveResponse.MISS;
            }
            UpdateMessage msg = (UpdateMessage) message;
            barModel.setHeight(msg.getValues());
            view.updateBarGraph(barModel.getHeight());
            return ValveResponse.EXECUTED;
        }
    }

    private class DoResetValve implements Valve {
        @Override
        public ValveResponse execute(Message message) {
            if (message.getClass() != ResetMessage.class){
                return ValveResponse.MISS;
            }
            ResetMessage msg = (ResetMessage) message;
            barModel.setHeight(msg.getValues());
            view.updateBarGraph(barModel.getHeight());
            return ValveResponse.EXECUTED;
        }
    }

    private interface Valve {
        /**
         * Performs certain action in response to message
         */
        public ValveResponse execute(Message message);
    }
}


