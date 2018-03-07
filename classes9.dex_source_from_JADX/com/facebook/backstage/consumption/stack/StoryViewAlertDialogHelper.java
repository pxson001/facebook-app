package com.facebook.backstage.consumption.stack;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.backstage.consumption.BackstageNavigatorApi.Action;
import com.facebook.backstage.consumption.BackstageNavigatorApi.NavigationState;
import com.facebook.backstage.consumption.SimpleAnimationHelper.AnimationType;
import com.facebook.backstage.consumption.stack.BackstageStoryModeController.C05304.C05291;
import com.facebook.backstage.graphql.BackstagePostDeletionHelper;
import com.facebook.backstage.graphql.BackstagePostDeletionHelper.C05581;
import com.facebook.backstage.graphql.FBBackstageMutationFragments.FBBackstagePostsDeleteMutationString;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.graphql.calls.BackstagePostsDeleteInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: results_were_received */
public class StoryViewAlertDialogHelper {
    public final Context f5076a;
    public final BackstagePostDeletionHelper f5077b;

    /* compiled from: results_were_received */
    public class C05441 implements OnClickListener {
        final /* synthetic */ ProgressDialog f5069a;
        final /* synthetic */ String f5070b;
        final /* synthetic */ C05291 f5071c;
        final /* synthetic */ StoryViewAlertDialogHelper f5072d;

        /* compiled from: results_were_received */
        public class C05431 {
            final /* synthetic */ C05441 f5068a;

            C05431(C05441 c05441) {
                this.f5068a = c05441;
            }

            public final void m4872a(boolean z) {
                this.f5068a.f5069a.hide();
                if (z) {
                    C05291 c05291 = this.f5068a.f5071c;
                    c05291.f4993a.f4994a.f5014K.m4562b(AnimationType.SLIDE_FROM_RIGHT);
                    c05291.f4993a.f4994a.f5017d.m4493a(NavigationState.COLD_START, NavigationState.MAIN_LIST, Action.REFRESH);
                }
            }
        }

        public C05441(StoryViewAlertDialogHelper storyViewAlertDialogHelper, ProgressDialog progressDialog, String str, C05291 c05291) {
            this.f5072d = storyViewAlertDialogHelper;
            this.f5069a = progressDialog;
            this.f5070b = str;
            this.f5071c = c05291;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5069a.show();
            BackstagePostDeletionHelper backstagePostDeletionHelper = this.f5072d.f5077b;
            String str = this.f5070b;
            C05431 c05431 = new C05431(this);
            List arrayList = new ArrayList(1);
            arrayList.add(str);
            GraphQlQueryString fBBackstagePostsDeleteMutationString = new FBBackstagePostsDeleteMutationString();
            BackstagePostsDeleteInputData backstagePostsDeleteInputData = new BackstagePostsDeleteInputData();
            backstagePostsDeleteInputData.a("actor_id", (String) backstagePostDeletionHelper.f5217d.get());
            GraphQlCallInput graphQlCallInput = backstagePostsDeleteInputData;
            graphQlCallInput.a("post_fbids", arrayList);
            graphQlCallInput = graphQlCallInput;
            graphQlCallInput.a("client_mutation_id", fBBackstagePostsDeleteMutationString.d);
            fBBackstagePostsDeleteMutationString.a("0", graphQlCallInput);
            Futures.a(backstagePostDeletionHelper.f5216c.a(GraphQLRequest.a(fBBackstagePostsDeleteMutationString)), new C05581(backstagePostDeletionHelper, c05431), backstagePostDeletionHelper.f5215b);
        }
    }

    /* compiled from: results_were_received */
    public class C05452 implements OnClickListener {
        final /* synthetic */ AlertDialog f5073a;
        final /* synthetic */ C05291 f5074b;
        final /* synthetic */ StoryViewAlertDialogHelper f5075c;

        public C05452(StoryViewAlertDialogHelper storyViewAlertDialogHelper, AlertDialog alertDialog, C05291 c05291) {
            this.f5075c = storyViewAlertDialogHelper;
            this.f5073a = alertDialog;
            this.f5074b = c05291;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5073a.dismiss();
        }
    }

    public static StoryViewAlertDialogHelper m4873b(InjectorLike injectorLike) {
        return new StoryViewAlertDialogHelper((Context) injectorLike.getInstance(Context.class), new BackstagePostDeletionHelper((Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), IdBasedProvider.a(injectorLike, 4442)));
    }

    @Inject
    public StoryViewAlertDialogHelper(Context context, BackstagePostDeletionHelper backstagePostDeletionHelper) {
        this.f5076a = context;
        this.f5077b = backstagePostDeletionHelper;
    }
}
