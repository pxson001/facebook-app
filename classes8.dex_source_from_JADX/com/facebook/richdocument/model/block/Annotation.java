package com.facebook.richdocument.model.block;

import com.facebook.graphql.enums.GraphQLTextAnnotationHorizontalPosition;
import com.facebook.graphql.enums.GraphQLTextAnnotationPresentationStyle;
import com.facebook.graphql.enums.GraphQLTextAnnotationVerticalPosition;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentStyleModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextAnnotationModel;

/* compiled from: placeRating */
public class Annotation {
    public final AnnotationType f5608a;
    public final String f5609b;
    public final AnnotationStyle f5610c;
    public final AnnotationAlignment f5611d;
    public final AnnotationSlot f5612e;
    private final RichDocumentStyleModel f5613f;
    public final RichDocumentText f5614g;

    /* compiled from: placeRating */
    /* synthetic */ class C07151 {
        static final /* synthetic */ int[] f5605a = new int[GraphQLTextAnnotationPresentationStyle.values().length];
        static final /* synthetic */ int[] f5606b = new int[GraphQLTextAnnotationHorizontalPosition.values().length];
        static final /* synthetic */ int[] f5607c = new int[GraphQLTextAnnotationVerticalPosition.values().length];

        static {
            try {
                f5607c[GraphQLTextAnnotationVerticalPosition.ABOVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5607c[GraphQLTextAnnotationVerticalPosition.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5607c[GraphQLTextAnnotationVerticalPosition.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5607c[GraphQLTextAnnotationVerticalPosition.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5607c[GraphQLTextAnnotationVerticalPosition.BELOW.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5606b[GraphQLTextAnnotationHorizontalPosition.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f5606b[GraphQLTextAnnotationHorizontalPosition.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f5606b[GraphQLTextAnnotationHorizontalPosition.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f5605a[GraphQLTextAnnotationPresentationStyle.REGULAR.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f5605a[GraphQLTextAnnotationPresentationStyle.LARGE.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f5605a[GraphQLTextAnnotationPresentationStyle.MEDIUM.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f5605a[GraphQLTextAnnotationPresentationStyle.EXTRA_LARGE.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    /* compiled from: placeRating */
    public enum AnnotationAlignment {
        LEFT,
        CENTER,
        RIGHT;

        public static AnnotationAlignment from(GraphQLTextAnnotationHorizontalPosition graphQLTextAnnotationHorizontalPosition) {
            if (graphQLTextAnnotationHorizontalPosition != null) {
                switch (C07151.f5606b[graphQLTextAnnotationHorizontalPosition.ordinal()]) {
                    case 1:
                        return LEFT;
                    case 2:
                        return CENTER;
                    case 3:
                        return RIGHT;
                }
            }
            return null;
        }
    }

    /* compiled from: placeRating */
    public enum AnnotationSlot {
        ABOVE,
        TOP,
        CENTER,
        BOTTOM,
        BELOW;

        public static AnnotationSlot from(GraphQLTextAnnotationVerticalPosition graphQLTextAnnotationVerticalPosition) {
            if (graphQLTextAnnotationVerticalPosition != null) {
                switch (C07151.f5607c[graphQLTextAnnotationVerticalPosition.ordinal()]) {
                    case 1:
                        return ABOVE;
                    case 2:
                        return TOP;
                    case 3:
                        return CENTER;
                    case 4:
                        return BOTTOM;
                    case 5:
                        return BELOW;
                }
            }
            return null;
        }
    }

    /* compiled from: placeRating */
    public enum AnnotationStyle {
        MINI_LABEL,
        REGULAR,
        LARGE,
        MEDIUM,
        EXTRA_LARGE;

        public static AnnotationStyle from(GraphQLTextAnnotationPresentationStyle graphQLTextAnnotationPresentationStyle) {
            if (graphQLTextAnnotationPresentationStyle != null) {
                switch (C07151.f5605a[graphQLTextAnnotationPresentationStyle.ordinal()]) {
                    case 1:
                        return REGULAR;
                    case 2:
                        return LARGE;
                    case 3:
                        return MEDIUM;
                    case 4:
                        return EXTRA_LARGE;
                }
            }
            return null;
        }
    }

    /* compiled from: placeRating */
    public enum AnnotationType {
        TITLE,
        SUBTITLE,
        COPYRIGHT,
        AUDIO,
        LOCATION,
        VIDEO_CONTROL,
        VIDEO_SEEK_BAR,
        UFI,
        LOADING_INDICATOR
    }

    public Annotation(AnnotationType annotationType, String str, AnnotationStyle annotationStyle, AnnotationAlignment annotationAlignment, AnnotationSlot annotationSlot, RichDocumentStyleModel richDocumentStyleModel) {
        this(annotationType, str, null, annotationStyle, annotationAlignment, annotationSlot, richDocumentStyleModel);
    }

    public Annotation(AnnotationType annotationType, String str, RichDocumentText richDocumentText, AnnotationStyle annotationStyle, AnnotationAlignment annotationAlignment, AnnotationSlot annotationSlot, RichDocumentStyleModel richDocumentStyleModel) {
        this.f5608a = annotationType;
        this.f5609b = str;
        this.f5614g = richDocumentText;
        this.f5610c = annotationStyle;
        this.f5611d = annotationAlignment;
        this.f5612e = annotationSlot;
        this.f5613f = richDocumentStyleModel;
    }

    public static Annotation m5431a(AnnotationType annotationType, RichDocumentTextAnnotationModel richDocumentTextAnnotationModel, RichDocumentStyleModel richDocumentStyleModel) {
        if (richDocumentTextAnnotationModel == null) {
            return null;
        }
        return new Annotation(annotationType, richDocumentTextAnnotationModel.m6376b(), richDocumentTextAnnotationModel.m6375a(), AnnotationStyle.from(richDocumentTextAnnotationModel.m6378d()), AnnotationAlignment.from(richDocumentTextAnnotationModel.m6377c()), AnnotationSlot.from(richDocumentTextAnnotationModel.iu_()), richDocumentStyleModel);
    }
}
