package com.facebook.reviews.handler;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.pagesprotocol.DeletePageReviewParams;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.reviews.analytics.ReviewsLogger;
import com.facebook.reviews.event.ReviewEventBus;
import com.facebook.reviews.event.ReviewEvents;
import com.facebook.reviews.event.ReviewEvents.PageOverallRatingUpdatedEvent;
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsModels.PageOverallStarRatingModel;
import com.facebook.reviews.util.PageReviewLoader;
import com.facebook.reviews.util.PageReviewLoader.LoadPageOverallStarRatingCallback;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: Tried to set a review without a rating */
public class DeleteReviewHandler {
    private final DefaultBlueServiceOperationFactory f21618a;
    public final PageReviewLoader f21619b;
    public final ReviewEventBus f21620c;
    public final ReviewsLogger f21621d;
    private final TasksManager<String> f21622e;
    public final Toaster f21623f;

    /* compiled from: Tried to set a review without a rating */
    public class C23202 implements LoadPageOverallStarRatingCallback {
        final /* synthetic */ ProgressDialog f21614a;
        final /* synthetic */ String f21615b;
        final /* synthetic */ String f21616c;
        final /* synthetic */ DeleteReviewHandler f21617d;

        public C23202(DeleteReviewHandler deleteReviewHandler, ProgressDialog progressDialog, String str, String str2) {
            this.f21617d = deleteReviewHandler;
            this.f21614a = progressDialog;
            this.f21615b = str;
            this.f21616c = str2;
        }

        public final void mo1177a(PageOverallStarRatingModel pageOverallStarRatingModel) {
            this.f21614a.dismiss();
            DeleteReviewHandler.m25163a(this.f21617d, this.f21615b, this.f21616c);
            if (pageOverallStarRatingModel != null) {
                this.f21617d.f21620c.a(new PageOverallRatingUpdatedEvent(pageOverallStarRatingModel, this.f21615b));
            }
        }

        public final void mo1176a() {
            this.f21614a.dismiss();
            DeleteReviewHandler.m25163a(this.f21617d, this.f21615b, this.f21616c);
        }
    }

    @Inject
    public DeleteReviewHandler(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, PageReviewLoader pageReviewLoader, ReviewEventBus reviewEventBus, ReviewsLogger reviewsLogger, TasksManager tasksManager, Toaster toaster) {
        this.f21618a = defaultBlueServiceOperationFactory;
        this.f21619b = pageReviewLoader;
        this.f21620c = reviewEventBus;
        this.f21621d = reviewsLogger;
        this.f21622e = tasksManager;
        this.f21623f = toaster;
    }

    public final void m25164a(Context context, DeletePageReviewParams deletePageReviewParams, String str) {
        final ProgressDialog a = ProgressDialog.a(context, context.getString(2131235326), context.getString(2131235333), true, false);
        final Context context2 = context;
        final DeletePageReviewParams deletePageReviewParams2 = deletePageReviewParams;
        final String str2 = str;
        this.f21622e.a("delete_review_task_key" + deletePageReviewParams.f10683a, m25162a(deletePageReviewParams), new OperationResultFutureCallback(this) {
            final /* synthetic */ DeleteReviewHandler f21613e;

            protected final void m25158a(ServiceException serviceException) {
                a.dismiss();
                DeleteReviewHandler deleteReviewHandler = this.f21613e;
                Context context = context2;
                String str = deletePageReviewParams2.f10683a;
                deleteReviewHandler.f21621d.f(str2, str);
                deleteReviewHandler.f21623f.b(new ToastBuilder(context.getResources().getString(2131235334)));
            }

            protected final void m25159a(Object obj) {
                a.dismiss();
                DeleteReviewHandler deleteReviewHandler = this.f21613e;
                ProgressDialog progressDialog = a;
                String str = deletePageReviewParams2.f10683a;
                deleteReviewHandler.f21619b.m4901a(str, new C23202(deleteReviewHandler, progressDialog, str, str2));
            }
        });
    }

    private ListenableFuture<OperationResult> m25162a(DeletePageReviewParams deletePageReviewParams) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("deleteReviewParams", deletePageReviewParams);
        return BlueServiceOperationFactoryDetour.a(this.f21618a, "delete_page_review", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(getClass()), 156096691).a();
    }

    public static void m25163a(DeleteReviewHandler deleteReviewHandler, String str, String str2) {
        deleteReviewHandler.f21621d.e(str2, str);
        deleteReviewHandler.f21620c.a(ReviewEvents.m4890a(str, null));
    }
}
