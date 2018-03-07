package com.facebook.feedplugins.graphqlstory.header;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.LazyResources;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.goodfriends.abtest.FeedPrivacyRenderingQEStore;
import com.facebook.goodfriends.abtest.GoodFriendsFeedPrivacyRenderingQEStore;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLSponsoredData;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtil.ExternalClickableSpan;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: image/x-png2jpg */
public class BulletedHeaderSubtitleFormatter {
    private static BulletedHeaderSubtitleFormatter f20478g;
    private static final Object f20479h = new Object();
    private final Lazy<String> f20480a;
    private final Lazy<String> f20481b;
    private final LinkifyUtil f20482c;
    private final Lazy<Float> f20483d;
    private final FeedPrivacyRenderingQEStore f20484e;
    private final GoodFriendsFeedPrivacyRenderingQEStore f20485f;

    private static BulletedHeaderSubtitleFormatter m28218b(InjectorLike injectorLike) {
        return new BulletedHeaderSubtitleFormatter((Context) injectorLike.getInstance(Context.class), LinkifyUtil.m26532a(injectorLike), FeedPrivacyRenderingQEStore.m28224a(injectorLike), GoodFriendsFeedPrivacyRenderingQEStore.m28232a(injectorLike));
    }

    @Inject
    public BulletedHeaderSubtitleFormatter(Context context, LinkifyUtil linkifyUtil, FeedPrivacyRenderingQEStore feedPrivacyRenderingQEStore, GoodFriendsFeedPrivacyRenderingQEStore goodFriendsFeedPrivacyRenderingQEStore) {
        this.f20482c = linkifyUtil;
        this.f20484e = feedPrivacyRenderingQEStore;
        this.f20485f = goodFriendsFeedPrivacyRenderingQEStore;
        this.f20480a = LazyResources.m28239a(context, 2131233387);
        this.f20481b = LazyResources.m28239a(context, 2131233386);
        this.f20483d = LazyResources.m28240a(context.getResources(), 2131428860);
    }

    public static BulletedHeaderSubtitleFormatter m28213a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BulletedHeaderSubtitleFormatter b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20479h) {
                BulletedHeaderSubtitleFormatter bulletedHeaderSubtitleFormatter;
                if (a2 != null) {
                    bulletedHeaderSubtitleFormatter = (BulletedHeaderSubtitleFormatter) a2.mo818a(f20479h);
                } else {
                    bulletedHeaderSubtitleFormatter = f20478g;
                }
                if (bulletedHeaderSubtitleFormatter == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28218b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20479h, b3);
                        } else {
                            f20478g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = bulletedHeaderSubtitleFormatter;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    private void m28216a(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            if (spannableStringBuilder.length() != 0) {
                m28221a(spannableStringBuilder);
            }
            spannableStringBuilder.append(StringUtil.m3595b(charSequence));
        }
    }

    private CharSequence m28214a(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (graphQLStory.m22324J() != null) {
            m28216a(spannableStringBuilder, graphQLStory.m22324J().m23676y());
            LinkifyUtil linkifyUtil = this.f20482c;
            String y = ((GraphQLStory) feedProps.f13444a).m22324J().m23676y();
            Boolean valueOf;
            if (Strings.isNullOrEmpty(y)) {
                valueOf = Boolean.valueOf(false);
            } else {
                int indexOf = spannableStringBuilder.toString().indexOf(y);
                if (indexOf == -1) {
                    valueOf = Boolean.valueOf(false);
                } else {
                    String a = GraphQLStoryUtil.m9566a((GraphQLStory) feedProps.f13444a);
                    if (Strings.isNullOrEmpty(a)) {
                        valueOf = Boolean.valueOf(false);
                    } else {
                        spannableStringBuilder.setSpan(new ExternalClickableSpan(linkifyUtil, a, linkifyUtil.f18875o, linkifyUtil.f18870j, TrackableFeedProps.m27451a(feedProps)), indexOf, y.length() + indexOf, 33);
                        valueOf = Boolean.valueOf(true);
                    }
                }
            }
        }
        if (GraphQLHelper.m22517m(graphQLStory)) {
            GraphQLPlace Y = graphQLStory.m22339Y();
            if (Y.m24164q() != null) {
                m28216a(spannableStringBuilder, Y.m24164q().m23462N());
            }
        } else if (graphQLStory.ae() != null) {
            m28216a(spannableStringBuilder, graphQLStory.ae().m24126B());
        }
        if (StoryProps.m27465n(feedProps)) {
            m28216a(spannableStringBuilder, m28215a(GraphQLStoryUtil.m9588r(feedProps)));
        }
        return spannableStringBuilder;
    }

    @Nullable
    public final CharSequence m28220a(FeedProps<GraphQLStory> feedProps, String str) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        m28216a(spannableStringBuilder, (CharSequence) str);
        m28216a(spannableStringBuilder, m28214a((FeedProps) feedProps));
        if (spannableStringBuilder.length() == 0) {
            return null;
        }
        m28217a(graphQLStory, spannableStringBuilder);
        return spannableStringBuilder;
    }

    public final CharSequence m28222b(FeedProps<GraphQLStory> feedProps, String str) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        SpannableStringBuilder c = m28219c(feedProps, str);
        m28217a(graphQLStory, c);
        return c;
    }

    public final void m28221a(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(".");
        spannableStringBuilder.setSpan(new HeaderBulletSeparatorSpan(this.f20483d), length, length + 1, 17);
    }

    private SpannableStringBuilder m28219c(FeedProps<GraphQLStory> feedProps, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (StoryProps.m27465n(feedProps)) {
            CharSequence a = m28215a(GraphQLStoryUtil.m9588r(feedProps));
            if (a != null) {
                m28216a(spannableStringBuilder, a);
            }
        }
        return spannableStringBuilder;
    }

    private void m28217a(GraphQLStory graphQLStory, SpannableStringBuilder spannableStringBuilder) {
        GraphQLPrivacyScope c = GraphQLStoryHelper.m10201c(graphQLStory);
        if (spannableStringBuilder.length() != 0 && c != null && !this.f20484e.m28226a()) {
            if ((!"good_friends".equals(c.m23522s()) || !this.f20485f.m28234a()) && spannableStringBuilder.length() != 0 && GraphQLStoryHelper.m10201c(graphQLStory) != null) {
                m28221a(spannableStringBuilder);
            }
        }
    }

    private String m28215a(GraphQLSponsoredData graphQLSponsoredData) {
        if (graphQLSponsoredData == null) {
            return null;
        }
        if (graphQLSponsoredData.m24814n()) {
            return graphQLSponsoredData.mo2963b() ? (String) this.f20480a.get() : (String) this.f20481b.get();
        } else {
            return "";
        }
    }
}
