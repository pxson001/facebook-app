package com.fasterxml.jackson.annotation;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: com.android.internal.app.IBatteryStats */
public class JsonFormat$Value {
    public final String f5937a;
    public final Shape f5938b;
    public final Locale f5939c;
    public final TimeZone f5940d;

    public JsonFormat$Value() {
        this("", Shape.ANY, "", "");
    }

    public JsonFormat$Value(JsonFormat jsonFormat) {
        this(jsonFormat.pattern(), jsonFormat.shape(), jsonFormat.locale(), jsonFormat.timezone());
    }

    private JsonFormat$Value(String str, Shape shape, String str2, String str3) {
        TimeZone timeZone = null;
        Locale locale = (str2 == null || str2.length() == 0 || "##default".equals(str2)) ? null : new Locale(str2);
        if (!(str3 == null || str3.length() == 0 || "##default".equals(str3))) {
            timeZone = TimeZone.getTimeZone(str3);
        }
        this(str, shape, locale, timeZone);
    }

    private JsonFormat$Value(String str, Shape shape, Locale locale, TimeZone timeZone) {
        this.f5937a = str;
        this.f5938b = shape;
        this.f5939c = locale;
        this.f5940d = timeZone;
    }

    public final String m10731a() {
        return this.f5937a;
    }

    public final Shape m10732b() {
        return this.f5938b;
    }

    public final Locale m10733c() {
        return this.f5939c;
    }

    public final TimeZone m10734d() {
        return this.f5940d;
    }
}
