package org.example.designPattern.decorator;

/**
 * @content 装饰器
 *
 * @param null
 * @return {@link null}
 * @author    @date                 @description<br>
 * 康晓平      20240321 10:09:12     <br>
 *
 */
public class MainTest {
	public static void main (String[] args) {
		TextNode n1 = new SpanNode();
		TextNode n2 = new BoldDecorator(new SpanNode());
//		TextNode n3 = new ItalicDecorator(new BoldDecorator(new SpanNode()));
		n1.setText("Hello");
		
		n2.setText("Decorated");
//		n3.setText("World");
		System.out.println(n1.getText());
// 输出<span>Hello</span>
		
		System.out.println(n2.getText());
// 输出<b><u><span>Decorated</span></u></b>
		
//		System.out.println(n3.getText());
// 输出<i><b><span>World</span></b></i>
	}
}