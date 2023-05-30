package cse.java2.project.controller;

import com.alibaba.fastjson.JSON;
import cse.java2.project.entity.Question;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
  public static List<Question> questions = new ArrayList<>();
  static Connection conn = null;

  public static void main(String[] args) {
    // 加载驱动
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    // 连接到数据库
    String url = "jdbc:postgresql://localhost:5432/cs307";
    String username = "checker";
    String password = "123456";
    try {
      conn = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    try {
      String jsonStrings = Files.readString(Path.of("D:\\Project\\java2finalproject(1)\\questions1.json"));
      questions = JSON.parseArray(jsonStrings, Question.class);
      //replies.forEach(System.out::println);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    ExecutorService executor = Executors.newFixedThreadPool(6); // 创建一个固定大小为4的线程池
    long startTime = System.currentTimeMillis();
    long endTime = System.currentTimeMillis(); // 获取结束时间
    long elapsedTime = endTime - startTime; // 计算运行时间
    System.out.println("runningTime:" + elapsedTime + "ms");
    executor.shutdown(); // 关闭线程池
  }


}