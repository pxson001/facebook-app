package com.facebook.feed.ui.fullscreenvideoplayer;

import android.content.Context;
import android.support.v7.app.MediaRouteButton;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;

/* compiled from: Top level comments were null. */
public class FullScreenMediaRouteButton extends MediaRouteButton {
    public FullScreenMediaRouteButton(Context context) {
        this(context, null);
    }

    public FullScreenMediaRouteButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130773715);
    }

    public FullScreenMediaRouteButton(Context context, AttributeSet attributeSet, int i) {
        super(m24540a(context), attributeSet, i);
    }

    private static Context m24540a(Context context) {
        return new ContextThemeWrapper(context, 2131624137);
    }
}
