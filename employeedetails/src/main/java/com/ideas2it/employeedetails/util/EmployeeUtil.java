package com.ideas2it.employeedetails.util;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ideas2it.employeedetails.employeeEnum.Enum;

public class EmployeeUtil {

    /**
     * This method is used to generate ID
     *
     * @return {@link String} employeeId
     */
    public static String generateIdNumber() {
        Random random = new Random();
        int range = 99999 - 10000 + 1;
        int randomNum = random .nextInt(range) + 10000;
        char identity = 'I';
        String employeeId = identity+""+randomNum;
        return employeeId;
    }

    /**
     * This method is used to Validate Name
     *
     * @return {@link boolean}
     */
    public static boolean isValidName(String employeeName) {
        Pattern pattern = Pattern.compile("^[A-Za-z]{1}[A-Za-z.]{0,}$");
        Matcher match = pattern.matcher(employeeName);
        if ( match.find()) {
            return true;
        }
        return false;
    }

    /**
     * This method is used to Validate Designation
     *
     * @return {@link boolean}
     */
    public static boolean isValidDesignation(String designation) {
        Pattern pattern = Pattern.compile("^[A-Za-z]{1}[A-Za-z.]{0,}$");
        Matcher match = pattern.matcher(designation);
        if ( match.find()) {
            return true;
        }
        return false;
    }

    /**
     * This method is used to Validate Designation
     *
     * @return {@link boolean}
     */
    public static boolean isValidContactNumber(String contactNumber) {
        Pattern pattern = Pattern.compile("^[1-9][0-9]{9}$");
        Matcher match = pattern.matcher((contactNumber));
        if ( match.find()) {
            return true;
        }
        return false;
    }

    /**
     * This method is used to Validate Designation
     *
     * @return {@link boolean}
     */
    public static boolean isValidDateOfBirth(String dateOfBirth) {
        Pattern pattern = Pattern.compile("^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-([0-9]{4})$");
        Matcher match = pattern.matcher(dateOfBirth);
        if ( match.find()) {
            return true;
        }
        return false;
    }

    /**
     * This method is used to Validate Designation
     *
     * @return {@link boolean}
     */
    public static boolean isValidEmailId(String emailId) {
        Pattern pattern = Pattern.compile("([a-z0-9-_./]+)@(.+)$");
        Matcher match = pattern.matcher(emailId);
        if ( match.find()) {
            return true;
        }
        return false;
    }

    /**
     * This method is used to Validate Designation
     *
     * @return {@link boolean}
     */
    public static boolean isValidGender(String gender) {
        for(Enum.Gender g : Enum.Gender.values()) {
            if (gender.equalsIgnoreCase(g.name())){
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to Validate Designation
     *
     * @return {@link boolean}
     */
    public static boolean isValidMaritalStatus(String maritalStatus) {
        for(Enum.MaritalStatus maritalstatus : Enum.MaritalStatus.values()) {
            if (maritalStatus.equalsIgnoreCase(maritalstatus.name())){
                return true;
            }
        }
        return false;
    }


}