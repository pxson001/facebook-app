package com.facebook.notes.graphql;

import com.facebook.notes.graphql.NotesGraphQlModels.NoteEdgeModel.DocumentAuthorsModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentAuthorEdge;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentEdge.DocumentAuthors;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;

/* compiled from: UUID in context heaeder view is null */
public class DocumentAuthorsWrapper implements DocumentAuthors {
    private final DocumentAuthorsModel f10480a;

    public DocumentAuthorsWrapper(DocumentAuthorsModel documentAuthorsModel) {
        this.f10480a = documentAuthorsModel;
    }

    @Nonnull
    public final ImmutableList<? extends RichDocumentAuthorEdge> m10919a() {
        return this.f10480a.m10949a();
    }
}
