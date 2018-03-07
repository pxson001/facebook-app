package com.facebook.attachments.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;

/* compiled from: upsell_time_label */
public class AttachmentViewStaticVideo extends AttachmentViewPhoto {
    public AttachmentViewStaticVideo(Context context) {
        this(context, null, 0);
    }

    public AttachmentViewStaticVideo(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AttachmentViewStaticVideo(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void setupImageView(GraphQLStoryAttachment graphQLStoryAttachment) {
        super.setupImageView(graphQLStoryAttachment);
        ((GenericDraweeHierarchy) this.f978i.getHierarchy()).a(getContext().getResources().getDrawable(2130840340));
    }

    protected final void mo49a() {
        DefaultFeedIntentBuilder defaultFeedIntentBuilder = this.f971a;
        Long.parseLong(getAttachment().r().b());
        this.f973c.a(defaultFeedIntentBuilder.c(getAttachment().r().aO()), getContext());
    }
}
