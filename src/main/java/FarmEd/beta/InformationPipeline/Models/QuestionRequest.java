package FarmEd.beta.InformationPipeline.Models;



public class QuestionRequest {
    int userNum;
    double n;
    double p;
    double k;
    double pH;
    String date;
    String location;
    String question;
    String image;

    public QuestionRequest() {
        super();
    }

    public QuestionRequest(int userNum, double n, double p, double k, double pH, String date, String location, String question, String image) {
        this.userNum = userNum;
        this.n = n;
        this.p = p;
        this.k = k;
        this.pH = pH;
        this.date = date;
        this.location = location;
        this.question = question;
        this.image = image;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "QuestionResponse [userNum=" + userNum +  ", n=" + n + ", p=" + p  + ", k=" + k +  ", pH=" + pH + ", date="
                + date +  ", location=" + location + ", question=" + question +  ", image=" + image + "]";
    }

}
