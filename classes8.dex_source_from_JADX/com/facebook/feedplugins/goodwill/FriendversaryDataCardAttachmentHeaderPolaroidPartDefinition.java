package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: graph_search_results_page_post */
public class FriendversaryDataCardAttachmentHeaderPolaroidPartDefinition<E extends HasPositionInformation & HasPrefetcher> extends DualPhotoBasePartDefinition<GraphQLStoryAttachment, E> {
    private static FriendversaryDataCardAttachmentHeaderPolaroidPartDefinition f12254b;
    private static final Object f12255c = new Object();

    private static FriendversaryDataCardAttachmentHeaderPolaroidPartDefinition m14219b(InjectorLike injectorLike) {
        return new FriendversaryDataCardAttachmentHeaderPolaroidPartDefinition(FbDraweeControllerBuilder.b(injectorLike));
    }

    public final Object m14220a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).a;
        DualPhotoViewConfig dualPhotoViewConfig = new DualPhotoViewConfig();
        dualPhotoViewConfig.f12216a = -4.3f;
        dualPhotoViewConfig.f12217b = 9.3f;
        dualPhotoViewConfig.f12218c = 52;
        dualPhotoViewConfig.f12219d = 4;
        dualPhotoViewConfig.f12220e = 4;
        dualPhotoViewConfig.f12221f = 16;
        dualPhotoViewConfig.f12222g = 20;
        dualPhotoViewConfig.f12223h = 12;
        dualPhotoViewConfig.f12224i = 0;
        return m14186a(hasPositionInformation, ((GraphQLMedia) graphQLStoryAttachment.z().im().get(0)).S().b(), ((GraphQLMedia) graphQLStoryAttachment.z().im().get(1)).S().b(), dualPhotoViewConfig);
    }

    public final boolean m14221a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).a;
        if (graphQLStoryAttachment.z() == null) {
            return false;
        }
        ImmutableList im = graphQLStoryAttachment.z().im();
        if (im == null || im.size() < 2) {
            return false;
        }
        for (int i = 0; i < 2; i++) {
            GraphQLMedia graphQLMedia = (GraphQLMedia) im.get(i);
            if (graphQLMedia == null || graphQLMedia.S() == null || graphQLMedia.S().b() == null) {
                return false;
            }
        }
        return true;
    }

    @Inject
    public FriendversaryDataCardAttachmentHeaderPolaroidPartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        super(fbDraweeControllerBuilder);
    }

    public static FriendversaryDataCardAttachmentHeaderPolaroidPartDefinition m14218a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendversaryDataCardAttachmentHeaderPolaroidPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12255c) {
                FriendversaryDataCardAttachmentHeaderPolaroidPartDefinition friendversaryDataCardAttachmentHeaderPolaroidPartDefinition;
                if (a2 != null) {
                    friendversaryDataCardAttachmentHeaderPolaroidPartDefinition = (FriendversaryDataCardAttachmentHeaderPolaroidPartDefinition) a2.a(f12255c);
                } else {
                    friendversaryDataCardAttachmentHeaderPolaroidPartDefinition = f12254b;
                }
                if (friendversaryDataCardAttachmentHeaderPolaroidPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14219b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12255c, b3);
                        } else {
                            f12254b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendversaryDataCardAttachmentHeaderPolaroidPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
