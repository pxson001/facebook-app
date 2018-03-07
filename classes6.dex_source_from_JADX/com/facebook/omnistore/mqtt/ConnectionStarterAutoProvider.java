package com.facebook.omnistore.mqtt;

import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.inject.AbstractProvider;
import com.facebook.push.mqtt.service.ChannelConnectivityTracker;

/* compiled from: target_post */
public class ConnectionStarterAutoProvider extends AbstractProvider<ConnectionStarter> {
    public /* bridge */ /* synthetic */ Object get() {
        return new ConnectionStarter(ChannelConnectivityTracker.a(this), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(this));
    }
}
