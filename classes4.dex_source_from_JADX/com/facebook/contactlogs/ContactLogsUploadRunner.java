package com.facebook.contactlogs;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import com.facebook.common.android.ConnectivityManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.contactlogs.logging.ContactLogsAnalyticsLogger;
import com.facebook.contactlogs.logging.ContactLogsLoggingConstants.EventType;
import com.facebook.contactlogs.prefs.ContactLogsPrefKeys;
import com.facebook.contactlogs.upload.ContactLogsUploadSettings;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: fb4a_send_as_message_version */
public class ContactLogsUploadRunner {
    public static final String f12081a = ContactLogsUploadRunner.class.getName();
    private static volatile ContactLogsUploadRunner f12082n;
    public final DefaultBlueServiceOperationFactory f12083b;
    public final FbSharedPreferences f12084c;
    private final Provider<String> f12085d;
    public final Clock f12086e;
    public final RuntimePermissionsUtil f12087f;
    private final ExecutorService f12088g;
    public final ConnectivityManager f12089h;
    private final ContactLogsUploadSettings f12090i;
    public final ContactLogsAnalyticsLogger f12091j;
    private final Provider<TriState> f12092k;
    public final Provider<Boolean> f12093l;
    @Nullable
    public OperationFuture f12094m;

    public static com.facebook.contactlogs.ContactLogsUploadRunner m12764a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12082n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contactlogs.ContactLogsUploadRunner.class;
        monitor-enter(r1);
        r0 = f12082n;	 Catch:{ all -> 0x003a }
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
        r0 = m12766b(r0);	 Catch:{ all -> 0x0035 }
        f12082n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12082n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contactlogs.ContactLogsUploadRunner.a(com.facebook.inject.InjectorLike):com.facebook.contactlogs.ContactLogsUploadRunner");
    }

    private static ContactLogsUploadRunner m12766b(InjectorLike injectorLike) {
        return new ContactLogsUploadRunner(DefaultBlueServiceOperationFactory.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), (Clock) SystemClockMethodAutoProvider.a(injectorLike), RuntimePermissionsUtil.b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), ConnectivityManagerMethodAutoProvider.b(injectorLike), ContactLogsUploadSettings.m12772b(injectorLike), ContactLogsAnalyticsLogger.m12776a(injectorLike), IdBasedProvider.a(injectorLike, 654), IdBasedProvider.a(injectorLike, 3938));
    }

    @Inject
    public ContactLogsUploadRunner(BlueServiceOperationFactory blueServiceOperationFactory, FbSharedPreferences fbSharedPreferences, Provider<String> provider, Clock clock, RuntimePermissionsUtil runtimePermissionsUtil, ExecutorService executorService, ConnectivityManager connectivityManager, ContactLogsUploadSettings contactLogsUploadSettings, ContactLogsAnalyticsLogger contactLogsAnalyticsLogger, Provider<TriState> provider2, Provider<Boolean> provider3) {
        this.f12083b = blueServiceOperationFactory;
        this.f12084c = fbSharedPreferences;
        this.f12085d = provider;
        this.f12086e = clock;
        this.f12087f = runtimePermissionsUtil;
        this.f12088g = executorService;
        this.f12089h = connectivityManager;
        this.f12090i = contactLogsUploadSettings;
        this.f12091j = contactLogsAnalyticsLogger;
        this.f12092k = provider2;
        this.f12093l = provider3;
    }

    public final OperationFuture m12769a() {
        if (m12771c()) {
            return m12767e();
        }
        return null;
    }

    public final OperationFuture m12770b() {
        return m12767e();
    }

    public final boolean m12771c() {
        if (((TriState) this.f12092k.get()).asBoolean(false) && this.f12085d.get() != null && this.f12090i.m12775a()) {
            Object obj;
            if (this.f12094m != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null && this.f12087f.a("android.permission.READ_CALL_LOG") && this.f12087f.a("android.permission.READ_SMS")) {
                long j;
                long a = this.f12086e.a() - this.f12084c.a(ContactLogsPrefKeys.b, 0);
                NetworkInfo activeNetworkInfo = this.f12089h.getActiveNetworkInfo();
                Object obj2 = (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) ? 1 : null;
                if (((Boolean) this.f12093l.get()).booleanValue()) {
                    j = 3600000;
                } else if (obj2 != null) {
                    j = 86400000;
                } else {
                    j = 1814400000;
                }
                if ((a >= j ? 1 : null) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private synchronized OperationFuture m12767e() {
        this.f12091j.m12780a(EventType.UPLOAD_STARTED);
        this.f12084c.edit().a(ContactLogsPrefKeys.b, this.f12086e.a()).commit();
        this.f12094m = m12768f();
        m12765a(this.f12094m);
        return this.f12094m;
    }

    private OperationFuture m12768f() {
        return BlueServiceOperationFactoryDetour.a(this.f12083b, "upload_contact_logs", new Bundle(), ErrorPropagation.BY_ERROR_CODE, CallerContext.a(ContactLogsUploadRunner.class), 589160208).a();
    }

    private void m12765a(OperationFuture operationFuture) {
        Futures.a(operationFuture, new 1(this), this.f12088g);
    }
}
