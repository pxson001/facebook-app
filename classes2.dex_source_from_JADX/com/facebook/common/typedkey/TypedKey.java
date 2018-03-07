package com.facebook.common.typedkey;

import com.facebook.common.preconditions.Preconditions;

/* compiled from: vnd.android.cursor.item/vnd.com.facebook.katana.provider.contacts */
public abstract class TypedKey<T extends TypedKey> implements Comparable<T> {
    protected final TypedKey<T> f995a;
    protected final String f996b;
    protected String f997c;

    protected abstract T mo317a(TypedKey<T> typedKey, String str);

    public /* synthetic */ int compareTo(Object obj) {
        return m2015c((TypedKey) obj);
    }

    protected TypedKey(String str) {
        Preconditions.m2017b(str != null);
        this.f995a = null;
        this.f996b = str;
        this.f997c = str;
    }

    protected TypedKey(TypedKey<T> typedKey, String str) {
        boolean z;
        boolean z2 = true;
        if (typedKey != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.m2017b(z);
        if (str == null) {
            z2 = false;
        }
        Preconditions.m2017b(z2);
        this.f995a = typedKey;
        this.f996b = str;
    }

    public final String m2012a() {
        if (this.f997c == null) {
            if (this.f995a == null || this.f995a.m2012a() == null) {
                this.f997c = this.f996b;
            } else {
                this.f997c = this.f996b != null ? this.f995a.m2012a().concat(this.f996b) : this.f995a.m2012a();
            }
        }
        return this.f997c;
    }

    public final T m2011a(String str) {
        return mo317a(this, str);
    }

    public final boolean m2013a(T t) {
        return (this.f995a != null && this.f995a.m2013a((TypedKey) t)) || m2012a().startsWith(t.m2012a());
    }

    public final String m2014b(T t) {
        Preconditions.m2017b(m2012a().startsWith(t.m2012a()));
        return m2012a().substring(t.m2012a().length());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r1 = 0;
        r0 = 1;
        if (r4 != r5) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        if (r5 == 0) goto L_0x0011;
    L_0x0007:
        r2 = r4.getClass();
        r3 = r5.getClass();
        if (r2 == r3) goto L_0x0013;
    L_0x0011:
        r0 = r1;
        goto L_0x0004;
    L_0x0013:
        r5 = (com.facebook.common.typedkey.TypedKey) r5;
        r2 = r4.f997c;
        if (r2 != 0) goto L_0x002d;
    L_0x0019:
        r2 = r5.f997c;
        if (r2 != 0) goto L_0x002d;
    L_0x001d:
        r2 = r4.f995a;
        if (r2 != 0) goto L_0x003b;
    L_0x0021:
        r2 = r5.f995a;
        if (r2 != 0) goto L_0x002d;
    L_0x0025:
        r2 = r4.f996b;
        if (r2 != 0) goto L_0x0046;
    L_0x0029:
        r2 = r5.f996b;
        if (r2 == 0) goto L_0x0004;
    L_0x002d:
        r2 = r4.m2012a();
        if (r2 != 0) goto L_0x0051;
    L_0x0033:
        r2 = r5.m2012a();
        if (r2 == 0) goto L_0x0004;
    L_0x0039:
        r0 = r1;
        goto L_0x0004;
    L_0x003b:
        r2 = r4.f995a;
        r3 = r5.f995a;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x002d;
    L_0x0045:
        goto L_0x0025;
    L_0x0046:
        r2 = r4.f996b;
        r3 = r5.f996b;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x002d;
    L_0x0050:
        goto L_0x0004;
    L_0x0051:
        r0 = r4.m2012a();
        r1 = r5.m2012a();
        r0 = r0.equals(r1);
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.typedkey.TypedKey.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        String str;
        int i;
        int i2 = 0;
        if (this.f997c != null) {
            str = this.f997c;
            i = 0;
        } else {
            if (this.f995a != null) {
                i = this.f995a.hashCode();
            } else {
                i = 0;
            }
            str = this.f996b;
        }
        if (str != null) {
            while (i2 < str.length()) {
                i = (i * 31) + str.charAt(i2);
                i2++;
            }
        }
        return i;
    }

    public String toString() {
        return m2012a();
    }

    public final int m2015c(T t) {
        return m2012a().compareTo(t.m2012a());
    }
}
