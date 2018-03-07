package com.facebook.quickpromotion.ui;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fbui.facepile.Face;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quickpromotion.asset.QuickPromotionImageFetcher;
import com.facebook.quickpromotion.asset.QuickPromotionImageFetcher$ImageType;
import com.facebook.quickpromotion.data.QuickPromotionUsersLoader;
import com.facebook.quickpromotion.logger.QuickPromotionLogger$LayoutInfo;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Action;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Attribute;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.user.model.User;
import com.facebook.widget.text.TextViewUtils;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: queue_start_timestamp */
public class QuickPromotionInterstitialFragment extends QuickPromotionFragment {
    private static final CallerContext f4824e = CallerContext.a(QuickPromotionInterstitialFragment.class, "quick_promotion_interstitial");
    @Inject
    public QuickPromotionImageFetcher f4825a;
    private ImageButton al;
    private FbDraweeView am;
    private TextView an;
    private TextView ao;
    private TextView ap;
    private Optional<TextView> aq;
    public FacepileView ar;
    private Optional<View> as;
    private LinearLayout at;
    private QuickPromotionDefinition au;
    public int av = 0;
    public int aw = 1;
    public Creative ax;
    private boolean ay = false;
    @Inject
    public QuickPromotionUsersLoader f4826b;
    @Inject
    public AnalyticsTagger f4827d;
    private ControllerListener f4828f;
    private final OnGlobalLayoutListener f4829g = new C06411(this);
    private Button f4830h;
    private Button f4831i;

    /* compiled from: queue_start_timestamp */
    class C06411 implements OnGlobalLayoutListener {
        final /* synthetic */ QuickPromotionInterstitialFragment f4817a;

        C06411(QuickPromotionInterstitialFragment quickPromotionInterstitialFragment) {
            this.f4817a = quickPromotionInterstitialFragment;
        }

        public void onGlobalLayout() {
            if (TemplateType.FIG_DIALOG.equals(this.f4817a.ax.template)) {
                QuickPromotionInterstitialFragment.aD(this.f4817a);
            }
        }
    }

    /* compiled from: queue_start_timestamp */
    class C06422 extends BaseControllerListener {
        final /* synthetic */ QuickPromotionInterstitialFragment f4818a;

        C06422(QuickPromotionInterstitialFragment quickPromotionInterstitialFragment) {
            this.f4818a = quickPromotionInterstitialFragment;
        }

        public final void m4691a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    /* compiled from: queue_start_timestamp */
    class C06433 implements OnClickListener {
        final /* synthetic */ QuickPromotionInterstitialFragment f4819a;

        C06433(QuickPromotionInterstitialFragment quickPromotionInterstitialFragment) {
            this.f4819a = quickPromotionInterstitialFragment;
        }

        public void onClick(View view) {
            Object obj;
            int a = Logger.a(2, EntryType.UI_INPUT_START, 313892550);
            QuickPromotionInterstitialFragment quickPromotionInterstitialFragment = this.f4819a;
            if (quickPromotionInterstitialFragment.av == quickPromotionInterstitialFragment.aw - 1) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                this.f4819a.as();
            } else if (!QuickPromotionInterstitialFragment.m4697a(this.f4819a, this.f4819a.ax.primaryAction)) {
                QuickPromotionFragment quickPromotionFragment = this.f4819a;
                quickPromotionFragment.f4798e.m4729c();
                quickPromotionFragment.m4667a(quickPromotionFragment.f4798e.m4730d());
            }
            LogUtils.a(172236436, a);
        }
    }

    /* compiled from: queue_start_timestamp */
    class C06444 implements OnClickListener {
        final /* synthetic */ QuickPromotionInterstitialFragment f4820a;

        C06444(QuickPromotionInterstitialFragment quickPromotionInterstitialFragment) {
            this.f4820a = quickPromotionInterstitialFragment;
        }

        public void onClick(View view) {
            Object obj;
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1161104587);
            if (this.f4820a.av == 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                this.f4820a.au();
            } else if (!QuickPromotionInterstitialFragment.m4697a(this.f4820a, this.f4820a.ax.secondaryAction)) {
                QuickPromotionFragment quickPromotionFragment = this.f4820a;
                quickPromotionFragment.f4798e.m4732f();
                quickPromotionFragment.m4667a(quickPromotionFragment.f4798e.m4733g());
            }
            LogUtils.a(-1495049717, a);
        }
    }

    /* compiled from: queue_start_timestamp */
    class C06455 implements OnClickListener {
        final /* synthetic */ QuickPromotionInterstitialFragment f4821a;

        C06455(QuickPromotionInterstitialFragment quickPromotionInterstitialFragment) {
            this.f4821a = quickPromotionInterstitialFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -363527717);
            this.f4821a.aw();
            Logger.a(2, EntryType.UI_INPUT_END, -1856204081, a);
        }
    }

    /* compiled from: queue_start_timestamp */
    class C06466 implements Callback<List<String>, ImmutableList<User>, Throwable> {
        final /* synthetic */ QuickPromotionInterstitialFragment f4822a;

        C06466(QuickPromotionInterstitialFragment quickPromotionInterstitialFragment) {
            this.f4822a = quickPromotionInterstitialFragment;
        }

        public final void m4693a(Object obj, Object obj2) {
            ImmutableList<User> immutableList = (ImmutableList) obj2;
            QuickPromotionInterstitialFragment quickPromotionInterstitialFragment = this.f4822a;
            List b = Lists.b(immutableList.size());
            for (User x : immutableList) {
                b.add(new Face(Uri.parse(x.x())));
            }
            quickPromotionInterstitialFragment.ar.setFaces(b);
            quickPromotionInterstitialFragment.ar.setVisibility(0);
            quickPromotionInterstitialFragment.ar.postInvalidate();
        }

        public final /* bridge */ /* synthetic */ void m4694b(Object obj, Object obj2) {
        }

        public final /* bridge */ /* synthetic */ void m4695c(Object obj, Object obj2) {
        }
    }

    /* compiled from: queue_start_timestamp */
    /* synthetic */ class C06477 {
        static final /* synthetic */ int[] f4823a = new int[TemplateType.values().length];

        static {
            try {
                f4823a[TemplateType.INTERSTITIAL_1_BUTTON_X.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4823a[TemplateType.INTERSTITIAL_2_BUTTON.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4823a[TemplateType.ANDROID_MESSAGES_INTERSTITIAL_2_BUTTON.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4823a[TemplateType.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4823a[TemplateType.MESSENGER_CARD.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4823a[TemplateType.CARD_WITH_HEADER.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f4823a[TemplateType.FIG_DIALOG.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f4823a[TemplateType.MESSENGER_CARD_NO_BADGE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public static void m4696a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        QuickPromotionInterstitialFragment quickPromotionInterstitialFragment = (QuickPromotionInterstitialFragment) obj;
        QuickPromotionImageFetcher a = QuickPromotionImageFetcher.a(fbInjector);
        QuickPromotionUsersLoader b = QuickPromotionUsersLoader.m4482b(fbInjector);
        AnalyticsTagger a2 = AnalyticsTagger.a(fbInjector);
        quickPromotionInterstitialFragment.f4825a = a;
        quickPromotionInterstitialFragment.f4826b = b;
        quickPromotionInterstitialFragment.f4827d = a2;
    }

    public final void mo226c(Bundle bundle) {
        super.mo226c(bundle);
        Bundle bundle2 = this.s;
        Class cls = QuickPromotionInterstitialFragment.class;
        m4696a((Object) this, getContext());
        this.au = this.f4794a;
        this.ax = (Creative) bundle2.getParcelable("qp_creative");
        if (this.ax == null) {
            this.ax = this.au.c();
            return;
        }
        this.av = bundle2.getInt("page_position");
        this.aw = bundle2.getInt("num_pages");
        this.ay = bundle2.getBoolean("is_multi");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View m4699a(android.view.LayoutInflater r11, android.view.ViewGroup r12, android.os.Bundle r13) {
        /*
        r10 = this;
        r4 = 8;
        r0 = 2;
        r1 = com.facebook.loom.logger.LogEntry.EntryType.LIFECYCLE_FRAGMENT_START;
        r2 = 1771202351; // 0x6992672f float:2.2123805E25 double:8.750902335E-315;
        r1 = com.facebook.loom.logger.Logger.a(r0, r1, r2);
        r0 = r10.ax;
        r2 = r0.template;
        r0 = com.facebook.quickpromotion.ui.QuickPromotionInterstitialFragment.C06477.f4823a;
        r3 = r2.ordinal();
        r0 = r0[r3];
        switch(r0) {
            case 4: goto L_0x0115;
            case 5: goto L_0x0115;
            case 6: goto L_0x011a;
            case 7: goto L_0x011f;
            case 8: goto L_0x0124;
            default: goto L_0x001b;
        };
    L_0x001b:
        r0 = 2130906547; // 0x7f030db3 float:1.742E38 double:1.0528077194E-314;
    L_0x001e:
        r3 = 0;
        r3 = r11.inflate(r0, r12, r3);
        r0 = 2131566498; // 0x7f0d1fa2 float:1.875854E38 double:1.0531337785E-314;
        r0 = com.facebook.common.util.FindViewUtil.b(r3, r0);
        r0 = (android.widget.Button) r0;
        r10.f4830h = r0;
        r0 = 2131566497; // 0x7f0d1fa1 float:1.8758537E38 double:1.053133778E-314;
        r0 = com.facebook.common.util.FindViewUtil.b(r3, r0);
        r0 = (android.widget.Button) r0;
        r10.f4831i = r0;
        r0 = 2131566499; // 0x7f0d1fa3 float:1.8758541E38 double:1.053133779E-314;
        r0 = com.facebook.common.util.FindViewUtil.b(r3, r0);
        r0 = (android.widget.ImageButton) r0;
        r10.al = r0;
        r0 = 2131558927; // 0x7f0d020f float:1.8743184E38 double:1.053130038E-314;
        r0 = com.facebook.common.util.FindViewUtil.b(r3, r0);
        r0 = (android.widget.TextView) r0;
        r10.an = r0;
        r0 = 2131561061; // 0x7f0d0a65 float:1.8747512E38 double:1.0531310923E-314;
        r0 = com.facebook.common.util.FindViewUtil.b(r3, r0);
        r0 = (android.widget.TextView) r0;
        r10.ao = r0;
        r0 = 2131559663; // 0x7f0d04ef float:1.8744676E38 double:1.0531304015E-314;
        r0 = com.facebook.common.util.FindViewUtil.b(r3, r0);
        r0 = (android.widget.TextView) r0;
        r10.ap = r0;
        r0 = r10.ap;
        r0.setVisibility(r4);
        r0 = 2131566495; // 0x7f0d1f9f float:1.8758533E38 double:1.053133777E-314;
        r0 = com.facebook.common.util.FindViewUtil.b(r3, r0);
        r0 = (com.facebook.fbui.facepile.FacepileView) r0;
        r10.ar = r0;
        r0 = r10.ar;
        r0.setVisibility(r4);
        r0 = 2131563938; // 0x7f0d15a2 float:1.8753347E38 double:1.0531325137E-314;
        r0 = com.facebook.common.util.FindViewUtil.b(r3, r0);
        r0 = (android.widget.LinearLayout) r0;
        r10.at = r0;
        r0 = r10.at;
        r0 = r0.getViewTreeObserver();
        r4 = r10.f4829g;
        r0.addOnGlobalLayoutListener(r4);
        r0 = com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType.MESSENGER_CARD;
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0129;
    L_0x0098:
        r0 = 2131566502; // 0x7f0d1fa6 float:1.8758548E38 double:1.0531337805E-314;
        r0 = com.facebook.common.util.FindViewUtil.b(r3, r0);
        r0 = (com.facebook.drawee.fbpipeline.FbDraweeView) r0;
        r10.am = r0;
        r0 = r10.ar;
        r4 = 1;
        r0.setShowRoundFaces(r4);
    L_0x00a9:
        r0 = new com.facebook.quickpromotion.ui.QuickPromotionInterstitialFragment$2;
        r0.<init>(r10);
        r10.f4828f = r0;
        r0 = com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType.CARD_WITH_HEADER;
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x00f5;
    L_0x00b8:
        r6 = 0;
        r5 = 2131566493; // 0x7f0d1f9d float:1.875853E38 double:1.053133776E-314;
        r8 = com.facebook.common.util.FindViewUtil.b(r3, r5);
        if (r3 == 0) goto L_0x00f5;
    L_0x00c2:
        r5 = r10.ax;
        if (r5 == 0) goto L_0x00f5;
    L_0x00c6:
        r5 = r10.ax;
        r5 = r5.templateParameters;
        if (r5 == 0) goto L_0x00f5;
    L_0x00cc:
        r5 = r10.ax;
        r5 = r5.templateParameters;
        r7 = "color_scheme";
        r5 = r5.containsKey(r7);
        if (r5 == 0) goto L_0x00f5;
    L_0x00d8:
        r5 = r10.ax;
        r5 = r5.templateParameters;
        r7 = "color_scheme";
        r5 = r5.get(r7);
        r5 = (java.lang.String) r5;
        r7 = -1;
        r9 = r5.hashCode();
        switch(r9) {
            case -734239628: goto L_0x0137;
            case 94746189: goto L_0x0141;
            default: goto L_0x00ec;
        };
    L_0x00ec:
        r5 = r7;
    L_0x00ed:
        switch(r5) {
            case 0: goto L_0x014b;
            default: goto L_0x00f0;
        };
    L_0x00f0:
        r5 = 8;
        r8.setVisibility(r5);
    L_0x00f5:
        r0 = 2131566506; // 0x7f0d1faa float:1.8758556E38 double:1.0531337824E-314;
        r0 = com.facebook.common.util.FindViewUtil.a(r3, r0);
        r10.as = r0;
        r0 = 2131566496; // 0x7f0d1fa0 float:1.8758535E38 double:1.0531337775E-314;
        r0 = com.facebook.common.util.FindViewUtil.a(r3, r0);
        r10.aq = r0;
        r0 = r10.f4827d;
        r2 = "quick_promotion_interstitial";
        r0.a(r3, r2, r10);
        r0 = -279881723; // 0xffffffffef515805 float:-6.4788776E28 double:NaN;
        com.facebook.tools.dextr.runtime.LogUtils.f(r0, r1);
        return r3;
    L_0x0115:
        r0 = 2130906543; // 0x7f030daf float:1.7419992E38 double:1.0528077174E-314;
        goto L_0x001e;
    L_0x011a:
        r0 = 2130906541; // 0x7f030dad float:1.7419988E38 double:1.0528077164E-314;
        goto L_0x001e;
    L_0x011f:
        r0 = 2130906545; // 0x7f030db1 float:1.7419996E38 double:1.0528077184E-314;
        goto L_0x001e;
    L_0x0124:
        r0 = 2130906551; // 0x7f030db7 float:1.7420008E38 double:1.0528077213E-314;
        goto L_0x001e;
    L_0x0129:
        r0 = 2131566494; // 0x7f0d1f9e float:1.8758531E38 double:1.0531337765E-314;
        r0 = com.facebook.common.util.FindViewUtil.b(r3, r0);
        r0 = (com.facebook.drawee.fbpipeline.FbDraweeView) r0;
        r10.am = r0;
        goto L_0x00a9;
    L_0x0137:
        r9 = "yellow";
        r5 = r5.equals(r9);
        if (r5 == 0) goto L_0x00ec;
    L_0x013f:
        r5 = r6;
        goto L_0x00ed;
    L_0x0141:
        r9 = "clear";
        r5 = r5.equals(r9);
        if (r5 == 0) goto L_0x00ec;
    L_0x0149:
        r5 = 1;
        goto L_0x00ed;
    L_0x014b:
        r5 = r8.getBackground();
        r5 = (android.graphics.drawable.GradientDrawable) r5;
        r5 = r5.mutate();
        r5 = (android.graphics.drawable.GradientDrawable) r5;
        r7 = r10.jW_();
        r9 = 2131363032; // 0x7f0a04d8 float:1.8345861E38 double:1.053033253E-314;
        r7 = r7.getColor(r9);
        r5.setColor(r7);
        r8.setVisibility(r6);
        goto L_0x00f5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.ui.QuickPromotionInterstitialFragment.a(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public final void mo227d(Bundle bundle) {
        Object obj;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1084165735);
        super.mo227d(bundle);
        this.an.setText(this.ax.title);
        if (TextUtils.isEmpty(this.ax.content)) {
            this.ao.setVisibility(8);
        } else {
            this.ao.setText(this.ax.content);
        }
        if (this.f4825a.a(this.am, this.ax, f4824e, this.f4828f)) {
            QuickPromotionImageFetcher.a(this.ax, this.am);
            if (TemplateType.MESSENGER_CARD.equals(this.ax.template)) {
                ((GenericDraweeHierarchy) this.am.getHierarchy()).a(ScaleType.g);
            } else {
                ((GenericDraweeHierarchy) this.am.getHierarchy()).a(ScaleType.f);
            }
            int a2 = this.f4825a.a(QuickPromotionImageFetcher.b(this.ax, QuickPromotionImageFetcher$ImageType.ANY), this.ax);
            LayoutParams layoutParams = this.am.getLayoutParams();
            layoutParams.width = a2;
            layoutParams.height = a2;
            this.am.setLayoutParams(layoutParams);
            this.ao.setMaxLines(jW_().getInteger(2131492902));
            this.am.setVisibility(0);
        } else {
            if (this.ax.socialContext == null) {
                this.an.setMaxLines(jW_().getInteger(2131492901));
            } else {
                this.an.setMaxLines(jW_().getInteger(2131492900));
            }
            this.ao.setMovementMethod(ScrollingMovementMethod.getInstance());
            this.am.setVisibility(8);
        }
        this.f4830h.setText(this.ax.primaryAction.title);
        this.f4830h.setOnClickListener(new C06433(this));
        Action action = this.ax.secondaryAction;
        int i = (action == null || Strings.isNullOrEmpty(action.title)) ? 0 : 1;
        if (i != 0) {
            this.f4831i.setText(this.ax.secondaryAction.title);
            this.f4831i.setOnClickListener(new C06444(this));
            this.f4831i.setVisibility(0);
        } else {
            this.f4831i.setVisibility(8);
            if (this.as.isPresent()) {
                ((View) this.as.get()).setVisibility(8);
            }
        }
        if (this.f4794a.f().contains(Attribute.IS_UNCANCELABLE)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null || (this.ax.dismissAction == null && i != 0)) {
            this.al.setVisibility(8);
        } else {
            this.al.setOnClickListener(new C06455(this));
            this.al.setVisibility(0);
        }
        if (this.ax.socialContext != null) {
            if (TextUtils.isEmpty(this.ax.socialContext.text)) {
                this.ap.setVisibility(8);
            } else {
                this.ap.setText(this.ax.socialContext.text);
                this.ap.setVisibility(0);
            }
            List list = this.ax.socialContext.friendIds;
            if (!(list == null || list.isEmpty())) {
                this.ar.setFaces(null);
                this.ar.setVisibility(4);
                this.f4826b.m4483a(new C06466(this));
                this.f4826b.m4485a(list);
            }
        }
        if (this.aq.isPresent()) {
            if (TextUtils.isEmpty(this.ax.footer)) {
                ((TextView) this.aq.get()).setVisibility(8);
            } else {
                ((TextView) this.aq.get()).setText(this.ax.footer);
                Drawable drawable = jW_().getDrawable(2130839828);
                drawable.setBounds(0, 0, jW_().getDimensionPixelSize(2131430050), drawable.getIntrinsicHeight());
                ((TextView) this.aq.get()).setCompoundDrawables(null, drawable, null, null);
                ((TextView) this.aq.get()).setVisibility(0);
            }
        }
        LogUtils.f(1277040916, a);
    }

    public final void mo230g(boolean z) {
        super.mo230g(z);
        if (this.ay && z && this.ar != null && this.ar.getVisibility() == 0) {
            this.ar.setWillNotDraw(false);
            this.ar.postInvalidate();
        }
    }

    public final void m4698I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1632116900);
        super.I();
        this.f4828f = null;
        QuickPromotionUsersLoader quickPromotionUsersLoader = this.f4826b;
        if (quickPromotionUsersLoader.f4618a != null) {
            quickPromotionUsersLoader.f4618a.a(true);
            quickPromotionUsersLoader.f4618a = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1805542415, a);
    }

    public final boolean mo229e() {
        return !this.ay;
    }

    @Nullable
    public static boolean m4697a(@Nullable QuickPromotionInterstitialFragment quickPromotionInterstitialFragment, Action action) {
        if (action == null) {
            return false;
        }
        String str = action.url;
        if (str == null) {
            return false;
        }
        Uri parse = Uri.parse(str);
        List pathSegments = parse.getPathSegments();
        if (pathSegments.size() == 2) {
            Object obj = null;
            String scheme = parse.getScheme();
            String host = parse.getHost();
            if (scheme != null && host != null && scheme.equals(FBLinks.a) && host.equals("qp")) {
                obj = 1;
            }
            if (obj != null) {
                if (!((String) pathSegments.get(0)).equals("action")) {
                    return false;
                }
                ViewPager aC;
                if (((String) pathSegments.get(1)).equals("next")) {
                    aC = quickPromotionInterstitialFragment.aC();
                    if (aC != null) {
                        aC.a(quickPromotionInterstitialFragment.av + 1, true);
                    }
                    return true;
                } else if (!((String) pathSegments.get(1)).equals("back")) {
                    return false;
                } else {
                    aC = quickPromotionInterstitialFragment.aC();
                    if (aC != null) {
                        aC.a(quickPromotionInterstitialFragment.av - 1, true);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    protected final QuickPromotionLogger$LayoutInfo mo225b() {
        QuickPromotionLogger$LayoutInfo quickPromotionLogger$LayoutInfo = new QuickPromotionLogger$LayoutInfo();
        quickPromotionLogger$LayoutInfo.f4746a = TextViewUtils.b(this.an);
        quickPromotionLogger$LayoutInfo = quickPromotionLogger$LayoutInfo;
        quickPromotionLogger$LayoutInfo.f4747b = TextViewUtils.b(this.ao);
        quickPromotionLogger$LayoutInfo = quickPromotionLogger$LayoutInfo;
        quickPromotionLogger$LayoutInfo.f4748c = TextViewUtils.b(this.f4830h);
        quickPromotionLogger$LayoutInfo = quickPromotionLogger$LayoutInfo;
        quickPromotionLogger$LayoutInfo.f4749d = TextViewUtils.b(this.f4831i);
        quickPromotionLogger$LayoutInfo = quickPromotionLogger$LayoutInfo;
        quickPromotionLogger$LayoutInfo.f4750e = TextViewUtils.b(this.ap);
        return quickPromotionLogger$LayoutInfo;
    }

    public static void aD(QuickPromotionInterstitialFragment quickPromotionInterstitialFragment) {
        Action action = quickPromotionInterstitialFragment.ax.secondaryAction;
        Object obj = (action == null || Strings.isNullOrEmpty(action.title)) ? null : 1;
        if (obj == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) quickPromotionInterstitialFragment.at.getLayoutParams();
            layoutParams.width = -1;
            quickPromotionInterstitialFragment.at.setLayoutParams(layoutParams);
        } else if (quickPromotionInterstitialFragment.ax.templateParameters != null && quickPromotionInterstitialFragment.ax.templateParameters.containsKey("fig_button_layout")) {
            String str = (String) quickPromotionInterstitialFragment.ax.templateParameters.get("fig_button_layout");
            if ("AUTOMATIC".equals(str) && quickPromotionInterstitialFragment.aE()) {
                quickPromotionInterstitialFragment.aF();
            }
            if ("VERTICAL_STACK".equals(str)) {
                quickPromotionInterstitialFragment.aF();
            }
        } else if (quickPromotionInterstitialFragment.aE()) {
            quickPromotionInterstitialFragment.aF();
        }
    }

    private boolean aE() {
        return this.f4830h.getLayout().getLineCount() > 1 || this.f4831i.getLayout().getLineCount() > 1;
    }

    private void aF() {
        this.at.setOrientation(1);
        this.at.removeView(this.f4830h);
        this.at.addView(this.f4830h, 0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f4830h.getLayoutParams();
        layoutParams.gravity = 5;
        this.f4830h.setLayoutParams(layoutParams);
        layoutParams = (LinearLayout.LayoutParams) this.f4831i.getLayoutParams();
        layoutParams.gravity = 5;
        layoutParams.rightMargin = 0;
        this.f4831i.setLayoutParams(layoutParams);
    }

    private ViewPager aC() {
        Fragment fragment = this.G;
        if (fragment instanceof QuickPromotionMultiPageInterstitialMainFragment) {
            return ((QuickPromotionMultiPageInterstitialMainFragment) fragment).f4835d;
        }
        return null;
    }
}
