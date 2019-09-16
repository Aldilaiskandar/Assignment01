import com.enigma.model.Directions;
import com.enigma.model.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in) );
        System.out.print("Masukan koordinat awal x,y : ");
        String coordinate = reader.readLine();
        String[] post = coordinate.split(",");
        Integer ada = 0;
        System.out.print("Masukan arah awal : ");
        String DIR = reader.readLine();
        String arah = DIR.toUpperCase();

            Robot jarvis = new Robot(Integer.parseInt(post[0]), Integer.parseInt(post[1]), Directions.valueOf(DIR.toUpperCase()));

            System.out.print("Masukan Isi Battery : ");
            String masukFuel = reader.readLine();
            Integer isiFuel = Integer.parseInt(masukFuel);
            jarvis.fillFuel(isiFuel);
            System.out.print("masukan perintah :");
            String masukCommands = reader.readLine();
            jarvis.setCommands(masukCommands);
            jarvis.run();
            System.out.println(jarvis.print());
        }
}
