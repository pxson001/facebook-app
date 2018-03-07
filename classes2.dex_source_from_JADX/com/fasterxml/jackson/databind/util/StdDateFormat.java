package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.io.NumberInput;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: story index -1 in flyout launch */
public class StdDateFormat extends DateFormat {
    protected static final String[] f4060a = new String[]{"yyyy-MM-dd'T'HH:mm:ss.SSSZ", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd"};
    protected static final DateFormat f4061b;
    protected static final DateFormat f4062c;
    protected static final DateFormat f4063d;
    protected static final DateFormat f4064e;
    public static final StdDateFormat f4065f = new StdDateFormat();
    private static final TimeZone f4066l = TimeZone.getTimeZone("GMT");
    protected transient TimeZone f4067g;
    protected transient DateFormat f4068h;
    protected transient DateFormat f4069i;
    protected transient DateFormat f4070j;
    protected transient DateFormat f4071k;

    static {
        DateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        f4061b = simpleDateFormat;
        simpleDateFormat.setTimeZone(f4066l);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        f4062c = simpleDateFormat;
        simpleDateFormat.setTimeZone(f4066l);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f4063d = simpleDateFormat;
        simpleDateFormat.setTimeZone(f4066l);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        f4064e = simpleDateFormat;
        simpleDateFormat.setTimeZone(f4066l);
    }

    private StdDateFormat(TimeZone timeZone) {
        this.f4067g = timeZone;
    }

    public static StdDateFormat m7122a(TimeZone timeZone) {
        if (timeZone == null) {
            timeZone = f4066l;
        }
        return new StdDateFormat(timeZone);
    }

    public Object clone() {
        return new StdDateFormat();
    }

    public static DateFormat m7127b(TimeZone timeZone) {
        return m7124a(f4062c, timeZone);
    }

    public void setTimeZone(TimeZone timeZone) {
        if (timeZone != this.f4067g) {
            this.f4068h = null;
            this.f4069i = null;
            this.f4070j = null;
            this.f4071k = null;
            this.f4067g = timeZone;
        }
    }

    public Date parse(String str) {
        String trim = str.trim();
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = parse(trim, parsePosition);
        if (parse != null) {
            return parse;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : f4060a) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("\", \"");
            } else {
                stringBuilder.append('\"');
            }
            stringBuilder.append(str2);
        }
        stringBuilder.append('\"');
        throw new ParseException(String.format("Can not parse date \"%s\": not compatible with any of standard forms (%s)", new Object[]{trim, stringBuilder.toString()}), parsePosition.getErrorIndex());
    }

    public Date parse(String str, ParsePosition parsePosition) {
        if (m7126a(str)) {
            return m7125a(str, parsePosition);
        }
        int length = str.length();
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            char charAt = str.charAt(length);
            if ((charAt < '0' || charAt > '9') && (length > 0 || charAt != '-')) {
                break;
            }
        }
        if (length >= 0 || !NumberInput.m13442a(str, false)) {
            return m7128b(str, parsePosition);
        }
        return new Date(Long.parseLong(str));
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (this.f4069i == null) {
            this.f4069i = m7123a(f4062c);
        }
        return this.f4069i.format(date, stringBuffer, fieldPosition);
    }

    private static boolean m7126a(String str) {
        if (str.length() >= 5 && Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(3)) && str.charAt(4) == '-') {
            return true;
        }
        return false;
    }

    private Date m7125a(String str, ParsePosition parsePosition) {
        DateFormat dateFormat;
        int length = str.length();
        char charAt = str.charAt(length - 1);
        if (length <= 10 && Character.isDigit(charAt)) {
            dateFormat = this.f4071k;
            if (dateFormat == null) {
                dateFormat = m7123a(f4064e);
                this.f4071k = dateFormat;
            }
        } else if (charAt == 'Z') {
            dateFormat = this.f4070j;
            if (dateFormat == null) {
                dateFormat = m7123a(f4063d);
                this.f4070j = dateFormat;
            }
            if (str.charAt(length - 4) == ':') {
                StringBuilder stringBuilder = new StringBuilder(str);
                stringBuilder.insert(length - 1, ".000");
                str = stringBuilder.toString();
            }
        } else if (m7129b(str)) {
            charAt = str.charAt(length - 3);
            if (charAt == ':') {
                r0 = new StringBuilder(str);
                r0.delete(length - 3, length - 2);
                str = r0.toString();
            } else if (charAt == '+' || charAt == '-') {
                str = str + "00";
            }
            int length2 = str.length();
            if (Character.isDigit(str.charAt(length2 - 9))) {
                StringBuilder stringBuilder2 = new StringBuilder(str);
                stringBuilder2.insert(length2 - 5, ".000");
                str = stringBuilder2.toString();
            }
            dateFormat = this.f4069i;
            if (this.f4069i == null) {
                dateFormat = m7123a(f4062c);
                this.f4069i = dateFormat;
            }
        } else {
            r0 = new StringBuilder(str);
            if ((length - str.lastIndexOf(84)) - 1 <= 8) {
                r0.append(".000");
            }
            r0.append('Z');
            str = r0.toString();
            dateFormat = this.f4070j;
            if (dateFormat == null) {
                dateFormat = m7123a(f4063d);
                this.f4070j = dateFormat;
            }
        }
        return dateFormat.parse(str, parsePosition);
    }

    private Date m7128b(String str, ParsePosition parsePosition) {
        if (this.f4068h == null) {
            this.f4068h = m7123a(f4061b);
        }
        return this.f4068h.parse(str, parsePosition);
    }

    private static final boolean m7129b(String str) {
        int length = str.length();
        if (length >= 6) {
            char charAt = str.charAt(length - 6);
            if (charAt == '+' || charAt == '-') {
                return true;
            }
            charAt = str.charAt(length - 5);
            if (charAt == '+' || charAt == '-') {
                return true;
            }
            char charAt2 = str.charAt(length - 3);
            if (charAt2 == '+' || charAt2 == '-') {
                return true;
            }
        }
        return false;
    }

    private final DateFormat m7123a(DateFormat dateFormat) {
        return m7124a(dateFormat, this.f4067g);
    }

    private static final DateFormat m7124a(DateFormat dateFormat, TimeZone timeZone) {
        DateFormat dateFormat2 = (DateFormat) dateFormat.clone();
        if (timeZone != null) {
            dateFormat2.setTimeZone(timeZone);
        }
        return dateFormat2;
    }
}
