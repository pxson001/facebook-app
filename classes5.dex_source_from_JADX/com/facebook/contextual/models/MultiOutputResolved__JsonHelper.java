package com.facebook.contextual.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.instagram.common.json.JsonFactoryHolder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: action_path */
public final class MultiOutputResolved__JsonHelper {
    public static MultiOutputResolved m19732a(String str) {
        JsonParser a = JsonFactoryHolder.f7685a.a(str);
        a.c();
        MultiOutputResolved multiOutputResolved = new MultiOutputResolved();
        if (a.g() != JsonToken.START_OBJECT) {
            a.f();
            multiOutputResolved = null;
        } else {
            while (a.c() != JsonToken.END_OBJECT) {
                String i = a.i();
                a.c();
                List list = null;
                int i2;
                if ("cctype".equals(i)) {
                    String o;
                    if (a.g() != JsonToken.VALUE_NULL) {
                        o = a.o();
                    }
                    multiOutputResolved.f11612a = o;
                    i2 = 1;
                } else if ("version".equals(i)) {
                    multiOutputResolved.f11613b = Integer.valueOf(a.E());
                    i2 = 1;
                } else if ("outputs".equals(i)) {
                    if (a.g() == JsonToken.START_ARRAY) {
                        list = new ArrayList();
                        while (a.c() != JsonToken.END_ARRAY) {
                            Output a2 = Output__JsonHelper.m19735a(a);
                            if (a2 != null) {
                                list.add(a2);
                            }
                        }
                    }
                    multiOutputResolved.f11614c = list;
                    i2 = 1;
                } else if ("values".equals(i)) {
                    if (a.g() == JsonToken.START_ARRAY) {
                        list = new ArrayList();
                        while (a.c() != JsonToken.END_ARRAY) {
                            OutputValue a3 = OutputValue__JsonHelper.m19734a(a);
                            if (a3 != null) {
                                list.add(a3);
                            }
                        }
                    }
                    multiOutputResolved.f11615d = list;
                    i2 = 1;
                }
                a.f();
            }
        }
        return multiOutputResolved;
    }
}
