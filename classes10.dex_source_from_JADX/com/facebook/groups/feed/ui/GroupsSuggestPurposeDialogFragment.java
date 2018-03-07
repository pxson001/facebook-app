package com.facebook.groups.feed.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.GroupEditInputData;
import com.facebook.graphql.calls.GroupEditInputData.GroupPurpose;
import com.facebook.graphql.calls.GroupEditInputData.Source;
import com.facebook.graphql.calls.ViewerGroupPurposeModalSeenInputData;
import com.facebook.graphql.calls.ViewerGroupPurposeModalSeenInputData.SeenGroupPurposesModal;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.groups.editsettings.protocol.FetchGroupEditSettings;
import com.facebook.groups.editsettings.protocol.FetchGroupEditSettings.FBGroupEditSettingsMutationString;
import com.facebook.groups.editsettings.protocol.FetchGroupEditSettingsModels.FBGroupEditSettingsMutationModel;
import com.facebook.groups.feed.ui.GroupsFeedFragment.C31938;
import com.facebook.groups.mutations.protocol.GroupMutations.FBGroupPurposeModalSeenCoreMutationString;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;

/* compiled from: ThreadViewMessagesAdapterUpdater_failed_patch */
public final class GroupsSuggestPurposeDialogFragment extends FbDialogFragment {
    public C31938 am;
    public String an;
    public String ao;
    public ExecutorService ap;
    public GraphQLQueryExecutor aq;

    /* compiled from: ThreadViewMessagesAdapterUpdater_failed_patch */
    class C32511 implements OnClickListener {
        final /* synthetic */ GroupsSuggestPurposeDialogFragment f22387a;

        C32511(GroupsSuggestPurposeDialogFragment groupsSuggestPurposeDialogFragment) {
            this.f22387a = groupsSuggestPurposeDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            GroupsSuggestPurposeDialogFragment groupsSuggestPurposeDialogFragment = this.f22387a;
            GroupPurpose groupPurpose = GroupPurpose.FOR_SALE;
            GroupEditInputData groupEditInputData = new GroupEditInputData();
            groupEditInputData.b(groupsSuggestPurposeDialogFragment.an).a(groupsSuggestPurposeDialogFragment.ao).a(groupPurpose).a(Source.SUGGESTED_PURPOSE_MODAL);
            Futures.a(groupsSuggestPurposeDialogFragment.aq.a(GraphQLRequest.a((FBGroupEditSettingsMutationString) FetchGroupEditSettings.m22645a().a("input", groupEditInputData))), new C32533(groupsSuggestPurposeDialogFragment, groupPurpose), groupsSuggestPurposeDialogFragment.ap);
        }
    }

    /* compiled from: ThreadViewMessagesAdapterUpdater_failed_patch */
    class C32522 implements OnClickListener {
        final /* synthetic */ GroupsSuggestPurposeDialogFragment f22388a;

        C32522(GroupsSuggestPurposeDialogFragment groupsSuggestPurposeDialogFragment) {
            this.f22388a = groupsSuggestPurposeDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f22388a.am != null) {
                C31938 c31938 = this.f22388a.am;
            }
        }
    }

    /* compiled from: ThreadViewMessagesAdapterUpdater_failed_patch */
    public class C32533 implements FutureCallback<GraphQLResult<FBGroupEditSettingsMutationModel>> {
        final /* synthetic */ GroupPurpose f22389a;
        final /* synthetic */ GroupsSuggestPurposeDialogFragment f22390b;

        public C32533(GroupsSuggestPurposeDialogFragment groupsSuggestPurposeDialogFragment, GroupPurpose groupPurpose) {
            this.f22390b = groupsSuggestPurposeDialogFragment;
            this.f22389a = groupPurpose;
        }

        public void onSuccess(Object obj) {
            if (this.f22390b.am != null) {
                GroupsFeedFragment.m23267h(this.f22390b.am.f22145a, true);
            }
        }

        public void onFailure(Throwable th) {
            if (this.f22390b.am != null) {
                C31938 c31938 = this.f22390b.am;
            }
        }
    }

    public static void m23447a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GroupsSuggestPurposeDialogFragment groupsSuggestPurposeDialogFragment = (GroupsSuggestPurposeDialogFragment) obj;
        ExecutorService executorService = (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector);
        String b = String_LoggedInUserIdMethodAutoProvider.b(fbInjector);
        GraphQLQueryExecutor a = GraphQLQueryExecutor.a(fbInjector);
        groupsSuggestPurposeDialogFragment.ao = b;
        groupsSuggestPurposeDialogFragment.ap = executorService;
        groupsSuggestPurposeDialogFragment.aq = a;
    }

    public final void m23448a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 486228921);
        super.a(bundle);
        Class cls = GroupsSuggestPurposeDialogFragment.class;
        m23447a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2041687571, a);
    }

    public final Dialog m23449c(Bundle bundle) {
        CharSequence b = b(2131238070);
        CharSequence b2 = b(2131238071);
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(getContext());
        fbAlertDialogBuilder.b(LayoutInflater.from(getContext()).inflate(2130906521, (ViewGroup) this.T));
        fbAlertDialogBuilder.a(b, new C32511(this));
        fbAlertDialogBuilder.b(b2, new C32522(this));
        ViewerGroupPurposeModalSeenInputData viewerGroupPurposeModalSeenInputData = new ViewerGroupPurposeModalSeenInputData();
        viewerGroupPurposeModalSeenInputData.a("group_id", this.an);
        GraphQlCallInput graphQlCallInput = viewerGroupPurposeModalSeenInputData;
        graphQlCallInput.a("actor_id", this.ao);
        graphQlCallInput.a("seen_group_purposes_modal", SeenGroupPurposesModal.TRUE);
        this.aq.a(GraphQLRequest.a((FBGroupPurposeModalSeenCoreMutationString) new FBGroupPurposeModalSeenCoreMutationString().a("input", viewerGroupPurposeModalSeenInputData)));
        return fbAlertDialogBuilder.b();
    }
}
