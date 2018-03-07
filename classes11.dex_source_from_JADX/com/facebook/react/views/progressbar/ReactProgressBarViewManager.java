package com.facebook.react.views.progressbar;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

/* compiled from: Request fail state */
public class ReactProgressBarViewManager extends BaseViewManager<ProgressBarContainerView, ProgressBarShadowNode> {
    private static Object f11492a = new Object();

    protected final void m11921b(View view) {
        ((ProgressBarContainerView) view).m11903a();
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ProgressBarContainerView progressBarContainerView, @Nullable Integer num) {
        progressBarContainerView.f11483a = num;
    }

    public static ProgressBar m11916a(Context context, int i) {
        ProgressBar progressBar;
        synchronized (f11492a) {
            progressBar = new ProgressBar(context, null, i);
        }
        return progressBar;
    }

    @ReactProp(name = "indeterminate")
    public void setIndeterminate(ProgressBarContainerView progressBarContainerView, boolean z) {
        progressBarContainerView.f11484b = z;
    }

    public final String m11918a() {
        return "AndroidProgressBar";
    }

    @ReactProp(name = "progress")
    public void setProgress(ProgressBarContainerView progressBarContainerView, double d) {
        progressBarContainerView.f11486d = d;
    }

    @ReactProp(name = "animating")
    public void setAnimating(ProgressBarContainerView progressBarContainerView, boolean z) {
        progressBarContainerView.f11485c = z;
    }

    protected final View m11917a(ThemedReactContext themedReactContext) {
        return new ProgressBarContainerView(themedReactContext);
    }

    @ReactProp(name = "styleAttr")
    public void setStyle(ProgressBarContainerView progressBarContainerView, @Nullable String str) {
        progressBarContainerView.m11906a(str);
    }

    public final ReactShadowNode m11922c() {
        return new ProgressBarShadowNode();
    }

    public final Class<ProgressBarShadowNode> m11920b() {
        return ProgressBarShadowNode.class;
    }

    static int m11915a(@Nullable String str) {
        if (str == null) {
            throw new JSApplicationIllegalArgumentException("ProgressBar needs to have a style, null received");
        } else if (str.equals("Horizontal")) {
            return 16842872;
        } else {
            if (str.equals("Small")) {
                return 16842873;
            }
            if (str.equals("Large")) {
                return 16842874;
            }
            if (str.equals("Inverse")) {
                return 16843399;
            }
            if (str.equals("SmallInverse")) {
                return 16843400;
            }
            if (str.equals("LargeInverse")) {
                return 16843401;
            }
            if (str.equals("Normal")) {
                return 16842871;
            }
            throw new JSApplicationIllegalArgumentException("Unknown ProgressBar style: " + str);
        }
    }
}
