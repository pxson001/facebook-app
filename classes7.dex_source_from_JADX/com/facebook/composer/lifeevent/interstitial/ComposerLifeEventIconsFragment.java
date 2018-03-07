package com.facebook.composer.lifeevent.interstitial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.FindViewUtil;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel.Builder;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQL.FBLifeEventSuggestionsAllIconsQueryString;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.FBLifeEventSuggestionsAllIconsQueryModel;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.LifeEventIconsFieldsModel;
import com.facebook.composer.lifeevent.view.ComposerLifeEventView;
import com.facebook.composer.lifeevent.view.ComposerLifeEventViewBinder;
import com.facebook.device.ScreenUtil;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: core_attribute_chevron */
public class ComposerLifeEventIconsFragment extends FbFragment {
    @Inject
    public ComposerLifeEventIconsListAdapterProvider f16728a;
    public final TextWatcher al = new C13241(this);
    private final OnClickListener am = new C13252(this);
    @Inject
    public GraphQLQueryExecutor f16729b;
    @Inject
    @ForUiThread
    public ListeningScheduledExecutorService f16730c;
    public FbTitleBar f16731d;
    public ComposerLifeEventView f16732e;
    public LoadingIndicatorView f16733f;
    public BetterListView f16734g;
    public ComposerLifeEventIconsListAdapter f16735h;
    public RetryTrigger f16736i;

    /* compiled from: core_attribute_chevron */
    class C13241 implements TextWatcher {
        final /* synthetic */ ComposerLifeEventIconsFragment f16721a;

        C13241(ComposerLifeEventIconsFragment composerLifeEventIconsFragment) {
            this.f16721a = composerLifeEventIconsFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: core_attribute_chevron */
    class C13252 implements OnClickListener {
        final /* synthetic */ ComposerLifeEventIconsFragment f16722a;

        C13252(ComposerLifeEventIconsFragment composerLifeEventIconsFragment) {
            this.f16722a = composerLifeEventIconsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1183378403);
            if (this.f16722a.ao() != null) {
                Intent intent = new Intent();
                LifeEventIconsFieldsModel lifeEventIconsFieldsModel = (LifeEventIconsFieldsModel) view.getTag();
                Builder l = ComposerLifeEventIconsFragment.as(this.f16722a).l();
                l.c = lifeEventIconsFieldsModel.j();
                l = l;
                l.d = lifeEventIconsFieldsModel.k();
                Builder builder = l;
                builder.a = this.f16722a.f16732e.getTitleText().toString();
                intent.putExtra("extra_composer_life_event_icon_model", builder.a());
                this.f16722a.ao().setResult(-1, intent);
                this.f16722a.ao().finish();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -605145733, a);
        }
    }

    /* compiled from: core_attribute_chevron */
    class C13263 implements Function<GraphQLResult<FBLifeEventSuggestionsAllIconsQueryModel>, ImmutableList<ImmutableList<LifeEventIconsFieldsModel>>> {
        final /* synthetic */ ComposerLifeEventIconsFragment f16723a;

        C13263(ComposerLifeEventIconsFragment composerLifeEventIconsFragment) {
            this.f16723a = composerLifeEventIconsFragment;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FBLifeEventSuggestionsAllIconsQueryModel) graphQLResult.e).a() == null) {
                return null;
            }
            ImmutableList a = ((FBLifeEventSuggestionsAllIconsQueryModel) graphQLResult.e).a().a();
            ImmutableList.Builder builder = new ImmutableList.Builder();
            ImmutableList.Builder builder2 = new ImmutableList.Builder();
            int size = a.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                LifeEventIconsFieldsModel lifeEventIconsFieldsModel = (LifeEventIconsFieldsModel) a.get(i2);
                if (Integer.parseInt(lifeEventIconsFieldsModel.a()) != i + 1) {
                    i++;
                    builder2.c(builder.b());
                    builder = new ImmutableList.Builder();
                }
                builder.c(lifeEventIconsFieldsModel);
            }
            builder2.c(builder.b());
            return builder2.b();
        }
    }

    /* compiled from: core_attribute_chevron */
    class C13274 implements FutureCallback<ImmutableList<ImmutableList<LifeEventIconsFieldsModel>>> {
        final /* synthetic */ ComposerLifeEventIconsFragment f16724a;

        C13274(ComposerLifeEventIconsFragment composerLifeEventIconsFragment) {
            this.f16724a = composerLifeEventIconsFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            if (this.f16724a.f16733f != null) {
                this.f16724a.f16733f.b();
            }
            if (immutableList != null && !immutableList.isEmpty()) {
                this.f16724a.f16735h.f16740d = immutableList;
                this.f16724a.f16734g.setAdapter(this.f16724a.f16735h);
            }
        }

        public void onFailure(Throwable th) {
            if (this.f16724a.f16733f != null && this.f16724a.E != null && this.f16724a.jW_() != null) {
                this.f16724a.f16733f.a(this.f16724a.b(2131230761), this.f16724a.f16736i);
            }
        }
    }

    /* compiled from: core_attribute_chevron */
    public class C13285 implements OnClickListener {
        final /* synthetic */ ComposerLifeEventIconsFragment f16725a;

        public C13285(ComposerLifeEventIconsFragment composerLifeEventIconsFragment) {
            this.f16725a = composerLifeEventIconsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 90825191);
            ComposerLifeEventIconsFragment composerLifeEventIconsFragment = this.f16725a;
            if (composerLifeEventIconsFragment.ao() != null) {
                composerLifeEventIconsFragment.ao().setResult(0);
                composerLifeEventIconsFragment.ao().finish();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -999126094, a);
        }
    }

    /* compiled from: core_attribute_chevron */
    public class C13296 extends OnToolbarButtonListener {
        final /* synthetic */ ComposerLifeEventIconsFragment f16726a;

        public C13296(ComposerLifeEventIconsFragment composerLifeEventIconsFragment) {
            this.f16726a = composerLifeEventIconsFragment;
        }

        public final void m20763a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (this.f16726a.ao() != null) {
                Intent intent = new Intent();
                Builder l = ComposerLifeEventIconsFragment.as(this.f16726a).l();
                l.a = this.f16726a.f16732e.getTitleText().toString();
                intent.putExtra("extra_composer_life_event_icon_model", l.a());
                this.f16726a.ao().setResult(-1, intent);
                this.f16726a.ao().finish();
            }
        }
    }

    /* compiled from: core_attribute_chevron */
    class RetryTrigger implements RetryClickedListener {
        final /* synthetic */ ComposerLifeEventIconsFragment f16727a;

        public RetryTrigger(ComposerLifeEventIconsFragment composerLifeEventIconsFragment) {
            this.f16727a = composerLifeEventIconsFragment;
        }

        public final void m20764a() {
            ComposerLifeEventIconsFragment.m20766b(this.f16727a);
        }
    }

    public static void m20765a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ComposerLifeEventIconsFragment composerLifeEventIconsFragment = (ComposerLifeEventIconsFragment) obj;
        ComposerLifeEventIconsListAdapterProvider composerLifeEventIconsListAdapterProvider = (ComposerLifeEventIconsListAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ComposerLifeEventIconsListAdapterProvider.class);
        GraphQLQueryExecutor a = GraphQLQueryExecutor.a(fbInjector);
        ListeningScheduledExecutorService a2 = ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector);
        composerLifeEventIconsFragment.f16728a = composerLifeEventIconsListAdapterProvider;
        composerLifeEventIconsFragment.f16729b = a;
        composerLifeEventIconsFragment.f16730c = a2;
    }

    public final void m20769c(Bundle bundle) {
        super.c(bundle);
        Class cls = ComposerLifeEventIconsFragment.class;
        m20765a((Object) this, getContext());
        this.f16736i = new RetryTrigger(this);
    }

    public final View m20767a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1995716857);
        View inflate = layoutInflater.inflate(2130903683, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 296654197, a);
        return inflate;
    }

    public final void m20768a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f16735h = new ComposerLifeEventIconsListAdapter(this.am, ScreenUtil.a(this.f16728a));
        FbTitleBarUtil.a(view);
        this.f16731d = (FbTitleBar) e(2131558563);
        this.f16731d.a(new C13285(this));
        this.f16731d.setTitle(2131234182);
        if (this.s.getBoolean("extra_composer_life_event_custom")) {
            TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
            a.g = jW_().getString(2131230751);
            a = a;
            a.h = -2;
            this.f16731d.setButtonSpecs(ImmutableList.of(a.a()));
            this.f16731d.setOnToolbarButtonListener(new C13296(this));
        }
        this.f16732e = (ComposerLifeEventView) e(2131560536);
        ComposerLifeEventViewBinder.m20815a(jW_(), this.f16732e, as(this), this.al, null);
        int dimensionPixelSize = jW_().getDimensionPixelSize(2131429628);
        int dimensionPixelSize2 = jW_().getDimensionPixelSize(2131428032);
        this.f16732e.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
        if (this.f16732e.hs_()) {
            this.f16732e.hr_();
        }
        this.f16733f = (LoadingIndicatorView) FindViewUtil.b(view, 2131560537);
        this.f16734g = (BetterListView) e(2131560538);
        m20766b(this);
    }

    public static void m20766b(ComposerLifeEventIconsFragment composerLifeEventIconsFragment) {
        if (composerLifeEventIconsFragment.f16733f != null) {
            composerLifeEventIconsFragment.f16733f.a();
            GraphQlQueryString fBLifeEventSuggestionsAllIconsQueryString = new FBLifeEventSuggestionsAllIconsQueryString();
            fBLifeEventSuggestionsAllIconsQueryString.a("scale", GraphQlQueryDefaults.a());
            Futures.a(Futures.a(composerLifeEventIconsFragment.f16729b.a(GraphQLRequest.a(fBLifeEventSuggestionsAllIconsQueryString).a(GraphQLCachePolicy.a).a(86400)), new C13263(composerLifeEventIconsFragment), MoreExecutors.a()), new C13274(composerLifeEventIconsFragment), composerLifeEventIconsFragment.f16730c);
        }
    }

    public static ComposerLifeEventModel as(ComposerLifeEventIconsFragment composerLifeEventIconsFragment) {
        return (ComposerLifeEventModel) composerLifeEventIconsFragment.s.getParcelable("extra_composer_life_event_model");
    }
}
