package cn.nnxy.model;


public class ResponseData {
    private Boolean state;
    private String msg;
    private Object data;

    public ResponseData(Boolean state, String msg, Object data) {
        this.state = state;
        this.msg = msg;
        this.data = data;
    }

    public Boolean getState() {
        return state;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}
