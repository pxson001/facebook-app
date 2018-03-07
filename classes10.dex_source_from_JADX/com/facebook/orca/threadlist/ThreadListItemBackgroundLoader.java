package com.facebook.orca.threadlist;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.facebook.analytics.CounterLogger;
import com.facebook.auth.module.UserKey_LoggedInUserKeyMethodAutoProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.send.client.SendMessageManager;
import com.facebook.messaging.util.date.MessagingDateUtil;
import com.facebook.orca.threadview.seenheads.SeenHeadsEligibilityChecker;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Provider;

@UserScoped
/* compiled from: native_article */
public class ThreadListItemBackgroundLoader {
    private static final Object f6686n = new Object();
    private final ExecutorService f6687a;
    private final GatekeeperStoreImpl f6688b;
    private final GlyphColorizer f6689c;
    private final MessagingDateUtil f6690d;
    private final Provider<Boolean> f6691e;
    private final SeenHeadsEligibilityChecker f6692f;
    private final ThreadSnippetDisplayUtil f6693g;
    public final UserCache f6694h;
    private final UserKey f6695i;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<CounterLogger> f6696j = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> f6697k = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SendMessageManager> f6698l = UltralightRuntime.b;
    public final Map<ThreadKey, Future<PrefetchedData>> f6699m;

    /* compiled from: native_article */
    final class PrefetchedData {
        final int f6681a;
        @Nullable
        CharSequence f6682b;
        @Nullable
        Drawable f6683c;
        @Nullable
        List<UserKey> f6684d;
        @Nullable
        String f6685e;

        PrefetchedData(int i) {
            this.f6681a = i;
        }
    }

    private static ThreadListItemBackgroundLoader m6388b(InjectorLike injectorLike) {
        ThreadListItemBackgroundLoader threadListItemBackgroundLoader = new ThreadListItemBackgroundLoader((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), GlyphColorizer.a(injectorLike), MessagingDateUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 4155), SeenHeadsEligibilityChecker.m8295a(injectorLike), ThreadSnippetDisplayUtil.m6427a(injectorLike), UserCache.a(injectorLike), UserKey_LoggedInUserKeyMethodAutoProvider.b(injectorLike));
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 128);
        com.facebook.inject.Lazy b2 = IdBasedSingletonScopeProvider.b(injectorLike, 494);
        com.facebook.inject.Lazy a = IdBasedLazy.a(injectorLike, 8347);
        threadListItemBackgroundLoader.f6696j = b;
        threadListItemBackgroundLoader.f6697k = b2;
        threadListItemBackgroundLoader.f6698l = a;
        return threadListItemBackgroundLoader;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.orca.threadlist.ThreadListItemBackgroundLoader m6384a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f6686n;	 Catch:{ all -> 0x006c }
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
        r1 = m6388b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f6686n;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.orca.threadlist.ThreadListItemBackgroundLoader) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.orca.threadlist.ThreadListItemBackgroundLoader) r0;	 Catch:{  }
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
        r0 = f6686n;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.orca.threadlist.ThreadListItemBackgroundLoader) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.threadlist.ThreadListItemBackgroundLoader.a(com.facebook.inject.InjectorLike):com.facebook.orca.threadlist.ThreadListItemBackgroundLoader");
    }

    @Inject
    private ThreadListItemBackgroundLoader(ExecutorService executorService, GatekeeperStore gatekeeperStore, GlyphColorizer glyphColorizer, MessagingDateUtil messagingDateUtil, Provider<Boolean> provider, SeenHeadsEligibilityChecker seenHeadsEligibilityChecker, ThreadSnippetDisplayUtil threadSnippetDisplayUtil, UserCache userCache, UserKey userKey) {
        this.f6687a = executorService;
        this.f6688b = gatekeeperStore;
        this.f6689c = glyphColorizer;
        this.f6690d = messagingDateUtil;
        this.f6691e = provider;
        this.f6692f = seenHeadsEligibilityChecker;
        this.f6693g = threadSnippetDisplayUtil;
        this.f6694h = userCache;
        this.f6695i = userKey;
        this.f6699m = new HashMap();
    }

    public final void m6391a(final Context context, List<ThreadSummary> list) {
        if (this.f6688b.a(163, false)) {
            final int a = m6382a(context);
            for (final ThreadSummary threadSummary : list) {
                if (!this.f6699m.containsKey(threadSummary.a)) {
                    this.f6699m.put(threadSummary.a, ExecutorDetour.a(this.f6687a, new Callable<PrefetchedData>(this) {
                        final /* synthetic */ ThreadListItemBackgroundLoader f6680d;

                        public Object call() {
                            return ThreadListItemBackgroundLoader.m6387b(this.f6680d, context, threadSummary, a);
                        }
                    }, -1940997450));
                }
            }
        }
    }

    public final PrefetchedData m6390a(Context context, ThreadSummary threadSummary, int i) {
        Future future = (Future) this.f6699m.remove(threadSummary.a);
        if (future == null || !future.isDone()) {
            if (future != null) {
                future.cancel(false);
            }
            return m6387b(this, context, threadSummary, i);
        }
        try {
            PrefetchedData prefetchedData = (PrefetchedData) FutureDetour.a(future, 1, TimeUnit.NANOSECONDS, -987327007);
            if (prefetchedData.f6681a == i) {
                return prefetchedData;
            }
            BLog.c("ThreadListItemBackgroundLoader", "guessed wrong text size: guess=%d, actual=%d", new Object[]{Integer.valueOf(prefetchedData.f6681a), Integer.valueOf(i)});
            prefetchedData.f6682b = this.f6693g.m6431a(threadSummary, i);
            return prefetchedData;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private int m6382a(Context context) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131428617);
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(2130773038, typedValue, true)) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(typedValue.data, new int[]{16842901});
            int dimensionPixelSize2;
            try {
                dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(0, dimensionPixelSize);
                return dimensionPixelSize2;
            } catch (Exception e) {
                dimensionPixelSize2 = e;
                BLog.c("ThreadListItemBackgroundLoader", dimensionPixelSize2, "couldn't extract text size from style", new Object[0]);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            ((CounterLogger) this.f6696j.get()).a("android.messenger.threadlist_background_loader.theme_attr_resolution_failed");
            return dimensionPixelSize;
        }
    }

    public static PrefetchedData m6387b(ThreadListItemBackgroundLoader threadListItemBackgroundLoader, Context context, ThreadSummary threadSummary, int i) {
        PrefetchedData prefetchedData = new PrefetchedData(i);
        prefetchedData.f6682b = threadListItemBackgroundLoader.f6693g.m6431a(threadSummary, i);
        prefetchedData.f6685e = threadListItemBackgroundLoader.f6690d.a(threadSummary.k);
        TracerDetour.a("GetSendStateDrawable", 484858208);
        try {
            if (threadListItemBackgroundLoader.m6385a(threadSummary)) {
                prefetchedData.f6683c = threadListItemBackgroundLoader.f6693g.m6430a(context, threadSummary);
            } else if (threadSummary.r != null && threadSummary.r.b.equals(threadListItemBackgroundLoader.f6695i)) {
                prefetchedData.f6683c = threadListItemBackgroundLoader.m6383a(context, threadSummary);
                if (prefetchedData.f6683c == null) {
                    prefetchedData.f6684d = threadListItemBackgroundLoader.m6389b(threadSummary);
                    if (prefetchedData.f6684d == null) {
                        prefetchedData.f6683c = threadListItemBackgroundLoader.m6386b(context, threadSummary);
                    }
                }
            }
            TracerDetour.a(-1329312243);
            return prefetchedData;
        } catch (Throwable th) {
            TracerDetour.a(-19690095);
        }
    }

    private boolean m6385a(ThreadSummary threadSummary) {
        return !this.f6692f.m8297a(threadSummary.h.size(), threadSummary.A) || this.f6693g.m6432a(threadSummary);
    }

    @Nullable
    private Drawable m6383a(Context context, ThreadSummary threadSummary) {
        if (threadSummary.z) {
            return this.f6689c.a(2130842109, context.getResources().getColor(2131362299));
        }
        if (((SendMessageManager) this.f6698l.get()).a(threadSummary.a)) {
            return context.getResources().getDrawable(2130842111);
        }
        return null;
    }

    @Nullable
    private List<UserKey> m6389b(ThreadSummary threadSummary) {
        TreeMap treeMap = new TreeMap();
        ImmutableList immutableList = threadSummary.h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
            if (threadParticipant.b >= threadSummary.k && !threadParticipant.b().equals(this.f6695i)) {
                treeMap.put(Long.valueOf(threadParticipant.b), threadParticipant.b());
            }
        }
        if (treeMap.isEmpty()) {
            return null;
        }
        List<UserKey> copyOf = ImmutableList.copyOf(treeMap.values());
        ImmutableList a = this.f6694h.a(copyOf);
        int size2 = a.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((User) a.get(i2)).z();
        }
        return copyOf;
    }

    @Nullable
    private Drawable m6386b(Context context, ThreadSummary threadSummary) {
        ImmutableList immutableList = threadSummary.h;
        int size = immutableList.size();
        Object obj = null;
        for (int i = 0; i < size; i++) {
            ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
            UserKey b = threadParticipant.b();
            if (!b.equals(this.f6695i)) {
                User a = this.f6694h.a(b);
                if (a != null && a.t) {
                    obj = 1;
                }
                if (threadParticipant.d >= threadSummary.k && !(r1 == null && ((Boolean) this.f6691e.get()).booleanValue())) {
                    return context.getResources().getDrawable(2130842108);
                }
            }
        }
        if (obj == null && ((Boolean) this.f6691e.get()).booleanValue()) {
            return null;
        }
        return context.getResources().getDrawable(2130842114);
    }
}
