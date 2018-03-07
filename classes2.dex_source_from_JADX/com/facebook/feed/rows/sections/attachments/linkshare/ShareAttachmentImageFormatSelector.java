package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import com.facebook.browser.liteclient.qe.ExperimentsForBrowserLiteQEModule;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.GifShareAttachmentPartDefinition;
import com.facebook.feed.rows.sections.attachments.linkshare.CoverPhotoShareAttachmentWithTextPreviewPartDefinition.Props;
import com.facebook.feed.rows.sections.attachments.linkshare.components.ShareAttachmentComponentPartDefinition;
import com.facebook.feedplugins.attachments.linkshare.follow.FollowShareAttachmentKey;
import com.facebook.feedplugins.attachments.linkshare.follow.FollowShareAttachmentPersistentState;
import com.facebook.feedplugins.attachments.linkshare.offlinesave.OfflineAttachmentSaveGroupDefinition;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.interfaces.CacheableEntity;
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
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_more_threads */
public class ShareAttachmentImageFormatSelector extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, FeedEnvironment> {
    private static ShareAttachmentImageFormatSelector f24008r;
    private static final Object f24009s = new Object();
    private final Lazy<AttachmentLinkCoverPartDefinition<FeedEnvironment>> f24010a;
    private final Lazy<InstantArticleShareAttachmentPartDefinition<FeedEnvironment, ?>> f24011b;
    private final Lazy<InstantArticleSidePhotoPartDefinition<FeedEnvironment>> f24012c;
    private final Lazy<PlayableShareAttachmentPartDefinition<FeedEnvironment, ?>> f24013d;
    private final Lazy<SquarePhotoShareAttachmentSelector> f24014e;
    private final Lazy<DataSavingsPhotoAttachmentPartDefinition> f24015f;
    private final Lazy<PortraitPhotoShareAttachmentPartDefinition<FeedEnvironment>> f24016g;
    private final Lazy<CoverPhotoShareAttachmentPartDefinition<FeedEnvironment, ?>> f24017h;
    private final Lazy<ShareAttachmentComponentPartDefinition<FeedEnvironment>> f24018i;
    private final Lazy<RatingBarShareAttachmentPartDefinition<FeedEnvironment, ?>> f24019j;
    private final Lazy<DonationShareAttachmentPartDefinition<FeedEnvironment, ?>> f24020k;
    private final Lazy<FollowShareAttachmentSelector> f24021l;
    private final Lazy<OfflineAttachmentSaveGroupDefinition> f24022m;
    private final Lazy<GifShareAttachmentPartDefinition<FeedEnvironment>> f24023n;
    private final Lazy<CoverPhotoShareAttachmentWithTextPreviewPartDefinition<FeedEnvironment, ?>> f24024o;
    private final Lazy<ObjectionableContentCoverPhotoShareAttachmentPartDefinition<FeedEnvironment>> f24025p;
    public final QeAccessor f24026q;

    private static ShareAttachmentImageFormatSelector m32427b(InjectorLike injectorLike) {
        return new ShareAttachmentImageFormatSelector(IdBasedLazy.m1808a(injectorLike, 1565), IdBasedLazy.m1808a(injectorLike, 1552), IdBasedLazy.m1808a(injectorLike, 1564), IdBasedLazy.m1808a(injectorLike, 1570), IdBasedLazy.m1808a(injectorLike, 1554), IdBasedLazy.m1808a(injectorLike, 1563), IdBasedLazy.m1808a(injectorLike, 1556), IdBasedLazy.m1808a(injectorLike, 1548), IdBasedLazy.m1808a(injectorLike, 1574), IdBasedLazy.m1808a(injectorLike, 1555), IdBasedLazy.m1808a(injectorLike, 6007), IdBasedLazy.m1808a(injectorLike, 1804), IdBasedLazy.m1808a(injectorLike, 1524), IdBasedLazy.m1808a(injectorLike, 1557), IdBasedLazy.m1808a(injectorLike, 1553), IdBasedLazy.m1808a(injectorLike, 1561), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        if (feedEnvironment.mo2446c().mo2419a() == FeedListName.SEARCH_DENSE_FEED || feedEnvironment.mo2446c().mo2419a() == FeedListName.SEARCH_DENSE_FEED_WITHOUT_UFI) {
            SubPartsSelector.m19115a(baseMultiRowSubParts, this.f24014e, obj);
        } else {
            boolean z = false;
            if (this.f24026q.mo596a(ExperimentsForBrowserLiteQEModule.f24028b, false)) {
                CacheableEntity c = AttachmentProps.m28714c(obj);
                if (!(c == null || c.mo2890l() == null)) {
                    boolean y_ = c.mo2890l().y_();
                    InstantPreviewState instantPreviewState = (InstantPreviewState) feedEnvironment.mo2425a(new InstantPreviewKey(c), c);
                    if (y_) {
                        if (instantPreviewState.b) {
                            z = true;
                        } else if (instantPreviewState.a == TriState.NO && y_) {
                            z = true;
                        }
                    }
                    instantPreviewState.a = TriState.valueOf(y_);
                    instantPreviewState.b = z;
                }
            }
            boolean z2 = z;
            SubPartsSelector a = SubPartsSelector.m19115a(baseMultiRowSubParts, this.f24015f, obj).m19119a(this.f24020k, obj).m19119a(this.f24010a, obj).m19119a(this.f24019j, obj);
            if (feedEnvironment.mo2446c().mo2419a() == FeedListName.FEED) {
                a.m19118a((MultiRowSinglePartDefinition) this.f24025p.get(), obj);
            }
            a.m19119a(this.f24011b, obj).m19119a(this.f24012c, obj).m19119a(this.f24023n, obj).m19119a(this.f24016g, obj).m19119a(this.f24013d, obj).m19119a(this.f24024o, new Props(obj, z2)).m19119a(this.f24018i, obj).m19119a(this.f24017h, obj).m19119a(this.f24014e, obj);
        }
        if (((FollowShareAttachmentPersistentState) feedEnvironment.mo2425a(new FollowShareAttachmentKey(obj), AttachmentProps.m28714c(obj))).f24268b) {
            baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f24021l.get(), obj);
        } else {
            baseMultiRowSubParts.m19112a((MultiRowPartWithIsNeeded) this.f24022m.get(), obj);
        }
        return null;
    }

    public static ShareAttachmentImageFormatSelector m32426a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ShareAttachmentImageFormatSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24009s) {
                ShareAttachmentImageFormatSelector shareAttachmentImageFormatSelector;
                if (a2 != null) {
                    shareAttachmentImageFormatSelector = (ShareAttachmentImageFormatSelector) a2.mo818a(f24009s);
                } else {
                    shareAttachmentImageFormatSelector = f24008r;
                }
                if (shareAttachmentImageFormatSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32427b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24009s, b3);
                        } else {
                            f24008r = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = shareAttachmentImageFormatSelector;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ShareAttachmentImageFormatSelector(Lazy<RatingBarShareAttachmentPartDefinition> lazy, Lazy<CoverPhotoShareAttachmentPartDefinition> lazy2, Lazy<PortraitPhotoShareAttachmentPartDefinition> lazy3, Lazy<SquarePhotoShareAttachmentSelector> lazy4, Lazy<DataSavingsPhotoAttachmentPartDefinition> lazy5, Lazy<PlayableShareAttachmentPartDefinition> lazy6, Lazy<InstantArticleShareAttachmentPartDefinition> lazy7, Lazy<AttachmentLinkCoverPartDefinition> lazy8, Lazy<ShareAttachmentComponentPartDefinition> lazy9, Lazy<DonationShareAttachmentPartDefinition> lazy10, Lazy<FollowShareAttachmentSelector> lazy11, Lazy<OfflineAttachmentSaveGroupDefinition> lazy12, Lazy<GifShareAttachmentPartDefinition> lazy13, Lazy<InstantArticleSidePhotoPartDefinition> lazy14, Lazy<CoverPhotoShareAttachmentWithTextPreviewPartDefinition> lazy15, Lazy<ObjectionableContentCoverPhotoShareAttachmentPartDefinition> lazy16, QeAccessor qeAccessor) {
        this.f24010a = lazy8;
        this.f24011b = lazy7;
        this.f24013d = lazy6;
        this.f24014e = lazy4;
        this.f24015f = lazy5;
        this.f24016g = lazy3;
        this.f24017h = lazy2;
        this.f24019j = lazy;
        this.f24018i = lazy9;
        this.f24020k = lazy10;
        this.f24021l = lazy11;
        this.f24022m = lazy12;
        this.f24023n = lazy13;
        this.f24012c = lazy14;
        this.f24024o = lazy15;
        this.f24025p = lazy16;
        this.f24026q = qeAccessor;
    }
}
