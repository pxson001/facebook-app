package com.facebook.feedplugins.attachments.multimedia;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.collage.PhotoGridProperties;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.collage.CollageAttachmentPartDefinition;
import com.facebook.feedplugins.attachments.multimedia.ui.MultimediaAttachmentView;
import com.facebook.feedplugins.attachments.video.InlineVideoPartDefinition;
import com.facebook.feedplugins.attachments.video.InlineVideoPartDefinition.Props;
import com.facebook.feedplugins.attachments.video.VideoAttachmentDelegate.VideoSizeAndBackgroundOverride;
import com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition;
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
import com.facebook.video.player.PlayerActivityManager;
import com.google.common.base.Optional;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: groups/events/{%s} */
public class MultimediaCollageAttachmentPartDefinition<E extends HasFeedListType & HasInvalidate & HasImageLoadListener & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, MultimediaAttachmentView> {
    public static final ViewType f21594a = new C08562();
    private static MultimediaCollageAttachmentPartDefinition f21595j;
    private static final Object f21596k = new Object();
    public final CollageAttachmentPartDefinition<E> f21597b;
    private final Lazy<InlineVideoPartDefinition> f21598c;
    private final Lazy<VideoZeroDialogPartDefinition> f21599d;
    private final PhotoGridProperties f21600e;
    public final PlayerActivityManager f21601f;
    private final MultimediaAttachmentUtil f21602g;
    private final QeAccessor f21603h;
    private final C08571 f21604i = new C08571(this);

    /* compiled from: groups/events/{%s} */
    final class C08562 extends ViewType {
        C08562() {
        }

        public final View mo1995a(Context context) {
            return new MultimediaAttachmentView(context);
        }
    }

    /* compiled from: groups/events/{%s} */
    public class C08571 {
        public final /* synthetic */ MultimediaCollageAttachmentPartDefinition f21605a;

        C08571(MultimediaCollageAttachmentPartDefinition multimediaCollageAttachmentPartDefinition) {
            this.f21605a = multimediaCollageAttachmentPartDefinition;
        }
    }

    private static MultimediaCollageAttachmentPartDefinition m29298b(InjectorLike injectorLike) {
        return new MultimediaCollageAttachmentPartDefinition(CollageAttachmentPartDefinition.m29238a(injectorLike), IdBasedLazy.m1808a(injectorLike, 6191), IdBasedLazy.m1808a(injectorLike, 1817), PhotoGridProperties.m28823b(injectorLike), PlayerActivityManager.m12995a(injectorLike), MultimediaAttachmentUtil.m29294b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2755a(2131564005, this.f21597b, feedProps);
        State state = new State(this.f21602g.m29295a(feedProps));
        if (m29299b()) {
            subParts.mo2755a(2131558600, (SinglePartDefinition) this.f21598c.get(), new Props((FeedProps) this.f21600e.m28829a(feedProps).get(state.a), -1, Optional.of(new VideoSizeAndBackgroundOverride(-1, -1, 0)), new AtomicReference()));
            if (this.f21603h.mo596a(ExperimentsForMediaGalleryAbTestModule.l, false)) {
                subParts.mo2755a(2131558600, (SinglePartDefinition) this.f21599d.get(), new VideoZeroDialogPartDefinition.Props(new 3(this, state)));
            }
        }
        return state;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 940926976);
        m29297a((FeedProps) obj, (State) obj2, (MultimediaAttachmentView) view);
        Logger.a(8, EntryType.MARK_POP, 1248186073, a);
    }

    public final boolean m29303a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return this.f21597b.m29253a(feedProps) && this.f21602g.m29295a(feedProps) != -1;
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        MultimediaAttachmentView multimediaAttachmentView = (MultimediaAttachmentView) view;
        multimediaAttachmentView.setVideoIndex(-1);
        multimediaAttachmentView.f = null;
    }

    public static MultimediaCollageAttachmentPartDefinition m29296a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MultimediaCollageAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21596k) {
                MultimediaCollageAttachmentPartDefinition multimediaCollageAttachmentPartDefinition;
                if (a2 != null) {
                    multimediaCollageAttachmentPartDefinition = (MultimediaCollageAttachmentPartDefinition) a2.mo818a(f21596k);
                } else {
                    multimediaCollageAttachmentPartDefinition = f21595j;
                }
                if (multimediaCollageAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29298b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21596k, b3);
                        } else {
                            f21595j = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = multimediaCollageAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public MultimediaCollageAttachmentPartDefinition(CollageAttachmentPartDefinition collageAttachmentPartDefinition, Lazy<InlineVideoPartDefinition> lazy, Lazy<VideoZeroDialogPartDefinition> lazy2, PhotoGridProperties photoGridProperties, PlayerActivityManager playerActivityManager, MultimediaAttachmentUtil multimediaAttachmentUtil, QeAccessor qeAccessor) {
        this.f21597b = collageAttachmentPartDefinition;
        this.f21598c = lazy;
        this.f21599d = lazy2;
        this.f21600e = photoGridProperties;
        this.f21601f = playerActivityManager;
        this.f21602g = multimediaAttachmentUtil;
        this.f21603h = qeAccessor;
    }

    public final ViewType<MultimediaAttachmentView> mo2547a() {
        return f21594a;
    }

    private boolean m29299b() {
        return this.f21603h.mo596a(ExperimentsForNewsFeedAbTestModule.f5079F, false);
    }

    private void m29297a(FeedProps<GraphQLStoryAttachment> feedProps, State state, MultimediaAttachmentView multimediaAttachmentView) {
        if (!this.f21597b.m29256b((FeedProps) feedProps) && m29299b()) {
            multimediaAttachmentView.setVideoIndex(state.a);
        }
        multimediaAttachmentView.f = this.f21604i;
    }
}
