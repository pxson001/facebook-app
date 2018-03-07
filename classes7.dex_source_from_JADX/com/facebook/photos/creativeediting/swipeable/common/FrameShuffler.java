package com.facebook.photos.creativeediting.swipeable.common;

import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.Frame;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* compiled from: mFrequency */
public class FrameShuffler {
    public static ImmutableList<Frame> m11680a(ImmutableList<? extends Frame> immutableList) {
        Collection arrayList = new ArrayList(immutableList);
        Collections.shuffle(arrayList);
        return ImmutableList.copyOf(arrayList);
    }
}
