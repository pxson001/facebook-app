package com.facebook.photos.taggablegallery;

import com.facebook.ipc.media.MediaIdKey;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.taggablegallery.PhotoGalleryContent.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: selected_location */
public class TaggableGalleryPhotoSourceListImp implements TaggableGalleryPhotoSource {
    private final List<PhotoGalleryContent> f3426a;
    private final Map<MediaIdKey, Integer> f3427b;

    public TaggableGalleryPhotoSourceListImp(List<PhotoItem> list) {
        int size = list.size();
        this.f3426a = Lists.b(size);
        this.f3427b = Maps.a(size);
        for (int i = 0; i < size; i++) {
            PhotoItem photoItem = (PhotoItem) list.get(i);
            this.f3426a.add(Builder.m3368a(photoItem).m3370a());
            this.f3427b.put(photoItem.d(), Integer.valueOf(i));
        }
    }

    public TaggableGalleryPhotoSourceListImp(List<PhotoItem> list, List<CreativeEditingData> list2) {
        boolean z;
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        if (list2.size() == list.size()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        int size = list.size();
        this.f3426a = Lists.b(size);
        this.f3427b = Maps.a(size);
        for (int i = 0; i < size; i++) {
            PhotoItem photoItem = (PhotoItem) list.get(i);
            CreativeEditingData creativeEditingData = (CreativeEditingData) list2.get(i);
            List list3 = this.f3426a;
            Builder a = Builder.m3368a(photoItem);
            a.f3406b = creativeEditingData;
            list3.add(a.m3370a());
            this.f3427b.put(photoItem.d(), Integer.valueOf(i));
        }
    }

    public final PhotoGalleryContent mo185a(int i) {
        return (PhotoGalleryContent) this.f3426a.get(i);
    }

    @Nullable
    public final Integer mo186a(MediaIdKey mediaIdKey) {
        return (Integer) this.f3427b.get(mediaIdKey);
    }

    public final int mo184a() {
        return this.f3426a.size();
    }
}
