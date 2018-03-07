package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: order_id */
public class LargeImagePartDefinition<V extends View & AttachmentHasLargeImage> extends BaseSinglePartDefinition<Props, DraweeController, HasPrefetcher, V> {
    private static LargeImagePartDefinition f5972b;
    private static final Object f5973c = new Object();
    private final FbDraweeControllerBuilder f5974a;

    /* compiled from: order_id */
    public class Props {
        public final GraphQLImage f6042a;
        public final CallerContext f6043b;
        public final float f6044c;

        public Props(GraphQLImage graphQLImage, CallerContext callerContext, float f) {
            this.f6042a = graphQLImage;
            this.f6043b = callerContext;
            this.f6044c = f;
        }
    }

    private static LargeImagePartDefinition m6430b(InjectorLike injectorLike) {
        return new LargeImagePartDefinition(FbDraweeControllerBuilder.b(injectorLike));
    }

    public final Object m6431a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasPrefetcher hasPrefetcher = (HasPrefetcher) anyEnvironment;
        if (props.f6042a == null) {
            return null;
        }
        ImageRequest a = ImageRequest.a(props.f6042a.b());
        hasPrefetcher.a(a, props.f6043b);
        return ((FbDraweeControllerBuilder) this.f5974a.a(props.f6043b).c(a)).s();
    }

    public final /* bridge */ /* synthetic */ void m6432a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1023839836);
        m6429a((Props) obj, (DraweeController) obj2, view);
        Logger.a(8, EntryType.MARK_POP, 912593773, a);
    }

    @Inject
    public LargeImagePartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f5974a = fbDraweeControllerBuilder;
    }

    public static LargeImagePartDefinition m6428a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LargeImagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5973c) {
                LargeImagePartDefinition largeImagePartDefinition;
                if (a2 != null) {
                    largeImagePartDefinition = (LargeImagePartDefinition) a2.a(f5973c);
                } else {
                    largeImagePartDefinition = f5972b;
                }
                if (largeImagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6430b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5973c, b3);
                        } else {
                            f5972b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = largeImagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static void m6429a(Props props, DraweeController draweeController, V v) {
        ((AttachmentHasLargeImage) v).setLargeImageController(draweeController);
        ((AttachmentHasLargeImage) v).setLargeImageAspectRatio(props.f6044c);
    }

    public final void m6433b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((AttachmentHasLargeImage) view).setLargeImageController(null);
    }
}
