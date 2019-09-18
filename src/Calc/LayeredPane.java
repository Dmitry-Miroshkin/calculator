package Calc;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class LayeredPane extends JFrame {
    public LayeredPane() {
        // создание окна
        super("Graphical Calculator");

        // выход при закрытии окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // определение многослойной панели
        JLayeredPane lp = getLayeredPane();

        // создание  фигур
        JButton button1 = new JButton("+");
        JButton button2 = new JButton("-");
        JButton button3 = new JButton("*");
        JButton button4 = new JButton("/");
        JButton button5 = new JButton("^");


        JTextField field1 = new JTextField();
        JTextField field2 = new JTextField();
        add(field2);
        add(field1);
// Создаем панель меню
        JMenuBar menubar = new JMenuBar();

        // Создаем меню
        JMenu menu = new JMenu("File");

        // ------------------------------------
        // Добавление простых элементов меню
        JMenuItem itm = new JMenuItem("Clear arguments");
        itm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field1.setText(" ");
                field2.setText(" ");
            }
        });
        menu.add(itm);

        itm = new JMenuItem("Close");
        itm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Close pressed...");
            }
        });
        menu.add(itm);

        // Добавляем меню в панель меню
        menubar.add(menu);

        // Добавляем панель меню в окно
        setJMenuBar(menubar);

        // определение местоположения фигур в окне
        button1.setBounds(150, 50, 50, 50);
        button2.setBounds(150, 110, 50, 50);
        button3.setBounds(150, 170, 50, 50);
        button4.setBounds(150, 230, 50, 50);
        button5.setBounds(150, 290, 50, 50);

        field1.setBounds(10, 150, 100, 50);
        field2.setBounds(220, 150, 100, 50);

        lp.add(button1, JLayeredPane.DEFAULT_LAYER);
        lp.add(button2, JLayeredPane.DEFAULT_LAYER);
        lp.add(button3, JLayeredPane.DEFAULT_LAYER);
        lp.add(button4, JLayeredPane.DEFAULT_LAYER);
        lp.add(button5, JLayeredPane.DEFAULT_LAYER);

        lp.add(field1);
        lp.add(field2);
        //        Обработка кликов по кнопке
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.z = Main.x + Main.y;
                System.out.println(Main.z);
                JOptionPane.showMessageDialog(LayeredPane.this,
                        "Результат: " + Main.z);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.z = Main.x - Main.y;
                System.out.println(Main.z);
                JOptionPane.showMessageDialog(LayeredPane.this,
                        "Результат: " + Main.z);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.z = Main.x * Main.y;
                System.out.println(Main.z);
                JOptionPane.showMessageDialog(LayeredPane.this,
                        "Результат: " + Main.z);
            }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.z = Main.x / Main.y;
                System.out.println(Main.z);
                JOptionPane.showMessageDialog(LayeredPane.this,
                        "Результат: " + Main.z);
            }
        });
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.z = Math.pow(Main.x, Main.y);
                System.out.println(Main.z);
                JOptionPane.showMessageDialog(LayeredPane.this,
                        "Результат: " + Main.z);
            }
        });

//        Обработка нажатия кнопки Enter в текстовом поле

        field1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.x = Double.parseDouble(field1.getText());
                System.out.println("Операнд1 : " + Main.x);
            }
        });
//        Обработка ввода и преобразование в число
        field1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!field1.getText().equals("")) {
                    Main.x = Double.parseDouble(field1.getText());
                    System.out.println("Операнд1 : " + Main.x);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!field1.getText().equals("")) {
                    Main.x = Double.parseDouble(field1.getText());
                    System.out.println("Операнд1 : " + Main.x);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (!field1.getText().equals("")) {
                    Main.x = Double.parseDouble(field1.getText());
                    System.out.println("Операнд1 : " + Main.x);
                }
            }
        });
        field2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!field2.getText().equals("")){
                    Main.y = Double.parseDouble(field2.getText());
                System.out.println("Операнд2: " + Main.y);}
            }
        });
        field2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!field2.getText().equals("")) {
                    Main.y = Double.parseDouble(field2.getText());
                    System.out.println("Операнд2 : " + Main.y);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!field2.getText().equals("")) {
                    Main.y = Double.parseDouble(field2.getText());
                    System.out.println("Операнд2 : " + Main.y);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (!field2.getText().equals("")) {
                    Main.y = Double.parseDouble(field2.getText());
                    System.out.println("Операнд2 : " + Main.y);
                }
            }
        });

        // определение размера и открытие окна
        setBounds(600, 500, 350, 450);

        setVisible(true);
    }
}

