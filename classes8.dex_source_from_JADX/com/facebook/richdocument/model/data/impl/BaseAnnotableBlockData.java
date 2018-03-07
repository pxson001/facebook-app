package com.facebook.richdocument.model.data.impl;

import com.facebook.graphql.enums.GraphQLAudioAnnotationPlayMode;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.richdocument.model.data.AnnotatableBlock;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.impl.BaseBlockData.BaseBlockDataBuilder;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentLocationAnnotationModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextAnnotationModel;

/* compiled from: photo_upload_waterfall_id */
public abstract class BaseAnnotableBlockData extends BaseBlockData implements AnnotatableBlock {
    private final RichDocumentTextAnnotationModel f5686a;
    private final RichDocumentTextAnnotationModel f5687b;
    private final RichDocumentTextAnnotationModel f5688c;
    private final RichDocumentLocationAnnotationModel f5689d;
    private final String f5690e;
    private final GraphQLAudioAnnotationPlayMode f5691f;
    private final RichDocumentTextAnnotationModel f5692g;
    private final GraphQLDocumentFeedbackOptions f5693h;
    private final GraphQLFeedback f5694i;

    /* compiled from: photo_upload_waterfall_id */
    public abstract class BaseAnnotatableBlockBuilder<T extends AnnotatableBlock & BlockData> extends BaseBlockDataBuilder<T> {
        public RichDocumentTextAnnotationModel f5677a;
        public RichDocumentTextAnnotationModel f5678b;
        public RichDocumentTextAnnotationModel f5679c;
        public RichDocumentLocationAnnotationModel f5680d;
        public String f5681e;
        public GraphQLAudioAnnotationPlayMode f5682f;
        public RichDocumentTextAnnotationModel f5683g;
        public GraphQLDocumentFeedbackOptions f5684h;
        public GraphQLFeedback f5685i;

        public BaseAnnotatableBlockBuilder(int i) {
            super(i);
        }

        public final BaseAnnotatableBlockBuilder m5496a(String str, GraphQLAudioAnnotationPlayMode graphQLAudioAnnotationPlayMode, RichDocumentTextAnnotationModel richDocumentTextAnnotationModel) {
            this.f5681e = str;
            this.f5682f = graphQLAudioAnnotationPlayMode;
            this.f5683g = richDocumentTextAnnotationModel;
            return this;
        }

        public final BaseAnnotatableBlockBuilder m5495a(GraphQLDocumentFeedbackOptions graphQLDocumentFeedbackOptions, GraphQLFeedback graphQLFeedback) {
            this.f5684h = graphQLDocumentFeedbackOptions;
            this.f5685i = graphQLFeedback;
            return this;
        }
    }

    public BaseAnnotableBlockData(BaseAnnotatableBlockBuilder baseAnnotatableBlockBuilder) {
        super((BaseBlockDataBuilder) baseAnnotatableBlockBuilder);
        this.f5686a = baseAnnotatableBlockBuilder.f5677a;
        this.f5687b = baseAnnotatableBlockBuilder.f5678b;
        this.f5688c = baseAnnotatableBlockBuilder.f5679c;
        this.f5689d = baseAnnotatableBlockBuilder.f5680d;
        this.f5690e = baseAnnotatableBlockBuilder.f5681e;
        this.f5691f = baseAnnotatableBlockBuilder.f5682f;
        this.f5692g = baseAnnotatableBlockBuilder.f5683g;
        this.f5693h = baseAnnotatableBlockBuilder.f5684h;
        this.f5694i = baseAnnotatableBlockBuilder.f5685i;
    }

    public final GraphQLAudioAnnotationPlayMode mo277h() {
        return this.f5691f;
    }

    public final RichDocumentTextAnnotationModel mo273c() {
        return this.f5686a;
    }

    public final RichDocumentTextAnnotationModel iV_() {
        return this.f5687b;
    }

    public final RichDocumentTextAnnotationModel mo274e() {
        return this.f5688c;
    }

    public final RichDocumentLocationAnnotationModel mo275f() {
        return this.f5689d;
    }

    public final String mo276g() {
        return this.f5690e;
    }

    public final RichDocumentTextAnnotationModel mo278i() {
        return this.f5692g;
    }

    public final GraphQLFeedback mo281k() {
        return this.f5694i;
    }

    public final GraphQLDocumentFeedbackOptions mo280j() {
        return this.f5693h;
    }
}
