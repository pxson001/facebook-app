package com.facebook.photos.tagging.store;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.photos.base.tagging.FaceBox;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: group_mentions */
public class FaceBoxStoreCopy implements Parcelable {
    public static final Creator<FaceBoxStoreCopy> CREATOR = new C08651();
    public static final FaceBoxStoreCopy f13422a = new FaceBoxStoreCopy(new HashMap());
    private final Map<MediaIdKey, ImmutableList<FaceBox>> f13423b;

    /* compiled from: group_mentions */
    final class C08651 implements Creator<FaceBoxStoreCopy> {
        C08651() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FaceBoxStoreCopy(parcel);
        }

        public final Object[] newArray(int i) {
            return new FaceBoxStoreCopy[i];
        }
    }

    public static FaceBoxStoreCopy m21137a(FaceBoxStore faceBoxStore, List<MediaIdKey> list) {
        Map hashMap = new HashMap();
        if (list != null) {
            for (MediaIdKey mediaIdKey : list) {
                ImmutableList immutableList;
                List list2 = (List) faceBoxStore.f13419a.get(mediaIdKey);
                if (list2 == null) {
                    immutableList = null;
                } else {
                    immutableList = ImmutableList.copyOf(list2);
                }
                hashMap.put(mediaIdKey, immutableList);
            }
        }
        return new FaceBoxStoreCopy(hashMap);
    }

    public final boolean m21138a(MediaIdKey mediaIdKey) {
        List list = (List) this.f13423b.get(mediaIdKey);
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Nullable
    public final ImmutableList<FaceBox> m21139b(MediaIdKey mediaIdKey) {
        return (ImmutableList) this.f13423b.get(mediaIdKey);
    }

    private FaceBoxStoreCopy(Map<MediaIdKey, ImmutableList<FaceBox>> map) {
        this.f13423b = map;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f13423b);
    }

    public FaceBoxStoreCopy(Parcel parcel) {
        this.f13423b = new HashMap();
        parcel.readMap(this.f13423b, HashMap.class.getClassLoader());
    }
}
