package com.facebook.privacy.checkup.photofeed;

import android.content.Context;
import android.view.View;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.impl.BaseFeedEnvironment;
import com.facebook.feed.environment.impl.HasScrollListenerSupportImpl;
import com.facebook.feed.fragment.generatedenvironments.HasPrefetcherImpl;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.photosfeed.CanLaunchMediaGallery;
import com.facebook.feed.rows.photosfeed.CanLaunchPhotosFeedFlyout;
import com.facebook.feed.rows.photosfeed.PrivacyFeedFeedbackLauncher;
import com.facebook.feed.ui.FlyoutLauncher.FlyoutContext;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.facebook.ufiservices.flyout.FeedbackParams.Builder;

/* compiled from: Spotify */
public class PhotoPrivacyFeedEnvironment extends BaseFeedEnvironment implements FeedEnvironment, CanLaunchMediaGallery, CanLaunchPhotosFeedFlyout, CanEditObjectPrivacy {
    private final FeedListType f11034m;
    private final HasPrefetcherImpl f11035n;
    private final PrivacyFeedMediaGalleryLauncher f11036o;
    private final PrivacyFeedFeedbackLauncher f11037p;
    private final CanEditObjectPrivacy f11038q;

    PhotoPrivacyFeedEnvironment(Context context, Runnable runnable, FeedListType feedListType, HasPrefetcherImpl hasPrefetcherImpl, PrivacyFeedMediaGalleryLauncher privacyFeedMediaGalleryLauncher, PrivacyFeedFeedbackLauncher privacyFeedFeedbackLauncher, CanEditObjectPrivacy canEditObjectPrivacy) {
        super(context, runnable, HasScrollListenerSupportImpl.b);
        this.f11034m = feedListType;
        this.f11035n = hasPrefetcherImpl;
        this.f11036o = privacyFeedMediaGalleryLauncher;
        this.f11037p = privacyFeedFeedbackLauncher;
        this.f11038q = canEditObjectPrivacy;
    }

    public final BaseFeedStoryMenuHelper m11442e() {
        return null;
    }

    public final FeedListType m11441c() {
        return this.f11034m;
    }

    public final void m11437a(ImageRequest imageRequest, CallerContext callerContext) {
        a(m(), imageRequest, callerContext);
    }

    public final void m11435a(RowKey rowKey, ImageRequest imageRequest, CallerContext callerContext) {
        this.f11035n.a(rowKey, imageRequest, callerContext);
    }

    public final void m11438a(MediaMetadata mediaMetadata, ImageRequest imageRequest, boolean z, int i) {
        this.f11036o.m11453a(mediaMetadata, imageRequest, z, i);
    }

    public final void m11436a(GraphQLFeedback graphQLFeedback, View view, FlyoutContext flyoutContext) {
        PrivacyFeedFeedbackLauncher privacyFeedFeedbackLauncher = this.f11037p;
        if (graphQLFeedback != null) {
            Builder builder = new Builder();
            builder.a = graphQLFeedback;
            builder = builder;
            builder.d = graphQLFeedback.z_();
            builder = builder;
            FeedbackLoggingParams.Builder builder2 = new FeedbackLoggingParams.Builder();
            builder2.c = "privacy_photo_checkup";
            builder.g = builder2.a();
            privacyFeedFeedbackLauncher.a.a(view.getContext(), builder.a());
        }
    }

    public final void mo291a(String str, PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation) {
        this.f11038q.mo291a(str, privacyOptionFieldsWithExplanation);
    }

    public final PrivacyOptionFieldsWithExplanation mo289a() {
        return this.f11038q.mo289a();
    }

    public final void mo292a(boolean z) {
        this.f11038q.mo292a(z);
    }

    public final PrivacyOptionFieldsWithExplanation mo290a(String str) {
        return this.f11038q.mo290a(str);
    }
}
