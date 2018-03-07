package com.fasterxml.jackson.core;

/* compiled from: story ID is null */
public final class Base64Variants {
    public static final Base64Variant f4072a = new Base64Variant("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    public static final Base64Variant f4073b = new Base64Variant(f4072a, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
    public static final Base64Variant f4074c = new Base64Variant(f4072a, "PEM", true, '=', 64);
    public static final Base64Variant f4075d;

    static {
        StringBuffer stringBuffer = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        stringBuffer.setCharAt(stringBuffer.indexOf("+"), '-');
        stringBuffer.setCharAt(stringBuffer.indexOf("/"), '_');
        f4075d = new Base64Variant("MODIFIED-FOR-URL", stringBuffer.toString(), false, '\u0000', Integer.MAX_VALUE);
    }

    public static Base64Variant m7130a() {
        return f4073b;
    }

    public static Base64Variant m7131a(String str) {
        if (f4072a._name.equals(str)) {
            return f4072a;
        }
        if (f4073b._name.equals(str)) {
            return f4073b;
        }
        if (f4074c._name.equals(str)) {
            return f4074c;
        }
        if (f4075d._name.equals(str)) {
            return f4075d;
        }
        String str2;
        if (str == null) {
            str2 = "<null>";
        } else {
            str2 = "'" + str + "'";
        }
        throw new IllegalArgumentException("No Base64Variant with name " + str2);
    }
}
