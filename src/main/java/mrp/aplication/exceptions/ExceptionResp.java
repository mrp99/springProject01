package mrp.aplication.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResp implements Serializable {

    private Date timestampArg;
    private String messageArg;
    private String detailsArg;

    public ExceptionResp(Date timestampParam, String messageParam, String detailsParam) {
        timestampArg = timestampParam;
        messageArg = messageParam;
        detailsArg = detailsParam;
    }

    public Date getTimestamp() {
        return timestampArg;
    }

    public String getMessage() {
        return messageArg;
    }

    public String getDetails() {
        return detailsArg;
    }
}
