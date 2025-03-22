import javax.swing.*;
import java.awt.event.*;

class Calc implements ActionListener
{
	JFrame jf;	
	JTextField tf;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
	JButton bmul, bsub, bdiv, badd, bdot, beq;

	static double a=0, b=0, result=0;
	static int operator = 0;

	JButton bdelete, bclear;
	
	Calc()
	{
		jf = new JFrame("Calculater");
		jf.setSize(290, 420);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLayout(null);
		jf.setResizable(false);

		tf = new JTextField();

		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");

		bmul = new JButton("*");
		bsub = new JButton("-");
		badd = new JButton("+");
		bdiv = new JButton("/");
		bdot = new JButton(".");
		beq = new JButton("=");

		bdelete = new JButton("Delete");
		bclear = new JButton("Clear");

		//setBounds
		tf.setBounds(20, 20, 230, 30);

		b7.setBounds(20, 70, 50, 50);
		b8.setBounds(80, 70, 50, 50);
		b9.setBounds(140, 70, 50, 50);
		bdiv.setBounds(200, 70, 50, 50);

		b4.setBounds(20, 130, 50, 50);
		b5.setBounds(80, 130, 50, 50);
		b6.setBounds(140, 130, 50, 50);
		bmul.setBounds(200, 130, 50, 50);

		b1.setBounds(20, 190, 50, 50);
		b2.setBounds(80, 190, 50, 50);
		b3.setBounds(140, 190, 50, 50);
		bsub.setBounds(200, 190, 50, 50);

		bdot.setBounds(20, 250, 50, 50);
		b0.setBounds(80, 250, 50, 50);
		beq.setBounds(140, 250, 50, 50);
		badd.setBounds(200, 250, 50, 50);

		bdelete.setBounds(40, 320, 80, 40);
		bclear.setBounds(140, 320, 80, 40);
		
		JButton[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b0};
		JButton[] ob = {bdelete, bclear, bdot, badd, bdiv, bsub, beq, bmul};


		//set action listener
		for (JButton b : buttons)
			b.addActionListener(this);
		for (JButton b : ob)
			b.addActionListener(this);

		//add to main
		jf.add(tf);
		for (JButton b : buttons)
			jf.add(b);
		for (JButton b : ob)
			jf.add(b);

		jf.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		JButton[] buttons = {b0, b1, b2, b3, b4, b5, b6, b7, b8, b9};
		for (int i = 0; i <10; i++)
			if (ae.getSource() == buttons[i])
				tf.setText(tf.getText() + i);
		
		if (ae.getSource() == bdot)
			tf.setText(tf.getText() + ".");
		if (ae.getSource() == bdelete)
			tf.setText(tf.getText().substring(0, tf.getText().length()-1));
		if (ae.getSource() == bclear)
			tf.setText("");
		if (ae.getSource() == badd)
		{
			a = Double.parseDouble(tf.getText());
			tf.setText("");
			operator = 1;
		}
		if (ae.getSource() == bsub)
		{
			a = Double.parseDouble(tf.getText());
			tf.setText("");
			operator = 2;
		}
		if (ae.getSource() == bmul)
		{
			a = Double.parseDouble(tf.getText());
			tf.setText("");
			operator = 3;
		}
		if (ae.getSource() == bdiv)
		{
			a = Double.parseDouble(tf.getText());
			tf.setText("");
			operator = 4;
		}
		if (ae.getSource() == beq)
		{
			b = Double.parseDouble(tf.getText());
			switch(operator)
			{
				case 1 : result = a+b; break;
				case 2 : result = a-b; break;
				case 3 : result = a*b; break;
				case 4 : result = a/b;
			}
			tf.setText(result+"");
		}

	}
	
	public static void main(String args[])
	{
		SwingUtilities.invokeLater(() ->
		{
			new Calc();
		});
	}
}
