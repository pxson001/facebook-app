package com.facebook.react.views.text;

import android.view.View;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;

/* compiled from: ReactMediaPlayer failed to set data source */
public class ReactRawTextManager extends ReactTextViewManager {
    public final /* synthetic */ View mo308a(ThemedReactContext themedReactContext) {
        return mo312b(themedReactContext);
    }

    public final /* synthetic */ ReactShadowNode mo314c() {
        return mo315d();
    }

    public String mo309a() {
        return "RCTRawText";
    }

    public final ReactTextView mo312b(ThemedReactContext themedReactContext) {
        throw new IllegalStateException("RKRawText doesn't map into a native view");
    }

    public final void mo311a(ReactTextView reactTextView, Object obj) {
    }

    public final ReactTextShadowNode mo315d() {
        return new ReactTextShadowNode(true);
    }

    public final Class<ReactTextShadowNode> mo313b() {
        return ReactTextShadowNode.class;
    }
}
