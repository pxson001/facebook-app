package com.facebook.photos.upload.ImageSampling;

import android.content.Context;
import com.facebook.common.hardware.BatteryStateManager;
import com.facebook.common.hardware.BatteryStateManager.ChargeState;
import com.facebook.common.hardware.SystemBatteryStateManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.prefs.PhotosPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import java.io.File;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: group_albums */
public class ImageSamplerFactory {
    private static final Class<?> f13479b = ImageSamplerFactory.class;
    public final PrefKey f13480a = ((PrefKey) PhotosPrefKeys.a.a("last_image_sample_timestamp"));
    private final Provider<TriState> f13481c;
    private final Clock f13482d;
    private final FbSharedPreferences f13483e;
    private final Context f13484f;
    private final SystemBatteryStateManager f13485g;
    private final Provider<RealImageSampler> f13486h;

    public static ImageSamplerFactory m21186a(InjectorLike injectorLike) {
        return new ImageSamplerFactory(IdBasedProvider.a(injectorLike, 728), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Context) injectorLike.getInstance(Context.class, ForAppContext.class), SystemBatteryStateManager.a(injectorLike), IdBasedProvider.a(injectorLike, 9448));
    }

    @Inject
    public ImageSamplerFactory(Provider<TriState> provider, Clock clock, FbSharedPreferences fbSharedPreferences, @ForAppContext Context context, BatteryStateManager batteryStateManager, Provider<RealImageSampler> provider2) {
        this.f13481c = provider;
        this.f13482d = clock;
        this.f13483e = fbSharedPreferences;
        this.f13484f = context;
        this.f13485g = batteryStateManager;
        this.f13486h = provider2;
    }

    public final ImageSampler m21191c() {
        ImageSampler imageSampler;
        if (((TriState) this.f13481c.get()).asBoolean(false) && m21188e()) {
            long j;
            long a = this.f13482d.a();
            long a2 = this.f13483e.a(this.f13480a, 0);
            File d = m21187d();
            if (d == null || !d.isFile()) {
                j = 0;
            } else {
                j = d.lastModified();
            }
            if (a2 >= a) {
                a2 = 0;
            }
            if (j >= a) {
                j = 0;
            }
            if (Math.max(j, a2) + 604800000 < a) {
                imageSampler = (ImageSampler) this.f13486h.get();
                if (imageSampler == null) {
                    imageSampler = new NoOpImageSampler();
                }
                imageSampler.mo1124a(this);
                return imageSampler;
            }
        }
        imageSampler = null;
        if (imageSampler == null) {
            imageSampler = new NoOpImageSampler();
        }
        imageSampler.mo1124a(this);
        return imageSampler;
    }

    private File m21187d() {
        File externalFilesDir = this.f13484f.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return new File(externalFilesDir, "last_image_sample_timestamp");
        }
        return null;
    }

    public final boolean m21189a() {
        return m21188e();
    }

    public final void m21190b() {
        long a = this.f13482d.a();
        File d = m21187d();
        if (d != null) {
            try {
                if (d.exists()) {
                    if (!d.setLastModified(a)) {
                        BLog.a(f13479b, "setLastModified failed");
                    }
                } else if (!d.createNewFile()) {
                    BLog.a(f13479b, "createNewFile failed");
                }
            } catch (IOException e) {
                BLog.a(f13479b, "Couldn't set file date %s, %s", new Object[]{d.getPath(), e.getMessage()});
            }
        }
        this.f13483e.edit().a(this.f13480a, a).commit();
    }

    private boolean m21188e() {
        float a = this.f13485g.a();
        if (a >= 0.7f) {
            return true;
        }
        if (a < 0.3f) {
            return false;
        }
        ChargeState b = this.f13485g.b();
        if (b == ChargeState.CHARGING_AC || b == ChargeState.CHARGING_USB || b == ChargeState.FULL) {
            return true;
        }
        return false;
    }
}
