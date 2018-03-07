package com.facebook.backstage.consumption;

import android.content.Context;
import android.graphics.Canvas;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: savedPins */
public class BackstagePanelImageView extends GenericDraweeView {
    @Inject
    public FbDraweeControllerBuilder f4543a;

    private static <T extends View> void m4503a(Class<T> cls, T t) {
        m4504a((Object) t, t.getContext());
    }

    private static void m4504a(Object obj, Context context) {
        ((BackstagePanelImageView) obj).f4543a = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    public BackstagePanelImageView(Context context) {
        this(context, null);
    }

    public BackstagePanelImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackstagePanelImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4503a(BackstagePanelImageView.class, (View) this);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    public final void m4505a(boolean z) {
        setHierarchy(GenericDraweeViewHelper.m4530a(getResources()));
        if (z) {
            ((GenericDraweeHierarchy) getHierarchy()).a(RoundingParams.e());
        }
    }

    public void setImage(Uri uri) {
        setController(GenericDraweeViewHelper.m4529a(uri, this.f4543a, null));
    }

    private void m4502a(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f4543a = fbDraweeControllerBuilder;
    }
}
