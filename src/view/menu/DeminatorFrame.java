package view.menu;

import util.Controller;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by Nathaël N on 02/05/16.
 */
public class DeminatorFrame extends JFrame {
	private final Controller control;
	private JPanel jpContent;
	private JSPPlayersList jpRight;

	public DeminatorFrame(Controller control) {
		super("Deminator !!");
		this.control = control;

		// CONTENT
		JPanel jpMain = new JPanel();
		jpMain.setLayout(new BorderLayout());

		JScrollPane jpCenter = new JScrollPane();
		jpCenter.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jpCenter.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		jpMain.add(jpCenter, BorderLayout.CENTER);

		JPanel jpp = new JPanel();
		jpp.setBackground(Color.GRAY);
		jpContent = new JPanel();
		jpContent.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		jpp.add(jpContent);
		jpCenter.setViewportView(jpp);

		jpRight = new JSPPlayersList();
		jpMain.add(jpRight, BorderLayout.EAST);

		// This frame
		setContentPane(jpMain);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
		addWindowListener(new WindowListener() {
			@Override
			public void windowClosing(WindowEvent e) {
				int n = JOptionPane.showConfirmDialog(
						DeminatorFrame.this,
						"Do you really want to close the server?",
						"Close?",
						JOptionPane.YES_NO_OPTION);
				if(n == JOptionPane.YES_OPTION){
					Object[] options = {"OSEF",
							"YOLO"};
					n = JOptionPane.showOptionDialog(DeminatorFrame.this,
							"Nooo!!Don't do that otherwise this is what will happen: The time and space will break.",
							"Don't do that!",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null, options, options[0]);
					//TODO
				}
			}

			@Override public void windowOpened(WindowEvent e) {}
			@Override public void windowClosed(WindowEvent e) {}
			@Override public void windowIconified(WindowEvent e) {}
			@Override public void windowDeiconified(WindowEvent e) {}
			@Override public void windowActivated(WindowEvent e) {}
			@Override public void windowDeactivated(WindowEvent e) {}
		});
	}

	public void setView(JComponent jc) {
		jpContent.removeAll();
		jpContent.add(jc);
		jc.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		this.validate();
		this.repaint();
	}

	public void putPlayerToList(String playerName, Color playerColor) {
		jpRight.putPlayerToList(playerName, playerColor);
	}
	public void removePlayerFromList(String playerName) {
		jpRight.removePlayerFromList(playerName);
	}
}