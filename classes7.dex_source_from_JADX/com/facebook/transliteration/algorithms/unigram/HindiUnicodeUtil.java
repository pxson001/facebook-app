package com.facebook.transliteration.algorithms.unigram;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: extra_composer_facecast_info */
public class HindiUnicodeUtil {
    Map<String, String> f15138a = new HashMap();

    @Inject
    public HindiUnicodeUtil() {
        this.f15138a.put("्अ", "");
        this.f15138a.put("्आ", "ा");
        this.f15138a.put("्इ", "ि");
        this.f15138a.put("्ई", "ी");
        this.f15138a.put("्उ", "ु");
        this.f15138a.put("्ऊ", "ू");
        this.f15138a.put("्ए", "े");
        this.f15138a.put("्ऐ", "ै");
        this.f15138a.put("्ओ", "ो");
        this.f15138a.put("्औ", "ौ");
        this.f15138a.put("्ऋ", "ृ");
    }

    public final String m19127a(String str) {
        return m19126c(m19125b(str));
    }

    private static String m19125b(String str) {
        if (str.endsWith("्")) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

    private String m19126c(String str) {
        for (Entry entry : this.f15138a.entrySet()) {
            str = str.replace((String) entry.getKey(), (String) entry.getValue());
        }
        return str;
    }
}
