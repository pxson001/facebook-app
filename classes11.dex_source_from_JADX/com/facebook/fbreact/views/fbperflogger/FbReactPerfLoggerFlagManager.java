package com.facebook.fbreact.views.fbperflogger;

import android.view.View;
import com.facebook.fbreact.fb4a.Fb4aReactPerfFlagListener;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

/* compiled from: enter_edit_mode */
public class FbReactPerfLoggerFlagManager extends SimpleViewManager<FbReactPerfLoggerFlag> {
    private final Fb4aReactPerfFlagListener f7478a;

    public FbReactPerfLoggerFlagManager(Fb4aReactPerfFlagListener fb4aReactPerfFlagListener) {
        this.f7478a = fb4aReactPerfFlagListener;
    }

    public final String m8648a() {
        return "FBReactPerfLoggerFlag";
    }

    protected final View m8647a(ThemedReactContext themedReactContext) {
        return new FbReactPerfLoggerFlag(themedReactContext, this.f7478a);
    }

    @ReactProp(name = "eventName")
    public void setEventName(FbReactPerfLoggerFlag fbReactPerfLoggerFlag, @Nullable String str) {
        fbReactPerfLoggerFlag.f7476b = str;
    }

    @ReactProp(name = "extraData")
    public void setExtraData(FbReactPerfLoggerFlag fbReactPerfLoggerFlag, @Nullable ReadableMap readableMap) {
        fbReactPerfLoggerFlag.f7477c = readableMap;
    }
}
