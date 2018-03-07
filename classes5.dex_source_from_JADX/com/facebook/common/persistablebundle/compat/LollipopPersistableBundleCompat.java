package com.facebook.common.persistablebundle.compat;

import android.os.PersistableBundle;

/* compiled from: show_even_if_installed */
public class LollipopPersistableBundleCompat extends PersistableBundleCompat {
    public PersistableBundle f2723a = new PersistableBundle();

    LollipopPersistableBundleCompat() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof LollipopPersistableBundleCompat) {
            return this.f2723a.equals(((LollipopPersistableBundleCompat) obj).f2723a);
        }
        return false;
    }

    public int hashCode() {
        return this.f2723a.hashCode();
    }

    public String toString() {
        return this.f2723a.toString();
    }
}
