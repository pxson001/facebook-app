package com.facebook.loom.module;

import com.facebook.common.init.INeedInit;
import com.facebook.loom.config.ConfigProvider;
import com.facebook.loom.config.DefaultConfigProvider;
import com.facebook.loom.config.OverlayConfigProvider;
import com.facebook.loom.core.BackgroundUploadService;
import com.facebook.loom.core.TraceOrchestrator;
import com.facebook.loom.core.TraceOrchestrator.LoomBridgeFactory;
import com.facebook.loom.core.TraceOrchestrator.LoomListener;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import javax.inject.Inject;

/* compiled from: time_since_session_start */
public class LoomBridgeFactoryImpl implements INeedInit, LoomBridgeFactory {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<LoomBridge> f2822a = UltralightRuntime.f368b;

    @Inject
    public LoomBridgeFactoryImpl(LoomBridge loomBridge) {
    }

    public void init() {
        TraceOrchestrator.b().a(this);
    }

    public final BackgroundUploadService m4824a() {
        return (BackgroundUploadService) ((LoomBridge) this.f2822a.get()).f2823a.get();
    }

    public final ConfigProvider m4825b() {
        return new OverlayConfigProvider((ConfigProvider) ((LoomBridge) this.f2822a.get()).f2824b.get(), new DefaultConfigProvider());
    }

    public final LoomListener m4826c() {
        return (LoomListener) ((LoomBridge) this.f2822a.get()).f2825c.get();
    }
}
