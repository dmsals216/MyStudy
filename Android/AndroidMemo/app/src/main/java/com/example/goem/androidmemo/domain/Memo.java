package com.example.goem.androidmemo.domain;

/**
 * Created by GoEM on 2017-09-20.
 */

public class Memo {
    private  final String LABEL = "~~";

    private int no;
    private String title;
    private String author;
    private String content;
    private long datetime;

    public Memo() {

    }
    public Memo(String text) {
        setMemoValueFromFile(text);
    }

    public String toString() {
        StringBuilder temp = new StringBuilder();
        temp.append("No").append(LABEL).append(getNo()).append("\n");
        temp.append("Author").append(LABEL).append(getAuthor()).append("\n");
        temp.append("Title").append(LABEL).append(getTitle()).append("\n");
        temp.append("Content").append(LABEL).append(getContent()).append("\n");
        temp.append("DateTime").append(LABEL).append(getDatetime()).append("\n");
        return temp.toString();
    }

    private Memo setMemoValueFromFile(String text) {
        String[] texts = text.split("\n");
        for(String line : texts){
            String columns[] = line.split(LABEL);
            String key = "";
            String value = "";
            if(columns.length == 2) {
                key = columns[0];
                value = columns[1];
            }else{
                key = "";
                value = columns[0];
            }
            switch(key){
                case "No":
                    setNo(Integer.parseInt(value));
                    break;
                case "Title":
                    setTitle(value);
                    break;
                case "Author":
                    setAuthor(value);
                    break;
                case "DateTime":
                    setDatetime(Long.parseLong(value));
                    break;
                case "Content":
                    setContent(value);
                    break;
                default:
                    appendContent(value);
            }
        }
        return this;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void appendContent(String content) {
        this.content += "\n" + content;
    }

    public long getDatetime() {
        return datetime;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }
}
