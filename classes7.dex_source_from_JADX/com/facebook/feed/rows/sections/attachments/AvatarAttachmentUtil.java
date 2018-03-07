package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.feedplugins.graphqlstory.page.actionablepage.PageStoryType;
import com.facebook.feedplugins.graphqlstory.page.actionablepage.PageStoryTypeResolver;
import com.facebook.feedplugins.graphqlstory.page.actionablepage.PrimaryActionLinkResolver;
import com.facebook.graphql.model.GraphQLBylineFragment;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.resources.utils.ResourceUtils;
import com.facebook.text.CustomFontUtil;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: [[content]] */
public class AvatarAttachmentUtil {
    private static AvatarAttachmentUtil f20536e;
    private static final Object f20537f = new Object();
    private final CustomFontUtil f20538a;
    private final Spannable f20539b = SpannableStringBuilder.valueOf(this.f20541d.getString(2131233219));
    private final LegacyAngoraAttachmentUtil f20540c;
    private final Resources f20541d;

    private static AvatarAttachmentUtil m23596b(InjectorLike injectorLike) {
        return new AvatarAttachmentUtil(LegacyAngoraAttachmentUtil.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), CustomFontUtil.a(injectorLike));
    }

    @Inject
    public AvatarAttachmentUtil(LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, Resources resources, CustomFontUtil customFontUtil) {
        this.f20540c = legacyAngoraAttachmentUtil;
        this.f20541d = resources;
        this.f20538a = customFontUtil;
    }

    public static AvatarAttachmentUtil m23595a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AvatarAttachmentUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20537f) {
                AvatarAttachmentUtil avatarAttachmentUtil;
                if (a2 != null) {
                    avatarAttachmentUtil = (AvatarAttachmentUtil) a2.a(f20537f);
                } else {
                    avatarAttachmentUtil = f20536e;
                }
                if (avatarAttachmentUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23596b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20537f, b3);
                        } else {
                            f20536e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = avatarAttachmentUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Spannable m23599b(FeedProps<GraphQLStoryAttachment> feedProps) {
        FeedProps e = AttachmentProps.e(feedProps);
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        GraphQLStoryActionLink a = PrimaryActionLinkResolver.a((GraphQLStory) e.a);
        if (m23597d(e) && a.ab() != null && GraphQLHelper.c(a.ab()) > 0) {
            return SpannableStringBuilder.valueOf(ResourceUtils.a(this.f20541d, 2131233554, 2131233555, GraphQLHelper.c(a.ab())));
        } else if (GraphQLStoryAttachmentUtil.q(graphQLStoryAttachment)) {
            return this.f20539b;
        } else {
            if (graphQLStoryAttachment.n() != null) {
                return SpannableStringBuilder.valueOf(graphQLStoryAttachment.n().a());
            }
            return null;
        }
    }

    public final Spannable m23598a(FeedProps<GraphQLStoryAttachment> feedProps) {
        String b;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        Spannable spannableStringBuilder = new SpannableStringBuilder();
        if (!Strings.isNullOrEmpty(graphQLStoryAttachment.A())) {
            spannableStringBuilder.append(graphQLStoryAttachment.A());
            spannableStringBuilder.setSpan(CustomFontUtil.a(), 0, graphQLStoryAttachment.A().length(), 17);
        }
        FeedProps e = AttachmentProps.e(feedProps);
        GraphQLStoryAttachment graphQLStoryAttachment2 = (GraphQLStoryAttachment) feedProps.a;
        GraphQLStoryActionLink a = PrimaryActionLinkResolver.a((GraphQLStory) e.a);
        if (m23597d(e) && a.ab() != null && GraphQLHelper.a(a.ab())) {
            b = GraphQLHelper.b(a.ab());
        } else {
            if (graphQLStoryAttachment2.z() != null) {
                int i;
                GraphQLNode z = graphQLStoryAttachment2.z();
                if (z.ar() == null || z.ar().isEmpty() || ((GraphQLBylineFragment) z.ar().get(0)).a() == null) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    b = ((GraphQLBylineFragment) graphQLStoryAttachment2.z().ar().get(0)).a().a();
                }
            }
            b = null;
        }
        String str = b;
        if (str != null) {
            LegacyAngoraAttachmentUtil.a(spannableStringBuilder);
            spannableStringBuilder.append(str);
        }
        return spannableStringBuilder;
    }

    public static boolean m23597d(FeedProps<GraphQLStory> feedProps) {
        return feedProps != null && PageStoryTypeResolver.a(feedProps) == PageStoryType.PAGE_LIKE;
    }
}
