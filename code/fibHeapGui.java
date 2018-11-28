import javax.swing.*;

public class fibHeapGUI
{
	private static void createAndShowGUI()
	{
		JFrame frame=new JFrame("Fibonacci Heap");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Fibonacci Heap");
		frame.getContentPane().add(label);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
				createAndShowGUI();
			}
		});
	}
}
