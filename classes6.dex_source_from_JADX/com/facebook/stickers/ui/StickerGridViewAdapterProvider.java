package com.facebook.stickers.ui;

import android.content.Context;
import com.facebook.common.gridlayoututils.GridSizingCalculator.Sizes;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: durationMinutes */
public class StickerGridViewAdapterProvider extends AbstractAssistedProvider<StickerGridViewAdapter> {
    public final StickerGridViewAdapter m24762a(Context context, String str, Sizes sizes) {
        return new StickerGridViewAdapter(StickerUrls.m24769b((InjectorLike) this), FbDraweeControllerBuilder.b(this), IdBasedProvider.a(this, 4331), context, str, sizes);
    }
}
