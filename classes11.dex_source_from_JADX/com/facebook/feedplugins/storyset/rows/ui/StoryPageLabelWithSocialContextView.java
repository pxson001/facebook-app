package com.facebook.feedplugins.storyset.rows.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import javax.annotation.Nullable;

/* compiled from: appUpdates/ */
public class StoryPageLabelWithSocialContextView extends StoryPageGenericLabelView {
    private final TextView f9856h;

    public StoryPageLabelWithSocialContextView(Context context) {
        this(context, null);
    }

    public StoryPageLabelWithSocialContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130907261);
    }

    public StoryPageLabelWithSocialContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9856h = (TextView) getView(2131567709);
        setTitleLines(1);
    }

    public void setSocialContextText(@Nullable CharSequence charSequence) {
        this.f9856h.setText(charSequence);
    }
}
