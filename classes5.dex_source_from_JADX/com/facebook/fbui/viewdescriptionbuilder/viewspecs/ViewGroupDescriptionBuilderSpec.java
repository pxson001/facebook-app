package com.facebook.fbui.viewdescriptionbuilder.viewspecs;

import android.os.Bundle;
import android.view.ViewGroup;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilderSpec;

/* compiled from: XLARGE */
public class ViewGroupDescriptionBuilderSpec implements ViewDescriptionBuilderSpec<ViewGroup> {
    public final void mo1226a(Object obj, Bundle bundle) {
        bundle.putInt("immediate_child_count", ((ViewGroup) obj).getChildCount());
    }

    public final Class<ViewGroup> mo1225a() {
        return ViewGroup.class;
    }
}
