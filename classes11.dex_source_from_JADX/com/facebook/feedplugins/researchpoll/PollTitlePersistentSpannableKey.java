package com.facebook.feedplugins.researchpoll;

import android.text.SpannableStringBuilder;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.spannable.PersistentSpannable;
import com.facebook.graphql.model.GraphQLResearchPollFeedUnit;
import com.facebook.ufiservices.flyout.FlyoutClickSource;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;

/* compiled from: canViewerAddAlbum without providing onClickCreateAlbumListener */
public class PollTitlePersistentSpannableKey implements ContextStateKey<String, PersistentSpannable> {
    private final GraphQLResearchPollFeedUnit f9035a;
    private final String f9036b;
    private final LinkifyUtil f9037c;

    public final Object m9739a() {
        if (this.f9035a.O().a().isEmpty()) {
            return new PersistentSpannable(new SpannableStringBuilder(""), false);
        }
        return new PersistentSpannable(new SpannableStringBuilder(this.f9037c.a(LinkifyUtilConverter.b(this.f9035a.O()), this.f9035a, FlyoutClickSource.TITLE, null)), false);
    }

    public PollTitlePersistentSpannableKey(GraphQLResearchPollFeedUnit graphQLResearchPollFeedUnit, LinkifyUtil linkifyUtil) {
        String g;
        this.f9035a = graphQLResearchPollFeedUnit;
        this.f9037c = linkifyUtil;
        StringBuilder stringBuilder = new StringBuilder("researchpoll:header:title:");
        if (graphQLResearchPollFeedUnit.g() != null) {
            g = graphQLResearchPollFeedUnit.g();
        } else {
            g = graphQLResearchPollFeedUnit.D();
        }
        String stringBuilder2 = stringBuilder.append(g).toString();
        if (!(graphQLResearchPollFeedUnit.O() == null || graphQLResearchPollFeedUnit.O().a() == null)) {
            stringBuilder2 = stringBuilder2 + ":" + graphQLResearchPollFeedUnit.O().a();
        }
        this.f9036b = stringBuilder2;
    }

    public final Object m9740b() {
        return this.f9036b;
    }
}
