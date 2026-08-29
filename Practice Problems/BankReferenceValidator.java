public class BankReferenceValidator {
    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    static String validateAndFormat(String ref) {
        if (ref.length() != 14) return "Invalid: length must be 14 characters";

        String bank = ref.substring(0, 3);
        String date = ref.substring(3, 9);
        String seq = ref.substring(9, 14);

        for (char c : bank.toCharArray()) {
            if (!Character.isLetter(c)) return "Invalid: bank code must be 3 letters";
        }
        for (char c : (date + seq).toCharArray()) {
            if (!Character.isDigit(c)) return "Invalid: remaining 11 characters must be digits";
        }

        String formattedDate = date.substring(0, 2) + "/" + date.substring(2, 4) + "/" + date.substring(4, 6);
        return new StringBuilder().append("[").append(bank).append("] DATE: ")
                .append(formattedDate).append(" | SEQ: ").append(seq).toString();
    }

    public static void main(String[] args) {
        String normalized = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(normalized));
        System.out.println(validateAndFormat("12F03022600042"));
    }
}