package com.facebook.feedplugins.graphqlstory.explanation;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLGraphSearchSnippet;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friend_requests_seen */
public class ExplanationSpannableBuilder {
    private static ExplanationSpannableBuilder f23157c;
    private static final Object f23158d = new Object();
    private final SocialContextSpannableBuilder f23159a;
    private final GraphQLStoryUtil f23160b;

    private static ExplanationSpannableBuilder m31268b(InjectorLike injectorLike) {
        return new ExplanationSpannableBuilder(SocialContextSpannableBuilder.m31270a(injectorLike), GraphQLStoryUtil.m9565a(injectorLike));
    }

    @Inject
    public ExplanationSpannableBuilder(SocialContextSpannableBuilder socialContextSpannableBuilder, GraphQLStoryUtil graphQLStoryUtil) {
        this.f23159a = socialContextSpannableBuilder;
        this.f23160b = graphQLStoryUtil;
    }

    public static ExplanationSpannableBuilder m31267a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ExplanationSpannableBuilder b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23158d) {
                ExplanationSpannableBuilder explanationSpannableBuilder;
                if (a2 != null) {
                    explanationSpannableBuilder = (ExplanationSpannableBuilder) a2.mo818a(f23158d);
                } else {
                    explanationSpannableBuilder = f23157c;
                }
                if (explanationSpannableBuilder == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31268b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23158d, b3);
                        } else {
                            f23157c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = explanationSpannableBuilder;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final Spannable m31269a(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        if (graphQLStory.aG() != null) {
            return this.f23159a.m31272a((FeedProps) feedProps);
        }
        if (graphQLStory.m22337W() != null) {
            return new SpannableString(graphQLStory.m22337W().mo2911a());
        }
        String a;
        if (GraphQLStoryUtil.m9579j(graphQLStory)) {
            a = ((GraphQLTextWithEntities) ((GraphQLGraphSearchSnippet) PropertyHelper.m21307i(graphQLStory).l().get(0)).a().get(0)).mo2911a();
        } else {
            a = null;
        }
        return new SpannableString(a);
    }
}
