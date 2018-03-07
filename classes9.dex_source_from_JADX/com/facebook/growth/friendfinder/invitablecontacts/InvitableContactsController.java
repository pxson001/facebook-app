package com.facebook.growth.friendfinder.invitablecontacts;

import android.support.v7.widget.RecyclerView.Adapter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.friends.FriendingClient;
import com.facebook.growth.contactimporter.SendInviteClientProvider;
import com.facebook.growth.friendfinder.invitablecontacts.InvitableContactsCandidate.InviteState;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger;
import com.facebook.growth.logging.FriendFinderAnalyticsLogger.ApiType;
import com.facebook.inject.Assisted;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: page_like_promotion_key */
public class InvitableContactsController {
    public final FriendFinderAnalyticsLogger f7359a;
    public final FriendingClient f7360b;
    public final SendInviteClientProvider f7361c;
    public final TasksManager f7362d;
    public final Toaster f7363e;
    public final ListeningScheduledExecutorService f7364f;
    public final Map<Long, ListenableFuture<?>> f7365g = new HashMap();
    public final CIFlow f7366h;
    private final Adapter f7367i;

    /* compiled from: page_like_promotion_key */
    public class C07932 extends AbstractDisposableFutureCallback<Void> {
        final /* synthetic */ InvitableContactsCandidate f7356a;
        final /* synthetic */ InvitableContactsController f7357b;

        public C07932(InvitableContactsController invitableContactsController, InvitableContactsCandidate invitableContactsCandidate) {
            this.f7357b = invitableContactsController;
            this.f7356a = invitableContactsCandidate;
        }

        public final void m7692a(@Nullable Object obj) {
            InvitableContactsController.m7694a(this.f7357b, this.f7356a, InviteState.INVITED);
        }

        public final void m7693a(Throwable th) {
            this.f7357b.f7363e.b(new ToastBuilder(2131230758));
            InvitableContactsController.m7694a(this.f7357b, this.f7356a, InviteState.UNINVITED);
        }
    }

    private void m7695d(InvitableContactsCandidate invitableContactsCandidate) {
        long j = invitableContactsCandidate.f7348a;
        if (this.f7365g.containsKey(Long.valueOf(j))) {
            ListenableFuture listenableFuture = (ListenableFuture) this.f7365g.get(Long.valueOf(j));
            if (listenableFuture != null) {
                listenableFuture.cancel(true);
            }
            this.f7365g.remove(Long.valueOf(j));
            this.f7359a.b(this.f7366h.value, ApiType.INVITABLE_CONTACTS_API);
        }
        m7694a(this, invitableContactsCandidate, InviteState.UNINVITED);
    }

    public static void m7694a(InvitableContactsController invitableContactsController, InvitableContactsCandidate invitableContactsCandidate, InviteState inviteState) {
        invitableContactsCandidate.f7352e = inviteState;
        invitableContactsController.f7367i.notifyDataSetChanged();
    }

    @Inject
    public InvitableContactsController(FriendFinderAnalyticsLogger friendFinderAnalyticsLogger, FriendingClient friendingClient, SendInviteClientProvider sendInviteClientProvider, TasksManager tasksManager, Toaster toaster, ListeningScheduledExecutorService listeningScheduledExecutorService, @Assisted CIFlow cIFlow, @Assisted Adapter adapter) {
        this.f7359a = friendFinderAnalyticsLogger;
        this.f7360b = friendingClient;
        this.f7361c = sendInviteClientProvider;
        this.f7362d = tasksManager;
        this.f7363e = toaster;
        this.f7364f = listeningScheduledExecutorService;
        this.f7366h = cIFlow;
        this.f7367i = adapter;
    }

    public final void m7696a(final InvitableContactsCandidate invitableContactsCandidate) {
        switch (invitableContactsCandidate.f7352e) {
            case UNINVITED:
                final long j = invitableContactsCandidate.f7348a;
                if (!this.f7365g.containsKey(Long.valueOf(j))) {
                    this.f7365g.put(Long.valueOf(j), this.f7364f.a(new Runnable(this) {
                        final /* synthetic */ InvitableContactsController f7355c;

                        public void run() {
                            this.f7355c.f7365g.remove(Long.valueOf(j));
                            InvitableContactsController invitableContactsController = this.f7355c;
                            InvitableContactsCandidate invitableContactsCandidate = invitableContactsCandidate;
                            if (invitableContactsCandidate.f7352e == InviteState.PENDING_CAN_UNDO) {
                                invitableContactsController.f7362d.b(invitableContactsCandidate.f7350c, invitableContactsController.f7360b.a(invitableContactsCandidate.f7350c, invitableContactsCandidate.f7351d, invitableContactsCandidate.f7349b, String.valueOf(invitableContactsCandidate.f7348a)), new C07932(invitableContactsController, invitableContactsCandidate));
                            }
                            InvitableContactsController.m7694a(this.f7355c, invitableContactsCandidate, InviteState.PENDING_CANNOT_UNDO);
                        }
                    }, 4, TimeUnit.SECONDS));
                    this.f7359a.a(this.f7366h.value, ApiType.INVITABLE_CONTACTS_API);
                }
                m7694a(this, invitableContactsCandidate, InviteState.PENDING_CAN_UNDO);
                return;
            case PENDING_CAN_UNDO:
                m7695d(invitableContactsCandidate);
                return;
            default:
                return;
        }
    }
}
