package com.facebook.placetips.pulsarcore;

import com.facebook.inject.Lazy;
import com.facebook.inject.LazyFutures;
import com.facebook.placetips.settings.PlaceTipsSettingsPrefs;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesFuture;
import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.objects.FbSharedObjectPreferencesImpl;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Future;
import javax.inject.Inject;

/* compiled from: The default donation amount is not in the list of donation amounts */
public class PulsarPrefs implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f10678a = ((PrefKey) PlaceTipsSettingsPrefs.a.a("has_done_pulsar_scan_once"));

    /* compiled from: The default donation amount is not in the list of donation amounts */
    public class Accessor {
        public final FbSharedPreferences f10673a;
        private final FbSharedObjectPreferencesImpl f10674b;

        @Inject
        public Accessor(FbSharedPreferences fbSharedPreferences, FbSharedObjectPreferencesImpl fbSharedObjectPreferencesImpl) {
            this.f10673a = fbSharedPreferences;
            this.f10674b = fbSharedObjectPreferencesImpl;
        }
    }

    /* compiled from: The default donation amount is not in the list of donation amounts */
    public class AccessorFuture extends ForwardingListenableFuture<Accessor> {
        private final Lazy<ListenableFuture<Accessor>> f10677a;

        protected final /* synthetic */ Future m11186a() {
            return m11187b();
        }

        protected final /* synthetic */ Object m11188e() {
            return m11187b();
        }

        @Inject
        public AccessorFuture(final Lazy<Accessor> lazy, Lazy<FbSharedPreferencesFuture> lazy2) {
            this.f10677a = LazyFutures.a(lazy2, new Function<FbSharedPreferences, Accessor>(this) {
                final /* synthetic */ AccessorFuture f10676b;

                public Object apply(Object obj) {
                    return (Accessor) lazy.get();
                }
            }, MoreExecutors.a());
        }

        protected final ListenableFuture<Accessor> m11187b() {
            return (ListenableFuture) this.f10677a.get();
        }
    }

    public final ImmutableSet<PrefKey> m11189a() {
        return ImmutableSet.of(f10678a);
    }
}
