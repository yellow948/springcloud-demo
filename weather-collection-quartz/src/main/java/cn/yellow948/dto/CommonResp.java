package cn.yellow948.dto;


public class CommonResp<T> {
    private Integer code;
    private String msg;
    private T data;

    public CommonResp(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public CommonResp(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResp() {}

    @Override
    public String toString() {
        return "CommonResp{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
