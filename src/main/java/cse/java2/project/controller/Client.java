package cse.java2.project.controller;

import com.alibaba.fastjson.JSON;
import cse.java2.project.entity.Question;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
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
//    downLoadAccount();
//    downLoadPost();
//    executor.execute(() -> downLoadFollow());
//    executor.execute(() -> downLoadFavorite());
//    executor.execute(() -> downLoadShare());
//    executor.execute(() -> downLoadLike());
//    executor.execute(() -> downLoadCategory());
//    executor.execute(() -> downLoadReply());
//    downLoadSecondReply();
    long endTime = System.currentTimeMillis(); // 获取结束时间
    long elapsedTime = endTime - startTime; // 计算运行时间
    System.out.println("runningTime:"+elapsedTime+"ms");
    executor.shutdown(); // 关闭线程池
  }


//
//  public static void downLoadAccount() {
//    PreparedStatement stmt = null;
//    try {
//      String sql = "INSERT INTO account ( username,first_name,sec_name,register_time,identity_card,birth_time,phone) VALUES (?,?,?,?,?,?,?);";
//      stmt = conn.prepareStatement(sql);
//      // 执行查询操作
//      for (int i = 0; i < posts.size(); i++) {
//        String strDate = Client.posts.get(i).getAuthorRegistrationTime();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String strDate1 = Client.posts.get(i).getAuthorID().substring(6,14);
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
//        java.util.Date date = null;
//        java.util.Date date1 = null;
//        try {
//          date = sdf.parse(strDate);
//          date1 =sdf1.parse(strDate1);
//        } catch (ParseException e) {
//          e.printStackTrace();
//        }
//        long register_time = date.getTime();
//        long birth_time = date1.getTime();
//        stmt.setString(1,Client.posts.get(i).getAuthor());
//        stmt.setString(2,Client.posts.get(i).getAuthor().split("_")[0]);
//        stmt.setString(3,Client.posts.get(i).getAuthor().split("_")[1]);
//        stmt.setTimestamp(4,new Timestamp(register_time));
//        stmt.setString(5,Client.posts.get(i).getAuthorID());
//        stmt.setTimestamp(6,new Timestamp(birth_time));
//        stmt.setString(7,Client.posts.get(i).getAuthorPhone());
//        stmt.addBatch();
//        // System.out.println(new Timestamp(register_time));
//      }
//      stmt.executeBatch();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  public static void downLoadPost(){
//    PreparedStatement stmt = null;
//    try {
//      String sql = "INSERT INTO post ( title,post_content,post_time,loc_country,loc_city,post_author) VALUES (?,?,?,?,?,?);";
//      stmt = conn.prepareStatement(sql);
//      // 执行查询操作
//      for (int i = 0; i < posts.size(); i++) {
//        String strDate = Client.posts.get(i).getPostingTime();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = null;
//        try {
//          date = new java.sql.Date(sdf.parse(strDate).getTime());
//        } catch (ParseException e) {
//          e.printStackTrace();
//        }
//        long post_time = date.getTime();
//        stmt.setString(1,Client.posts.get(i).getTitle());
//        stmt.setString(2,Client.posts.get(i).getContent());
//        stmt.setTimestamp(3,new Timestamp(post_time));
//        stmt.setString(4,Client.posts.get(i).getPostingCity().split(",")[1]);
//        stmt.setString(5,Client.posts.get(i).getPostingCity().split(",")[0]);
//        stmt.setString(6,Client.posts.get(i).getAuthor());
//        stmt.addBatch();
//      }
//      stmt.executeBatch();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  public static void downLoadFollow(){
//    PreparedStatement stmt = null;
//    PreparedStatement stmt1 = null;
//    try {
//      String sql = "INSERT INTO follow (follower,followed) VALUES (?,?);";
//      stmt = conn.prepareStatement(sql);
//      // 执行查询操作
//      String sql1 = "insert into account (username,first_name,sec_name,register_time,identity_card,birth_time) values (?,?,?,?,?,?) on conflict (username) do nothing";
//      stmt1 = conn.prepareStatement(sql1);
//      for (int i = 0; i < posts.size(); i++) {
//        stmt.setString(1,Client.posts.get(i).getAuthor());
//        String s = Client.posts.get(i).getAuthorFollowedBy().toString();
//        s = s.substring(1,s.length()-1);
//        //stmt.setString(2,s);
//        //stmt.executeUpdate();
//        String[] str = s.split(",");
//        for (int j = 0; j < str.length; j++) {
//          stmt.setString(2,str[j]);
//          stmt1.setString(1,str[j]);
//          stmt1.setString(2,str[j].split("_")[0]);
//          stmt1.setString(3,str[j].split("_")[1]);
//          StringBuilder sb = new StringBuilder();
//          Random rand = new Random();
//          for (int k = 0; k < 6; k++) {
//            int n = rand.nextInt(10);
//            sb.append(n);
//          }
//          sb.append("197");
//          sb.append(rand.nextInt(10));
//          sb.append("0813");
//          for (int k = 0; k < 4; k++) {
//            int n = rand.nextInt(10);
//            sb.append(n);
//          }
//          stmt1.setString(5,sb.toString());
//          String birth = sb.substring(6,10)+"-"+sb.substring(10,12)+"-"+sb.substring(12,14);
//          String strDate = "199" +
//              rand.nextInt(10) +
//              "-08-13";
//          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//          SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//          Date date = null;
//          Date date1 = null;
//          try {
//            date = new java.sql.Date(sdf.parse(strDate).getTime());
//            date1 = new java.sql.Date(sdf1.parse(birth).getTime());
//          } catch (ParseException e) {
//            e.printStackTrace();
//          }
//          long register_time = date.getTime();
//          long birth_time = date1.getTime();
//          stmt1.setTimestamp(4, new Timestamp(register_time));
//          stmt1.setTimestamp(6,new Timestamp(birth_time));
//          stmt1.addBatch();
//          stmt.addBatch();
//        }
//      }
//      stmt1.executeBatch();
//      stmt.executeBatch();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  public static void downLoadFavorite(){
//    PreparedStatement stmt = null;
//    PreparedStatement stmt1 = null;
//    try {
//      String sql = "INSERT INTO favorite (post_id,account_name) VALUES (?,?);";
//      stmt = conn.prepareStatement(sql);
//      // 执行查询操作
//      String sql1 = "insert into account (username,first_name,sec_name,register_time,identity_card,birth_time) values (?,?,?,?,?,?) on conflict (username) do nothing";
//      stmt1 = conn.prepareStatement(sql1);
//      for (int i = 0; i < posts.size(); i++) {
//        stmt.setInt(1,Client.posts.get(i).getPostID());
//        String s = Client.posts.get(i).getAuthorFavorite().toString();
//        s = s.substring(1,s.length()-1);
//        //stmt.executeUpdate();
//        String[] str = s.split(",");
//        for (int j = 0; j < str.length; j++) {
//          stmt.setString(2,str[j]);
//          stmt1.setString(1,str[j]);
//          stmt1.setString(2,str[j].split("_")[0]);
//          if (str[j].split("_").length>=2)
//            stmt1.setString(3,str[j].split("_")[1]);
//          else stmt1.setString(3,null);
//          StringBuilder sb = new StringBuilder();
//          Random rand = new Random();
//          for (int k = 0; k < 6; k++) {
//            int n = rand.nextInt(10);
//            sb.append(n);
//          }
//          sb.append("197");
//          sb.append(rand.nextInt(10));
//          sb.append("0813");
//          for (int k = 0; k < 4; k++) {
//            int n = rand.nextInt(10);
//            sb.append(n);
//          }
//          stmt1.setString(5,sb.toString());
//          String birth = sb.substring(6,10)+"-"+sb.substring(10,12)+"-"+sb.substring(12,14);
//          String strDate = "199" +
//              rand.nextInt(10) +
//              "-08-13";
//          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//          SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//          Date date = null;
//          Date date1 = null;
//          try {
//            date = new java.sql.Date(sdf.parse(strDate).getTime());
//            date1 = new java.sql.Date(sdf1.parse(birth).getTime());
//          } catch (ParseException e) {
//            e.printStackTrace();
//          }
//          long register_time = date.getTime();
//          long birth_time = date1.getTime();
//          stmt1.setTimestamp(4, new Timestamp(register_time));
//          stmt1.setTimestamp(6,new Timestamp(birth_time));
//          stmt1.addBatch();
//          stmt.addBatch();
//        }
//      }
//      stmt1.executeBatch();
//      stmt.executeBatch();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  public static void downLoadShare(){
//    PreparedStatement stmt = null;
//    PreparedStatement stmt1 = null;
//    try {
//      String sql = "INSERT INTO share (post_id,account_name) VALUES (?,?);";
//      stmt = conn.prepareStatement(sql);
//      // 执行查询操作
//      String sql1 = "insert into account (username,first_name,sec_name,register_time,identity_card,birth_time) values (?,?,?,?,?,?) on conflict (username) do nothing";
//      stmt1 = conn.prepareStatement(sql1);
//      for (int i = 0; i < posts.size(); i++) {
//        stmt.setInt(1,Client.posts.get(i).getPostID());
//        String s = Client.posts.get(i).getAuthorShared().toString();
//        s = s.substring(1,s.length()-1);
//
//        //stmt.executeUpdate();
//        String[] str = s.split(",");
//        for (int j = 0; j < str.length; j++) {
//          stmt.setString(2,str[j]);
//          stmt1.setString(1,str[j]);
//          stmt1.setString(2,str[j].split("_")[0]);
//          if (str[j].split("_").length>=2)
//            stmt1.setString(3,str[j].split("_")[1]);
//          else stmt1.setString(3,null);
//          StringBuilder sb = new StringBuilder();
//          Random rand = new Random();
//          for (int k = 0; k < 6; k++) {
//            int n = rand.nextInt(10);
//            sb.append(n);
//          }
//          sb.append("197");
//          sb.append(rand.nextInt(10));
//          sb.append("0813");
//          for (int k = 0; k < 4; k++) {
//            int n = rand.nextInt(10);
//            sb.append(n);
//          }
//          stmt1.setString(5,sb.toString());
//          String birth = sb.substring(6,10)+"-"+sb.substring(10,12)+"-"+sb.substring(12,14);
//          String strDate = "199" +
//              rand.nextInt(10) +
//              "-08-13";
//          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//          SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//          Date date = null;
//          Date date1 = null;
//          try {
//            date = new java.sql.Date(sdf.parse(strDate).getTime());
//            date1 = new java.sql.Date(sdf1.parse(birth).getTime());
//          } catch (ParseException e) {
//            e.printStackTrace();
//          }
//          long register_time = date.getTime();
//          long birth_time = date1.getTime();
//          stmt1.setTimestamp(4, new Timestamp(register_time));
//          stmt1.setTimestamp(6,new Timestamp(birth_time));
//          stmt1.addBatch();
//          stmt.addBatch();
//        }
//      }
//      stmt1.executeBatch();
//      stmt.executeBatch();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  public static void downLoadLike(){
//    PreparedStatement stmt = null;
//    PreparedStatement stmt1 = null;
//    try {
//      String sql = "INSERT INTO give_like (post_id,account_name) VALUES (?,?);";
//      stmt = conn.prepareStatement(sql);
//      // 执行查询操作
//      String sql1 = "insert into account (username,first_name,sec_name,register_time,identity_card,birth_time) values (?,?,?,?,?,?) on conflict (username) do nothing";
//      stmt1 = conn.prepareStatement(sql1);
//      for (int i = 0; i < posts.size(); i++) {
//        stmt.setInt(1,Client.posts.get(i).getPostID());
//        String s = Client.posts.get(i).getAuthorLiked().toString();
//        s = s.substring(1,s.length()-1);
//        //stmt.executeUpdate();
//        String[] str = s.split(",");
//        for (int j = 0; j < str.length; j++) {
//          stmt.setString(2,str[j]);
//          stmt1.setString(1,str[j]);
//          stmt1.setString(2,str[j].split("_")[0]);
//          if (str[j].split("_").length>=2)
//            stmt1.setString(3,str[j].split("_")[1]);
//          else stmt1.setString(3,null);
//          StringBuilder sb = new StringBuilder();
//          Random rand = new Random();
//          for (int k = 0; k < 6; k++) {
//            int n = rand.nextInt(10);
//            sb.append(n);
//          }
//          sb.append("197");
//          sb.append(rand.nextInt(10));
//          sb.append("0813");
//          for (int k = 0; k < 4; k++) {
//            int n = rand.nextInt(10);
//            sb.append(n);
//          }
//          stmt1.setString(5,sb.toString());
//          String birth = sb.substring(6,10)+"-"+sb.substring(10,12)+"-"+sb.substring(12,14);
//          String strDate = "199" +
//              rand.nextInt(10) +
//              "-08-13";
//          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//          SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//          Date date = null;
//          Date date1 = null;
//          try {
//            date = new java.sql.Date(sdf.parse(strDate).getTime());
//            date1 = new java.sql.Date(sdf1.parse(birth).getTime());
//          } catch (ParseException e) {
//            e.printStackTrace();
//          }
//          long register_time = date.getTime();
//          long birth_time = date1.getTime();
//          stmt1.setTimestamp(4, new Timestamp(register_time));
//          stmt1.setTimestamp(6,new Timestamp(birth_time));
//          stmt1.addBatch();
//          stmt.addBatch();
//        }
//      }
//      stmt1.executeBatch();
//      stmt.executeBatch();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  public static void downLoadCategory(){
//    PreparedStatement stmt = null;
//    try {
//      String sql = "INSERT INTO post_category (post_id,category) VALUES (?,?);";
//      stmt = conn.prepareStatement(sql);
//      for (int i = 0; i < posts.size(); i++) {
//        stmt.setInt(1,Client.posts.get(i).getPostID());
//        String s = Client.posts.get(i).getCategory().toString();
//        s = s.substring(1,s.length()-1);
//        stmt.setString(2,s);
//        stmt.addBatch();
//      }
//      stmt.executeBatch();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  public static void downLoadReply(){
//    PreparedStatement stmt = null;
//    PreparedStatement stmt1 = null;
//    try {
//      String sql = "INSERT INTO reply (id,post_id,reply_content,stars,reply_author) VALUES (?,?,?,?,?) on CONFLICT (post_id,reply_content,stars,reply_author) do nothing;";
//      stmt = conn.prepareStatement(sql);
//      String sql1 = "insert into account (username,first_name,sec_name,register_time,identity_card,birth_time) values (?,?,?,?,?,?) on conflict (username) do nothing";
//      stmt1 = conn.prepareStatement(sql1);
//      int id = 1;
//      stmt.setInt(1,id);
//      stmt.setInt(2,replies.get(0).getPostID());
//      stmt.setString(3,replies.get(0).getReplyContent());
//      stmt.setInt(4,replies.get(0).getReplyStars());
//      stmt.setString(5,replies.get(0).getReplyAuthor());
//      stmt.addBatch();
//      String s1 = replies.get(0).getReplyAuthor();
//      //stmt.executeUpdate();
//      String[] str1 = s1.split(",");
//      for (int j = 0; j < str1.length; j++) {
//        stmt1.setString(1,str1[j]);
//        stmt1.setString(2,str1[j].split("_")[0]);
//        if (str1[j].split("_").length>=2)
//          stmt1.setString(3,str1[j].split("_")[1]);
//        else stmt1.setString(3,null);
//        StringBuilder sb = new StringBuilder();
//        Random rand = new Random();
//        for (int k = 0; k < 6; k++) {
//          int n = rand.nextInt(10);
//          sb.append(n);
//        }
//        sb.append("197");
//        sb.append(rand.nextInt(10));
//        sb.append("0813");
//        for (int k = 0; k < 4; k++) {
//          int n = rand.nextInt(10);
//          sb.append(n);
//        }
//        stmt1.setString(5,sb.toString());
//        String birth = sb.substring(6,10)+"-"+sb.substring(10,12)+"-"+sb.substring(12,14);
//        String strDate = "199" +
//            rand.nextInt(10) +
//            "-08-13";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = null;
//        Date date1 = null;
//        try {
//          date = new java.sql.Date(sdf.parse(strDate).getTime());
//          date1 = new java.sql.Date(sdf1.parse(birth).getTime());
//        } catch (ParseException e) {
//          e.printStackTrace();
//        }
//        long register_time = date.getTime();
//        long birth_time = date1.getTime();
//        stmt1.setTimestamp(4, new Timestamp(register_time));
//        stmt1.setTimestamp(6,new Timestamp(birth_time));
//        stmt1.addBatch();
//      }
//      for (int i = 1; i < replies.size(); i++) {
//        if (Objects.equals(replies.get(i - 1).getReplyAuthor(), replies.get(i).getReplyAuthor()) && Objects.equals(replies.get(i - 1).getReplyContent(), replies.get(i).getReplyContent()) &&replies.get(i-1).getReplyStars()==replies.get(i).getReplyStars()){
//          continue;
//        }
//        else id++;
//        stmt.setInt(1,id);
//        stmt.setInt(2,replies.get(i).getPostID());
//        stmt.setString(3,replies.get(i).getReplyContent());
//        stmt.setInt(4,replies.get(i).getReplyStars());
//        stmt.setString(5,replies.get(i).getReplyAuthor());
//        String s = replies.get(i).getReplyAuthor();
//        //stmt.executeUpdate();
//        String[] str = s.split(",");
//        for (int j = 0; j < str.length; j++) {
//          stmt1.setString(1,str[j]);
//          stmt1.setString(2,str[j].split("_")[0]);
//          if (str[j].split("_").length>=2)
//            stmt1.setString(3,str[j].split("_")[1]);
//          else stmt1.setString(3,null);
//          StringBuilder sb = new StringBuilder();
//          Random rand = new Random();
//          for (int k = 0; k < 6; k++) {
//            int n = rand.nextInt(10);
//            sb.append(n);
//          }
//          sb.append("197");
//          sb.append(rand.nextInt(10));
//          sb.append("0813");
//          for (int k = 0; k < 4; k++) {
//            int n = rand.nextInt(10);
//            sb.append(n);
//          }
//          stmt1.setString(5,sb.toString());
//          String birth = sb.substring(6,10)+"-"+sb.substring(10,12)+"-"+sb.substring(12,14);
//          String strDate = "199" +
//              rand.nextInt(10) +
//              "-08-13";
//          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//          SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//          Date date = null;
//          Date date1 = null;
//          try {
//            date = new java.sql.Date(sdf.parse(strDate).getTime());
//            date1 = new java.sql.Date(sdf1.parse(birth).getTime());
//          } catch (ParseException e) {
//            e.printStackTrace();
//          }
//          long register_time = date.getTime();
//          long birth_time = date1.getTime();
//          stmt1.setTimestamp(4, new Timestamp(register_time));
//          stmt1.setTimestamp(6,new Timestamp(birth_time));
//          stmt1.addBatch();
//        }
//        stmt1.executeBatch();
//        stmt.addBatch();
//      }
//      System.out.println("reply");
//      stmt.executeBatch();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  public static void downLoadSecondReply(){
//    PreparedStatement stmt = null;
//    PreparedStatement stmt1 = null;
//    try {
//      String sql = "INSERT INTO sec_reply (reply_id,reply_content,stars,reply_author) VALUES (?,?,?,?);";
//      stmt = conn.prepareStatement(sql);
//      // 执行查询操作
//      String sql1 = "insert into account (username,first_name,sec_name,register_time,identity_card,birth_time) values (?,?,?,?,?,?) on conflict (username) do nothing";
//      stmt1 = conn.prepareStatement(sql1);
//      int reply_id = 1;
//      stmt.setInt(1,reply_id);
//      stmt.setString(2,replies.get(0).getSecondaryReplyContent());
//      stmt.setInt(3,replies.get(0).getSecondaryReplyStars());
//      stmt.setString(4,replies.get(0).getSecondaryReplyAuthor());
//      stmt.addBatch();
//      for (int i = 1; i < replies.size(); i++) {
//        if (Objects.equals(replies.get(i - 1).getReplyAuthor(), replies.get(i).getReplyAuthor()) && Objects.equals(replies.get(i - 1).getReplyContent(), replies.get(i).getReplyContent()) &&replies.get(i-1).getReplyStars()==replies.get(i).getReplyStars()){
//        }
//        else {
//          reply_id++;
//        }
//        stmt.setInt(1,reply_id);
//        stmt.setString(2,replies.get(i).getSecondaryReplyContent());
//        stmt.setInt(3,replies.get(i).getSecondaryReplyStars());
//        stmt.setString(4,replies.get(i).getSecondaryReplyAuthor());
//        String s = replies.get(i).getSecondaryReplyAuthor();
//        //stmt.executeUpdate();
//        String[] str = s.split(",");
//        for (int j = 0; j < str.length; j++) {
//          stmt1.setString(1,str[j]);
//          stmt1.setString(2,str[j].split("_")[0]);
//          if (str[j].split("_").length>=2)
//            stmt1.setString(3,str[j].split("_")[1]);
//          else stmt1.setString(3,null);
//          StringBuilder sb = new StringBuilder();
//          Random rand = new Random();
//          for (int k = 0; k < 6; k++) {
//            int n = rand.nextInt(10);
//            sb.append(n);
//          }
//          sb.append("197");
//          sb.append(rand.nextInt(10));
//          sb.append("0813");
//          for (int k = 0; k < 4; k++) {
//            int n = rand.nextInt(10);
//            sb.append(n);
//          }
//          stmt1.setString(5,sb.toString());
//          String birth = sb.substring(6,10)+"-"+sb.substring(10,12)+"-"+sb.substring(12,14);
//          String strDate = "199" +
//              rand.nextInt(10) +
//              "-08-13";
//          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//          SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//          Date date = null;
//          Date date1 = null;
//          try {
//            date = new java.sql.Date(sdf.parse(strDate).getTime());
//            date1 = new java.sql.Date(sdf1.parse(birth).getTime());
//          } catch (ParseException e) {
//            e.printStackTrace();
//          }
//          long register_time = date.getTime();
//          long birth_time = date1.getTime();
//          stmt1.setTimestamp(4, new Timestamp(register_time));
//          stmt1.setTimestamp(6,new Timestamp(birth_time));
//          stmt1.addBatch();
//        }
//        stmt1.executeBatch();
//        stmt.addBatch();
//      }
//      stmt.executeBatch();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
}