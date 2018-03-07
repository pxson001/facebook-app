package com.facebook.ufiservices.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.facebook.api.feed.data.AppendOnlyGraphQLObjectCollection;
import com.facebook.api.feed.data.AppendOnlyGraphQLObjectCollectionConverter;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.Tuple;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.inject.FbInjector;
import com.facebook.inject.ProviderLazy;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.feed.ProfileListParamType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.sentry.SentryUtil;
import com.facebook.sentry.SentryUtil.SentryBlockTitle;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ufiservices.data.ProfilesListLoader;
import com.facebook.ufiservices.data.ProfilesLoaderFactory;
import com.facebook.ufiservices.data.STATICDI_MULTIBIND_PROVIDER$ProfilesListLoader;
import com.facebook.ufiservices.flyout.ProfileListParams;
import com.facebook.ufiservices.ui.ProfileListFragmentGraphQLInterfaces.ProfileListFragmentGraphQL;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ui.errordialog.ErrorMessageGenerator;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: customization_type */
public abstract class ProfileListFragment<T extends ProfileListFragmentGraphQL> extends FbFragment {
    private final Function<T, String> f18113a = new C13401(this);
    public BaseAdapter al;
    public AppendOnlyGraphQLObjectCollection<T> am;
    public RetryTrigger an;
    private View ao;
    private CompositeOnScrollListener ap;
    private ProfilesLoaderFactory aq;
    private ProfilesListLoader ar;
    public boolean as;
    public String at;
    public GraphQLLinkExtractor f18114b;
    public IFeedIntentBuilder f18115c;
    public ErrorDialogs f18116d;
    public ErrorMessageGenerator f18117e;
    public AbstractFbErrorReporter f18118f;
    private ProfileListParams f18119g;
    public BetterListView f18120h;
    public LoadingIndicatorView f18121i;

    /* compiled from: customization_type */
    class C13401 implements Function<T, String> {
        final /* synthetic */ ProfileListFragment f18254a;

        C13401(ProfileListFragment profileListFragment) {
            this.f18254a = profileListFragment;
        }

        public Object apply(Object obj) {
            return ((ProfileListFragmentGraphQL) obj).g();
        }
    }

    /* compiled from: customization_type */
    class C13412 implements OnScrollListener {
        final /* synthetic */ ProfileListFragment f18255a;

        C13412(ProfileListFragment profileListFragment) {
            this.f18255a = profileListFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (!this.f18255a.as && this.f18255a.am.g && i + i2 > i3 - 1 && i2 != 0) {
                ProfileListFragment.m26641a(this.f18255a, false);
            }
        }
    }

    /* compiled from: customization_type */
    public class C13423 extends AbstractDisposableFutureCallback<Tuple<List<GraphQLActor>, GraphQLPageInfo>> {
        final /* synthetic */ ProfileListFragment f18256a;

        public C13423(ProfileListFragment profileListFragment) {
            this.f18256a = profileListFragment;
        }

        public final void m26786a(Object obj) {
            Tuple tuple = (Tuple) obj;
            this.f18256a.as = false;
            this.f18256a.f18121i.b();
            ProfileListFragment profileListFragment = this.f18256a;
            if (!(tuple == null || tuple.a == null)) {
                int firstVisiblePosition = profileListFragment.f18120h.getFirstVisiblePosition();
                View childAt = profileListFragment.f18120h.getChildAt(0);
                int top = childAt == null ? 0 : childAt.getTop();
                profileListFragment.am.a(profileListFragment.mo1380a((List) tuple.a), AppendOnlyGraphQLObjectCollectionConverter.a((GraphQLPageInfo) tuple.b));
                AdapterDetour.a(profileListFragment.al, 2114049310);
                profileListFragment.f18120h.setSelectionFromTop(firstVisiblePosition, top);
            }
            this.f18256a.f18120h.setVisibility(0);
        }

        public final void m26787a(Throwable th) {
            this.f18256a.as = false;
            ProfileListFragment profileListFragment = this.f18256a;
            ServiceException a = ServiceException.a(th);
            String a2 = profileListFragment.f18117e.a(a, true, true);
            if (profileListFragment.f18117e.b(a)) {
                ErrorDialogs errorDialogs = profileListFragment.f18116d;
                ErrorDialogParamsBuilder a3 = ErrorDialogParams.a(profileListFragment.jW_()).a(SentryBlockTitle.SENTRY_PROFILE_LIST_BLOCK.getTitleId());
                a3.c = a2;
                a3 = a3.c(2131230784);
                a3.e = SentryUtil.f15951a;
                errorDialogs.a(a3.l());
            }
            if (profileListFragment.f18121i != null && profileListFragment.am.c() == 0) {
                profileListFragment.f18121i.a(a2, profileListFragment.an);
            }
            profileListFragment.f18118f.a("FetchLikersFailed", StringFormatUtil.formatStrLocaleSafe("feedbackId: %s", profileListFragment.at), th);
        }
    }

    /* compiled from: customization_type */
    class C13434 implements OnItemClickListener {
        final /* synthetic */ ProfileListFragment f18257a;

        C13434(ProfileListFragment profileListFragment) {
            this.f18257a = profileListFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ProfileListFragmentGraphQL profileListFragmentGraphQL = (ProfileListFragmentGraphQL) this.f18257a.al.getItem(i);
            String a = this.f18257a.f18114b.a(profileListFragmentGraphQL.c(), profileListFragmentGraphQL.g(), profileListFragmentGraphQL.j());
            Bundle bundle = new Bundle();
            if (profileListFragmentGraphQL.c().g() == 2645995) {
                ModelBundle.m25598a(bundle, profileListFragmentGraphQL);
            }
            this.f18257a.f18115c.a(this.f18257a.getContext(), a, bundle, null);
        }
    }

    /* compiled from: customization_type */
    public class CompositeOnScrollListener implements OnScrollListener {
        final /* synthetic */ ProfileListFragment f18258a;
        public List<OnScrollListener> f18259b = Lists.a();

        protected CompositeOnScrollListener(ProfileListFragment profileListFragment) {
            this.f18258a = profileListFragment;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            for (int i4 = 0; i4 < this.f18259b.size(); i4++) {
                ((OnScrollListener) this.f18259b.get(i4)).onScroll(absListView, i, i2, i3);
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            for (int i2 = 0; i2 < this.f18259b.size(); i2++) {
                ((OnScrollListener) this.f18259b.get(i2)).onScrollStateChanged(absListView, i);
            }
        }
    }

    /* compiled from: customization_type */
    class RetryTrigger implements RetryClickedListener {
        final /* synthetic */ ProfileListFragment f18260a;

        public RetryTrigger(ProfileListFragment profileListFragment) {
            this.f18260a = profileListFragment;
        }

        public final void m26788a() {
            ProfileListFragment.m26641a(this.f18260a, true);
        }
    }

    public static void m26642a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ProfileListFragment) obj).m26640a(GraphQLLinkExtractor.a(fbInjector), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(fbInjector), ErrorDialogs.a(fbInjector), ErrorMessageGenerator.b(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), new ProfilesLoaderFactory(ProviderLazy.a(new STATICDI_MULTIBIND_PROVIDER$ProfilesListLoader(fbInjector.getScopeAwareInjector()), fbInjector.getScopeAwareInjector())));
    }

    public abstract List<T> mo1380a(List<GraphQLActor> list);

    public abstract BaseAdapter au();

    protected abstract int av();

    protected abstract CallerContext aw();

    @Inject
    private void m26640a(GraphQLLinkExtractor graphQLLinkExtractor, IFeedIntentBuilder iFeedIntentBuilder, ErrorDialogs errorDialogs, ErrorMessageGenerator errorMessageGenerator, AbstractFbErrorReporter abstractFbErrorReporter, ProfilesLoaderFactory profilesLoaderFactory) {
        this.f18114b = graphQLLinkExtractor;
        this.f18115c = iFeedIntentBuilder;
        this.f18116d = errorDialogs;
        this.f18117e = errorMessageGenerator;
        this.f18118f = abstractFbErrorReporter;
        this.aq = profilesLoaderFactory;
    }

    public void mo1384c(Bundle bundle) {
        super.c(bundle);
        Class cls = ProfileListFragment.class;
        m26642a((Object) this, getContext());
        this.f18119g = (ProfileListParams) this.s.getParcelable("profileListParams");
        this.am = new AppendOnlyGraphQLObjectCollection(this.f18113a);
        this.al = au();
        this.an = new RetryTrigger(this);
        ProfilesLoaderFactory profilesLoaderFactory = this.aq;
        ProfileListParamType profileListParamType = this.f18119g.f18092d;
        for (ProfilesListLoader profilesListLoader : (Set) profilesLoaderFactory.f18004a.get()) {
            if (profilesListLoader.mo1345a().equals(profileListParamType)) {
                break;
            }
        }
        ProfilesListLoader profilesListLoader2 = null;
        this.ar = profilesListLoader2;
        if (this.ar == null) {
            BLog.c(getClass(), "Unsupported profile list type %s", new Object[]{this.f18119g.f18092d});
        }
        this.ap = new CompositeOnScrollListener(this);
        CompositeOnScrollListener compositeOnScrollListener = this.ap;
        C13412 c13412 = new C13412(this);
        if (c13412 != null) {
            compositeOnScrollListener.f18259b.add(c13412);
        }
    }

    public final void m26646d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -563059262);
        super.d(bundle);
        m26641a(this, true);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1700829636, a);
    }

    public static void m26641a(ProfileListFragment profileListFragment, boolean z) {
        if (profileListFragment.ar != null) {
            if (z || (!z && profileListFragment.ar.mo1347b())) {
                profileListFragment.ar.mo1346a(profileListFragment.f18119g, new C13423(profileListFragment), true, profileListFragment.am.e, profileListFragment.aw());
            }
        }
    }

    public final View m26643a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2086524979);
        this.ao = layoutInflater.inflate(av(), viewGroup, false);
        this.at = this.f18119g.f18089a;
        this.f18120h = (BetterListView) this.ao.findViewById(2131562214);
        this.f18120h.setAdapter(this.al);
        this.f18120h.setOnScrollListener(this.ap);
        this.f18120h.setOnItemClickListener(new C13434(this));
        this.f18121i = (LoadingIndicatorView) FindViewUtil.b(this.ao, 2131560537);
        View view = this.ao;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1455164892, a);
        return view;
    }
}
