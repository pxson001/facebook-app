package com.facebook.instantshopping.view.widget.media;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: SESSION_CHANGE */
public class TiltToPanDraweeView extends FbDraweeView {
    @Inject
    public FbDraweeControllerBuilder f23943c;

    private static <T extends View> void m25214a(Class<T> cls, T t) {
        m25215a((Object) t, t.getContext());
    }

    private static void m25215a(Object obj, Context context) {
        ((TiltToPanDraweeView) obj).f23943c = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    public TiltToPanDraweeView(Context context) {
        this(context, null, 0);
    }

    public TiltToPanDraweeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TiltToPanDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25214a(TiltToPanDraweeView.class, (View) this);
    }

    private void m25213a(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f23943c = fbDraweeControllerBuilder;
    }

    public final void m25217b(Uri uri, CallerContext callerContext) {
        m25216c(uri, callerContext);
        setVisibility(0);
    }

    private void m25216c(Uri uri, CallerContext callerContext) {
        FbDraweeControllerBuilder a = m25212a(callerContext);
        a.b(uri).c(true);
        setController(a.s());
    }

    private FbDraweeControllerBuilder m25212a(CallerContext callerContext) {
        return ((FbDraweeControllerBuilder) this.f23943c.b(getController())).a(callerContext);
    }
}
