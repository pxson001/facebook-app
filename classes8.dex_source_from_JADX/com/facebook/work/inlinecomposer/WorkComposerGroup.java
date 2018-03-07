package com.facebook.work.inlinecomposer;

import android.net.Uri;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: location_opt_in_feed_unit_vpv */
public final class WorkComposerGroup {
    public final String f9912a;
    public final String f9913b;
    public final Uri f9914c;

    public WorkComposerGroup(String str, String str2, Uri uri) {
        this.f9912a = (String) Preconditions.checkNotNull(str);
        this.f9913b = str2;
        this.f9914c = uri;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof WorkComposerGroup)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return ((WorkComposerGroup) obj).f9912a.equals(this.f9912a);
    }

    public final int hashCode() {
        return this.f9912a.hashCode();
    }
}
