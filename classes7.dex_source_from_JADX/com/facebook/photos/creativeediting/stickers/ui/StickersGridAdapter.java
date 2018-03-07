package com.facebook.photos.creativeediting.stickers.ui;

import android.content.Context;
import com.facebook.common.gridlayoututils.GridSizingCalculator.Sizes;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.Assisted;
import com.facebook.stickers.client.StickersLoader;
import com.facebook.stickers.client.StickersLoader.Params;
import com.facebook.stickers.client.StickersLoader.Results;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.ui.StickerGridViewAdapter;
import com.facebook.stickers.ui.StickerUrls;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mLocalMediaData */
public class StickersGridAdapter extends StickerGridViewAdapter {
    public final StickersLoader f9709a;
    public StickerPack f9710b;

    /* compiled from: mLocalMediaData */
    public class C07981 implements Callback<Params, Results, Throwable> {
        final /* synthetic */ StickersGridAdapter f9708a;

        public C07981(StickersGridAdapter stickersGridAdapter) {
            this.f9708a = stickersGridAdapter;
        }

        public final void m11644b(Object obj, Object obj2) {
            this.f9708a.a(ImmutableList.copyOf(((Results) obj2).a));
        }

        public final /* bridge */ /* synthetic */ void m11645c(Object obj, Object obj2) {
        }
    }

    @Inject
    public StickersGridAdapter(StickersLoader stickersLoader, StickerUrls stickerUrls, FbDraweeControllerBuilder fbDraweeControllerBuilder, Provider<Boolean> provider, @Assisted Context context, @Assisted String str, @Assisted Sizes sizes) {
        super(stickerUrls, fbDraweeControllerBuilder, provider, context, str, sizes);
        this.f9709a = stickersLoader;
    }

    public final void m11646a(StickerPack stickerPack) {
        this.f9710b = stickerPack;
        this.f9709a.a();
        this.f9709a.a(new C07981(this));
        this.f9709a.a(new Params(this.f9710b.t));
        AdapterDetour.a(this, 8143718);
    }
}
