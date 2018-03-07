package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.facebook.pages.common.ui.widgets.ExpandableTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;

/* compiled from: second_story_tracking_data */
public class PageInfoDescriptionComponentView extends CustomLinearLayout {
    public ExpandableTextView f2157a = ((ExpandableTextView) a(2131565553));

    public PageInfoDescriptionComponentView(Context context) {
        super(context);
        setOrientation(0);
        Resources resources = getResources();
        CustomViewUtils.b(this, resources.getDrawable(2130842474));
        setPadding(resources.getDimensionPixelSize(2131429797), resources.getDimensionPixelSize(2131429798), resources.getDimensionPixelSize(2131429797), resources.getDimensionPixelSize(2131429798));
        LayoutInflater.from(getContext()).inflate(2130906043, this);
        CustomFontHelper.a(this.f2157a, FontFamily.ROBOTO, FontWeight.REGULAR, this.f2157a.getTypeface());
        this.f2157a.m3660a();
    }
}
