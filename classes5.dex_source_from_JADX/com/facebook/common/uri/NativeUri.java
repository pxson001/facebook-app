package com.facebook.common.uri;

import android.os.Bundle;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: after_party_popular_at_ios */
public class NativeUri {
    public String f11177a;
    @Nullable
    public Bundle f11178b;
    @Nullable
    public ImmutableMap<String, Object> f11179c;
    @Nullable
    public NativeAppDetails f11180d;
    public String f11181e;

    /* compiled from: after_party_popular_at_ios */
    public class Builder {
        public String f11172a;
        @Nullable
        public Bundle f11173b;
        @Nullable
        private ImmutableMap<String, Object> f11174c;
        @Nullable
        public NativeAppDetails f11175d;
        public String f11176e;

        public final Builder m19129a(@Nullable Map<String, Object> map) {
            if (map != null) {
                this.f11174c = ImmutableMap.copyOf(map);
            } else {
                this.f11174c = null;
            }
            return this;
        }

        public final NativeUri m19130a() {
            return new NativeUri(this.f11172a, this.f11173b, this.f11174c, this.f11175d, this.f11176e);
        }
    }

    private NativeUri(String str, @Nullable Bundle bundle, @Nullable ImmutableMap<String, Object> immutableMap, @Nullable NativeAppDetails nativeAppDetails, String str2) {
        this.f11177a = str;
        this.f11178b = bundle;
        this.f11179c = immutableMap;
        this.f11180d = nativeAppDetails;
        this.f11181e = str2;
    }

    public final String m19132a() {
        return this.f11177a;
    }

    @Nullable
    public final Bundle m19133b() {
        return this.f11178b;
    }

    @Nullable
    public final ImmutableMap<String, Object> m19134c() {
        return this.f11179c;
    }

    public static Builder m19131f() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        return obj instanceof NativeUri;
    }

    public int hashCode() {
        return 0;
    }
}
