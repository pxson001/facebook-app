package com.facebook.stickers.ui;

import android.widget.GridView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.stickers.model.StickerInterface;

/* compiled from: duration_millis */
public class StickerGridControllerProvider extends AbstractAssistedProvider<StickerGridController> {
    public final StickerGridController m24758a(GridView gridView, StickerInterface stickerInterface) {
        return new StickerGridController(Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(974, false)), StickerUiModule.m24766a(ResourcesMethodAutoProvider.a(this), FbDraweeControllerBuilder.b(this)), ClickEventDebouncer.m24734a(this), gridView, stickerInterface);
    }
}
