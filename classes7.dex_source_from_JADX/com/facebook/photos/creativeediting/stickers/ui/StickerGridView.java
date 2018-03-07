package com.facebook.photos.creativeediting.stickers.ui;

import android.content.Context;
import android.widget.GridView;
import com.facebook.common.gridlayoututils.GridSizingCalculator;
import com.facebook.common.gridlayoututils.GridSizingCalculator.Sizes;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.photos.creativeediting.stickers.events.StickerEventBus;
import com.facebook.photos.creativeediting.stickers.events.StickerEvents.StickerSelectedEvent;
import com.facebook.stickers.client.StickersLoader;
import com.facebook.stickers.gridlayout.StickersInFb4aComposerGridSizingParams;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.ui.StickerGridController;
import com.facebook.stickers.ui.StickerGridController.Listener;
import com.facebook.stickers.ui.StickerGridControllerProvider;
import com.facebook.stickers.ui.StickerUrls;
import com.google.common.collect.RegularImmutableList;

/* compiled from: mMediaData */
public class StickerGridView extends GridView {
    public static final StickerInterface f9700a = StickerInterface.COMPOSER;
    private StickersGridAdapter f9701b;
    public StickersGridAdapterProvider f9702c;
    public StickerGridControllerProvider f9703d;
    public StickerGridController f9704e = this.f9703d.a(this, f9700a);
    private Sizes f9705f;
    public StickerPack f9706g;
    public Lazy<StickerEventBus> f9707h;

    /* compiled from: mMediaData */
    class C07971 implements Listener {
        final /* synthetic */ StickerGridView f9699a;

        C07971(StickerGridView stickerGridView) {
            this.f9699a = stickerGridView;
        }

        public final void m11639a(Sticker sticker) {
            if (sticker != null) {
                ((StickerEventBus) this.f9699a.f9707h.get()).a(new StickerSelectedEvent(sticker, this.f9699a.getResources().getDimensionPixelSize(2131431917), this.f9699a.getResources().getDimensionPixelSize(2131431917)));
            }
        }
    }

    public static void m11640a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        StickerGridView stickerGridView = (StickerGridView) obj;
        StickerGridControllerProvider stickerGridControllerProvider = (StickerGridControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(StickerGridControllerProvider.class);
        StickersGridAdapterProvider stickersGridAdapterProvider = (StickersGridAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(StickersGridAdapterProvider.class);
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 9280);
        stickerGridView.f9703d = stickerGridControllerProvider;
        stickerGridView.f9702c = stickersGridAdapterProvider;
        stickerGridView.f9707h = b;
    }

    public StickerGridView(Context context) {
        super(context);
        Class cls = StickerGridView.class;
        m11640a(this, getContext());
        setStretchMode(3);
        setNumColumns(-1);
        setColumnWidth(((int) getResources().getDisplayMetrics().density) * getResources().getDimensionPixelSize(2131431918));
        setClickable(true);
        setGravity(17);
        setPadding(0, 0, 0, 0);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f9705f == null) {
            m11641b();
        }
    }

    private void m11641b() {
        this.f9705f = new GridSizingCalculator(getContext().getResources(), new StickersInFb4aComposerGridSizingParams()).a(getWidth(), getHeight(), false);
        StickersGridAdapterProvider stickersGridAdapterProvider = this.f9702c;
        this.f9701b = new StickersGridAdapter(StickersLoader.b(stickersGridAdapterProvider), StickerUrls.b(stickersGridAdapterProvider), FbDraweeControllerBuilder.b(stickersGridAdapterProvider), IdBasedProvider.a(stickersGridAdapterProvider, 4331), getContext(), "", this.f9705f);
        this.f9701b.a(RegularImmutableList.a);
        setNumColumns(this.f9705f.a);
        this.f9704e.e = new C07971(this);
        this.f9701b.m11646a(this.f9706g);
        setAdapter(this.f9701b);
    }
}
