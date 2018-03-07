package com.facebook.feed.inlinecomposer.work;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: android.intent.category.HOME */
public class WorkGroupPogView extends CustomLinearLayout {
    private static final CallerContext f19326a = CallerContext.a(WorkGroupPogView.class);
    public FbDraweeView f19327b = ((FbDraweeView) a(2131563152));
    public View f19328c = a(2131563153);
    public BetterTextView f19329d = ((BetterTextView) a(2131563154));

    public WorkGroupPogView(Context context) {
        super(context);
        View.inflate(context, 2130904905, this);
        setOrientation(1);
    }

    public void setName(String str) {
        this.f19329d.setText(str);
    }

    public void setImage(Uri uri) {
        this.f19327b.a(uri, f19326a);
    }

    public void setTextColor(int i) {
        this.f19329d.setTextColor(i);
    }
}
