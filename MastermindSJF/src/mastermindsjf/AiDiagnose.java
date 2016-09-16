/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermindsjf;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author daer
 */
public class AiDiagnose {

    private int numColors;
    private int codeLength;
    private int loopCount;
    private int[] neededTries;
    private int[] neededTime;
    private boolean speedMode;

    public AiDiagnose(int numColors, int codeLength, int loopCount,boolean speedMode) {
        this.numColors = numColors;
        this.codeLength = codeLength;
        this.loopCount = loopCount;
        this.speedMode = speedMode;
        start();
    }

    private void start() {
        neededTime = new int[loopCount];
        neededTries = new int[loopCount];
        MasterMindGame mmg;
        AI ai;
        Calendar calendar = Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        for (int i = 0; i < loopCount; i++) {
            calendar.setTime(new Date());
            mmg = new MasterMindGame((int)Math.pow(numColors, codeLength), codeLength, numColors);
            long actTime = calendar.getTimeInMillis();
            ai = new AI(mmg);
            ai.setSpeedMode(speedMode);
            neededTries[i] = ai.play().length;
            calendar.setTime(new Date());
            neededTime[i] = (int)calendar.getTimeInMillis() - (int)actTime;
        }
    }

    public double getAverage() {

        return (double) getSum() / (double) neededTries.length;
    }

    public int getSum() {
        int sum = 0;
        for (int nt : neededTries) {
            sum += nt;
        }
        return sum;
    }
    
    public int getMax(){
       int max = 0;
       for(int nt : neededTries){
           if(nt > max){
               max = nt;
           }
       }
       return max;
    }
    
    public int getMin(){
        int min = 100000000;
               for(int nt : neededTries){
           if(nt < min){
               min = nt;
           }
       }
               return min;
    }

    public double getAverageTime() {
        return (double)getSumTime() / (double)neededTime.length;
    }

    public int getSumTime() {
        int sum = 0;
        for (int nt : neededTime) {
            sum += nt;
        }
        return sum;
    }

}
