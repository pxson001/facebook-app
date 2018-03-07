package com.facebook.richdocument.linkcovers.view;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: place_tagging_button */
public class LinkCoverByLineView extends CustomLinearLayout {
    private static final CallerContext f5439b = CallerContext.a(LinkCoverByLineView.class);
    @Inject
    public FbDraweeControllerBuilder f5440a;
    public FbDraweeView f5441c;
    private FbTextView f5442d;

    private static <T extends View> void m5337a(Class<T> cls, T t) {
        m5338a((Object) t, t.getContext());
    }

    private static void m5338a(Object obj, Context context) {
        ((LinkCoverByLineView) obj).f5440a = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    public LinkCoverByLineView(Context context) {
        super(context);
        m5335a();
    }

    public LinkCoverByLineView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m5335a();
    }

    public LinkCoverByLineView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5335a();
    }

    private void m5335a() {
        m5337a(LinkCoverByLineView.class, (View) this);
        setContentView(2130905053);
        this.f5441c = (FbDraweeView) a(2131563443);
        this.f5442d = (FbTextView) a(2131563445);
    }

    public final void m5339a(Uri uri, final int i) {
        this.f5441c.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f5440a.a(f5439b).b(uri).b(this.f5441c.getController())).a(new BaseControllerListener(this) {
            final /* synthetic */ LinkCoverByLineView f5438b;

            public final void m5333a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
                CloseableImage closeableImage = (CloseableImage) obj;
                if (closeableImage != null) {
                    int f = closeableImage.f();
                    int g = closeableImage.g();
                    if (f == 0 || g == 0) {
                        this.f5438b.f5441c.setVisibility(8);
                        return;
                    }
                    this.f5438b.f5441c.setVisibility(0);
                    f = (f * i) / g;
                    LayoutParams layoutParams = this.f5438b.f5441c.getLayoutParams();
                    layoutParams.width = f;
                    layoutParams.height = i;
                    this.f5438b.f5441c.setLayoutParams(layoutParams);
                }
            }
        })).s());
    }

    private void m5336a(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f5440a = fbDraweeControllerBuilder;
    }

    public void setAuthorText(String str) {
        this.f5442d.setText(str);
    }

    public void setAuthorTextColor(int i) {
        this.f5442d.setTextColor(i);
    }

    public FbDraweeView getLogoImageView() {
        return this.f5441c;
    }

    public FbTextView getAuthorTextView() {
        return this.f5442d;
    }
}
