import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Logining extends JFrame {

    JTextField loginField;
    JPasswordField passwordField;



    public Logining() {

        super("Вход в систему");
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
// Настраиваем первую горизонтальную панель (для ввода логина)
        Box box1 = Box.createHorizontalBox();
        final JLabel loginLabel = new JLabel("Логин:");
        loginField = new JTextField(15);
        box1.add(loginLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(loginField);
// Настраиваем вторую горизонтальную панель (для ввода пароля)
        Box box2 = Box.createHorizontalBox();
        JLabel passwordLabel = new JLabel("Пароль:");
        passwordField = new JPasswordField(15);
        box2.add(passwordLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(passwordField);
// Настраиваем третью горизонтальную панель (с кнопками)
        Box box3 = Box.createHorizontalBox();
        JButton ok = new JButton("OK");


        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DBWorker dbWorker = new DBWorker();
                ResultSet resultSet = null;
                Statement statement = null;
                boolean result = false;

                String query = "SELECT * from user where name=\'"+loginField.getText() +"\' and password = \'"+passwordField.getText() +"\';";
                try {
                    statement = dbWorker.getConnection().createStatement();
                    resultSet = statement.executeQuery(query);
                    result = resultSet.next(); //есть или нет результата

                        System.out.println(result);

                    //создать запрос -> передать

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                finally { //закрываем все в обратном порядке
                    if(resultSet != null){
                        try {
                            resultSet.close();
                            statement.close();
                            dbWorker.getConnection().close();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
            }
        }});


        JButton cancel = new JButton("Отмена");
        box3.add(Box.createHorizontalGlue());
        box3.add(ok);
        box3.add(Box.createHorizontalStrut(12));
        box3.add(cancel);
// Уточняем размеры компонентов
        loginLabel.setPreferredSize(passwordLabel.getPreferredSize());
// Размещаем три горизонтальные панели на одной вертикальной
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box3);
        setContentPane(mainBox);
        pack();
        setResizable(false);

        jFrame.add(box1);
        jFrame.add(box2);
        jFrame.add(box3);
        jFrame.add(mainBox);
        jFrame.setBounds(200,200,300,150);

    }
}
