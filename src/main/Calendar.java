package main;

import javax.swing.JOptionPane;

/**
 *
 * @author HAS
 */
public class Calendar extends javax.swing.JFrame {

    String result;

    public Calendar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        year1 = new javax.swing.JTextField();
        month1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        res = new javax.swing.JScrollPane();
        res1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calendar");

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year1ActionPerformed(evt);
            }
        });

        month1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                month1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter a Year");

        jLabel2.setText("Enter a Month");

        res1.setBackground(java.awt.Color.lightGray);
        res1.setColumns(20);
        res1.setRows(5);
        res.setViewportView(res1);

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(res)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(year1)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(month1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addComponent(jButton1)))))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(month1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(res, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String year2 = year1.getText();
        String month2 = month1.getText();
        // no exist input
        if ("".equals(year1.getText()) || "".equals(month1.getText())) {
            res1.setText("Invalid input");
        } else {
            // cheak if the input is valid or not
            try {
                int year = Integer.parseInt(year2);
                int month = Integer.parseInt(month2);

                // Prompt the user to enter month
                if (month <= 0 || month > 12 || year > 9999 || year < 1800) {

                    res1.setText("Invalid input");
                } else {
                    res1.setText("");
                    res1.append("\n\t" + getMonthName(month)
                            + " " + year);
                    res1.append("\n\t-----------------------------\n");

                    res1.append("\tSun\t Mon\t Tue\t Wed\t Thu\t Fri\t Sat\t\n");
                // Print calendar for the month of the year

                    // Get start day of the week for the first date in the month
                    int startDay = getStartDay(year, month);

                    // Get number of days in the month
                    int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

                    // Pad space before the first day of the month
                    int i = 0;

                    for (i = 0; i < startDay; i++) {
                        res1.append("\t");
                    }

                    for (i = 1; i <= numberOfDaysInMonth; i++) {

                        if (i < 10) {
                            res1.append("\t0" + i);
                        } else {
                            res1.append("\t" + i);
                        }

                        if ((i + startDay) % 7 == 0) {
                            res1.append("\n");
                        }

                    }

                    res1.append("\n");
                }

            } catch (Exception x) {
                res1.setText("Invalid input");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Get the English name for the month
     */
    static String getMonthName(int month) {
        String monthName = null;
        switch (month) {

            case 1: monthName = "January"; break;

            case 2: monthName = "February"; break;

            case 3: monthName = "March"; break;

            case 4: monthName = "April"; break;

            case 5: monthName = "May"; break;

            case 6: monthName = "June"; break;

            case 7: monthName = "July"; break;

            case 8: monthName = "August"; break;

            case 9: monthName = "September"; break;

            case 10: monthName = "October"; break;

            case 11: monthName = "November"; break;

            case 12: monthName = "December";
        }
        return monthName;
    }

    public static int getStartDay(int year, int month) {

        // Get total number of days since 1/1/1800
        int startDay1800 = 3;
        int totalNumberOfDays = getTotalNumberOfDays(year, month);
        // Return the start day
        return (totalNumberOfDays + startDay1800) % 7;

    }

    public static int getTotalNumberOfDays(int year, int month) {

        int total = 0;

        // Get the total days from 1800 to year - 1
        for (int i = 1800; i < year; i++) {
            if (isLeapYear(i)) {
                total = total + 366;
            } else {
                total = total + 365;
            }
        }
        // Add days from Jan to the month prior to the calendar month
        for (int i = 1; i < month; i++) {
            total = total + getNumberOfDaysInMonth(year, i);
        }

        return total;

    }

    static int getNumberOfDaysInMonth(int year, int month) {

        if (month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12) {
            return 31;
        }

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }

        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        }

        return 0; // If month is incorrect
    }

    /**
     * Determine if it is a leap year
     */
    static boolean isLeapYear(int year) {

        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);

    }


    private void year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_year1ActionPerformed

    private void month1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_month1ActionPerformed

    }//GEN-LAST:event_month1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        year1.setText("");
        month1.setText("");
        res1.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calendar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JTextField month1;
    public javax.swing.JScrollPane res;
    public static javax.swing.JTextArea res1;
    public javax.swing.JTextField year1;
    // End of variables declaration//GEN-END:variables
}
