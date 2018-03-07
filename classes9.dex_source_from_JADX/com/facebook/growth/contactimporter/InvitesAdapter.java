package com.facebook.growth.contactimporter;

import android.content.Context;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.common.locale.Locales;
import com.facebook.growth.contactimporter.BaseInvitesAdapter.FirstLetterFriendSection;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger;
import com.facebook.inject.Assisted;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.ipc.model.FacebookPhonebookContact;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: paymentRequestsQueryType */
public class InvitesAdapter extends BaseInvitesAdapter {
    private GrowthUtils f7107s;
    private Spanned f7108t;
    private boolean f7109u = this.f7107s.m7386b();
    private boolean f7110v;

    public final /* bridge */ /* synthetic */ View mo277a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        return super.mo277a(i, i2, z, view, viewGroup);
    }

    @Inject
    public InvitesAdapter(FriendFinderAnalyticsLogger friendFinderAnalyticsLogger, GrowthUtils growthUtils, ListeningScheduledExecutorService listeningScheduledExecutorService, Locales locales, @Assisted Context context, @Assisted CIFlow cIFlow, @Assisted Map<Long, FacebookPhonebookContact> map, @Assisted Spanned spanned, @Assisted long j, @Assisted SendInviteClient sendInviteClient, @Assisted SendInviteLogger sendInviteLogger) {
        super(context, cIFlow, sendInviteClient, sendInviteLogger, friendFinderAnalyticsLogger, map, j, listeningScheduledExecutorService, locales);
        this.f7107s = growthUtils;
        this.f7108t = spanned;
    }

    public final View mo278a(int i, View view, ViewGroup viewGroup) {
        if (!this.f7109u) {
            return super.mo278a(i, view, viewGroup);
        }
        if (i == 0) {
            if (!this.f7110v) {
                this.f7110v = true;
                this.f7107s.m7385a();
            }
            if (view == null || !(view instanceof LinearLayout)) {
                view = this.f7096l.inflate(2130904372, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(2131562072);
            textView.setText(this.f7108t);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            ((TextView) view.findViewById(2131562531)).setText(((FirstLetterFriendSection) this.f7088d.get(i)).toString());
            return view;
        } else if (view == null || (view instanceof TextView)) {
            return super.mo278a(i, view, viewGroup);
        } else {
            return super.mo278a(i, null, null);
        }
    }

    protected final void mo279a(View view) {
        view.findViewById(2131561876).setVisibility(8);
    }

    protected final String mo280d() {
        return this.f7089e.getString(2131236381);
    }

    protected final long mo276a(FacebookPhonebookContact facebookPhonebookContact) {
        return facebookPhonebookContact.recordId;
    }

    protected final String mo281h() {
        return this.f7089e.getString(2131236383);
    }
}
