package ashwini.abhishek.courses;

public class ResponseMessage {
    int status;
    String message;

    public ResponseMessage() {
    }

    public ResponseMessage(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public boolean equals(Object response) {
        if(this.getStatus() == ((ResponseMessage)response).getStatus() && this.getMessage().equals(((ResponseMessage)response).getMessage()))
            return true;
        return false;
    }
}
