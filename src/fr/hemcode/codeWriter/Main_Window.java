package fr.hemcode.codeWriter;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.*;

public class Main_Window extends JFrame implements AutoCloseable {

    private static final int WINDOW_WIDTH = 1280;
    private static final int WINDOW_HEIGHT = 720;

    private Main_Window(String win_name) {
        super(win_name);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setLocationRelativeTo(null);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int close = JOptionPane.showConfirmDialog(
                        Main_Window.this,
                        "Êtes-vous sûr de vouloir quitter Code Writer",
                        "Quitter",
                        JOptionPane.YES_NO_OPTION);

                if (close == JOptionPane.YES_OPTION) {
                    try {
                        Main_Window.this.close();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        this.setJMenuBar(setMenuBar());
        JPanel jPanel = (JPanel) this.getContentPane();
    }

    @Override
    public void close() {
        Main_Window.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        Main_Window main_window = new Main_Window("Code Writer");
        main_window.setVisible(true);
    }

    private JMenuBar setMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("FILE");
        fileMenu.setMnemonic('f');

        JMenuItem newFileMenu = new JMenuItem("New file");
        newFileMenu.setMnemonic('n');

        fileMenu.add(newFileMenu);

        menuBar.add(fileMenu);

        return menuBar;
    }

    private JToolBar setToolBar() {
        JToolBar toolBar = new JToolBar();

        JButton btn_run = new JButton();

        return toolBar;
    }
}
