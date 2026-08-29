public class IsbnValidator {
    static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) return "Invalid: length must be 13 characters";

        String pub = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        for (char c : pub.toCharArray()) {
            if (!Character.isLetter(c)) return "Invalid: publisher code must be 3 letters";
        }
        for (char c : (year + catalog).toCharArray()) {
            if (!Character.isDigit(c)) return "Invalid: remaining 10 characters must be digits";
        }

        return new StringBuilder().append("[").append(pub).append("] YEAR: ")
                .append(year).append(" | CATALOG: ").append(catalog).toString();
    }

    public static void main(String[] args) {
        String normalized = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(normalized));
        System.out.println(validateAndFormat("12N2026004251"));
    }
}