package com.facebook.timeline.profilevideo.playback;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.facebook.caspian.ui.standardheader.ProfileVideoIconBinder;
import com.facebook.caspian.ui.standardheader.ProfileVideoView;
import com.facebook.caspian.ui.standardheader.StandardCoverHeaderView;
import com.facebook.common.util.ContextUtils;
import com.facebook.graphql.calls.MediaTypeInputMimeType;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Assisted;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.timeline.profilevideo.playback.protocol.FetchProfileVideoGraphQL.ProfileVideoDetailQueryString;
import com.facebook.timeline.profilevideo.playback.protocol.FetchProfileVideoGraphQLModels.ProfileVideoHeaderFieldsModel;
import com.facebook.timeline.profilevideo.playback.protocol.ProfileVideoHeaderData;
import com.facebook.timeline.profilevideo.store.OptimisticProfileVideoModel;
import com.facebook.timeline.profilevideo.store.OptimisticProfileVideoStore;
import com.facebook.video.activity.FullscreenVideoPlayerLauncher;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import com.facebook.video.settings.VideoAutoPlaySettingsChecker;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mPageCategoryNames */
public class ProfileVideoController {
    public final Context f9379a;
    private final ProfileVideoPlaybackExperimentAccessor f9380b;
    private final StandardCoverHeaderView f9381c;
    private final boolean f9382d;
    public ProfileVideoHeaderData f9383e;
    public final VideoAutoPlaySettingsChecker f9384f;
    public final GraphQLQueryExecutor f9385g;
    public final ListeningExecutorService f9386h;
    public final FullscreenVideoPlayerLauncher f9387i;
    public final ZeroDialogController f9388j;
    private final OptimisticProfileVideoStore f9389k;
    private final ProfileVideoIconBinder f9390l;

    /* compiled from: mPageCategoryNames */
    public class C09791 implements FutureCallback<GraphQLResult<VideoDetailFragmentModel>> {
        final /* synthetic */ ProfileVideoController f9376a;

        public C09791(ProfileVideoController profileVideoController) {
            this.f9376a = profileVideoController;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null && this.f9376a.f9379a != null) {
                ProfileVideoController profileVideoController = this.f9376a;
                VideoDetailFragmentModel videoDetailFragmentModel = (VideoDetailFragmentModel) graphQLResult.e;
                FragmentActivity fragmentActivity = (FragmentActivity) ContextUtils.a(profileVideoController.f9379a, FragmentActivity.class);
                if (fragmentActivity != null) {
                    profileVideoController.f9388j.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, profileVideoController.f9379a.getString(2131232932), new C09802(profileVideoController, videoDetailFragmentModel));
                    profileVideoController.f9388j.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, fragmentActivity.kO_());
                }
            }
        }

        public void onFailure(Throwable th) {
            if (this.f9376a.f9379a != null) {
                Toast.makeText(this.f9376a.f9379a, 2131230758, 1).show();
            }
        }
    }

    /* compiled from: mPageCategoryNames */
    public class C09802 implements Listener {
        final /* synthetic */ VideoDetailFragmentModel f9377a;
        final /* synthetic */ ProfileVideoController f9378b;

        public C09802(ProfileVideoController profileVideoController, VideoDetailFragmentModel videoDetailFragmentModel) {
            this.f9378b = profileVideoController;
            this.f9377a = videoDetailFragmentModel;
        }

        public final void m11138a(Object obj) {
            this.f9378b.f9387i.m11257a(this.f9377a, this.f9378b.f9379a, PlayerOrigin.PROFILE_VIDEO);
        }

        public final void m11137a() {
        }
    }

    @Inject
    public ProfileVideoController(@Assisted Context context, @Assisted StandardCoverHeaderView standardCoverHeaderView, @Assisted boolean z, @Assisted ProfileVideoHeaderData profileVideoHeaderData, @Assisted ProfileVideoPlaybackExperimentAccessor profileVideoPlaybackExperimentAccessor, VideoAutoPlaySettingsChecker videoAutoPlaySettingsChecker, GraphQLQueryExecutor graphQLQueryExecutor, ListeningExecutorService listeningExecutorService, FullscreenVideoPlayerLauncher fullscreenVideoPlayerLauncher, ZeroDialogController zeroDialogController, OptimisticProfileVideoStore optimisticProfileVideoStore, ProfileVideoIconBinder profileVideoIconBinder) {
        this.f9379a = context;
        this.f9380b = profileVideoPlaybackExperimentAccessor;
        this.f9381c = standardCoverHeaderView;
        this.f9382d = z;
        this.f9383e = profileVideoHeaderData;
        this.f9384f = videoAutoPlaySettingsChecker;
        this.f9385g = graphQLQueryExecutor;
        this.f9386h = listeningExecutorService;
        this.f9387i = fullscreenVideoPlayerLauncher;
        this.f9388j = zeroDialogController;
        this.f9389k = optimisticProfileVideoStore;
        this.f9390l = profileVideoIconBinder;
    }

    public final boolean m11145a() {
        return m11146b() && this.f9384f.a();
    }

    public final boolean m11146b() {
        return m11139g() != null;
    }

    private ProfileVideoHeaderFieldsModel m11139g() {
        if (!this.f9380b.m11151a()) {
            return null;
        }
        if (m11140h() != null) {
            return m11140h();
        }
        return this.f9383e.b();
    }

    public final boolean m11147c() {
        if (this.f9380b.m11151a() && m11140h() != null) {
            return true;
        }
        return false;
    }

    public final void m11144a(OnClickListener onClickListener) {
        Object obj;
        if (!m11146b() || this.f9384f.a()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            this.f9390l.a(this.f9381c.getLazyProfileVideoIcon(), 1);
        } else {
            this.f9390l.a(this.f9381c.getLazyProfileVideoIcon(), 0);
        }
        if (m11145a()) {
            ((ProfileVideoView) this.f9381c.getLazyProfileVideoView().a()).setVisibility(0);
            ProfileVideoViewBinder.m11153a((ProfileVideoView) this.f9381c.getLazyProfileVideoView().a(), m11139g(), m11142j(), this.f9381c.j, onClickListener, m11141i());
            return;
        }
        if (this.f9381c.getLazyProfileVideoView().b()) {
            ((ProfileVideoView) this.f9381c.getLazyProfileVideoView().a()).g();
        }
        this.f9381c.getLazyProfileVideoView().c();
    }

    public final void m11148d() {
        if (this.f9381c.getLazyProfileVideoView().b()) {
            ((ProfileVideoView) this.f9381c.getLazyProfileVideoView().a()).g();
        }
    }

    @Nullable
    private ProfileVideoHeaderFieldsModel m11140h() {
        OptimisticProfileVideoModel k = m11143k();
        if (k == null) {
            return null;
        }
        return k.f9409b;
    }

    @Nullable
    private VideoCreativeEditingData m11141i() {
        OptimisticProfileVideoModel k = m11143k();
        if (k == null) {
            return null;
        }
        return k.f9411d;
    }

    private float m11142j() {
        OptimisticProfileVideoModel k = m11143k();
        if (k == null) {
            return 1.0f;
        }
        return k.f9412e;
    }

    @Nullable
    private OptimisticProfileVideoModel m11143k() {
        if (!this.f9380b.m11152b() || !this.f9382d) {
            return null;
        }
        OptimisticProfileVideoModel a = this.f9389k.m11181a("uploading");
        return a == null ? this.f9389k.m11181a(this.f9383e.a()) : a;
    }

    public final void m11149e() {
        if (this.f9383e != null && this.f9383e.b() != null && this.f9383e.b().b() != null && !this.f9383e.b().b().equals("0") && m11146b()) {
            String b = this.f9383e.b().b();
            this.f9381c.getProfileVideoView();
            GraphQlQueryString profileVideoDetailQueryString = new ProfileVideoDetailQueryString();
            profileVideoDetailQueryString.a("video_id", b).a("media_type", MediaTypeInputMimeType.IMAGEWEBP);
            Futures.a(this.f9385g.a(GraphQLRequest.a(profileVideoDetailQueryString).a(GraphQLCachePolicy.c)), new C09791(this), this.f9386h);
        }
    }
}
