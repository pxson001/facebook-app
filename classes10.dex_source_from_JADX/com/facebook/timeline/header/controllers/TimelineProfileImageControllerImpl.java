package com.facebook.timeline.header.controllers;

import android.app.Activity;
import android.content.Intent;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.view.DraweeView;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcherConstructionRule;
import com.facebook.photos.mediafetcher.query.ProfilePictureMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.param.IdQueryParam;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory.Builder;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.editphotohelper.TimelineEditPhotoHelper;
import com.facebook.timeline.header.expirephoto.ExpirePhotoInputData;
import com.facebook.timeline.header.expirephoto.ExpirePhotoMutationClient;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import com.facebook.timeline.profilemedia.ProfileMediaChangeBroadcaster;
import com.facebook.timeline.profilevideo.CreateProfileVideoActivity;
import com.facebook.timeline.protocol.RevertTemporaryMutation.RevertTemporaryMutationString;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: first_item_count */
public class TimelineProfileImageControllerImpl implements TimelineProfileImageController {
    private final Activity f11646a;
    private final Supplier<TimelineEditPhotoHelper> f11647b;
    private final Lazy<ExpirePhotoMutationClient> f11648c;
    private final Provider<SecureContextHelper> f11649d;
    private final Executor f11650e;
    private final QeAccessor f11651f;
    public final ProfileMediaChangeBroadcaster f11652g;
    private final TimelineContext f11653h;
    private final TimelineHeaderUserData f11654i;
    private final Provider<MediaGalleryLauncher> f11655j;
    private final Provider<MediaGalleryLauncherParamsFactory> f11656k;
    private final TimelineAnalyticsLogger f11657l;
    public final Lazy<Toaster> f11658m;

    /* compiled from: first_item_count */
    class C16691 implements FutureCallback {
        final /* synthetic */ TimelineProfileImageControllerImpl f11645a;

        C16691(TimelineProfileImageControllerImpl timelineProfileImageControllerImpl) {
            this.f11645a = timelineProfileImageControllerImpl;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f11645a.f11652g.b();
        }

        public void onFailure(Throwable th) {
            ((Toaster) this.f11645a.f11658m.get()).b(new ToastBuilder(2131235060));
        }
    }

    @Inject
    public TimelineProfileImageControllerImpl(@Assisted Activity activity, @Assisted TimelineAnalyticsLogger timelineAnalyticsLogger, @Assisted TimelineContext timelineContext, @Assisted Supplier<TimelineEditPhotoHelper> supplier, @Assisted TimelineHeaderUserData timelineHeaderUserData, Provider<MediaGalleryLauncher> provider, Provider<MediaGalleryLauncherParamsFactory> provider2, Lazy<ExpirePhotoMutationClient> lazy, Provider<SecureContextHelper> provider3, Lazy<Toaster> lazy2, Executor executor, QeAccessor qeAccessor, ProfileMediaChangeBroadcaster profileMediaChangeBroadcaster) {
        this.f11646a = activity;
        this.f11657l = timelineAnalyticsLogger;
        this.f11653h = timelineContext;
        this.f11647b = supplier;
        this.f11654i = timelineHeaderUserData;
        this.f11655j = provider;
        this.f11656k = provider2;
        this.f11648c = lazy;
        this.f11649d = provider3;
        this.f11658m = lazy2;
        this.f11650e = executor;
        this.f11651f = qeAccessor;
        this.f11652g = profileMediaChangeBroadcaster;
    }

    public final void mo546a() {
        m11700a("selector_picture");
        ((TimelineEditPhotoHelper) this.f11647b.get()).b(this.f11651f.a(ExperimentsForTimelineAbTestModule.aI, false), false);
    }

    public final void mo548b() {
        m11700a("upload_picture");
        ((TimelineEditPhotoHelper) this.f11647b.get()).a(null);
    }

    public final void mo549c() {
        TimelineEditPhotoHelper timelineEditPhotoHelper = (TimelineEditPhotoHelper) this.f11647b.get();
        ((SecureContextHelper) timelineEditPhotoHelper.g.get()).a(new Intent(timelineEditPhotoHelper.b.getContext(), CreateProfileVideoActivity.class), 130, timelineEditPhotoHelper.b);
    }

    public final void mo550d() {
        ExpirePhotoMutationClient expirePhotoMutationClient = (ExpirePhotoMutationClient) this.f11648c.get();
        ExpirePhotoInputData expirePhotoInputData = new ExpirePhotoInputData();
        expirePhotoInputData.a("client_mutation_id", SafeUUIDGenerator.a().toString());
        GraphQlCallInput graphQlCallInput = expirePhotoInputData;
        graphQlCallInput.a("actor_id", expirePhotoMutationClient.f11687a);
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString revertTemporaryMutationString = new RevertTemporaryMutationString();
        revertTemporaryMutationString.a("input", graphQlCallInput);
        Futures.a(expirePhotoMutationClient.f11688b.a(GraphQLRequest.a(revertTemporaryMutationString)), new C16691(this), this.f11650e);
    }

    public final void mo547a(DraweeView draweeView, String str, ImageRequest imageRequest, DefaultImageFields defaultImageFields) {
        m11700a("view_picture");
        ImmutableList of = ImmutableList.of(MediaGalleryLauncherHelper.m11670a(str, defaultImageFields));
        this.f11656k.get();
        ((MediaGalleryLauncher) this.f11655j.get()).a(this.f11646a, new Builder(MediaFetcherConstructionRule.a(ProfilePictureMediaQueryProvider.class, new IdQueryParam(str))).a(FullscreenGallerySource.TIMELINE_PROFILE_PHOTO).a(str).a(imageRequest).a(of).b(), MediaGalleryLauncherHelper.m11671a(str, draweeView, imageRequest));
    }

    public final void mo551e() {
        m11700a("view_profile_video");
    }

    private void m11700a(String str) {
        if (this.f11657l != null && this.f11653h != null && this.f11654i != null) {
            this.f11657l.a(this.f11653h.b, str);
        }
    }
}
