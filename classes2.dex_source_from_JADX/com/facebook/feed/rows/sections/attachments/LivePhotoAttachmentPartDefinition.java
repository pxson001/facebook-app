package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.livephotos.LivePhotoAttachmentContainerView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.BasePhotoAttachmentPartDefinition.State;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.livephotos.ExperimentsForLivePhotosModule;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: hi */
public class LivePhotoAttachmentPartDefinition<E extends HasPositionInformation & HasImageLoadListener & HasInvalidate & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, LivePhotoAttachmentContainerView> {
    public static final ViewType f21105a = new C08411();
    private static LivePhotoAttachmentPartDefinition f21106d;
    private static final Object f21107e = new Object();
    private final BasePhotoAttachmentPartDefinition f21108b;
    private final boolean f21109c;

    /* compiled from: hi */
    final class C08411 extends ViewType {
        C08411() {
        }

        public final View mo1995a(Context context) {
            return new LivePhotoAttachmentContainerView(context);
        }
    }

    private static LivePhotoAttachmentPartDefinition m28854b(InjectorLike injectorLike) {
        return new LivePhotoAttachmentPartDefinition(BasePhotoAttachmentPartDefinition.m28731a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.mo2756a(this.f21108b, (FeedProps) obj);
        return null;
    }

    public final boolean m28857a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).f13444a;
        return (!this.f21109c || graphQLStoryAttachment == null || graphQLStoryAttachment.m23979r() == null || graphQLStoryAttachment.m23979r().aG() == null) ? false : true;
    }

    @Inject
    public LivePhotoAttachmentPartDefinition(BasePhotoAttachmentPartDefinition basePhotoAttachmentPartDefinition, QeAccessor qeAccessor) {
        this.f21108b = basePhotoAttachmentPartDefinition;
        this.f21109c = qeAccessor.mo596a(ExperimentsForLivePhotosModule.f21110a, false);
    }

    public final ViewType mo2547a() {
        return f21105a;
    }

    public static LivePhotoAttachmentPartDefinition m28853a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LivePhotoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21107e) {
                LivePhotoAttachmentPartDefinition livePhotoAttachmentPartDefinition;
                if (a2 != null) {
                    livePhotoAttachmentPartDefinition = (LivePhotoAttachmentPartDefinition) a2.mo818a(f21107e);
                } else {
                    livePhotoAttachmentPartDefinition = f21106d;
                }
                if (livePhotoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28854b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21107e, b3);
                        } else {
                            f21106d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = livePhotoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
