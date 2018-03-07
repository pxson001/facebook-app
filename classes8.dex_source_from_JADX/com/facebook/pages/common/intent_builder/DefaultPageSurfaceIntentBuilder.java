package com.facebook.pages.common.intent_builder;

import android.annotation.SuppressLint;
import android.content.Intent;
import com.facebook.analytics.CurationMechanism;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.events.common.ActionMechanism;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerPageData;
import javax.annotation.Nullable;

/* compiled from: crowdsourcing_context */
public abstract class DefaultPageSurfaceIntentBuilder {
    public ComposerPageData f16570a;

    public abstract Intent m19585c(long j, String str);

    public Builder m19575a(long j, String str) {
        throw new UnsupportedOperationException("IPageIdentityIntentBuilder getCheckinConfigurationBuilder");
    }

    public Builder m19577a(long j, String str, String str2, ViewerContext viewerContext) {
        throw new UnsupportedOperationException("IPageIdentityIntentBuilder getAdminStatusConfigurationBuilder");
    }

    public Builder m19578a(long j, String str, String str2, boolean z) {
        throw new UnsupportedOperationException("IPageIdentityIntentBuilder getNonAdminPostConfigurationBuilder");
    }

    public Intent m19583b(long j, String str, String str2, ViewerContext viewerContext) {
        throw new UnsupportedOperationException("IPageIdentityIntentBuilder newAdminPhotoIntent");
    }

    public Intent m19573a(long j, String str, String str2) {
        throw new UnsupportedOperationException("IPageIdentityIntentBuilder newNonAdminPhotoIntent");
    }

    public Intent m19582b(long j, String str, String str2) {
        throw new UnsupportedOperationException("IPageIdentityIntentBuilder launchPageIntent");
    }

    public void m19580a(long j) {
        throw new UnsupportedOperationException("IPageIdentityIntentBuilder launchPageInfoIntent");
    }

    public Builder m19576a(long j, String str, @Nullable GraphQLPrivacyOption graphQLPrivacyOption, CurationMechanism curationMechanism, int i) {
        throw new UnsupportedOperationException("IPageIdentityIntentBuilder newPostRecommendationIntent");
    }

    public Builder m19579a(@Nullable String str, int i, String str2, long j, GraphQLPrivacyOption graphQLPrivacyOption, CurationMechanism curationMechanism) {
        throw new UnsupportedOperationException("IPageIdentityIntentBuilder newEditReviewIntent");
    }

    public Intent m19571a() {
        throw new UnsupportedOperationException("IPageIdentityIntentBuilder newCreatePageIntent");
    }

    public Intent m19581b(long j, String str) {
        throw new UnsupportedOperationException("IPageIdentityIntentBuilder newEditHomeIntent");
    }

    public Intent m19574a(long j, String str, String str2, String str3) {
        throw new UnsupportedOperationException("IPageIdentityIntentBuilder launchPageUpcomingEventsListIntent");
    }

    @SuppressLint({"DeprecatedMethod"})
    public final boolean m19584b() {
        throw new UnsupportedOperationException("IPageIdentityIntentBuilder openEventCreation");
    }

    public Intent m19572a(long j, String str, ActionMechanism actionMechanism) {
        throw new UnsupportedOperationException("IPageIdentityIntentBuilder openEventCreation");
    }
}
