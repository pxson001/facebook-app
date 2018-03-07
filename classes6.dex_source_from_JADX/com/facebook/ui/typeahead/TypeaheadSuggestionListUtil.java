package com.facebook.ui.typeahead;

import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: createAlbumParams */
public class TypeaheadSuggestionListUtil<T> {
    private final TypeaheadSuggestionDeduper<T> f18443a;

    @Inject
    public TypeaheadSuggestionListUtil(@Assisted TypeaheadSuggestionDeduper typeaheadSuggestionDeduper) {
        this.f18443a = typeaheadSuggestionDeduper;
    }

    public final SearchResponse<T> m27054a(@Nullable SearchResponse<T> searchResponse, @Nullable SearchResponse<T> searchResponse2, FetchSource fetchSource) {
        ImmutableList immutableList;
        ImmutableList immutableList2;
        int i = 0;
        if (searchResponse != null) {
            immutableList = searchResponse.f18413b;
        } else {
            immutableList = RegularImmutableList.a;
        }
        if (searchResponse2 != null) {
            immutableList2 = searchResponse2.f18413b;
        } else {
            immutableList2 = RegularImmutableList.a;
        }
        Collection arrayList = new ArrayList(immutableList.size() + immutableList2.size());
        arrayList.addAll(immutableList);
        for (int i2 = 0; i2 < immutableList2.size(); i2++) {
            Object obj = searchResponse2.f18413b.get(i2);
            int indexOf = arrayList.indexOf(obj);
            if (indexOf == -1) {
                arrayList.add(obj);
            } else {
                arrayList.set(indexOf, this.f18443a.mo1397a(arrayList.get(indexOf), obj, fetchSource));
            }
        }
        immutableList = ImmutableList.copyOf(arrayList);
        if (searchResponse2 != null) {
            i = searchResponse2.f18414c;
        }
        return new SearchResponse(immutableList, i);
    }

    public final SearchResponse<T> m27055b(@Nullable SearchResponse<T> searchResponse, @Nullable SearchResponse<T> searchResponse2, FetchSource fetchSource) {
        ImmutableList immutableList;
        ImmutableList immutableList2;
        if (searchResponse != null) {
            immutableList = searchResponse.f18413b;
        } else {
            immutableList = RegularImmutableList.a;
        }
        if (searchResponse2 != null) {
            immutableList2 = searchResponse2.f18413b;
        } else {
            immutableList2 = RegularImmutableList.a;
        }
        Collection arrayList = new ArrayList(immutableList.size() + immutableList2.size());
        arrayList.addAll(immutableList2);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Object obj = immutableList.get(i);
            int indexOf = immutableList2.indexOf(obj);
            if (indexOf == -1) {
                arrayList.add(obj);
            } else {
                arrayList.set(indexOf, this.f18443a.mo1397a(obj, immutableList2.get(indexOf), fetchSource));
            }
        }
        return new SearchResponse(ImmutableList.copyOf(arrayList), searchResponse2 != null ? searchResponse2.f18414c : 0);
    }
}
