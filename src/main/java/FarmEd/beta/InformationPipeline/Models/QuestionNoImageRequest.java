package FarmEd.beta.InformationPipeline.Models;

import FarmEd.beta.InformationPipeline.Queries.Question;

import java.sql.Date;

public class QuestionNoImageRequest {
    int id;
    int userNum;
    double n;
    double p;
    double k;
    double pH;
    Date date;
    String location;
    String question;
    String pesticides;
    String fertilisers;
    String length;
    String frequency;
    String username;

    public QuestionNoImageRequest() {
        super();
    }

    public QuestionNoImageRequest(String username, int userNum, double n, double p, double k, double pH, String location, String question, String pesticides, String fertilisers, String length, String frequency, int id, Date date) {
        this.id = id;
        this.userNum = userNum;
        this.n = n;
        this.p = p;
        this.k = k;
        this.pH = pH;
        this.location = location;
        this.question = question;
        this.pesticides = pesticides;
        this.fertilisers = fertilisers;
        this.length = length;
        this.frequency = frequency;
        this.date = date;
        this.username = username;
    }

    public QuestionNoImageRequest(Question q) {
        this.id = q.getId();
        this.userNum = q.getUserNum();
        this.n = q.getN();
        this.p = q.getP();
        this.k = q.getK();
        this.pH = q.getpH();
        this.location = q.getLocation();
        this.question = q.getQuestion();
        this.pesticides = q.getPesticides();
        this.fertilisers = q.getFertilisers();
        this.length = q.getLength();
        this.frequency = q.getFrequency();
        this.date = q.getDate();
    }


    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getpH() {
        return pH;
    }

    public void setpH(double pH) {
        this.pH = pH;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getPesticides() {
        return pesticides;
    }

    public void setPesticides(String pesticides) {
        this.pesticides = pesticides;
    }

    public String getFertilisers() {
        return fertilisers;
    }

    public void setFertilisers(String fertilisers) {
        this.fertilisers = fertilisers;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
