package com.facebook.timeline.header.externalLinks;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;

/* compiled from: filter_item_label */
public class IntroCardExternalLinkView extends CustomLinearLayout {
    public static final CallerContext f11689a = CallerContext.a(IntroCardExternalLinkView.class, "timeline");
    public FbDraweeView f11690b = ((FbDraweeView) a(2131567926));
    public FbTextView f11691c = ((FbTextView) a(2131559739));

    public IntroCardExternalLinkView(Context context) {
        super(context);
        setContentView(2130907443);
        setOrientation(0);
        CustomViewUtils.b(this, ContextCompat.a(getContext(), 2130839563));
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131429962);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
    }
}
