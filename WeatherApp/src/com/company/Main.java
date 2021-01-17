package com.company;

import com.company.Observation;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            File input = new File("input.txt");
            Scanner sc = new Scanner(input);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] params = line.split("\\s+");
                Query q = new Query(params);
                Client c = new Client(q.name);
                Observation o = new Observation(c.getResponse());
                o.PrintInteresting();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
