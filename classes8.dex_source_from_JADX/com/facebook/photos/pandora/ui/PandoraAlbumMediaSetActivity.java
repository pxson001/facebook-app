package com.facebook.photos.pandora.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.event.FbEvent;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLAlbum.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.albums.events.AlbumsEvents.ToggleContributorsEvent;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.MediaGalleryFragmentVisibilityChangeEvent;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.MediaGalleryFragmentVisibilityChangeEventSubscriber;
import com.facebook.photos.pandora.logging.PandoraLoadedCounter;
import com.facebook.photos.pandora.ui.DialtonePhotosCoverFragment.PandoraType;
import com.facebook.photos.photoset.controllers.FbPhotoPickerController;
import com.facebook.photos.photoset.controllers.PhotoSetOnActivityResultController;
import com.facebook.photos.photoset.ui.contributors.AlbumPermalinkContributorsFragment;
import com.facebook.photos.photoset.ui.permalink.AlbumPermalinkTitleBarSupplier;
import com.facebook.platformattribution.result.PlatformAttributionResultController;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: com.facebook.pages.identity.fragments.timeline.PageIdentityPostsByOthersFragment */
public class PandoraAlbumMediaSetActivity extends FbFragmentActivity implements AnalyticsActivity, DialtoneStateChangedListener {
    private static final CallerContext f17599x = CallerContext.a(PandoraAlbumMediaSetActivity.class, "photos_album");
    @Inject
    AlbumPermalinkTitleBarSupplier f17600p;
    @Inject
    PandoraLoadedCounter f17601q;
    @Inject
    FbPhotoPickerController f17602r;
    @Inject
    Lazy<AlbumsEventBus> f17603s;
    @Inject
    Lazy<PhotoSetOnActivityResultController> f17604t;
    @Inject
    PlatformAttributionResultController f17605u;
    @Inject
    Lazy<ConsumptionPhotoEventBus> f17606v;
    @Inject
    DialtoneController f17607w;
    private final ToggleContributorsEventSubscriber f17608y = new ToggleContributorsEventSubscriber(this);
    private MediaGalleryFragmentVisibilityChangeEventSubscriber f17609z;

    /* compiled from: com.facebook.pages.identity.fragments.timeline.PageIdentityPostsByOthersFragment */
    class C18681 implements OnClickListener {
        final /* synthetic */ PandoraAlbumMediaSetActivity f17595a;

        C18681(PandoraAlbumMediaSetActivity pandoraAlbumMediaSetActivity) {
            this.f17595a = pandoraAlbumMediaSetActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -576513339);
            this.f17595a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1319940734, a);
        }
    }

    /* compiled from: com.facebook.pages.identity.fragments.timeline.PageIdentityPostsByOthersFragment */
    class ToggleContributorsEventSubscriber extends com.facebook.photos.albums.events.AlbumsEvents.ToggleContributorsEventSubscriber {
        final /* synthetic */ PandoraAlbumMediaSetActivity f17598a;

        public ToggleContributorsEventSubscriber(PandoraAlbumMediaSetActivity pandoraAlbumMediaSetActivity) {
            this.f17598a = pandoraAlbumMediaSetActivity;
        }

        public final void m21567b(FbEvent fbEvent) {
            this.f17598a.m21569a(((ToggleContributorsEvent) fbEvent).a);
        }
    }

    private static <T extends Context> void m21573a(Class<T> cls, T t) {
        m21574a((Object) t, (Context) t);
    }

    public static void m21574a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PandoraAlbumMediaSetActivity) obj).m21572a(AlbumPermalinkTitleBarSupplier.m21788a(injectorLike), PandoraLoadedCounter.m21547a(injectorLike), FbPhotoPickerController.m21757a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9247), IdBasedLazy.a(injectorLike, 9408), PlatformAttributionResultController.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2971), (DialtoneController) DialtoneControllerImpl.a(injectorLike));
    }

    private void m21572a(AlbumPermalinkTitleBarSupplier albumPermalinkTitleBarSupplier, PandoraLoadedCounter pandoraLoadedCounter, FbPhotoPickerController fbPhotoPickerController, Lazy<AlbumsEventBus> lazy, Lazy<PhotoSetOnActivityResultController> lazy2, PlatformAttributionResultController platformAttributionResultController, Lazy<ConsumptionPhotoEventBus> lazy3, DialtoneController dialtoneController) {
        this.f17600p = albumPermalinkTitleBarSupplier;
        this.f17601q = pandoraLoadedCounter;
        this.f17602r = fbPhotoPickerController;
        this.f17603s = lazy;
        this.f17604t = lazy2;
        this.f17605u = platformAttributionResultController;
        this.f17606v = lazy3;
        this.f17607w = dialtoneController;
    }

    public final void m21577b(Bundle bundle) {
        super.b(bundle);
        Class cls = PandoraAlbumMediaSetActivity.class;
        m21574a((Object) this, (Context) this);
        setContentView(2130903233);
        if (FbTitleBarUtil.b(this)) {
            FbTitleBar fbTitleBar = (FbTitleBar) findViewById(2131558563);
            fbTitleBar.setHasBackButton(false);
            fbTitleBar.a(new C18681(this));
            this.f17600p.f17823a = fbTitleBar;
        }
        if (bundle == null) {
            if (this.f17601q != null) {
                this.f17601q.f17578c = 0;
            }
            this.f17602r.m21759a(getIntent());
            final int requestedOrientation = getRequestedOrientation();
            this.f17609z = new MediaGalleryFragmentVisibilityChangeEventSubscriber(this) {
                final /* synthetic */ PandoraAlbumMediaSetActivity f17597b;

                public final void m21566b(FbEvent fbEvent) {
                    PandoraAlbumMediaSetActivity.m21575b(this.f17597b, ((MediaGalleryFragmentVisibilityChangeEvent) fbEvent).a ? 13 : requestedOrientation);
                }
            };
            m21576i();
        }
    }

    private void m21576i() {
        Fragment a;
        GraphQLAlbum graphQLAlbum = (GraphQLAlbum) FlatBufferModelHelper.a(getIntent(), "extra_album_selected");
        String stringExtra = getIntent().getStringExtra("extra_album_id");
        if (graphQLAlbum != null) {
            a = m21568a(graphQLAlbum, getIntent().getExtras());
        } else {
            Builder builder = new Builder();
            builder.o = stringExtra;
            graphQLAlbum = builder.a();
            Bundle extras = getIntent().getExtras();
            FlatBufferModelHelper.a(extras, "extra_album_selected", graphQLAlbum);
            a = m21568a(graphQLAlbum, extras);
        }
        kO_().a().b(2131558429, a, "PandoraAlbumFragment").b();
    }

    private FbFragment m21568a(GraphQLAlbum graphQLAlbum, Bundle bundle) {
        if (this.f17607w.j()) {
            return DialtonePhotosCoverFragment.m21558a(PandoraType.ALBUM, graphQLAlbum.w() == null ? 0 : graphQLAlbum.w().a(), null);
        }
        CallerContext callerContext = f17599x;
        Preconditions.checkNotNull(graphQLAlbum);
        Bundle bundle2 = new Bundle();
        FlatBufferModelHelper.a(bundle2, "extra_album_selected", graphQLAlbum);
        bundle2.putParcelable("extra_caller_context", callerContext);
        PandoraAlbumMediaSetFragment pandoraAlbumMediaSetFragment = new PandoraAlbumMediaSetFragment();
        pandoraAlbumMediaSetFragment.g(bundle2);
        FbFragment fbFragment = pandoraAlbumMediaSetFragment;
        fbFragment.g(bundle);
        return fbFragment;
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -412928661);
        super.onResume();
        ((AlbumsEventBus) this.f17603s.get()).a(this.f17608y);
        ((ConsumptionPhotoEventBus) this.f17606v.get()).a(this.f17609z);
        this.f17607w.a(this);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1738086288, a);
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1480906020);
        super.onPause();
        ((AlbumsEventBus) this.f17603s.get()).b(this.f17608y);
        ((ConsumptionPhotoEventBus) this.f17606v.get()).b(this.f17609z);
        this.f17607w.b(this);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1200498667, a);
    }

    public void onBackPressed() {
        FbFragment fbFragment = (FbFragment) kO_().a("PandoraAlbumFragment");
        if (fbFragment == null || !(fbFragment instanceof CanHandleBackPressed) || !fbFragment.z() || !((CanHandleBackPressed) fbFragment).O_()) {
            super.onBackPressed();
        }
    }

    public final String am_() {
        return f17599x.c();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1004:
                this.f17605u.a(i, i2, intent);
                return;
            default:
                if (((PhotoSetOnActivityResultController) this.f17604t.get()).m21764a(this, i, i2, intent)) {
                    finish();
                    return;
                } else {
                    super.onActivityResult(i, i2, intent);
                    return;
                }
        }
    }

    private void m21569a(GraphQLAlbum graphQLAlbum) {
        boolean z = true;
        Preconditions.checkArgument(graphQLAlbum.q() != null);
        if (graphQLAlbum.q().size() <= 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        AlbumPermalinkContributorsFragment albumPermalinkContributorsFragment = new AlbumPermalinkContributorsFragment();
        Bundle bundle = new Bundle();
        FlatBufferModelHelper.a(bundle, "arg_album", graphQLAlbum);
        albumPermalinkContributorsFragment.g(bundle);
        FragmentTransaction b = kO_().a().b(2131558429, albumPermalinkContributorsFragment);
        b.a(null);
        b.c();
    }

    public final void iw_() {
    }

    public final void b_(boolean z) {
        if (!z) {
            m21576i();
        }
    }

    public static void m21575b(PandoraAlbumMediaSetActivity pandoraAlbumMediaSetActivity, int i) {
        if (pandoraAlbumMediaSetActivity.getRequestedOrientation() != i) {
            pandoraAlbumMediaSetActivity.setRequestedOrientation(i);
        }
    }
}
