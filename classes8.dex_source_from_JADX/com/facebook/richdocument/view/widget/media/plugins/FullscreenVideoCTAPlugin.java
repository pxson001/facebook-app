package com.facebook.richdocument.view.widget.media.plugins;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.common.util.SizeUtil;
import com.facebook.richdocument.view.touch.RichDocumentTouch;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.widget.RichTextView;
import com.facebook.richdocument.view.widget.media.MediaFrame;

/* compiled from: num_nearby_places */
public class FullscreenVideoCTAPlugin extends BaseMediaFramePlugin<Void> {
    public final RichTextView f7630a = ((RichTextView) this.f7631b.mo480b().findViewById(2131563005));
    private MediaFrame f7631b;
    private Point f7632c;
    public boolean f7633d;

    public FullscreenVideoCTAPlugin(MediaFrame mediaFrame) {
        super(mediaFrame);
        this.f7631b = mediaFrame;
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(2131431873);
        RichDocumentTouch.m7189a(this.f7630a, Integer.valueOf(getContext().getResources().getDimensionPixelSize(2131431874)), Integer.valueOf(dimensionPixelSize), Integer.valueOf(4));
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        this.f7632c = new Point();
        defaultDisplay.getSize(this.f7632c);
    }

    public final void mo504a(ViewLayout viewLayout) {
        if (this.f7630a != null) {
            int a = SizeUtil.a(getContext(), 10.0f);
            int measuredWidth = (this.f7632c.x - this.f7630a.getMeasuredWidth()) - SizeUtil.a(getContext(), 10.0f);
            if (this.f7633d) {
                a = SizeUtil.a(getContext(), 20.0f);
                measuredWidth = (this.f7632c.y - this.f7630a.getMeasuredWidth()) - SizeUtil.a(getContext(), 40.0f);
            }
            this.f7631b.m7802a(this.f7630a, new Rect(measuredWidth, a, this.f7630a.getMeasuredWidth() + measuredWidth, this.f7630a.getMeasuredHeight() + a));
        }
    }
}
