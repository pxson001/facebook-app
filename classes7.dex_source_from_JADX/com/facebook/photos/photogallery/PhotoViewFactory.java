package com.facebook.photos.photogallery;

import android.content.Context;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.photos.Photo;
import com.facebook.photos.creativeediting.model.CreativeEditingData;

/* compiled from: isFullScreenActive() Could not find FullScreenVideoPlayerHost */
public class PhotoViewFactory {
    public static PhotoViewFactory m12894a(InjectorLike injectorLike) {
        return new PhotoViewFactory();
    }

    public PhotoView m12895a(Photo photo, Context context, CreativeEditingData creativeEditingData) {
        PhotoView photoView = new PhotoView(context);
        photoView.mo612a(photo);
        return photoView;
    }
}
