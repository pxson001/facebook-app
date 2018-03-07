package com.facebook.auth.login.ui;

import android.content.Context;
import android.os.Bundle;

/* compiled from: product_items_delete */
public class GenericSilentLoginViewGroup extends AuthFragmentViewGroup<AuthFragmentControlBase> {
    public GenericSilentLoginViewGroup(Context context, AuthFragmentControlBase authFragmentControlBase) {
        super(context, authFragmentControlBase);
        int resourceArgument = getResourceArgument("layout_resource", 0);
        if (resourceArgument > 0) {
            setContentView(resourceArgument);
        }
    }

    public static Bundle createParameterBundle(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("layout_resource", i);
        return bundle;
    }
}
