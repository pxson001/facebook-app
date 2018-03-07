package com.facebook.devicebasedlogin.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.RoundedDrawParams;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: permissions_public_profile_text */
public class DBLProfilePhotoView extends CustomLinearLayout {
    DraweeView f6645a;
    @Inject
    public Provider<FbDraweeControllerBuilder> f6646b;
    CallerContext f6647c = CallerContext.a(getClass(), "dbl");

    private static <T extends View> void m6954a(Class<T> cls, T t) {
        m6955a((Object) t, t.getContext());
    }

    private static void m6955a(Object obj, Context context) {
        ((DBLProfilePhotoView) obj).f6646b = IdBasedProvider.a(FbInjector.get(context), 1117);
    }

    public DBLProfilePhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6953a(context, attributeSet);
    }

    private final void m6953a(Context context, AttributeSet attributeSet) {
        m6954a(DBLProfilePhotoView.class, (View) this);
        setContentView(2130903856);
        setOrientation(1);
        RoundedDrawParams a = RoundedDrawParams.a(context, attributeSet, 0);
        this.f6645a = (DraweeView) a(2131560919);
        GenericDraweeHierarchyBuilder a2 = new GenericDraweeHierarchyBuilder(getResources()).a(getResources().getDrawable(2130842778), ScaleType.a);
        if (a.f > 0.0f) {
            a2.u = RoundingParams.b(a.f);
        }
        Preconditions.checkNotNull(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DBLOverlayParams, 0, 0);
        DBLOverlayParams dBLOverlayParams = new DBLOverlayParams(obtainStyledAttributes.getDrawable(0));
        obtainStyledAttributes.recycle();
        DBLOverlayParams dBLOverlayParams2 = dBLOverlayParams;
        if (dBLOverlayParams2.f6644a != null) {
            a2.f(dBLOverlayParams2.f6644a);
        }
        this.f6645a.setHierarchy(a2.u());
    }

    private void m6956a(Provider<FbDraweeControllerBuilder> provider) {
        this.f6646b = provider;
    }

    public void setImage(String str) {
        this.f6645a.setController(((FbDraweeControllerBuilder) this.f6646b.get()).a(this.f6647c).a(str).s());
    }
}
