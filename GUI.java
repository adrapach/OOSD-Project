import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	    JButton newGameButton = new JButton("New Game");
	    newGameButton.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent event)
	    	{
	    		openFile();
	    	}
	    });
	    
	    JButton loadGameButton = new JButton("Load Game");
	    loadGameButton.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent event)
	    	{
	    		openFile();
	    	}
	    });
	    JButton saveGameButton = new JButton("Save Game");
	    saveGameButton.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent event)
	    	{
	    		saveFile();
	    	}
	    });
	    fileButtons.add(newGameButton);
	    fileButtons.add(loadGameButton);
	    fileButtons.add(saveGameButton);
	    frame.add(fileButtons, BorderLayout.NORTH);
	    frame.pack();
	    frame.setVisible(true);

	}
	
	public void drawPuzzle()
	{

		JButton checkWordButton = new JButton("Check Word");
		checkWordButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//puzzle.checkWord([whatever clue its on]);
			}
		});
		JButton solveWordButton = new JButton("Solve Word");
		solveWordButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//puzzle.solveWord([whatever clue its on]);
			}
		});
		JButton solvePuzzleButton = new JButton("Solve Puzzle");
		solvePuzzleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//puzzle.solvePuzzle();
			}
		});
		JPanel puzzleButtons = new JPanel();
		puzzleButtons.add(checkWordButton);
		puzzleButtons.add(solveWordButton);
		puzzleButtons.add(solvePuzzleButton);
		
		//Grid g;
		//[get grid from puzzleSystem in some way]
		JPanel gridPanel = new JPanel();
		
		crosswordSpaces = new JFormattedTextField[15][15];
		for (int i = 0; i < 15; i++)
		{
			for (int j = 0; j < 15; j++)
			{
				crosswordSpaces[i][j] = new JFormattedTextField();
				//Add an observer that watches puzzle for changes
				gridPanel.add(crosswordSpaces[i][j]);
			}
		}
		
		JPanel wordCluePanel = new JPanel();
		
		for (int i = 0; i < puzzle.solutions.length(); i++)
		{
			JButton wordClueButton = new JButton(puzzle.solutions[i].desc);
			wordClueButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					//puzzle.setActiveWordClue(i);
					//I'm scared that this will access the variable i instead of the value
				}
			});
		}
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
			drawPuzzle();
		}
		
	}
	
	public void saveFile()
	{
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT Files", "txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showSaveDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			//ps.savePuzzle(chooser.getFile());
		}
	}
	
	private JFrame frame;
	private JFormattedTextField crosswordSpaces[][];
	//private PuzzleSystem ps;
}
