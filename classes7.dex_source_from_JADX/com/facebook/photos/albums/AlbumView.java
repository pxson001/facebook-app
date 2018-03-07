package com.facebook.photos.albums;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albums.AlbumsOptionsController.C07601;
import com.facebook.photos.albums.AlbumsOptionsController.C07612;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.albums.events.AlbumsEvents.AlbumSelectedEvent;
import com.facebook.photos.futures.PhotosFuturesGenerator;
import com.facebook.ui.dialogs.ActionSheetDialogBuilder;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: marginRight */
public class AlbumView extends ContentViewWithButton {
    @Inject
    public AlbumsOptionsControllerProvider f9312h;
    @Inject
    public AlbumsEventBus f9313i;
    public GraphQLAlbum f9314j;
    public final OnClickListener f9315k = new C07521(this);
    public final OnClickListener f9316l = new C07532(this);

    /* compiled from: marginRight */
    class C07521 implements OnClickListener {
        final /* synthetic */ AlbumView f9310a;

        C07521(AlbumView albumView) {
            this.f9310a = albumView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1366234321);
            AlbumsOptionsControllerProvider albumsOptionsControllerProvider = this.f9310a.f9312h;
            AlbumsOptionsBaseController albumsOptionsController = new AlbumsOptionsController(PhotosFuturesGenerator.m12388a(albumsOptionsControllerProvider), TasksManager.b(albumsOptionsControllerProvider), AlbumsEventBus.m11400a(albumsOptionsControllerProvider), albumsOptionsControllerProvider.getProvider(Context.class), this.f9310a.f9314j);
            new ActionSheetDialogBuilder(albumsOptionsController.m11339b()).a(albumsOptionsController.m11339b().getResources().getString(2131234358), new C07601(albumsOptionsController)).a(albumsOptionsController.m11339b().getResources().getString(2131234383), new C07612(albumsOptionsController)).show();
            Logger.a(2, EntryType.UI_INPUT_END, 59765127, a);
        }
    }

    /* compiled from: marginRight */
    class C07532 implements OnClickListener {
        final /* synthetic */ AlbumView f9311a;

        C07532(AlbumView albumView) {
            this.f9311a = albumView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1125729655);
            this.f9311a.f9313i.a(new AlbumSelectedEvent(this.f9311a.f9314j, (String) this.f9311a.getTag()));
            Logger.a(2, EntryType.UI_INPUT_END, 119362411, a);
        }
    }

    public static void m11328a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        AlbumView albumView = (AlbumView) obj;
        AlbumsOptionsControllerProvider albumsOptionsControllerProvider = (AlbumsOptionsControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(AlbumsOptionsControllerProvider.class);
        AlbumsEventBus a = AlbumsEventBus.m11400a(fbInjector);
        albumView.f9312h = albumsOptionsControllerProvider;
        albumView.f9313i = a;
    }

    public AlbumView(Context context) {
        super(context);
        Class cls = AlbumView.class;
        m11328a(this, getContext());
    }
}
