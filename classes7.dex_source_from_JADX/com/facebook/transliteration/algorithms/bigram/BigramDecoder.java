package com.facebook.transliteration.algorithms.bigram;

import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.transliteration.algorithms.HindiLanguageUtil;
import com.google.common.collect.MinMaxPriorityQueue;
import com.google.common.collect.NaturalOrdering;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: extra_composer_life_event_icon_model */
public class BigramDecoder {
    private final Map<String, Map<String, Double>> f15128a;
    private final Map<String, Integer> f15129b;
    private final double[][] f15130c;
    private final int f15131d;
    private final int f15132e;
    public String f15133f = "";
    private ArrayList<MinMaxPriorityQueue<BigramDecoderItem>> f15134g;

    public BigramDecoder(Map<String, Map<String, Double>> map, Map<String, Integer> map2, double[][] dArr, int i) {
        this.f15128a = map;
        this.f15129b = map2;
        this.f15132e = ((Integer) this.f15129b.get("</s>")).intValue();
        this.f15130c = dArr;
        this.f15131d = i;
        this.f15134g = new ArrayList();
        MinMaxPriorityQueue a = MinMaxPriorityQueue.a(NaturalOrdering.a).a();
        a.add(new BigramDecoderItem("", "</s>", Double.valueOf(0.0d)));
        this.f15134g.add(a);
    }

    public final List<String> m19120a(String str, int i) {
        int a = StringLengthHelper.a(str);
        int a2 = StringLengthHelper.a(this.f15133f);
        if (a2 <= a || !this.f15133f.substring(0, a).equals(str)) {
            if (a2 >= a || !str.substring(0, a2).equals(Integer.valueOf(a2))) {
                a = 1;
            } else {
                a = a2 + 1;
            }
        }
        MinMaxPriorityQueue a3 = m19118a(str, a, i);
        List<String> arrayList = new ArrayList();
        for (int i2 = 0; i2 < i && !a3.isEmpty(); i2++) {
            arrayList.add(((BigramDecoderItem) a3.poll()).f15135a);
        }
        this.f15133f = str;
        return arrayList;
    }

    private MinMaxPriorityQueue<BigramDecoderItem> m19118a(String str, int i, int i2) {
        Map hashMap = new HashMap();
        int a = StringLengthHelper.a(str);
        this.f15134g.subList(i, this.f15134g.size()).clear();
        while (i <= a) {
            this.f15134g.add(MinMaxPriorityQueue.a(NaturalOrdering.a).a(i2 * 2).a());
            hashMap.clear();
            int i3 = 1;
            while (i3 <= this.f15131d && i - i3 >= 0) {
                int i4 = i - i3;
                String substring = str.substring(i4, i);
                if (this.f15128a.containsKey(substring)) {
                    Iterator it = ((MinMaxPriorityQueue) this.f15134g.get(i4)).iterator();
                    while (it.hasNext()) {
                        m19119a((BigramDecoderItem) it.next(), substring, hashMap);
                    }
                }
                i3++;
            }
            ((MinMaxPriorityQueue) this.f15134g.get(i)).addAll(hashMap.values());
            i++;
        }
        return m19117a(a, i2);
    }

    private MinMaxPriorityQueue<BigramDecoderItem> m19117a(int i, int i2) {
        MinMaxPriorityQueue<BigramDecoderItem> a = MinMaxPriorityQueue.a(NaturalOrdering.a).a(i2).a();
        Iterator it = ((MinMaxPriorityQueue) this.f15134g.get(i)).iterator();
        while (it.hasNext()) {
            BigramDecoderItem bigramDecoderItem = (BigramDecoderItem) it.next();
            a.add(new BigramDecoderItem(bigramDecoderItem.f15135a, "</s>", Double.valueOf(this.f15130c[((Integer) this.f15129b.get(bigramDecoderItem.f15136b)).intValue()][this.f15132e] + bigramDecoderItem.m19121a().doubleValue())));
        }
        return a;
    }

    private void m19119a(BigramDecoderItem bigramDecoderItem, String str, Map<String, BigramDecoderItem> map) {
        Map map2 = (Map) this.f15128a.get(str);
        String c = bigramDecoderItem.m19124c();
        String b = bigramDecoderItem.m19123b();
        for (Entry entry : map2.entrySet()) {
            String str2 = (String) entry.getKey();
            if (!HindiLanguageUtil.m19108a(c, str2)) {
                double doubleValue = ((Double) entry.getValue()).doubleValue();
                double d = this.f15130c[((Integer) this.f15129b.get(c)).intValue()][((Integer) this.f15129b.get(str2)).intValue()];
                String str3 = b + str2;
                doubleValue = ((doubleValue + bigramDecoderItem.m19121a().doubleValue()) + d) - 8.0d;
                if (map.containsKey(str3)) {
                    ((BigramDecoderItem) map.get(str3)).m19122a(doubleValue);
                } else {
                    map.put(str3, new BigramDecoderItem(str3, str2, Double.valueOf(doubleValue)));
                }
            }
        }
    }
}
