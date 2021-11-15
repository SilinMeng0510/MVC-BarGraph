package model;

public class BarModel {
    private int[] height = new int[3];

    public int[] getHeight(){
        return height;
    }

    public void setHeight(int[] value){
        for (int i = 0; i < value.length; i++){
           if (value[i] < 0){
               value[i] = height[i];
           }
        }
        height = value;
    }
}
