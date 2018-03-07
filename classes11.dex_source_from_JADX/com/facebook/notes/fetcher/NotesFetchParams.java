package com.facebook.notes.fetcher;

import android.content.Context;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.instantarticles.fetcher.BaseInstantArticlesFetchParams;
import com.facebook.notes.graphql.NotesGraphQl.NoteQueryString;
import com.facebook.notes.graphql.NotesGraphQlModels.NoteMasterModel;

/* compiled from: Unable to retrieve current vm policy. */
public class NotesFetchParams extends BaseInstantArticlesFetchParams<NoteMasterModel> {
    public NotesFetchParams(Context context, String str) {
        super(context, str);
    }

    public final Object m10910a() {
        GraphQLRequest a = GraphQLRequest.a((NoteQueryString) new NoteQueryString().a("noteID", this.b).a("maxAuthors", Integer.valueOf(this.c)).a("maxElements", Integer.valueOf(this.d)).a("maxListElements", Integer.valueOf(this.e)).a("maxSlideshowMedia", Integer.valueOf(this.f)).a("media_type", this.g).a("scale", this.h).a("final_image_width", Integer.valueOf(2500)).a("final_image_height", Integer.valueOf(this.n))).a(this.i);
        a.b = true;
        return a.a(this.p).a(this.j);
    }
}
