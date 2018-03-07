package com.facebook.timeline.favmediapicker.ui.views;

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

/* compiled from: friends_nearby_ping_open_in_app */
public class SectionTitleView extends CustomLinearLayout {
    @Inject
    public AllCapsTransformationMethod f11130a;
    public LazyView<FbTextView> f11131b = new LazyView((ViewStub) findViewById(2131561742));

    public static void m11290a(Object obj, Context context) {
        ((SectionTitleView) obj).f11130a = AllCapsTransformationMethod.b(FbInjector.get(context));
    }

    public SectionTitleView(Context context) {
        super(context);
        Class cls = SectionTitleView.class;
        m11290a(this, getContext());
        setContentView(2130904248);
        CustomViewUtils.b(this, ContextCompat.a(getContext(), 2130843301));
        ((FbTextView) findViewById(2131561741)).setTransformationMethod(this.f11130a);
    }
}
