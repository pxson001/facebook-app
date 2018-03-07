package android.support.v7.media;

import android.os.Bundle;

/* compiled from: cursor is null */
public final class MediaRouteDiscoveryRequest {
    public final Bundle f16251a;
    private MediaRouteSelector f16252b;

    public MediaRouteDiscoveryRequest(MediaRouteSelector mediaRouteSelector, boolean z) {
        if (mediaRouteSelector == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        this.f16251a = new Bundle();
        this.f16252b = mediaRouteSelector;
        this.f16251a.putBundle("selector", mediaRouteSelector.f16269b);
        this.f16251a.putBoolean("activeScan", z);
    }

    public final MediaRouteSelector m20317a() {
        m20315d();
        return this.f16252b;
    }

    private void m20315d() {
        if (this.f16252b == null) {
            this.f16252b = MediaRouteSelector.m20342a(this.f16251a.getBundle("selector"));
            if (this.f16252b == null) {
                this.f16252b = MediaRouteSelector.f16268a;
            }
        }
    }

    public final boolean m20318b() {
        return this.f16251a.getBoolean("activeScan");
    }

    private boolean m20316e() {
        boolean z;
        m20315d();
        MediaRouteSelector mediaRouteSelector = this.f16252b;
        MediaRouteSelector.m20343e(mediaRouteSelector);
        if (mediaRouteSelector.f16270c.contains(null)) {
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof MediaRouteDiscoveryRequest)) {
            return false;
        }
        MediaRouteDiscoveryRequest mediaRouteDiscoveryRequest = (MediaRouteDiscoveryRequest) obj;
        if (m20317a().equals(mediaRouteDiscoveryRequest.m20317a()) && m20318b() == mediaRouteDiscoveryRequest.m20318b()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (m20318b() ? 1 : 0) ^ m20317a().hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DiscoveryRequest{ selector=").append(m20317a());
        stringBuilder.append(", activeScan=").append(m20318b());
        stringBuilder.append(", isValid=").append(m20316e());
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
