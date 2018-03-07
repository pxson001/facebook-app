package com.facebook.katana.util;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* compiled from: p2p_initiate_send */
public class SignatureBuilder {
    private SignatureBuilder() {
    }

    public static String m7878a(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder(256);
        List<String> arrayList = new ArrayList(new HashSet(map.keySet()));
        Collections.sort(arrayList);
        for (String str2 : arrayList) {
            stringBuilder.append(str2).append("=").append((String) map.get(str2));
        }
        stringBuilder.append(str);
        String stringBuilder2 = stringBuilder.toString();
        int i = 0;
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.reset();
        byte[] bytes = stringBuilder2.getBytes("UTF-8");
        instance.update(bytes, 0, bytes.length);
        byte[] digest = instance.digest();
        StringBuilder stringBuilder3 = new StringBuilder(digest.length * 2);
        while (i < digest.length) {
            int i2 = digest[i] & 255;
            if (i2 < 16) {
                stringBuilder3.append("0");
            }
            stringBuilder3.append(Integer.toHexString(i2).toLowerCase());
            i++;
        }
        return stringBuilder3.toString();
    }
}
