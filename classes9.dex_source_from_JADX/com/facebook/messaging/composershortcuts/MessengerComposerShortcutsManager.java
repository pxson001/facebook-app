package com.facebook.messaging.composershortcuts;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.time.Clock;
import com.facebook.debug.log.BLog;
import com.facebook.messaging.composershortcuts.ComposerShortcutsManager.ShortcutsList;
import com.facebook.messaging.composershortcuts.data.ComposerShortcutsDbStorage;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: messagevideoattachment */
public class MessengerComposerShortcutsManager implements IHaveUserData, ComposerShortcutsManager {
    public static final String f10069a = (BuildConstants.e + ".ACTION_COMPOSER_SHORTCUTS_UPDATED");
    public static final PrefKey f10070b;
    public static final PrefKey f10071c;
    public static final PrefKey f10072d = ((PrefKey) f10070b.a("latest_overflow_close_time_ms_pref_key"));
    public static final Class<?> f10073e = MessengerComposerShortcutsManager.class;
    private static final double f10074f = (Math.log(2.0d) / 24.0d);
    private static final ByWeightComparator f10075g = new ByWeightComparator();
    private final BaseFbBroadcastManager f10076h;
    private final Provider<Boolean> f10077i;
    private final Provider<Boolean> f10078j;
    private final DefaultComposerShortcuts f10079k;
    private final MessengerComposerShortcutsVisibilityHelper f10080l;
    private final ComposerShortcutsDbStorage f10081m;
    private final MessengerComposerShortcutsOrderingHelper f10082n;
    private final Clock f10083o;
    private final FbSharedPreferences f10084p;
    private final SampleContentGraphQLFetchHelper f10085q;
    @GuardedBy("this")
    private ArrayList<ComposerShortcutItem> f10086r;
    @GuardedBy("this")
    private ImmutableList<ComposerShortcutItem> f10087s;
    @GuardedBy("this")
    private ImmutableList<ComposerShortcutItem> f10088t;
    @GuardedBy("this")
    private boolean f10089u;
    @GuardedBy("this")
    private ImmutableMap<String, Integer> f10090v;
    @GuardedBy("this")
    private boolean f10091w;
    @GuardedBy("this")
    private boolean f10092x;
    @GuardedBy("this")
    private FutureAndCallbackHolder f10093y;

    /* compiled from: messagevideoattachment */
    class C11671 extends AbstractDisposableFutureCallback<ImmutableMap<String, ImmutableList<PlatformSampleContent>>> {
        final /* synthetic */ MessengerComposerShortcutsManager f10068a;

        C11671(MessengerComposerShortcutsManager messengerComposerShortcutsManager) {
            this.f10068a = messengerComposerShortcutsManager;
        }

        protected final void m10580a(Object obj) {
            synchronized (this.f10068a) {
                this.f10068a.f10092x = false;
                this.f10068a.f10093y = null;
            }
        }

        protected final void m10581a(Throwable th) {
            BLog.b(MessengerComposerShortcutsManager.f10073e, "Sample content GQL fetch failed.", th);
            synchronized (this.f10068a) {
                this.f10068a.f10093y = null;
            }
        }
    }

    /* compiled from: messagevideoattachment */
    class ByWeightComparator implements Comparator<ComposerShortcutItem> {
        public int compare(Object obj, Object obj2) {
            ComposerShortcutItem composerShortcutItem = (ComposerShortcutItem) obj;
            ComposerShortcutItem composerShortcutItem2 = (ComposerShortcutItem) obj2;
            if (composerShortcutItem.f9982k && composerShortcutItem2.f9982k) {
                double d = composerShortcutItem.f9985n;
                double d2 = composerShortcutItem2.f9985n;
                if (d > d2) {
                    return -1;
                }
                if (d < d2) {
                    return 1;
                }
                return composerShortcutItem.f9973b.compareTo(composerShortcutItem2.f9973b);
            } else if (composerShortcutItem.f9982k) {
                return -1;
            } else {
                if (composerShortcutItem2.f9982k) {
                    return 1;
                }
                return composerShortcutItem.f9973b.compareTo(composerShortcutItem2.f9973b);
            }
        }
    }

    static {
        PrefKey prefKey = (PrefKey) MessagingPrefKeys.c.a("composer_shortcuts_pref_key");
        f10070b = prefKey;
        f10071c = (PrefKey) prefKey.a("overflow_pref_key");
    }

    @Inject
    public MessengerComposerShortcutsManager(FbBroadcastManager fbBroadcastManager, Provider<Boolean> provider, Provider<Boolean> provider2, ComposerShortcutsDbStorage composerShortcutsDbStorage, DefaultComposerShortcuts defaultComposerShortcuts, MessengerComposerShortcutsVisibilityHelper messengerComposerShortcutsVisibilityHelper, MessengerComposerShortcutsOrderingHelper messengerComposerShortcutsOrderingHelper, Clock clock, FbSharedPreferences fbSharedPreferences, SampleContentGraphQLFetchHelper sampleContentGraphQLFetchHelper) {
        this.f10076h = fbBroadcastManager;
        this.f10077i = provider;
        this.f10078j = provider2;
        this.f10081m = composerShortcutsDbStorage;
        this.f10079k = defaultComposerShortcuts;
        this.f10080l = messengerComposerShortcutsVisibilityHelper;
        this.f10082n = messengerComposerShortcutsOrderingHelper;
        this.f10083o = clock;
        this.f10084p = fbSharedPreferences;
        this.f10085q = sampleContentGraphQLFetchHelper;
    }

    public final synchronized ShortcutsList mo406a(ComposerShortcutsFilter composerShortcutsFilter) {
        if (this.f10088t == null) {
            if (this.f10086r == null || this.f10087s == null) {
                this.f10088t = this.f10079k.m10567a();
                this.f10089u = false;
            } else {
                this.f10088t = m10584a(this.f10079k.m10567a(), this.f10086r, this.f10087s);
                boolean booleanValue = ((Boolean) this.f10078j.get()).booleanValue();
                if (booleanValue) {
                    this.f10088t = this.f10082n.m10594a(this.f10088t, this.f10090v, m10587c());
                }
                this.f10089u = booleanValue;
            }
        }
        return new ShortcutsList(this.f10080l.m10595a(composerShortcutsFilter, this.f10088t), this.f10089u);
    }

    public final synchronized ListenableFuture<ImmutableMap<String, ImmutableList<PlatformSampleContent>>> mo407a() {
        ListenableFuture<ImmutableMap<String, ImmutableList<PlatformSampleContent>>> a;
        a = this.f10085q.m10618a(this.f10092x);
        C11671 c11671 = new C11671(this);
        Futures.a(a, c11671);
        this.f10093y = FutureAndCallbackHolder.a(a, c11671);
        return a;
    }

    private static ImmutableList<ComposerShortcutItem> m10584a(List<ComposerShortcutItem> list, List<ComposerShortcutItem> list2, List<ComposerShortcutItem> list3) {
        Builder builder = ImmutableList.builder();
        builder.b(list);
        builder.b(list2);
        builder.b(list3);
        return builder.b();
    }

    public synchronized void clearUserData() {
        this.f10088t = null;
        this.f10086r = null;
        this.f10087s = null;
    }

    public final synchronized void mo408a(ComposerShortcutItem composerShortcutItem) {
        int a = m10582a(composerShortcutItem.f9973b);
        if (a >= 0) {
            ComposerShortcutItem composerShortcutItem2 = (ComposerShortcutItem) this.f10086r.get(a);
            composerShortcutItem2 = ComposerShortcutItem.newBuilder().m10520a(composerShortcutItem2).m10517a(composerShortcutItem2.f9985n + 100.0d).m10528s();
            int binarySearch = Collections.binarySearch(this.f10086r, composerShortcutItem2, f10075g);
            if (binarySearch >= 0) {
                BLog.c("ComposerShortcutsManager", "Missing shortcut for %s", new Object[]{composerShortcutItem.f9978g});
            } else {
                binarySearch = (-binarySearch) - 1;
                if (binarySearch == a) {
                    this.f10086r.set(a, composerShortcutItem2);
                    this.f10088t = null;
                } else {
                    this.f10086r.remove(a);
                    this.f10086r.add(binarySearch, composerShortcutItem2);
                    m10585a(binarySearch);
                    this.f10088t = null;
                    this.f10076h.a(f10069a);
                }
                this.f10091w = true;
                m10588d();
            }
        }
    }

    private static ImmutableMap<String, Integer> m10587c() {
        return ImmutableBiMap.b("ride_service_promotion", Integer.valueOf(1));
    }

    @GuardedBy("this")
    private void m10585a(int i) {
        while (i >= 0) {
            ComposerShortcutItem composerShortcutItem = (ComposerShortcutItem) this.f10086r.get(i);
            ComposerShortcutItemBuilder a = ComposerShortcutItem.newBuilder().m10520a(composerShortcutItem);
            a.f9991a = composerShortcutItem.f9985n + 300.0d;
            this.f10086r.set(i, a.m10528s());
            i--;
        }
    }

    @GuardedBy("this")
    private void m10588d() {
        if (BLog.b(3)) {
            int size = this.f10086r.size();
            for (int i = 0; i < size; i++) {
                Double.valueOf(((ComposerShortcutItem) this.f10086r.get(i)).f9985n);
            }
        }
    }

    @GuardedBy("this")
    private int m10582a(String str) {
        if (this.f10086r == null) {
            return -1;
        }
        for (int i = 0; i < this.f10086r.size(); i++) {
            if (Objects.equal(str, ((ComposerShortcutItem) this.f10086r.get(i)).f9973b)) {
                return i;
            }
        }
        return -1;
    }
}
