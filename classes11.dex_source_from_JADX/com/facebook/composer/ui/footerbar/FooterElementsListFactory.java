package com.facebook.composer.ui.footerbar;

import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import com.facebook.common.util.FindViewUtil;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass12;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass13;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass14;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass15;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass16;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass17;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass18;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass19;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass21;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass22;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.capability.ComposerPhotoCapability.ProvidesCapability;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.tip.TipManager;
import com.facebook.composer.ui.footerbar.ComposerMinutiaeFooterBarController.MinutiaeFooterBarDataProvider;
import com.facebook.composer.ui.footerbar.ComposerPhotoFooterBarController.Listener;
import com.facebook.config.application.Product;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsAlbumPillSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsAttachToAlbumSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsCheckinSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsCustomPublishModeSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsFacecastSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsImplicitLocationSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsPagePublishModePillSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsPostCompositionViewSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsTagPeopleSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsTransliterationSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesShouldShowNoLocationBadge;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTargetAlbum;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.ipc.composer.model.ComposerDateInfo.ProvidesDateInfo;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginIsDatePickerSupportedGetter;
import com.facebook.qe.api.QeAccessor;
import com.facebook.widget.LazyView.OnInflateRunner;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fb_incentive_activity_open */
public class FooterElementsListFactory<DataProvider extends ProvidesAttachments & ProvidesIsAlbumPillSupported & ProvidesIsAttachToAlbumSupported & ProvidesIsCheckinSupported & ProvidesIsCustomPublishModeSupported & ProvidesIsFacecastSupported & ProvidesIsImplicitLocationSupported & ProvidesIsPagePublishModePillSupported & ProvidesIsPostCompositionViewSupported & ProvidesIsTagPeopleSupported & ProvidesIsTransliterationSupported & ProvidesSessionId & ProvidesShouldShowNoLocationBadge & ProvidesTargetAlbum & ProvidesConfiguration & ProvidesContentType & ProvidesDateInfo & ProvidesFacecastInfo & ProvidesLocationInfo & ProvidesCapability & ProvidesPluginIsDatePickerSupportedGetter & ProvidesTaggedUsers & ProvidesTargetData> {
    public final FacecastUtil f7098A;
    public final TipManager f7099B;
    public final QeAccessor f7100C;
    private final ViewGroup f7101a;
    public final AnonymousClass14 f7102b;
    public final AnonymousClass13 f7103c;
    public final AnonymousClass15 f7104d;
    public final AnonymousClass16 f7105e;
    public final AnonymousClass17 f7106f;
    public final AnonymousClass18 f7107g;
    public final AnonymousClass19 f7108h;
    public final AnonymousClass22 f7109i;
    public final AnonymousClass12 f7110j;
    public final ComposerPhotoFooterBarControllerProvider f7111k;
    public final ComposerAlbumFooterBarControllerProvider f7112l;
    public final ComposerTagPeopleFooterBarControllerProvider f7113m;
    private final ComposerMinutiaeFooterBarControllerProvider f7114n;
    public final ComposerCheckInFooterBarControllerProvider f7115o;
    public final ComposerPickDateFooterBarControllerProvider f7116p;
    private final ComposerImplicitLocationFooterBarControllerProvider f7117q;
    private final ComposerPublishModeFooterBarControllerProvider f7118r;
    private final ComposerTransliterationFooterBarControllerProvider f7119s;
    public final ComposerFacecastFooterBarControllerProvider f7120t;
    public final AnonymousClass21 f7121u;
    public final DataProvider f7122v;
    public final WindowManager f7123w;
    public final Resources f7124x;
    private final Product f7125y;
    public ImmutableList<ComposerFooterBarController> f7126z;

    /* compiled from: fb_incentive_activity_open */
    class C09021 implements Function<ComposerFooterBarController, ComposerEventHandler> {
        final /* synthetic */ FooterElementsListFactory f7096a;

        C09021(FooterElementsListFactory footerElementsListFactory) {
            this.f7096a = footerElementsListFactory;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            return (ComposerFooterBarController) obj;
        }
    }

    /* compiled from: fb_incentive_activity_open */
    public class C09032 implements OnInflateRunner<GlyphButton> {
        final /* synthetic */ FooterElementsListFactory f7097a;

        public C09032(FooterElementsListFactory footerElementsListFactory) {
            this.f7097a = footerElementsListFactory;
        }

        public final void m8348a(View view) {
            ((GlyphButton) view).setImageResource(this.f7097a.f7098A.a(true));
        }
    }

    @Inject
    public FooterElementsListFactory(@Nonnull @Assisted TipManager tipManager, @Nonnull @Assisted Listener listener, @Nonnull @Assisted ComposerAlbumFooterBarController.Listener listener2, @Nonnull @Assisted ComposerTagPeopleFooterBarController.Listener listener3, @Nonnull @Assisted ComposerMinutiaeFooterBarController.Listener listener4, @Nonnull @Assisted ComposerCheckInFooterBarController.Listener listener5, @Nonnull @Assisted ComposerPickDateFooterBarController.Listener listener6, @Nonnull @Assisted ComposerPublishModeFooterBarController.Listener listener7, @Assisted ComposerTransliterationFooterBarController.Listener listener8, @Nonnull @Assisted ComposerFacecastFooterBarController.Listener listener9, @Nonnull @Assisted ViewGroup viewGroup, @Nonnull @Assisted MinutiaeFooterBarDataProvider minutiaeFooterBarDataProvider, @Nonnull @Assisted DataProvider dataProvider, ComposerPhotoFooterBarControllerProvider composerPhotoFooterBarControllerProvider, ComposerAlbumFooterBarControllerProvider composerAlbumFooterBarControllerProvider, ComposerTagPeopleFooterBarControllerProvider composerTagPeopleFooterBarControllerProvider, ComposerMinutiaeFooterBarControllerProvider composerMinutiaeFooterBarControllerProvider, ComposerCheckInFooterBarControllerProvider composerCheckInFooterBarControllerProvider, ComposerPickDateFooterBarControllerProvider composerPickDateFooterBarControllerProvider, ComposerImplicitLocationFooterBarControllerProvider composerImplicitLocationFooterBarControllerProvider, ComposerPublishModeFooterBarControllerProvider composerPublishModeFooterBarControllerProvider, ComposerTransliterationFooterBarControllerProvider composerTransliterationFooterBarControllerProvider, ComposerFacecastFooterBarControllerProvider composerFacecastFooterBarControllerProvider, WindowManager windowManager, Resources resources, Product product, QeAccessor qeAccessor, FacecastUtil facecastUtil) {
        this.f7099B = tipManager;
        this.f7102b = listener;
        this.f7103c = listener2;
        this.f7104d = listener3;
        this.f7105e = listener4;
        this.f7106f = listener5;
        this.f7107g = listener6;
        this.f7108h = listener7;
        this.f7109i = listener8;
        this.f7110j = listener9;
        this.f7121u = minutiaeFooterBarDataProvider;
        this.f7122v = dataProvider;
        this.f7101a = viewGroup;
        this.f7111k = composerPhotoFooterBarControllerProvider;
        this.f7112l = composerAlbumFooterBarControllerProvider;
        this.f7113m = composerTagPeopleFooterBarControllerProvider;
        this.f7114n = composerMinutiaeFooterBarControllerProvider;
        this.f7115o = composerCheckInFooterBarControllerProvider;
        this.f7116p = composerPickDateFooterBarControllerProvider;
        this.f7117q = composerImplicitLocationFooterBarControllerProvider;
        this.f7118r = composerPublishModeFooterBarControllerProvider;
        this.f7119s = composerTransliterationFooterBarControllerProvider;
        this.f7120t = composerFacecastFooterBarControllerProvider;
        this.f7123w = windowManager;
        this.f7124x = resources;
        this.f7125y = product;
        this.f7100C = qeAccessor;
        this.f7098A = facecastUtil;
    }

    public final ImmutableList<ComposerEventHandler> m8349a() {
        if (this.f7126z == null) {
            int width;
            ViewStub viewStub = (ViewStub) this.f7101a.findViewById(2131560662);
            if (this.f7125y == Product.PAA) {
                viewStub.setLayoutResource(2130903674);
            } else {
                viewStub.setLayoutResource(2130903673);
            }
            View inflate = viewStub.inflate();
            int i = 0;
            Builder builder = ImmutableList.builder();
            WindowManager windowManager = this.f7123w;
            Resources resources = this.f7124x;
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (VERSION.SDK_INT < 13) {
                width = defaultDisplay.getWidth();
            } else {
                Point point = new Point();
                defaultDisplay.getSize(point);
                width = point.x;
            }
            int dimensionPixelSize = resources.getDimensionPixelSize(2131429612);
            if (width < resources.getDimensionPixelSize(2131429614) + (dimensionPixelSize * 5)) {
                width = resources.getDimensionPixelSize(2131429613);
            } else {
                width = dimensionPixelSize;
            }
            int i2 = width;
            Optional a = FindViewUtil.a(inflate, 2131560505);
            if (a.isPresent()) {
                builder.c(this.f7111k.m8329a(new LazyFooterView((ViewStub) a.get(), i2), this.f7122v, this.f7102b));
            }
            if (!((ComposerDataProviderImpl) this.f7122v).m7446x()) {
                a = FindViewUtil.a(inflate, 2131560507);
                if (a.isPresent()) {
                    builder.c(this.f7112l.m8300a(new LazyFooterView((ViewStub) a.get(), i2), this.f7122v, this.f7103c));
                }
            }
            a = FindViewUtil.a(inflate, 2131560511);
            if (a.isPresent()) {
                builder.c(this.f7113m.m8345a(this.f7099B, new LazyFooterView((ViewStub) a.get(), i2), this.f7122v, this.f7104d));
            }
            a = FindViewUtil.a(inflate, 2131560513);
            if (a.isPresent()) {
                builder.c(new ComposerMinutiaeFooterBarController(this.f7105e, this.f7121u, new LazyFooterView((ViewStub) a.get(), i2)));
            }
            a = FindViewUtil.a(inflate, 2131560515);
            if (a.isPresent()) {
                builder.c(this.f7115o.m8310a(this.f7099B, new LazyFooterView((ViewStub) a.get(), i2), this.f7106f, this.f7122v));
            }
            if (!this.f7100C.a(ExperimentsForFeedUtilComposerAbtestModule.H, false)) {
                a = FindViewUtil.a(inflate, 2131560517);
                if (a.isPresent()) {
                    builder.c(this.f7116p.m8332a(this.f7122v, new LazyFooterView((ViewStub) a.get(), i2), this.f7107g));
                }
            }
            if (!this.f7100C.a(ExperimentsForFeedUtilComposerAbtestModule.f, false)) {
                a = FindViewUtil.a(inflate, 2131560521);
                if (a.isPresent()) {
                    builder.c(ComposerImplicitLocationFooterBarControllerProvider.m8323a(new LazyFooterView((ViewStub) a.get(), i2), this.f7122v, this.f7106f));
                }
            }
            if (!(((ComposerDataProviderImpl) this.f7122v).m7411L() || ((ComposerDataProviderImpl) this.f7122v).m7412N())) {
                a = FindViewUtil.a(inflate, 2131560523);
                if (a.isPresent()) {
                    builder.c(new ComposerPublishModeFooterBarController(new LazyFooterView((ViewStub) a.get(), i2), (ComposerDataProviderImpl) this.f7122v, this.f7108h));
                }
            }
            a = FindViewUtil.a(inflate, 2131560519);
            if (a.isPresent()) {
                builder.c(new ComposerTransliterationFooterBarController(this.f7109i, (ComposerDataProviderImpl) this.f7122v, new LazyFooterView((ViewStub) a.get(), i2)));
            }
            a = FindViewUtil.a(inflate, 2131560509);
            if (a.isPresent()) {
                builder.c(this.f7120t.m8320a(this.f7099B, new LazyFooterView((ViewStub) a.get(), i2, new C09032(this)), this.f7122v, this.f7110j));
            }
            this.f7126z = builder.b();
            int size = this.f7126z.size();
            while (i < size) {
                ((ComposerFooterBarController) this.f7126z.get(i)).mo215b();
                i++;
            }
        }
        return ImmutableList.copyOf(Lists.a(this.f7126z, new C09021(this)));
    }
}
