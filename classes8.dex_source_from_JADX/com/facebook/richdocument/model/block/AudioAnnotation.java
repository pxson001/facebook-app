package com.facebook.richdocument.model.block;

import com.facebook.graphql.enums.GraphQLAudioAnnotationPlayMode;
import com.facebook.richdocument.model.block.Annotation.AnnotationAlignment;
import com.facebook.richdocument.model.block.Annotation.AnnotationSlot;
import com.facebook.richdocument.model.block.Annotation.AnnotationStyle;
import com.facebook.richdocument.model.block.Annotation.AnnotationType;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentStyleModel;

/* compiled from: placePriceRange */
public final class AudioAnnotation extends Annotation {
    public String f5615a;
    public GraphQLAudioAnnotationPlayMode f5616b;

    public AudioAnnotation(String str, GraphQLAudioAnnotationPlayMode graphQLAudioAnnotationPlayMode, String str2, AnnotationAlignment annotationAlignment, RichDocumentStyleModel richDocumentStyleModel) {
        super(AnnotationType.AUDIO, str2, AnnotationStyle.MINI_LABEL, annotationAlignment, AnnotationSlot.TOP, richDocumentStyleModel);
        this.f5615a = str;
        this.f5616b = graphQLAudioAnnotationPlayMode;
    }
}
