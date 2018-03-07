package com.facebook.richdocument.model.block;

import com.facebook.richdocument.model.block.Annotation.AnnotationAlignment;
import com.facebook.richdocument.model.block.Annotation.AnnotationSlot;
import com.facebook.richdocument.model.block.Annotation.AnnotationStyle;
import com.facebook.richdocument.model.block.Annotation.AnnotationType;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentLocationAnnotationModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentStyleModel;

/* compiled from: place-suggest-info */
public class LocationAnnotation extends Annotation {
    private final RichDocumentLocationAnnotationModel f5621a;

    public LocationAnnotation(String str, AnnotationStyle annotationStyle, AnnotationAlignment annotationAlignment, AnnotationSlot annotationSlot, RichDocumentLocationAnnotationModel richDocumentLocationAnnotationModel, RichDocumentStyleModel richDocumentStyleModel) {
        super(AnnotationType.LOCATION, str, annotationStyle, annotationAlignment, annotationSlot, richDocumentStyleModel);
        this.f5621a = richDocumentLocationAnnotationModel;
    }
}
