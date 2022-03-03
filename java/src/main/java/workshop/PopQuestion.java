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
public class PopQuestion extends Question{

    public PopQuestion() {
        super();
    }
    public String createQuestion(int index)
    {
    return "Pop question "+ index;
    }
}
