package FarmEd.beta.InformationPipeline.Models;


import java.sql.Date;

public class QuestionRequest {
    int userNum;
    double n;
    double p;
    double k;
    double pH;
    Date date;
    String location;
    String question;
    String image;
    String pesticides;
    String fertilisers;
    String length;
    String frequency;
    String username;

    public QuestionRequest() {
        super();
    }

    public QuestionRequest(String username, int userNum, double n, double p, double k, double pH, Date date, String location, String question, String image, String pesticides, String fertilisers, String length, String frequency) {
        this.userNum = userNum;
        this.n = n;
        this.p = p;
        this.k = k;
        this.pH = pH;
        this.location = location;
        this.question = question;
        this.image = image;
        this.pesticides = pesticides;
        this.fertilisers = fertilisers;
        this.length = length;
        this.username = username;
        this.frequency = frequency;
        this.date = date;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "QuestionResponse [userNum=" + userNum +  ", n=" + n + ", p=" + p  + ", k=" + k +  ", pH=" + pH +  ", location=" + location + ", question=" + question +  ", image=" + image + "]";
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
