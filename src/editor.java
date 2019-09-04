import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class editor extends JFrame implements ActionListener {

    JFrame frame;
    JPanel panel;
    //JTextArea ta;
    RSyntaxTextArea ta;
    editor(){

        frame = new JFrame("Text editor by Sergiovmdo");
        panel = new JPanel(new BorderLayout());
        frame.add(panel);

        //ta = new JTextArea();
        ta = new RSyntaxTextArea(20,60);

        ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        ta.setCodeFoldingEnabled(true);
        ta.setCurrentLineHighlightColor(Color.white);
        panel.add(ta);
        RTextScrollPane sp = new RTextScrollPane(ta);
        panel.add(sp);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenu menu2 = new JMenu("Languages");
        JMenu menu3 = new JMenu("Dark Mode");

        JMenuItem item1 = new JMenuItem("New");
        JMenuItem item2 = new JMenuItem("Open");
        JMenuItem item3 = new JMenuItem("Save");
        JMenuItem item4 = new JMenuItem("Close");
        JMenuItem item5 = new JMenuItem("New Window");

        JMenuItem lang1 = new JMenuItem("Java");
        JMenuItem lang2 = new JMenuItem("JavaScript");
        JMenuItem lang3 = new JMenuItem("C++");
        JMenuItem lang4 = new JMenuItem("SQL");
        JMenuItem lang5 = new JMenuItem("C");
        JMenuItem lang6 = new JMenuItem("x86");
        JMenuItem lang7 = new JMenuItem("JSON");
        JMenuItem lang8 = new JMenuItem("XML");
        JMenuItem lang9 = new JMenuItem("HTML");
        JMenuItem lang10 = new JMenuItem("PYTHON");
        JMenuItem lang11 = new JMenuItem("LUA");
        JMenuItem lang12 = new JMenuItem("C#");
        JMenuItem lang13 = new JMenuItem("PHP");

        JMenuItem darkMode = new JMenuItem("Dark Mode");


        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
        item5.addActionListener(this);

        lang1.addActionListener(this);
        lang2.addActionListener(this);
        lang3.addActionListener(this);
        lang4.addActionListener(this);
        lang5.addActionListener(this);
        lang6.addActionListener(this);
        lang7.addActionListener(this);
        lang8.addActionListener(this);
        lang9.addActionListener(this);
        lang10.addActionListener(this);
        lang11.addActionListener(this);
        lang12.addActionListener(this);
        lang13.addActionListener(this);

        darkMode.addActionListener(this);

        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);
        menu.add(item5);

        menu2.add(lang1);
        menu2.add(lang2);
        menu2.add(lang3);
        menu2.add(lang4);
        menu2.add(lang5);
        menu2.add(lang6);
        menu2.add(lang7);
        menu2.add(lang8);
        menu2.add(lang9);
        menu2.add(lang10);
        menu2.add(lang11);
        menu2.add(lang12);
        menu2.add(lang13);

        menu3.add(darkMode);

        menuBar.add(menu);
        menuBar.add(menu2);
        menuBar.add(menu3);
        frame.setJMenuBar(menuBar);

        frame.setSize(1000,1000);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();

        if (command.equals("New")) ta.setText("");
        else if (command.equals("Open")){
            JFileChooser fileChooser = new JFileChooser("frame");
            int selection = fileChooser.showOpenDialog(null);

            if (selection == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                try {
                    FileReader frame = new FileReader(file);
                    BufferedReader br = new BufferedReader(frame);

                    String s1 = "";

                    s1 = br.readLine();
                    String s2 = "";
                    while ((s2 = br.readLine()) != null) {
                        s1 += "\n" + s2;
                    }
                    ta.setText(s1);
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(frame,ex.getMessage());
                }
            }
        }

        else if (command.equals("Save")){
            JFileChooser fileChooser = new JFileChooser("frame:");
            int selection = fileChooser.showSaveDialog(null);

            if (selection == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                try{
                    FileWriter fw = new FileWriter(file,false);
                    BufferedWriter bw = new BufferedWriter(fw);

                    bw.write(ta.getText());
                    bw.flush();
                    bw.close();
                }
                catch (Exception exc){
                    JOptionPane.showMessageDialog(frame,exc.getMessage());
                }
            }
            else JOptionPane.showMessageDialog(frame, "Cancelled by the user");
        }
        else if (command.equals("Close")) frame.setVisible(false);

        else if(command.equals("New Window")){
            editor e2 = new editor();

        }

        else if(command.equals("Java")) ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        else if(command.equals("JavaScript")) ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);
        else if(command.equals("C++")) ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);
        else if(command.equals("SQL")) ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_SQL);
        else if(command.equals("C")) ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C);
        else if(command.equals("x86")) ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_ASSEMBLER_X86);
        else if(command.equals("C#")) ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CSHARP);
        else if(command.equals("HTML")) ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_HTML);
        else if(command.equals("JSON")) ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JSON);
        else if(command.equals("LUA")) ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_LUA);
        else if(command.equals("PHP")) ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PHP);
        else if(command.equals("PYTHON")) ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
        else if(command.equals("XML")) ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_XML);

        else if(command.equals("Dark Mode")) {
            ta.setBackground(Color.black);
            ta.setForeground(Color.white);
            ta.setCurrentLineHighlightColor(Color.black);
        }



    }

    public static void main(String arg[]){
        editor e = new editor();

    }
}
