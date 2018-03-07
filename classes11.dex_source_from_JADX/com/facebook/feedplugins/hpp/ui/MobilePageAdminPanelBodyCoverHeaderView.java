package com.facebook.feedplugins.hpp.ui;

import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.text.BadgeTextView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: current_size */
public class MobilePageAdminPanelBodyCoverHeaderView extends CustomFrameLayout {
    private static final CallerContext f7801a = CallerContext.a(MobilePageAdminPanelBodyCoverHeaderView.class, "pages_public_view", "hpp_cover_header");
    private FbDraweeView f7802b;
    private FbDraweeView f7803c;
    private ContentView f7804d;
    private BadgeTextView f7805e;
    private FbTextView f7806f;

    public MobilePageAdminPanelBodyCoverHeaderView(Context context) {
        super(context);
        m8968a();
    }

    public MobilePageAdminPanelBodyCoverHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8968a();
    }

    public MobilePageAdminPanelBodyCoverHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8968a();
    }

    private void m8968a() {
        setContentView(2130904804);
        float dimension = getResources().getDimension(2131434589);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        genericDraweeHierarchyBuilder.u = RoundingParams.b(dimension, dimension, 0.0f, 0.0f);
        GenericDraweeHierarchy u = genericDraweeHierarchyBuilder.f(getResources().getDrawable(2130840798)).u();
        this.f7803c = (FbDraweeView) c(2131562948);
        this.f7802b = (FbDraweeView) c(2131562947);
        this.f7804d = (ContentView) c(2131562949);
        this.f7805e = (BadgeTextView) c(2131562950);
        this.f7806f = (FbTextView) c(2131562951);
        this.f7802b.setHierarchy(u);
        this.f7802b.setAspectRatio(2.7f);
        this.f7804d.setTitleTextAppearance(2131626692);
        this.f7804d.setSubtitleTextAppearance(2131626693);
    }

    public final void m8969a(Uri uri, @Nullable PointF pointF) {
        this.f7802b.a(uri, f7801a);
        if (pointF != null) {
            ((GenericDraweeHierarchy) this.f7802b.getHierarchy()).a(pointF);
        }
    }

    public void setProfilePhoto(Uri uri) {
        this.f7803c.a(uri, f7801a);
    }

    public final void m8970a(String str, String str2) {
        this.f7805e.setText(str);
        this.f7806f.setText(str2);
    }

    public void setBadgeCount(String str) {
        BadgeTextView badgeTextView = this.f7805e;
        if (str == null || str.length() == 0) {
            str = null;
        }
        badgeTextView.setBadgeText(str);
    }
}
