package com.facebook.instantshopping.view.widget.slideup;

import android.graphics.Paint.Style;
import android.graphics.Rect;
import com.facebook.common.util.SizeUtil;
import com.facebook.instantshopping.view.widget.InstantShoppingSlideshowView;
import com.facebook.instantshopping.view.widget.InstantShoppingSlideshowView.InstantShoppingSlideChangeListener;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.plugins.BaseMediaFramePlugin;
import com.facebook.widget.viewpageindicator.HScrollCirclePageIndicator;

/* compiled from: SENT_WITH_HIDDEN_SEND_RECEIPT */
public class SlideshowIndicatorPlugin extends BaseMediaFramePlugin<Void> {
    public final HScrollCirclePageIndicator f23959a;
    private final InstantShoppingSlideChangeListener f23960b = new C34341(this);
    private MediaFrame f23961c;

    /* compiled from: SENT_WITH_HIDDEN_SEND_RECEIPT */
    class C34341 implements InstantShoppingSlideChangeListener {
        final /* synthetic */ SlideshowIndicatorPlugin f23958a;

        C34341(SlideshowIndicatorPlugin slideshowIndicatorPlugin) {
            this.f23958a = slideshowIndicatorPlugin;
        }

        public final void mo1036a(int i) {
            this.f23958a.f23959a.setCurrentItem(i);
        }
    }

    public SlideshowIndicatorPlugin(MediaFrame mediaFrame) {
        super(mediaFrame);
        this.f23961c = mediaFrame;
        this.f23959a = (HScrollCirclePageIndicator) this.f23961c.b().findViewById(2131563265);
        this.f23959a.r = 3.33f;
        ((InstantShoppingSlideshowView) this.f23961c.getMediaView().getView()).f23924v = this.f23960b;
        this.f23959a.setStrokeColor(this.f23961c.getMediaView().getView().getContext().getResources().getColor(2131363676));
        this.f23959a.setStrokeStyle(Style.STROKE);
        this.f23959a.setStrokeWidth(2.0f);
    }

    public final void m25230c() {
        this.f23959a.a();
    }

    public final void m25229a(ViewLayout viewLayout) {
        Rect rect = BaseMediaFramePlugin.a(viewLayout, i()).a;
        int width = (rect.width() - this.f23959a.getMeasuredWidth()) / 2;
        int height = rect.height() - (SizeUtil.a(this.f23961c.getMediaView().getView().getContext(), 16.0f) + this.f23959a.getMeasuredHeight());
        this.f23961c.a(this.f23959a, new Rect(width, height, this.f23959a.getMeasuredWidth() + width, this.f23959a.getMeasuredHeight() + height));
    }
}
