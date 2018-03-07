package com.facebook.feedplugins.musicstory;

import android.net.Uri;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: composer_group_sale_post_intercept_declined */
public class SingleSongData implements CacheableEntity {
    public final String f8225a;
    public final String f8226b;
    public final String f8227c;
    public final String f8228d;
    public final Uri f8229e;
    public final Uri f8230f;
    public final Uri f8231g;
    public final Uri f8232h;
    public final Uri f8233i;
    public final String f8234j;
    public final Uri f8235k;

    /* compiled from: composer_group_sale_post_intercept_declined */
    public class Builder {
        public Uri f8214a;
        @Nullable
        public String f8215b;
        @Nullable
        public String f8216c;
        @Nullable
        public String f8217d;
        @Nullable
        public String f8218e;
        @Nullable
        public Uri f8219f;
        @Nullable
        public Uri f8220g;
        @Nullable
        public Uri f8221h;
        @Nullable
        public String f8222i;
        @Nullable
        public Uri f8223j;
        @Nullable
        public Uri f8224k;

        public Builder(Uri uri) {
            this.f8214a = (Uri) Preconditions.checkNotNull(uri);
        }

        public final SingleSongData m9195a() {
            return new SingleSongData(this);
        }
    }

    public SingleSongData(Builder builder) {
        this.f8225a = builder.f8215b == null ? "" : builder.f8215b;
        this.f8226b = builder.f8216c == null ? "" : builder.f8216c;
        this.f8227c = builder.f8217d == null ? "" : builder.f8217d;
        this.f8228d = builder.f8218e == null ? "" : builder.f8218e;
        this.f8229e = builder.f8219f;
        this.f8230f = builder.f8223j;
        this.f8231g = builder.f8214a;
        this.f8232h = builder.f8220g;
        this.f8233i = builder.f8221h;
        this.f8234j = builder.f8222i;
        this.f8235k = builder.f8224k;
    }

    public final Uri m9197k() {
        return this.f8231g;
    }

    public final String m9196g() {
        return this.f8231g.toString();
    }
}
