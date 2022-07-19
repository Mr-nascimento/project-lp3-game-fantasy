package com.dados;

import com.cartola.classes.Jogador;
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

    public void editPont(int id, double pre, double pont, int modo) throws IOException {
        try {
            boolean str = true;
            String linha = id+"\t"+ pont+"\t"+pre+"\n";
            switch (modo){
                case 1:
                    str = false;
                    break;
                case 2:
                    linha = id+"\t"+ pont+"\t"+pre;
                    break;
                case 3:
                    break;
                default:
                    System.out.println("ERRO!!");
                    break;
            }
            File file = new File("dados/Mercado.txt");
            // Verifica se o arquivo existe
            // Se não existir será criado.
            if (!file.exists()) {
                file.createNewFile();
            }

            // Segundo parâmetro da Classe FileWriter(String, boolean)
            // define se é para adicionar conteúdo ao final do arquivo (true)
            // senão sobrescreve td o conteudo
            FileWriter fileWritter = new FileWriter(file.getPath(), str);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(linha);
            bufferWritter.flush();
            bufferWritter.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void editPont(List<Jogador> jog) throws IOException {
        for (int i=0;i<jog.size();i++) {
            if(i==0) //primeira linha
                editPont(jog.get(i).getId(), jog.get(i).getPreco(), jog.get(i).getPontuacao(), 1);
            else if(i==jog.size()-1) //ultima linha
                editPont(jog.get(i).getId(), jog.get(i).getPreco(), jog.get(i).getPontuacao(), 2);
            else //default
                editPont(jog.get(i).getId(), jog.get(i).getPreco(), jog.get(i).getPontuacao(), 3);
        }
    }

    public List<String> getStrings() {
        return mercad;
    }
    public void setStrings(List<String> teams) {
        this.mercad = mercad;
    }
}
