package com.facebook.photos.photoset.ui.photoset;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.photos.albums.AlbumSetPagedCollection;
import com.facebook.photos.albums.protocols.MediasetQueryModels.DefaultThumbnailImageModel;
import com.facebook.photos.albums.ui.PhotoGridImageView;
import com.google.common.base.Strings;

/* compiled from: click_menu_button */
public class PhotoSetGridAdapter extends BaseAdapter {
    private static final CallerContext f17927a = CallerContext.a(PhotoSetGridAdapter.class, "photos_view");
    private AlbumSetPagedCollection f17928b;

    public /* synthetic */ Object getItem(int i) {
        return m21882a(i);
    }

    public PhotoSetGridAdapter(AlbumSetPagedCollection albumSetPagedCollection) {
        this.f17928b = albumSetPagedCollection;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view != null) {
            view = (PhotoGridImageView) view;
        } else {
            view = new PhotoGridImageView(viewGroup.getContext());
        }
        DefaultImageFields j = m21882a(i).j();
        CallerContext callerContext = f17927a;
        if (!(j == null || Strings.isNullOrEmpty(j.b()))) {
            view.a(ImageUtil.a(j), callerContext);
        }
        return view;
    }

    public int getCount() {
        int i;
        AlbumSetPagedCollection albumSetPagedCollection = this.f17928b;
        if (albumSetPagedCollection.a == null || albumSetPagedCollection.a.isEmpty()) {
            i = 0;
        } else {
            i = albumSetPagedCollection.a.size();
        }
        return i;
    }

    private DefaultThumbnailImageModel m21882a(int i) {
        DefaultThumbnailImageModel defaultThumbnailImageModel;
        AlbumSetPagedCollection albumSetPagedCollection = this.f17928b;
        if (albumSetPagedCollection.a == null || albumSetPagedCollection.a.isEmpty() || i < 0 || i >= albumSetPagedCollection.a.size()) {
            defaultThumbnailImageModel = null;
        } else {
            defaultThumbnailImageModel = (DefaultThumbnailImageModel) albumSetPagedCollection.a.get(i);
        }
        return defaultThumbnailImageModel;
    }

    public long getItemId(int i) {
        if (m21882a(i) == null) {
            return -1;
        }
        return Long.parseLong(m21882a(i).d());
    }

    public boolean hasStableIds() {
        return true;
    }
}
