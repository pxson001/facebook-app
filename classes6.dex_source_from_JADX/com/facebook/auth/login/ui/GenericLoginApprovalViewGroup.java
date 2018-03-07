package com.facebook.auth.login.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.common.ui.util.DynamicLayoutUtil;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: product_ref_type */
public class GenericLoginApprovalViewGroup extends AuthFragmentViewGroup<LoginApprovalFragmentControl> {
    @Inject
    InputMethodManager inputMethodManager;
    private final View loginButton = getView(2131564881);
    @Inject
    public DynamicLayoutUtil mDynamicLayoutUtil;
    public final boolean mHideLogoOnSmallDisplays;
    private final TextView passwordText = ((TextView) getView(2131560912));

    /* compiled from: product_ref_type */
    class C04391 implements OnClickListener {
        final /* synthetic */ GenericLoginApprovalViewGroup f7381a;

        C04391(GenericLoginApprovalViewGroup genericLoginApprovalViewGroup) {
            this.f7381a = genericLoginApprovalViewGroup;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1231784389);
            GenericLoginApprovalViewGroup.onLoginClick(this.f7381a);
            Logger.a(2, EntryType.UI_INPUT_END, 1513521295, a);
        }
    }

    /* compiled from: product_ref_type */
    class C04402 implements OnEditorActionListener {
        final /* synthetic */ GenericLoginApprovalViewGroup f7382a;

        C04402(GenericLoginApprovalViewGroup genericLoginApprovalViewGroup) {
            this.f7382a = genericLoginApprovalViewGroup;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 2) {
                return false;
            }
            GenericLoginApprovalViewGroup.onLoginClick(this.f7382a);
            return true;
        }
    }

    public static Bundle createParameterBundle(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("orca:authparam:login_approval_layout", i);
        bundle.putBoolean("orca:authparam:hide_logo", false);
        return bundle;
    }

    public GenericLoginApprovalViewGroup(Context context, LoginApprovalFragmentControl loginApprovalFragmentControl) {
        super(context, loginApprovalFragmentControl);
        FbInjector.a(GenericLoginApprovalViewGroup.class, this);
        setContentView(getResourceArgument("orca:authparam:login_approval_layout", 2130905714));
        if (getArguments() != null) {
            this.mHideLogoOnSmallDisplays = getArguments().getBoolean("orca:authparam:hide_logo", false);
        } else {
            this.mHideLogoOnSmallDisplays = false;
        }
        if (this.mHideLogoOnSmallDisplays) {
            this.mDynamicLayoutUtil.a(getRootView(), getResources().getInteger(2131492868), ImmutableList.of(Integer.valueOf(2131564875)));
            this.mDynamicLayoutUtil.a(getRootView(), getResources().getInteger(2131492869), ImmutableList.of(Integer.valueOf(2131558927), Integer.valueOf(2131563835)), ImmutableList.of(Integer.valueOf(2131427716), Integer.valueOf(2131427718)), ImmutableList.of(Integer.valueOf(2131427715), Integer.valueOf(2131427717)));
        }
        this.loginButton.setOnClickListener(new C04391(this));
        this.passwordText.setOnEditorActionListener(new C04402(this));
    }

    void $ul_injectMe(InputMethodManager inputMethodManager, DynamicLayoutUtil dynamicLayoutUtil) {
        this.inputMethodManager = inputMethodManager;
        this.mDynamicLayoutUtil = dynamicLayoutUtil;
    }

    public static void onLoginClick(GenericLoginApprovalViewGroup genericLoginApprovalViewGroup) {
        if (genericLoginApprovalViewGroup.passwordText.getText().toString().length() > 0) {
            genericLoginApprovalViewGroup.inputMethodManager.hideSoftInputFromWindow(genericLoginApprovalViewGroup.getWindowToken(), 0);
            DialogBasedProgressIndicator dialogBasedProgressIndicator = new DialogBasedProgressIndicator(genericLoginApprovalViewGroup.getContext(), 2131230858);
        }
    }
}
