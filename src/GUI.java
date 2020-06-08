import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class GUI implements ActionListener, KeyListener
{	
	private CardLayout cardLayout;
	private JFrame frame = new JFrame("Game Mash");
	private JButton buttonOK = new JButton();
    private JPanel jPanel4 = new JPanel();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JScrollPane jScrollPane3 = new JScrollPane();
    private JScrollPane jScrollPane4 = new JScrollPane();
    private JTextArea jTextArea1 = new JTextArea();
    private JLabel labelEnemyHealth = new JLabel();
    private JLabel labelEnemyHealthVariable = new JLabel();
    private JLabel labelEnemyNameVariable = new JLabel();
    private JLabel labelPlayer = new JLabel();
    private JLabel labelPlayerHealth = new JLabel();
    private JLabel labelPlayerHealthVariable = new JLabel();
    private JLabel labelPlayerNameVariable = new JLabel();
    private JList<String> listEnemy = new JList<>();
    private JList<String> listMove = new JList<>();
    private JList<String> jList1 = new JList<>();
    private JPanel panelCard = new JPanel();
    private JPanel panelEnemy = new JPanel();
    private JPanel panelInfo = new JPanel();
    private JPanel panelMove = new JPanel();
    private JPanel panelText = new JPanel();
    private JPanel panelWeapons = new JPanel();
    private JPanel panelMypanel = new JPanel();
    private String playerName = "";
    protected boolean moveSelected = false;
    protected boolean weaponSelected = false;
    
    //Setters
    public void appendText(String text)
    {
    	jTextArea1.append(text);
    }

   public void setPlayerName(String s)
   {
	   playerName = s;
	   labelPlayerNameVariable.setText(playerName);
   }
   
   public void displayBattleInfo()
   {
	   labelPlayerHealth.setText("Player Health:");
	   labelPlayerHealthVariable.setText(Integer.toString(GameManager.hero.health));
	   labelEnemyNameVariable.setText(GameManager.enemy.name + " Health:");
	   labelEnemyHealthVariable.setText(Integer.toString(GameManager.enemy.health));
   }
   
   public void setlabelPlayerHealth(String s)
   {
	   labelPlayerHealth.setText(s);
   }
   
   public void setlabelEnemyHealth(String s)
   {
	   labelEnemyHealth.setText(s);
   }
   
   public void makeVisible()
   {
	   frame.setVisible(true);
   }
   
   //Show cards
   public void showWeaponsCard()
   {
	   ArrayList<Weapon> myList = GameManager.hero.heroWeapons;
	   cardLayout.show(panelCard, "panelWeapons");
	   DefaultListModel<String> defaultListModel = new DefaultListModel<>();
	   //ArrayList<Weapon> myList = GameManager.hero.heroWeapons;
	   for (int i = 0; i < myList.size(); i++) //line 94 is null...
	   {
		   int num = i + 1;
		   String myString = "";
		   myString += myList.get(i).getName();
		   defaultListModel.addElement(myString);
	   }
	   jList1.setModel(defaultListModel);
	   appendText("Select your weapon");
	   appendText("\n");
   }
   
   public void showEnemyCard()
   {
	   cardLayout.show(panelCard, "panelEnemy");
   }
   
   public void showBattleMoveCard()
   {
	   cardLayout.show(panelCard, "panelMove");
   }
   
   //Getters
   public String getPlayerName()
   {
	   return playerName;
   }
   
    public void initComponents() 
    {
	        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jTextArea1.setColumns(20);
	        jTextArea1.setRows(5);
	        jScrollPane1.setViewportView(jTextArea1);
	        jTextArea1.setEditable(false);

	        javax.swing.GroupLayout panelTextLayout = new javax.swing.GroupLayout(panelText);
	        panelText.setLayout(panelTextLayout);
	        panelTextLayout.setHorizontalGroup(
	            panelTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
	        );
	        panelTextLayout.setVerticalGroup(
	            panelTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jScrollPane1)
	        );

	        labelPlayer.setText("Player: ");
	        labelPlayer.setMinimumSize(new Dimension(10, 10));
	        labelPlayer.setPreferredSize(new Dimension(100, 15));
	        
	        GridLayout gridLayout = new GridLayout(3, 2, 10, 10);
	        panelInfo.setLayout(gridLayout);
	        panelInfo.add(labelPlayer);
	        panelInfo.add(labelPlayerNameVariable);
	        panelInfo.add(labelPlayerHealth);
	        panelInfo.add(labelPlayerHealthVariable);
	        panelInfo.add(labelEnemyNameVariable);
	        panelInfo.add(labelEnemyHealthVariable);
	        labelPlayer.setHorizontalAlignment(JLabel.RIGHT);
	        labelPlayerHealth.setHorizontalAlignment(JLabel.RIGHT);
	        labelEnemyNameVariable.setHorizontalAlignment(JLabel.RIGHT);
	        
//---------------------------------
	        panelCard.setLayout(cardLayout = new CardLayout());

	        listMove.setModel(new javax.swing.AbstractListModel<String>() {
	            String[] strings = { "Attack" };
	            public int getSize() { return strings.length; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jScrollPane2.setViewportView(listMove);

	        javax.swing.GroupLayout panelMoveLayout = new javax.swing.GroupLayout(panelMove);
	        panelMove.setLayout(panelMoveLayout);
	        panelMoveLayout.setHorizontalGroup(
	            panelMoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMoveLayout.createSequentialGroup()
	                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        panelMoveLayout.setVerticalGroup(
	            panelMoveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(panelMoveLayout.createSequentialGroup()
	                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(0, 64, Short.MAX_VALUE))
	        );

//----------CARDS ALREADY ADDED TO PANELCARD--------------------
	        panelCard.add(panelMove, "panelMove");

	        listEnemy.setModel(new javax.swing.AbstractListModel<String>() {
	            String[] strings = { "ChainBlade", "Option 2", "Option 3" };
	            public int getSize() { return strings.length; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jScrollPane3.setViewportView(listEnemy);

	        javax.swing.GroupLayout panelEnemyLayout = new javax.swing.GroupLayout(panelEnemy);
	        panelEnemy.setLayout(panelEnemyLayout);
	        panelEnemyLayout.setHorizontalGroup(
	            panelEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(panelEnemyLayout.createSequentialGroup()
	                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        panelEnemyLayout.setVerticalGroup(
	            panelEnemyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(panelEnemyLayout.createSequentialGroup()
	                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(0, 64, Short.MAX_VALUE))
	        );
	             
	        //listEnemy.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	        	
				//@Override
				//public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					//String string = listEnemy.getSelectedValue();
					//System.out.println(string);
				//}
			//});
	        
//----------CARDS ALREADY ADDED TO PANELCARD--------------------
	        panelCard.add(panelEnemy, "panelEnemy");

//----------START NEW CARD
	        jList1.setModel(new javax.swing.AbstractListModel<String>() 
	        {
	            String[] strings = {" "};
	            public int getSize() { return strings.length; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        jScrollPane4.setViewportView(jList1);

	        javax.swing.GroupLayout panelWeaponsLayout = new javax.swing.GroupLayout(panelWeapons);
	        panelWeapons.setLayout(panelWeaponsLayout);
	        panelWeaponsLayout.setHorizontalGroup(
	            panelWeaponsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(panelWeaponsLayout.createSequentialGroup()
	                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        panelWeaponsLayout.setVerticalGroup(
	            panelWeaponsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(panelWeaponsLayout.createSequentialGroup()
	                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(0, 64, Short.MAX_VALUE))
	        );

//----------CARDS ALREADY ADDED TO PANELCARD--------------------
	        panelCard.add(panelWeapons, "panelWeapons");
	        
	        //ADD THE BLANK CARD I CREATED
	        panelCard.add(panelMypanel, "panelMyPanel");
	    
	        buttonOK.setText("OK");
	        buttonOK.addActionListener(this);
	        
	        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
	        jPanel4.setLayout(jPanel4Layout);
	        jPanel4Layout.setHorizontalGroup(
	            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel4Layout.createSequentialGroup()
	                .addGap(34, 34, 34)
	                .addComponent(buttonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        jPanel4Layout.setVerticalGroup(
	            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(buttonOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
	        frame.getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(panelText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addContainerGap())
	                    .addComponent(panelCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(panelText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	            .addGroup(layout.createSequentialGroup()
	                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(panelCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );

	        frame.pack();
	        
	        //Show the blank panel right away
	        cardLayout.show(panelCard, "panelMyPanel");
	        //cardLayout.show(panelCard, "panelWeapons");
	        //cardLayout.show(panelCard, "panelEnemy");
	        
	        //Need to have both to function properly
	        jTextArea1.setLineWrap(true); //Wraps the lines in jTextArea1
	        jTextArea1.setWrapStyleWord(true); //Wraps at the words (whitespace) in jTextArea1
	     
	        
	    }


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//If the button is clicked and the Enemy card is showing 
		//then we are selecting an enemy to battle
		if (e.getSource().equals(buttonOK)&& panelEnemy.isVisible())
		{
			//Get the selected enemy
			String string = listEnemy.getSelectedValue();
			
			//If the selected enemy is chainblade
			if (string.equals("ChainBlade")) 
			{
				GameManager gameManager = new GameManager();
				gameManager.setChainBladeBattle(true);
				//Thread t1 = new Thread(gameManager);
				//t1.start();
				
				cardLayout.show(panelCard, "panelMove");
				appendText("You are battling ChainBlade");
				appendText("\n");
				appendText("Select your move");
				appendText("\n");
			}//end nested if
		}
			
		//The button was clicked and the Move Card is showing
		//then we are selecting a move (Attack)
		else if (e.getSource().equals(buttonOK) && panelMove.isVisible())
		{	
			//Get the selected value
			String string = listMove.getSelectedValue();
			//System.out.println(string);
				
			if (string.equals("Attack"))
			{
				moveSelected = true;
				appendText("You chose to attack");
				appendText("\n");
			}
		}
		
		//The button was clicked and the Weapons Card is showing
		//then we are selecting a weapon
		else if (e.getSource().equals(buttonOK) && panelWeapons.isVisible())
		{
			ArrayList<Weapon> myList = GameManager.hero.heroWeapons;
			String string = jList1.getSelectedValue();
			
			if (string.equals("Sniper"))
			{
				GameManager.hero.weapon = myList.get(0);
				appendText("Weapon selected: Sniper");
				appendText("\n");
			}
			
			else if (string.equals("Pistol"))
			{
				GameManager.hero.weapon = myList.get(1);
				appendText("Weapon selected: Pistol");
				appendText("\n");
			}
			
			else if (string.equals("Melee"))
			{
				GameManager.hero.weapon = myList.get(2);
				appendText("Weapon selected: Melee");
				appendText("\n");
			}
			
			weaponSelected = true;
		}
		
		
	}//end actionPerformed
	
	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			playerName = jTextArea1.getText();
			System.out.println(playerName);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}//end class
