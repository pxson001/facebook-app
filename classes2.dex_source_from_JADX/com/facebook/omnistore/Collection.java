package com.facebook.omnistore;

import com.facebook.jni.Countable;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: mBreadCrumbTitleRes=# */
public class Collection extends Countable {

    @DoNotStrip
    /* compiled from: mBreadCrumbTitleRes=# */
    public enum SortDirection {
        ASCENDING,
        DESCENDING
    }

    public native void deleteObject(String str);

    public native Cursor getObject(String str);

    public native Cursor query(String str, int i, SortDirection sortDirection);

    public native Cursor queryWithIndex(IndexQuery indexQuery, int i);

    public native Cursor queryWithIndex(String str, String[] strArr, int i);

    public native Cursor queryWithIndexSorted(IndexQuery indexQuery, String str, SortDirection sortDirection, int i);

    public native Cursor queryWithIndexSorted(String str, String[] strArr, String str2, SortDirection sortDirection, int i);

    public native void reindexAllObjects();

    public native void saveObject(String str, String str2, byte[] bArr);

    static {
        Prerequisites.ensure();
    }
}
