package gui;

import crud.crud;
import entity.month;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;



public class GUIWindow {
    public void mainFraime (){
        JFrame frame = new JFrame("Калькулятор стоимости услуг ЖКХ");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton readButton = new JButton("Получить данные");
        JButton addButton = new JButton("Добавить данные");
        JButton updateButton = new JButton("Обновить данные");
        JButton deleteButton = new JButton("Удалить данные");
        buttonPanel.add(readButton);
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        //main panel for Jtable
        JPanel mainPanel = new JPanel();

        crud.createDb();
        crud.readFromDB();
        System.out.println(crud.monthArray.size());





        TableModel tm = new MyTable(crud.monthArray);
        JTable table = new JTable(tm);
        frame.getContentPane().add(new JScrollPane(table));
        mainPanel.add(table);








        //info panel
        JPanel infoPanel = new JPanel();
        infoPanel.setBorder(new TitledBorder("Информация"));
        JLabel textInfo = new JLabel("Дополнительная информация будет ввыводиться тут.");
        infoPanel.add(textInfo);

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(infoPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public class MyTable extends AbstractTableModel{

        private java.util.List<month> monthArrayList;

        public MyTable(java.util.List<month>  monthArrayList){
            super();
            this.monthArrayList =  monthArrayList;
        }

        public int getColumnCount() {
            return 4;
        }

        @Override
        public String getColumnName(int col) {
            switch (col) {
                case 0:
                    return "Id";
                case 1:
                    return "Name";
                case 2:
                    return "Sum";
                default:
                    return " ";
            }
        }

        public int getRowCount() {
            return monthArrayList.size();
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            month month = monthArrayList.get(rowIndex);
            switch (columnIndex){
                case 0: return month.getId();
                case 1: return month.getMonthName();
                case 2: return month.getRentSum();
                default:return " szdfvsd";
            }

        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }




        }

}
