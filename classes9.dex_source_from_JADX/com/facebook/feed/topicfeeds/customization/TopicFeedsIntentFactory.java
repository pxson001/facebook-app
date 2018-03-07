package com.facebook.feed.topicfeeds.customization;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import java.io.Serializable;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: TRANSFER_INITED */
public class TopicFeedsIntentFactory {
    private final Context f24590a;
    @LoggedInUserId
    private final Provider<String> f24591b;
    private final UriIntentMapper f24592c;

    public static TopicFeedsIntentFactory m26508b(InjectorLike injectorLike) {
        return new TopicFeedsIntentFactory((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 4442), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike));
    }

    @Inject
    public TopicFeedsIntentFactory(Context context, Provider<String> provider, UriIntentMapper uriIntentMapper) {
        this.f24590a = context;
        this.f24591b = provider;
        this.f24592c = uriIntentMapper;
    }

    public final Intent m26509a(GraphQLExploreFeed graphQLExploreFeed) {
        Intent a = this.f24592c.a(this.f24590a, StringFormatUtil.a(FBLinks.fm, new Object[]{this.f24591b.get()}));
        Bundle bundle = new Bundle();
        bundle.putString("topicId", graphQLExploreFeed.n());
        bundle.putString("topicName", graphQLExploreFeed.q());
        bundle.putBoolean("searchable", graphQLExploreFeed.r());
        a.putExtra("init_props", bundle);
        a.putExtra("analytics_tag", "topic_feeds_customization");
        Serializable hashMap = new HashMap();
        hashMap.put("topic_id", graphQLExploreFeed.n());
        a.putExtra("analytics_extra_data", hashMap);
        return a;
    }
}
