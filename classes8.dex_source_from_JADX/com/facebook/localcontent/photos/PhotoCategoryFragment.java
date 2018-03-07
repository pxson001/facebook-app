package com.facebook.localcontent.photos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.calls.CategoryInputCategoryName;
import com.facebook.graphql.enums.GraphQLAvailablePhotoCategoryEnum;
import com.facebook.graphql.enums.GraphQLPhotosByCategoryEntryPoint;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.localcontent.constants.IsPhotosByCategoryUploadEnabled;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraPhotoCollageFetchPhotosFutureGenerator;
import com.facebook.photos.pandora.common.ui.renderer.PandoraRendererResult;
import com.facebook.photos.pandora.ui.PandoraPhotoCollageAdapter.PhotoCollageLoadingListener;
import com.facebook.photos.pandora.ui.PandoraPhotoCollageFragment;
import com.facebook.photos.pandora.ui.PandoraPhotoCollageFragment.PhotoCollageDataSetObserver;
import com.facebook.photos.photoset.launcher.PhotoSetConsumptionGalleryPhotoLauncher;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: double_tap_on_photo */
public class PhotoCategoryFragment extends PandoraPhotoCollageFragment {
    @Inject
    @IsPhotosByCategoryUploadEnabled
    Provider<TriState> f15191a;
    public UploadPhotoByCategoryView aA;
    @Inject
    PlacePhotoUploadHandler ar;
    @Inject
    public SecureContextHelper as;
    @Inject
    PhotoCategoryFetchPhotosFutureGenerator at;
    @Inject
    Lazy<PhotoSetConsumptionGalleryPhotoLauncher> au;
    private CategoryInputCategoryName av;
    private GraphQLPhotosByCategoryEntryPoint aw;
    private boolean ax;
    public String ay;
    private String az;

    /* compiled from: double_tap_on_photo */
    class C16561 implements PhotoCollageLoadingListener {
        final /* synthetic */ PhotoCategoryFragment f15178a;

        C16561(PhotoCategoryFragment photoCategoryFragment) {
            this.f15178a = photoCategoryFragment;
        }

        public final void mo904a() {
            PandoraPhotoCollageFragment pandoraPhotoCollageFragment = this.f15178a;
            pandoraPhotoCollageFragment.aA.setVisibility(0);
            if (!pandoraPhotoCollageFragment.aq()) {
                pandoraPhotoCollageFragment.aA.setPrimaryUploadMessage(pandoraPhotoCollageFragment.ay);
                pandoraPhotoCollageFragment.aA.setImageDrawable(pandoraPhotoCollageFragment.jW_().getDrawable(2130843829));
            }
        }

        public final void mo905a(PandoraRendererResult pandoraRendererResult) {
        }
    }

    /* compiled from: double_tap_on_photo */
    class C16572 implements OnClickListener {
        final /* synthetic */ PhotoCategoryFragment f15179a;

        C16572(PhotoCategoryFragment photoCategoryFragment) {
            this.f15179a = photoCategoryFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -471564274);
            PhotoCategoryFragment photoCategoryFragment = this.f15179a;
            photoCategoryFragment.as.a(SimplePickerIntent.a(photoCategoryFragment.getContext(), new Builder(SimplePickerSource.PHOTOS_BY_CATEGORY).k().i().a(Action.NONE)), 1, photoCategoryFragment);
            Logger.a(2, EntryType.UI_INPUT_END, -414272989, a);
        }
    }

    /* compiled from: double_tap_on_photo */
    class PhotoCategoryDataSetObserver extends PhotoCollageDataSetObserver {
        final /* synthetic */ PhotoCategoryFragment f15181b;

        public PhotoCategoryDataSetObserver(PhotoCategoryFragment photoCategoryFragment) {
            this.f15181b = photoCategoryFragment;
            super(photoCategoryFragment);
        }

        public void onChanged() {
            if (PhotoCategoryFragment.ar(this.f15181b)) {
                this.f15181b.ap.setVisibility(8);
            } else {
                super.onChanged();
            }
        }
    }

    public static void m17634a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PhotoCategoryFragment) obj).m17635a(IdBasedProvider.a(fbInjector, 702), new PlacePhotoUploadHandler(ResourcesMethodAutoProvider.a(fbInjector), Toaster.b(fbInjector), UploadManager.a(fbInjector), UploadOperationFactory.b(fbInjector)), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), PhotoCategoryFetchPhotosFutureGenerator.m17615a(fbInjector), IdBasedLazy.a(fbInjector, 9409));
    }

    public final void mo910c(Bundle bundle) {
        super.mo910c(bundle);
        Class cls = PhotoCategoryFragment.class;
        m17634a((Object) this, getContext());
        this.av = (CategoryInputCategoryName) this.s.getSerializable("photo_category");
        this.aw = (GraphQLPhotosByCategoryEntryPoint) this.s.getSerializable("local_content_entry_point");
        this.ax = this.s.getBoolean("local_content_photo_upload_enabled");
        this.ay = this.s.getString("local_content_upload_message");
        if (Strings.isNullOrEmpty(this.ay)) {
            this.ay = b(2131239136);
        }
        this.az = this.s.getString("local_content_secondary_upload_message");
    }

    public final void m17637a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        if (ar(this) && this.aA != null) {
            this.an.m21640a(new C16561(this));
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 4717147);
        super.mY_();
        this.an.m21640a(null);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2129960279, a);
    }

    public final void m17636a(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 1) {
            PlacePhotoUploadHandler placePhotoUploadHandler = this.ar;
            long parseLong = Long.parseLong(this.ao);
            Collection parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_media_items");
            if (parcelableArrayListExtra != null) {
                UploadOperation a = placePhotoUploadHandler.f15222d.a(ImmutableList.copyOf(parcelableArrayListExtra), parseLong, SafeUUIDGenerator.a().toString());
                placePhotoUploadHandler.f15220b.a(new ToastBuilder(placePhotoUploadHandler.f15219a.getString(2131239105)));
                placePhotoUploadHandler.f15221c.a(a);
            }
        }
    }

    private void m17635a(Provider<TriState> provider, PlacePhotoUploadHandler placePhotoUploadHandler, SecureContextHelper secureContextHelper, PhotoCategoryFetchPhotosFutureGenerator photoCategoryFetchPhotosFutureGenerator, Lazy<PhotoSetConsumptionGalleryPhotoLauncher> lazy) {
        this.f15191a = provider;
        this.ar = placePhotoUploadHandler;
        this.as = secureContextHelper;
        this.at = photoCategoryFetchPhotosFutureGenerator;
        this.au = lazy;
    }

    public static PhotoCategoryFragment m17633a(int i, @Nullable GraphQLPhotosByCategoryEntryPoint graphQLPhotosByCategoryEntryPoint, String str, boolean z, GraphQLAvailablePhotoCategoryEnum graphQLAvailablePhotoCategoryEnum, boolean z2, String str2, String str3, CallerContext callerContext) {
        PhotoCategoryFragment photoCategoryFragment = new PhotoCategoryFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("local_content_entry_point", graphQLPhotosByCategoryEntryPoint);
        bundle.putString("profileId", str);
        CategoryInputCategoryName valueOf = CategoryInputCategoryName.valueOf(graphQLAvailablePhotoCategoryEnum.name());
        bundle.putParcelable("pandora_instance_id", new PhotosByCategoryPandoraInstanceId(str, i, valueOf, graphQLPhotosByCategoryEntryPoint));
        bundle.putBoolean("isDefaultLandingPage", z);
        bundle.putParcelable("callerContext", callerContext);
        bundle.putSerializable("photo_category", valueOf);
        bundle.putBoolean("local_content_photo_upload_enabled", z2);
        bundle.putString("local_content_upload_message", str2);
        bundle.putString("local_content_secondary_upload_message", str3);
        bundle.putBoolean("pandora_two_views_row", true);
        bundle.putBoolean("pandora_non_highlight_worthy_single_photo", true);
        photoCategoryFragment.g(bundle);
        return photoCategoryFragment;
    }

    protected final PandoraPhotoCollageFetchPhotosFutureGenerator mo909b() {
        return this.at;
    }

    protected final void mo908a(String str, @Nullable Uri uri) {
        ((PhotoSetConsumptionGalleryPhotoLauncher) this.au.get()).m21770a(ao(), this.ao, this.av, this.aw.name(), str, uri, this.an.f17457i.m21444d(), FullscreenGallerySource.PHOTOS_BY_CATEGORY, false);
    }

    protected final void mo907a(ListView listView) {
        if (ar(this)) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(listView.getContext()).inflate(2130906222, listView, false);
            this.aA = (UploadPhotoByCategoryView) frameLayout.findViewById(2131565945);
            this.aA.setVisibility(8);
            this.aA.setSecondaryUploadMessage(this.az);
            this.aA.setUploadButtonOnClickListener(new C16572(this));
            listView.addFooterView(frameLayout);
        }
    }

    protected final PhotoCollageDataSetObserver mo911e() {
        return new PhotoCategoryDataSetObserver(this);
    }

    public static boolean ar(PhotoCategoryFragment photoCategoryFragment) {
        return photoCategoryFragment.ax && ((TriState) photoCategoryFragment.f15191a.get()).asBoolean(false);
    }
}
