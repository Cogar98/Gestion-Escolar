
package SAES;
import java.util.ArrayList;
import static SAES.Main.*; // IMPORTA TODOS LOS ARRAYLIST DE MAIN
import javax.swing.JOptionPane;

public class Inicio_Sesion extends javax.swing.JFrame {
    public Inicio_Sesion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        UserLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        UserField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        B_Iniciar = new javax.swing.JButton();
        B_Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Titulo.setText("INICIO DE SESION");

        UserLabel.setText("USER");

        PasswordLabel.setText("PASSWORD");

        B_Iniciar.setText("CONTINUAR");
        B_Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_IniciarActionPerformed(evt);
            }
        });
        B_Iniciar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                B_IniciarKeyPressed(evt);
            }
        });

        B_Salir.setText("SALIR");
        B_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 156, Short.MAX_VALUE)
                .addComponent(Titulo)
                .addGap(154, 154, 154))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PasswordLabel)
                            .addComponent(UserLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PasswordField)
                            .addComponent(UserField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(B_Iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(B_Salir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(Titulo)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UserLabel)
                        .addGap(27, 27, 27)
                        .addComponent(PasswordLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B_Iniciar)
                    .addComponent(B_Salir))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_IniciarActionPerformed
        //boolean regresaPrivilegios = true; // SIRVE PARA DECIDIR SI recorre_ArrayList regresa privilegios administrativos o solamente para recorrer los ArrayList
        
        if(recorre_ArrayList(alumnos ,administradores,profesores, false)) // DEBE SER TRUE PARA QUE SUCEDA
        {
            // ATRIBUTOS
            boolean privilegios_administrativos = recorre_ArrayList(alumnos,administradores,profesores,true); // CONCEDE TRUE/FALSE SEGUN EL ATRIBUTO Privilegios_Administrativos del usuario
            // VALIDACION DE PRIVILEGIOS ADMINISTRATIVOS
            if(privilegios_administrativos == true)
            {
                Menu_Administrador ventana_administrador = new Menu_Administrador();
                this.setVisible(false);
                ventana_administrador.setVisible(true); // ABRE EL MENU PARA ADMINISTRADORES
            }
            if(privilegios_administrativos == false)
            { // EL USUARIO ES DE TIPO ALUMNO O PROFESOR POR LO TANTO ES NECESARIO VALIDAR QUE TIPO ES
                switch("ES " + consigue_tipo_usuario())
                { // ESTE SWITCH ABRE EL TIPO DE VENTANA PARA ALUMNO O PROFESORS
                    case "ES ALUMNO":
                        Menu_Alumno ventana_alumno = new Menu_Alumno();
                        this.setVisible(false); // cierra el inicio de sesion
                        ventana_alumno.setVisible(true); //  // ABRE VENTANA DE TIPO ALUMNO
                        break;
                    case "ES PROFESOR":
                        Menu_Profesor ventana_profesor  = new Menu_Profesor();
                        this.setVisible(false);
                        ventana_profesor.setVisible(true);
                        break;
                    case "NINGUNO":
                        JOptionPane.showMessageDialog(null,"FALLO ENCONTRAR EL TIPO DE USUARIO, COMUNIQUESE CON EL ADMINISTRADOR");
                        break;
                }
            }
        }
        else
        {
           JOptionPane.showMessageDialog(null,"DATOS INCORRECTOS PORFAVOR VUELVE A INTENTARLO");
        }
    }//GEN-LAST:event_B_IniciarActionPerformed

    private void B_IniciarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_B_IniciarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_B_IniciarKeyPressed

    private void B_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_SalirActionPerformed
    System.exit(0); // CIERRA EL PROGRAMA
    }//GEN-LAST:event_B_SalirActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio_Sesion().setVisible(true);
            }
        });
    }
    //METODOS
    public void iniciar_sesion()
    {
        
    }
    public boolean recorre_ArrayList(ArrayList<Alumno> alumnos , ArrayList<Administrador> administradores,
    ArrayList<Profesor> profesores, boolean regresaPrivilegios)
    {
        int i;
        for( i = 0 ; i < alumnos.size() ; i++ ) // RECORRE LA CANTIDAD DE ALUMNOS
        { 
            if( (alumnos.get(i).credenciales.user.equals(UserField.getText())) && (alumnos.get(i).credenciales.password.equals(PasswordField.getText())) && (alumnos.get(i).Privilegios_Administrativos == false) && (regresaPrivilegios == false))
            { // LA CONDICION INDICA QUE SI EL USUARIO Y LA CONTRASEÑA SON IGUALES A LOS TEXTFIELD, RETORNARA VERDADERO
                i = alumnos.size()-1; // CIERRA EL CICLO FOR
                return true;
            }
            // ESTE IF RETORNA EL VALOR DE LOS PRIVILEGIOS DEL USUARIO COMO BOOLEAN
            if( (alumnos.get(i).credenciales.user.equals(UserField.getText())) && (alumnos.get(i).credenciales.password.equals(PasswordField.getText())) && (alumnos.get(i).Privilegios_Administrativos == false) && (regresaPrivilegios == true)) // regresaPrivilegios == true porque QUIERO QUE RETORNE LOS PRIVILEGIOS DEL USUARIO
            { 
                i = alumnos.size()-1; // CIERRA EL CICLO FOR
                return alumnos.get(i).Privilegios_Administrativos;
            }            
        }
        for( i = 0 ; i < profesores.size() ; i++)
        {
            if( (profesores.get(i).credenciales.user.equals(UserField.getText())) && (profesores.get(i).credenciales.password.equals(PasswordField.getText())) && (profesores.get(i).Privilegios_Administrativos == false) && (regresaPrivilegios == false))
            { // LA CONDICION INDICA QUE SI EL USUARIO Y LA CONTRASEÑA SON IGUALES A LOS TEXTFIELD, RETORNARA VERDADERO
                i = profesores.size()-1; // CIERRA EL CICLO FOR
                return true;
            }
            if( (profesores.get(i).credenciales.user.equals(UserField.getText())) && (profesores.get(i).credenciales.password.equals(PasswordField.getText())) && (profesores.get(i).Privilegios_Administrativos == false) && (regresaPrivilegios == true)) // regresaPrivilegios == true porque QUIERO QUE RETORNE LOS PRIVILEGIOS DEL USUARIO
            { // LA CONDICION INDICA QUE SI EL USUARIO Y LA CONTRASEÑA SON IGUALES A LOS TEXTFIELD, RETORNARA VERDADERO
                i = profesores.size()-1; // CIERRA EL CICLO FOR
                return profesores.get(i).Privilegios_Administrativos;
            }   
        }
        for( i = 0 ; i < administradores.size() ; i++)
        {
            if( (administradores.get(i).credenciales.user.equals(UserField.getText())) && (administradores.get(i).credenciales.password.equals(PasswordField.getText())) && (administradores.get(i).Privilegios_Administrativos == true) && (regresaPrivilegios == false))
            { // LA CONDICION INDICA QUE SI EL USUARIO Y LA CONTRASEÑA SON IGUALES A LOS TEXTFIELD, RETORNARA VERDADERO
                i = administradores.size()-1; // CIERRA EL CICLO FOR
                return true;
            }
            if( (administradores.get(i).credenciales.user.equals(UserField.getText())) && (administradores.get(i).credenciales.password.equals(PasswordField.getText())) && (administradores.get(i).Privilegios_Administrativos == true) && (regresaPrivilegios == true)) // regresaPrivilegios == true porque QUIERO QUE RETORNE LOS PRIVILEGIOS DEL USUARIO
            { // LA CONDICION INDICA QUE SI EL USUARIO Y LA CONTRASEÑA SON IGUALES A LOS TEXTFIELD, RETORNARA VERDADERO
                i = administradores.size()-1; // CIERRA EL CICLO FOR
                return administradores.get(i).Privilegios_Administrativos;
            }   
        }
        return false; // FALSE POR DEFAULT 
    }
    public String consigue_tipo_usuario()
    {
        int i;
        for( i = 0 ; i < alumnos.size() ; i++ )
        {
            if( (alumnos.get(i).credenciales.user.equals(UserField.getText())) && (alumnos.get(i).credenciales.password.equals(PasswordField.getText())) && (alumnos.get(i).Privilegios_Administrativos == false))
            { // LA CONDICION INDICA QUE SI EL USUARIO Y LA CONTRASEÑA SON IGUALES A LOS TEXTFIELD, RETORNARA VERDADERO
                String tipoUsuario = "ALUMNO";
                i = alumnos.size()-1; // CIERRA EL CICLO FOR
                return tipoUsuario; // REGRESA  LA PALABRA "ALUMNO" PARA EL SWITCH
            }
            if( (profesores.get(i).credenciales.user.equals(UserField.getText())) && (profesores.get(i).credenciales.password.equals(PasswordField.getText())) && (profesores.get(i).Privilegios_Administrativos == false)) // regresaPrivilegios == true porque QUIERO QUE RETORNE LOS PRIVILEGIOS DEL USUARIO
            { // LA CONDICION INDICA QUE SI EL USUARIO Y LA CONTRASEÑA SON IGUALES A LOS TEXTFIELD, RETORNARA VERDADERO
                String tipoUsuario = "PROFESOR";
                i = profesores.size()-1; // CIERRA EL CICLO FOR
                return tipoUsuario; // RETORNA LA PALABRA "PROFESOR" PARA EL SWITCH
            } 
        }
        return "NINGUNO"; // RETURN POR DEFAULT YA QUE NO SE ENCONTRO EL TIPO DE USUARIO
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Iniciar;
    private javax.swing.JButton B_Salir;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel Titulo;
    private javax.swing.JTextField UserField;
    private javax.swing.JLabel UserLabel;
    // End of variables declaration//GEN-END:variables
}
