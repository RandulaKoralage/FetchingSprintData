package Controller;

import java.io.*;

public class DocumentPrinter {
    public void printDocument(String line, String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName + ".txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        out.println(line);
        bw.close();
    }
    public void printDocumentHeader(String header, String fileName) throws IOException {
        File file =new File(fileName + ".txt");
        if(file.length() ==0) {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println(header);
            bw.close();
        }
    }
}
