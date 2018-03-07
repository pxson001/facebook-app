package com.facebook.auth.login.ui;

import android.content.Context;
import android.os.Bundle;
import com.facebook.base.fragment.FragmentActionBuilder;
import com.facebook.widget.CustomViewGroup;

/* compiled from: profileListParams */
public class AuthFragmentViewGroup<T extends AuthFragmentControlBase> extends CustomViewGroup {
    protected final T control;
    private final int mEnterTransitionAnimation = getResourceArgument("com.facebook.fragment.ENTER_ANIM", 0);
    private final int mExitTransitionAnimation = getResourceArgument("com.facebook.fragment.EXIT_ANIM", 0);
    private final int mPopEnterTransitionAnimation = getResourceArgument("com.facebook.fragment.POP_ENTER_ANIM", 0);
    private final int mPopExitTransitionAnimation = getResourceArgument("com.facebook.fragment.POP_EXIT_ANIM", 0);

    public static Bundle createParameterBundle(int i, int i2, int i3, int i4) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.facebook.fragment.ENTER_ANIM", i);
        bundle.putInt("com.facebook.fragment.EXIT_ANIM", i2);
        bundle.putInt("com.facebook.fragment.POP_ENTER_ANIM", i3);
        bundle.putInt("com.facebook.fragment.POP_EXIT_ANIM", i4);
        return bundle;
    }

    public AuthFragmentViewGroup(Context context, T t) {
        super(context);
        this.control = t;
    }

    public void setCustomAnimations(FragmentActionBuilder fragmentActionBuilder) {
        fragmentActionBuilder.a(this.mEnterTransitionAnimation, this.mExitTransitionAnimation, this.mPopEnterTransitionAnimation, this.mPopExitTransitionAnimation);
    }

    public Bundle getArguments() {
        return this.control.m10472a().f7367b;
    }

    protected int getResourceArgument(String str, int i) {
        Bundle arguments = getArguments();
        int i2 = 0;
        if (arguments != null) {
            i2 = arguments.getInt(str, i);
        }
        return i2 == 0 ? i : i2;
    }
}
