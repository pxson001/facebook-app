package com.facebook.messaging.contacts.loader;

import android.content.Context;
import android.content.Intent;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.init.INeedInit;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: mSelfStartSync */
public class ContactListsCacheListener implements INeedInit {
    private static final Class<?> f8558a = ContactListsCacheListener.class;
    private static volatile ContactListsCacheListener f8559f;
    public final LoggedInUserSessionManager f8560b;
    private final BaseFbBroadcastManager f8561c;
    public final Provider<ContactListsCache> f8562d;
    private SelfRegistrableReceiverImpl f8563e;

    /* compiled from: mSelfStartSync */
    class C05321 implements ActionReceiver {
        final /* synthetic */ ContactListsCacheListener f11136a;

        C05321(ContactListsCacheListener contactListsCacheListener) {
            this.f11136a = contactListsCacheListener;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -199062040);
            if ("com.facebook.contacts.CONTACT_BULK_DELETE".equals(intent.getAction()) && this.f11136a.f8560b.b()) {
                ((ContactListsCache) this.f11136a.f8562d.get()).m14012d();
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1034470557, a);
        }
    }

    public static com.facebook.messaging.contacts.loader.ContactListsCacheListener m8812a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8559f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.contacts.loader.ContactListsCacheListener.class;
        monitor-enter(r1);
        r0 = f8559f;	 Catch:{ all -> 0x003a }
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
        r0 = m8813b(r0);	 Catch:{ all -> 0x0035 }
        f8559f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8559f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.contacts.loader.ContactListsCacheListener.a(com.facebook.inject.InjectorLike):com.facebook.messaging.contacts.loader.ContactListsCacheListener");
    }

    private static ContactListsCacheListener m8813b(InjectorLike injectorLike) {
        return new ContactListsCacheListener(LoggedInUserSessionManager.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), IdBasedProvider.a(injectorLike, 2590));
    }

    @Inject
    ContactListsCacheListener(LoggedInUserAuthDataStore loggedInUserAuthDataStore, FbBroadcastManager fbBroadcastManager, Provider<ContactListsCache> provider) {
        this.f8560b = loggedInUserAuthDataStore;
        this.f8561c = fbBroadcastManager;
        this.f8562d = provider;
    }

    public void init() {
        this.f8563e = this.f8561c.a().a("com.facebook.contacts.CONTACT_BULK_DELETE", new C05321(this)).a();
        this.f8563e.b();
    }
}
