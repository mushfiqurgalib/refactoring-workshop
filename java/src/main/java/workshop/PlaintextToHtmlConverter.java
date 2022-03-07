package workshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {
   List <HtmlPatternMatcher> htmlPatternMatchers;

    public PlaintextToHtmlConverter(List<HtmlPatternMatcher> htmlPatternMatchers) {
            this.htmlPatternMatchers=htmlPatternMatchers;
    }

    public String toHtml() throws Exception{
        return basicHtmlEncode(read());
    }
    protected String read() throws IOException {
        Path filePath = Paths.get("sample.txt");
        byte[] fileByteArray = Files.readAllBytes(filePath);
        return new String(fileByteArray);
    }

    private String basicHtmlEncode(String source) {
        List<String> result = new ArrayList<>();
        List<String> convertedLine = new ArrayList<>();
        for (char characterToConvert : source.toCharArray()) {
            for(HtmlPatternMatcher hMatcher:htmlPatternMatchers){
                if (hMatcher.match(characterToConvert)){
                    convertedLine.add(hMatcher.addHtmlSign());
                }
                else if(characterToConvert=='\n')
                {
                    addANewLine(result,convertedLine);
                }
                else{
                    convertedLine.add(String.valueOf(characterToConvert));
                }
            }
            }
        
        addANewLine(result,convertedLine);
        return String.join("<br />", result);
    }


    //stringfy convertedLine array and push into result
    //reset convertedLine
    private void addANewLine(List<String> result,List<String> convertedLine) {
        String line = String.join("", convertedLine);
        result.add(line);
    }

  
}