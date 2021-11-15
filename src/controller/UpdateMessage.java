package controller;

public class UpdateMessage implements Message{
    private int[] heights = new int[3];

    public UpdateMessage(int[] values){
        heights = values;
    }

    public int[] getHeights(){
        return heights;
    }
}
