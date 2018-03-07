package com.facebook.contacts.background;

import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.auth.datastore.LoggedInUserAuthDataStore;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.alarm.FbAlarmManager;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.locale.Locales;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.ratelimiter.RateLimiter;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.typedkey.TypedKey;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.properties.ContactsStorageMode;
import com.facebook.contacts.properties.DbContactsProperties;
import com.facebook.contacts.properties.DbContactsPropertyKey;
import com.facebook.contacts.properties.DbContactsPropertyUtil;
import com.facebook.contacts.provider.ContactsConnectionsContract.Selectors;
import com.facebook.contacts.util.ContactsPrefKeys;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.content.DynamicSecureBroadcastReceiver;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: rtc_opispx */
public class AddressBookPeriodicRunner implements IHaveUserData {
    private static final Class<?> f12105a = AddressBookPeriodicRunner.class;
    private static volatile AddressBookPeriodicRunner f12106x;
    private final Context f12107b;
    private final FbAlarmManagerImpl f12108c;
    private final DBPropertyUtilWithValueRetrievalErrorHandling f12109d;
    private final LoggedInUserSessionManager f12110e;
    private final DefaultBlueServiceOperationFactory f12111f;
    private final Clock f12112g;
    public final ExecutorService f12113h;
    private final AppStateManager f12114i;
    private final Locales f12115j;
    private final Provider<Boolean> f12116k;
    private final FbSharedPreferences f12117l;
    private final RateLimiter f12118m;
    private final AbstractFbErrorReporter f12119n;
    private final FbNetworkManager f12120o;
    private final Provider<ContactsStorageMode> f12121p;
    private final GatekeeperStoreImpl f12122q;
    private ListenableFuture<OperationResult> f12123r;
    private ListenableFuture<OperationResult> f12124s;
    @GuardedBy("this")
    private long f12125t;
    @GuardedBy("this")
    private long f12126u = -1;
    @GuardedBy("this")
    private String f12127v = null;
    @GuardedBy("this")
    private PendingIntent f12128w;

    /* compiled from: rtc_opispx */
    public class LocalBroadcastReceiver extends DynamicSecureBroadcastReceiver {
        public LocalBroadcastReceiver() {
            super("com.facebook.orca.database.ACTION_ALARM", new AlarmActionReceiver());
        }
    }

    /* compiled from: rtc_opispx */
    public class AlarmActionReceiver implements ActionReceiver {
        private AddressBookPeriodicRunner f3224a;

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 2070396260);
            AppInitLockHelper.a(context);
            this.f3224a = AddressBookPeriodicRunner.m12785a(FbInjector.get(context));
            AddressBookPeriodicRunner addressBookPeriodicRunner = this.f3224a;
            ExecutorDetour.a(addressBookPeriodicRunner.f12113h, new C01462(addressBookPeriodicRunner), 600088851);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 447247977, a);
        }
    }

    /* compiled from: rtc_opispx */
    public class C01462 implements Runnable {
        final /* synthetic */ AddressBookPeriodicRunner f3225a;

        public C01462(AddressBookPeriodicRunner addressBookPeriodicRunner) {
            this.f3225a = addressBookPeriodicRunner;
        }

        public void run() {
            this.f3225a.m12798c();
            this.f3225a.m12799d();
        }
    }

    /* compiled from: rtc_opispx */
    class C01473 extends OperationResultFutureCallback {
        final /* synthetic */ AddressBookPeriodicRunner f3226a;

        C01473(AddressBookPeriodicRunner addressBookPeriodicRunner) {
            this.f3226a = addressBookPeriodicRunner;
        }

        public final void m3435a(Object obj) {
            AddressBookPeriodicRunner.m12795m(this.f3226a);
        }

        protected final void mo148a(ServiceException serviceException) {
            serviceException.toString();
            AddressBookPeriodicRunner.m12791i(this.f3226a);
        }
    }

    /* compiled from: rtc_opispx */
    class C01554 extends OperationResultFutureCallback {
        final /* synthetic */ AddressBookPeriodicRunner f3426a;

        C01554(AddressBookPeriodicRunner addressBookPeriodicRunner) {
            this.f3426a = addressBookPeriodicRunner;
        }

        public final void m3642a(Object obj) {
            AddressBookPeriodicRunner.m12789g(this.f3426a);
        }

        protected final void mo148a(ServiceException serviceException) {
            AddressBookPeriodicRunner.m12791i(this.f3426a);
        }
    }

    /* compiled from: rtc_opispx */
    class DBPropertyUtilWithValueRetrievalErrorHandling {
        private final DbContactsPropertyUtil f12129a;
        private final AbstractFbErrorReporter f12130b;

        DBPropertyUtilWithValueRetrievalErrorHandling(DbContactsPropertyUtil dbContactsPropertyUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
            this.f12129a = dbContactsPropertyUtil;
            this.f12130b = abstractFbErrorReporter;
        }

        public static long m12800a(DBPropertyUtilWithValueRetrievalErrorHandling dBPropertyUtilWithValueRetrievalErrorHandling, DbContactsPropertyKey dbContactsPropertyKey, long j) {
            try {
                return dBPropertyUtilWithValueRetrievalErrorHandling.f12129a.m8550a((TypedKey) dbContactsPropertyKey, j);
            } catch (Throwable e) {
                dBPropertyUtilWithValueRetrievalErrorHandling.f12130b.a("AddressBookPeriodicRunner.DBPropertyUtilWithValueRetrievalErrorHandling", "Failed to get value in getValueForKeyAsLong", e);
                throw new ValueRetrievalException(e);
            }
        }

        public static String m12801a(DBPropertyUtilWithValueRetrievalErrorHandling dBPropertyUtilWithValueRetrievalErrorHandling, DbContactsPropertyKey dbContactsPropertyKey, String str) {
            try {
                return dBPropertyUtilWithValueRetrievalErrorHandling.f12129a.m8552a((TypedKey) dbContactsPropertyKey, str);
            } catch (Throwable e) {
                dBPropertyUtilWithValueRetrievalErrorHandling.f12130b.a("AddressBookPeriodicRunner.DBPropertyUtilWithValueRetrievalErrorHandling", "Failed to get value in getValueForKey", e);
                throw new ValueRetrievalException(e);
            }
        }
    }

    public static com.facebook.contacts.background.AddressBookPeriodicRunner m12785a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12106x;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.background.AddressBookPeriodicRunner.class;
        monitor-enter(r1);
        r0 = f12106x;	 Catch:{ all -> 0x003a }
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
        r0 = m12786b(r0);	 Catch:{ all -> 0x0035 }
        f12106x = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12106x;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.background.AddressBookPeriodicRunner.a(com.facebook.inject.InjectorLike):com.facebook.contacts.background.AddressBookPeriodicRunner");
    }

    private static AddressBookPeriodicRunner m12786b(InjectorLike injectorLike) {
        return new AddressBookPeriodicRunner((Context) injectorLike.getInstance(Context.class), FbAlarmManagerImpl.a(injectorLike), DbContactsPropertyUtil.m8547a(injectorLike), LoggedInUserSessionManager.a(injectorLike), DefaultBlueServiceOperationFactory.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), AppStateManager.a(injectorLike), Locales.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 3940), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), FbNetworkManager.a(injectorLike), IdBasedProvider.a(injectorLike, 939), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AddressBookPeriodicRunner(Context context, FbAlarmManager fbAlarmManager, DbContactsPropertyUtil dbContactsPropertyUtil, LoggedInUserAuthDataStore loggedInUserAuthDataStore, BlueServiceOperationFactory blueServiceOperationFactory, Clock clock, ExecutorService executorService, AppStateManager appStateManager, Locales locales, FbSharedPreferences fbSharedPreferences, Provider<Boolean> provider, FbErrorReporter fbErrorReporter, FbNetworkManager fbNetworkManager, Provider<ContactsStorageMode> provider2, GatekeeperStore gatekeeperStore) {
        this.f12107b = context;
        this.f12108c = fbAlarmManager;
        this.f12109d = new DBPropertyUtilWithValueRetrievalErrorHandling(dbContactsPropertyUtil, fbErrorReporter);
        this.f12110e = loggedInUserAuthDataStore;
        this.f12111f = blueServiceOperationFactory;
        this.f12112g = clock;
        this.f12113h = executorService;
        this.f12114i = appStateManager;
        this.f12115j = locales;
        this.f12116k = provider;
        this.f12117l = fbSharedPreferences;
        this.f12118m = new RateLimiter(clock, 5, 60000);
        this.f12119n = fbErrorReporter;
        this.f12120o = fbNetworkManager;
        this.f12121p = provider2;
        this.f12122q = gatekeeperStore;
    }

    public final void m12796a() {
        ExecutorDetour.a(this.f12113h, new 1(this, true), -586545494);
    }

    final synchronized void m12797a(boolean z) {
        if (((Boolean) this.f12116k.get()).booleanValue() && this.f12121p.get() != ContactsStorageMode.OMNISTORE_CONTACTS_COLLECTION && ((this.f12128w == null || z) && m12787e())) {
            if (z) {
                this.f12125t = 0;
            }
            Intent intent = new Intent(this.f12107b, LocalBroadcastReceiver.class);
            intent.setAction("com.facebook.orca.database.ACTION_ALARM");
            this.f12128w = PendingIntent.getBroadcast(this.f12107b, -1, intent, 0);
            this.f12108c.a(1, this.f12112g.a() + this.f12125t, this.f12128w);
        }
    }

    @GuardedBy("this")
    private synchronized boolean m12787e() {
        boolean z = false;
        synchronized (this) {
            if (this.f12110e.b() && this.f12120o.d()) {
                try {
                    if (this.f12126u == -1) {
                        this.f12126u = DBPropertyUtilWithValueRetrievalErrorHandling.m12800a(this.f12109d, DbContactsProperties.f13090a, -1);
                    }
                    if (this.f12127v == null) {
                        this.f12127v = DBPropertyUtilWithValueRetrievalErrorHandling.m12801a(this.f12109d, DbContactsProperties.f13092c, this.f12115j.g());
                    }
                    if (m12788f() || !StringUtil.a(this.f12115j.g(), this.f12127v)) {
                        z = true;
                    }
                } catch (ValueRetrievalException e) {
                }
            }
        }
        return z;
    }

    @GuardedBy("this")
    private boolean m12788f() {
        long a = this.f12112g.a() - this.f12126u;
        if (a < 0) {
            return true;
        }
        boolean j = this.f12114i.j();
        if (this.f12126u == -1) {
            return true;
        }
        if (j && a >= 86400000) {
            Long.valueOf(a);
            return true;
        } else if (j || a < 3600000) {
            Long.valueOf(a);
            return false;
        } else {
            Long.valueOf(a);
            return true;
        }
    }

    public static synchronized void m12789g(AddressBookPeriodicRunner addressBookPeriodicRunner) {
        synchronized (addressBookPeriodicRunner) {
            addressBookPeriodicRunner.f12124s = null;
            addressBookPeriodicRunner.f12117l.edit().putBoolean(ContactsPrefKeys.f3932b, true).putBoolean(ContactsPrefKeys.f3933c, true).commit();
            addressBookPeriodicRunner.m12790h();
        }
    }

    @GuardedBy("this")
    private void m12790h() {
        this.f12126u = this.f12112g.a();
        this.f12125t = 0;
        m12797a(false);
        ContentResolver contentResolver = this.f12107b.getApplicationContext().getContentResolver();
        for (Selectors fullUri : Selectors.values()) {
            contentResolver.notifyChange(fullUri.getFullUri(), null);
        }
    }

    public static synchronized void m12791i(AddressBookPeriodicRunner addressBookPeriodicRunner) {
        synchronized (addressBookPeriodicRunner) {
            addressBookPeriodicRunner.f12124s = null;
            addressBookPeriodicRunner.f12123r = null;
            addressBookPeriodicRunner.f12117l.edit().putBoolean(ContactsPrefKeys.f3932b, true).commit();
            if (addressBookPeriodicRunner.f12125t == 0) {
                addressBookPeriodicRunner.f12125t = 30000;
            } else {
                addressBookPeriodicRunner.f12125t = 2 * addressBookPeriodicRunner.f12125t;
            }
            addressBookPeriodicRunner.f12125t = Math.min(addressBookPeriodicRunner.f12125t, 3600000);
            addressBookPeriodicRunner.m12797a(false);
        }
    }

    final synchronized void m12798c() {
        if (this.f12128w != null) {
            this.f12108c.a(this.f12128w);
            this.f12128w = null;
        }
    }

    final synchronized void m12799d() {
        if (m12787e() && this.f12123r == null && this.f12124s == null) {
            if (this.f12118m.a()) {
                m12793k();
            } else {
                this.f12119n.a("AddressBookPeriodicRunner", m12792j());
            }
        }
    }

    private synchronized String m12792j() {
        StringBuilder stringBuilder;
        String g = this.f12115j.g();
        String str = "n/a";
        String str2 = "n/a";
        try {
            str = DBPropertyUtilWithValueRetrievalErrorHandling.m12801a(this.f12109d, DbContactsProperties.f13090a, Long.toString(-1));
            str2 = str;
            str = DBPropertyUtilWithValueRetrievalErrorHandling.m12801a(this.f12109d, DbContactsProperties.f13092c, g);
        } catch (ValueRetrievalException e) {
            String str3 = str2;
            str2 = str;
            str = str3;
        }
        stringBuilder = new StringBuilder("AddressBook rate limit exceeded. ");
        stringBuilder.append("now=" + this.f12112g.a());
        stringBuilder.append(",nextDelayMs=" + this.f12125t);
        stringBuilder.append(",lastSyncTimestamp=" + this.f12126u);
        stringBuilder.append(",last_contact_sync_client_time_ms=" + str2);
        stringBuilder.append(",lastSyncLocale=" + this.f12127v);
        stringBuilder.append(",currentLocale=" + g);
        stringBuilder.append(",last_contacts_sync_client_locale=" + str);
        return stringBuilder.toString();
    }

    private void m12793k() {
        Preconditions.checkArgument(this.f12123r == null);
        if (this.f12122q.a(203, false)) {
            m12795m(this);
            return;
        }
        this.f12123r = BlueServiceOperationFactoryDetour.a(this.f12111f, "sync_favorite_contacts", new Bundle(), 2065921879).a();
        Futures.a(this.f12123r, new C01473(this));
    }

    private void m12794l() {
        Preconditions.checkArgument(this.f12124s == null);
        this.f12124s = BlueServiceOperationFactoryDetour.a(this.f12111f, "sync_contacts_partial", new Bundle(), -433792591).a();
        Futures.a(this.f12124s, new C01554(this));
    }

    public static synchronized void m12795m(AddressBookPeriodicRunner addressBookPeriodicRunner) {
        synchronized (addressBookPeriodicRunner) {
            addressBookPeriodicRunner.m12794l();
            addressBookPeriodicRunner.f12123r = null;
        }
    }

    public synchronized void clearUserData() {
        if (this.f12124s != null) {
            this.f12124s.cancel(false);
            this.f12124s = null;
        }
        if (this.f12123r != null) {
            this.f12123r.cancel(false);
            this.f12123r = null;
        }
        m12798c();
        this.f12125t = 0;
        this.f12126u = -1;
    }
}
