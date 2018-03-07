package com.facebook.notes.graphql;

import com.facebook.graphql.enums.GraphQLDocumentTextDirectionEnum;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.notes.graphql.NotesGraphQlModels.FBPrivacyScopeModel;
import com.facebook.notes.graphql.NotesGraphQlModels.NoteEdgeModel;
import com.facebook.notes.graphql.NotesGraphQlModels.NoteMasterModel.CoverPhotoModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.FBPage;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentEdge;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentEdge.DocumentAuthors;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentEdge.DocumentBodyElements;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.FBProfileModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentEdgeModel.CoverMediaModel;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentStyleModel;
import javax.annotation.Nullable;

/* compiled from: USN */
public class NoteEdgeToRichDocumentEdgeWrapper implements RichDocumentEdge {
    private final NoteEdgeModel f10482a;
    private final String f10483b;
    public final CoverPhotoModel f10484c;
    public final GraphQLFeedback f10485d;
    public final FBProfileModel f10486e;
    public final FBPrivacyScopeModel f10487f;
    private final DocumentBodyElementsWrapper f10488g;
    private final DocumentAuthorsWrapper f10489h;

    public NoteEdgeToRichDocumentEdgeWrapper(NoteEdgeModel noteEdgeModel, String str, CoverPhotoModel coverPhotoModel, GraphQLFeedback graphQLFeedback, FBProfileModel fBProfileModel, FBPrivacyScopeModel fBPrivacyScopeModel) {
        this.f10482a = noteEdgeModel;
        this.f10483b = str;
        this.f10484c = coverPhotoModel;
        this.f10485d = graphQLFeedback;
        this.f10486e = fBProfileModel;
        this.f10487f = fBPrivacyScopeModel;
        this.f10488g = new DocumentBodyElementsWrapper(noteEdgeModel.od_());
        this.f10489h = new DocumentAuthorsWrapper(noteEdgeModel.m10976d());
    }

    @Nullable
    public final String m10921b() {
        return this.f10483b;
    }

    public final int m10922c() {
        return 0;
    }

    @Nullable
    public final RichDocumentText m10923d() {
        return this.f10482a.m10974b();
    }

    @Nullable
    public final CoverMediaModel id_() {
        return null;
    }

    @Nullable
    public final RichDocumentText m10924g() {
        return this.f10482a.m10975c();
    }

    @Nullable
    public final DocumentAuthors ic_() {
        return this.f10489h;
    }

    @Nullable
    public final DocumentBodyElements ib_() {
        return this.f10488g;
    }

    @Nullable
    public final RichDocumentText m10925j() {
        return this.f10482a.m10977g();
    }

    @Nullable
    public final FBPage m10926k() {
        return this.f10482a.oc_();
    }

    @Nullable
    public final RichDocumentStyleModel m10927l() {
        return null;
    }

    @Nullable
    public final RichDocumentText m10928m() {
        return this.f10482a.ob_();
    }

    @Nullable
    public final RichDocumentText m10929n() {
        return this.f10482a.m10978j();
    }

    @Nullable
    public final String m10930o() {
        return this.f10482a.m10979k();
    }

    public final long m10931p() {
        return this.f10482a.m10980l();
    }

    @Nullable
    public final GraphQLDocumentTextDirectionEnum m10932q() {
        return GraphQLDocumentTextDirectionEnum.LEFT_TO_RIGHT;
    }
}
