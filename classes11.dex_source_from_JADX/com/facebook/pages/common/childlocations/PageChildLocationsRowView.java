package com.facebook.pages.common.childlocations;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: step_navigation */
public class PageChildLocationsRowView extends CustomLinearLayout {
    public static final CallerContext f1377a = CallerContext.a(PageChildLocationsRowView.class);
    public final FbDraweeView f1378b;
    public final TextView f1379c;
    public final TextView f1380d;

    public PageChildLocationsRowView(Context context) {
        this(context, null);
    }

    private PageChildLocationsRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130906026);
        setOrientation(1);
        this.f1378b = (FbDraweeView) a(2131560587);
        this.f1379c = (TextView) a(2131560588);
        this.f1380d = (TextView) a(2131565511);
    }

    public final void m2016a(PageChildLocationsRowViewController pageChildLocationsRowViewController) {
        this.f1378b.a(pageChildLocationsRowViewController.f1383c, f1377a);
        this.f1379c.setText(pageChildLocationsRowViewController.f1381a);
        String str = pageChildLocationsRowViewController.f1382b;
        if (str != null) {
            this.f1380d.setText(str);
        }
    }
}
