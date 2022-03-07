package workshop;

public class LessThanSignChecker implements HtmlPatternMatcher {
    public boolean match(char character)
    {
        return character=='<';
    }

    public String addHtmlSign(){
        return "&gt;";
    }
    
}
