package com.facebook.timeline.refresher;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.User_LoggedInUserMethodAutoProvider;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.base.fragment.IRefreshableFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultBigProfilePictureFieldsModel;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.coverphoto.activity.CoverPhotoRepositionActivityLauncher;
import com.facebook.timeline.coverphoto.activity.CoverPhotoRepositionActivityLauncherProvider;
import com.facebook.timeline.header.editphotohelper.TimelineEditPhotoHelper;
import com.facebook.timeline.header.editphotohelper.TimelineEditPhotoHelperProvider;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQL;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQL.TimelineProfilePictureUriQueryString;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQL;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQL.TimelineCoverPhotoUriQueryString;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: updatePaymentPinStatusParams */
public class ProfileRefresherHeaderFragment extends FbFragment implements IRefreshableFragment {
    public static final CallerContext f983b = CallerContext.a(ProfileRefresherHeaderFragment.class, "timeline");
    @Inject
    volatile Provider<QeAccessor> f984a = UltralightRuntime.a;
    @Inject
    @LocalBroadcast
    public BaseFbBroadcastManager al;
    public FbDraweeView am;
    public FbDraweeView an;
    public FbTextView ao;
    public FrameLayout ap;
    private LinearLayout aq;
    private HeaderFragmentListener ar;
    public HeaderRefreshable as = null;
    private boolean at;
    @Nullable
    private TimelineEditPhotoHelper au;
    @Nullable
    public CoverPhotoRepositionActivityLauncher av;
    public SelfRegistrableReceiverImpl aw;
    @Inject
    @LoggedInUserId
    public Provider<String> f985c;
    @Inject
    @LoggedInUser
    User f986d;
    @Inject
    FbUriIntentHandler f987e;
    @Inject
    public GraphQLQueryExecutor f988f;
    @Inject
    @ForUiThread
    public Executor f989g;
    @Inject
    TimelineEditPhotoHelperProvider f990h;
    @Inject
    public CoverPhotoRepositionActivityLauncherProvider f991i;

    /* compiled from: updatePaymentPinStatusParams */
    public interface HeaderFragmentListener {
        ProfileRefresherModel mo50m();
    }

    /* compiled from: updatePaymentPinStatusParams */
    public interface HeaderRefreshable {
        void mo53f();
    }

    /* compiled from: updatePaymentPinStatusParams */
    public class C00961 implements ActionReceiver {
        final /* synthetic */ ProfileRefresherHeaderFragment f978a;

        public C00961(ProfileRefresherHeaderFragment profileRefresherHeaderFragment) {
            this.f978a = profileRefresherHeaderFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 134489075);
            ProfileRefresherHeaderFragment.aC(this.f978a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 319774001, a);
        }
    }

    /* compiled from: updatePaymentPinStatusParams */
    public class C00972 implements ActionReceiver {
        final /* synthetic */ ProfileRefresherHeaderFragment f979a;

        public C00972(ProfileRefresherHeaderFragment profileRefresherHeaderFragment) {
            this.f979a = profileRefresherHeaderFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1368184126);
            ProfileRefresherHeaderFragment.aC(this.f979a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 296955708, a);
        }
    }

    /* compiled from: updatePaymentPinStatusParams */
    class C00983 implements HeaderRefreshable {
        final /* synthetic */ ProfileRefresherHeaderFragment f980a;

        C00983(ProfileRefresherHeaderFragment profileRefresherHeaderFragment) {
            this.f980a = profileRefresherHeaderFragment;
        }

        public final void mo53f() {
            this.f980a.ao().finish();
            this.f980a.f987e.a(this.f980a.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, this.f980a.f986d.a.toString()));
        }
    }

    /* compiled from: updatePaymentPinStatusParams */
    public class C00994 extends AbstractDisposableFutureCallback<GraphQLResult<TimelineCoverPhotoUriQueryModel>> {
        final /* synthetic */ ProfileRefresherHeaderFragment f981a;

        public C00994(ProfileRefresherHeaderFragment profileRefresherHeaderFragment) {
            this.f981a = profileRefresherHeaderFragment;
        }

        protected final void m1001a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            String a = (((TimelineCoverPhotoUriQueryModel) graphQLResult.e).m1136a() == null || ((TimelineCoverPhotoUriQueryModel) graphQLResult.e).m1136a().m1131a() == null || ((TimelineCoverPhotoUriQueryModel) graphQLResult.e).m1136a().m1131a().m1127a() == null) ? null : ((TimelineCoverPhotoUriQueryModel) graphQLResult.e).m1136a().m1131a().m1127a().m1123a();
            ProfileRefresherHeaderFragment profileRefresherHeaderFragment = this.f981a;
            if (a == null) {
                a = "https://static.xx.fbcdn.net/rsrc.php/v1/y2/r/pQ_103u9HMH.jpg";
            } else {
                a = ((TimelineCoverPhotoUriQueryModel) graphQLResult.e).m1136a().m1131a().m1127a().m1123a();
            }
            profileRefresherHeaderFragment.am.a(Uri.parse(a), ProfileRefresherHeaderFragment.f983b);
        }

        protected final void m1002a(Throwable th) {
        }
    }

    /* compiled from: updatePaymentPinStatusParams */
    public class C01005 extends AbstractDisposableFutureCallback<GraphQLResult<DefaultBigProfilePictureFieldsModel>> {
        final /* synthetic */ ProfileRefresherHeaderFragment f982a;

        public C01005(ProfileRefresherHeaderFragment profileRefresherHeaderFragment) {
            this.f982a = profileRefresherHeaderFragment;
        }

        public final void m1003a(Object obj) {
            String str;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (((DefaultBigProfilePictureFieldsModel) graphQLResult.e).a() == null) {
                str = null;
            } else {
                str = ((DefaultBigProfilePictureFieldsModel) graphQLResult.e).a().b();
            }
            ProfileRefresherHeaderFragment profileRefresherHeaderFragment = this.f982a;
            if (str == null) {
                str = "";
            }
            profileRefresherHeaderFragment.an.a(Uri.parse(str), ProfileRefresherHeaderFragment.f983b);
        }

        public final void m1004a(Throwable th) {
        }
    }

    public static void m1005a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ProfileRefresherHeaderFragment) obj).m1006a(IdBasedSingletonScopeProvider.a(fbInjector, 3219), IdBasedProvider.a(fbInjector, 4442), User_LoggedInUserMethodAutoProvider.b(fbInjector), FbUriIntentHandler.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), (TimelineEditPhotoHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(TimelineEditPhotoHelperProvider.class), (CoverPhotoRepositionActivityLauncherProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CoverPhotoRepositionActivityLauncherProvider.class), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(fbInjector));
    }

    private void m1006a(Provider<QeAccessor> provider, Provider<String> provider2, User user, FbUriIntentHandler fbUriIntentHandler, GraphQLQueryExecutor graphQLQueryExecutor, Executor executor, TimelineEditPhotoHelperProvider timelineEditPhotoHelperProvider, CoverPhotoRepositionActivityLauncherProvider coverPhotoRepositionActivityLauncherProvider, FbBroadcastManager fbBroadcastManager) {
        this.f984a = provider;
        this.f985c = provider2;
        this.f986d = user;
        this.f987e = fbUriIntentHandler;
        this.f988f = graphQLQueryExecutor;
        this.f989g = executor;
        this.f990h = timelineEditPhotoHelperProvider;
        this.f991i = coverPhotoRepositionActivityLauncherProvider;
        this.al = fbBroadcastManager;
    }

    public static ProfileRefresherHeaderFragment m1007n(Bundle bundle) {
        ProfileRefresherHeaderFragment profileRefresherHeaderFragment = new ProfileRefresherHeaderFragment();
        if (bundle == null) {
            bundle = new Bundle();
        }
        profileRefresherHeaderFragment.g(bundle);
        return profileRefresherHeaderFragment;
    }

    public final void m1011c(Bundle bundle) {
        super.c(bundle);
        Class cls = ProfileRefresherHeaderFragment.class;
        m1005a(this, getContext());
        if (this.s != null) {
            this.at = this.s.getBoolean("extra_is_from_qp", false);
        }
        this.aw = this.al.a().a("com.facebook.intent.action.COVER_PHOTO_UPDATED", new C00972(this)).a("com.facebook.intent.action.PROFILE_PIC_UPDATED", new C00961(this)).a();
        this.aw.b();
    }

    public final void a_(Context context) {
        super.a_(context);
        this.ar = (HeaderFragmentListener) context;
    }

    public final View m1009a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1310363928);
        View inflate = layoutInflater.inflate(2130906470, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 142351804, a);
        return inflate;
    }

    public final void m1012d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1147357448);
        super.d(bundle);
        this.am = (FbDraweeView) e(2131566393);
        this.an = (FbDraweeView) e(2131566399);
        this.ao = (FbTextView) e(2131566400);
        this.ap = (FrameLayout) e(2131566398);
        if (this.at) {
            this.ao.setText(this.f986d.e.toString());
            Futures.a(this.f988f.a(GraphQLRequest.a((TimelineCoverPhotoUriQueryString) FetchProfileRefresherGraphQL.m1071c().a("profile_id", (String) this.f985c.get()).a("cover_photo_size", Integer.valueOf(GraphQlQueryDefaults.c())))), new C00994(this), this.f989g);
            Futures.a(this.f988f.a(GraphQLRequest.a((TimelineProfilePictureUriQueryString) FetchTimelineHeaderGraphQL.b().a("profile_id", (String) this.f985c.get()))), new C01005(this), this.f989g);
            this.am.setAlpha(0.4f);
            this.as = new C00983(this);
            this.aq = (LinearLayout) e(2131566397);
            this.aq.setVisibility(8);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 192287897, a);
    }

    public final LinearLayout at() {
        return (LinearLayout) e(2131566397);
    }

    public final void m1013e() {
    }

    public final void m1010a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 125 || i == 9915) {
                aD().m882a(intent.getExtras());
            } else if ((i == 124 || i == 9916) && intent != null) {
                if (this.av == null) {
                    this.av = this.f991i.a(Long.valueOf(Long.parseLong((String) this.f985c.get())));
                }
                this.av.a(this, intent, this.ar.mo50m().f1017e);
            }
        }
    }

    public final void au() {
        aD().m885b(aB(), true);
    }

    public final void av() {
        aD().m884a(aB(), true);
    }

    private boolean aB() {
        return ((QeAccessor) this.f984a.get()).a(ExperimentsForTimelineAbTestModule.aG, false);
    }

    public static void aC(ProfileRefresherHeaderFragment profileRefresherHeaderFragment) {
        if (profileRefresherHeaderFragment.as != null) {
            profileRefresherHeaderFragment.as.mo53f();
        }
    }

    public final void aw() {
        aD().m883a(null);
    }

    public final void ax() {
        aD().m881a();
    }

    private TimelineEditPhotoHelper aD() {
        if (this.au == null) {
            this.au = this.f990h.m886a(Long.valueOf(Long.parseLong((String) this.f985c.get())), this, 0);
        }
        return this.au;
    }

    public final void m1008I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -832115799);
        super.I();
        this.as = null;
        if (this.aw != null && this.aw.a()) {
            this.aw.c();
        }
        this.aw = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 681393665, a);
    }
}
