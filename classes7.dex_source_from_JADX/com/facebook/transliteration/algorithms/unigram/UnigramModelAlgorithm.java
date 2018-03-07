package com.facebook.transliteration.algorithms.unigram;

import com.facebook.transliteration.algorithms.TransliterationAlgorithm;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: external_image */
public class UnigramModelAlgorithm implements TransliterationAlgorithm {
    public int f15140a;
    public UnigramLanguageModel f15141b;
    public HindiUnicodeUtil f15142c;

    @Inject
    public UnigramModelAlgorithm(HindiUnicodeUtil hindiUnicodeUtil) {
        this.f15142c = hindiUnicodeUtil;
    }

    public final ImmutableMap<String, String> mo1171a() {
        UnigramLanguageModel unigramLanguageModel = this.f15141b;
        Map hashMap = new HashMap();
        for (Entry entry : unigramLanguageModel.mModel.entrySet()) {
            hashMap.put(((UnigramModelDataItem) entry.getValue()).mStandardEmission, (String) entry.getKey());
        }
        return ImmutableMap.copyOf(hashMap);
    }

    private String m19130a(String str) {
        if (this.f15141b.mModel.containsKey(str)) {
            return str;
        }
        str = str.toLowerCase(Locale.US);
        return !this.f15141b.mModel.containsKey(str) ? null : str;
    }

    private void m19132a(List<String> list, String str, Integer num, String str2) {
        String a;
        if (num.intValue() == str2.length()) {
            if (str != null) {
                a = m19130a(str);
                if (a != null) {
                    list.add(a);
                }
            }
        } else if (str == null) {
            m19132a(list, str2.substring(num.intValue(), num.intValue() + 1), Integer.valueOf(num.intValue() + 1), str2);
        } else {
            a = str + str2.charAt(num.intValue());
            String a2 = m19130a(a);
            if (a2 == null) {
                list.add(m19130a(str));
                m19132a(list, str2.substring(num.intValue(), num.intValue() + 1), Integer.valueOf(num.intValue() + 1), str2);
            } else if (a2.length() >= this.f15140a) {
                list.add(a2);
                m19132a(list, null, Integer.valueOf(num.intValue() + 1), str2);
            } else {
                m19132a(list, a, Integer.valueOf(num.intValue() + 1), str2);
            }
        }
    }

    private List<String> m19133b(String str) {
        List<String> arrayList = new ArrayList();
        m19132a(arrayList, null, Integer.valueOf(0), str);
        return arrayList;
    }

    private List<String> m19131a(List<String> list, int i) {
        List arrayList = new ArrayList();
        arrayList.add(new UnigramProbabilityItem("", 1.0d));
        List list2 = arrayList;
        for (String str : list) {
            List arrayList2 = new ArrayList();
            UnigramModelDataItem unigramModelDataItem = (UnigramModelDataItem) this.f15141b.mModel.get(str);
            if (unigramModelDataItem != null) {
                UnmodifiableIterator it = unigramModelDataItem.mEmissions.entrySet().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    for (UnigramProbabilityItem unigramProbabilityItem : r5) {
                        arrayList2.add(new UnigramProbabilityItem(unigramProbabilityItem.m19142a() + ((String) entry.getKey()), unigramProbabilityItem.m19143b().doubleValue() * ((Double) entry.getValue()).doubleValue()));
                    }
                }
                Collections.sort(arrayList2);
                if (arrayList2.size() > i * 2) {
                    arrayList = arrayList2.subList(arrayList2.size() - (i * 2), arrayList2.size());
                } else {
                    arrayList = arrayList2;
                }
                list2 = arrayList;
            }
        }
        Collections.reverse(r5);
        if (r5.size() > i) {
            list2 = r5.subList(0, i);
        }
        List<String> arrayList3 = new ArrayList();
        for (UnigramProbabilityItem a : r5) {
            arrayList3.add(this.f15142c.m19127a(a.m19142a()));
        }
        return arrayList3;
    }

    public final List<String> mo1172a(String str, int i) {
        int i2 = i + 1;
        Collection linkedHashSet = new LinkedHashSet();
        List<String> b = m19133b(str);
        String str2 = "";
        for (String str3 : b) {
            UnigramModelDataItem unigramModelDataItem = (UnigramModelDataItem) this.f15141b.mModel.get(str3);
            if (unigramModelDataItem != null) {
                str2 = str2 + unigramModelDataItem.mStandardEmission;
            } else {
                str2 = str2 + str3;
            }
        }
        linkedHashSet.add(this.f15142c.m19127a(str2));
        if (i > 0 && linkedHashSet.size() < i2) {
            linkedHashSet.addAll(m19131a((List) b, i2));
        }
        List<String> arrayList = new ArrayList(linkedHashSet);
        if (arrayList.size() > i2) {
            return arrayList.subList(0, i2);
        }
        return arrayList;
    }
}
