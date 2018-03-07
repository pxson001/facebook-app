package com.facebook.messaging.sms.readonly;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Telephony.MmsSms;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.sms.abtest.AnonymousSmsThreadStateHelper;
import com.facebook.messaging.sms.abtest.ReadonlyModeNotificationType;
import com.facebook.messaging.sms.abtest.SmsIntegrationState;
import com.facebook.messaging.sms.abtest.SmsTakeoverMultiverseExperimentHelper;
import com.facebook.messaging.sms.defaultapp.SmsPermissionsUtil;
import com.facebook.messaging.sms.prefs.SmsPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

@TargetApi(19)
/* compiled from: com.facebook.orca.category.PLATFORM_REPLY_20141218 */
public class ReadOnlyModeObserver {
    public final Handler f17762a;
    public final ContentResolver f17763b;
    public final FbSharedPreferences f17764c;
    public final ReadOnlyEventHandler f17765d;
    private final SmsTakeoverMultiverseExperimentHelper f17766e;
    public final Lazy<GentleNotificationChecker> f17767f;
    public final SmsIntegrationState f17768g;
    private final AnonymousSmsThreadStateHelper f17769h;
    public final SmsPermissionsUtil f17770i;
    private final Object f17771j = new Object();
    private boolean f17772k;
    public boolean f17773l;
    public boolean f17774m;
    public boolean f17775n;
    public ContentObserver f17776o;
    private OnSharedPreferenceChangeListener f17777p;

    /* compiled from: com.facebook.orca.category.PLATFORM_REPLY_20141218 */
    class C20941 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ ReadOnlyModeObserver f17757a;

        C20941(ReadOnlyModeObserver readOnlyModeObserver) {
            this.f17757a = readOnlyModeObserver;
        }

        public final void m17698a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            ReadOnlyModeObserver.m17700b(this.f17757a);
        }
    }

    /* compiled from: com.facebook.orca.category.PLATFORM_REPLY_20141218 */
    class C20952 implements Runnable {
        final /* synthetic */ ReadOnlyModeObserver f17758a;

        C20952(ReadOnlyModeObserver readOnlyModeObserver) {
            this.f17758a = readOnlyModeObserver;
        }

        public void run() {
            Object obj;
            ReadOnlyModeObserver readOnlyModeObserver = this.f17758a;
            if ((readOnlyModeObserver.f17768g.b() || readOnlyModeObserver.f17768g.c()) && readOnlyModeObserver.f17770i.m17594b()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                if (this.f17758a.f17776o == null) {
                    readOnlyModeObserver = this.f17758a;
                    ReadOnlyModeObserver readOnlyModeObserver2 = this.f17758a;
                    readOnlyModeObserver.f17776o = new C20973(readOnlyModeObserver2, readOnlyModeObserver2.f17762a);
                    this.f17758a.f17765d.m17696a();
                    this.f17758a.f17763b.registerContentObserver(MmsSms.CONTENT_URI, false, this.f17758a.f17776o);
                }
            } else if (this.f17758a.f17776o != null) {
                this.f17758a.f17763b.unregisterContentObserver(this.f17758a.f17776o);
                this.f17758a.f17776o = null;
            }
        }
    }

    /* compiled from: com.facebook.orca.category.PLATFORM_REPLY_20141218 */
    public class C20973 extends ContentObserver {
        final /* synthetic */ ReadOnlyModeObserver f17760a;

        /* compiled from: com.facebook.orca.category.PLATFORM_REPLY_20141218 */
        class C20961 implements Runnable {
            final /* synthetic */ C20973 f17759a;

            C20961(C20973 c20973) {
                this.f17759a = c20973;
            }

            public void run() {
                this.f17759a.f17760a.f17765d.m17697b();
                this.f17759a.f17760a.f17773l = false;
            }
        }

        public C20973(ReadOnlyModeObserver readOnlyModeObserver, Handler handler) {
            this.f17760a = readOnlyModeObserver;
            super(handler);
        }

        public void onChange(boolean z, Uri uri) {
            super.onChange(z);
            if (uri != null) {
                if (this.f17760a.f17768g.d()) {
                    this.f17760a.f17764c.edit().a(SmsPrefKeys.b).commit();
                } else if (!this.f17760a.f17773l) {
                    if (this.f17760a.f17774m) {
                        this.f17760a.f17773l = true;
                        HandlerDetour.b(this.f17760a.f17762a, new C20961(this), 1000, 882237115);
                        return;
                    }
                    this.f17760a.f17775n = true;
                }
            }
        }
    }

    /* compiled from: com.facebook.orca.category.PLATFORM_REPLY_20141218 */
    class C20984 implements Runnable {
        final /* synthetic */ ReadOnlyModeObserver f17761a;

        C20984(ReadOnlyModeObserver readOnlyModeObserver) {
            this.f17761a = readOnlyModeObserver;
        }

        public void run() {
            ReadOnlyEventHandler readOnlyEventHandler = this.f17761a.f17765d;
            readOnlyEventHandler.f17747f.m17597a();
            readOnlyEventHandler.m17696a();
        }
    }

    public static ReadOnlyModeObserver m17699b(InjectorLike injectorLike) {
        return new ReadOnlyModeObserver(Handler_ForNonUiThreadMethodAutoProvider.b(injectorLike), ContentResolverMethodAutoProvider.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), ReadOnlyEventHandler.m17692b(injectorLike), SmsTakeoverMultiverseExperimentHelper.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 8483), SmsIntegrationState.a(injectorLike), AnonymousSmsThreadStateHelper.a(injectorLike), SmsPermissionsUtil.m17591a(injectorLike));
    }

    @Inject
    public ReadOnlyModeObserver(Handler handler, ContentResolver contentResolver, FbSharedPreferences fbSharedPreferences, ReadOnlyEventHandler readOnlyEventHandler, SmsTakeoverMultiverseExperimentHelper smsTakeoverMultiverseExperimentHelper, Lazy<GentleNotificationChecker> lazy, SmsIntegrationState smsIntegrationState, AnonymousSmsThreadStateHelper anonymousSmsThreadStateHelper, SmsPermissionsUtil smsPermissionsUtil) {
        this.f17762a = handler;
        this.f17763b = contentResolver;
        this.f17764c = fbSharedPreferences;
        this.f17765d = readOnlyEventHandler;
        this.f17766e = smsTakeoverMultiverseExperimentHelper;
        this.f17767f = lazy;
        this.f17768g = smsIntegrationState;
        this.f17769h = anonymousSmsThreadStateHelper;
        this.f17770i = smsPermissionsUtil;
    }

    public final void m17701a() {
        if (!this.f17772k) {
            synchronized (this.f17771j) {
                if (this.f17772k) {
                    return;
                }
                this.f17772k = true;
                m17700b(this);
                this.f17777p = new C20941(this);
                this.f17764c.a(ImmutableSet.of(SmsPrefKeys.b, SmsPrefKeys.d), this.f17777p);
            }
        }
    }

    public static void m17700b(ReadOnlyModeObserver readOnlyModeObserver) {
        HandlerDetour.a(readOnlyModeObserver.f17762a, new C20952(readOnlyModeObserver), 1473436062);
    }

    public final void m17702a(boolean z) {
        boolean z2 = true;
        if (this.f17768g.b() || this.f17768g.c()) {
            boolean z3;
            if (!z) {
                Object obj;
                ReadonlyModeNotificationType p = this.f17766e.p();
                if (p == ReadonlyModeNotificationType.CHATHEAD_NOTIFICATIONS_ON || p == ReadonlyModeNotificationType.CHATHEAD_SYSTEM_NOTIFICATIONS_ON || ((p == ReadonlyModeNotificationType.GENTLE_CHATHEAD_SYSTEM_NOTIFICATIONS_ON || p == ReadonlyModeNotificationType.GENTLE_CHATHEAD_NOTIFICATIONS_ON) && !((GentleNotificationChecker) this.f17767f.get()).m17690a())) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null && !this.f17769h.b()) {
                    z3 = false;
                    if (this.f17774m != z3) {
                        if (this.f17774m) {
                            z2 = false;
                        }
                        this.f17774m = z2;
                        if (this.f17774m && this.f17775n) {
                            this.f17775n = false;
                            HandlerDetour.a(this.f17762a, new C20984(this), 105149256);
                            return;
                        }
                    }
                }
            }
            z3 = true;
            if (this.f17774m != z3) {
                if (this.f17774m) {
                    z2 = false;
                }
                this.f17774m = z2;
                if (this.f17774m) {
                }
            }
        }
    }
}
