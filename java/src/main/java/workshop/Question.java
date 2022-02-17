/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
public class Question {
    private final Map<String,List<String>> questions=new HashMap<>();

    public Question() {
        questions.put("Pop",new ArrayList<>());
        questions.put("Science",new ArrayList<>());
        questions.put("Sports",new ArrayList<>());
        questions.put("Rock",new ArrayList<>());
    
    
    for(int i=0;i<50;i++)
    {
        questions.get("Pop").add("Pop Question"+i);
         questions.get("Science").add("Science Question"+i);
          questions.get("Sports").add("Sports Question"+i);
           questions.get("Rock").add("Rock Question"+i);
    }
    
}
public String nextquestion(int currentplace)
{
switch(currentplace %4){
    case 0:
        return questions.get("Pop").remove(0);
        case 1:
        return questions.get("Science").remove(0);
        case 2:
        return questions.get("Sports").remove(0);
        default:
            return questions.get("Rock").remove(0);
}}}
