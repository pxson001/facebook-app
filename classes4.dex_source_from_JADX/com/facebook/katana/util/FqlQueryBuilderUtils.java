package com.facebook.katana.util;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.util.StringUtil;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Throwables;
import com.google.common.collect.Sets;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: suggestion_timestamp */
public class FqlQueryBuilderUtils {
    protected Map<Class<?>, Set<String>> f1570a = new HashMap();

    public static String m1786a(String str, String str2, Set<String> set) {
        StringBuffer stringBuffer = new StringBuffer("SELECT ");
        stringBuffer.append(StringUtil.b(",", new Object[]{set})).append(" FROM ").append(str).append(" WHERE ").append(str2);
        return stringBuffer.toString();
    }

    public final Set<String> m1787a(Class<?> cls) {
        Set<String> set = (Set) this.f1570a.get(cls);
        if (set == null) {
            HashSet a = Sets.a();
            Annotation annotation = cls.getAnnotation(JsonDeserialize.class);
            if (annotation != null) {
                try {
                    Class cls2 = (Class) annotation.annotationType().getDeclaredMethod("using", new Class[0]).invoke(annotation, new Object[0]);
                    if (FbJsonDeserializer.class.isAssignableFrom(cls2)) {
                        set = (Set) cls2.getDeclaredMethod("getJsonFields", new Class[0]).invoke(null, new Object[0]);
                        this.f1570a.put(cls, set);
                    }
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                } catch (Throwable e2) {
                    throw Throwables.propagate(e2);
                } catch (Throwable e22) {
                    throw Throwables.propagate(e22);
                }
            }
            Object obj = a;
            this.f1570a.put(cls, set);
        }
        return set;
    }
}
