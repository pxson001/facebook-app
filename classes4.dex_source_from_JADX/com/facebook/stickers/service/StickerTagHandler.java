package com.facebook.stickers.service;

import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.data.StickerDbStorageImpl;
import javax.inject.Inject;

/* compiled from: ranges */
public class StickerTagHandler {
    public final StickerCache f3859a;
    public final StickerDbStorageImpl f3860b;
    public final ApiMethodRunnerImpl f3861c;
    public final FetchStickerTagsMethod f3862d;
    public final FetchTaggedStickersMethod f3863e;
    public final StickerSearchMethod f3864f;

    public static StickerTagHandler m4299b(InjectorLike injectorLike) {
        return new StickerTagHandler(StickerCache.m12960a(injectorLike), StickerDbStorageImpl.m4229a(injectorLike), ApiMethodRunnerImpl.a(injectorLike), FetchStickerTagsMethod.m4300a(injectorLike), FetchTaggedStickersMethod.m4320a(injectorLike), StickerSearchMethod.m4325a(injectorLike));
    }

    @Inject
    public StickerTagHandler(StickerCache stickerCache, StickerDbStorageImpl stickerDbStorageImpl, ApiMethodRunnerImpl apiMethodRunnerImpl, FetchStickerTagsMethod fetchStickerTagsMethod, FetchTaggedStickersMethod fetchTaggedStickersMethod, StickerSearchMethod stickerSearchMethod) {
        this.f3859a = stickerCache;
        this.f3860b = stickerDbStorageImpl;
        this.f3861c = apiMethodRunnerImpl;
        this.f3862d = fetchStickerTagsMethod;
        this.f3863e = fetchTaggedStickersMethod;
        this.f3864f = stickerSearchMethod;
    }
}
