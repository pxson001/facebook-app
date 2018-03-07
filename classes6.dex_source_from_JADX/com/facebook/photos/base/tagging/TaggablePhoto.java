package com.facebook.photos.base.tagging;

import com.facebook.ipc.media.MediaIdKey;
import com.facebook.photos.base.photos.Photo;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: initial_share_params */
public abstract class TaggablePhoto extends Photo {
    protected List<FaceBox> f12746c;
    public List<Tag> f12747d;

    public TaggablePhoto(long j, List<Tag> list, @Nullable List<FaceBox> list2) {
        super(j);
        this.f12747d = list;
        this.f12746c = list2;
    }

    public MediaIdKey mo1094a() {
        return null;
    }
}
