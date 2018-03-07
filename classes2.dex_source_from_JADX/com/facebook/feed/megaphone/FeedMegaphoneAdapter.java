package com.facebook.feed.megaphone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.config.versioninfo.VersionStringComparator;
import com.facebook.contacts.pna.qps.PhoneNumberAcquisitionQPView;
import com.facebook.contacts.pna.qps.PnaCustomRenderEntry;
import com.facebook.graphql.enums.GraphQLMegaphoneLocation;
import com.facebook.graphql.model.GraphQLMegaphone;
import com.facebook.inject.Lazy;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.megaphone.data.MegaphoneStore;
import com.facebook.megaphone.model.MegaphoneWithLayout;
import com.facebook.megaphone.ui.DefaultMegaphoneStoryView;
import com.facebook.megaphone.ui.DynamicLayoutMegaphoneView;
import com.facebook.megaphone.ui.IdentityGrowthMegaphoneStoryView;
import com.facebook.megaphone.ui.MegaphoneLegacyStoryView;
import com.facebook.megaphone.ui.MegaphoneStoryView;
import com.facebook.megaphone.ui.QuickPromotionBrandedMegaphoneStoryView;
import com.facebook.megaphone.ui.QuickPromotionMegaphoneStoryView;
import com.facebook.megaphone.ui.QuickPromotionSurveyMegaphoneStoryView;
import com.facebook.multirow.api.ViewType;
import com.facebook.quickpromotion.customrender.CustomRenderBaseView;
import com.facebook.quickpromotion.customrender.CustomRenderManager;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType;
import com.facebook.quickpromotion.ui.QuickPromotionMegaphoneController;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: pending_sessions */
public class FeedMegaphoneAdapter extends FbBaseAdapter {
    public final ViewType f10273a = new C04321(this);
    public final ViewType f10274b = new C04332(this);
    public final ViewType f10275c = new C04343(this);
    public final ViewType f10276d = new C04354(this);
    public final ViewType f10277e = new C04365(this);
    public final ViewType f10278f = new C04376(this);
    public final ViewType f10279g = new C04387(this);
    public final ViewType f10280h = new C04398(this);
    public final ViewType f10281i = new C04409(this);
    public final Context f10282j;
    public final Lazy<CustomRenderManager> f10283k;
    public final MegaphoneStore f10284l;
    public final InterstitialManager f10285m;
    private final VersionStringComparator f10286n;
    private final ViewType[] f10287o;
    public MegaphoneWithLayout f10288p;
    public QuickPromotionDefinition f10289q;
    public QuickPromotionDefinition f10290r;
    private final Runnable f10291s = new Runnable(this) {
        final /* synthetic */ FeedMegaphoneAdapter f10372a;

        {
            this.f10372a = r1;
        }

        public void run() {
            FeedMegaphoneAdapter.m15357g(this.f10372a);
            this.f10372a.f10284l.m15374d(GraphQLMegaphoneLocation.NEWSFEED);
        }
    };

    /* compiled from: pending_sessions */
    class C04321 extends ViewType {
        final /* synthetic */ FeedMegaphoneAdapter f10363a;

        C04321(FeedMegaphoneAdapter feedMegaphoneAdapter) {
            this.f10363a = feedMegaphoneAdapter;
        }

        public final View mo1995a(Context context) {
            return LayoutInflater.from(context).inflate(2130904350, null);
        }
    }

    /* compiled from: pending_sessions */
    class C04332 extends ViewType {
        final /* synthetic */ FeedMegaphoneAdapter f10364a;

        C04332(FeedMegaphoneAdapter feedMegaphoneAdapter) {
            this.f10364a = feedMegaphoneAdapter;
        }

        public final View mo1995a(Context context) {
            return new DefaultMegaphoneStoryView(context);
        }
    }

    /* compiled from: pending_sessions */
    class C04343 extends ViewType {
        final /* synthetic */ FeedMegaphoneAdapter f10365a;

        C04343(FeedMegaphoneAdapter feedMegaphoneAdapter) {
            this.f10365a = feedMegaphoneAdapter;
        }

        public final View mo1995a(Context context) {
            return new QuickPromotionMegaphoneStoryView(context);
        }
    }

    /* compiled from: pending_sessions */
    class C04354 extends ViewType {
        final /* synthetic */ FeedMegaphoneAdapter f10366a;

        C04354(FeedMegaphoneAdapter feedMegaphoneAdapter) {
            this.f10366a = feedMegaphoneAdapter;
        }

        public final View mo1995a(Context context) {
            return new QuickPromotionBrandedMegaphoneStoryView(context);
        }
    }

    /* compiled from: pending_sessions */
    class C04365 extends ViewType {
        final /* synthetic */ FeedMegaphoneAdapter f10367a;

        C04365(FeedMegaphoneAdapter feedMegaphoneAdapter) {
            this.f10367a = feedMegaphoneAdapter;
        }

        public final View mo1995a(Context context) {
            return new QuickPromotionSurveyMegaphoneStoryView(context);
        }
    }

    /* compiled from: pending_sessions */
    class C04376 extends ViewType {
        final /* synthetic */ FeedMegaphoneAdapter f10368a;

        C04376(FeedMegaphoneAdapter feedMegaphoneAdapter) {
            this.f10368a = feedMegaphoneAdapter;
        }

        public final View mo1995a(Context context) {
            return new IdentityGrowthMegaphoneStoryView(context);
        }
    }

    /* compiled from: pending_sessions */
    class C04387 extends ViewType {
        final /* synthetic */ FeedMegaphoneAdapter f10369a;

        C04387(FeedMegaphoneAdapter feedMegaphoneAdapter) {
            this.f10369a = feedMegaphoneAdapter;
        }

        public final View mo1995a(Context context) {
            return new MegaphoneLegacyStoryView(context);
        }
    }

    /* compiled from: pending_sessions */
    class C04398 extends ViewType {
        final /* synthetic */ FeedMegaphoneAdapter f10370a;

        C04398(FeedMegaphoneAdapter feedMegaphoneAdapter) {
            this.f10370a = feedMegaphoneAdapter;
        }

        public final View mo1995a(Context context) {
            return new DynamicLayoutMegaphoneView(context);
        }
    }

    /* compiled from: pending_sessions */
    class C04409 extends ViewType {
        final /* synthetic */ FeedMegaphoneAdapter f10371a;

        C04409(FeedMegaphoneAdapter feedMegaphoneAdapter) {
            this.f10371a = feedMegaphoneAdapter;
        }

        public final View mo1995a(Context context) {
            if (this.f10371a.f10289q == null) {
                return new View(context);
            }
            View view;
            CustomRenderManager customRenderManager = (CustomRenderManager) this.f10371a.f10283k.get();
            if (((PnaCustomRenderEntry) customRenderManager.a.get(this.f10371a.f10289q.customRenderType)) == null) {
                view = new View(context);
            } else {
                view = new PhoneNumberAcquisitionQPView(context);
            }
            return view;
        }
    }

    @Inject
    public FeedMegaphoneAdapter(Context context, Lazy<CustomRenderManager> lazy, MegaphoneStore megaphoneStore, InterstitialManager interstitialManager, VersionStringComparator versionStringComparator) {
        this.f10282j = context;
        this.f10283k = lazy;
        this.f10284l = megaphoneStore;
        this.f10285m = interstitialManager;
        this.f10286n = versionStringComparator;
        this.f10287o = new ViewType[]{this.f10273a, this.f10274b, this.f10275c, this.f10278f, this.f10279g, this.f10280h, this.f10276d, this.f10277e, this.f10281i};
    }

    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        ViewType viewType = this.f10287o[getItemViewType(i)];
        if (!(view == null || viewType != this.f10281i || this.f10289q == null)) {
            Class cls;
            Class cls2 = view.getClass();
            CustomRenderManager customRenderManager = (CustomRenderManager) this.f10283k.get();
            if (((PnaCustomRenderEntry) customRenderManager.a.get(this.f10289q.customRenderType)) == null) {
                cls = null;
            } else {
                cls = PhoneNumberAcquisitionQPView.class;
            }
            if (cls2 != cls) {
                view = null;
            }
        }
        return super.getView(i, view, viewGroup);
    }

    public final View mo1985a(int i, ViewGroup viewGroup) {
        return this.f10287o[i].mo1995a(viewGroup.getContext());
    }

    public final void mo1986a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        TracerDetour.a("FeedMegaphoneAdapter.bindView", 2002971034);
        try {
            ViewType viewType = this.f10287o[i2];
            if (obj == this.f10273a) {
                m15352a(view, m15355d());
            } else if (m15354a(viewType)) {
                m15353a(viewType, view);
            } else {
                throw new IllegalStateException();
            }
            TracerDetour.a(-540757087);
        } catch (Throwable th) {
            TracerDetour.a(-2001813777);
        }
    }

    public int getCount() {
        return (m15355d() ? 1 : 0) + 1;
    }

    public Object getItem(int i) {
        Preconditions.checkElementIndex(i, getCount());
        if (i == 0) {
            return this.f10273a;
        }
        Preconditions.checkState(m15355d());
        return m15356e();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        ViewType viewType = (ViewType) getItem(i);
        for (int i2 = 0; i2 < this.f10287o.length; i2++) {
            if (viewType == this.f10287o[i2]) {
                return i2;
            }
        }
        throw new IllegalStateException();
    }

    public int getViewTypeCount() {
        return this.f10287o.length;
    }

    public void notifyDataSetChanged() {
        QuickPromotionDefinition quickPromotionDefinition;
        this.f10288p = this.f10284l.m15370a(GraphQLMegaphoneLocation.NEWSFEED);
        if (this.f10290r != null) {
            quickPromotionDefinition = this.f10290r;
        } else {
            InterstitialIntentController interstitialIntentController = (InterstitialIntentController) this.f10285m.m8118a(new InterstitialTrigger(Action.NEWSFEED), InterstitialIntentController.class);
            if (interstitialIntentController == null) {
                quickPromotionDefinition = null;
            } else {
                Intent a = interstitialIntentController.mo1687a(this.f10282j);
                if (a == null) {
                    quickPromotionDefinition = null;
                } else {
                    this.f10290r = (QuickPromotionDefinition) a.getExtras().get("qp_definition");
                    quickPromotionDefinition = this.f10290r;
                }
            }
        }
        this.f10289q = quickPromotionDefinition;
        super.notifyDataSetChanged();
    }

    private boolean m15355d() {
        return (this.f10289q == null && m15358h() == null) ? false : true;
    }

    private ViewType m15356e() {
        GraphQLMegaphone h = m15358h();
        if (h != null) {
            if (Objects.equal(h.k(), "2322")) {
                return this.f10278f;
            }
            if (this.f10288p.a != null) {
                return this.f10280h;
            }
            if (this.f10286n.m8673a(h.u(), "2.0") < 0) {
                return this.f10279g;
            }
            return this.f10274b;
        } else if (this.f10289q == null) {
            throw new IllegalStateException("MegaphoneController#hasMegaphone returned true for a megaphone with no view type mapped.");
        } else if (this.f10289q.e() == TemplateType.BRANDED_MEGAPHONE) {
            return this.f10276d;
        } else {
            if (this.f10289q.e() == TemplateType.SURVEY_MEGAPHONE) {
                return this.f10277e;
            }
            if (this.f10289q.e() == TemplateType.CUSTOM_RENDERED) {
                return this.f10281i;
            }
            return this.f10275c;
        }
    }

    private boolean m15354a(ViewType viewType) {
        return viewType == this.f10274b || viewType == this.f10278f || viewType == this.f10275c || viewType == this.f10280h || viewType == this.f10279g || viewType == this.f10276d || viewType == this.f10277e || viewType == this.f10281i;
    }

    private void m15353a(ViewType viewType, View view) {
        if (viewType == this.f10274b || viewType == this.f10279g || viewType == this.f10280h) {
            ((MegaphoneStoryView) view).setMegaphoneStory(this.f10288p);
        } else if (viewType == this.f10278f) {
            m15351a(view, this.f10288p.b);
        } else if (viewType == this.f10275c) {
            ((QuickPromotionMegaphoneStoryView) view).g = this.f10291s;
            ((QuickPromotionMegaphoneStoryView) view).a(this.f10289q, QuickPromotionMegaphoneController.f13675a);
        } else if (viewType == this.f10276d) {
            ((QuickPromotionBrandedMegaphoneStoryView) view).q = this.f10291s;
            ((QuickPromotionBrandedMegaphoneStoryView) view).a(this.f10289q, QuickPromotionMegaphoneController.f13675a);
        } else if (viewType == this.f10277e) {
            ((QuickPromotionSurveyMegaphoneStoryView) view).m = this.f10291s;
            ((QuickPromotionSurveyMegaphoneStoryView) view).a(this.f10289q, QuickPromotionMegaphoneController.f13675a);
        } else if (viewType == this.f10281i && (view instanceof CustomRenderBaseView)) {
            ((CustomRenderBaseView) view).setOnDismiss(this.f10291s);
            ((CustomRenderBaseView) view).a(this.f10289q, QuickPromotionMegaphoneController.f13675a);
        }
    }

    public static void m15357g(FeedMegaphoneAdapter feedMegaphoneAdapter) {
        feedMegaphoneAdapter.f10290r = null;
    }

    private GraphQLMegaphone m15358h() {
        return this.f10288p != null ? this.f10288p.b : null;
    }

    private static View m15352a(View view, boolean z) {
        view.findViewById(2131562035).setVisibility(z ? 8 : 0);
        return view;
    }

    private View m15351a(View view, GraphQLMegaphone graphQLMegaphone) {
        if (view == null) {
            view = new IdentityGrowthMegaphoneStoryView(this.f10282j);
        } else {
            IdentityGrowthMegaphoneStoryView identityGrowthMegaphoneStoryView = (IdentityGrowthMegaphoneStoryView) view;
        }
        view.a(graphQLMegaphone);
        return view;
    }
}
