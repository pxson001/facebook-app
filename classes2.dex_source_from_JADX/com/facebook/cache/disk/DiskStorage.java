package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.disk.DefaultDiskStorage.EntryImpl;
import java.util.Collection;

/* compiled from: optimistic_visitor_count */
public interface DiskStorage {
    long mo2077a(EntryImpl entryImpl);

    Inserter mo2078a(String str, Object obj);

    void mo2079a();

    BinaryResource mo2080b(String str, Object obj);

    void mo2081b();

    Collection<Entry> mo2082c();

    boolean mo2083c(String str, Object obj);

    boolean mo2084d(String str, Object obj);
}
