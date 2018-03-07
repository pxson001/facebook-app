package com.facebook.photos.photogallery;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.DisableableView;
import com.facebook.widget.images.zoomableimageview.ImageViewTouch;

/* compiled from: irrelevant */
public class ZoomableViewPager extends ViewPager implements DisableableView {
    private boolean f10864a;

    public ZoomableViewPager(Context context) {
        this(context, null);
    }

    public ZoomableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10864a = true;
    }

    protected final boolean m12896a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ImageViewTouch) {
            return ((ImageViewTouch) view).a(i);
        }
        return super.a(view, z, i, i2, i3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1229441291);
        if (this.f10864a) {
            try {
                boolean onTouchEvent = super.onTouchEvent(motionEvent);
                Logger.a(2, EntryType.UI_INPUT_END, -1612420446, a);
                return onTouchEvent;
            } catch (Throwable e) {
                ((AbstractFbErrorReporter) FbErrorReporterImpl.a(FbInjector.get(getContext()))).a("ZoomableViewPager", "Error during touch event: " + motionEvent, e);
                LogUtils.a(-2094365782, a);
                return true;
            }
        }
        LogUtils.a(982423377, a);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f10864a) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public final void m12897g() {
        this.f10864a = true;
    }

    public final void m12898h() {
        this.f10864a = false;
    }
}
