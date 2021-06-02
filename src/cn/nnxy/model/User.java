package cn.nnxy.model;

import java.io.*;
import java.util.ArrayList;

public class User {
    private String email;
    private String userName;
    private String passWord;
    private String file;
    private String zhen;
    private String fan;

    public String getZhen() {
        return zhen;
    }

    public void setZhen(String zhen) {
        this.zhen = zhen;
    }

    public String getFan() {
        return fan;
    }

    public void setFan(String fan) {
        this.fan = fan;
    }

    public User(String email, String userName, String passWord, String file) {
        this.email = email;
        this.userName = userName;
        this.passWord = passWord;
        this.file = file;
        zhen = " ";
        fan = " ";
    }

    public User(String email, String userName, String passWord, String file, String zhen, String fan) {
        this.email = email;
        this.userName = userName;
        this.passWord = passWord;
        this.file = file;
        this.zhen = zhen;
        this.fan = fan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public User getLoginUser() throws IOException {
        for (String user : getUserList()) {
            String[] userInfo = user.split(",");
            try {
                User user1 = new User(userInfo[0], userInfo[1], userInfo[2], userInfo[3], userInfo[4], userInfo[5]);
                if (user1.getEmail().equals(email) && user1.getPassWord().equals(passWord)) return user1;
            } catch (Exception e) {
                File file = new File("user.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
            }
        }
        return null;
    }

    public User register() {
        try {
            ArrayList<String> userList = getUserList();
            for (String emil : userList) {
                if (emil.split(",")[0].equals(this.email)) return null;
            }
            userList.add(this.toString());// 通过User对象封装的数据，进行数据保存
            if (writeUser(userList)) return this;
            return null;
        } catch (Exception e) {
            return null;
        }
    }


    private ArrayList<String> getUserList() {
        ArrayList<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("user.txt")));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                lines.add(s);
            }
            br.close();
        } catch (Exception e) {
        }
        return lines;
    }

    private boolean writeUser(ArrayList<String> arrayList) {
        try {
            FileOutputStream fileOutputStream = null;
            File file = new File("user.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
            for (String user : arrayList) {
                fileOutputStream.write(user.getBytes("utf-8"));
                fileOutputStream.write("\n".getBytes("utf-8"));
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public User() {

    }

    public User(String email, String passWord) {
        this.email = email;
        this.passWord = passWord;
    }

    public boolean updateUserInfo(String zhen,String fan) {
        ArrayList<String> userList = getUserList();
        for (int i = 0; i < userList.size(); i++) {
            String[] userInfo = userList.get(i).split(",");
            User user1 = new User(userInfo[0], userInfo[1], userInfo[2], userInfo[3], zhen, fan);
            if (user1.getEmail().equals(email) && user1.getPassWord().equals(passWord)) {
                userList.set(i, user1.toString());
            }
        }
        return writeUser(userList);
    }

    @Override
    public String toString() {
        return email + "," + userName + "," + passWord + "," + file + "," + zhen + "," + fan;
    }

}
