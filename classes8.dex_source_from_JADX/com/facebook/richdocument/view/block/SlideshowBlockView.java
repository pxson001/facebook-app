package com.facebook.richdocument.view.block;

import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.presenter.SlideshowBlockPresenter;

/* compiled from: paged_data_source_received_duplicate */
public interface SlideshowBlockView extends AudioAnnotationAware, BlockView<SlideshowBlockPresenter>, FeedbackAware, LocationAnnotationAware, TextAnnotationAware {
    void mo404a(GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle, RichDocumentBlocksImpl richDocumentBlocksImpl);

    void mo405a(String str);
}
