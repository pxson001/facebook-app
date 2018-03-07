package com.facebook.sounds;

import android.net.Uri;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: setting */
public class FBSoundUtil implements SoundPlayer$SoundPlayerListener {
    private final Provider<SoundPlayer> f2374a;
    private Provider<SoundResourceStore> f2375b;
    public final Cache<SoundPlayer, Object> f2376c = CacheBuilder.newBuilder().a(10).q();

    @Inject
    public FBSoundUtil(Provider<SoundPlayer> provider, Provider<SoundResourceStore> provider2) {
        this.f2374a = provider;
        this.f2375b = provider2;
    }

    private SoundPlayer mo191a() {
        SoundPlayer soundPlayer = (SoundPlayer) this.f2374a.get();
        soundPlayer.h = this;
        return soundPlayer;
    }

    public final SoundPlayer m2623a(@Nullable Uri uri) {
        return m2620a(uri, 2);
    }

    public final SoundPlayer m2624a(@Nullable Uri uri, float f) {
        return m2625a(uri, 2, f);
    }

    private SoundPlayer m2620a(@Nullable Uri uri, int i) {
        SoundPlayer a = mo191a();
        m2621a(a, (Object) uri);
        a.a(uri, i);
        return a;
    }

    public final SoundPlayer m2625a(@Nullable Uri uri, int i, float f) {
        SoundPlayer a = mo191a();
        m2621a(a, (Object) uri);
        a.a(uri, i, f);
        return a;
    }

    protected final SoundPlayer m2626a(String str) {
        return m2627a(str, 1.0f);
    }

    protected final SoundPlayer m2627a(String str, float f) {
        int intValue = ((SoundResourceStore) this.f2375b.get()).a(str).intValue();
        if (intValue == 0) {
            return null;
        }
        return m2622a(intValue, 2, f);
    }

    public final SoundPlayer m2622a(int i, int i2, float f) {
        SoundPlayer a = mo191a();
        m2621a(a, Integer.valueOf(i));
        a.a(i, i2, f);
        return a;
    }

    public void m2629b(String str) {
    }

    private void m2621a(SoundPlayer soundPlayer, @Nullable Object obj) {
        Cache cache = this.f2376c;
        if (obj == null) {
            obj = "NULL";
        }
        cache.a(soundPlayer, obj);
    }

    public final void mo192a(SoundPlayer soundPlayer) {
        this.f2376c.b(soundPlayer);
    }
}
