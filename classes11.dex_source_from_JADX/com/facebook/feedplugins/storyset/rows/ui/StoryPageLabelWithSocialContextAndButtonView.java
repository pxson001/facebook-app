package com.facebook.feedplugins.storyset.rows.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import javax.annotation.Nullable;

/* compiled from: appVersion */
public class StoryPageLabelWithSocialContextAndButtonView extends StoryPageLabelWithButtonView {
    private final TextView f9855h;

    public StoryPageLabelWithSocialContextAndButtonView(Context context) {
        this(context, null);
    }

    public StoryPageLabelWithSocialContextAndButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130907260);
    }

    public StoryPageLabelWithSocialContextAndButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9855h = (TextView) getView(2131567709);
        setTitleLines(1);
    }

    public void setSocialContextText(@Nullable CharSequence charSequence) {
        this.f9855h.setText(charSequence);
    }
}
