package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.dataMoviecontroller;
/**
 * @RozaanHP
 * **/
public class MainView extends JFrame {

    dataMoviecontroller dc;
    public MainView(){
        initComponents();
        dc = new dataMoviecontroller(this);
        dc.isitable();
    }


    private JTextField judul, alur, penokohan, akting, nilai;
    private JButton create, update, delete;
    private JTable movieTable;
    private DefaultTableModel tableModel;

    private void initComponents() {
        JPanel leftPanel = new JPanel(new BorderLayout());
        tabelDataMovie = new JTable();

        tabelDataMovie.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
                }
        ));
        tabelDataMovie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ActionEvent dummyEvent = new ActionEvent(tabelDataMovie, ActionEvent.ACTION_PERFORMED, "");
                tabelDataMovieMouseClicked(dummyEvent);
            }
        });
        JScrollPane scrollPane = new JScrollPane(tabelDataMovie);
        leftPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        JPanel createPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        createPanel.add(new JLabel("Judul"));
        judul = new JTextField(20);
        createPanel.add(judul);

        createPanel.add(new JLabel("Alur"));
        alur = new JTextField(20);
        createPanel.add(alur);

        createPanel.add(new JLabel("Penokohan"));
        penokohan = new JTextField(20);
        createPanel.add(penokohan);

        createPanel.add(new JLabel("Akting"));
        akting = new JTextField(20);
        createPanel.add(akting);


        rightPanel.add(createPanel);



        JPanel readPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        create = new JButton("Tambah");
        readPanel.add(create);
        update = new JButton("Update");
        readPanel.add(update);
        delete = new JButton("Delete");
        readPanel.add(delete);
        rightPanel.add(readPanel);


        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                create();
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });

        setLayout(new BorderLayout());
        add(leftPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);

        setTitle("Movie Database");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void create() {
        dc.create();
        dc.isitable();
    }

    private void tabelDataMovieMouseClicked(java.awt.event.ActionEvent evt){
        int baris = tabelDataMovie.getSelectedRow();
        judul.setText(tabelDataMovie.getValueAt(baris,0).toString());
        alur.setText(tabelDataMovie.getValueAt(baris,1).toString());
        penokohan.setText(tabelDataMovie.getValueAt(baris,2).toString());
        akting.setText(tabelDataMovie.getValueAt(baris,3).toString());
        nilai.setText(tabelDataMovie.getValueAt(baris,4).toString());
    }
    private void update() {
        dc.update();
        dc.isitable();
    }

    private void delete() {
        dc.delete();
        dc.isitable();
    }

    private javax.swing.JTable tabelDataMovie;

    public JTable getMovieTable() {
        return tabelDataMovie;
    }
    public String getJudul() {
        return judul.getText();
    }
    public String getAlur() {
        return alur.getText();
    }
    public String getPenokohan() {
        return penokohan.getText();
    }
    public String getAkting() {
        return akting.getText();
    }
}
