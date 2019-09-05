import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Editor extends JFrame implements ActionListener {

    JFrame frame;
    JPanel panel;
    RSyntaxTextArea ta;

    Editor(){

        frame = new JFrame("Text editor by Sergiovmdo");
        panel = new JPanel(new BorderLayout());
        frame.add(panel);

        ta = new RSyntaxTextArea(20,60);

        //We initiate the editor in java mode
        ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
        ta.setCodeFoldingEnabled(true);

        //This line is to disable the highlight, you can enable it by putting the color you want but white
        ta.setCurrentLineHighlightColor(Color.white);
        panel.add(ta);
        RTextScrollPane sp = new RTextScrollPane(ta);
        panel.add(sp);

        JMenuBar menuBar = new JMenuBar();

        //All the menus that will have the menuBar
        JMenu menu = new JMenu("File");
        JMenu menu2 = new JMenu("Languages");
        JMenu menu3 = new JMenu("Dark Mode");
        JMenu menu4 = new JMenu("Edit");

        //File Menu
        JMenuItem item1 = new JMenuItem("New");
        JMenuItem item2 = new JMenuItem("Open");
        JMenuItem item3 = new JMenuItem("Save");
        JMenuItem item4 = new JMenuItem("Close");
        JMenuItem item5 = new JMenuItem("New Window");

        //Languages menu
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

        //This is for darkMode which is not perfect it was only a test
        JMenuItem darkMode = new JMenuItem("Dark Mode");

        //Edit Menu
        JMenuItem edit1 = new JMenuItem("Cut");
        JMenuItem edit2 = new JMenuItem("Copy");
        JMenuItem edit3 = new JMenuItem("Paste");
        JMenuItem edit4 = new JMenuItem("Undo");
        JMenuItem edit5 = new JMenuItem("Redo");

        //Every menu has her own ActionListener in order to have it well organized
        item1.addActionListener(file);
        item2.addActionListener(file);
        item3.addActionListener(file);
        item4.addActionListener(file);
        item5.addActionListener(file);

        lang1.addActionListener(languages);
        lang2.addActionListener(languages);
        lang3.addActionListener(languages);
        lang4.addActionListener(languages);
        lang5.addActionListener(languages);
        lang6.addActionListener(languages);
        lang7.addActionListener(languages);
        lang8.addActionListener(languages);
        lang9.addActionListener(languages);
        lang10.addActionListener(languages);
        lang11.addActionListener(languages);
        lang12.addActionListener(languages);
        lang13.addActionListener(languages);

        darkMode.addActionListener(languages);

        edit1.addActionListener(edit);
        edit2.addActionListener(edit);
        edit3.addActionListener(edit);
        edit4.addActionListener(edit);
        edit5.addActionListener(edit);

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

        menu4.add(edit1);
        menu4.add(edit2);
        menu4.add(edit3);
        menu4.add(edit4);
        menu4.add(edit5);

        menuBar.add(menu);
        menuBar.add(menu4);
        menuBar.add(menu2);
        menuBar.add(menu3);
        frame.setJMenuBar(menuBar);

        //I set this without any criterion, you can set it as you want
        frame.setSize(1000,1000);
        frame.setVisible(true);

    }

    private ActionListener file = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "New":
                    ta.setText("");
                    break;
                case "Open": {
                    JFileChooser fileChooser = new JFileChooser("frame");
                    int selection = fileChooser.showOpenDialog(null);

                    if (selection == JFileChooser.APPROVE_OPTION) {
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
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(frame, ex.getMessage());
                        }
                    }
                    break;
                }
                case "Save": {
                    JFileChooser fileChooser = new JFileChooser("frame:");
                    int selection = fileChooser.showSaveDialog(null);

                    if (selection == JFileChooser.APPROVE_OPTION) {
                        File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                        try {
                            FileWriter fw = new FileWriter(file, false);
                            BufferedWriter bw = new BufferedWriter(fw);

                            bw.write(ta.getText());
                            bw.flush();
                            bw.close();
                        } catch (Exception exc) {
                            JOptionPane.showMessageDialog(frame, exc.getMessage());
                        }
                    } else JOptionPane.showMessageDialog(frame, "Cancelled by the user");
                    break;
                }
                case "Close":
                    frame.setVisible(false);
                    break;
                case "New Window":
                    Editor e2 = new Editor();

                    break;
            }
        }
    };

    ActionListener languages = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "Java":
                    ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
                    break;
                case "JavaScript":
                    ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);
                    break;
                case "C++":
                    ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);
                    break;
                case "SQL":
                    ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_SQL);
                    break;
                case "C":
                    ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C);
                    break;
                case "x86":
                    ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_ASSEMBLER_X86);
                    break;
                case "C#":
                    ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CSHARP);
                    break;
                case "HTML":
                    ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_HTML);
                    break;
                case "JSON":
                    ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JSON);
                    break;
                case "LUA":
                    ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_LUA);
                    break;
                case "PHP":
                    ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PHP);
                    break;
                case "PYTHON":
                    ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
                    break;
                case "XML":
                    ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_XML);
                    break;
                case "Dark Mode":
                    ta.setBackground(Color.black);
                    ta.setForeground(Color.white);
                    ta.setCurrentLineHighlightColor(Color.black);
                    break;
            }
        }
    };

    ActionListener edit = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command){
                case "Cut":
                    ta.cut();
                case "Copy":
                    ta.copy();
                case "Paste":
                    ta.paste();
                case "Undo":
                    ta.undoLastAction();
                case "Redo":
                    ta.redoLastAction();
            }
        }
    };

    public void actionPerformed(ActionEvent evt){

    }

    public static void main(String arg[]){
        Editor e = new Editor();

    }
}
