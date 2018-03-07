package com.facebook.feed.rows.sections.attachments.videos;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TV;)V */
public class VideoViewCountTextPartDefinition extends BaseSinglePartDefinition<GraphQLStoryAttachment, Void, AnyEnvironment, FbTextView> {
    private static VideoViewCountTextPartDefinition f347c;
    private static final Object f348d = new Object();
    private final TextPartDefinition f349a;
    private final Resources f350b;

    private static VideoViewCountTextPartDefinition m312b(InjectorLike injectorLike) {
        return new VideoViewCountTextPartDefinition(TextPartDefinition.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m313a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
        Preconditions.checkArgument(GraphQLStoryAttachmentUtil.d(graphQLStoryAttachment));
        Preconditions.checkArgument(graphQLStoryAttachment.r().j().g() == 82650203);
        subParts.a(this.f349a, this.f350b.getQuantityString(2131689538, r0, new Object[]{Integer.valueOf(graphQLStoryAttachment.r().aJ())}));
        return null;
    }

    @Inject
    public VideoViewCountTextPartDefinition(TextPartDefinition textPartDefinition, Resources resources) {
        this.f349a = textPartDefinition;
        this.f350b = resources;
    }

    public static VideoViewCountTextPartDefinition m311a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoViewCountTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f348d) {
                VideoViewCountTextPartDefinition videoViewCountTextPartDefinition;
                if (a2 != null) {
                    videoViewCountTextPartDefinition = (VideoViewCountTextPartDefinition) a2.a(f348d);
                } else {
                    videoViewCountTextPartDefinition = f347c;
                }
                if (videoViewCountTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m312b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f348d, b3);
                        } else {
                            f347c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoViewCountTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
