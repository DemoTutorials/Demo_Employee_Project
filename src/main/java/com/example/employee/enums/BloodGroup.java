package com.example.employee.enums;

public enum BloodGroup {
    A_Positive,A_Negative,
    B_Positive,B_Negative,
    AB_Positive,AB_Negative,
    O_Positive,O_Negative;


    public static BloodGroup fromString(String key){
        return key==null?null:BloodGroup.valueOf(key);
    }
}
