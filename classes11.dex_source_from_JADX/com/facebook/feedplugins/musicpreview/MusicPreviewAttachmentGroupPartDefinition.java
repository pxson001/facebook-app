package com.facebook.feedplugins.musicpreview;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
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
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: composer_user_tagging_inline_sprout */
public class MusicPreviewAttachmentGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static MusicPreviewAttachmentGroupPartDefinition f8047f;
    private static final Object f8048g = new Object();
    private final MusicPreviewSquarePartDefinition f8049a;
    private final MusicPreviewWidePartDefinition f8050b;
    private final MusicPreviewUtils f8051c;
    private final boolean f8052d;
    private final Resources f8053e;

    private static MusicPreviewAttachmentGroupPartDefinition m9094b(InjectorLike injectorLike) {
        return new MusicPreviewAttachmentGroupPartDefinition(MusicPreviewSquarePartDefinition.m9124a(injectorLike), MusicPreviewWidePartDefinition.m9141a(injectorLike), MusicPreviewUtils.m9127b(injectorLike), Boolean_IsTabletMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m9095a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        Object obj2 = null;
        if ((this.f8053e.getConfiguration().orientation == 2 ? 1 : null) != null || this.f8052d) {
            obj2 = 1;
        }
        if (obj2 != null) {
            baseMultiRowSubParts.a(this.f8050b, feedProps);
        } else {
            baseMultiRowSubParts.a(this.f8049a, feedProps);
        }
        return null;
    }

    @Inject
    public MusicPreviewAttachmentGroupPartDefinition(MusicPreviewSquarePartDefinition musicPreviewSquarePartDefinition, MusicPreviewWidePartDefinition musicPreviewWidePartDefinition, MusicPreviewUtils musicPreviewUtils, Boolean bool, Resources resources) {
        this.f8049a = musicPreviewSquarePartDefinition;
        this.f8050b = musicPreviewWidePartDefinition;
        this.f8051c = musicPreviewUtils;
        this.f8052d = bool.booleanValue();
        this.f8053e = resources;
    }

    public final boolean m9096a(FeedProps<GraphQLStoryAttachment> feedProps) {
        MusicPreviewUtils musicPreviewUtils = this.f8051c;
        return ((MusicPreviewQuickExperiment$Config) musicPreviewUtils.f8101a.a(musicPreviewUtils.f8102b)).f8092a && this.f8051c.m9129a((GraphQLStoryAttachment) feedProps.a);
    }

    public static MusicPreviewAttachmentGroupPartDefinition m9093a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MusicPreviewAttachmentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8048g) {
                MusicPreviewAttachmentGroupPartDefinition musicPreviewAttachmentGroupPartDefinition;
                if (a2 != null) {
                    musicPreviewAttachmentGroupPartDefinition = (MusicPreviewAttachmentGroupPartDefinition) a2.a(f8048g);
                } else {
                    musicPreviewAttachmentGroupPartDefinition = f8047f;
                }
                if (musicPreviewAttachmentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9094b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8048g, b3);
                        } else {
                            f8047f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = musicPreviewAttachmentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
