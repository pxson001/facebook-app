package com.facebook.feed.rows.sections.text;

import android.content.Context;
import android.view.View;
import com.facebook.feed.rows.views.CopyStoryTextListener;
import com.facebook.feed.rows.views.SupportsCopyStoryText;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Lazy;
import com.facebook.ui.toaster.Toaster;

/* compiled from: friending_state_change */
public final class CopyTextEventListenerManager {
    private final CopyStoryTextListener f23093a;

    public CopyTextEventListenerManager(Context context, Lazy<Toaster> lazy, GraphQLStory graphQLStory) {
        this.f23093a = new CopyStoryTextListener(lazy, graphQLStory, context);
    }

    public final <V extends View & SupportsCopyStoryText> void m31225a(V v) {
        this.f23093a.f23098e = v;
        ((SupportsCopyStoryText) v).setCopyTextGestureListener(this.f23093a);
    }
}
