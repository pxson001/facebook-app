package com.facebook.photos.photoset.controllers;

import android.content.Context;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.futures.PhotosFuturesGenerator;
import com.facebook.photos.photoset.ui.permalink.GraphQLAlbumUtils;
import com.facebook.ui.futures.TasksManager;

/* compiled from: collection_product_items */
public class AlbumsPermalinkOptionsControllerProvider extends AbstractAssistedProvider<AlbumsPermalinkOptionsController> {
    public final AlbumsPermalinkOptionsController m21756a(GraphQLAlbum graphQLAlbum) {
        return new AlbumsPermalinkOptionsController(PhotosFuturesGenerator.a(this), TasksManager.b(this), AlbumsEventBus.a(this), GraphQLAlbumUtils.m21791a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), getProvider(Context.class), graphQLAlbum, AlbumHeaderSetupController.m21739b(this));
    }
}
