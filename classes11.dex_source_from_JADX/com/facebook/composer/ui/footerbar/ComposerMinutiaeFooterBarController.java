package com.facebook.composer.ui.footerbar;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.NavigationLogger;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass16;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass21;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.minutiae.view.MinutiaeBadgeView;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: fbpage_new_message */
public class ComposerMinutiaeFooterBarController extends ComposerFooterBarControllerBase {
    private static final ImmutableList<ComposerEvent> f7052a = ImmutableList.of(ComposerEvent.ON_FIRST_DRAW, ComposerEvent.ON_DATASET_CHANGE);
    private final OnClickListener f7053b = new C08921(this);
    public final WeakReference<Listener> f7054c;
    public final WeakReference<MinutiaeFooterBarDataProvider> f7055d;
    public final LazyFooterView<BadgeableFooterButton> f7056e;

    /* compiled from: fbpage_new_message */
    class C08921 implements OnClickListener {
        final /* synthetic */ ComposerMinutiaeFooterBarController f7051a;

        C08921(ComposerMinutiaeFooterBarController composerMinutiaeFooterBarController) {
            this.f7051a = composerMinutiaeFooterBarController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1478642060);
            AnonymousClass16 anonymousClass16 = (AnonymousClass16) this.f7051a.f7054c.get();
            if (anonymousClass16 != null) {
                ((NavigationLogger) anonymousClass16.f6044a.ap.get()).a("tap_composer_footer_buttons");
                ComposerFragment.bT(anonymousClass16.f6044a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -246704512, a);
        }
    }

    @Inject
    public ComposerMinutiaeFooterBarController(@Assisted Listener listener, @Assisted MinutiaeFooterBarDataProvider minutiaeFooterBarDataProvider, @Assisted LazyFooterView<BadgeableFooterButton> lazyFooterView) {
        this.f7055d = new WeakReference(minutiaeFooterBarDataProvider);
        this.f7054c = new WeakReference(listener);
        this.f7056e = lazyFooterView;
    }

    protected final ImmutableList<ComposerEvent> mo214a() {
        return f7052a;
    }

    public final void mo215b() {
        Object obj;
        AnonymousClass21 anonymousClass21 = (AnonymousClass21) this.f7055d.get();
        if (anonymousClass21 == null || !anonymousClass21.f6050a.aS.m7409J()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            boolean z;
            MinutiaeBadgeView minutiaeBadgeView;
            BadgeableFooterButton badgeableFooterButton = (BadgeableFooterButton) this.f7056e.m8352a();
            anonymousClass21 = (AnonymousClass21) this.f7055d.get();
            if (anonymousClass21 != null) {
                Object obj2;
                if (anonymousClass21.f6050a.aS.m7436l() != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null) {
                    z = true;
                    badgeableFooterButton.setActive(z);
                    ((BadgeableFooterButton) this.f7056e.m8352a()).setVisibility(0);
                    ((BadgeableFooterButton) this.f7056e.m8352a()).setOnClickListener(this.f7053b);
                    anonymousClass21 = (AnonymousClass21) this.f7055d.get();
                    if (anonymousClass21 != null) {
                        if (anonymousClass21.f6050a.bG.f6341g) {
                            ((BadgeableFooterButton) this.f7056e.m8352a()).m8294a();
                            return;
                        }
                        minutiaeBadgeView = (MinutiaeBadgeView) ((BadgeableFooterButton) this.f7056e.m8352a()).getBadgeView();
                        minutiaeBadgeView.setData(anonymousClass21.f6050a.bG.m7769e());
                        minutiaeBadgeView.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            z = false;
            badgeableFooterButton.setActive(z);
            ((BadgeableFooterButton) this.f7056e.m8352a()).setVisibility(0);
            ((BadgeableFooterButton) this.f7056e.m8352a()).setOnClickListener(this.f7053b);
            anonymousClass21 = (AnonymousClass21) this.f7055d.get();
            if (anonymousClass21 != null) {
                return;
            }
            if (anonymousClass21.f6050a.bG.f6341g) {
                ((BadgeableFooterButton) this.f7056e.m8352a()).m8294a();
                return;
            }
            minutiaeBadgeView = (MinutiaeBadgeView) ((BadgeableFooterButton) this.f7056e.m8352a()).getBadgeView();
            minutiaeBadgeView.setData(anonymousClass21.f6050a.bG.m7769e());
            minutiaeBadgeView.setVisibility(0);
            return;
        }
        this.f7056e.m8353b();
    }
}
