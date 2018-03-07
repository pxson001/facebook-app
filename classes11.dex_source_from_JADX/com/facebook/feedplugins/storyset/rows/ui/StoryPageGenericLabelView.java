package com.facebook.feedplugins.storyset.rows.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.fbui.widget.layout.ImageBlockLayout;

/* compiled from: app_review */
public class StoryPageGenericLabelView extends ImageBlockLayout implements AttachmentHasLabel {
    private final TextView f9852h;
    private final TextView f9853i;

    public StoryPageGenericLabelView(Context context) {
        this(context, null);
    }

    public StoryPageGenericLabelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130907255);
    }

    public StoryPageGenericLabelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setContentView(i);
        this.f9852h = (TextView) getView(2131567706);
        this.f9853i = (TextView) getView(2131567707);
        setTitleLines(1);
    }

    public void setTitleLines(int i) {
        this.f9852h.setLines(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.f9852h.setText(charSequence);
    }

    public void setContextText(CharSequence charSequence) {
        this.f9853i.setText(charSequence);
    }
}
