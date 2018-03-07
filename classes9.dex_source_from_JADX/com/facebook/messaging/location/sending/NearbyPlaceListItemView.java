package com.facebook.messaging.location.sending;

import android.content.Context;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: mMapDelegate became null after animation was started and before that animation was finished. That's super weird. */
public class NearbyPlaceListItemView extends CustomRelativeLayout {
    public static final CallerContext f11453a = CallerContext.a(NearbyPlaceListItemView.class);
    public FbDraweeView f11454b = ((FbDraweeView) a(2131564076));
    public TextView f11455c = ((TextView) a(2131564078));
    public TextView f11456d = ((TextView) a(2131564079));
    public TextView f11457e = ((TextView) a(2131564077));

    public NearbyPlaceListItemView(Context context) {
        super(context);
        setContentView(2130905382);
        setBackgroundResource(2130842168);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131433707);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }
}
