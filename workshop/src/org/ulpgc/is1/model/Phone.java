package org.ulpgc.is1.model;

public class Phone{
    private String number;

    public Phone(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String isValid(String number){
        if(number.length() == 9){
            return number;
        } else {
            number = "XXXX";
            return number;
        }
    }
}
