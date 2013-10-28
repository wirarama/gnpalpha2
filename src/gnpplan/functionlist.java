/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gnpplan;

/**
 *
 * @author test
 */
public class functionlist {
    public static int randomrange(int min,int max){
        int randomvalue = min + (int)(Math.random() * ((max - min) + 1));
        return randomvalue;
    }
    public static int[][] makerandomdataset(int amount,int[][] stuck,int min,int max){
        int[][] data = new int[amount][2];
        for(int i=0;i<amount;i++){
            data[i][0] = i+1;
            int rand = (i+randomrange(1,20))*randomrange(min,max);
            if(i!=0){
                if(rand<data[i-1][1]){
                    rand=data[i-1][1];
                }
            }
            for(int j=0;j<stuck.length;j++){
                if(i>stuck[j][0] && i<stuck[j][1]){
                    rand = data[i-1][1];
                }
            }
            data[i][1] = rand;
        }
        return data;
    }
    public static int[][] makerandomdataset1(int amount,int[][] stuck,int start,int min){
        int[][] data = new int[amount][2];
        int rand = start;
        for(int i=0;i<amount;i++){
            data[i][0] = i+1;
            for(int j=0;j<stuck.length;j++){
                if(i>=stuck[j][0] && i<stuck[j][1]){
                    rand = rand-min;
                }
            }
            data[i][1] = rand;
        }
        return data;
    }
}
