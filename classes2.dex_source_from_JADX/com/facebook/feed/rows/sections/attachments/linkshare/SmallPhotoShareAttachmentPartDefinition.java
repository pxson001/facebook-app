package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.linkshare.SidePhotoPartDefinition.Props;
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
import com.facebook.photos.warning.ObjectionableContentController;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_megaphone */
public class SmallPhotoShareAttachmentPartDefinition<E extends HasFeedListType & HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher, V extends View & AngoraAttachment> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f24041a = new AtomicReference();
    private static SmallPhotoShareAttachmentPartDefinition f24042g;
    private static final Object f24043h = new Object();
    private final BaseShareAttachmentPartDefinition<E, V> f24044b;
    private final SidePhotoPartDefinition<E, V> f24045c;
    public final ObjectionableContentController f24046d;
    private final int f24047e;
    private final QeAccessor f24048f;

    private static SmallPhotoShareAttachmentPartDefinition m32435b(InjectorLike injectorLike) {
        return new SmallPhotoShareAttachmentPartDefinition(BaseShareAttachmentPartDefinition.m32218a(injectorLike), SidePhotoPartDefinition.m32360a(injectorLike), ObjectionableContentController.m27812a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        subParts.mo2756a(this.f24044b, feedProps);
        if (graphQLStoryAttachment.m23979r() != null) {
            Object obj2;
            FeedListType c = hasFeedListType.mo2446c();
            if (c != null && c.mo2419a() == FeedListName.FEED && this.f24046d.m27822a(feedProps)) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                subParts.mo2756a(this.f24045c, new Props(graphQLStoryAttachment, this.f24047e));
            }
        }
        return null;
    }

    public static SmallPhotoShareAttachmentPartDefinition m32434a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SmallPhotoShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24043h) {
                SmallPhotoShareAttachmentPartDefinition smallPhotoShareAttachmentPartDefinition;
                if (a2 != null) {
                    smallPhotoShareAttachmentPartDefinition = (SmallPhotoShareAttachmentPartDefinition) a2.mo818a(f24043h);
                } else {
                    smallPhotoShareAttachmentPartDefinition = f24042g;
                }
                if (smallPhotoShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32435b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24043h, b3);
                        } else {
                            f24042g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = smallPhotoShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public SmallPhotoShareAttachmentPartDefinition(BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition, SidePhotoPartDefinition sidePhotoPartDefinition, ObjectionableContentController objectionableContentController, Resources resources, QeAccessor qeAccessor) {
        this.f24044b = baseShareAttachmentPartDefinition;
        this.f24045c = sidePhotoPartDefinition;
        this.f24046d = objectionableContentController;
        this.f24047e = resources.getDimensionPixelSize(2131427517);
        this.f24048f = qeAccessor;
    }

    public final ViewType<V> mo2547a() {
        if (f24041a.get() == null) {
            f24041a.set(this.f24048f.mo596a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : AngoraAttachmentView.a);
        }
        return (ViewType) f24041a.get();
    }

    public final boolean m32438a(Object obj) {
        return true;
    }
}
