package com.facebook.search.results.fragment.reaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.local.serp.analytics.LocalSERPAnalyticsLogger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.ReactionSessionHelper;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.analytics.perflog.ReactionPerfLogger;
import com.facebook.reaction.intent.ReactionReviewUpdateHandler;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStories;
import com.facebook.reaction.ui.fragment.BaseReactionFragment;
import com.facebook.reaction.ui.recyclerview.AbstractReactionRecyclerViewAdapter;
import com.facebook.search.fragment.GraphSearchChildFragment.OnResultClickListener;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.api.SearchResultsSource;
import com.facebook.search.logging.api.SearchTypeaheadSession;
import com.facebook.search.model.GraphSearchQuerySpec;
import com.facebook.search.model.ReactionSearchData;
import com.facebook.search.results.fragment.GraphSearchResultFragment;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Strings;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SEE_MORE_POSTS_TAPPED */
public class SearchResultsReactionFragment extends BaseReactionFragment implements AnalyticsFragmentWithExtraData, GraphSearchResultFragment {
    private static final String f23143a = SearchResultsReactionFragment.class.getSimpleName();
    private long aA = 0;
    public Long aB;
    public String aC;
    public String aD;
    public String aE;
    public SearchResultsSource aF;
    public Surface aG;
    public long aH;
    private long aI;
    private boolean aJ = false;
    private boolean aK = false;
    private boolean aL = false;
    private boolean aM = false;
    private boolean aN = false;
    @Inject
    private Lazy<ComposerPublishServiceHelper> am;
    @Inject
    @LocalBroadcast
    public BaseFbBroadcastManager an;
    @Inject
    private AbstractFbErrorReporter ao;
    @Inject
    @ForUiThread
    public Handler ap;
    @Inject
    private LocalSERPAnalyticsLogger aq;
    @Inject
    public NavigationLogger ar;
    @Inject
    private ReactionAnalyticsLogger as;
    @Inject
    public ReactionPerfLogger at;
    @Inject
    private ReactionSessionHelper au;
    @Inject
    private Lazy<ReactionReviewUpdateHandler> av;
    public final SearchResultsMutableContext aw = new SearchResultsMutableContext();
    public SelfRegistrableReceiverImpl ax;
    public SelfRegistrableReceiverImpl ay;
    public Bundle az = new Bundle();

    /* compiled from: SEE_MORE_POSTS_TAPPED */
    public class C24863 implements Runnable {
        final /* synthetic */ SearchResultsReactionFragment f23137a;

        public C24863(SearchResultsReactionFragment searchResultsReactionFragment) {
            this.f23137a = searchResultsReactionFragment;
        }

        public void run() {
            this.f23137a.ar.a(this.f23137a, this.f23137a.getContext());
        }
    }

    /* compiled from: SEE_MORE_POSTS_TAPPED */
    public class C24874 implements ActionReceiver {
        final /* synthetic */ SearchResultsReactionFragment f23138a;

        public C24874(SearchResultsReactionFragment searchResultsReactionFragment) {
            this.f23138a = searchResultsReactionFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1673889072);
            if (this.f23138a.aH > 0) {
                SearchResultsReactionFragment.m26796a(this.f23138a, this.f23138a.aQ() - this.f23138a.aH);
            }
            this.f23138a.aH = 0;
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 255376323, a);
        }
    }

    /* compiled from: SEE_MORE_POSTS_TAPPED */
    public class C24885 implements ActionReceiver {
        final /* synthetic */ SearchResultsReactionFragment f23139a;

        public C24885(SearchResultsReactionFragment searchResultsReactionFragment) {
            this.f23139a = searchResultsReactionFragment;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 538775517);
            this.f23139a.aH = this.f23139a.aQ();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1963806302, a);
        }
    }

    /* compiled from: SEE_MORE_POSTS_TAPPED */
    public /* synthetic */ class C24907 {
        public static final /* synthetic */ int[] f23142a = new int[Surface.values().length];

        static {
            try {
                f23142a[Surface.ANDROID_SEARCH_LOCAL_NULL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f23142a[Surface.ANDROID_SEARCH_LOCAL_PLACE_TIPS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f23142a[Surface.ANDROID_SEARCH_LOCAL_PLACE_TIPS_CHECKIN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f23142a[Surface.ANDROID_SEARCH_LOCAL_PLACE_TIPS_LOCATION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f23142a[Surface.ANDROID_SEARCH_LOCAL_SINGLE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f23142a[Surface.ANDROID_SEARCH_LOCAL_TYPEAHEAD.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f23142a[Surface.ANDROID_SEARCH_LOCAL_PUSH.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static void m26799a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((SearchResultsReactionFragment) obj).m26797a(IdBasedLazy.a(injectorLike, 5272), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), new LocalSERPAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike)), NavigationLogger.a(injectorLike), ReactionAnalyticsLogger.m22814a(injectorLike), ReactionPerfLogger.a(injectorLike), ReactionSessionHelper.m22580b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 10087));
    }

    private void m26797a(Lazy<ComposerPublishServiceHelper> lazy, FbBroadcastManager fbBroadcastManager, FbErrorReporter fbErrorReporter, Handler handler, LocalSERPAnalyticsLogger localSERPAnalyticsLogger, NavigationLogger navigationLogger, ReactionAnalyticsLogger reactionAnalyticsLogger, ReactionPerfLogger reactionPerfLogger, ReactionSessionHelper reactionSessionHelper, Lazy<ReactionReviewUpdateHandler> lazy2) {
        this.am = lazy;
        this.an = fbBroadcastManager;
        this.ao = fbErrorReporter;
        this.ap = handler;
        this.aq = localSERPAnalyticsLogger;
        this.ar = navigationLogger;
        this.as = reactionAnalyticsLogger;
        this.at = reactionPerfLogger;
        this.au = reactionSessionHelper;
        this.av = lazy2;
    }

    static /* synthetic */ long m26796a(SearchResultsReactionFragment searchResultsReactionFragment, long j) {
        long j2 = searchResultsReactionFragment.aI + j;
        searchResultsReactionFragment.aI = j2;
        return j2;
    }

    public final void m26815g(boolean z) {
        if (z) {
            super.g(z);
            av();
            return;
        }
        aw();
        super.g(z);
    }

    public final void mo743c(@Nullable Bundle bundle) {
        Class cls = SearchResultsReactionFragment.class;
        m26799a((Object) this, getContext());
        if (bundle != null) {
            if (bundle.containsKey("place_id")) {
                this.aB = Long.valueOf(bundle.getLong("place_id"));
            }
            if (bundle.containsKey("ranking_data")) {
                this.aC = bundle.getString("ranking_data");
            }
            if (bundle.containsKey("semantic")) {
                this.aD = bundle.getString("semantic");
            }
            if (bundle.containsKey("reaction_session_id")) {
                this.aE = bundle.getString("reaction_session_id");
            }
            if (bundle.containsKey("search_results_source")) {
                this.aF = SearchResultsSource.a(bundle.getString("search_results_source"));
            }
            if (bundle.containsKey("reaction_surface")) {
                this.aG = Surface.valueOf(bundle.getString("reaction_surface"));
            }
            if (bundle.getParcelable("extra_logging_data") instanceof Bundle) {
                this.az = (Bundle) bundle.getParcelable("extra_logging_data");
            }
        }
        if (!(TextUtils.isEmpty(this.aE) || this.aG == null)) {
            this.at.a(1966090, this.aE);
            this.at.a(1966092, this.aE, this.aG);
            aX();
        }
        super.mo743c(bundle);
        this.ax = this.an.a().a(AppStateManager.b, new C24874(this)).a();
        this.ax.b();
        this.ay = this.an.a().a(AppStateManager.c, new C24885(this)).a();
        this.ay.b();
        m26798a(this.aF);
        aZ();
    }

    public final void m26804a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        AbstractReactionRecyclerViewAdapter abstractReactionRecyclerViewAdapter = this.at;
        abstractReactionRecyclerViewAdapter.f10462h = this.aw;
        if (abstractReactionRecyclerViewAdapter.mo716e() > 0) {
            this.ay = false;
            this.aJ = true;
            au();
        }
    }

    public final void m26814e(Bundle bundle) {
        super.e(bundle);
        if (bundle != null) {
            if (this.aB != null) {
                bundle.putLong("place_id", this.aB.longValue());
            }
            if (!TextUtils.isEmpty(this.aC)) {
                bundle.putString("ranking_data", this.aC);
            }
            if (!TextUtils.isEmpty(this.aD)) {
                bundle.putString("semantic", this.aD);
            }
            if (!TextUtils.isEmpty(this.aE)) {
                bundle.putString("reaction_session_id", this.aE);
            }
            if (this.aF != null) {
                bundle.putString("search_results_source", this.aF.toString());
            }
            if (this.aG != null) {
                bundle.putString("reaction_surface", this.aG.name());
            }
            if (this.az != null && !this.az.isEmpty()) {
                bundle.putParcelable("extra_logging_data", this.az);
            }
        }
    }

    public final void m26803a(int i, int i2, Intent intent) {
        if (i == UnitInteractionType.WRITE_REVIEW_TAP.ordinal() && i2 == -1) {
            String stringExtra = intent.getStringExtra("reaction_unit_id");
            if (stringExtra == null) {
                this.ao.b(f23143a, "WRITE_REVIEW_TAP should have value for EXTRA_REACTION_UNIT_ID in the return intent");
                return;
            }
            ((ReactionReviewUpdateHandler) this.av.get()).m24390a(i2, intent, am_(), stringExtra, this, this.aB, this.aD);
        } else if (i == UnitInteractionType.CHECKIN_TAP.ordinal() && i2 == -1 && intent != null) {
            PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
            if (!(publishPostParams == null || Strings.isNullOrEmpty(publishPostParams.composerSessionId))) {
                this.au.f18691b.m22611a(publishPostParams.composerSessionId, getSessionId());
                this.au.f18691b.m22608a(publishPostParams.composerSessionId);
            }
            ((ComposerPublishServiceHelper) this.am.get()).c(intent);
        }
    }

    public final long av() {
        if (!this.y || !D() || !this.aJ) {
            return 0;
        }
        long av = super.av();
        if (this.aA == 0) {
            this.aA = av;
        }
        HandlerDetour.a(this.ap, new C24863(this), -2050278874);
        return av;
    }

    public final long aw() {
        if (!D()) {
            return 0;
        }
        if (at() && !this.aL) {
            String sessionId = getSessionId();
            if (!"NO_SESSION_ID".equals(sessionId)) {
                this.at.c(1966092, sessionId);
                this.at.c(1966089, sessionId);
                this.at.c(1966091, sessionId);
            }
            this.aL = true;
        }
        return super.aw();
    }

    public final void mo1303I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1567990443);
        long aQ = (aQ() - this.aA) - this.aI;
        if (getInteractionTracker() != null) {
            getInteractionTracker().m18926a(aQ, this.aB);
            if (at()) {
                getInteractionTracker().m18928a(aQ, this.aB, this.aw.f23370e, this.aw.f23369d.b);
            } else {
                this.aq.m17400a(getSessionId(), getSurface(), this.aw.mo1211a(), this.aF.toString(), this.aw.f23370e, this.aw.f23369d.c, this.aw.f23369d.b, this.aw.jH_());
            }
        }
        if (this.ax != null) {
            this.ax.c();
        }
        if (this.ay != null) {
            this.ay.c();
        }
        super.mo1303I();
        LogUtils.f(926002031, a);
    }

    public final String am_() {
        return "graph_search_results_page_reaction";
    }

    public final Map<String, Object> m26812c() {
        Map<String, Object> a = SearchResultsLogger.m25462a(this.aw.f23370e);
        a.put("reaction_session_id", getSessionId());
        if (this.aD != null) {
            a.put("semantic", this.aD);
        }
        if (this.aB != null) {
            a.put("place_id", this.aB);
        }
        return a;
    }

    public final void mo726a(ReactionStories reactionStories) {
        super.mo726a(reactionStories);
        final String sessionId = getSessionId();
        if (!"NO_SESSION_ID".equals(sessionId)) {
            HandlerDetour.a(this.ap, new Runnable(this) {
                final /* synthetic */ SearchResultsReactionFragment f23134b;

                public void run() {
                    this.f23134b.at.a(1966093, sessionId);
                }
            }, -520391613);
        }
    }

    protected final ReactionSession ax() {
        if ((this.aB == null && TextUtils.isEmpty(this.aD)) || this.aG == null) {
            this.ao.b(getClass().getSimpleName(), "missing session data - surface: " + this.aG + " pageId: " + this.aB + " semantic: " + this.aD);
        }
        this.ay = true;
        String str = !Strings.isNullOrEmpty(this.aD) ? this.aD : this.aC;
        ReactionSessionHelper reactionSessionHelper = this.au;
        String str2 = this.aE;
        Surface surface = this.aG;
        ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
        reactionQueryParams.f18624e = str;
        ReactionQueryParams reactionQueryParams2 = reactionQueryParams;
        reactionQueryParams2.f18631l = this.aB;
        reactionQueryParams2 = reactionQueryParams2;
        reactionQueryParams2.f18639t = this.aB;
        return reactionSessionHelper.m22585a(str2, surface, reactionQueryParams2);
    }

    public final Fragment mo1192b() {
        return this;
    }

    public final void mo1281a(GraphSearchQuerySpec graphSearchQuerySpec, SearchTypeaheadSession searchTypeaheadSession, SearchResultsSource searchResultsSource) {
        m26798a(searchResultsSource);
        ReactionSearchData m = graphSearchQuerySpec.mo1221m();
        if (m != null) {
            Long l;
            String str = m.f22246a;
            if (Strings.isNullOrEmpty(str)) {
                l = null;
            } else {
                l = Long.valueOf(Long.parseLong(str));
            }
            this.aB = l;
            this.aC = m.f22247b;
            this.aD = m.f22248c;
            this.aE = m.f22249d;
            this.aG = m.f22250e;
        }
        this.aw.m27087a(graphSearchQuerySpec, searchTypeaheadSession, searchResultsSource);
        if (this.az == null) {
            this.az = new Bundle();
        } else {
            this.az.clear();
        }
        this.az.putString("candidate_result_sid", this.aw.f23369d.c);
        this.az.putString("query", this.aw.mo1211a());
        this.az.putString("results_vertical", this.aw.jH_());
        this.az.putString("search_ts_token", this.aw.f23370e);
        this.az.putString("typeahead_sid", this.aw.f23369d.b);
        aZ();
    }

    public final boolean mo1191a(boolean z) {
        return false;
    }

    public final void mo1190a(OnResultClickListener onResultClickListener) {
    }

    @Nullable
    protected final String aB() {
        return this.aE;
    }

    protected final void mo1304a(@Nullable ReactionSession reactionSession) {
        super.mo1304a(reactionSession);
        if (this.at.mo715d() > 0) {
            this.aJ = true;
            av();
        }
        String str = null;
        switch (C24907.f23142a[reactionSession.f18660c.ordinal()]) {
            case 1:
                str = "517105395138503";
                break;
            case 2:
            case 3:
            case 4:
                str = "1705302933021543";
                break;
            case 5:
                str = "1528797434114560";
                break;
            case 6:
                str = "1761511150749287";
                break;
            case 7:
                str = "566380456861524";
                break;
        }
        if (!Strings.isNullOrEmpty(str)) {
            Intent intent = new Intent();
            intent.putExtra("try_show_survey_on_result_integration_point_id", str);
            Bundle bundle = new Bundle();
            if (this.aw.f23382q != null) {
                bundle.putString("results_vertical", this.aw.f23382q);
            }
            if (this.aw.mo1212b() != null) {
                bundle.putString("query_function", this.aw.mo1212b());
            }
            if (this.aw.mo1211a() != null) {
                bundle.putString("query", this.aw.mo1211a());
            }
            if (this.aw.f23367b != null) {
                bundle.putString("results_source", this.aw.f23367b.toString());
            }
            if (!(this.aw.f23369d == null || TextUtils.isEmpty(this.aw.f23369d.b))) {
                bundle.putString("typeahead_sid", this.aw.f23369d.b);
            }
            bundle.putString("reaction_session_id", reactionSession.f18658a);
            intent.putExtra("try_show_survey_on_result_extra_data", bundle);
            ao().setResult(-1, intent);
        }
    }

    protected final void mo1307b(String str) {
    }

    private void au() {
        ReactionSession reactionSession = this.av;
        if (!at() && reactionSession != null) {
            m26801d(reactionSession);
            this.aK = true;
            final String str = reactionSession.f18658a;
            HandlerDetour.a(this.ap, new Runnable(this) {
                final /* synthetic */ SearchResultsReactionFragment f23141b;

                public void run() {
                    this.f23141b.at.a(1966092, str);
                    this.f23141b.at.a(1966082, str, "network_response:return_early");
                    this.f23141b.at.a(1966082, str);
                }
            }, -431659718);
        }
    }

    public final void kQ_() {
        ReactionSession reactionSession = this.av;
        if (this.aM || reactionSession == null) {
            super.kQ_();
            return;
        }
        m26801d(reactionSession);
        this.aM = true;
        final String str = reactionSession.f18658a;
        Surface surface = reactionSession.f18660c;
        this.at.a(1966089, str, surface);
        super.kQ_();
        this.at.a(1966091, str, surface);
        HandlerDetour.a(this.ap, new Runnable(this) {
            final /* synthetic */ SearchResultsReactionFragment f23136b;

            public void run() {
                this.f23136b.at.a(1966091, str);
                this.f23136b.at.a(1966089, str);
                this.f23136b.at.a(1966092, str);
                this.f23136b.at.a(1966082, str, "network_response:return_late");
                this.f23136b.at.a(1966082, str);
            }
        }, 2054403200);
    }

    private boolean at() {
        return this.aM || this.aK;
    }

    private void m26801d(ReactionSession reactionSession) {
        this.as.m22820a(reactionSession, this.aw.mo1211a(), this.aF.toString(), this.aw.f23370e, this.aw.f23369d.c, this.aw.f23369d.b, this.aw.jH_());
    }

    private void aX() {
        if (!this.aN && this.aF != null) {
            this.aq.m17401b(this.aE, this.aG, this.aw.mo1211a(), this.aF.toString(), this.aw.f23370e, this.aw.f23369d.c, this.aw.f23369d.b, this.aw.jH_());
            this.aN = true;
        }
    }

    private void aZ() {
        if (this.az != null && !this.az.isEmpty() && getInteractionTracker() != null) {
            getInteractionTracker().f16097b = this.az;
        }
    }

    private void m26798a(SearchResultsSource searchResultsSource) {
        this.aF = searchResultsSource;
        if (this.aF != null && getInteractionTracker() != null) {
            getInteractionTracker().f16106k = this.aF.toString();
        }
    }
}
