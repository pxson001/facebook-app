package com.facebook.contacts.upload;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.contacts.upload.ContactsUploadState.Status;
import com.facebook.contacts.upload.prefs.ContactUploadStatusHelper;
import com.facebook.contacts.upload.prefs.ContactsUploadPrefKeys;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OnProgressListener;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.orca.notify.ContactsUploadResultNotifier;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: tapped_event_going */
public class ContactsUploadRunner implements IHaveUserData {
    public static final String f2127a = ContactsUploadRunner.class.getName();
    private static volatile ContactsUploadRunner f2128n;
    private final DefaultBlueServiceOperationFactory f2129b;
    private final BaseFbBroadcastManager f2130c;
    public final FbSharedPreferences f2131d;
    public final AnalyticsLogger f2132e;
    private final FbAppType f2133f;
    private final FriendFinderAnalyticsLogger f2134g;
    public final Clock f2135h;
    private final Set<ContactsUploadStateListener> f2136i;
    private final ContactUploadStatusHelper f2137j;
    private ContactsUploadState f2138k = ContactsUploadState.m2132e();
    private ContactsUploadVisibility f2139l = ContactsUploadVisibility.HIDE;
    public OperationFuture f2140m;

    /* compiled from: tapped_event_going */
    class C02181 extends OnProgressListener {
        final /* synthetic */ ContactsUploadRunner f2125a;

        C02181(ContactsUploadRunner contactsUploadRunner) {
            this.f2125a = contactsUploadRunner;
        }

        public final void m2092a(OperationResult operationResult) {
            ContactsUploadState contactsUploadState = (ContactsUploadState) operationResult.k();
            AnalyticsLogger analyticsLogger = this.f2125a.f2132e;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("contacts_upload_running");
            honeyClientEvent.c = "contacts_upload";
            analyticsLogger.a(honeyClientEvent.a("num_processed", contactsUploadState.f2186b).a("num_matched", contactsUploadState.f2187c).a("total", contactsUploadState.f2188d));
            String str = ContactsUploadRunner.f2127a;
            new StringBuilder("Contacts upload state (").append(contactsUploadState).append(")");
            ContactsUploadRunner.m2096a(this.f2125a, contactsUploadState);
        }
    }

    /* compiled from: tapped_event_going */
    class C02192 implements FutureCallback<OperationResult> {
        final /* synthetic */ ContactsUploadRunner f2126a;

        C02192(ContactsUploadRunner contactsUploadRunner) {
            this.f2126a = contactsUploadRunner;
        }

        public void onSuccess(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            String str = ContactsUploadRunner.f2127a;
            m2093a();
            AnalyticsLogger analyticsLogger = this.f2126a.f2132e;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("contacts_upload_succeeded");
            honeyClientEvent.c = "contacts_upload";
            analyticsLogger.a(honeyClientEvent);
            this.f2126a.f2131d.edit().putBoolean(ContactsUploadPrefKeys.d, false).commit();
            if (!this.f2126a.f2131d.a(ContactsUploadPrefKeys.g)) {
                this.f2126a.f2131d.edit().a(ContactsUploadPrefKeys.g, this.f2126a.f2135h.a()).commit();
            }
            ContactsUploadState b = this.f2126a.m2107b();
            ContactsUploadRunner.m2096a(this.f2126a, new ContactsUploadState(Status.SUCCEEDED, b.f2186b, b.f2187c, b.f2188d, operationResult, null));
        }

        public void onFailure(Throwable th) {
            BLog.b(ContactsUploadRunner.f2127a, "Contacts upload failed: ", th);
            m2093a();
            AnalyticsLogger analyticsLogger = this.f2126a.f2132e;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent("contacts_upload_failed");
            honeyClientEvent.c = "contacts_upload";
            analyticsLogger.a(honeyClientEvent);
            this.f2126a.f2131d.edit().putBoolean(ContactsUploadPrefKeys.d, false).commit();
            if (th instanceof ServiceException) {
                ContactsUploadRunner contactsUploadRunner = this.f2126a;
                ContactsUploadState b = this.f2126a.m2107b();
                ContactsUploadRunner.m2096a(contactsUploadRunner, new ContactsUploadState(Status.FAILED, b.f2186b, b.f2187c, b.f2188d, null, (ServiceException) th));
                return;
            }
            ContactsUploadRunner.m2096a(this.f2126a, ContactsUploadState.m2133f());
        }

        private void m2093a() {
            this.f2126a.f2140m = null;
        }
    }

    public static com.facebook.contacts.upload.ContactsUploadRunner m2094a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2128n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.upload.ContactsUploadRunner.class;
        monitor-enter(r1);
        r0 = f2128n;	 Catch:{ all -> 0x003a }
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
        r0 = m2098b(r0);	 Catch:{ all -> 0x0035 }
        f2128n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2128n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.upload.ContactsUploadRunner.a(com.facebook.inject.InjectorLike):com.facebook.contacts.upload.ContactsUploadRunner");
    }

    private static ContactsUploadRunner m2098b(InjectorLike injectorLike) {
        return new ContactsUploadRunner(DefaultBlueServiceOperationFactory.b(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class), FriendFinderAnalyticsLogger.m7863a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$ContactsUploadStateListener(injectorLike)), ContactUploadStatusHelper.b(injectorLike));
    }

    @Inject
    public ContactsUploadRunner(BlueServiceOperationFactory blueServiceOperationFactory, FbBroadcastManager fbBroadcastManager, FbSharedPreferences fbSharedPreferences, AnalyticsLogger analyticsLogger, FbAppType fbAppType, FriendFinderAnalyticsLogger friendFinderAnalyticsLogger, Clock clock, Set<ContactsUploadStateListener> set, ContactUploadStatusHelper contactUploadStatusHelper) {
        this.f2129b = blueServiceOperationFactory;
        this.f2130c = fbBroadcastManager;
        this.f2131d = fbSharedPreferences;
        this.f2132e = analyticsLogger;
        this.f2133f = fbAppType;
        this.f2134g = friendFinderAnalyticsLogger;
        this.f2135h = clock;
        this.f2136i = set;
        this.f2137j = contactUploadStatusHelper;
    }

    public final synchronized OperationFuture m2105a(ContactsUploadVisibility contactsUploadVisibility) {
        Preconditions.checkNotNull(contactsUploadVisibility);
        if (!m2103g()) {
            this.f2139l = contactsUploadVisibility;
            m2099b(ContactsUploadState.m2131a(0, 0, 0));
            this.f2131d.edit().putBoolean(ContactsUploadPrefKeys.c, true).commit();
            this.f2137j.a(true);
            this.f2131d.edit().putBoolean(ContactsUploadPrefKeys.d, true).commit();
            this.f2131d.edit().a(ContactsUploadPrefKeys.h, this.f2135h.a()).commit();
            m2100d();
            m2101e();
            this.f2132e.a(new HoneyClientEvent("contacts_upload_started").g(m2104h()));
            m2096a(this, ContactsUploadState.m2131a(0, 0, 0));
        } else if (this.f2139l == ContactsUploadVisibility.HIDE && contactsUploadVisibility == ContactsUploadVisibility.SHOW) {
            this.f2139l = contactsUploadVisibility;
            m2097a(m2107b(), m2102f());
        }
        return this.f2140m;
    }

    private void m2100d() {
        String str;
        Bundle bundle = new Bundle();
        bundle.putBoolean("forceFullUploadAndTurnOffGlobalKillSwitch", true);
        if (this.f2133f.j == Product.FB4A) {
            str = "contacts_upload_friend_finder";
        } else {
            str = "contacts_upload_messaging";
        }
        if ("contacts_upload_friend_finder".equals(str)) {
            this.f2134g.m7888e();
        }
        this.f2140m = BlueServiceOperationFactoryDetour.a(this.f2129b, str, bundle, 1117239783).a(new C02181(this)).a();
    }

    private void m2101e() {
        Futures.a(this.f2140m, new C02192(this));
    }

    public final synchronized void m2106a() {
        this.f2139l = ContactsUploadVisibility.HIDE;
        m2096a(this, ContactsUploadState.m2132e());
    }

    public static void m2096a(ContactsUploadRunner contactsUploadRunner, ContactsUploadState contactsUploadState) {
        contactsUploadRunner.m2099b(contactsUploadState);
        contactsUploadRunner.m2097a(contactsUploadState, contactsUploadRunner.m2102f());
        if (contactsUploadState.f2185a == Status.SUCCEEDED) {
            for (ContactsUploadResultNotifier a : contactsUploadRunner.f2136i) {
                a.a(contactsUploadState);
            }
        }
    }

    private void m2099b(ContactsUploadState contactsUploadState) {
        synchronized (this) {
            this.f2138k = contactsUploadState;
        }
    }

    private void m2097a(ContactsUploadState contactsUploadState, ContactsUploadVisibility contactsUploadVisibility) {
        Intent intent = new Intent();
        intent.setAction("com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED");
        intent.putExtra("state", contactsUploadState);
        intent.putExtra("visibility", contactsUploadVisibility);
        this.f2130c.a(intent);
    }

    public final synchronized ContactsUploadState m2107b() {
        return this.f2138k;
    }

    private synchronized ContactsUploadVisibility m2102f() {
        return this.f2139l;
    }

    private boolean m2103g() {
        return this.f2140m != null;
    }

    public void clearUserData() {
        m2106a();
    }

    private static String m2104h() {
        return "contacts_upload";
    }
}
