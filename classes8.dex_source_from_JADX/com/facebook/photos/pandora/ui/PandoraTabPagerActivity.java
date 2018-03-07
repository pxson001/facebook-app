package com.facebook.photos.pandora.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.tagging.AnalyticsActivityWithExtraData;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.profile.TimelinePhotoTabModeParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albumcreator.AlbumCreatorIntentBuilder;
import com.facebook.photos.albumcreator.AlbumCreatorSourceType;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.MediaGalleryFragmentVisibilityChangeEvent;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.MediaGalleryFragmentVisibilityChangeEventSubscriber;
import com.facebook.photos.intent.IPhotoIntentBuilder;
import com.facebook.photos.pandora.logging.PandoraLoadedCounter;
import com.facebook.photos.pandora.logging.PandoraSequenceLogger;
import com.facebook.photos.pandora.logging.PandoraSequences;
import com.facebook.photos.photoset.controllers.MediaPickerLaunchController;
import com.facebook.photos.photoset.controllers.PhotoSetOnActivityResultController;
import com.facebook.platformattribution.result.PlatformAttributionResultController;
import com.facebook.user.model.User;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.intent.action.ACTION_OPTIMISTIC_PROFILE_PIC_UPDATED */
public class PandoraTabPagerActivity extends FbFragmentActivity implements AnalyticsActivityWithExtraData {
    private static final CallerContext f17678B = CallerContext.a(PandoraTabPagerActivity.class, "photos_tabs");
    @Inject
    Lazy<PhotoSetOnActivityResultController> f17679A;
    private FbTitleBar f17680C;
    private TimelinePhotoTabModeParams f17681D;
    private MediaGalleryFragmentVisibilityChangeEventSubscriber f17682E;
    @Inject
    @LoggedInUserId
    String f17683p;
    @Inject
    @LoggedInUser
    Provider<User> f17684q;
    @Inject
    Lazy<MediaPickerLaunchController> f17685r;
    @Inject
    Lazy<IPhotoIntentBuilder> f17686s;
    @Inject
    Lazy<SecureContextHelper> f17687t;
    @Inject
    Lazy<AlbumCreatorIntentBuilder> f17688u;
    @Inject
    PandoraSequenceLogger f17689v;
    @Inject
    PandoraLoadedCounter f17690w;
    @Inject
    ComposerPublishServiceHelper f17691x;
    @Inject
    PlatformAttributionResultController f17692y;
    @Inject
    ConsumptionPhotoEventBus f17693z;

    /* compiled from: com.facebook.intent.action.ACTION_OPTIMISTIC_PROFILE_PIC_UPDATED */
    class C18861 implements OnClickListener {
        final /* synthetic */ PandoraTabPagerActivity f17674a;

        C18861(PandoraTabPagerActivity pandoraTabPagerActivity) {
            this.f17674a = pandoraTabPagerActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1257824941);
            this.f17674a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 987418571, a);
        }
    }

    /* compiled from: com.facebook.intent.action.ACTION_OPTIMISTIC_PROFILE_PIC_UPDATED */
    class C18872 extends OnToolbarButtonListener {
        final /* synthetic */ PandoraTabPagerActivity f17675a;

        C18872(PandoraTabPagerActivity pandoraTabPagerActivity) {
            this.f17675a = pandoraTabPagerActivity;
        }

        public final void m21658a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (titleBarButtonSpec != null) {
                if (titleBarButtonSpec.h == 2130838297) {
                    ((SecureContextHelper) this.f17675a.f17687t.get()).a(((AlbumCreatorIntentBuilder) this.f17675a.f17688u.get()).a(AlbumCreatorSourceType.ALBUMSTAB, null), this.f17675a);
                } else if (titleBarButtonSpec.h == 2130840542) {
                    ((SecureContextHelper) this.f17675a.f17687t.get()).a(((IPhotoIntentBuilder) this.f17675a.f17686s.get()).a(), this.f17675a);
                } else {
                    ((MediaPickerLaunchController) this.f17675a.f17685r.get()).m21762a(this.f17675a);
                }
            }
        }
    }

    private static <T extends Context> void m21661a(Class<T> cls, T t) {
        m21662a((Object) t, (Context) t);
    }

    public static void m21662a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PandoraTabPagerActivity) obj).m21663a(String_LoggedInUserIdMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 3595), IdBasedSingletonScopeProvider.b(injectorLike, 9407), IdBasedSingletonScopeProvider.b(injectorLike, 7324), IdBasedSingletonScopeProvider.b(injectorLike, 968), IdBasedLazy.a(injectorLike, 9243), PandoraSequenceLogger.m21549a(injectorLike), PandoraLoadedCounter.m21547a(injectorLike), ComposerPublishServiceHelper.b(injectorLike), PlatformAttributionResultController.a(injectorLike), ConsumptionPhotoEventBus.a(injectorLike), IdBasedLazy.a(injectorLike, 9408));
    }

    private void m21663a(String str, Provider<User> provider, Lazy<MediaPickerLaunchController> lazy, Lazy<IPhotoIntentBuilder> lazy2, Lazy<SecureContextHelper> lazy3, Lazy<AlbumCreatorIntentBuilder> lazy4, PandoraSequenceLogger pandoraSequenceLogger, PandoraLoadedCounter pandoraLoadedCounter, ComposerPublishServiceHelper composerPublishServiceHelper, PlatformAttributionResultController platformAttributionResultController, ConsumptionPhotoEventBus consumptionPhotoEventBus, Lazy<PhotoSetOnActivityResultController> lazy5) {
        this.f17683p = str;
        this.f17684q = provider;
        this.f17685r = lazy;
        this.f17686s = lazy2;
        this.f17687t = lazy3;
        this.f17688u = lazy4;
        this.f17689v = pandoraSequenceLogger;
        this.f17690w = pandoraLoadedCounter;
        this.f17691x = composerPublishServiceHelper;
        this.f17692y = platformAttributionResultController;
        this.f17693z = consumptionPhotoEventBus;
        this.f17679A = lazy5;
    }

    protected final void m21667b(Bundle bundle) {
        String j;
        Class cls = PandoraTabPagerActivity.class;
        m21662a((Object) this, (Context) this);
        this.f17689v.f17580a.a(PandoraSequences.f17581a);
        this.f17689v.m21551a("InflateTabPagerActivity");
        super.b(bundle);
        setContentView(2130906139);
        Intent intent = getIntent();
        String valueOf = String.valueOf(intent.getLongExtra("owner_id", Long.parseLong(this.f17683p)));
        String stringExtra = intent.getStringExtra("profile_name");
        if (Strings.isNullOrEmpty(stringExtra) && Objects.equal(valueOf, this.f17683p)) {
            j = ((User) this.f17684q.get()).j();
        } else {
            j = stringExtra;
        }
        if (this.f17690w != null) {
            PandoraLoadedCounter pandoraLoadedCounter = this.f17690w;
            pandoraLoadedCounter.f17576a = 0;
            pandoraLoadedCounter.f17577b = 0;
            pandoraLoadedCounter.f17578c = 0;
        }
        this.f17681D = (TimelinePhotoTabModeParams) intent.getParcelableExtra("extra_photo_tab_mode_params");
        this.f17689v.m21553b("InflateTabPagerActivity");
        this.f17689v.m21551a("InflateTitleBar");
        if (FbTitleBarUtil.b(this)) {
            this.f17680C = (FbTitleBar) findViewById(2131558563);
            this.f17680C.setHasBackButton(false);
            this.f17680C.a(new C18861(this));
            if (m21665i() || m21666j()) {
                stringExtra = intent.getStringExtra("title");
                if (!Strings.isNullOrEmpty(stringExtra)) {
                    this.f17680C.setTitle(stringExtra);
                } else if (!Strings.isNullOrEmpty(j)) {
                    this.f17680C.setTitle(j);
                }
            }
            if (Objects.equal(valueOf, this.f17683p)) {
                Builder a = TitleBarButtonSpec.a();
                a.i = 2130837954;
                a = a;
                a.j = getResources().getString(2131234350);
                this.f17680C.setButtonSpecs(ImmutableList.of(a.a()));
                this.f17680C.setOnToolbarButtonListener(new C18872(this));
            }
        }
        final int requestedOrientation = getRequestedOrientation();
        this.f17682E = new MediaGalleryFragmentVisibilityChangeEventSubscriber(this) {
            final /* synthetic */ PandoraTabPagerActivity f17677b;

            public final void m21659b(FbEvent fbEvent) {
                PandoraTabPagerActivity.m21664b(this.f17677b, ((MediaGalleryFragmentVisibilityChangeEvent) fbEvent).a ? 13 : requestedOrientation);
            }
        };
        this.f17693z.a(this.f17682E);
        this.f17689v.m21553b("InflateTitleBar");
        this.f17689v.m21551a("AttachTabPagerFragment");
        FragmentManager kO_ = kO_();
        if (kO_.f() <= 0 || !(kO_.a(2131558429) instanceof PandoraTabPagerFragment)) {
            kO_.a().b(2131558429, PandoraTabPagerFragment.m21685a(getIntent().getExtras(), valueOf, j, f17678B), PandoraTabPagerFragment.class.getName()).a(null).c();
            kO_.b();
            this.f17689v.m21553b("AttachTabPagerFragment");
        }
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -760111447);
        if (this.f17693z != null) {
            this.f17693z.b(this.f17682E);
        }
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 923751215, a);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (((PhotoSetOnActivityResultController) this.f17679A.get()).m21764a(this, i, i2, intent)) {
                finish();
                return;
            }
            switch (i) {
                case 1004:
                    this.f17692y.a(i, i2, intent);
                    return;
                case 1756:
                    this.f17691x.c(intent);
                    return;
                case 9913:
                    setResult(i2, intent);
                    finish();
                    return;
                default:
                    super.onActivityResult(i, i2, intent);
                    return;
            }
        }
    }

    public void onBackPressed() {
        if (kO_().f() == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    public final String am_() {
        return f17678B.c();
    }

    public final Map<String, Object> m21668c() {
        long longExtra = getIntent().getLongExtra("owner_id", Long.parseLong(this.f17683p));
        Map<String, Object> c = Maps.c();
        c.put("profile_id", Long.valueOf(longExtra));
        return c;
    }

    private boolean m21665i() {
        return this.f17681D == null || this.f17681D.a();
    }

    private boolean m21666j() {
        return this.f17681D == null || this.f17681D.c() || this.f17681D.d();
    }

    public static void m21664b(PandoraTabPagerActivity pandoraTabPagerActivity, int i) {
        if (pandoraTabPagerActivity.getRequestedOrientation() != i) {
            super.setRequestedOrientation(i);
        }
    }

    public void setRequestedOrientation(int i) {
        super.setRequestedOrientation(1);
    }
}
