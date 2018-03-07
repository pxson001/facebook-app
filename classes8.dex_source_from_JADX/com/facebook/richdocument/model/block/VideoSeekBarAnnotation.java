package com.facebook.richdocument.model.block;

import com.facebook.richdocument.model.block.Annotation.AnnotationAlignment;
import com.facebook.richdocument.model.block.Annotation.AnnotationSlot;
import com.facebook.richdocument.model.block.Annotation.AnnotationStyle;
import com.facebook.richdocument.model.block.Annotation.AnnotationType;

/* compiled from: picture_uri */
public class VideoSeekBarAnnotation extends Annotation {
    public VideoSeekBarAnnotation() {
        super(AnnotationType.VIDEO_SEEK_BAR, null, AnnotationStyle.REGULAR, AnnotationAlignment.LEFT, AnnotationSlot.BOTTOM, null);
    }
}
