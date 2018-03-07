package com.facebook.photos.creativeediting.stickers.ui;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.photos.creativeediting.stickers.events.StickerEventBus;
import com.facebook.photos.creativeediting.stickers.events.StickerEvents.StickerSelectedEvent;
import com.facebook.photos.creativeediting.stickers.stickers.StickersTrayAdapter;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.search.StickerSearchContainer;
import com.facebook.stickers.search.StickerSearchContainer.StickerSearchListener;
import javax.inject.Inject;

/* compiled from: mList */
public class StickersViewPagerAdapter extends PagerAdapter {
    private final StickersTrayAdapter f9713a;
    public Lazy<StickerEventBus> f9714b;
    public StickerSearchContainer f9715c;
    public StickerInterface f9716d;

    @Inject
    public StickersViewPagerAdapter(@Assisted StickersTrayAdapter stickersTrayAdapter, @Assisted StickerInterface stickerInterface, Lazy<StickerEventBus> lazy) {
        this.f9713a = stickersTrayAdapter;
        this.f9716d = stickerInterface;
        this.f9714b = lazy;
    }

    public final int m11654b() {
        return this.f9713a.getCount();
    }

    public final boolean m11653a(View view, Object obj) {
        return view == obj;
    }

    public final Object m11651a(ViewGroup viewGroup, int i) {
        View view;
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        Object item = this.f9713a.getItem(i);
        if (item == StickersTrayAdapter.f9646a) {
            final Context context = viewGroup.getContext();
            if (this.f9715c == null) {
                this.f9715c = new StickerSearchContainer(ContextUtils.a(context, 2131625383, 2131625383), this.f9716d);
                this.f9715c.setStickerSearchListener(new StickerSearchListener(this) {
                    final /* synthetic */ StickersViewPagerAdapter f9712b;

                    public final void m11648a(Sticker sticker) {
                        ((StickerEventBus) this.f9712b.f9714b.get()).a(new StickerSelectedEvent(sticker, context.getResources().getDimensionPixelSize(2131431917), context.getResources().getDimensionPixelSize(2131431917)));
                    }

                    public final void m11649a(String str) {
                    }

                    public final void m11647a() {
                    }

                    public final void m11650b() {
                    }
                });
            }
            view = this.f9715c;
        } else {
            StickerPack stickerPack = (StickerPack) item;
            View stickerGridView = new StickerGridView(viewGroup.getContext());
            stickerGridView.f9704e = stickerGridView.f9703d.a(stickerGridView, this.f9716d);
            stickerGridView.f9706g = stickerPack;
            stickerGridView.setClipToPadding(false);
            view = stickerGridView;
        }
        viewGroup.addView(view, layoutParams);
        return view;
    }

    public final void m11652a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
