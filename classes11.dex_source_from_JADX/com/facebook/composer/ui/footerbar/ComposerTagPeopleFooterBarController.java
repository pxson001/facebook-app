package com.facebook.composer.ui.footerbar;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass15;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.tip.Tip;
import com.facebook.composer.tip.TipControllerInterface;
import com.facebook.composer.tip.TipManager;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.tooltip.Tooltip.OnTooltipClickListener;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsTagPeopleSupported;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: fb_mobile_app_name */
public class ComposerTagPeopleFooterBarController<DataProvider extends ProvidesAttachments & ProvidesIsTagPeopleSupported & ProvidesConfiguration & ProvidesLocationInfo & ProvidesTaggedUsers & ProvidesTargetData> extends ComposerFooterBarControllerBase {
    private static final ImmutableList<ComposerEvent> f7084a = ImmutableList.of(ComposerEvent.ON_FIRST_DRAW, ComposerEvent.ON_DATASET_CHANGE, ComposerEvent.ON_FACE_DETECTION_COMPLETE);
    private final OnClickListener f7085b = new C08961(this);
    public final Context f7086c;
    public final WeakReference<DataProvider> f7087d;
    public final LazyFooterView<GlyphButton> f7088e;
    public final AnonymousClass15 f7089f;

    /* compiled from: fb_mobile_app_name */
    class C08961 implements OnClickListener {
        final /* synthetic */ ComposerTagPeopleFooterBarController f7077a;

        C08961(ComposerTagPeopleFooterBarController composerTagPeopleFooterBarController) {
            this.f7077a = composerTagPeopleFooterBarController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 172485557);
            this.f7077a.f7089f.m7451a();
            Logger.a(2, EntryType.UI_INPUT_END, 309083653, a);
        }
    }

    /* compiled from: fb_mobile_app_name */
    public class C09002 implements TipControllerInterface {
        final /* synthetic */ ComposerTagPeopleFooterBarController f7081a;
        public Tooltip f7082b;
        public boolean f7083c = false;

        /* compiled from: fb_mobile_app_name */
        class C08991 implements Runnable {
            final /* synthetic */ C09002 f7080a;

            /* compiled from: fb_mobile_app_name */
            class C08971 implements OnTooltipClickListener {
                final /* synthetic */ C08991 f7078a;

                C08971(C08991 c08991) {
                    this.f7078a = c08991;
                }

                public final void m8336a() {
                    this.f7078a.f7080a.f7081a.f7089f.m7451a();
                }
            }

            /* compiled from: fb_mobile_app_name */
            class C08982 implements OnDismissListener {
                final /* synthetic */ C08991 f7079a;

                C08982(C08991 c08991) {
                    this.f7079a = c08991;
                }

                public final boolean m8337a(PopoverWindow popoverWindow) {
                    this.f7079a.f7080a.f7083c = false;
                    return false;
                }
            }

            C08991(C09002 c09002) {
                this.f7080a = c09002;
            }

            public void run() {
                this.f7080a.f7082b = new Tooltip(this.f7080a.f7081a.f7086c, 2);
                this.f7080a.f7082b.b(2131234638);
                this.f7080a.f7082b.t = -1;
                this.f7080a.f7082b.a(new C08971(this));
                this.f7080a.f7082b.H = new C08982(this);
                this.f7080a.f7082b.a(Position.ABOVE);
                this.f7080a.f7082b.f(this.f7080a.f7081a.f7088e.m8352a());
            }
        }

        public C09002(ComposerTagPeopleFooterBarController composerTagPeopleFooterBarController) {
            this.f7081a = composerTagPeopleFooterBarController;
        }

        public final void m8338a() {
            this.f7083c = true;
            ((GlyphButton) this.f7081a.f7088e.m8352a()).post(new C08991(this));
        }

        public final boolean m8339b() {
            ProvidesAttachments providesAttachments = (ProvidesAttachments) this.f7081a.f7087d.get();
            if (providesAttachments == null) {
                return false;
            }
            return this.f7081a.m8344c() && ((ProvidesLocationInfo) providesAttachments).g().a() != null && ((ProvidesTaggedUsers) providesAttachments).h().isEmpty() && !((ProvidesTargetData) providesAttachments).s().a();
        }

        public final boolean m8340c() {
            if (this.f7082b == null) {
                return false;
            }
            this.f7082b.l();
            return true;
        }

        public final boolean m8341d() {
            return this.f7083c;
        }
    }

    @Inject
    public ComposerTagPeopleFooterBarController(@Assisted TipManager tipManager, @Assisted LazyFooterView<GlyphButton> lazyFooterView, @Assisted DataProvider dataProvider, @Assisted Listener listener, Context context) {
        this.f7086c = context;
        this.f7087d = new WeakReference(dataProvider);
        this.f7089f = listener;
        this.f7088e = lazyFooterView;
        tipManager.a(Tip.TAG_PEOPLE_FOR_CHECKIN, new C09002(this));
    }

    protected final ImmutableList<ComposerEvent> mo214a() {
        return f7084a;
    }

    public final void mo215b() {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) this.f7087d.get();
        if (providesAttachments != null) {
            if (m8344c()) {
                GlyphButton glyphButton = (GlyphButton) this.f7088e.m8352a();
                if (((ProvidesTaggedUsers) providesAttachments).h().isEmpty()) {
                    glyphButton.setGlyphColor(this.f7086c.getResources().getColorStateList(2131364092));
                } else {
                    glyphButton.setGlyphColor(this.f7086c.getResources().getColor(2131362954));
                }
                glyphButton.setVisibility(0);
                glyphButton.setOnClickListener(this.f7085b);
                return;
            }
            this.f7088e.m8353b();
        }
    }

    @VisibleForTesting
    final boolean m8344c() {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) this.f7087d.get();
        return providesAttachments != null && ((ComposerDataProviderImpl) providesAttachments).m7415Q();
    }
}
