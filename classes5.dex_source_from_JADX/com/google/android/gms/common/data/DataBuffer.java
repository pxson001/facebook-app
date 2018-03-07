package com.google.android.gms.common.data;

import com.google.android.gms.common.api.Releasable;
import java.util.Iterator;

public interface DataBuffer<T> extends Releasable, Iterable<T> {
    int mo735a();

    T mo739a(int i);

    @Deprecated
    void mo736b();

    Iterator<T> iterator();
}
