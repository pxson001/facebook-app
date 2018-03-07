package com.facebook.timeline.coverphoto;

import android.content.Context;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.Dimension;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.upload.constants.PhotoProcessingConstantsUtils;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.contextual.TimelineContextualInfoDataFactory;
import com.facebook.timeline.coverphoto.UserEditCoverPhotoHeaderView.C15261;
import com.facebook.timeline.coverphoto.activity.CoverPhotoFragment;
import com.facebook.timeline.datafetcher.TimelineHeaderRequestFactory;
import com.facebook.timeline.header.data.TimelineHeaderData.InitializeState;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.profilepiccoverphotoupload.SetCoverPhotoParams;
import com.facebook.timeline.profileprotocol.FetchTimelineHeaderParamsFactory;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.recyclerview.DelegatingAdapter;
import com.google.common.base.Absent;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

@UriMatchPatterns(fragment = ContentFragmentType.TIMELINE_COVERPHOTO_FRAGMENT)
/* compiled from: group_hide_suggestion */
public class UserCoverPhotoRepositionFragment extends FbFragment implements CoverPhotoFragment {
    private static final CallerContext al;
    private static final Class<?> f10360i;
    @Inject
    AbstractFbErrorReporter f10361a;
    private String am;
    private Dimension an;
    private long ao = 0;
    private TimelineUserContext ap;
    public TimelineHeaderUserData aq;
    private ListenableFuture<? extends GraphQLResult<? extends BaseModel>> ar;
    private UserEditCoverPhotoHeaderView as;
    @Inject
    BitmapUtils f10362b;
    @Inject
    @LoggedInUserId
    String f10363c;
    @Inject
    GraphQLQueryExecutor f10364d;
    @Inject
    @ForUiThread
    ExecutorService f10365e;
    @Inject
    FetchTimelineHeaderParamsFactory f10366f;
    @Inject
    TimelineHeaderRequestFactory f10367g;
    @Inject
    QeAccessor f10368h;

    /* compiled from: group_hide_suggestion */
    class C15251 implements FutureCallback<GraphQLResult<? extends BaseModel>> {
        final /* synthetic */ UserCoverPhotoRepositionFragment f10359a;

        C15251(UserCoverPhotoRepositionFragment userCoverPhotoRepositionFragment) {
            this.f10359a = userCoverPhotoRepositionFragment;
        }

        public void onSuccess(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (this.f10359a.aq != null && graphQLResult != null && graphQLResult.e != null) {
                this.f10359a.aq.a(graphQLResult.e);
                UserCoverPhotoRepositionFragment.m10488b(this.f10359a);
            }
        }

        public void onFailure(Throwable th) {
            if (this.f10359a.hn_() && this.f10359a.getContext() != null) {
                Toast.makeText(this.f10359a.getContext(), 2131230758, 1).show();
                this.f10359a.ao().setResult(0);
                this.f10359a.ao().finish();
            }
        }
    }

    private static <T extends InjectableComponentWithContext> void m10486a(Class<T> cls, T t) {
        m10487a((Object) t, t.getContext());
    }

    private static void m10487a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((UserCoverPhotoRepositionFragment) obj).m10485a((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), BitmapUtils.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), FetchTimelineHeaderParamsFactory.m12093a(injectorLike), TimelineHeaderRequestFactory.m10637a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    private void m10485a(AbstractFbErrorReporter abstractFbErrorReporter, BitmapUtils bitmapUtils, String str, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, FetchTimelineHeaderParamsFactory fetchTimelineHeaderParamsFactory, TimelineHeaderRequestFactory timelineHeaderRequestFactory, QeAccessor qeAccessor) {
        this.f10361a = abstractFbErrorReporter;
        this.f10362b = bitmapUtils;
        this.f10363c = str;
        this.f10364d = graphQLQueryExecutor;
        this.f10365e = executorService;
        this.f10366f = fetchTimelineHeaderParamsFactory;
        this.f10367g = timelineHeaderRequestFactory;
        this.f10368h = qeAccessor;
    }

    static {
        Class cls = UserCoverPhotoRepositionFragment.class;
        f10360i = cls;
        al = CallerContext.a(cls, "timeline");
    }

    public final void m10491c(Bundle bundle) {
        super.c(bundle);
        Bundle mt_ = mt_();
        this.am = mt_.getString("cover_photo_uri");
        this.ao = mt_.getLong("cover_photo_id");
        long j = mt_.getLong("profile_id");
        if (this.am == null || j == 0) {
            BLog.b(f10360i, "Missing required arguments.");
            ao().finish();
            return;
        }
        long parseLong;
        m10486a(UserCoverPhotoRepositionFragment.class, (InjectableComponentWithContext) this);
        try {
            parseLong = Long.parseLong(this.f10363c);
        } catch (NumberFormatException e) {
            parseLong = -1;
            this.f10361a.a("timeline_invalid_meuser", "logged in user: " + this.f10363c);
        }
        this.ap = TimelineUserContext.a(parseLong, parseLong, null, new ParcelUuid(SafeUUIDGenerator.a()));
        this.aq = new TimelineHeaderUserData(this.ap);
        m10484a(j, mt_.getBoolean("force_refresh", false));
    }

    public static UserCoverPhotoRepositionFragment m10483a(long j, String str, long j2, boolean z) {
        UserCoverPhotoRepositionFragment userCoverPhotoRepositionFragment = new UserCoverPhotoRepositionFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("cover_photo_id", j);
        bundle.putString("cover_photo_uri", str);
        bundle.putLong("profile_id", j2);
        bundle.putBoolean("force_refresh", z);
        userCoverPhotoRepositionFragment.g(bundle);
        return userCoverPhotoRepositionFragment;
    }

    public final View m10489a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2082909367);
        this.an = BitmapUtils.a(this.am);
        if (!PhotoProcessingConstantsUtils.a(this.an)) {
            Toast.makeText(getContext(), 2131234972, 1).show();
            ao().setResult(0);
            ao().finish();
        }
        this.as = new UserEditCoverPhotoHeaderView(this.am, this.f10368h.a(ExperimentsForTimelineAbTestModule.ah, false) ? new ContextThemeWrapper(getContext(), 2131624517) : getContext());
        Futures.a(this.ar, new C15251(this), this.f10365e);
        View view = this.as;
        LogUtils.f(1539457964, a);
        return view;
    }

    private void m10484a(long j, boolean z) {
        this.ar = this.f10364d.a(this.f10367g.m10642a(this.f10366f.m12095a(j, Absent.INSTANCE), z ? GraphQLCachePolicy.d : GraphQLCachePolicy.a, al, RequestPriority.INTERACTIVE));
    }

    public static void m10488b(UserCoverPhotoRepositionFragment userCoverPhotoRepositionFragment) {
        if (userCoverPhotoRepositionFragment.aq.e != InitializeState.UNINITIALIZED) {
            UserEditCoverPhotoHeaderView userEditCoverPhotoHeaderView = userCoverPhotoRepositionFragment.as;
            TimelineUserContext timelineUserContext = userCoverPhotoRepositionFragment.ap;
            TimelineHeaderUserData timelineHeaderUserData = userCoverPhotoRepositionFragment.aq;
            TimelineUserContext timelineUserContext2 = timelineUserContext;
            TimelineHeaderUserData timelineHeaderUserData2 = timelineHeaderUserData;
            userEditCoverPhotoHeaderView.f10376g = userEditCoverPhotoHeaderView.f10371b.m11423a(userEditCoverPhotoHeaderView.getContext(), timelineUserContext2, TimelineContextualInfoDataFactory.m10471a(), timelineHeaderUserData2, new TimelineTaggedMediaSetData(), userEditCoverPhotoHeaderView.f10372c.m11444a(timelineUserContext.c, Long.valueOf(timelineUserContext.b), timelineHeaderUserData), Boolean.valueOf(false), true);
            userEditCoverPhotoHeaderView.f10375f.setAdapter(new DelegatingAdapter(userEditCoverPhotoHeaderView.f10376g, userEditCoverPhotoHeaderView.f10375f));
            userEditCoverPhotoHeaderView.f10375f.getViewTreeObserver().addOnGlobalLayoutListener(new C15261(userEditCoverPhotoHeaderView));
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1003200308);
        super.mY_();
        if (!(this.as == null || this.as.f10374e == null)) {
            this.as.f10374e.m11760a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1810325726, a);
    }

    public final SetCoverPhotoParams m10490a() {
        return new SetCoverPhotoParams(-1, this.am, this.as.f10374e != null ? this.as.f10374e.getNormalizedCropBounds() : new RectF(0.0f, 0.0f, 1.0f, 1.0f), this.an, this.ao);
    }
}
