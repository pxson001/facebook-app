package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AttachmentHasArticleIcon;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.attachments.angora.AttachmentHasPlayIcon;
import com.facebook.attachments.angora.AttachmentHasTooltipAnchor;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.device.ScreenUtil;
import com.facebook.fbui.popover.PopoverWindow$OnCancelListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.richdocument.nux.InstantArticleIconInterstitialController;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_all_pages */
public class ArticleIconPartDefinition<V extends View & AngoraAttachment & AttachmentHasLargeImage & AttachmentHasPlayIcon & AttachmentHasArticleIcon & AttachmentHasTooltipAnchor> extends BaseSinglePartDefinition<GraphQLStoryAttachment, Void, AnyEnvironment, V> {
    private static ArticleIconPartDefinition f24171r;
    private static final Object f24172s = new Object();
    public final InterstitialManager f24173a;
    private final Context f24174b;
    public final MonotonicClock f24175c;
    public final IconClickListener f24176d = new IconClickListener(this);
    private final TooltipOnCancelListener f24177e = new TooltipOnCancelListener(this);
    public Tooltip f24178f;
    public boolean f24179g;
    public long f24180h;
    public InterstitialController f24181i;
    public long f24182j;
    public int f24183k;
    public int f24184l;
    public int f24185m;
    public int f24186n;
    public final Rect f24187o = new Rect(0, 0, 0, 0);
    public final ScreenUtil f24188p;
    public boolean f24189q = false;

    /* compiled from: fetch_all_pages */
    class IconClickListener implements OnClickListener {
        final /* synthetic */ ArticleIconPartDefinition f24190a;

        public IconClickListener(ArticleIconPartDefinition articleIconPartDefinition) {
            this.f24190a = articleIconPartDefinition;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -362531731);
            ArticleIconPartDefinition.m32533d(this.f24190a, view);
            Logger.a(2, EntryType.UI_INPUT_END, -1316480185, a);
        }
    }

    /* compiled from: fetch_all_pages */
    class TooltipOnCancelListener implements PopoverWindow$OnCancelListener {
        final /* synthetic */ ArticleIconPartDefinition f24191a;

        public TooltipOnCancelListener(ArticleIconPartDefinition articleIconPartDefinition) {
            this.f24191a = articleIconPartDefinition;
        }

        public final boolean mo3515a() {
            this.f24191a.f24180h = this.f24191a.f24175c.now();
            if (!(this.f24191a.f24173a == null || this.f24191a.f24181i == null)) {
                this.f24191a.f24173a.m8121a().d(this.f24191a.f24181i.mo1173b());
            }
            return false;
        }
    }

    private static ArticleIconPartDefinition m32531b(InjectorLike injectorLike) {
        return new ArticleIconPartDefinition((Context) injectorLike.getInstance(Context.class), InterstitialManager.m8082a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), ScreenUtil.m8695a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean z = false;
        this.f24179g = false;
        this.f24181i = this.f24173a.m8118a(InstantArticleIconInterstitialController.a, InstantArticleIconInterstitialController.class);
        if (this.f24181i != null) {
            this.f24178f = m32530b();
            if (this.f24178f != null) {
                z = true;
            }
            this.f24179g = z;
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -235971193);
        ((AttachmentHasArticleIcon) view).setCoverPhotoArticleIconVisibility(0);
        View tooltipAnchor = ((AttachmentHasTooltipAnchor) view).getTooltipAnchor();
        if (tooltipAnchor != null) {
            tooltipAnchor.setOnClickListener(this.f24176d);
        }
        this.f24189q = true;
        if (this.f24179g) {
            m32532b(this, view);
        }
        Logger.a(8, EntryType.MARK_POP, -319814365, a);
    }

    public static ArticleIconPartDefinition m32529a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ArticleIconPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24172s) {
                ArticleIconPartDefinition articleIconPartDefinition;
                if (a2 != null) {
                    articleIconPartDefinition = (ArticleIconPartDefinition) a2.mo818a(f24172s);
                } else {
                    articleIconPartDefinition = f24171r;
                }
                if (articleIconPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32531b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24172s, b3);
                        } else {
                            f24171r = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = articleIconPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ArticleIconPartDefinition(Context context, InterstitialManager interstitialManager, MonotonicClock monotonicClock, ScreenUtil screenUtil) {
        this.f24174b = context;
        this.f24173a = interstitialManager;
        this.f24175c = monotonicClock;
        this.f24188p = screenUtil;
        this.f24180h = 0;
    }

    public static void m32532b(ArticleIconPartDefinition articleIconPartDefinition, View view) {
        View tooltipAnchor = ((AttachmentHasTooltipAnchor) view).getTooltipAnchor();
        if (tooltipAnchor != null) {
            view.getGlobalVisibleRect(articleIconPartDefinition.f24187o);
            articleIconPartDefinition.f24182j = articleIconPartDefinition.f24175c.now();
            articleIconPartDefinition.f24183k = articleIconPartDefinition.f24187o.top;
            articleIconPartDefinition.f24184l = articleIconPartDefinition.f24187o.bottom;
            view.postDelayed(new 1(articleIconPartDefinition, tooltipAnchor, view), 500);
        }
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((AttachmentHasArticleIcon) view).setCoverPhotoArticleIconVisibility(8);
        View tooltipAnchor = ((AttachmentHasTooltipAnchor) view).getTooltipAnchor();
        if (tooltipAnchor != null) {
            tooltipAnchor.setOnClickListener(null);
        }
        this.f24189q = false;
    }

    public static void m32533d(ArticleIconPartDefinition articleIconPartDefinition, View view) {
        if (articleIconPartDefinition.f24178f == null) {
            articleIconPartDefinition.f24178f = articleIconPartDefinition.m32530b();
        }
        if (articleIconPartDefinition.f24175c.now() - articleIconPartDefinition.f24180h > 800) {
            articleIconPartDefinition.f24178f.a(view);
        }
        articleIconPartDefinition.f24180h = 0;
    }

    private Tooltip m32530b() {
        Tooltip tooltip = new Tooltip(this.f24174b, 2);
        Resources resources = this.f24174b.getResources();
        tooltip.a(resources.getString(2131235557));
        tooltip.b(resources.getString(2131235558));
        tooltip.I = this.f24177e;
        tooltip.b(resources.getDrawable(2130840804));
        tooltip.l.m20499d((int) resources.getDimension(2131430186), (int) resources.getDimension(2131430186));
        tooltip.t = -1;
        tooltip.a(Position.ABOVE);
        return tooltip;
    }
}
