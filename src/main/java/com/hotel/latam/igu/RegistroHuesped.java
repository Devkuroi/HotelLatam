package com.hotel.latam.igu;

import com.hotel.latam.logica.ControladoraLogica;
import com.hotel.latam.logica.Huesped;
import com.hotel.latam.logica.Reserva;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.Format;
import java.awt.Toolkit;
import java.time.ZoneId;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.plaf.basic.BasicComboBoxUI;

@SuppressWarnings("serial")
public class RegistroHuesped extends JFrame {

    private JPanel contentPane;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTelefono;
    private JTextField txtNreserva;
    private JDateChooser txtFechaN;
    private JComboBox<Format> txtNacionalidad;
    int xMouse, yMouse;

    public RegistroHuesped(Reserva reserva) {

        setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroHuesped.class.getResource("/Imagenes/disquete.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 634);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(56, 56, 56));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setUndecorated(true);
        contentPane.setLayout(null);

        JPanel header = new JPanel();
        header.setBounds(0, 0, 910, 36);
        header.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                headerMouseDragged(e);

            }
        });
        header.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                headerMousePressed(e);
            }
        });
        header.setLayout(null);
        header.setBackground(new Color(56, 56, 56));
        header.setOpaque(false);
        header.setBounds(0, 0, 910, 36);
        contentPane.add(header);

        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtNombre.setBounds(560, 135, 285, 33);
        txtNombre.setBackground(new Color(56, 56, 56));
        txtNombre.setForeground(Color.white);
        txtNombre.setCaretColor(Color.white);
        txtNombre.setColumns(10);
        txtNombre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtNombre);

        txtApellido = new JTextField();
        txtApellido.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtApellido.setBounds(560, 204, 285, 33);
        txtApellido.setColumns(10);
        txtApellido.setBackground(new Color(56, 56, 56));
        txtApellido.setForeground(Color.white);
        txtApellido.setCaretColor(Color.white);
        txtApellido.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtApellido);

        txtFechaN = new JDateChooser();
        txtFechaN.setBounds(560, 278, 285, 36);
        txtFechaN.getCalendarButton().setIcon(new ImageIcon(RegistroHuesped.class.getResource("/Imagenes/icon-reservas.png")));
        txtFechaN.getCalendarButton().setBackground(SystemColor.textHighlight);
        txtFechaN.setDateFormatString("yyyy-MM-dd");
        
        JTextField dateEditor = (JTextField) txtFechaN.getDateEditor();
        dateEditor.setBackground(new Color(100, 100, 100));
        dateEditor.setEditable(false);
        contentPane.add(txtFechaN);

        txtNacionalidad = new JComboBox();
        txtNacionalidad.setBounds(560, 350, 289, 36);
        txtNacionalidad.setBackground(new Color(56, 56, 56));
        txtNacionalidad.setForeground(Color.WHITE);
        txtNacionalidad.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtNacionalidad.setModel(new DefaultComboBoxModel(new String[]{"Afganistan", "Alemania", "Árabia saudita", "Argentina", "Australia", "Belgica", "Bolivia", "Brasil", "Camboya", "Canada", "Chile", "China", "Colombia", "Corea", "Costa Rica", "Cuba", "danés-danesa", "Ecuador", "Egipto", "Salvador", "Escocia", "España", "Estados Unidos", "Estonia", "Etiopia", "Filipinas", "Finlandés", "Francia", "Gales", "Grecia", "Guatemala", "Haiti", "Paises Bajos", "Honduras", "Indonesia", "Reindo Unido", "Irak", "Iran", "Irlandia", "Israel", "Italia", "Japon", "Jordania", "Laos", "Letonia", "letonia", "Malasia", "Marruecos", "Mexico", "Nicaragua", "Noruega", "neozelandés-neozelandesa", "Panama", "paraguay", "Peru", "Polonia", "portugal", "Puerto Rico", "Republica dominica", "Rumania", "Rusia", "Suecia", "Suiza", "Tailandia", "Taiwan", "Turquia", "Ucrania", "Uruguay", "Venezuela", "Vietnam"}));
        txtNacionalidad.setUI(new CustomComboBoxUI());
        contentPane.add(txtNacionalidad);

        JLabel lblNombre = new JLabel("NOMBRE");
        lblNombre.setBounds(562, 119, 253, 14);
        lblNombre.setForeground(Color.white);
        lblNombre.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNombre);

        JLabel lblApellido = new JLabel("APELLIDO");
        lblApellido.setBounds(560, 189, 255, 14);
        lblApellido.setForeground(Color.white);
        lblApellido.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblApellido);

        JLabel lblFechaN = new JLabel("FECHA DE NACIMIENTO");
        lblFechaN.setBounds(560, 256, 255, 14);
        lblFechaN.setForeground(Color.white);
        lblFechaN.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblFechaN);

        JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
        lblNacionalidad.setBounds(560, 326, 255, 14);
        lblNacionalidad.setForeground(Color.white);
        lblNacionalidad.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNacionalidad);

        JLabel lblTelefono = new JLabel("TELÉFONO");
        lblTelefono.setBounds(562, 406, 253, 14);
        lblTelefono.setForeground(Color.white);
        lblTelefono.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtTelefono.setBounds(560, 424, 285, 33);
        txtTelefono.setColumns(10);
        txtTelefono.setBackground(new Color(56, 56, 56));
        txtTelefono.setForeground(Color.white);
        txtTelefono.setCaretColor(Color.white);
        txtTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        contentPane.add(txtTelefono);

        JLabel lblTitulo = new JLabel("REGISTRO HUÉSPED");
        lblTitulo.setBounds(596, 55, 254, 42);
        lblTitulo.setForeground(new Color(12, 138, 199));
        lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 23));
        contentPane.add(lblTitulo);

        JLabel lblNumeroReserva = new JLabel("NÚMERO DE RESERVA");
        lblNumeroReserva.setBounds(560, 474, 253, 14);
        lblNumeroReserva.setForeground(Color.white);
        lblNumeroReserva.setFont(new Font("Roboto Black", Font.PLAIN, 18));
        contentPane.add(lblNumeroReserva);

        txtNreserva = new JTextField();
        txtNreserva.setFont(new Font("Roboto", Font.PLAIN, 16));
        txtNreserva.setBounds(560, 495, 285, 33);
        txtNreserva.setColumns(10);
        txtNreserva.setBackground(new Color(56, 56, 56));
        txtNreserva.setForeground(Color.white);
        txtNreserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        txtNreserva.setText(String.valueOf(reserva.getId()));
        txtNreserva.setEditable(false);
        contentPane.add(txtNreserva);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setBounds(560, 170, 289, 2);
        separator_1_2.setForeground(new Color(12, 138, 199));
        separator_1_2.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2);

        JSeparator separator_1_2_1 = new JSeparator();
        separator_1_2_1.setBounds(560, 240, 289, 2);
        separator_1_2_1.setForeground(new Color(12, 138, 199));
        separator_1_2_1.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_1);

        JSeparator separator_1_2_2 = new JSeparator();
        separator_1_2_2.setBounds(560, 314, 289, 2);
        separator_1_2_2.setForeground(new Color(12, 138, 199));
        separator_1_2_2.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_2);

        JSeparator separator_1_2_3 = new JSeparator();
        separator_1_2_3.setBounds(560, 386, 289, 2);
        separator_1_2_3.setForeground(new Color(12, 138, 199));
        separator_1_2_3.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_3);

        JSeparator separator_1_2_4 = new JSeparator();
        separator_1_2_4.setBounds(560, 457, 289, 2);
        separator_1_2_4.setForeground(new Color(12, 138, 199));
        separator_1_2_4.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_4);

        JSeparator separator_1_2_5 = new JSeparator();
        separator_1_2_5.setBounds(560, 529, 289, 2);
        separator_1_2_5.setForeground(new Color(12, 138, 199));
        separator_1_2_5.setBackground(new Color(12, 138, 199));
        contentPane.add(separator_1_2_5);

        ControladoraLogica control = new ControladoraLogica();

        JPanel btnguardar = new JPanel();
        btnguardar.setBounds(723, 560, 122, 35);
        btnguardar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtNombre.getText() != null
                        && txtApellido.getText() != null
                        && txtFechaN.getDate() != null
                        && txtNacionalidad.getSelectedItem() != null
                        && txtTelefono.getText() != null) {
                    Huesped huesped = new Huesped(
                            txtNombre.getText(),
                            txtApellido.getText(),
                            txtFechaN.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                            txtNacionalidad.getSelectedItem().toString(),
                            txtTelefono.getText(),
                            reserva);
                    control.saveHuesped(huesped);
                    Exito exito = new Exito();
                    exito.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
                }

            }
        });
        btnguardar.setLayout(null);
        btnguardar.setBackground(new Color(12, 138, 199));
        contentPane.add(btnguardar);
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JLabel labelGuardar = new JLabel("GUARDAR");
        labelGuardar.setHorizontalAlignment(SwingConstants.CENTER);
        labelGuardar.setForeground(Color.WHITE);
        labelGuardar.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelGuardar.setBounds(0, 0, 122, 35);
        btnguardar.add(labelGuardar);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 489, 634);
        panel.setBackground(new Color(12, 138, 199));
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel imagenFondo = new JLabel("");
        imagenFondo.setBounds(0, 121, 479, 502);
        panel.add(imagenFondo);
        imagenFondo.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/Imagenes/registro.png")));

        JLabel logo = new JLabel("");
        logo.setBounds(174, 39, 124, 107);
        panel.add(logo);
        logo.setIcon(new ImageIcon(RegistroHuesped.class.getResource("/Imagenes/Ha-100px.png")));

    }

    //Código que permite mover la ventana por la pantalla según la posición de "x" y "y"	
    private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
    
    private static class CustomComboBoxUI extends BasicComboBoxUI {

        @Override
        protected JButton createArrowButton() {
            JButton button = super.createArrowButton();
            button.setBackground(new Color(56, 56, 56));
            button.setForeground(Color.WHITE);
            button.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            return button;
        }
    }
}
