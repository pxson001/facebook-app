package com.facebook.photos.mediagallery.util;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: is_profile_cached */
public class MediaGalleryAttachmentFilter {
    private static final String f10785a = MediaGalleryAttachmentFilter.class.getSimpleName();
    private final AbstractFbErrorReporter f10786b;

    public static MediaGalleryAttachmentFilter m12806b(InjectorLike injectorLike) {
        return new MediaGalleryAttachmentFilter((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public MediaGalleryAttachmentFilter(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f10786b = abstractFbErrorReporter;
    }

    public final ImmutableList<GraphQLStoryAttachment> m12807a(ImmutableList<GraphQLStoryAttachment> immutableList) {
        Preconditions.checkNotNull(immutableList);
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) immutableList.get(i);
            if (graphQLStoryAttachment.r() == null) {
                String str;
                if (graphQLStoryAttachment.w() == null) {
                    str = "styleList == null";
                } else if (graphQLStoryAttachment.w().isEmpty()) {
                    str = "styleList.size == 0";
                } else {
                    str = "first attachment:" + graphQLStoryAttachment.w().get(0) + " styleList.size == " + graphQLStoryAttachment.w().size();
                }
                this.f10786b.b(f10785a, str);
            } else if (GraphQLStoryAttachmentUtil.b(graphQLStoryAttachment)) {
                builder.c(graphQLStoryAttachment);
            }
        }
        return builder.b();
    }
}
