package pack;

import java.io.*;
import java.nio.file.Files;

public class MyClass {

    public static void main(String[] args) throws IOException {

        // Will work when start from working directory (when relative path exists)

        File newFile = new File("src/main/resources/myfile3.txt");
        System.out.println(Files.readString(newFile.toPath()));

        // Works when file inside jar (path is relative to the directory named as package for current class)
        InputStream in = MyClass.class.getResourceAsStream("myfile.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        System.out.println(reader.readLine());
        reader.close();

        // Works when file inside jar (path is relative to the Resources directory)
        InputStream in1 = MyClass.class.getResourceAsStream("/myfile1.txt");
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(in1));
        System.out.println(reader1.readLine());
        reader1.close();
    }
}
