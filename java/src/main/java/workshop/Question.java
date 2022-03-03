/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
public abstract class Question {
    LinkedList questionLinkedList;
    public Question(){
        questionLinkedList=new LinkedList<>();
        for(int i=0;i<50;i++)
        {questionLinkedList.add(createQuestion(i));
}
    
   
}

    public String createQuestion(int index) {
            return "";
    }
    public String removeFirst()
    {
    questionLinkedList.removeFirst();
        return null;
    }
}
