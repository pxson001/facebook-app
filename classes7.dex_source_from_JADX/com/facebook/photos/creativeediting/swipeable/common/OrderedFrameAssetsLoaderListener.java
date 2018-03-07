package com.facebook.photos.creativeediting.swipeable.common;

import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.Frame;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel;
import com.facebook.photos.creativeediting.swipeable.common.FrameAssetsLoader.Listener;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

/* compiled from: mDurationMsecs */
public class OrderedFrameAssetsLoaderListener implements Listener {
    public final ImmutableList<Frame> f9753a;
    public final Listener f9754b;
    public final boolean[] f9755c;
    public int f9756d = 0;

    public OrderedFrameAssetsLoaderListener(ImmutableList<Frame> immutableList, Listener listener) {
        this.f9753a = immutableList;
        this.f9754b = listener;
        this.f9755c = new boolean[immutableList.size()];
    }

    public final void mo509a(FrameModel frameModel) {
        this.f9755c[m11683b(frameModel)] = true;
        while (this.f9756d < this.f9755c.length && this.f9755c[this.f9756d]) {
            this.f9754b.mo509a((FrameModel) this.f9753a.get(this.f9756d));
            this.f9756d++;
        }
    }

    private int m11683b(FrameModel frameModel) {
        for (int i = 0; i < this.f9753a.size(); i++) {
            if (Objects.equal(((FrameModel) this.f9753a.get(i)).c(), frameModel.c())) {
                return i;
            }
        }
        throw new IllegalArgumentException("Unexpected frame: " + frameModel.c());
    }
}
