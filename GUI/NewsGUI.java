package GUI;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsGUI extends JFrame {
    public NewsGUI(ArrayList<String> noticias, String tituloPagina) {
        //configurarLookAndFeel();
        // Configurar la ventana
        setTitle("Noticias - " + tituloPagina);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450);
        setResizable(false);

        JPanel panelPrincipal = crearPanelPrincipal(tituloPagina);
        JPanel panelNoticias = crearPanelNoticias(noticias);

        panelPrincipal.add(new JScrollPane(panelNoticias), BorderLayout.CENTER);

        add(panelPrincipal);
        setVisible(true);
    }

    /**
     * Configura el Look and Feel de la aplicación para Nimbus: Opcional
     */
    private void configurarLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private JPanel crearPanelPrincipal(String tituloPagina) {
        JPanel panelCabecera = crearPanelCabecera(tituloPagina);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelCabecera, BorderLayout.NORTH);

        return panelPrincipal;
    }

    private JPanel crearPanelCabecera(String tituloPagina) {
        JPanel panelCabecera = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelCabecera = new JLabel(tituloPagina);
        labelCabecera.setFont(new Font("Roboto", Font.BOLD, 18));

        ImageIcon iconoLogo = getLogo(50, 150);
        if (iconoLogo != null) {
            JLabel labelLogo = new JLabel(iconoLogo);
            panelCabecera.add(labelLogo);
        }

        panelCabecera.add(labelCabecera);
        return panelCabecera;
    }

    private JPanel crearPanelNoticias(ArrayList<String> noticias) {
        JPanel panelNoticias = new JPanel();
        panelNoticias.setLayout(new BoxLayout(panelNoticias, BoxLayout.Y_AXIS));

        for (String noticia : noticias) {
            JPanel panelTituloNoticia = crearPanelTituloNoticia(noticia);
            panelNoticias.add(panelTituloNoticia);
            panelNoticias.add(Box.createRigidArea(new Dimension(5, 15)));
        }

        return panelNoticias;
    }

    private JPanel crearPanelTituloNoticia(String noticia) {
        String titulo = extraerTituloNoticia(noticia);

        JPanel panelTituloNoticia = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTituloNoticia.setBackground(new Color(222, 222, 216));
        panelTituloNoticia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JLabel labelTituloNoticia = new JLabel(titulo);
        configurarEstiloLabelTitulo(labelTituloNoticia, noticia);

        panelTituloNoticia.add(labelTituloNoticia);
        return panelTituloNoticia;
    }

    private void configurarEstiloLabelTitulo(JLabel labelTituloNoticia, String noticia) {
        labelTituloNoticia.setForeground(Color.BLACK);
        labelTituloNoticia.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelTituloNoticia.setFont(new Font("Roboto", Font.BOLD, 14));
        labelTituloNoticia.addMouseListener(new NoticiaMouseListener(noticia));
    }

    ImageIcon getLogo(int h, int w) {
        URL urlLogo = getClass().getResource("/logo.png");
        try {
            ImageIcon originalIcon = new ImageIcon(urlLogo);
            Image resizedImage = originalIcon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String extraerTituloNoticia(String noticia) {
        // Se considera título todo lo que está antes del primer punto de la noticia
        String regex = "^(.*?\\.)";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(noticia);

        // Extraer el resultado si hay una coincidencia
        if (matcher.find()) {
            return matcher.group(1).trim();
        }

        // Si no hay coincidencia, devolver toda la primera línea (o toda la noticia si no hay línea)
        String[] lineas = noticia.split("\n");
        return lineas.length > 0 ? lineas[0].trim() : noticia.trim();
    }

    private class NoticiaMouseListener extends MouseAdapter {
        private String noticia;

        public NoticiaMouseListener(String noticia) {
            this.noticia = noticia;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // Abrir una nueva ventana para mostrar la noticia completa
            JFrame ventanaNoticia = new JFrame("Noticia Completa");
            ventanaNoticia.setSize(400, 300);

            JTextArea textoNoticia = new JTextArea(noticia);
            textoNoticia.setLineWrap(true);
            textoNoticia.setWrapStyleWord(true);
            textoNoticia.setEditable(false);

            ventanaNoticia.add(new JScrollPane(textoNoticia));
            ventanaNoticia.setVisible(true);
        }
    }

}
