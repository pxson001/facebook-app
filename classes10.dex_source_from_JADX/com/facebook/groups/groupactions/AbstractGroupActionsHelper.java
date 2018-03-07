package com.facebook.groups.groupactions;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.graphql.calls.GroupLeaveInputData.ReaddPolicy;
import com.facebook.graphql.enums.GraphQLGroupSubscriptionLevel;
import com.facebook.graphql.enums.GraphQLLeavingGroupScenario;
import com.facebook.groups.groupactions.GroupActionsHelper.onGroupActionLeaveListener;
import com.facebook.groups.groupsgrid.mutations.GroupLeaveDialogHelper;
import com.facebook.groups.info.DefaultGroupInfoClickHandler;
import com.facebook.groups.info.DefaultGroupInfoClickHandler.C32703;
import com.facebook.groups.info.DefaultGroupLeaveActionResponder;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.groups.settings.AbstractGroupSubscriptionController;
import com.facebook.groups.settings.GroupSubscriptionController;
import com.facebook.inject.Lazy;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: ThreadListFragment.onViewCreatedRecyclerView */
public abstract class AbstractGroupActionsHelper {
    private final DefaultAndroidThreadUtil f22560a;
    private final GroupsClient f22561b;
    public final Lazy<GroupSubscriptionController> f22562c;
    private final GroupLeaveDialogHelper f22563d;

    public abstract void mo989a(Uri uri, String str, String str2);

    public AbstractGroupActionsHelper(AndroidThreadUtil androidThreadUtil, GroupsClient groupsClient, Lazy<GroupSubscriptionController> lazy, GroupLeaveDialogHelper groupLeaveDialogHelper) {
        this.f22560a = androidThreadUtil;
        this.f22561b = groupsClient;
        this.f22562c = lazy;
        this.f22563d = groupLeaveDialogHelper;
    }

    public final void m23577a(Context context, FragmentManager fragmentManager, final GroupLeaveActionData groupLeaveActionData, @Nullable C32703 c32703) {
        GraphQLLeavingGroupScenario graphQLLeavingGroupScenario = groupLeaveActionData.f22569e;
        final FragmentManager fragmentManager2 = fragmentManager;
        final GroupLeaveActionData groupLeaveActionData2 = groupLeaveActionData;
        final Context context2 = context;
        final C32703 c327032 = c32703;
        C32641 c32641 = new OnClickListener(this) {
            final /* synthetic */ AbstractGroupActionsHelper f22547e;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f22547e.m23575a(fragmentManager2, groupLeaveActionData2, context2, c327032, ReaddPolicy.PREVENT_READD);
            }
        };
        final FragmentManager fragmentManager3 = fragmentManager;
        final GroupLeaveActionData groupLeaveActionData3 = groupLeaveActionData;
        final Context context3 = context;
        final C32703 c327033 = c32703;
        C32652 c32652 = new OnClickListener(this) {
            final /* synthetic */ AbstractGroupActionsHelper f22552e;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f22552e.m23575a(fragmentManager3, groupLeaveActionData3, context3, c327033, ReaddPolicy.ALLOW_READD);
            }
        };
        Context context4 = context;
        C32652 c326522 = c32652;
        C32641 c326412 = c32641;
        this.f22563d.a(context4, c326522, c326412, new OnClickListener(this) {
            final /* synthetic */ AbstractGroupActionsHelper f22554b;

            public void onClick(DialogInterface dialogInterface, int i) {
                AbstractGroupActionsHelper abstractGroupActionsHelper = this.f22554b;
                ((AbstractGroupSubscriptionController) abstractGroupActionsHelper.f22562c.get()).m24423a(groupLeaveActionData.f22565a, groupLeaveActionData.f22570f, GraphQLGroupSubscriptionLevel.OFF);
            }
        }, graphQLLeavingGroupScenario, groupLeaveActionData.f22566b);
    }

    private void m23575a(FragmentManager fragmentManager, GroupLeaveActionData groupLeaveActionData, Context context, C32703 c32703, ReaddPolicy readdPolicy) {
        DialogFragment a = GroupLeaveDialogHelper.a(fragmentManager, 2131237882);
        this.f22560a.a(this.f22561b.a(groupLeaveActionData.f22565a, groupLeaveActionData.f22571g, readdPolicy), m23574a(a, groupLeaveActionData, this.f22563d.a(context), c32703));
    }

    private FutureCallback<Void> m23574a(DialogFragment dialogFragment, GroupLeaveActionData groupLeaveActionData, Builder builder, onGroupActionLeaveListener com_facebook_groups_groupactions_GroupActionsHelper_onGroupActionLeaveListener) {
        final GroupLeaveActionData groupLeaveActionData2 = groupLeaveActionData;
        final DialogFragment dialogFragment2 = dialogFragment;
        final C32703 c32703 = com_facebook_groups_groupactions_GroupActionsHelper_onGroupActionLeaveListener;
        final Builder builder2 = builder;
        return new FutureCallback<Void>(this) {
            final /* synthetic */ AbstractGroupActionsHelper f22559e;

            public void onSuccess(Object obj) {
                GroupLeaveDialogHelper.a(dialogFragment2);
                if (c32703 != null) {
                    DefaultGroupLeaveActionResponder defaultGroupLeaveActionResponder = c32703.f22576a;
                    if (defaultGroupLeaveActionResponder.f22594b == null) {
                        defaultGroupLeaveActionResponder.f22595c.b(DefaultGroupLeaveActionResponder.f22593a, "fragment is null while responding to leave action");
                    } else if (!defaultGroupLeaveActionResponder.f22594b.L && defaultGroupLeaveActionResponder.f22594b.o() != null) {
                        defaultGroupLeaveActionResponder.f22594b.o().onBackPressed();
                    }
                }
            }

            public void onFailure(Throwable th) {
                GroupLeaveDialogHelper.a(dialogFragment2);
                builder2.a().show();
                if (c32703 != null) {
                    ((AbstractFbErrorReporter) c32703.f22577b.f22585g.get()).a(DefaultGroupInfoClickHandler.f22579a, "Group leave action failed.", th);
                }
            }
        };
    }
}
