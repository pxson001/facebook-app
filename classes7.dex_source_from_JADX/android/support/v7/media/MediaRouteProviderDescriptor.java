package android.support.v7.media;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: current_song_artist */
public final class MediaRouteProviderDescriptor {
    private final Bundle f16265a;
    private List<MediaRouteDescriptor> f16266b;

    /* compiled from: current_song_artist */
    public final class Builder {
        private final Bundle f16263a = new Bundle();
        private ArrayList<MediaRouteDescriptor> f16264b;

        public final Builder m20331a(MediaRouteDescriptor mediaRouteDescriptor) {
            if (mediaRouteDescriptor == null) {
                throw new IllegalArgumentException("route must not be null");
            }
            if (this.f16264b == null) {
                this.f16264b = new ArrayList();
            } else if (this.f16264b.contains(mediaRouteDescriptor)) {
                throw new IllegalArgumentException("route descriptor already added");
            }
            this.f16264b.add(mediaRouteDescriptor);
            return this;
        }

        public final MediaRouteProviderDescriptor m20332a() {
            if (this.f16264b != null) {
                int size = this.f16264b.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    arrayList.add(((MediaRouteDescriptor) this.f16264b.get(i)).f16249a);
                }
                this.f16263a.putParcelableArrayList("routes", arrayList);
            }
            return new MediaRouteProviderDescriptor(this.f16263a, this.f16264b);
        }
    }

    public MediaRouteProviderDescriptor(Bundle bundle, List<MediaRouteDescriptor> list) {
        this.f16265a = bundle;
        this.f16266b = list;
    }

    public final List<MediaRouteDescriptor> m20335a() {
        m20334c();
        return this.f16266b;
    }

    private void m20334c() {
        if (this.f16266b == null) {
            ArrayList parcelableArrayList = this.f16265a.getParcelableArrayList("routes");
            if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
                this.f16266b = Collections.emptyList();
                return;
            }
            int size = parcelableArrayList.size();
            this.f16266b = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Bundle bundle = (Bundle) parcelableArrayList.get(i);
                this.f16266b.add(bundle != null ? new MediaRouteDescriptor(bundle, null) : null);
            }
        }
    }

    public final boolean m20336b() {
        m20334c();
        int size = this.f16266b.size();
        for (int i = 0; i < size; i++) {
            MediaRouteDescriptor mediaRouteDescriptor = (MediaRouteDescriptor) this.f16266b.get(i);
            if (mediaRouteDescriptor == null || !mediaRouteDescriptor.m20314n()) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MediaRouteProviderDescriptor{ ");
        stringBuilder.append("routes=").append(Arrays.toString(m20335a().toArray()));
        stringBuilder.append(", isValid=").append(m20336b());
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public static MediaRouteProviderDescriptor m20333a(Bundle bundle) {
        return bundle != null ? new MediaRouteProviderDescriptor(bundle, null) : null;
    }
}
