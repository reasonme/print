package cn.fintecher.print.web.util;

import cn.fintecher.print.model.BaseObject;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * Created by ChenChang on 2017/4/13.
 */
public class JodaTimeEditor extends PropertyEditorSupport {
    private final boolean allowEmpty;

    public JodaTimeEditor(boolean allowEmpty) {
        this.allowEmpty = allowEmpty;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (this.allowEmpty && !StringUtils.hasText(text)) {
            // Treat empty String as null value.
            setValue(null);
        } else {
            try {
                if (text.length() > BaseObject.DATE_FORMAT.length()) {
                    setValue(DateTime.parse(text, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDate());
                } else {
                    setValue(DateTime.parse(text, DateTimeFormat.forPattern("yyyy-MM-dd")).toDate());

                }
            } catch (Exception ex) {
                throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
            }
        }
    }

    @Override
    public String getAsText() {
        Date value = (Date) getValue();
        return (value != null ? new DateTime(value).toString() : "");
    }

}
