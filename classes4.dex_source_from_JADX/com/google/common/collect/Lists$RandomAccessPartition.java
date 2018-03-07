package com.google.common.collect;

import java.util.List;
import java.util.RandomAccess;

/* compiled from: thread_id_canonical */
class Lists$RandomAccessPartition<T> extends Lists$Partition<T> implements RandomAccess {
    Lists$RandomAccessPartition(List<T> list, int i) {
        super(list, i);
    }
}
