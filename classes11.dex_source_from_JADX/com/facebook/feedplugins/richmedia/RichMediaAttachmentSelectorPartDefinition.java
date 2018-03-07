package com.facebook.feedplugins.richmedia;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
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
/* compiled from: buying_unseen */
public class RichMediaAttachmentSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static RichMediaAttachmentSelectorPartDefinition f9157d;
    private static final Object f9158e = new Object();
    private final RichMediaVideoAttachmentPartDefinition f9159a;
    private final RichMediaImageAttachmentPartDefinition f9160b;
    private final boolean f9161c;

    private static RichMediaAttachmentSelectorPartDefinition m9839b(InjectorLike injectorLike) {
        return new RichMediaAttachmentSelectorPartDefinition(RichMediaVideoAttachmentPartDefinition.m9873a(injectorLike), RichMediaImageAttachmentPartDefinition.m9846a(injectorLike), Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(418, false)));
    }

    public final Object m9840a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f9159a, feedProps).a(this.f9160b, feedProps);
        return null;
    }

    @Inject
    public RichMediaAttachmentSelectorPartDefinition(RichMediaVideoAttachmentPartDefinition richMediaVideoAttachmentPartDefinition, RichMediaImageAttachmentPartDefinition richMediaImageAttachmentPartDefinition, Boolean bool) {
        this.f9159a = richMediaVideoAttachmentPartDefinition;
        this.f9160b = richMediaImageAttachmentPartDefinition;
        this.f9161c = bool.booleanValue();
    }

    public final boolean m9841a(Object obj) {
        return this.f9161c;
    }

    public static RichMediaAttachmentSelectorPartDefinition m9838a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichMediaAttachmentSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9158e) {
                RichMediaAttachmentSelectorPartDefinition richMediaAttachmentSelectorPartDefinition;
                if (a2 != null) {
                    richMediaAttachmentSelectorPartDefinition = (RichMediaAttachmentSelectorPartDefinition) a2.a(f9158e);
                } else {
                    richMediaAttachmentSelectorPartDefinition = f9157d;
                }
                if (richMediaAttachmentSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9839b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9158e, b3);
                        } else {
                            f9157d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = richMediaAttachmentSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
