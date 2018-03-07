package com.facebook.placetips.settings;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.LazyFutures;
import com.facebook.placetips.bootstrap.PlaceTipsDebugStatusDataProvider;
import com.facebook.placetips.settings.graphql.C0638x892114ef;
import com.facebook.placetips.settings.graphql.GravitySettingsUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesFuture;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.prefs.shared.objects.FbSharedObjectPreferences;
import com.facebook.prefs.shared.objects.FbSharedObjectPreferencesImpl;
import com.facebook.prefs.shared.objects.ObjectPrefKey;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Set;
import java.util.concurrent.Future;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: max_idle_http_sessions */
public class PlaceTipsSettingsPrefs implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f14954a;
    public static final ObjectPrefKey<C0638x892114ef> f14955b;
    public static final PrefKey f14956c = ((PrefKey) f14954a.m2011a("upsell_seen_count"));
    public static final PrefKey f14957d = ((PrefKey) f14954a.m2011a("upsell_last_seen"));
    public static final PrefKey f14958e = ((PrefKey) f14954a.m2011a("upsell_completed"));

    /* compiled from: max_idle_http_sessions */
    public class Accessor implements PlaceTipsDebugStatusDataProvider {
        private final FbSharedObjectPreferencesImpl f14878a;
        public final FbSharedPreferences f14879b;
        private final Provider<Set<PlaceTipsSettingsChangedListener>> f14880c;
        public final Clock f14881d;

        public static Accessor m21309b(InjectorLike injectorLike) {
            return new Accessor(FbSharedObjectPreferencesImpl.m21242b(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), new STATICDI_MULTIBIND_PROVIDER$PlaceTipsSettingsChangedListener(injectorLike.getScopeAwareInjector()), SystemClockMethodAutoProvider.m1498a(injectorLike));
        }

        @Inject
        public Accessor(FbSharedObjectPreferences fbSharedObjectPreferences, FbSharedPreferences fbSharedPreferences, Provider<Set<PlaceTipsSettingsChangedListener>> provider, Clock clock) {
            this.f14878a = fbSharedObjectPreferences;
            this.f14879b = fbSharedPreferences;
            this.f14880c = provider;
            this.f14881d = clock;
        }

        @Nullable
        public final C0638x892114ef m21312b() {
            return (C0638x892114ef) this.f14878a.m21244a(PlaceTipsSettingsPrefs.f14955b);
        }

        public final boolean m21313c() {
            return GravitySettingsUtil.m21578a(m21312b());
        }

        public final boolean m21314d() {
            return GravitySettingsUtil.m21579b(m21312b());
        }

        public final boolean m21315e() {
            return GravitySettingsUtil.m21579b(m21312b());
        }

        public final boolean m21316f() {
            return GravitySettingsUtil.m21580c(m21312b());
        }

        public final void m21311a(@Nullable C0638x892114ef c0638x892114ef) {
            if (c0638x892114ef != null) {
                C0638x892114ef b = m21312b();
                this.f14878a.m21243a().a(PlaceTipsSettingsPrefs.f14955b, c0638x892114ef instanceof C0638x892114ef ? c0638x892114ef : C0638x892114ef.m21393a(c0638x892114ef)).a();
                Object obj = 1;
                if (b != c0638x892114ef) {
                    if (b == null || c0638x892114ef == null) {
                        obj = null;
                    } else if (!(b.m21399c() == c0638x892114ef.m21399c() && b.m21397a() == c0638x892114ef.m21397a() && b.m21400d() == c0638x892114ef.m21400d())) {
                        obj = null;
                    }
                }
                if (obj == null) {
                    for (PlaceTipsSettingsChangedListener a : (Set) this.f14880c.get()) {
                        a.mo2828a(b, c0638x892114ef);
                    }
                }
            }
        }

        public final int m21317g() {
            return this.f14879b.mo276a(PlaceTipsSettingsPrefs.f14956c, 0);
        }

        public final CharSequence mo652a() {
            Object stringBuilder = new StringBuilder("------------GRAVITY SETTINGS-------------\n\tSETTINGS OBJECT (from graphql)");
            C0638x892114ef b = m21312b();
            if (b == null) {
                stringBuilder.append("\nSettings object is null");
            } else {
                stringBuilder.append("\nis_feature_enabled: ").append(b.m21397a()).append("\nlocation_tracking_enabled: ").append(b.m21399c()).append("\nnotifications_enabled: ").append(b.m21400d()).append("\nlearn_more_link: ").append(b.m21398b());
            }
            stringBuilder.append("\n\tSETTINGS LOGIC\nisGravityFeatureEnabled(): ").append(m21313c()).append("\nisGravityNotificationsEnabled(): ").append(m21314d()).append("\nisGravityBackgroundScanningEnabled(): ").append(m21315e());
            return stringBuilder;
        }
    }

    /* compiled from: max_idle_http_sessions */
    public class AccessorFuture extends ForwardingListenableFuture<Accessor> {
        private final Lazy<ListenableFuture<Accessor>> f14968a;

        public static AccessorFuture m21411b(InjectorLike injectorLike) {
            return new AccessorFuture(IdBasedLazy.m1808a(injectorLike, 3022), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3077));
        }

        protected final /* synthetic */ Future mo1830a() {
            return mo2648b();
        }

        protected final /* synthetic */ Object mo105e() {
            return mo2648b();
        }

        @Inject
        public AccessorFuture(final Lazy<Accessor> lazy, Lazy<FbSharedPreferencesFuture> lazy2) {
            this.f14968a = LazyFutures.m19931a(lazy2, new Function<FbSharedPreferences, Accessor>(this) {
                final /* synthetic */ AccessorFuture f14970b;

                public Object apply(Object obj) {
                    return (Accessor) lazy.get();
                }
            }, MoreExecutors.m1813a());
        }

        protected final ListenableFuture<Accessor> mo2648b() {
            return (ListenableFuture) this.f14968a.get();
        }
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("pulsar/");
        f14954a = prefKey;
        f14955b = ObjectPrefKey.m21401a(prefKey, "gravity_settings", C0638x892114ef.class);
    }

    public final ImmutableSet<PrefKey> mo1206a() {
        return ImmutableSet.of(f14955b.f14963a, f14957d, f14956c, f14958e);
    }
}
