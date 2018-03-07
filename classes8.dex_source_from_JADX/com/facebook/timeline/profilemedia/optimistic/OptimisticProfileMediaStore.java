package com.facebook.timeline.profilemedia.optimistic;

import android.net.Uri;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.util.UriUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mTextWithEntities */
public class OptimisticProfileMediaStore implements IHaveUserData {
    public static final PrefKey f9181a = ((PrefKey) SharedPrefKeys.a.a("optimisticProfilePictureUri"));
    public static final PrefKey f9182b = ((PrefKey) SharedPrefKeys.a.a("optimisticCoverPhotoUri"));
    public final FbSharedPreferences f9183c;

    public static OptimisticProfileMediaStore m10957b(InjectorLike injectorLike) {
        return new OptimisticProfileMediaStore((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public OptimisticProfileMediaStore(FbSharedPreferences fbSharedPreferences) {
        this.f9183c = fbSharedPreferences;
    }

    public void clearUserData() {
        m10959b();
        m10960d();
    }

    @Nullable
    public final Uri m10958a() {
        return UriUtil.a(this.f9183c.a(f9181a, null));
    }

    public static OptimisticProfileMediaStore m10956a(InjectorLike injectorLike) {
        return m10957b(injectorLike);
    }

    public final void m10959b() {
        Editor edit = this.f9183c.edit();
        edit.a(f9181a);
        edit.commit();
    }

    public final void m10960d() {
        Editor edit = this.f9183c.edit();
        edit.a(f9182b);
        edit.commit();
    }
}
