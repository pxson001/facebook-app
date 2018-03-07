package com.facebook.messaging.login;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.facebook.auth.login.ui.AuthFragmentControlBase;
import com.facebook.auth.login.ui.AuthFragmentViewGroup;
import com.facebook.widget.listview.EmptyListViewItem;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;

/* compiled from: is_linked */
public class OrcaSilentLoginViewGroup extends AuthFragmentViewGroup<AuthFragmentControlBase> {
    public static Bundle createParameterBundle(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("orca:authparam:silent_login_layout", i);
        return bundle;
    }

    public OrcaSilentLoginViewGroup(Context context, AuthFragmentControlBase authFragmentControlBase) {
        super(context, authFragmentControlBase);
        setContentView(getResourceArgument("orca:authparam:silent_login_layout", 2130905716));
        ((EmptyListViewItem) getView(2131564884)).m8598a(true);
        if (FbTitleBarUtil.m8798a((View) this)) {
            FbTitleBar fbTitleBar = (FbTitleBar) getView(2131558563);
            Builder a = TitleBarButtonSpec.a();
            a.a = 1;
            a = a;
            a.b = getResources().getDrawable(2130842008);
            fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
        }
    }
}
