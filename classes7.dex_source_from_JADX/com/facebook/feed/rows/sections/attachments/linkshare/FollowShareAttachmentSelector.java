package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.linkshare.follow.FollowAuthorUtil;
import com.facebook.feedplugins.attachments.linkshare.follow.FollowPageShareAttachmentPartDefinition;
import com.facebook.feedplugins.attachments.linkshare.follow.FollowUserShareAttachmentPartDefinition;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ViewManager for tag  */
public class FollowShareAttachmentSelector extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static FollowShareAttachmentSelector f20960c;
    private static final Object f20961d = new Object();
    private final FollowPageShareAttachmentPartDefinition<FeedEnvironment> f20962a;
    private final FollowUserShareAttachmentPartDefinition<FeedEnvironment> f20963b;

    private static FollowShareAttachmentSelector m23874b(InjectorLike injectorLike) {
        return new FollowShareAttachmentSelector(FollowUserShareAttachmentPartDefinition.m25278a(injectorLike), FollowPageShareAttachmentPartDefinition.m25270a(injectorLike));
    }

    public final Object m23875a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f20962a, feedProps).a(this.f20963b, feedProps);
        return null;
    }

    public final boolean m23876a(Object obj) {
        return FollowAuthorUtil.a((GraphQLStoryAttachment) ((FeedProps) obj).a);
    }

    @Inject
    public FollowShareAttachmentSelector(FollowUserShareAttachmentPartDefinition followUserShareAttachmentPartDefinition, FollowPageShareAttachmentPartDefinition followPageShareAttachmentPartDefinition) {
        this.f20963b = followUserShareAttachmentPartDefinition;
        this.f20962a = followPageShareAttachmentPartDefinition;
    }

    public static FollowShareAttachmentSelector m23873a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FollowShareAttachmentSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20961d) {
                FollowShareAttachmentSelector followShareAttachmentSelector;
                if (a2 != null) {
                    followShareAttachmentSelector = (FollowShareAttachmentSelector) a2.a(f20961d);
                } else {
                    followShareAttachmentSelector = f20960c;
                }
                if (followShareAttachmentSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23874b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20961d, b3);
                        } else {
                            f20960c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = followShareAttachmentSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
