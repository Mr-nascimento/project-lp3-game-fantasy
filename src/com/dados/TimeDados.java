package com.dados;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.cartola.classes.Time;

public class TimeDados {
    private File Dados;
    private Scanner scan;
    private List<Time> times;

    public TimeDados() throws FileNotFoundException {
        Dados = new File("dados/Time.txt");
        scan = new Scanner(Dados);
        times = this.ListTime();

    }

    public List<Time> ListTime() {
        List<Time> team = new ArrayList<>();
        String linha;
        String[] parts;
        Time temp;

        while (scan.hasNext()) {
            linha = scan.nextLine();
            parts = linha.split("\t");
            temp = new Time(Integer.parseInt(parts[0]), parts[1], parts[2]);
            team.add(temp);
        }


        return team;
    }

    public boolean existTime(int id){
        for (Time team : times) {
            if(team.getId()==id)
                return true;
        }
        return false;
    }
    public Time buscTime(int id){
        for (Time team : times) {
            if(team.getId()==id)
                return team;
        }
        return null;
    }

    public List<Time> getTimes() {
        return times;
    }
    public void setTimes(List<Time> teams) {
        this.times = times;
    }
}
