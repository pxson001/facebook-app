package com.google.common.collect;

import com.google.common.annotations.Beta;
import java.util.Set;

@Beta
/* compiled from: calling_package */
public interface RangeSet<C extends Comparable> {
    Set<Range<C>> mo1009a();

    void mo894a(Range<C> range);

    RangeSet<C> mo1010b();

    boolean mo1012c(Range<C> range);
}
