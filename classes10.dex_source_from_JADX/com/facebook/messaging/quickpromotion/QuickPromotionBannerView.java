package com.facebook.messaging.quickpromotion;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTriggerContext;
import com.facebook.interstitial.manager.InterstitialTriggerContextHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quickpromotion.asset.QuickPromotionImageFetcher;
import com.facebook.quickpromotion.logger.QuickPromotionLogger.LayoutInfo;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import com.facebook.quickpromotion.ui.QuickPromotionViewHelper;
import com.facebook.quickpromotion.ui.QuickPromotionViewHelperProvider;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.PicSquareUrlWithSize;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.TextViewUtils;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: registration_account_creation_attempt */
public class QuickPromotionBannerView extends CustomLinearLayout {
    private static final CallerContext f3757c = CallerContext.a(QuickPromotionBannerView.class, "quick_promotion_interstitial");
    @Inject
    QuickPromotionViewHelperProvider f3758a;
    @Inject
    QuickPromotionImageFetcher f3759b;
    private ControllerListener f3760d;
    private InterstitialTriggerContext f3761e;
    public QuickPromotionViewHelper f3762f;
    @Nullable
    private QuickPromotionDefinition f3763g;
    private Type f3764h;
    @Nullable
    public ComposerPointerLocation f3765i;
    public boolean f3766j;
    private boolean f3767k;
    @Nullable
    public Listener f3768l;
    private FbDraweeView f3769m;
    private UserTileView f3770n;
    private View f3771o;
    private TextView f3772p;
    private TextView f3773q;
    public TextView f3774r;
    public TextView f3775s;
    public View f3776t;
    private View f3777u;
    private View f3778v;
    private View f3779w;

    /* compiled from: registration_account_creation_attempt */
    public enum ComposerPointerLocation {
        TEXT,
        QUICK_CAM,
        MEDIA_TRAY,
        STICKERS,
        PAYMENTS,
        VOICE_CLIPS,
        RIDE_SERVICE_PROMOTION,
        MORE,
        EPHEMERAL
    }

    /* compiled from: registration_account_creation_attempt */
    public interface Listener {
        void mo333a(int[] iArr);
    }

    /* compiled from: registration_account_creation_attempt */
    public enum Type {
        THREADLIST,
        THREADVIEW,
        COMPOSER
    }

    private static <T extends View> void m3560a(Class<T> cls, T t) {
        m3561a((Object) t, t.getContext());
    }

    private static void m3561a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((QuickPromotionBannerView) obj).m3559a((QuickPromotionViewHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(QuickPromotionViewHelperProvider.class), QuickPromotionImageFetcher.a(fbInjector));
    }

    private void m3559a(QuickPromotionViewHelperProvider quickPromotionViewHelperProvider, QuickPromotionImageFetcher quickPromotionImageFetcher) {
        this.f3758a = quickPromotionViewHelperProvider;
        this.f3759b = quickPromotionImageFetcher;
    }

    public QuickPromotionBannerView(Context context) {
        super(context);
        m3563b();
    }

    public QuickPromotionBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3563b();
    }

    public QuickPromotionBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3563b();
    }

    private void m3563b() {
        m3560a(QuickPromotionBannerView.class, (View) this);
        setContentView(2130904587);
        setOrientation(1);
        this.f3776t = a(2131562526);
        this.f3772p = (TextView) a(2131559946);
        this.f3773q = (TextView) a(2131562528);
        this.f3769m = (FbDraweeView) a(2131562522);
        this.f3774r = (TextView) a(2131562530);
        this.f3775s = (TextView) a(2131559664);
        this.f3770n = (UserTileView) a(2131562523);
        this.f3771o = a(2131562521);
        this.f3777u = a(2131562527);
        this.f3778v = a(2131562520);
        this.f3779w = a(2131562529);
        this.f3760d = this.f3759b.a();
    }

    public final void m3575a() {
        this.f3762f.a();
        QuickPromotionViewHelper quickPromotionViewHelper = this.f3762f;
        LayoutInfo layoutInfo = new LayoutInfo();
        layoutInfo.a = TextViewUtils.b(this.f3772p);
        layoutInfo = layoutInfo;
        layoutInfo.b = TextViewUtils.b(this.f3773q);
        layoutInfo = layoutInfo;
        layoutInfo.c = TextViewUtils.b(this.f3774r);
        layoutInfo = layoutInfo;
        layoutInfo.d = TextViewUtils.b(this.f3775s);
        quickPromotionViewHelper.a(layoutInfo);
    }

    private void setTitle(String str) {
        this.f3772p.setText(str);
    }

    private void setDescription(String str) {
        if (StringUtil.a(str)) {
            this.f3773q.setText(this.f3772p.getText());
            this.f3772p.setVisibility(8);
            return;
        }
        this.f3773q.setText(str);
        this.f3772p.setVisibility(0);
        this.f3773q.setVisibility(0);
    }

    private void setPrimaryActionText(String str) {
        this.f3774r.setText(str);
        this.f3774r.setVisibility(StringUtil.a(str) ? 8 : 0);
    }

    private void setSecondaryActionText(String str) {
        this.f3775s.setText(str);
        this.f3775s.setVisibility(StringUtil.a(str) ? 8 : 0);
    }

    public final void m3576a(Type type, QuickPromotionDefinition quickPromotionDefinition, OnClickListener onClickListener, String str, InterstitialTriggerContext interstitialTriggerContext) {
        setupOnClickListeners(onClickListener);
        if (!quickPromotionDefinition.equals(this.f3763g) || (interstitialTriggerContext != null && !interstitialTriggerContext.equals(this.f3761e))) {
            TypedArray obtainStyledAttributes;
            this.f3764h = type;
            this.f3761e = interstitialTriggerContext;
            this.f3763g = quickPromotionDefinition;
            Creative c = this.f3763g.c();
            m3574k();
            this.f3762f = this.f3758a.a(this.f3763g, str, c, interstitialTriggerContext);
            setTitle(InterstitialTriggerContextHelper.a(c.title, this.f3761e));
            setDescription(InterstitialTriggerContextHelper.a(c.content, this.f3761e));
            if (QuickPromotionDefinition.a(this.f3763g)) {
                if (c.primaryAction != null) {
                    setUpTappableBanner(onClickListener);
                } else {
                    setClickable(true);
                }
                this.f3774r.setVisibility(8);
            } else {
                if (c.primaryAction != null) {
                    setPrimaryActionText(InterstitialTriggerContextHelper.a(c.primaryAction.title, this.f3761e));
                } else {
                    this.f3774r.setVisibility(8);
                }
                if (c.secondaryAction != null) {
                    setSecondaryActionText(InterstitialTriggerContextHelper.a(c.secondaryAction.title, this.f3761e));
                    if (!this.f3767k) {
                        obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{2130772873});
                        setBackgroundDrawable(new ColorDrawable(obtainStyledAttributes.getColor(0, getResources().getColor(2131362528))));
                        obtainStyledAttributes.recycle();
                    }
                    if ("true".equals(m3558a("circle_crop_image", this.f3763g))) {
                        this.f3770n.setVisibility(8);
                        if (this.f3759b.a(this.f3769m, c, f3757c, this.f3760d)) {
                            QuickPromotionImageFetcher.a(c, this.f3769m);
                            this.f3769m.setVisibility(0);
                            if (c.dismissAction == null) {
                                this.f3776t.setVisibility(0);
                            } else {
                                this.f3776t.setVisibility(8);
                            }
                            m3565c();
                            m3567d();
                        }
                    }
                    this.f3770n.setParams(UserTileViewParams.a(new PicSquare(ImmutableList.of(new PicSquareUrlWithSize(getResources().getDimensionPixelSize(2131427940), c.imageParams.uri))), TileBadge.NONE));
                    this.f3770n.setVisibility(0);
                    this.f3769m.setVisibility(8);
                    if (c.dismissAction == null) {
                        this.f3776t.setVisibility(8);
                    } else {
                        this.f3776t.setVisibility(0);
                    }
                    m3565c();
                    m3567d();
                }
            }
            this.f3775s.setVisibility(8);
            if (this.f3767k) {
                obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{2130772873});
                setBackgroundDrawable(new ColorDrawable(obtainStyledAttributes.getColor(0, getResources().getColor(2131362528))));
                obtainStyledAttributes.recycle();
            }
            if ("true".equals(m3558a("circle_crop_image", this.f3763g))) {
                this.f3770n.setVisibility(8);
                if (this.f3759b.a(this.f3769m, c, f3757c, this.f3760d)) {
                    QuickPromotionImageFetcher.a(c, this.f3769m);
                    this.f3769m.setVisibility(0);
                    if (c.dismissAction == null) {
                        this.f3776t.setVisibility(0);
                    } else {
                        this.f3776t.setVisibility(8);
                    }
                    m3565c();
                    m3567d();
                }
            }
            this.f3770n.setParams(UserTileViewParams.a(new PicSquare(ImmutableList.of(new PicSquareUrlWithSize(getResources().getDimensionPixelSize(2131427940), c.imageParams.uri))), TileBadge.NONE));
            this.f3770n.setVisibility(0);
            this.f3769m.setVisibility(8);
            if (c.dismissAction == null) {
                this.f3776t.setVisibility(8);
            } else {
                this.f3776t.setVisibility(0);
            }
            m3565c();
            m3567d();
        }
    }

    @Nullable
    public ComposerPointerLocation getComposerPointerLocation() {
        return this.f3765i;
    }

    public boolean getComposerPointerOverflowsToMoreTab() {
        return this.f3766j;
    }

    public int getColorSchemeThemeId() {
        return m3556a(this.f3763g);
    }

    public static int m3556a(QuickPromotionDefinition quickPromotionDefinition) {
        if ("light".equals(m3558a("color_scheme", quickPromotionDefinition))) {
            return 2131624676;
        }
        return 2131624675;
    }

    public void setListener(Listener listener) {
        this.f3768l = listener;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3768l != null && this.f3767k) {
            this.f3768l.mo333a(getDrawableState());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m3568e();
    }

    private void setupOnClickListeners(final OnClickListener onClickListener) {
        this.f3774r.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ QuickPromotionBannerView f3749b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1004550342);
                this.f3749b.f3762f.b();
                if (this.f3749b.f3762f.d()) {
                    onClickListener.onClick(this.f3749b.f3774r);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1401781052, a);
            }
        });
        this.f3775s.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ QuickPromotionBannerView f3751b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -498127788);
                this.f3751b.f3762f.e();
                if (this.f3751b.f3762f.g()) {
                    onClickListener.onClick(this.f3751b.f3775s);
                }
                Logger.a(2, EntryType.UI_INPUT_END, -1397204340, a);
            }
        });
        this.f3776t.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ QuickPromotionBannerView f3753b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1387070248);
                this.f3753b.f3762f.h();
                if (this.f3753b.f3762f.i()) {
                    onClickListener.onClick(this.f3753b.f3776t);
                }
                Logger.a(2, EntryType.UI_INPUT_END, -255574558, a);
            }
        });
    }

    private void setUpTappableBanner(final OnClickListener onClickListener) {
        this.f3767k = true;
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ QuickPromotionBannerView f3755b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 55231210);
                this.f3755b.f3762f.b();
                if (this.f3755b.f3762f.d()) {
                    onClickListener.onClick(this.f3755b.f3774r);
                }
                Logger.a(2, EntryType.UI_INPUT_END, -2130772864, a);
            }
        });
        if (this.f3764h == Type.THREADLIST) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{2130772874});
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
            obtainStyledAttributes.recycle();
            return;
        }
        setBackgroundDrawable(getResources().getDrawable(2130842161));
    }

    private void m3565c() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131427939);
        if (this.f3776t.getVisibility() == 0) {
            this.f3778v.setPadding(this.f3778v.getPaddingLeft(), this.f3778v.getPaddingTop(), 0, this.f3778v.getPaddingBottom());
        } else {
            this.f3778v.setPadding(this.f3778v.getPaddingLeft(), this.f3778v.getPaddingTop(), dimensionPixelSize, this.f3778v.getPaddingBottom());
        }
    }

    private void m3567d() {
        switch (this.f3764h) {
            case COMPOSER:
                m3570g();
                m3571h();
                m3572i();
                m3573j();
                return;
            default:
                return;
        }
    }

    private void m3568e() {
        LayoutParams layoutParams = (LayoutParams) this.f3777u.getLayoutParams();
        if (this.f3777u.getHeight() < this.f3771o.getHeight()) {
            if (layoutParams.getRules()[15] != -1) {
                layoutParams.addRule(15);
                this.f3777u.setLayoutParams(layoutParams);
                this.f3777u.setPadding(0, 0, 0, 0);
            }
        } else if (layoutParams.getRules()[15] != 0) {
            layoutParams.addRule(15, 0);
            this.f3777u.setLayoutParams(layoutParams);
            this.f3777u.setPadding(0, getResources().getDimensionPixelSize(2131427939), 0, 0);
        }
        layoutParams = (LayoutParams) this.f3776t.getLayoutParams();
        if (m3569f()) {
            if (layoutParams.getRules()[15] != -1) {
                layoutParams.addRule(15);
                layoutParams.addRule(10, 0);
                this.f3776t.setLayoutParams(layoutParams);
                this.f3777u.setPadding(this.f3777u.getPaddingLeft(), this.f3777u.getPaddingTop(), this.f3777u.getPaddingRight(), this.f3778v.getPaddingBottom());
                this.f3778v.setPadding(this.f3778v.getPaddingLeft(), this.f3778v.getPaddingTop(), this.f3778v.getPaddingRight(), 0);
            }
        } else if (layoutParams.getRules()[15] != 0) {
            layoutParams.addRule(15, 0);
            layoutParams.addRule(10);
            this.f3776t.setLayoutParams(layoutParams);
            this.f3777u.setPadding(this.f3777u.getPaddingLeft(), this.f3777u.getPaddingTop(), this.f3777u.getPaddingRight(), 0);
            this.f3778v.setPadding(this.f3778v.getPaddingLeft(), this.f3778v.getPaddingTop(), this.f3778v.getPaddingRight(), getResources().getDimensionPixelSize(2131427939));
        }
    }

    private boolean m3569f() {
        return this.f3776t.getVisibility() == 0 && this.f3772p.getVisibility() == 8 && this.f3773q.getLineCount() == 1 && this.f3769m.getVisibility() == 8 && this.f3770n.getVisibility() == 8;
    }

    private void m3570g() {
        this.f3778v.setPadding(this.f3778v.getPaddingLeft(), getResources().getDimensionPixelSize(2131433892) + this.f3778v.getPaddingTop(), this.f3778v.getPaddingRight(), this.f3778v.getPaddingBottom());
        this.f3778v.setBackgroundDrawable(getResources().getDrawable(2130840548));
    }

    private void m3571h() {
        this.f3779w.setPadding(0, 0, 0, 0);
        this.f3779w.setBackgroundDrawable(null);
    }

    private void m3572i() {
        String a = m3558a("composer_trigger_banner_pointer_location", this.f3763g);
        if ("text".equals(a)) {
            this.f3765i = ComposerPointerLocation.TEXT;
        } else if ("quick_cam".equals(a)) {
            this.f3765i = ComposerPointerLocation.QUICK_CAM;
        } else if ("media_tray".equals(a)) {
            this.f3765i = ComposerPointerLocation.MEDIA_TRAY;
        } else if ("stickers".equals(a)) {
            this.f3765i = ComposerPointerLocation.STICKERS;
        } else if ("payments".equals(a)) {
            this.f3765i = ComposerPointerLocation.PAYMENTS;
        } else if ("voice_clips".equals(a)) {
            this.f3765i = ComposerPointerLocation.VOICE_CLIPS;
        } else if ("ride_service_promotion".equals(a)) {
            this.f3765i = ComposerPointerLocation.RIDE_SERVICE_PROMOTION;
        } else if ("more".equals(a)) {
            this.f3765i = ComposerPointerLocation.MORE;
        } else {
            this.f3765i = null;
        }
    }

    private void m3573j() {
        this.f3766j = "true".equals(m3558a("composer_banner_pointer_overflows_to_more_tab", this.f3763g));
    }

    private void m3574k() {
        this.f3767k = false;
        this.f3765i = null;
        this.f3766j = false;
        this.f3768l = null;
    }

    @Nullable
    private static String m3558a(String str, QuickPromotionDefinition quickPromotionDefinition) {
        Creative c = quickPromotionDefinition.c();
        if (c == null || c.templateParameters == null || !c.templateParameters.containsKey(str)) {
            return null;
        }
        return (String) c.templateParameters.get(str);
    }

    public final boolean m3577a(InterstitialTrigger interstitialTrigger) {
        if (this.f3763g == null) {
            return false;
        }
        List a = this.f3763g.a();
        if (a == null || !a.contains(interstitialTrigger)) {
            return false;
        }
        return true;
    }
}
