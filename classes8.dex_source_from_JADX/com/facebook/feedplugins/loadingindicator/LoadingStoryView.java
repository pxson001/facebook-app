package com.facebook.feedplugins.loadingindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: friending_possibilities_click */
public class LoadingStoryView extends ImageView {
    public LoadingStoryView(Context context) {
        super(context);
        m14649a();
    }

    public LoadingStoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14649a();
    }

    public LoadingStoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14649a();
    }

    private void m14649a() {
        setImageDrawable(new LoadingStoryDrawable(getResources()));
    }
}
