package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.facebook.photos.mediagallery.ui.MediaGalleryFragment.6;
import com.facebook.photos.mediagallery.ui.MediaGalleryVideoPageFragment.3;
import com.facebook.resources.ui.FbTextView;
import com.facebook.video.engine.VideoResolution;
import com.facebook.video.player.RichVideoPlayerParams;

/* compiled from: composer_add_location_ready */
public class InvisibleSeekBarPlugin extends SeekBarBasePlugin {
    private final FbTextView f19351l;
    private final FbTextView f19352m;
    private final SeekBar f19353n;
    private 3 f19354o;

    public InvisibleSeekBarPlugin(Context context) {
        this(context, null);
    }

    private InvisibleSeekBarPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private InvisibleSeekBarPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19351l = (FbTextView) a(2131562400);
        this.f19352m = (FbTextView) a(2131562402);
        this.f19353n = (SeekBar) a(2131562401);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setVisibility(8);
        }
    }

    protected final void mo1488a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (richVideoPlayerParams.b.containsKey("InvisibleSeekBarListenerKey")) {
            this.f19354o = (3) richVideoPlayerParams.b.get("InvisibleSeekBarListenerKey");
            mo1493d();
        }
    }

    protected final void mo1489c() {
        this.f19354o = null;
    }

    public final void mo1493d() {
        if (this.h != null) {
            super.mo1493d();
            if (this.f19354o != null) {
                3 3 = this.f19354o;
                int progress = this.f19353n.getProgress();
                int max = this.f19353n.getMax();
                CharSequence text = this.f19351l.getText();
                CharSequence text2 = this.f19352m.getText();
                if (3.a.c.a != null) {
                    3.a.c.a.a(3.a.f, progress, max, text, text2);
                }
            }
        }
    }

    protected final void mo1487a(VideoResolution videoResolution) {
        super.mo1487a(videoResolution);
        if (this.f19354o != null) {
            3 3 = this.f19354o;
            if (3.a.c.a != null) {
                6 6 = 3.a.c.a;
                String str = 3.a.f;
                6.a(3.a.h, videoResolution);
            }
        }
    }

    protected int getContentView() {
        return 2130907051;
    }

    protected int getActiveThumbResource() {
        return 0;
    }
}
