package com.hotel.latam.igu;

import com.hotel.latam.logica.ControladoraLogica;
import com.hotel.latam.logica.Huesped;
import com.hotel.latam.logica.Reserva;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.math.BigDecimal;
import java.util.Optional;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Busqueda extends javax.swing.JFrame {

    private JPanel contentPane;
    private JTextField txtBuscar;
    private JTable tbHuespedes;
    private JTable tbReservas;
    private DefaultTableModel modelo;
    private DefaultTableModel modeloHuesped;
    private JLabel labelAtras;
    private JLabel labelExit;
    int xMouse, yMouse;

    public Busqueda() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa-1.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 571);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(56, 56, 56));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
        setUndecorated(true);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(536, 127, 193, 31);
        txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        txtBuscar.setForeground(Color.WHITE);
        txtBuscar.setCaretColor(Color.WHITE);
        txtBuscar.setBackground(new Color(56, 56, 56));
        contentPane.add(txtBuscar);
        txtBuscar.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
        lblNewLabel_4.setForeground(new Color(12, 138, 199));
        lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
        lblNewLabel_4.setBounds(321, 62, 310, 42);
        contentPane.add(lblNewLabel_4);

        JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
        panel.setBackground(new Color(12, 138, 199));
        panel.setFont(new Font("Roboto", Font.PLAIN, 16));
        panel.setBounds(20, 169, 865, 328);
        contentPane.add(panel);

        ControladoraLogica control = new ControladoraLogica();

        List<Reserva> reservas = control.ListReserva();
        List<Huesped> huespedes = control.ListHuesped();

        tbReservas = new JTable();
        tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
        tbReservas.setBackground(new Color(56, 56, 56));
        tbReservas.setForeground(Color.WHITE);
        tbReservas.getTableHeader().setBackground(new Color(56, 56, 56));
        tbReservas.getTableHeader().setForeground(Color.WHITE);
        modelo = (DefaultTableModel) tbReservas.getModel();
        modelo.addColumn("Numero de Reserva");
        modelo.addColumn("Fecha Check In");
        modelo.addColumn("Fecha Check Out");
        modelo.addColumn("Valor");
        modelo.addColumn("Forma de Pago");
        
        for (Reserva reserva : reservas) {
            modelo.addRow(new Object[]{reserva.getId(),
                reserva.getFecha_checkIn(),
                reserva.getFecha_checkOut(),
                reserva.getValor(),
                reserva.getFormaDePago()});
        }
        JScrollPane scroll_table = new JScrollPane(tbReservas);
        scroll_table.getViewport().setBackground(new Color(56, 56, 56));
        panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table, null);
        scroll_table.setVisible(true);

        tbHuespedes = new JTable();
        tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
        tbHuespedes.setBackground(new Color(56, 56, 56));
        tbHuespedes.setForeground(Color.WHITE);
        tbHuespedes.getTableHeader().setBackground(new Color(56, 56, 56));
        tbHuespedes.getTableHeader().setForeground(Color.WHITE);
        modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
        modeloHuesped.addColumn("Número de Huesped");
        modeloHuesped.addColumn("Nombre");
        modeloHuesped.addColumn("Apellido");
        modeloHuesped.addColumn("Fecha de Nacimiento");
        modeloHuesped.addColumn("Nacionalidad");
        modeloHuesped.addColumn("Telefono");
        modeloHuesped.addColumn("Número de Reserva");
        
        for (Huesped huesped : huespedes) {
            modeloHuesped.addRow(new Object[]{huesped.getId(),
                huesped.getNombre(),
                huesped.getApellido(),
                huesped.getFechaDeNacimiento(),
                huesped.getNacionalidad(),
                huesped.getTelefono(),
                huesped.getReserva().getId()});
        }
        JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
        scroll_tableHuespedes.getViewport().setBackground(new Color(56, 56, 56));
        panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), scroll_tableHuespedes, null);
        scroll_tableHuespedes.setVisible(true);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
        lblNewLabel_2.setBounds(36, 51, 124, 107);
        contentPane.add(lblNewLabel_2);

        JPanel header = new JPanel();
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
        header.setBounds(0, 0, 910, 36);
        contentPane.add(header);

        JPanel btnAtras = new JPanel();
        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAtras.setBackground(new Color(12, 138, 199));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAtras.setBackground(new Color(56, 56, 56));
                
            }
        });
        btnAtras.setLayout(null);
        btnAtras.setBackground(new Color(56, 56, 56));
        btnAtras.setBounds(0, 0, 53, 36);
        header.add(btnAtras);

        labelAtras = new JLabel("<");
        labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
        labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
        labelAtras.setForeground(Color.white);
        labelAtras.setBounds(0, 0, 53, 36);
        btnAtras.add(labelAtras);

        JPanel btnexit = new JPanel();
        btnexit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MenuUsuario usuario = new MenuUsuario();
                usuario.setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) { //Al usuario pasar el mouse por el botón este cambiará de color
                btnexit.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) { //Al usuario quitar el mouse por el botón este volverá al estado original
                btnexit.setBackground(new Color(56, 56, 56));
                
            }
        });
        btnexit.setLayout(null);
        btnexit.setBackground(new Color(56, 56, 56));
        btnexit.setBounds(857, 0, 53, 36);
        header.add(btnexit);

        labelExit = new JLabel("X");
        labelExit.setHorizontalAlignment(SwingConstants.CENTER);
        labelExit.setForeground(Color.white);
        labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
        labelExit.setBounds(0, 0, 53, 36);
        btnexit.add(labelExit);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setForeground(new Color(12, 138, 199));
        separator_1_2.setBackground(new Color(12, 138, 199));
        separator_1_2.setBounds(539, 159, 193, 2);
        contentPane.add(separator_1_2);

        JPanel btnbuscar = new JPanel();
        btnbuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modeloHuesped.getDataVector().clear();
                modelo.getDataVector().clear();
                String buscar = txtBuscar.getText();

                if (buscar == null || buscar.isEmpty()) {
                    modelo.getDataVector().clear();
                    modeloHuesped.getDataVector().clear();
                    JOptionPane.showMessageDialog(null, "La busqueda esta vacia");
                } else {
                    for (Huesped huesped : huespedes) {
                        Reserva reserva = control.SearchReserva(huesped.getReserva().getId());

                        if (huesped.getNombre().equals(buscar) || huesped.getApellido().equals(buscar) || huesped.getTelefono().equals(buscar) || huesped.getNacionalidad().equals(buscar)) {
                            modeloHuesped.addRow(new Object[]{huesped.getId(),
                                huesped.getNombre(),
                                huesped.getApellido(),
                                huesped.getFechaDeNacimiento(),
                                huesped.getNacionalidad(),
                                huesped.getTelefono(),
                                huesped.getReserva().getId()});

                            modelo.addRow(new Object[]{reserva.getId(),
                                reserva.getFecha_checkIn(),
                                reserva.getFecha_checkOut(),
                                reserva.getValor(),
                                reserva.getFormaDePago()});
                            return;
                        }
                    }

                    modelo.getDataVector().clear();
                    modeloHuesped.getDataVector().clear();
                    JOptionPane.showMessageDialog(null, "Este usuario no esta registrado");
                }
            }
        });
        btnbuscar.setLayout(null);
        btnbuscar.setBackground(new Color(12, 138, 199));
        btnbuscar.setBounds(748, 125, 122, 35);
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contentPane.add(btnbuscar);

        JLabel lblBuscar = new JLabel("BUSCAR");
        lblBuscar.setBounds(0, 0, 122, 35);
        btnbuscar.add(lblBuscar);
        lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuscar.setForeground(Color.WHITE);
        lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
        
        JPanel btnEditar = new JPanel();
        btnEditar.setLayout(null);
        btnEditar.setBackground(new Color(12, 138, 199));
        btnEditar.setBounds(635, 508, 122, 35);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (tbReservas.isFocusOwner()) {
                        if (tbReservas.getSelectedRowCount() == 0 || tbReservas.getSelectedColumnCount() == 0) {
                            JOptionPane.showMessageDialog(null, "Por favor, elije un item");
                        } else {
                            Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
                                    .ifPresentOrElse(fila -> {

                                        Reserva reserva = control.SearchReserva(Long.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString()));
                                        reserva.setFecha_checkIn(modelo.getValueAt(tbReservas.getSelectedRow(), 1).toString());
                                        reserva.setFecha_checkOut(modelo.getValueAt(tbReservas.getSelectedRow(), 2).toString());
                                        reserva.setValor(new BigDecimal(modelo.getValueAt(tbReservas.getSelectedRow(), 3).toString()));
                                        reserva.setFormaDePago(modelo.getValueAt(tbReservas.getSelectedRow(), 4).toString());

                                        control.editReserva(reserva);

                                        tbReservas.clearSelection();
                                    }, () -> JOptionPane.showMessageDialog(null, "Por favor, elije un item"));
                        }
                    } else if (tbHuespedes.isFocusOwner()) {
                        if (tbHuespedes.getSelectedRowCount() == 0 || tbHuespedes.getSelectedColumnCount() == 0) {
                            JOptionPane.showMessageDialog(null, "Por favor, elije un item");
                        } else {
                            Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
                                    .ifPresentOrElse(fila -> {

                                        Reserva reserva = control.SearchReserva(Long.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 6).toString()));
                                        Huesped huesped = control.SearchHuesped(Long.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString()));

                                        huesped.setNombre(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1).toString());
                                        huesped.setApellido(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 2).toString());
                                        huesped.setFechaDeNacimiento(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 3).toString());
                                        huesped.setNacionalidad(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 4).toString());
                                        huesped.setTelefono(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 5).toString());
                                        huesped.setReserva(reserva);

                                        control.editHuesped(huesped);

                                        tbHuespedes.clearSelection();
                                    }, () -> JOptionPane.showMessageDialog(null, "Por favor, elije un item"));
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Este regsitro esta asociado a un huesped");
                    tbReservas.clearSelection();
                    tbHuespedes.clearSelection();
                }
            }
        });
        contentPane.add(btnEditar);

        JLabel lblEditar = new JLabel("EDITAR");
        lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEditar.setForeground(Color.WHITE);
        lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEditar.setBounds(0, 0, 122, 35);
        btnEditar.add(lblEditar);

        JPanel btnEliminar = new JPanel();
        btnEliminar.setLayout(null);
        btnEliminar.setBackground(new Color(12, 138, 199));
        btnEliminar.setBounds(767, 508, 122, 35);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (tbReservas.isFocusOwner()) {
                        if (tbReservas.getSelectedRowCount() == 0 || tbReservas.getSelectedColumnCount() == 0) {
                            JOptionPane.showMessageDialog(null, "Por favor, elije un item");
                        } else {
                            Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
                                    .ifPresentOrElse(fila -> {
                                        Long id = Long.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());

                                        control.deleteReserva(id);
                                        modelo.removeRow(tbReservas.getSelectedRow());

                                    }, () -> JOptionPane.showMessageDialog(null, "Por favor, elije un item"));
                        }
                    } else if (tbHuespedes.isFocusOwner()) {
                        if (tbHuespedes.getSelectedRowCount() == 0 || tbHuespedes.getSelectedColumnCount() == 0) {
                            JOptionPane.showMessageDialog(null, "Por favor, elije un item");
                        } else {
                            Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
                                    .ifPresentOrElse(fila -> {
                                        Long id = Long.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());

                                        control.deleteHuesped(id);
                                        modeloHuesped.removeRow(tbHuespedes.getSelectedRow());

                                    }, () -> JOptionPane.showMessageDialog(null, "Por favor, elije un item"));
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Este registro esta asociado a un huesped");
                    tbReservas.clearSelection();
                    tbHuespedes.clearSelection();
                }
            }
        });
        contentPane.add(btnEliminar);

        JLabel lblEliminar = new JLabel("ELIMINAR");
        lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEliminar.setForeground(Color.WHITE);
        lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
        lblEliminar.setBounds(0, 0, 122, 35);
        btnEliminar.add(lblEliminar);
        setResizable(false);
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
}
