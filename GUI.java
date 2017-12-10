import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI {

	public GUI() 
	{
		frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //ps = new PuzzleSystem();
	}
	
	public void drawMenus()
	{

	    JPanel fileButtons = new JPanel();
	    JButton newGame = new JButton("New Game");
	    newGame.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent event)
	    	{
	    		openFile();
	    	}
	    });
	    
	    JButton loadGame = new JButton("Load Game");
	    JButton saveGame = new JButton("Save Game");
	    fileButtons.add(newGame);
	    fileButtons.add(loadGame);
	    fileButtons.add(saveGame);
	    frame.add(fileButtons, BorderLayout.NORTH);
	    frame.pack();
	    frame.setVisible(true);

	}
	
	public void drawPuzzle()
	{
		
	}
	
	public void openFile()
	{
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT Files", "txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			//ps.loadPuzzle(chooser.getFile());
		}
		
	}
	
	private JFrame frame;
	//private PuzzleSystem ps;
}
