package com.facebook.stickers.service;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.common.file.FileTree;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.data.StickerAssetDownloader;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.data.StickerDbStorageImpl;
import com.facebook.stickers.data.StickersDatabaseSupplier;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.service.FetchStickersParams.StickersUpdateOperation;
import com.facebook.tools.dextr.runtime.detour.SQLiteDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: q */
public class StickersHandler {
    public final StickerCache f3959a;
    private final StickersDatabaseSupplier f3960b;
    public final StickerDbStorageImpl f3961c;
    private final ApiMethodRunnerImpl f3962d;
    private final FetchStickersMethod f3963e;
    public final StickerAssetDownloader f3964f;

    public static StickersHandler m4454b(InjectorLike injectorLike) {
        return new StickersHandler(StickerCache.m12960a(injectorLike), StickersDatabaseSupplier.m4268a(injectorLike), StickerDbStorageImpl.m4229a(injectorLike), ApiMethodRunnerImpl.a(injectorLike), FetchStickersMethod.m4457a(injectorLike), StickerAssetDownloader.m4462a(injectorLike));
    }

    @Inject
    public StickersHandler(StickerCache stickerCache, StickersDatabaseSupplier stickersDatabaseSupplier, StickerDbStorageImpl stickerDbStorageImpl, ApiMethodRunnerImpl apiMethodRunnerImpl, FetchStickersMethod fetchStickersMethod, StickerAssetDownloader stickerAssetDownloader) {
        this.f3959a = stickerCache;
        this.f3960b = stickersDatabaseSupplier;
        this.f3961c = stickerDbStorageImpl;
        this.f3962d = apiMethodRunnerImpl;
        this.f3963e = fetchStickersMethod;
        this.f3964f = stickerAssetDownloader;
    }

    private static FetchStickersParams m4452a(FetchStickersParams fetchStickersParams, List<Sticker> list) {
        Collection b = Sets.b(fetchStickersParams.f3957a);
        for (Sticker sticker : list) {
            b.remove(sticker.a);
        }
        return new FetchStickersParams(b, StickersUpdateOperation.DO_NOT_UPDATE_IF_CACHED);
    }

    private FetchStickersResult m4455c(FetchStickersParams fetchStickersParams) {
        ImmutableList a = this.f3959a.m12964a(fetchStickersParams.f3957a);
        FetchStickersParams a2 = m4452a(fetchStickersParams, a);
        Collection<Sticker> a3 = Lists.a();
        if (!a2.f3957a.isEmpty()) {
            ImmutableList a4 = this.f3961c.m4250a((Collection) a2.f3957a);
            a2 = m4452a(a2, a4);
            if (!a2.f3957a.isEmpty()) {
                a3.addAll(((FetchStickersResult) this.f3962d.a(this.f3963e, a2)).f4000a);
                this.f3961c.m4262b((Collection) a3);
            }
            a3.addAll(a4);
            this.f3959a.m12974b((Collection) a3);
        }
        a3.addAll(a);
        Map c = Maps.c();
        Builder builder = ImmutableList.builder();
        for (Sticker sticker : a3) {
            c.put(sticker.a, sticker);
        }
        ImmutableList immutableList = fetchStickersParams.f3957a;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) immutableList.get(i);
            if (c.containsKey(str)) {
                builder.c(c.get(str));
            }
        }
        return new FetchStickersResult(builder.b());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.stickers.service.FetchStickersResult m4456a(com.facebook.stickers.service.FetchStickersParams r3) {
        /*
        r2 = this;
        r0 = "StickersHandler.handleFetchStickers";
        r1 = -1070086139; // 0xffffffffc037c805 float:-2.8715832 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0, r1);
        r0 = com.facebook.stickers.service.StickersHandler.C01831.f3999a;	 Catch:{ all -> 0x001f }
        r1 = r3.m4451b();	 Catch:{ all -> 0x001f }
        r1 = r1.ordinal();	 Catch:{ all -> 0x001f }
        r0 = r0[r1];	 Catch:{ all -> 0x001f }
        switch(r0) {
            case 1: goto L_0x0027;
            case 2: goto L_0x0032;
            default: goto L_0x0017;
        };	 Catch:{ all -> 0x001f }
    L_0x0017:
        r0 = new java.lang.IllegalArgumentException;	 Catch:{ all -> 0x001f }
        r1 = "Cannot fetch stickers without operation type specified";
        r0.<init>(r1);	 Catch:{ all -> 0x001f }
        throw r0;	 Catch:{ all -> 0x001f }
    L_0x001f:
        r0 = move-exception;
        r1 = 18940678; // 0x1210306 float:2.95732E-38 double:9.3579383E-317;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
    L_0x0027:
        r0 = r2.m4453b(r3);	 Catch:{  }
        r1 = 598389803; // 0x23aab42b float:1.8507741E-17 double:2.956438445E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
    L_0x0031:
        return r0;
    L_0x0032:
        r0 = r2.m4455c(r3);	 Catch:{  }
        r1 = 1428441067; // 0x552447eb float:1.12892995E13 double:7.057436583E-315;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        goto L_0x0031;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.service.StickersHandler.a(com.facebook.stickers.service.FetchStickersParams):com.facebook.stickers.service.FetchStickersResult");
    }

    private FetchStickersResult m4453b(FetchStickersParams fetchStickersParams) {
        if (fetchStickersParams.m4450a().isEmpty()) {
            return new FetchStickersResult(Collections.emptyList());
        }
        List a = ((FetchStickersResult) this.f3962d.a(this.f3963e, fetchStickersParams)).m4497a();
        for (Sticker sticker : this.f3961c.m4250a(fetchStickersParams.m4450a())) {
            if (sticker.d != null) {
                FileTree.m3118b(new File(sticker.d.getPath()));
            }
            if (sticker.f != null) {
                FileTree.m3118b(new File(sticker.f.getPath()));
            }
            if (sticker.h != null) {
                FileTree.m3118b(new File(sticker.h.getPath()));
            }
        }
        SQLiteDatabase a2 = this.f3960b.a();
        SQLiteDetour.a(a2, -282726847);
        try {
            this.f3961c.m4267c(fetchStickersParams.m4450a());
            this.f3961c.m4262b((Collection) a);
            a2.setTransactionSuccessful();
            this.f3959a.m12974b((Collection) a);
            return new FetchStickersResult(a);
        } finally {
            a = -69548107;
            SQLiteDetour.b(a2, -69548107);
        }
    }
}
