package com.facebook.ipc.creativecam;

import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.FramePack;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.google.common.collect.ImmutableList;

/* compiled from: places_model */
public class CreativeCamCaptureInfo {
    public final CreativeCamMediaSource f6148a;
    public final ImmutableList<FramePack> f6149b;
    public final String f6150c;
    public final ImmutableList<StickerParams> f6151d;

    public CreativeCamCaptureInfo(CreativeCamMediaSource creativeCamMediaSource, ImmutableList<FramePack> immutableList, String str, ImmutableList<StickerParams> immutableList2) {
        this.f6148a = creativeCamMediaSource;
        this.f6149b = immutableList;
        this.f6150c = str;
        this.f6151d = immutableList2;
    }
}
