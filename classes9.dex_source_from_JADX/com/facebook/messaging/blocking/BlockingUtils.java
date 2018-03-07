package com.facebook.messaging.blocking;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import com.facebook.api.reportable_entity.NegativeFeedbackActionOnReportableEntityMethod.Params;
import com.facebook.api.reportable_entity.NegativeFeedbackActionOnReportableEntityMethod.ParamsBuilder;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.graphql.calls.MessengerCommerceUserControlActionInputData;
import com.facebook.graphql.calls.MessengerCommerceUserControlActionInputData.UserAction;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.blocking.ManageBlockingFragmentController.C09364;
import com.facebook.messaging.blocking.annotations.IsBlockeeExperienceEnabled;
import com.facebook.messaging.blocking.graphql.BlockingMutations.MessengerCommerceUserControlActionString;
import com.facebook.messaging.blocking.graphql.BlockingMutationsModels.MessengerCommerceUserControlActionModel;
import com.facebook.messaging.business.subscription.common.utils.BusinessSubscriptionMutationHelper;
import com.facebook.messaging.business.subscription.common.utils.BusinessSubscriptionMutationHelper.SubscribeCallback;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: onScrollEndDrag */
public class BlockingUtils {
    public static final Uri f8256a = Uri.parse("https://www.facebook.com/help/389645087895231");
    private DefaultBlueServiceOperationFactory f8257b;
    private ListeningExecutorService f8258c;
    @IsBlockeeExperienceEnabled
    public Provider<Boolean> f8259d;
    public ErrorDialogs f8260e;
    public Context f8261f;
    private GraphQLQueryExecutor f8262g;
    private ExecutorService f8263h;
    public BusinessSubscriptionMutationHelper f8264i;

    /* compiled from: onScrollEndDrag */
    public class C09301 implements SubscribeCallback {
        final /* synthetic */ C09364 f8250a;
        final /* synthetic */ BlockingUtils f8251b;

        public C09301(BlockingUtils blockingUtils, C09364 c09364) {
            this.f8251b = blockingUtils;
            this.f8250a = c09364;
        }

        public final void m8503a() {
            this.f8250a.m8529a();
        }

        public final void m8504b() {
            this.f8250a.m8530b();
        }
    }

    /* compiled from: onScrollEndDrag */
    public class C09312 {
        public final /* synthetic */ C09364 f8252a;
        final /* synthetic */ BlockingUtils f8253b;

        public C09312(BlockingUtils blockingUtils, C09364 c09364) {
            this.f8253b = blockingUtils;
            this.f8252a = c09364;
        }

        public final void m8505b() {
            this.f8252a.m8530b();
        }
    }

    public static BlockingUtils m8514b(InjectorLike injectorLike) {
        return new BlockingUtils(DefaultBlueServiceOperationFactory.b(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4111), ErrorDialogs.a(injectorLike), (Context) injectorLike.getInstance(Context.class), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), BusinessSubscriptionMutationHelper.b(injectorLike));
    }

    public static BlockingUtils m8507a(InjectorLike injectorLike) {
        return m8514b(injectorLike);
    }

    private void m8510a(MessengerCommerceUserControlActionInputData messengerCommerceUserControlActionInputData, final C09364 c09364) {
        GraphQlQueryString messengerCommerceUserControlActionString = new MessengerCommerceUserControlActionString();
        messengerCommerceUserControlActionString.a("input", messengerCommerceUserControlActionInputData);
        Futures.a(this.f8262g.a(GraphQLRequest.a(messengerCommerceUserControlActionString)), new FutureCallback<GraphQLResult<MessengerCommerceUserControlActionModel>>(this) {
            final /* synthetic */ BlockingUtils f8255b;

            public void onSuccess(@Nullable Object obj) {
                c09364.m8529a();
            }

            public void onFailure(Throwable th) {
                c09364.m8530b();
            }
        }, this.f8263h);
    }

    @Inject
    public BlockingUtils(BlueServiceOperationFactory blueServiceOperationFactory, ListeningExecutorService listeningExecutorService, Provider<Boolean> provider, ErrorDialogs errorDialogs, Context context, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, BusinessSubscriptionMutationHelper businessSubscriptionMutationHelper) {
        this.f8257b = blueServiceOperationFactory;
        this.f8258c = listeningExecutorService;
        this.f8259d = provider;
        this.f8260e = errorDialogs;
        this.f8261f = context;
        this.f8262g = graphQLQueryExecutor;
        this.f8263h = executorService;
        this.f8264i = businessSubscriptionMutationHelper;
    }

    public static String m8508a(User user) {
        if (StringUtil.a(user.h())) {
            return user.j();
        }
        return user.h();
    }

    public final void m8516a(String str, OperationResultFutureCallback operationResultFutureCallback) {
        m8511a(str, false, operationResultFutureCallback);
    }

    public final void m8519b(String str, OperationResultFutureCallback operationResultFutureCallback) {
        m8511a(str, true, operationResultFutureCallback);
    }

    public final void m8517a(String str, C09364 c09364) {
        MessengerCommerceUserControlActionInputData messengerCommerceUserControlActionInputData = new MessengerCommerceUserControlActionInputData();
        messengerCommerceUserControlActionInputData.a(str);
        messengerCommerceUserControlActionInputData.a(UserAction.BLOCK_PROMOTION);
        m8510a(messengerCommerceUserControlActionInputData, c09364);
    }

    public final void m8520b(String str, C09364 c09364) {
        MessengerCommerceUserControlActionInputData messengerCommerceUserControlActionInputData = new MessengerCommerceUserControlActionInputData();
        messengerCommerceUserControlActionInputData.a(str);
        messengerCommerceUserControlActionInputData.a(UserAction.UNBLOCK_PROMOTION);
        m8510a(messengerCommerceUserControlActionInputData, c09364);
    }

    public final void m8521c(String str, OperationResultFutureCallback operationResultFutureCallback) {
        m8515b(str, true, operationResultFutureCallback);
    }

    private void m8511a(String str, boolean z, OperationResultFutureCallback operationResultFutureCallback) {
        Futures.a(m8506a(str, z).a(), operationResultFutureCallback, this.f8258c);
    }

    private void m8515b(String str, boolean z, OperationResultFutureCallback operationResultFutureCallback) {
        String string;
        Operation a = m8506a(str, z);
        if (z) {
            string = this.f8261f.getResources().getString(2131240241);
        } else {
            string = this.f8261f.getResources().getString(2131240242);
        }
        a.a(new DialogBasedProgressIndicator(this.f8261f, string));
        Futures.a(a.a(), operationResultFutureCallback, this.f8258c);
    }

    private Operation m8506a(String str, boolean z) {
        ParamsBuilder paramsBuilder = new ParamsBuilder();
        paramsBuilder.a = GraphQLNegativeFeedbackActionType.BLOCK_MESSAGES;
        paramsBuilder = paramsBuilder;
        paramsBuilder.c = NegativeFeedbackExperienceLocation.MESSENGER.stringValueOf();
        paramsBuilder = paramsBuilder;
        paramsBuilder.b = str;
        paramsBuilder = paramsBuilder;
        paramsBuilder.d = Boolean.valueOf(z);
        Parcelable params = new Params(paramsBuilder);
        Bundle bundle = new Bundle();
        bundle.putParcelable("negativeFeedbackActionOnReportableEntityParams", params);
        return BlueServiceOperationFactoryDetour.a(this.f8257b, "negative_feedback_action_on_reportable_entity", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(ManageBlockingFragmentController.class), 881915494);
    }

    public static boolean m8513a(@Nullable User user, FragmentManager fragmentManager) {
        if (user == null || !user.I) {
            return false;
        }
        AskToUnblockDialogFragment askToUnblockDialogFragment = new AskToUnblockDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("blockee", user);
        askToUnblockDialogFragment.g(bundle);
        askToUnblockDialogFragment.a(fragmentManager, "askToUnblockDialog");
        return true;
    }

    public static boolean m8512a(ThreadSummary threadSummary) {
        if (threadSummary == null) {
            return true;
        }
        return threadSummary.u;
    }

    private void m8509a(int i) {
        String string = this.f8261f.getResources().getString(i);
        ErrorDialogs errorDialogs = this.f8260e;
        ErrorDialogParamsBuilder a = ErrorDialogParams.a(this.f8261f);
        a.c = string;
        errorDialogs.a(a.l());
    }

    public final boolean m8518a(ImmutableList<User> immutableList, FragmentManager fragmentManager) {
        if (immutableList.isEmpty()) {
            return false;
        }
        User user = null;
        int size = immutableList.size();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < size) {
            int i5;
            User user2 = (User) immutableList.get(i);
            if (user2.I) {
                i4++;
                if (user == null) {
                    i5 = i2;
                    i2 = i3;
                    i3 = i4;
                }
                user2 = user;
                i5 = i2;
                i2 = i3;
                i3 = i4;
            } else if (user2.H) {
                r0 = i3 + 1;
                i3 = i4;
                int i6 = i2;
                i2 = r0;
                user2 = user;
                i5 = i6;
            } else {
                if (!user2.K) {
                    r0 = i2 + 1;
                    i2 = i3;
                    i3 = i4;
                    User user3 = user;
                    i5 = r0;
                    user2 = user3;
                }
                user2 = user;
                i5 = i2;
                i2 = i3;
                i3 = i4;
            }
            i++;
            i4 = i3;
            i3 = i2;
            i2 = i5;
            user = user2;
        }
        if (i4 == 0 && i3 == 0 && i2 == 0) {
            return false;
        }
        if (i4 == 1 && i3 == 0 && i2 == 0) {
            if (m8513a(user, fragmentManager)) {
                return true;
            }
            return false;
        } else if (i4 > 1 && i3 == 0 && i2 == 0) {
            m8509a(2131240243);
            return true;
        } else {
            m8509a(2131240244);
            return true;
        }
    }
}
