package com.facebook.privacy.selector;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionController;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.TriState;
import com.facebook.contacts.background.AddressBookPeriodicRunner;
import com.facebook.graphql.enums.GraphQLPrivacyBaseState;
import com.facebook.graphql.enums.GraphQLPrivacyOptionTagExpansionType;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.enums.GraphQLPrivacyTagExpansionState;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPrivacyAudienceMember;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLPrivacyRowInput.Builder;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.model.CustomPrivacyToken;
import com.facebook.privacy.model.FriendsExceptToken;
import com.facebook.privacy.model.GraphQLPrivacyOptionBuilder;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.model.PrivacyOptionsResult;
import com.facebook.privacy.model.PrivacyParameter;
import com.facebook.privacy.model.PrivacyParameter.Allow;
import com.facebook.privacy.model.PrivacyToken;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.model.SpecificFriendsToken;
import com.facebook.privacy.model.TagExpansionToken;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsForComposer;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.facebook.privacy.selector.AbstractCustomPrivacyTypeaheadFragment.SelectedMembersUpdater;
import com.facebook.privacy.service.PrivacyAnalyticsLogger;
import com.facebook.privacy.ui.PrivacyOptionsSection;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ExpandableSectionedListSection;
import com.facebook.widget.listview.ImmutableSectionedListSection;
import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.tokenizedtypeahead.BaseTokenSpan;
import com.facebook.widget.tokenizedtypeahead.TokenSpan;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.DropdownMode;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView.TextMode;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.facebook.widget.tokenizedtypeahead.model.OnBaseTokenClickedListener;
import com.facebook.widget.tokenizedtypeahead.model.Token;
import com.facebook.widget.tokenizedtypeahead.ui.listview.DefaultViewFactory;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter.ViewFactory;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadItemRow;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadSubtitledItemRow;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fetch successful but get a null SelectablePrivacyData */
public class AudienceTypeaheadFragment extends FbFragment {
    private static final Class<?> f15186a = AudienceTypeaheadFragment.class;
    private SpecificFriendsTypeaheadFragment aA;
    public List<GraphQLPrivacyAudienceMember> aB;
    public List<GraphQLPrivacyAudienceMember> aC;
    public List<BaseToken> aD = Lists.a();
    private int aE;
    private final OnScrollListener aF = new C10321(this);
    private final TextWatcher aG = new C10332(this);
    private final OnItemClickListener aH = new C10343(this);
    public DefaultUserInteractionController al;
    private InputMethodManager am;
    private AbstractFbErrorReporter an;
    private PrivacyAnalyticsLogger ao;
    private View ap;
    public TokenizedAutoCompleteTextView aq;
    public TypeaheadAdapter ar;
    private View as;
    private View at;
    private View au;
    public BetterListView av;
    private View aw;
    private boolean ax;
    private CustomPrivacyFragment ay;
    private FriendsExceptTypeaheadFragment az;
    private AudienceTypeaheadUtil f15187b;
    private PrivacyTokenMatcher f15188c;
    public AudienceSelectorPerformanceLogger f15189d;
    private WeakReference<DataProvider> f15190e;
    @Nullable
    private WeakReference<SelectorListener> f15191f;
    private Provider<TriState> f15192g;
    public SelectablePrivacyData f15193h;
    private AddressBookPeriodicRunner f15194i;

    /* compiled from: fetch successful but get a null SelectablePrivacyData */
    public interface DataProvider {
        SelectablePrivacyData mo1183a();

        boolean mo1184b();
    }

    /* compiled from: fetch successful but get a null SelectablePrivacyData */
    class C10321 implements OnScrollListener {
        final /* synthetic */ AudienceTypeaheadFragment f15168a;

        C10321(AudienceTypeaheadFragment audienceTypeaheadFragment) {
            this.f15168a = audienceTypeaheadFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            switch (i) {
                case 0:
                    this.f15168a.al.b(this.f15168a.T);
                    return;
                case 1:
                case 2:
                    this.f15168a.al.a(this.f15168a.T);
                    AudienceTypeaheadFragment.aL(this.f15168a);
                    return;
                default:
                    return;
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* compiled from: fetch successful but get a null SelectablePrivacyData */
    class C10332 implements TextWatcher {
        final /* synthetic */ AudienceTypeaheadFragment f15173a;
        private boolean f15174b;

        C10332(AudienceTypeaheadFragment audienceTypeaheadFragment) {
            this.f15173a = audienceTypeaheadFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (i3 < i2 && AudienceTypeaheadFragment.aw(this.f15173a) != null) {
                this.f15174b = true;
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (i3 < i2) {
                this.f15173a.aq.m28739d();
                m22758a();
                this.f15174b = false;
            }
        }

        public void afterTextChanged(Editable editable) {
            this.f15173a.ar.mo438a().mo389a(this.f15173a.aq.getUserEnteredPlainText());
            Object obj = !this.f15173a.aD.isEmpty() ? 1 : null;
            this.f15173a.aD = AudienceTypeaheadFragment.m22794a(this.f15173a.aq);
            if (obj == null && !this.f15173a.aD.isEmpty()) {
                AudienceTypeaheadFragment.aA(this.f15173a);
            }
            m22759b();
            this.f15173a.ar.f18485i = this.f15173a.aD;
            this.f15173a.m22819c(this.f15173a.aD);
        }

        private void m22758a() {
            if (!this.f15173a.aD.isEmpty() && this.f15174b) {
                if ((AudienceTypeaheadFragment.aw(this.f15173a) != null ? 1 : null) == null) {
                    AudienceTypeaheadFragment.ar(this.f15173a);
                }
            }
        }

        private void m22759b() {
            if (this.f15173a.aD.size() == 1 && ((BaseToken) this.f15173a.aD.get(0)).f15080a == Type.TAG_EXPANSION) {
                AudienceTypeaheadFragment.au(this.f15173a);
                ((PrivacyOptionsSection) this.f15173a.ar.m27115g(AudienceSectionIndices.f15183a)).m22856j();
            }
        }
    }

    /* compiled from: fetch successful but get a null SelectablePrivacyData */
    class C10343 implements OnItemClickListener {
        final /* synthetic */ AudienceTypeaheadFragment f15175a;

        C10343(AudienceTypeaheadFragment audienceTypeaheadFragment) {
            this.f15175a = audienceTypeaheadFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f15175a.m22804a((BaseToken) this.f15175a.ar.getItem(i), view);
        }
    }

    /* compiled from: fetch successful but get a null SelectablePrivacyData */
    class C10354 implements OnTouchListener {
        final /* synthetic */ AudienceTypeaheadFragment f15176a;

        C10354(AudienceTypeaheadFragment audienceTypeaheadFragment) {
            this.f15176a = audienceTypeaheadFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: fetch successful but get a null SelectablePrivacyData */
    class C10365 implements OnKeyListener {
        final /* synthetic */ AudienceTypeaheadFragment f15177a;

        C10365(AudienceTypeaheadFragment audienceTypeaheadFragment) {
            this.f15177a = audienceTypeaheadFragment;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent == null || keyEvent.getKeyCode() != 66) {
                return false;
            }
            AudienceTypeaheadFragment.aL(this.f15177a);
            return true;
        }
    }

    /* compiled from: fetch successful but get a null SelectablePrivacyData */
    class C10376 implements OnBaseTokenClickedListener {
        final /* synthetic */ AudienceTypeaheadFragment f15178a;

        C10376(AudienceTypeaheadFragment audienceTypeaheadFragment) {
            this.f15178a = audienceTypeaheadFragment;
        }

        public final void mo1200a(Token token) {
            BaseToken baseToken = (BaseToken) token;
            if ((baseToken instanceof FriendsExceptToken) || (baseToken instanceof SpecificFriendsToken) || (baseToken instanceof CustomPrivacyToken)) {
                this.f15178a.m22845a(baseToken, this.f15178a.aq);
            }
        }
    }

    /* compiled from: fetch successful but get a null SelectablePrivacyData */
    class C10398 implements OnPreDrawListener {
        final /* synthetic */ AudienceTypeaheadFragment f15181a;

        C10398(AudienceTypeaheadFragment audienceTypeaheadFragment) {
            this.f15181a = audienceTypeaheadFragment;
        }

        public boolean onPreDraw() {
            AudienceSelectorPerformanceLogger audienceSelectorPerformanceLogger = this.f15181a.f15189d;
            if (audienceSelectorPerformanceLogger.f15152e) {
                audienceSelectorPerformanceLogger.f15149b.b(AudienceSelectorPerformanceLogger.f15147a);
                audienceSelectorPerformanceLogger.f15152e = false;
            } else {
                ((AbstractFbErrorReporter) audienceSelectorPerformanceLogger.f15151d.get()).b(AudienceSelectorPerformanceLogger.class.toString(), new IllegalStateException("Trying to terminate a perf sequence without starting it. This is likely caused by calling AudienceTypeaheadFragment without calling AudienceSelectorPerformanceLogger.onOpenAudienceSelector() to track perf."));
            }
            this.f15181a.av.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    /* compiled from: fetch successful but get a null SelectablePrivacyData */
    class C10409 implements SelectedMembersUpdater {
        final /* synthetic */ AudienceTypeaheadFragment f15182a;

        C10409(AudienceTypeaheadFragment audienceTypeaheadFragment) {
            this.f15182a = audienceTypeaheadFragment;
        }

        public final void mo1199a(List<GraphQLPrivacyAudienceMember> list) {
            if (list != null) {
                this.f15182a.m22808a((List) list, this.f15182a.aB);
                this.f15182a.m22845a(AudienceTypeaheadFragment.aI(this.f15182a), this.f15182a.aq);
                this.f15182a.m22798a(this.f15182a.f15193h);
            }
        }
    }

    /* compiled from: fetch successful but get a null SelectablePrivacyData */
    class AudienceSectionIndices {
        public static int f15183a = 0;

        private AudienceSectionIndices() {
        }
    }

    /* compiled from: fetch successful but get a null SelectablePrivacyData */
    public class PrivacyItemViewFactory extends DefaultViewFactory {
        public OnBaseTokenClickedListener f15185a;

        public PrivacyItemViewFactory() {
            super(true);
        }

        public final void m22784a(OnBaseTokenClickedListener onBaseTokenClickedListener) {
            this.f15185a = onBaseTokenClickedListener;
        }

        public final void mo1205a(View view, BaseToken baseToken, boolean z) {
            super.mo1205a(view, baseToken, z);
            if ((baseToken instanceof FriendsExceptToken) || (baseToken instanceof SpecificFriendsToken) || (baseToken instanceof CustomPrivacyToken)) {
                baseToken.f15076b = this.f15185a;
                ((TypeaheadItemRow) view).m28796b();
            }
        }
    }

    /* compiled from: fetch successful but get a null SelectablePrivacyData */
    public interface SelectorListener {
        void m22785a();

        void m22786b();

        void m22787c();
    }

    private static <T extends InjectableComponentWithContext> void m22806a(Class<T> cls, T t) {
        m22807a((Object) t, t.getContext());
    }

    private static void m22807a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AudienceTypeaheadFragment) obj).m22797a(AddressBookPeriodicRunner.a(injectorLike), AudienceSelectorPerformanceLogger.m22742a(injectorLike), AudienceTypeaheadUtil.m22864b(injectorLike), PrivacyTokenMatcher.m22908c(injectorLike), TypeaheadAdapter.m27098b(injectorLike), InputMethodManagerMethodAutoProvider.b(injectorLike), DefaultUserInteractionController.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 743), PrivacyAnalyticsLogger.b(injectorLike));
    }

    @Inject
    private void m22797a(AddressBookPeriodicRunner addressBookPeriodicRunner, AudienceSelectorPerformanceLogger audienceSelectorPerformanceLogger, AudienceTypeaheadUtil audienceTypeaheadUtil, PrivacyTokenMatcher privacyTokenMatcher, TypeaheadAdapter typeaheadAdapter, InputMethodManager inputMethodManager, UserInteractionController userInteractionController, FbErrorReporter fbErrorReporter, Provider<TriState> provider, PrivacyAnalyticsLogger privacyAnalyticsLogger) {
        this.f15194i = addressBookPeriodicRunner;
        this.f15189d = audienceSelectorPerformanceLogger;
        this.f15187b = audienceTypeaheadUtil;
        this.f15188c = privacyTokenMatcher;
        this.ar = typeaheadAdapter;
        this.am = inputMethodManager;
        this.al = userInteractionController;
        this.an = fbErrorReporter;
        this.f15192g = provider;
        this.ao = privacyAnalyticsLogger;
    }

    public final View m22842a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1850531949);
        this.ap = layoutInflater.inflate(2130906375, viewGroup, false);
        m22811b(this.ap);
        m22817c(this.ap);
        View view = this.ap;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -708164606, a);
        return view;
    }

    public final void m22847c(Bundle bundle) {
        super.c(bundle);
        m22806a(AudienceTypeaheadFragment.class, (InjectableComponentWithContext) this);
        this.f15194i.a();
    }

    public final void m22841G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -702544137);
        super.G();
        az();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1561129255, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1032889898);
        this.av.setOnScrollListener(null);
        this.av.setOnItemClickListener(null);
        this.av = null;
        this.aq.removeTextChangedListener(this.aG);
        this.aq = null;
        this.ar = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1892370791, a);
    }

    private void m22811b(View view) {
        this.ar.m27106a(this.f15188c, aq());
        this.ar.m27107a(ImmutableList.of(new ImmutableSectionedListSection(), new ImmutableSectionedListSection()));
        this.av = (BetterListView) view.findViewById(2131559373);
        this.av.setAdapter(this.ar);
        this.av.setOnScrollListener(this.aF);
        this.av.setOnItemClickListener(this.aH);
        this.aw = view.findViewById(2131559557);
        this.aw.setOnTouchListener(new C10354(this));
    }

    private void m22817c(View view) {
        this.aq = (TokenizedAutoCompleteTextView) view.findViewById(2131566114);
        this.aq.addTextChangedListener(this.aG);
        this.aq.f20028f = DropdownMode.NO_DROPDOWN;
        this.aq.setTextMode(TextMode.PLAIN_TEXT);
        this.aq.f20038p = jW_().getColor(2131361917);
        this.aq.setLongClickable(false);
        this.aq.setOnKeyListener(new C10365(this));
    }

    private ViewFactory aq() {
        ViewFactory privacyItemViewFactory = new PrivacyItemViewFactory();
        privacyItemViewFactory.f15185a = new C10376(this);
        return privacyItemViewFactory;
    }

    private void m22803a(BaseToken baseToken) {
        au(this);
        GraphQLPrivacyOption graphQLPrivacyOption = this.f15193h.f15109d;
        Preconditions.checkNotNull(graphQLPrivacyOption);
        Builder a = Builder.a(PrivacyOptionHelper.e(graphQLPrivacyOption));
        a.g = GraphQLPrivacyTagExpansionState.UNSPECIFIED;
        graphQLPrivacyOption = GraphQLPrivacyOptionBuilder.m22662a(graphQLPrivacyOption).m22665a(a.a()).m22668b();
        SelectablePrivacyData.Builder builder = new SelectablePrivacyData.Builder(this.f15193h);
        builder.f15104c = false;
        this.f15193h = builder.m22696a(graphQLPrivacyOption).m22697b();
        m22814b(baseToken);
    }

    public static void ar(AudienceTypeaheadFragment audienceTypeaheadFragment) {
        au(audienceTypeaheadFragment);
        GraphQLPrivacyOption graphQLPrivacyOption = audienceTypeaheadFragment.f15193h.f15109d;
        Preconditions.checkNotNull(graphQLPrivacyOption);
        Builder a = Builder.a(PrivacyOptionHelper.e(graphQLPrivacyOption));
        a.g = GraphQLPrivacyTagExpansionState.TAGGEES;
        graphQLPrivacyOption = GraphQLPrivacyOptionBuilder.m22662a(graphQLPrivacyOption).m22665a(a.a()).m22668b();
        SelectablePrivacyData.Builder builder = new SelectablePrivacyData.Builder(audienceTypeaheadFragment.f15193h);
        builder.f15104c = true;
        audienceTypeaheadFragment.f15193h = builder.m22696a(graphQLPrivacyOption).m22697b();
        SelectorListener aM = audienceTypeaheadFragment.aM();
        if (aM != null) {
            aM.m22786b();
        }
    }

    private void m22798a(final SelectablePrivacyData selectablePrivacyData) {
        List d;
        List e;
        PrivacyOptionsResult privacyOptionsResult = selectablePrivacyData.f15106a;
        GraphQLPrivacyOption graphQLPrivacyOption = selectablePrivacyData.f15109d;
        C10387 c10387 = new AbstractProvider<Integer>(this) {
            final /* synthetic */ AudienceTypeaheadFragment f15180b;

            public Object get() {
                return selectablePrivacyData != null ? Integer.valueOf(selectablePrivacyData.m22699c()) : null;
            }
        };
        if (((TriState) this.f15192g.get()).asBoolean(false)) {
            d = m22823d(selectablePrivacyData);
            e = m22826e(selectablePrivacyData);
        } else {
            e = m22810b(selectablePrivacyData);
            d = m22816c(selectablePrivacyData);
        }
        SectionedListSection a = this.f15187b.m22870a(privacyOptionsResult, graphQLPrivacyOption, c10387, jW_(), e, d);
        this.ar.m27104a(AudienceSectionIndices.f15183a, a);
        this.aE = a.mo1212e().size();
    }

    private static List<BaseToken> m22794a(TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView) {
        BaseTokenSpan[] baseTokenSpanArr = (BaseTokenSpan[]) tokenizedAutoCompleteTextView.getPickedTokenSpans();
        List<BaseToken> a = Lists.a();
        for (TokenSpan tokenSpan : baseTokenSpanArr) {
            a.add(tokenSpan.f19988f);
        }
        return a;
    }

    private List<GraphQLPrivacyAudienceMember> m22810b(SelectablePrivacyData selectablePrivacyData) {
        if (!CollectionUtil.a(this.aB)) {
            return this.aB;
        }
        if (selectablePrivacyData == null || selectablePrivacyData.f15106a == null || selectablePrivacyData.f15106a.selectedPrivacyOption == null || selectablePrivacyData.f15109d == null) {
            return RegularImmutableList.a;
        }
        if (this.f15187b.m22874c(selectablePrivacyData.f15109d)) {
            return selectablePrivacyData.f15109d.g();
        }
        GraphQLPrivacyOption graphQLPrivacyOption = selectablePrivacyData.f15106a.selectedPrivacyOption;
        if (this.f15187b.m22874c(graphQLPrivacyOption)) {
            return graphQLPrivacyOption.g();
        }
        return RegularImmutableList.a;
    }

    private List<GraphQLPrivacyAudienceMember> m22816c(SelectablePrivacyData selectablePrivacyData) {
        if (!CollectionUtil.a(this.aC)) {
            return this.aC;
        }
        if (selectablePrivacyData == null || selectablePrivacyData.f15106a == null || selectablePrivacyData.f15106a.selectedPrivacyOption == null || selectablePrivacyData.f15109d == null) {
            return RegularImmutableList.a;
        }
        if (this.f15187b.m22875d(selectablePrivacyData.f15109d)) {
            return selectablePrivacyData.f15109d.F_();
        }
        GraphQLPrivacyOption graphQLPrivacyOption = selectablePrivacyData.f15106a.selectedPrivacyOption;
        if (this.f15187b.m22875d(graphQLPrivacyOption)) {
            return graphQLPrivacyOption.F_();
        }
        return RegularImmutableList.a;
    }

    private List<GraphQLPrivacyAudienceMember> m22823d(SelectablePrivacyData selectablePrivacyData) {
        if (!CollectionUtil.a(this.aC)) {
            return this.aC;
        }
        if (selectablePrivacyData == null || selectablePrivacyData.f15106a == null || selectablePrivacyData.f15106a.selectedPrivacyOption == null || selectablePrivacyData.f15109d == null) {
            return RegularImmutableList.a;
        }
        if (this.f15187b.m22873b(selectablePrivacyData.f15109d)) {
            return selectablePrivacyData.f15109d.F_();
        }
        PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer = selectablePrivacyData.f15106a.selectedPrivacyOption;
        if (this.f15187b.m22873b(privacyOptionFieldsForComposer)) {
            return privacyOptionFieldsForComposer.F_();
        }
        return RegularImmutableList.a;
    }

    private List<GraphQLPrivacyAudienceMember> m22826e(SelectablePrivacyData selectablePrivacyData) {
        if (!CollectionUtil.a(this.aB)) {
            return this.aB;
        }
        if (selectablePrivacyData == null || selectablePrivacyData.f15106a == null || selectablePrivacyData.f15106a.selectedPrivacyOption == null || selectablePrivacyData.f15109d == null) {
            return RegularImmutableList.a;
        }
        if (this.f15187b.m22873b(selectablePrivacyData.f15109d)) {
            return selectablePrivacyData.f15109d.g();
        }
        PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer = selectablePrivacyData.f15106a.selectedPrivacyOption;
        if (this.f15187b.m22873b(privacyOptionFieldsForComposer)) {
            return privacyOptionFieldsForComposer.g();
        }
        return RegularImmutableList.a;
    }

    private void as() {
        SelectablePrivacyData a = aN().mo1183a();
        m22798a(a);
        if (this.f15193h == null || this.f15193h.f15106a == null || a == null || a.f15106a == null || this.f15193h.f15107b != a.f15107b || !Objects.equal(this.f15193h.f15109d, a.f15109d) || !Objects.equal(this.f15193h.f15106a.selectedPrivacyOption, a.f15106a.selectedPrivacyOption)) {
            this.f15193h = a;
            if (this.f15187b.m22874c(this.f15193h.f15109d)) {
                m22827e(this, this.f15193h.f15109d.g());
            }
            if (this.f15187b.m22875d(this.f15193h.f15109d)) {
                m22829f(this, this.f15193h.f15109d.F_());
            }
            if (this.f15187b.m22873b((PrivacyOptionFieldsForComposer) this.f15193h.f15109d)) {
                m22808a(this.f15193h.f15109d.F_(), this.f15193h.f15109d.g());
            }
            at();
        }
    }

    private void at() {
        if (this.f15193h != null) {
            PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation = this.f15193h.f15109d;
            if (privacyOptionFieldsWithExplanation != null) {
                int c = this.f15193h.m22699c();
                if (c != -1) {
                    this.aq.m28737b();
                    if (this.f15187b.m22873b((PrivacyOptionFieldsForComposer) privacyOptionFieldsWithExplanation)) {
                        this.aq.m28732a(aI(this));
                    } else if (this.f15187b.m22874c(privacyOptionFieldsWithExplanation)) {
                        this.aq.m28732a(aJ(this));
                    } else if (this.f15187b.m22875d(privacyOptionFieldsWithExplanation)) {
                        this.aq.m28732a(aK(this));
                    } else {
                        Token a = ((PrivacyOptionsSection) this.ar.m27115g(AudienceSectionIndices.f15183a)).m22849a(c);
                        if (a == null) {
                            a = this.f15187b.m22868a(privacyOptionFieldsWithExplanation, c);
                        }
                        this.aq.m28732a(a);
                    }
                    this.aD = m22794a(this.aq);
                    if (!this.aD.isEmpty() && m22820c((BaseToken) this.aD.get(0))) {
                        av();
                    }
                    aA(this);
                }
            }
        }
    }

    public static void au(AudienceTypeaheadFragment audienceTypeaheadFragment) {
        Token aw = aw(audienceTypeaheadFragment);
        if (aw != null) {
            audienceTypeaheadFragment.aD.remove(aw);
            audienceTypeaheadFragment.aq.m28733a(aw, true);
        }
    }

    private void m22814b(BaseToken baseToken) {
        Preconditions.checkArgument(baseToken.f15080a == Type.TAG_EXPANSION, "Treating non tag expansion token as a tag expansion token");
        this.aq.setSelection(this.aq.getText().length());
        this.aD.add(baseToken);
        this.aq.m28732a((Token) baseToken);
        this.aq.m28738c();
    }

    private void av() {
        boolean z = true;
        if (this.f15193h != null) {
            if (this.av.getVisibility() == 0) {
                this.aD = m22794a(this.aq);
            }
            au(this);
            if (!this.aD.isEmpty()) {
                BaseToken baseToken = (BaseToken) this.aD.get(0);
                if (m22820c(baseToken)) {
                    Object aI;
                    PrivacyOptionsSection privacyOptionsSection = (PrivacyOptionsSection) this.ar.m27115g(AudienceSectionIndices.f15183a);
                    privacyOptionsSection.m22856j();
                    if (baseToken.f15080a == Type.FULL_CUSTOM) {
                        aI = aI(this);
                    } else if (baseToken.f15080a == Type.FRIENDS_EXCEPT) {
                        aI = aJ(this);
                    } else if (baseToken.f15080a == Type.SPECIFIC_FRIENDS) {
                        aI = aK(this);
                    } else {
                        aI = privacyOptionsSection.m22849a(this.f15193h.m22699c());
                    }
                    if (this.ax && aI != null && this.f15193h != null && this.f15193h.m22701f()) {
                        ImmutableList G_ = this.f15193h.f15109d.G_();
                        if (G_ == null || G_.size() <= 1) {
                            z = false;
                        }
                        BaseToken a = this.f15187b.m22869a(this.f15193h.m22702g(), jW_(), false, z);
                        if (this.av.getVisibility() == 0) {
                            privacyOptionsSection.m22850a(a, privacyOptionsSection.mo1212e().indexOf(aI) + 1);
                        }
                        AdapterDetour.a(this.ar, 1494220557);
                        if (!this.f15193h.f15107b || !z) {
                            m22814b(a);
                        }
                    }
                }
            }
        }
    }

    private void az() {
        if (this.y && this.ap.getVisibility() != 0) {
            this.ap.setVisibility(0);
            this.av.getViewTreeObserver().addOnPreDrawListener(new C10398(this));
            as();
            if (!this.aD.isEmpty()) {
                av();
            }
            at();
            this.aq.setSelection(this.aq.getText().length());
            SelectorListener aM = aM();
            if (aM != null) {
                aM.m22785a();
            }
            aL(this);
        }
    }

    public static TagExpansionToken aw(AudienceTypeaheadFragment audienceTypeaheadFragment) {
        for (BaseToken baseToken : audienceTypeaheadFragment.aD) {
            if (baseToken.f15080a == Type.TAG_EXPANSION) {
                return (TagExpansionToken) baseToken;
            }
        }
        return null;
    }

    public final void m22844a(SelectorListener selectorListener) {
        this.f15191f = new WeakReference(Preconditions.checkNotNull(selectorListener));
    }

    public final void m22843a(DataProvider dataProvider) {
        this.f15190e = new WeakReference(Preconditions.checkNotNull(dataProvider));
    }

    private boolean ax() {
        return (this.f15193h == null || this.f15193h.f15109d == null) ? false : true;
    }

    public final boolean m22846b() {
        if (this.as == null || this.as.getVisibility() != 0) {
            if (this.at != null && this.at.getVisibility() == 0) {
                this.at.setVisibility(8);
                aL(this);
                return false;
            } else if (this.au == null || this.au.getVisibility() != 0) {
                return true;
            } else {
                ay();
                this.au.setVisibility(8);
                aL(this);
                this.ao.b(this.aC.size());
                return false;
            }
        } else if (!this.ay.m22901e()) {
            return false;
        } else {
            ay();
            this.as.setVisibility(8);
            aL(this);
            return false;
        }
    }

    private void ay() {
        int i = 0;
        if (this.aC != null && this.aC.size() == 1) {
            if (!((TriState) this.f15192g.get()).asBoolean(false) || !CollectionUtil.b(this.aB)) {
                GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember = (GraphQLPrivacyAudienceMember) this.aC.get(0);
                if (graphQLPrivacyAudienceMember.b() != null && graphQLPrivacyAudienceMember.b().g() == 236555388) {
                    String str = Allow.SOME_FRIENDS.name() + "," + graphQLPrivacyAudienceMember.c();
                    PrivacyOptionsResult privacyOptionsResult = this.f15193h.f15106a;
                    ImmutableList immutableList = privacyOptionsResult.friendListPrivacyOptions;
                    int size = immutableList.size();
                    while (i < size) {
                        PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation = (GraphQLPrivacyOption) immutableList.get(i);
                        PrivacyParameter a = PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation);
                        if (a == null || !str.equals(a.allow)) {
                            i++;
                        } else {
                            Token a2 = this.f15187b.m22868a(privacyOptionFieldsWithExplanation, privacyOptionsResult.b(privacyOptionFieldsWithExplanation));
                            this.aq.m28737b();
                            this.aq.m28732a(a2);
                            List arrayList = new ArrayList();
                            arrayList.add(a2);
                            m22819c(arrayList);
                            av();
                            this.aq.m28740e();
                            m22798a(this.f15193h);
                            return;
                        }
                    }
                }
            }
        }
    }

    public final SelectablePrivacyData m22848e() {
        if (!ax()) {
            as();
        }
        aN().mo1183a();
        for (int i = 0; i < this.ar.mo1063c(); i++) {
            ((SectionedListSection) this.ar.mo1060b(i)).mo433a(false);
        }
        AdapterDetour.a(this.ar, -1872887860);
        this.aq.m28729a();
        this.aq.clearComposingText();
        this.aq.m28740e();
        this.aD = m22794a(this.aq);
        return this.f15193h;
    }

    public static void aA(AudienceTypeaheadFragment audienceTypeaheadFragment) {
        if (audienceTypeaheadFragment.aq != null) {
            audienceTypeaheadFragment.aD = m22794a(audienceTypeaheadFragment.aq);
        }
        if (audienceTypeaheadFragment.ar != null && !audienceTypeaheadFragment.aD.isEmpty()) {
            boolean b = audienceTypeaheadFragment.aN().mo1184b();
            if (b != audienceTypeaheadFragment.ax) {
                audienceTypeaheadFragment.ax = b;
                audienceTypeaheadFragment.av();
                if (!audienceTypeaheadFragment.ax && audienceTypeaheadFragment.f15193h != null) {
                    SelectablePrivacyData.Builder builder = new SelectablePrivacyData.Builder(audienceTypeaheadFragment.f15193h);
                    builder.f15104c = true;
                    audienceTypeaheadFragment.f15193h = builder.m22697b();
                }
            }
        }
    }

    private GraphQLPrivacyOption m22790a(PrivacyToken privacyToken) {
        Preconditions.checkNotNull(privacyToken.mo1196c());
        GraphQLPrivacyOption a = this.f15193h.f15106a.a(privacyToken.mo1196c().intValue());
        Preconditions.checkNotNull(a);
        Builder a2 = Builder.a(PrivacyOptionHelper.e(a));
        a2.g = aB();
        return GraphQLPrivacyOptionBuilder.m22662a(a).m22665a(a2.a()).m22668b();
    }

    private GraphQLPrivacyOption m22789a(GraphQLPrivacyBaseState graphQLPrivacyBaseState, List<GraphQLPrivacyAudienceMember> list, List<GraphQLPrivacyAudienceMember> list2) {
        GraphQLPrivacyOptionBuilder graphQLPrivacyOptionBuilder = new GraphQLPrivacyOptionBuilder();
        if (graphQLPrivacyBaseState == GraphQLPrivacyBaseState.SELF) {
            graphQLPrivacyOptionBuilder.m22672c("{\"value\":\"SELF\"}");
        } else {
            graphQLPrivacyOptionBuilder.m22672c("{\"value\":\"ALL_FRIENDS\"}");
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        if (list != null) {
            for (GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember : list) {
                builder.c(graphQLPrivacyAudienceMember);
                builder2.c(graphQLPrivacyAudienceMember.c());
                graphQLPrivacyOptionBuilder.m22667a(graphQLPrivacyAudienceMember.c());
            }
        }
        ImmutableList.Builder builder3 = ImmutableList.builder();
        ImmutableList.Builder builder4 = ImmutableList.builder();
        if (list2 != null) {
            for (GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember2 : list2) {
                builder3.c(graphQLPrivacyAudienceMember2);
                builder4.c(graphQLPrivacyAudienceMember2.c());
                graphQLPrivacyOptionBuilder.m22670b(graphQLPrivacyAudienceMember2.c());
            }
        }
        GraphQLImage.Builder builder5 = new GraphQLImage.Builder();
        builder5.e = "custom";
        GraphQLImage a = builder5.a();
        Builder builder6 = new Builder();
        builder6.e = graphQLPrivacyBaseState;
        builder6 = builder6;
        builder6.d = builder2.b();
        Builder builder7 = builder6;
        builder7.f = builder4.b();
        builder7 = builder7;
        builder7.g = aB();
        graphQLPrivacyOptionBuilder.m22673d(AudienceTypeaheadUtil.m22860a(jW_())).m22664a(a).m22666a(builder.b()).m22669b(builder3.b()).m22665a(builder7.a());
        if (graphQLPrivacyBaseState == GraphQLPrivacyBaseState.SELF) {
            graphQLPrivacyOptionBuilder.m22671c(ImmutableList.of(GraphQLPrivacyOptionTagExpansionType.TAGGEES));
        } else {
            graphQLPrivacyOptionBuilder.m22671c(ImmutableList.of(GraphQLPrivacyOptionTagExpansionType.FRIENDS_OF_TAGGEES, GraphQLPrivacyOptionTagExpansionType.TAGGEES));
        }
        return graphQLPrivacyOptionBuilder.m22668b();
    }

    private GraphQLPrivacyOption m22791a(List<GraphQLPrivacyAudienceMember> list) {
        GraphQLPrivacyOptionBuilder c = new GraphQLPrivacyOptionBuilder().m22672c("{\"value\":\"ALL_FRIENDS\"}");
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        for (GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember : list) {
            builder.c(graphQLPrivacyAudienceMember);
            builder2.c(graphQLPrivacyAudienceMember.c());
            c.m22670b(graphQLPrivacyAudienceMember.c());
        }
        GraphQLImage.Builder builder3 = new GraphQLImage.Builder();
        builder3.e = "friends_except_acquaintances";
        GraphQLImage a = builder3.a();
        Builder builder4 = new Builder();
        builder4.e = GraphQLPrivacyBaseState.FRIENDS;
        builder4 = builder4;
        builder4.f = builder2.b();
        Builder builder5 = builder4;
        builder5.g = aB();
        return c.m22673d(AudienceTypeaheadUtil.m22861a(jW_(), (List) list)).m22664a(a).m22666a(RegularImmutableList.a).m22669b(builder.b()).m22665a(builder5.a()).m22671c(ImmutableList.of(GraphQLPrivacyOptionTagExpansionType.FRIENDS_OF_TAGGEES, GraphQLPrivacyOptionTagExpansionType.TAGGEES)).m22668b();
    }

    private GraphQLPrivacyOption m22809b(List<GraphQLPrivacyAudienceMember> list) {
        GraphQLPrivacyOptionBuilder c = new GraphQLPrivacyOptionBuilder().m22672c("{\"value\":\"SELF\"}");
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        for (GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember : list) {
            builder.c(graphQLPrivacyAudienceMember);
            builder2.c(graphQLPrivacyAudienceMember.c());
            c.m22667a(graphQLPrivacyAudienceMember.c());
        }
        GraphQLImage.Builder builder3 = new GraphQLImage.Builder();
        builder3.e = "custom";
        GraphQLImage a = builder3.a();
        Builder builder4 = new Builder();
        builder4.e = GraphQLPrivacyBaseState.SELF;
        builder4 = builder4;
        builder4.d = builder2.b();
        Builder builder5 = builder4;
        builder5.g = aB();
        return c.m22673d(AudienceTypeaheadUtil.m22865b(jW_(), list)).m22664a(a).m22666a(builder.b()).m22669b(RegularImmutableList.a).m22665a(builder5.a()).m22671c(ImmutableList.of(GraphQLPrivacyOptionTagExpansionType.TAGGEES)).m22668b();
    }

    private GraphQLPrivacyTagExpansionState aB() {
        if (this.f15193h.f15107b) {
            return GraphQLPrivacyTagExpansionState.TAGGEES;
        }
        return GraphQLPrivacyTagExpansionState.UNSPECIFIED;
    }

    @VisibleForTesting
    protected final void m22845a(BaseToken baseToken, TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView) {
        aC();
        List a = m22794a(tokenizedAutoCompleteTextView);
        if (baseToken.f15080a == Type.FULL_CUSTOM) {
            if (CollectionUtil.a(this.aC) && aG() != null) {
                baseToken = aG();
            }
            if (this.as == null || this.as.getVisibility() == 8) {
                aD();
            }
        } else if (baseToken.f15080a == Type.FRIENDS_EXCEPT) {
            if (CollectionUtil.a(this.aB) && aG() != null) {
                baseToken = aG();
            }
            if (this.at == null || this.at.getVisibility() == 8) {
                aE();
            }
        } else if (baseToken.f15080a == Type.SPECIFIC_FRIENDS) {
            if (CollectionUtil.a(this.aC) && aH() != null) {
                baseToken = aH();
            }
            if (this.au == null || this.au.getVisibility() == 8) {
                aF();
            }
        }
        if ((baseToken.f15080a != Type.TAG_EXPANSION && baseToken.f15080a == Type.PRIVACY) || baseToken.f15080a == Type.FULL_CUSTOM || baseToken.f15080a == Type.FRIENDS_EXCEPT || baseToken.f15080a == Type.SPECIFIC_FRIENDS) {
            tokenizedAutoCompleteTextView.m28737b();
            a.clear();
        }
        boolean z = false;
        if (a.contains(baseToken)) {
            tokenizedAutoCompleteTextView.m28733a((Token) baseToken, true);
            a.remove(baseToken);
            z = true;
        } else {
            tokenizedAutoCompleteTextView.m28732a((Token) baseToken);
            a.add(baseToken);
        }
        m22819c(a);
        if (baseToken.f15080a != Type.TAG_EXPANSION || this.f15193h.f15109d == null) {
            av();
        } else if (z) {
            ar(this);
        } else {
            m22803a(baseToken);
        }
        tokenizedAutoCompleteTextView.m28740e();
    }

    private void aC() {
        Object obj = 1;
        if (this.ar != null) {
            SectionedListSection sectionedListSection = (SectionedListSection) this.ar.mo1060b(AudienceSectionIndices.f15183a);
            Object obj2 = ((sectionedListSection instanceof ExpandableSectionedListSection) && sectionedListSection.mo435c()) ? 1 : null;
            if (sectionedListSection.mo434b().size() != this.aE) {
                obj = null;
            }
            if (obj2 == null && r2 == null) {
                SelectorListener aM = aM();
                if (aM != null) {
                    aM.m22787c();
                }
            }
        }
    }

    private void m22819c(List<BaseToken> list) {
        if (this.f15193h != null) {
            if (list.isEmpty()) {
                this.f15193h = new SelectablePrivacyData.Builder(this.f15193h).m22696a(null).m22697b();
                return;
            }
            BaseToken d = m22822d((List) list);
            switch (d.f15080a) {
                case PRIVACY:
                    this.f15193h = new SelectablePrivacyData.Builder(this.f15193h).m22696a(m22790a((PrivacyToken) d)).m22697b();
                    return;
                case FULL_CUSTOM:
                    if (this.aC != null) {
                        this.f15193h = new SelectablePrivacyData.Builder(this.f15193h).m22696a(m22789a(GraphQLPrivacyBaseState.SELF, this.aC, this.aB)).m22697b();
                        return;
                    }
                    return;
                case FRIENDS_EXCEPT:
                    if (this.aB != null) {
                        this.f15193h = new SelectablePrivacyData.Builder(this.f15193h).m22696a(m22791a(this.aB)).m22697b();
                        return;
                    }
                    return;
                case SPECIFIC_FRIENDS:
                    if (this.aC != null) {
                        this.f15193h = new SelectablePrivacyData.Builder(this.f15193h).m22696a(m22809b(this.aC)).m22697b();
                        return;
                    }
                    return;
                default:
                    this.an.a(SoftError.a(f15186a.getSimpleName(), StringFormatUtil.formatStrLocaleSafe("Unexpected selected option token of type %s", d.f15080a.name())).g());
                    return;
            }
        }
    }

    private static BaseToken m22822d(List<BaseToken> list) {
        BaseToken baseToken = (BaseToken) list.get(0);
        if (baseToken.f15080a == Type.TAG_EXPANSION && list.size() == 2) {
            return (BaseToken) list.get(1);
        }
        return baseToken;
    }

    private void m22805a(CharSequence charSequence) {
        Toast makeText = Toast.makeText(getContext(), charSequence, 1);
        makeText.setGravity(48, 0, 0);
        makeText.show();
    }

    private static boolean m22820c(BaseToken baseToken) {
        return baseToken.f15080a == Type.PRIVACY || baseToken.f15080a == Type.FULL_CUSTOM || baseToken.f15080a == Type.FRIENDS_EXCEPT || baseToken.f15080a == Type.SPECIFIC_FRIENDS;
    }

    private void aD() {
        FragmentManager s = s();
        if (s.a(2131566110) == null) {
            this.ay = new CustomPrivacyFragment();
            FragmentTransaction a = s().a();
            a.a(2131566110, this.ay);
            a.b();
            s.b();
        } else {
            this.ay = (CustomPrivacyFragment) s.a(2131566110);
        }
        this.ay.au = new C10409(this);
        this.ay.av = new AbstractProvider<ImmutableList<GraphQLPrivacyAudienceMember>>(this) {
            final /* synthetic */ AudienceTypeaheadFragment f15158a;

            {
                this.f15158a = r1;
            }

            public Object get() {
                if (CollectionUtil.a(this.f15158a.aC)) {
                    return RegularImmutableList.a;
                }
                return ImmutableList.copyOf(this.f15158a.aC);
            }
        };
        this.ay.ax = new SelectedMembersUpdater(this) {
            final /* synthetic */ AudienceTypeaheadFragment f15159a;

            {
                this.f15159a = r1;
            }

            public final void mo1199a(List<GraphQLPrivacyAudienceMember> list) {
                if (list != null) {
                    this.f15159a.m22808a(this.f15159a.aC, (List) list);
                    this.f15159a.m22845a(AudienceTypeaheadFragment.aI(this.f15159a), this.f15159a.aq);
                    this.f15159a.m22798a(this.f15159a.f15193h);
                }
            }
        };
        this.ay.ay = new AbstractProvider<ImmutableList<GraphQLPrivacyAudienceMember>>(this) {
            final /* synthetic */ AudienceTypeaheadFragment f15160a;

            {
                this.f15160a = r1;
            }

            public Object get() {
                if (CollectionUtil.a(this.f15160a.aB)) {
                    return RegularImmutableList.a;
                }
                return ImmutableList.copyOf(this.f15160a.aB);
            }
        };
        this.ay.az = new AbstractProvider<ImmutableList<GraphQLPrivacyOption>>(this) {
            final /* synthetic */ AudienceTypeaheadFragment f15161a;

            {
                this.f15161a = r1;
            }

            public Object get() {
                return this.f15161a.f15193h.f15106a.friendListPrivacyOptions;
            }
        };
        this.ay.m22898b();
        this.as = this.ap.findViewById(2131566110);
        this.as.setVisibility(0);
    }

    private void aE() {
        FragmentManager s = s();
        if (s.a(2131566111) == null) {
            this.az = FriendsExceptTypeaheadFragment.m22905a(false);
            FragmentTransaction a = s().a();
            a.a(2131566111, this.az);
            a.b();
            s.b();
        } else {
            this.az = (FriendsExceptTypeaheadFragment) s.a(2131566111);
        }
        this.az.m22730a(new SelectedMembersUpdater(this) {
            final /* synthetic */ AudienceTypeaheadFragment f15162a;

            {
                this.f15162a = r1;
            }

            public final void mo1199a(List<GraphQLPrivacyAudienceMember> list) {
                if (list != null) {
                    AudienceTypeaheadFragment.m22827e(this.f15162a, list);
                    this.f15162a.m22798a(this.f15162a.f15193h);
                    this.f15162a.m22845a(AudienceTypeaheadFragment.aJ(this.f15162a), this.f15162a.aq);
                }
            }
        });
        this.az.ax = new AbstractProvider<ImmutableList<GraphQLPrivacyAudienceMember>>(this) {
            final /* synthetic */ AudienceTypeaheadFragment f15163a;

            {
                this.f15163a = r1;
            }

            public Object get() {
                return CollectionUtil.a(this.f15163a.aB) ? RegularImmutableList.a : ImmutableList.copyOf(this.f15163a.aB);
            }
        };
        this.az.ay = new AbstractProvider<ImmutableList<GraphQLPrivacyOption>>(this) {
            final /* synthetic */ AudienceTypeaheadFragment f15164a;

            {
                this.f15164a = r1;
            }

            public Object get() {
                return this.f15164a.f15193h.f15106a.friendListPrivacyOptions;
            }
        };
        this.az.m22734e();
        this.at = this.ap.findViewById(2131566111);
        this.at.setVisibility(0);
    }

    private void aF() {
        FragmentManager s = s();
        if (s.a(2131566112) == null) {
            this.aA = new SpecificFriendsTypeaheadFragment();
            FragmentTransaction a = s().a();
            a.a(2131566112, this.aA);
            a.b();
            s.b();
        } else {
            this.aA = (SpecificFriendsTypeaheadFragment) s.a(2131566112);
        }
        this.aA.m22730a(new SelectedMembersUpdater(this) {
            final /* synthetic */ AudienceTypeaheadFragment f15165a;

            {
                this.f15165a = r1;
            }

            public final void mo1199a(List<GraphQLPrivacyAudienceMember> list) {
                if (list != null) {
                    AudienceTypeaheadFragment.m22829f(this.f15165a, list);
                    this.f15165a.m22845a(AudienceTypeaheadFragment.aK(this.f15165a), this.f15165a.aq);
                    this.f15165a.m22798a(this.f15165a.f15193h);
                }
            }
        });
        this.aA.ax = new AbstractProvider<ImmutableList<GraphQLPrivacyAudienceMember>>(this) {
            final /* synthetic */ AudienceTypeaheadFragment f15166a;

            {
                this.f15166a = r1;
            }

            public Object get() {
                if (CollectionUtil.a(this.f15166a.aC)) {
                    return RegularImmutableList.a;
                }
                return ImmutableList.copyOf(this.f15166a.aC);
            }
        };
        this.aA.ay = new AbstractProvider<ImmutableList<GraphQLPrivacyOption>>(this) {
            final /* synthetic */ AudienceTypeaheadFragment f15167a;

            {
                this.f15167a = r1;
            }

            public Object get() {
                return this.f15167a.f15193h.f15106a.friendListPrivacyOptions;
            }
        };
        this.aA.m22734e();
        this.au = this.ap.findViewById(2131566112);
        this.au.setVisibility(0);
        this.ao.a(this.aC != null ? this.aC.size() : -1);
    }

    private void m22808a(List<GraphQLPrivacyAudienceMember> list, List<GraphQLPrivacyAudienceMember> list2) {
        this.aC = list;
        this.aB = list2;
        this.f15193h = new SelectablePrivacyData.Builder(this.f15193h).m22696a(m22789a(GraphQLPrivacyBaseState.SELF, this.aC, this.aB)).m22697b();
    }

    public static void m22827e(AudienceTypeaheadFragment audienceTypeaheadFragment, List list) {
        audienceTypeaheadFragment.aB = list;
        audienceTypeaheadFragment.f15193h = new SelectablePrivacyData.Builder(audienceTypeaheadFragment.f15193h).m22696a(audienceTypeaheadFragment.m22791a(audienceTypeaheadFragment.aB)).m22697b();
    }

    public static void m22829f(AudienceTypeaheadFragment audienceTypeaheadFragment, List list) {
        audienceTypeaheadFragment.aC = list;
        audienceTypeaheadFragment.f15193h = new SelectablePrivacyData.Builder(audienceTypeaheadFragment.f15193h).m22696a(audienceTypeaheadFragment.m22809b(audienceTypeaheadFragment.aC)).m22697b();
    }

    private PrivacyToken aG() {
        if (this.f15193h == null || this.f15193h.f15106a == null) {
            return null;
        }
        PrivacyOptionsResult privacyOptionsResult = this.f15193h.f15106a;
        ImmutableList immutableList = privacyOptionsResult.basicPrivacyOptions;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation = (GraphQLPrivacyOption) immutableList.get(i);
            if (PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation) == GraphQLPrivacyOptionType.FRIENDS) {
                return this.f15187b.m22868a(privacyOptionFieldsWithExplanation, privacyOptionsResult.b(privacyOptionFieldsWithExplanation));
            }
        }
        return null;
    }

    private PrivacyToken aH() {
        if (this.f15193h == null || this.f15193h.f15106a == null) {
            return null;
        }
        PrivacyOptionsResult privacyOptionsResult = this.f15193h.f15106a;
        ImmutableList immutableList = privacyOptionsResult.basicPrivacyOptions;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation = (GraphQLPrivacyOption) immutableList.get(i);
            if (PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation) == GraphQLPrivacyOptionType.ONLY_ME) {
                return this.f15187b.m22868a(privacyOptionFieldsWithExplanation, privacyOptionsResult.b(privacyOptionFieldsWithExplanation));
            }
        }
        return null;
    }

    public static CustomPrivacyToken aI(AudienceTypeaheadFragment audienceTypeaheadFragment) {
        return ((PrivacyOptionsSection) audienceTypeaheadFragment.ar.m27115g(AudienceSectionIndices.f15183a)).m22853g();
    }

    public static FriendsExceptToken aJ(AudienceTypeaheadFragment audienceTypeaheadFragment) {
        return ((PrivacyOptionsSection) audienceTypeaheadFragment.ar.m27115g(AudienceSectionIndices.f15183a)).m22854h();
    }

    public static SpecificFriendsToken aK(AudienceTypeaheadFragment audienceTypeaheadFragment) {
        return ((PrivacyOptionsSection) audienceTypeaheadFragment.ar.m27115g(AudienceSectionIndices.f15183a)).m22855i();
    }

    private void m22804a(BaseToken baseToken, View view) {
        if (baseToken != null) {
            m22845a(baseToken, this.aq);
            this.aq.m28739d();
            if (!(baseToken instanceof FriendsExceptToken) && !(baseToken instanceof SpecificFriendsToken) && !(baseToken instanceof CustomPrivacyToken)) {
                int i = -1;
                if (view instanceof TypeaheadItemRow) {
                    i = 2131560883;
                } else if (view instanceof TypeaheadSubtitledItemRow) {
                    i = 2131561319;
                }
                if (i > 0) {
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        m22796a(textView);
                    }
                }
            }
        }
    }

    private void m22796a(final TextView textView) {
        Layout layout = textView.getLayout();
        if (layout != null) {
            m22795a(layout, textView.getText());
            return;
        }
        final ViewTreeObserver viewTreeObserver = textView.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ AudienceTypeaheadFragment f15171c;

            public void onGlobalLayout() {
                this.f15171c.m22795a(textView.getLayout(), textView.getText());
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        });
    }

    private void m22795a(Layout layout, CharSequence charSequence) {
        if (layout != null) {
            int lineCount = layout.getLineCount() - 1;
            if (lineCount >= 0 && layout.getEllipsisCount(lineCount) > 0) {
                m22805a(charSequence);
            }
        }
    }

    public static void aL(AudienceTypeaheadFragment audienceTypeaheadFragment) {
        audienceTypeaheadFragment.am.hideSoftInputFromWindow(audienceTypeaheadFragment.aq.getWindowToken(), 0);
    }

    @Nullable
    private SelectorListener aM() {
        if (this.f15191f == null) {
            return null;
        }
        return (SelectorListener) Preconditions.checkNotNull(this.f15191f.get());
    }

    private DataProvider aN() {
        Preconditions.checkNotNull(this.f15190e);
        return (DataProvider) Preconditions.checkNotNull(this.f15190e.get());
    }
}
