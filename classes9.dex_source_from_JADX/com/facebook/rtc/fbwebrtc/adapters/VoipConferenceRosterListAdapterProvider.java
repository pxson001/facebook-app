package com.facebook.rtc.fbwebrtc.adapters;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.messaging.badges.BadgesExperimentController;
import com.facebook.messaging.util.launchtimeline.LaunchTimelineHelper;
import com.facebook.rtc.ContactFetcherMethodAutoProvider;
import com.facebook.rtc.models.RtcConferenceParticipantInfo;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.ExecutorService;

/* compiled from: application/xhtml+xml */
public class VoipConferenceRosterListAdapterProvider extends AbstractAssistedProvider<VoipConferenceRosterListAdapter> {
    public final VoipConferenceRosterListAdapter m19503a(ImmutableList<RtcConferenceParticipantInfo> immutableList, FragmentManager fragmentManager) {
        VoipConferenceRosterListAdapter voipConferenceRosterListAdapter = new VoipConferenceRosterListAdapter((Context) getInstance(Context.class), ContactFetcherMethodAutoProvider.m19085a(this), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), GatekeeperStoreImplMethodAutoProvider.a(this), LaunchTimelineHelper.m18337b(this), immutableList, fragmentManager);
        BadgesExperimentController b = BadgesExperimentController.m8365b(this);
        voipConferenceRosterListAdapter.f19627l = IdBasedLazy.a(this, 10375);
        voipConferenceRosterListAdapter.f19628m = b;
        return voipConferenceRosterListAdapter;
    }
}
