package com.facebook.platform.composer.privacy;

import android.content.res.Resources;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.privacy.common.ComposerAlbumPrivacyDelegate;
import com.facebook.composer.privacy.common.ComposerAlbumPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerDisabledPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerEventPrivacyDelegateProvider;
import com.facebook.composer.privacy.common.ComposerGroupPrivacyDelegateProvider;
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
import com.facebook.platform.composer.composer.PlatformComposerFragment.C05254;
import com.facebook.platform.composer.composer.PlatformComposerFragment.C05265;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: return_from_app_store */
public final class PlatformComposerPrivacyController {
    private static final ImmutableList<ComposerEvent> f4244d = ImmutableList.of(ComposerEvent.ON_DATASET_CHANGE);
    public ComposerPrivacyDelegate f4245a;
    private String f4246b;
    public ComposerSelectablePrivacyDelegate f4247c;
    public final WeakReference<ComposerPrivacyDataProvider> f4248e;
    public final WeakReference<ComposerPrivacyCallback> f4249f;
    public final ComposerAlbumPrivacyDelegateProvider f4250g;
    public final ComposerPageAdminPrivacyDelegateProvider f4251h;
    public final ComposerSelectablePrivacyDelegateProvider f4252i;
    public final ComposerEventPrivacyDelegateProvider f4253j;
    public final ComposerGroupPrivacyDelegateProvider f4254k;
    public final ComposerTimelinePrivacyDelegateProvider f4255l;
    public final ComposerPagePrivacyDelegateProvider f4256m;
    public final ComposerDisabledPrivacyDelegateProvider f4257n;
    public final Resources f4258o;

    /* compiled from: return_from_app_store */
    public /* synthetic */ class C05461 {
        public static final /* synthetic */ int[] f4243a = new int[TargetType.values().length];

        static {
            try {
                f4243a[TargetType.UNDIRECTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4243a[TargetType.EVENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4243a[TargetType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4243a[TargetType.USER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4243a[TargetType.PAGE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    @Inject
    public PlatformComposerPrivacyController(@Assisted C05254 c05254, @Assisted C05265 c05265, ComposerAlbumPrivacyDelegateProvider composerAlbumPrivacyDelegateProvider, ComposerPageAdminPrivacyDelegateProvider composerPageAdminPrivacyDelegateProvider, ComposerSelectablePrivacyDelegateProvider composerSelectablePrivacyDelegateProvider, ComposerEventPrivacyDelegateProvider composerEventPrivacyDelegateProvider, ComposerGroupPrivacyDelegateProvider composerGroupPrivacyDelegateProvider, ComposerTimelinePrivacyDelegateProvider composerTimelinePrivacyDelegateProvider, ComposerPagePrivacyDelegateProvider composerPagePrivacyDelegateProvider, ComposerDisabledPrivacyDelegateProvider composerDisabledPrivacyDelegateProvider, Resources resources) {
        this.f4248e = new WeakReference(c05254);
        this.f4249f = new WeakReference(c05265);
        this.f4250g = composerAlbumPrivacyDelegateProvider;
        this.f4251h = composerPageAdminPrivacyDelegateProvider;
        this.f4252i = composerSelectablePrivacyDelegateProvider;
        this.f4253j = composerEventPrivacyDelegateProvider;
        this.f4254k = composerGroupPrivacyDelegateProvider;
        this.f4255l = composerTimelinePrivacyDelegateProvider;
        this.f4256m = composerPagePrivacyDelegateProvider;
        this.f4257n = composerDisabledPrivacyDelegateProvider;
        this.f4258o = resources;
        m4190c();
    }

    public final void m4191a(ComposerEvent composerEvent) {
        if (f4244d.contains(composerEvent)) {
            m4190c();
        }
    }

    private void m4190c() {
        ComposerConfiguration composerConfiguration;
        ComposerTargetData composerTargetData;
        ComposerAlbumPrivacyDelegate a;
        C05254 c05254 = (C05254) Preconditions.checkNotNull(this.f4248e.get());
        C05265 c05265 = (C05265) Preconditions.checkNotNull(this.f4249f.get());
        if (c05254.f4098a.aO == null) {
            composerConfiguration = null;
        } else {
            composerConfiguration = c05254.f4098a.aO.f4187b;
        }
        ComposerConfiguration composerConfiguration2 = composerConfiguration;
        if (c05254.f4098a.aO == null) {
            composerTargetData = null;
        } else {
            composerTargetData = c05254.f4098a.aO.f4190e;
        }
        ComposerTargetData composerTargetData2 = composerTargetData;
        Preconditions.checkNotNull(composerConfiguration2);
        if (c05254.m4037d() == null || composerTargetData2.targetType == TargetType.GROUP) {
            if (!composerTargetData2.actsAsTarget) {
                switch (C05461.f4243a[composerTargetData2.targetType.ordinal()]) {
                    case 1:
                        if (this.f4247c == null) {
                            a = this.f4252i.a(c05265, c05265, c05254.m4038f(), c05254);
                            this.f4247c = a;
                            break;
                        }
                        this.f4247c.a(c05254.m4038f());
                        a = this.f4247c;
                        break;
                    case 2:
                        a = this.f4253j.a(c05265, Long.valueOf(composerTargetData2.targetId), composerTargetData2.targetName, composerTargetData2.targetPrivacy);
                        break;
                    case 3:
                        a = this.f4254k.a(c05265, Long.valueOf(composerTargetData2.targetId), composerTargetData2.targetName);
                        break;
                    case 4:
                        a = this.f4255l.a(c05265, Long.valueOf(composerTargetData2.targetId), composerTargetData2.targetName, composerTargetData2.targetPrivacy);
                        break;
                    case 5:
                        a = this.f4256m.a(c05265, composerTargetData2.targetName);
                        break;
                    default:
                        a = this.f4257n.a(c05265);
                        break;
                }
            }
            a = this.f4251h.a(c05265, this.f4258o.getString(2131234192), this.f4258o.getString(2131234611, new Object[]{composerTargetData2.targetName}));
        } else {
            a = this.f4250g.a(c05265, c05254.m4037d());
        }
        ComposerPrivacyDelegate composerPrivacyDelegate = a;
        Object obj = this.f4245a != null ? 1 : null;
        if (obj == null || !this.f4246b.equals(composerPrivacyDelegate.b())) {
            if (obj != null) {
                this.f4245a.e();
            }
            this.f4245a = composerPrivacyDelegate;
            this.f4246b = this.f4245a.b();
            if (obj != null) {
                this.f4245a.a();
            }
        }
    }
}
