package example.numbers.boundary;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import example.numbers.controller.MoveTileController;
import example.numbers.controller.ResetController;
import example.numbers.controller.SelectTileController;
import example.numbers.controller.StatusController;
import example.numbers.model.Model;
import example.numbers.model.MoveType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JComboBox;

public class NumberPuzzleApp extends JFrame {

	private JPanel contentPane;
	
	PuzzlePanel panel;
	StatusPanel statPanel;
	
	Model model;
	JButton upButton, downButton, rightButton, leftButton, resetButton;
	JLabel actualNumMoves;
	
	public PuzzlePanel getPuzzlePanel() {return panel;}
	public JButton getUpButton() { return upButton;}
	public JButton getDownButton() { return downButton;}
	public JButton getRightButton() { return rightButton;}
	public JButton getLeftButton() { return leftButton;}
	public JLabel getActualNumMovesLabel () {return actualNumMoves;}

	public NumberPuzzleApp(Model m) {
		super();
		this.model = m;
		setTitle("Numbers Puzzle Application");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 660, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		statPanel = new StatusPanel(model);
		panel = new PuzzlePanel(model);
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				new SelectTileController(model, NumberPuzzleApp.this).process(me.getPoint());
			}
		});
	
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		
		
		
		JLabel numMovesLabel = new JLabel("Moves");
		
		actualNumMoves = new JLabel("" + model.getNumMoves());
		
		resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetController(model, NumberPuzzleApp.this).reset();
			}
		});
		
		upButton = new JButton("\u2191");
		upButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		upButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, NumberPuzzleApp.this).move(MoveType.Up);
				new StatusController(model, NumberPuzzleApp.this).check();
			}
		});
				
		downButton = new JButton("\u2193");
		downButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		downButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, NumberPuzzleApp.this).move(MoveType.Down);
				new StatusController(model, NumberPuzzleApp.this).check();
			}
		});
		
		rightButton = new JButton("\u2192");
		rightButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		rightButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, NumberPuzzleApp.this).move(MoveType.Right);
				new StatusController(model, NumberPuzzleApp.this).check();
			}
		});
		
		leftButton = new JButton("\u2190");
		leftButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		leftButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new MoveTileController(model, NumberPuzzleApp.this).move(MoveType.Left);
				new StatusController(model, NumberPuzzleApp.this).check();
			}
		});
		
		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(numMovesLabel)
												.addComponent(actualNumMoves))
											.addPreferredGap(ComponentPlacement.RELATED, 213, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(27)
											.addComponent(leftButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
											.addComponent(rightButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
											.addGap(26)))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(upButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
										.addGap(97)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(downButton, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addGap(97)))
							.addGap(0))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(73))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(resetButton)
					.addContainerGap(573, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(resetButton)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(statPanel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(upButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rightButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(leftButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(downButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(106)
							.addComponent(numMovesLabel)
							.addGap(18)
							.addComponent(actualNumMoves))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)))
		);
		
		contentPane.setLayout(gl_contentPane);
		UpdateButtons.enableButtons(this, new ArrayList<MoveType>());
	}
}
