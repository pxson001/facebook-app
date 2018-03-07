package com.facebook.richdocument.model.block;

import com.facebook.richdocument.model.block.Annotation.AnnotationAlignment;
import com.facebook.richdocument.model.block.Annotation.AnnotationSlot;
import com.facebook.richdocument.model.block.Annotation.AnnotationStyle;
import com.facebook.richdocument.model.block.Annotation.AnnotationType;

/* compiled from: placeCategory */
public class ImageLoadingIndicatorAnnotation extends Annotation {
    public ImageLoadingIndicatorAnnotation() {
        super(AnnotationType.LOADING_INDICATOR, null, AnnotationStyle.REGULAR, AnnotationAlignment.CENTER, AnnotationSlot.CENTER, null);
    }
}
