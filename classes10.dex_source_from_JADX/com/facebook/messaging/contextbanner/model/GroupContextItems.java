package com.facebook.messaging.contextbanner.model;

import android.content.res.Resources;
import com.facebook.inject.Assisted;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: story_create */
public class GroupContextItems implements ContextItems {
    private final String f2215a;
    private final int f2216b;
    private final int f2217c;
    private final Resources f2218d;

    @Inject
    public GroupContextItems(@Assisted String str, @Assisted Integer num, @Assisted Integer num2, Resources resources) {
        this.f2215a = str;
        this.f2216b = num.intValue();
        this.f2217c = num2.intValue();
        this.f2218d = resources;
    }

    @Nullable
    public final String mo60a() {
        return this.f2218d.getString(2131241193, new Object[]{this.f2215a});
    }

    @Nullable
    public final String mo61b() {
        if (this.f2216b > 0) {
            return this.f2218d.getQuantityString(2131689788, this.f2216b, new Object[]{Integer.valueOf(this.f2216b)});
        }
        return this.f2218d.getQuantityString(2131689789, this.f2217c, new Object[]{Integer.valueOf(this.f2217c)});
    }

    @Nullable
    public final String mo62c() {
        return null;
    }
}
