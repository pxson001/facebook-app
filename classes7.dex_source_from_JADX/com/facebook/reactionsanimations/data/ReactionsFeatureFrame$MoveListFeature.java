package com.facebook.reactionsanimations.data;

import com.facebook.reactionsanimations.VectorCommand;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: fetch_failed */
public class ReactionsFeatureFrame$MoveListFeature {
    final /* synthetic */ ReactionsFeatureFrame f14401a;
    public final List<VectorCommand> f14402b;

    public ReactionsFeatureFrame$MoveListFeature(ReactionsFeatureFrame reactionsFeatureFrame, List<String> list) {
        this.f14401a = reactionsFeatureFrame;
        List arrayList = new ArrayList();
        for (String a : list) {
            arrayList.add(VectorCommand.m18273a(a));
        }
        this.f14402b = Collections.unmodifiableList(arrayList);
    }
}
