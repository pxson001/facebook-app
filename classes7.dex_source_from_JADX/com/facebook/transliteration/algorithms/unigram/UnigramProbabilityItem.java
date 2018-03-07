package com.facebook.transliteration.algorithms.unigram;

/* compiled from: expirationKey */
public class UnigramProbabilityItem implements Comparable<UnigramProbabilityItem> {
    private String f15146a;
    private double f15147b;

    public int compareTo(Object obj) {
        return m19143b().compareTo(((UnigramProbabilityItem) obj).m19143b());
    }

    public UnigramProbabilityItem(String str, double d) {
        this.f15146a = str;
        this.f15147b = d;
    }

    public final String m19142a() {
        return this.f15146a;
    }

    public final Double m19143b() {
        return Double.valueOf(this.f15147b);
    }
}
