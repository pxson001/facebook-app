package com.facebook.securitycheckup.password;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: http80 */
public class PasswordStrengthScheme {
    private double f9891a;
    private ImmutableMap<Character, Double> f9892b;
    private double f9893c;
    private boolean f9894d;
    private boolean f9895e;
    private ImmutableMap<Character, Character> f9896f;
    private ImmutableMap<String, Double> f9897g;
    private ImmutableMap<String, Double> f9898h;

    /* compiled from: http80 */
    public class Builder {
        public double f9883a;
        public ImmutableMap<Character, Double> f9884b;
        public double f9885c;
        public boolean f9886d;
        public boolean f9887e;
        public ImmutableMap<Character, Character> f9888f;
        public ImmutableMap<String, Double> f9889g;
        public ImmutableMap<String, Double> f9890h;

        public final Builder m10046a(ImmutableMap<Character, Double> immutableMap) {
            this.f9884b = ImmutableMap.copyOf(immutableMap);
            return this;
        }

        public final Builder m10045a(ImmutableList<String> immutableList, double d) {
            this.f9889g = m10044a(immutableList, d, 2);
            return this;
        }

        public final Builder m10047b(ImmutableList<String> immutableList, double d) {
            this.f9890h = m10044a(immutableList, d, 3);
            return this;
        }

        private static ImmutableMap<String, Double> m10044a(ImmutableList<String> immutableList, double d, int i) {
            Map hashMap = new HashMap();
            int size = immutableList.size();
            int i2 = 0;
            int i3 = 1;
            while (i2 < size) {
                String str = (String) immutableList.get(i2);
                int i4 = 0;
                while (i4 < str.length()) {
                    hashMap.put(str.substring(i4, i4 + i), Double.valueOf(((double) i3) * d));
                    i4 += i;
                }
                i2++;
                i3++;
            }
            return ImmutableMap.copyOf(hashMap);
        }

        public final PasswordStrengthScheme m10048i() {
            return new PasswordStrengthScheme(this);
        }
    }

    public PasswordStrengthScheme(Builder builder) {
        this.f9891a = builder.f9883a;
        this.f9892b = builder.f9884b;
        this.f9893c = builder.f9885c;
        this.f9894d = builder.f9886d;
        this.f9895e = builder.f9887e;
        this.f9896f = builder.f9888f;
        this.f9897g = builder.f9889g;
        this.f9898h = builder.f9890h;
    }

    public final double m10050a(String str) {
        int i;
        int i2 = 0;
        String b = m10049b(str);
        List arrayList = new ArrayList();
        Map hashMap = new HashMap();
        for (i = 0; i < b.length(); i++) {
            arrayList.add(Double.valueOf(this.f9892b.containsKey(Character.valueOf(b.charAt(i))) ? ((Double) this.f9892b.get(Character.valueOf(b.charAt(i)))).doubleValue() : this.f9891a));
        }
        for (i = 0; i < b.length() - 1; i++) {
            String substring = b.substring(i, i + 2);
            if (this.f9897g.containsKey(substring)) {
                arrayList.set(i + 1, Double.valueOf(((Double) arrayList.get(i + 1)).doubleValue() - ((Double) this.f9897g.get(substring)).doubleValue()));
            }
            if (hashMap.containsKey(substring)) {
                arrayList.set(i + 1, Double.valueOf(((Double) arrayList.get(i + 1)).doubleValue() - (Math.sqrt((double) ((Integer) hashMap.get(substring)).intValue()) * this.f9893c)));
                hashMap.put(substring, Integer.valueOf(((Integer) hashMap.get(substring)).intValue() + 1));
            } else {
                hashMap.put(substring, Integer.valueOf(1));
            }
        }
        for (i = 0; i < b.length() - 2; i++) {
            substring = b.substring(i, i + 3);
            if (this.f9898h.containsKey(substring)) {
                arrayList.set(i + 2, Double.valueOf(((Double) arrayList.get(i + 2)).doubleValue() - ((Double) this.f9898h.get(substring)).doubleValue()));
            }
        }
        int i3 = 0;
        while (i2 < b.length()) {
            i3 = (int) (Math.max(((Double) arrayList.get(i2)).doubleValue(), 0.0d) + ((double) i3));
            i2++;
        }
        return (double) i3;
    }

    private String m10049b(String str) {
        String str2 = "";
        if (this.f9894d) {
            return str.toLowerCase();
        }
        if (!this.f9895e) {
            return str;
        }
        String str3 = str2;
        for (int i = 0; i < str.length(); i++) {
            if (this.f9896f.containsKey(Character.valueOf(str.charAt(i)))) {
                str3 = str3 + this.f9896f.get(Character.valueOf(str.charAt(i)));
            } else {
                str3 = str3 + str.charAt(i);
            }
        }
        return str3;
    }
}
