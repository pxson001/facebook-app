package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.MinutiaeAttachmentTextPartDefinition.Props;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.ufiservices.flyout.FlyoutClickSource;
import javax.inject.Inject;

@ContextScoped
/* compiled from: inflight_packet_loss */
public class MinutiaeAttachmentGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static MinutiaeAttachmentGroupPartDefinition f20155d;
    private static final Object f20156e = new Object();
    private final MinutiaeAttachmentIconPartDefinition f20157a;
    private final Lazy<MinutiaeAttachmentTextPartDefinition<FeedEnvironment>> f20158b;
    private final Lazy<MinutiaeAttachmentTextComponentPartDefinition<FeedEnvironment>> f20159c;

    private static MinutiaeAttachmentGroupPartDefinition m27829b(InjectorLike injectorLike) {
        return new MinutiaeAttachmentGroupPartDefinition(MinutiaeAttachmentIconPartDefinition.m27832a(injectorLike), IdBasedLazy.m1808a(injectorLike, 5987), IdBasedLazy.m1808a(injectorLike, 5986));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        Object a = feedProps.m19803a(StoryAttachmentHelper.m28042o((GraphQLStory) feedProps.f13444a));
        baseMultiRowSubParts.m19112a(this.f20157a, a);
        Object props = new Props(a, FlyoutClickSource.TITLE, "Title");
        SubPartsSelector.m19115a(baseMultiRowSubParts, this.f20159c, props).m19119a(this.f20158b, props);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        return GraphQLStoryAttachmentUtil.m28049a(StoryAttachmentHelper.m28042o((GraphQLStory) ((FeedProps) obj).f13444a), GraphQLStoryAttachmentStyle.MINUTIAE_UNIT);
    }

    @Inject
    public MinutiaeAttachmentGroupPartDefinition(MinutiaeAttachmentIconPartDefinition minutiaeAttachmentIconPartDefinition, Lazy<MinutiaeAttachmentTextPartDefinition> lazy, Lazy<MinutiaeAttachmentTextComponentPartDefinition> lazy2) {
        this.f20157a = minutiaeAttachmentIconPartDefinition;
        this.f20158b = lazy;
        this.f20159c = lazy2;
    }

    public static MinutiaeAttachmentGroupPartDefinition m27828a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MinutiaeAttachmentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20156e) {
                MinutiaeAttachmentGroupPartDefinition minutiaeAttachmentGroupPartDefinition;
                if (a2 != null) {
                    minutiaeAttachmentGroupPartDefinition = (MinutiaeAttachmentGroupPartDefinition) a2.mo818a(f20156e);
                } else {
                    minutiaeAttachmentGroupPartDefinition = f20155d;
                }
                if (minutiaeAttachmentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27829b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20156e, b3);
                        } else {
                            f20155d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = minutiaeAttachmentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
