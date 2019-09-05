package pojo;

public class Message {
    public int messageID;
    public int messagevideoID;
    public int messageuserID;
    public String messageuserName;
    public String message;
    public String messageHand;

    public Message() {
    }

    public Message(String messageuserName, String message) {
        this.messageuserName = messageuserName;
        this.message = message;
    }

    public Message(int messagevideoID, String messageuserName, String message) {
        this.messagevideoID = messagevideoID;
        this.messageuserName = messageuserName;
        this.message = message;
    }

    public Message(int messageID, int messagevideoID, int messageuserID, String messageuserName, String message) {
        this.messageID = messageID;
        this.messagevideoID = messagevideoID;
        this.messageuserID = messageuserID;
        this.messageuserName = messageuserName;
        this.message = message;
    }

    public Message(int messageID, int messagevideoID, int messageuserID, String messageuserName, String message, String messageHand) {
        this.messageID = messageID;
        this.messagevideoID = messagevideoID;
        this.messageuserID = messageuserID;
        this.messageuserName = messageuserName;
        this.message = message;
        this.messageHand = messageHand;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public int getMessagevideoID() {
        return messagevideoID;
    }

    public void setMessagevideoID(int messagevideoID) {
        this.messagevideoID = messagevideoID;
    }

    public int getMessageuserID() {
        return messageuserID;
    }

    public void setMessageuserID(int messageuserID) {
        this.messageuserID = messageuserID;
    }

    public String getMessageuserName() {
        return messageuserName;
    }

    public void setMessageuserName(String messageuserName) {
        this.messageuserName = messageuserName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageHand() {
        return messageHand;
    }

    public void setMessageHand(String messageHand) {
        this.messageHand = messageHand;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageID=" + messageID +
                ", messagevideoID=" + messagevideoID +
                ", messageuserID=" + messageuserID +
                ", messageuserName='" + messageuserName + '\'' +
                ", message='" + message + '\'' +
                ", messageHand='" + messageHand + '\'' +
                '}';
    }
}
