import java.util.*;


/**
 * Created by icons on 7.3.17.
 */
public class Text {
    public static void main(String[] args) {
        //can you can a can as a canner can can a can

        String text = "can you can a can as a canner can can a can";

        HashMap<String, Integer> hashMap = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(text);

        while (tokenizer.hasMoreTokens()) {

            String token = tokenizer.nextToken();
            Integer value = hashMap.get(token);

            if (value != null)
                hashMap.put(token, value + 1);
            else
                hashMap.put(token, 1);
        }

        System.out.println("кол-во различных слов " + hashMap.size());
        for (Map.Entry<String, Integer> entry : hashMap.entrySet())
            System.out.println("слово " + entry.getKey() + " встречается " + entry.getValue() + " раз");
    }
}
