package com.facebook.messaging.media.mediapicker;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

@UserScoped
/* compiled from: mCardLastFour */
public class DynamicMediaPickerPreference {
    private static final Object f11660f = new Object();
    public final QeAccessor f11661a;
    public final Clock f11662b;
    public final FbSharedPreferences f11663c;
    private final AnalyticsLogger f11664d;
    public boolean f11665e = false;

    private static DynamicMediaPickerPreference m12324b(InjectorLike injectorLike) {
        return new DynamicMediaPickerPreference((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DynamicMediaPickerPreference(QeAccessor qeAccessor, Clock clock, FbSharedPreferences fbSharedPreferences, AnalyticsLogger analyticsLogger) {
        this.f11661a = qeAccessor;
        this.f11662b = clock;
        this.f11663c = fbSharedPreferences;
        this.f11664d = analyticsLogger;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.media.mediapicker.DynamicMediaPickerPreference m12321a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f11660f;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m12324b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f11660f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.media.mediapicker.DynamicMediaPickerPreference) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.media.mediapicker.DynamicMediaPickerPreference) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f11660f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.media.mediapicker.DynamicMediaPickerPreference) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.mediapicker.DynamicMediaPickerPreference.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.mediapicker.DynamicMediaPickerPreference");
    }

    private void m12323a(boolean z, long j, long j2) {
        Map hashMap = new HashMap();
        hashMap.put("picker_used_ratio", String.valueOf(z ? 1 : 0));
        hashMap.put("open_timestamp_difference", String.valueOf(TimeUnit.MILLISECONDS.toHours(j2 - j)));
        this.f11664d.a("messenger_dynamic_media_picker_preference", hashMap);
    }

    private void m12322a(long j, long j2) {
        Editor edit = this.f11663c.edit();
        edit.a(MediaPickerPrefKeys.f11717b, j);
        edit.a(MediaPickerPrefKeys.f11718c, j2);
        edit.commit();
    }

    public final void m12325b() {
        if (this.f11661a.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForMediaPickerModule.f11666a, false)) {
            long a = this.f11662b.a();
            if (this.f11665e) {
                m12323a(true, a, a);
                this.f11665e = false;
            }
            m12322a(a, a);
        }
    }

    public final void m12326c() {
        if (this.f11661a.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForMediaPickerModule.f11666a, false)) {
            long a = this.f11663c.a(MediaPickerPrefKeys.f11717b, 0);
            long a2 = this.f11663c.a(MediaPickerPrefKeys.f11718c, 0);
            long a3 = this.f11662b.a();
            if (a2 == 0 || a == 0 || a == a2) {
                a = 43200000 + a3;
            } else {
                a = Math.min(604800000, ((a2 - a) * 2) + a3);
            }
            m12322a(a3, a);
            m12323a(false, a3, a);
            this.f11665e = false;
        }
    }
}
