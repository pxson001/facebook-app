package com.facebook.fbreact.views.fbvpvlogger;

import android.content.Context;
import android.view.View;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.UIManagerModule;

/* compiled from: endX */
public class FbReactVpvLoggerFlag extends View {
    public String f7481a;
    public boolean f7482b;

    public FbReactVpvLoggerFlag(Context context) {
        super(context);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 628305807);
        super.onAttachedToWindow();
        m8654a(true);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1365147670, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1982807609);
        super.onDetachedFromWindow();
        m8654a(false);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1707237062, a);
    }

    private void m8654a(boolean z) {
        Context context = getContext();
        if (context instanceof ReactContext) {
            ReactContext reactContext = (ReactContext) context;
            if (reactContext.b()) {
                ((UIManagerModule) reactContext.b(UIManagerModule.class)).a.a(new ReactVpvEvent(getId(), SystemClock.b(), this.f7481a, z, this.f7482b));
            }
        }
    }
}
