package com.facebook.pages.identity.cards.photos;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.abtest.qe.bootstrap.framework.QuickExperimentController;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.pageviewercontext.ViewerContextWaiter;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.pages.common.viewercontextutils.ViewerContextUtil;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.facebook.pages.identity.cards.photos.PageIdentityPhotosCardController.PhotoCollectionType;
import com.facebook.pages.identity.cards.photos.PageIdentityPhotosCardController.TabbedPhotosetData;
import com.facebook.pages.identity.cards.photos.PageIdentityPhotosGallery.OnPhotoDisplayedListener;
import com.facebook.photos.albums.protocols.MediasetType;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: primary_pin_tapped */
public class PageIdentityPhotosCardView extends CustomLinearLayout implements PageSecondaryCardView {
    @Inject
    FbUriIntentHandler f3593a;
    @Inject
    public PagesAnalytics f3594b;
    @Inject
    Lazy<QuickExperimentController> f3595c;
    @Inject
    public Lazy<ViewerContextUtil> f3596d;
    @Inject
    Toaster f3597e;
    @Inject
    @ForUiThread
    public Lazy<Executor> f3598f;
    public TextView f3599g;
    public PageIdentityPhotosGallery f3600h;
    private Resources f3601i;
    public PageIdentityPhotosCardController f3602j;
    private int f3603k;
    public long f3604l;
    private String f3605m;
    private ImmutableList<String> f3606n;
    private String f3607o;
    public boolean f3608p;
    private boolean f3609q;

    /* compiled from: primary_pin_tapped */
    public class C04901 implements OnPhotoDisplayedListener {
        final /* synthetic */ PageIdentityPhotosCardView f3588a;

        public C04901(PageIdentityPhotosCardView pageIdentityPhotosCardView) {
            this.f3588a = pageIdentityPhotosCardView;
        }

        public final void mo95a(String str) {
            PageIdentityPhotosCardView pageIdentityPhotosCardView = this.f3588a;
            pageIdentityPhotosCardView.f3594b.e(pageIdentityPhotosCardView.f3604l, str);
        }
    }

    /* compiled from: primary_pin_tapped */
    public class C04912 implements OnClickListener {
        final /* synthetic */ PageIdentityPhotosCardView f3589a;

        public C04912(PageIdentityPhotosCardView pageIdentityPhotosCardView) {
            this.f3589a = pageIdentityPhotosCardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -150839642);
            PageIdentityPhotosCardView pageIdentityPhotosCardView = this.f3589a;
            if (pageIdentityPhotosCardView.f3608p) {
                ((ViewerContextUtil) pageIdentityPhotosCardView.f3596d.get()).a(String.valueOf(pageIdentityPhotosCardView.f3604l), new C04923(pageIdentityPhotosCardView, new DialogBasedProgressIndicator(pageIdentityPhotosCardView.getContext(), 2131235433)), (Executor) pageIdentityPhotosCardView.f3598f.get());
            } else {
                PageIdentityPhotosCardView.m4643a(pageIdentityPhotosCardView, null);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 471890114, a);
        }
    }

    /* compiled from: primary_pin_tapped */
    public class C04923 implements ViewerContextWaiter {
        final /* synthetic */ DialogBasedProgressIndicator f3590a;
        final /* synthetic */ PageIdentityPhotosCardView f3591b;

        public C04923(PageIdentityPhotosCardView pageIdentityPhotosCardView, DialogBasedProgressIndicator dialogBasedProgressIndicator) {
            this.f3591b = pageIdentityPhotosCardView;
            this.f3590a = dialogBasedProgressIndicator;
        }

        public final void m4638a(ViewerContext viewerContext) {
            PageIdentityPhotosCardView.m4643a(this.f3591b, viewerContext);
        }

        public final void m4637a() {
            if (this.f3591b.getContext() != null) {
                this.f3590a.a();
            }
        }

        public final void m4640b(ViewerContext viewerContext) {
            if (this.f3591b.getContext() != null) {
                this.f3590a.b();
                PageIdentityPhotosCardView.m4643a(this.f3591b, viewerContext);
            }
        }

        public final void m4639b() {
            if (this.f3591b.getContext() != null) {
                this.f3590a.b();
                this.f3591b.f3597e.a(new ToastBuilder(this.f3591b.getContext().getResources().getString(2131235536)));
            }
        }
    }

    public static void m4644a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageIdentityPhotosCardView) obj).m4642a(FbUriIntentHandler.a(fbInjector), PagesAnalytics.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 83), IdBasedLazy.a(fbInjector, 9011), Toaster.b(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 3863));
    }

    public PageIdentityPhotosCardView(Context context) {
        super(context);
        m4641a();
    }

    private void m4641a() {
        Class cls = PageIdentityPhotosCardView.class;
        m4644a((Object) this, getContext());
        setContentView(2130906028);
        setOrientation(1);
        this.f3601i = getResources();
        this.f3599g = (TextView) a(2131565517);
        this.f3600h = (PageIdentityPhotosGallery) a(2131565518);
        this.f3603k = this.f3601i.getConfiguration().orientation;
        m4645b();
    }

    private void m4645b() {
        Resources resources = getResources();
        int i = resources.getDisplayMetrics().widthPixels;
        int dimension = (int) resources.getDimension(2131427487);
        int paddingLeft = this.f3600h.getPaddingLeft();
        i = (i - dimension) - paddingLeft;
        int paddingBottom = this.f3600h.getPaddingBottom();
        this.f3600h.setOffscreenPageLimit(((int) Math.ceil((double) (((float) i) / ((float) dimension)))) + 1);
        this.f3600h.b(dimension + paddingBottom, false);
        this.f3600h.setPadding(paddingLeft, this.f3600h.getPaddingTop(), i, paddingBottom);
        this.f3600h.setCurrentItem(0);
        this.f3600h.scrollTo(0, 0);
    }

    public final void m4646a(long j, FetchPageHeaderQueryModel fetchPageHeaderQueryModel, TabbedPhotosetData tabbedPhotosetData) {
        Object obj;
        this.f3604l = j;
        this.f3605m = fetchPageHeaderQueryModel.D();
        this.f3606n = fetchPageHeaderQueryModel.af();
        this.f3607o = fetchPageHeaderQueryModel.N() != null ? fetchPageHeaderQueryModel.N().b() : null;
        this.f3608p = new ProfilePermissions(this.f3606n).a(Permission.BASIC_ADMIN);
        this.f3609q = fetchPageHeaderQueryModel.y();
        PageIdentityPhotosCardController pageIdentityPhotosCardController = new PageIdentityPhotosCardController(getResources());
        pageIdentityPhotosCardController.f3574d = j;
        pageIdentityPhotosCardController.f3573c = tabbedPhotosetData;
        this.f3602j = pageIdentityPhotosCardController;
        if (pageIdentityPhotosCardController.f3573c == null || pageIdentityPhotosCardController.f3573c.m4624b()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            String string;
            TabbedPhotosetData tabbedPhotosetData2 = pageIdentityPhotosCardController.f3573c;
            TextView textView = this.f3599g;
            PageIdentityPhotosCardController pageIdentityPhotosCardController2 = this.f3602j;
            switch (pageIdentityPhotosCardController2.f3573c.f3570b) {
                case PHOTOS_TAKEN_HERE:
                    string = pageIdentityPhotosCardController2.f3572b.getString(2131235459);
                    break;
                case PAGE_PHOTOS_BY:
                    string = pageIdentityPhotosCardController2.f3572b.getString(2131235460);
                    break;
                case PAGE_PHOTOS_OF:
                    string = pageIdentityPhotosCardController2.f3572b.getString(2131235465);
                    break;
                default:
                    BLog.b(PageIdentityPhotosCardController.f3571a, "Unknown collection type in getLongString()");
                    string = null;
                    break;
            }
            textView.setText(string);
            this.f3600h.setPhotosCollections(tabbedPhotosetData2.f3569a);
            this.f3600h.f3615e = new C04901(this);
            this.f3599g.setOnClickListener(new C04912(this));
        }
    }

    private void m4642a(FbUriIntentHandler fbUriIntentHandler, PagesAnalytics pagesAnalytics, Lazy<QuickExperimentController> lazy, Lazy<ViewerContextUtil> lazy2, Toaster toaster, Lazy<Executor> lazy3) {
        this.f3593a = fbUriIntentHandler;
        this.f3594b = pagesAnalytics;
        this.f3595c = lazy;
        this.f3596d = lazy2;
        this.f3597e = toaster;
        this.f3598f = lazy3;
    }

    public static void m4643a(PageIdentityPhotosCardView pageIdentityPhotosCardView, ViewerContext viewerContext) {
        String str;
        Object obj;
        PhotoCollectionType photoCollectionType = pageIdentityPhotosCardView.f3602j.f3573c.f3570b;
        switch (photoCollectionType) {
            case PAGE_PHOTOS_OF:
                str = "of";
                break;
            case PAGE_PHOTOS_BY:
                str = "by";
                break;
            case PHOTOS_TAKEN_HERE:
                str = "at";
                break;
            default:
                BLog.a("PageIdentityPhotosCardView", "Unknown PhotoCollectionType " + photoCollectionType);
                break;
        }
        pageIdentityPhotosCardView.f3594b.d(pageIdentityPhotosCardView.f3604l, str);
        Bundle bundle = new Bundle();
        if (pageIdentityPhotosCardView.f3602j.f3573c.f3570b != PhotoCollectionType.PAGE_PHOTOS_BY) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            bundle.putBoolean("extra_show_attribution", true);
        }
        bundle.putString("owner_id", String.valueOf(pageIdentityPhotosCardView.f3604l));
        if (pageIdentityPhotosCardView.f3609q) {
            if (pageIdentityPhotosCardView.f3608p) {
                bundle.putParcelable("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", viewerContext);
                bundle.putStringArrayList("extra_pages_admin_permissions", new ArrayList(pageIdentityPhotosCardView.f3606n));
                bundle.putString("profile_name", pageIdentityPhotosCardView.f3605m);
                bundle.putString("page_admin_profile_pic_url_extra", pageIdentityPhotosCardView.f3607o);
            }
            pageIdentityPhotosCardView.f3593a.a(pageIdentityPhotosCardView.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.ad, Long.valueOf(pageIdentityPhotosCardView.f3604l)), bundle);
            return;
        }
        int ordinal;
        String str2 = "mediaset_type";
        switch (pageIdentityPhotosCardView.f3602j.f3573c.f3570b) {
            case PHOTOS_TAKEN_HERE:
                ordinal = MediasetType.PHOTOS_TAKEN_HERE.ordinal();
                break;
            case PAGE_PHOTOS_BY:
                ordinal = MediasetType.POSTED_PHOTOS.ordinal();
                break;
            case PAGE_PHOTOS_OF:
                ordinal = MediasetType.PHOTOS_TAKEN_OF.ordinal();
                break;
            default:
                ordinal = MediasetType.TAGGED_MEDIASET.ordinal();
                break;
        }
        bundle.putInt(str2, ordinal);
        pageIdentityPhotosCardView.f3593a.a(pageIdentityPhotosCardView.getContext(), pageIdentityPhotosCardView.f3602j.m4625b(), bundle);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f3603k != configuration.orientation) {
            this.f3603k = configuration.orientation;
            m4645b();
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -320292470);
        super.onSizeChanged(i, i2, i3, i4);
        m4645b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1907311030, a);
    }
}
