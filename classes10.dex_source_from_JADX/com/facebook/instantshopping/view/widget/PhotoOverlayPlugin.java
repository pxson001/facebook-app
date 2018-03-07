package com.facebook.instantshopping.view.widget;

import android.graphics.Rect;
import android.widget.ImageView;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.plugins.BaseMediaFramePlugin;

/* compiled from: SET_UP_SHOP */
public class PhotoOverlayPlugin extends BaseMediaFramePlugin<Void> {
    public final ImageView f23932a = ((ImageView) this.f23933b.b().findViewById(2131563255));
    private MediaFrame f23933b;

    public PhotoOverlayPlugin(MediaFrame mediaFrame) {
        super(mediaFrame);
        this.f23933b = mediaFrame;
    }

    public final void m25204a(ViewLayout viewLayout) {
        if (this.f23932a != null) {
            Rect rect = BaseMediaFramePlugin.a(viewLayout, this.f23933b.getMediaView().getView()).a;
            this.f23933b.a(this.f23932a, new Rect(rect.left, rect.top, rect.left + this.f23932a.getMeasuredWidth(), rect.top + this.f23932a.getMeasuredHeight()));
        }
    }
}
