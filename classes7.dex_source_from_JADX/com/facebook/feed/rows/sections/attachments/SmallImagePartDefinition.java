package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AttachmentHasSideImage;
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
/* compiled from: Y */
public class SmallImagePartDefinition<V extends View & AttachmentHasSideImage> extends BaseSinglePartDefinition<Props, DraweeController, HasPrefetcher, V> {
    private static SmallImagePartDefinition f20762b;
    private static final Object f20763c = new Object();
    private final FbDraweeControllerBuilder f20764a;

    /* compiled from: Y */
    public class Props {
        public final GraphQLImage f20760a;
        public final CallerContext f20761b;

        public Props(GraphQLImage graphQLImage, CallerContext callerContext) {
            this.f20760a = graphQLImage;
            this.f20761b = callerContext;
        }
    }

    private static SmallImagePartDefinition m23743b(InjectorLike injectorLike) {
        return new SmallImagePartDefinition(FbDraweeControllerBuilder.b(injectorLike));
    }

    public final Object m23744a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasPrefetcher hasPrefetcher = (HasPrefetcher) anyEnvironment;
        if (props.f20760a == null) {
            return null;
        }
        ImageRequest a = ImageRequest.a(props.f20760a.b());
        hasPrefetcher.a(a, props.f20761b);
        return ((FbDraweeControllerBuilder) this.f20764a.a(props.f20761b).c(a)).s();
    }

    public final /* bridge */ /* synthetic */ void m23745a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1862301214);
        m23742a((DraweeController) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -235489671, a);
    }

    @Inject
    public SmallImagePartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f20764a = fbDraweeControllerBuilder;
    }

    public static SmallImagePartDefinition m23741a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SmallImagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20763c) {
                SmallImagePartDefinition smallImagePartDefinition;
                if (a2 != null) {
                    smallImagePartDefinition = (SmallImagePartDefinition) a2.a(f20763c);
                } else {
                    smallImagePartDefinition = f20762b;
                }
                if (smallImagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23743b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20763c, b3);
                        } else {
                            f20762b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = smallImagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static void m23742a(DraweeController draweeController, V v) {
        ((AttachmentHasSideImage) v).setSideImageController(draweeController);
    }

    public final void m23746b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((AttachmentHasSideImage) view).setSideImageController(null);
    }
}
