package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.video.VideoAttachmentsSelectorPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.GraphQLStoryAttachment;
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
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: gms_dialog_mechanism */
public class ThrowbackVideoCardAttachmentGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static ThrowbackVideoCardAttachmentGroupPartDefinition f12618c;
    private static final Object f12619d = new Object();
    private final Lazy<FriendversaryInProductBrandingAttachmentHeaderPartDefinition> f12620a;
    private final Lazy<VideoAttachmentsSelectorPartDefinition> f12621b;

    private static ThrowbackVideoCardAttachmentGroupPartDefinition m14461b(InjectorLike injectorLike) {
        return new ThrowbackVideoCardAttachmentGroupPartDefinition(IdBasedLazy.a(injectorLike, 6255), IdBasedLazy.a(injectorLike, 2066));
    }

    public final Object m14462a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        if (((GraphQLStoryAttachment) feedProps.a).z() != null) {
            FeedProps feedProps2;
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f12620a.get(), feedProps);
            if (feedProps.b == null || !(feedProps.b.a instanceof GraphQLStory)) {
                feedProps2 = null;
            } else {
                ImmutableList in = ((GraphQLStoryAttachment) feedProps.a).z().in();
                if (in == null || in.isEmpty()) {
                    feedProps2 = null;
                } else {
                    Builder a = Builder.a((GraphQLStory) feedProps.b.a);
                    a.m = in;
                    feedProps2 = feedProps.b.b(a.a());
                }
            }
            FeedProps feedProps3 = feedProps2;
            if (feedProps3 != null) {
                baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f12621b.get(), feedProps3.a(StoryAttachmentHelper.o((GraphQLStory) feedProps3.a)));
            }
        }
        return null;
    }

    @Inject
    public ThrowbackVideoCardAttachmentGroupPartDefinition(Lazy<FriendversaryInProductBrandingAttachmentHeaderPartDefinition> lazy, Lazy<VideoAttachmentsSelectorPartDefinition> lazy2) {
        this.f12620a = lazy;
        this.f12621b = lazy2;
    }

    public final boolean m14463a(Object obj) {
        return true;
    }

    public static ThrowbackVideoCardAttachmentGroupPartDefinition m14460a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackVideoCardAttachmentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12619d) {
                ThrowbackVideoCardAttachmentGroupPartDefinition throwbackVideoCardAttachmentGroupPartDefinition;
                if (a2 != null) {
                    throwbackVideoCardAttachmentGroupPartDefinition = (ThrowbackVideoCardAttachmentGroupPartDefinition) a2.a(f12619d);
                } else {
                    throwbackVideoCardAttachmentGroupPartDefinition = f12618c;
                }
                if (throwbackVideoCardAttachmentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14461b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12619d, b3);
                        } else {
                            f12618c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackVideoCardAttachmentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
