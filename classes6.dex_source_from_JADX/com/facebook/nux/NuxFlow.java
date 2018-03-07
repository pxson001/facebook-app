package com.facebook.nux;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: isScoped */
public class NuxFlow {
    public final String f12207a;
    public final String f12208b;
    public final ImmutableList<NuxScreen> f12209c;

    public NuxFlow(String str, String str2, NuxScreen... nuxScreenArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(nuxScreenArr);
        Preconditions.checkArgument(nuxScreenArr.length > 0);
        this.f12207a = str;
        this.f12208b = str2;
        this.f12209c = ImmutableList.copyOf(nuxScreenArr);
    }
}
