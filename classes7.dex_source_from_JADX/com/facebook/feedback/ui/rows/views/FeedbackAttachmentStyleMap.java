package com.facebook.feedback.ui.rows.views;

import com.facebook.feedback.ui.rows.CommentPhotoAttachmentPartDefinition;
import com.facebook.feedback.ui.rows.CommentPlaceInfoAttachmentSelectorPartDefinition;
import com.facebook.feedback.ui.rows.CommentShareAttachmentPartDefinition;
import com.facebook.feedback.ui.rows.CommentStickerAttachmentPartDefinition;
import com.facebook.feedback.ui.rows.CommentVideoAttachmentPartDefinition;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: resized_text_count */
public class FeedbackAttachmentStyleMap {
    public Lazy<CommentPhotoAttachmentPartDefinition> f5213a;
    public Lazy<CommentVideoAttachmentPartDefinition> f5214b;
    public Lazy<CommentShareAttachmentPartDefinition> f5215c;
    public Lazy<CommentStickerAttachmentPartDefinition> f5216d;
    public Lazy<CommentPlaceInfoAttachmentSelectorPartDefinition> f5217e;

    /* compiled from: resized_text_count */
    public /* synthetic */ class C05161 {
        public static final /* synthetic */ int[] f5212a = new int[GraphQLStoryAttachmentStyle.values().length];

        static {
            try {
                f5212a[GraphQLStoryAttachmentStyle.PHOTO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5212a[GraphQLStoryAttachmentStyle.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5212a[GraphQLStoryAttachmentStyle.SHARE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5212a[GraphQLStoryAttachmentStyle.STICKER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5212a[GraphQLStoryAttachmentStyle.COMMENT_PLACE_INFO.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Inject
    public FeedbackAttachmentStyleMap(Lazy<CommentPhotoAttachmentPartDefinition> lazy, Lazy<CommentVideoAttachmentPartDefinition> lazy2, Lazy<CommentShareAttachmentPartDefinition> lazy3, Lazy<CommentStickerAttachmentPartDefinition> lazy4, Lazy<CommentPlaceInfoAttachmentSelectorPartDefinition> lazy5) {
        this.f5213a = lazy;
        this.f5214b = lazy2;
        this.f5215c = lazy3;
        this.f5216d = lazy4;
        this.f5217e = lazy5;
    }
}
