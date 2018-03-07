package com.facebook.common.persistablebundle.compat;

import android.os.Bundle;

/* compiled from: show_attachment_preview */
public class PreLollipopPersistableBundleCompat extends PersistableBundleCompat {
    public final Bundle f2724a = new Bundle();

    PreLollipopPersistableBundleCompat() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof PreLollipopPersistableBundleCompat) {
            return this.f2724a.equals(((PreLollipopPersistableBundleCompat) obj).f2724a);
        }
        return false;
    }

    public int hashCode() {
        return this.f2724a.hashCode();
    }

    public String toString() {
        return this.f2724a.toString();
    }
}
