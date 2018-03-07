package com.facebook.feedback.reactions.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.api.feed.data.AppendOnlyGraphQLObjectCollection;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.Tuple;
import com.facebook.fbui.pagerindicator.ColorInterpolatorHelper;
import com.facebook.fbui.pagerindicator.ColoredTabProgressListenerBadgeTextView;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator.OnTabClickListener;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.ui.logging.ReactorsListLogger;
import com.facebook.feedback.reactions.ui.logging.ReactorsListLogger.NavigationReason;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.ufiservices.flyout.ProfileListParams;
import com.facebook.ui.errordialog.ErrorMessageGenerator;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;

/* compiled from: share_body_text_prefill */
public abstract class TabbedReactorsListFragment extends FbFragment implements AnalyticsFragment {
    private final Comparator f3868a = new C03421(this);
    @Inject
    public QuickPerformanceLogger al;
    public ViewPager am;
    public TabbedViewPagerIndicator an;
    public ReactorViewPagerAdapter ao;
    public ProfileListParams ap;
    private View aq;
    public String ar;
    public Resources as;
    public HashMap<FeedbackReaction, Integer> at;
    public boolean au = false;
    public int av = 25;
    public int aw = 25;
    public int ax = 25;
    public int ay = 0;
    @Inject
    IFeedIntentBuilder f3869b;
    @Inject
    GraphQLLinkExtractor f3870c;
    @Inject
    ReactorsListLogger f3871d;
    @Inject
    public ErrorMessageGenerator f3872e;
    @Inject
    NumberTruncationUtil f3873f;
    @Inject
    public ReactorsLoader f3874g;
    @Inject
    TabbedReactorsListTransformer f3875h;
    @Inject
    FeedbackReactionsController f3876i;

    /* compiled from: share_body_text_prefill */
    class C03421 implements Comparator<Tuple<FeedbackReaction, AppendOnlyGraphQLObjectCollection<ActorReactionPair>>> {
        final /* synthetic */ TabbedReactorsListFragment f3941a;

        C03421(TabbedReactorsListFragment tabbedReactorsListFragment) {
            this.f3941a = tabbedReactorsListFragment;
        }

        public int compare(Object obj, Object obj2) {
            return TabbedReactorsListFragment.m4509f(this.f3941a, (FeedbackReaction) ((Tuple) obj2).a) - TabbedReactorsListFragment.m4509f(this.f3941a, (FeedbackReaction) ((Tuple) obj).a);
        }
    }

    /* compiled from: share_body_text_prefill */
    public class C03432 implements OnTabClickListener {
        final /* synthetic */ TabbedReactorsListFragment f3942a;

        public C03432(TabbedReactorsListFragment tabbedReactorsListFragment) {
            this.f3942a = tabbedReactorsListFragment;
        }

        public final void mo181a(int i, int i2) {
            if (this.f3942a.f3871d != null && this.f3942a.ao != null) {
                this.f3942a.au = true;
                FeedbackReaction e = ReactorViewPagerAdapter.m4578e(this.f3942a.ao, i);
                this.f3942a.f3871d.m4627a(NavigationReason.TAP, e);
                if (i == i2) {
                    View findViewWithTag = this.f3942a.am.findViewWithTag(e);
                    if (findViewWithTag != null) {
                        BetterListView betterListView = (BetterListView) findViewWithTag.findViewById(2131562222);
                        if (betterListView.getFirstVisiblePosition() > 20) {
                            betterListView.setSelection(20);
                        }
                        betterListView.smoothScrollToPosition(0);
                    }
                }
            }
        }
    }

    /* compiled from: share_body_text_prefill */
    public class C03443 implements OnPageChangeListener {
        final /* synthetic */ TabbedReactorsListFragment f3943a;

        public C03443(TabbedReactorsListFragment tabbedReactorsListFragment) {
            this.f3943a = tabbedReactorsListFragment;
        }

        public final void m4575a(int i, float f, int i2) {
            if (f != 0.0f) {
                this.f3943a.an.setUnderlineColor(ColorInterpolatorHelper.m4271a(f, TabbedReactorsListFragment.m4508d(ReactorViewPagerAdapter.m4578e(this.f3943a.ao, i)), TabbedReactorsListFragment.m4508d(ReactorViewPagerAdapter.m4578e(this.f3943a.ao, i + 1))));
            }
        }

        public final void e_(int i) {
            if (!(this.f3943a.f3871d == null || this.f3943a.ao == null || this.f3943a.au)) {
                this.f3943a.f3871d.m4627a(NavigationReason.SWIPE, ReactorViewPagerAdapter.m4578e(this.f3943a.ao, i));
            }
            this.f3943a.au = false;
        }

        public final void m4576b(int i) {
        }
    }

    /* compiled from: share_body_text_prefill */
    public class ReactionTypeRetryTrigger implements RetryClickedListener {
        final /* synthetic */ TabbedReactorsListFragment f3944a;
        private final FeedbackReaction f3945b;

        public ReactionTypeRetryTrigger(TabbedReactorsListFragment tabbedReactorsListFragment, FeedbackReaction feedbackReaction) {
            this.f3944a = tabbedReactorsListFragment;
            this.f3945b = feedbackReaction;
        }

        public final void m4577a() {
            this.f3944a.f3871d.f3969b.a(ReactorsListLogger.f3968a, "retry_load", "reaction_" + this.f3945b.e);
            this.f3944a.f3874g.m4562a(this.f3945b, 25, true);
        }
    }

    /* compiled from: share_body_text_prefill */
    public class ReactorViewPagerAdapter extends PagerAdapter {
        public final /* synthetic */ TabbedReactorsListFragment f3952a;
        private final List<Tuple<FeedbackReaction, AppendOnlyGraphQLObjectCollection<ActorReactionPair>>> f3953b;

        public ReactorViewPagerAdapter(TabbedReactorsListFragment tabbedReactorsListFragment, List<Tuple<FeedbackReaction, AppendOnlyGraphQLObjectCollection<ActorReactionPair>>> list) {
            this.f3952a = tabbedReactorsListFragment;
            this.f3953b = list;
        }

        public final int m4583b() {
            return this.f3953b.size();
        }

        public final CharSequence J_(int i) {
            return this.f3952a.m4517b(m4578e(this, i));
        }

        public static FeedbackReaction m4578e(ReactorViewPagerAdapter reactorViewPagerAdapter, int i) {
            if (i >= reactorViewPagerAdapter.m4583b()) {
                return FeedbackReaction.c;
            }
            return (FeedbackReaction) ((Tuple) reactorViewPagerAdapter.f3953b.get(i)).a;
        }

        public final boolean m4582a(View view, Object obj) {
            return view == obj;
        }

        public final Object m4579a(ViewGroup viewGroup, int i) {
            Object obj;
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(this.f3952a.mo180e(), viewGroup, false);
            final FeedbackReaction e = m4578e(this, i);
            final AppendOnlyGraphQLObjectCollection appendOnlyGraphQLObjectCollection = (AppendOnlyGraphQLObjectCollection) ((Tuple) this.f3953b.get(i)).b;
            final ListAdapter tabbedReactorsListAdapter = new TabbedReactorsListAdapter(appendOnlyGraphQLObjectCollection, this.f3952a.ap.g);
            BetterListView betterListView = (BetterListView) FindViewUtil.b(inflate, 2131562222);
            betterListView.setOnScrollListener(new OnScrollListener(this) {
                final /* synthetic */ ReactorViewPagerAdapter f3948c;

                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (i2 != 0 && (i + i2) + this.f3948c.f3952a.ay >= i3 && appendOnlyGraphQLObjectCollection.g) {
                        this.f3948c.f3952a.f3871d.f3969b.a(ReactorsListLogger.f3968a, "auto_load_more", "reaction_" + e.e);
                        this.f3948c.f3952a.f3874g.m4562a(e, this.f3948c.f3952a.ax, true);
                    }
                }

                public void onScrollStateChanged(AbsListView absListView, int i) {
                }
            });
            betterListView.setAdapter(tabbedReactorsListAdapter);
            betterListView.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ ReactorViewPagerAdapter f3951c;

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.f3951c.f3952a.m4516a(tabbedReactorsListAdapter.getItem(i));
                    this.f3951c.f3952a.f3871d.f3969b.a(ReactorsListLogger.f3968a, "profile_click", "reaction_" + e.e);
                }
            });
            inflate.setTag(e);
            viewGroup.addView(inflate);
            if (appendOnlyGraphQLObjectCollection == null || appendOnlyGraphQLObjectCollection.c() != 0) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                int i2;
                ReactorsLoader reactorsLoader = this.f3952a.f3874g;
                if (this.f3952a.am.k == i) {
                    i2 = this.f3952a.av;
                } else {
                    i2 = this.f3952a.aw;
                }
                reactorsLoader.m4562a(e, i2, true);
                ((LoadingIndicatorView) FindViewUtil.b(inflate, 2131562221)).a();
            }
            return inflate;
        }

        public final void m4580a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public final CharSequence m4584b(int i) {
            FeedbackReaction e = m4578e(this, i);
            if (ReactorsLoader.m4556c(e)) {
                return this.f3952a.m4517b(e);
            }
            return this.f3952a.as.getString(2131235960, new Object[]{Integer.valueOf(TabbedReactorsListFragment.m4509f(this.f3952a, e)), e.f});
        }

        public final void m4581a(TextView textView, int i) {
            FeedbackReaction e = m4578e(this, i);
            if (textView instanceof ColoredTabProgressListenerBadgeTextView) {
                ColoredTabProgressListenerBadgeTextView coloredTabProgressListenerBadgeTextView = (ColoredTabProgressListenerBadgeTextView) textView;
                coloredTabProgressListenerBadgeTextView.f3558b = TabbedReactorsListFragment.m4508d(e);
                coloredTabProgressListenerBadgeTextView.f3559c = this.f3952a.at();
            }
            TabbedReactorsListFragment tabbedReactorsListFragment = this.f3952a;
            int d = TabbedReactorsListFragment.m4508d(e);
            int at = tabbedReactorsListFragment.at();
            r5 = new int[2][];
            r5[0] = new int[]{16842913};
            r5[1] = new int[0];
            textView.setTextColor(new ColorStateList(r5, new int[]{d, at}));
        }
    }

    /* compiled from: share_body_text_prefill */
    public class TabbedReactorsLoaderConfiguration {
        public final /* synthetic */ TabbedReactorsListFragment f3954a;

        public TabbedReactorsLoaderConfiguration(TabbedReactorsListFragment tabbedReactorsListFragment) {
            this.f3954a = tabbedReactorsListFragment;
        }

        public final CallerContext m4585b() {
            return this.f3954a.ar();
        }
    }

    /* compiled from: share_body_text_prefill */
    public class TabbedReactorsLoaderListener {
        public final /* synthetic */ TabbedReactorsListFragment f3955a;

        public TabbedReactorsLoaderListener(TabbedReactorsListFragment tabbedReactorsListFragment) {
            this.f3955a = tabbedReactorsListFragment;
        }
    }

    public static void m4507a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((TabbedReactorsListFragment) obj).m4506a((IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), GraphQLLinkExtractor.a(injectorLike), new ReactorsListLogger(FunnelLoggerImpl.a(injectorLike)), ErrorMessageGenerator.b(injectorLike), NumberTruncationUtil.a(injectorLike), ReactorsLoader.m4555b(injectorLike), TabbedReactorsListTransformer.m4587a(injectorLike), FeedbackReactionsController.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike));
    }

    protected abstract int aq();

    protected abstract CallerContext ar();

    public abstract int mo180e();

    public void mo179c(Bundle bundle) {
        super.c(bundle);
        Class cls = TabbedReactorsListFragment.class;
        m4507a(this, getContext());
        this.ap = (ProfileListParams) this.s.getParcelable("profileListParams");
        this.at = au();
        this.f3874g.f3923i = new TabbedReactorsLoaderListener(this);
        this.f3874g.f3924j = new TabbedReactorsLoaderConfiguration(this);
        this.f3874g.m4561a();
        this.as = jW_();
    }

    private HashMap<FeedbackReaction, Integer> au() {
        HashMap hashMap;
        HashMap hashMap2;
        int i;
        HashMap<FeedbackReaction, Integer> hashMap3 = new HashMap();
        ProfileListParams profileListParams = this.ap;
        if (profileListParams.j != null) {
            hashMap = new HashMap(profileListParams.j);
        } else {
            hashMap = null;
        }
        HashMap hashMap4 = hashMap;
        if (hashMap4 == null) {
            hashMap2 = new HashMap();
        } else {
            hashMap2 = hashMap4;
        }
        ImmutableList immutableList = this.f3876i.d;
        int size = immutableList.size();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < size) {
            int i5;
            FeedbackReaction feedbackReaction = (FeedbackReaction) immutableList.get(i2);
            if (hashMap2.containsKey(Integer.valueOf(feedbackReaction.e))) {
                int intValue = ((Integer) hashMap2.get(Integer.valueOf(feedbackReaction.e))).intValue();
                hashMap3.put(feedbackReaction, Integer.valueOf(intValue));
                i = i4 + intValue;
                if (intValue > 0) {
                    i5 = i3 + 1;
                } else {
                    i5 = i3;
                }
            } else {
                hashMap3.put(feedbackReaction, Integer.valueOf(0));
                i5 = i3;
                i = i4;
            }
            i2++;
            i4 = i;
            i3 = i5;
        }
        i = i4;
        for (Integer num : hashMap2.keySet()) {
            if (this.f3876i.a(num.intValue()) == FeedbackReaction.c) {
                i5 = ((Integer) hashMap2.get(num)).intValue() + i;
            } else {
                i5 = i;
            }
            i = i5;
        }
        if (i3 != 1) {
            hashMap3.put(FeedbackReaction.c, Integer.valueOf(i));
        }
        return hashMap3;
    }

    public static int m4509f(TabbedReactorsListFragment tabbedReactorsListFragment, FeedbackReaction feedbackReaction) {
        if (tabbedReactorsListFragment.at == null || !tabbedReactorsListFragment.at.containsKey(feedbackReaction)) {
            return 0;
        }
        return ((Integer) tabbedReactorsListFragment.at.get(feedbackReaction)).intValue();
    }

    private ImmutableList<FeedbackReaction> aw() {
        return this.f3876i.b();
    }

    private boolean m4510h(FeedbackReaction feedbackReaction) {
        return feedbackReaction != null && aw().contains(feedbackReaction);
    }

    public final void m4520d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 501196599);
        super.d(bundle);
        this.ar = this.ap.a;
        ReactorsListLogger reactorsListLogger = this.f3871d;
        String str = this.ap.i;
        reactorsListLogger.f3969b.a(ReactorsListLogger.f3968a);
        reactorsListLogger.f3969b.a(ReactorsListLogger.f3968a, str);
        aC();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -473788070, a);
    }

    public final View m4515a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1174004314);
        super.a(layoutInflater, viewGroup, bundle);
        this.aq = layoutInflater.inflate(aq(), viewGroup, false);
        this.am = (ViewPager) FindViewUtil.b(this.aq, 2131562220);
        this.an = (TabbedViewPagerIndicator) FindViewUtil.b(this.aq, 2131562219);
        this.an.f3572m = new C03432(this);
        this.an.f3571l = new C03443(this);
        View view = this.aq;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2074018166, a);
        return view;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2056163716);
        this.ao = null;
        this.an = null;
        this.am = null;
        this.aq = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1311803168, a);
    }

    public final void m4512G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 70095726);
        super.G();
        this.f3871d.f3969b.b(ReactorsListLogger.f3968a, "fragment_resume");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1950741224, a);
    }

    public final void m4513H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -260311710);
        super.H();
        this.f3871d.f3969b.b(ReactorsListLogger.f3968a, "fragment_pause");
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 328732404, a);
    }

    public final void m4514I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1089586311);
        super.I();
        this.f3874g.f3916b.c();
        this.al.d(8519681);
        this.f3871d.f3969b.b(ReactorsListLogger.f3968a);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -451050229, a);
    }

    private List<Tuple<FeedbackReaction, AppendOnlyGraphQLObjectCollection<ActorReactionPair>>> aB() {
        List<Tuple<FeedbackReaction, AppendOnlyGraphQLObjectCollection<ActorReactionPair>>> arrayList = new ArrayList();
        ImmutableList aw = aw();
        int size = aw.size();
        for (int i = 0; i < size; i++) {
            FeedbackReaction feedbackReaction = (FeedbackReaction) aw.get(i);
            AppendOnlyGraphQLObjectCollection a = this.f3874g.m4560a(feedbackReaction);
            if (a != null) {
                Object obj;
                if (!(feedbackReaction == FeedbackReaction.c && this.at.containsKey(FeedbackReaction.c)) && m4509f(this, feedbackReaction) <= 0) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    arrayList.add(new Tuple(feedbackReaction, a));
                }
            }
        }
        Collections.sort(arrayList, this.f3868a);
        if (!arrayList.isEmpty()) {
            this.f3871d.m4626a(arrayList.size(), (FeedbackReaction) ((Tuple) arrayList.get(0)).a);
        }
        return arrayList;
    }

    public final CharSequence m4517b(FeedbackReaction feedbackReaction) {
        CharSequence a = this.f3873f.a(m4509f(this, feedbackReaction));
        return ReactorsLoader.m4556c(feedbackReaction) ? jW_().getString(2131235953) + " " + a : a;
    }

    public final void m4516a(Object obj) {
        GraphQLActor graphQLActor = ((ActorReactionPair) obj).f3861a;
        String a = this.f3870c.a(graphQLActor.b(), graphQLActor.H(), graphQLActor.aw());
        Bundle bundle = new Bundle();
        if (graphQLActor.b().g() == 2645995) {
            ModelBundle.a(bundle, graphQLActor.H(), graphQLActor.ai().b(), graphQLActor.aa());
        }
        this.f3869b.a(getContext(), a, bundle, null);
    }

    public final void m4519c(FeedbackReaction feedbackReaction) {
        if (m4510h(feedbackReaction)) {
            int b = this.f3874g.m4563b(feedbackReaction);
            if (((Integer) this.at.get(feedbackReaction)).intValue() != b) {
                this.at.put(feedbackReaction, Integer.valueOf(b));
                if (this.an != null) {
                    this.an.m4293b();
                }
            }
        }
        m4511k(feedbackReaction);
        this.al.b(8519681, (short) 2);
    }

    private void m4511k(FeedbackReaction feedbackReaction) {
        if (this.am != null) {
            aC();
            View findViewWithTag = this.am.findViewWithTag(feedbackReaction);
            if (findViewWithTag != null) {
                LoadingIndicatorView loadingIndicatorView = (LoadingIndicatorView) FindViewUtil.b(findViewWithTag, 2131562221);
                BetterListView betterListView = (BetterListView) FindViewUtil.b(findViewWithTag, 2131562222);
                if (betterListView.getAdapter() != null && (betterListView.getAdapter() instanceof FbListAdapter)) {
                    ((FbListAdapter) betterListView.getAdapter()).notifyDataSetChanged();
                }
                loadingIndicatorView.b();
            }
        }
    }

    private void aC() {
        if (this.ao == null) {
            this.ao = new ReactorViewPagerAdapter(this, aB());
            this.am.a(false, this.f3875h);
            this.am.setAdapter(this.ao);
            this.an.setViewPager(this.am);
            this.an.setUnderlineColor(m4508d(ReactorViewPagerAdapter.m4578e(this.ao, 0)));
        }
    }

    public static int m4508d(FeedbackReaction feedbackReaction) {
        return ReactorsLoader.m4556c(feedbackReaction) ? -10972929 : feedbackReaction.g;
    }

    public final int at() {
        return jW_().getColor(2131363160);
    }

    private void m4506a(IFeedIntentBuilder iFeedIntentBuilder, GraphQLLinkExtractor graphQLLinkExtractor, ReactorsListLogger reactorsListLogger, ErrorMessageGenerator errorMessageGenerator, NumberTruncationUtil numberTruncationUtil, ReactorsLoader reactorsLoader, TabbedReactorsListTransformer tabbedReactorsListTransformer, FeedbackReactionsController feedbackReactionsController, QuickPerformanceLogger quickPerformanceLogger) {
        this.f3869b = iFeedIntentBuilder;
        this.f3870c = graphQLLinkExtractor;
        this.f3871d = reactorsListLogger;
        this.f3872e = errorMessageGenerator;
        this.f3873f = numberTruncationUtil;
        this.f3874g = reactorsLoader;
        this.f3875h = tabbedReactorsListTransformer;
        this.f3876i = feedbackReactionsController;
        this.al = quickPerformanceLogger;
    }
}
