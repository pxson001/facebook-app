package com.facebook.photos.tagging.store;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.MediaItem.MediaType;
import com.facebook.photos.base.tagging.Tag;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: group_feed_title */
public class TagStoreCopy implements Parcelable {
    public static final Creator<TagStoreCopy> CREATOR = new C08661();
    public static final TagStoreCopy f13469a = new TagStoreCopy(new HashMap());
    private final Map<MediaIdKey, ImmutableList<Tag>> f13470b;

    /* compiled from: group_feed_title */
    final class C08661 implements Creator<TagStoreCopy> {
        C08661() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TagStoreCopy(parcel);
        }

        public final Object[] newArray(int i) {
            return new TagStoreCopy[i];
        }
    }

    public static TagStoreCopy m21172a(TagStore tagStore, List<MediaIdKey> list) {
        Map hashMap = new HashMap();
        if (list != null) {
            for (MediaIdKey mediaIdKey : list) {
                hashMap.put(mediaIdKey, tagStore.m21159a(mediaIdKey));
            }
        }
        return new TagStoreCopy(hashMap);
    }

    public static TagStoreCopy m21171a(TagStore tagStore, ImmutableList<MediaItem> immutableList) {
        Map hashMap = new HashMap();
        if (immutableList != null) {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                MediaItem mediaItem = (MediaItem) immutableList.get(i);
                if (mediaItem.m() == MediaType.PHOTO) {
                    MediaIdKey d = mediaItem.d();
                    hashMap.put(d, ImmutableList.copyOf(tagStore.m21159a(d)));
                }
            }
        }
        return new TagStoreCopy(hashMap);
    }

    public final boolean m21173a(MediaIdKey mediaIdKey) {
        ImmutableList immutableList = (ImmutableList) this.f13470b.get(mediaIdKey);
        return immutableList == null || immutableList.isEmpty();
    }

    public final ImmutableList<Tag> m21174b(MediaIdKey mediaIdKey) {
        return (ImmutableList) this.f13470b.get(mediaIdKey);
    }

    private TagStoreCopy(Map<MediaIdKey, ImmutableList<Tag>> map) {
        this.f13470b = map;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f13470b);
    }

    public TagStoreCopy(Parcel parcel) {
        this.f13470b = new HashMap();
        parcel.readMap(this.f13470b, HashMap.class.getClassLoader());
    }
}
