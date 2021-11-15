package controller;

public class UpdateMessage implements Message{
    private int[] values = new int[3];

    public UpdateMessage(int[] values){
        this.values = values;
    }

    public int[] getValues(){
        return values;
    }
}
