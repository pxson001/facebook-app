package com.facebook.stickers.service;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.login.RemoteLogOutHelper;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.data.StickerDbStorageImpl;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerAssetType;
import com.facebook.stickers.model.StickerBuilder;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.service.FetchStickerPacksParams.Builder;
import com.facebook.stickers.service.FetchStickerPacksParams.TrayPacksUpdateOperation;
import com.facebook.stickers.service.FetchStickerPacksResult.Availability;
import com.facebook.stickers.service.FetchStickerTagsParams.TagType;
import com.facebook.stickers.service.FetchStickersParams.StickersUpdateOperation;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

/* compiled from: reaction_infos */
public class StickerLocalServiceHandler implements BlueServiceHandler {
    private final StickerCache f3772a;
    private final RecentStickersHandler f3773b;
    private final StickerTagHandler f3774c;
    private final StickerPacksHandler f3775d;
    private final DownloadPreviewStickerPacksHandler f3776e;
    private final StickerConfigBroadcaster f3777f;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RemoteLogOutHelper> f3778g = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<StickersHandler> f3779h = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<StickerAssetsHandler> f3780i = UltralightRuntime.b;

    public static StickerLocalServiceHandler m4212b(InjectorLike injectorLike) {
        StickerLocalServiceHandler stickerLocalServiceHandler = new StickerLocalServiceHandler(StickerCache.m12960a(injectorLike), new RecentStickersHandler(StickerCache.m12960a(injectorLike), StickerDbStorageImpl.m4229a(injectorLike)), StickerTagHandler.m4299b(injectorLike), StickerPacksHandler.m4340b(injectorLike), new DownloadPreviewStickerPacksHandler(StickerPacksHandler.m4340b(injectorLike), StickerCache.m12960a(injectorLike), StickerDbStorageImpl.m4229a(injectorLike), DownloadPreviewStickerPacksHelper.m4382a(injectorLike)), StickerConfigBroadcaster.m4373a(injectorLike));
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 7906);
        com.facebook.inject.Lazy a = IdBasedLazy.a(injectorLike, 3477);
        com.facebook.inject.Lazy a2 = IdBasedLazy.a(injectorLike, 11032);
        stickerLocalServiceHandler.f3778g = b;
        stickerLocalServiceHandler.f3779h = a;
        stickerLocalServiceHandler.f3780i = a2;
        return stickerLocalServiceHandler;
    }

    @Inject
    public StickerLocalServiceHandler(StickerCache stickerCache, RecentStickersHandler recentStickersHandler, StickerTagHandler stickerTagHandler, StickerPacksHandler stickerPacksHandler, DownloadPreviewStickerPacksHandler downloadPreviewStickerPacksHandler, StickerConfigBroadcaster stickerConfigBroadcaster) {
        this.f3772a = stickerCache;
        this.f3773b = recentStickersHandler;
        this.f3774c = stickerTagHandler;
        this.f3775d = stickerPacksHandler;
        this.f3776e = downloadPreviewStickerPacksHandler;
        this.f3777f = stickerConfigBroadcaster;
    }

    private OperationResult m4214c(OperationParams operationParams) {
        Object obj;
        FetchStickerPacksParams fetchStickerPacksParams = (FetchStickerPacksParams) operationParams.c.getParcelable("fetchStickerPacksParams");
        StickerPackType stickerPackType = fetchStickerPacksParams.f3923a;
        DataFreshnessParam dataFreshnessParam = fetchStickerPacksParams.f3924b;
        if (!this.f3772a.m12970a(stickerPackType) || dataFreshnessParam == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA) {
            obj = (FetchStickerPacksResult) this.f3775d.m4347c(operationParams).h();
            if (obj.f3955b.isPresent()) {
                this.f3772a.m12967a(stickerPackType, (List) obj.f3955b.get());
                if (fetchStickerPacksParams.f3930h != TrayPacksUpdateOperation.DO_NOT_UPDATE) {
                    Builder builder = new Builder(StickerPackType.DOWNLOADED_PACKS, DataFreshnessParam.DO_NOT_CHECK_SERVER);
                    builder.f3917c = fetchStickerPacksParams.m4388d();
                    Parcelable a = builder.m4385a();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("fetchStickerPacksParams", a);
                    FetchStickerPacksResult fetchStickerPacksResult = (FetchStickerPacksResult) this.f3775d.m4347c(new OperationParams("fetch_sticker_packs", bundle)).h();
                    if (fetchStickerPacksResult.f3955b.isPresent()) {
                        this.f3772a.m12967a(StickerPackType.DOWNLOADED_PACKS, (List) fetchStickerPacksResult.f3955b.get());
                    }
                }
            } else if (dataFreshnessParam != DataFreshnessParam.DO_NOT_CHECK_SERVER) {
                throw new IllegalStateException("Undefined sticker pack fetch results from server, this should never happen!");
            }
        }
        obj = new FetchStickerPacksResult(this.f3772a.m12973b(stickerPackType));
        return OperationResult.a(obj);
    }

    private OperationResult m4217e(OperationParams operationParams) {
        return OperationResult.a(((StickersHandler) this.f3779h.get()).m4456a((FetchStickersParams) operationParams.c.getParcelable("fetchStickersParams")));
    }

    private OperationResult m4219g(OperationParams operationParams) {
        FetchStickerTagsResult fetchStickerTagsResult;
        FetchStickerTagsParams fetchStickerTagsParams = (FetchStickerTagsParams) operationParams.c.getParcelable("fetchStickerTagsParam");
        StickerTagHandler stickerTagHandler = this.f3774c;
        boolean equals = fetchStickerTagsParams.a.equals(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
        if (!fetchStickerTagsParams.b.equals(TagType.FEATURED)) {
            fetchStickerTagsResult = (FetchStickerTagsResult) stickerTagHandler.f3861c.a(stickerTagHandler.f3862d, fetchStickerTagsParams);
        } else if (!stickerTagHandler.f3859a.m12982f() || equals) {
            if (stickerTagHandler.f3860b.m4266c().isEmpty() || equals) {
                fetchStickerTagsResult = (FetchStickerTagsResult) stickerTagHandler.f3861c.a(stickerTagHandler.f3862d, fetchStickerTagsParams);
                stickerTagHandler.f3860b.m4253a(fetchStickerTagsResult.a);
            } else {
                fetchStickerTagsResult = new FetchStickerTagsResult(stickerTagHandler.f3860b.m4266c());
            }
            stickerTagHandler.f3859a.m12968a(fetchStickerTagsResult.a);
        } else {
            fetchStickerTagsResult = new FetchStickerTagsResult(stickerTagHandler.f3859a.m12983g());
        }
        return OperationResult.a(fetchStickerTagsResult);
    }

    private OperationResult m4221i(OperationParams operationParams) {
        OperationResult a;
        SaveStickerAssetParams saveStickerAssetParams = (SaveStickerAssetParams) operationParams.c.getParcelable("SaveStickerAssetParams");
        CallerContext callerContext = operationParams.e;
        StickersHandler stickersHandler = (StickersHandler) this.f3779h.get();
        int i = 0;
        String str = saveStickerAssetParams.a;
        Uri uri = saveStickerAssetParams.c;
        StickerAssetType fromDbString = StickerAssetType.fromDbString(saveStickerAssetParams.b);
        ImmutableList a2 = stickersHandler.f3961c.m4250a(ImmutableList.of(str));
        if (a2.isEmpty()) {
            a = OperationResult.a(ErrorCode.CANCELLED, "The given sticker id is not valid");
        } else {
            Sticker sticker = (Sticker) a2.get(0);
            int i2 = (fromDbString.equals(StickerAssetType.STATIC) && sticker.d == null) ? 1 : 0;
            int i3;
            if (fromDbString.equals(StickerAssetType.ANIMATED) && sticker.f == null) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            int i4;
            if (fromDbString.equals(StickerAssetType.PREVIEW) && sticker.h == null && sticker.d == null) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            if (!(i2 == 0 && r8 == 0 && r10 == 0)) {
                i = 1;
            }
            if (i != 0) {
                StickerBuilder a3 = StickerBuilder.newBuilder().a(sticker);
                File a4 = stickersHandler.f3964f.m4464a(sticker.b, sticker.a, fromDbString, uri, callerContext);
                stickersHandler.f3961c.m4255a(sticker.a, fromDbString, a4);
                if (fromDbString.equals(StickerAssetType.STATIC)) {
                    a3.d = Uri.fromFile(a4);
                    if (sticker.h != null) {
                        stickersHandler.f3961c.m4254a(sticker.a, StickerAssetType.PREVIEW);
                        boolean delete = new File(sticker.h.getPath()).delete();
                        a3.h = null;
                    }
                } else if (fromDbString.equals(StickerAssetType.ANIMATED)) {
                    a3.f = Uri.fromFile(a4);
                } else if (fromDbString.equals(StickerAssetType.PREVIEW)) {
                    a3.h = Uri.fromFile(a4);
                }
                stickersHandler.f3959a.m12974b(ImmutableList.of(a3.a()));
            }
            a = OperationResult.a;
        }
        return a;
    }

    private OperationResult m4222j(OperationParams operationParams) {
        StickerPack stickerPack = (StickerPack) operationParams.c.getParcelable("stickerPack");
        this.f3775d.m4348d(operationParams);
        m4209a(StickerPackType.OWNED_PACKS, stickerPack);
        m4209a(StickerPackType.DOWNLOADED_PACKS, stickerPack);
        Bundle bundle = new Bundle();
        bundle.putParcelable("stickerPack", stickerPack);
        this.f3776e.m4381a(new OperationParams("add_closed_download_preview_sticker_pack", bundle));
        this.f3777f.m4375a();
        return OperationResult.a;
    }

    private OperationResult m4225m(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        this.f3775d.m4345a(bundle.getParcelableArrayList("stickerPacks"), bundle.getParcelableArrayList("deletedStickerPacks"));
        this.f3772a.m12981e();
        return OperationResult.a;
    }

    private OperationResult m4226n(OperationParams operationParams) {
        StickerSearchParams stickerSearchParams = (StickerSearchParams) operationParams.c.getParcelable("stickerSearchParams");
        StickerTagHandler stickerTagHandler = this.f3774c;
        return OperationResult.a((StickerSearchResult) stickerTagHandler.f3861c.a(stickerTagHandler.f3864f, stickerSearchParams));
    }

    private OperationResult m4227o(OperationParams operationParams) {
        Sticker sticker = (Sticker) operationParams.c.getParcelable("sticker");
        RecentStickersHandler recentStickersHandler = this.f3773b;
        ImmutableList<Sticker> a = recentStickersHandler.f3782b.m4248a();
        List a2 = Lists.a(Math.min(a.size() + 1, 16));
        a2.add(sticker);
        for (Sticker sticker2 : a) {
            if (a2.size() >= 16) {
                break;
            } else if (!sticker2.a.equals(sticker.a)) {
                a2.add(sticker2);
            }
        }
        recentStickersHandler.f3782b.m4256a(a2);
        recentStickersHandler.f3781a.m12969a(a2);
        return OperationResult.a;
    }

    public final OperationResult m4228a(OperationParams operationParams) {
        try {
            String a = operationParams.a();
            if ("fetch_sticker_pack_ids".equals(a)) {
                return m4211b(operationParams);
            }
            if ("fetch_sticker_packs".equals(a)) {
                return m4214c(operationParams);
            }
            if ("fetch_sticker_packs_by_id".equals(a)) {
                return m4216d(operationParams);
            }
            if ("fetch_recent_stickers".equals(a)) {
                return m4208a();
            }
            if ("fetch_stickers".equals(a)) {
                return m4217e(operationParams);
            }
            if ("fetch_sticker_packs_and_stickers".equals(a)) {
                return m4218f(operationParams);
            }
            if ("fetch_sticker_tags".equals(a)) {
                return m4219g(operationParams);
            }
            if ("fetch_tagged_sticker_ids".equals(a)) {
                return m4220h(operationParams);
            }
            if ("add_sticker_pack".equals(a)) {
                return m4222j(operationParams);
            }
            if ("fetch_closed_download_preview_pack_ids".equals(a)) {
                return m4210b();
            }
            if ("fetch_download_preview_sticker_packs".equals(a)) {
                return m4213c();
            }
            if ("add_closed_download_preview_sticker_pack".equals(a)) {
                return m4223k(operationParams);
            }
            if ("download_sticker_pack_assets".equals(a)) {
                return m4224l(operationParams);
            }
            if ("set_downloaded_sticker_packs".equals(a)) {
                return m4225m(operationParams);
            }
            if ("sticker_search".equals(a)) {
                return m4226n(operationParams);
            }
            if ("update_recent_stickers".equals(a)) {
                return m4227o(operationParams);
            }
            if ("download_sticker_asset".equals(a)) {
                return m4221i(operationParams);
            }
            if ("clear_sticker_cache".equals(a)) {
                return m4215d();
            }
            throw new IllegalArgumentException("Unknown operation type: " + a);
        } catch (Exception e) {
            Exception exception = e;
            ((RemoteLogOutHelper) this.f3778g.get()).a(exception);
            throw exception;
        }
    }

    private OperationResult m4211b(OperationParams operationParams) {
        return this.f3775d.m4344a(operationParams);
    }

    private OperationResult m4216d(OperationParams operationParams) {
        return this.f3775d.m4346b(operationParams);
    }

    private OperationResult m4208a() {
        List a;
        RecentStickersHandler recentStickersHandler = this.f3773b;
        if (recentStickersHandler.f3781a.m12976b()) {
            a = recentStickersHandler.f3781a.m12963a();
        } else {
            a = recentStickersHandler.f3782b.m4248a();
            recentStickersHandler.f3781a.m12969a(a);
        }
        return OperationResult.a(new FetchRecentStickersResult(a));
    }

    private OperationResult m4218f(OperationParams operationParams) {
        FetchStickerPacksAndStickersParams fetchStickerPacksAndStickersParams = (FetchStickerPacksAndStickersParams) operationParams.c.getParcelable("fetchStickerPacksAndStickersParams");
        Parcelable a = new Builder(fetchStickerPacksAndStickersParams.f3766a, fetchStickerPacksAndStickersParams.f3767b).m4385a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchStickerPacksParams", a);
        OperationResult a2 = m4228a(new OperationParams("fetch_sticker_packs", bundle, operationParams.a, operationParams.d, operationParams.e, operationParams.f));
        if (!a2.b) {
            return a2;
        }
        ImmutableList immutableList;
        int i;
        FetchStickerPacksResult fetchStickerPacksResult = (FetchStickerPacksResult) a2.k();
        if (fetchStickerPacksResult.f3955b.isPresent()) {
            immutableList = (ImmutableList) fetchStickerPacksResult.f3955b.get();
        } else {
            immutableList = RegularImmutableList.a;
        }
        Collection a3 = Lists.a();
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            a3.addAll(((StickerPack) immutableList.get(i)).t);
        }
        a = new FetchStickersParams(a3, StickersUpdateOperation.DO_NOT_UPDATE_IF_CACHED);
        bundle = new Bundle();
        bundle.putParcelable("fetchStickersParams", a);
        a2 = m4228a(new OperationParams("fetch_stickers", bundle, operationParams.a, operationParams.d, operationParams.e, operationParams.f));
        if (!a2.b) {
            return a2;
        }
        FetchStickersResult fetchStickersResult = (FetchStickersResult) a2.k();
        ArrayListMultimap t = ArrayListMultimap.t();
        ImmutableList immutableList2 = fetchStickersResult.f4000a;
        int size2 = immutableList2.size();
        for (i = 0; i < size2; i++) {
            Sticker sticker = (Sticker) immutableList2.get(i);
            t.a(sticker.b, sticker);
        }
        ImmutableMap.Builder builder = ImmutableMap.builder();
        size2 = immutableList.size();
        for (i = 0; i < size2; i++) {
            StickerPack stickerPack = (StickerPack) immutableList.get(i);
            builder.b(stickerPack.a, ImmutableList.copyOf(t.a(stickerPack.a)));
        }
        return OperationResult.a(new FetchStickerPacksAndStickersResult(immutableList, builder.b()));
    }

    private OperationResult m4220h(OperationParams operationParams) {
        StickerTagHandler stickerTagHandler = this.f3774c;
        return OperationResult.a((FetchTaggedStickersResult) stickerTagHandler.f3861c.a(stickerTagHandler.f3863e, (FetchTaggedStickersParams) operationParams.c.getParcelable("fetchTaggedStickerIdsParams")));
    }

    private void m4209a(StickerPackType stickerPackType, StickerPack stickerPack) {
        if (this.f3772a.m12970a(stickerPackType)) {
            this.f3772a.m12966a(stickerPackType, stickerPack);
        }
    }

    private OperationResult m4223k(OperationParams operationParams) {
        this.f3776e.m4381a(operationParams);
        return OperationResult.a;
    }

    private OperationResult m4210b() {
        return OperationResult.a(new FetchStickerPackIdsResult(this.f3776e.f3911c.m4259b()));
    }

    private OperationResult m4213c() {
        FetchStickerPacksResult fetchStickerPacksResult;
        DownloadPreviewStickerPacksHandler downloadPreviewStickerPacksHandler = this.f3776e;
        if (downloadPreviewStickerPacksHandler.f3910b.m12980d()) {
            fetchStickerPacksResult = new FetchStickerPacksResult(downloadPreviewStickerPacksHandler.f3910b.m12978c());
        } else {
            String a = downloadPreviewStickerPacksHandler.f3912d.f3914a.a(DownloadPreviewStickerPacksXConfig.f1888c, "");
            ArrayList arrayList = a.isEmpty() ? new ArrayList() : StringUtil.a(a, ',');
            arrayList.removeAll(downloadPreviewStickerPacksHandler.f3911c.m4259b());
            FetchStickerPacksByIdParams fetchStickerPacksByIdParams = new FetchStickerPacksByIdParams(arrayList);
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchStickerPacksByIdParams", fetchStickerPacksByIdParams);
            OperationParams operationParams = new OperationParams("fetch_sticker_packs_by_id", bundle);
            ImmutableList.Builder builder = new ImmutableList.Builder();
            fetchStickerPacksResult = (FetchStickerPacksResult) downloadPreviewStickerPacksHandler.f3909a.m4346b(operationParams).h();
            for (StickerPack stickerPack : (List) fetchStickerPacksResult.f3955b.get()) {
                if (((Availability) fetchStickerPacksResult.m4448a(stickerPack).get()).equals(Availability.IN_STORE)) {
                    builder.c(stickerPack);
                }
            }
            List b = builder.b();
            downloadPreviewStickerPacksHandler.f3910b.m12975b(b);
            fetchStickerPacksResult = new FetchStickerPacksResult(b);
        }
        return OperationResult.a(fetchStickerPacksResult);
    }

    private OperationResult m4224l(OperationParams operationParams) {
        return ((StickerAssetsHandler) this.f3780i.get()).a(operationParams);
    }

    private OperationResult m4215d() {
        this.f3772a.m12984h();
        return OperationResult.a;
    }
}
