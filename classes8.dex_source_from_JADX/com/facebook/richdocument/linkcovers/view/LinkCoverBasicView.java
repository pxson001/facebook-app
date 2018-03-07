package com.facebook.richdocument.linkcovers.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: place_tip_upsell_shown */
public class LinkCoverBasicView extends CustomLinearLayout {
    private static final CallerContext f5432a = CallerContext.a(LinkCoverBasicView.class);
    private FbDraweeView f5433b;
    public LinkCoverByLineView f5434c;
    private FbTextView f5435d;
    private FbTextView f5436e;

    public LinkCoverBasicView(Context context) {
        super(context);
        m5332a();
    }

    public LinkCoverBasicView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m5332a();
    }

    public LinkCoverBasicView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5332a();
    }

    private void m5332a() {
        setContentView(2130905049);
        this.f5433b = (FbDraweeView) a(2131563435);
        this.f5434c = (LinkCoverByLineView) a(2131563436);
        this.f5435d = (FbTextView) a(2131563437);
        this.f5436e = (FbTextView) a(2131563438);
    }

    public void setImageParams(Uri uri) {
        this.f5433b.a(uri, f5432a);
    }

    public void setTitleText(String str) {
        this.f5435d.setText(str);
    }

    public void setDescriptionText(String str) {
        this.f5436e.setText(str);
    }

    public LinkCoverByLineView getBylineView() {
        return this.f5434c;
    }

    public FbDraweeView getCoverImageView() {
        return this.f5433b;
    }

    public FbTextView getTitleTextView() {
        return this.f5435d;
    }

    public FbTextView getDescriptionTextView() {
        return this.f5436e;
    }
}
