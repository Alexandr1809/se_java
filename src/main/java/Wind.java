import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wind extends JFrame implements ActionListener {

    int sum = 0, dif = 0, mul = 0, div = 0, fa = 0, st = 0, ma = 0;
    int a, b, c, res=1;
    String j, h, f;

    private JFrame win;
    private JButton knop[] = new JButton[10];
    private Font font = new Font("SanSerif", Font.BOLD, 20);
    private JTextField wwesti;
    private JButton del;
    private JButton rawn;
    private JButton minu;
    private JButton plus;
    private JButton delen;
    private JButton umn;
    private JButton fac;
    private JButton stp;
    private JButton srw;
    private JButton maxi;

    private String text = "";

    public Wind() {
        setLayout(null);

        win = new JFrame("КАЛЬКУЛЯТОР");
        win.setSize(300, 450);
        win.setVisible(true);

        del = new JButton("<");
        del.setBounds(10, 250, 50, 50);
        del.setFont(font);
        win.add(del);

        rawn = new JButton("=");
        rawn.setBounds(130, 250, 50, 50);
        rawn.setFont(font);
        win.add(rawn);

        minu = new JButton("-");
        minu.setBounds(190, 70, 50, 50);
        minu.setFont(font);
        win.add(minu);

        plus = new JButton("+");
        plus.setBounds(190, 130, 50, 50);
        plus.setFont(font);
        win.add(plus);

        delen = new JButton(":");
        delen.setBounds(190, 190, 50, 50);
        delen.setFont(font);
        win.add(delen);

        umn = new JButton("*");
        umn.setBounds(190, 250, 50, 50);
        umn.setFont(font);
        win.add(umn);

        fac = new JButton("!");
        fac.setBounds(10, 320, 50, 50);
        fac.setFont(font);
        win.add(fac);

        stp = new JButton("stp");
        stp.setBounds(70, 320, 60, 50);
       // stp.setFont(font);
        win.add(stp);

        maxi = new JButton("max");
        maxi.setBounds(140, 320, 60, 50);
       // srw.setFont(font);
        win.add(maxi);


        knop[0] = new JButton("0");
        knop[0].setBounds(70, 250, 50, 50);
        knop[0].setFont(font);
        win.add(knop[0]);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                knop[x * 3 + y + 1] = new JButton((x * 3 + y + 1) + "");
                knop[x * 3 + y + 1].setBounds(x * (50 + 10) + 10, y * (50 + 10) + 70, 50, 50);
                knop[x * 3 + y + 1].setFont(font);
                win.add(knop[x * 3 + y + 1]);
            }
        }
        wwesti = new JTextField();
        wwesti.setBounds(10, 10, 230, 50);
        // wwesti.setVisible(true);
        wwesti.setEnabled(false);
        wwesti.setFont(font);
        win.add(wwesti);

        ActionListener l = (ActionEvent e) -> {
            JButton kn = (JButton) e.getSource();
            wwesti.setText(wwesti.getText() + kn.getText());
        };
        for (JButton kn : knop) {
            kn.addActionListener(l);
        }


        maxi.addActionListener(this);
        stp.addActionListener(this);
        fac.addActionListener(this);
        del.addActionListener(this);
        plus.addActionListener(this);
        rawn.addActionListener(this);
        minu.addActionListener(this);
        umn.addActionListener(this);
        delen.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == del) {
            text = "";
            wwesti.setText(text);
        }

        if (e.getSource() == plus) {
            j = wwesti.getText();
            text = "";
            wwesti.setText(text);
            sum++;
        }

        if (e.getSource() == minu) {
            j = wwesti.getText();
            text = "";
            wwesti.setText(text);
            dif++;
        }

        if (e.getSource() == umn) {
            j = wwesti.getText();
            text = "";
            wwesti.setText(text);
            mul++;
        }

        if (e.getSource() == delen) {
            j = wwesti.getText();
            text = "";
            wwesti.setText(text);
            div++;
        }

        if (e.getSource() == fac) {
            f = wwesti.getText();
            c = Integer.parseInt(f);
        while (c !=0) {
            res *= c;
            c--;
        }
            wwesti.setText(res + "");

            f = "";
            c=0;
            j="";

        }

        if (e.getSource() == stp){
            j = wwesti.getText();
            text = "";
            wwesti.setText(text);
            st++;
        }

        if (e.getSource() == maxi){
            j = wwesti.getText();
            text = "";
            wwesti.setText(text);
            ma++;
        }

                h = wwesti.getText();
                b = Integer.parseInt(h);
                a = Integer.parseInt(j);
                if (sum == 1) {
                    wwesti.setText(a + b + "");
                    sum = 0;
                    a = 0;
                    b = 0;
                    h = "";
                    j = "";
                }

                if (dif == 1) {
                    wwesti.setText(a - b + "");
                    dif = 0;
                    a = 0;
                    b = 0;
                    h = "";
                    j = "";
                }

                if (mul == 1) {
                    wwesti.setText(a * b + "");
                    mul = 0;
                    a = 0;
                    b = 0;
                    h = "";
                    j = "";
                }

                if (div == 1) {
                    wwesti.setText(a / b + "");
                    div = 0;
                    a = 0;
                    b = 0;
                    h = "";
                    j = "";
                }

                if (st == 1){
                    res = 1;
                  for (int i=0;i<a;i++){
                      res = res * b;
                  }
                    wwesti.setText(res + "");
                  st = 0;
                    a = 0;
                    b = 0;
                    h = "";
                    j = "";
            }

                if (ma == 1){
                    res = (a>b)?a:b;
                    wwesti.setText(res + "");
                    ma = 0;
                    a = 0;
                    b = 0;
                    h = "";
                    j = "";
                }
        }
    }
