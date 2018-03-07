package com.facebook.aplacefor.reaction.views;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;

/* compiled from: is_viewer_joined */
public class APlaceForHeaderCardView extends CustomLinearLayout {
    private FbTextView f10552a = ((FbTextView) a(2131559607));
    private FbTextView f10553b = ((FbTextView) a(2131559608));

    public APlaceForHeaderCardView(Context context) {
        super(context);
        setContentView(2130903257);
        setOrientation(1);
        CustomViewUtils.b(this, new ColorDrawable(getResources().getColor(2131361920)));
        setPadding(0, 0, 0, (int) getResources().getDimension(2131432898));
    }

    public void setTitleColor(int i) {
        this.f10552a.setTextColor(i);
    }

    public void setSubtitleColor(int i) {
        this.f10553b.setTextColor(i);
    }
}
