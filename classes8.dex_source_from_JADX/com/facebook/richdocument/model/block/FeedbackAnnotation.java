package com.facebook.richdocument.model.block;

import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.richdocument.model.block.Annotation.AnnotationAlignment;
import com.facebook.richdocument.model.block.Annotation.AnnotationSlot;
import com.facebook.richdocument.model.block.Annotation.AnnotationStyle;
import com.facebook.richdocument.model.block.Annotation.AnnotationType;
import com.facebook.richdocument.view.util.RichDocumentLayoutDirection;

/* compiled from: placeHourRanges */
public class FeedbackAnnotation extends Annotation {
    public GraphQLDocumentFeedbackOptions f5619a;
    public GraphQLFeedback f5620b;

    private FeedbackAnnotation(GraphQLDocumentFeedbackOptions graphQLDocumentFeedbackOptions, GraphQLFeedback graphQLFeedback, AnnotationAlignment annotationAlignment) {
        super(AnnotationType.UFI, null, AnnotationStyle.REGULAR, annotationAlignment, AnnotationSlot.BELOW, null);
        this.f5619a = graphQLDocumentFeedbackOptions;
        this.f5620b = graphQLFeedback;
    }

    public static FeedbackAnnotation m5432a(GraphQLDocumentFeedbackOptions graphQLDocumentFeedbackOptions, GraphQLFeedback graphQLFeedback, RichDocumentLayoutDirection richDocumentLayoutDirection) {
        if (graphQLDocumentFeedbackOptions == null || graphQLFeedback == null) {
            return null;
        }
        return new FeedbackAnnotation(graphQLDocumentFeedbackOptions, graphQLFeedback, richDocumentLayoutDirection.m7369a() ? AnnotationAlignment.RIGHT : AnnotationAlignment.LEFT);
    }
}
