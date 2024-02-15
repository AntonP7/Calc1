import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.text.DecimalFormat;

public class Main extends JFrame {
    Main(){
        this.setVisible(true);
        this.setBounds(100,200,800,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Calculator 0.1");
        this.setLayout(null);



        jbNum = new JButton[10]; //number of digits
        for(int i=0; i<10; i++) {
            jbNum[i] = new JButton("" + i);
            this.add(jbNum[i]);
            jbNum[i].setBounds(25 + 60 * (i%3), 45+30*(i/3), 50, 25);

            int finalI = i;
            jbNum[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    digitType(""+ finalI);

                }
            });
        }



        jbClear =new JButton("C");
        this.add(jbClear);
        jbClear.setBounds(465,100,50, 25);


        jbMultiply =new JButton("×");
        this.add(jbMultiply);
        jbMultiply.setBounds(330,130,50, 25);


        jbSum=new JButton("+");
        this.add(jbSum);
        jbSum.setBounds(400,100,50, 25);


        jbSub=new JButton("−");
        this.add(jbSub);
        jbSub.setBounds(400,130,50, 25);


        jbDiv =new JButton("/");
        this.add(jbDiv);
        jbDiv.setBounds(330,100,50, 25);


        jbResult =new JButton("=");
        this.add(jbResult);
        jbResult.setBounds(330,180,120, 25);


        jLResult = new JLabel("0");
        this.add(jLResult);
        jLResult.setBounds(50,20,50,24);

        jbPoint = new JButton(".");
        this.add(jbPoint);
        jbPoint.setBounds(465,130,50,25);



        jbClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLResult.setText("0");
            }
        });


        jbSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstOper = Integer.parseInt(jLResult.getText());
                jLResult.setText("0");
                operationCalc =OperationCalc.SUM;
            }
        });
        jbSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstOper = Integer.parseInt(jLResult.getText());
                jLResult.setText("0");
                operationCalc=OperationCalc.SUB;
            }
        });
        jbDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstOper = Integer.parseInt(jLResult.getText());
                jLResult.setText("0");

                operationCalc = OperationCalc.DIV;
            }
        });
        jbMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstOper = Integer.parseInt(jLResult.getText());
                jLResult.setText("0");
                operationCalc = OperationCalc.MUL;
            }
        });
        jbResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                jLResult.setText(operationCalc.OperCalc(firstOper, Integer.parseInt(jLResult.getText())));
                operationCalc =OperationCalc.NONE;

            }

        });
        jbPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLResult.setText(".");

            }
        });

    }


    private void digitType(String inputDigit){
        if(jLResult.getText().equals("0")){
            jLResult.setText(inputDigit);
        }
        else{
            jLResult.setText( jLResult.getText()+inputDigit);
        }
    }
    public static void main(String[] args) {
        new Main();
    }
    private int firstOper = 0;
    private final float firstResult= 0;
    private final int  secondResult=0;


    private OperationCalc operationCalc = OperationCalc.NONE;


    JButton[] jbNum;
    JButton jbClear;
    JButton jbMultiply;
    JButton jbSum;
    JButton jbSub;
    JButton jbDiv;
    JButton jbResult;
    JButton jbPoint;



    JLabel jLResult;

    public int getFirstOper() {
        return firstOper;
    }
}