package com.facebook.drawee.fbpipeline;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: messenger_animated_stickers_android */
public class FbDraweeView extends GenericDraweeView {
    private static final CallerContext f14172c = CallerContext.m9061a(FbDraweeView.class, "unknown");
    @Inject
    AnalyticsTagger f14173a;
    @Inject
    FbDraweeControllerBuilder f14174b;

    private static <T extends View> void m20504a(Class<T> cls, T t) {
        m20505a((Object) t, t.getContext());
    }

    private static void m20505a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FbDraweeView) obj).m20503a(AnalyticsTagger.m11473a(injectorLike), FbDraweeControllerBuilder.m19410b(injectorLike));
    }

    private void m20503a(AnalyticsTagger analyticsTagger, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f14173a = analyticsTagger;
        this.f14174b = fbDraweeControllerBuilder;
    }

    public FbDraweeView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
        m20506c();
    }

    public FbDraweeView(Context context) {
        super(context);
        m20506c();
    }

    public FbDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20506c();
    }

    public FbDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20506c();
    }

    private void m20506c() {
        m20504a(FbDraweeView.class, (View) this);
    }

    @Deprecated
    public void setImageURI(Uri uri) {
        CallerContext b = AnalyticsTagger.m11476b(this);
        if (b == null) {
            b = f14172c;
        }
        m20507a(uri, b);
    }

    public void m20507a(Uri uri, CallerContext callerContext) {
        setController(((FbDraweeControllerBuilder) this.f14174b.m19417a(callerContext).m19424b(uri).m19449b(getController())).m19435s());
    }
}
