/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop;

/**
 *
 * @author user
 */
public class RockQuestion extends Question{
     public RockQuestion() {
        super();
    }
    public String createQuestion(int index)
    {
    return "Rock question "+ index;
    }
}
