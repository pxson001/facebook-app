package com.facebook.stickers.keyboard;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.loader.FbLoader;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.debug.log.BLog;
import com.facebook.debug.tracer.Tracer;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.data.StickerInterfaceTranslator;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.service.FetchStickerPacksParams.Builder;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: failure to decode exception JSON!!!! */
public class StickerKeyboardMetadataLoader implements FbLoader<Params, Results, Throwable> {
    private static final Class<?> f12281a = StickerKeyboardMetadataLoader.class;
    private static final Object f12282i = new Object();
    public boolean f12283b = false;
    public DefaultBlueServiceOperationFactory f12284c;
    public Callback<Params, Results, Throwable> f12285d;
    private Executor f12286e;
    public ListenableFuture<List<OperationResult>> f12287f;
    public StickerCache f12288g;
    public ViewerContextManager f12289h;

    private static StickerKeyboardMetadataLoader m12950b(InjectorLike injectorLike) {
        return new StickerKeyboardMetadataLoader(StickerCache.m12960a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), ViewerContextManagerProvider.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.stickers.keyboard.StickerKeyboardMetadataLoader m12947a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f12282i;	 Catch:{ all -> 0x006c }
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
        r1 = m12950b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f12282i;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.stickers.keyboard.StickerKeyboardMetadataLoader) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.stickers.keyboard.StickerKeyboardMetadataLoader) r0;	 Catch:{  }
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
        r0 = f12282i;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.stickers.keyboard.StickerKeyboardMetadataLoader) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.keyboard.StickerKeyboardMetadataLoader.a(com.facebook.inject.InjectorLike):com.facebook.stickers.keyboard.StickerKeyboardMetadataLoader");
    }

    @Inject
    public StickerKeyboardMetadataLoader(StickerCache stickerCache, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ViewerContextManager viewerContextManager, Executor executor) {
        this.f12288g = stickerCache;
        this.f12284c = defaultBlueServiceOperationFactory;
        this.f12289h = viewerContextManager;
        this.f12286e = executor;
    }

    public final void mo903a(Callback<Params, Results, Throwable> callback) {
        this.f12285d = callback;
    }

    public final void m12956a(Params params) {
        boolean z = false;
        if (this.f12285d != null) {
            ImmutableList a;
            this.f12283b = false;
            StickerPackType stickerPackType = StickerPackType.DOWNLOADED_PACKS;
            if (this.f12288g.m12970a(stickerPackType)) {
                a = m12948a(params, this.f12288g.m12973b(stickerPackType));
            } else {
                a = null;
            }
            List list = a;
            if (this.f12288g.m12976b()) {
                a = this.f12288g.m12963a();
            } else {
                a = null;
            }
            List list2 = a;
            if (this.f12288g.m12980d()) {
                a = m12948a(params, this.f12288g.m12978c());
            } else {
                a = null;
            }
            List list3 = a;
            if (list == null || list2 == null || list3 == null || params.a) {
                z = true;
            } else {
                Lists.a().addAll(list);
            }
            if (z) {
                this.f12285d.mo948a((Object) params, m12952c(params));
            } else {
                this.f12285d.mo950b(params, new Results(list, m12949a(list, list3), list2));
            }
        }
    }

    public final void m12954a() {
        this.f12283b = true;
        if (this.f12287f != null) {
            this.f12287f.cancel(false);
            this.f12287f = null;
        }
    }

    private ListenableFuture<Results> m12952c(Params params) {
        DataFreshnessParam dataFreshnessParam;
        SettableFuture f = SettableFuture.f();
        List a = Lists.a();
        StickerPackType stickerPackType = StickerPackType.DOWNLOADED_PACKS;
        if (params.a) {
            dataFreshnessParam = DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA;
        } else {
            dataFreshnessParam = DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE;
        }
        Builder builder = new Builder(stickerPackType, dataFreshnessParam);
        builder.f3917c = StickerInterfaceTranslator.a(params.b);
        Parcelable a2 = builder.m4385a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchStickerPacksParams", a2);
        bundle.putParcelable("overridden_viewer_context", this.f12289h.a());
        ListenableFuture a3 = BlueServiceOperationFactoryDetour.a(this.f12284c, "fetch_sticker_packs", bundle, 1225825202).a();
        OperationFuture d = m12953d();
        OperationFuture c = m12951c();
        this.f12287f = Futures.a(new ListenableFuture[]{d, a3, c});
        Futures.a(this.f12287f, new 1(this, a, params, f), this.f12286e);
        Tracer.b("fetchStickerPacksAsync (DOWNLOADED) started");
        return f;
    }

    private OperationFuture m12951c() {
        return BlueServiceOperationFactoryDetour.a(this.f12284c, "fetch_download_preview_sticker_packs", new Bundle(), 913328844).a();
    }

    private OperationFuture m12953d() {
        return BlueServiceOperationFactoryDetour.a(this.f12284c, "fetch_recent_stickers", new Bundle(), 78749417).a();
    }

    public static ImmutableList<StickerPack> m12948a(Params params, @Nullable List<StickerPack> list) {
        if (list == null || list.isEmpty()) {
            return RegularImmutableList.a;
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (StickerPack stickerPack : list) {
            if (stickerPack.n && params.b == StickerInterface.COMPOSER) {
                builder.c(stickerPack);
            } else if (stickerPack.m && params.b == StickerInterface.COMMENTS) {
                builder.c(stickerPack);
            } else if (stickerPack.o && params.b == StickerInterface.MESSENGER) {
                builder.c(stickerPack);
            } else if (stickerPack.v && params.b == StickerInterface.SMS) {
                builder.c(stickerPack);
            }
        }
        return builder.b();
    }

    public static ImmutableList<StickerPack> m12949a(List<StickerPack> list, List<StickerPack> list2) {
        Set a = Sets.a();
        for (StickerPack stickerPack : list) {
            a.add(stickerPack.a);
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (StickerPack stickerPack2 : list2) {
            if (a.contains(stickerPack2.a)) {
                BLog.b(f12281a, "Download preview cache out of sync");
            } else {
                builder.c(stickerPack2);
            }
        }
        return builder.b();
    }
}
