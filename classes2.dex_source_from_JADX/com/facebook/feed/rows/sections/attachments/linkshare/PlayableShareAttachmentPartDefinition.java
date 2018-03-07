package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.attachments.angora.AttachmentHasPlayIcon;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.fig.attachment.FIGAttachmentView;
import com.facebook.fig.attachment.qe.ExperimentsForFIGAttachmentModule;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetchZeroInterstitialEligibilityParams */
public class PlayableShareAttachmentPartDefinition<E extends HasImageLoadListener & HasInvalidate & HasPositionInformation & HasPrefetcher & HasPersistentState, V extends View & AngoraAttachment & AttachmentHasLargeImage & AttachmentHasPlayIcon> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f24222a = new AtomicReference();
    private static PlayableShareAttachmentPartDefinition f24223g;
    private static final Object f24224h = new Object();
    private final BaseShareAttachmentPartDefinition<E, V> f24225b;
    private final AttachmentCoverPhotoPartDefinition<E, V> f24226c;
    private final PlayIconPartDefinition<V> f24227d;
    private final CoverPhotoShareAttachmentBinderFactory f24228e;
    private final QeAccessor f24229f;

    private static PlayableShareAttachmentPartDefinition m32570b(InjectorLike injectorLike) {
        return new PlayableShareAttachmentPartDefinition(BaseShareAttachmentPartDefinition.m32218a(injectorLike), AttachmentCoverPhotoPartDefinition.m32326a(injectorLike), PlayIconPartDefinition.m32342a(injectorLike), CoverPhotoShareAttachmentBinderFactory.m32330a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        subParts.mo2756a(this.f24225b, feedProps);
        subParts.mo2756a(this.f24226c, feedProps);
        subParts.mo2756a(this.f24227d, graphQLStoryAttachment);
        return null;
    }

    public final boolean m32573a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).f13444a;
        Object obj2 = (graphQLStoryAttachment.m23979r() == null || graphQLStoryAttachment.m23979r().m24440S() == null || !graphQLStoryAttachment.m23979r().an()) ? null : 1;
        return obj2 != null && this.f24228e.m32333a(graphQLStoryAttachment.m23979r());
    }

    @Inject
    public PlayableShareAttachmentPartDefinition(BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition, AttachmentCoverPhotoPartDefinition attachmentCoverPhotoPartDefinition, PlayIconPartDefinition playIconPartDefinition, CoverPhotoShareAttachmentBinderFactory coverPhotoShareAttachmentBinderFactory, QeAccessor qeAccessor) {
        this.f24225b = baseShareAttachmentPartDefinition;
        this.f24226c = attachmentCoverPhotoPartDefinition;
        this.f24227d = playIconPartDefinition;
        this.f24228e = coverPhotoShareAttachmentBinderFactory;
        this.f24229f = qeAccessor;
    }

    public static PlayableShareAttachmentPartDefinition m32569a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlayableShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24224h) {
                PlayableShareAttachmentPartDefinition playableShareAttachmentPartDefinition;
                if (a2 != null) {
                    playableShareAttachmentPartDefinition = (PlayableShareAttachmentPartDefinition) a2.mo818a(f24224h);
                } else {
                    playableShareAttachmentPartDefinition = f24223g;
                }
                if (playableShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32570b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24224h, b3);
                        } else {
                            f24223g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = playableShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType<V> mo2547a() {
        if (f24222a.get() == null) {
            f24222a.set(this.f24229f.mo596a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : AngoraAttachmentView.a);
        }
        return (ViewType) f24222a.get();
    }
}
