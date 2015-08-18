package gui;

import crud.crud;

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

        crud.createDb();
        crud.readFromDB();

        //add vectors 2 table
        JTable table = new JTable(crud.b, crud.a);
        // add table header's
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(table.getTableHeader(), BorderLayout.PAGE_START);
        mainPanel.add(table, BorderLayout.CENTER);
        mainPanel.add(table);



        //info panel
        JPanel infoPanel = new JPanel();
        infoPanel.setBorder(new TitledBorder("����������"));
        JLabel textInfo = new JLabel("�������������� ���������� ����� ����������� ���.");
        infoPanel.add(textInfo);

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(infoPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
