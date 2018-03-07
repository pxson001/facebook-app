package com.facebook.feedplugins.opengraph;

import android.content.Context;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.linkshare.BaseShareAttachmentPartDefinition;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: collections_section_type */
public class OpenGraphFallbackAttachmentPartDefinition<E extends HasInvalidate & HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, AngoraAttachmentView> {
    private static OpenGraphFallbackAttachmentPartDefinition f8575b;
    private static final Object f8576c = new Object();
    private final BaseShareAttachmentPartDefinition<E, AngoraAttachmentView> f8577a;

    private static OpenGraphFallbackAttachmentPartDefinition m9424b(InjectorLike injectorLike) {
        return new OpenGraphFallbackAttachmentPartDefinition(BaseShareAttachmentPartDefinition.a(injectorLike));
    }

    public final Object m9426a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f8577a, (FeedProps) obj);
        return null;
    }

    @Inject
    public OpenGraphFallbackAttachmentPartDefinition(BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition) {
        this.f8577a = baseShareAttachmentPartDefinition;
    }

    public final ViewType<AngoraAttachmentView> m9425a() {
        return AngoraAttachmentView.a;
    }

    public final boolean m9427a(Object obj) {
        return true;
    }

    public static OpenGraphFallbackAttachmentPartDefinition m9423a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OpenGraphFallbackAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8576c) {
                OpenGraphFallbackAttachmentPartDefinition openGraphFallbackAttachmentPartDefinition;
                if (a2 != null) {
                    openGraphFallbackAttachmentPartDefinition = (OpenGraphFallbackAttachmentPartDefinition) a2.a(f8576c);
                } else {
                    openGraphFallbackAttachmentPartDefinition = f8575b;
                }
                if (openGraphFallbackAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9424b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8576c, b3);
                        } else {
                            f8575b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = openGraphFallbackAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
