package com.hotel.latam.igu;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Exito extends JDialog {

    private final JPanel contentPanel = new JPanel();

    public Exito() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(Exito.class.getResource("/imagenes/aH-40px.png")));
        setBounds(100, 100, 394, 226);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(56, 56, 56));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setUndecorated(true);
        contentPanel.setLayout(null);
        {
            JLabel lblNewLabel = new JLabel("");
            lblNewLabel.setIcon(new ImageIcon(Exito.class.getResource("/imagenes/Ha-100px.png")));
            lblNewLabel.setBounds(124, 10, 124, 100);
            contentPanel.add(lblNewLabel);
        }
        {
            JLabel lblNewLabel_1 = new JLabel("Datos guardados satisfactoriamente");
            lblNewLabel_1.setForeground(new Color(12, 138, 199));
            lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
            lblNewLabel_1.setBounds(40, 130, 322, 21);
            contentPanel.add(lblNewLabel_1);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(SystemColor.textHighlight);
            buttonPane.setBounds(159, 173, 72, 34);
            buttonPane.setLayout(null);
            buttonPane.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            buttonPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buttonPane.setBackground(new Color(0, 156, 223));
			}
		
			@Override
			public void mouseExited(MouseEvent e) {
				buttonPane.setBackground(SystemColor.textHighlight);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
                                usuario.setVisible(true);
                                dispose();
			}
		});
            contentPanel.add(buttonPane);

            JLabel lblNewLabel = new JLabel("OK");
            lblNewLabel.setBounds(0, 0, 72, 34);
            buttonPane.add(lblNewLabel);
            lblNewLabel.setForeground(SystemColor.controlLtHighlight);
            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
        }
    }
}
