package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: bug_report_retry_upload_success */
class Synchronized$SynchronizedAsMapValues<V> extends Synchronized$SynchronizedCollection<Collection<V>> {
    Synchronized$SynchronizedAsMapValues(Collection<Collection<V>> collection, @Nullable Object obj) {
        super(collection, obj);
    }

    public Iterator<Collection<V>> iterator() {
        return new TransformedIterator<Collection<V>, Collection<V>>(this, super.iterator()) {
            final /* synthetic */ Synchronized$SynchronizedAsMapValues f7572a;

            final Object m13680a(Object obj) {
                return Synchronized.d((Collection) obj, this.f7572a.mutex);
            }
        };
    }
}
