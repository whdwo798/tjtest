package test;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test7 {
    public static void main(String[] args) throws IOException {
        FileOutputStream output = new FileOutputStream("out.txt");
        for (int i = 1; i < 11 ; i++) {
            String data = i + "번쨰 줄입니다.\r\n";
            output.write(data.getBytes());
        }
        output.close();
    }
}
