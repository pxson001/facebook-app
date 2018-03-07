package com.facebook.privacy.checkup.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.enums.GraphQLEditablePrivacyScopeType;
import com.facebook.graphql.enums.GraphQLPrivacyCheckupActionType;
import com.facebook.inject.Assisted;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupItemRow;
import com.facebook.privacy.checkup.service.PrivacyCheckupAnalyticsLogger;
import com.facebook.privacy.checkup.ui.PrivacyCheckupStepAdapter.PrivacyCheckupActionCallbackInterface;
import com.facebook.privacy.spinner.AudienceSpinner;
import com.facebook.privacy.ui.PrivacyOptionView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Set AlbumViewHolder with null onClickAlbumListener as View.OnClickListener */
public class PrivacyCheckupComposerStepAdapter extends PrivacyCheckupStepAdapter {
    public OnClickListener f11116c;
    @Nullable
    public String f11117d;
    @Nullable
    public GraphQLEditablePrivacyScopeType f11118e;

    @Inject
    public PrivacyCheckupComposerStepAdapter(LayoutInflater layoutInflater, Resources resources, Context context, PrivacyCheckupAnalyticsLogger privacyCheckupAnalyticsLogger, @Assisted PrivacyCheckupActionCallbackInterface privacyCheckupActionCallbackInterface, @Assisted PrivacyCheckupStepData privacyCheckupStepData) {
        super(layoutInflater, resources, context, privacyCheckupAnalyticsLogger, privacyCheckupActionCallbackInterface, privacyCheckupStepData);
    }

    protected final void mo293a(View view, PrivacyCheckupItemRow privacyCheckupItemRow) {
        m11505b(view, privacyCheckupItemRow);
        AudienceSpinner audienceSpinner = (AudienceSpinner) view.findViewById(2131566225);
        PrivacyOptionView privacyOptionView = (PrivacyOptionView) view.findViewById(2131566226);
        privacyOptionView.setVisibility(0);
        audienceSpinner.setVisibility(8);
        privacyOptionView.setBackgroundResource(0);
        if (this.f11106a.mo301c() == null || !this.f11107b.f10968d.contains(GraphQLPrivacyCheckupActionType.CHANGE_PRIVACY)) {
            privacyOptionView.a(privacyCheckupItemRow.f10962g, privacyCheckupItemRow.f10963h);
            privacyOptionView.setOnClickListener(null);
            this.f11117d = null;
            this.f11118e = null;
            return;
        }
        privacyOptionView.c = true;
        privacyOptionView.setPrivacyOption(this.f11106a.mo301c().d);
        privacyOptionView.setOnClickListener(this.f11116c);
        this.f11117d = privacyCheckupItemRow.f10956a;
        this.f11118e = privacyCheckupItemRow.f10957b;
    }
}
