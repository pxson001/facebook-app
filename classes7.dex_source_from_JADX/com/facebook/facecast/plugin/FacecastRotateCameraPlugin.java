package com.facebook.facecast.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.sounds.FBSoundUtil;
import javax.inject.Inject;

/* compiled from: c1fef5fb1ffaf5bd593ec0326ae47d41 */
public class FacecastRotateCameraPlugin extends FacecastBasePlugin {
    @Inject
    public Lazy<FBSoundUtil> f18507c;
    public GlyphView f18508d;

    /* compiled from: c1fef5fb1ffaf5bd593ec0326ae47d41 */
    public interface RotateCameraClickListener {
        void mo1393p();
    }

    /* compiled from: c1fef5fb1ffaf5bd593ec0326ae47d41 */
    public enum Corner {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT
    }

    public static void m22132a(Object obj, Context context) {
        ((FacecastRotateCameraPlugin) obj).f18507c = IdBasedSingletonScopeProvider.b(FbInjector.get(context), 10994);
    }

    public FacecastRotateCameraPlugin(Context context) {
        this(context, null);
    }

    private FacecastRotateCameraPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastRotateCameraPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = FacecastRotateCameraPlugin.class;
        m22132a(this, getContext());
        setContentView(2130904228);
        this.f18508d = (GlyphView) a(2131561637);
    }

    public void setOnClickListener(final RotateCameraClickListener rotateCameraClickListener) {
        this.f18508d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FacecastRotateCameraPlugin f18505b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 503509789);
                view.setEnabled(false);
                rotateCameraClickListener.mo1393p();
                ((FBSoundUtil) this.f18505b.f18507c.get()).a(2131165193, 2, 0.15f);
                Logger.a(2, EntryType.UI_INPUT_END, 1503197560, a);
            }
        });
    }

    public void setCorner(Corner corner) {
        LayoutParams layoutParams = (LayoutParams) this.f18508d.getLayoutParams();
        layoutParams.removeRule(3);
        layoutParams.removeRule(12);
        layoutParams.removeRule(9);
        layoutParams.removeRule(20);
        layoutParams.removeRule(11);
        layoutParams.removeRule(21);
        switch (corner) {
            case TOP_LEFT:
                layoutParams.addRule(3, 2131561596);
                layoutParams.addRule(9);
                layoutParams.addRule(20);
                break;
            case TOP_RIGHT:
                layoutParams.addRule(3, 2131561596);
                layoutParams.addRule(11);
                layoutParams.addRule(21);
                break;
            case BOTTOM_LEFT:
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                layoutParams.addRule(20);
                break;
            case BOTTOM_RIGHT:
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                layoutParams.addRule(21);
                break;
        }
        this.f18508d.setLayoutParams(layoutParams);
    }

    public final void m22133g() {
        this.f18508d.setEnabled(true);
    }
}
