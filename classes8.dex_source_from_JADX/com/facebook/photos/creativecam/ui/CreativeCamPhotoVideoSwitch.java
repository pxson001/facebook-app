package com.facebook.photos.creativecam.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: state_can_edit_name */
public class CreativeCamPhotoVideoSwitch extends CustomFrameLayout {
    private View f2200a;
    private int f2201b;
    private int f2202c;
    private GlyphView f2203d;
    private GlyphView f2204e;
    private final int f2205f;
    private final int f2206g;
    public OnToggleListener f2207h;

    /* compiled from: state_can_edit_name */
    class C02591 implements OnClickListener {
        final /* synthetic */ CreativeCamPhotoVideoSwitch f2198a;

        C02591(CreativeCamPhotoVideoSwitch creativeCamPhotoVideoSwitch) {
            this.f2198a = creativeCamPhotoVideoSwitch;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2126118702);
            CreativeCamPhotoVideoSwitch.m2376f(this.f2198a);
            Logger.a(2, EntryType.UI_INPUT_END, 658280281, a);
        }
    }

    /* compiled from: state_can_edit_name */
    class C02602 implements AnimationListener {
        final /* synthetic */ CreativeCamPhotoVideoSwitch f2199a;

        C02602(CreativeCamPhotoVideoSwitch creativeCamPhotoVideoSwitch) {
            this.f2199a = creativeCamPhotoVideoSwitch;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            CreativeCamPhotoVideoSwitch.m2375e(this.f2199a);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: state_can_edit_name */
    public interface OnToggleListener {
        void m2370a(int i);
    }

    public CreativeCamPhotoVideoSwitch(Context context) {
        this(context, null);
    }

    public CreativeCamPhotoVideoSwitch(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CreativeCamPhotoVideoSwitch(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2202c = 0;
        this.f2205f = getContext().getResources().getColor(2131361920);
        this.f2206g = getContext().getResources().getColor(2131361936);
        View.inflate(context, 2130903491, this);
        this.f2201b = (int) (context.getResources().getDimension(2131429532) - context.getResources().getDimension(2131429533));
    }

    public void setToggleListener(OnToggleListener onToggleListener) {
        this.f2207h = onToggleListener;
    }

    public void setSelectedPosition(int i) {
        this.f2202c = i;
        m2371a();
        m2375e(this);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1770878595);
        super.onFinishInflate();
        this.f2200a = findViewById(2131560182);
        this.f2203d = (GlyphView) findViewById(2131560183);
        this.f2204e = (GlyphView) findViewById(2131560184);
        m2371a();
        setOnClickListener(new C02591(this));
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1637992650, a);
    }

    private void m2371a() {
        int i = this.f2202c == 0 ? this.f2205f : this.f2206g;
        int i2 = this.f2202c == 0 ? this.f2206g : this.f2205f;
        this.f2203d.setGlyphColor(i);
        this.f2204e.setGlyphColor(i2);
    }

    private void m2373b() {
        float f = (float) ((LayoutParams) this.f2200a.getLayoutParams()).topMargin;
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.f2202c == 0 ? -f : ((float) this.f2201b) - f);
        translateAnimation.setDuration(300);
        translateAnimation.setAnimationListener(new C02602(this));
        this.f2200a.startAnimation(translateAnimation);
    }

    public static void m2375e(CreativeCamPhotoVideoSwitch creativeCamPhotoVideoSwitch) {
        LayoutParams layoutParams = (LayoutParams) creativeCamPhotoVideoSwitch.f2200a.getLayoutParams();
        layoutParams.topMargin = creativeCamPhotoVideoSwitch.f2202c == 0 ? 0 : creativeCamPhotoVideoSwitch.f2201b;
        creativeCamPhotoVideoSwitch.f2200a.setLayoutParams(layoutParams);
    }

    public static void m2376f(CreativeCamPhotoVideoSwitch creativeCamPhotoVideoSwitch) {
        if (creativeCamPhotoVideoSwitch.f2202c == 0) {
            creativeCamPhotoVideoSwitch.f2202c = 1;
        } else {
            creativeCamPhotoVideoSwitch.f2202c = 0;
        }
        creativeCamPhotoVideoSwitch.m2371a();
        if (creativeCamPhotoVideoSwitch.f2207h != null) {
            creativeCamPhotoVideoSwitch.f2207h.m2370a(creativeCamPhotoVideoSwitch.f2202c);
        }
        creativeCamPhotoVideoSwitch.m2373b();
    }
}
