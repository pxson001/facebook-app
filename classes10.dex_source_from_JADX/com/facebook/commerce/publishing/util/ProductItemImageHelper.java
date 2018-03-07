package com.facebook.commerce.publishing.util;

import android.content.Intent;
import android.net.Uri;
import com.facebook.commerce.publishing.adapter.AddEditProductImagesDataProvider;
import com.facebook.commerce.publishing.adapter.AddEditProductImagesDataProvider.ImageProviderModel;
import com.facebook.commerce.publishing.adapter.AddEditProductImagesDataProvider.ImageProviderModel.Type;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@NotThreadSafe
/* compiled from: cross_group_for_sale_posts */
public class ProductItemImageHelper {
    @Nullable
    public MediaItem f15642a;
    public final SecureContextHelper f15643b;
    public final Lazy<MediaItemFactory> f15644c;
    @Nullable
    public AddEditProductImagesDataProvider f15645d;

    public static ProductItemImageHelper m16112a(InjectorLike injectorLike) {
        return new ProductItemImageHelper((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedLazy.a(injectorLike, 2963));
    }

    @Inject
    public ProductItemImageHelper(SecureContextHelper secureContextHelper, Lazy<MediaItemFactory> lazy) {
        this.f15643b = secureContextHelper;
        this.f15644c = lazy;
    }

    public final boolean m16114a(int i, int i2, @Nullable Intent intent) {
        if (i != 9420 || i2 != -1) {
            return false;
        }
        if (intent != null && this.f15642a != null && this.f15645d != null) {
            CreativeEditingData creativeEditingData;
            EditGalleryIpcBundle editGalleryIpcBundle = (EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a);
            if (editGalleryIpcBundle == null) {
                creativeEditingData = null;
            } else {
                creativeEditingData = editGalleryIpcBundle.e;
            }
            CreativeEditingData creativeEditingData2 = creativeEditingData;
            MediaItem mediaItem = null;
            if (!(creativeEditingData2 == null || this.f15642a == null || this.f15645d == null)) {
                MediaItem a = ((MediaItemFactory) this.f15644c.get()).a(Uri.parse(m16113a(this.f15642a.e(), creativeEditingData2)), FallbackMediaId.DEFAULT);
                if (a != null) {
                    AddEditProductImagesDataProvider addEditProductImagesDataProvider = this.f15645d;
                    MediaItem mediaItem2 = this.f15642a;
                    int i3 = 0;
                    while (i3 < addEditProductImagesDataProvider.f15443a.size()) {
                        ImageProviderModel imageProviderModel = (ImageProviderModel) addEditProductImagesDataProvider.f15443a.get(i3);
                        if (imageProviderModel.f15442b == Type.MEDIA_ITEM && ((MediaItem) imageProviderModel.f15441a).equals(mediaItem2)) {
                            break;
                        }
                        i3++;
                    }
                    i3 = -1;
                    if (i3 != -1) {
                        addEditProductImagesDataProvider.f15443a.remove(i3);
                        addEditProductImagesDataProvider.f15443a.add(i3, new ImageProviderModel(a));
                    }
                    this.f15642a = null;
                    mediaItem = a;
                }
            }
            MediaItem mediaItem3 = mediaItem;
        }
        return true;
    }

    public static String m16113a(String str, CreativeEditingData creativeEditingData) {
        if (creativeEditingData == null) {
            return str;
        }
        if (creativeEditingData.p() != null) {
            return creativeEditingData.p().toString();
        }
        if (creativeEditingData.o() != null) {
            return creativeEditingData.o().toString();
        }
        return str;
    }
}
