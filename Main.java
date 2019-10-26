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
        }
        else {
            while(level != 3 || level != 4 || level!= 5){
            System.out.println("Берите сложность- 3, 4 или 5");
            level = in.nextInt();
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
           
            boolean correct = m.verifyInput(guess_arr);
            correct_guess = false;
            if (correct) {
                    int[] number_arr = m.toArray(number, level);
                    int[] result = m.compareNumbers(number_arr, guess_arr);
                    for (int i = 0; i < result.length; i++) {
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

        System.out.println("I've finished programme");
    }
	
    
    //Методы:
    public int[] numberGen(int difficulty){
        Random rnd = new Random();
        int num = 0;
        int next_int = 0;
        int counter = 1;
        int [] arr = new int[difficulty];
        boolean in_array;// = false;
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
          }
        return arr; 
    }
    public boolean verifyInput(int[] array)
    {
        if(array == null) return false;
        boolean correct_format = true;
	
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
        int next = 0;
        for(int i = 0; i< difficulty;i++)
        {
            next = int_num % 10;
            num_arr[i] = next;
            int_num /= 10;
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
