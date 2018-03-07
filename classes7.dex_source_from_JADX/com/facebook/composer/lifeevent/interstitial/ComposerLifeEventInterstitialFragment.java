package com.facebook.composer.lifeevent.interstitial;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel.Builder;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.TypeAheadSuggestionFieldsModel;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerDateInfo;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import javax.inject.Inject;

/* compiled from: core_attribute_margin */
public abstract class ComposerLifeEventInterstitialFragment extends FbFragment {
    @Inject
    InputMethodManager f16711a;
    public View al;
    public LoadingIndicatorView am;
    private Intent an;
    public ComposerLifeEventInterstitialListAdapter ao;
    public ComposerLifeEventInterstitialTypeaheadStore ap = new ComposerLifeEventInterstitialTypeaheadStore();
    private final OnClickListener aq = new C13301(this);
    private final TextWatcher ar = new C13322(this);
    @Inject
    SecureContextHelper f16712b;
    @Inject
    GraphQLQueryExecutor f16713c;
    @Inject
    @ForUiThread
    ListeningScheduledExecutorService f16714d;
    @Inject
    ComposerLifeEventInterstitialListAdapterProvider f16715e;
    @Inject
    ComposerLauncher f16716f;
    public FbTitleBar f16717g;
    private BetterListView f16718h;
    public EditText f16719i;

    /* compiled from: core_attribute_margin */
    class C13301 implements OnClickListener {
        final /* synthetic */ ComposerLifeEventInterstitialFragment f16741a;

        C13301(ComposerLifeEventInterstitialFragment composerLifeEventInterstitialFragment) {
            this.f16741a = composerLifeEventInterstitialFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1829221486);
            ComposerLifeEventInterstitialFragment composerLifeEventInterstitialFragment = this.f16741a;
            this.f16741a.o();
            ComposerLifeEventInterstitialFragment.m20740a(composerLifeEventInterstitialFragment, composerLifeEventInterstitialFragment.mo1290a(ComposerLifeEventInterstitialFragment.as(composerLifeEventInterstitialFragment).l(), (TypeAheadSuggestionFieldsModel) view.getTag()).a());
            Logger.a(2, EntryType.UI_INPUT_END, 2136136910, a);
        }
    }

    /* compiled from: core_attribute_margin */
    class C13322 implements TextWatcher {
        final /* synthetic */ ComposerLifeEventInterstitialFragment f16744a;

        C13322(ComposerLifeEventInterstitialFragment composerLifeEventInterstitialFragment) {
            this.f16744a = composerLifeEventInterstitialFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f16744a.al.setVisibility(StringUtil.a(charSequence) ? 8 : 0);
            final String charSequence2 = charSequence.toString();
            if (StringUtil.a(charSequence) || this.f16744a.ap.f16752a.f(charSequence2)) {
                this.f16744a.ao.f16751b = this.f16744a.ap.m20778b(charSequence2);
                AdapterDetour.a(this.f16744a.ao, -657504611);
                return;
            }
            Futures.a(this.f16744a.mo1291a(charSequence2), new FutureCallback<ImmutableList<TypeAheadSuggestionFieldsModel>>(this) {
                final /* synthetic */ C13322 f16743b;

                public void onSuccess(Object obj) {
                    ImmutableList immutableList = (ImmutableList) obj;
                    if (this.f16743b.f16744a.am != null) {
                        this.f16743b.f16744a.am.b();
                    }
                    if (immutableList == null || immutableList.isEmpty()) {
                        this.f16743b.f16744a.ap.m20777a(charSequence2, Lists.a());
                    } else {
                        this.f16743b.f16744a.ap.m20777a(charSequence2, immutableList);
                    }
                    this.f16743b.f16744a.ao.f16751b = this.f16743b.f16744a.ap.m20778b(charSequence2);
                    AdapterDetour.a(this.f16743b.f16744a.ao, 1448877941);
                }

                public void onFailure(Throwable th) {
                    if (this.f16743b.f16744a.am != null) {
                        this.f16743b.f16744a.am.a(this.f16743b.f16744a.b(2131230761), null);
                    }
                }
            }, this.f16744a.f16714d);
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: core_attribute_margin */
    class C13333 implements OnFocusChangeListener {
        final /* synthetic */ ComposerLifeEventInterstitialFragment f16745a;

        C13333(ComposerLifeEventInterstitialFragment composerLifeEventInterstitialFragment) {
            this.f16745a = composerLifeEventInterstitialFragment;
        }

        public void onFocusChange(View view, boolean z) {
            ComposerLifeEventInterstitialFragment.at(this.f16745a);
        }
    }

    /* compiled from: core_attribute_margin */
    class C13344 implements OnClickListener {
        final /* synthetic */ ComposerLifeEventInterstitialFragment f16746a;

        C13344(ComposerLifeEventInterstitialFragment composerLifeEventInterstitialFragment) {
            this.f16746a = composerLifeEventInterstitialFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1664285956);
            this.f16746a.f16719i.setText("");
            Logger.a(2, EntryType.UI_INPUT_END, 714625100, a);
        }
    }

    /* compiled from: core_attribute_margin */
    class C13355 implements OnScrollListener {
        final /* synthetic */ ComposerLifeEventInterstitialFragment f16747a;

        C13355(ComposerLifeEventInterstitialFragment composerLifeEventInterstitialFragment) {
            this.f16747a = composerLifeEventInterstitialFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            ComposerLifeEventInterstitialFragment.at(this.f16747a);
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* compiled from: core_attribute_margin */
    public class C13366 extends OnToolbarButtonListener {
        final /* synthetic */ ComposerLifeEventInterstitialFragment f16748a;

        public C13366(ComposerLifeEventInterstitialFragment composerLifeEventInterstitialFragment) {
            this.f16748a = composerLifeEventInterstitialFragment;
        }

        public final void m20773a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            ComposerLifeEventInterstitialFragment.m20740a(this.f16748a, ComposerLifeEventInterstitialFragment.as(this.f16748a));
        }
    }

    public static void m20741a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ComposerLifeEventInterstitialFragment) obj).m20739a(InputMethodManagerMethodAutoProvider.b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), (ComposerLifeEventInterstitialListAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ComposerLifeEventInterstitialListAdapterProvider.class), (ComposerLauncher) ComposerLauncherImpl.a(fbInjector));
    }

    public abstract Builder mo1290a(Builder builder, TypeAheadSuggestionFieldsModel typeAheadSuggestionFieldsModel);

    protected abstract ListenableFuture<ImmutableList<TypeAheadSuggestionFieldsModel>> mo1291a(String str);

    public abstract boolean aq();

    protected abstract String mo1292b();

    protected abstract String mo1289e();

    private void m20739a(InputMethodManager inputMethodManager, SecureContextHelper secureContextHelper, GraphQLQueryExecutor graphQLQueryExecutor, ListeningScheduledExecutorService listeningScheduledExecutorService, ComposerLifeEventInterstitialListAdapterProvider composerLifeEventInterstitialListAdapterProvider, ComposerLauncher composerLauncher) {
        this.f16711a = inputMethodManager;
        this.f16712b = secureContextHelper;
        this.f16713c = graphQLQueryExecutor;
        this.f16714d = listeningScheduledExecutorService;
        this.f16715e = composerLifeEventInterstitialListAdapterProvider;
        this.f16716f = composerLauncher;
    }

    public final void m20745a(int i, int i2, Intent intent) {
        o().setResult(i2, intent);
        o().finish();
    }

    public final void m20748c(Bundle bundle) {
        super.c(bundle);
        Class cls = ComposerLifeEventInterstitialFragment.class;
        m20741a((Object) this, getContext());
    }

    public final View m20742a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1497734173);
        View inflate = layoutInflater.inflate(2130903686, null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1561816816, a);
        return inflate;
    }

    public final void m20746a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.an = (Intent) this.s.getParcelable("intent");
        this.ao = new ComposerLifeEventInterstitialListAdapter(this.aq);
        FbTitleBarUtil.a(view);
        this.f16717g = (FbTitleBar) e(2131558563);
        this.f16717g.setTitle(mo1289e());
        if (aq()) {
            TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
            a.a = 1;
            a = a;
            a.g = jW_().getString(2131230751);
            a = a;
            a.h = -2;
            this.f16717g.setButtonSpecs(ImmutableList.of(a.a()));
            this.f16717g.setOnToolbarButtonListener(new C13366(this));
        }
        this.am = (LoadingIndicatorView) FindViewUtil.b(view, 2131560537);
        this.f16718h = (BetterListView) view.findViewById(2131560542);
        this.f16718h.setAdapter(this.ao);
        this.f16719i = (EditText) view.findViewById(2131560540);
        this.f16719i.setHint(mo1292b());
        this.f16719i.setOnFocusChangeListener(new C13333(this));
        this.al = view.findViewById(2131560541);
        this.al.setOnClickListener(new C13344(this));
        this.f16718h.a(new C13355(this));
        this.f16719i.addTextChangedListener(this.ar);
    }

    public static void m20740a(ComposerLifeEventInterstitialFragment composerLifeEventInterstitialFragment, ComposerLifeEventModel composerLifeEventModel) {
        composerLifeEventInterstitialFragment.f16716f.a(null, ComposerConfiguration.a((ComposerConfiguration) composerLifeEventInterstitialFragment.an.getParcelableExtra("extra_composer_configuration")).setDisableFriendTagging(true).a(composerLifeEventModel).setInitialDateInfo(new ComposerDateInfo.Builder().a()).a(), 1756, composerLifeEventInterstitialFragment);
    }

    public static ComposerLifeEventModel as(ComposerLifeEventInterstitialFragment composerLifeEventInterstitialFragment) {
        return (ComposerLifeEventModel) composerLifeEventInterstitialFragment.an.getParcelableExtra("life_event_model");
    }

    public static void at(ComposerLifeEventInterstitialFragment composerLifeEventInterstitialFragment) {
        if (composerLifeEventInterstitialFragment.f16711a != null && composerLifeEventInterstitialFragment.f16719i != null) {
            composerLifeEventInterstitialFragment.f16711a.hideSoftInputFromWindow(composerLifeEventInterstitialFragment.f16719i.getWindowToken(), 0);
        }
    }
}
