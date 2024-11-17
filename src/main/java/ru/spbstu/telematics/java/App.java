package ru.spbstu.telematics.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Вы не указали два файла из которых требуется прочитать строки");
            return;
        }
        //сохранили в переменные имена файлов, переданные в качестве аргументов в программу
        String file1 = args[0];
        String file2 = args[1];

        try(BufferedReader reader1 = new BufferedReader(new FileReader(file1));
            BufferedReader reader2 = new BufferedReader(new FileReader(file2))){
            String line1;
            String line2;
            
            while(true){
                line1 = reader1.readLine();
                if(line1!=null){
                    System.out.println(line1);
                }
                else{
                    break; //строки в первом файле закончились
                }

                line2 = reader2.readLine();
                if(line2!=null){
                    System.out.println(line2);
                }
                else{
                    break; //строки во втором файле закончились
                }
            }

            //если остались строки в 1ом/2ом файле, то выводим их
            while((line1 = reader1.readLine())!=null){
                System.out.println(line1);
            }
            while((line2 = reader2.readLine())!=null){
                System.out.println(line2);
            }

        }
        catch(IOException exp){
            System.err.println("Ошибка при чтении файлов: " + exp.getMessage());
        }

    }

}
