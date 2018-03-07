package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.attachments.collage.CollageAttachmentPartDefinition;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: goodwill_throwback_share_composer_open_birthday_frame */
public class ThrowbackCollageAttachmentPartDefinition<E extends HasFeedListType & HasInvalidate & HasImageLoadListener & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, CollageAttachmentView> {
    private static ThrowbackCollageAttachmentPartDefinition f12364e;
    private static final Object f12365f = new Object();
    private final CollageAttachmentPartDefinition<E> f12366a;
    private final ThrowbackCollageClickOverridePartDefinition f12367b;
    private final BackgroundPartDefinition f12368c;
    private final GatekeeperStoreImpl f12369d;

    private static ThrowbackCollageAttachmentPartDefinition m14295b(InjectorLike injectorLike) {
        return new ThrowbackCollageAttachmentPartDefinition(CollageAttachmentPartDefinition.a(injectorLike), ThrowbackCollageClickOverridePartDefinition.m14301a(injectorLike), BackgroundPartDefinition.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m14297a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f12366a, StoryProps.i(feedProps));
        subParts.a(this.f12367b, null);
        if (this.f12369d.a(858, false)) {
            subParts.a(this.f12368c, new StylingData(feedProps, PaddingStyle.f, Position.MIDDLE));
        }
        return null;
    }

    @Inject
    public ThrowbackCollageAttachmentPartDefinition(CollageAttachmentPartDefinition collageAttachmentPartDefinition, ThrowbackCollageClickOverridePartDefinition throwbackCollageClickOverridePartDefinition, BackgroundPartDefinition backgroundPartDefinition, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f12366a = collageAttachmentPartDefinition;
        this.f12367b = throwbackCollageClickOverridePartDefinition;
        this.f12368c = backgroundPartDefinition;
        this.f12369d = gatekeeperStoreImpl;
    }

    public static ThrowbackCollageAttachmentPartDefinition m14294a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackCollageAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12365f) {
                ThrowbackCollageAttachmentPartDefinition throwbackCollageAttachmentPartDefinition;
                if (a2 != null) {
                    throwbackCollageAttachmentPartDefinition = (ThrowbackCollageAttachmentPartDefinition) a2.a(f12365f);
                } else {
                    throwbackCollageAttachmentPartDefinition = f12364e;
                }
                if (throwbackCollageAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14295b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12365f, b3);
                        } else {
                            f12364e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackCollageAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<CollageAttachmentView> m14296a() {
        return this.f12366a.a();
    }

    public final boolean m14298a(FeedProps<GraphQLStory> feedProps) {
        return this.f12366a.a(StoryProps.i(feedProps));
    }
}
