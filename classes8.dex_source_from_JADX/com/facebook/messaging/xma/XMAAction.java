package com.facebook.messaging.xma;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.messaging.business.common.calltoaction.CallToActionContainerView.1.1;
import javax.annotation.Nullable;

/* compiled from: timeout_niem */
public class XMAAction {
    @Nullable
    public final 1 f1570a;
    public final String f1571b;
    public final Bundle f1572c;

    public XMAAction(String str, @Nullable Bundle bundle) {
        this(str, bundle, null);
    }

    public XMAAction(String str, @Nullable Bundle bundle, @Nullable 1 1) {
        this.f1571b = str;
        this.f1572c = new Bundle();
        if (bundle != null) {
            this.f1572c.putAll(bundle);
        }
        this.f1570a = 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof XMAAction)) {
            return false;
        }
        return ((XMAAction) obj).f1571b.equals(this.f1571b);
    }

    public int hashCode() {
        return this.f1571b.hashCode();
    }

    public final <T extends Parcelable> T m1742a(String str) {
        return this.f1572c.getParcelable(str);
    }
}
