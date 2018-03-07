package com.facebook.notes.graphql;

import com.facebook.notes.graphql.NotesGraphQlModels.NoteEdgeModel.DocumentBodyElementsModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentEdge.DocumentBodyElements;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentSectionEdge;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;

/* compiled from: UUID in context header view is null */
public class DocumentBodyElementsWrapper implements DocumentBodyElements {
    private final DocumentBodyElementsModel f10481a;

    public DocumentBodyElementsWrapper(DocumentBodyElementsModel documentBodyElementsModel) {
        this.f10481a = documentBodyElementsModel;
    }

    @Nonnull
    public final ImmutableList<? extends RichDocumentSectionEdge> m10920a() {
        return this.f10481a.m10955a();
    }
}
