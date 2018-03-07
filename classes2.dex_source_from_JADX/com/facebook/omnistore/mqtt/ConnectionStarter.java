package com.facebook.omnistore.mqtt;

import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.inject.InjectorLike;
import com.facebook.push.mqtt.service.ChannelConnectivityTracker;
import javax.inject.Inject;

/* compiled from: mLoadersStarted= */
public class ConnectionStarter {
    public final ChannelConnectivityTracker mChannelConnectivityTracker;
    public final BaseFbBroadcastManager mLocalBroadcastManager;

    public static ConnectionStarter m22136x34e3561e(InjectorLike injectorLike) {
        return new ConnectionStarter(ChannelConnectivityTracker.m13542a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike));
    }

    @Inject
    public ConnectionStarter(ChannelConnectivityTracker channelConnectivityTracker, BaseFbBroadcastManager baseFbBroadcastManager) {
        this.mChannelConnectivityTracker = channelConnectivityTracker;
        this.mLocalBroadcastManager = baseFbBroadcastManager;
    }
}
