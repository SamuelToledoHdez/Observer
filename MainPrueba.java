import GUI.NewsGUI;
import java.util.ArrayList;

public class MainPrueba{
    public static void main(String[] args) {
        ArrayList<String> noticias = new ArrayList<>();
        noticias.add("Noticias deportivas. Tratan sobre sucesos vinculados con los distintos deportes que se practican en una comunidad, por lo general dando prioridad a los más populares. Por ejemplo:");
        noticias.add("Los Astros se ponen a una sola victoria del título tras vencer a Phillies en el quinto de la Serie Mundial . Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl quis aliquam ultricies, nunc nisl aliquet nunc, sit amet aliquam nisl nunc sit amet nisl. Sed euismod, nisl quis aliquam ultricies, nunc nisl aliquet nunc, sit amet aliquam nisl nunc sit amet nisl.");
        noticias.add("Rihanna hace llorar a sus seguidores con ‘Lift Me Up’, su primera canción en seis años (. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl quis aliquam ultricies, nunc nisl aliquet nunc, sit amet aliquam nisl nunc sit amet nisl. Sed euismod, nisl quis aliquam ultricies, nunc nisl aliquet nunc, sit amet aliquam nisl nunc sit amet nisl.");
        noticias.add("Dólar: cotización de apertura hoy 1 de noviembre en Chile . Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl quis aliquam ultricies, nunc nisl aliquet nunc, sit amet aliquam nisl nunc sit amet nisl. Sed euismod, nisl quis aliquam ultricies, nunc nisl aliquet nunc, sit amet aliquam nisl nunc sit amet nisl.");
        noticias.add("Tratan sobre sucesos vinculados con los distintos deportes que se practican en una comunidad. por lo general dando prioridad a los más populares. Por ejemplo:");
        noticias.add("Los Astros se ponen a una sola victoria del título tras vencer a Phillies en el quinto de la Serie Mundial. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl quis aliquam ultricies, nunc nisl aliquet nunc, sit amet aliquam nisl nunc sit amet nisl. Sed euismod, nisl quis aliquam ultricies, nunc nisl aliquet nunc, sit amet aliquam nisl nunc sit amet nisl.");
        noticias.add("Rihanna hace llorar a sus seguidores con ‘Lift Me Up’, su primera canción en seis años.");
        noticias.add("Dólar: cotización de apertura hoy 1 de noviembre en Chile (Infobae, 1° de noviembre de 2022).");
        noticias.add("Noticias deportivas. Tratan sobre sucesos vinculados con los distintos deportes que se practican en una comunidad, por lo general dando prioridad a los más populares. Por ejemplo:");
        noticias.add("Los Astros se ponen a una sola victoria del título tras vencer a Phillies en el quinto de la Serie Mundial . Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl quis aliquam ultricies, nunc nisl aliquet nunc, sit amet aliquam nisl nunc sit amet nisl. Sed euismod, nisl quis aliquam ultricies, nunc nisl aliquet nunc, sit amet aliquam nisl nunc sit amet nisl.");
        noticias.add("Rihanna hace llorar a sus seguidores con ‘Lift Me Up’, su primera canción en seis años . Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl quis aliquam ultricies, nunc nisl aliquet nunc, sit amet aliquam nisl nunc sit amet nisl. Sed euismod, nisl quis aliquam ultricies, nunc nisl aliquet nunc, sit amet aliquam nisl nunc sit amet nisl.");
        noticias.add("Dólar: cotización de apertura hoy 1 de noviembre en Chile (Infobae, 1° de noviembre de 2022). Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl quis aliquam ultricies, nunc nisl aliquet nunc, sit amet aliquam nisl nunc sit amet nisl. Sed euismod, nisl quis aliquam ultricies, nunc nisl aliquet nunc, sit amet aliquam nisl nunc sit amet nisl.");
        noticias.add("Tratan sobre sucesos vinculados con los distintos deportes que se practican en una comunidad. por lo general dando prioridad a los más populares. Por ejemplo:");
        noticias.add("Los Astros se ponen a una sola victoria del título tras vencer a Phillies en el quinto de la Serie Mundial. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl quis aliquam ultricies, nunc nisl aliquet nunc, sit amet aliquam nisl nunc sit amet nisl. Sed euismod, nisl quis aliquam ultricies, nunc nisl aliquet nunc, sit amet aliquam nisl nunc sit amet nisl.");
        noticias.add("Rihanna hace llorar a sus seguidores con ‘Lift Me Up’, su primera canción en seis años.");
        noticias.add("Dólar: cotización de apertura hoy 1 de noviembre en Chile (Infobae, 1° de noviembre de 2022).");

        String titulo = new String("Actualidad");
        NewsGUI gui = new NewsGUI(noticias, titulo);
    }
}