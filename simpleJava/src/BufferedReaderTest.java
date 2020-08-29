import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Tethamo_zzx
 */

public class BufferedReaderTest {
    public static void main(String[] args) /*throws IOException*/ {//如果不用try catch的话，可以在此处throws IOException
        /**
         * BufferedReader应用实例：
         */
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            String string = input.readLine();
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
