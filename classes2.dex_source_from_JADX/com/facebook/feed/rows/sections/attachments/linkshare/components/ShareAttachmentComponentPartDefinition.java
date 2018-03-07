package com.facebook.feed.rows.sections.attachments.linkshare.components;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.actionbutton.AngoraActionButton;
import com.facebook.attachments.angora.actionbutton.AngoraActionButtonController;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.components.feed.FeedComponentView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.feed.rows.qe.ExperimentsForMultiRowQEModule;
import com.facebook.feed.rows.sections.attachments.linkshare.BaseShareAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.CoverPhotoShareAttachmentBinderFactory;
import com.facebook.feed.rows.sections.attachments.linkshare.CoverPhotoShareAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.components.CoverPhotoShareComponent.Builder;
import com.facebook.feed.rows.sections.attachments.linkshare.components.CoverPhotoShareComponent.State;
import com.facebook.feed.rows.sections.components.FeedBackgroundStylerComponentWrapper;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetchZeroInterstitialContentParams */
public class ShareAttachmentComponentPartDefinition<E extends HasContext & HasFeedListType & HasImageLoadListener & HasInvalidate & HasIsAsync & HasPersistentState & HasPositionInformation & HasPrefetcher> extends ComponentPartDefinition<FeedProps<GraphQLStoryAttachment>, E> {
    public static final ViewType<FeedComponentView> f24241c = new C09841();
    private static ShareAttachmentComponentPartDefinition f24242i;
    private static final Object f24243j = new Object();
    private final CoverPhotoShareComponent f24244d;
    public final CoverPhotoShareAttachmentBinderFactory f24245e;
    public final AndroidComponentsExperimentHelper f24246f;
    private final FeedBackgroundStylerComponentWrapper f24247g;
    private final AngoraActionButtonController f24248h;

    /* compiled from: fetchZeroInterstitialContentParams */
    final class C09841 extends ViewType<FeedComponentView> {
        C09841() {
        }

        public final View mo1995a(Context context) {
            return new FeedComponentView(context);
        }
    }

    private static ShareAttachmentComponentPartDefinition m32583b(InjectorLike injectorLike) {
        return new ShareAttachmentComponentPartDefinition((Context) injectorLike.getInstance(Context.class), CoverPhotoShareComponent.m32591a(injectorLike), CoverPhotoShareAttachmentBinderFactory.m32330a(injectorLike), AndroidComponentsExperimentHelper.m10053a(injectorLike), FeedBackgroundStylerComponentWrapper.m28338b(injectorLike), AngoraActionButtonController.m32349a(injectorLike));
    }

    public final void mo3132a(SubParts subParts, Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        AngoraActionButton a = this.f24248h.m32351a(feedProps);
        if (a != null) {
            SinglePartDefinition b = a.mo3514b();
            if (b != null) {
                subParts.mo2756a(b, feedProps);
            }
        }
    }

    public final boolean m32588a(Object obj) {
        if (CoverPhotoShareAttachmentPartDefinition.m32518a((FeedProps) obj, this.f24245e)) {
            AndroidComponentsExperimentHelper androidComponentsExperimentHelper = this.f24246f;
            int i = 0;
            if (androidComponentsExperimentHelper.f5904h == null) {
                androidComponentsExperimentHelper.f5904h = Boolean.valueOf(AndroidComponentsExperimentHelper.m10054a(androidComponentsExperimentHelper.f5897a.mo572a(ExperimentsForMultiRowQEModule.f5921e, 0)));
            }
            if (androidComponentsExperimentHelper.f5904h.booleanValue() || androidComponentsExperimentHelper.m10064s()) {
                i = 1;
            }
            if (i != 0) {
                return true;
            }
        }
        return false;
    }

    public final CacheableEntity mo3131b(Object obj) {
        return AttachmentProps.m28716f((FeedProps) obj);
    }

    public static ShareAttachmentComponentPartDefinition m32582a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ShareAttachmentComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24243j) {
                ShareAttachmentComponentPartDefinition shareAttachmentComponentPartDefinition;
                if (a2 != null) {
                    shareAttachmentComponentPartDefinition = (ShareAttachmentComponentPartDefinition) a2.mo818a(f24243j);
                } else {
                    shareAttachmentComponentPartDefinition = f24242i;
                }
                if (shareAttachmentComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32583b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24243j, b3);
                        } else {
                            f24242i = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = shareAttachmentComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ShareAttachmentComponentPartDefinition(Context context, CoverPhotoShareComponent coverPhotoShareComponent, CoverPhotoShareAttachmentBinderFactory coverPhotoShareAttachmentBinderFactory, AndroidComponentsExperimentHelper androidComponentsExperimentHelper, FeedBackgroundStylerComponentWrapper feedBackgroundStylerComponentWrapper, AngoraActionButtonController angoraActionButtonController) {
        super(context);
        this.f24244d = coverPhotoShareComponent;
        this.f24245e = coverPhotoShareAttachmentBinderFactory;
        this.f24246f = androidComponentsExperimentHelper;
        this.f24247g = feedBackgroundStylerComponentWrapper;
        this.f24248h = angoraActionButtonController;
    }

    private Component<?> m32581a(ComponentContext componentContext, FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        StylingData a = BaseShareAttachmentPartDefinition.m32219a((FeedProps) feedProps);
        CoverPhotoShareComponent coverPhotoShareComponent = this.f24244d;
        State state = new State(coverPhotoShareComponent);
        Builder builder = (Builder) coverPhotoShareComponent.f24252c.mo740a();
        if (builder == null) {
            builder = new Builder(coverPhotoShareComponent);
        }
        Builder.a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.a.a = feedProps;
        builder2.e.set(0);
        Builder builder3 = builder2;
        builder3.a.b = (HasFeedListType) e;
        builder3.e.set(1);
        return this.f24247g.m28340b(componentContext, (HasPositionInformation) e, a, builder3.mo3296d());
    }

    public final ViewType mo2547a() {
        return f24241c;
    }
}
