package controller;

public class ResetMessage implements Message{
    private int[] values = {0, 0, 0};

    public ResetMessage(){
    }

    public int[] getValues(){
        return values;
    }
}
