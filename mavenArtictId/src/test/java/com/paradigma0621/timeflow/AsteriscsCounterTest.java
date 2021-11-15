package com.paradigma0621.timeflow;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.paradigma0621.timeflow.model.Paragraph;

//import org.junit.Test;

/*import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
*/
/**
 * Unit test for simple App.
 */
public class AsteriscsCounterTest
{
    @Test
    public void howManyAsteriscs2()
    {
    	String text1 = "aaaa";
    	Paragraph p1 = new Paragraph(text1);
    	System.out.println("Text: " + text1 + " - the depth: " + String.valueOf(p1.getNumberAsterisksParagraphBegins()));
    	assertTrue(p1.getNumberAsterisksParagraphBegins() == 0);
    	
    	String text2 = "* aaaa";
    	Paragraph p2 = new Paragraph(text2);
    	System.out.println("Text: " + text2 + " - the depth: " + String.valueOf(p2.getNumberAsterisksParagraphBegins()));
    	assertTrue(p2.getNumberAsterisksParagraphBegins() == 1);
    	
    	String text3 = "** aaaa";
    	Paragraph p3 = new Paragraph(text3);
    	System.out.println("Text: " + text3 + " - the depth: " + String.valueOf(p3.getNumberAsterisksParagraphBegins()));
    	assertTrue(p3.getNumberAsterisksParagraphBegins() == 2);

    	String text4 = "***";
    	Paragraph p4 = new Paragraph(text4);
    	System.out.println("Text: " + text4 + " - the depth: " + String.valueOf(p4.getNumberAsterisksParagraphBegins()));
    	assertTrue(p4.getNumberAsterisksParagraphBegins() == 3);
    	
    	String text5 = "****a";
    	Paragraph p5 = new Paragraph(text5);
    	System.out.println("Text: " + text5 + " - the depth: " + String.valueOf(p5.getNumberAsterisksParagraphBegins()));
    	assertTrue(p5.getNumberAsterisksParagraphBegins() == 0);
    	
    	String text6 = "************** tem que ter 14";
    	Paragraph p6 = new Paragraph(text6);
    	System.out.println("Text: " + text6 + " - the depth: " + String.valueOf(p6.getNumberAsterisksParagraphBegins()));
    	assertTrue(p6.getNumberAsterisksParagraphBegins() == 14);
    	
    	String text7 = "*****b**";
    	Paragraph p7 = new Paragraph(text7);
    	System.out.println("Text: " + text7 + " - the depth: " + String.valueOf(p7.getNumberAsterisksParagraphBegins()));
    	assertTrue(p7.getNumberAsterisksParagraphBegins() == 0);
    	
    	String text8 = "*****b** text";
    	Paragraph p8 = new Paragraph(text8);
    	System.out.println("Text: " + text8 + " - the depth: " + String.valueOf(p8.getNumberAsterisksParagraphBegins()));
    	assertTrue(p8.getNumberAsterisksParagraphBegins() == 0);
    	
    	String text9 = "*** ****** text";
    	Paragraph p9 = new Paragraph(text9);
    	System.out.println("Text: " + text9 + " - the depth: " + String.valueOf(p9.getNumberAsterisksParagraphBegins()));
    	assertTrue(p9.getNumberAsterisksParagraphBegins() == 3);
    }
}
