package com.google.common.collect;

import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

/* compiled from: bug_report_retry_upload_success */
class Synchronized$SynchronizedRandomAccessList<E> extends Synchronized$SynchronizedList<E> implements RandomAccess {
    Synchronized$SynchronizedRandomAccessList(List<E> list, @Nullable Object obj) {
        super(list, obj);
    }
}
