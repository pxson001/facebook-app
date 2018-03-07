package com.facebook.feedplugins.video;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AvatarAttachmentPartDefinition;
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
import com.facebook.multirow.api.PartWithIsNeeded;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fragment_onstart */
public class AvatarVideoAttachmentSelectorPartDefinition<V extends View & AngoraAttachment & AttachmentHasLargeImage> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> implements PartWithIsNeeded<FeedProps<GraphQLStoryAttachment>> {
    private static AvatarVideoAttachmentSelectorPartDefinition f13024c;
    private static final Object f13025d = new Object();
    private final AvatarAttachmentPartDefinition<FeedEnvironment, V> f13026a;
    private final AvatarVideoAttachmentPartDefinition<FeedEnvironment> f13027b;

    private static AvatarVideoAttachmentSelectorPartDefinition m14729b(InjectorLike injectorLike) {
        return new AvatarVideoAttachmentSelectorPartDefinition(AvatarVideoAttachmentPartDefinition.m14723a(injectorLike), AvatarAttachmentPartDefinition.a(injectorLike));
    }

    public final Object m14730a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f13027b, feedProps).a(this.f13026a, feedProps);
        return null;
    }

    @Inject
    public AvatarVideoAttachmentSelectorPartDefinition(AvatarVideoAttachmentPartDefinition avatarVideoAttachmentPartDefinition, AvatarAttachmentPartDefinition avatarAttachmentPartDefinition) {
        this.f13026a = avatarAttachmentPartDefinition;
        this.f13027b = avatarVideoAttachmentPartDefinition;
    }

    public final boolean m14731a(Object obj) {
        return true;
    }

    public static AvatarVideoAttachmentSelectorPartDefinition m14728a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AvatarVideoAttachmentSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13025d) {
                AvatarVideoAttachmentSelectorPartDefinition avatarVideoAttachmentSelectorPartDefinition;
                if (a2 != null) {
                    avatarVideoAttachmentSelectorPartDefinition = (AvatarVideoAttachmentSelectorPartDefinition) a2.a(f13025d);
                } else {
                    avatarVideoAttachmentSelectorPartDefinition = f13024c;
                }
                if (avatarVideoAttachmentSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14729b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13025d, b3);
                        } else {
                            f13024c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = avatarVideoAttachmentSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
