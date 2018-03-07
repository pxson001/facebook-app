package android.support.v7.media;

import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* compiled from: customBubblingEventTypes */
public final class MediaRouteDescriptor {
    public final Bundle f16249a;
    public List<IntentFilter> f16250b;

    /* compiled from: customBubblingEventTypes */
    public final class Builder {
        public final Bundle f16247a;
        private ArrayList<IntentFilter> f16248b;

        public Builder(String str, String str2) {
            this.f16247a = new Bundle();
            this.f16247a.putString("id", str);
            this.f16247a.putString("name", str2);
        }

        public Builder(MediaRouteDescriptor mediaRouteDescriptor) {
            if (mediaRouteDescriptor == null) {
                throw new IllegalArgumentException("descriptor must not be null");
            }
            this.f16247a = new Bundle(mediaRouteDescriptor.f16249a);
            MediaRouteDescriptor.m20300p(mediaRouteDescriptor);
            if (!mediaRouteDescriptor.f16250b.isEmpty()) {
                this.f16248b = new ArrayList(mediaRouteDescriptor.f16250b);
            }
        }

        private Builder m20291a(IntentFilter intentFilter) {
            if (intentFilter == null) {
                throw new IllegalArgumentException("filter must not be null");
            }
            if (this.f16248b == null) {
                this.f16248b = new ArrayList();
            }
            if (!this.f16248b.contains(intentFilter)) {
                this.f16248b.add(intentFilter);
            }
            return this;
        }

        public final Builder m20293a(Collection<IntentFilter> collection) {
            if (collection == null) {
                throw new IllegalArgumentException("filters must not be null");
            }
            if (!collection.isEmpty()) {
                for (IntentFilter a : collection) {
                    m20291a(a);
                }
            }
            return this;
        }

        public final Builder m20292a(int i) {
            this.f16247a.putInt("playbackType", i);
            return this;
        }

        public final Builder m20295b(int i) {
            this.f16247a.putInt("playbackStream", i);
            return this;
        }

        public final Builder m20296c(int i) {
            this.f16247a.putInt("volume", i);
            return this;
        }

        public final Builder m20297d(int i) {
            this.f16247a.putInt("volumeMax", i);
            return this;
        }

        public final Builder m20298e(int i) {
            this.f16247a.putInt("volumeHandling", i);
            return this;
        }

        public final Builder m20299f(int i) {
            this.f16247a.putInt("presentationDisplayId", i);
            return this;
        }

        public final MediaRouteDescriptor m20294a() {
            if (this.f16248b != null) {
                this.f16247a.putParcelableArrayList("controlFilters", this.f16248b);
            }
            return new MediaRouteDescriptor(this.f16247a, this.f16248b);
        }
    }

    public MediaRouteDescriptor(Bundle bundle, List<IntentFilter> list) {
        this.f16249a = bundle;
        this.f16250b = list;
    }

    public final String m20301a() {
        return this.f16249a.getString("id");
    }

    public final String m20302b() {
        return this.f16249a.getString("name");
    }

    public final String m20303c() {
        return this.f16249a.getString("status");
    }

    public final boolean m20304d() {
        return this.f16249a.getBoolean("enabled", true);
    }

    public final boolean m20305e() {
        return this.f16249a.getBoolean("connecting", false);
    }

    public final List<IntentFilter> m20306f() {
        m20300p(this);
        return this.f16250b;
    }

    public static void m20300p(MediaRouteDescriptor mediaRouteDescriptor) {
        if (mediaRouteDescriptor.f16250b == null) {
            mediaRouteDescriptor.f16250b = mediaRouteDescriptor.f16249a.getParcelableArrayList("controlFilters");
            if (mediaRouteDescriptor.f16250b == null) {
                mediaRouteDescriptor.f16250b = Collections.emptyList();
            }
        }
    }

    public final int m20307g() {
        return this.f16249a.getInt("playbackType", 1);
    }

    public final int m20308h() {
        return this.f16249a.getInt("playbackStream", -1);
    }

    public final int m20309i() {
        return this.f16249a.getInt("volume");
    }

    public final int m20310j() {
        return this.f16249a.getInt("volumeMax");
    }

    public final int m20311k() {
        return this.f16249a.getInt("volumeHandling", 0);
    }

    public final int m20312l() {
        return this.f16249a.getInt("presentationDisplayId", -1);
    }

    public final Bundle m20313m() {
        return this.f16249a.getBundle("extras");
    }

    public final boolean m20314n() {
        m20300p(this);
        if (TextUtils.isEmpty(m20301a()) || TextUtils.isEmpty(m20302b()) || this.f16250b.contains(null)) {
            return false;
        }
        return true;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MediaRouteDescriptor{ ");
        stringBuilder.append("id=").append(m20301a());
        stringBuilder.append(", name=").append(m20302b());
        stringBuilder.append(", description=").append(m20303c());
        stringBuilder.append(", isEnabled=").append(m20304d());
        stringBuilder.append(", isConnecting=").append(m20305e());
        stringBuilder.append(", controlFilters=").append(Arrays.toString(m20306f().toArray()));
        stringBuilder.append(", playbackType=").append(m20307g());
        stringBuilder.append(", playbackStream=").append(m20308h());
        stringBuilder.append(", volume=").append(m20309i());
        stringBuilder.append(", volumeMax=").append(m20310j());
        stringBuilder.append(", volumeHandling=").append(m20311k());
        stringBuilder.append(", presentationDisplayId=").append(m20312l());
        stringBuilder.append(", extras=").append(m20313m());
        stringBuilder.append(", isValid=").append(m20314n());
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
