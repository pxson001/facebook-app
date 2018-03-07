package com.facebook.messaging.photos.editing;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.messaging.photos.editing.StickerLayer.Event;
import com.facebook.springs.SpringSystem;

/* compiled from: did_click_trending_item */
public class StickerLayerPresenter extends LayerPresenter {
    private final CallerContext f16228a;
    private final StickerLayer f16229b;
    private final FbDraweeView f16230c;

    public StickerLayerPresenter(StickerLayer stickerLayer, FbDraweeView fbDraweeView, CallerContext callerContext, SpringSystem springSystem) {
        super(stickerLayer, fbDraweeView, springSystem);
        this.f16229b = stickerLayer;
        this.f16230c = fbDraweeView;
        this.f16228a = callerContext;
    }

    public final void mo675c() {
        super.mo675c();
        m16320s();
    }

    protected final void mo674a(Object obj) {
        super.mo674a(obj);
        if (obj instanceof Event) {
            switch ((Event) obj) {
                case STICKER_CHANGE:
                    m16320s();
                    return;
                default:
                    return;
            }
        }
    }

    private void m16320s() {
        this.f16229b.m16179a(false);
        this.f16230c.a(this.f16229b.f16226a.c, this.f16228a);
        this.f16230c.invalidate();
    }
}
