package com.facebook.photos.creativeediting.swipeable.common;

import com.facebook.inject.Assisted;
import com.facebook.photos.creativeediting.model.Filter;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.Frame;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.FramePack;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.photos.creativeediting.model.SwipeableParams.SwipeableItemType;
import com.facebook.ultralight.Inject;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.LinkedHashMap;

/* compiled from: mBle */
public class SwipeableParamsListBuilder {
    private final LinkedHashMap<String, SwipeableParams> f9782a = new LinkedHashMap();
    private final int f9783b;
    private final int f9784c;
    private final SwipeableParamsHelper f9785d;

    @Inject
    public SwipeableParamsListBuilder(@Assisted int i, @Assisted int i2, SwipeableParamsHelper swipeableParamsHelper) {
        this.f9783b = i;
        this.f9784c = i2;
        this.f9785d = swipeableParamsHelper;
    }

    public final SwipeableParamsListBuilder m11722a(ImmutableList<SwipeableParams> immutableList) {
        Preconditions.checkNotNull(immutableList);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            m11719a((SwipeableParams) immutableList.get(i));
        }
        return this;
    }

    public final SwipeableParamsListBuilder m11723b(ImmutableList<FramePack> immutableList) {
        Preconditions.checkNotNull(immutableList);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            FramePackModel framePackModel = (FramePackModel) immutableList.get(i);
            ImmutableList c = framePackModel.c();
            int size2 = c.size();
            for (int i2 = 0; i2 < size2; i2++) {
                m11721a((FrameModel) c.get(i2), framePackModel.bJ_());
            }
        }
        return this;
    }

    public final SwipeableParamsListBuilder m11725c(ImmutableList<Frame> immutableList) {
        Preconditions.checkNotNull(immutableList);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            m11721a((FrameModel) immutableList.get(i), "");
        }
        return this;
    }

    public final SwipeableParamsListBuilder m11721a(FrameModel frameModel, String str) {
        m11719a(this.f9785d.m11715a(frameModel, this.f9783b, this.f9784c, str));
        return this;
    }

    public final SwipeableParamsListBuilder m11720a() {
        m11719a(new SwipeableParams(RegularImmutableList.a, Filter.PassThrough.name(), SwipeableItemType.FILTER, this.f9785d.m11718a(Filter.PassThrough.name())));
        return this;
    }

    private void m11719a(SwipeableParams swipeableParams) {
        this.f9782a.put(swipeableParams.b, swipeableParams);
    }

    public final ImmutableList<SwipeableParams> m11724b() {
        return new Builder().b(this.f9782a.values()).b();
    }
}
