package com.facebook.messaging.photoreminders;

import android.os.Build.VERSION;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.photoreminders.omnistore.PhotoRemindersOmnistoreUtil;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.user.model.User;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mResizedMediaResources */
public class PhotoRemindersGatingUtil {
    private static final String f8576a = PhotoRemindersGatingUtil.class.getSimpleName();
    public final FbSharedPreferences f8577b;
    private final PhotoRemindersGatekeepers f8578c;
    private final PhotoRemindersLogger f8579d;
    private final PhotoRemindersOmnistoreUtil f8580e;
    private final Provider<User> f8581f;
    public final QeAccessor f8582g;
    public final RuntimePermissionsUtil f8583h;

    public static PhotoRemindersGatingUtil m8821b(InjectorLike injectorLike) {
        return new PhotoRemindersGatingUtil((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), PhotoRemindersGatekeepers.m8831b(injectorLike), PhotoRemindersLogger.m8838b(injectorLike), PhotoRemindersOmnistoreUtil.m8840b(injectorLike), IdBasedProvider.a(injectorLike, 3595), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), RuntimePermissionsUtil.b(injectorLike));
    }

    @Inject
    public PhotoRemindersGatingUtil(FbSharedPreferences fbSharedPreferences, PhotoRemindersGatekeepers photoRemindersGatekeepers, PhotoRemindersLogger photoRemindersLogger, PhotoRemindersOmnistoreUtil photoRemindersOmnistoreUtil, Provider<User> provider, QeAccessor qeAccessor, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f8577b = fbSharedPreferences;
        this.f8578c = photoRemindersGatekeepers;
        this.f8579d = photoRemindersLogger;
        this.f8580e = photoRemindersOmnistoreUtil;
        this.f8581f = provider;
        this.f8582g = qeAccessor;
        this.f8583h = runtimePermissionsUtil;
    }

    public final boolean m8823a() {
        return this.f8581f.get() != null && m8825b() && m8827e();
    }

    public final boolean m8825b() {
        if (this.f8578c.m8832a()) {
            boolean z = false;
            if (this.f8582g.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForMessagingPhotoRemindersModule.j, false) || this.f8582g.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForMessagingPhotoRemindersModule.m, false)) {
                z = true;
            }
            if (z) {
                Object obj = (VERSION.SDK_INT <= 21 || this.f8583h.a("android.permission.READ_EXTERNAL_STORAGE")) ? 1 : null;
                if (obj != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean m8826d() {
        return this.f8577b.a(MessagingPrefKeys.aA, false);
    }

    public final void m8822a(boolean z) {
        this.f8577b.edit().putBoolean(MessagingPrefKeys.aA, z).commit();
    }

    public final boolean m8827e() {
        TriState b = this.f8577b.b(MessagingPrefKeys.az);
        if (b != TriState.UNSET) {
            return b.asBoolean();
        }
        Boolean b2 = this.f8580e.m8843b();
        if (b2 == null) {
            return false;
        }
        m8824b(b2.booleanValue());
        return b2.booleanValue();
    }

    public final void m8824b(boolean z) {
        Boolean.valueOf(z);
        this.f8577b.edit().putBoolean(MessagingPrefKeys.az, z).commit();
    }

    public final boolean m8828f() {
        return this.f8578c.f8584a.a(281, false);
    }

    public final boolean m8829g() {
        return this.f8577b.a(MessagingPrefKeys.aE, 0) >= this.f8582g.a(ExperimentsForMessagingPhotoRemindersModule.h, 50);
    }
}
