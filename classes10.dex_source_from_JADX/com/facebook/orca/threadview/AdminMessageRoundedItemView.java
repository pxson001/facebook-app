package com.facebook.orca.threadview;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.messaging.model.messages.Message;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: multipickerCoverShown */
public class AdminMessageRoundedItemView extends CustomFrameLayout {
    private ThreadViewImageAttachmentView f6834a;

    public AdminMessageRoundedItemView(Context context) {
        this(context, null, 0);
    }

    public AdminMessageRoundedItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdminMessageRoundedItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905560);
        this.f6834a = (ThreadViewImageAttachmentView) findViewById(2131564438);
        this.f6834a.setNeedsUserRequestToLoad(false);
        this.f6834a.f7564C = true;
    }

    public void setMessage(Message message) {
        this.f6834a.setMessage(message);
    }

    public final void m6497a(AdminMessageItemView adminMessageItemView) {
        this.f6834a.m7315a((ThreadImageClickListener) adminMessageItemView);
    }
}
