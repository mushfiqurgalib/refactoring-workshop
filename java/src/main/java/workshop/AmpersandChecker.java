package workshop;

public class AmpersandChecker implements HtmlPatternMatcher {
    public boolean match(char character)
    {
        return character=='&';
    }

    public String addHtmlSign(){
        return "&amp;";
    }
    
}
