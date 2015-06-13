import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font.*;
/**
 * Write a description of class textEditor here.
 * 
 * @author (tharuni) 
 * @version (v1.0)
 */
public class textEditor
{
    
    private JFrame myFrame = new JFrame();
    private Container contentPane = myFrame.getContentPane();
    private JPanel northPanel = new JPanel();
    private JPanel westPanel = new JPanel();
    private JPanel eastPanel = new JPanel();
    private JTextArea text = new JTextArea();        
    private JButton clearButton = new JButton("Clear");
    private JScrollPane scroll = new JScrollPane(text);
    private Font f;
    public textEditor()
    {
        makeMenuBar();
        contentPane.setLayout(new FlowLayout());                 
        makeFrame();
        myFrame.getContentPane().setPreferredSize(new Dimension(500, 500));
        myFrame.pack();
        myFrame.setVisible(true);
        f= new Font("Helvetica",Font.PLAIN, 12);

    }

    /**
     * Create the main frame's menu bar.
     */
    private void makeMenuBar()
    {

        JMenuBar menubar = new JMenuBar();
        myFrame.setJMenuBar(menubar);  
        // creating the File menu
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);
        //Open menu object to open file
        JMenuItem open = new JMenuItem("Open");
        fileMenu.add(open);        
        open.addActionListener(new OpenHandler());
        //save file
        JMenuItem save = new JMenuItem("Save");
        fileMenu.add(save);
        save.addActionListener(new SaveHandler());
        //exit application 
        JMenuItem exit = new JMenuItem("Exit");
        fileMenu.add(exit);
        exit.addActionListener(new QuitHandler());
        //make new menu edit
        JMenu editMenu = new JMenu("Edit");
        menubar.add(editMenu);
        JMenuItem cut = new JMenuItem("Cut");
        editMenu.add(cut);
        cut.addActionListener(new CutHandler());
        JMenuItem copy = new JMenuItem("Copy");
        editMenu.add(copy);
        copy.addActionListener(new CopyHandler());
        JMenuItem paste = new JMenuItem("Paste");
        editMenu.add(paste);
        paste.addActionListener(new PasteHandler());
        //make menu format
        JMenu formatMenu = new JMenu("Format");
        menubar.add(formatMenu);
        JMenuItem it = new JMenuItem("Italic");
        formatMenu.add(it);
        it.addActionListener(new ItalicHandler());
        JMenuItem bold = new JMenuItem("Bold");
        formatMenu.add(bold);
        bold.addActionListener(new BoldHandler());

        JMenuItem plain = new JMenuItem("Plain");
        formatMenu.add(plain);
        plain.addActionListener(new PlainHandler());
        //new menu view
        JMenu viewMenu = new JMenu("View");
        menubar.add(viewMenu);
        JMenuItem lineCount = new JMenuItem("Line Count");
        viewMenu.add(lineCount);
        lineCount.addActionListener(new LineHandler());

    }

    /**
     * Create the frame and its content - private method.
     * All components made not visible except Quit button
     */
    private void makeFrame()
    {   

        //set layout of content pane
        contentPane.setLayout(new BorderLayout());
        contentPane.add(text,BorderLayout.EAST); 
        contentPane.add(northPanel, BorderLayout.NORTH);

        //add some components directly to content pane
        text.setVisible(true);
        JScrollPane scroll = new JScrollPane (text,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        northPanel.add(clearButton);
        // clearButton.setVisible(false);
        //set panel layout and add components
        northPanel.setLayout(new GridLayout(1,4));
        northPanel.setVisible(true);

        myFrame.add(scroll);
        myFrame.pack();
        myFrame.setVisible(true);

    }

    private class OpenHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {  
            JFileChooser fileChooser = new JFileChooser();
          //  int result = fileChooser.showOpenDialog();
          //  if (result == JFileChooser.APPROVE_OPTION)
          //  {
            //    File selectedFile = fileChooser.getSelectedFile();
           //     System.out.println("Selected file: " + selectedFile.getAbsolutePath());
         //   }
        }
    }

    private class SaveHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            northPanel.setVisible(true);
            eastPanel.setVisible(true);
            text.setVisible(true);
            clearButton.setVisible(true);
        }
    }

    private class CutHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {            
            text.cut();
        }
    }

    private class CopyHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            text.copy();
        }
    }

    private class PasteHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            text.paste();
        }
    }

    private class QuitHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            System.exit(0);
        }
    }

    private class ItalicHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            f = new Font("Helvetica",Font.ITALIC,12);
            text.setFont(f);
        }
    }

    private class BoldHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            f = new Font("Helvetica",Font.BOLD,12);
            text.setFont(f);
        }
    }

    private class PlainHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            f = new Font("Helvetica",Font.BOLD,12);
            text.setFont(f);
        }
    }

    private class LineHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int s = text.getLineCount();
            JOptionPane.showMessageDialog(myFrame,s);
        }
    }

}
