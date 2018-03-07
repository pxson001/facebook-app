package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.feed.rows.util.DraweeControllerPartDefinition;
import com.facebook.feed.rows.util.DraweeControllerPartDefinition.Callbacks;
import com.facebook.feed.rows.util.DraweeControllerPartDefinition.Props;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: bd6c7f33f322be6288d4bc4c599acf5a */
public class StorySetAttachmentImagePartDefinition extends BaseSinglePartDefinition<GraphQLStoryAttachment, Void, AnyEnvironment, GenericDraweeView> {
    private static final CallerContext f9589a = CallerContext.a(StorySetAttachmentImagePartDefinition.class, "newsfeed_storyset_view");
    private static StorySetAttachmentImagePartDefinition f9590e;
    private static final Object f9591f = new Object();
    private final DraweeControllerPartDefinition<GenericDraweeView> f9592b;
    private final FbDraweeControllerBuilder f9593c;
    public final Resources f9594d;

    private static StorySetAttachmentImagePartDefinition m10106b(InjectorLike injectorLike) {
        return new StorySetAttachmentImagePartDefinition(DraweeControllerPartDefinition.a(injectorLike), FbDraweeControllerBuilder.b(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object m10107a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
        subParts.a(this.f9592b, new Props(f9589a, new Callbacks<GenericDraweeView>(this) {
            final /* synthetic */ StorySetAttachmentImagePartDefinition f9588b;

            public final void m10104a(View view, @Nullable DraweeController draweeController) {
                GenericDraweeView genericDraweeView = (GenericDraweeView) view;
                GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) genericDraweeView.getHierarchy();
                genericDraweeHierarchy.b(this.f9588b.f9594d.getDrawable(2131362786));
                genericDraweeView.setHierarchy(genericDraweeHierarchy);
                genericDraweeView.setController(draweeController);
                genericDraweeView.setAspectRatio(1.9318181f);
            }

            public final ImageRequest m10103a() {
                ImageRequestBuilder a = ImageRequestBuilder.a(ImageUtil.a(graphQLStoryAttachment.r().W()));
                a.g = true;
                return a.m();
            }
        }, true, false));
        return null;
    }

    @Inject
    public StorySetAttachmentImagePartDefinition(DraweeControllerPartDefinition draweeControllerPartDefinition, FbDraweeControllerBuilder fbDraweeControllerBuilder, Context context) {
        this.f9592b = draweeControllerPartDefinition;
        this.f9593c = fbDraweeControllerBuilder;
        this.f9594d = context.getResources();
    }

    public static StorySetAttachmentImagePartDefinition m10105a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetAttachmentImagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9591f) {
                StorySetAttachmentImagePartDefinition storySetAttachmentImagePartDefinition;
                if (a2 != null) {
                    storySetAttachmentImagePartDefinition = (StorySetAttachmentImagePartDefinition) a2.a(f9591f);
                } else {
                    storySetAttachmentImagePartDefinition = f9590e;
                }
                if (storySetAttachmentImagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10106b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9591f, b3);
                        } else {
                            f9590e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetAttachmentImagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
