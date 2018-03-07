package com.facebook.photos.pandora.ui;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.profile.TimelinePhotoTabModeParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albums.ProfilePicCoverPhotoEditHelper;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.PhotoFlowLogger;
import com.facebook.photos.base.analytics.photostab.PhotosUploadedBaseParams;
import com.facebook.photos.base.photos.PhotoFetchInfo;
import com.facebook.photos.base.photos.PhotoFetchInfo.FetchCause;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.DeletePhotoEventSubscriber;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.facebook.photos.pandora.common.data.SimplePandoraInstanceId;
import com.facebook.photos.pandora.common.events.PandoraEventBus;
import com.facebook.photos.pandora.common.events.PandoraEvents.LaunchConsumptionGalleryEvent;
import com.facebook.photos.pandora.common.futures.photocollage.PandoraPhotoCollageFetchPhotosFutureGenerator;
import com.facebook.photos.pandora.common.source.PandoraRequestSource;
import com.facebook.photos.pandora.common.ui.feedadapter.PandoraBasicFeedAdapter;
import com.facebook.photos.pandora.common.ui.renderer.configs.PandoraRendererConfiguration;
import com.facebook.photos.pandora.common.ui.renderer.configs.PandoraRendererGridConfiguration;
import com.facebook.photos.pandora.common.ui.views.PandoraBennyLoadingSpinnerView;
import com.facebook.photos.pandora.logging.PandoraSequenceLogger;
import com.facebook.photos.pandora.ui.listview.PandoraFeedListView;
import com.facebook.photos.photoset.controllers.FbPhotoPickerController;
import com.facebook.photos.photoset.launcher.PhotoSetConsumptionGalleryPhotoLauncher;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: dom_content_loaded_ms */
public abstract class PandoraPhotoCollageFragment extends FbFragment {
    public PandoraInstanceId f15182a;
    @Inject
    Lazy<ConsumptionPhotoEventBus> al;
    @Inject
    Lazy<PandoraRendererGridConfiguration> am;
    public PandoraPhotoCollageAdapter an;
    public String ao;
    public PandoraBennyLoadingSpinnerView ap;
    public TextView aq;
    public TimelinePhotoTabModeParams ar;
    public CallerContext as;
    private boolean at;
    private LaunchConsumptionGalleryEventSubscriber au = new LaunchConsumptionGalleryEventSubscriber(this);
    private final PhotoCollageDataSetObserver av = mo911e();
    private final PhotoDeleteSubscriber aw = new PhotoDeleteSubscriber(this);
    @Inject
    Lazy<PhotoSetConsumptionGalleryPhotoLauncher> f15183b;
    @Inject
    @LoggedInUserId
    public String f15184c;
    @Inject
    PandoraPhotoCollageAdapterProvider f15185d;
    @Inject
    Lazy<PandoraEventBus> f15186e;
    @Inject
    public Lazy<PhotoFlowLogger> f15187f;
    @Inject
    Lazy<ProfilePicCoverPhotoEditHelper> f15188g;
    @Inject
    Lazy<FbPhotoPickerController> f15189h;
    @Inject
    PandoraSequenceLogger f15190i;

    /* compiled from: dom_content_loaded_ms */
    public class PhotoCollageDataSetObserver extends DataSetObserver {
        final /* synthetic */ PandoraPhotoCollageFragment f15180a;

        protected PhotoCollageDataSetObserver(PandoraPhotoCollageFragment pandoraPhotoCollageFragment) {
            this.f15180a = pandoraPhotoCollageFragment;
        }

        public void onChanged() {
            int i;
            TextView textView = this.f15180a.aq;
            if (this.f15180a.aq()) {
                i = 8;
            } else {
                i = 0;
            }
            textView.setVisibility(i);
            this.f15180a.ap.setVisibility(8);
        }
    }

    /* compiled from: dom_content_loaded_ms */
    class LaunchConsumptionGalleryEventSubscriber extends com.facebook.photos.pandora.common.events.PandoraEvents.LaunchConsumptionGalleryEventSubscriber {
        final /* synthetic */ PandoraPhotoCollageFragment f17670a;

        public LaunchConsumptionGalleryEventSubscriber(PandoraPhotoCollageFragment pandoraPhotoCollageFragment) {
            this.f17670a = pandoraPhotoCollageFragment;
        }

        public final void m21648b(FbEvent fbEvent) {
            LaunchConsumptionGalleryEvent launchConsumptionGalleryEvent = (LaunchConsumptionGalleryEvent) fbEvent;
            if (launchConsumptionGalleryEvent != null && !Strings.isNullOrEmpty(launchConsumptionGalleryEvent.f17374a) && this.f17670a.f15182a.equals(launchConsumptionGalleryEvent.f17376c) && launchConsumptionGalleryEvent.f17377d == PandoraRequestSource.UPLOADED_MEDIA_SET) {
                PhotoFetchInfo photoFetchInfo = new PhotoFetchInfo(FetchCause.USER_INITIATED, this.f17670a.as);
                if (((FbPhotoPickerController) this.f17670a.f15189h.get()).f17782a) {
                    ((ProfilePicCoverPhotoEditHelper) this.f17670a.f15188g.get()).a(Long.parseLong(launchConsumptionGalleryEvent.f17374a), launchConsumptionGalleryEvent.f17375b, this.f17670a, photoFetchInfo, false);
                } else if (((FbPhotoPickerController) this.f17670a.f15189h.get()).f17783b) {
                    ((ProfilePicCoverPhotoEditHelper) this.f17670a.f15188g.get()).a(Long.parseLong(launchConsumptionGalleryEvent.f17374a), launchConsumptionGalleryEvent.f17375b, this.f17670a, photoFetchInfo, true);
                } else {
                    if (!(this.f17670a.ar == null || launchConsumptionGalleryEvent.f17378e == null)) {
                        if (this.f17670a.ar.d()) {
                            ((ProfilePicCoverPhotoEditHelper) this.f17670a.f15188g.get()).a(launchConsumptionGalleryEvent.f17378e, this.f17670a.o(), Long.parseLong(this.f17670a.f15184c));
                            return;
                        } else if (this.f17670a.ar.c()) {
                            ((ProfilePicCoverPhotoEditHelper) this.f17670a.f15188g.get()).a(launchConsumptionGalleryEvent.f17378e, this.f17670a.ao());
                            return;
                        }
                    }
                    PandoraPhotoCollageFragment pandoraPhotoCollageFragment = this.f17670a;
                    String str = launchConsumptionGalleryEvent.f17374a;
                    Uri uri = launchConsumptionGalleryEvent.f17375b;
                    if (!(Strings.isNullOrEmpty(str) || pandoraPhotoCollageFragment.an == null)) {
                        pandoraPhotoCollageFragment.mo908a(str, uri);
                    }
                }
            }
        }
    }

    /* compiled from: dom_content_loaded_ms */
    class PhotoDeleteSubscriber extends DeletePhotoEventSubscriber {
        final /* synthetic */ PandoraPhotoCollageFragment f17671a;

        public PhotoDeleteSubscriber(PandoraPhotoCollageFragment pandoraPhotoCollageFragment) {
            this.f17671a = pandoraPhotoCollageFragment;
        }

        public final void m21649b(FbEvent fbEvent) {
            if (this.f17671a.an != null) {
                PandoraBasicFeedAdapter pandoraBasicFeedAdapter = this.f17671a.an;
                pandoraBasicFeedAdapter.m21437i();
                pandoraBasicFeedAdapter.f17461m = true;
                pandoraBasicFeedAdapter.mo1054d();
            }
        }
    }

    public static void m17623a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PandoraPhotoCollageFragment) obj).m17622a(IdBasedLazy.a(injectorLike, 9409), String_LoggedInUserIdMethodAutoProvider.b(injectorLike), (PandoraPhotoCollageAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PandoraPhotoCollageAdapterProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 9375), IdBasedLazy.a(injectorLike, 9251), IdBasedLazy.a(injectorLike, 9245), IdBasedLazy.a(injectorLike, 9406), PandoraSequenceLogger.m21549a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2971), IdBasedLazy.a(injectorLike, 9385));
    }

    public abstract void mo908a(String str, @Nullable Uri uri);

    protected abstract PandoraPhotoCollageFetchPhotosFutureGenerator mo909b();

    public void mo910c(Bundle bundle) {
        String str;
        super.c(bundle);
        Class cls = PandoraPhotoCollageFragment.class;
        m17623a((Object) this, getContext());
        e(true);
        if (Strings.isNullOrEmpty(this.s.getString("profileId"))) {
            str = this.f15184c;
        } else {
            str = this.s.getString("profileId");
        }
        this.ao = str;
        this.f15182a = (PandoraInstanceId) this.s.getParcelable("pandora_instance_id");
        this.at = this.s.getBoolean("isDefaultLandingPage", false);
        this.ar = (TimelinePhotoTabModeParams) this.s.getParcelable("extra_photo_tab_mode_params");
        ((FbPhotoPickerController) this.f15189h.get()).m21759a(o().getIntent());
        this.as = (CallerContext) this.s.getParcelable("callerContext");
        if (this.as == null) {
            this.as = CallerContext.a(PandoraPhotoCollageFragment.class);
        }
    }

    public final void m17624G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1713967996);
        super.G();
        ((PandoraEventBus) this.f15186e.get()).a(this.au);
        ((ConsumptionPhotoEventBus) this.al.get()).a(this.aw);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2077050269, a);
    }

    public final void m17625H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2056059202);
        super.H();
        ((PandoraEventBus) this.f15186e.get()).b(this.au);
        ((ConsumptionPhotoEventBus) this.al.get()).b(this.aw);
        ((ProfilePicCoverPhotoEditHelper) this.f15188g.get()).a();
        if (this.an != null) {
            String str;
            String str2 = this.ao;
            if (Long.parseLong(this.f15184c) > 0) {
                str = this.f15184c;
            } else {
                str = this.ao;
            }
            PhotosUploadedBaseParams photosUploadedBaseParams = new PhotosUploadedBaseParams(new ProfileViewerContext(str2, str, GraphQLFriendshipStatus.fromString(this.s.getString("friendship_status")), GraphQLSubscribeStatus.fromString(this.s.getString("subscribe_status"))).g().name(), this.ao, this.f15184c, this.an.f17457i.m21443c());
            ((DefaultPhotoFlowLogger) this.f15187f.get()).a(this.s.getString("session_id"));
            ((DefaultPhotoFlowLogger) this.f15187f.get()).a(photosUploadedBaseParams);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1162207991, a);
    }

    public void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 849866823);
        super.mY_();
        this.an.unregisterDataSetObserver(this.av);
        this.an.m21437i();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -475324571, a);
    }

    public View m17626a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -134301115);
        this.f15190i.m21551a("InflateUploadedMediaSetFragment");
        CustomFrameLayout customFrameLayout = new CustomFrameLayout(getContext());
        customFrameLayout.setBackgroundDrawable(new ColorDrawable(jW_().getColor(2131363277)));
        PandoraFeedListView pandoraFeedListView = new PandoraFeedListView(getContext());
        mo907a(pandoraFeedListView);
        pandoraFeedListView.setId(2131558616);
        this.an = this.f15185d.m21647a(mo909b(), Boolean.valueOf(this.s.getBoolean("pandora_two_views_row", false)), Boolean.valueOf(this.s.getBoolean("pandora_non_highlight_worthy_single_photo", false)), (PandoraRendererConfiguration) this.am.get());
        this.an.m21428a(this.ao, this.f15182a == null ? new SimplePandoraInstanceId(this.ao) : this.f15182a, "LoadScreenImagesUploads", this.at, true, false);
        this.an.registerDataSetObserver(this.av);
        PandoraAdapter pandoraAdapter = new PandoraAdapter(this.an);
        pandoraFeedListView.setAdapter(pandoraAdapter);
        pandoraFeedListView.f17748a = pandoraAdapter;
        customFrameLayout.addView(pandoraFeedListView, new LayoutParams(-1, -1));
        this.f15190i.m21553b("SpinnerUploadMediaFragment");
        this.ap = new PandoraBennyLoadingSpinnerView(getContext());
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        customFrameLayout.addView(this.ap, layoutParams);
        if (aq()) {
            this.ap.setVisibility(8);
            this.f15190i.m21553b("SpinnerUploadMediaFragment");
        }
        this.aq = m17629b(getContext());
        this.aq.setVisibility(8);
        layoutParams = new LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        customFrameLayout.addView(this.aq, layoutParams);
        this.f15190i.m21553b("InflateUploadedMediaSetFragment");
        LogUtils.f(263993483, a);
        return customFrameLayout;
    }

    protected TextView m17629b(Context context) {
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTextSize(0, jW_().getDimension(2131430953));
        textView.setText(jW_().getString(2131236726));
        textView.setTextColor(jW_().getColor(2131361974));
        textView.setBackgroundDrawable(new ColorDrawable(jW_().getColor(2131363277)));
        return textView;
    }

    protected void mo907a(ListView listView) {
    }

    protected PhotoCollageDataSetObserver mo911e() {
        return new PhotoCollageDataSetObserver(this);
    }

    public final boolean aq() {
        if (this.an == null || this.an.f17457i == null || this.an.f17457i.f17469a == null || this.an.f17457i.f17469a.isEmpty()) {
            return false;
        }
        return true;
    }

    private void m17622a(Lazy<PhotoSetConsumptionGalleryPhotoLauncher> lazy, String str, PandoraPhotoCollageAdapterProvider pandoraPhotoCollageAdapterProvider, Lazy<PandoraEventBus> lazy2, Lazy<PhotoFlowLogger> lazy3, Lazy<ProfilePicCoverPhotoEditHelper> lazy4, Lazy<FbPhotoPickerController> lazy5, PandoraSequenceLogger pandoraSequenceLogger, Lazy<ConsumptionPhotoEventBus> lazy6, Lazy<PandoraRendererGridConfiguration> lazy7) {
        this.f15183b = lazy;
        this.f15184c = str;
        this.f15185d = pandoraPhotoCollageAdapterProvider;
        this.f15186e = lazy2;
        this.f15187f = lazy3;
        this.f15188g = lazy4;
        this.f15189h = lazy5;
        this.f15190i = pandoraSequenceLogger;
        this.al = lazy6;
        this.am = lazy7;
    }
}
