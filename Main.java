package com.accenture.itfactory.base.GuessingGame;

import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Correct termination strings and outputs
        Main m= new Main();
        Scanner in = new Scanner(System.in);
        System.out.println("Берите сложность- 3, 4 или 5");
        int level = in.nextInt();
        int number = 0;
        int num_of_trail = 0;
        boolean  correct_guess = false;
        if(level == 3 || level == 4 || level == 5){
            System.out.println("Выбрали сложность: "+ level);
            number = m.toNumber(m.numberGen(level));
            //System.out.println("number is:"+ number);}
            /*System.out.println("Enter your "+level+" digit guess:");
            int guess = in.nextInt();
            int [] guess_arr = m.toArray(guess,level);
            //System.out.println("Guess arr is:");
            //for(int i = 0; i< guess_arr.length;i++)
            //{
            //    System.out.println(guess_arr[i]);
            //}
            boolean correct  = m.verifyInput(guess_arr);
            if(correct) {
                //System.out.println("The number entered was correct");
                int [] number_arr = m.toArray(number,level);
                int[] result = m.compareNumbers(number_arr,guess_arr);
                for(int i = 0; i< guess_arr.length;i++)
                {
                    System.out.println(result[i]);
                }
            }
            else
                System.out.println("The number entered was wrong ");*/
        }
        else {
            while(level != 3 || level != 4 || level!= 5){
            System.out.println("Берите сложность- 3, 4 или 5");
            level = in.nextInt();
            //string num = number.ToString();
            }
        }
        String stop_game = "";
	//"Clf.cm" равна "Сдаюсь" при кириллинской раскладке
        while(stop_game != "Clf.cm" ||stop_game != "Сдаюсь" || num_of_trail <= 5)
        {
            System.out.println("Enter your " + level + " digit guess:");
            int guess = in.nextInt();
            stop_game = in.nextLine();
            int[] guess_arr = m.toArray(guess, level);
            /*System.out.println("Guess arr is:");
            for(int i = 0; i< guess_arr.length;i++)
            {
                System.out.println(guess_arr[i]);
            }*/
            boolean correct = m.verifyInput(guess_arr);
            correct_guess = false;
            if (correct) {
                    //System.out.println("The number entered was correct");
                    int[] number_arr = m.toArray(number, level);
                    int[] result = m.compareNumbers(number_arr, guess_arr);
                    for (int i = 0; i < result.length; i++) {
                        //System.out.println(result[i]);
                        if(result[i] != 1)
                        {
                            num_of_trail++;
                            correct_guess = false;
                            System.out.println("Try again!!!");
                            break;
                        }
                        else
                            correct_guess = true;
                    }
                } else
                    System.out.println("The number entered was wrong ");
        }
        if(num_of_trail == 6)
            System.out.println("You've exhausted your trials");
        if(correct_guess)
            System.out.println(("Well gone!!"));

        //System.out.println("You chose "+ level);
        //Random rnd = new Random();
        //System.out.println("The number generated was: "+ number);

        /*if(correct)
            System.out.println("The number entered was correct");
        else
            System.out.println("The number entered was wrong ");*/
        //String guess = String.valueOf(in.nextInt());

        System.out.println("I've finished programme");
        /*switch(level)
        {
            case 3: number = rnd.nextInt() + 1000;
            break;
            case 4: number  = rnd.nextInt() + 100000;
                break;
            case 5: number = rnd.nextInt() + 100000000;
                break;
            default: number = 0;
        }
        */
    }
	
    
    //Методы:
    public int[] numberGen(int difficulty){
        Random rnd = new Random();
        int num = 0;
        int next_int = 0;
        int counter = 1;
        int [] arr = new int[difficulty];
        boolean in_array;// = false;
        //int length = (int) Math.pow(10,difficulty);
        while(counter <= difficulty)
        {
            next_int = rnd.nextInt(10);
            in_array = true;
            arr[counter-1] = 0;
            //counter++;
            for(int i = 0; i<counter;i++)
            {
                //break;
                if(arr[i] == next_int)
                {
                    in_array = true;
                    break;
                }
                else
                    in_array = false;
            }
            if(in_array) {
                continue;
            }
            else if(!in_array)
            {
                arr[counter-1] = next_int;
                counter++;
            }
            /*if(num%length == next_int)
            {
                continue;
            }
            else
            {
                num += next_int;
                num *= 10;
                counter++;
            }*/
        }
        return arr; ///= 10;
    }
    public boolean verifyInput(int[] array)//,int difficulty)
    {
        if(array == null) return false;
        //System.out.println("In verifyInput");
        //int length = (int) Math.pow(10,(difficulty+1));
        //System.out.println("length "+length);
        //int [] num_arr = new int [difficulty];
        //int next = 0;
        boolean correct_format = true;

        /*for(int i = 0; i< difficulty;i++)
        {
            next = n % 10;
           // System.out.println("Next is "+next);
            num_arr[i] = next;
            n /= n % length;
            length /= 10;
            //System.out.println(a[i]);
        }*/
        for(int i = 0; i< array.length-1;i++)
        {
            if(array[i] == array[i+1])
            {
                System.out.println("found same pair "+array[i]+" and "+array[i+1]);
                correct_format = false;
                break;
            }
            else
                continue;
        }
        return correct_format;
    }
    public int[] toArray(int int_num,int difficulty)
    {
        int num_arr[] = new int[difficulty];
        //int length = (int) Math.pow(10,difficulty);
        int next = 0;
        for(int i = 0; i< difficulty;i++)
        {
            next = int_num % 10;
            //System.out.println("Next is "+next);
            num_arr[i] = next;
            int_num /= 10;//length;
            //length /= 10;
            //System.out.println(num_arr[i]);
            //System.out.println(int_num);
            //System.out.println(length);
        }
        for(int i = 0;i<num_arr.length/2;i++)
        {
            int x = num_arr[i];
            num_arr[i]= num_arr[num_arr.length-(i+1)];
            num_arr[num_arr.length-(i+1)] = x;
        }
        return num_arr;
    }
    public int[] compareNumbers(int[]number_arr,int[]guess_array)
    {
        if(number_arr != null && guess_array!=null)
        {
            if(number_arr.length != guess_array.length) return null;
        }
        else
            return null;
        int [] result_arr = new int[number_arr.length];
        for(int i = 0;i<result_arr.length;i++)
        {
            if(number_arr[i] == guess_array[i])
                result_arr[i] = 1;
            else
            {
                for(int j : guess_array)
                {
                    if(j == number_arr[i])
                        result_arr[i] = 2;
                }
            }
        }
        return result_arr;
    }
    public int toNumber(int[] number_arr)
    {
        if (number_arr == null) return 0;
        int int_num = 0;
        for(int i =0;i<number_arr.length;i++)
        {
            int_num += number_arr[i];
            int_num *= 10;
        }
        int_num /= 10;
        return int_num;
    }
}
