package com.facebook.common.hardware;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.os.SystemClock;
import android.support.v4.net.ConnectivityManagerCompat;
import com.facebook.common.flightrecorder.FlightRecorderEvent;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: sphericalPlayableUrlSdString */
public class NetworkConnectionChanged implements FlightRecorderEvent {
    public final NetworkInfoContainer f2606a;
    private final long f2607b = SystemClock.uptimeMillis();
    public final int f2608c;
    public final boolean f2609d;

    /* compiled from: sphericalPlayableUrlSdString */
    public class NetworkInfoContainer {
        public final NetworkInfo f2605a;

        public NetworkInfoContainer(NetworkInfo networkInfo) {
            this.f2605a = (NetworkInfo) Preconditions.checkNotNull(networkInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NetworkInfoContainer)) {
                return false;
            }
            NetworkInfoContainer networkInfoContainer = (NetworkInfoContainer) obj;
            if (this.f2605a.getType() == networkInfoContainer.f2605a.getType() && this.f2605a.getSubtype() == networkInfoContainer.f2605a.getSubtype() && this.f2605a.getState().equals(networkInfoContainer.f2605a.getState()) && Objects.equal(this.f2605a.getReason(), networkInfoContainer.f2605a.getReason()) && this.f2605a.isRoaming() == networkInfoContainer.f2605a.isRoaming() && this.f2605a.isFailover() == networkInfoContainer.f2605a.isFailover() && this.f2605a.isAvailable() == networkInfoContainer.f2605a.isAvailable()) {
                return true;
            }
            return false;
        }
    }

    public NetworkConnectionChanged(@Nullable NetworkInfo networkInfo, int i, ConnectivityManager connectivityManager) {
        this.f2608c = i;
        this.f2606a = networkInfo != null ? new NetworkInfoContainer(networkInfo) : null;
        this.f2609d = ConnectivityManagerCompat.a(connectivityManager);
    }

    public long getStartTime() {
        return this.f2607b;
    }

    public final int m3718b() {
        return this.f2608c;
    }

    @Nullable
    public final DetailedState m3719c() {
        return this.f2606a == null ? null : this.f2606a.f2605a.getDetailedState();
    }

    public final String m3717a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NetworkInfo{");
        if (this.f2606a != null) {
            String str;
            NetworkInfo networkInfo = this.f2606a.f2605a;
            StringBuilder append = stringBuilder.append("type: ").append(networkInfo.getTypeName()).append("[").append(networkInfo.getSubtypeName()).append("], state: ").append(networkInfo.getState().toString()).append("/").append(networkInfo.getDetailedState().toString()).append(", reason: ");
            if (networkInfo.getReason() == null) {
                str = "(unspecified)";
            } else {
                str = networkInfo.getReason();
            }
            append.append(str).append(", roaming: ").append(networkInfo.isRoaming()).append(", failover: ").append(networkInfo.isFailover()).append(", isAvailable: ").append(networkInfo.isAvailable());
            stringBuilder.append(", isMetered: ").append(this.f2609d);
        } else {
            stringBuilder.append("(none)");
        }
        stringBuilder.append("}");
        stringBuilder.append("; ");
        stringBuilder.append("inetCond: " + (this.f2608c >= 0 ? Integer.valueOf(this.f2608c) : "(unknown)"));
        return stringBuilder.toString();
    }
}
