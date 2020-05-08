import java.io.*;
public class Task {
    public static void main(String[] args) {
        int lineNumber = 0;
        int lineNumber2 = 0;
        String s;
        try (BufferedReader br =
                     new BufferedReader( new FileReader("test.txt"))) {
            while ((s = br.readLine()) != null){
                System.out.println("Текст из файла: " + s);
            }
        } catch (IOException exc) {
            System.out.println("Ошибка ввода-вывода: " +exc);
        }
        try{
            File myFile =new File("test.txt");
            FileReader fileReader = new FileReader(myFile);
            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

            while (lineNumberReader.readLine() != null){
                lineNumber++;
            }

            System.out.println("Количество строк до перезаписи файла: " + lineNumber);

            lineNumberReader.close();

        }catch(IOException e){
            e.printStackTrace();
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
        try{

            File myFile2 =new File("test.txt");
            FileReader fileReader2 = new FileReader(myFile2);
            LineNumberReader lineNumberReader2 = new LineNumberReader(fileReader2);

            while (lineNumberReader2.readLine() != null){
                lineNumber2++;
            }

            System.out.println("Количество строк после перезаписи файла: " + lineNumber2);

            lineNumberReader2.close();


        }catch(IOException e){
            e.printStackTrace();
        }
        if (lineNumber==lineNumber2){
            System.out.println("Количество строк совпадает!");
        } else {
            System.out.println("Количество строк не совпадает!");
        }
    }
}
