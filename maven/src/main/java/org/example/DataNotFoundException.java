package org.example;

public class DataNotFoundException extends Exception{
    @Override
    public void printStackTrace() {
        System.out.println("\nДанные на ваш запрос не найдены." +
                "\n Попробуйте еще раз.");}
}
