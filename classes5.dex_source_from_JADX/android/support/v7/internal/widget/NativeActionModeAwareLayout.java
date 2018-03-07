package android.support.v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.View;

@TargetApi(11)
/* compiled from: uri_handler */
public class NativeActionModeAwareLayout extends ContentFrameLayout {
    public OnActionModeForChildListener f1111a;

    /* compiled from: uri_handler */
    public interface OnActionModeForChildListener {
        ActionMode mo224a(View view, Callback callback);
    }

    public NativeActionModeAwareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setActionModeForChildListener(OnActionModeForChildListener onActionModeForChildListener) {
        this.f1111a = onActionModeForChildListener;
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        if (this.f1111a != null) {
            return this.f1111a.mo224a(view, callback);
        }
        return super.startActionModeForChild(view, callback);
    }
}
