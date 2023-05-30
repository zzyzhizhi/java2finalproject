package cse.java2.project.controller;

import cse.java2.project.entity.Question;
import cse.java2.project.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.zip.GZIPInputStream;

public class JsonDownloader {

  public static void main(String[] args) {
    String fileName = null;
    String fileName1 = "D:\\Project\\java2finalproject(1)\\questions1.json";
    String fileName2 = "D:\\Project\\java2finalproject(1)\\questions2.json";
    String fileName3 = "D:\\Project\\java2finalproject(1)\\questions3.json";
    String fileName4 = "D:\\Project\\java2finalproject(1)\\questions4.json";
    String fileName5 = "D:\\Project\\java2finalproject(1)\\questions5.json";

    for (int i = 1; i <= 5; i++) {
      StringBuilder sb = new StringBuilder();
      String url = "https://api.stackexchange.com/2.3/questions?page=" + i + "&pagesize=100&order=desc&sort=activity&tagged=java&site=stackoverflow&&filter=!22jPRAJ-X*z0Ql.gqcYc(";

      try (BufferedReader in = new BufferedReader(new InputStreamReader(new GZIPInputStream(new URL(url).openStream()), StandardCharsets.UTF_8))) {
        String line;
        while ((line = in.readLine()) != null) {
          sb.append(line);
          sb.append("\n");
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      if (i==1) fileName = fileName1;
      if (i==2) fileName = fileName2;
      if (i==3) fileName = fileName3;
      if (i==4) fileName = fileName4;
      if (i==5) fileName = fileName5;
      try (FileWriter writer = new FileWriter(fileName, StandardCharsets.UTF_8)) {
        writer.write(sb.toString());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}

