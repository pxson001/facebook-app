package com.facebook.feedplugins.attachments.album;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.AlbumAttachmentHScrollPartDefinition;
import com.facebook.feedplugins.attachments.collage.CollageAttachmentPartDefinition;
import com.facebook.feedplugins.attachments.collage.CollageAttachmentWithWarningsPartDefinition;
import com.facebook.feedplugins.attachments.collage.ObjectionableContentCollageAttachmentPartDefinition;
import com.facebook.feedplugins.attachments.multimedia.MultimediaCollageAttachmentPartDefinition;
import com.facebook.feedplugins.attachments.multimedia.MultimediaSinglePlayerAttachmentPartDefinition;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: groups_xanalytics_double_logging_gatekeeper */
public class AlbumAttachmentSelector extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static AlbumAttachmentSelector f21508g;
    private static final Object f21509h = new Object();
    private final Lazy<MultimediaCollageAttachmentPartDefinition<FeedEnvironment>> f21510a;
    private final Lazy<MultimediaSinglePlayerAttachmentPartDefinition<FeedEnvironment>> f21511b;
    private final Lazy<AlbumAttachmentHScrollPartDefinition<FeedEnvironment>> f21512c;
    private final Lazy<CollageAttachmentWithWarningsPartDefinition<FeedEnvironment>> f21513d;
    private final Lazy<CollageAttachmentPartDefinition<FeedEnvironment>> f21514e;
    private final Lazy<ObjectionableContentCollageAttachmentPartDefinition<FeedEnvironment>> f21515f;

    private static AlbumAttachmentSelector m29220b(InjectorLike injectorLike) {
        return new AlbumAttachmentSelector(IdBasedLazy.m1808a(injectorLike, 1800), IdBasedLazy.m1808a(injectorLike, 1801), IdBasedLazy.m1808a(injectorLike, 5970), IdBasedLazy.m1808a(injectorLike, 1806), IdBasedLazy.m1808a(injectorLike, 1807), IdBasedLazy.m1808a(injectorLike, 1802));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        SubPartsSelector a = SubPartsSelector.m19115a(baseMultiRowSubParts, this.f21513d, obj);
        if (feedEnvironment.mo2446c().mo2419a() == FeedListName.FEED) {
            a.m19118a((MultiRowSinglePartDefinition) this.f21515f.get(), obj);
        }
        a.m19119a(this.f21511b, obj).m19119a(this.f21510a, obj).m19119a(this.f21514e, obj).m19119a(this.f21512c, obj);
        return null;
    }

    @Inject
    public AlbumAttachmentSelector(Lazy<CollageAttachmentPartDefinition> lazy, Lazy<CollageAttachmentWithWarningsPartDefinition> lazy2, Lazy<AlbumAttachmentHScrollPartDefinition> lazy3, Lazy<MultimediaCollageAttachmentPartDefinition> lazy4, Lazy<MultimediaSinglePlayerAttachmentPartDefinition> lazy5, Lazy<ObjectionableContentCollageAttachmentPartDefinition> lazy6) {
        this.f21510a = lazy4;
        this.f21511b = lazy5;
        this.f21512c = lazy3;
        this.f21513d = lazy2;
        this.f21514e = lazy;
        this.f21515f = lazy6;
    }

    public static AlbumAttachmentSelector m29219a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AlbumAttachmentSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21509h) {
                AlbumAttachmentSelector albumAttachmentSelector;
                if (a2 != null) {
                    albumAttachmentSelector = (AlbumAttachmentSelector) a2.mo818a(f21509h);
                } else {
                    albumAttachmentSelector = f21508g;
                }
                if (albumAttachmentSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29220b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21509h, b3);
                        } else {
                            f21508g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = albumAttachmentSelector;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final boolean mo2536a(Object obj) {
        return true;
    }
}
