package com.facebook.contacts.upload;

import com.facebook.analytics.prefs.AnalyticsPrefKeys;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.backgroundtasks.SimpleBackgroundResultFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.contacts.background.ContactsTaskTag;
import com.facebook.contacts.upload.logging.ContactsUploadAnalyticsLogger;
import com.facebook.contacts.upload.prefs.ContactUploadStatusHelper;
import com.facebook.contacts.upload.prefs.ContactsUploadPrefKeys;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.EnumSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: fb4a_mobile_data_usage */
public class ContactsUploadBackgroundTask extends AbstractBackgroundTask {
    private static final Class<?> f12131a = ContactsUploadBackgroundTask.class;
    private static final ImmutableSet<Class<? extends Annotation>> f12132b = ImmutableSet.of(ContactsTaskTag.class);
    private static volatile ContactsUploadBackgroundTask f12133n;
    private final FbSharedPreferences f12134c;
    private final GatekeeperStoreImpl f12135d;
    private final Provider<TriState> f12136e;
    private final Provider<TriState> f12137f;
    private final Clock f12138g;
    private final FbAppType f12139h;
    private final Provider<String> f12140i;
    private final ContactUploadStatusHelper f12141j;
    private final RuntimePermissionsUtil f12142k;
    private final ContinuousContactUploadClient f12143l;
    private final ContactsUploadAnalyticsLogger f12144m;

    public static com.facebook.contacts.upload.ContactsUploadBackgroundTask m12802a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12133n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.upload.ContactsUploadBackgroundTask.class;
        monitor-enter(r1);
        r0 = f12133n;	 Catch:{ all -> 0x003a }
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
        r0 = m12803b(r0);	 Catch:{ all -> 0x0035 }
        f12133n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12133n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.upload.ContactsUploadBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.contacts.upload.ContactsUploadBackgroundTask");
    }

    private static ContactsUploadBackgroundTask m12803b(InjectorLike injectorLike) {
        return new ContactsUploadBackgroundTask((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 659), IdBasedProvider.a(injectorLike, 658), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), IdBasedProvider.a(injectorLike, 4442), ContactUploadStatusHelper.m11414b(injectorLike), RuntimePermissionsUtil.b(injectorLike), ContinuousContactUploadClient.m12814b(injectorLike), ContactsUploadAnalyticsLogger.m12821a(injectorLike));
    }

    @Inject
    public ContactsUploadBackgroundTask(FbSharedPreferences fbSharedPreferences, GatekeeperStore gatekeeperStore, Provider<TriState> provider, Provider<TriState> provider2, Clock clock, FbAppType fbAppType, Provider<String> provider3, ContactUploadStatusHelper contactUploadStatusHelper, RuntimePermissionsUtil runtimePermissionsUtil, ContinuousContactUploadClient continuousContactUploadClient, ContactsUploadAnalyticsLogger contactsUploadAnalyticsLogger) {
        super("ContractsUploadBackgroundTask");
        this.f12134c = fbSharedPreferences;
        this.f12135d = gatekeeperStore;
        this.f12136e = provider;
        this.f12137f = provider2;
        this.f12138g = clock;
        this.f12139h = fbAppType;
        this.f12140i = provider3;
        this.f12141j = contactUploadStatusHelper;
        this.f12142k = runtimePermissionsUtil;
        this.f12143l = continuousContactUploadClient;
        this.f12144m = contactsUploadAnalyticsLogger;
    }

    public final ImmutableSet<Class<? extends Annotation>> mo599b() {
        return f12132b;
    }

    public final Set<Prerequisite> mo594h() {
        return EnumSet.of(Prerequisite.NETWORK_CONNECTIVITY, Prerequisite.USER_LOGGED_IN);
    }

    public final boolean mo595i() {
        if (this.f12135d.a(387, false) || !this.f12142k.a("android.permission.READ_CONTACTS")) {
            return false;
        }
        long a = this.f12134c.a(ContactsUploadPrefKeys.f10965h, -1);
        if (this.f12138g.a() - a < (this.f12134c.a(AnalyticsPrefKeys.d, 86400000) < 86400000 ? 60000 : 28800000)) {
            return false;
        }
        boolean z;
        this.f12134c.edit().a(ContactsUploadPrefKeys.f10965h, this.f12138g.a()).commit();
        if (this.f12139h.j == Product.FB4A) {
            this.f12141j.m11417a(this.f12134c.a(GrowthPrefKeys.m1227a((String) this.f12140i.get()), false));
            z = true;
        } else {
            z = false;
        }
        boolean a2 = this.f12141j.m11418a();
        this.f12144m.m12829a(a2);
        if (!a2 || !((TriState) this.f12136e.get()).asBoolean(false)) {
            return false;
        }
        if (this.f12138g.a() - this.f12134c.a(ContactsUploadPrefKeys.f10963f, -1) < this.f12134c.a(AnalyticsPrefKeys.d, 86400000)) {
            return false;
        }
        if (m12804k()) {
            this.f12143l.f12159o = a;
            return true;
        } else if (this.f12143l.m12820a(z)) {
            return false;
        } else {
            return true;
        }
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        String str;
        if (this.f12139h.j == Product.FB4A) {
            str = "contacts_upload_friend_finder";
        } else {
            str = "contacts_upload_messaging";
        }
        OperationFuture a = this.f12143l.m12818a(str, m12804k());
        if (a == null) {
            return null;
        }
        ListenableFuture<BackgroundResult> simpleBackgroundResultFutureCallback = new SimpleBackgroundResultFutureCallback(f12131a);
        Futures.a(a, simpleBackgroundResultFutureCallback);
        return simpleBackgroundResultFutureCallback;
    }

    private boolean m12804k() {
        return ((TriState) this.f12137f.get()).asBoolean(false);
    }
}
