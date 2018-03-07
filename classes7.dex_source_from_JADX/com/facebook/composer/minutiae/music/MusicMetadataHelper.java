package com.facebook.composer.minutiae.music;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import com.facebook.audiofingerprinting.MusicMetadata;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.TriState;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.SortedMap;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: title_length */
public class MusicMetadataHelper {
    public static final PrefKey f1593a;
    public static final PrefKey f1594b = ((PrefKey) f1597e.a("Song"));
    public static final PrefKey f1595c = ((PrefKey) f1597e.a("Album"));
    public static final PrefKey f1596d = ((PrefKey) f1597e.a("Timestamp"));
    private static final PrefKey f1597e;
    private static Map<String, PrefKey> f1598f = ImmutableMap.builder().b("album", f1595c).b("artist", f1593a).b("track", f1594b).b("com.amazon.mp3.track", f1594b).b("com.amazon.mp3.artist", f1593a).b("com.amazon.mp3.album", f1595c).b("ARTIST_NAME", f1593a).b("ALBUM_NAME", f1595c).b("TRACK_NAME", f1594b).b();
    public final FbSharedPreferences f1599g;
    private final MonotonicClock f1600h;
    private final AudioManager f1601i;
    private final Provider<TriState> f1602j;
    private final QeAccessor f1603k;

    public static MusicMetadataHelper m1645b(InjectorLike injectorLike) {
        return new MusicMetadataHelper((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), AudioManagerMethodAutoProvider.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 652));
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.h.a("last_song_played");
        f1597e = prefKey;
        f1593a = (PrefKey) prefKey.a("Artist");
    }

    @Inject
    public MusicMetadataHelper(FbSharedPreferences fbSharedPreferences, MonotonicClock monotonicClock, AudioManager audioManager, QeAccessor qeAccessor, Provider<TriState> provider) {
        this.f1599g = fbSharedPreferences;
        this.f1600h = monotonicClock;
        this.f1601i = audioManager;
        this.f1603k = qeAccessor;
        this.f1602j = provider;
    }

    public final void m1649a(@Nonnull Bundle bundle) {
        if (m1647c()) {
            Map b = m1646b(bundle);
            if (b != null) {
                if (this.f1599g.a()) {
                    this.f1599g.edit().a(b).commit();
                }
            }
        }
    }

    public final boolean m1650a(Intent intent) {
        return (intent.getExtras() == null || m1646b(intent.getExtras()) == null) ? false : true;
    }

    private boolean m1647c() {
        return ((TriState) this.f1602j.get()).asBoolean(false) || this.f1603k.a(ExperimentsForFeedUtilComposerAbtestModule.G, false);
    }

    private Map<PrefKey, Object> m1646b(@Nonnull Bundle bundle) {
        Map<PrefKey, Object> c = Maps.c();
        for (String str : f1598f.keySet()) {
            if (bundle.containsKey(str)) {
                String string = bundle.getString(str);
                if (string != null) {
                    c.put(f1598f.get(str), string);
                }
            }
        }
        if (c.size() == 0) {
            return null;
        }
        c.put(f1596d, String.valueOf(this.f1600h.now()));
        return c;
    }

    public final void m1648a() {
        this.f1599g.edit().b(f1597e).commit();
    }

    public final Optional<MusicMetadata> m1651b() {
        if (!m1647c()) {
            return Absent.INSTANCE;
        }
        SortedMap e = this.f1599g.e(f1597e);
        if (e == null || e.size() == 0) {
            return Absent.INSTANCE;
        }
        long parseLong = Long.parseLong((String) e.get(f1596d));
        if (this.f1600h.now() < parseLong) {
            m1648a();
            return Absent.INSTANCE;
        } else if (this.f1600h.now() - parseLong > 600000) {
            m1648a();
            return Absent.INSTANCE;
        } else if (this.f1601i.isMusicActive()) {
            return Optional.of(new MusicMetadata((String) e.get(f1593a), (String) e.get(f1594b), (String) e.get(f1595c), (String) e.get(f1596d)));
        } else {
            m1648a();
            return Absent.INSTANCE;
        }
    }
}
