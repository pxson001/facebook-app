package com.facebook.feedplugins.fitness;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.linkshare.ShareAttachmentImageFormatSelector;
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
/* compiled from: didReceiveNetworkResponse */
public class FitnessAttachmentPartSelector extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static FitnessAttachmentPartSelector f7607c;
    private static final Object f7608d = new Object();
    private final ShareAttachmentImageFormatSelector f7609a;
    private final FitnessAttachmentGroupPartDefinition f7610b;

    private static FitnessAttachmentPartSelector m8832b(InjectorLike injectorLike) {
        return new FitnessAttachmentPartSelector(FitnessAttachmentGroupPartDefinition.m8827a(injectorLike), ShareAttachmentImageFormatSelector.a(injectorLike));
    }

    public final Object m8833a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f7610b, feedProps).a(this.f7609a, feedProps);
        return null;
    }

    @Inject
    public FitnessAttachmentPartSelector(FitnessAttachmentGroupPartDefinition fitnessAttachmentGroupPartDefinition, ShareAttachmentImageFormatSelector shareAttachmentImageFormatSelector) {
        this.f7609a = shareAttachmentImageFormatSelector;
        this.f7610b = fitnessAttachmentGroupPartDefinition;
    }

    public final boolean m8834a(Object obj) {
        return true;
    }

    public static FitnessAttachmentPartSelector m8831a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FitnessAttachmentPartSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7608d) {
                FitnessAttachmentPartSelector fitnessAttachmentPartSelector;
                if (a2 != null) {
                    fitnessAttachmentPartSelector = (FitnessAttachmentPartSelector) a2.a(f7608d);
                } else {
                    fitnessAttachmentPartSelector = f7607c;
                }
                if (fitnessAttachmentPartSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8832b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7608d, b3);
                        } else {
                            f7607c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fitnessAttachmentPartSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
