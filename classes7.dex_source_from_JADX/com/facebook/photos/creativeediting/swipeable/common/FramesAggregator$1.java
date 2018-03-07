package com.facebook.photos.creativeediting.swipeable.common;

import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.FramePack;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import javax.annotation.Nullable;

/* compiled from: mFacecastNetworker is null. Unable to send seal request */
class FramesAggregator$1 implements Function<List<ImmutableList<FramePack>>, ImmutableList<FramePack>> {
    final /* synthetic */ FramesAggregator f9750a;

    /* compiled from: mFacecastNetworker is null. Unable to send seal request */
    class C08041 implements Comparator<FramePack> {
        final /* synthetic */ FramesAggregator$1 f9749a;

        C08041(FramesAggregator$1 framesAggregator$1) {
            this.f9749a = framesAggregator$1;
        }

        public int compare(Object obj, Object obj2) {
            return (int) (((FramePackModel) obj2).g() - ((FramePackModel) obj).g());
        }
    }

    FramesAggregator$1(FramesAggregator framesAggregator) {
        this.f9750a = framesAggregator;
    }

    @Nullable
    public Object apply(@Nullable Object obj) {
        List<ImmutableList> list = (List) obj;
        if (list == null) {
            return RegularImmutableList.a;
        }
        PriorityQueue priorityQueue = new PriorityQueue(10, new C08041(this));
        for (ImmutableList immutableList : list) {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                priorityQueue.add((FramePackModel) immutableList.get(i));
            }
        }
        Map linkedHashMap = new LinkedHashMap();
        while (!priorityQueue.isEmpty()) {
            FramePackModel framePackModel = (FramePackModel) priorityQueue.poll();
            linkedHashMap.put(framePackModel.d(), framePackModel);
        }
        return new Builder().b(linkedHashMap.values()).b();
    }
}
