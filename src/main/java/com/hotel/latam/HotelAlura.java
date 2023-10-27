package com.hotel.latam;

import com.hotel.latam.igu.Login;
import java.awt.EventQueue;

public class HotelAlura {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
                                        frame.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
