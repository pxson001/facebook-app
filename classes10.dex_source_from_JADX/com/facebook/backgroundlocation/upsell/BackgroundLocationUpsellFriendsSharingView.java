package com.facebook.backgroundlocation.upsell;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: detection_strings */
public class BackgroundLocationUpsellFriendsSharingView extends CustomLinearLayout implements BackgroundLocationUpsell {
    @Inject
    public BackgroundLocationUpsellText f15058a;
    public FacepileView f15059b = ((FacepileView) a(2131559816));
    public TextView f15060c = ((TextView) a(2131559817));
    public Button f15061d = ((Button) a(2131559818));

    public static void m15558a(Object obj, Context context) {
        ((BackgroundLocationUpsellFriendsSharingView) obj).f15058a = BackgroundLocationUpsellText.m15563a(FbInjector.get(context));
    }

    public BackgroundLocationUpsellFriendsSharingView(Context context) {
        super(context);
        Class cls = BackgroundLocationUpsellFriendsSharingView.class;
        m15558a(this, getContext());
        setContentView(2130903345);
        setOrientation(1);
        setGravity(1);
    }

    public String getDesignName() {
        return "facepile";
    }
}
