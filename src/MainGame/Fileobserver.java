package MainGame;

import java.io.FileWriter;
import java.io.IOException;

public class Fileobserver implements Observer {
    private int update_one;
    private int update_two;
    private FileWriter fileWriter;

    public Fileobserver() {
        update_one = update_two = 0;
        try {
            fileWriter = new FileWriter("score.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int x1, int x2) {
        if ((update_one != x1) || (update_two != x2)) {
            update_one = x1;
            update_two = x2;
            String result = "player one score" + update_one + " player two score" + update_two + " \n";
            try {
                fileWriter.write(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
