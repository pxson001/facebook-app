package com.facebook.notes.model.block;

import android.content.Context;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.instantarticles.model.data.RichDocumentMasterAdapter;
import com.facebook.notes.graphql.NoteEdgeToRichDocumentEdgeWrapper;
import com.facebook.notes.graphql.NoteToRichDocumentWrapper;
import com.facebook.notes.graphql.NotesGraphQlModels.NoteMasterModel.CoverPhotoModel;
import com.facebook.notes.model.data.impl.UFIBlockDataImpl;
import com.facebook.richdocument.model.block.FeedbackAnnotation;
import com.facebook.richdocument.model.block.v2.RichDocumentBlocksImpl;
import com.facebook.richdocument.model.data.impl.ImageBlockDataImpl.ImageBlockDataBuilder;

/* compiled from: UNKNOWN_INSECURE */
public class NotesMasterAdapter extends RichDocumentMasterAdapter {
    public NotesMasterAdapter(Context context) {
        super(context);
    }

    public final RichDocumentBlocksImpl m11032a(NoteToRichDocumentWrapper noteToRichDocumentWrapper) {
        NoteEdgeToRichDocumentEdgeWrapper noteEdgeToRichDocumentEdgeWrapper = noteToRichDocumentWrapper.f10491b;
        NotesBlocksBuilder g = new NotesBlocksBuilder(this.a).m11028e(noteToRichDocumentWrapper.m10934c()).m11030f(noteEdgeToRichDocumentEdgeWrapper.m10921b()).m11025b(noteEdgeToRichDocumentEdgeWrapper.m10922c()).m11031g(noteEdgeToRichDocumentEdgeWrapper.m10929n().d());
        CoverPhotoModel coverPhotoModel = noteEdgeToRichDocumentEdgeWrapper.f10484c;
        if (coverPhotoModel != null) {
            String str = g.j;
            ImageBlockDataBuilder imageBlockDataBuilder = new ImageBlockDataBuilder(coverPhotoModel.m10992a(), GraphQLDocumentMediaPresentationStyle.NON_INTERACTIVE);
            imageBlockDataBuilder.g = str;
            imageBlockDataBuilder = imageBlockDataBuilder;
            imageBlockDataBuilder.e = true;
            g.p = imageBlockDataBuilder.c();
        }
        NotesBlocksBuilder notesBlocksBuilder = g;
        notesBlocksBuilder.f10524A = noteEdgeToRichDocumentEdgeWrapper.f10486e;
        notesBlocksBuilder.m11029f(noteEdgeToRichDocumentEdgeWrapper.m10929n()).f10525B = new TimestampAndPrivacyInfoWrapper(noteEdgeToRichDocumentEdgeWrapper.m10931p(), noteEdgeToRichDocumentEdgeWrapper.f10487f.m10943a());
        g.a(noteEdgeToRichDocumentEdgeWrapper.ib_());
        FeedbackAnnotation a = FeedbackAnnotation.a(GraphQLDocumentFeedbackOptions.LIKES_AND_COMMENTS, noteEdgeToRichDocumentEdgeWrapper.f10485d, g.f10526y);
        if (a != null) {
            g.f10527z = new UFIBlockDataImpl(a);
        }
        return g.b();
    }
}
