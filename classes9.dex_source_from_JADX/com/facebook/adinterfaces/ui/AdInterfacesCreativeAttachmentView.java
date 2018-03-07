package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.text.BadgeTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.text.BetterTextView;

/* compiled from: V2_UNKNOWN_TYPE */
public class AdInterfacesCreativeAttachmentView extends CustomLinearLayout {
    private static final CallerContext f22669a = CallerContext.a(AdInterfacesCreativeAttachmentView.class);
    public BadgeTextView f22670b = ((BadgeTextView) a(2131559269));
    public ImageView f22671c = ((ImageView) a(2131560844));
    public CustomLinearLayout f22672d = ((CustomLinearLayout) a(2131560842));
    public BetterEditTextView f22673e = ((BetterEditTextView) a(2131559270));
    public CustomLinearLayout f22674f = ((CustomLinearLayout) a(2131559275));
    public BetterTextView f22675g = ((BetterTextView) a(2131560843));
    public int f22676h;
    public View f22677i = a(2131560845);
    public FbDraweeView f22678j = ((FbDraweeView) a(2131559276));

    public AdInterfacesCreativeAttachmentView(Context context) {
        super(context);
        setContentView(2130903823);
        setOrientation(1);
    }

    public final void m24596a(String str, int i) {
        this.f22675g.setText(str + " " + i);
        this.f22676h = i;
    }

    public void setAdImageThumbnail(String str) {
        this.f22678j.a(Uri.parse(str), f22669a);
    }
}
