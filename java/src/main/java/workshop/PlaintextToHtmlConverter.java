package workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {
  
    public String toHtml() throws Exception {
        String text = read();
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }

    private String read() throws IOException {
    	Path filePath = Paths.get("sample.txt");
    	byte[] fileByteArray = Files.readAllBytes(filePath);
        return new String(fileByteArray);
    }

    private String basicHtmlEncode(String source) {
        
       
        List<String> result = new ArrayList<>();
        List<String> convertedLine = new ArrayList<>();
        
        for (int i=0;i<source.length();i++) {
            switch (source.charAt(i)) {
                case '<':
                    convertedLine.add("&lt;");
                    break;
              case '>':
                    convertedLine.add("&gt;");
                    break;
                case '&':
                    convertedLine.add("&amp;");
                    break;
                case '\n':
                    addANewLine(result,convertedLine);
                    break;
                default:
            {
                String characterToConvert = null;
                pushACharacterToTheOutput(convertedLine,characterToConvert);
            }
            }
        }
        addANewLine(result,convertedLine);
        String finalResult = String.join("<br />", result);
        return finalResult;
    }

   
    //stringfy convertedLine array and push into result
    //reset convertedLine
    private void addANewLine(List<String> result,List<String> convertedLine) {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine = new ArrayList<>();
    }

    private void pushACharacterToTheOutput(List<String> convertedLine,String characterToConvert) {
        convertedLine.add(characterToConvert);
    }
}
