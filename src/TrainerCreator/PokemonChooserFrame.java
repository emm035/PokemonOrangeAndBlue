/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Benjamin Matase, Jason Corriveau, Eric Marshall, Alexander Murph
 * Date: Apr 21, 2016
 * Time: 4:21:12 PM
 *
 * Project: csci205FinalProject
 * Package: TrainerCreator
 * File: PokemonChooserFrame
 * Description:
 *
 * ****************************************
 */
package TrainerCreator;

import DatabaseLoaderUtilities.PokemonLoaderUtility;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author Benjamin Matase
 */
public class PokemonChooserFrame extends javax.swing.JFrame implements
        ActionListener {

    /**
     * Creates new form pokemonChooserFrame
     */
    public PokemonChooserFrame() {
        initComponents();

        //hide panel with moves stuff originally
        pnlMoves.setVisible(false);

        //populate pokemon drop down list with all pokemon names
        populateCbxPkmn();

        cbxPkmn.addActionListener(this);
        cbxMove1.addActionListener(this);
        cbxMove2.addActionListener(this);
        cbxMove3.addActionListener(this);
        cbxMove4.addActionListener(this);

        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPkmn = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        cbxPkmn = new javax.swing.JComboBox();
        pnlMoves = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        cbxMove1 = new javax.swing.JComboBox();
        cbxMove2 = new javax.swing.JComboBox();
        cbxMove3 = new javax.swing.JComboBox();
        cbxMove4 = new javax.swing.JComboBox();
        btnCreate = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Choose a Pokemon:");
        jLabel1.setToolTipText("");

        cbxPkmn.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        javax.swing.GroupLayout pnlPkmnLayout = new javax.swing.GroupLayout(pnlPkmn);
        pnlPkmn.setLayout(pnlPkmnLayout);
        pnlPkmnLayout.setHorizontalGroup(
            pnlPkmnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPkmnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxPkmn, 0, 226, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPkmnLayout.setVerticalGroup(
            pnlPkmnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPkmnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPkmnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxPkmn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel2.setText("Move 1:");

        jLabel3.setText("Move 2:");

        jLabel4.setText("Move 3:");

        jLabel5.setText("Move 4:");

        cbxMove1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        cbxMove2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        cbxMove3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        cbxMove4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        btnCreate.setText("Create");

        javax.swing.GroupLayout pnlMovesLayout = new javax.swing.GroupLayout(pnlMoves);
        pnlMoves.setLayout(pnlMovesLayout);
        pnlMovesLayout.setHorizontalGroup(
            pnlMovesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMovesLayout.createSequentialGroup()
                .addGroup(pnlMovesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMovesLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxMove2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlMovesLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxMove4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlMovesLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxMove1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlMovesLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxMove3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMovesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCreate)
                .addContainerGap())
        );
        pnlMovesLayout.setVerticalGroup(
            pnlMovesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMovesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMovesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxMove1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlMovesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMove2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlMovesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMove3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlMovesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMove4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCreate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMoves, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPkmn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPkmn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlMoves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox cbxMove1;
    private javax.swing.JComboBox cbxMove2;
    private javax.swing.JComboBox cbxMove3;
    private javax.swing.JComboBox cbxMove4;
    private javax.swing.JComboBox cbxPkmn;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel pnlMoves;
    private javax.swing.JPanel pnlPkmn;
    // End of variables declaration//GEN-END:variables

    public JComboBox getCbxMove1() {
        return cbxMove1;
    }

    public void setCbxMove1(JComboBox cbxMove1) {
        this.cbxMove1 = cbxMove1;
    }

    public JComboBox getCbxMove2() {
        return cbxMove2;
    }

    public void setCbxMove2(JComboBox cbxMove2) {
        this.cbxMove2 = cbxMove2;
    }

    public JComboBox getCbxMove3() {
        return cbxMove3;
    }

    public void setCbxMove3(JComboBox cbxMove3) {
        this.cbxMove3 = cbxMove3;
    }

    public JComboBox getCbxMove4() {
        return cbxMove4;
    }

    public void setCbxMove4(JComboBox cbxMove4) {
        this.cbxMove4 = cbxMove4;
    }

    public JComboBox getCbxPkmn() {
        return cbxPkmn;
    }

    public void setCbxPkmn(JComboBox cbxPkmn) {
        this.cbxPkmn = cbxPkmn;
    }

    public JPanel getPnlPkmn() {
        return pnlPkmn;
    }

    public void setPnlPkmn(JPanel pnlPkmn) {
        this.pnlPkmn = pnlPkmn;
    }

    public JPanel getPnlMoves() {
        return pnlMoves;
    }

    public void setPnlMoves(JPanel pnlMoves) {
        this.pnlMoves = pnlMoves;
    }

    public String getPkmnName() {
        return cbxPkmn.getSelectedItem().toString();
    }

    private void populateCbxPkmn() {
        List<String> pkmnNameList = PokemonLoaderUtility.getPokemonNames();

        for (String pkmnName : pkmnNameList) {
            cbxPkmn.addItem(pkmnName);
        }
    }

    private boolean hasChosenPkmn() {
        return !cbxPkmn.getSelectedItem().equals(" ");
    }

    private boolean hasChosenAMove() {
        boolean hasMove1 = !cbxMove1.getSelectedItem().equals(" ");
        boolean hasMove2 = !cbxMove2.getSelectedItem().equals(" ");
        boolean hasMove3 = !cbxMove3.getSelectedItem().equals(" ");
        boolean hasMove4 = !cbxMove4.getSelectedItem().equals(" ");

        return hasMove1 || hasMove2 || hasMove3 || hasMove4;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cbxPkmn) {
            if (hasChosenPkmn()) {
                showMovesPnl();
                populateMoves();
            } else {
                hideMovesPnl();
            }

        } else if (e.getSource() == cbxMove1) {

        } else if (e.getSource() == cbxMove2) {

        } else if (e.getSource() == cbxMove3) {

        } else if (e.getSource() == cbxMove4) {

        }
    }

    private void hideMovesPnl() {
        pnlMoves.setVisible(false);
        this.pack();
    }

    private void showMovesPnl() {
        pnlMoves.setVisible(true);
        this.pack();
    }

    private void populateMoves() {
        String pkmnName = cbxPkmn.getSelectedItem().toString();
        List<String> moveNames = PokemonLoaderUtility.getMovesForPokemon(
                pkmnName);
        resetCbxs();
        for (String moveName : moveNames) {
            cbxMove1.addItem(moveName);
            cbxMove2.addItem(moveName);
            cbxMove3.addItem(moveName);
            cbxMove4.addItem(moveName);
        }
    }

    private void resetCbxs() {
        cbxMove1.removeAllItems();
        cbxMove2.removeAllItems();
        cbxMove3.removeAllItems();
        cbxMove4.removeAllItems();
        cbxMove1.addItem(" ");
        cbxMove2.addItem(" ");
        cbxMove3.addItem(" ");
        cbxMove4.addItem(" ");
    }

}
