package ru.springcourse.lessons.validators;

import ru.springcourse.lessons.Constants;

public class CalculatorParametersValidator {

    public static boolean validateNumber(String parameter){
        try{
            Double.parseDouble(parameter);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static boolean validateAction(String action){
        return action.equals(Constants.MULTIPLICATION) ||
                action.equals(Constants.DIVISION) ||
                action.equals(Constants.ADDITION) ||
                action.equals(Constants.SUBTRACTION);
    }
}
