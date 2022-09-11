package com.nagarro.statementservice.infrastructure.helpers.utilities;

public class AccountUtils {
    /**
     * Masks account number except for the last 4 digits
     */
    public static String getMaskedAccountNumber(String accountNumber) {
        int accountNumberLength = accountNumber.length();
        int maskedDigitsLength = accountNumberLength - 4;
        return "#".repeat(maskedDigitsLength) + accountNumber.substring(maskedDigitsLength, accountNumberLength);
    }
}
