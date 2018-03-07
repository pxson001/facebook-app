package com.facebook.contextual.network;

import com.facebook.common.network.ServerConnectionQualityManager;
import com.facebook.common.network.ServerConnectionQualityManager.ServerConnectionQualityManagerStateChangeListener;
import com.facebook.contextual.ContextHandler;
import com.facebook.contextual.ContextValue;
import com.facebook.contextual.ContextsProvider;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.http.observer.DownloadBandwidthManager;
import com.facebook.http.observer.DownloadBandwidthManager.DownloadBandwidthManagerStateChangeListener;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Locale;

/* compiled from: stale_contact_import */
public class NetworkQualityContextsProvider implements ServerConnectionQualityManagerStateChangeListener, ContextsProvider, DownloadBandwidthManagerStateChangeListener {
    private ContextValue f1914a;
    private ContextValue f1915b;

    public NetworkQualityContextsProvider(DownloadBandwidthManager downloadBandwidthManager, ServerConnectionQualityManager serverConnectionQualityManager) {
        this.f1914a = new ContextValue(downloadBandwidthManager.a(this).name().toLowerCase(Locale.US));
        this.f1915b = new ContextValue(serverConnectionQualityManager.a(this).name().toLowerCase(Locale.US));
    }

    public final List<ContextHandler> mo134a() {
        return ImmutableList.of(new ContextHandler("bandwidth_class", this, 1), new ContextHandler("latency_class", this, 2));
    }

    public final ContextValue mo133a(long j) {
        switch ((int) (-1 & j)) {
            case 1:
                return this.f1914a;
            case 2:
                return this.f1915b;
            default:
                return null;
        }
    }

    public final void m1972a(ConnectionQuality connectionQuality) {
        this.f1914a = new ContextValue(connectionQuality.name().toLowerCase(Locale.US));
    }

    public final void m1973b(ConnectionQuality connectionQuality) {
        this.f1915b = new ContextValue(connectionQuality.name().toLowerCase(Locale.US));
    }
}
