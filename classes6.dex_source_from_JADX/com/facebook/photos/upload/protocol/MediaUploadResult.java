package com.facebook.photos.upload.protocol;

import com.facebook.graphql.model.GraphQLStory;
import com.google.common.base.Optional;
import javax.annotation.Nonnull;

/* compiled from: keyword_bolded_subtext */
public class MediaUploadResult {
    public final String f13989a;
    public final Optional<GraphQLStory> f13990b;

    public MediaUploadResult(@Nonnull String str, @Nonnull Optional<GraphQLStory> optional) {
        this.f13989a = str;
        this.f13990b = optional;
    }
}
