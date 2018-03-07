package com.facebook.facecast.plugin;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.facecast.FacecastStateManager;
import com.facebook.facecast.plugin.FacecastStartingAggregatePlugin.C15901;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

@TargetApi(18)
/* compiled from: borderRightColor */
public class FacecastGoLiveButtonPlugin extends FacecastBasePlugin {
    @Inject
    public Toaster f18422c;
    public final BetterTextView f18423d;
    public final ObjectAnimator f18424e;
    public boolean f18425f;

    /* compiled from: borderRightColor */
    public class C15771 implements OnClickListener {
        final /* synthetic */ C15901 f18420a;
        final /* synthetic */ FacecastGoLiveButtonPlugin f18421b;

        public C15771(FacecastGoLiveButtonPlugin facecastGoLiveButtonPlugin, C15901 c15901) {
            this.f18421b = facecastGoLiveButtonPlugin;
            this.f18420a = c15901;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -524730359);
            if (this.f18421b.f18425f) {
                FacecastStartingAggregatePlugin.m22135l(this.f18420a.f18509a);
            } else {
                this.f18421b.f18422c.a(new ToastBuilder(2131238257));
            }
            LogUtils.a(-2116045378, a);
        }
    }

    public static void m22081a(Object obj, Context context) {
        ((FacecastGoLiveButtonPlugin) obj).f18422c = Toaster.b(FbInjector.get(context));
    }

    public FacecastGoLiveButtonPlugin(Context context) {
        this(context, null);
    }

    private FacecastGoLiveButtonPlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastGoLiveButtonPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = FacecastGoLiveButtonPlugin.class;
        m22081a((Object) this, getContext());
        setContentView(2130904219);
        this.f18423d = (BetterTextView) a(2131561638);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimension(2131432271));
        gradientDrawable.setColor(-1);
        this.f18423d.setBackground(gradientDrawable);
        gradientDrawable.setAlpha(38);
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[1];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofInt("alpha", new int[]{51});
        this.f18424e = ObjectAnimator.ofPropertyValuesHolder(gradientDrawable, propertyValuesHolderArr);
        this.f18424e.setDuration(600);
        this.f18424e.setRepeatCount(-1);
        this.f18424e.setRepeatMode(2);
    }

    protected final void hE_() {
        super.hE_();
        this.f18424e.start();
    }

    protected final void mo1408a(ViewGroup viewGroup, FacecastStateManager facecastStateManager) {
        super.mo1408a(viewGroup, facecastStateManager);
        this.f18424e.end();
    }
}
