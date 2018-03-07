package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AngoraInstantArticlesAttachmentView;
import com.facebook.attachments.angora.AttachmentHasArticleIcon;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.attachments.angora.AttachmentHasPlayIcon;
import com.facebook.attachments.angora.AttachmentHasTooltipAnchor;
import com.facebook.common.callercontext.CallerContext;
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
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLNode;
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
/* compiled from: fetch_audience_info */
public class InstantArticleShareAttachmentPartDefinition<E extends HasInvalidate & HasImageLoadListener & HasPersistentState & HasPositionInformation & HasPrefetcher, V extends View & AngoraAttachment & AttachmentHasLargeImage & AttachmentHasPlayIcon & AttachmentHasArticleIcon & AttachmentHasTooltipAnchor> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f24162a = new AtomicReference();
    private static final CallerContext f24163b = CallerContext.m9060a(InstantArticleShareAttachmentPartDefinition.class);
    private static InstantArticleShareAttachmentPartDefinition f24164h;
    private static final Object f24165i = new Object();
    private final BaseShareAttachmentPartDefinition<E, V> f24166c;
    private final AttachmentCoverPhotoPartDefinition<E, V> f24167d;
    private final ArticleIconPartDefinition<V> f24168e;
    private final CoverPhotoShareAttachmentBinderFactory f24169f;
    private final QeAccessor f24170g;

    private static InstantArticleShareAttachmentPartDefinition m32525b(InjectorLike injectorLike) {
        return new InstantArticleShareAttachmentPartDefinition(BaseShareAttachmentPartDefinition.m32218a(injectorLike), AttachmentCoverPhotoPartDefinition.m32326a(injectorLike), ArticleIconPartDefinition.m32529a(injectorLike), CoverPhotoShareAttachmentBinderFactory.m32330a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        subParts.mo2756a(this.f24166c, feedProps);
        subParts.mo2756a(this.f24167d, feedProps);
        subParts.mo2756a(this.f24168e, graphQLStoryAttachment);
        return null;
    }

    public final boolean m32528a(Object obj) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) ((FeedProps) obj).f13444a;
        GraphQLMedia r = graphQLStoryAttachment.m23979r();
        return r != null && r.m24440S() != null && m32524a(graphQLStoryAttachment) && this.f24169f.m32333a(r);
    }

    public static InstantArticleShareAttachmentPartDefinition m32523a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantArticleShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24165i) {
                InstantArticleShareAttachmentPartDefinition instantArticleShareAttachmentPartDefinition;
                if (a2 != null) {
                    instantArticleShareAttachmentPartDefinition = (InstantArticleShareAttachmentPartDefinition) a2.mo818a(f24165i);
                } else {
                    instantArticleShareAttachmentPartDefinition = f24164h;
                }
                if (instantArticleShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32525b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24165i, b3);
                        } else {
                            f24164h = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = instantArticleShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public InstantArticleShareAttachmentPartDefinition(BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition, AttachmentCoverPhotoPartDefinition attachmentCoverPhotoPartDefinition, ArticleIconPartDefinition articleIconPartDefinition, CoverPhotoShareAttachmentBinderFactory coverPhotoShareAttachmentBinderFactory, QeAccessor qeAccessor) {
        this.f24166c = baseShareAttachmentPartDefinition;
        this.f24167d = attachmentCoverPhotoPartDefinition;
        this.f24168e = articleIconPartDefinition;
        this.f24169f = coverPhotoShareAttachmentBinderFactory;
        this.f24170g = qeAccessor;
    }

    public final ViewType<V> mo2547a() {
        if (f24162a.get() == null) {
            f24162a.set(this.f24170g.mo596a(ExperimentsForFIGAttachmentModule.a, false) ? FIGAttachmentView.h : AngoraInstantArticlesAttachmentView.c);
        }
        return (ViewType) f24162a.get();
    }

    public static boolean m32524a(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLNode z = graphQLStoryAttachment.m23987z();
        return (z == null || z.dB() == null) ? false : true;
    }
}
