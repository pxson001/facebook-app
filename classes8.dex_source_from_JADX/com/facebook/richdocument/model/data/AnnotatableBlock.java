package com.facebook.richdocument.model.data;

import com.facebook.graphql.enums.GraphQLAudioAnnotationPlayMode;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentLocationAnnotationModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextAnnotationModel;

/* compiled from: picked_city */
public interface AnnotatableBlock extends MediaPresentationBlock {
    RichDocumentTextAnnotationModel mo273c();

    RichDocumentTextAnnotationModel mo274e();

    RichDocumentLocationAnnotationModel mo275f();

    String mo276g();

    GraphQLAudioAnnotationPlayMode mo277h();

    RichDocumentTextAnnotationModel mo278i();

    RichDocumentTextAnnotationModel iV_();

    GraphQLDocumentFeedbackOptions mo280j();

    GraphQLFeedback mo281k();
}
