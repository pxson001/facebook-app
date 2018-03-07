package com.facebook.notes.graphql;

import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.notes.graphql.NotesGraphQlModels.NoteMasterModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentEdge;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentMaster;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.FBMessengerSubscriptionInfoModel.MessengerContentSubscriptionOptionModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentMasterModel.RelatedArticleObjectsModel;
import javax.annotation.Nullable;

/* compiled from: USE_SECONDARY_ACTION */
public class NoteToRichDocumentWrapper implements RichDocumentMaster {
    private final NoteMasterModel f10490a;
    public final NoteEdgeToRichDocumentEdgeWrapper f10491b;

    public NoteToRichDocumentWrapper(NoteMasterModel noteMasterModel) {
        this.f10490a = noteMasterModel;
        this.f10491b = new NoteEdgeToRichDocumentEdgeWrapper(noteMasterModel.og_(), noteMasterModel.of_(), noteMasterModel.m11001b(), noteMasterModel.m11002c(), noteMasterModel.m11003d(), noteMasterModel.m11004g());
    }

    @Nullable
    public final String m10934c() {
        return this.f10490a.oe_();
    }

    @Nullable
    public final RelatedArticleObjectsModel ij_() {
        return null;
    }

    @Nullable
    public final /* synthetic */ RichDocumentEdge m10936g() {
        return this.f10491b;
    }

    @Nullable
    public final MessengerContentSubscriptionOptionModel m10935d() {
        return null;
    }

    @Nullable
    public final GraphQLFeedback m10933b() {
        return null;
    }
}
