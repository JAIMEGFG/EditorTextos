import sun.text.normalizer.Replaceable;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.*;
public class Ventana extends JFrame implements ItemListener,ActionListener {
    JMenuBar barraMenu;
    JMenu menuArchivo, menuEdicion,menuEstiloFuente;
    JMenuItem menuItemNuevo, menuItemAbrir, menuItemCerrar,menuItemGuardar,menuItemGuardarComo,menuItemImprimir;
    JMenuItem menuItemCopiar,menuItemCortar,menuItemPegar,menuItemBold,menuItemNormal,menuItemCursiva;
    JButton btnNuevo,btnAbrir,btnGuardar,btnImprimir,btnCopiar,btnCortar,btnPegar,btnBold;
    JButton btnCopiar2,btnCortar2,btnPegar2;
    JComboBox comboLetra, comboTamanio;
    DefaultComboBoxModel modeloLetra,modeloTamanio;
    JLabel labelLetra, labelTamanio;
    JPanel panelSuperior,panelCentro;
    JTextArea textArea;
    JPopupMenu popupMenu;
    JFileChooser fileChooser;


    public void initGUI(){
        instancias();
        configurarMenu();
        configurarPanel();
        rellenarTamanio();
        rellenarLetras();
        rellenarPopup();
        configurarMenu();
        acciones();
        this.setSize(new Dimension(300,300));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    private void rellenarPopup() {
        popupMenu.add(btnCopiar);
        popupMenu.add(btnCortar);
        popupMenu.add(btnPegar);
        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton()==MouseEvent.BUTTON3){
                    popupMenu.show(textArea,10,50);
                    setVisible(true);
                }
            }
        });
    }
    private void instancias() {
        popupMenu = new JPopupMenu();
        fileChooser = new JFileChooser();
        modeloLetra = new DefaultComboBoxModel();
        modeloTamanio = new DefaultComboBoxModel();
        comboLetra = new JComboBox(modeloLetra);
        comboTamanio = new JComboBox(modeloTamanio);
        labelLetra = new JLabel("Estilo");
        labelTamanio = new JLabel("Tipo");
        barraMenu = new JMenuBar();
        menuArchivo = new JMenu("Archivo");
        menuEdicion = new JMenu("Edición");
        menuEstiloFuente = new JMenu("Estilo de la Fuente");
        menuItemNuevo = new JMenuItem("Nuevo");
        menuItemNuevo.setIcon(new ImageIcon(getClass().getResource("/recursos/new.png")));
        menuItemAbrir = new JMenuItem("Abrir");
        menuItemAbrir.setIcon(new ImageIcon(getClass().getResource("/recursos/open.png")));
        menuItemCerrar = new JMenuItem("Cerrar");
        menuItemCerrar.setIcon(new ImageIcon(getClass().getResource("/recursos/close.png")));
        menuItemGuardar = new JMenuItem("Guardar");
        menuItemGuardar.setIcon(new ImageIcon(getClass().getResource("/recursos/save.png")));
        menuItemGuardarComo = new JMenuItem("Cuardar Como");
        menuItemImprimir = new JMenuItem("Imprimir");
        menuItemImprimir.setIcon(new ImageIcon(getClass().getResource("/recursos/new.png")));
        menuItemCopiar = new JMenuItem("Copiar");
        menuItemCopiar.setIcon(new ImageIcon(getClass().getResource("/recursos/copy.png")));
        menuItemCortar = new JMenuItem("Cortar");
        menuItemCortar.setIcon(new ImageIcon(getClass().getResource("/recursos/cut.png")));
        menuItemPegar = new JMenuItem("Pegar");
        menuItemPegar.setIcon(new ImageIcon(getClass().getResource("/recursos/paste.png")));
        menuItemBold = new JMenuItem("Bold");
        menuItemBold.setIcon(new ImageIcon(getClass().getResource("/recursos/bold.png")));
        menuItemNormal = new JMenuItem("Normal");
        menuItemNormal.setIcon(new ImageIcon(getClass().getResource("/recursos/normal.png")));
        menuItemCursiva = new JMenuItem("Cursiva");
        menuItemCursiva.setIcon(new ImageIcon(getClass().getResource("/recursos/italic.png")));
        btnNuevo = new JButton();
        btnNuevo.setIcon(new ImageIcon(getClass().getResource("/recursos/new.png")));
        btnAbrir = new JButton();
        btnAbrir.setIcon(new ImageIcon(getClass().getResource("/recursos/open.png")));
        btnGuardar = new JButton();
        btnGuardar.setIcon(new ImageIcon(getClass().getResource("/recursos/save.png")));
        btnImprimir = new JButton();
        btnImprimir.setIcon(new ImageIcon(getClass().getResource("/recursos/new.png")));
        btnCopiar = new JButton("Copiar");
        btnCopiar.setIcon(new ImageIcon(getClass().getResource("/recursos/copy.png")));
        btnCopiar2 = new JButton();
        btnCopiar2.setIcon(new ImageIcon(getClass().getResource("/recursos/copy.png")));
        btnCortar2 = new JButton();
        btnCortar2.setIcon(new ImageIcon(getClass().getResource("/recursos/cut.png")));
        btnCortar = new JButton("Cortar");
        btnCortar.setIcon(new ImageIcon(getClass().getResource("/recursos/cut.png")));
        btnPegar = new JButton("Pegar");
        btnPegar.setIcon(new ImageIcon(getClass().getResource("/recursos/paste.png")));
        btnPegar2 = new JButton();
        btnPegar2.setIcon(new ImageIcon(getClass().getResource("/recursos/paste.png")));
        btnBold = new JButton();
        btnBold.setIcon(new ImageIcon(getClass().getResource("/recursos/bold.png")));
        panelCentro = new JPanel();
        panelSuperior = new JPanel();
        labelLetra = new JLabel("Tipo de Letra");
        labelTamanio = new JLabel("Tamaño de Letra");
        textArea = new JTextArea();
        
    }
    private void configurarMenu() {
        barraMenu.add(menuArchivo);
        menuArchivo.add(menuItemNuevo);
        menuArchivo.add(menuItemAbrir);
        menuArchivo.add(menuItemCerrar);
        menuArchivo.add(menuItemGuardar);
        menuArchivo.add(menuItemGuardarComo);
        menuArchivo.addSeparator();
        menuArchivo.add(menuItemImprimir);
        barraMenu.add(menuEdicion);
        menuEdicion.add(menuItemCopiar);
        menuEdicion.add(menuItemCortar);
        menuEdicion.add(menuItemPegar);
        menuEdicion.addSeparator();
        menuEdicion.add(menuEstiloFuente);
        menuEstiloFuente.add(menuItemNormal);
        menuEstiloFuente.add(menuItemBold);
        menuEstiloFuente.add(menuItemCursiva);
        this.setJMenuBar(barraMenu);
    }
    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(configurarSuperior(),BorderLayout.NORTH);
        this.add(textArea,BorderLayout.CENTER);
    }
    private JPanel configurarSuperior()  {
        panelSuperior.setLayout(new GridBagLayout());
        configurarGridBag(0,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,btnNuevo);
        configurarGridBag(1,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,btnAbrir);
        configurarGridBag(2,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,btnGuardar);
        configurarGridBag(3,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,btnImprimir);
        configurarGridBag(4,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,btnCopiar2);
        configurarGridBag(5,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,btnCortar2);
        configurarGridBag(6,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,btnPegar2);
        configurarGridBag(7,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,btnBold);
        configurarGridBag(8,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,labelLetra);
        configurarGridBag(9,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,comboLetra);
        configurarGridBag(10,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,labelTamanio);
        configurarGridBag(11,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,comboTamanio);
        return panelSuperior;
    }
    private void rellenarTamanio() {
        for (int i = 8; i <= 100; i++) {
            modeloTamanio.addElement(i);
        }
    }
    private void rellenarLetras() {
        Font[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAllFonts();

        for (Font item : fuentes) {

            modeloLetra.addElement(item.getName());
        }
    }
    private void configurarGridBag(int pX, int pY, int tX, int tY,double peX, double peY, int anc,
                                   int fill, JComponent component) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = pX;
        constraints.gridy = pY;
        constraints.gridwidth = tX;
        constraints.gridheight = tY;
        constraints.weightx = peX;
        constraints.weighty = peY;
        constraints.fill = fill;
        constraints.anchor = anc;
        panelSuperior.add(component,constraints);
    }
    private void acciones() {
        comboLetra.addItemListener(this);
        comboTamanio.addItemListener(this);
        btnNuevo.addActionListener(this);
        menuItemNuevo.addActionListener(this);
        menuItemGuardar.addActionListener(this);
        btnGuardar.addActionListener(this);
        btnAbrir.addActionListener(this);
        menuItemAbrir.addActionListener(this);
        menuItemCerrar.addActionListener(this);
        btnBold.addActionListener(this);
        menuItemNormal.addActionListener(this);
        menuItemBold.addActionListener(this);
        btnCortar.addActionListener(this);
        btnCopiar.addActionListener(this);
        btnPegar.addActionListener(this);
    }
    private void cambiarLetras() {
        Font fuente = new Font((String) modeloLetra.getSelectedItem(),
                comboTamanio.getSelectedIndex(),
                (int) modeloTamanio.getSelectedItem());
            textArea.setFont(fuente);
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == comboLetra) {
            cambiarLetras();
        } else if (e.getSource() == comboTamanio) {
            cambiarLetras();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItemAbrir) {
            fileChooser.showOpenDialog(this);
        }else if (e.getSource()==btnAbrir) {
            fileChooser.showOpenDialog(this);
        }else if (e.getSource()==btnGuardar) {
            fileChooser.showSaveDialog(this);
        }else if (e.getSource()==menuItemGuardar){
            fileChooser.showSaveDialog(this);
        }else if (e.getSource()==menuItemNuevo){
            textArea.setText("");
        }else if (e.getSource()==btnNuevo){
            textArea.setText("");
        }else if (e.getSource()==menuItemCerrar){
            setVisible(false);
        }else if (e.getSource()==btnBold) {
            Font negrita = new Font((String) modeloLetra.getSelectedItem(), Font.BOLD, (int) modeloTamanio.getSelectedItem());
            textArea.setFont(negrita);
        }else if (e.getSource()==menuItemBold) {
            Font negrita = new Font((String) modeloLetra.getSelectedItem(), Font.BOLD, (int) modeloTamanio.getSelectedItem());
            textArea.setFont(negrita);
        }else if (e.getSource()==btnCopiar){
            textArea.getSelectedText();
        }else if (e.getSource()==btnPegar){
            textArea.getSelectedText();
        }else if (e.getSource()==btnCortar){
             textArea.getSelectedText();
             textArea.setText("");
        }else if (e.getSource()==menuItemGuardarComo){
            fileChooser.showSaveDialog(this);
        }else if (e.getSource()==menuItemNormal){
            Font normal = new Font((String) modeloLetra.getSelectedItem(),Font.PLAIN ,(int) modeloTamanio.getSelectedItem());
            textArea.setFont(normal);
        }else if (e.getSource()== menuItemCursiva){
            Font normal = new Font((String) modeloLetra.getSelectedItem(),Font.ITALIC ,(int) modeloTamanio.getSelectedItem());
            textArea.setFont(normal);
        }
    }
}