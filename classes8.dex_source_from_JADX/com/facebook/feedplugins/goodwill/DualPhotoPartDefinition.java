package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
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
/* compiled from: gravity_end_scan_session_fail */
public class DualPhotoPartDefinition<E extends HasPositionInformation & HasPrefetcher> extends DualPhotoBasePartDefinition<GraphQLStoryAttachment, E> {
    private static DualPhotoPartDefinition f12202c;
    private static final Object f12203d = new Object();
    private final BackgroundPartDefinition f12204b;

    private static DualPhotoPartDefinition m14190b(InjectorLike injectorLike) {
        return new DualPhotoPartDefinition(BackgroundPartDefinition.a(injectorLike), FbDraweeControllerBuilder.b(injectorLike));
    }

    public final Object m14191a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        subParts.a(this.f12204b, new StylingData(AttachmentProps.e(feedProps), PaddingStyle.a));
        return m14186a(hasPositionInformation, ((GraphQLMedia) graphQLStoryAttachment.z().im().get(0)).S().b(), ((GraphQLMedia) graphQLStoryAttachment.z().im().get(1)).S().b(), new DualPhotoViewConfig());
    }

    public final boolean m14192a(Object obj) {
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
    public DualPhotoPartDefinition(BackgroundPartDefinition backgroundPartDefinition, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        super(fbDraweeControllerBuilder);
        this.f12204b = backgroundPartDefinition;
    }

    public static DualPhotoPartDefinition m14189a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DualPhotoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12203d) {
                DualPhotoPartDefinition dualPhotoPartDefinition;
                if (a2 != null) {
                    dualPhotoPartDefinition = (DualPhotoPartDefinition) a2.a(f12203d);
                } else {
                    dualPhotoPartDefinition = f12202c;
                }
                if (dualPhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14190b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12203d, b3);
                        } else {
                            f12202c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = dualPhotoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
