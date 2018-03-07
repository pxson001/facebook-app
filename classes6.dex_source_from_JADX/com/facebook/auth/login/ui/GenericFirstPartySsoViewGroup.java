package com.facebook.auth.login.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.fblibraries.fblogin.FirstPartySsoSessionInfo;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.text.CustomUrlLikeSpan;
import com.facebook.widget.text.CustomUrlLikeSpan.OnUrlClickHandler;
import javax.annotation.Nullable;

/* compiled from: production_prompt */
public class GenericFirstPartySsoViewGroup extends AuthFragmentLogoViewGroup<FirstPartySsoFragmentControl> {
    private final Button loginButton = ((Button) getView(2131564881));
    private final TextView loginText = ((TextView) getView(2131564885));

    /* compiled from: production_prompt */
    class C04371 implements OnClickListener {
        final /* synthetic */ GenericFirstPartySsoViewGroup f7379a;

        C04371(GenericFirstPartySsoViewGroup genericFirstPartySsoViewGroup) {
            this.f7379a = genericFirstPartySsoViewGroup;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1140414529);
            DialogBasedProgressIndicator dialogBasedProgressIndicator = new DialogBasedProgressIndicator(this.f7379a.getContext(), 2131230858);
            Logger.a(2, EntryType.UI_INPUT_END, 1329672970, a);
        }
    }

    /* compiled from: production_prompt */
    class C04382 extends OnUrlClickHandler {
        final /* synthetic */ GenericFirstPartySsoViewGroup f7380a;

        C04382(GenericFirstPartySsoViewGroup genericFirstPartySsoViewGroup) {
            this.f7380a = genericFirstPartySsoViewGroup;
        }

        public final void m10487a() {
            GenericFirstPartySsoViewGroup genericFirstPartySsoViewGroup = this.f7380a;
        }
    }

    public GenericFirstPartySsoViewGroup(Context context, FirstPartySsoFragmentControl firstPartySsoFragmentControl) {
        super(context, firstPartySsoFragmentControl);
        this.loginText.setMovementMethod(LinkMovementMethod.getInstance());
        this.loginButton.setOnClickListener(new C04371(this));
    }

    protected int getDefaultLayoutResource() {
        return 2130905717;
    }

    public void setSsoSessionInfo(FirstPartySsoSessionInfo firstPartySsoSessionInfo) {
        String replace = firstPartySsoSessionInfo.b.replace(' ', ' ');
        Resources resources = getResources();
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(resources);
        styledStringBuilder.a(resources.getString(2131230860));
        styledStringBuilder.a("[[name]]", replace, null, 33);
        this.loginButton.setText(styledStringBuilder.b());
        CustomUrlLikeSpan customUrlLikeSpan = new CustomUrlLikeSpan();
        customUrlLikeSpan.a = new C04382(this);
        styledStringBuilder = new StyledStringBuilder(resources);
        styledStringBuilder.a(customUrlLikeSpan, 33);
        styledStringBuilder.a(resources.getString(2131230861));
        styledStringBuilder.a();
        this.loginText.setText(styledStringBuilder.b());
        this.loginText.setSaveEnabled(false);
    }

    public void onSsoSuccess() {
    }

    public void onSsoFailure(@Nullable ServiceException serviceException) {
    }
}
