package ru.comp;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    private String sortString(String inputString)
    {
        char[] tempArray = inputString.toCharArray();

        Arrays.sort(tempArray);

        return new String(tempArray);
    }

    public String symbolSetEquals(List<String> stringArray) {
        Map<String, String> resultsMap = new HashMap<>();
        Map<String, Integer> countsMap = new HashMap<>();
        String tmpString = "";
        String resultString = "";

        for(int i = 0; i< stringArray.size(); i++)
        {
            tmpString = sortString(stringArray.get(i));
            if(resultsMap.containsKey(tmpString))
            {
                resultsMap.put(tmpString, resultsMap.get(tmpString) + ", " + i);
                countsMap.put(tmpString, countsMap.get(tmpString) + 1);
            }
            else
            {
                resultsMap.put(tmpString, Integer.toString(i));
                countsMap.put(tmpString, 1);
            }
        }

        // признак того, что найдена хоть одна пара
        boolean isFounded =false;

        for (Map.Entry<String, String> entry : resultsMap.entrySet()) {
            if(countsMap.get(entry.getKey()) > 1)
            {
                if(isFounded)
                {
                    resultString += " ";
                }
                resultString += MessageFormat.format("{0} = {1}", entry.getKey(), entry.getValue());
                isFounded = true;
            }
        }
        return resultString;
    }

    public static void main( String[] args )
    {
        App app = new App();
        System.out.println(app.symbolSetEquals(Arrays.asList("qwe", "wqe", "qwee", "a", "a")));
    }
}
