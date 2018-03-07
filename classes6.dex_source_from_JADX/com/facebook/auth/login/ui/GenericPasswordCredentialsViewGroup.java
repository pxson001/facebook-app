package com.facebook.auth.login.ui;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.text.CustomUrlLikeSpan;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: product_items_edge */
public class GenericPasswordCredentialsViewGroup extends AuthFragmentLogoViewGroup<PasswordCredentialsFragmentControl> {
    private static final CallerContext CALLER_CONTEXT = CallerContext.a(GenericPasswordCredentialsViewGroup.class);
    public final TextView emailText = ((TextView) getView(2131564880));
    private final Button loginButton = ((Button) getView(2131564881));
    @Inject
    PasswordCredentialsViewGroupHelper mPasswordCredentialsViewGroupHelper;
    public final TextView notYouLink = ((TextView) getView(2131564879));
    private final TextView passwordText = ((TextView) getView(2131560912));
    public final Button signupButton = ((Button) findViewById(2131564882));
    public final TextView userName = ((TextView) getView(2131563988));
    public final FbDraweeView userPhoto = ((FbDraweeView) getView(2131564878));

    /* compiled from: product_items_edge */
    class C04411 implements OnClickListener {
        final /* synthetic */ GenericPasswordCredentialsViewGroup f7383a;

        C04411(GenericPasswordCredentialsViewGroup genericPasswordCredentialsViewGroup) {
            this.f7383a = genericPasswordCredentialsViewGroup;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2134246017);
            GenericPasswordCredentialsViewGroup genericPasswordCredentialsViewGroup = this.f7383a;
            genericPasswordCredentialsViewGroup.emailText.setText("");
            genericPasswordCredentialsViewGroup.emailText.setVisibility(0);
            genericPasswordCredentialsViewGroup.userPhoto.setVisibility(8);
            genericPasswordCredentialsViewGroup.userName.setVisibility(8);
            genericPasswordCredentialsViewGroup.notYouLink.setVisibility(8);
            if (genericPasswordCredentialsViewGroup.signupButton != null) {
                genericPasswordCredentialsViewGroup.signupButton.setVisibility(0);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1350199396, a);
        }
    }

    public GenericPasswordCredentialsViewGroup(Context context, PasswordCredentialsFragmentControl passwordCredentialsFragmentControl) {
        super(context, passwordCredentialsFragmentControl);
        FbInjector.a(GenericPasswordCredentialsViewGroup.class, this);
        this.mPasswordCredentialsViewGroupHelper.m10491a(this, passwordCredentialsFragmentControl, this.emailText, this.passwordText, this.loginButton, this.signupButton, null);
        CustomUrlLikeSpan customUrlLikeSpan = new CustomUrlLikeSpan();
        Resources resources = getResources();
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(resources);
        styledStringBuilder.a(customUrlLikeSpan, 33);
        styledStringBuilder.a(resources.getString(2131230861));
        styledStringBuilder.a();
        this.notYouLink.setText(styledStringBuilder.b());
        this.notYouLink.setSaveEnabled(false);
        this.notYouLink.setOnClickListener(new C04411(this));
    }

    void $ul_injectMe(PasswordCredentialsViewGroupHelper passwordCredentialsViewGroupHelper) {
        this.mPasswordCredentialsViewGroupHelper = passwordCredentialsViewGroupHelper;
    }

    protected int getDefaultLayoutResource() {
        return 2130905713;
    }

    public void setUser(String str, String str2, String str3, boolean z) {
        Preconditions.checkState(z);
        this.emailText.setText(str);
        this.emailText.setVisibility(8);
        this.userPhoto.a(Uri.parse(str3), CALLER_CONTEXT);
        this.userPhoto.setVisibility(0);
        this.userName.setText(str2);
        this.userName.setVisibility(0);
        this.notYouLink.setVisibility(0);
        if (this.signupButton != null) {
            this.signupButton.setVisibility(8);
        }
    }
}
