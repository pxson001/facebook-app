package com.facebook.composer.controller;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass35;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass37;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.privacy.common.ComposerAlbumPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerDisabledPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerEventPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerGroupPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerMarketplacePrivacyDelegate;
import com.facebook.composer.privacy.common.ComposerMarketplacePrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerPageAdminPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerPagePrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegate;
import com.facebook.composer.privacy.common.ComposerSelectablePrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerTimelinePrivacyDelegateProvider;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: icon_link */
public final class ComposerPrivacyController implements ComposerEventHandler {
    public ComposerPrivacyDelegate f6267a;
    private String f6268b;
    private ComposerSelectablePrivacyDelegate f6269c;
    private final WeakReference<ComposerPrivacyDataProvider> f6270d;
    private final WeakReference<ComposerPrivacyCallback> f6271e;
    private final ComposerAlbumPrivacyDelegateProvider f6272f;
    private final ComposerPageAdminPrivacyDelegateProvider f6273g;
    private final ComposerSelectablePrivacyDelegateProvider f6274h;
    private final ComposerEventPrivacyDelegateProvider f6275i;
    private final ComposerGroupPrivacyDelegateProvider f6276j;
    private final ComposerTimelinePrivacyDelegateProvider f6277k;
    private final ComposerPagePrivacyDelegateProvider f6278l;
    private final ComposerMarketplacePrivacyDelegateProvider f6279m;
    private final ComposerDisabledPrivacyDelegateProvider f6280n;
    private final Resources f6281o;
    private final Boolean f6282p;

    /* compiled from: icon_link */
    /* synthetic */ class C07821 {
        static final /* synthetic */ int[] f6265a = new int[ComposerEvent.values().length];
        static final /* synthetic */ int[] f6266b = new int[TargetType.values().length];

        static {
            try {
                f6266b[TargetType.EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6266b[TargetType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6266b[TargetType.USER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6266b[TargetType.PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6266b[TargetType.MARKETPLACE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f6265a[ComposerEvent.ON_DATASET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Inject
    public ComposerPrivacyController(@Assisted AnonymousClass37 anonymousClass37, @Assisted AnonymousClass35 anonymousClass35, ComposerAlbumPrivacyDelegateProvider composerAlbumPrivacyDelegateProvider, ComposerPageAdminPrivacyDelegateProvider composerPageAdminPrivacyDelegateProvider, ComposerSelectablePrivacyDelegateProvider composerSelectablePrivacyDelegateProvider, ComposerEventPrivacyDelegateProvider composerEventPrivacyDelegateProvider, ComposerGroupPrivacyDelegateProvider composerGroupPrivacyDelegateProvider, ComposerTimelinePrivacyDelegateProvider composerTimelinePrivacyDelegateProvider, ComposerPagePrivacyDelegateProvider composerPagePrivacyDelegateProvider, ComposerMarketplacePrivacyDelegateProvider composerMarketplacePrivacyDelegateProvider, ComposerDisabledPrivacyDelegateProvider composerDisabledPrivacyDelegateProvider, Resources resources, Boolean bool) {
        this.f6270d = new WeakReference(anonymousClass37);
        this.f6271e = new WeakReference(anonymousClass35);
        this.f6272f = composerAlbumPrivacyDelegateProvider;
        this.f6273g = composerPageAdminPrivacyDelegateProvider;
        this.f6274h = composerSelectablePrivacyDelegateProvider;
        this.f6275i = composerEventPrivacyDelegateProvider;
        this.f6276j = composerGroupPrivacyDelegateProvider;
        this.f6277k = composerTimelinePrivacyDelegateProvider;
        this.f6278l = composerPagePrivacyDelegateProvider;
        this.f6279m = composerMarketplacePrivacyDelegateProvider;
        this.f6280n = composerDisabledPrivacyDelegateProvider;
        this.f6281o = resources;
        this.f6282p = bool;
        m7722c();
    }

    public final void m7724a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        switch (C07821.f6265a[composerEvent.ordinal()]) {
            case 1:
                m7722c();
                return;
            default:
                return;
        }
    }

    private void m7722c() {
        ComposerPrivacyDelegate d = m7723d();
        Object obj = this.f6267a != null ? 1 : null;
        if (obj == null || !this.f6268b.equals(d.b())) {
            if (obj != null) {
                this.f6267a.e();
            }
            this.f6267a = d;
            this.f6268b = this.f6267a.b();
            if (obj != null) {
                this.f6267a.a();
            }
        }
    }

    private ComposerPrivacyDelegate m7723d() {
        AnonymousClass37 anonymousClass37 = (AnonymousClass37) Preconditions.checkNotNull(this.f6270d.get());
        AnonymousClass35 anonymousClass35 = (AnonymousClass35) Preconditions.checkNotNull(this.f6271e.get());
        if (anonymousClass37.m7474h() != null) {
            return anonymousClass37.m7474h().a(anonymousClass35, anonymousClass35);
        }
        ComposerConfiguration o = anonymousClass37.f6068a.aS.o();
        ComposerTargetData s = anonymousClass37.f6068a.aS.m7443s();
        Preconditions.checkNotNull(o);
        if (anonymousClass37.m7472d() != null && s.targetType != TargetType.GROUP) {
            return this.f6272f.a(anonymousClass35, anonymousClass37.m7472d());
        }
        if (s.actsAsTarget) {
            return this.f6273g.a(anonymousClass35, this.f6281o.getString(2131234192), this.f6281o.getString(2131234611, new Object[]{s.targetName}));
        } else if (s.targetType != TargetType.UNDIRECTED || (o.isEdit() && (!o.isEditPrivacyEnabled() || this.f6282p.booleanValue()))) {
            switch (C07821.f6266b[s.targetType.ordinal()]) {
                case 1:
                    return this.f6275i.a(anonymousClass35, Long.valueOf(s.targetId), s.targetName, s.targetPrivacy);
                case 2:
                    return this.f6276j.a(anonymousClass35, Long.valueOf(s.targetId), s.targetName);
                case 3:
                    return this.f6277k.a(anonymousClass35, Long.valueOf(s.targetId), s.targetName, s.targetPrivacy);
                case 4:
                    return this.f6278l.a(anonymousClass35, s.targetName);
                case 5:
                    ComposerMarketplacePrivacyDelegateProvider composerMarketplacePrivacyDelegateProvider = this.f6279m;
                    return new ComposerMarketplacePrivacyDelegate(anonymousClass35, (AbstractFbErrorReporter) FbErrorReporterImpl.a(composerMarketplacePrivacyDelegateProvider), TasksManager.b(composerMarketplacePrivacyDelegateProvider), ResourcesMethodAutoProvider.a(composerMarketplacePrivacyDelegateProvider), s.targetName);
                default:
                    return this.f6280n.a(anonymousClass35);
            }
        } else if (this.f6269c != null) {
            this.f6269c.a(anonymousClass37.m7473f());
            return this.f6269c;
        } else {
            ComposerPrivacyDelegate a = this.f6274h.a(anonymousClass35, anonymousClass35, anonymousClass37.m7473f(), anonymousClass37);
            this.f6269c = a;
            return a;
        }
    }
}
