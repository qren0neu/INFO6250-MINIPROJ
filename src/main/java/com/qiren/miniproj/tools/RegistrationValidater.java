package com.qiren.miniproj.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.qiren.miniproj.bean.UserRegistrationBean;

public class RegistrationValidater {

    private UserRegistrationBean registrationInfo;
    private String formattedString;
    private String errorInfo;

    public RegistrationValidater(UserRegistrationBean registrationInfo) {
        super();
        this.registrationInfo = registrationInfo;
    }

    public boolean isValid() {
        return isValid(true);
    }

    public boolean isValid(boolean checkPass) {
        String companyPattern = "([a-zA-Z0-9]+\\s?)+";
        String addressPattern = "([a-zA-Z0-9]+\\s?)+";
        String statePattern = "[A-Z]{2}";
        String postalPattern = "([A-Z0-9]{3}\\s?){2}";
        String positionPattern = "([a-zA-Z]+\\s?)+";
        String userNamePattern = "[a-zA-Z0-9]{4,8}";
        String passwordPattern = ".{8,16}";
        String namePattern = "[A-Z][a-z]+";
        String mobilePattern = "(\\(\\+[0-9]+\\))?\\s?[0-9]{3}-[0-9]{3}-[0-9]{4}";
        String emailPattern = "([a-zA-Z0-9]+)([\\_\\.\\-{1}])?([a-zA-Z0-9]+)\\@([a-zA-Z0-9]+)([\\.])([a-zA-Z\\.]+)";
        // check name
        String fname = registrationInfo.getFname();
        String lname = registrationInfo.getLname();
        String fullName = "";
        if (stringBlank(fname) || stringBlank(lname)) {
            setErrorInfo("Missing first name or last name");
        } else {
            // check name pattern
            String mnameSpace = "";
            boolean allMatch = true;
            allMatch = allMatch && fname.matches(namePattern);
            allMatch = allMatch && lname.matches(namePattern);
            fullName = fname + " " + lname;
            if (!allMatch) {
                setErrorInfo("Invalid name format");
            }
        }
        // check address related info
        String address1 = registrationInfo.getAddress1();
        String city = registrationInfo.getCity();
        String state = registrationInfo.getState();
        String postalCode = registrationInfo.getPostalCode();
        String fullAddress = "";
        if (stringBlank(address1)
                || stringBlank(city)
                || stringBlank(state)
                || stringBlank(postalCode)) {
            setErrorInfo("Missing address info");
        } else {
            if (!address1.matches(addressPattern)) {
                setErrorInfo("Invalid address format");
            }
            if (!postalCode.matches(postalPattern)) {
                setErrorInfo("Invalid postal code format");
            }
            if (!state.matches(statePattern)) {
                setErrorInfo("Invalid state format");
            }
        }
        fullAddress = address1
                + ", " + city
                + ", " + state
                + ", " + postalCode;
        // contact info
        String mobile = registrationInfo.getMobileNumber();
        if (stringBlank(mobile)) {
            setErrorInfo("Missing mobile number");
        } else {
            // phone validation
            if (!mobile.matches(mobilePattern)) {
                setErrorInfo("Invalid mobile format");
            }
        }
        String email = registrationInfo.getEmail();
        if (stringBlank(email)) {
            setErrorInfo("Missing email address");
        } else {
            // Email Pattern reference:
            // https://stackoverflow.com/questions/16200965/regular-expression-validate-gmail-addresses
            if (!email.matches(emailPattern)) {
                setErrorInfo("Invalid email format");
            }
        }
        // other info
        String birthday = registrationInfo.getBirthday();
        if (!checkDate(birthday)) {
            setErrorInfo("Invalid birthday format");
        }
        // username and password
        String username = registrationInfo.getUsername();
        if (stringBlank(username)) {
            setErrorInfo("Missing username or password");
        } else {
            if (!username.matches(userNamePattern)) {
                setErrorInfo("Invalid Username format");
            }
        }
        if (checkPass) {
            String password = registrationInfo.getPassword();
            String confirm = registrationInfo.getConfirmPassword();
            if (stringBlank(password)) {
                setErrorInfo("Missing username or password");
            } else {
                if (!password.matches(passwordPattern)) {
                    setErrorInfo("Invalid Password format");
                }
                if (!password.equals(confirm)) {
                    setErrorInfo("Password mismatch confirm password");
                }
            }
        }
        return null == getErrorInfo() || getErrorInfo().isEmpty();
    }

    private boolean stringBlank(String s) {
        return null == s || s.isBlank();
    }

    private void setErrorInfo(String errorInfo) {
        if (null == this.errorInfo) {
            this.errorInfo = errorInfo;
        }
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    private boolean checkDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        try {
            sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return formattedString;
    }
}
