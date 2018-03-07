package com.facebook.photos.albumcreator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.composer.privacy.common.ComposerAudienceFragment;
import com.facebook.composer.privacy.common.ComposerAudienceFragment.AudienceDialogData;
import com.facebook.composer.privacy.common.ComposerAudienceFragment.OnAudienceSelectedListener;
import com.facebook.composer.privacy.common.ComposerGroupPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerPagePrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.composer.privacy.common.ComposerPrivacyData.Builder;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegateBase;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegateBase.AnalyticsCallback;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegateProvider;
import com.facebook.composer.privacy.common.FixedPrivacyView;
import com.facebook.composer.privacy.common.SelectablePrivacyView;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albumcreator.AlbumCreatorController.PagesData;
import com.facebook.places.checkin.ipc.CheckinIntentCreator;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.selector.AudienceSelectorPerformanceLogger;
import com.facebook.privacy.selector.AudienceSelectorPerformanceLogger.Caller;
import com.facebook.privacy.selector.AudienceTypeaheadFragment.DataProvider;
import com.facebook.resources.ui.FbEditText;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: marketplace_cross_post_setting */
public class AlbumCreatorFragment extends FbFragment {
    @Inject
    ComposerSelectablePrivacyDelegateProvider f9295a;
    public FixedPrivacyView aA;
    public FbEditText aB;
    public FbEditText aC;
    public final PrivacyUpdatedHandler al = new C07453(this);
    private final PrivacyUpdatedHandler am = new C07464(this);
    private final PrivacyUpdatedHandler an = new C07475(this);
    public final DataProvider ao = new C07486(this);
    public final OnAudienceSelectedListener ap = new C07497(this);
    public CheckinPlaceModel aq;
    private ComposerPrivacyDelegate ar;
    public ComposerPrivacyData as;
    public SelectablePrivacyData at;
    private ViewerContext au;
    @Nullable
    public ComposerTargetData av;
    public boolean aw = false;
    public boolean ax = false;
    public GlyphView ay;
    public SelectablePrivacyView az;
    @Inject
    ComposerPagePrivacyDelegateProvider f9296b;
    @Inject
    ComposerGroupPrivacyDelegateProvider f9297c;
    @Inject
    SecureContextHelper f9298d;
    @Inject
    public Lazy<AudienceSelectorPerformanceLogger> f9299e;
    @Inject
    public Lazy<AlbumCreatorController> f9300f;
    @Inject
    public AlbumCreatorFlowLogger f9301g;
    private final ComposerSelectablePrivacyDelegateBase.DataProvider f9302h = new C07431(this);
    private final AnalyticsCallback f9303i = new C07442(this);

    /* compiled from: marketplace_cross_post_setting */
    class C07431 implements ComposerSelectablePrivacyDelegateBase.DataProvider {
        final /* synthetic */ AlbumCreatorFragment f9286a;

        C07431(AlbumCreatorFragment albumCreatorFragment) {
            this.f9286a = albumCreatorFragment;
        }

        public final boolean mo483a() {
            return this.f9286a.ax;
        }

        public final boolean mo484b() {
            return true;
        }

        public final boolean mo485c() {
            return this.f9286a.as == null || this.f9286a.as.f2003d;
        }
    }

    /* compiled from: marketplace_cross_post_setting */
    class C07442 implements AnalyticsCallback {
        final /* synthetic */ AlbumCreatorFragment f9287a;

        C07442(AlbumCreatorFragment albumCreatorFragment) {
            this.f9287a = albumCreatorFragment;
        }

        public final void mo486a() {
        }
    }

    /* compiled from: marketplace_cross_post_setting */
    class C07453 implements PrivacyUpdatedHandler {
        final /* synthetic */ AlbumCreatorFragment f9288a;

        C07453(AlbumCreatorFragment albumCreatorFragment) {
            this.f9288a = albumCreatorFragment;
        }

        public final void mo487a(ComposerPrivacyData composerPrivacyData, boolean z) {
            if (z || composerPrivacyData.f2003d || this.f9288a.at == null) {
                this.f9288a.az.m1990a(false, composerPrivacyData);
                this.f9288a.as = composerPrivacyData;
                if (z) {
                    this.f9288a.at = composerPrivacyData.f2001b;
                    return;
                }
                return;
            }
            this.f9288a.as = new Builder(composerPrivacyData).m1944a(this.f9288a.at).m1945a();
            this.f9288a.az.m1990a(false, this.f9288a.as);
        }
    }

    /* compiled from: marketplace_cross_post_setting */
    class C07464 implements PrivacyUpdatedHandler {
        final /* synthetic */ AlbumCreatorFragment f9289a;

        C07464(AlbumCreatorFragment albumCreatorFragment) {
            this.f9289a = albumCreatorFragment;
        }

        public final void mo487a(ComposerPrivacyData composerPrivacyData, boolean z) {
            this.f9289a.aA.m1983a(composerPrivacyData.f2000a, null);
            this.f9289a.as = composerPrivacyData;
        }
    }

    /* compiled from: marketplace_cross_post_setting */
    class C07475 implements PrivacyUpdatedHandler {
        final /* synthetic */ AlbumCreatorFragment f9290a;

        C07475(AlbumCreatorFragment albumCreatorFragment) {
            this.f9290a = albumCreatorFragment;
        }

        public final void mo487a(ComposerPrivacyData composerPrivacyData, boolean z) {
            this.f9290a.aA.m1983a(composerPrivacyData.f2000a, null);
            this.f9290a.as = composerPrivacyData;
        }
    }

    /* compiled from: marketplace_cross_post_setting */
    class C07486 implements DataProvider {
        final /* synthetic */ AlbumCreatorFragment f9291a;

        C07486(AlbumCreatorFragment albumCreatorFragment) {
            this.f9291a = albumCreatorFragment;
        }

        public final SelectablePrivacyData m11313a() {
            return this.f9291a.as.f2001b;
        }

        public final boolean m11314b() {
            return false;
        }
    }

    /* compiled from: marketplace_cross_post_setting */
    class C07497 implements OnAudienceSelectedListener {
        final /* synthetic */ AlbumCreatorFragment f9292a;

        C07497(AlbumCreatorFragment albumCreatorFragment) {
            this.f9292a = albumCreatorFragment;
        }

        public final void mo488a(SelectablePrivacyData selectablePrivacyData) {
            this.f9292a.aw = true;
            this.f9292a.al.mo487a(new Builder(this.f9292a.as).m1944a(selectablePrivacyData).m1945a(), true);
        }
    }

    /* compiled from: marketplace_cross_post_setting */
    class C07508 extends BaseTextWatcher {
        final /* synthetic */ AlbumCreatorFragment f9293a;

        C07508(AlbumCreatorFragment albumCreatorFragment) {
            this.f9293a = albumCreatorFragment;
        }

        public void afterTextChanged(Editable editable) {
            this.f9293a.f9301g.m11299b();
        }
    }

    /* compiled from: marketplace_cross_post_setting */
    class C07519 extends BaseTextWatcher {
        final /* synthetic */ AlbumCreatorFragment f9294a;

        C07519(AlbumCreatorFragment albumCreatorFragment) {
            this.f9294a = albumCreatorFragment;
        }

        public void afterTextChanged(Editable editable) {
            this.f9294a.f9301g.m11301c();
        }
    }

    public static void m11317a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AlbumCreatorFragment) obj).m11316a((ComposerSelectablePrivacyDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerSelectablePrivacyDelegateProvider.class), (ComposerPagePrivacyDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerPagePrivacyDelegateProvider.class), (ComposerGroupPrivacyDelegateProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ComposerGroupPrivacyDelegateProvider.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9716), IdBasedLazy.a(injectorLike, 9241), AlbumCreatorFlowLogger.m11295b(injectorLike));
    }

    private void m11316a(ComposerSelectablePrivacyDelegateProvider composerSelectablePrivacyDelegateProvider, ComposerPagePrivacyDelegateProvider composerPagePrivacyDelegateProvider, ComposerGroupPrivacyDelegateProvider composerGroupPrivacyDelegateProvider, SecureContextHelper secureContextHelper, Lazy<AudienceSelectorPerformanceLogger> lazy, Lazy<AlbumCreatorController> lazy2, AlbumCreatorFlowLogger albumCreatorFlowLogger) {
        this.f9295a = composerSelectablePrivacyDelegateProvider;
        this.f9296b = composerPagePrivacyDelegateProvider;
        this.f9297c = composerGroupPrivacyDelegateProvider;
        this.f9298d = secureContextHelper;
        this.f9299e = lazy;
        this.f9300f = lazy2;
        this.f9301g = albumCreatorFlowLogger;
    }

    public final void m11321c(Bundle bundle) {
        super.c(bundle);
        Class cls = AlbumCreatorFragment.class;
        m11317a(this, getContext());
    }

    public final View m11319a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2029558059);
        View inflate = layoutInflater.inflate(2130903229, viewGroup, false);
        this.au = (ViewerContext) o().getIntent().getParcelableExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT");
        this.av = (ComposerTargetData) o().getIntent().getParcelableExtra("extra_composer_target_data");
        if (az() || aA()) {
            this.aA = (FixedPrivacyView) ((ViewStub) inflate.findViewById(2131559539)).inflate();
            this.aA.setVisibility(0);
        } else {
            this.az = (SelectablePrivacyView) ((ViewStub) inflate.findViewById(2131559537)).inflate();
        }
        this.aB = (FbEditText) inflate.findViewById(2131559541);
        this.aC = (FbEditText) inflate.findViewById(2131559542);
        this.aB.setSelected(true);
        this.aB.addTextChangedListener(new C07508(this));
        this.aC.addTextChangedListener(new C07519(this));
        LogUtils.f(-1829041645, a);
        return inflate;
    }

    public final void m11322d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -442636456);
        super.d(bundle);
        if (bundle != null) {
            this.at = (SelectablePrivacyData) bundle.getParcelable("savedPrivacyKey");
            CharSequence string = bundle.getString("savedAlbumTitle");
            if (string != null) {
                this.aB.setText(string);
            }
            string = bundle.getString("savedAlbumDescription");
            if (string != null) {
                this.aC.setText(string);
            }
            this.aq = (CheckinPlaceModel) FlatBufferModelHelper.a(bundle, "savedLocation");
            this.aw = bundle.getBoolean("savedHasPrivacyChanged");
            this.ax = bundle.getBoolean("savedHasUserInteracted");
            this.av = (ComposerTargetData) bundle.getParcelable("savedComposerTargetData");
        }
        this.f9301g.f9278b = SafeUUIDGenerator.a().toString();
        this.f9301g.m11300b(o().getIntent().getStringExtra("source"));
        Fb4aTitleBar fb4aTitleBar = (Fb4aTitleBar) e(2131558563);
        fb4aTitleBar.setTitle(b(2131237840));
        fb4aTitleBar.a(new OnClickListener(this) {
            final /* synthetic */ AlbumCreatorFragment f9284a;

            {
                this.f9284a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1225898212);
                ((AlbumCreatorController) this.f9284a.f9300f.get()).m11292a(this.f9284a.o(), AlbumCreatorFragment.ax(this.f9284a));
                AlbumCreatorFragment.aw(this.f9284a);
                Logger.a(2, EntryType.UI_INPUT_END, -1022815062, a);
            }
        });
        TitleBarButtonSpec.Builder a2 = TitleBarButtonSpec.a();
        a2.g = b(2131237841);
        a2 = a2;
        a2.q = true;
        fb4aTitleBar.setButtonSpecs(ImmutableList.of(a2.a()));
        fb4aTitleBar.setOnToolbarButtonListener(new OnToolbarButtonListener(this) {
            final /* synthetic */ AlbumCreatorFragment f9285a;

            {
                this.f9285a = r1;
            }

            public final void m11305a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                AlbumCreatorFragment.ay(this.f9285a);
            }
        });
        this.ay = (GlyphView) e(2131559543);
        this.ay.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AlbumCreatorFragment f9283a;

            {
                this.f9283a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1713058631);
                PlacePickerConfiguration.Builder newBuilder = PlacePickerConfiguration.newBuilder();
                newBuilder.p = SearchType.ALBUM_CREATOR;
                newBuilder = newBuilder;
                if (this.f9283a.aq != null) {
                    newBuilder.a = CheckinPlaceModel.a(this.f9283a.aq);
                }
                this.f9283a.f9298d.a(CheckinIntentCreator.a(this.f9283a.getContext(), newBuilder.a()), 101, this.f9283a);
                Logger.a(2, EntryType.UI_INPUT_END, 864510607, a);
            }
        });
        as();
        DialogFragment dialogFragment = (ComposerAudienceFragment) this.D.a("AUDIENCE_FRAGMENT_TAG");
        if (dialogFragment != null) {
            dialogFragment.a();
        }
        if (bundle != null) {
            aq();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -949368660, a);
    }

    public final void m11323e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("savedPrivacyKey", this.as.f2001b);
        bundle.putString("savedAlbumTitle", this.aB.getText().toString());
        bundle.putString("savedAlbumDescription", this.aC.getText().toString());
        FlatBufferModelHelper.a(bundle, "savedLocation", this.aq);
        bundle.putBoolean("savedHasPrivacyChanged", this.aw);
        bundle.putBoolean("savedHasUserInteracted", this.ax);
        bundle.putParcelable("savedComposerTargetData", this.av);
    }

    public final void m11320a(int i, int i2, Intent intent) {
        if (i == 101 && i2 == -1) {
            this.aq = (CheckinPlaceModel) FlatBufferModelHelper.a(intent, "extra_place");
            aq();
        }
    }

    private void aq() {
        if (this.aq != null) {
            this.ay.setGlyphColor(jW_().getColor(2131362954));
            this.f9301g.m11304e();
            return;
        }
        this.ay.setGlyphColor(jW_().getColorStateList(2131364092));
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -634098579);
        super.mi_();
        this.ar.mo91a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1287159412, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 42782674);
        super.mj_();
        this.ar.m1906e();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -829207369, a);
    }

    private void as() {
        if (az()) {
            this.ar = this.f9296b.m1942a(this.am, this.au.mUsername);
        } else if (aA()) {
            this.ar = this.f9297c.m1934a(this.an, Long.valueOf(this.av.targetId), this.av.targetName);
        } else {
            this.ar = this.f9295a.m1964a(this.al, this.f9303i, null, this.f9302h);
            this.az.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ AlbumCreatorFragment f9282a;

                {
                    this.f9282a = r1;
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 628123905);
                    if (!this.f9282a.as.f2003d) {
                        AlbumCreatorFragment albumCreatorFragment = this.f9282a;
                        albumCreatorFragment.f9301g.m11303d();
                        ((AudienceSelectorPerformanceLogger) albumCreatorFragment.f9299e.get()).a(Caller.ALBUM_CREATOR_FRAGMENT);
                        ComposerAudienceFragment composerAudienceFragment = new ComposerAudienceFragment();
                        composerAudienceFragment.m1913a(new AudienceDialogData(albumCreatorFragment.ao, albumCreatorFragment.ap, null));
                        composerAudienceFragment.a(albumCreatorFragment.D, "AUDIENCE_FRAGMENT_TAG");
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -1147704695, a);
                }
            });
        }
    }

    public static void aw(AlbumCreatorFragment albumCreatorFragment) {
        if (albumCreatorFragment.o() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) albumCreatorFragment.o().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(albumCreatorFragment.o().getWindow().getDecorView().getWindowToken(), 0);
            }
        }
    }

    public static boolean ax(AlbumCreatorFragment albumCreatorFragment) {
        return m11318a(albumCreatorFragment.aB) || m11318a(albumCreatorFragment.aC) || albumCreatorFragment.aq != null || albumCreatorFragment.aw;
    }

    public static void ay(AlbumCreatorFragment albumCreatorFragment) {
        PagesData pagesData;
        CheckinPlaceModel checkinPlaceModel = null;
        if (albumCreatorFragment.az()) {
            pagesData = new PagesData(Long.parseLong(albumCreatorFragment.au.mUserId), albumCreatorFragment.au);
        } else {
            pagesData = null;
        }
        AlbumCreatorController albumCreatorController = (AlbumCreatorController) albumCreatorFragment.f9300f.get();
        FragmentActivity o = albumCreatorFragment.o();
        String trim = albumCreatorFragment.aB.getText().toString().trim();
        String trim2 = albumCreatorFragment.aC.getText().toString().trim();
        if (albumCreatorFragment.aq != null) {
            checkinPlaceModel = albumCreatorFragment.aq;
        }
        albumCreatorController.m11291a(o, trim, trim2, checkinPlaceModel, albumCreatorFragment.as, pagesData, albumCreatorFragment.av);
    }

    private boolean az() {
        return this.au != null;
    }

    private boolean aA() {
        return this.av != null && this.av.targetType == TargetType.GROUP;
    }

    private static boolean m11318a(FbEditText fbEditText) {
        return !Strings.isNullOrEmpty(fbEditText.getText().toString());
    }
}
