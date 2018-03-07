package com.facebook.fbreact.views.fbvpvlogger;

import android.view.View;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: empty_feed_uuid */
public class FbReactVpvLoggerFlagManager extends SimpleViewManager<FbReactVpvLoggerFlag> {
    public final String m8658a() {
        return "FbReactVpvLoggerFlag";
    }

    @ReactProp(name = "feedUnitId")
    public void setFeedUnitId(FbReactVpvLoggerFlag fbReactVpvLoggerFlag, @Nullable String str) {
        fbReactVpvLoggerFlag.f7481a = str;
    }

    protected final View m8657a(ThemedReactContext themedReactContext) {
        return new FbReactVpvLoggerFlag(themedReactContext);
    }

    @ReactProp(name = "isTop")
    public void setTop(FbReactVpvLoggerFlag fbReactVpvLoggerFlag, @Nullable boolean z) {
        fbReactVpvLoggerFlag.f7482b = z;
    }

    @Nullable
    public final Map m8659h() {
        return MapBuilder.a("reactVpvEvent", MapBuilder.a("registrationName", "onAttachmentEvent"));
    }
}
