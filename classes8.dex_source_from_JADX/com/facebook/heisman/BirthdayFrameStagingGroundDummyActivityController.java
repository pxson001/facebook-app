package com.facebook.heisman;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.heisman.protocol.HeismanSelfProfilePictureGraphQLModels.SelfProfilePictureFieldsModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.inject.Assisted;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.editgallery.EntryPoint;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.stagingground.StagingGroundIntentFactory;
import com.facebook.timeline.stagingground.StagingGroundLaunchConfig.Builder;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: video_player_origin */
public class BirthdayFrameStagingGroundDummyActivityController {
    @Inject
    public SecureContextHelper f541a;
    @Inject
    private GraphQLQueryExecutor f542b;
    @Inject
    @ForUiThread
    private Executor f543c;
    @Inject
    private ProfilePictureOverlayIntentFactory f544d;
    @Inject
    private SelfProfilePictureQueryBuilder f545e;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> f546f = UltralightRuntime.b;
    @Inject
    private QeAccessor f547g;
    private final Activity f548h;
    private final String f549i;
    private final ImageOverlayFieldsModel f550j;
    @Nullable
    private FutureAndCallbackHolder<Intent> f551k = null;

    /* compiled from: video_player_origin */
    class C00691 extends AbstractDisposableFutureCallback<GraphQLResult<SelfProfilePictureFieldsModel>> {
        final /* synthetic */ BirthdayFrameStagingGroundDummyActivityController f537a;

        C00691(BirthdayFrameStagingGroundDummyActivityController birthdayFrameStagingGroundDummyActivityController) {
            this.f537a = birthdayFrameStagingGroundDummyActivityController;
        }

        public final void m595a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f537a.m607a(((SelfProfilePictureFieldsModel) graphQLResult.e).j().a(), ((SelfProfilePictureFieldsModel) graphQLResult.e).a().j());
        }

        public final void m596a(Throwable th) {
            if (!(th instanceof IOException)) {
                ((AbstractFbErrorReporter) this.f537a.f546f.get()).a("heisman_fetch_self_profile_picture_failed", th);
            }
            this.f537a.f541a;
        }
    }

    @Inject
    public BirthdayFrameStagingGroundDummyActivityController(@Assisted Activity activity, @Assisted String str, @Assisted ImageOverlayFieldsModel imageOverlayFieldsModel) {
        this.f548h = activity;
        this.f549i = str;
        this.f550j = imageOverlayFieldsModel;
    }

    public final void m604a() {
        SelfProfilePictureQueryBuilder selfProfilePictureQueryBuilder = this.f545e;
        Futures.a(this.f542b.a(GraphQLRequest.a(SelfProfilePictureQueryBuilder.m808a(this.f549i, Integer.valueOf(GraphQlQueryDefaults.d())))), new C00691(this), this.f543c);
    }

    final void m606a(SecureContextHelper secureContextHelper, GraphQLQueryExecutor graphQLQueryExecutor, Executor executor, ProfilePictureOverlayIntentFactory profilePictureOverlayIntentFactory, SelfProfilePictureQueryBuilder selfProfilePictureQueryBuilder, com.facebook.inject.Lazy<FbErrorReporter> lazy, QeAccessor qeAccessor) {
        this.f541a = secureContextHelper;
        this.f542b = graphQLQueryExecutor;
        this.f543c = executor;
        this.f544d = profilePictureOverlayIntentFactory;
        this.f545e = selfProfilePictureQueryBuilder;
        this.f546f = lazy;
        this.f547g = qeAccessor;
    }

    public final void m605a(Activity activity, int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            m600a(activity, intent);
        }
    }

    public final void m608b() {
        if (this.f551k != null) {
            this.f551k.a(true);
        }
    }

    private void m600a(final Activity activity, Intent intent) {
        ListenableFuture a = this.f544d.m788a((EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a), null, intent.getLongExtra("extra_profile_pic_expiration", 0), intent.getStringExtra("staging_ground_photo_caption"), "existing");
        final ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.a(activity.getResources().getString(2131230739));
        progressDialog.show();
        C00702 c00702 = new AbstractDisposableFutureCallback<Intent>(this) {
            final /* synthetic */ BirthdayFrameStagingGroundDummyActivityController f540c;

            protected final void m597a(Object obj) {
                Intent intent = (Intent) obj;
                progressDialog.dismiss();
                if (intent != null) {
                    this.f540c.f541a.a(intent, activity);
                }
                activity.finish();
            }

            protected final void m598a(Throwable th) {
                progressDialog.dismiss();
            }
        };
        Futures.a(a, c00702, this.f543c);
        this.f551k = new FutureAndCallbackHolder(a, c00702);
    }

    @VisibleForTesting
    public final void m607a(String str, String str2) {
        Calendar instance = Calendar.getInstance();
        instance.add(6, 1);
        Builder a = new Builder().a(Uri.parse(str), str2);
        a.m = this.f550j;
        a = a;
        a.p = this.f547g.a(ExperimentsForTimelineAbTestModule.m, false);
        a = a;
        a.s = true;
        a = a;
        a.r = false;
        a = a;
        a.d = EntryPoint.PROFILE.name();
        a = a;
        a.f = instance.getTimeInMillis() / 1000;
        Builder builder = a;
        builder.k = "profile_picture_overlay_birthday";
        this.f541a.a(StagingGroundIntentFactory.a(this.f548h, builder.a(), null), 1, this.f548h);
    }

    public static void m603c(BirthdayFrameStagingGroundDummyActivityController birthdayFrameStagingGroundDummyActivityController) {
        Toast.makeText(birthdayFrameStagingGroundDummyActivityController.f548h, birthdayFrameStagingGroundDummyActivityController.f548h.getResources().getString(2131230758), 1).show();
    }
}
