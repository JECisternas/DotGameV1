/*
This class print the results of the game in a new window:
Print the amount of squares claimed by every player.
Show who is the winner.
*/
package dotgameapp;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Winner  extends JFrame
{
    private String labelW;
    private String count1;
    private String count2;
    JPanel jp = new JPanel();
    JLabel jl = new JLabel();
    JLabel jlH1 = new JLabel("\\\\||||||||||||||||//");
    JLabel jlH2 = new JLabel("//||||||||||||||||\\\\");
    JTextField jf1 = new JTextField();
    JTextField jf2 = new JTextField();

    public Winner(String labelW, String count1, String count2) // Constructor
    {
        this.labelW = labelW;
        this.count1 = count1;
        this.count2 = count2;
    }
    public void theWinner()
    {    
        setTitle("**********    THE WINNER    **********");
        setSize(400,400);
        setBackground(Color.LIGHT_GRAY);
        setResizable(false);
        setLocation(700, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        jp.add(jf1);
        jf1.setBounds(250, 100, 50, 50);
        jf1.setText(count1);
        jf1.setFont(new Font("Serif",Font.PLAIN,30));
        jf1.setHorizontalAlignment(JTextField.CENTER);
        jf1.setBackground(Color.YELLOW);
        jf1.setForeground(Color.BLUE);
        jf1.setEditable(false);

        jp.add(jf2);
        jf2.setBounds(250, 200, 50, 50);
        jf2.setText(count2);
        jf2.setFont(new Font("Serif",Font.PLAIN,30));
        jf2.setHorizontalAlignment(JTextField.CENTER);
        jf2.setBackground(Color.GREEN);
        jf2.setForeground(Color.BLUE);
        jf2.setEditable(false);
        if (labelW.equalsIgnoreCase("YOU WIN ------>>"))
        {
            jp.add(jl);
            jl.setBounds(100, 110, 200, 30);
            jl.setText(labelW);
            jl.setForeground(Color.black);

            jp.add(jlH1);
            jlH1.setBounds(244,75,100,30);
            jlH1.setVisible(true);
            jp.add(jlH2);
            jlH2.setBounds(244,142,100,30);
            jlH2.setVisible(true);
        }else
        {
            jp.add(jl);
            jl.setBounds(100, 210, 200, 30);
            jl.setText(labelW);
            jl.setForeground(Color.black);    
            
            jp.add(jlH1);
            jlH1.setBounds(244,175,100,30);
            jlH1.setVisible(true);
            jp.add(jlH2);
            jlH2.setBounds(244,242,100,30);            
            jlH2.setVisible(true);            
        }
        jp.setLayout(null);
        add(jp);
    }    
}
