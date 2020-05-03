import java.io.*;
public class Task {
    public static void main(String[] args) {
        String s;
        try (BufferedReader br =
                     new BufferedReader( new FileReader("test.txt"))) {
            while ((s = br.readLine()) != null){
                System.out.println("Текст из файла: " + s);
            }
        } catch (IOException exc) {
            System.out.println("Ошибка ввода-вывода: " +exc);
        }
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Признак конца ввода - сторка 'stop'");;
        try(FileWriter fw = new FileWriter("test.txt")){
            do {
                System.out.print(": ");
                str = br.readLine();

                if (str.compareTo("stop") == 0) break;

                str = str + "\r\n";
                fw.write(str);
            } while(str.compareTo("stop") != 0);
        } catch (IOException exc) {
            System.out.println("Ошибка ввода-вывода: " +exc);
        }
    }
}
