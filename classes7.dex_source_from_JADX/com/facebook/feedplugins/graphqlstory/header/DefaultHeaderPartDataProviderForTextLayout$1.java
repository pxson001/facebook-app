package com.facebook.feedplugins.graphqlstory.header;

import android.content.Intent;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.graphql.model.GraphQLExploreFeed;

/* compiled from: reportable_ent_token */
class DefaultHeaderPartDataProviderForTextLayout$1 extends ClickableSpan {
    final /* synthetic */ GraphQLExploreFeed f5245a;
    final /* synthetic */ DefaultHeaderPartDataProviderForTextLayout f5246b;

    DefaultHeaderPartDataProviderForTextLayout$1(DefaultHeaderPartDataProviderForTextLayout defaultHeaderPartDataProviderForTextLayout, GraphQLExploreFeed graphQLExploreFeed) {
        this.f5246b = defaultHeaderPartDataProviderForTextLayout;
        this.f5245a = graphQLExploreFeed;
    }

    public void onClick(View view) {
        Intent b = this.f5246b.g.b();
        b.putExtra("feed_type_name", Name.k.A);
        b.putExtra("topic_id", this.f5245a.n());
        b.putExtra("topic_name", this.f5245a.q());
        this.f5246b.q.a(b, view.getContext());
    }
}
