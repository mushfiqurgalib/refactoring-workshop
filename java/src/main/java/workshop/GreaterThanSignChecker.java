package workshop;

public class GreaterThanSignChecker implements HtmlPatternMatcher {
    public boolean match(char character)
    {
        return character=='>';
    }

    public String addHtmlSign(){
        return "&lt;";
    }
    
}
