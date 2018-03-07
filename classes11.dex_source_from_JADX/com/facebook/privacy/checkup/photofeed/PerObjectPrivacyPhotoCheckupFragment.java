package com.facebook.privacy.checkup.photofeed;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.fragment.generatedenvironments.HasPrefetcherImplProvider;
import com.facebook.feed.rows.adapter.ListItemCollectionWithFeedEnd;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder;
import com.facebook.feed.rows.adapter.MultiRowAdapterBuilder.Builder;
import com.facebook.feed.rows.adapter.api.ListItemCollectionEndProvider;
import com.facebook.feed.rows.adapter.api.MultiRowAdapter;
import com.facebook.feed.rows.core.MultipleRowsStoriesRecycleCallback;
import com.facebook.feed.rows.core.parts.MultiRowGroupPartDefinitions;
import com.facebook.feed.rows.photosfeed.PrivacyFeedFeedbackLauncher;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherFactory;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapper;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.consumptiongallery.snowflake.SnowflakeMediaGalleryHelper;
import com.facebook.photos.dialog.PhotoAnimationContentFragment;
import com.facebook.photos.dialog.PhotoAnimationDialogFragment;
import com.facebook.photos.dialog.PhotoAnimationDialogFragment.3;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;
import com.facebook.privacy.checkup.photofeed.data.POPPhotoCheckupData;
import com.facebook.privacy.checkup.photofeed.data.PhotoCheckupManager;
import com.facebook.privacy.checkup.photofeed.data.PhotoCheckupManager.GraphQLMorePhotosToCheckupDataTransform;
import com.facebook.privacy.checkup.photofeed.data.PhotoCheckupManager.GraphQLProfilePhotoToCheckupDataTransform;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckup.FetchProfilePhotoCheckupQueryString;
import com.facebook.privacy.checkup.protocol.FetchPhotoCheckupInterfaces.MediaMetadataWithCreatorPrivacyOptions;
import com.facebook.privacy.checkup.protocol.PrivacyCheckupClient;
import com.facebook.privacy.checkup.service.PrivacyCheckupAnalyticsLogger;
import com.facebook.privacy.checkup.service.PrivacyCheckupAnalyticsLogger.PhotoCheckupEvent;
import com.facebook.privacy.checkup.service.PrivacyCheckupAnalyticsLogger.ReviewType;
import com.facebook.privacy.protocol.BulkEditAlbumPhotoPrivacyParams.BulkEditAlbumType;
import com.facebook.privacy.protocol.BulkEditAlbumPhotoPrivacyParams.BulkEditCaller;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.listview.BaseProxyOnScrollListener;
import com.facebook.widget.listview.FbListAdapter;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.recyclerview.LayoutManagerWithKeepAttachedHack;
import com.facebook.widget.recyclerview.RecyclerViewProxy;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Starting graphql request */
public final class PerObjectPrivacyPhotoCheckupFragment extends PhotoAnimationContentFragment implements CanEditObjectPrivacy {
    @Inject
    PhotoCheckupManager f11002a;
    private PrivacyOptionFieldsWithExplanation aA;
    private boolean aB;
    private final ListItemCollection<POPPhotoCheckupData> aC = new C13041(this);
    private final ListItemCollection<MediaMetadataWithCreatorPrivacyOptions> aD = new C13052(this);
    public final AbstractDisposableFutureCallback<OperationResult> aE = new C13063(this);
    private final AbstractDisposableFutureCallback<Void> aF = new C13074(this);
    @Inject
    public Toaster al;
    @Inject
    MultiRowImagePrefetcherFactory am;
    @Inject
    HasPrefetcherImplProvider an;
    @Inject
    XConfigReader ao;
    public POPPhotoCheckupData ap;
    private ScrollingViewProxy aq;
    private MultiRowAdapter ar;
    public MultiRowAdapter as;
    private MultiAdapterListAdapter at;
    private MultiRowImagePrefetcherWrapper au;
    private BaseProxyOnScrollListener av;
    private HashMap<String, PrivacyOptionFieldsWithExplanation> aw;
    private String ax;
    private int ay;
    private boolean az;
    @Inject
    PrivacyCheckupAnalyticsLogger f11003b;
    @Inject
    TasksManager f11004c;
    @Inject
    MultipleRowsStoriesRecycleCallback f11005d;
    @Inject
    MultiRowAdapterBuilder f11006e;
    @Inject
    Lazy<PhotoPrivacyFeedHeaderPartDefinition> f11007f;
    @Inject
    Lazy<PhotoPrivacyFeedRootPartDefinition> f11008g;
    @Inject
    PrivacyFeedMediaGalleryLauncherProvider f11009h;
    @Inject
    PrivacyFeedFeedbackLauncher f11010i;

    /* compiled from: Starting graphql request */
    class C13041 implements ListItemCollection<POPPhotoCheckupData> {
        final /* synthetic */ PerObjectPrivacyPhotoCheckupFragment f10992a;

        C13041(PerObjectPrivacyPhotoCheckupFragment perObjectPrivacyPhotoCheckupFragment) {
            this.f10992a = perObjectPrivacyPhotoCheckupFragment;
        }

        public final int m11391a() {
            return this.f10992a.ap == null ? 0 : 1;
        }

        public final Object m11392a(int i) {
            return this.f10992a.ap;
        }
    }

    /* compiled from: Starting graphql request */
    class C13052 implements ListItemCollection<MediaMetadataWithCreatorPrivacyOptions> {
        final /* synthetic */ PerObjectPrivacyPhotoCheckupFragment f10993a;

        C13052(PerObjectPrivacyPhotoCheckupFragment perObjectPrivacyPhotoCheckupFragment) {
            this.f10993a = perObjectPrivacyPhotoCheckupFragment;
        }

        public final int m11393a() {
            POPPhotoCheckupData pOPPhotoCheckupData = this.f10993a.ap;
            return pOPPhotoCheckupData.f11058c == null ? 0 : pOPPhotoCheckupData.f11058c.size();
        }

        public final Object m11394a(int i) {
            return (MediaMetadataWithCreatorPrivacyOptions) this.f10993a.ap.f11058c.get(i);
        }
    }

    /* compiled from: Starting graphql request */
    class C13063 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ PerObjectPrivacyPhotoCheckupFragment f10994a;

        C13063(PerObjectPrivacyPhotoCheckupFragment perObjectPrivacyPhotoCheckupFragment) {
            this.f10994a = perObjectPrivacyPhotoCheckupFragment;
        }

        protected final void m11396a(Throwable th) {
            this.f10994a.al.b(new ToastBuilder(2131242319));
        }
    }

    /* compiled from: Starting graphql request */
    class C13074 extends AbstractDisposableFutureCallback<Void> {
        final /* synthetic */ PerObjectPrivacyPhotoCheckupFragment f10995a;

        C13074(PerObjectPrivacyPhotoCheckupFragment perObjectPrivacyPhotoCheckupFragment) {
            this.f10995a = perObjectPrivacyPhotoCheckupFragment;
        }

        protected final void m11397a(Object obj) {
            PerObjectPrivacyPhotoCheckupFragment.ax(this.f10995a);
        }

        protected final void m11398a(Throwable th) {
        }
    }

    /* compiled from: Starting graphql request */
    class C13085 extends BaseProxyOnScrollListener {
        final /* synthetic */ PerObjectPrivacyPhotoCheckupFragment f10996a;

        C13085(PerObjectPrivacyPhotoCheckupFragment perObjectPrivacyPhotoCheckupFragment) {
            this.f10996a = perObjectPrivacyPhotoCheckupFragment;
        }

        public final void m11399a(ScrollingViewProxy scrollingViewProxy, int i) {
        }

        public final void m11400a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            if ((this.f10996a.as.s_(i) + i2) + 4 >= PerObjectPrivacyPhotoCheckupFragment.aw(this.f10996a) && this.f10996a.ap.f11063h) {
                PerObjectPrivacyPhotoCheckupFragment.au(this.f10996a);
            }
        }
    }

    /* compiled from: Starting graphql request */
    class C13107 implements ListItemCollectionEndProvider {
        final /* synthetic */ PerObjectPrivacyPhotoCheckupFragment f10999a;

        C13107(PerObjectPrivacyPhotoCheckupFragment perObjectPrivacyPhotoCheckupFragment) {
            this.f10999a = perObjectPrivacyPhotoCheckupFragment;
        }

        public final boolean m11401a() {
            return this.f10999a.ap.f11063h;
        }
    }

    /* compiled from: Starting graphql request */
    class C13118 implements Runnable {
        final /* synthetic */ PerObjectPrivacyPhotoCheckupFragment f11000a;

        C13118(PerObjectPrivacyPhotoCheckupFragment perObjectPrivacyPhotoCheckupFragment) {
            this.f11000a = perObjectPrivacyPhotoCheckupFragment;
        }

        public void run() {
            PerObjectPrivacyPhotoCheckupFragment.ax(this.f11000a);
        }
    }

    /* compiled from: Starting graphql request */
    public class C13129 implements OnClickListener {
        final /* synthetic */ PerObjectPrivacyPhotoCheckupFragment f11001a;

        public C13129(PerObjectPrivacyPhotoCheckupFragment perObjectPrivacyPhotoCheckupFragment) {
            this.f11001a = perObjectPrivacyPhotoCheckupFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f11001a.f11003b.m11466a(ReviewType.PROFILE_PHOTO_CHECKUP.reviewType, PhotoCheckupEvent.PHOTO_CHECKUP_BULK_EDIT_REJECTED.eventName);
        }
    }

    /* compiled from: Starting graphql request */
    enum Tasks {
        FETCH_PHOTOS
    }

    public static void m11403a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PerObjectPrivacyPhotoCheckupFragment) obj).m11402a(PhotoCheckupManager.m11454a(fbInjector), PrivacyCheckupAnalyticsLogger.m11461b(fbInjector), TasksManager.b(fbInjector), MultipleRowsStoriesRecycleCallback.a(fbInjector), MultiRowAdapterBuilder.b(fbInjector), IdBasedLazy.a(fbInjector, 9696), IdBasedLazy.a(fbInjector, 9697), (PrivacyFeedMediaGalleryLauncherProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PrivacyFeedMediaGalleryLauncherProvider.class), PrivacyFeedFeedbackLauncher.b(fbInjector), Toaster.b(fbInjector), MultiRowImagePrefetcherFactory.a(fbInjector), (HasPrefetcherImplProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(HasPrefetcherImplProvider.class), XConfigReader.a(fbInjector));
    }

    public final View m11406a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1417700830);
        View inflate = layoutInflater.inflate(2130906341, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1724591106, a);
        return inflate;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.as != null) {
            this.as.a(configuration);
            this.aB = false;
        }
    }

    public final void m11414c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PerObjectPrivacyPhotoCheckupFragment.class;
        m11403a((Object) this, getContext());
        Object string = this.s.getString("checkup_type");
        Preconditions.checkArgument(!TextUtils.isEmpty(string));
        String string2 = this.s.getString("checkup_source");
        if (TextUtils.isEmpty(string2)) {
            string2 = "unknown";
        }
        this.ap = new POPPhotoCheckupData(string, string2, null, null, null, null, true);
        av();
    }

    private void m11402a(PhotoCheckupManager photoCheckupManager, PrivacyCheckupAnalyticsLogger privacyCheckupAnalyticsLogger, TasksManager tasksManager, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, MultiRowAdapterBuilder multiRowAdapterBuilder, Lazy<PhotoPrivacyFeedHeaderPartDefinition> lazy, Lazy<PhotoPrivacyFeedRootPartDefinition> lazy2, PrivacyFeedMediaGalleryLauncherProvider privacyFeedMediaGalleryLauncherProvider, PrivacyFeedFeedbackLauncher privacyFeedFeedbackLauncher, Toaster toaster, MultiRowImagePrefetcherFactory multiRowImagePrefetcherFactory, HasPrefetcherImplProvider hasPrefetcherImplProvider, XConfigReader xConfigReader) {
        this.f11002a = photoCheckupManager;
        this.f11003b = privacyCheckupAnalyticsLogger;
        this.f11004c = tasksManager;
        this.f11005d = multipleRowsStoriesRecycleCallback;
        this.f11006e = multiRowAdapterBuilder;
        this.f11007f = lazy;
        this.f11008g = lazy2;
        this.f11009h = privacyFeedMediaGalleryLauncherProvider;
        this.f11010i = privacyFeedFeedbackLauncher;
        this.al = toaster;
        this.am = multiRowImagePrefetcherFactory;
        this.an = hasPrefetcherImplProvider;
        this.ao = xConfigReader;
    }

    public final void m11416e(Bundle bundle) {
        super.e(bundle);
        bundle.putSerializable("pending_privacy_edits", this.aw);
        if (this.ax != null) {
            bundle.putString("last_selected_privacy", this.ax);
        }
        bundle.putBoolean("has_prompted_bulk_edit", this.az);
        if (this.aA != null) {
            FlatBufferModelHelper.a(bundle, "locked_privacy", this.aA);
        }
    }

    public final void m11410a(View view, Bundle bundle) {
        this.aw = new HashMap();
        this.ax = null;
        this.ay = 0;
        this.az = false;
        this.aA = null;
        if (bundle != null) {
            if (bundle.containsKey("pending_privacy_edits")) {
                this.aw = (HashMap) bundle.getSerializable("pending_privacy_edits");
            }
            this.ax = bundle.getString("last_selected_privacy", null);
            this.az = bundle.getBoolean("has_prompted_bulk_edit", false);
            if (bundle.containsKey("locked_privacy")) {
                this.aA = (PrivacyOptionFieldsWithExplanation) FlatBufferModelHelper.a(bundle, "locked_privacy");
            }
        }
        BetterRecyclerView betterRecyclerView = (BetterRecyclerView) e(2131566175);
        betterRecyclerView.setLayoutManager(new LayoutManagerWithKeepAttachedHack(betterRecyclerView));
        this.aq = new RecyclerViewProxy(betterRecyclerView);
        this.aq.a(this.at);
        this.aq.a(this.f11005d.a());
        this.av = new C13085(this);
        au(this);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 941610700);
        this.f11004c.c(Tasks.FETCH_PHOTOS);
        if (!this.aw.isEmpty()) {
            this.f11002a.m11459a(this.aw, null);
            this.aw.clear();
        }
        super.mY_();
        if (this.as != null) {
            this.as.jc_();
            this.as = null;
        }
        if (this.ar != null) {
            this.ar.jc_();
            this.ar = null;
        }
        this.at = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1316822041, a);
    }

    public final void m11404G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -437108450);
        super.G();
        this.au.a(this.aq);
        this.aq.b(this.au.a());
        this.aq.b(this.av);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1310294252, a);
    }

    public final void m11405H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1507790757);
        super.H();
        this.au.b();
        this.aq.c(this.au.a());
        this.aq.c(this.av);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1520078935, a);
    }

    public final String as() {
        return PhotoAnimationDialogFragment.ao;
    }

    @Nullable
    public final String m11415e() {
        return null;
    }

    public final boolean m11413a(3 3) {
        return true;
    }

    public final DrawingRule m11407a(Drawable drawable, Rect rect) {
        return null;
    }

    public final PrivacyOptionFieldsWithExplanation mo289a() {
        return this.aA;
    }

    public static void au(PerObjectPrivacyPhotoCheckupFragment perObjectPrivacyPhotoCheckupFragment) {
        final int dimensionPixelSize = perObjectPrivacyPhotoCheckupFragment.getContext().getResources().getDimensionPixelSize(2131434459);
        perObjectPrivacyPhotoCheckupFragment.f11004c.a(Tasks.FETCH_PHOTOS, new Callable<ListenableFuture>(perObjectPrivacyPhotoCheckupFragment) {
            final /* synthetic */ PerObjectPrivacyPhotoCheckupFragment f10998b;

            public Object call() {
                ListenableFuture a;
                PhotoCheckupManager photoCheckupManager = this.f10998b.f11002a;
                int i = dimensionPixelSize;
                POPPhotoCheckupData pOPPhotoCheckupData = this.f10998b.ap;
                String str = pOPPhotoCheckupData.f11062g;
                if (str == null) {
                    PrivacyCheckupClient privacyCheckupClient = photoCheckupManager.f11074a;
                    String str2 = pOPPhotoCheckupData.f11056a;
                    GraphQLRequest a2 = GraphQLRequest.a(new FetchProfilePhotoCheckupQueryString());
                    GraphQlQueryString a3 = new FetchProfilePhotoCheckupQueryString().a("first_count", String.valueOf(10)).a("cover_photo_height", Integer.valueOf(i)).a("cover_photo_width", Integer.valueOf(i)).a("checkup_type", str2).a("header_scale", GraphQlQueryDefaults.a());
                    privacyCheckupClient.f4549b.a(a3);
                    privacyCheckupClient.f4550c.a(a3);
                    privacyCheckupClient.f4551d.a(a3);
                    a2.a(a3.a);
                    a = Futures.a(privacyCheckupClient.f4548a.a(a2), new GraphQLProfilePhotoToCheckupDataTransform(pOPPhotoCheckupData), photoCheckupManager.f11077d);
                } else {
                    a = Futures.a(photoCheckupManager.f11074a.m5811a(pOPPhotoCheckupData.f11056a, str, 10), new GraphQLMorePhotosToCheckupDataTransform(pOPPhotoCheckupData), photoCheckupManager.f11077d);
                }
                return a;
            }
        }, perObjectPrivacyPhotoCheckupFragment.aF);
    }

    private void av() {
        this.au = this.am.a();
        C13107 c13107 = new C13107(this);
        PrivacyFeedMediaGalleryLauncherProvider privacyFeedMediaGalleryLauncherProvider = this.f11009h;
        PhotoPrivacyFeedEnvironment photoPrivacyFeedEnvironment = new PhotoPrivacyFeedEnvironment(getContext(), new C13118(this), PhotoPrivacyFeedListType.f11049a, this.an.a(this.au), new PrivacyFeedMediaGalleryLauncher(SnowflakeMediaGalleryHelper.b(privacyFeedMediaGalleryLauncherProvider), getContext(), null), this.f11010i, this);
        Builder a = this.f11006e.a(MultiRowGroupPartDefinitions.a(this.f11007f), this.aC);
        a.f = photoPrivacyFeedEnvironment;
        this.ar = a.e();
        a = this.f11006e.a(this.f11008g, this.aD);
        a.f = photoPrivacyFeedEnvironment;
        Builder builder = a;
        builder.d = new ListItemCollectionWithFeedEnd(builder.c, c13107, true);
        this.as = builder.e();
        this.au.a(this.as.f());
        this.at = MultiAdapterListAdapter.a(new FbListAdapter[]{this.ar, this.as});
    }

    public static int aw(PerObjectPrivacyPhotoCheckupFragment perObjectPrivacyPhotoCheckupFragment) {
        if (perObjectPrivacyPhotoCheckupFragment.ap.f11058c == null) {
            return 0;
        }
        return perObjectPrivacyPhotoCheckupFragment.ap.f11058c.size();
    }

    public static void ax(PerObjectPrivacyPhotoCheckupFragment perObjectPrivacyPhotoCheckupFragment) {
        if (!perObjectPrivacyPhotoCheckupFragment.aB) {
            perObjectPrivacyPhotoCheckupFragment.as.notifyDataSetChanged();
        }
    }

    public final void mo291a(String str, final PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation) {
        this.ap.f11059d.put(str, privacyOptionFieldsWithExplanation);
        this.aw.put(str, privacyOptionFieldsWithExplanation);
        if (this.f11002a.m11459a(this.aw, this.aE)) {
            this.aw.clear();
        }
        if (Objects.equal(privacyOptionFieldsWithExplanation.c(), this.ax)) {
            this.ay++;
        } else {
            this.ax = privacyOptionFieldsWithExplanation.c();
            this.ay = 1;
        }
        int a = this.ao.a(PhotoPrivacyFeedXConfig.c, 1000);
        if (aw(this) >= this.ao.a(PhotoPrivacyFeedXConfig.d, 2000) && this.ay == a && !this.az) {
            this.az = true;
            new FbAlertDialogBuilder(getContext()).a(a(2131242320, new Object[]{privacyOptionFieldsWithExplanation.d()})).b(a(2131242321, new Object[]{privacyOptionFieldsWithExplanation.d()})).a(2131242322, new OnClickListener(this, null) {
                final /* synthetic */ PerObjectPrivacyPhotoCheckupFragment f10991c;

                public void onClick(DialogInterface dialogInterface, int i) {
                    this.f10991c.f11003b.m11466a(ReviewType.PROFILE_PHOTO_CHECKUP.reviewType, PhotoCheckupEvent.PHOTO_CHECKUP_BULK_EDIT_ACCEPTED.eventName);
                    this.f10991c.f11002a.m11458a(null, BulkEditCaller.PROFILE_PHOTO_CHECKUP, BulkEditAlbumType.PROFILE_PHOTO_ALBUM, privacyOptionFieldsWithExplanation.c(), this.f10991c.aE);
                    Activity ao = this.f10991c.ao();
                    if (ao != null) {
                        ao.finish();
                        this.f10991c.al.a(new ToastBuilder(2131242324));
                    }
                }
            }).b(2131242323, new C13129(this)).a().show();
        }
    }

    public final void mo292a(boolean z) {
        this.aB = z;
        if (!z) {
            ax(this);
        }
    }

    public final PrivacyOptionFieldsWithExplanation mo290a(String str) {
        return (PrivacyOptionFieldsWithExplanation) this.ap.f11059d.get(str);
    }
}
