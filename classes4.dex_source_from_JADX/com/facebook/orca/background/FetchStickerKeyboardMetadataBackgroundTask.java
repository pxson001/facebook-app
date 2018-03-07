package com.facebook.orca.background;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.background.MessagesLocalTaskTag;
import com.facebook.stickers.keyboard.StickerKeyboardMetadataLoader;
import com.facebook.stickers.keyboard.StickerKeyboardMetadataLoader.Params;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.service.StickersQueue;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.EnumSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: failure while replacing text */
public class FetchStickerKeyboardMetadataBackgroundTask extends AbstractBackgroundTask {
    public static final Class<?> f12274a = FetchStickerKeyboardMetadataBackgroundTask.class;
    private static final Object f12275g = new Object();
    private final Clock f12276b;
    private final GatekeeperStoreImpl f12277c;
    private final Provider<Boolean> f12278d;
    private final StickerKeyboardMetadataLoader f12279e;
    private long f12280f;

    private static FetchStickerKeyboardMetadataBackgroundTask m12941b(InjectorLike injectorLike) {
        return new FetchStickerKeyboardMetadataBackgroundTask((Clock) SystemClockMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4045), StickerKeyboardMetadataLoader.m12947a(injectorLike));
    }

    @Inject
    public FetchStickerKeyboardMetadataBackgroundTask(Clock clock, GatekeeperStore gatekeeperStore, Provider<Boolean> provider, StickerKeyboardMetadataLoader stickerKeyboardMetadataLoader) {
        super("STICKER_FETCH_KEYBOARD_METADATA");
        this.f12276b = clock;
        this.f12278d = provider;
        this.f12277c = gatekeeperStore;
        this.f12279e = stickerKeyboardMetadataLoader;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.orca.background.FetchStickerKeyboardMetadataBackgroundTask m12940a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f12275g;	 Catch:{ all -> 0x006c }
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
        r1 = m12941b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f12275g;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.orca.background.FetchStickerKeyboardMetadataBackgroundTask) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.orca.background.FetchStickerKeyboardMetadataBackgroundTask) r0;	 Catch:{  }
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
        r0 = f12275g;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.orca.background.FetchStickerKeyboardMetadataBackgroundTask) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.background.FetchStickerKeyboardMetadataBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.orca.background.FetchStickerKeyboardMetadataBackgroundTask");
    }

    public final ImmutableSet<Class<? extends Annotation>> mo592d() {
        return ImmutableSet.of(StickersQueue.class);
    }

    public final ImmutableSet<Class<? extends Annotation>> mo599b() {
        return ImmutableSet.of(MessagesLocalTaskTag.class);
    }

    public final Set<Prerequisite> mo594h() {
        return EnumSet.of(Prerequisite.NETWORK_CONNECTIVITY, Prerequisite.USER_LOGGED_IN, Prerequisite.USER_IN_APP);
    }

    public final boolean mo595i() {
        if (((Boolean) this.f12278d.get()).booleanValue()) {
            return false;
        }
        if (!this.f12277c.a(291, false)) {
            return false;
        }
        if (this.f12280f == 0) {
            return true;
        }
        return this.f12276b.a() - this.f12280f > 86400000;
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        this.f12279e.mo903a(new 1(this));
        this.f12279e.m12956a(new Params(false, StickerInterface.MESSENGER));
        this.f12280f = this.f12276b.a();
        return null;
    }
}
