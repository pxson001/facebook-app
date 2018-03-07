package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AttachmentHasSideImage;
import com.facebook.attachments.photos.GraphQLMediaRequestHelper;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.graphql.model.GraphQLImage;
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
/* compiled from: fetch_payment_request */
public class SidePhotoShareAttachmentPartDefinition<E extends HasPrefetcher, V extends View & AttachmentHasSideImage> extends BaseSinglePartDefinition<Props, DraweeController, E, V> {
    private static final CallerContext f23976a = CallerContext.m9063a(SidePhotoShareAttachmentPartDefinition.class, "newsfeed_angora_attachment_view", "small_photo", "native_newsfeed");
    private static SidePhotoShareAttachmentPartDefinition f23977d;
    private static final Object f23978e = new Object();
    private final FbDraweeControllerBuilder f23979b;
    private final FeedImageLoader f23980c;

    private static SidePhotoShareAttachmentPartDefinition m32365b(InjectorLike injectorLike) {
        return new SidePhotoShareAttachmentPartDefinition(FeedImageLoader.m28808a(injectorLike), FbDraweeControllerBuilder.m19410b(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasPrefetcher hasPrefetcher = (HasPrefetcher) anyEnvironment;
        GraphQLImage a = props.a.m23979r() != null ? FeedImageLoader.m28809a(props.a.m23979r(), props.b) : null;
        if (a == null) {
            return null;
        }
        hasPrefetcher.mo2434a(GraphQLMediaRequestHelper.m29772a(props.a.m23979r(), a, this.f23979b), f23976a);
        return this.f23979b.m19417a(f23976a).m19435s();
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1137447757);
        m32364a((DraweeController) obj2, view);
        Logger.a(8, EntryType.MARK_POP, 1746020478, a);
    }

    @Inject
    public SidePhotoShareAttachmentPartDefinition(FeedImageLoader feedImageLoader, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f23980c = feedImageLoader;
        this.f23979b = fbDraweeControllerBuilder;
    }

    public static SidePhotoShareAttachmentPartDefinition m32363a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SidePhotoShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23978e) {
                SidePhotoShareAttachmentPartDefinition sidePhotoShareAttachmentPartDefinition;
                if (a2 != null) {
                    sidePhotoShareAttachmentPartDefinition = (SidePhotoShareAttachmentPartDefinition) a2.mo818a(f23978e);
                } else {
                    sidePhotoShareAttachmentPartDefinition = f23977d;
                }
                if (sidePhotoShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32365b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23978e, b3);
                        } else {
                            f23977d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = sidePhotoShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    private static void m32364a(DraweeController draweeController, V v) {
        if (draweeController != null) {
            ((AttachmentHasSideImage) v).setSideImageController(draweeController);
        }
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((AttachmentHasSideImage) view).setSideImageController(null);
    }
}
