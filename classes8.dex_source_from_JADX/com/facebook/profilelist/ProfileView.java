package com.facebook.profilelist;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: removed_urls */
public class ProfileView extends CustomRelativeLayout {
    public static final CallerContext f4562a = CallerContext.a(ProfileView.class);
    public TextView f4563b = ((TextView) a(2131566124));
    public FbDraweeView f4564c = ((FbDraweeView) a(2131561876));
    public CheckBox f4565d = ((CheckBox) a(2131560310));

    public ProfileView(Context context) {
        super(context);
        setContentView(2130906489);
    }

    public void setIsSelected(boolean z) {
        this.f4565d.setChecked(z);
    }
}
