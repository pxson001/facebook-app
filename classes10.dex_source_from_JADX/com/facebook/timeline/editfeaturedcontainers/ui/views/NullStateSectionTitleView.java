package com.facebook.timeline.editfeaturedcontainers.ui.views;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.ViewStub;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.LazyView;
import javax.inject.Inject;

/* compiled from: geofence_radius_meters */
public class NullStateSectionTitleView extends CustomLinearLayout {
    @Inject
    public AllCapsTransformationMethod f10945a;
    public LazyView<FbTextView> f10946b = new LazyView((ViewStub) findViewById(2131561742));

    public static void m11080a(Object obj, Context context) {
        ((NullStateSectionTitleView) obj).f10945a = AllCapsTransformationMethod.b(FbInjector.get(context));
    }

    public NullStateSectionTitleView(Context context) {
        super(context);
        Class cls = NullStateSectionTitleView.class;
        m11080a(this, getContext());
        setContentView(2130905507);
        CustomViewUtils.b(this, ContextCompat.a(getContext(), 2130843301));
        ((FbTextView) findViewById(2131561741)).setTransformationMethod(this.f10945a);
    }
}
