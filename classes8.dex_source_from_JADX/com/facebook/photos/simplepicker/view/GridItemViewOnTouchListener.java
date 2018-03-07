package com.facebook.photos.simplepicker.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.simplepicker.controller.PickerSelectionController;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import javax.inject.Inject;

/* compiled from: setSessionId */
public class GridItemViewOnTouchListener implements OnTouchListener {
    private static final SpringConfig f3230a = SpringConfig.a(65.0d, 8.0d);
    private final PickerSelectionController f3231b;
    public final PickerLongPressProgressBar f3232c;
    private final Spring f3233d;
    public final SelectableView f3234e;

    /* compiled from: setSessionId */
    class ScaleSpringListener extends SimpleSpringListener {
        final /* synthetic */ GridItemViewOnTouchListener f3229a;

        public ScaleSpringListener(GridItemViewOnTouchListener gridItemViewOnTouchListener) {
            this.f3229a = gridItemViewOnTouchListener;
        }

        public final void m3195a(Spring spring) {
            float d = (float) spring.d();
            ((View) this.f3229a.f3234e).setScaleX(d);
            ((View) this.f3229a.f3234e).setScaleY(d);
        }

        public final void m3196b(Spring spring) {
            if (spring.d() == 0.98d) {
                this.f3229a.f3232c.m3263a(this.f3229a.f3234e.getMediaItem());
            }
        }
    }

    @Inject
    public GridItemViewOnTouchListener(@Assisted PickerSelectionController pickerSelectionController, @Assisted PickerLongPressProgressBar pickerLongPressProgressBar, @Assisted SelectableView selectableView, Lazy<SpringSystem> lazy) {
        this.f3231b = pickerSelectionController;
        this.f3232c = pickerLongPressProgressBar;
        this.f3234e = selectableView;
        Spring a = ((SpringSystem) lazy.get()).a().a(f3230a).a(1.0d);
        a.c = true;
        this.f3233d = a.l();
        this.f3233d.a(new ScaleSpringListener(this));
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f3234e.mo156f()) {
            return false;
        }
        MediaItem mediaItem = this.f3234e.getMediaItem();
        switch (motionEvent.getAction()) {
            case 0:
                this.f3233d.b(0.98d);
                break;
            case 1:
                if (!this.f3232c.m3262a()) {
                    this.f3231b.m3134b(this.f3234e);
                    break;
                }
                break;
            case 3:
            case 4:
                break;
        }
        this.f3233d.b(1.0d);
        this.f3232c.m3264b(mediaItem);
        return true;
    }
}
