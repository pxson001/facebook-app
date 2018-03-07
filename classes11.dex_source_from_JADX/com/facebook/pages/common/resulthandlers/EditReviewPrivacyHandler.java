package com.facebook.pages.common.resulthandlers;

import android.content.Intent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.OperationResult.NoResultDataParcelableException;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.pages.common.eventbus.PageEventBus;
import com.facebook.pages.common.eventbus.PageEvents.PageIdentityDataUpdateParams;
import com.facebook.pages.common.eventbus.PageEvents.UpdatePageDataEvent;
import com.facebook.pages.common.logging.analytics.NetworkFailureEvent;
import com.facebook.pages.common.logging.analytics.NetworkSuccessEvent;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.resulthandlers.interfaces.ActivityResultHandler;
import com.facebook.pages.common.surface.cards.interfaces.PageCardType;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.protocol.EditReviewPrivacyParams;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: saved_collection_ego_action_link_clicked */
public class EditReviewPrivacyHandler implements ActivityResultHandler {
    private final PagesAnalytics f2276a;
    private final PrivacyOperationsClient f2277b;
    private final PageEventBus f2278c;
    private long f2279d;

    /* compiled from: saved_collection_ego_action_link_clicked */
    class C02841 implements PageIdentityDataUpdateParams {
        final /* synthetic */ EditReviewPrivacyHandler f2275a;

        C02841(EditReviewPrivacyHandler editReviewPrivacyHandler) {
            this.f2275a = editReviewPrivacyHandler;
        }

        public final ImmutableList<PageCardType> mo40a() {
            return ImmutableList.of(PageCardType.REVIEWS);
        }
    }

    @Inject
    public EditReviewPrivacyHandler(PagesAnalytics pagesAnalytics, PrivacyOperationsClient privacyOperationsClient, PageEventBus pageEventBus) {
        this.f2276a = pagesAnalytics;
        this.f2277b = privacyOperationsClient;
        this.f2278c = pageEventBus;
    }

    public final void mo47a(OperationResult operationResult) {
        try {
            m3233f();
        } catch (NoResultDataParcelableException e) {
            m3232e();
        }
    }

    public final void mo48a(ServiceException serviceException) {
        m3232e();
    }

    public final boolean mo50c() {
        return true;
    }

    @Nullable
    public final DialogBasedProgressIndicator mo45a() {
        return null;
    }

    public final boolean mo49b() {
        return false;
    }

    public final ListenableFuture<OperationResult> mo46a(long j, @Nullable ProfilePermissions profilePermissions, FbFragment fbFragment, Intent intent, int i) {
        this.f2279d = j;
        GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) FlatBufferModelHelper.a(intent, "privacy_option");
        if (graphQLPrivacyOption == null) {
            return null;
        }
        EditReviewPrivacyParams editReviewPrivacyParams = new EditReviewPrivacyParams(graphQLPrivacyOption.c(), this.f2279d);
        this.f2278c.a(new UpdatePageDataEvent(new C02841(this)));
        return this.f2277b.a(editReviewPrivacyParams);
    }

    public final ImmutableList<Integer> mo51d() {
        return ImmutableList.of(Integer.valueOf(10110));
    }

    private void m3232e() {
        this.f2276a.a(NetworkFailureEvent.EVENT_PAGE_EDIT_REVIEW_PRIVACY_ERROR, this.f2279d);
    }

    private void m3233f() {
        this.f2276a.a(NetworkSuccessEvent.EVENT_PAGE_EDIT_REVIEW_PRIVACY_SUCCESS, this.f2279d);
    }
}
