package com.facebook.growth.contactimporter;

import android.content.Context;
import android.text.Spanned;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.locale.Locales;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.ipc.model.FacebookPhonebookContact;
import java.util.Map;

/* compiled from: paymentRequests */
public class InvitesAdapterProvider extends AbstractAssistedProvider<InvitesAdapter> {
    public final InvitesAdapter m7393a(Context context, CIFlow cIFlow, Map<Long, FacebookPhonebookContact> map, Spanned spanned, long j, SendInviteClient sendInviteClient, SendInviteLogger sendInviteLogger) {
        return new InvitesAdapter(FriendFinderAnalyticsLogger.a(this), GrowthUtils.m7382a((InjectorLike) this), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), Locales.a(this), context, cIFlow, map, spanned, j, sendInviteClient, sendInviteLogger);
    }
}
