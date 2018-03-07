package com.facebook.richdocument.ham;

import com.facebook.graphql.enums.GraphQLDocumentElementType;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.graphql.enums.GraphQLDocumentWebviewPresentationStyle;
import com.facebook.graphql.enums.GraphQLTextAnnotationVerticalPosition;
import com.facebook.richdocument.model.block.Annotation;
import com.facebook.richdocument.model.block.Annotation.AnnotationType;
import com.facebook.richdocument.model.block.RichDocumentTextType;
import com.facebook.richdocument.model.data.AnnotatableBlock;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.MediaPresentationBlock;
import com.facebook.richdocument.model.data.OGBlock;
import com.facebook.richdocument.model.data.TextBlockData;
import com.facebook.richdocument.model.data.impl.ListItemBlockDataImpl;
import com.facebook.richdocument.model.data.impl.WebViewBlockDataImpl;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextAnnotationModel;
import com.facebook.richdocument.view.widget.RichTextUtils;
import javax.annotation.Nullable;

/* compiled from: placeholder_type */
public enum HamContentType {
    TEXT_KICKER,
    TEXT_TITLE,
    TEXT_SUBTITLE,
    TEXT_BYLINE,
    TEXT_AUTHOR_PIC,
    TEXT_BODY,
    TEXT_H1,
    TEXT_H2,
    TEXT_PULL_QUOTE,
    TEXT_PULL_QUOTE_ATTRIBUTION,
    TEXT_BLOCK_QUOTE,
    TEXT_CODE,
    TEXT_CAPTION_SMALL,
    TEXT_CAPTION_MEDIUM,
    TEXT_CAPTION_LARGE,
    TEXT_CAPTION_XLARGE,
    TEXT_CAPTION_CREDIT,
    TEXT_ELEMENT_UFI,
    TEXT_BULLETED_LIST,
    TEXT_NUMBERED_LIST,
    TEXT_END_CREDITS_BAR,
    TEXT_END_CREDITS,
    MEDIA_WITH_ABOVE_CAPTION,
    MEDIA_WITH_BELOW_CAPTION,
    MEDIA_WITH_ABOVE_AND_BELOW_CAPTION,
    MEDIA_WITHOUT_ABOVE_OR_BELOW_CAPTION,
    AD_WITH_CAPTION,
    AD_WITHOUT_CAPTION,
    MAP_WITH_CAPTION,
    MAP_WITHOUT_CAPTION,
    HTML_WITH_CAPTION,
    HTML_WITHOUT_CAPTION,
    SOCIAL_EMBED_WITH_CAPTION,
    SOCIAL_EMBED_WITHOUT_CAPTION,
    RELATED_ARTICLE_CELL,
    RELATED_ARTICLES_HEADER,
    INLINE_RELATED_ARTICLES_HEADER,
    INLINE_RELATED_ARTICLES_FOOTER,
    AUTHORS_CONTRIBUTORS_HEADER,
    SHARE_BUTTON,
    VIDEO_SEEK_BAR,
    NONE,
    UNKNOWN;

    /* compiled from: placeholder_type */
    /* synthetic */ class C06931 {
        static final /* synthetic */ int[] f5294b = null;

        static {
            f5294b = new int[GraphQLDocumentWebviewPresentationStyle.values().length];
            try {
                f5294b[GraphQLDocumentWebviewPresentationStyle.AD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5294b[GraphQLDocumentWebviewPresentationStyle.SOCIAL_EMBED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5294b[GraphQLDocumentWebviewPresentationStyle.FACEBOOK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5294b[GraphQLDocumentWebviewPresentationStyle.TWEET.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5294b[GraphQLDocumentWebviewPresentationStyle.VINE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5294b[GraphQLDocumentWebviewPresentationStyle.YOUTUBE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f5294b[GraphQLDocumentWebviewPresentationStyle.INSTAGRAM.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            f5293a = new int[RichDocumentTextType.values().length];
            try {
                f5293a[RichDocumentTextType.BODY.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f5293a[RichDocumentTextType.CAPTION_SUBTITLE.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f5293a[RichDocumentTextType.CAPTION_TITLE.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f5293a[RichDocumentTextType.CREDITS.ordinal()] = 4;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f5293a[RichDocumentTextType.HEADER_ONE.ordinal()] = 5;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f5293a[RichDocumentTextType.HEADER_TWO.ordinal()] = 6;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f5293a[RichDocumentTextType.PULL_QUOTE.ordinal()] = 7;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f5293a[RichDocumentTextType.RELATED_ARTICLES.ordinal()] = 8;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f5293a[RichDocumentTextType.SUBTITLE.ordinal()] = 9;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f5293a[RichDocumentTextType.TITLE.ordinal()] = 10;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f5293a[RichDocumentTextType.KICKER.ordinal()] = 11;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f5293a[RichDocumentTextType.AUTHORS_CONTRIBUTORS_HEADER.ordinal()] = 12;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f5293a[RichDocumentTextType.RELATED_ARTICLES_HEADER.ordinal()] = 13;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f5293a[RichDocumentTextType.INLINE_RELATED_ARTICLES_HEADER.ordinal()] = 14;
            } catch (NoSuchFieldError e21) {
            }
        }
    }

    public static HamContentType from(RichDocumentTextType richDocumentTextType) {
        if (richDocumentTextType == null) {
            return UNKNOWN;
        }
        switch (richDocumentTextType) {
            case BODY:
                return TEXT_BODY;
            case CAPTION_SUBTITLE:
                return TEXT_CAPTION_MEDIUM;
            case CAPTION_TITLE:
                return TEXT_CAPTION_MEDIUM;
            case CREDITS:
                return TEXT_END_CREDITS;
            case HEADER_ONE:
                return TEXT_H1;
            case HEADER_TWO:
                return TEXT_H2;
            case PULL_QUOTE:
                return TEXT_PULL_QUOTE;
            case RELATED_ARTICLES:
                return UNKNOWN;
            case SUBTITLE:
                return TEXT_SUBTITLE;
            case TITLE:
                return TEXT_TITLE;
            case KICKER:
                return TEXT_KICKER;
            case AUTHORS_CONTRIBUTORS_HEADER:
                return AUTHORS_CONTRIBUTORS_HEADER;
            case RELATED_ARTICLES_HEADER:
                return RELATED_ARTICLES_HEADER;
            case INLINE_RELATED_ARTICLES_HEADER:
                return INLINE_RELATED_ARTICLES_HEADER;
            default:
                return UNKNOWN;
        }
    }

    public static HamContentType from(BlockData blockData) {
        if (blockData == null) {
            return NONE;
        }
        int n = blockData.mo272n();
        boolean hasAnyAnnotations = hasAnyAnnotations(blockData);
        boolean hasAboveAnnotation = hasAboveAnnotation(blockData);
        boolean hasBelowAnnotation = hasBelowAnnotation(blockData);
        switch (n) {
            case 2:
                return RELATED_ARTICLE_CELL;
            case 3:
            case 22:
                if (blockData instanceof ListItemBlockDataImpl) {
                    return ((ListItemBlockDataImpl) blockData).f5728b ? TEXT_NUMBERED_LIST : TEXT_BULLETED_LIST;
                } else {
                    return from(((TextBlockData) blockData).mo298g());
                }
            case 4:
            case 5:
            case 6:
                if (hasAboveAnnotation && hasBelowAnnotation) {
                    return MEDIA_WITH_ABOVE_AND_BELOW_CAPTION;
                }
                if (hasAboveAnnotation) {
                    return MEDIA_WITH_ABOVE_CAPTION;
                }
                if (hasBelowAnnotation) {
                    return MEDIA_WITH_BELOW_CAPTION;
                }
                return MEDIA_WITHOUT_ABOVE_OR_BELOW_CAPTION;
            case 7:
                return hasAnyAnnotations ? MAP_WITH_CAPTION : MAP_WITHOUT_CAPTION;
            case 8:
                return getTypeFromWebViewBlock(((WebViewBlockDataImpl) blockData).f5803g, hasAnyAnnotations);
            case 9:
                return SHARE_BUTTON;
            case 11:
                return NONE;
            case 12:
                return NONE;
            case 14:
                return TEXT_BYLINE;
            case 16:
            case 19:
                return RELATED_ARTICLES_HEADER;
            case 17:
                return TEXT_BLOCK_QUOTE;
            case 18:
                return TEXT_CODE;
            case 20:
                return INLINE_RELATED_ARTICLES_HEADER;
            case 21:
                return INLINE_RELATED_ARTICLES_FOOTER;
            default:
                return UNKNOWN;
        }
    }

    public static HamContentType from(@Nullable Annotation annotation) {
        if (annotation == null) {
            return NONE;
        }
        if (annotation.f5608a == AnnotationType.COPYRIGHT) {
            return TEXT_CAPTION_CREDIT;
        }
        if (annotation.f5608a == AnnotationType.UFI) {
            return TEXT_ELEMENT_UFI;
        }
        if (annotation.f5608a == AnnotationType.VIDEO_SEEK_BAR) {
            return VIDEO_SEEK_BAR;
        }
        int a = RichTextUtils.m1352a(annotation);
        if (a == 0) {
            return NONE;
        }
        if (a == 2131626005 || a == 2131626003) {
            return TEXT_CAPTION_SMALL;
        }
        if (a == 2131626006) {
            return TEXT_CAPTION_MEDIUM;
        }
        if (a == 2131626007) {
            return TEXT_CAPTION_LARGE;
        }
        if (a == 2131626008) {
            return TEXT_CAPTION_XLARGE;
        }
        return NONE;
    }

    private static boolean hasAnyAnnotations(@Nullable BlockData blockData) {
        if (blockData == null || !(blockData instanceof AnnotatableBlock)) {
            return false;
        }
        AnnotatableBlock annotatableBlock = (AnnotatableBlock) blockData;
        if (annotatableBlock.mo293m() != GraphQLDocumentMediaPresentationStyle.ASPECT_FIT) {
            return false;
        }
        if (annotatableBlock.mo273c() == null && annotatableBlock.iV_() == null && annotatableBlock.mo274e() == null) {
            return false;
        }
        return true;
    }

    private static boolean hasBelowUfi(@Nullable BlockData blockData) {
        if (!(blockData instanceof AnnotatableBlock)) {
            return false;
        }
        if (!isSlideshow(blockData)) {
            AnnotatableBlock annotatableBlock = (AnnotatableBlock) blockData;
            boolean z = annotatableBlock.mo293m() == GraphQLDocumentMediaPresentationStyle.ASPECT_FIT || annotatableBlock.mo293m() == GraphQLDocumentMediaPresentationStyle.ASPECT_FIT_ONLY;
            if (!z || annotatableBlock.mo280j() == GraphQLDocumentFeedbackOptions.NONE) {
                return false;
            }
            return true;
        } else if (((AnnotatableBlock) blockData).mo280j() != GraphQLDocumentFeedbackOptions.NONE) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean hasBelowAnnotation(@Nullable BlockData blockData) {
        if (blockData == null || !(blockData instanceof AnnotatableBlock)) {
            return false;
        }
        if (isDefaultFullscreen(blockData) && !isSlideshow(blockData)) {
            return false;
        }
        AnnotatableBlock annotatableBlock = (AnnotatableBlock) blockData;
        return hasBelowUfi(blockData) || isAnnotationInSlot(annotatableBlock.mo273c(), GraphQLTextAnnotationVerticalPosition.BELOW) || isAnnotationInSlot(annotatableBlock.iV_(), GraphQLTextAnnotationVerticalPosition.BELOW) || isAnnotationInSlot(annotatableBlock.mo274e(), GraphQLTextAnnotationVerticalPosition.BELOW);
    }

    private static boolean hasAboveAnnotation(@Nullable BlockData blockData) {
        if (blockData == null || !(blockData instanceof AnnotatableBlock)) {
            return false;
        }
        if (isDefaultFullscreen(blockData) && !isSlideshow(blockData)) {
            return false;
        }
        AnnotatableBlock annotatableBlock = (AnnotatableBlock) blockData;
        if (isAnnotationInSlot(annotatableBlock.mo273c(), GraphQLTextAnnotationVerticalPosition.ABOVE) || isAnnotationInSlot(annotatableBlock.iV_(), GraphQLTextAnnotationVerticalPosition.ABOVE) || isAnnotationInSlot(annotatableBlock.mo274e(), GraphQLTextAnnotationVerticalPosition.ABOVE)) {
            return true;
        }
        return false;
    }

    private static boolean isSlideshow(@Nullable BlockData blockData) {
        if (blockData != null && (blockData instanceof OGBlock) && ((OGBlock) blockData).iT_() == GraphQLDocumentElementType.SLIDESHOW) {
            return true;
        }
        return false;
    }

    private static boolean isDefaultFullscreen(@Nullable BlockData blockData) {
        if (blockData != null && (blockData instanceof MediaPresentationBlock) && ((MediaPresentationBlock) blockData).mo293m() == GraphQLDocumentMediaPresentationStyle.FULL_SCREEN) {
            return true;
        }
        return false;
    }

    private static boolean isAnnotationInSlot(RichDocumentTextAnnotationModel richDocumentTextAnnotationModel, GraphQLTextAnnotationVerticalPosition graphQLTextAnnotationVerticalPosition) {
        return richDocumentTextAnnotationModel != null && richDocumentTextAnnotationModel.iu_() == graphQLTextAnnotationVerticalPosition;
    }

    private static HamContentType getTypeFromWebViewBlock(GraphQLDocumentWebviewPresentationStyle graphQLDocumentWebviewPresentationStyle, boolean z) {
        switch (C06931.f5294b[graphQLDocumentWebviewPresentationStyle.ordinal()]) {
            case 1:
                return z ? AD_WITH_CAPTION : AD_WITHOUT_CAPTION;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return z ? SOCIAL_EMBED_WITH_CAPTION : SOCIAL_EMBED_WITHOUT_CAPTION;
            default:
                if (z) {
                    return HTML_WITH_CAPTION;
                }
                return HTML_WITHOUT_CAPTION;
        }
    }
}
