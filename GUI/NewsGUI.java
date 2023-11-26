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
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setTitle("Noticias - " + tituloPagina);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450);
        setResizable(false);

        // Crear un panel principal con BorderLayout
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Agregar el panel de título con logo en la parte superior
        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelTitulo = new JLabel(tituloPagina);
        labelTitulo.setFont(new Font("Roboto", Font.BOLD, 18));
        panelTitulo.add(labelTitulo);

        // Agregar el logo al panel de título
        ImageIcon iconoLogo = getLogo(50, 150);
        if (iconoLogo != null) {
            JLabel labelLogo = new JLabel(iconoLogo);
            panelTitulo.add(labelLogo);
        }

        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);

        // Crear un panel para las noticias con JScrollPane
        JPanel panelNoticias = new JPanel();
        panelNoticias.setLayout(new BoxLayout(panelNoticias, BoxLayout.Y_AXIS));

        // Agregar solo los títulos al panel
        for (String noticia : noticias) {
            String titulo = extraerTituloNoticia(noticia);

            // Crear un panel personalizado para el título
            JPanel panelTituloNoticia = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panelTituloNoticia.setBackground(new Color(240, 240, 240)); // Color de fondo
            panelTituloNoticia.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); // Borde

            // Configurar el estilo de la etiqueta JLabel dentro del panel personalizado
            JLabel labelTituloNoticia = new JLabel(titulo);
            labelTituloNoticia.setForeground(Color.BLACK); // Cambiar el color del texto
            labelTituloNoticia.setFont(new Font("Roboto", Font.BOLD, 14)); // Cambiar la fuente y el tamaño

            // Agregar el MouseListener para abrir la ventana de la noticia completa
            labelTituloNoticia.addMouseListener(new NoticiaMouseListener(noticia));

            // Agregar la etiqueta al panel personalizado
            panelTituloNoticia.add(labelTituloNoticia);

            // Agregar el panel personalizado al panel de noticias
            panelNoticias.add(panelTituloNoticia);
            panelNoticias.add(Box.createRigidArea(new Dimension(5, 15))); // Espaciado entre títulos
        }

        // Agregar el panel de noticias al panel principal en el centro
        panelPrincipal.add(new JScrollPane(panelNoticias), BorderLayout.CENTER);

        // Agregar el panel principal a la ventana
        add(panelPrincipal);

        // Hacer visible la ventana
        setVisible(true);
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
        // Usar una expresión regular para encontrar el texto antes del primer punto en la primera línea
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
