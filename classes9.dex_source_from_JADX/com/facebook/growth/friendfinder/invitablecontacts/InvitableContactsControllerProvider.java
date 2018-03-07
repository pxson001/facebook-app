package com.facebook.growth.friendfinder.invitablecontacts;

import android.support.v7.widget.RecyclerView.Adapter;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.friends.FriendingClient;
import com.facebook.growth.contactimporter.SendInviteClientProvider;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;

/* compiled from: page_actor_profile_picture_uri */
public class InvitableContactsControllerProvider extends AbstractAssistedProvider<InvitableContactsController> {
    public final InvitableContactsController m7697a(CIFlow cIFlow, Adapter adapter) {
        return new InvitableContactsController(FriendFinderAnalyticsLogger.a(this), FriendingClient.b(this), (SendInviteClientProvider) getOnDemandAssistedProviderForStaticDi(SendInviteClientProvider.class), TasksManager.b(this), Toaster.b(this), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), cIFlow, adapter);
    }
}
