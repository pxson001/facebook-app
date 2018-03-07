package com.facebook.photos.albums;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.inject.Assisted;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.futures.PhotosFuturesGenerator;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: margin */
public class AlbumsOptionsController extends AlbumsOptionsBaseController {

    /* compiled from: margin */
    public class C07601 implements OnClickListener {
        final /* synthetic */ AlbumsOptionsController f9340a;

        public C07601(AlbumsOptionsController albumsOptionsController) {
            this.f9340a = albumsOptionsController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f9340a.m11337a();
        }
    }

    /* compiled from: margin */
    public class C07612 implements OnClickListener {
        final /* synthetic */ AlbumsOptionsController f9341a;

        public C07612(AlbumsOptionsController albumsOptionsController) {
            this.f9341a = albumsOptionsController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f9341a.m11338a(null);
        }
    }

    @Inject
    public AlbumsOptionsController(PhotosFuturesGenerator photosFuturesGenerator, TasksManager tasksManager, AlbumsEventBus albumsEventBus, Provider<Context> provider, @Assisted GraphQLAlbum graphQLAlbum) {
        super(provider, graphQLAlbum, albumsEventBus, photosFuturesGenerator, tasksManager);
    }
}
