package com.facebook.photos.photoset.ui.photoset;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.ipc.profile.TimelinePhotoTabModeParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albums.AlbumSetPagedCollection;
import com.facebook.photos.albums.ProfilePicCoverPhotoEditHelper;
import com.facebook.photos.albums.protocols.MediasetQueryInterfaces.DefaultMediaSetMediaConnection;
import com.facebook.photos.albums.protocols.MediasetQueryModels.DefaultMediaSetMediaConnectionModel;
import com.facebook.photos.albums.protocols.MediasetType;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.base.photos.PhotoFetchInfo;
import com.facebook.photos.base.photos.PhotoFetchInfo.FetchCause;
import com.facebook.photos.futures.MediaSetFuturesGenerator;
import com.facebook.photos.photoset.controllers.AlbumHeaderSetupController;
import com.facebook.photos.photoset.controllers.FbPhotoPickerController;
import com.facebook.photos.photoset.launcher.PhotoSetConsumptionGalleryPhotoLauncher;
import com.facebook.photos.photoset.ui.SmoothedScrollAdapter;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: click_like_button */
public class PhotoSetGridFragment extends FbFragment {
    @Inject
    Lazy<TasksManager> f17934a;
    private String al;
    private GraphQLAlbum am;
    public AlbumSetPagedCollection an = new AlbumSetPagedCollection();
    public String ao;
    public CallerContext ap;
    public MediasetType aq = MediasetType.TAGGED_MEDIASET;
    public int ar;
    private FullscreenGallerySource as;
    @Inject
    Lazy<MediaSetFuturesGenerator> f17935b;
    @Inject
    Lazy<AlbumHeaderSetupController> f17936c;
    @Inject
    Lazy<PhotoSetConsumptionGalleryPhotoLauncher> f17937d;
    @Inject
    Lazy<FbPhotoPickerController> f17938e;
    @Inject
    @LoggedInUserId
    String f17939f;
    @Inject
    Lazy<ProfilePicCoverPhotoEditHelper> f17940g;
    public PhotoSetGridAdapter f17941h;
    public AbsListView f17942i;

    /* compiled from: click_like_button */
    public class C19341 implements Callable<ListenableFuture<DefaultMediaSetMediaConnection>> {
        final /* synthetic */ PhotoSetGridFragment f17929a;

        public C19341(PhotoSetGridFragment photoSetGridFragment) {
            this.f17929a = photoSetGridFragment;
        }

        public Object call() {
            return ((MediaSetFuturesGenerator) this.f17929a.f17935b.get()).a(this.f17929a.ao, null, this.f17929a.an.e, 40, this.f17929a.ar, this.f17929a.ar, this.f17929a.aq);
        }
    }

    /* compiled from: click_like_button */
    class C19352 extends AbstractDisposableFutureCallback<DefaultMediaSetMediaConnection> {
        final /* synthetic */ PhotoSetGridFragment f17930a;

        C19352(PhotoSetGridFragment photoSetGridFragment) {
            this.f17930a = photoSetGridFragment;
        }

        protected final void m21883a(Object obj) {
            DefaultMediaSetMediaConnectionModel defaultMediaSetMediaConnectionModel = (DefaultMediaSetMediaConnectionModel) obj;
            if (defaultMediaSetMediaConnectionModel != null) {
                AlbumSetPagedCollection albumSetPagedCollection = this.f17930a.an;
                if (!(defaultMediaSetMediaConnectionModel == null || defaultMediaSetMediaConnectionModel.b() == null || (!Strings.isNullOrEmpty(albumSetPagedCollection.e) && Objects.equal(albumSetPagedCollection.e, defaultMediaSetMediaConnectionModel.b().v_())))) {
                    albumSetPagedCollection.d = defaultMediaSetMediaConnectionModel.b().v_();
                    albumSetPagedCollection.e = defaultMediaSetMediaConnectionModel.b().a();
                    albumSetPagedCollection.b = defaultMediaSetMediaConnectionModel.b().b();
                    albumSetPagedCollection.c = defaultMediaSetMediaConnectionModel.b().c();
                    if (albumSetPagedCollection.a == null) {
                        albumSetPagedCollection.a = ImmutableList.copyOf(defaultMediaSetMediaConnectionModel.a());
                    } else {
                        albumSetPagedCollection.a = ImmutableList.builder().b(albumSetPagedCollection.a).b(defaultMediaSetMediaConnectionModel.a()).b();
                    }
                }
                AdapterDetour.a(this.f17930a.f17941h, 346689979);
                if (this.f17930a.f17941h.getCount() == 0) {
                    PhotoSetGridFragment.aq(this.f17930a);
                } else {
                    this.f17930a.f17942i.setVisibility(0);
                }
            }
        }

        protected final void m21884a(Throwable th) {
            if (this.f17930a.f17941h.getCount() != 0) {
                PhotoSetGridFragment photoSetGridFragment = this.f17930a;
                if (photoSetGridFragment.T != null) {
                    photoSetGridFragment.f17942i.setVisibility(8);
                    ((TextView) photoSetGridFragment.T.findViewById(2131561172)).setText(2131234389);
                    photoSetGridFragment.T.findViewById(16908292).setVisibility(0);
                    photoSetGridFragment.T.findViewById(2131561172).setVisibility(0);
                    photoSetGridFragment.T.findViewById(2131561173).setVisibility(8);
                    return;
                }
                return;
            }
            PhotoSetGridFragment.aq(this.f17930a);
        }
    }

    /* compiled from: click_like_button */
    /* synthetic */ class C19363 {
        static final /* synthetic */ int[] f17931a = new int[MediasetType.values().length];

        static {
            try {
                f17931a[MediasetType.MEDIASET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17931a[MediasetType.ALBUM_MEDIASET.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17931a[MediasetType.TAGGED_MEDIASET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f17931a[MediasetType.PHOTOS_TAKEN_HERE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f17931a[MediasetType.PHOTOS_TAKEN_OF.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f17931a[MediasetType.POSTED_PHOTOS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* compiled from: click_like_button */
    class ItemClickListener implements OnItemClickListener {
        final /* synthetic */ PhotoSetGridFragment f17932a;

        public ItemClickListener(PhotoSetGridFragment photoSetGridFragment) {
            this.f17932a = photoSetGridFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (j > 0 && this.f17932a.f17940g != null) {
                PhotoFetchInfo photoFetchInfo = new PhotoFetchInfo(FetchCause.USER_INITIATED, this.f17932a.ap);
                if (((FbPhotoPickerController) this.f17932a.f17938e.get()).f17782a) {
                    ((ProfilePicCoverPhotoEditHelper) this.f17932a.f17940g.get()).a(j, null, this.f17932a, photoFetchInfo, false);
                } else if (((FbPhotoPickerController) this.f17932a.f17938e.get()).f17783b) {
                    ((ProfilePicCoverPhotoEditHelper) this.f17932a.f17940g.get()).a(j, null, this.f17932a, photoFetchInfo, true);
                } else if (((AlbumHeaderSetupController) this.f17932a.f17936c.get()).m21753b()) {
                    ((ProfilePicCoverPhotoEditHelper) this.f17932a.f17940g.get()).a(j, this.f17932a, photoFetchInfo);
                } else if (((AlbumHeaderSetupController) this.f17932a.f17936c.get()).m21752a()) {
                    ((ProfilePicCoverPhotoEditHelper) this.f17932a.f17940g.get()).a(j, this.f17932a, Long.parseLong(this.f17932a.f17939f), photoFetchInfo);
                } else {
                    PhotoSetGridFragment.m21887a(this.f17932a, j);
                }
            }
        }
    }

    /* compiled from: click_like_button */
    class ScrollListener extends SmoothedScrollAdapter {
        final /* synthetic */ PhotoSetGridFragment f17933b;

        public ScrollListener(PhotoSetGridFragment photoSetGridFragment) {
            this.f17933b = photoSetGridFragment;
        }

        protected final void mo1062a(int i, int i2, int i3) {
            if (i + i2 > this.f17933b.f17941h.getCount() - 5 && i3 > 0) {
                PhotoSetGridFragment.m21889e(this.f17933b);
            }
        }
    }

    public static void m21888a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PhotoSetGridFragment) obj).m21886a(IdBasedLazy.a(fbInjector, 3561), IdBasedLazy.a(fbInjector, 9333), IdBasedLazy.a(fbInjector, 9405), IdBasedLazy.a(fbInjector, 9409), IdBasedLazy.a(fbInjector, 9406), String_LoggedInUserIdMethodAutoProvider.b(fbInjector), IdBasedLazy.a(fbInjector, 9245));
    }

    public final void m21891H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1662114404);
        this.f17942i.setEnabled(false);
        if (this.f17934a != null) {
            ((TasksManager) this.f17934a.get()).c();
        }
        if (this.f17940g != null) {
            ((ProfilePicCoverPhotoEditHelper) this.f17940g.get()).a();
        }
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1244427518, a);
    }

    public final void m21890G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1210128607);
        super.G();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131236723);
        }
        this.f17942i.setEnabled(true);
        m21889e(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1367723920, a);
    }

    public final View m21893a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1979877693);
        View inflate = ((Activity) getContext()).getLayoutInflater().inflate(2130906212, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1061416756, a);
        return inflate;
    }

    public final void m21894c(Bundle bundle) {
        super.c(bundle);
        Class cls = PhotoSetGridFragment.class;
        m21888a((Object) this, getContext());
    }

    public final void m21895d(Bundle bundle) {
        Bundle bundle2;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 887655229);
        super.d(bundle);
        this.f17942i = (AbsListView) this.T.findViewById(16908298);
        Bundle bundle3 = this.s;
        if (bundle3 == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle3;
        }
        this.f17941h = new PhotoSetGridAdapter(this.an);
        this.as = bundle2.containsKey("fullscreen_gallery_source") ? FullscreenGallerySource.valueOf(bundle2.getString("fullscreen_gallery_source")) : FullscreenGallerySource.TIMELINE_PHOTOS_OF_USER;
        this.ap = (CallerContext) bundle2.getParcelable("extra_caller_context");
        if (this.ap == null) {
            this.ap = CallerContext.a(PhotoSetGridFragment.class, "unknown");
        }
        Intent intent = o().getIntent();
        String stringExtra = intent.getStringExtra("owner_id");
        if (!Strings.isNullOrEmpty(stringExtra)) {
            this.ao = stringExtra;
        }
        this.aq = MediasetType.values()[intent.getIntExtra("mediaset_type", MediasetType.TAGGED_MEDIASET.ordinal())];
        TimelinePhotoTabModeParams timelinePhotoTabModeParams = (TimelinePhotoTabModeParams) bundle2.getParcelable("extra_photo_tab_mode_params");
        if (timelinePhotoTabModeParams != null) {
            this.ao = String.valueOf(timelinePhotoTabModeParams.b);
        }
        this.am = (GraphQLAlbum) FlatBufferModelHelper.a(bundle2, "extra_album_selected");
        this.al = bundle2.getString("set_token");
        if (this.am != null && !Strings.isNullOrEmpty(this.am.u())) {
            this.ao = this.am.u();
            this.aq = MediasetType.ALBUM_MEDIASET;
        } else if (!Strings.isNullOrEmpty(this.al) && this.ao == null) {
            this.ao = this.al;
            this.aq = MediasetType.MEDIASET;
        }
        if (Strings.isNullOrEmpty(this.ao)) {
            this.ao = this.f17939f;
        }
        if (bundle2.containsKey("mediaset_type") && bundle2.containsKey("owner_id")) {
            this.aq = MediasetType.values()[bundle2.getInt("mediaset_type")];
            this.ao = bundle2.getString("owner_id");
        }
        this.f17942i.setVisibility(8);
        ((AlbumHeaderSetupController) this.f17936c.get()).m21750a(this.am, timelinePhotoTabModeParams, e(2131559544), (FbTitleBar) o().findViewById(2131558563), this.ao, this.f17939f);
        if (11 <= VERSION.SDK_INT || !(this.f17942i instanceof GridView)) {
            this.f17942i.setAdapter(this.f17941h);
        } else {
            ((GridView) this.f17942i).setAdapter(this.f17941h);
        }
        this.f17942i.setOnScrollListener(new ScrollListener(this));
        this.f17942i.setClickable(true);
        this.f17942i.setOnItemClickListener(new ItemClickListener(this));
        this.f17942i.setVisibility(8);
        this.ar = jW_().getDimensionPixelSize(2131430936);
        LogUtils.f(-229302106, a);
    }

    public final void m21892I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -874799908);
        super.I();
        AlbumSetPagedCollection albumSetPagedCollection = this.an;
        albumSetPagedCollection.b = true;
        albumSetPagedCollection.c = false;
        albumSetPagedCollection.d = null;
        albumSetPagedCollection.e = null;
        albumSetPagedCollection.a = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1587917828, a);
    }

    public static void m21889e(PhotoSetGridFragment photoSetGridFragment) {
        if (photoSetGridFragment.an.b) {
            ((TasksManager) photoSetGridFragment.f17934a.get()).a("task-fetchMediaset", new C19341(photoSetGridFragment), new C19352(photoSetGridFragment));
        }
    }

    private void m21886a(Lazy<TasksManager> lazy, Lazy<MediaSetFuturesGenerator> lazy2, Lazy<AlbumHeaderSetupController> lazy3, Lazy<PhotoSetConsumptionGalleryPhotoLauncher> lazy4, Lazy<FbPhotoPickerController> lazy5, String str, Lazy<ProfilePicCoverPhotoEditHelper> lazy6) {
        this.f17934a = lazy;
        this.f17935b = lazy2;
        this.f17936c = lazy3;
        this.f17937d = lazy4;
        this.f17938e = lazy5;
        this.f17939f = str;
        this.f17940g = lazy6;
    }

    public static void aq(PhotoSetGridFragment photoSetGridFragment) {
        View view = photoSetGridFragment.T;
        if (view != null) {
            photoSetGridFragment.f17942i.setVisibility(8);
            ((TextView) view.findViewById(2131561172)).setText(2131234390);
            view.findViewById(16908292).setVisibility(0);
            view.findViewById(2131561172).setVisibility(0);
            view.findViewById(2131561173).setVisibility(8);
        }
    }

    public static void m21887a(PhotoSetGridFragment photoSetGridFragment, long j) {
        boolean booleanExtra = photoSetGridFragment.ao().getIntent().getBooleanExtra("extra_show_attribution", false);
        if (photoSetGridFragment.am != null) {
            ((PhotoSetConsumptionGalleryPhotoLauncher) photoSetGridFragment.f17937d.get()).m21767a(photoSetGridFragment.ao(), photoSetGridFragment.am, String.valueOf(j), null, photoSetGridFragment.an.a(), photoSetGridFragment.as, booleanExtra);
            return;
        }
        switch (C19363.f17931a[photoSetGridFragment.aq.ordinal()]) {
            case 1:
            case 2:
            case 3:
                ((PhotoSetConsumptionGalleryPhotoLauncher) photoSetGridFragment.f17937d.get()).m21771a(photoSetGridFragment.ao(), (String) Preconditions.checkNotNull(photoSetGridFragment.al), String.valueOf(j), null, photoSetGridFragment.an.a(), photoSetGridFragment.as, booleanExtra);
                return;
            case 4:
                ((PhotoSetConsumptionGalleryPhotoLauncher) photoSetGridFragment.f17937d.get()).m21772a(photoSetGridFragment.ao(), (String) Preconditions.checkNotNull(photoSetGridFragment.ao), String.valueOf(j), photoSetGridFragment.an.a(), photoSetGridFragment.as, booleanExtra);
                return;
            case 5:
                ((PhotoSetConsumptionGalleryPhotoLauncher) photoSetGridFragment.f17937d.get()).m21774b(photoSetGridFragment.ao(), (String) Preconditions.checkNotNull(photoSetGridFragment.ao), String.valueOf(j), photoSetGridFragment.an.a(), photoSetGridFragment.as, booleanExtra);
                return;
            case 6:
                ((PhotoSetConsumptionGalleryPhotoLauncher) photoSetGridFragment.f17937d.get()).m21773b(photoSetGridFragment.ao(), (String) Preconditions.checkNotNull(photoSetGridFragment.ao), String.valueOf(j), null, photoSetGridFragment.an.a(), photoSetGridFragment.as, booleanExtra);
                return;
            default:
                Object obj;
                Object obj2;
                String str = "unknown photoset: %s, objectId: %s, setToken: %s";
                String name = photoSetGridFragment.aq.name();
                if (photoSetGridFragment.ao != null) {
                    obj = photoSetGridFragment.ao;
                } else {
                    obj = "NULL";
                }
                if (photoSetGridFragment.al != null) {
                    obj2 = photoSetGridFragment.al;
                } else {
                    obj2 = "NULL";
                }
                Preconditions.checkState(false, StringFormatUtil.formatStrLocaleSafe(str, name, obj, obj2));
                return;
        }
    }
}
