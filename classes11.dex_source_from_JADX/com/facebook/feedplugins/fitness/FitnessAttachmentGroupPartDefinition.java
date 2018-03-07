package com.facebook.feedplugins.fitness;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.PhotoAttachmentPartDefinition;
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
/* compiled from: disableAnimation */
public class FitnessAttachmentGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static FitnessAttachmentGroupPartDefinition f7602d;
    private static final Object f7603e = new Object();
    private final FitnessMapPartDefinition f7604a;
    private final FitnessAttachmentUtils f7605b;
    private final PhotoAttachmentPartDefinition f7606c;

    private static FitnessAttachmentGroupPartDefinition m8828b(InjectorLike injectorLike) {
        return new FitnessAttachmentGroupPartDefinition(FitnessMapPartDefinition.m8840a(injectorLike), FitnessAttachmentUtils.m8837b(injectorLike), PhotoAttachmentPartDefinition.a(injectorLike));
    }

    public final Object m8829a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        if (((GraphQLStoryAttachment) feedProps.a).r() != null) {
            baseMultiRowSubParts.a(this.f7606c, feedProps);
        } else {
            baseMultiRowSubParts.a(this.f7604a, feedProps);
        }
        return null;
    }

    public final boolean m8830a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return (((GraphQLStoryAttachment) feedProps.a).r() != null || this.f7604a.m8847a(feedProps)) && this.f7605b.m8838a();
    }

    @Inject
    public FitnessAttachmentGroupPartDefinition(FitnessMapPartDefinition fitnessMapPartDefinition, FitnessAttachmentUtils fitnessAttachmentUtils, PhotoAttachmentPartDefinition photoAttachmentPartDefinition) {
        this.f7604a = fitnessMapPartDefinition;
        this.f7605b = fitnessAttachmentUtils;
        this.f7606c = photoAttachmentPartDefinition;
    }

    public static FitnessAttachmentGroupPartDefinition m8827a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FitnessAttachmentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7603e) {
                FitnessAttachmentGroupPartDefinition fitnessAttachmentGroupPartDefinition;
                if (a2 != null) {
                    fitnessAttachmentGroupPartDefinition = (FitnessAttachmentGroupPartDefinition) a2.a(f7603e);
                } else {
                    fitnessAttachmentGroupPartDefinition = f7602d;
                }
                if (fitnessAttachmentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8828b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7603e, b3);
                        } else {
                            f7602d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fitnessAttachmentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
