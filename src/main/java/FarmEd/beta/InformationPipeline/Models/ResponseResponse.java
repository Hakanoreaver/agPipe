package FarmEd.beta.InformationPipeline.Models;

import FarmEd.beta.InformationPipeline.Responses.Response;

public class ResponseResponse {
    int questionId;
    String reply;

    public ResponseResponse() {
        super();
    }

    public ResponseResponse(int questionId, String reply) {
        this.questionId = questionId;
        this.reply = reply;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String toString() {
        return "ResponseResponse [questionId=" + questionId +", reply=" + reply + "]";
    }
}
