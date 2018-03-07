package com.facebook.groups.info.view;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: TVTH.init */
public class GroupInfoTopicView extends BetterTextView {
    public GroupInfoTopicView(Context context) {
        super(context);
        setTextColor(getContext().getResources().getColor(2131362110));
        setBackgroundResource(2130840641);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(2131434308);
        layoutParams.setMargins(0, dimensionPixelSize, getContext().getResources().getDimensionPixelSize(2131434309), dimensionPixelSize);
        setLayoutParams(layoutParams);
    }
}
