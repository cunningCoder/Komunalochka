package gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class GUIWindow {
    public void mainFraime (){
        JFrame frame = new JFrame("����������� ��������� ����� ���");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        //panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton readButton = new JButton("�������� ������");
        JButton addButton = new JButton("�������� ������");
        JButton updateButton = new JButton("�������� ������");
        JButton deleteButton = new JButton("������� ������");
        buttonPanel.add(readButton);
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        //main panel for Jtable
        JPanel mainPanel = new JPanel();


        //info panel
        JPanel infoPanel = new JPanel();
        infoPanel.setBorder(new TitledBorder("����������"));

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(infoPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
