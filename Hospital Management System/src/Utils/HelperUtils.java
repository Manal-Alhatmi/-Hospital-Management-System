package Utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class HelperUtils {

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNull(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    public static boolean isNotNull(String str) {
        return (str != null && !str.isEmpty());
    }

    public static boolean isValidString(String str) {
        return isNotNull(str);
    }

    public static boolean isValidString(String str, int minLength) {
        return isNotNull(str) && str.length() >= minLength;
    }

    public static boolean isValidString(String str, int minLength, int maxLength) {
        return isNotNull(str) && str.length() >= minLength && str.length() <= maxLength;
    }

    public static boolean isValidString(String str, String regex) {
        return isNotNull(str) && str.matches(regex);
    }

    public static String generateId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public static String generateId(String prefix) {
        return prefix + "-" + UUID.randomUUID().toString().substring(0, 8);
    }

    public static String generateId(String prefix, int length) {
        StringBuilder id = new StringBuilder(prefix + "-");
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            id.append(random.nextInt(10));
        }
        return id.toString();
    }

    public static String generateId(String prefix, String suffix) {
        return prefix + "-" + UUID.randomUUID().toString().substring(0, 8) + "-" + suffix;
    }

    public static boolean isValidDate(Date date) {
        return date != null;
    }

    public static boolean isValidDate(String dateStr) {
        if (isNull(dateStr)) return false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        return date != null;
    }

    public static boolean isValidDate(LocalDate date, LocalDate minDate, LocalDate maxDate) {
        return date != null && !date.isBefore(minDate) && !date.isAfter(maxDate);
    }

    public static boolean isFutureDate(LocalDate date) {
        return date != null && date.isAfter(LocalDate.now());
    }

    public static boolean isPastDate(LocalDate date) {
        return date != null && date.isBefore(LocalDate.now());
    }

    public static boolean isToday(LocalDate date) {
        return date != null && date.isEqual(LocalDate.now());
    }

    public static boolean isValidNumber(int num, int min, int max) {
        return num >= min && num <= max;
    }

    public static boolean isValidNumber(double num, double min, double max) {
        return num >= min && num <= max;
    }

    public static boolean isPositive(int num) {
        return num > 0;
    }

    public static boolean isPositive(double num) {
        return num > 0;
    }

    public static boolean isNegative(int num) {
        return num < 0;
    }

    public static boolean isNegative(double num) {
        return num < 0;
    }

    public static boolean isValidAge(int age) {
        return isValidNumber(age, 0, 120);
    }

    public static boolean isValidAge(LocalDate dateOfBirth) {
        if (isNull(dateOfBirth))
            return false;
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return isValidAge(age);
    }

    public static boolean isEmptyList(java.util.List<?> list) {
        return list == null || list.isEmpty();
    }

    public static String capitalize(String str) {
        if (isNull(str)) return "";
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public static boolean isPositiveNumber(double number) {
        return number > 0;
    }
}
