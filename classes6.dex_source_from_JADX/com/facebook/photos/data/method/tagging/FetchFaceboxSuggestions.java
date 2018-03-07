package com.facebook.photos.data.method.tagging;

import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.TaggingProfileProvider;
import javax.inject.Inject;

/* compiled from: hpp */
public class FetchFaceboxSuggestions {
    private final TaggingProfileProvider f12964a;

    private static FetchFaceboxSuggestions m20329b(InjectorLike injectorLike) {
        return new FetchFaceboxSuggestions(TaggingProfileProvider.m20263b(injectorLike));
    }

    @Inject
    public FetchFaceboxSuggestions(TaggingProfileProvider taggingProfileProvider) {
        this.f12964a = taggingProfileProvider;
    }
}
