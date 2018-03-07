package com.facebook.messaging.montage.composer;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.ContextUtils;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.ViewStubHolder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_promote_product */
public class MontageComposerMediaPickerItemView extends CustomFrameLayout {
    public static final CallerContext f12488b = CallerContext.a(MontageComposerMediaPickerItemView.class);
    @Inject
    public FbDraweeControllerBuilder f12489a;
    public final BaseControllerListener f12490c;
    public final ResizeOptions f12491d;
    public final ViewStubHolder<View> f12492e;
    public final FbDraweeView f12493f;
    public final View f12494g;

    /* compiled from: is_promote_product */
    class C13871 extends BaseControllerListener {
        final /* synthetic */ MontageComposerMediaPickerItemView f12487a;

        C13871(MontageComposerMediaPickerItemView montageComposerMediaPickerItemView) {
            this.f12487a = montageComposerMediaPickerItemView;
        }

        public final void m12950a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }

        public final void m12951b(String str, Throwable th) {
            this.f12487a.f12493f.setVisibility(8);
            this.f12487a.f12494g.setVisibility(8);
            this.f12487a.f12492e.f();
        }
    }

    public static void m12952a(Object obj, Context context) {
        ((MontageComposerMediaPickerItemView) obj).f12489a = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    public MontageComposerMediaPickerItemView(Context context) {
        this(context, null);
    }

    private MontageComposerMediaPickerItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private MontageComposerMediaPickerItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = MontageComposerMediaPickerItemView.class;
        m12952a(this, getContext());
        setContentView(2130905326);
        setForeground((Drawable) ContextUtils.d(getContext(), 16843534).orNull());
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131433686);
        this.f12491d = new ResizeOptions(dimensionPixelSize, dimensionPixelSize);
        this.f12492e = ViewStubHolder.a((ViewStubCompat) c(2131560575));
        this.f12493f = (FbDraweeView) c(2131559057);
        this.f12494g = c(2131563971);
        this.f12490c = new C13871(this);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1226694959);
        if (this.f12493f.getController() != null) {
            Animatable g = this.f12493f.getController().g();
            if (g != null) {
                g.stop();
            }
        }
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1476122602, a);
    }
}
