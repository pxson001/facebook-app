package com.facebook.photos.mediagallery.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.mediagallery.ui.MediaGalleryVideoPageFragment;
import com.facebook.photos.mediagallery.ui.MediaGalleryVideoPageFragment.C02891;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.VideoResolution;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: simplepicker_num_new_photos */
public class MediaGallerySeekBar extends CustomLinearLayout {
    @Inject
    public MediaGalleryVideoChromeController f2812a;
    private final SeekBar f2813b;
    private final FbTextView f2814c;
    private final FbTextView f2815d;
    private final FbTextView f2816e;
    private final int f2817f;
    private final int f2818g;
    public String f2819h;
    public boolean f2820i;
    private int f2821j;
    private int f2822k;

    /* compiled from: simplepicker_num_new_photos */
    class HdToggleListener implements OnClickListener {
        final /* synthetic */ MediaGallerySeekBar f2810a;

        public HdToggleListener(MediaGallerySeekBar mediaGallerySeekBar) {
            this.f2810a = mediaGallerySeekBar;
        }

        public void onClick(View view) {
            boolean z;
            int a = Logger.a(2, EntryType.UI_INPUT_START, 500449380);
            MediaGallerySeekBar mediaGallerySeekBar = this.f2810a;
            if (this.f2810a.f2820i) {
                z = false;
            } else {
                z = true;
            }
            mediaGallerySeekBar.f2820i = z;
            this.f2810a.m2871a(true, this.f2810a.f2820i);
            MediaGalleryVideoChromeController mediaGalleryVideoChromeController = this.f2810a.f2812a;
            String str = this.f2810a.f2819h;
            boolean z2 = this.f2810a.f2820i;
            for (C02891 c02891 : mediaGalleryVideoChromeController.f2834b.keySet()) {
                if (c02891 != null) {
                    if (c02891.f2419a.f2428e != null && MediaGalleryVideoPageFragment.m2551a(c02891.f2419a, str) && c02891.f2419a.f2431h) {
                        c02891.f2419a.f2428e.a(z2 ? VideoResolution.HIGH_DEFINITION : VideoResolution.STANDARD_DEFINITION, EventTriggerType.BY_USER);
                    }
                }
            }
            LogUtils.a(1407280179, a);
        }
    }

    /* compiled from: simplepicker_num_new_photos */
    class SeekBarListener implements OnSeekBarChangeListener {
        final /* synthetic */ MediaGallerySeekBar f2811a;

        public SeekBarListener(MediaGallerySeekBar mediaGallerySeekBar) {
            this.f2811a = mediaGallerySeekBar;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                MediaGalleryVideoChromeController mediaGalleryVideoChromeController = this.f2811a.f2812a;
                String str = this.f2811a.f2819h;
                int max = seekBar.getMax();
                for (C02891 c02891 : mediaGalleryVideoChromeController.f2834b.keySet()) {
                    if (c02891 != null) {
                        if (c02891.f2419a.f2428e != null && MediaGalleryVideoPageFragment.m2551a(c02891.f2419a, str) && MediaGalleryVideoPageFragment.m2552b(c02891.f2419a)) {
                            c02891.f2419a.f2428e.a((c02891.f2419a.f2428e.getVideoDurationMs() * i) / max, EventTriggerType.BY_USER);
                        }
                    }
                }
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    private static <T extends View> void m2866a(Class<T> cls, T t) {
        m2867a((Object) t, t.getContext());
    }

    private static void m2867a(Object obj, Context context) {
        ((MediaGallerySeekBar) obj).f2812a = MediaGalleryVideoChromeController.m2873a(FbInjector.get(context));
    }

    public MediaGallerySeekBar(Context context) {
        this(context, null);
    }

    public MediaGallerySeekBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaGallerySeekBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2866a(MediaGallerySeekBar.class, (View) this);
        setOrientation(0);
        setContentView(2130905179);
        this.f2813b = (SeekBar) a(2131563721);
        this.f2814c = (FbTextView) a(2131563720);
        this.f2815d = (FbTextView) a(2131563722);
        this.f2816e = (FbTextView) a(2131561905);
        this.f2817f = getResources().getColor(2131361867);
        this.f2818g = getResources().getColor(2131362630);
        this.f2813b.setOnSeekBarChangeListener(new SeekBarListener(this));
        this.f2816e.setOnClickListener(new HdToggleListener(this));
    }

    private void m2865a(MediaGalleryVideoChromeController mediaGalleryVideoChromeController) {
        this.f2812a = mediaGalleryVideoChromeController;
    }

    public void setMediaId(String str) {
        this.f2819h = str;
    }

    public final void m2870a(int i, int i2, CharSequence charSequence, CharSequence charSequence2) {
        this.f2814c.setText(charSequence);
        this.f2815d.setText(charSequence2);
        if (this.f2821j != i2) {
            this.f2821j = i2;
            this.f2813b.setMax(i2);
        }
        if (this.f2822k != i) {
            this.f2822k = i;
            this.f2813b.setProgress(i);
        }
    }

    public final void m2871a(boolean z, boolean z2) {
        this.f2816e.setVisibility(z ? 0 : 8);
        this.f2816e.setTextColor(z2 ? this.f2817f : this.f2818g);
    }
}
