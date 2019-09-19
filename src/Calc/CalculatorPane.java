package Calc;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalculatorPane extends JFrame {
    CalculatorPane() {
        // создание окна
        super("Graphic Calculator");

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
        field1.setText("0");
        field2.setText("0");

// Создаем панель меню (просто попробовать)
        JMenuBar menubar = new JMenuBar();

        // Создаем меню
        JMenu menu = new JMenu("File");

        // ------------------------------------
        // Добавление простых элементов меню
        JMenuItem itm = new JMenuItem("Clear arguments");
        itm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field1.setText("0");
                field2.setText("0");
            }
        });
        menu.add(itm);

        itm = new JMenuItem("Close");
        itm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Close pressed...");
                System.exit(0);
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
                JOptionPane.showMessageDialog(CalculatorPane.this,
                        "Результат: " + Main.z);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.z = Main.x - Main.y;
                System.out.println(Main.z);
                JOptionPane.showMessageDialog(CalculatorPane.this,
                        "Результат: " + Main.z);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.z = Main.x * Main.y;
                System.out.println(Main.z);
                JOptionPane.showMessageDialog(CalculatorPane.this,
                        "Результат: " + Main.z);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.z = Main.x / Main.y;
                System.out.println(Main.z);
                JOptionPane.showMessageDialog(CalculatorPane.this,
                        "Результат: " + Main.z);
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.z = Math.pow(Main.x, Main.y);
                System.out.println(Main.z);
                JOptionPane.showMessageDialog(CalculatorPane.this,
                        "Результат: " + Main.z);
            }
        });

//        Обработка нажатия кнопки Enter в текстовом поле

/*
        field1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numeralOrNot(field1.getText())) {
                    Main.x = Double.parseDouble(field1.getText());
                    System.out.println("Операнд1 : " + Main.x);
                } else {
                    JOptionPane.showMessageDialog(CalculatorPane.this,
                            "Ошибка ввода! Введите число.");
                }
            }
        });
        field2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numeralOrNot(field2.getText())) {
                    Main.y = Double.parseDouble(field2.getText());
                    System.out.println("Операнд2: " + Main.y);
                } else {
                    JOptionPane.showMessageDialog(CalculatorPane.this,
                            "Ошибка ввода! Введите число.");
                }
            }
        });

*/
//        Обработка ввода и преобразование в число
        field1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (numeralOrNot(field1.getText())) {
                    Main.x = Double.parseDouble(field1.getText());
                    System.out.println("Операнд1 : " + Main.x);
                } else {
                    JOptionPane.showMessageDialog(CalculatorPane.this,
                            "Ошибка ввода! Введите число.");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (numeralOrNot(field1.getText())) {
                    Main.x = Double.parseDouble(field1.getText());
                    System.out.println("Операнд1 : " + Main.x);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (numeralOrNot(field1.getText())) {
                    Main.x = Double.parseDouble(field1.getText());
                    System.out.println("Операнд1 : " + Main.x);
                } else {
                    JOptionPane.showMessageDialog(CalculatorPane.this,
                            "Ошибка ввода! Введите число.");
                }
            }
        });
        field2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                if (numeralOrNot(field2.getText())) {
                    Main.y = Double.parseDouble(field2.getText());
                    System.out.println("Операнд2 : " + Main.y);
                } else {
                    JOptionPane.showMessageDialog(CalculatorPane.this,
                            "Ошибка ввода! Введите число.");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (numeralOrNot(field2.getText())) {
                    Main.y = Double.parseDouble(field2.getText());
                    System.out.println("Операнд2 : " + Main.y);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (numeralOrNot(field2.getText())) {
                    Main.y = Double.parseDouble(field2.getText());
                    System.out.println("Операнд2 : " + Main.y);
                } else {
                    JOptionPane.showMessageDialog(CalculatorPane.this,
                            "Ошибка ввода! Введите число.");
                }
            }
        });

        // определение размера и открытие окна
        setBounds(600, 500, 350, 450);

        setVisible(true);
    }

    //Проверка ввода чисел
    private static boolean numeralOrNot(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        int commaCount = 0;
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '.') {
                commaCount++;
            }
            if ((!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.' && str.charAt(i) != '-') || commaCount > 1) {
                return false;
            }
        }

        return true;
    }
}

