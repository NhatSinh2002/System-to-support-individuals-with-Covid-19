/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import View.*;
import Process.PersonController;
import static Process.PersonController.getNextValuePerson;
import Model.Account;
import Model.Person;
import static View.ChangeValue.PersonStatus;
import static View.ChangeValue.getGender;
import static View.ChangeValue.getProvince;
import java.awt.event.KeyEvent;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Nguyen Hoang Trung
 */
public class AddPersonHotlineScreen extends javax.swing.JDialog {

    /**Hàm khởi tạo JDialg nhận Jframe EmployeeScreen làm parent
     * Creates new form AddInfomationPersonScreen
     */
    EmployeeScreen  emp = new EmployeeScreen();
    public AddPersonHotlineScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        emp = (EmployeeScreen) parent;
        setView();
    }
    
    //Dùng để giới hạn số điện thoại của người dùng
    //Chỉ được là số, giới hạn "lenghth_char_exp" kí tự
    public void LimitCharPhone(JTextField txt, java.awt.event.KeyEvent evt, int lenghth_char_exp) {
        String string = txt.getText();
        ErrorLabel.setText("");
        
        int length = string.length();

        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < lenghth_char_exp) {
                txt.setEditable(true);
            } else {
                txt.setEditable(false);
                ErrorLabel.setText("Nhập quá kí tự cho phép!!");
            }   
        }
        else
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ){
                ErrorLabel.setText("");
                txt.setEditable(true);
            } else {
                txt.setEditable(false);
            }

    }
    
    //Dùng để giới hạn ký tự cho Jtextfield
   //Chỉ được là số, giới hạn "lenghth_char_exp" kí tự
    public void LimitChar(JTextField txt, java.awt.event.KeyEvent evt, int lenghth_char_exp) {
        String string = txt.getText();
        ErrorLabel.setText("");

        int length = string.length();
            if (length < lenghth_char_exp) {
                txt.setEditable(true);
            } else {
                txt.setEditable(false);
                ErrorLabel.setText("Nhập quá kí tự cho phép!!");
                if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                    ErrorLabel.setText("");
                    txt.setEditable(true);
                } else {
                    txt.setEditable(false);
                }
            }      
    }
    
    //Đặt dữ liệu lại khi nhấn vào button thêm tại Jframe
    public void setView() {
        
        // set data
        IdperTextField.setText(getNextValuePerson());
        NameTextField.setText("");
        PhoneTextField.setText("");
        DistrictTextField.setText("");
        TownTextField.setText("");
        AddressTextField.setText("");
        StatusTextField.setText("Đang sử dụng");
        
        ProvinceComboBox.setModel(new DefaultComboBoxModel(getProvince()));
        ProvinceComboBox.setSelectedIndex(0);
    }
    
        //Đặt sự kiện khi nhấn nút lưu  tại JDialog

        public void setEventHotLine(){ 
        int check =-1;    
        if ((PhoneTextField.getText().length()) < 10) {
            JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!",
                    "Lỗi!", JOptionPane.ERROR_MESSAGE);
        } else {    
        Person person = new Person();
        person.setIdper(parseInt(IdperTextField.getText()));
        person.setName(NameTextField.getText());
        person.setGender(getGender(MaleGenderRadioButton));
        person.setDistrict(DistrictTextField.getText());
        person.setTown(TownTextField.getText());
        person.setAddress(AddressTextField.getText());
        person.setPhone(PhoneTextField.getText());
        if (ProvinceComboBox.getSelectedIndex() != 0) {
            person.setProvince(String.valueOf(ProvinceComboBox.getSelectedItem()));
        } else
            person.setProvince("");
        
        check = PersonController.AddPersonHotLine(person);
        emp.setTableManagePerson();
        emp.resizeColumnWidth(emp.getPersonTable());
        }
        
        if (check == 0) {
            int option = JOptionPane.showConfirmDialog(null, "Thêm thông tin thành công, bạn muốn tiếp tục?",
                    "Thông báo!", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                setView();
            } else {
                this.dispose();
            }
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IdperTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        DistrictTextField = new javax.swing.JTextField();
        TownTextField = new javax.swing.JTextField();
        AddressTextField = new javax.swing.JTextField();
        StatusTextField = new javax.swing.JTextField();
        MaleGenderRadioButton = new javax.swing.JRadioButton();
        FeMaleGenderRadioButton = new javax.swing.JRadioButton();
        NameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        PhoneTextField = new javax.swing.JTextField();
        ProvinceComboBox = new javax.swing.JComboBox<>();
        ErrorLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(106, 128, 254));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin người cần giúp đỡ ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Semibold", 0, 15))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setText("Mã người dùng");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setText("Họ và tên");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("Giới tính");

        IdperTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        IdperTextField.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setText("Tỉnh/Thành phố");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel7.setText("Quận/Huyện");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel8.setText("Phường");

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel9.setText("Địa chỉ");

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel10.setText("Trạng thái");

        DistrictTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DistrictTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DistrictTextFieldKeyPressed(evt);
            }
        });

        TownTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TownTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TownTextFieldKeyPressed(evt);
            }
        });

        AddressTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AddressTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AddressTextFieldKeyPressed(evt);
            }
        });

        StatusTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        StatusTextField.setEnabled(false);

        MaleGenderRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(MaleGenderRadioButton);
        MaleGenderRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MaleGenderRadioButton.setSelected(true);
        MaleGenderRadioButton.setText("Nam");

        FeMaleGenderRadioButton.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(FeMaleGenderRadioButton);
        FeMaleGenderRadioButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        FeMaleGenderRadioButton.setText("Nữ");

        NameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NameTextFieldKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setText("Số điện thoại");

        PhoneTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PhoneTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PhoneTextFieldKeyPressed(evt);
            }
        });

        ProvinceComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ProvinceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ErrorLabel.setBackground(new java.awt.Color(255, 255, 255));
        ErrorLabel.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        ErrorLabel.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)
                                .addComponent(IdperTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ProvinceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(MaleGenderRadioButton)
                                        .addGap(53, 53, 53)
                                        .addComponent(FeMaleGenderRadioButton))
                                    .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(96, 96, 96)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TownTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(DistrictTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(AddressTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(StatusTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(IdperTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(DistrictTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(TownTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(MaleGenderRadioButton)
                    .addComponent(FeMaleGenderRadioButton)
                    .addComponent(jLabel9)
                    .addComponent(AddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(PhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(StatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ProvinceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jButton1.setText("Lưu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setEventHotLine();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameTextFieldKeyPressed
        // TODO add your handling code here:
        LimitChar(NameTextField, evt, 30);
    }//GEN-LAST:event_NameTextFieldKeyPressed

    private void PhoneTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PhoneTextFieldKeyPressed
        // TODO add your handling code here:
        LimitCharPhone(PhoneTextField, evt, 10);
    }//GEN-LAST:event_PhoneTextFieldKeyPressed

    private void DistrictTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DistrictTextFieldKeyPressed
        // TODO add your handling code here:
        LimitChar(DistrictTextField, evt, 30);
    }//GEN-LAST:event_DistrictTextFieldKeyPressed

    private void TownTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TownTextFieldKeyPressed
        // TODO add your handling code here:
        LimitChar(TownTextField, evt, 30);
    }//GEN-LAST:event_TownTextFieldKeyPressed

    private void AddressTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddressTextFieldKeyPressed
        // TODO add your handling code here:
        LimitChar(AddressTextField, evt, 30);
    }//GEN-LAST:event_AddressTextFieldKeyPressed

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
            java.util.logging.Logger.getLogger(AddPersonHotlineScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPersonHotlineScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPersonHotlineScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPersonHotlineScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

    
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressTextField;
    private javax.swing.JTextField DistrictTextField;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JRadioButton FeMaleGenderRadioButton;
    private javax.swing.JTextField IdperTextField;
    private javax.swing.JRadioButton MaleGenderRadioButton;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JTextField PhoneTextField;
    private javax.swing.JComboBox<String> ProvinceComboBox;
    private javax.swing.JTextField StatusTextField;
    private javax.swing.JTextField TownTextField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
