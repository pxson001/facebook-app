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
import android.widget.ListAdapter;
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
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.base.analytics.photostab.PhotosOfLoadingParams;
import com.facebook.photos.base.photos.PhotoFetchInfo;
import com.facebook.photos.base.photos.PhotoFetchInfo.FetchCause;
import com.facebook.photos.data.model.PhotoSet;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.PhotoTagOnChangeEventSubscriber;
import com.facebook.photos.pandora.common.events.PandoraEventBus;
import com.facebook.photos.pandora.common.events.PandoraEvents.LaunchConsumptionGalleryEvent;
import com.facebook.photos.pandora.common.source.PandoraRequestSource;
import com.facebook.photos.pandora.common.ui.views.PandoraBennyLoadingSpinnerView;
import com.facebook.photos.pandora.logging.PandoraSequenceLogger;
import com.facebook.photos.photoset.controllers.FbPhotoPickerController;
import com.facebook.photos.photoset.launcher.PhotoSetConsumptionGalleryPhotoLauncher;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: com.facebook.confirmation. */
public class PandoraTaggedPhotosFragment extends FbFragment {
    @Inject
    @LoggedInUserId
    public String f17733a;
    public String al;
    private String am;
    private String an;
    private boolean ao;
    public TimelinePhotoTabModeParams ap;
    public CallerContext aq;
    private CustomFrameLayout ar;
    public PandoraTaggedPhotosListView as;
    public PandoraBennyLoadingSpinnerView at;
    public TextView au;
    private LaunchConsumptionGalleryEventSubscriber av = new LaunchConsumptionGalleryEventSubscriber(this);
    private TagOnChangeEventSubscriber aw = new TagOnChangeEventSubscriber(this);
    private TaggedPhotoDataObserver ax = new TaggedPhotoDataObserver(this);
    @Inject
    Lazy<PandoraEventBus> f17734b;
    @Inject
    Lazy<ConsumptionPhotoEventBus> f17735c;
    @Inject
    public Lazy<PandoraTaggedPhotosMainAdapter> f17736d;
    @Inject
    Lazy<PhotoSetConsumptionGalleryPhotoLauncher> f17737e;
    @Inject
    public Lazy<PhotoFlowLogger> f17738f;
    @Inject
    Lazy<ProfilePicCoverPhotoEditHelper> f17739g;
    @Inject
    Lazy<FbPhotoPickerController> f17740h;
    @Inject
    PandoraSequenceLogger f17741i;

    /* compiled from: com.facebook.confirmation. */
    class LaunchConsumptionGalleryEventSubscriber extends com.facebook.photos.pandora.common.events.PandoraEvents.LaunchConsumptionGalleryEventSubscriber {
        final /* synthetic */ PandoraTaggedPhotosFragment f17730a;

        public LaunchConsumptionGalleryEventSubscriber(PandoraTaggedPhotosFragment pandoraTaggedPhotosFragment) {
            this.f17730a = pandoraTaggedPhotosFragment;
        }

        public final void m21706b(FbEvent fbEvent) {
            LaunchConsumptionGalleryEvent launchConsumptionGalleryEvent = (LaunchConsumptionGalleryEvent) fbEvent;
            if (launchConsumptionGalleryEvent != null && !Strings.isNullOrEmpty(launchConsumptionGalleryEvent.f17374a) && launchConsumptionGalleryEvent.f17377d == PandoraRequestSource.TAGGED_MEDIA_SET) {
                PhotoFetchInfo photoFetchInfo = new PhotoFetchInfo(FetchCause.USER_INITIATED, this.f17730a.aq);
                if (!(this.f17730a.ap == null || launchConsumptionGalleryEvent.f17378e == null)) {
                    if (this.f17730a.ap.d()) {
                        ((ProfilePicCoverPhotoEditHelper) this.f17730a.f17739g.get()).a(launchConsumptionGalleryEvent.f17378e, this.f17730a.o(), Long.parseLong(this.f17730a.f17733a));
                        return;
                    } else if (this.f17730a.ap.c()) {
                        ((ProfilePicCoverPhotoEditHelper) this.f17730a.f17739g.get()).a(launchConsumptionGalleryEvent.f17378e, this.f17730a.ao());
                        return;
                    }
                }
                if (((FbPhotoPickerController) this.f17730a.f17740h.get()).f17782a) {
                    ((ProfilePicCoverPhotoEditHelper) this.f17730a.f17739g.get()).a(Long.parseLong(launchConsumptionGalleryEvent.f17374a), launchConsumptionGalleryEvent.f17375b, this.f17730a, photoFetchInfo, false);
                } else if (((FbPhotoPickerController) this.f17730a.f17740h.get()).f17783b) {
                    ((ProfilePicCoverPhotoEditHelper) this.f17730a.f17739g.get()).a(Long.parseLong(launchConsumptionGalleryEvent.f17374a), launchConsumptionGalleryEvent.f17375b, this.f17730a, photoFetchInfo, true);
                } else {
                    PandoraTaggedPhotosFragment.m21709a(this.f17730a, launchConsumptionGalleryEvent.f17374a, launchConsumptionGalleryEvent.f17375b);
                }
            }
        }
    }

    /* compiled from: com.facebook.confirmation. */
    class TagOnChangeEventSubscriber extends PhotoTagOnChangeEventSubscriber {
        final /* synthetic */ PandoraTaggedPhotosFragment f17731a;

        public TagOnChangeEventSubscriber(PandoraTaggedPhotosFragment pandoraTaggedPhotosFragment) {
            this.f17731a = pandoraTaggedPhotosFragment;
        }

        public final void m21707b(FbEvent fbEvent) {
            ((PandoraTaggedPhotosMainAdapter) this.f17731a.f17736d.get()).m21718d().m21437i();
            this.f17731a.as.setVisibility(8);
            this.f17731a.at.setVisibility(0);
            ((PandoraTaggedPhotosMainAdapter) this.f17731a.f17736d.get()).m21718d().mo1054d();
        }
    }

    /* compiled from: com.facebook.confirmation. */
    class TaggedPhotoDataObserver extends DataSetObserver {
        final /* synthetic */ PandoraTaggedPhotosFragment f17732a;

        public TaggedPhotoDataObserver(PandoraTaggedPhotosFragment pandoraTaggedPhotosFragment) {
            this.f17732a = pandoraTaggedPhotosFragment;
        }

        public void onChanged() {
            int i;
            int i2 = 8;
            TextView textView = this.f17732a.au;
            if (PandoraTaggedPhotosFragment.aq(this.f17732a)) {
                i = 8;
            } else {
                i = 0;
            }
            textView.setVisibility(i);
            this.f17732a.at.setVisibility(8);
            PandoraTaggedPhotosListView pandoraTaggedPhotosListView = this.f17732a.as;
            if (PandoraTaggedPhotosFragment.aq(this.f17732a)) {
                i2 = 0;
            }
            pandoraTaggedPhotosListView.setVisibility(i2);
        }
    }

    public static void m21710a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PandoraTaggedPhotosFragment) obj).m21711a(String_LoggedInUserIdMethodAutoProvider.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9375), IdBasedSingletonScopeProvider.b(injectorLike, 2971), IdBasedLazy.a(injectorLike, 9402), IdBasedLazy.a(injectorLike, 9409), IdBasedLazy.a(injectorLike, 9251), IdBasedLazy.a(injectorLike, 9245), IdBasedLazy.a(injectorLike, 9406), PandoraSequenceLogger.m21549a(injectorLike));
    }

    private void m21711a(String str, Lazy<PandoraEventBus> lazy, Lazy<ConsumptionPhotoEventBus> lazy2, Lazy<PandoraTaggedPhotosMainAdapter> lazy3, Lazy<PhotoSetConsumptionGalleryPhotoLauncher> lazy4, Lazy<PhotoFlowLogger> lazy5, Lazy<ProfilePicCoverPhotoEditHelper> lazy6, Lazy<FbPhotoPickerController> lazy7, PandoraSequenceLogger pandoraSequenceLogger) {
        this.f17733a = str;
        this.f17734b = lazy;
        this.f17735c = lazy2;
        this.f17736d = lazy3;
        this.f17737e = lazy4;
        this.f17738f = lazy5;
        this.f17739g = lazy6;
        this.f17740h = lazy7;
        this.f17741i = pandoraSequenceLogger;
    }

    public static PandoraTaggedPhotosFragment m21708a(Bundle bundle, String str, String str2, CallerContext callerContext) {
        PandoraTaggedPhotosFragment pandoraTaggedPhotosFragment = new PandoraTaggedPhotosFragment();
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!Strings.isNullOrEmpty(str)) {
            bundle.putString("userId", str);
        }
        if (!Strings.isNullOrEmpty(str2)) {
            bundle.putString("userName", str2);
        }
        bundle.putParcelable("callerContext", callerContext);
        pandoraTaggedPhotosFragment.g(bundle);
        return pandoraTaggedPhotosFragment;
    }

    public final void m21715c(Bundle bundle) {
        super.c(bundle);
        Class cls = PandoraTaggedPhotosFragment.class;
        m21710a(this, getContext());
        if (this.s == null) {
            this.al = this.f17733a;
            return;
        }
        this.al = this.s.getString("userId");
        if (this.al == null) {
            this.al = this.f17733a;
        }
        this.am = this.s.getString("userName");
        this.aq = (CallerContext) this.s.getParcelable("callerContext");
        this.ap = (TimelinePhotoTabModeParams) this.s.getParcelable("extra_photo_tab_mode_params");
        ((FbPhotoPickerController) this.f17740h.get()).m21759a(o().getIntent());
        this.ao = true;
        this.an = PhotoSet.a(Long.parseLong(this.al));
    }

    public final View m21714a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Object obj;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 132276291);
        this.f17741i.m21551a("InflatePhotosOfFragment");
        this.ar = new CustomFrameLayout(getContext());
        this.ar.setBackgroundDrawable(new ColorDrawable(jW_().getColor(2131363277)));
        this.as = new PandoraTaggedPhotosListView(getContext());
        this.as.setId(2131558617);
        ((PandoraTaggedPhotosMainAdapter) this.f17736d.get()).m21716a(this.al, this.am, this.ao, true, false);
        this.as.setAdapter((ListAdapter) this.f17736d.get());
        this.ar.addView(this.as, new LayoutParams(-1, -1));
        this.f17741i.m21551a("SpinnerPhotosOfFragment");
        this.at = new PandoraBennyLoadingSpinnerView(getContext());
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.ar.addView(this.at, layoutParams);
        if (aq(this)) {
            this.at.setVisibility(8);
            this.f17741i.m21553b("SpinnerPhotosOfFragment");
        }
        this.au = new TextView(getContext());
        this.au.setGravity(17);
        this.au.setTextSize(0, jW_().getDimension(2131430953));
        this.au.setText(jW_().getString(2131236726));
        this.au.setTextColor(jW_().getColor(2131361974));
        this.au.setBackgroundDrawable(new ColorDrawable(jW_().getColor(2131363277)));
        layoutParams = new LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.ar.addView(this.au, layoutParams);
        if (((PandoraTaggedPhotosMainAdapter) this.f17736d.get()).m21718d() == null || !((PandoraTaggedPhotosMainAdapter) this.f17736d.get()).m21718d().f17461m) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null || aq(this)) {
            this.au.setVisibility(8);
        } else {
            this.au.setVisibility(0);
            this.as.setVisibility(8);
        }
        this.f17741i.m21553b("InflatePhotosOfFragment");
        CustomFrameLayout customFrameLayout = this.ar;
        LogUtils.f(-216935261, a);
        return customFrameLayout;
    }

    public final void m21712G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -491655231);
        super.G();
        ((PandoraEventBus) this.f17734b.get()).a(this.av);
        ((ConsumptionPhotoEventBus) this.f17735c.get()).a(this.aw);
        ((PandoraTaggedPhotosMainAdapter) this.f17736d.get()).m21718d().registerDataSetObserver(this.ax);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1385564955, a);
    }

    public final void m21713H() {
        String str;
        int i;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -360885023);
        super.H();
        ((PandoraEventBus) this.f17734b.get()).b(this.av);
        ((ConsumptionPhotoEventBus) this.f17735c.get()).b(this.aw);
        ((PandoraTaggedPhotosMainAdapter) this.f17736d.get()).m21718d().unregisterDataSetObserver(this.ax);
        ((ProfilePicCoverPhotoEditHelper) this.f17739g.get()).a();
        String str2 = this.al;
        if (Long.parseLong(this.f17733a) > 0) {
            str = this.f17733a;
        } else {
            str = this.al;
        }
        String name = new ProfileViewerContext(str2, str, GraphQLFriendshipStatus.fromString(this.s.getString("friendship_status")), GraphQLSubscribeStatus.fromString(this.s.getString("subscribe_status"))).g().name();
        String str3 = this.al;
        String str4 = this.f17733a;
        PandoraTaggedPhotosMainAdapter pandoraTaggedPhotosMainAdapter = (PandoraTaggedPhotosMainAdapter) this.f17736d.get();
        if (((PandoraTaggedPhotosAdapter) pandoraTaggedPhotosMainAdapter.f17745c.get()).f17457i == null) {
            i = 0;
        } else {
            i = ((PandoraTaggedPhotosAdapter) pandoraTaggedPhotosMainAdapter.f17745c.get()).f17457i.m21443c();
        }
        PhotosOfLoadingParams photosOfLoadingParams = new PhotosOfLoadingParams(name, str3, str4, i);
        ((DefaultPhotoFlowLogger) this.f17738f.get()).a(this.s.getString("session_id"));
        ((DefaultPhotoFlowLogger) this.f17738f.get()).a(photosOfLoadingParams);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1989344425, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -263054532);
        super.mY_();
        ((PandoraTaggedPhotosMainAdapter) this.f17736d.get()).m21718d().m21437i();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 420160685, a);
    }

    public static void m21709a(PandoraTaggedPhotosFragment pandoraTaggedPhotosFragment, String str, Uri uri) {
        ((PhotoSetConsumptionGalleryPhotoLauncher) pandoraTaggedPhotosFragment.f17737e.get()).m21771a(pandoraTaggedPhotosFragment.ao(), pandoraTaggedPhotosFragment.an, str, uri, ((PandoraTaggedPhotosMainAdapter) pandoraTaggedPhotosFragment.f17736d.get()).m21717c().m21444d(), FullscreenGallerySource.TIMELINE_PHOTOS_OF_USER, false);
    }

    public static boolean aq(PandoraTaggedPhotosFragment pandoraTaggedPhotosFragment) {
        return (((PandoraTaggedPhotosMainAdapter) pandoraTaggedPhotosFragment.f17736d.get()).m21717c() == null || ((PandoraTaggedPhotosMainAdapter) pandoraTaggedPhotosFragment.f17736d.get()).m21717c().f17469a == null || ((PandoraTaggedPhotosMainAdapter) pandoraTaggedPhotosFragment.f17736d.get()).m21717c().f17469a.isEmpty()) ? false : true;
    }
}
