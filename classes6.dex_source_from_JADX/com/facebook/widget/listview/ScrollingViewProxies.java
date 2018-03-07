package com.facebook.widget.listview;

import android.view.View;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: refCode */
public class ScrollingViewProxies {
    @Nullable
    public static ScrollingViewProxy m8635a(View view) {
        Object tag = view.getTag(2131558446);
        boolean z = tag == null || (tag instanceof WeakReference);
        Preconditions.checkState(z);
        WeakReference weakReference = (WeakReference) tag;
        return weakReference == null ? null : (ScrollingViewProxy) weakReference.get();
    }
}
