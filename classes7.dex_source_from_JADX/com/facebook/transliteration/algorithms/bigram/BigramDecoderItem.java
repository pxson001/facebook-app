package com.facebook.transliteration.algorithms.bigram;

/* compiled from: extra_composer_life_event_custom */
public class BigramDecoderItem implements Comparable<BigramDecoderItem> {
    public String f15135a;
    public String f15136b;
    private double f15137c;

    public int compareTo(Object obj) {
        return m19121a().compareTo(((BigramDecoderItem) obj).m19121a()) * -1;
    }

    public BigramDecoderItem(String str, String str2, Double d) {
        this.f15135a = str;
        this.f15136b = str2;
        this.f15137c = d.doubleValue();
    }

    public final Double m19121a() {
        return Double.valueOf(this.f15137c);
    }

    public final String m19123b() {
        return this.f15135a;
    }

    public final String m19124c() {
        return this.f15136b;
    }

    public final void m19122a(double d) {
        double d2 = this.f15137c;
        if (d2 > d) {
            this.f15137c = d2 + Math.log1p(Math.exp(d - d2));
        } else {
            this.f15137c = Math.log1p(Math.exp(d2 - d)) + d;
        }
    }
}
