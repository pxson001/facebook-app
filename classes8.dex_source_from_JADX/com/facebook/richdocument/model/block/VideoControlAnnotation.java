package com.facebook.richdocument.model.block;

import com.facebook.richdocument.model.block.Annotation.AnnotationAlignment;
import com.facebook.richdocument.model.block.Annotation.AnnotationSlot;
import com.facebook.richdocument.model.block.Annotation.AnnotationStyle;
import com.facebook.richdocument.model.block.Annotation.AnnotationType;

/* compiled from: pin_source */
public class VideoControlAnnotation extends Annotation {
    public VideoControlAnnotation() {
        super(AnnotationType.VIDEO_CONTROL, null, AnnotationStyle.REGULAR, AnnotationAlignment.CENTER, AnnotationSlot.CENTER, null);
    }
}
