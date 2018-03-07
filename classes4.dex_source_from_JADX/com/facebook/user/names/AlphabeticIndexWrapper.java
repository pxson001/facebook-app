package com.facebook.user.names;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: receiver_webrtc_application_layer */
public class AlphabeticIndexWrapper {
    public Object f3712a;
    public Method f3713b;
    public Method f3714c;
    public Method f3715d;

    public AlphabeticIndexWrapper(Locale locale, List<Locale> list, int i) {
        Class cls = Class.forName("libcore.icu.AlphabeticIndex");
        Class cls2 = Class.forName("libcore.icu.AlphabeticIndex$ImmutableIndex");
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{Locale.class});
        declaredConstructor.setAccessible(true);
        Object newInstance = declaredConstructor.newInstance(new Object[]{locale});
        Method declaredMethod = cls.getDeclaredMethod("addLabels", new Class[]{Locale.class});
        Iterator it = list.iterator();
        while (it.hasNext()) {
            declaredMethod.invoke(newInstance, new Object[]{(Locale) it.next()});
        }
        cls.getDeclaredMethod("setMaxLabelCount", new Class[]{Integer.TYPE}).invoke(newInstance, new Object[]{Integer.valueOf(i)});
        this.f3712a = cls.getDeclaredMethod("getImmutableIndex", new Class[0]).invoke(newInstance, new Object[0]);
        this.f3713b = cls2.getDeclaredMethod("getBucketCount", new Class[0]);
        this.f3714c = cls2.getDeclaredMethod("getBucketIndex", new Class[]{String.class});
        this.f3715d = cls2.getDeclaredMethod("getBucketLabel", new Class[]{Integer.TYPE});
    }
}
