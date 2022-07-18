package com.dados;

import com.cartola.classes.Time;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PontsDados {
    private File Dados;
    private Scanner scan;
    private List<String> mercad;

    public PontsDados() throws FileNotFoundException {
        Dados = new File("dados/Mercado.txt");
        scan = new Scanner(Dados);
    }

    public List<String> regPrecos() {
        List<String> merc = new ArrayList<>();
        String linha;

        while (scan.hasNext()) {
            linha = scan.nextLine();
            merc.add(linha);
        }
        return merc;
    }

    public boolean existString(int id){
        for (String merc : mercad) {
            if(Integer.parseInt(merc.split("\t")[0])==id)
                return true;
        }
        return false;
    }
    public String buscString(int id){
        for (String merc : mercad) {
            if(Integer.parseInt(merc.split("\t")[0])==id)
                return merc;
        }
        return null;
    }

    public void rescPont(int id, int pre, int pont) throws IOException {
        OutputStream os = new FileOutputStream("dados/temp.txt"); // nome do arquivo que será escrito
        Writer wr = new OutputStreamWriter(os); // criação de um escritor
        BufferedWriter br = new BufferedWriter(wr); // adiciono a um escritor de buffer

        br.write(String.valueOf(id)+"\t"+String.valueOf(pont)+"\t"+String.valueOf(pre));
        br.newLine();
        br.close();


        File temp = new File("dados/temp.txt");
        Dados.renameTo(temp);
        temp = new File("dados/Mercado.txt");
        temp.delete();


    }

    public List<String> getStrings() {
        return mercad;
    }
    public void setStrings(List<String> teams) {
        this.mercad = mercad;
    }
}
