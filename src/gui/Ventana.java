package gui;

import Almacenar.Almacenar;
import TDA.Graficas;
import TDA.Preguntas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Ventana extends JFrame implements ActionListener {

    private JButton sig, ant, res, ev, grafica;
    private Graficas graf;
    private JLabel etq1, etq2, etqImg;
    private ImageIcon img;
    private JRadioButton a, b, c, d;
    private ButtonGroup gRBtn;
    private Almacenar array;
    private Preguntas preg;
    private int i = 0, resp = 0, cont = 0;
    private int[] arrRes = {1, 2, 3, 3, 1, 3, 1, 2, 1, 2};
    private int[] corr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public Ventana() {
        array = new Almacenar();
        preg = new Preguntas();
        setTitle("Cuestionario");
        inicio();
        setBounds(100, 50, 800, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void inicio() {
        llenarArray("¿Que componente contenedor es mas adecuado para organizar los componentes en una cuadricula?", "JPanel", "JPanel", "JFrame", "JTable", "JSrollPane", "src/Imagenes/JPanel.png");
        llenarArray("¿Que componente contenedor se utiliza para organizar los componentes en varias pestañas?", "JTabbedPane", "JPanel", "JTabbedPane", "JScrollPane", "JList", "src/Imagenes/JTabbedPane.png");
        llenarArray("¿Que metodo se utiliza para inicializar un Applet en Java", "init()", "start()", "paint()", "init()", "stop()", "src/Imagenes/applet.jpg");
        llenarArray("¿Cuál es el método que se utiliza para pintar un Applet en la pantalla?", "paint()", "init()", "start()", "paint()", "stop()", "src/Imagenes/pait.png");
        llenarArray("¿Que evento se dispara cuadno el usuario presiona una tecla mientras el applet tiene el foco?", "keyPressed()", "keyPressed()", "keyReleased()", "keyTyped()", "KeyClicked()", "src/Imagenes/teclado.jpg");
        llenarArray("Es una ventana secundaria que se utiliza para mostrar informacion adicional", "JDialog", "JFrame", "JInternalFrame", "JDialog", "JApplet", "src/Imagenes/JDialog.jpg");
        llenarArray("JDialog  son  ventanas  modales,  lo  que  significa  que  el  usuario  no  puede interactuar con la ventana principal hasta que se cierre el dialogo.", "Verdadero", "Verdadero", "Falso", "", "", "src/Imagenes/JdialogVer.jpg");
        llenarArray("AWT en una clase mas moderna que java Swing", "Falso", "Verdadero", "Falso", "", "", "src/Imagenes/AWT.jpg");
        llenarArray("La generacion de metodos consta de auditores y fuentes", "Verdadero", "Verdadero", "Falso", "", "", "src/Imagenes/Metodo.png");
        llenarArray("En la generacion de metodos solo debe de haber una fuente", "Falso", "Verdadero", "Falso", "", "", "src/Imagenes/fuente.png");

        etq1 = new JLabel((i + 1) + ") " + array.devPregunta(0));
        etq1.setBounds(20, 20, 750, 15);
        add(etq1);

        a = new JRadioButton(array.devA(0));
        a.setBounds(20, 50, 120, 15);
        a.addActionListener(this);
        add(a);

        b = new JRadioButton(array.devB(0));
        b.setBounds(20, 70, 120, 15);
        b.addActionListener(this);
        add(b);

        c = new JRadioButton(array.devC(0));
        c.setBounds(20, 90, 120, 15);
        c.addActionListener(this);
        add(c);

        d = new JRadioButton(array.devD(0));
        d.setBounds(20, 110, 120, 15);
        d.addActionListener(this);
        add(d);

        gRBtn = new ButtonGroup();
        gRBtn.add(a);
        gRBtn.add(b);
        gRBtn.add(c);
        gRBtn.add(d);

        img = new ImageIcon(array.devRuta(0));

        etqImg = new JLabel();
        etqImg.setBounds(150, 100, 540, 370);
        etqImg.setIcon(img);
        add(etqImg);

        ant = new JButton("Anterior");
        ant.setBounds(50, 500, 90, 40);
        ant.addActionListener(this);
        add(ant);

        sig = new JButton("Siguiente");
        sig.setBounds(650, 500, 90, 40);
        sig.addActionListener(this);
        add(sig);

        res = new JButton("Responder");
        res.setBounds(340, 500, 100, 40);
        res.addActionListener(this);
        add(res);

        ev = new JButton("Evaluar");
        ev.setBounds(650, 500, 90, 40);
        ev.addActionListener(this);
        add(ev);

        etq2 = new JLabel("");
        etq2.setBounds(350, 450, 300, 40);
        add(etq2);

        if (i == 0) {
            ant.setEnabled(false);
        } else {
            ant.setEnabled(true);
        }
    }

    public void llenarArray(String pregun, String resp, String ax, String bx, String cx, String dx, String route) {
        preg = new Preguntas(pregun, resp, ax, bx, cx, dx, route);
        array.añadirPreg(preg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sig) {

            i++;
            etq1.setText((i + 1) + ") " + array.devPregunta(i));
            a.setText(array.devA(i));
            b.setText(array.devB(i));
            c.setText(array.devC(i));
            d.setText(array.devD(i));

            img = new ImageIcon(array.devRuta(i));
            etqImg.setIcon(img);

            etq2.setText(" ");
            gRBtn.clearSelection();

            if (array.devC(i) == "" && array.devD(i) == "") {
                c.setVisible(false);
                d.setVisible(false);
            } else {
                c.setVisible(true);
                d.setVisible(true);
            }

            if (i == 9) {
                sig.setEnabled(false);
                sig.setVisible(false);
                ev.setVisible(true);
            }

            if (i == 0) {
                ant.setEnabled(false);
            } else {
                ant.setEnabled(true);
            }

            //System.out.println("Si");
        }

        if (e.getSource() == ant) {
            i--;

            etq1.setText((i + 1) + ") " + array.devPregunta(i));
            a.setText(array.devA(i));
            b.setText(array.devB(i));
            c.setText(array.devC(i));
            d.setText(array.devD(i));
            sig.setVisible(true);
            ev.setVisible(false);
            sig.setEnabled(true);

            img = new ImageIcon(array.devRuta(i));
            etqImg.setIcon(img);

            etq2.setText(" ");
            gRBtn.clearSelection();

            if (array.devC(i) == "" && array.devD(i) == "") {
                c.setVisible(false);
                d.setVisible(false);
            } else {
                c.setVisible(true);
                d.setVisible(true);
            }

            if (i == 0) {
                ant.setEnabled(false);
            } else {
                ant.setEnabled(true);
            }

            //System.out.println("Non");
        }

        if (e.getSource() == a) {
            resp = 1;
        }
        if (e.getSource() == b) {
            resp = 2;
        }
        if (e.getSource() == c) {
            resp = 3;
        }
        if (e.getSource() == d) {
            resp = 4;
        }

        if (e.getSource() == res) {
            if (resp == arrRes[i]) {
                etq2.setText("¡Respuesta correcta!");
                corr[i] = 1;
            } else {
                etq2.setText("Respuesta incorrecta, intentelo de nuevo");
            }
        }

        if (e.getSource() == ev) {
            for (i = 0; i <= 9; i++) {
                cont += corr[i];
            }
            JOptionPane.showMessageDialog(null, "El usuario obtuvo " + cont + " respuestas correctas");
            
            ev.setEnabled(false);
            ev.setVisible(false);
            
            grafica = new JButton("Mostrar Grafica");
            grafica.setBounds(600, 500, 140, 40);
            grafica.addActionListener(this);
            add(grafica);
        }
        
        if(e.getSource() == grafica){
            graf = new Graficas();
            
            graf.graficaBarras3D(graf.grafEval(cont, (10-cont)));
        }

    }

}
