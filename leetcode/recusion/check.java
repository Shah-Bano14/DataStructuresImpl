package leetcode.recusion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class check {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd, yyyy", Locale.US);
        String formattedDate = date.format(formatter);
        System.out.println(formattedDate);  // Outputs something like: Wed, Apr 21, 2024

    }
}
