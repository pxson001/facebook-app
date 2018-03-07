package com.facebook.ui.images.fetch;

import android.net.Uri;
import android.net.Uri.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import javax.annotation.Nonnull;

/* compiled from: measurement.service_enabled */
public class ImageReferrer {
    private final String f14719a;
    private final ImmutableList<String> f14720b;

    public ImageReferrer(@Nonnull String str, @Nonnull ImmutableList<String> immutableList) {
        Preconditions.checkNotNull(immutableList);
        Preconditions.checkArgument(!immutableList.isEmpty());
        this.f14720b = immutableList;
        this.f14719a = (String) Preconditions.checkNotNull(str);
    }

    public final Uri m21137a() {
        Builder authority = new Builder().scheme("fbapp").authority(this.f14719a);
        Iterator it = this.f14720b.iterator();
        while (it.hasNext()) {
            authority.appendPath(((String) it.next()).toString());
        }
        return authority.build();
    }
}
