package com.facebook.photos.photoset.controllers;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.popover.PopoverMenuWindow.OnMenuItemClickListener;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLAlbum.Builder;
import com.facebook.inject.Assisted;
import com.facebook.photos.albums.AlbumsOptionsBaseController;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.futures.PhotosFuturesGenerator;
import com.facebook.photos.photoset.ui.permalink.GraphQLAlbumUtils;
import com.facebook.photos.photoset.ui.permalink.edit.EditAlbumPermalinkActivity;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: color_scheme */
public class AlbumsPermalinkOptionsController extends AlbumsOptionsBaseController {
    private GraphQLAlbumUtils f17777h;
    public SecureContextHelper f17778i;
    public AlbumHeaderSetupController f17779j;

    @Inject
    public AlbumsPermalinkOptionsController(PhotosFuturesGenerator photosFuturesGenerator, TasksManager tasksManager, AlbumsEventBus albumsEventBus, GraphQLAlbumUtils graphQLAlbumUtils, SecureContextHelper secureContextHelper, Provider<Context> provider, @Assisted GraphQLAlbum graphQLAlbum, AlbumHeaderSetupController albumHeaderSetupController) {
        super(provider, graphQLAlbum, albumsEventBus, photosFuturesGenerator, tasksManager);
        this.f17777h = graphQLAlbumUtils;
        this.f17778i = secureContextHelper;
        this.f17779j = albumHeaderSetupController;
    }

    public final void m21755a(View view, final Activity activity, final Fragment fragment, boolean z, boolean z2) {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow((Context) this.a.get());
        figPopoverMenuWindow.b(2131820544);
        if (!z2) {
            figPopoverMenuWindow.c().findItem(2131568599).setVisible(false);
        }
        if (z) {
            figPopoverMenuWindow.c().findItem(2131568601).setVisible(false);
        } else {
            figPopoverMenuWindow.c().findItem(2131568600).setVisible(false);
        }
        figPopoverMenuWindow.p = new OnMenuItemClickListener(this) {
            final /* synthetic */ AlbumsPermalinkOptionsController f17776c;

            public final boolean m21754a(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == 2131568599) {
                    AlbumsPermalinkOptionsController albumsPermalinkOptionsController = this.f17776c;
                    albumsPermalinkOptionsController.f17779j.m21749a(albumsPermalinkOptionsController.b, activity);
                } else if (itemId == 2131568600) {
                    Builder a = Builder.a(this.f17776c.b);
                    a.d = null;
                    a = a;
                    a.n = null;
                    a = a;
                    a.A = null;
                    a = a;
                    a.g = null;
                    a = a;
                    a.p = null;
                    this.f17776c.f17778i.a(EditAlbumPermalinkActivity.m21797a(this.f17776c.b(), a.a()), 4, fragment);
                } else if (itemId == 2131568601) {
                    this.f17776c.a();
                } else if (itemId == 2131568602) {
                    this.f17776c.a(activity);
                }
                return false;
            }
        };
        figPopoverMenuWindow.c(view);
        figPopoverMenuWindow.c(false);
        figPopoverMenuWindow.d();
    }
}
