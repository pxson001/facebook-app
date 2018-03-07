package com.facebook.push.registration;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.init.AppInitLockHelper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.push.adm.ADMRegistrar;
import com.facebook.push.c2dm.C2DMRegistrar;
import com.facebook.push.fbnslite.FbnsLiteRegistrar;
import com.facebook.push.nna.NNARegistrar;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;

/* compiled from: has_new_data */
public class RegistrarHelperService extends FbIntentService {
    private static final Class<?> f11346e = RegistrarHelperService.class;
    @Inject
    Lazy<ADMRegistrar> f11347a;
    @Inject
    Lazy<NNARegistrar> f11348b;
    @Inject
    Lazy<C2DMRegistrar> f11349c;
    @Inject
    Lazy<FbnsLiteRegistrar> f11350d;

    /* compiled from: has_new_data */
    /* synthetic */ class C09981 {
        static final /* synthetic */ int[] f11345a = new int[ServiceType.values().length];

        static {
            try {
                f11345a[ServiceType.ADM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11345a[ServiceType.NNA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11345a[ServiceType.GCM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11345a[ServiceType.FBNS_LITE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f11345a[ServiceType.FBNS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private static <T extends Context> void m13221a(Class<T> cls, T t) {
        m13222a((Object) t, (Context) t);
    }

    public static void m13222a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RegistrarHelperService) obj).m13220a(IdBasedSingletonScopeProvider.b(fbInjector, 3158), IdBasedSingletonScopeProvider.b(fbInjector, 9756), IdBasedSingletonScopeProvider.b(fbInjector, 3162), IdBasedSingletonScopeProvider.b(fbInjector, 3178));
    }

    public RegistrarHelperService() {
        super(f11346e.getSimpleName());
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 1506193690);
        super.onCreate();
        AppInitLockHelper.a(this);
        Class cls = RegistrarHelperService.class;
        m13222a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1063703626, a);
    }

    @VisibleForTesting
    public final void m13223a(Intent intent) {
        Object stringExtra = intent.getStringExtra("serviceType");
        try {
            Registrar registrar;
            switch (C09981.f11345a[ServiceType.valueOf(stringExtra).ordinal()]) {
                case 1:
                    registrar = (Registrar) this.f11347a.get();
                    break;
                case 2:
                    registrar = (Registrar) this.f11348b.get();
                    break;
                case 3:
                    registrar = (Registrar) this.f11349c.get();
                    break;
                case 4:
                    registrar = (Registrar) this.f11350d.get();
                    break;
                default:
                    throw new IllegalStateException(StringFormatUtil.a("Illegal ServiceType %s", new Object[]{ServiceType.valueOf(stringExtra)}));
            }
            registrar.a();
        } catch (Throwable e) {
            BLog.b(f11346e, e, "serviceTypeString is null", new Object[0]);
        } catch (Throwable e2) {
            BLog.b(f11346e, e2, "Failed to convert serviceType=%s", new Object[]{stringExtra});
        }
    }

    private void m13220a(Lazy<ADMRegistrar> lazy, Lazy<NNARegistrar> lazy2, Lazy<C2DMRegistrar> lazy3, Lazy<FbnsLiteRegistrar> lazy4) {
        this.f11347a = lazy;
        this.f11348b = lazy2;
        this.f11349c = lazy3;
        this.f11350d = lazy4;
    }
}
