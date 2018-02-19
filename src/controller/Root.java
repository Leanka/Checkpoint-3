package controller;

import view.ViewRoot;

public class Root {
    private String name;
    private ViewRoot viewRoot;

    public Root(){
        this.name = "Jerzy";
        this.viewRoot = new ViewRoot();
    }

    public void runMenu(){
        boolean toContinue = true;
        do{
            viewRoot.showMainOptions(name);
            String option = viewRoot.getUserInput("Choose option: ");
            switch(option){
                case "1": viewRoot.showMessage("1");
                break;
                case "2": viewRoot.showMessage("2");
                break;
                case "3": viewRoot.showMessage("3");
                    break;
                case "4": viewRoot.showMessage("4");
                    break;
                case "5": viewRoot.showMessage("5");
                    break;
                case "6": viewRoot.showMessage("6");
                    break;
                case "0": toContinue = false;
                    break;
                default:
                    viewRoot.showMessage("There is no such option!");
            }
        }while(toContinue);

    }
}
