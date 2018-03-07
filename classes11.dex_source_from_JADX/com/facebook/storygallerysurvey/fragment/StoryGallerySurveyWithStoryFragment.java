package com.facebook.storygallerysurvey.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.FindViewUtil;
import com.facebook.debug.log.BLog;
import com.facebook.feed.menu.newsfeed.NewsFeedStoryMenuHelperFactory;
import com.facebook.feed.rows.NewsFeedRootGroupPartDefinition;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feedplugins.storygallerysurvey.constants.StoryGallerySurveyConstants.ActionType;
import com.facebook.feedplugins.storygallerysurvey.constants.StoryGallerySurveyConstants.Rating;
import com.facebook.feedplugins.storygallerysurvey.logger.StoryGallerySurveyLogger;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.storygallerysurvey.activity.StoryGallerySurveyWithStoryActivity;
import com.facebook.storygallerysurvey.controllers.StoryGallerySurveyWithStoryController;
import com.facebook.storygallerysurvey.fetchers.StoryGallerySurveyWithStoryFetcher;
import com.facebook.storygallerysurvey.fetchers.StoryGallerySurveyWithStoryFetcher.C15261;
import com.facebook.storygallerysurvey.fetchers.StoryGallerySurveyWithStoryFetcher.C15272;
import com.facebook.storygallerysurvey.model.StoryGallerySurveyWithStoryCollection;
import com.facebook.storygallerysurvey.popover.StoryGallerySurveyWithStoryFinishPopoverWindow;
import com.facebook.storygallerysurvey.protocol.FetchStoryGallerySurveyWithStoryGraphQLModels.FetchStoryGallerySurveyWithStoryQueryModel.StoryGallerySurveyModel.NodesModel;
import com.facebook.storygallerysurvey.rows.StoryGallerySurveyWithStoryEnvironment;
import com.facebook.storygallerysurvey.rows.StoryGallerySurveyWithStoryEnvironmentProvider;
import com.facebook.storygallerysurvey.rows.StoryGallerySurveyWithStoryListType;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import java.util.List;
import javax.inject.Inject;

/* compiled from: Not completed successfully */
public class StoryGallerySurveyWithStoryFragment extends FbFragment {
    private static final Class<?> f12950h = StoryGallerySurveyWithStoryFragment.class;
    @Inject
    AbstractFbErrorReporter f12951a;
    private TextView al;
    private LinearLayout am;
    private RadioButton an;
    private RadioButton ao;
    private RadioButton ap;
    private ScrollingViewProxy aq;
    private LoadingIndicatorView ar;
    private StoryGallerySurveyWithStoryController as;
    public MultiRowAdapter at;
    private StoryGallerySurveyWithStoryCollection au;
    public int av;
    public float aw = -1.0f;
    public int ax = -1;
    public boolean ay;
    @Inject
    StoryGallerySurveyWithStoryFetcher f12952b;
    @Inject
    MultipleRowsStoriesRecycleCallback f12953c;
    @Inject
    MultiRowAdapterBuilder f12954d;
    @Inject
    Lazy<NewsFeedRootGroupPartDefinition> f12955e;
    @Inject
    StoryGallerySurveyLogger f12956f;
    @Inject
    StoryGallerySurveyWithStoryEnvironmentProvider f12957g;
    private FbTitleBar f12958i;

    /* compiled from: Not completed successfully */
    class C15291 implements OnClickListener {
        final /* synthetic */ StoryGallerySurveyWithStoryFragment f12942a;

        C15291(StoryGallerySurveyWithStoryFragment storyGallerySurveyWithStoryFragment) {
            this.f12942a = storyGallerySurveyWithStoryFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1580280925);
            StoryGallerySurveyWithStoryFragment.aA(this.f12942a);
            Logger.a(2, EntryType.UI_INPUT_END, 481012666, a);
        }
    }

    /* compiled from: Not completed successfully */
    class C15302 implements OnClickListener {
        final /* synthetic */ StoryGallerySurveyWithStoryFragment f12943a;

        C15302(StoryGallerySurveyWithStoryFragment storyGallerySurveyWithStoryFragment) {
            this.f12943a = storyGallerySurveyWithStoryFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1649502268);
            this.f12943a.m13644a(Rating.PREF_FIRST);
            Logger.a(2, EntryType.UI_INPUT_END, -114292201, a);
        }
    }

    /* compiled from: Not completed successfully */
    class C15313 implements OnClickListener {
        final /* synthetic */ StoryGallerySurveyWithStoryFragment f12944a;

        C15313(StoryGallerySurveyWithStoryFragment storyGallerySurveyWithStoryFragment) {
            this.f12944a = storyGallerySurveyWithStoryFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 254235286);
            this.f12944a.m13644a(Rating.PREF_SKIP);
            Logger.a(2, EntryType.UI_INPUT_END, -1091785106, a);
        }
    }

    /* compiled from: Not completed successfully */
    class C15324 implements OnClickListener {
        final /* synthetic */ StoryGallerySurveyWithStoryFragment f12945a;

        C15324(StoryGallerySurveyWithStoryFragment storyGallerySurveyWithStoryFragment) {
            this.f12945a = storyGallerySurveyWithStoryFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1828584508);
            this.f12945a.m13644a(Rating.PREF_SECOND);
            Logger.a(2, EntryType.UI_INPUT_END, 1278768115, a);
        }
    }

    /* compiled from: Not completed successfully */
    public class C15335 {
        final /* synthetic */ StoryGallerySurveyWithStoryFragment f12946a;

        C15335(StoryGallerySurveyWithStoryFragment storyGallerySurveyWithStoryFragment) {
            this.f12946a = storyGallerySurveyWithStoryFragment;
        }

        public final boolean m13635a(MotionEvent motionEvent) {
            int i = 0;
            if (!StoryGallerySurveyWithStoryFragment.aB(this.f12946a)) {
                return true;
            }
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.f12946a.ax = MotionEventCompat.b(motionEvent, 0);
                    this.f12946a.aw = motionEvent.getX();
                    return false;
                case 1:
                case 3:
                    this.f12946a.ay = false;
                    this.f12946a.ax = -1;
                    return true;
                case 2:
                    float c = MotionEventCompat.c(motionEvent, MotionEventCompat.a(motionEvent, this.f12946a.ax));
                    float f = c - this.f12946a.aw;
                    if (!this.f12946a.ay && Math.abs(f) >= ((float) this.f12946a.av)) {
                        this.f12946a.ay = true;
                    }
                    if (!this.f12946a.ay) {
                        return true;
                    }
                    this.f12946a.aw = c;
                    return false;
                case 5:
                    i = MotionEventCompat.b(motionEvent);
                    this.f12946a.aw = MotionEventCompat.c(motionEvent, i);
                    this.f12946a.ax = MotionEventCompat.b(motionEvent, i);
                    return true;
                case 6:
                    int b = MotionEventCompat.b(motionEvent);
                    if (MotionEventCompat.b(motionEvent, b) == this.f12946a.ax) {
                        if (b == 0) {
                            i = 1;
                        }
                        this.f12946a.ax = MotionEventCompat.b(motionEvent, i);
                    }
                    this.f12946a.aw = MotionEventCompat.c(motionEvent, MotionEventCompat.a(motionEvent, this.f12946a.ax));
                    return true;
                default:
                    return true;
            }
        }
    }

    /* compiled from: Not completed successfully */
    class C15346 implements Runnable {
        final /* synthetic */ StoryGallerySurveyWithStoryFragment f12947a;

        C15346(StoryGallerySurveyWithStoryFragment storyGallerySurveyWithStoryFragment) {
            this.f12947a = storyGallerySurveyWithStoryFragment;
        }

        public void run() {
            this.f12947a.at.notifyDataSetChanged();
        }
    }

    /* compiled from: Not completed successfully */
    public class C15357 {
        final /* synthetic */ StoryGallerySurveyWithStoryFragment f12948a;

        C15357(StoryGallerySurveyWithStoryFragment storyGallerySurveyWithStoryFragment) {
            this.f12948a = storyGallerySurveyWithStoryFragment;
        }

        public final void m13636a() {
            StoryGallerySurveyWithStoryFragment.aA(this.f12948a);
        }
    }

    /* compiled from: Not completed successfully */
    public class StoryGallerySurveyWithStoryControllerCallback {
        final /* synthetic */ StoryGallerySurveyWithStoryFragment f12949a;

        public StoryGallerySurveyWithStoryControllerCallback(StoryGallerySurveyWithStoryFragment storyGallerySurveyWithStoryFragment) {
            this.f12949a = storyGallerySurveyWithStoryFragment;
        }

        public final void m13637a() {
            StoryGallerySurveyWithStoryFragment.as(this.f12949a);
        }

        public final void m13638b() {
            StoryGallerySurveyWithStoryFragment.at(this.f12949a);
        }

        public final void m13639c() {
            StoryGallerySurveyWithStoryFragment.az(this.f12949a);
        }
    }

    private static <T extends InjectableComponentWithContext> void m13647a(Class<T> cls, T t) {
        m13648a((Object) t, t.getContext());
    }

    private static void m13648a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((StoryGallerySurveyWithStoryFragment) obj).m13643a((AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), StoryGallerySurveyWithStoryFetcher.m13634b(fbInjector), MultipleRowsStoriesRecycleCallback.a(fbInjector), MultiRowAdapterBuilder.b(fbInjector), IdBasedLazy.a(fbInjector, 1480), StoryGallerySurveyLogger.m10068b(fbInjector), (StoryGallerySurveyWithStoryEnvironmentProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(StoryGallerySurveyWithStoryEnvironmentProvider.class));
    }

    private void m13643a(FbErrorReporter fbErrorReporter, StoryGallerySurveyWithStoryFetcher storyGallerySurveyWithStoryFetcher, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<NewsFeedRootGroupPartDefinition> lazy, StoryGallerySurveyLogger storyGallerySurveyLogger, StoryGallerySurveyWithStoryEnvironmentProvider storyGallerySurveyWithStoryEnvironmentProvider) {
        this.f12951a = fbErrorReporter;
        this.f12952b = storyGallerySurveyWithStoryFetcher;
        this.f12953c = multipleRowsStoriesRecycleCallback;
        this.f12954d = multiRowAdapterBuilder;
        this.f12955e = lazy;
        this.f12956f = storyGallerySurveyLogger;
        this.f12957g = storyGallerySurveyWithStoryEnvironmentProvider;
    }

    public final void m13666c(Bundle bundle) {
        super.c(bundle);
        m13647a(StoryGallerySurveyWithStoryFragment.class, (InjectableComponentWithContext) this);
        this.as = new StoryGallerySurveyWithStoryController(this.f12951a, this.f12952b);
    }

    public final View m13664a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -91557986);
        this.av = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        View inflate = layoutInflater.inflate(2130907252, viewGroup, false);
        this.al = (TextView) inflate.findViewById(2131567694);
        this.am = (LinearLayout) inflate.findViewById(2131567696);
        this.an = (RadioButton) inflate.findViewById(2131567697);
        this.ao = (RadioButton) inflate.findViewById(2131567699);
        this.ap = (RadioButton) inflate.findViewById(2131567701);
        this.aq = m13651b(inflate);
        this.ar = (LoadingIndicatorView) inflate.findViewById(2131567693);
        m13652b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 511489758, a);
        return inflate;
    }

    public final void m13665a(View view, Bundle bundle) {
        super.a(view, bundle);
        FbTitleBarUtil.a(view);
        this.f12958i = (FbTitleBar) e(2131558563);
        this.f12958i.a(new C15291(this));
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -910987155);
        super.mi_();
        this.as.f12931e = new StoryGallerySurveyWithStoryControllerCallback(this);
        StoryGallerySurveyWithStoryController storyGallerySurveyWithStoryController = this.as;
        StoryGallerySurveyWithStoryFetcher storyGallerySurveyWithStoryFetcher = storyGallerySurveyWithStoryController.f12929c;
        FutureCallback futureCallback = storyGallerySurveyWithStoryController.f12930d;
        if (futureCallback != null) {
            storyGallerySurveyWithStoryFetcher.f12939b.a(null, new C15261(storyGallerySurveyWithStoryFetcher), new C15272(storyGallerySurveyWithStoryFetcher, futureCallback));
        }
        this.ar.a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1270861911, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1048619001);
        super.mY_();
        if (this.at != null) {
            this.at.jc_();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1281097894, a);
    }

    private void m13652b() {
        m13657e();
        ar();
    }

    private void m13657e() {
        this.an.setOnClickListener(new C15302(this));
        this.ao.setOnClickListener(new C15313(this));
        this.ap.setOnClickListener(new C15324(this));
    }

    private void m13644a(Rating rating) {
        m13653b(rating);
        aq();
    }

    private void aq() {
        if (this.as != null) {
            StoryGallerySurveyWithStoryController storyGallerySurveyWithStoryController = this.as;
            if (storyGallerySurveyWithStoryController.f12933g >= storyGallerySurveyWithStoryController.f12932f.size() - 1) {
                storyGallerySurveyWithStoryController.f12931e.m13639c();
                return;
            } else {
                storyGallerySurveyWithStoryController.f12931e.m13638b();
                return;
            }
        }
        BLog.b(f12950h, "Fail to initialize story gallery survey controller");
    }

    private ScrollingViewProxy m13651b(View view) {
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) ((ViewStub) FindViewUtil.b(view, 2131567703)).inflate();
        betterRecyclerView.setLayoutManager(new LayoutManagerWithKeepAttachedHack(betterRecyclerView));
        return new RecyclerViewProxy(betterRecyclerView);
    }

    private void m13653b(Rating rating) {
        StoryGallerySurveyLogger storyGallerySurveyLogger = this.f12956f;
        int e = this.as.m13631e();
        int d = this.as.m13630d();
        List list = this.au.f12960b;
        storyGallerySurveyLogger.f9527b.c(new HoneyClientEvent(rating.toEventName()).a("count", e).a("final_count", d).b("selection", rating.toString()).b("first_story_tracking_data", (String) list.get(0)).b("second_story_tracking_data", (String) list.get(1)));
    }

    private void ar() {
        this.aq.a(new C15335(this));
        this.aq.a(this.f12953c.a());
        this.aq.f(this.ar);
    }

    public static void as(StoryGallerySurveyWithStoryFragment storyGallerySurveyWithStoryFragment) {
        storyGallerySurveyWithStoryFragment.al.setVisibility(0);
        storyGallerySurveyWithStoryFragment.am.setVisibility(0);
    }

    public static void at(StoryGallerySurveyWithStoryFragment storyGallerySurveyWithStoryFragment) {
        storyGallerySurveyWithStoryFragment.al.setText(storyGallerySurveyWithStoryFragment.au());
        storyGallerySurveyWithStoryFragment.av();
        storyGallerySurveyWithStoryFragment.ax();
    }

    private String au() {
        return "(" + (this.as.m13631e() + 1) + " of " + this.as.m13630d() + ")";
    }

    private void av() {
        ay();
        if (this.at == null) {
            this.at = m13642a(aw());
            this.aq.a(this.at);
            return;
        }
        this.at.notifyDataSetChanged();
    }

    private MultiRowAdapter m13642a(StoryGallerySurveyWithStoryEnvironment storyGallerySurveyWithStoryEnvironment) {
        Builder a = this.f12954d.a(this.f12955e, this.au);
        a.f = storyGallerySurveyWithStoryEnvironment;
        return a.e();
    }

    private StoryGallerySurveyWithStoryEnvironment aw() {
        return new StoryGallerySurveyWithStoryEnvironment(getContext(), StoryGallerySurveyWithStoryListType.f12971a, new C15346(this), NewsFeedStoryMenuHelperFactory.a(this.f12957g));
    }

    private void ax() {
        this.an.setChecked(false);
        this.ao.setChecked(false);
        this.ap.setChecked(false);
    }

    private void ay() {
        if (this.au == null) {
            this.au = new StoryGallerySurveyWithStoryCollection(this.as.m13629c());
            return;
        }
        StoryGallerySurveyWithStoryCollection storyGallerySurveyWithStoryCollection = this.au;
        ImmutableList c = this.as.m13629c();
        storyGallerySurveyWithStoryCollection.f12959a.clear();
        storyGallerySurveyWithStoryCollection.f12960b.clear();
        int size = c.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) c.get(i);
            storyGallerySurveyWithStoryCollection.f12959a.add(nodesModel.m13681a());
            storyGallerySurveyWithStoryCollection.f12960b.add(nodesModel.m13683j());
        }
    }

    public static void az(StoryGallerySurveyWithStoryFragment storyGallerySurveyWithStoryFragment) {
        storyGallerySurveyWithStoryFragment.ax();
        storyGallerySurveyWithStoryFragment.f12956f.m10070a(ActionType.FINISH, ((StoryGallerySurveyWithStoryActivity) storyGallerySurveyWithStoryFragment.o()).f12925p);
        StoryGallerySurveyWithStoryFinishPopoverWindow storyGallerySurveyWithStoryFinishPopoverWindow = new StoryGallerySurveyWithStoryFinishPopoverWindow(storyGallerySurveyWithStoryFragment.getContext());
        storyGallerySurveyWithStoryFinishPopoverWindow.f12962a = new C15357(storyGallerySurveyWithStoryFragment);
        storyGallerySurveyWithStoryFinishPopoverWindow.a(storyGallerySurveyWithStoryFragment.T);
    }

    public static void aA(StoryGallerySurveyWithStoryFragment storyGallerySurveyWithStoryFragment) {
        Activity ao = storyGallerySurveyWithStoryFragment.ao();
        if (ao != null) {
            ao.onBackPressed();
        }
    }

    public static boolean aB(StoryGallerySurveyWithStoryFragment storyGallerySurveyWithStoryFragment) {
        if (storyGallerySurveyWithStoryFragment.au == null || storyGallerySurveyWithStoryFragment.au.m13667a() != 2) {
            return false;
        }
        if (m13649a(storyGallerySurveyWithStoryFragment.au.m13669b(0)) && m13649a(storyGallerySurveyWithStoryFragment.au.m13669b(1))) {
            return true;
        }
        return false;
    }

    private static boolean m13649a(GraphQLStory graphQLStory) {
        if (StoryAttachmentHelper.o(graphQLStory) == null || StoryAttachmentHelper.o(graphQLStory).w().indexOf(GraphQLStoryAttachmentStyle.MULTI_SHARE) == -1) {
            return false;
        }
        return true;
    }
}
