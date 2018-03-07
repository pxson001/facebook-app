package com.facebook.platform.composer.composer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLAlbumsConnection;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albumcreator.AlbumCreatorIntentBuilder;
import com.facebook.photos.albumcreator.AlbumCreatorSourceType;
import com.facebook.photos.albums.AlbumsAdapter;
import com.facebook.photos.albums.AlbumsAdapter.AlbumsAdapterMode;
import com.facebook.photos.albums.AlbumsAdapterProvider;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.albums.events.AlbumsEvents.AlbumSelectedEvent;
import com.facebook.photos.albums.futures.AlbumsFuturesGenerator;
import com.facebook.platform.composer.composer.PlatformComposerFragment.AnonymousClass29;
import com.facebook.platform.composer.composer.PlatformComposerFragment.AnonymousClass32;
import com.google.common.base.Objects;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: role */
public class PlatformComposerAlbumSelectorController {
    public final long f3959a;
    public final AlbumsEventBus f3960b;
    public final AlbumCreatorIntentBuilder f3961c;
    public final SecureContextHelper f3962d;
    public final Context f3963e;
    public final ViewerContext f3964f;
    public final AnonymousClass32 f3965g;
    public AlbumSelectedEventSubscriber f3966h;
    public AlbumsListController f3967i;
    public final AnonymousClass29 f3968j;
    public final Fragment f3969k;
    public boolean f3970l = false;
    public PopoverWindow f3971m;
    public boolean f3972n;
    public final DefaultAndroidThreadUtil f3973o;
    public final AlbumsFuturesGenerator f3974p;
    public final AlbumsAdapterProvider f3975q;

    /* compiled from: role */
    class C04981 implements OnClickListener {
        final /* synthetic */ PlatformComposerAlbumSelectorController f3944a;

        C04981(PlatformComposerAlbumSelectorController platformComposerAlbumSelectorController) {
            this.f3944a = platformComposerAlbumSelectorController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -584072763);
            PlatformComposerAlbumSelectorController platformComposerAlbumSelectorController = this.f3944a;
            Intent a2 = platformComposerAlbumSelectorController.f3961c.a(AlbumCreatorSourceType.COMPOSER, platformComposerAlbumSelectorController.f3964f, platformComposerAlbumSelectorController.f3968j.m4012b());
            if (platformComposerAlbumSelectorController.f3971m != null) {
                platformComposerAlbumSelectorController.f3971m.l();
            }
            if (platformComposerAlbumSelectorController.f3969k != null) {
                platformComposerAlbumSelectorController.f3962d.a(a2, 1000, platformComposerAlbumSelectorController.f3969k);
            } else if (platformComposerAlbumSelectorController.f3963e instanceof Activity) {
                platformComposerAlbumSelectorController.f3962d.a(a2, 1000, (Activity) platformComposerAlbumSelectorController.f3963e);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 681450458, a);
        }
    }

    /* compiled from: role */
    class C05003 implements OnDismissListener {
        final /* synthetic */ PlatformComposerAlbumSelectorController f3947a;

        C05003(PlatformComposerAlbumSelectorController platformComposerAlbumSelectorController) {
            this.f3947a = platformComposerAlbumSelectorController;
        }

        public final boolean m3936a(PopoverWindow popoverWindow) {
            if (this.f3947a.f3972n) {
                this.f3947a.f3972n = false;
            }
            return false;
        }
    }

    /* compiled from: role */
    public class AlbumSelectedEventSubscriber extends com.facebook.photos.albums.events.AlbumsEvents.AlbumSelectedEventSubscriber {
        final /* synthetic */ PlatformComposerAlbumSelectorController f3948a;

        public AlbumSelectedEventSubscriber(PlatformComposerAlbumSelectorController platformComposerAlbumSelectorController) {
            this.f3948a = platformComposerAlbumSelectorController;
        }

        public final void m3937b(FbEvent fbEvent) {
            AlbumSelectedEvent albumSelectedEvent = (AlbumSelectedEvent) fbEvent;
            if (this.f3948a.f3968j.m4011a() == null || !Objects.equal(this.f3948a.f3968j.m4011a().u(), albumSelectedEvent.a.u())) {
                this.f3948a.f3965g.m4027a(albumSelectedEvent.a);
            } else {
                this.f3948a.f3965g.m4027a(null);
            }
            if (this.f3948a.f3971m != null) {
                this.f3948a.f3972n = true;
                this.f3948a.f3971m.l();
            }
        }
    }

    /* compiled from: role */
    public class AlbumsListController {
        public final ListView f3950a;
        private final DefaultAndroidThreadUtil f3951b;
        public final AlbumsFuturesGenerator f3952c;
        public final Long f3953d;
        private final AlbumsAdapterProvider f3954e;
        public final C04992 f3955f;
        public final ComposerTargetData f3956g;
        public AlbumsAdapter f3957h;
        public final int f3958i;

        /* compiled from: role */
        class C05011 extends OperationResultFutureCallback {
            final /* synthetic */ AlbumsListController f3949a;

            C05011(AlbumsListController albumsListController) {
                this.f3949a = albumsListController;
            }

            protected final void m3939a(Object obj) {
                GraphQLAlbumsConnection graphQLAlbumsConnection = (GraphQLAlbumsConnection) ((OperationResult) obj).h();
                if (graphQLAlbumsConnection != null) {
                    this.f3949a.f3957h = AlbumsAdapterProvider.a(AlbumsAdapterMode.DEFAULT);
                    this.f3949a.f3950a.setAdapter(this.f3949a.f3957h);
                    this.f3949a.f3957h.a(graphQLAlbumsConnection);
                    C04992 c04992 = this.f3949a.f3955f;
                    if (c04992.f3946b.f3968j.m4011a() != null) {
                        AlbumsListController albumsListController = c04992.f3946b.f3967i;
                        GraphQLAlbum a = c04992.f3946b.f3968j.m4011a();
                        if (a != null) {
                            String u = a.u();
                            if (albumsListController.f3957h != null) {
                                albumsListController.f3957h.a(u);
                            }
                        }
                    }
                    c04992.f3945a.setVisibility(8);
                }
            }

            protected final void m3938a(ServiceException serviceException) {
            }
        }

        public AlbumsListController(ComposerTargetData composerTargetData, Long l, Context context, ListView listView, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AlbumsFuturesGenerator albumsFuturesGenerator, AlbumsAdapterProvider albumsAdapterProvider, C04992 c04992) {
            this.f3953d = l;
            this.f3950a = listView;
            this.f3951b = defaultAndroidThreadUtil;
            this.f3952c = albumsFuturesGenerator;
            this.f3958i = context.getResources().getDimensionPixelSize(2131432469);
            this.f3954e = albumsAdapterProvider;
            this.f3955f = c04992;
            this.f3956g = composerTargetData;
            m3940a();
        }

        private void m3940a() {
            ListenableFuture b;
            if (this.f3956g.targetType == TargetType.GROUP) {
                b = this.f3952c.b(String.valueOf(this.f3956g.targetId), this.f3958i);
            } else {
                b = this.f3952c.a(String.valueOf(this.f3953d), this.f3958i);
            }
            this.f3951b.a(b, new C05011(this));
        }
    }

    @Inject
    public PlatformComposerAlbumSelectorController(@Assisted AnonymousClass32 anonymousClass32, @Assisted AnonymousClass29 anonymousClass29, @Assisted Fragment fragment, @Assisted ViewerContext viewerContext, @Assisted String str, AlbumsEventBus albumsEventBus, AlbumCreatorIntentBuilder albumCreatorIntentBuilder, SecureContextHelper secureContextHelper, Context context, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AlbumsFuturesGenerator albumsFuturesGenerator, AlbumsAdapterProvider albumsAdapterProvider) {
        this.f3965g = anonymousClass32;
        this.f3968j = anonymousClass29;
        this.f3969k = fragment;
        this.f3964f = viewerContext;
        this.f3959a = Long.parseLong(str);
        this.f3960b = albumsEventBus;
        this.f3961c = albumCreatorIntentBuilder;
        this.f3962d = secureContextHelper;
        this.f3963e = context;
        this.f3973o = defaultAndroidThreadUtil;
        this.f3974p = albumsFuturesGenerator;
        this.f3975q = albumsAdapterProvider;
    }

    public final void m3943a(View view) {
        if (!this.f3970l) {
            this.f3970l = true;
            this.f3966h = new AlbumSelectedEventSubscriber(this);
            m3942a();
        }
        if (this.f3971m != null && this.f3971m.r) {
            this.f3971m.l();
        }
        this.f3971m = new PopoverWindow(this.f3963e);
        this.f3971m.d(m3941d());
        this.f3971m.c(true);
        this.f3971m.H = new C05003(this);
        this.f3971m.f(view);
    }

    @SuppressLint({"InflateParams", "BadArgument-LayoutInflater#inflate-0"})
    private View m3941d() {
        long parseLong;
        View inflate = LayoutInflater.from(this.f3963e).inflate(2130906296, null);
        ListView listView = (ListView) inflate.findViewById(2131559553);
        final ProgressBar progressBar = (ProgressBar) inflate.findViewById(2131559554);
        progressBar.setVisibility(0);
        ComposerTargetData b = this.f3968j.m4012b();
        if (this.f3964f != null) {
            parseLong = Long.parseLong(this.f3964f.mUserId);
        } else {
            parseLong = this.f3959a;
        }
        this.f3967i = new AlbumsListController(b, Long.valueOf(parseLong), this.f3963e, listView, this.f3973o, this.f3974p, this.f3975q, new Object(this) {
            public final /* synthetic */ PlatformComposerAlbumSelectorController f3946b;
        });
        inflate.findViewById(2131559556).setOnClickListener(new C04981(this));
        return inflate;
    }

    public final void m3942a() {
        if (this.f3970l) {
            this.f3960b.a(this.f3966h);
        }
    }
}
