package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main
{
    //  Кубик Рубіка як 3-охвимірний масив випадково згенерованих стрічок
    public static void main(String[] args)
    {
        int[] wyrbog_count = {0,0,0,0,0,0};
        String[] colors = {"white","yellow","red","blue","orange","green"};
        String[][][] Rubik = new String[6][3][3];
        for (int i = 0; i < Rubik.length; i++){
            for (int j = 0; j < Rubik[i].length;j++) {
                for (int k = 0; k < Rubik[i][j].length; k++) {
                    Rubik[i][j][k] = Randcolor(colors);
                    colors = SortColors(colors, Rubik[i][j][k], wyrbog_count);
                }
            }
        }
        for (int i = 0; i < Rubik.length; i++){
            for (int j = 0; j < Rubik[i].length;j++) {
                for (int k = 0; k < Rubik[i][j].length; k++){
                    if(k < Rubik[i][j].length-1)
                        System.out.print(Rubik[i][j][k]+' ');
                    else
                        System.out.print(Rubik[i][j][k]+"\n");
                }
            }
            System.out.print("\n");
        }
        Authorship();
    }

    public static String Randcolor(String[] colors){
        List<String> colorlist = Arrays.asList(colors);
        Collections.shuffle(colorlist);
        return colorlist.get(0);
    }
    public static String[] SortColors(String[] colors, String color, int[] count_arr) {
        switch (color) {
            case "white":
                if (++count_arr[0]==9) {
                    colors = Removecolor(colors,color);
                }
                break;
            case "yellow":
                if (++count_arr[1]==9) {
                    colors = Removecolor(colors,color);
                }
                break;
            case "red":
                if (++count_arr[2]==9) {
                    colors = Removecolor(colors,color);
                }
                break;
            case "blue":
                if (++count_arr[3]==9) {
                    colors = Removecolor(colors,color);
                }
                break;
            case "orange":
                if (++count_arr[4]==9) {
                    colors = Removecolor(colors,color);
                }
                break;
            case "green":
                if (++count_arr[5]==9) {
                    colors = Removecolor(colors,color);
                }
                break;
            default:
                break;
        }
        return colors;
    }
    public static String[] Removecolor(String[] colors, String color){
        List<String> colorlist = new ArrayList<>(Arrays.asList(colors));
        colorlist.remove(color);
        colors = colorlist.toArray(new String[0]);
        return colors;
    }
    public static void Authorship() {
        String[] text = {"Program","made","by","shyshk4"};
        for (int i = 0; i < text.length; i++){
            if (i < text.length-1)
                System.out.print(text[i]+' ');
            else
                System.out.print(text[i]+"\n");
        }
    }
}