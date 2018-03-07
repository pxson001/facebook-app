package com.facebook.crudolib.params;

import java.io.Writer;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: t_p */
public class NumberFormatHelper {
    private static final ThreadLocal<NumberFormatHelper> f3512a = new C02051();
    private final StringBuilder f3513b = new StringBuilder(20);

    /* compiled from: t_p */
    final class C02051 extends ThreadLocal<NumberFormatHelper> {
        C02051() {
        }

        public final Object initialValue() {
            return new NumberFormatHelper();
        }
    }

    public static NumberFormatHelper m5729a() {
        return (NumberFormatHelper) f3512a.get();
    }

    NumberFormatHelper() {
    }

    private CharSequence m5730a(Number number) {
        StringBuilder stringBuilder = this.f3513b;
        stringBuilder.delete(0, stringBuilder.length());
        if (number instanceof Float) {
            stringBuilder.append(number.floatValue());
        } else if (number instanceof Double) {
            stringBuilder.append(number.doubleValue());
        } else if (number instanceof Integer) {
            stringBuilder.append(number.intValue());
        } else if (number instanceof Long) {
            stringBuilder.append(number.longValue());
        } else {
            throw new UnsupportedOperationException("Type " + number.getClass() + " not supported");
        }
        return stringBuilder;
    }

    public final void m5731a(Writer writer, Number number) {
        CharSequence a = m5730a(number);
        int length = a.length();
        for (int i = 0; i < length; i++) {
            writer.write(a.charAt(i));
        }
    }
}
