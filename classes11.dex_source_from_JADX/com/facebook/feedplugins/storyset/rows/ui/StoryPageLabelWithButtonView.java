package com.facebook.feedplugins.storyset.rows.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.attachments.angora.actionbutton.GenericActionButtonView;

/* compiled from: app_not_in_background */
public class StoryPageLabelWithButtonView extends StoryPageGenericLabelView implements AttachmentHasButton {
    private final GenericActionButtonView f9854h;

    public StoryPageLabelWithButtonView(Context context) {
        this(context, null);
    }

    public StoryPageLabelWithButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130907258);
    }

    public StoryPageLabelWithButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9854h = (GenericActionButtonView) getView(2131567708);
    }

    public void setActionButtonOnClickListener(OnClickListener onClickListener) {
        this.f9854h.a.setOnClickListener(onClickListener);
    }

    public GenericActionButtonView getActionButton() {
        return this.f9854h;
    }
}
