package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class ViewRoot {
    private List<String> mainOptions = new ArrayList<>(asList("1. Add new book to my book collection",
            "2. Edit given book's data",
            "3. Delete book from collection",
            "4. Search for a books",
            "5. See all books available in library sorted ascending by name of books",
            "6. See all books written by given author",
            "0. Quit",
            ""));

    public void showMainOptions(String name){
        showMessage("Hello, " + name + "! What would you like to do?");
        for(String option: mainOptions){
            showMessage(option);
        }
    }

    public void showMessage(String message){
        System.out.println(message);
    }

    public String getUserInput(String message) {
        String input = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            do {
                System.out.print(message);
                input = reader.readLine();
            } while (input.trim().isEmpty());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

    public Integer getUserIntInput(String message){
        Integer input = null;
        boolean isInputInt = false;
        do{
            try {
                String stringInput = getUserInput(message);
                input = Integer.parseInt(stringInput);
                isInputInt = true;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }while (!isInputInt);

        return input;
    }

    public Float getUserFloatInput(String message){
        Float input = null;
        boolean isInputInt = false;
        do{
            try {
                String stringInput = getUserInput(message);
                input = Float.parseFloat(stringInput);
                isInputInt = true;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }while (!isInputInt);

        return input;
    }

    public Long getUserLongInput(String message){
        Long input = null;
        boolean isInputInt = false;
        do{
            try {
                String stringInput = getUserInput(message);
                input = Long.parseLong(stringInput);
                isInputInt = true;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }while (!isInputInt);

        return input;
    }

    public <T> void showCollecton(ArrayList<T> collection){
        int counter = 0;
        for(T item: collection){
            showMessage("ID " + counter++ + ": " + item.toString());
        }
    }
}

