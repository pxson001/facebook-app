package android.support.v7.media;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* compiled from: current_index */
public final class MediaRouteSelector {
    public static final MediaRouteSelector f16268a = new MediaRouteSelector(new Bundle(), null);
    public final Bundle f16269b;
    public List<String> f16270c;

    /* compiled from: current_index */
    public final class Builder {
        private ArrayList<String> f16267a;

        public Builder(@NonNull MediaRouteSelector mediaRouteSelector) {
            if (mediaRouteSelector == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            MediaRouteSelector.m20343e(mediaRouteSelector);
            if (!mediaRouteSelector.f16270c.isEmpty()) {
                this.f16267a = new ArrayList(mediaRouteSelector.f16270c);
            }
        }

        @NonNull
        public final Builder m20340a(@NonNull String str) {
            if (str == null) {
                throw new IllegalArgumentException("category must not be null");
            }
            if (this.f16267a == null) {
                this.f16267a = new ArrayList();
            }
            if (!this.f16267a.contains(str)) {
                this.f16267a.add(str);
            }
            return this;
        }

        @NonNull
        private Builder m20338a(@NonNull Collection<String> collection) {
            if (collection == null) {
                throw new IllegalArgumentException("categories must not be null");
            }
            if (!collection.isEmpty()) {
                for (String a : collection) {
                    m20340a(a);
                }
            }
            return this;
        }

        @NonNull
        public final Builder m20339a(@NonNull MediaRouteSelector mediaRouteSelector) {
            if (mediaRouteSelector == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            m20338a(mediaRouteSelector.m20344a());
            return this;
        }

        @NonNull
        public final MediaRouteSelector m20341a() {
            if (this.f16267a == null) {
                return MediaRouteSelector.f16268a;
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("controlCategories", this.f16267a);
            return new MediaRouteSelector(bundle, this.f16267a);
        }
    }

    public MediaRouteSelector(Bundle bundle, List<String> list) {
        this.f16269b = bundle;
        this.f16270c = list;
    }

    public final List<String> m20344a() {
        m20343e(this);
        return this.f16270c;
    }

    public static void m20343e(MediaRouteSelector mediaRouteSelector) {
        if (mediaRouteSelector.f16270c == null) {
            mediaRouteSelector.f16270c = mediaRouteSelector.f16269b.getStringArrayList("controlCategories");
            if (mediaRouteSelector.f16270c == null || mediaRouteSelector.f16270c.isEmpty()) {
                mediaRouteSelector.f16270c = Collections.emptyList();
            }
        }
    }

    public final boolean m20345b() {
        m20343e(this);
        return this.f16270c.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof MediaRouteSelector)) {
            return false;
        }
        MediaRouteSelector mediaRouteSelector = (MediaRouteSelector) obj;
        m20343e(this);
        m20343e(mediaRouteSelector);
        return this.f16270c.equals(mediaRouteSelector.f16270c);
    }

    public final int hashCode() {
        m20343e(this);
        return this.f16270c.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MediaRouteSelector{ ");
        stringBuilder.append("controlCategories=").append(Arrays.toString(m20344a().toArray()));
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public static MediaRouteSelector m20342a(@Nullable Bundle bundle) {
        return bundle != null ? new MediaRouteSelector(bundle, null) : null;
    }
}
