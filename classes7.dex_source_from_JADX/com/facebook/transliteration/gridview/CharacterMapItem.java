package com.facebook.transliteration.gridview;

/* compiled from: event_permalink */
public class CharacterMapItem implements Comparable<CharacterMapItem> {
    public String f15182a;
    public String f15183b;

    public int compareTo(Object obj) {
        return this.f15182a.compareTo(((CharacterMapItem) obj).f15182a);
    }

    public CharacterMapItem(String str, String str2) {
        this.f15182a = str;
        this.f15183b = str2;
    }
}
