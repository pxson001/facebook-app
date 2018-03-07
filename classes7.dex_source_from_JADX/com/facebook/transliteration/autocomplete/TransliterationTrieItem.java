package com.facebook.transliteration.autocomplete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: expand_prompt */
public class TransliterationTrieItem {
    public static String f15153a = "";
    public double f15154b = 0.0d;
    public String f15155c = null;
    public HashMap<Character, TransliterationTrieItem> f15156d = new HashMap();
    public boolean f15157e = false;

    public final void m19156a(String str, String str2) {
        m19153a(str, str2, 0);
    }

    private void m19153a(String str, String str2, int i) {
        if (i != 0) {
            double length = (((double) i) * 1.0d) / ((double) str.length());
            if (length >= this.f15154b) {
                this.f15154b = length;
                this.f15155c = str2;
            }
        }
        if (i == str.length()) {
            this.f15157e = true;
            return;
        }
        Character valueOf = Character.valueOf(str.charAt(i));
        if (this.f15156d.containsKey(valueOf)) {
            ((TransliterationTrieItem) this.f15156d.get(valueOf)).m19153a(str, str2, i + 1);
            return;
        }
        TransliterationTrieItem transliterationTrieItem = new TransliterationTrieItem();
        transliterationTrieItem.m19153a(str, str2, i + 1);
        this.f15156d.put(valueOf, transliterationTrieItem);
    }

    public final String m19154a(String str) {
        return m19151a(str, 0);
    }

    private String m19151a(String str, int i) {
        if (i == str.length()) {
            return this.f15157e ? this.f15155c : f15153a;
        } else {
            Character valueOf = Character.valueOf(str.charAt(i));
            if (this.f15156d.containsKey(valueOf)) {
                return ((TransliterationTrieItem) this.f15156d.get(valueOf)).m19151a(str, i + 1);
            }
            return f15153a;
        }
    }

    public final List<String> m19155a(String str, double d) {
        return m19152a(str, d, 0);
    }

    private List<String> m19152a(String str, double d, int i) {
        if (i != str.length()) {
            Character valueOf = Character.valueOf(str.charAt(i));
            if (this.f15156d.containsKey(valueOf)) {
                return ((TransliterationTrieItem) this.f15156d.get(valueOf)).m19152a(str, d, i + 1);
            }
            return new ArrayList();
        } else if (this.f15154b < d) {
            return new ArrayList();
        } else {
            List<String> arrayList = new ArrayList();
            if (this.f15157e) {
                arrayList.add(this.f15155c);
            }
            for (Entry value : this.f15156d.entrySet()) {
                TransliterationTrieItem transliterationTrieItem = (TransliterationTrieItem) value.getValue();
                if (transliterationTrieItem.f15154b >= d) {
                    arrayList.add(transliterationTrieItem.f15155c);
                }
            }
            return arrayList;
        }
    }
}
