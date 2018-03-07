package com.facebook.orca.push.mqtt;

import android.os.Bundle;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.bugreporter.foldercounts.FolderCountsDebugDataTracker;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.service.model.UpdateFolderCountsParams;
import com.facebook.mqtt.model.thrift.InboxNotification;
import com.facebook.mqtt.model.thrift.PresenceUpdate;
import com.facebook.mqtt.model.thrift.PresenceUpdateBatch;
import com.facebook.orca.notify.MessengerLauncherBadgesController;
import com.facebook.presence.PresenceBroadcaster;
import com.facebook.presence.PresenceItem;
import com.facebook.presence.PresenceList;
import com.facebook.push.mqtt.external.MqttPushHandler;
import com.facebook.sync.model.thrift.MqttThriftHeader;
import com.facebook.thrift.TException;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.transport.TIOStreamTransport;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetchStickerTagsParam */
public class OrcaMqttPushHandler implements MqttPushHandler {
    private static final Class<?> f11698a = OrcaMqttPushHandler.class;
    private static volatile OrcaMqttPushHandler f11699k;
    private final PresenceBroadcaster f11700b;
    private final ObjectMapper f11701c;
    private final LoggedInUserSessionManager f11702d;
    private final MessagesBroadcaster f11703e;
    private final DefaultBlueServiceOperationFactory f11704f;
    private final MessengerLauncherBadgesController f11705g;
    private final Provider<FolderCountsDebugDataTracker> f11706h;
    private final Provider<Boolean> f11707i;
    private final GatekeeperStoreImpl f11708j;

    public static com.facebook.orca.push.mqtt.OrcaMqttPushHandler m12245a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11699k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.push.mqtt.OrcaMqttPushHandler.class;
        monitor-enter(r1);
        r0 = f11699k;	 Catch:{ all -> 0x003a }
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
        r0 = m12251b(r0);	 Catch:{ all -> 0x0035 }
        f11699k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11699k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.push.mqtt.OrcaMqttPushHandler.a(com.facebook.inject.InjectorLike):com.facebook.orca.push.mqtt.OrcaMqttPushHandler");
    }

    private static OrcaMqttPushHandler m12251b(InjectorLike injectorLike) {
        return new OrcaMqttPushHandler(PresenceBroadcaster.m12254a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), LoggedInUserSessionManager.a(injectorLike), MessengerLauncherBadgesController.m9281a(injectorLike), MessagesBroadcaster.a(injectorLike), IdBasedProvider.a(injectorLike, 2558), DefaultBlueServiceOperationFactory.b(injectorLike), IdBasedProvider.a(injectorLike, 4075), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public OrcaMqttPushHandler(PresenceBroadcaster presenceBroadcaster, ObjectMapper objectMapper, LoggedInUserAuthDataStore loggedInUserAuthDataStore, MessengerLauncherBadgesController messengerLauncherBadgesController, MessagesBroadcaster messagesBroadcaster, Provider<FolderCountsDebugDataTracker> provider, BlueServiceOperationFactory blueServiceOperationFactory, Provider<Boolean> provider2, GatekeeperStore gatekeeperStore) {
        this.f11700b = presenceBroadcaster;
        this.f11701c = objectMapper;
        this.f11702d = loggedInUserAuthDataStore;
        this.f11705g = messengerLauncherBadgesController;
        this.f11703e = messagesBroadcaster;
        this.f11706h = provider;
        this.f11704f = blueServiceOperationFactory;
        this.f11707i = provider2;
        this.f11708j = gatekeeperStore;
    }

    public void onMessage(String str, byte[] bArr) {
        try {
            if (!this.f11702d.b()) {
                return;
            }
            if ("/orca_presence".equals(str)) {
                m12250a(m12252b(bArr), str);
            } else if ("/t_p".equals(str) || "/t_sp".equals(str)) {
                m12248a(m12253c(bArr), str);
            } else if ("/inbox".equals(str)) {
                m12249a(m12252b(bArr));
            } else if ("/t_inbox".equals(str)) {
                m12247a(m12244a(bArr));
            }
        } catch (IOException e) {
        }
    }

    private void m12250a(JsonNode jsonNode, String str) {
        boolean equal = Objects.equal("full", JSONUtil.b(jsonNode.b("list_type")));
        JsonNode b = jsonNode.b("list");
        Builder builder = ImmutableList.builder();
        Iterator it = b.iterator();
        while (it.hasNext()) {
            b = (JsonNode) it.next();
            String l = Long.toString(JSONUtil.c(b.b("u")));
            int d = JSONUtil.d(b.b("p"));
            long a = JSONUtil.a(b.b("l"), -1);
            int a2 = JSONUtil.a(b.b("d"), 0);
            if (a == 0) {
                a = -1;
            }
            b = b.b("vc");
            Long l2 = null;
            if (!(b == null || b.q())) {
                l2 = Long.valueOf(JSONUtil.c(b));
            }
            builder.c(new PresenceItem(new UserKey(Type.FACEBOOK, l), d == 2, a, a2, l2));
        }
        this.f11700b.m12258a(str, new PresenceList(builder.b()), equal);
    }

    private void m12248a(PresenceUpdateBatch presenceUpdateBatch, String str) {
        boolean z = !presenceUpdateBatch.isIncrementalUpdate.booleanValue();
        Builder builder = ImmutableList.builder();
        for (PresenceUpdate presenceUpdate : presenceUpdateBatch.updates) {
            String l = presenceUpdate.uid.toString();
            int intValue = presenceUpdate.state.intValue();
            long longValue = (presenceUpdate.lastActiveTimeSec == null || presenceUpdate.lastActiveTimeSec.longValue() == 0) ? -1 : presenceUpdate.lastActiveTimeSec.longValue();
            builder.c(new PresenceItem(new UserKey(Type.FACEBOOK, l), intValue == 1, longValue, presenceUpdate.detailedClientPresence == null ? 0 : presenceUpdate.detailedClientPresence.shortValue(), presenceUpdate.voipCapabilities));
        }
        this.f11700b.m12258a(str, new PresenceList(builder.b()), z);
    }

    private static InboxNotification m12244a(byte[] bArr) {
        TProtocol a = new Factory().a(new TIOStreamTransport(new ByteArrayInputStream(bArr, 0, bArr.length)));
        try {
            MqttThriftHeader.m12262b(a);
            return InboxNotification.b(a);
        } catch (TException e) {
            throw new IOException(e);
        }
    }

    private void m12247a(InboxNotification inboxNotification) {
        m12246a(inboxNotification.unread.intValue(), inboxNotification.unseen.intValue());
    }

    private void m12249a(JsonNode jsonNode) {
        m12246a(JSONUtil.d(jsonNode.b("unread")), JSONUtil.d(jsonNode.b("unseen")));
    }

    private void m12246a(int i, int i2) {
        ((FolderCountsDebugDataTracker) this.f11706h.get()).m10059a(i, i2);
        this.f11705g.m9285a(i2);
        this.f11703e.a(i2);
        if (((Boolean) this.f11707i.get()).booleanValue() && this.f11708j.a(343, false)) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("updateFolderCountsParams", new UpdateFolderCountsParams(FolderName.INBOX, i, i2));
            BlueServiceOperationFactoryDetour.a(this.f11704f, "update_folder_counts", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(OrcaMqttPushHandler.class), 203379082).a(true).a();
        }
    }

    private JsonNode m12252b(byte[] bArr) {
        JsonNode a = this.f11701c.a(StringUtil.a(bArr));
        if (BLog.b(2)) {
            a.toString();
        }
        return a;
    }

    private static PresenceUpdateBatch m12253c(byte[] bArr) {
        TProtocol a = new Factory().a(new TIOStreamTransport(new ByteArrayInputStream(bArr, 0, bArr.length)));
        try {
            MqttThriftHeader.m12262b(a);
            return PresenceUpdateBatch.m12265b(a);
        } catch (TException e) {
            throw new RuntimeException(e);
        }
    }
}
