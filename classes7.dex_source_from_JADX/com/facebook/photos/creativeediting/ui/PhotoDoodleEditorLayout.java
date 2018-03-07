package com.facebook.photos.creativeediting.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawingview.DrawingView;
import com.facebook.drawingview.DrawingView.DrawingListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.doodle.ColourIndicator;
import com.facebook.messaging.doodle.ColourPicker;
import com.facebook.messaging.doodle.ColourPicker.OnColourPickerInteractionListener;
import com.facebook.photos.creativeediting.analytics.DoodleOnPhotosLoggingParams;
import com.facebook.photos.editgallery.DoodlesEditController.C08623;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: live_video_comment_create_subscribe */
public class PhotoDoodleEditorLayout extends CustomFrameLayout {
    public DrawingView f10014a;
    public ColourIndicator f10015b;
    public ColourPicker f10016c;
    private ValueAnimator f10017d;
    public boolean f10018e;
    public boolean f10019f;
    public C08623 f10020g;
    public int f10021h;

    /* compiled from: live_video_comment_create_subscribe */
    public class C08421 implements DrawingListener {
        final /* synthetic */ PhotoDoodleEditorLayout f10009a;

        public C08421(PhotoDoodleEditorLayout photoDoodleEditorLayout) {
            this.f10009a = photoDoodleEditorLayout;
        }

        public final void m11949a() {
            this.f10009a.f10018e = true;
            C08623 c08623 = this.f10009a.f10020g;
            DoodleOnPhotosLoggingParams doodleOnPhotosLoggingParams = c08623.f10222a.f10237o;
            doodleOnPhotosLoggingParams.f9564c++;
            if (c08623.f10222a.f10232j.f10019f) {
                c08623.f10222a.f10237o.f9562a = true;
            }
            if (c08623.f10222a.f10232j.m11956f()) {
                c08623.f10222a.f10235m.setVisibility(0);
                c08623.f10222a.f10234l.setVisibility(0);
            }
            PhotoDoodleEditorLayout.m11953a(this.f10009a, 1, this.f10009a.f10016c);
        }

        public final void m11950b() {
            PhotoDoodleEditorLayout.m11953a(this.f10009a, 0, this.f10009a.f10016c);
        }
    }

    /* compiled from: live_video_comment_create_subscribe */
    public class C08432 implements OnClickListener {
        final /* synthetic */ PhotoDoodleEditorLayout f10010a;

        public C08432(PhotoDoodleEditorLayout photoDoodleEditorLayout) {
            this.f10010a = photoDoodleEditorLayout;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, 1161361357, Logger.a(2, EntryType.UI_INPUT_START, -1322356686));
        }
    }

    /* compiled from: live_video_comment_create_subscribe */
    public class C08443 implements OnColourPickerInteractionListener {
        final /* synthetic */ PhotoDoodleEditorLayout f10011a;

        public C08443(PhotoDoodleEditorLayout photoDoodleEditorLayout) {
            this.f10011a = photoDoodleEditorLayout;
        }

        public final void mo545a(int i, float f, float f2, float f3) {
            this.f10011a.f10015b.m9447a(i, f - ((float) this.f10011a.f10021h), f2, f3);
            this.f10011a.f10014a.setStrokeWidth(f3);
            this.f10011a.f10014a.setColour(i);
        }

        public final void mo544a(int i) {
            this.f10011a.f10015b.setColour(i);
            this.f10011a.f10015b.m9446a();
            this.f10011a.f10014a.setColour(i);
            this.f10011a.f10019f = true;
        }
    }

    public PhotoDoodleEditorLayout(Context context) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(2130906190, this);
        this.f10014a = (DrawingView) FindViewUtil.b(inflate, 2131560061);
        this.f10014a = (DrawingView) c(2131560061);
        this.f10014a.d = new C08421(this);
        this.f10015b = (ColourIndicator) FindViewUtil.b(inflate, 2131565886);
        this.f10016c = (ColourPicker) FindViewUtil.b(inflate, 2131565887);
        this.f10016c.f7828c = new C08443(this);
        setOnClickListener(new C08432(this));
        this.f10021h = getResources().getDimensionPixelSize(2131429552);
    }

    public static void m11953a(PhotoDoodleEditorLayout photoDoodleEditorLayout, int i, final View view) {
        float f = i == 0 ? 1.0f : 0.0f;
        if (photoDoodleEditorLayout.f10017d != null) {
            photoDoodleEditorLayout.f10017d.cancel();
        }
        photoDoodleEditorLayout.f10017d = ValueAnimator.ofFloat(new float[]{view.getAlpha(), f});
        photoDoodleEditorLayout.f10017d.addUpdateListener(new AnimatorUpdateListener(photoDoodleEditorLayout) {
            final /* synthetic */ PhotoDoodleEditorLayout f10013b;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        if (i == 1) {
            photoDoodleEditorLayout.f10017d.setStartDelay(200);
        }
        view.setEnabled(i == 0);
        photoDoodleEditorLayout.f10017d.start();
    }

    public final void m11955a() {
        this.f10018e = false;
    }

    public final boolean m11956f() {
        return this.f10014a.getHistorySize() != 0;
    }

    public final void m11957i() {
        setVisibility(8);
        setEnabled(false);
    }

    public final Bitmap m11954a(int i) {
        return this.f10014a.a(i);
    }
}
