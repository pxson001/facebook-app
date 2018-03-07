package com.facebook.feed.rows.core.traversal;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/* compiled from: message_id */
public final class PartHolderDebugUtil$1 implements Callable {
    final /* synthetic */ SinglePartHolder f14336a;

    public PartHolderDebugUtil$1(SinglePartHolder singlePartHolder) {
        this.f14336a = singlePartHolder;
    }

    public final Object call() {
        SinglePartHolder singlePartHolder = this.f14336a;
        ArrayList arrayList = new ArrayList();
        for (GroupPartHolder groupPartHolder = singlePartHolder.f13429b; groupPartHolder != null; groupPartHolder = groupPartHolder.f12985b) {
            arrayList.add(groupPartHolder.f12984a.getClass().getName());
        }
        return arrayList;
    }
}
