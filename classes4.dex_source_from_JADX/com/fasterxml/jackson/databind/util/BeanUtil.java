package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

/* compiled from: video_channel_can_viewer_follow */
public class BeanUtil {
    public static String m488a(AnnotatedMethod annotatedMethod) {
        String b = annotatedMethod.b();
        String b2 = m491b(annotatedMethod, b);
        if (b2 == null) {
            return m489a(annotatedMethod, b);
        }
        return b2;
    }

    public static String m489a(AnnotatedMethod annotatedMethod, String str) {
        if (!str.startsWith("get")) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            if (m492b(annotatedMethod)) {
                return null;
            }
        } else if ("getMetaClass".equals(str) && m494c(annotatedMethod)) {
            return null;
        }
        return m490a(str.substring(3));
    }

    public static String m491b(AnnotatedMethod annotatedMethod, String str) {
        if (!str.startsWith("is")) {
            return null;
        }
        Class d = annotatedMethod.d();
        if (d == Boolean.class || d == Boolean.TYPE) {
            return m490a(str.substring(2));
        }
        return null;
    }

    public static String m493c(AnnotatedMethod annotatedMethod, String str) {
        String b = annotatedMethod.b();
        if (b.startsWith(str)) {
            return m490a(b.substring(str.length()));
        }
        return null;
    }

    private static boolean m492b(AnnotatedMethod annotatedMethod) {
        Class d = annotatedMethod.d();
        if (d == null || !d.isArray()) {
            return false;
        }
        Package packageR = d.getComponentType().getPackage();
        if (packageR == null) {
            return false;
        }
        String name = packageR.getName();
        if (name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib")) {
            return true;
        }
        return false;
    }

    private static boolean m494c(AnnotatedMethod annotatedMethod) {
        Class d = annotatedMethod.d();
        if (d == null || d.isArray()) {
            return false;
        }
        Package packageR = d.getPackage();
        if (packageR == null || !packageR.getName().startsWith("groovy.lang")) {
            return false;
        }
        return true;
    }

    private static String m490a(String str) {
        StringBuilder stringBuilder = null;
        int length = str.length();
        if (length == 0) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            char toLowerCase = Character.toLowerCase(charAt);
            if (charAt == toLowerCase) {
                break;
            }
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder(str);
            }
            stringBuilder.setCharAt(i, toLowerCase);
        }
        return stringBuilder != null ? stringBuilder.toString() : str;
    }
}
