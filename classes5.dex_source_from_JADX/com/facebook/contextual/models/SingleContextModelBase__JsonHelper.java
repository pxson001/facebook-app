package com.facebook.contextual.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.ArrayList;
import java.util.List;

/* compiled from: acting_team */
public final class SingleContextModelBase__JsonHelper {
    public static boolean m19737a(SingleContextModelBase singleContextModelBase, String str, JsonParser jsonParser) {
        List list = null;
        if ("cctype".equals(str)) {
            String o;
            if (jsonParser.g() != JsonToken.VALUE_NULL) {
                o = jsonParser.o();
            }
            singleContextModelBase.f11616d = o;
            return true;
        } else if ("version".equals(str)) {
            singleContextModelBase.f11617e = Integer.valueOf(jsonParser.E());
            return true;
        } else if ("context".equals(str)) {
            Context context = new Context();
            if (jsonParser.g() != JsonToken.START_OBJECT) {
                jsonParser.f();
                context = null;
            } else {
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    String str2 = null;
                    int i2;
                    if ("name".equals(i)) {
                        if (jsonParser.g() != JsonToken.VALUE_NULL) {
                            str2 = jsonParser.o();
                        }
                        context.f11605a = str2;
                        i2 = 1;
                    } else if ("modifier".equals(i)) {
                        context.f11606b = jsonParser.F();
                        i2 = 1;
                    } else if ("type".equals(i)) {
                        if (jsonParser.g() != JsonToken.VALUE_NULL) {
                            str2 = jsonParser.o();
                        }
                        context.f11607c = str2;
                        i2 = 1;
                    } else if ("directmap".equals(i)) {
                        context.f11608d = jsonParser.H();
                        i2 = 1;
                    } else if ("local".equals(i)) {
                        context.f11609e = jsonParser.H();
                        i2 = 1;
                    }
                    jsonParser.f();
                }
            }
            singleContextModelBase.f11618f = context;
            return true;
        } else if (!"buckets".equals(str)) {
            return false;
        } else {
            if (jsonParser.g() == JsonToken.START_ARRAY) {
                list = new ArrayList();
                while (jsonParser.c() != JsonToken.END_ARRAY) {
                    Bucket a = Bucket__JsonHelper.m19730a(jsonParser);
                    if (a != null) {
                        list.add(a);
                    }
                }
            }
            singleContextModelBase.f11619g = list;
            return true;
        }
    }
}
