package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.attachments.photos.PhotoAttachmentLayoutHelper;
import com.facebook.attachments.photos.ui.PhotoAttachmentContainerView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.localstats.LocalStatsLogger;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.photos.warning.DisturbingMediaTracker;
import com.facebook.photos.warning.DisturbingMediaView;
import com.facebook.tablet.abtest.TabletExperimentConfiguration;
import com.facebook.widget.images.DrawableUtil;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@ContextScoped
/* compiled from: hide_all_link */
public class PhotoAttachmentWithWarningsPartDefinition<E extends HasFeedListType & HasImageLoadListener & HasInvalidate & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, PhotoAttachmentContainerView> {
    private static PhotoAttachmentWithWarningsPartDefinition f21045j;
    private static final Object f21046k = new Object();
    public final PhotoAttachmentLayoutHelper f21047a;
    public final Rect f21048b;
    public final PaddingStyle f21049c;
    public final PaddingStyle f21050d;
    public final BasePaddingStyleResolver f21051e;
    public final Lazy<DisturbingMediaTracker> f21052f;
    public final Lazy<LocalStatsLogger> f21053g;
    public final float f21054h;
    private final PhotoAttachmentPartDefinition<E> f21055i;

    private static PhotoAttachmentWithWarningsPartDefinition m28781b(InjectorLike injectorLike) {
        return new PhotoAttachmentWithWarningsPartDefinition(ResourcesMethodAutoProvider.m6510a(injectorLike), PhotoAttachmentPartDefinition.m28723a(injectorLike), PhotoAttachmentLayoutHelper.m28742a(injectorLike), DrawableUtil.m28756a(injectorLike), DefaultPaddingStyleResolver.m19157a(injectorLike), TabletExperimentConfiguration.m7856a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 9505), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2477));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        subParts.mo2756a(this.f21055i, feedProps);
        State state = new State(graphQLStoryAttachment.m23979r());
        Preconditions.checkNotNull(state.a);
        if (m28782b(state.a)) {
            PaddingStyle paddingStyle;
            GraphQLMedia r = ((GraphQLStoryAttachment) feedProps.f13444a).m23979r();
            Preconditions.checkNotNull(r);
            BasePaddingStyleResolver basePaddingStyleResolver = this.f21051e;
            Preconditions.checkNotNull(r.m24440S());
            if (GraphQLHelper.m22492b(r.m24440S())) {
                paddingStyle = this.f21049c;
            } else {
                paddingStyle = this.f21050d;
            }
            state.b = this.f21047a.m28745a(r, this.f21048b, basePaddingStyleResolver.m19174a(paddingStyle, AttachmentProps.m28715e(feedProps), this.f21054h), 0.0f).f21998h;
            state.d = new 1(this, state);
        }
        return state;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1792300264);
        m28779a((State) obj2, (PhotoAttachmentContainerView) view);
        Logger.a(8, EntryType.MARK_POP, 511101889, a);
    }

    public final boolean m28786a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return PhotoAttachmentPartDefinition.m28724a(feedProps) && m28780a((GraphQLStoryAttachment) feedProps.f13444a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        boolean z = false;
        if (state.c != null) {
            state.c.b(false);
            state.c.setSeePhotoOnClickListener(null);
            state.c = null;
            return;
        }
        if (!m28782b(state.a)) {
            z = true;
        }
        Preconditions.checkState(z);
    }

    public static PhotoAttachmentWithWarningsPartDefinition m28778a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotoAttachmentWithWarningsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21046k) {
                PhotoAttachmentWithWarningsPartDefinition photoAttachmentWithWarningsPartDefinition;
                if (a2 != null) {
                    photoAttachmentWithWarningsPartDefinition = (PhotoAttachmentWithWarningsPartDefinition) a2.mo818a(f21046k);
                } else {
                    photoAttachmentWithWarningsPartDefinition = f21045j;
                }
                if (photoAttachmentWithWarningsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28781b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21046k, b3);
                        } else {
                            f21045j = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = photoAttachmentWithWarningsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public PhotoAttachmentWithWarningsPartDefinition(Resources resources, PhotoAttachmentPartDefinition photoAttachmentPartDefinition, PhotoAttachmentLayoutHelper photoAttachmentLayoutHelper, DrawableUtil drawableUtil, BasePaddingStyleResolver basePaddingStyleResolver, TabletExperimentConfiguration tabletExperimentConfiguration, Lazy<DisturbingMediaTracker> lazy, Lazy<LocalStatsLogger> lazy2) {
        this.f21055i = photoAttachmentPartDefinition;
        this.f21047a = photoAttachmentLayoutHelper;
        this.f21051e = basePaddingStyleResolver;
        this.f21052f = lazy;
        this.f21053g = lazy2;
        this.f21048b = drawableUtil.m28758a(2130840254);
        this.f21054h = (float) resources.getDimensionPixelSize(2131427380);
        this.f21049c = (tabletExperimentConfiguration.m7858a() ? Builder.m19301a() : Builder.m19303c()).m19310a(this.f21048b, this.f21054h).m19313i();
        this.f21050d = Builder.m19301a().m19310a(this.f21048b, this.f21054h).m19313i();
    }

    public final ViewType mo2547a() {
        return this.f21055i.mo2547a();
    }

    private void m28779a(State state, PhotoAttachmentContainerView photoAttachmentContainerView) {
        if (m28782b(state.a)) {
            state.c = DisturbingMediaView.a(photoAttachmentContainerView);
            LayoutParams layoutParams = state.c.getLayoutParams();
            layoutParams.height = state.b;
            state.c.setLayoutParams(layoutParams);
            state.c.setSeePhotoOnClickListener(state.d);
            state.c.a(false);
        }
    }

    private boolean m28780a(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (!m28782b(graphQLStoryAttachment.m23979r())) {
            return false;
        }
        ((LocalStatsLoggerImpl) this.f21053g.get()).m13616a(6946818);
        return true;
    }

    private boolean m28782b(GraphQLMedia graphQLMedia) {
        return graphQLMedia.ak() && !((DisturbingMediaTracker) this.f21052f.get()).a(graphQLMedia);
    }
}
