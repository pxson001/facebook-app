package com.facebook.search.results.rows.sections.videos.topvideo;

import android.view.View;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

/* compiled from: PICKER_SEARCH */
public class SearchVideoAttachmentPartDefinition<E extends HasPositionInformation, V extends View> extends MultiRowSinglePartDefinition<GraphQLStoryAttachment, Void, E, V> {
    private static final PaddingStyle f25296a;
    private final MultiRowSinglePartDefinition<GraphQLStoryAttachment, ?, E, V> f25297b;
    private final BackgroundPartDefinition f25298c;

    public final Object m28539a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f25297b, (GraphQLStoryAttachment) obj);
        subParts.a(this.f25298c, new StylingData(null, f25296a, Position.MIDDLE));
        return null;
    }

    public final boolean m28540a(Object obj) {
        return this.f25297b.a((GraphQLStoryAttachment) obj);
    }

    static {
        Builder a = Builder.a();
        a.b = -6.0f;
        a = a;
        a.d = -12.0f;
        a = a;
        a.c = -6.0f;
        f25296a = a.i();
    }

    @Inject
    public SearchVideoAttachmentPartDefinition(@Assisted MultiRowSinglePartDefinition<GraphQLStoryAttachment, ?, E, V> multiRowSinglePartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f25297b = multiRowSinglePartDefinition;
        this.f25298c = backgroundPartDefinition;
    }

    public final ViewType<V> m28538a() {
        return this.f25297b.a();
    }
}
