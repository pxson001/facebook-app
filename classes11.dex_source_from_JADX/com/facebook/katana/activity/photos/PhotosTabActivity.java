package com.facebook.katana.activity.photos;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost.OnTabChangeListener;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.pagerindicator.TabbedViewPagerIndicator;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.profile.TimelinePhotoEditMode;
import com.facebook.ipc.profile.TimelinePhotoTabModeParams;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.photos.PhotosTabFragmentPagerAdapter.TabInfo;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albumcreator.AlbumCreatorIntentBuilder;
import com.facebook.photos.albumcreator.AlbumCreatorSourceType;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.PhotoFlowLogger;
import com.facebook.photos.base.analytics.WaterfallIdGenerator;
import com.facebook.photos.base.analytics.photostab.PhotosTabBaseParams;
import com.facebook.photos.data.model.PhotoSet;
import com.facebook.photos.pandora.common.data.SimplePandoraInstanceId;
import com.facebook.photos.pandora.ui.PandoraCampaignMediaSetFragment;
import com.facebook.photos.pandora.ui.PandoraTaggedPhotosFragment;
import com.facebook.photos.pandora.ui.PandoraUploadedMediaSetFragment;
import com.facebook.photos.photoset.controllers.FbPhotoPickerController;
import com.facebook.photos.photoset.controllers.MediaPickerLaunchController;
import com.facebook.photos.photoset.controllers.PhotoSetOnActivityResultController;
import com.facebook.photos.photoset.ui.photoset.PandoraAlbumsFragment;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.user.model.User;
import com.facebook.vault.service.VaultHelpers;
import com.facebook.vault.ui.VaultSettingsActivity;
import com.facebook.vault.ui.VaultSyncScreenFragment;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: {action_type} */
public class PhotosTabActivity extends BaseFacebookActivity implements OnPageChangeListener, OnTabChangeListener, AnalyticsActivity {
    @Inject
    WaterfallIdGenerator f23A;
    private List<TabInfo> f24B;
    private ViewPager f25C;
    private Long f26D;
    private Long f27E;
    private String f28F;
    private int f29G = -1;
    private String f30H;
    private TimelinePhotoTabModeParams f31I;
    private String f32J;
    private String f33K;
    private String f34L;
    private String f35M;
    private boolean f36N;
    @Inject
    SecureContextHelper f37p;
    @Inject
    VaultHelpers f38q;
    @Inject
    @LoggedInUser
    Provider<User> f39r;
    @Inject
    @LoggedInUserId
    Provider<String> f40s;
    @Inject
    Lazy<ComposerPublishServiceHelper> f41t;
    @Inject
    Lazy<AlbumCreatorIntentBuilder> f42u;
    @Inject
    Lazy<FbErrorReporter> f43v;
    @Inject
    Lazy<PhotoSetOnActivityResultController> f44w;
    @Inject
    Lazy<MediaPickerLaunchController> f45x;
    @Inject
    Lazy<FbPhotoPickerController> f46y;
    @Inject
    DefaultPhotoFlowLogger f47z;

    /* compiled from: {action_type} */
    class C00011 implements OnClickListener {
        final /* synthetic */ PhotosTabActivity f22a;

        C00011(PhotosTabActivity photosTabActivity) {
            this.f22a = photosTabActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 639324984);
            this.f22a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1846353078, a);
        }
    }

    private static <T extends Context> void m43a(Class<T> cls, T t) {
        m44a((Object) t, (Context) t);
    }

    public static void m44a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PhotosTabActivity) obj).m42a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), VaultHelpers.b(fbInjector), IdBasedProvider.a(fbInjector, 3595), IdBasedProvider.a(fbInjector, 4442), IdBasedLazy.a(fbInjector, 5272), IdBasedLazy.a(fbInjector, 9243), IdBasedSingletonScopeProvider.b(fbInjector, 494), IdBasedLazy.a(fbInjector, 9408), IdBasedSingletonScopeProvider.b(fbInjector, 9407), IdBasedLazy.a(fbInjector, 9406), DefaultPhotoFlowLogger.b(fbInjector), WaterfallIdGenerator.a(fbInjector));
    }

    private void m42a(SecureContextHelper secureContextHelper, VaultHelpers vaultHelpers, Provider<User> provider, Provider<String> provider2, Lazy<ComposerPublishServiceHelper> lazy, Lazy<AlbumCreatorIntentBuilder> lazy2, Lazy<FbErrorReporter> lazy3, Lazy<PhotoSetOnActivityResultController> lazy4, Lazy<MediaPickerLaunchController> lazy5, Lazy<FbPhotoPickerController> lazy6, PhotoFlowLogger photoFlowLogger, WaterfallIdGenerator waterfallIdGenerator) {
        this.f37p = secureContextHelper;
        this.f38q = vaultHelpers;
        this.f39r = provider;
        this.f40s = provider2;
        this.f41t = lazy;
        this.f42u = lazy2;
        this.f43v = lazy3;
        this.f44w = lazy4;
        this.f45x = lazy5;
        this.f46y = lazy6;
        this.f47z = photoFlowLogger;
        this.f23A = waterfallIdGenerator;
    }

    protected final void m60b(Bundle bundle) {
        super.b(bundle);
        Class cls = PhotosTabActivity.class;
        m44a((Object) this, (Context) this);
        setContentView(2130906223);
        this.f25C = (ViewPager) a(2131565950);
        Intent intent = getIntent();
        this.f26D = Long.valueOf(intent.getLongExtra("owner_id", Long.parseLong((String) this.f40s.get())));
        this.f27E = Long.valueOf(intent.getLongExtra("viewer_id", Long.parseLong((String) this.f40s.get())));
        this.f33K = intent.getStringExtra("friendship_status");
        this.f34L = intent.getStringExtra("subscribe_status");
        this.f35M = intent.getStringExtra("session_id");
        if (StringUtil.a(this.f35M)) {
            this.f35M = WaterfallIdGenerator.a();
            intent.putExtra("session_id", this.f35M);
        }
        this.f28F = intent.getStringExtra("profile_name");
        if (Strings.isNullOrEmpty(this.f28F) && Objects.equal(this.f26D, Long.valueOf(Long.parseLong((String) this.f40s.get())))) {
            this.f28F = ((User) this.f39r.get()).j();
        }
        this.f31I = (TimelinePhotoTabModeParams) intent.getParcelableExtra("extra_photo_tab_mode_params");
        this.f36N = intent.getBooleanExtra("hide_photos_of_tab", false);
        this.f32J = intent.getStringExtra("extra_photo_title_text");
        if (intent.getBooleanExtra("edit_profile_pic", false)) {
            m49j();
        }
        ((FbPhotoPickerController) this.f46y.get()).a(intent);
        Fb4aTitleBar fb4aTitleBar = (Fb4aTitleBar) findViewById(2131558563);
        if (m52m() && !Strings.isNullOrEmpty(this.f28F)) {
            fb4aTitleBar.setTitle(this.f28F);
        } else if (this.f31I != null && (this.f31I.c() || this.f31I.d())) {
            fb4aTitleBar.setTitle(getString(2131234887));
            fb4aTitleBar.setShowDividers(true);
        } else if (!Strings.isNullOrEmpty(this.f32J)) {
            fb4aTitleBar.setTitle(this.f32J);
            fb4aTitleBar.setShowDividers(true);
        }
        fb4aTitleBar.setSearchButtonVisible(false);
        fb4aTitleBar.setHasBackButton(false);
        fb4aTitleBar.a(new C00011(this));
        m47c(intent.getStringExtra("tab_to_show"));
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1928940383);
        super.onResume();
        if (this.f29G != -1) {
            this.f25C.setCurrentItem(this.f29G);
            this.f29G = -1;
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1787590336, a);
    }

    public final void m58a(Intent intent) {
        super.a(intent);
        String stringExtra = intent.getStringExtra("tab_to_show");
        if (stringExtra == null) {
            this.f29G = -1;
            return;
        }
        Integer d = m48d(stringExtra);
        if (d == null) {
            this.f29G = -1;
        } else {
            this.f29G = d.intValue();
        }
    }

    private void m49j() {
        this.f31I = new TimelinePhotoTabModeParams(TimelinePhotoEditMode.EDIT_PROFILE_PIC, this.f26D.longValue());
    }

    private void m50k() {
        Builder a = TitleBarButtonSpec.a();
        a.i = 2130840542;
        a = a;
        a.j = getString(2131241698);
        a(a.a());
    }

    private void m51l() {
        a(null);
    }

    private void m46b(String str) {
        PhotosTabBaseParams photosTabBaseParams = new PhotosTabBaseParams(new ProfileViewerContext(this.f26D.longValue(), (this.f27E.longValue() > 0 ? this.f27E : this.f26D).longValue(), GraphQLFriendshipStatus.fromString(this.f33K), GraphQLSubscribeStatus.fromString(this.f34L)).g().name(), String.valueOf(this.f26D), str, this.f30H);
        this.f47z.a(this.f35M);
        this.f47z.a(photosTabBaseParams);
        this.f30H = str;
        m51l();
        Builder a;
        if (!m52m()) {
            a = TitleBarButtonSpec.a();
            a.g = getString(2131230727);
            a(a.a());
        } else if (str.equals("sync") && !this.f38q.e()) {
            m50k();
        } else if (!str.equals("albums") && !str.equals("sync") && m56q()) {
            a = TitleBarButtonSpec.a();
            a.i = 2130837601;
            a(a.a());
        } else if (str.equals("albums")) {
            a = TitleBarButtonSpec.a();
            a.i = 2130838296;
            a(a.a());
        }
    }

    public void onTabChanged(String str) {
        m46b(str);
    }

    public final void e_(int i) {
        m46b(((TabInfo) this.f24B.get(i)).f48a);
    }

    public final void m57a(int i, float f, int i2) {
    }

    public final void m59b(int i) {
    }

    private boolean m52m() {
        return ((this.f31I != null && !this.f31I.a()) || ((FbPhotoPickerController) this.f46y.get()).a || ((FbPhotoPickerController) this.f46y.get()).b) ? false : true;
    }

    public void titleBarPrimaryActionClickHandler(View view) {
        if (!m52m()) {
            finish();
        } else if ("sync".equals(this.f30H)) {
            this.f37p.a(new Intent(this, VaultSettingsActivity.class), this);
        } else if ("albums".equals(this.f30H)) {
            this.f37p.a(((AlbumCreatorIntentBuilder) this.f42u.get()).a(AlbumCreatorSourceType.ALBUMSTAB, null), this);
        } else if (!this.f30H.equals("albums")) {
            ((MediaPickerLaunchController) this.f45x.get()).a(this);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (((PhotoSetOnActivityResultController) this.f44w.get()).a(this, i, i2, intent)) {
                finish();
                return;
            }
            switch (i) {
                case 1756:
                    ComposerPublishServiceHelper composerPublishServiceHelper = (ComposerPublishServiceHelper) this.f41t.get();
                    if (!intent.getBooleanExtra("is_uploading_media", false)) {
                        composerPublishServiceHelper.c(intent);
                    }
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    private void m47c(String str) {
        Bundle bundle;
        boolean z = true;
        this.f24B = new ArrayList();
        if (this.f31I == null) {
            this.f31I = new TimelinePhotoTabModeParams(TimelinePhotoEditMode.VIEWING_MODE, this.f26D.longValue());
        }
        if (m54o()) {
            bundle = new Bundle();
            String stringExtra = getIntent().getStringExtra("set_token");
            if (stringExtra == null) {
                ((AbstractFbErrorReporter) this.f43v.get()).b(PhotosTabActivity.class.getSimpleName(), "Asked to show suggested photos but provided no campaign ID");
            } else {
                bundle.putString("campaign_id", stringExtra);
                bundle.putBoolean("isDefaultLandingPage", true);
                bundle.putParcelable("pandora_instance_id", new SimplePandoraInstanceId(stringExtra));
                bundle.putParcelable("callerContext", CallerContext.a(PhotosTabActivity.class));
                m45a("campaign", 2131236741, PandoraCampaignMediaSetFragment.class, bundle);
            }
        }
        bundle = new Bundle();
        bundle.putString("set_token", PhotoSet.a(this.f26D.longValue()));
        bundle.putParcelable("extra_photo_tab_mode_params", this.f31I);
        bundle.putString("photo_set_grid_source", "source_photos_tab");
        bundle.putString("userId", String.valueOf(this.f26D));
        bundle.putString("userName", this.f28F);
        bundle.putString("friendship_status", this.f33K);
        bundle.putString("subscribe_status", this.f34L);
        if (m55p()) {
            m45a("photos_of", 2131236735, PandoraTaggedPhotosFragment.class, bundle);
        }
        PandoraUploadedMediaSetFragment.b(bundle, String.valueOf(this.f26D), false, CallerContext.a(PhotosTabActivity.class));
        m45a("photo_uploads", 2131236736, PandoraUploadedMediaSetFragment.class, bundle);
        bundle = new Bundle();
        bundle.putParcelable("extra_photo_tab_mode_params", this.f31I);
        bundle.putBoolean("disable_adding_photos_to_albums", getIntent().getBooleanExtra("disable_adding_photos_to_albums", false));
        bundle.putLong("owner_id", this.f26D.longValue());
        m45a("albums", 2131236737, PandoraAlbumsFragment.class, bundle);
        if (m53n()) {
            bundle = new Bundle();
            String stringExtra2 = getIntent().getStringExtra("nux_ref");
            if (stringExtra2 != null) {
                bundle.putString("nux_ref", stringExtra2);
            }
            m45a("sync", 2131236738, VaultSyncScreenFragment.class, bundle);
        } else {
            z = false;
        }
        TabbedViewPagerIndicator tabbedViewPagerIndicator = (TabbedViewPagerIndicator) a(2131565949);
        this.f25C.setAdapter(new PhotosTabFragmentPagerAdapter(kO_(), this, this.f24B));
        tabbedViewPagerIndicator.setViewPager(this.f25C);
        tabbedViewPagerIndicator.l = this;
        if (str != null) {
            Integer d = m48d(str);
            if (d != null) {
                this.f25C.setCurrentItem(d.intValue());
                return;
            } else {
                ((AbstractFbErrorReporter) this.f43v.get()).b(PhotosTabActivity.class.getSimpleName(), StringFormatUtil.formatStrLocaleSafe("non existent tab tabToShow=\"%s\" syncTabAdded=\"%s\"", str, Boolean.valueOf(z)));
                return;
            }
        }
        e_(this.f25C.k);
    }

    private void m45a(String str, int i, Class<? extends Fragment> cls, Bundle bundle) {
        this.f24B.add(new TabInfo(str, i, cls, bundle));
    }

    private Integer m48d(String str) {
        int size = this.f24B.size();
        for (int i = 0; i < size; i++) {
            if (((TabInfo) this.f24B.get(i)).f48a.equals(str)) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    private boolean m53n() {
        return m56q() && this.f38q.a() && m52m() && VERSION.SDK_INT <= 22;
    }

    private boolean m54o() {
        return getIntent().getBooleanExtra("show_suggested_tab", false);
    }

    private boolean m55p() {
        return !this.f36N;
    }

    private boolean m56q() {
        return this.f26D != null && this.f26D.longValue() == Long.parseLong((String) this.f40s.get());
    }

    public final String am_() {
        return "photos_tabs";
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.f29G = this.f25C.k;
        bundle.putInt("mTabToShowOnResume", this.f29G);
        bundle.putParcelable("extra_photo_tab_mode_params", this.f31I);
        super.onSaveInstanceState(bundle);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f29G = bundle.getInt("mTabToShowOnResume", -1);
        this.f31I = (TimelinePhotoTabModeParams) bundle.getParcelable("extra_photo_tab_mode_params");
    }
}
