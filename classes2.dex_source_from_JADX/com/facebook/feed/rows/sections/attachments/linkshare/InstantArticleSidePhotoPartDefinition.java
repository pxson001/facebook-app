package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.view.View;
import android.widget.Space;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.ui.LargeSquarePhotoInstantArticleAttachmentView;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_alerts/ */
public class InstantArticleSidePhotoPartDefinition<E extends HasInvalidate & HasImageLoadListener & HasPersistentState & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, LargeSquarePhotoInstantArticleAttachmentView> {
    private static InstantArticleSidePhotoPartDefinition f24192d;
    private static final Object f24193e = new Object();
    private final BaseShareAttachmentPartDefinition<E, LargeSquarePhotoInstantArticleAttachmentView> f24194a;
    private final LargeSquarePhotoAttachmentPartDefinition<E> f24195b;
    private final CoverPhotoShareAttachmentBinderFactory f24196c;

    private static InstantArticleSidePhotoPartDefinition m32540b(InjectorLike injectorLike) {
        return new InstantArticleSidePhotoPartDefinition(BaseShareAttachmentPartDefinition.m32218a(injectorLike), CoverPhotoShareAttachmentBinderFactory.m32330a(injectorLike), LargeSquarePhotoAttachmentPartDefinition.m32545a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2756a(this.f24194a, feedProps);
        subParts.mo2756a(this.f24195b, feedProps);
        return null;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 270421129);
        LargeSquarePhotoInstantArticleAttachmentView largeSquarePhotoInstantArticleAttachmentView = (LargeSquarePhotoInstantArticleAttachmentView) view;
        GraphQLMedia r = ((GraphQLStoryAttachment) ((FeedProps) obj).f13444a).m23979r();
        Object obj3 = (r == null || r.m24440S() == null) ? null : 1;
        int i = 8;
        int visibility = largeSquarePhotoInstantArticleAttachmentView.j.getVisibility();
        if ((visibility != 0 || obj3 == null) && (visibility == 0 || obj3 != null)) {
            FbDraweeView fbDraweeView = largeSquarePhotoInstantArticleAttachmentView.j;
            if (obj3 != null) {
                visibility = 0;
            } else {
                visibility = 8;
            }
            fbDraweeView.setVisibility(visibility);
            Space space = largeSquarePhotoInstantArticleAttachmentView.k;
            if (obj3 == null) {
                i = 0;
            }
            space.setVisibility(i);
        }
        Logger.a(8, EntryType.MARK_POP, 855918501, a);
    }

    public final boolean m32544a(Object obj) {
        GraphQLNode z = ((GraphQLStoryAttachment) ((FeedProps) obj).f13444a).m23987z();
        boolean z2 = (z == null || z.dB() == null) ? false : true;
        return z2;
    }

    @Inject
    public InstantArticleSidePhotoPartDefinition(BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition, CoverPhotoShareAttachmentBinderFactory coverPhotoShareAttachmentBinderFactory, LargeSquarePhotoAttachmentPartDefinition largeSquarePhotoAttachmentPartDefinition) {
        this.f24194a = baseShareAttachmentPartDefinition;
        this.f24196c = coverPhotoShareAttachmentBinderFactory;
        this.f24195b = largeSquarePhotoAttachmentPartDefinition;
    }

    public final ViewType mo2547a() {
        return LargeSquarePhotoInstantArticleAttachmentView.h;
    }

    public static InstantArticleSidePhotoPartDefinition m32539a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantArticleSidePhotoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24193e) {
                InstantArticleSidePhotoPartDefinition instantArticleSidePhotoPartDefinition;
                if (a2 != null) {
                    instantArticleSidePhotoPartDefinition = (InstantArticleSidePhotoPartDefinition) a2.mo818a(f24193e);
                } else {
                    instantArticleSidePhotoPartDefinition = f24192d;
                }
                if (instantArticleSidePhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32540b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24193e, b3);
                        } else {
                            f24192d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = instantArticleSidePhotoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
