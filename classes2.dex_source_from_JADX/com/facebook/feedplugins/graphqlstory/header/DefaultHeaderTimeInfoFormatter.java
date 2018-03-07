package com.facebook.feedplugins.graphqlstory.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.timeformat.FeedTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feedplugins.graphqlstory.page.actionablepage.PageStoryType;
import com.facebook.feedplugins.graphqlstory.page.actionablepage.PageStoryTypeResolver;
import com.facebook.graphql.enums.GraphQLStoryTimestampStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: image_cache_stats_counter */
public class DefaultHeaderTimeInfoFormatter {
    private static DefaultHeaderTimeInfoFormatter f20454b;
    private static final Object f20455c = new Object();
    private final TimeFormatUtil f20456a;

    private static DefaultHeaderTimeInfoFormatter m28193b(InjectorLike injectorLike) {
        return new DefaultHeaderTimeInfoFormatter(FeedTimeFormatUtil.m28196a(injectorLike));
    }

    @Inject
    public DefaultHeaderTimeInfoFormatter(TimeFormatUtil timeFormatUtil) {
        this.f20456a = timeFormatUtil;
    }

    public final String m28195a(FeedProps<GraphQLStory> feedProps) {
        if (!m28194b((FeedProps) feedProps)) {
            return "";
        }
        return this.f20456a.mo1649a(TimeFormatStyle.STREAM_RELATIVE_STYLE, ((GraphQLStory) feedProps.f13444a).m22336V() * 1000);
    }

    public static boolean m28194b(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (graphQLStory.m22336V() == 0) {
            return false;
        }
        if (graphQLStory.aB() != null && !graphQLStory.aB().isEmpty() && graphQLStory.aB().get(0) == GraphQLStoryTimestampStyle.NONE) {
            return false;
        }
        if (graphQLStory.ay() == null) {
            graphQLStory = StoryProps.m27456c(feedProps);
            return graphQLStory == null || graphQLStory.ay() == null;
        } else {
            PageStoryType a = PageStoryTypeResolver.m28081a((FeedProps) feedProps);
            return (a == PageStoryType.NCPP || a == PageStoryType.GROUPER || StoryActorHelper.m27491a(graphQLStory)) ? false : true;
        }
    }

    public static DefaultHeaderTimeInfoFormatter m28192a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultHeaderTimeInfoFormatter b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20455c) {
                DefaultHeaderTimeInfoFormatter defaultHeaderTimeInfoFormatter;
                if (a2 != null) {
                    defaultHeaderTimeInfoFormatter = (DefaultHeaderTimeInfoFormatter) a2.mo818a(f20455c);
                } else {
                    defaultHeaderTimeInfoFormatter = f20454b;
                }
                if (defaultHeaderTimeInfoFormatter == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28193b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20455c, b3);
                        } else {
                            f20454b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultHeaderTimeInfoFormatter;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
