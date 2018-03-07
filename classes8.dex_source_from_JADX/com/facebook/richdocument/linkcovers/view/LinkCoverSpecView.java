package com.facebook.richdocument.linkcovers.view;

import android.content.Context;
import android.graphics.RectF;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.richdocument.linkcovers.AttachmentCoverLayoutSpec;
import com.facebook.richdocument.linkcovers.LinkCoverDescriptors.LinkCoverBarDescriptor;
import com.facebook.richdocument.utils.UIUtils;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: place_tag_selected */
public class LinkCoverSpecView extends CustomRelativeLayout {
    private static final CallerContext f5443b = CallerContext.a(LinkCoverSpecView.class);
    List<View> f5444a = new ArrayList();
    private FbDraweeView f5445c;
    public LinkCoverByLineView f5446d;
    private FbTextView f5447e;
    private FbTextView f5448f;

    public LinkCoverSpecView(Context context) {
        super(context);
        m5340a();
    }

    public LinkCoverSpecView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m5340a();
    }

    public LinkCoverSpecView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5340a();
    }

    private void m5340a() {
        setContentView(2130905050);
        this.f5445c = (FbDraweeView) a(2131563435);
        this.f5446d = (LinkCoverByLineView) a(2131563436);
        this.f5447e = (FbTextView) a(2131563437);
        this.f5448f = (FbTextView) a(2131563438);
    }

    public void setImageParams(Uri uri) {
        this.f5445c.a(uri, f5443b);
    }

    public void setTitleText(String str) {
        this.f5447e.setText(str);
    }

    public void setDescriptionText(String str) {
        this.f5448f.setText(str);
    }

    public LinkCoverByLineView getBylineView() {
        return this.f5446d;
    }

    public void setHeadlineTextColor(int i) {
        this.f5447e.setTextColor(i);
    }

    public void setDescriptionTextColor(int i) {
        this.f5448f.setTextColor(i);
    }

    public void setBylineAreaBackgroundColor(int i) {
        UIUtils.m6864a(this.f5446d, i);
    }

    public FbTextView getTitleTextView() {
        return this.f5447e;
    }

    public FbTextView getDescriptionTextView() {
        return this.f5448f;
    }

    public FbDraweeView getCoverImageView() {
        return this.f5445c;
    }

    private static void m5341a(View view, RectF rectF) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.width = (int) rectF.width();
        layoutParams.height = (int) rectF.height();
        layoutParams.leftMargin = (int) rectF.left;
        layoutParams.topMargin = (int) rectF.top;
        view.setLayoutParams(layoutParams);
    }

    public final void m5345a(AttachmentCoverLayoutSpec attachmentCoverLayoutSpec) {
        int i;
        RectF b = attachmentCoverLayoutSpec.m5307b();
        RectF c = attachmentCoverLayoutSpec.m5308c();
        RectF f = attachmentCoverLayoutSpec.m5311f();
        RectF d = attachmentCoverLayoutSpec.m5309d();
        d.right -= attachmentCoverLayoutSpec.m5310e().left;
        m5341a(this.f5445c, b);
        m5341a(this.f5447e, c);
        m5341a(this.f5448f, f);
        m5341a(this.f5446d, d);
        if (attachmentCoverLayoutSpec.f5360j != null) {
            i = attachmentCoverLayoutSpec.f5360j.f5401a;
        } else {
            i = -16777216;
        }
        setHeadlineTextColor(i);
        if (attachmentCoverLayoutSpec.f5361k != null) {
            i = attachmentCoverLayoutSpec.f5361k.f5401a;
        } else {
            i = -16777216;
        }
        setDescriptionTextColor(i);
        LinkCoverByLineView linkCoverByLineView = this.f5446d;
        if (attachmentCoverLayoutSpec.f5371u != null) {
            i = attachmentCoverLayoutSpec.f5371u.f5401a;
        } else {
            i = -7829368;
        }
        linkCoverByLineView.setAuthorTextColor(i);
        m5342b();
        m5343b(attachmentCoverLayoutSpec);
    }

    private void m5342b() {
        for (View view : this.f5444a) {
            if (view.getParent() != null) {
                removeView(view);
            }
        }
        this.f5444a.clear();
    }

    private void m5344c() {
        this.f5446d.bringToFront();
        this.f5447e.bringToFront();
        this.f5448f.bringToFront();
    }

    private void m5343b(AttachmentCoverLayoutSpec attachmentCoverLayoutSpec) {
        for (LinkCoverBarDescriptor linkCoverBarDescriptor : ImmutableList.copyOf(attachmentCoverLayoutSpec.f5367q)) {
            View view = new View(getContext());
            this.f5444a.add(view);
            addView(view);
            m5341a(view, attachmentCoverLayoutSpec.m5305a(linkCoverBarDescriptor.f5386b));
            UIUtils.m6864a(view, linkCoverBarDescriptor.f5385a);
        }
        m5344c();
    }
}
