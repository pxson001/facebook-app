package com.facebook.platform.composer.targetprivacy;

import android.content.Context;
import android.os.Build.VERSION;
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
import android.view.View.OnClickListener;
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
import com.facebook.funnellogger.FunnelLogger;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
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
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.platform.composer.composer.PlatformComposerControllerFragment.C05094;
import com.facebook.privacy.gating.IsFullCustomPrivacyEnabled;
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
import com.facebook.privacy.selector.AbstractCustomPrivacyTypeaheadFragment;
import com.facebook.privacy.selector.AbstractCustomPrivacyTypeaheadFragment.SelectedMembersUpdater;
import com.facebook.privacy.selector.AudienceTypeaheadUtil;
import com.facebook.privacy.selector.CustomPrivacyFragment;
import com.facebook.privacy.selector.FriendsExceptTypeaheadFragment;
import com.facebook.privacy.selector.PrivacyTokenMatcher;
import com.facebook.privacy.selector.SpecificFriendsTypeaheadFragment;
import com.facebook.privacy.service.PrivacyAnalyticsLogger;
import com.facebook.privacy.ui.PrivacyOptionsSection;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.BetterListView;
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
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadItemRow;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadSubtitledItemRow;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: results_display_styles */
public class PlatformComposerPrivacyFragment extends FbFragment {
    private static final Class<?> am = PlatformComposerPrivacyFragment.class;
    @Inject
    public AudienceTypeaheadUtil f4364a;
    public List<GraphQLPrivacyAudienceMember> aA;
    public List<BaseToken> aB = new ArrayList();
    public final OnScrollListener aC = new C05601(this);
    private final TextWatcher aD = new C05612(this);
    public final OnItemClickListener aE = new C05623(this);
    @Inject
    public FunnelLoggerImpl al;
    private WeakReference<DataProvider> an;
    public SelectablePrivacyData ao;
    public C05094 ap;
    public View aq;
    public TokenizedAutoCompleteTextView ar;
    public View as;
    private View at;
    public View au;
    public BetterListView av;
    private boolean aw;
    public boolean ax;
    public CustomPrivacyFragment ay;
    public List<GraphQLPrivacyAudienceMember> az;
    @Inject
    public PrivacyTokenMatcher f4365b;
    @Inject
    @IsFullCustomPrivacyEnabled
    Provider<TriState> f4366c;
    @Inject
    AddressBookPeriodicRunner f4367d;
    @Inject
    DefaultUserInteractionController f4368e;
    @Inject
    InputMethodManager f4369f;
    @Inject
    AbstractFbErrorReporter f4370g;
    @Inject
    public PrivacyAnalyticsLogger f4371h;
    @Inject
    public TypeaheadAdapter f4372i;

    /* compiled from: results_display_styles */
    class C05601 implements OnScrollListener {
        final /* synthetic */ PlatformComposerPrivacyFragment f4346a;

        C05601(PlatformComposerPrivacyFragment platformComposerPrivacyFragment) {
            this.f4346a = platformComposerPrivacyFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            switch (i) {
                case 0:
                    this.f4346a.f4368e.b(this.f4346a.T);
                    return;
                case 1:
                case 2:
                    this.f4346a.f4368e.a(this.f4346a.T);
                    PlatformComposerPrivacyFragment.aK(this.f4346a);
                    return;
                default:
                    return;
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* compiled from: results_display_styles */
    public class AnonymousClass21 implements OnGlobalLayoutListener {
        final /* synthetic */ TextView f4348a;
        final /* synthetic */ ViewTreeObserver f4349b;
        final /* synthetic */ PlatformComposerPrivacyFragment f4350c;

        public AnonymousClass21(PlatformComposerPrivacyFragment platformComposerPrivacyFragment, TextView textView, ViewTreeObserver viewTreeObserver) {
            this.f4350c = platformComposerPrivacyFragment;
            this.f4348a = textView;
            this.f4349b = viewTreeObserver;
        }

        public void onGlobalLayout() {
            PlatformComposerPrivacyFragment.m4251a(this.f4350c, this.f4348a.getLayout(), this.f4348a.getText());
            if (VERSION.SDK_INT >= 16) {
                this.f4349b.removeOnGlobalLayoutListener(this);
            } else {
                this.f4349b.removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* compiled from: results_display_styles */
    /* synthetic */ class AnonymousClass22 {
        static final /* synthetic */ int[] f4351a = new int[Type.values().length];

        static {
            try {
                f4351a[Type.PRIVACY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4351a[Type.FULL_CUSTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4351a[Type.FRIENDS_EXCEPT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4351a[Type.SPECIFIC_FRIENDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: results_display_styles */
    public class C05612 implements TextWatcher {
        public final /* synthetic */ PlatformComposerPrivacyFragment f4352a;
        public boolean f4353b;

        C05612(PlatformComposerPrivacyFragment platformComposerPrivacyFragment) {
            this.f4352a = platformComposerPrivacyFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (i3 < i2 && PlatformComposerPrivacyFragment.aw(this.f4352a) != null) {
                this.f4353b = true;
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (i3 < i2) {
                this.f4352a.ar.d();
                if (!this.f4352a.aB.isEmpty() && this.f4353b) {
                    if ((PlatformComposerPrivacyFragment.aw(this.f4352a) != null ? 1 : null) == null) {
                        PlatformComposerPrivacyFragment.ar(this.f4352a);
                    }
                }
                this.f4353b = false;
            }
        }

        public void afterTextChanged(Editable editable) {
            this.f4352a.f4372i.a().a(this.f4352a.ar.getUserEnteredPlainText());
            Object obj = !this.f4352a.aB.isEmpty() ? 1 : null;
            this.f4352a.aB = PlatformComposerPrivacyFragment.m4258b(this.f4352a.ar);
            if (obj == null && !this.f4352a.aB.isEmpty()) {
                PlatformComposerPrivacyFragment.aA(this.f4352a);
            }
            if (this.f4352a.aB.size() == 1 && ((BaseToken) this.f4352a.aB.get(0)).a == Type.TAG_EXPANSION) {
                PlatformComposerPrivacyFragment.au(this.f4352a);
                ((PrivacyOptionsSection) this.f4352a.f4372i.g(AudienceSectionIndices.f4362a)).j();
            }
            this.f4352a.f4372i.i = this.f4352a.aB;
            PlatformComposerPrivacyFragment.m4261c(this.f4352a, this.f4352a.aB);
        }
    }

    /* compiled from: results_display_styles */
    class C05623 implements OnItemClickListener {
        final /* synthetic */ PlatformComposerPrivacyFragment f4354a;

        C05623(PlatformComposerPrivacyFragment platformComposerPrivacyFragment) {
            this.f4354a = platformComposerPrivacyFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BaseToken baseToken = (BaseToken) this.f4354a.f4372i.getItem(i);
            PlatformComposerPrivacyFragment platformComposerPrivacyFragment = this.f4354a;
            if (baseToken != null) {
                platformComposerPrivacyFragment.al.b(FunnelRegistry.l, StringFormatUtil.formatStrLocaleSafe(" %s privacy option clicked", baseToken.b()));
                platformComposerPrivacyFragment.m4269a(baseToken, platformComposerPrivacyFragment.ar);
                platformComposerPrivacyFragment.ar.d();
                if (!(baseToken instanceof FriendsExceptToken) && !(baseToken instanceof SpecificFriendsToken) && !(baseToken instanceof CustomPrivacyToken)) {
                    int i2 = -1;
                    if (view instanceof TypeaheadItemRow) {
                        i2 = 2131560883;
                    } else if (view instanceof TypeaheadSubtitledItemRow) {
                        i2 = 2131561319;
                    }
                    if (i2 > 0) {
                        TextView textView = (TextView) view.findViewById(i2);
                        if (textView != null) {
                            Layout layout = textView.getLayout();
                            if (layout != null) {
                                PlatformComposerPrivacyFragment.m4251a(platformComposerPrivacyFragment, layout, textView.getText());
                            } else {
                                ViewTreeObserver viewTreeObserver = textView.getViewTreeObserver();
                                viewTreeObserver.addOnGlobalLayoutListener(new AnonymousClass21(platformComposerPrivacyFragment, textView, viewTreeObserver));
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: results_display_styles */
    public class C05634 implements OnTouchListener {
        final /* synthetic */ PlatformComposerPrivacyFragment f4355a;

        public C05634(PlatformComposerPrivacyFragment platformComposerPrivacyFragment) {
            this.f4355a = platformComposerPrivacyFragment;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* compiled from: results_display_styles */
    class C05645 implements OnClickListener {
        final /* synthetic */ PlatformComposerPrivacyFragment f4356a;

        C05645(PlatformComposerPrivacyFragment platformComposerPrivacyFragment) {
            this.f4356a = platformComposerPrivacyFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1131176891);
            if (this.f4356a.ap != null) {
                this.f4356a.ap.m3969a(100);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1164253330, a);
        }
    }

    /* compiled from: results_display_styles */
    class C05656 implements OnKeyListener {
        final /* synthetic */ PlatformComposerPrivacyFragment f4357a;

        C05656(PlatformComposerPrivacyFragment platformComposerPrivacyFragment) {
            this.f4357a = platformComposerPrivacyFragment;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent == null || keyEvent.getKeyCode() != 66) {
                return false;
            }
            PlatformComposerPrivacyFragment.aK(this.f4357a);
            return true;
        }
    }

    /* compiled from: results_display_styles */
    public class C05667 implements OnBaseTokenClickedListener {
        final /* synthetic */ PlatformComposerPrivacyFragment f4358a;

        public C05667(PlatformComposerPrivacyFragment platformComposerPrivacyFragment) {
            this.f4358a = platformComposerPrivacyFragment;
        }

        public final void m4244a(Token token) {
            BaseToken baseToken = (BaseToken) token;
            if ((baseToken instanceof FriendsExceptToken) || (baseToken instanceof SpecificFriendsToken) || (baseToken instanceof CustomPrivacyToken)) {
                this.f4358a.m4269a(baseToken, this.f4358a.ar);
            }
        }
    }

    /* compiled from: results_display_styles */
    class C05689 implements OnPreDrawListener {
        final /* synthetic */ PlatformComposerPrivacyFragment f4361a;

        C05689(PlatformComposerPrivacyFragment platformComposerPrivacyFragment) {
            this.f4361a = platformComposerPrivacyFragment;
        }

        public boolean onPreDraw() {
            this.f4361a.av.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    /* compiled from: results_display_styles */
    public class AudienceSectionIndices {
        public static int f4362a = 0;
    }

    /* compiled from: results_display_styles */
    public class PrivacyItemViewFactory extends DefaultViewFactory {
        public OnBaseTokenClickedListener f4363a;

        public PrivacyItemViewFactory() {
            super(true);
        }

        public final View m4246b(ViewGroup viewGroup) {
            return new TypeaheadSubtitledItemRow(viewGroup.getContext(), 2130907579);
        }

        public final View m4247c(ViewGroup viewGroup) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(2130906325, viewGroup, false);
        }

        public final void m4245a(View view, BaseToken baseToken, boolean z) {
            super.a(view, baseToken, z);
            if ((baseToken instanceof FriendsExceptToken) || (baseToken instanceof SpecificFriendsToken) || (baseToken instanceof CustomPrivacyToken)) {
                baseToken.b = this.f4363a;
                ((TypeaheadItemRow) view).b();
            }
        }
    }

    public static void m4256a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PlatformComposerPrivacyFragment) obj).m4254a(AudienceTypeaheadUtil.b(fbInjector), PrivacyTokenMatcher.c(fbInjector), IdBasedProvider.a(fbInjector, 743), AddressBookPeriodicRunner.a(fbInjector), DefaultUserInteractionController.a(fbInjector), InputMethodManagerMethodAutoProvider.b(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), PrivacyAnalyticsLogger.b(fbInjector), TypeaheadAdapter.b(fbInjector), FunnelLoggerImpl.a(fbInjector));
    }

    private void m4254a(AudienceTypeaheadUtil audienceTypeaheadUtil, PrivacyTokenMatcher privacyTokenMatcher, Provider<TriState> provider, AddressBookPeriodicRunner addressBookPeriodicRunner, UserInteractionController userInteractionController, InputMethodManager inputMethodManager, FbErrorReporter fbErrorReporter, PrivacyAnalyticsLogger privacyAnalyticsLogger, TypeaheadAdapter typeaheadAdapter, FunnelLogger funnelLogger) {
        this.f4364a = audienceTypeaheadUtil;
        this.f4365b = privacyTokenMatcher;
        this.f4366c = provider;
        this.f4367d = addressBookPeriodicRunner;
        this.f4368e = userInteractionController;
        this.f4369f = inputMethodManager;
        this.f4370g = fbErrorReporter;
        this.f4371h = privacyAnalyticsLogger;
        this.f4372i = typeaheadAdapter;
        this.al = funnelLogger;
    }

    public static PlatformComposerPrivacyFragment m4265n(Bundle bundle) {
        PlatformComposerPrivacyFragment platformComposerPrivacyFragment = new PlatformComposerPrivacyFragment();
        platformComposerPrivacyFragment.g(bundle);
        return platformComposerPrivacyFragment;
    }

    public final View m4267a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 224686828);
        this.aq = layoutInflater.inflate(2130906310, viewGroup, false);
        View view = this.aq;
        TypeaheadAdapter typeaheadAdapter = this.f4372i;
        PrivacyTokenMatcher privacyTokenMatcher = this.f4365b;
        PrivacyItemViewFactory privacyItemViewFactory = new PrivacyItemViewFactory();
        privacyItemViewFactory.f4363a = new C05667(this);
        typeaheadAdapter.a(privacyTokenMatcher, privacyItemViewFactory);
        this.f4372i.a(ImmutableList.of(new ImmutableSectionedListSection(), new ImmutableSectionedListSection()));
        this.av = (BetterListView) view.findViewById(2131559373);
        this.av.setAdapter(this.f4372i);
        this.av.setOnScrollListener(this.aC);
        this.av.setOnItemClickListener(this.aE);
        view.findViewById(2131559557).setOnTouchListener(new C05634(this));
        m4260c(this.aq);
        view = this.aq;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -868297516, a);
        return view;
    }

    public final void m4271c(Bundle bundle) {
        super.c(bundle);
        Class cls = PlatformComposerPrivacyFragment.class;
        m4256a((Object) this, getContext());
        this.f4367d.a();
    }

    public final void m4266G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -78331258);
        super.G();
        az();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 710223631, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 673177406);
        this.av.setOnScrollListener(null);
        this.av.setOnItemClickListener(null);
        this.av = null;
        this.ar.removeTextChangedListener(this.aD);
        this.ar = null;
        this.f4372i = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1975388165, a);
    }

    private void m4260c(View view) {
        this.ar = (TokenizedAutoCompleteTextView) view.findViewById(2131566114);
        this.ar.addTextChangedListener(this.aD);
        this.ar.f = DropdownMode.NO_DROPDOWN;
        this.ar.setTextMode(TextMode.PLAIN_TEXT);
        this.ar.p = jW_().getColor(2131361917);
        this.ar.setLongClickable(false);
        this.ar.setFocusable(this.ax);
        if (!this.ax) {
            this.ar.setOnClickListener(new C05645(this));
        }
        this.ar.setOnKeyListener(new C05656(this));
    }

    private void m4255a(BaseToken baseToken) {
        au(this);
        Builder a = Builder.a(PrivacyOptionHelper.e(this.ao.d));
        a.g = GraphQLPrivacyTagExpansionState.UNSPECIFIED;
        GraphQLPrivacyOption b = GraphQLPrivacyOptionBuilder.a(this.ao.d).a(a.a()).b();
        SelectablePrivacyData.Builder builder = new SelectablePrivacyData.Builder(this.ao);
        builder.c = false;
        this.ao = builder.a(b).b();
        m4259b(baseToken);
    }

    public static void ar(PlatformComposerPrivacyFragment platformComposerPrivacyFragment) {
        au(platformComposerPrivacyFragment);
        Builder a = Builder.a(PrivacyOptionHelper.e(platformComposerPrivacyFragment.ao.d));
        a.g = GraphQLPrivacyTagExpansionState.TAGGEES;
        GraphQLPrivacyOption b = GraphQLPrivacyOptionBuilder.a(platformComposerPrivacyFragment.ao.d).a(a.a()).b();
        SelectablePrivacyData.Builder builder = new SelectablePrivacyData.Builder(platformComposerPrivacyFragment.ao);
        builder.c = true;
        platformComposerPrivacyFragment.ao = builder.a(b).b();
    }

    public static void m4252a(PlatformComposerPrivacyFragment platformComposerPrivacyFragment, final SelectablePrivacyData selectablePrivacyData) {
        List list;
        List list2;
        PrivacyOptionsResult privacyOptionsResult = selectablePrivacyData.a;
        GraphQLPrivacyOption graphQLPrivacyOption = selectablePrivacyData.d;
        C05678 c05678 = new AbstractProvider<Integer>(platformComposerPrivacyFragment) {
            final /* synthetic */ PlatformComposerPrivacyFragment f4360b;

            public Object get() {
                return Integer.valueOf(selectablePrivacyData.c());
            }
        };
        List list3;
        GraphQLPrivacyOption graphQLPrivacyOption2;
        if (((TriState) platformComposerPrivacyFragment.f4366c.get()).asBoolean(false)) {
            if (!CollectionUtil.a(platformComposerPrivacyFragment.aA)) {
                list3 = platformComposerPrivacyFragment.aA;
            } else if (selectablePrivacyData == null || selectablePrivacyData.a == null || selectablePrivacyData.a.selectedPrivacyOption == null || selectablePrivacyData.d == null) {
                list3 = RegularImmutableList.a;
            } else {
                if (platformComposerPrivacyFragment.f4364a.b(selectablePrivacyData.d)) {
                    list3 = selectablePrivacyData.d.F_();
                } else {
                    graphQLPrivacyOption2 = selectablePrivacyData.a.selectedPrivacyOption;
                    list3 = platformComposerPrivacyFragment.f4364a.b(graphQLPrivacyOption2) ? graphQLPrivacyOption2.F_() : RegularImmutableList.a;
                }
            }
            list = list3;
            if (!CollectionUtil.a(platformComposerPrivacyFragment.az)) {
                list3 = platformComposerPrivacyFragment.az;
            } else if (selectablePrivacyData == null || selectablePrivacyData.a == null || selectablePrivacyData.a.selectedPrivacyOption == null || selectablePrivacyData.d == null) {
                list3 = RegularImmutableList.a;
            } else {
                if (platformComposerPrivacyFragment.f4364a.b(selectablePrivacyData.d)) {
                    list3 = selectablePrivacyData.d.g();
                } else {
                    graphQLPrivacyOption2 = selectablePrivacyData.a.selectedPrivacyOption;
                    list3 = platformComposerPrivacyFragment.f4364a.b(graphQLPrivacyOption2) ? graphQLPrivacyOption2.g() : RegularImmutableList.a;
                }
            }
            list2 = list3;
        } else {
            if (!CollectionUtil.a(platformComposerPrivacyFragment.az)) {
                list3 = platformComposerPrivacyFragment.az;
            } else if (selectablePrivacyData == null || selectablePrivacyData.a == null || selectablePrivacyData.a.selectedPrivacyOption == null || selectablePrivacyData.d == null) {
                list3 = RegularImmutableList.a;
            } else {
                if (platformComposerPrivacyFragment.f4364a.c(selectablePrivacyData.d)) {
                    list3 = selectablePrivacyData.d.g();
                } else {
                    graphQLPrivacyOption2 = selectablePrivacyData.a.selectedPrivacyOption;
                    list3 = platformComposerPrivacyFragment.f4364a.c(graphQLPrivacyOption2) ? graphQLPrivacyOption2.g() : RegularImmutableList.a;
                }
            }
            list2 = list3;
            if (!CollectionUtil.a(platformComposerPrivacyFragment.aA)) {
                list3 = platformComposerPrivacyFragment.aA;
            } else if (selectablePrivacyData == null || selectablePrivacyData.a == null || selectablePrivacyData.a.selectedPrivacyOption == null || selectablePrivacyData.d == null) {
                list3 = RegularImmutableList.a;
            } else {
                if (platformComposerPrivacyFragment.f4364a.d(selectablePrivacyData.d)) {
                    list3 = selectablePrivacyData.d.F_();
                } else {
                    graphQLPrivacyOption2 = selectablePrivacyData.a.selectedPrivacyOption;
                    list3 = platformComposerPrivacyFragment.f4364a.d(graphQLPrivacyOption2) ? graphQLPrivacyOption2.F_() : RegularImmutableList.a;
                }
            }
            list = list3;
        }
        platformComposerPrivacyFragment.f4372i.a(AudienceSectionIndices.f4362a, platformComposerPrivacyFragment.f4364a.a(privacyOptionsResult, graphQLPrivacyOption, c05678, platformComposerPrivacyFragment.jW_(), list2, list));
    }

    public static List<BaseToken> m4258b(TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView) {
        BaseTokenSpan[] baseTokenSpanArr = (BaseTokenSpan[]) tokenizedAutoCompleteTextView.getPickedTokenSpans();
        List<BaseToken> arrayList = new ArrayList();
        for (TokenSpan tokenSpan : baseTokenSpanArr) {
            arrayList.add(tokenSpan.f);
        }
        return arrayList;
    }

    private void as() {
        SelectablePrivacyData selectablePrivacyData;
        com.facebook.platform.composer.composer.PlatformComposerFragment.AnonymousClass10 aL = aL();
        if (aL.f4063a.aO.f4189d.b == null || aL.f4063a.aO.f4189d.b.a == null) {
            selectablePrivacyData = aL.f4063a.bo;
        } else {
            selectablePrivacyData = aL.f4063a.aO.f4189d.b;
        }
        SelectablePrivacyData selectablePrivacyData2 = selectablePrivacyData;
        m4252a(this, selectablePrivacyData2);
        if (this.ao == null || this.ao.a == null || selectablePrivacyData2 == null || selectablePrivacyData2.a == null || this.ao.b != selectablePrivacyData2.b || !Objects.equal(this.ao.d, selectablePrivacyData2.d) || !Objects.equal(this.ao.a.selectedPrivacyOption, selectablePrivacyData2.a.selectedPrivacyOption)) {
            this.ao = selectablePrivacyData2;
            if (this.f4364a.c(this.ao.d)) {
                m4263e(this, this.ao.d.g());
            }
            if (this.f4364a.d(this.ao.d)) {
                m4264f(this, this.ao.d.F_());
            }
            if (this.f4364a.b(this.ao.d)) {
                m4253a(this, this.ao.d.F_(), this.ao.d.g());
            }
            at();
        }
    }

    private void at() {
        if (this.ao != null) {
            PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer = this.ao.d;
            int c = this.ao.c();
            if (privacyOptionFieldsForComposer != null) {
                this.ar.b();
                if (this.f4364a.b(privacyOptionFieldsForComposer)) {
                    this.ar.a(aH(this));
                } else if (this.f4364a.c(privacyOptionFieldsForComposer)) {
                    this.ar.a(aI(this));
                } else if (this.f4364a.d(privacyOptionFieldsForComposer)) {
                    this.ar.a(aJ(this));
                } else {
                    Token a = ((PrivacyOptionsSection) this.f4372i.g(AudienceSectionIndices.f4362a)).a(c);
                    if (a == null) {
                        a = this.f4364a.a(privacyOptionFieldsForComposer, c);
                    }
                    this.ar.a(a);
                }
                this.aB = m4258b(this.ar);
                if (!this.aB.isEmpty() && m4262c((BaseToken) this.aB.get(0))) {
                    av();
                }
                aA(this);
            }
        }
    }

    public static void au(PlatformComposerPrivacyFragment platformComposerPrivacyFragment) {
        TagExpansionToken aw = aw(platformComposerPrivacyFragment);
        if (aw != null) {
            platformComposerPrivacyFragment.aB.remove(aw);
            platformComposerPrivacyFragment.ar.a(aw, true);
        }
    }

    private void m4259b(BaseToken baseToken) {
        Preconditions.checkArgument(baseToken.a == Type.TAG_EXPANSION, "Treating non tag expansion token as a tag expansion token");
        this.ar.setSelection(this.ar.getText().length());
        this.aB.add(baseToken);
        this.ar.a(baseToken);
        this.ar.c();
    }

    private void av() {
        boolean z = true;
        if (this.ao != null) {
            if (this.av.getVisibility() == 0) {
                this.aB = m4258b(this.ar);
            }
            au(this);
            if (!this.aB.isEmpty()) {
                BaseToken baseToken = (BaseToken) this.aB.get(0);
                if (m4262c(baseToken)) {
                    Object aH;
                    PrivacyOptionsSection privacyOptionsSection = (PrivacyOptionsSection) this.f4372i.g(AudienceSectionIndices.f4362a);
                    privacyOptionsSection.j();
                    if (baseToken.a == Type.FULL_CUSTOM) {
                        aH = aH(this);
                    } else if (baseToken.a == Type.FRIENDS_EXCEPT) {
                        aH = aI(this);
                    } else if (baseToken.a == Type.SPECIFIC_FRIENDS) {
                        aH = aJ(this);
                    } else {
                        aH = privacyOptionsSection.a(this.ao.c());
                    }
                    if (this.aw && aH != null && this.ao != null && this.ao.f()) {
                        if (this.ao.d.G_().size() <= 1) {
                            z = false;
                        }
                        BaseToken a = this.f4364a.a(this.ao.g(), jW_(), false, z);
                        if (this.av.getVisibility() == 0) {
                            privacyOptionsSection.a(a, privacyOptionsSection.e().indexOf(aH) + 1);
                        }
                        AdapterDetour.a(this.f4372i, 747052458);
                        if (!this.ao.b || !z) {
                            m4259b(a);
                        }
                    }
                }
            }
        }
    }

    private void az() {
        if (this.y && this.aq.getVisibility() != 0) {
            this.aq.setVisibility(0);
            this.av.getViewTreeObserver().addOnPreDrawListener(new C05689(this));
            as();
            if (!this.aB.isEmpty()) {
                av();
            }
            at();
            this.ar.setSelection(this.ar.getText().length());
            aK(this);
        }
    }

    public static TagExpansionToken aw(PlatformComposerPrivacyFragment platformComposerPrivacyFragment) {
        for (BaseToken baseToken : platformComposerPrivacyFragment.aB) {
            if (baseToken.a == Type.TAG_EXPANSION) {
                return (TagExpansionToken) baseToken;
            }
        }
        return null;
    }

    public final void m4268a(com.facebook.platform.composer.composer.PlatformComposerFragment.AnonymousClass10 anonymousClass10) {
        this.an = new WeakReference(Preconditions.checkNotNull(anonymousClass10));
    }

    public final boolean m4270b() {
        if (this.as == null || this.as.getVisibility() != 0) {
            if (this.at != null && this.at.getVisibility() == 0) {
                this.at.setVisibility(8);
                aK(this);
                return false;
            } else if (this.au == null || this.au.getVisibility() != 0) {
                return true;
            } else {
                ay();
                this.au.setVisibility(8);
                aK(this);
                this.f4371h.b(this.aA.size());
                return false;
            }
        } else if (!this.ay.e()) {
            return false;
        } else {
            ay();
            this.as.setVisibility(8);
            aK(this);
            return false;
        }
    }

    private void ay() {
        int i = 0;
        if (this.aA != null && this.aA.size() == 1) {
            if (!((TriState) this.f4366c.get()).asBoolean(false) || !CollectionUtil.b(this.az)) {
                GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember = (GraphQLPrivacyAudienceMember) this.aA.get(0);
                if (graphQLPrivacyAudienceMember.b() != null && graphQLPrivacyAudienceMember.b().g() == 236555388) {
                    String str = Allow.SOME_FRIENDS.name() + "," + graphQLPrivacyAudienceMember.c();
                    PrivacyOptionsResult privacyOptionsResult = this.ao.a;
                    ImmutableList immutableList = privacyOptionsResult.friendListPrivacyOptions;
                    int size = immutableList.size();
                    while (i < size) {
                        GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) immutableList.get(i);
                        PrivacyParameter a = PrivacyOptionHelper.a(graphQLPrivacyOption);
                        if (a == null || !str.equals(a.allow)) {
                            i++;
                        } else {
                            PrivacyToken a2 = this.f4364a.a(graphQLPrivacyOption, privacyOptionsResult.b(graphQLPrivacyOption));
                            this.ar.b();
                            this.ar.a(a2);
                            List arrayList = new ArrayList();
                            arrayList.add(a2);
                            m4261c(this, arrayList);
                            av();
                            this.ar.e();
                            m4252a(this, this.ao);
                            return;
                        }
                    }
                }
            }
        }
    }

    public final SelectablePrivacyData m4272e() {
        Object obj;
        if (this.ao == null || this.ao.d == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            as();
        }
        for (int i = 0; i < this.f4372i.c(); i++) {
            ((SectionedListSection) this.f4372i.b(i)).a(false);
        }
        AdapterDetour.a(this.f4372i, 157562513);
        this.ar.a();
        this.ar.clearComposingText();
        this.ar.e();
        this.aB = m4258b(this.ar);
        return this.ao;
    }

    public static void aA(PlatformComposerPrivacyFragment platformComposerPrivacyFragment) {
        if (platformComposerPrivacyFragment.ar != null) {
            platformComposerPrivacyFragment.aB = m4258b(platformComposerPrivacyFragment.ar);
        }
        if (platformComposerPrivacyFragment.f4372i != null && !platformComposerPrivacyFragment.aB.isEmpty()) {
            boolean z;
            if (platformComposerPrivacyFragment.aL().f4063a.aO.f4188c.m4168t().isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            boolean z2 = z;
            if (z2 != platformComposerPrivacyFragment.aw) {
                platformComposerPrivacyFragment.aw = z2;
                platformComposerPrivacyFragment.av();
                if (!platformComposerPrivacyFragment.aw && platformComposerPrivacyFragment.ao != null) {
                    SelectablePrivacyData.Builder builder = new SelectablePrivacyData.Builder(platformComposerPrivacyFragment.ao);
                    builder.c = true;
                    platformComposerPrivacyFragment.ao = builder.b();
                }
            }
        }
    }

    private GraphQLPrivacyOption m4249a(PrivacyToken privacyToken) {
        GraphQLPrivacyOption a = this.ao.a.a(privacyToken.c().intValue());
        Builder a2 = Builder.a(PrivacyOptionHelper.e(a));
        a2.g = aB();
        return GraphQLPrivacyOptionBuilder.a(a).a(a2.a()).b();
    }

    private GraphQLPrivacyOption m4248a(GraphQLPrivacyBaseState graphQLPrivacyBaseState, List<GraphQLPrivacyAudienceMember> list, List<GraphQLPrivacyAudienceMember> list2) {
        GraphQLPrivacyOptionBuilder graphQLPrivacyOptionBuilder = new GraphQLPrivacyOptionBuilder();
        if (graphQLPrivacyBaseState == GraphQLPrivacyBaseState.SELF) {
            graphQLPrivacyOptionBuilder.c("{\"value\":\"SELF\"}");
        } else {
            graphQLPrivacyOptionBuilder.c("{\"value\":\"ALL_FRIENDS\"}");
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        if (list != null) {
            for (GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember : list) {
                builder.c(graphQLPrivacyAudienceMember);
                builder2.c(graphQLPrivacyAudienceMember.c());
                graphQLPrivacyOptionBuilder.a(graphQLPrivacyAudienceMember.c());
            }
        }
        ImmutableList.Builder builder3 = ImmutableList.builder();
        ImmutableList.Builder builder4 = ImmutableList.builder();
        if (list2 != null) {
            for (GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember2 : list2) {
                builder3.c(graphQLPrivacyAudienceMember2);
                builder4.c(graphQLPrivacyAudienceMember2.c());
                graphQLPrivacyOptionBuilder.b(graphQLPrivacyAudienceMember2.c());
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
        graphQLPrivacyOptionBuilder.d(AudienceTypeaheadUtil.a(jW_())).a(a).a(builder.b()).b(builder3.b()).a(builder7.a());
        if (graphQLPrivacyBaseState == GraphQLPrivacyBaseState.SELF) {
            graphQLPrivacyOptionBuilder.c(ImmutableList.of(GraphQLPrivacyOptionTagExpansionType.TAGGEES));
        } else {
            graphQLPrivacyOptionBuilder.c(ImmutableList.of(GraphQLPrivacyOptionTagExpansionType.FRIENDS_OF_TAGGEES, GraphQLPrivacyOptionTagExpansionType.TAGGEES));
        }
        return graphQLPrivacyOptionBuilder.b();
    }

    private GraphQLPrivacyOption m4250a(List<GraphQLPrivacyAudienceMember> list) {
        GraphQLPrivacyOptionBuilder c = new GraphQLPrivacyOptionBuilder().c("{\"value\":\"ALL_FRIENDS\"}");
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        for (GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember : list) {
            builder.c(graphQLPrivacyAudienceMember);
            builder2.c(graphQLPrivacyAudienceMember.c());
            c.b(graphQLPrivacyAudienceMember.c());
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
        return c.d(AudienceTypeaheadUtil.a(jW_(), list)).a(a).a(RegularImmutableList.a).b(builder.b()).a(builder5.a()).c(ImmutableList.of(GraphQLPrivacyOptionTagExpansionType.FRIENDS_OF_TAGGEES, GraphQLPrivacyOptionTagExpansionType.TAGGEES)).b();
    }

    private GraphQLPrivacyOption m4257b(List<GraphQLPrivacyAudienceMember> list) {
        GraphQLPrivacyOptionBuilder c = new GraphQLPrivacyOptionBuilder().c("{\"value\":\"SELF\"}");
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList.Builder builder2 = ImmutableList.builder();
        for (GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember : list) {
            builder.c(graphQLPrivacyAudienceMember);
            builder2.c(graphQLPrivacyAudienceMember.c());
            c.a(graphQLPrivacyAudienceMember.c());
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
        return c.d(AudienceTypeaheadUtil.b(jW_(), list)).a(a).a(builder.b()).b(RegularImmutableList.a).a(builder5.a()).c(ImmutableList.of(GraphQLPrivacyOptionTagExpansionType.TAGGEES)).b();
    }

    private GraphQLPrivacyTagExpansionState aB() {
        if (this.ao.b) {
            return GraphQLPrivacyTagExpansionState.TAGGEES;
        }
        return GraphQLPrivacyTagExpansionState.UNSPECIFIED;
    }

    @VisibleForTesting
    public final void m4269a(BaseToken baseToken, TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView) {
        List b = m4258b(tokenizedAutoCompleteTextView);
        if (baseToken.a == Type.FULL_CUSTOM) {
            if (CollectionUtil.a(this.aA) && aF() != null) {
                baseToken = aF();
            }
            if (this.as == null || this.as.getVisibility() == 8) {
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
                this.ay.au = new SelectedMembersUpdater(this) {
                    final /* synthetic */ PlatformComposerPrivacyFragment f4336a;

                    {
                        this.f4336a = r1;
                    }

                    public final void m4240a(List<GraphQLPrivacyAudienceMember> list) {
                        if (list != null) {
                            PlatformComposerPrivacyFragment.m4253a(this.f4336a, (List) list, this.f4336a.az);
                            this.f4336a.m4269a(PlatformComposerPrivacyFragment.aH(this.f4336a), this.f4336a.ar);
                            PlatformComposerPrivacyFragment.m4252a(this.f4336a, this.f4336a.ao);
                        }
                    }
                };
                this.ay.av = new AbstractProvider<ImmutableList<GraphQLPrivacyAudienceMember>>(this) {
                    final /* synthetic */ PlatformComposerPrivacyFragment f4337a;

                    {
                        this.f4337a = r1;
                    }

                    public Object get() {
                        if (CollectionUtil.a(this.f4337a.aA)) {
                            return RegularImmutableList.a;
                        }
                        return ImmutableList.copyOf(this.f4337a.aA);
                    }
                };
                this.ay.ax = new SelectedMembersUpdater(this) {
                    final /* synthetic */ PlatformComposerPrivacyFragment f4338a;

                    {
                        this.f4338a = r1;
                    }

                    public final void m4241a(List<GraphQLPrivacyAudienceMember> list) {
                        if (list != null) {
                            PlatformComposerPrivacyFragment.m4253a(this.f4338a, this.f4338a.aA, (List) list);
                            this.f4338a.m4269a(PlatformComposerPrivacyFragment.aH(this.f4338a), this.f4338a.ar);
                            PlatformComposerPrivacyFragment.m4252a(this.f4338a, this.f4338a.ao);
                        }
                    }
                };
                this.ay.ay = new AbstractProvider<ImmutableList<GraphQLPrivacyAudienceMember>>(this) {
                    final /* synthetic */ PlatformComposerPrivacyFragment f4339a;

                    {
                        this.f4339a = r1;
                    }

                    public Object get() {
                        if (CollectionUtil.a(this.f4339a.az)) {
                            return RegularImmutableList.a;
                        }
                        return ImmutableList.copyOf(this.f4339a.az);
                    }
                };
                this.ay.az = new AbstractProvider<ImmutableList<GraphQLPrivacyOption>>(this) {
                    final /* synthetic */ PlatformComposerPrivacyFragment f4340a;

                    {
                        this.f4340a = r1;
                    }

                    public Object get() {
                        return this.f4340a.ao.a.friendListPrivacyOptions;
                    }
                };
                this.ay.b();
                this.as = this.aq.findViewById(2131566110);
                this.as.setVisibility(0);
            }
        } else if (baseToken.a == Type.FRIENDS_EXCEPT) {
            if (CollectionUtil.a(this.az) && aF() != null) {
                baseToken = aF();
            }
            if (this.at == null || this.at.getVisibility() == 8) {
                aD();
            }
        } else if (baseToken.a == Type.SPECIFIC_FRIENDS) {
            if (CollectionUtil.a(this.aA) && aG() != null) {
                baseToken = aG();
            }
            if (this.au == null || this.au.getVisibility() == 8) {
                AbstractCustomPrivacyTypeaheadFragment specificFriendsTypeaheadFragment;
                FragmentManager s2 = s();
                if (s2.a(2131566112) == null) {
                    specificFriendsTypeaheadFragment = new SpecificFriendsTypeaheadFragment();
                    FragmentTransaction a2 = s().a();
                    a2.a(2131566112, specificFriendsTypeaheadFragment);
                    a2.b();
                    s2.b();
                } else {
                    SpecificFriendsTypeaheadFragment specificFriendsTypeaheadFragment2 = (SpecificFriendsTypeaheadFragment) s2.a(2131566112);
                }
                specificFriendsTypeaheadFragment.a(new SelectedMembersUpdater(this) {
                    final /* synthetic */ PlatformComposerPrivacyFragment f4344a;

                    {
                        this.f4344a = r1;
                    }

                    public final void m4243a(List<GraphQLPrivacyAudienceMember> list) {
                        if (list != null) {
                            PlatformComposerPrivacyFragment.m4264f(this.f4344a, list);
                            this.f4344a.m4269a(PlatformComposerPrivacyFragment.aJ(this.f4344a), this.f4344a.ar);
                            PlatformComposerPrivacyFragment.m4252a(this.f4344a, this.f4344a.ao);
                        }
                    }
                });
                specificFriendsTypeaheadFragment.ax = new AbstractProvider<ImmutableList<GraphQLPrivacyAudienceMember>>(this) {
                    final /* synthetic */ PlatformComposerPrivacyFragment f4345a;

                    {
                        this.f4345a = r1;
                    }

                    public Object get() {
                        if (CollectionUtil.a(this.f4345a.aA)) {
                            return RegularImmutableList.a;
                        }
                        return ImmutableList.copyOf(this.f4345a.aA);
                    }
                };
                specificFriendsTypeaheadFragment.ay = new AbstractProvider<ImmutableList<GraphQLPrivacyOption>>(this) {
                    final /* synthetic */ PlatformComposerPrivacyFragment f4347a;

                    {
                        this.f4347a = r1;
                    }

                    public Object get() {
                        return this.f4347a.ao.a.friendListPrivacyOptions;
                    }
                };
                specificFriendsTypeaheadFragment.e();
                this.au = this.aq.findViewById(2131566112);
                this.au.setVisibility(0);
                this.f4371h.a(this.aA != null ? this.aA.size() : -1);
            }
        }
        if ((baseToken.a != Type.TAG_EXPANSION && baseToken.a == Type.PRIVACY) || baseToken.a == Type.FULL_CUSTOM || baseToken.a == Type.FRIENDS_EXCEPT || baseToken.a == Type.SPECIFIC_FRIENDS) {
            tokenizedAutoCompleteTextView.b();
            b.clear();
        }
        boolean z = false;
        if (b.contains(baseToken)) {
            tokenizedAutoCompleteTextView.a(baseToken, true);
            b.remove(baseToken);
            z = true;
        } else {
            tokenizedAutoCompleteTextView.a(baseToken);
            b.add(baseToken);
        }
        m4261c(this, b);
        if (baseToken.a != Type.TAG_EXPANSION) {
            av();
        } else if (z) {
            ar(this);
        } else {
            m4255a(baseToken);
        }
        tokenizedAutoCompleteTextView.e();
    }

    public static void m4261c(PlatformComposerPrivacyFragment platformComposerPrivacyFragment, List list) {
        if (platformComposerPrivacyFragment.ao != null) {
            if (list.isEmpty()) {
                platformComposerPrivacyFragment.ao = new SelectablePrivacyData.Builder(platformComposerPrivacyFragment.ao).a(null).b();
                return;
            }
            BaseToken baseToken = (BaseToken) list.get(0);
            if (baseToken.a == Type.TAG_EXPANSION && list.size() == 2) {
                baseToken = (BaseToken) list.get(1);
            }
            BaseToken baseToken2 = baseToken;
            switch (AnonymousClass22.f4351a[baseToken2.a.ordinal()]) {
                case 1:
                    platformComposerPrivacyFragment.ao = new SelectablePrivacyData.Builder(platformComposerPrivacyFragment.ao).a(platformComposerPrivacyFragment.m4249a((PrivacyToken) baseToken2)).b();
                    return;
                case 2:
                    if (platformComposerPrivacyFragment.aA != null) {
                        platformComposerPrivacyFragment.ao = new SelectablePrivacyData.Builder(platformComposerPrivacyFragment.ao).a(platformComposerPrivacyFragment.m4248a(GraphQLPrivacyBaseState.SELF, platformComposerPrivacyFragment.aA, platformComposerPrivacyFragment.az)).b();
                        return;
                    }
                    return;
                case 3:
                    if (platformComposerPrivacyFragment.az != null) {
                        platformComposerPrivacyFragment.ao = new SelectablePrivacyData.Builder(platformComposerPrivacyFragment.ao).a(platformComposerPrivacyFragment.m4250a(platformComposerPrivacyFragment.az)).b();
                        return;
                    }
                    return;
                case 4:
                    if (platformComposerPrivacyFragment.aA != null) {
                        platformComposerPrivacyFragment.ao = new SelectablePrivacyData.Builder(platformComposerPrivacyFragment.ao).a(platformComposerPrivacyFragment.m4257b(platformComposerPrivacyFragment.aA)).b();
                        return;
                    }
                    return;
                default:
                    platformComposerPrivacyFragment.f4370g.a(SoftError.a(am.getSimpleName(), StringFormatUtil.formatStrLocaleSafe("Unexpected selected option token of type %s", baseToken2.a.name())).g());
                    return;
            }
        }
    }

    private static boolean m4262c(BaseToken baseToken) {
        return baseToken.a == Type.PRIVACY || baseToken.a == Type.FULL_CUSTOM || baseToken.a == Type.FRIENDS_EXCEPT || baseToken.a == Type.SPECIFIC_FRIENDS;
    }

    private void aD() {
        AbstractCustomPrivacyTypeaheadFragment a;
        FragmentManager s = s();
        if (s.a(2131566111) == null) {
            a = FriendsExceptTypeaheadFragment.a(false);
            FragmentTransaction a2 = s().a();
            a2.a(2131566111, a);
            a2.b();
            s.b();
        } else {
            FriendsExceptTypeaheadFragment friendsExceptTypeaheadFragment = (FriendsExceptTypeaheadFragment) s.a(2131566111);
        }
        a.a(new SelectedMembersUpdater(this) {
            final /* synthetic */ PlatformComposerPrivacyFragment f4341a;

            {
                this.f4341a = r1;
            }

            public final void m4242a(List<GraphQLPrivacyAudienceMember> list) {
                if (list != null) {
                    PlatformComposerPrivacyFragment.m4263e(this.f4341a, list);
                    PlatformComposerPrivacyFragment.m4252a(this.f4341a, this.f4341a.ao);
                    this.f4341a.m4269a(PlatformComposerPrivacyFragment.aI(this.f4341a), this.f4341a.ar);
                }
            }
        });
        a.ax = new AbstractProvider<ImmutableList<GraphQLPrivacyAudienceMember>>(this) {
            final /* synthetic */ PlatformComposerPrivacyFragment f4342a;

            {
                this.f4342a = r1;
            }

            public Object get() {
                return CollectionUtil.a(this.f4342a.az) ? RegularImmutableList.a : ImmutableList.copyOf(this.f4342a.az);
            }
        };
        a.ay = new AbstractProvider<ImmutableList<GraphQLPrivacyOption>>(this) {
            final /* synthetic */ PlatformComposerPrivacyFragment f4343a;

            {
                this.f4343a = r1;
            }

            public Object get() {
                return this.f4343a.ao.a.friendListPrivacyOptions;
            }
        };
        a.e();
        this.at = this.aq.findViewById(2131566111);
        this.at.setVisibility(0);
    }

    public static void m4253a(PlatformComposerPrivacyFragment platformComposerPrivacyFragment, List list, List list2) {
        platformComposerPrivacyFragment.aA = list;
        platformComposerPrivacyFragment.az = list2;
        platformComposerPrivacyFragment.ao = new SelectablePrivacyData.Builder(platformComposerPrivacyFragment.ao).a(platformComposerPrivacyFragment.m4248a(GraphQLPrivacyBaseState.SELF, platformComposerPrivacyFragment.aA, platformComposerPrivacyFragment.az)).b();
    }

    public static void m4263e(PlatformComposerPrivacyFragment platformComposerPrivacyFragment, List list) {
        platformComposerPrivacyFragment.az = list;
        platformComposerPrivacyFragment.ao = new SelectablePrivacyData.Builder(platformComposerPrivacyFragment.ao).a(platformComposerPrivacyFragment.m4250a(platformComposerPrivacyFragment.az)).b();
    }

    public static void m4264f(PlatformComposerPrivacyFragment platformComposerPrivacyFragment, List list) {
        platformComposerPrivacyFragment.aA = list;
        platformComposerPrivacyFragment.ao = new SelectablePrivacyData.Builder(platformComposerPrivacyFragment.ao).a(platformComposerPrivacyFragment.m4257b(platformComposerPrivacyFragment.aA)).b();
    }

    private PrivacyToken aF() {
        if (this.ao == null || this.ao.a == null) {
            return null;
        }
        PrivacyOptionsResult privacyOptionsResult = this.ao.a;
        ImmutableList immutableList = privacyOptionsResult.basicPrivacyOptions;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) immutableList.get(i);
            if (PrivacyOptionHelper.a(graphQLPrivacyOption) == GraphQLPrivacyOptionType.FRIENDS) {
                return this.f4364a.a(graphQLPrivacyOption, privacyOptionsResult.b(graphQLPrivacyOption));
            }
        }
        return null;
    }

    private PrivacyToken aG() {
        if (this.ao == null || this.ao.a == null) {
            return null;
        }
        PrivacyOptionsResult privacyOptionsResult = this.ao.a;
        ImmutableList immutableList = privacyOptionsResult.basicPrivacyOptions;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) immutableList.get(i);
            if (PrivacyOptionHelper.a(graphQLPrivacyOption) == GraphQLPrivacyOptionType.ONLY_ME) {
                return this.f4364a.a(graphQLPrivacyOption, privacyOptionsResult.b(graphQLPrivacyOption));
            }
        }
        return null;
    }

    public static CustomPrivacyToken aH(PlatformComposerPrivacyFragment platformComposerPrivacyFragment) {
        return ((PrivacyOptionsSection) platformComposerPrivacyFragment.f4372i.g(AudienceSectionIndices.f4362a)).g();
    }

    public static FriendsExceptToken aI(PlatformComposerPrivacyFragment platformComposerPrivacyFragment) {
        return ((PrivacyOptionsSection) platformComposerPrivacyFragment.f4372i.g(AudienceSectionIndices.f4362a)).h();
    }

    public static SpecificFriendsToken aJ(PlatformComposerPrivacyFragment platformComposerPrivacyFragment) {
        return ((PrivacyOptionsSection) platformComposerPrivacyFragment.f4372i.g(AudienceSectionIndices.f4362a)).i();
    }

    public static void m4251a(PlatformComposerPrivacyFragment platformComposerPrivacyFragment, Layout layout, CharSequence charSequence) {
        if (layout != null) {
            int lineCount = layout.getLineCount() - 1;
            if (lineCount >= 0 && layout.getEllipsisCount(lineCount) > 0) {
                Toast makeText = Toast.makeText(platformComposerPrivacyFragment.getContext(), charSequence, 1);
                makeText.setGravity(48, 0, 0);
                makeText.show();
            }
        }
    }

    public static void aK(PlatformComposerPrivacyFragment platformComposerPrivacyFragment) {
        platformComposerPrivacyFragment.f4369f.hideSoftInputFromWindow(platformComposerPrivacyFragment.ar.getWindowToken(), 0);
    }

    private com.facebook.platform.composer.composer.PlatformComposerFragment.AnonymousClass10 aL() {
        Preconditions.checkNotNull(this.an);
        return (com.facebook.platform.composer.composer.PlatformComposerFragment.AnonymousClass10) Preconditions.checkNotNull(this.an.get());
    }
}
