package com.facebook.contacts.protocol.push.mqtt;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.database.ContactUpdateHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.push.mqtt.external.MqttPushHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetchViewerLoginAudienceInfo */
public class ContactsMqttPushHandler implements MqttPushHandler {
    private static final Class<?> f11667a = ContactsMqttPushHandler.class;
    private static volatile ContactsMqttPushHandler f11668e;
    private final ObjectMapper f11669b;
    private final LoggedInUserSessionManager f11670c;
    private final ContactUpdateHelper f11671d;

    public static com.facebook.contacts.protocol.push.mqtt.ContactsMqttPushHandler m12215a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11668e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.protocol.push.mqtt.ContactsMqttPushHandler.class;
        monitor-enter(r1);
        r0 = f11668e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m12217b(r0);	 Catch:{ all -> 0x0035 }
        f11668e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11668e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.protocol.push.mqtt.ContactsMqttPushHandler.a(com.facebook.inject.InjectorLike):com.facebook.contacts.protocol.push.mqtt.ContactsMqttPushHandler");
    }

    private static ContactsMqttPushHandler m12217b(InjectorLike injectorLike) {
        return new ContactsMqttPushHandler((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), LoggedInUserSessionManager.a(injectorLike), ContactUpdateHelper.m12218a(injectorLike));
    }

    @Inject
    public ContactsMqttPushHandler(ObjectMapper objectMapper, LoggedInUserSessionManager loggedInUserSessionManager, ContactUpdateHelper contactUpdateHelper) {
        this.f11669b = objectMapper;
        this.f11670c = loggedInUserSessionManager;
        this.f11671d = contactUpdateHelper;
    }

    public void onMessage(String str, byte[] bArr) {
        if (this.f11670c.b()) {
            try {
                if ("/messaging_events".equals(str)) {
                    JsonNode a = this.f11669b.a(StringUtil.a(bArr));
                    if (BLog.b(2)) {
                        new StringBuilder("Publish:\n").append(a.toString());
                    }
                    m12216a(a);
                    return;
                }
                return;
            } catch (Throwable e) {
                BLog.b(f11667a, "IOException", e);
                return;
            }
        }
        new StringBuilder("Not logged in: throwing out Mqtt message. ").append(str);
    }

    private void m12216a(JsonNode jsonNode) {
        if (JSONUtil.b(jsonNode.b("event")).equals("messenger_status")) {
            String b = JSONUtil.b(jsonNode.b("from_fbid"));
            if (jsonNode.d("is_messenger_user")) {
                boolean g = JSONUtil.g(jsonNode.b("is_messenger_user"));
                Boolean.valueOf(g);
                this.f11671d.m12220a(b, g);
            }
        }
    }
}
