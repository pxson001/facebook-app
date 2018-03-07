package com.facebook.feed.server;

import com.facebook.controller.mutation.util.AttachmentListMutator;
import com.facebook.controller.mutation.util.AttachmentMutator;
import com.facebook.feed.protocol.QuestionAddPollOptionModels$QuestionAddResponseMutationModel;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.executor.iface.CustomMutationVisitorFactory;
import javax.inject.Inject;

/* compiled from: feed_fetch_paginated_related_story */
public class QuestionAddPollCacheVisitorFactory implements CustomMutationVisitorFactory<QuestionAddPollOptionModels$QuestionAddResponseMutationModel> {
    private final QuestionMutationCacheVisitorProvider f11881a;

    public final CacheVisitor mo882a(Object obj) {
        QuestionAddPollOptionModels$QuestionAddResponseMutationModel questionAddPollOptionModels$QuestionAddResponseMutationModel = (QuestionAddPollOptionModels$QuestionAddResponseMutationModel) obj;
        QuestionMutationCacheVisitorProvider questionMutationCacheVisitorProvider = this.f11881a;
        return new QuestionMutationCacheVisitor(questionAddPollOptionModels$QuestionAddResponseMutationModel, AttachmentMutator.b(questionMutationCacheVisitorProvider), AttachmentListMutator.b(questionMutationCacheVisitorProvider));
    }

    @Inject
    public QuestionAddPollCacheVisitorFactory(QuestionMutationCacheVisitorProvider questionMutationCacheVisitorProvider) {
        this.f11881a = questionMutationCacheVisitorProvider;
    }

    public final Class mo883a() {
        return QuestionAddPollOptionModels$QuestionAddResponseMutationModel.class;
    }
}
