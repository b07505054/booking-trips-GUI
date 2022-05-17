import java.util.ArrayList;
import java.util.List;

public class SentenceProcessor {

    public String removeDuplicatedWords(String sentence) {

        String[] words = sentence.split(" ");  // splits sentence into words with " "
        String processedSentence = "";
        List<String> tempWords = new ArrayList<>();  // list used to save not duplicated words

        for (int i = 0; i < words.length; i++) {

            if (!tempWords.contains(words[i])) {
                tempWords.add(words[i]);
            }
        }

        for (int i = 0; i < tempWords.size(); i++) {
            if (i == 0) {
                processedSentence += tempWords.get(i);
            } else {  // if not first word, add a " "
                processedSentence += " " + tempWords.get(i);
            }
        }

        return processedSentence;
    }

    public String replaceWord(String target, String replacement, String sentence) {

        String[] words = sentence.split(" ");
        String processedSentence = "";

        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                if (!words[i].equals(target)) {
                    processedSentence += words[i];
                } else {
                    processedSentence += replacement;
                }
            } else {  // if not first word, add a " "
                if (!words[i].equals(target)) {
                    processedSentence += " " + words[i];
                } else {
                    processedSentence += " " + replacement;
                }
            }
        }

        return processedSentence;
    }
}
