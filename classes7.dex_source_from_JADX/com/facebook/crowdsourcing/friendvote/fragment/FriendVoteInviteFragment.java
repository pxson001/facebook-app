package com.facebook.crowdsourcing.friendvote.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.crowdsourcing.friendvote.graphql.CrowdsourcingFriendVoteMutations.CrowdsourcingFriendVoteInviteString;
import com.facebook.crowdsourcing.friendvote.graphql.CrowdsourcingFriendVoteMutationsModels.CrowdsourcingFriendVoteInviteModel;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.graphql.calls.CrowdsourcingFriendVoteInviteInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.offlinemode.common.OfflineQueryBehavior;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.friendselector.GenericFriendsSelectorFragment;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: com.facebook.timeline.TimelineFragment */
public class FriendVoteInviteFragment extends GenericFriendsSelectorFragment {
    @Inject
    public AbstractFbErrorReporter au;
    @Inject
    public GraphQLQueryExecutor av;
    @Inject
    public TasksManager aw;
    @Inject
    public Toaster ax;
    public final String ay = FriendVoteInviteFragment.class.getSimpleName();
    private String az;

    /* compiled from: com.facebook.timeline.TimelineFragment */
    class C14301 extends AbstractDisposableFutureCallback<GraphQLResult<CrowdsourcingFriendVoteInviteModel>> {
        final /* synthetic */ FriendVoteInviteFragment f17415a;

        C14301(FriendVoteInviteFragment friendVoteInviteFragment) {
            this.f17415a = friendVoteInviteFragment;
        }

        protected final void m21310a(Throwable th) {
            this.f17415a.ax.a(new ToastBuilder(this.f17415a.jW_().getString(2131230761)));
            this.f17415a.au.a(this.f17415a.ay, "FriendVote inviter GraphQL mutation failed");
        }
    }

    /* compiled from: com.facebook.timeline.TimelineFragment */
    public class C14312 implements OnClickListener {
        final /* synthetic */ FriendVoteInviteFragment f17416a;

        public C14312(FriendVoteInviteFragment friendVoteInviteFragment) {
            this.f17416a = friendVoteInviteFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f17416a.aI();
        }
    }

    /* compiled from: com.facebook.timeline.TimelineFragment */
    public class PostFriendVoteInviteDialog extends CustomLinearLayout {
        public PostFriendVoteInviteDialog(Context context, String str, String str2) {
            super(context);
            setContentView(2130906351);
            FbTextView fbTextView = (FbTextView) a(2131566191);
            ((FbTextView) a(2131566190)).setText(str);
            fbTextView.setText(str2);
        }
    }

    public static void m21311a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FriendVoteInviteFragment friendVoteInviteFragment = (FriendVoteInviteFragment) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        GraphQLQueryExecutor a = GraphQLQueryExecutor.a(fbInjector);
        TasksManager b = TasksManager.b(fbInjector);
        Toaster b2 = Toaster.b(fbInjector);
        friendVoteInviteFragment.au = abstractFbErrorReporter;
        friendVoteInviteFragment.av = a;
        friendVoteInviteFragment.aw = b;
        friendVoteInviteFragment.ax = b2;
    }

    public final void mo321c(Bundle bundle) {
        Class cls = FriendVoteInviteFragment.class;
        m21311a(this, getContext());
        super.mo321c(bundle);
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.az = bundle2.getString("com.facebook.katana.profile.id");
        }
        if (bundle2 == null || Strings.isNullOrEmpty(this.az)) {
            this.au.a(this.ay, "FriendVote inviter launched without specifying Page ID");
        }
    }

    protected final void aH() {
        ImmutableList ax = ax();
        GraphQlQueryString crowdsourcingFriendVoteInviteString = new CrowdsourcingFriendVoteInviteString();
        CrowdsourcingFriendVoteInviteInputData crowdsourcingFriendVoteInviteInputData = new CrowdsourcingFriendVoteInviteInputData();
        crowdsourcingFriendVoteInviteInputData.a("place_id", this.az);
        GraphQlCallInput graphQlCallInput = crowdsourcingFriendVoteInviteInputData;
        graphQlCallInput.a("friend_ids", ax);
        crowdsourcingFriendVoteInviteString.a("input", graphQlCallInput);
        MutationRequest a = GraphQLRequest.a(crowdsourcingFriendVoteInviteString);
        int size = ax.size();
        Builder builder = new Builder(getContext());
        builder.b(new PostFriendVoteInviteDialog(getContext(), jW_().getQuantityString(2131689728, size), jW_().getQuantityString(2131689729, size))).a(false).c(2131230726, new C14312(this));
        builder.a().show();
        this.aw.a("key_send_invite", this.av.a(a, OfflineQueryBehavior.b), new C14301(this));
    }
}
