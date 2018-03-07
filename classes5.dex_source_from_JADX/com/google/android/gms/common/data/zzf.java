package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T> extends AbstractDataBuffer<T> {
    private boolean f6493b = false;
    private ArrayList<Integer> f6494c;

    protected zzf(DataHolder dataHolder) {
        super(dataHolder);
    }

    private int m12181b(int i) {
        if (i >= 0 && i < this.f6494c.size()) {
            return ((Integer) this.f6494c.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    private int m12182c(int i) {
        if (i < 0 || i == this.f6494c.size()) {
            return 0;
        }
        int intValue = i == this.f6494c.size() + -1 ? this.f6461a.f6477c - ((Integer) this.f6494c.get(i)).intValue() : ((Integer) this.f6494c.get(i + 1)).intValue() - ((Integer) this.f6494c.get(i)).intValue();
        if (intValue != 1) {
            return intValue;
        }
        int b = m12181b(i);
        String str = null;
        return (str == null || this.f6461a.m12165c(str, b, this.f6461a.m12161a(b)) != null) ? intValue : 0;
    }

    private void m12183e() {
        synchronized (this) {
            if (!this.f6493b) {
                int g = this.f6461a.m12169g();
                this.f6494c = new ArrayList();
                if (g > 0) {
                    this.f6494c.add(Integer.valueOf(0));
                    String d = m12187d();
                    String c = this.f6461a.m12165c(d, 0, this.f6461a.m12161a(0));
                    int i = 1;
                    while (i < g) {
                        int a = this.f6461a.m12161a(i);
                        String c2 = this.f6461a.m12165c(d, i, a);
                        if (c2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + d + ", at row: " + i + ", for window: " + a);
                        }
                        if (c2.equals(c)) {
                            c2 = c;
                        } else {
                            this.f6494c.add(Integer.valueOf(i));
                        }
                        i++;
                        c = c2;
                    }
                }
                this.f6493b = true;
            }
        }
    }

    public final int mo735a() {
        m12183e();
        return this.f6494c.size();
    }

    public final T mo739a(int i) {
        m12183e();
        return m12186a(m12181b(i), m12182c(i));
    }

    protected abstract T m12186a(int i, int i2);

    protected abstract String m12187d();
}
