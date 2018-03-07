package com.facebook.links;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.linkutil.LinkExtractorConverter;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.graphql.story.util.StoryUtilModelConverter;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_uberbar_result */
public class AttachmentLinkInspector {
    private static AttachmentLinkInspector f23843b;
    private static final Object f23844c = new Object();
    private final GraphQLLinkExtractor f23845a;

    private static AttachmentLinkInspector m32232b(InjectorLike injectorLike) {
        return new AttachmentLinkInspector(GraphQLLinkExtractor.m26442a(injectorLike));
    }

    @Inject
    public AttachmentLinkInspector(GraphQLLinkExtractor graphQLLinkExtractor) {
        this.f23845a = graphQLLinkExtractor;
    }

    public final String m32235a(FeedProps<GraphQLStoryAttachment> feedProps) {
        String str;
        String a;
        GraphQLStory c = AttachmentProps.m28714c(feedProps);
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        if (m32234c(feedProps)) {
            str = (String) graphQLStoryAttachment.m23987z().m23365J().get(0);
        } else {
            str = null;
        }
        GraphQLStoryActionLink a2 = ActionLinkHelper.m22935a(graphQLStoryAttachment);
        if (a2 != null && a2.m22901a() != null && a2.m22901a().m22301g() == 1511838959 && a2.m22874A() != null) {
            a = GraphQLLinkExtractor.m26444a(67338874, a2.m22874A().as());
        } else if (graphQLStoryAttachment.m23987z() != null) {
            a = this.f23845a.m26449a(LinkExtractorConverter.a(graphQLStoryAttachment.m23987z()));
        } else {
            a = null;
        }
        if (!Strings.isNullOrEmpty(str)) {
            return str;
        }
        if (!Strings.isNullOrEmpty(a)) {
            return a;
        }
        if (Strings.isNullOrEmpty(graphQLStoryAttachment.m23966C())) {
            return (c == null || Strings.isNullOrEmpty(c.aO())) ? null : c.aO();
        } else {
            return graphQLStoryAttachment.m23966C();
        }
    }

    public static AttachmentLinkInspector m32230a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AttachmentLinkInspector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23844c) {
                AttachmentLinkInspector attachmentLinkInspector;
                if (a2 != null) {
                    attachmentLinkInspector = (AttachmentLinkInspector) a2.mo818a(f23844c);
                } else {
                    attachmentLinkInspector = f23843b;
                }
                if (attachmentLinkInspector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32232b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23844c, b3);
                        } else {
                            f23843b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = attachmentLinkInspector;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public static boolean m32233b(FeedProps<GraphQLStoryAttachment> feedProps) {
        FeedProps e = AttachmentProps.m28715e(feedProps);
        return e != null && StoryProps.m27466p(e);
    }

    public static boolean m32231a(GraphQLStoryAttachment graphQLStoryAttachment) {
        return GraphQLStoryUtil.m9569a(StoryUtilModelConverter.m28876a(graphQLStoryAttachment), -1703624614, -1304042141);
    }

    public static boolean m32234c(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        return (graphQLStoryAttachment.m23987z() == null || graphQLStoryAttachment.m23987z().m23365J() == null || graphQLStoryAttachment.m23987z().m23365J().isEmpty()) ? false : true;
    }
}
