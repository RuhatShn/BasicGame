package com.test.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.test.view.intf.AppListener;

public class App extends JFrame  {
	
    private int x=32;
	
	private int y=32;
	
	private JPanel[][] panelArr=new JPanel[x][y];
	
	private JButton[][] buttonArr=new JButton[x][y];
	
	private JLabel[][] labelArr=new JLabel[x][y];

    
	private GridBagConstraints gbc=new GridBagConstraints();
	
	private static List<AppListener> listeners=Collections.synchronizedList(new ArrayList<AppListener>());
	
	

	public void addListener(AppListener listener)
	{
		listeners.add(listener);
	}
	
	public void initChooseRowAndColumn()
	{
		JFrame choosingFrame=new JFrame();
		JPanel rowPanel=new JPanel();
		JPanel columnPanel=new JPanel();
		JPanel buttonPanel=new JPanel();
		JLabel rowLabel=new JLabel();
		JLabel columnLabel=new JLabel();
		JTextField rowTxtField=new JTextField();
		JTextField columnTxtField=new JTextField();
		JButton okBtn=new JButton();
		
		GridBagConstraints gbc=new GridBagConstraints();
		
		choosingFrame.setLayout(new GridBagLayout());
		
		
		//init row panel,label and text area
		rowPanel.setLayout(new GridBagLayout());
		gbc.gridx=0;
		gbc.gridy=0;
		choosingFrame.add(rowPanel, gbc);
		
		rowLabel.setText("Row: ");
		gbc.gridx=0;
		gbc.gridy=0;
		rowPanel.add(rowLabel, gbc);
		
		rowTxtField.setPreferredSize(new Dimension(80, 20));
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.insets=new Insets(0, 22, 0, 0);
		rowPanel.add(rowTxtField, gbc);
		
		//init column panel,label and text area
		columnLabel.setLayout(new GridBagLayout());
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.insets=new Insets(0, 0, 0, 0);
		choosingFrame.add(columnPanel, gbc);
		
		columnLabel.setText("Column: ");
		gbc.gridx=0;
		gbc.gridy=0;
		columnPanel.add(columnLabel, gbc);
		
		columnTxtField.setPreferredSize(new Dimension(80, 20));
		gbc.gridx=1;
		gbc.gridy=0;
		columnPanel.add(columnTxtField, gbc);
		
		//init okBtn panel and button
		buttonPanel.setLayout(new GridBagLayout());
		gbc.gridx=0;
		gbc.gridy=2;
		choosingFrame.add(buttonPanel, gbc);
		
		okBtn.setText("OK");
		gbc.gridx=0;
		gbc.gridy=0;
		buttonPanel.add(okBtn, gbc);
		
		choosingFrame.pack();
		choosingFrame.setLocationRelativeTo(null);
		choosingFrame.setVisible(true);
		choosingFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				x=Integer.parseInt(rowTxtField.getText());
				
				y=Integer.parseInt(columnTxtField.getText());
				
				choosingFrame.setVisible(false);
						
				open();		
			}
		});
		
	}
	
	public void open()
	{
		initFrame();
	}
	
	private void initFrame()
	{
		setPreferredSize(new Dimension(400, 400));
		setLayout(new GridBagLayout());
		
		initPanel();
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initPanel()
	{

		
		
		for(int i=0;i<x;i++)
		{
			for(int j=0;j<y;j++)
			{
			
				JPanel panel=new JPanel();
				
				panelArr[i][j]=panel;
				
				panelArr[i][j].setLayout(new GridBagLayout());
				
				gbc.gridx=i;
				gbc.gridy=j;
				gbc.weightx=0.5;
				gbc.weighty=0.5;
				gbc.fill=GridBagConstraints.BOTH;
				
				
				add(panelArr[i][j], gbc);
				
				initButton(i,j);
				initLabel(i,j);
			}
		}
	}
	
	private void initButton(int i,int j)
	{
		JButton button=new JButton();
		
		buttonArr[i][j]=button;
		buttonArr[i][j].setBackground(new Color(47, 47, 47));
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.fill=GridBagConstraints.BOTH;
		
        panelArr[i][j].add(buttonArr[i][j], gbc);
		
		
		buttonArr[i][j].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonArr[i][j].setVisible(false);
				
				System.out.println("i: "+i+" j: "+j);
			}
		});
		
	}
	
	private void initLabel(int i,int j)
	{
		//test "FOR" statement
		
		JLabel label=new JLabel();
		
		labelArr[i][j]=label;
		labelArr[i][j].setText(Integer.toString(i));
		labelArr[i][j].setHorizontalAlignment(SwingConstants.CENTER);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.fill=GridBagConstraints.BOTH;
		
		panelArr[i][j].add(labelArr[i][j], gbc);
	}

	
	
}
