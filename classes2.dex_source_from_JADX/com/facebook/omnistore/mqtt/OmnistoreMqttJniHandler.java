package com.facebook.omnistore.mqtt;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.C0259xe99f8445;
import com.facebook.common.executors.DefaultSerialListeningExecutorService;
import com.facebook.inject.InjectorLike;
import com.facebook.jni.Countable;
import com.facebook.omnistore.MqttProtocolProvider;
import com.facebook.omnistore.Prerequisites;
import com.facebook.omnistore.mqtt.ConnectionStarter.1;
import com.facebook.proguard.annotations.DoNotStrip;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@DoNotStrip
@Singleton
/* compiled from: mLock */
public class OmnistoreMqttJniHandler extends Countable {
    private static final String TAG = "OmnistoreMqttJniHandler";
    private static volatile OmnistoreMqttJniHandler f15515x836785e4;
    private final ConnectionStarter mConnectionStarter;
    private final DefaultSerialListeningExecutorService mExecutorService;
    public final AbstractFbErrorReporter mFbErrorReporter;
    private final MessagePublisher mMessagePublisher;
    @Nullable
    private MqttProtocolProvider mMqttProtocolProviderInstance;

    private native MqttProtocolProvider doGetJavaMqtt();

    private native void doHandleOmnistoreSyncMessage(byte[] bArr);

    public static com.facebook.omnistore.mqtt.OmnistoreMqttJniHandler m22135x6c6febe4(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f15515x836785e4;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.omnistore.mqtt.OmnistoreMqttJniHandler.class;
        monitor-enter(r1);
        r0 = f15515x836785e4;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m22134x6112327e(r0);	 Catch:{ all -> 0x0035 }
        f15515x836785e4 = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15515x836785e4;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.omnistore.mqtt.OmnistoreMqttJniHandler.getInstance__com_facebook_omnistore_mqtt_OmnistoreMqttJniHandler__INJECTED_BY_TemplateInjector(com.facebook.inject.InjectorLike):com.facebook.omnistore.mqtt.OmnistoreMqttJniHandler");
    }

    private native void onConnectionEstablished();

    private native void onPublishAcked(PublishCallback publishCallback);

    private native void onPublishFailed(PublishCallback publishCallback);

    private static OmnistoreMqttJniHandler m22134x6112327e(InjectorLike injectorLike) {
        return new OmnistoreMqttJniHandler(C0259xe99f8445.m9408b(injectorLike), ConnectionStarter.m22136x34e3561e(injectorLike), MessagePublisher.m22137xa42df3f6(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public OmnistoreMqttJniHandler(DefaultSerialListeningExecutorService defaultSerialListeningExecutorService, ConnectionStarter connectionStarter, MessagePublisher messagePublisher, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.mExecutorService = defaultSerialListeningExecutorService;
        this.mConnectionStarter = connectionStarter;
        this.mMessagePublisher = messagePublisher;
        this.mFbErrorReporter = abstractFbErrorReporter;
    }

    public MqttProtocolProvider getJavaMqtt() {
        ensureInitialized();
        return this.mMqttProtocolProviderInstance;
    }

    public void handleOmnistoreSyncMessage(byte[] bArr) {
        ensureInitialized();
        doHandleOmnistoreSyncMessage(bArr);
    }

    private synchronized void ensureInitialized() {
        if (this.mMqttProtocolProviderInstance == null) {
            Prerequisites.ensure();
            this.mMqttProtocolProviderInstance = doGetJavaMqtt();
        }
    }

    @DoNotStrip
    private void ensureConnection() {
        ConnectionStarter connectionStarter = this.mConnectionStarter;
        1 1 = new 1(this);
        connectionStarter.mLocalBroadcastManager.m2951a().mo506a("com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED", new 1(connectionStarter, 1)).mo503a().m3296b();
        if (connectionStarter.mChannelConnectivityTracker.m13552e()) {
            1.onConnectionEstablished();
        }
    }

    @DoNotStrip
    private void publishMessage(String str, byte[] bArr, PublishCallback publishCallback) {
        Futures.m2458a(this.mExecutorService.mo271a((Callable) new MessagePublisher.1(this.mMessagePublisher, str, bArr)), new 2(this, str, publishCallback), this.mExecutorService);
    }
}
