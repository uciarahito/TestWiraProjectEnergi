package uci.develops.wiraenergiproject.response;


/**
 * Created by ArahitoPC
 */
public class RegisterResponse {
    private String status;
    private String code;
    private String info;

    public RegisterResponse(String status, String code, String info) {
        this.status = status;
        this.code = code;
        this.info = info;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
