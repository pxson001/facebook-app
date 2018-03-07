package com.facebook.pages.common.photos;

import android.content.Context;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.pages.common.photos.PagesAlbumsAdapter.OnClickAlbumListener;
import com.facebook.pages.common.photos.PagesAlbumsAdapter.OnClickCreateAlbumListener;
import java.util.List;

/* compiled from: setUserSelectedTags */
public class PagesAlbumsAdapterProvider extends AbstractAssistedProvider<PagesAlbumsAdapter> {
    public final PagesAlbumsAdapter m2520a(Context context, List<GraphQLAlbum> list, boolean z, OnClickAlbumListener onClickAlbumListener, OnClickCreateAlbumListener onClickCreateAlbumListener) {
        return new PagesAlbumsAdapter(DefaultTimeFormatUtil.a(this), context, list, z, onClickAlbumListener, onClickCreateAlbumListener);
    }
}
