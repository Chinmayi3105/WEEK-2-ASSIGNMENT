public class WordReversalEncoder {
    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(new StringBuilder(word).reverse()).append(" ");
        }
        return result.toString().trim();
    }
    public static void main(String[] args) { System.out.println(reverseEachWord("hello club")); }
}