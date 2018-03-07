package com.facebook.sync.connection;

import android.content.Context;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.util.Hex;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.Lazy;
import com.facebook.push.mqtt.service.MqttPushServiceClient;
import com.facebook.push.mqtt.service.MqttPushServiceClientManager;
import com.facebook.push.mqtt.service.MqttPushServiceClientManagerImpl;
import com.facebook.push.mqtt.service.response.MqttResponse;
import com.facebook.push.mqtt.service.response.MqttResponseProcessor;
import com.facebook.sync.model.IrisQueueTypes;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: feedbackLoggingParams */
public abstract class SyncMqttPublisher {
    private static final Class<?> f14490a = SyncMqttPublisher.class;
    private final Context f14491b;
    private final MqttPushServiceClientManagerImpl f14492c;
    private final SyncDeviceParamsFactory f14493d;
    private final Lazy<FbErrorReporter> f14494e;
    private final Provider<Boolean> f14495f;
    private final Provider<Boolean> f14496g;
    public final Set<IrisQueueTypes> f14497h = Sets.b();

    /* compiled from: feedbackLoggingParams */
    public class CreateQueueResult {
        public final boolean f14487a;
        @Nullable
        public final String f14488b;
        @Nullable
        public final String f14489c;

        private CreateQueueResult(boolean z, @Nullable String str, @Nullable String str2) {
            this.f14487a = z;
            this.f14488b = str;
            this.f14489c = str2;
        }

        public static CreateQueueResult m18374a(String str) {
            return new CreateQueueResult(true, str, null);
        }

        public static CreateQueueResult m18375b(String str) {
            return new CreateQueueResult(false, null, str);
        }
    }

    public abstract IrisQueueTypes m18382a();

    public final boolean m18384a(int r10, java.lang.String r11, long r12, @javax.annotation.Nullable java.lang.String r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
        r9 = this;
        r8 = 0;
        r0 = r9.m18382a();
        r0 = r0.apiString;
        java.lang.Long.valueOf(r12);
        r2 = r9.m18387b(r10, r11, r12, r14);
        r0 = r9.f14492c;
        r1 = r0.a();
        r0 = r9.f14495f;	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r0 = r0.get();	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r0 = (java.lang.Boolean) r0;	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r0 = r0.booleanValue();	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        if (r0 == 0) goto L_0x0061;	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
    L_0x0022:
        r0 = com.facebook.sync.connection.GetIrisDiffsBuilder.m18346a(r2);	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        if (r0 == 0) goto L_0x0061;	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
    L_0x0028:
        r0 = new com.facebook.thrift.TSerializer;	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r3 = new com.facebook.thrift.protocol.TCompactProtocol$Factory;	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r3.<init>();	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r0.<init>(r3);	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r3 = new com.facebook.sync.connection.GetIrisDiffsBuilder;	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r3.<init>();	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r2 = r3.m18348b(r2);	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r2 = r2.m18347a();	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r0 = r0.a(r2);	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r2 = r0.length;	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r2 = r2 + 1;	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r3 = new byte[r2];	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r2 = 0;	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r4 = 1;	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r5 = r0.length;	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        java.lang.System.arraycopy(r0, r2, r3, r4, r5);	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r2 = "/t_ms_gd";	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r4 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r6 = 0;	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
        r0 = r1.a(r2, r3, r4, r6);	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
    L_0x0058:
        if (r0 == 0) goto L_0x005d;	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
    L_0x005a:
        r9.m18379g();	 Catch:{ RemoteException -> 0x006a, all -> 0x0070 }
    L_0x005d:
        r1.f();
    L_0x0060:
        return r0;
    L_0x0061:
        r0 = "/messenger_sync_get_diffs";	 Catch:{  }
        r4 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;	 Catch:{  }
        r0 = r1.a(r0, r2, r4);	 Catch:{  }
        goto L_0x0058;
    L_0x006a:
        r0 = move-exception;
        r1.f();
        r0 = r8;
        goto L_0x0060;
    L_0x0070:
        r0 = move-exception;
        r1.f();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sync.connection.SyncMqttPublisher.a(int, java.lang.String, long, java.lang.String):boolean");
    }

    public abstract int m18386b();

    protected SyncMqttPublisher(Context context, MqttPushServiceClientManager mqttPushServiceClientManager, SyncDeviceParamsFactory syncDeviceParamsFactory, Lazy<FbErrorReporter> lazy, Provider<Boolean> provider, Provider<Boolean> provider2) {
        this.f14491b = context;
        this.f14492c = mqttPushServiceClientManager;
        this.f14493d = syncDeviceParamsFactory;
        this.f14494e = lazy;
        this.f14495f = provider;
        this.f14496g = provider2;
    }

    public final MqttResponse<CreateQueueResult> m18381a(int i, long j, MqttResponseProcessor<CreateQueueResult> mqttResponseProcessor, @Nullable String str) {
        return m18378b(i, j, (MqttResponseProcessor) mqttResponseProcessor, str);
    }

    private MqttResponse<CreateQueueResult> m18378b(int i, long j, MqttResponseProcessor<CreateQueueResult> mqttResponseProcessor, @Nullable String str) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        m18383a(objectNode);
        objectNode.a("initial_titan_sequence_id", j);
        objectNode.a("delta_batch_size", 125);
        objectNode.c("device_params", this.f14493d.m18366a());
        m18377a(objectNode, str);
        m18376a(objectNode, i);
        m18388b(objectNode);
        MqttPushServiceClient a = this.f14492c.a();
        try {
            MqttResponse<CreateQueueResult> a2 = a.a("/messenger_sync_create_queue", objectNode, mqttResponseProcessor);
            if (a2.a) {
                m18379g();
            }
            a.f();
            return a2;
        } catch (Throwable th) {
            a.f();
        }
    }

    private void m18377a(ObjectNode objectNode, @Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > 0) {
                    objectNode.a("entity_fbid", parseLong);
                }
            } catch (NumberFormatException e) {
                ((AbstractFbErrorReporter) this.f14494e.get()).a(SoftError.b("Sync", "Invalid entity_fbid: " + str));
            }
        }
    }

    public final ObjectNode m18387b(int i, String str, long j, @Nullable String str2) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        m18383a(objectNode);
        objectNode.a("sync_token", str);
        objectNode.a("last_seq_id", j);
        if (!this.f14497h.contains(m18382a())) {
            objectNode.c("device_params", this.f14493d.m18366a());
        }
        m18377a(objectNode, str2);
        m18376a(objectNode, i);
        m18389c(objectNode);
        return objectNode;
    }

    public final boolean m18385a(SyncQueueTrackerImpl syncQueueTrackerImpl) {
        MqttPushServiceClient a = this.f14492c.a();
        try {
            a.a(syncQueueTrackerImpl);
            return true;
        } catch (RemoteException e) {
            return false;
        } finally {
            a.f();
        }
    }

    public void m18390d() {
    }

    protected void m18383a(ObjectNode objectNode) {
        objectNode.a("queue_type", m18382a().apiString);
    }

    protected void m18388b(ObjectNode objectNode) {
    }

    protected void m18389c(ObjectNode objectNode) {
    }

    public final void m18391e() {
        m18379g();
    }

    protected void m18392f() {
    }

    private void m18379g() {
        this.f14497h.add(m18382a());
        m18392f();
    }

    private void m18376a(ObjectNode objectNode, int i) {
        if (i <= 0) {
            ((AbstractFbErrorReporter) this.f14494e.get()).a(SoftError.b("Sync", "api_version: " + i));
        }
        if (((Boolean) this.f14496g.get()).booleanValue()) {
            String h = m18380h();
            if (h != null) {
                objectNode.a("sync_device_id", h);
            }
        }
        objectNode.a("sync_api_version", i);
        objectNode.a("max_deltas_able_to_process", 1250);
    }

    @Nullable
    private String m18380h() {
        String string = Secure.getString(this.f14491b.getContentResolver(), "android_id");
        if (StringUtil.c(string)) {
            return null;
        }
        try {
            return Base64.encodeToString(Hex.a(string), 17);
        } catch (IllegalArgumentException e) {
            return string;
        }
    }
}
