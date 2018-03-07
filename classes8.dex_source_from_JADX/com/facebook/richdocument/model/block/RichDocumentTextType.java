package com.facebook.richdocument.model.block;

import com.facebook.graphql.enums.GraphQLComposedBlockType;

/* compiled from: pivot_invalid_overlays */
public enum RichDocumentTextType {
    KICKER,
    TITLE,
    SUBTITLE,
    HEADER_ONE,
    HEADER_TWO,
    BODY,
    PULL_QUOTE,
    RELATED_ARTICLES,
    RELATED_ARTICLES_HEADER,
    INLINE_RELATED_ARTICLES_HEADER,
    CAPTION_TITLE,
    CAPTION_SUBTITLE,
    CREDITS,
    COPYRIGHT,
    BYLINE,
    BLOCK_QUOTE,
    CODE,
    AUTHORS_CONTRIBUTORS_HEADER;

    /* compiled from: pivot_invalid_overlays */
    /* synthetic */ class C07161 {
        static final /* synthetic */ int[] f5628a = null;

        static {
            f5628a = new int[GraphQLComposedBlockType.values().length];
            try {
                f5628a[GraphQLComposedBlockType.PARAGRAPH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5628a[GraphQLComposedBlockType.UNSTYLED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5628a[GraphQLComposedBlockType.BLOCKQUOTE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5628a[GraphQLComposedBlockType.PULLQUOTE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5628a[GraphQLComposedBlockType.CODE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5628a[GraphQLComposedBlockType.HEADER_ONE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f5628a[GraphQLComposedBlockType.HEADER_TWO.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static RichDocumentTextType from(GraphQLComposedBlockType graphQLComposedBlockType) {
        if (graphQLComposedBlockType == null) {
            return null;
        }
        switch (C07161.f5628a[graphQLComposedBlockType.ordinal()]) {
            case 1:
            case 2:
                return BODY;
            case 3:
                return BLOCK_QUOTE;
            case 4:
                return PULL_QUOTE;
            case 5:
                return CODE;
            case 6:
                return HEADER_ONE;
            case 7:
                return HEADER_TWO;
            default:
                return null;
        }
    }
}
