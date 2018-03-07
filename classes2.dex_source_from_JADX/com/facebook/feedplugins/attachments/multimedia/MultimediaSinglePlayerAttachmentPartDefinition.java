package com.facebook.feedplugins.attachments.multimedia;

import android.content.Context;
import android.view.View;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.collage.PhotoGridProperties;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.collage.CollageAttachmentPartDefinition;
import com.facebook.feedplugins.attachments.multimedia.ui.MultimediaSinglePlayerAttachmentView;
import com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition;
import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition;
import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition.Props;
import com.facebook.feedplugins.video.RichVideoPlayerPartDefinition.VideoSizeAndBackgroundOverride;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.photos.mediagallery.abtest.ExperimentsForMediaGalleryAbTestModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Optional;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: groups/gridtab */
public class MultimediaSinglePlayerAttachmentPartDefinition<E extends HasFeedListType & HasInvalidate & HasImageLoadListener & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, MultimediaSinglePlayerAttachmentView> {
    public static final ViewType f21583a = new C08551();
    private static MultimediaSinglePlayerAttachmentPartDefinition f21584i;
    private static final Object f21585j = new Object();
    public final OptimisticStoryStateCache f21586b;
    private final Lazy<CollageAttachmentPartDefinition> f21587c;
    private final Lazy<RichVideoPlayerPartDefinition> f21588d;
    private final Lazy<VideoZeroDialogPartDefinition> f21589e;
    private final PhotoGridProperties f21590f;
    private final MultimediaAttachmentUtil f21591g;
    public final QeAccessor f21592h;

    /* compiled from: groups/gridtab */
    final class C08551 extends ViewType {
        C08551() {
        }

        public final View mo1995a(Context context) {
            return new MultimediaSinglePlayerAttachmentView(context);
        }
    }

    private static MultimediaSinglePlayerAttachmentPartDefinition m29287b(InjectorLike injectorLike) {
        return new MultimediaSinglePlayerAttachmentPartDefinition(OptimisticStoryStateCache.m9726a(injectorLike), IdBasedLazy.m1808a(injectorLike, 1800), IdBasedLazy.m1808a(injectorLike, 2061), IdBasedLazy.m1808a(injectorLike, 1817), PhotoGridProperties.m28823b(injectorLike), MultimediaAttachmentUtil.m29294b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2755a(2131564005, (SinglePartDefinition) this.f21587c.get(), feedProps);
        State state = new State(this.f21591g.m29295a(feedProps));
        subParts.mo2755a(2131558600, (SinglePartDefinition) this.f21588d.get(), new Props((FeedProps) this.f21590f.m28829a(feedProps).get(state.a), -1, Optional.of(new VideoSizeAndBackgroundOverride(-1, -1, 0)), new AtomicReference()));
        if (this.f21592h.mo596a(ExperimentsForMediaGalleryAbTestModule.l, false)) {
            subParts.mo2755a(2131558600, (SinglePartDefinition) this.f21589e.get(), new VideoZeroDialogPartDefinition.Props(new 2(this, state)));
        }
        return state;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1870067132);
        ((MultimediaSinglePlayerAttachmentView) view).setVideoIndex(((State) obj2).a);
        Logger.a(8, EntryType.MARK_POP, 2026641010, a);
    }

    public final boolean m29291a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (((CollageAttachmentPartDefinition) this.f21587c.get()).m29253a(feedProps) && this.f21591g.m29295a(feedProps) != -1) {
            Object obj2 = null;
            if (!(AttachmentProps.m28714c(feedProps) == null || this.f21586b.m9730b(AttachmentProps.m28714c(feedProps)))) {
                obj2 = 1;
            }
            if (obj2 == null && this.f21592h.mo596a(ExperimentsForNewsFeedAbTestModule.f5081H, false)) {
                return true;
            }
        }
        return false;
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((MultimediaSinglePlayerAttachmentView) view).setVideoIndex(-1);
    }

    public static MultimediaSinglePlayerAttachmentPartDefinition m29286a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MultimediaSinglePlayerAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21585j) {
                MultimediaSinglePlayerAttachmentPartDefinition multimediaSinglePlayerAttachmentPartDefinition;
                if (a2 != null) {
                    multimediaSinglePlayerAttachmentPartDefinition = (MultimediaSinglePlayerAttachmentPartDefinition) a2.mo818a(f21585j);
                } else {
                    multimediaSinglePlayerAttachmentPartDefinition = f21584i;
                }
                if (multimediaSinglePlayerAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29287b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21585j, b3);
                        } else {
                            f21584i = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = multimediaSinglePlayerAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public MultimediaSinglePlayerAttachmentPartDefinition(OptimisticStoryStateCache optimisticStoryStateCache, Lazy<CollageAttachmentPartDefinition> lazy, Lazy<RichVideoPlayerPartDefinition> lazy2, Lazy<VideoZeroDialogPartDefinition> lazy3, PhotoGridProperties photoGridProperties, MultimediaAttachmentUtil multimediaAttachmentUtil, QeAccessor qeAccessor) {
        this.f21586b = optimisticStoryStateCache;
        this.f21587c = lazy;
        this.f21588d = lazy2;
        this.f21589e = lazy3;
        this.f21590f = photoGridProperties;
        this.f21591g = multimediaAttachmentUtil;
        this.f21592h = qeAccessor;
    }

    public final ViewType<MultimediaSinglePlayerAttachmentView> mo2547a() {
        return f21583a;
    }
}
