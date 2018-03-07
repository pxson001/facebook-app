package com.facebook.contacts.data;

import com.facebook.contacts.data.FbContactsContract.SearchType;
import com.google.common.collect.ImmutableSet;

/* compiled from: photo_items_added */
public final class FbContactsContract$SearchQuery {
    public final String f8138a;
    public final ImmutableSet<SearchType> f8139b;
    final /* synthetic */ FbContactsContract f8140c;

    public FbContactsContract$SearchQuery(FbContactsContract fbContactsContract, String str, ImmutableSet<SearchType> immutableSet) {
        this.f8140c = fbContactsContract;
        this.f8138a = str;
        this.f8139b = immutableSet;
    }
}
