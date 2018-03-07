package com.facebook.widget;

import android.view.View;
import android.view.ViewGroup;
import com.google.common.base.Preconditions;

/* compiled from: com.google.android.gms.common.internal.IGmsServiceBroker */
public class RecyclableViewHelper {
    public static boolean m10494a(FbCustomViewGroup fbCustomViewGroup, View view, int i) {
        Preconditions.checkArgument(view instanceof IViewAttachAware);
        if (((IViewAttachAware) view).a()) {
            return false;
        }
        ((ViewGroup) fbCustomViewGroup).addView(view, i);
        return true;
    }
}
