package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.PhotoAttachmentPartDefinition;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
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
/* compiled from: goodfriends_enter */
public class ThrowbackUnifiedAttachmentPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static ThrowbackUnifiedAttachmentPartDefinition f12537c;
    private static final Object f12538d = new Object();
    private final ThrowbackCollageAttachmentPartDefinition f12539a;
    private final PhotoAttachmentPartDefinition<FeedEnvironment> f12540b;

    private static ThrowbackUnifiedAttachmentPartDefinition m14419b(InjectorLike injectorLike) {
        return new ThrowbackUnifiedAttachmentPartDefinition(ThrowbackCollageAttachmentPartDefinition.m14294a(injectorLike), PhotoAttachmentPartDefinition.a(injectorLike));
    }

    public final Object m14420a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) feedProps.a);
        if (o.x().size() == 1) {
            baseMultiRowSubParts.a(this.f12540b, feedProps.a(o).a((Flattenable) o.x().get(0)));
        } else {
            baseMultiRowSubParts.a(this.f12539a, feedProps);
        }
        return null;
    }

    public final boolean m14421a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        return (StoryAttachmentHelper.o(graphQLStory) == null || StoryAttachmentHelper.o(graphQLStory).x() == null || StoryAttachmentHelper.o(graphQLStory).x().isEmpty()) ? false : true;
    }

    @Inject
    public ThrowbackUnifiedAttachmentPartDefinition(ThrowbackCollageAttachmentPartDefinition throwbackCollageAttachmentPartDefinition, PhotoAttachmentPartDefinition photoAttachmentPartDefinition) {
        this.f12539a = throwbackCollageAttachmentPartDefinition;
        this.f12540b = photoAttachmentPartDefinition;
    }

    public static ThrowbackUnifiedAttachmentPartDefinition m14418a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackUnifiedAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12538d) {
                ThrowbackUnifiedAttachmentPartDefinition throwbackUnifiedAttachmentPartDefinition;
                if (a2 != null) {
                    throwbackUnifiedAttachmentPartDefinition = (ThrowbackUnifiedAttachmentPartDefinition) a2.a(f12538d);
                } else {
                    throwbackUnifiedAttachmentPartDefinition = f12537c;
                }
                if (throwbackUnifiedAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14419b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12538d, b3);
                        } else {
                            f12537c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackUnifiedAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
