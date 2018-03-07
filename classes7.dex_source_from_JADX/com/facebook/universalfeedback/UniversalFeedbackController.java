package com.facebook.universalfeedback;

import android.support.v4.app.FragmentManager;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.calls.UniversalFeedbackGiveFeedbackInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.universalfeedback.graphql.UniversalFeedbackSubmissionMutationModels.FBUniversalFeedbackSubmissionMutationFragmentModel;
import com.facebook.universalfeedback.ui.UniversalFeedbackDialogFragment;
import com.facebook.universalfeedback.ui.UniversalFeedbackUIController;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ego */
public class UniversalFeedbackController {
    static final String f15346a = UniversalFeedbackController.class.getSimpleName();
    public final GraphQLQueryExecutor f15347b;
    public final Provider<Boolean> f15348c;
    public final ExecutorService f15349d;
    public final Provider<String> f15350e;
    public UniversalFeedbackUIController f15351f;
    public final C11541 f15352g = new C11541(this);
    public UniversalFeedbackGiveFeedbackInputData f15353h;
    public int f15354i;
    public String f15355j;
    public ResultListener f15356k;

    /* compiled from: ego */
    public class C11541 {
        public final /* synthetic */ UniversalFeedbackController f15345a;

        /* compiled from: ego */
        public class C11531 implements FutureCallback<GraphQLResult<FBUniversalFeedbackSubmissionMutationFragmentModel>> {
            final /* synthetic */ C11541 f15344a;

            public C11531(C11541 c11541) {
                this.f15344a = c11541;
            }

            public void onSuccess(@Nullable Object obj) {
                Integer.valueOf(this.f15344a.f15345a.f15354i);
                String str = this.f15344a.f15345a.f15355j;
            }

            public void onFailure(Throwable th) {
                BLog.b(UniversalFeedbackController.class, "UF mutation failure: %d, '%s'", new Object[]{Integer.valueOf(this.f15344a.f15345a.f15354i), this.f15344a.f15345a.f15355j});
            }
        }

        C11541(UniversalFeedbackController universalFeedbackController) {
            this.f15345a = universalFeedbackController;
        }

        public final void m19347c() {
            if (this.f15345a.f15356k != null) {
                this.f15345a.f15356k.mo1189b();
            }
        }
    }

    /* compiled from: ego */
    public interface ResultListener {
        void mo1188a();

        void mo1189b();
    }

    public static UniversalFeedbackController m19350b(InjectorLike injectorLike) {
        return new UniversalFeedbackController(new UniversalFeedbackUIController(), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), IdBasedProvider.a(injectorLike, 4361));
    }

    @Inject
    public UniversalFeedbackController(UniversalFeedbackUIController universalFeedbackUIController, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, Provider<String> provider, Provider<Boolean> provider2) {
        this.f15351f = universalFeedbackUIController;
        this.f15347b = graphQLQueryExecutor;
        this.f15349d = executorService;
        this.f15350e = provider;
        this.f15348c = provider2;
    }

    public final void m19351a(UniversalFeedbackContextBuilder universalFeedbackContextBuilder, FragmentManager fragmentManager) {
        if (((Boolean) this.f15348c.get()).booleanValue()) {
            UniversalFeedbackGiveFeedbackInputData universalFeedbackGiveFeedbackInputData = new UniversalFeedbackGiveFeedbackInputData();
            universalFeedbackGiveFeedbackInputData.a("experience_type", universalFeedbackContextBuilder.f15341a);
            universalFeedbackGiveFeedbackInputData.a("delivery_type", universalFeedbackContextBuilder.f15342b);
            if (universalFeedbackContextBuilder.f15343c != null) {
                universalFeedbackGiveFeedbackInputData.a("negative_feedback_node_token", universalFeedbackContextBuilder.f15343c);
            }
            this.f15353h = universalFeedbackGiveFeedbackInputData;
            this.f15351f.f15397a = this.f15352g;
            UniversalFeedbackUIController universalFeedbackUIController = this.f15351f;
            universalFeedbackUIController.f15400d = new UniversalFeedbackDialogFragment();
            universalFeedbackUIController.f15400d.am = universalFeedbackUIController;
            universalFeedbackUIController.f15400d.a(2, 0);
            universalFeedbackUIController.f15400d.a(fragmentManager, "UniversalFeedbackDialogFragment");
            return;
        }
        this.f15352g.m19347c();
    }
}
