package com.facebook.timeline.protiles.views;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: favorite_count */
public class ProtilesFriendView extends CustomLinearLayout {
    public TextView f12405a = ((TextView) a(2131566438));
    public TextView f12406b = ((TextView) a(2131566439));
    public FbDraweeView f12407c = ((FbDraweeView) a(2131566437));
    public ImageView f12408d = ((ImageView) a(2131566441));
    public View f12409e = a(2131566440);

    public ProtilesFriendView(Context context) {
        super(context);
        setOrientation(1);
        setContentView(2130906502);
    }

    public void setProfilePictureController(DraweeController draweeController) {
        this.f12407c.setController(draweeController);
    }

    public void setOnAddFriendClickListener(OnClickListener onClickListener) {
        this.f12408d.setOnClickListener(onClickListener);
    }
}
