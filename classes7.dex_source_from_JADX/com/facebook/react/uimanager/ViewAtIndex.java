package com.facebook.react.uimanager;

import java.util.Comparator;

/* compiled from: frame */
class ViewAtIndex {
    public static Comparator<ViewAtIndex> f11859a = new C10451();
    public final int f11860b;
    public final int f11861c;

    /* compiled from: frame */
    final class C10451 implements Comparator<ViewAtIndex> {
        C10451() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((ViewAtIndex) obj).f11861c - ((ViewAtIndex) obj2).f11861c;
        }
    }

    public ViewAtIndex(int i, int i2) {
        this.f11860b = i;
        this.f11861c = i2;
    }
}
