package com.facebook.timeline.inforeview;

import com.facebook.graphql.model.GraphQLPrivacyRowInput;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionFragmentModel;
import com.facebook.inject.Assisted;
import com.facebook.timeline.event.HeaderDataEvents.AdapterDataChangedEvent;
import com.facebook.timeline.event.TimelineHeaderEventBus;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLModels.InfoReviewItemsFragmentModel;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: upload_conn_quality */
public class PlutoniumProfileQuestionHandler {
    private final TimelineHeaderEventBus f886a;
    private final InfoReviewProfileQuestionStatusData f887b;
    private final PlutoniumProfileQuestionActionController f888c;
    private final TimelineInfoReviewData f889d;

    @Inject
    public PlutoniumProfileQuestionHandler(@Assisted TimelineHeaderEventBus timelineHeaderEventBus, @Assisted TimelineInfoReviewData timelineInfoReviewData, PlutoniumProfileQuestionActionController plutoniumProfileQuestionActionController) {
        this.f886a = timelineHeaderEventBus;
        this.f889d = timelineInfoReviewData;
        this.f887b = timelineInfoReviewData.f914f;
        this.f888c = plutoniumProfileQuestionActionController;
    }

    public final void m911a(@Nonnull ProfileQuestionFragmentModel profileQuestionFragmentModel, @Nonnull String str, @Nonnull GraphQLPrivacyRowInput graphQLPrivacyRowInput, @Nonnull String str2, @Nonnull String str3, @Nonnull String str4) {
        this.f887b.f874g = true;
        m910d();
        this.f888c.m908a(profileQuestionFragmentModel.d(), str, graphQLPrivacyRowInput, this.f887b.m900b(), str2, str3, str4);
        this.f888c.f885d = this;
    }

    public final void m912a(InfoReviewItemsFragmentModel infoReviewItemsFragmentModel) {
        m909c();
        this.f889d.m921a(infoReviewItemsFragmentModel, 2);
        m910d();
    }

    public final void m913b() {
        m909c();
        this.f889d.m921a(null, 2);
        m910d();
    }

    private void m909c() {
        this.f887b.m897a(null, null);
        this.f887b.m898a(false);
        this.f887b.m896a(null);
        this.f887b.m901b(null);
        this.f887b.f874g = false;
        this.f887b.f875h = false;
        this.f887b.m895a(null);
    }

    private void m910d() {
        this.f886a.a(new AdapterDataChangedEvent());
    }
}
