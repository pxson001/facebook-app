package com.facebook.transliteration.algorithms.bigram;

import com.facebook.debug.log.BLog;
import com.facebook.inject.Assisted;
import com.facebook.transliteration.algorithms.TransliterationAlgorithm;
import com.facebook.transliteration.datamanager.DataManagerUtil;
import com.google.common.collect.ImmutableMap;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: extra_composer_session_id */
public class BigramAlgorithm implements TransliterationAlgorithm {
    private BigramDecoder f15121a;
    private Map<String, Map<String, Double>> f15122b;
    private Map<String, Integer> f15123c;
    private double[][] f15124d;
    private int f15125e;
    private int f15126f;
    private LinkedHashMap<String, String> f15127g;

    @Inject
    public BigramAlgorithm(DataManagerUtil dataManagerUtil, @Assisted int i) {
        try {
            m19113b(dataManagerUtil, i);
            m19112a(dataManagerUtil, i);
            this.f15121a = new BigramDecoder(this.f15122b, this.f15123c, this.f15124d, this.f15125e);
        } catch (Throwable e) {
            BLog.b("TRANSLITERATION", "Could not parse or load Bigram Model files", e);
        }
    }

    private void m19112a(DataManagerUtil dataManagerUtil, int i) {
        JSONObject jSONObject = new JSONObject(dataManagerUtil.m19177a(1, i));
        this.f15126f = jSONObject.getInt("version");
        JSONObject jSONObject2 = jSONObject.getJSONObject("model");
        this.f15125e = jSONObject2.getInt("max_phoneme_length");
        this.f15123c = new HashMap();
        jSONObject = jSONObject2.getJSONObject("character_index");
        int length = jSONObject.length();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            this.f15123c.put(str, Integer.valueOf(jSONObject.getInt(str)));
        }
        this.f15124d = (double[][]) Array.newInstance(Double.TYPE, new int[]{length, length});
        JSONArray jSONArray = jSONObject2.getJSONArray("bigram_probability");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i2);
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                this.f15124d[i2][i3] = jSONArray2.getDouble(i3);
            }
        }
        jSONObject = jSONObject2.getJSONObject("phoneme_character_map");
        this.f15122b = new HashMap();
        Iterator keys2 = jSONObject.keys();
        while (keys2.hasNext()) {
            str = (String) keys2.next();
            JSONObject jSONObject3 = jSONObject.getJSONObject(str);
            HashMap hashMap = new HashMap();
            Iterator keys3 = jSONObject3.keys();
            while (keys3.hasNext()) {
                String str2 = (String) keys3.next();
                hashMap.put(str2, Double.valueOf(jSONObject3.getDouble(str2)));
            }
            this.f15122b.put(str, hashMap);
        }
    }

    public final List<String> mo1172a(String str, int i) {
        return this.f15121a.m19120a(str.toLowerCase(Locale.ENGLISH), i);
    }

    private void m19113b(DataManagerUtil dataManagerUtil, int i) {
        JSONObject jSONObject = new JSONObject(dataManagerUtil.m19176a(i));
        this.f15127g = new LinkedHashMap();
        JSONArray jSONArray = jSONObject.getJSONArray("characters");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                this.f15127g.put(str, jSONObject2.getString(str));
            }
        }
    }

    public final ImmutableMap<String, String> mo1171a() {
        return ImmutableMap.copyOf(this.f15127g);
    }
}
