package com.facebook.timeline.protiles.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
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
/* compiled from: fb4ar */
public class ProtilesSmallProfilePicturePartDefinition<E extends HasPrefetcher & HasRowKey & HasImageLoadListener> extends BaseSinglePartDefinition<Props, DraweeController, E, FbDraweeView> {
    private static final CallerContext f12345a = CallerContext.a(ProtilesSmallProfilePicturePartDefinition.class, "timeline");
    private static ProtilesSmallProfilePicturePartDefinition f12346c;
    private static final Object f12347d = new Object();
    private final FbDraweeControllerBuilder f12348b;

    /* compiled from: fb4ar */
    public class Props {
        public final ImageRequest f12343a;
        public final String f12344b;

        public Props(ImageRequest imageRequest, String str) {
            this.f12343a = imageRequest;
            this.f12344b = str;
        }
    }

    private static ProtilesSmallProfilePicturePartDefinition m12387b(InjectorLike injectorLike) {
        return new ProtilesSmallProfilePicturePartDefinition(FbDraweeControllerBuilder.b(injectorLike));
    }

    public final Object m12388a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasPrefetcher hasPrefetcher = (HasPrefetcher) anyEnvironment;
        FbPipelineDraweeController s = ((FbDraweeControllerBuilder) this.f12348b.a(f12345a).c(props.f12343a)).s();
        hasPrefetcher.a(props.f12343a, f12345a);
        ((HasImageLoadListener) hasPrefetcher).a(s, props.f12344b, props.f12343a);
        return s;
    }

    public final /* bridge */ /* synthetic */ void m12389a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2074123884);
        ((FbDraweeView) view).setController((DraweeController) obj2);
        Logger.a(8, EntryType.MARK_POP, -856913481, a);
    }

    public final void m12390b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((FbDraweeView) view).setController(null);
    }

    @Inject
    public ProtilesSmallProfilePicturePartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f12348b = fbDraweeControllerBuilder;
    }

    public static ProtilesSmallProfilePicturePartDefinition m12386a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesSmallProfilePicturePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12347d) {
                ProtilesSmallProfilePicturePartDefinition protilesSmallProfilePicturePartDefinition;
                if (a2 != null) {
                    protilesSmallProfilePicturePartDefinition = (ProtilesSmallProfilePicturePartDefinition) a2.a(f12347d);
                } else {
                    protilesSmallProfilePicturePartDefinition = f12346c;
                }
                if (protilesSmallProfilePicturePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12387b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12347d, b3);
                        } else {
                            f12346c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesSmallProfilePicturePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
