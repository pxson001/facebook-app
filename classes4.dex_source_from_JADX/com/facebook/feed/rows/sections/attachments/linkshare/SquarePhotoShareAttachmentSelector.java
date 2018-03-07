package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import com.facebook.attachments.angora.actionbutton.AngoraActionButtonController;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.calltoaction.ActionButtonPartDefinition;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: originalFbid */
public class SquarePhotoShareAttachmentSelector extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static SquarePhotoShareAttachmentSelector f5917d;
    private static final Object f5918e = new Object();
    private final MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, HasPositionInformation, ?> f5919a;
    private final LargeSquarePhotoAttachmentPartDefinition<FeedEnvironment> f5920b;
    private final SmallPhotoShareAttachmentPartDefinition<FeedEnvironment, ?> f5921c;

    private static SquarePhotoShareAttachmentSelector m6380b(InjectorLike injectorLike) {
        return new SquarePhotoShareAttachmentSelector(SmallPhotoShareAttachmentPartDefinition.a(injectorLike), LargeSquarePhotoAttachmentPartDefinition.a(injectorLike), (ButtonShareAttachmentDecoratorPartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ButtonShareAttachmentDecoratorPartDefinitionProvider.class));
    }

    public final Object m6381a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f5919a, feedProps).a(this.f5920b, feedProps).a(this.f5921c, feedProps);
        return null;
    }

    @Inject
    public SquarePhotoShareAttachmentSelector(SmallPhotoShareAttachmentPartDefinition smallPhotoShareAttachmentPartDefinition, LargeSquarePhotoAttachmentPartDefinition largeSquarePhotoAttachmentPartDefinition, ButtonShareAttachmentDecoratorPartDefinitionProvider buttonShareAttachmentDecoratorPartDefinitionProvider) {
        this.f5919a = new ButtonShareAttachmentDecoratorPartDefinition(smallPhotoShareAttachmentPartDefinition, AngoraActionButtonController.a(buttonShareAttachmentDecoratorPartDefinitionProvider), ActionButtonPartDefinition.a(buttonShareAttachmentDecoratorPartDefinitionProvider), (QeAccessor) QeInternalImplMethodAutoProvider.a(buttonShareAttachmentDecoratorPartDefinitionProvider));
        this.f5920b = largeSquarePhotoAttachmentPartDefinition;
        this.f5921c = smallPhotoShareAttachmentPartDefinition;
    }

    public final boolean m6382a(Object obj) {
        return true;
    }

    public static SquarePhotoShareAttachmentSelector m6379a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SquarePhotoShareAttachmentSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5918e) {
                SquarePhotoShareAttachmentSelector squarePhotoShareAttachmentSelector;
                if (a2 != null) {
                    squarePhotoShareAttachmentSelector = (SquarePhotoShareAttachmentSelector) a2.a(f5918e);
                } else {
                    squarePhotoShareAttachmentSelector = f5917d;
                }
                if (squarePhotoShareAttachmentSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6380b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5918e, b3);
                        } else {
                            f5917d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = squarePhotoShareAttachmentSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
