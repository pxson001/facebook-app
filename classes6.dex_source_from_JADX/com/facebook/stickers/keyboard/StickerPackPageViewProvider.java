package com.facebook.stickers.keyboard;

import android.content.Context;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.gridlayoututils.GridSizingCalculator.Sizes;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.client.StickerDownloadManager;
import com.facebook.stickers.client.StickersLoader;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.ui.StickerGridControllerProvider;
import com.facebook.stickers.ui.StickerGridViewAdapterProvider;

/* compiled from: edit_privacy_fragment_invalid_option_selected */
public class StickerPackPageViewProvider extends AbstractAssistedProvider<StickerPackPageView> {
    public final StickerPackPageView m24522a(StickerInterface stickerInterface, Sizes sizes) {
        return new StickerPackPageView((Context) getInstance(Context.class), StickerDownloadManager.m23933a((InjectorLike) this), StickersLoader.m23949b(this), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(this), (StickerGridControllerProvider) getOnDemandAssistedProviderForStaticDi(StickerGridControllerProvider.class), (StickerGridViewAdapterProvider) getOnDemandAssistedProviderForStaticDi(StickerGridViewAdapterProvider.class), stickerInterface, sizes);
    }
}
