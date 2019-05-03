package FarmEd.beta.InformationPipeline.Responses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int queryNum;
    String reply;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQueryNum() {
        return queryNum;
    }

    public void setQueryNum(int queryNum) {
        this.queryNum = queryNum;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
