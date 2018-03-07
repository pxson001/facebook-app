package com.facebook.payments.currency;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: iris_seq_id */
public class LocalizedCurrencyConfig {
    public static ImmutableList<String> f12290a = null;
    public static ImmutableMap<String, ImmutableMap<String, String>> f12291b = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m19192c(android.content.Context r5) {
        /*
        r0 = r5.getResources();
        r1 = "currency_config";
        r2 = "raw";
        r3 = r5.getPackageName();
        r1 = r0.getIdentifier(r1, r2, r3);
        if (r1 != 0) goto L_0x0013;
    L_0x0012:
        return;
    L_0x0013:
        r0 = 0;
        r2 = r5.getResources();	 Catch:{ NotFoundException -> 0x0027, all -> 0x0030 }
        r0 = r2.openRawResource(r1);	 Catch:{ NotFoundException -> 0x0027, all -> 0x0030 }
        m19191a(r0);	 Catch:{ NotFoundException -> 0x0027, all -> 0x003c }
        if (r0 == 0) goto L_0x0012;
    L_0x0021:
        r0.close();	 Catch:{ IOException -> 0x0025 }
        goto L_0x0012;
    L_0x0025:
        r0 = move-exception;
        goto L_0x0012;
    L_0x0027:
        r1 = move-exception;
        if (r0 == 0) goto L_0x0012;
    L_0x002a:
        r0.close();	 Catch:{ IOException -> 0x002e }
        goto L_0x0012;
    L_0x002e:
        r0 = move-exception;
        goto L_0x0012;
    L_0x0030:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0034:
        if (r1 == 0) goto L_0x0039;
    L_0x0036:
        r1.close();	 Catch:{ IOException -> 0x003a }
    L_0x0039:
        throw r0;
    L_0x003a:
        r1 = move-exception;
        goto L_0x0039;
    L_0x003c:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.payments.currency.LocalizedCurrencyConfig.c(android.content.Context):void");
    }

    @VisibleForTesting
    private static void m19191a(InputStream inputStream) {
        try {
            JsonParser a = new MappingJsonFactory().a(inputStream);
            a.c();
            while (a.c() != JsonToken.END_OBJECT) {
                String i = a.i();
                if (i.equals("adsCurrencyCodes")) {
                    a.c();
                    Collection arrayList = new ArrayList();
                    while (a.c() != JsonToken.END_ARRAY) {
                        arrayList.add(a.o());
                    }
                    f12290a = ImmutableList.copyOf(arrayList);
                } else if (i.equals("allCurrenciesByCode")) {
                    a.c();
                    Map hashMap = new HashMap();
                    while (a.c() != JsonToken.END_OBJECT) {
                        Map hashMap2 = new HashMap();
                        String i2 = a.i();
                        a.c();
                        while (a.c() != JsonToken.END_OBJECT) {
                            a.c();
                            hashMap2.put(a.i(), a.o());
                        }
                        hashMap.put(i2, ImmutableMap.copyOf(hashMap2));
                    }
                    f12291b = ImmutableMap.copyOf(hashMap);
                } else {
                    a.f();
                }
            }
            a.close();
        } catch (IOException e) {
        }
    }
}
