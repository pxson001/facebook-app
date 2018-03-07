package com.facebook.composer.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.composer.activity.AlbumSelectorActivity.C07481;
import com.facebook.composer.activity.AlbumSelectorActivity.C07492;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.analytics.ComposerAnalyticsLogger.Events;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albumcreator.AlbumCreatorIntentBuilder;
import com.facebook.photos.albumcreator.AlbumCreatorSourceType;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.albums.events.AlbumsEvents.AlbumSelectedEvent;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: is_minutiae_attached */
public class AlbumSelectorController {
    public final AlbumsEventBus f5958a;
    public final ComposerAnalyticsLogger f5959b;
    public final AlbumCreatorIntentBuilder f5960c;
    public final SecureContextHelper f5961d;
    public final Context f5962e;
    public final Lazy<AlbumsListControllerFactory> f5963f;
    public final ViewerContext f5964g;
    public final C07492 f5965h;
    public AlbumSelectedEventSubscriber f5966i;
    public AlbumsListController f5967j;
    public final C07481 f5968k;
    public final Fragment f5969l;
    public boolean f5970m = false;
    public PopoverWindow f5971n;
    public boolean f5972o;
    private AllCapsTransformationMethod f5973p;

    /* compiled from: is_minutiae_attached */
    class C07501 implements OnClickListener {
        final /* synthetic */ AlbumSelectorController f5953a;

        C07501(AlbumSelectorController albumSelectorController) {
            this.f5953a = albumSelectorController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -439855551);
            if (this.f5953a.f5962e instanceof Activity) {
                ((Activity) this.f5953a.f5962e).finish();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 795850779, a);
        }
    }

    /* compiled from: is_minutiae_attached */
    class C07512 extends OnToolbarButtonListener {
        final /* synthetic */ AlbumSelectorController f5954a;

        C07512(AlbumSelectorController albumSelectorController) {
            this.f5954a = albumSelectorController;
        }

        public final void m7361a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            AlbumSelectorController albumSelectorController = this.f5954a;
            Intent a = albumSelectorController.f5960c.a(AlbumCreatorSourceType.COMPOSER, albumSelectorController.f5964g, albumSelectorController.f5968k.m7349c());
            if (albumSelectorController.f5971n != null) {
                albumSelectorController.f5971n.l();
            }
            if (albumSelectorController.f5969l != null) {
                albumSelectorController.f5961d.a(a, 2312, albumSelectorController.f5969l);
            } else if (albumSelectorController.f5962e instanceof Activity) {
                albumSelectorController.f5961d.a(a, 2312, (Activity) albumSelectorController.f5962e);
            }
        }
    }

    /* compiled from: is_minutiae_attached */
    public class AlbumSelectedEventSubscriber extends com.facebook.photos.albums.events.AlbumsEvents.AlbumSelectedEventSubscriber {
        final /* synthetic */ AlbumSelectorController f5957a;

        public AlbumSelectedEventSubscriber(AlbumSelectorController albumSelectorController) {
            this.f5957a = albumSelectorController;
        }

        public final void m7362b(FbEvent fbEvent) {
            AlbumSelectedEvent albumSelectedEvent = (AlbumSelectedEvent) fbEvent;
            if (this.f5957a.f5968k.m7348b() == null || !Objects.equal(this.f5957a.f5968k.m7348b().u(), albumSelectedEvent.a.u())) {
                this.f5957a.f5959b.a(Events.COMPOSER_SELECT_ALBUM_CHOOSE, this.f5957a.f5968k.m7347a());
                this.f5957a.f5965h.m7351a(albumSelectedEvent.a);
            } else {
                this.f5957a.f5965h.m7351a(null);
            }
            if (this.f5957a.f5971n != null) {
                this.f5957a.f5972o = true;
                this.f5957a.f5971n.l();
            }
        }
    }

    @Inject
    public AlbumSelectorController(@Assisted AlbumSelectorCallback albumSelectorCallback, @Assisted DataProvider dataProvider, @Assisted Fragment fragment, @Assisted ViewerContext viewerContext, AlbumsEventBus albumsEventBus, ComposerAnalyticsLogger composerAnalyticsLogger, AlbumCreatorIntentBuilder albumCreatorIntentBuilder, SecureContextHelper secureContextHelper, Context context, AllCapsTransformationMethod allCapsTransformationMethod, Lazy<AlbumsListControllerFactory> lazy) {
        this.f5965h = albumSelectorCallback;
        this.f5968k = dataProvider;
        this.f5969l = fragment;
        this.f5964g = viewerContext;
        this.f5958a = albumsEventBus;
        this.f5959b = composerAnalyticsLogger;
        this.f5960c = albumCreatorIntentBuilder;
        this.f5961d = secureContextHelper;
        this.f5962e = context;
        this.f5963f = lazy;
        this.f5973p = allCapsTransformationMethod;
    }

    public final void m7365a(View view) {
        if (!this.f5970m) {
            this.f5970m = true;
            this.f5966i = new AlbumSelectedEventSubscriber(this);
            m7364a();
        }
        m7363b(view);
        FbTitleBar fbTitleBar = (FbTitleBar) view.findViewById(2131558563);
        Resources resources = this.f5962e.getResources();
        Builder a = TitleBarButtonSpec.a();
        a.a = 1;
        a = a;
        a.g = this.f5973p.getTransformation(resources.getString(2131234771), (View) fbTitleBar).toString();
        Builder builder = a;
        builder.h = -2;
        TitleBarButtonSpec a2 = builder.a();
        fbTitleBar.setTitle(2131234578);
        fbTitleBar.a(new C07501(this));
        fbTitleBar.setButtonSpecs(ImmutableList.of(a2));
        fbTitleBar.setOnToolbarButtonListener(new C07512(this));
    }

    private void m7363b(View view) {
        Long valueOf;
        ListView listView = (ListView) view.findViewById(2131559553);
        final ProgressBar progressBar = (ProgressBar) view.findViewById(2131559554);
        progressBar.setVisibility(0);
        AlbumsListControllerFactory albumsListControllerFactory = (AlbumsListControllerFactory) this.f5963f.get();
        ComposerTargetData c = this.f5968k.m7349c();
        if (this.f5964g != null) {
            valueOf = Long.valueOf(Long.parseLong(this.f5964g.mUserId));
        } else {
            valueOf = null;
        }
        this.f5967j = albumsListControllerFactory.m7370a(c, valueOf, listView, new Object(this) {
            public final /* synthetic */ AlbumSelectorController f5956b;
        }, this.f5968k.m7350d());
    }

    public final void m7364a() {
        if (this.f5970m) {
            this.f5958a.a(this.f5966i);
        }
    }
}
