package com.facebook.megaphone.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.megaphone.Megaphone;
import com.facebook.fbui.widget.megaphone.Megaphone.OnDismissListener;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quickpromotion.asset.QuickPromotionImageFetcher;
import com.facebook.quickpromotion.asset.QuickPromotionImageFetcher$ImageType;
import com.facebook.quickpromotion.logger.QuickPromotionLogger$LayoutInfo;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ImageParameters;
import com.facebook.quickpromotion.ui.QuickPromotionViewHelper;
import com.facebook.quickpromotion.ui.QuickPromotionViewHelperProvider;
import com.facebook.user.tiles.UserTileViewLogic;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: trending_entities */
public class QuickPromotionMegaphoneStoryView extends Megaphone {
    @Inject
    public QuickPromotionViewHelperProvider f1398a;
    @Inject
    public QuickPromotionImageFetcher f1399b;
    @Inject
    public UserTileViewLogic f1400c;
    public QuickPromotionDefinition f1401d;
    public QuickPromotionViewHelper f1402e;
    private boolean f1403f;
    public Runnable f1404g;
    private boolean f1405h;

    /* compiled from: trending_entities */
    class C01421 implements OnClickListener {
        final /* synthetic */ QuickPromotionMegaphoneStoryView f1395a;

        C01421(QuickPromotionMegaphoneStoryView quickPromotionMegaphoneStoryView) {
            this.f1395a = quickPromotionMegaphoneStoryView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -395603405);
            this.f1395a.f1402e.m4728b();
            if (this.f1395a.f1402e.m4730d()) {
                QuickPromotionMegaphoneStoryView.m1572i(this.f1395a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1894822832, a);
        }
    }

    /* compiled from: trending_entities */
    class C01432 implements OnClickListener {
        final /* synthetic */ QuickPromotionMegaphoneStoryView f1396a;

        C01432(QuickPromotionMegaphoneStoryView quickPromotionMegaphoneStoryView) {
            this.f1396a = quickPromotionMegaphoneStoryView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -306016751);
            this.f1396a.f1402e.m4731e();
            if (this.f1396a.f1402e.m4733g()) {
                QuickPromotionMegaphoneStoryView.m1572i(this.f1396a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -143096190, a);
        }
    }

    /* compiled from: trending_entities */
    class C01443 implements OnDismissListener {
        final /* synthetic */ QuickPromotionMegaphoneStoryView f1397a;

        C01443(QuickPromotionMegaphoneStoryView quickPromotionMegaphoneStoryView) {
            this.f1397a = quickPromotionMegaphoneStoryView;
        }

        public final void m1570a(Megaphone megaphone) {
            this.f1397a.f1402e.m4734h();
            if (this.f1397a.f1402e.m4735i()) {
                QuickPromotionMegaphoneStoryView.m1572i(this.f1397a);
            }
        }
    }

    public static void m1571a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        QuickPromotionMegaphoneStoryView quickPromotionMegaphoneStoryView = (QuickPromotionMegaphoneStoryView) obj;
        QuickPromotionViewHelperProvider quickPromotionViewHelperProvider = (QuickPromotionViewHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(QuickPromotionViewHelperProvider.class);
        QuickPromotionImageFetcher a = QuickPromotionImageFetcher.a(fbInjector);
        UserTileViewLogic a2 = UserTileViewLogic.a(fbInjector);
        quickPromotionMegaphoneStoryView.f1398a = quickPromotionViewHelperProvider;
        quickPromotionMegaphoneStoryView.f1399b = a;
        quickPromotionMegaphoneStoryView.f1400c = a2;
    }

    public QuickPromotionMegaphoneStoryView(Context context) {
        this(context, null);
    }

    private QuickPromotionMegaphoneStoryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private QuickPromotionMegaphoneStoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1405h = false;
        Class cls = QuickPromotionMegaphoneStoryView.class;
        m1571a((Object) this, getContext());
        this.f1403f = true;
    }

    public final boolean m1573a(QuickPromotionDefinition quickPromotionDefinition, String str) {
        if (this.f1401d != quickPromotionDefinition) {
            this.f1401d = quickPromotionDefinition;
            Creative c = this.f1401d.c();
            this.f1402e = this.f1398a.a(this.f1401d, str, c, null);
            OnClickListener c01421 = new C01421(this);
            OnClickListener c01432 = new C01432(this);
            C01443 c01443 = new C01443(this);
            setOnPrimaryButtonClickListener(c01421);
            setOnSecondaryButtonClickListener(c01432);
            this.m = c01443;
            if (c == null) {
                m1572i(this);
                return false;
            }
            boolean z;
            if (c.primaryAction == null || Strings.isNullOrEmpty(c.primaryAction.title)) {
                setShowPrimaryButton(false);
            } else {
                setPrimaryButtonText(c.primaryAction.title);
                setShowPrimaryButton(true);
            }
            if (c.secondaryAction == null || Strings.isNullOrEmpty(c.secondaryAction.title)) {
                setShowSecondaryButton(false);
            } else {
                setSecondaryButtonText(c.secondaryAction.title);
                setShowSecondaryButton(true);
            }
            if (c.dismissAction != null) {
                z = true;
            } else {
                z = false;
            }
            setShowCloseButton(z);
            if (this.f1399b.a(this.f1401d.c(), QuickPromotionImageFetcher$ImageType.ANY) != null) {
                ImageParameters b = QuickPromotionImageFetcher.b(quickPromotionDefinition.c(), QuickPromotionImageFetcher$ImageType.ANY);
                setImageUri(Uri.parse(b.uri));
                a(this.f1399b.a(b, quickPromotionDefinition.c()), this.f1399b.b(b, quickPromotionDefinition.c()));
            } else {
                setImageDrawable(null);
            }
            setTitle(this.f1401d.title);
            setSubtitle(this.f1401d.content);
            setFacepileUrls(null);
            if (c.socialContext == null) {
                setSocialContext(null);
            } else {
                setSocialContext(c.socialContext.text);
                ImmutableList immutableList = c.socialContext.friendIds;
                if (immutableList != null && immutableList.size() > 0) {
                    int dimensionPixelSize = getResources().getDimensionPixelSize(2131427501);
                    List b2 = Lists.b(3);
                    int i = 0;
                    while (i < immutableList.size() && i < 3) {
                        b2.add(this.f1400c.a((String) immutableList.get(i), dimensionPixelSize, dimensionPixelSize));
                        i++;
                    }
                    setFacepileUrls(b2);
                }
            }
            this.f1405h = true;
            this.f1403f = false;
            setVisibility(0);
            return true;
        } else if (!this.f1403f) {
            return false;
        } else {
            setVisibility(8);
            return false;
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1403f) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(i, i2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f1405h) {
            this.f1405h = false;
            QuickPromotionLogger$LayoutInfo quickPromotionLogger$LayoutInfo = new QuickPromotionLogger$LayoutInfo();
            if (a()) {
                quickPromotionLogger$LayoutInfo.f4746a = this.f1401d.title;
            }
            if (b()) {
                quickPromotionLogger$LayoutInfo.f4747b = this.f1401d.content;
            }
            if (e()) {
                quickPromotionLogger$LayoutInfo.f4748c = this.f1401d.primaryAction.title;
            }
            if (f()) {
                quickPromotionLogger$LayoutInfo.f4749d = this.f1401d.secondaryAction.title;
            }
            if (g()) {
                quickPromotionLogger$LayoutInfo.f4750e = this.f1401d.socialContext.text;
            }
            this.f1402e.m4726a();
            this.f1402e.m4727a(quickPromotionLogger$LayoutInfo);
        }
    }

    public static void m1572i(QuickPromotionMegaphoneStoryView quickPromotionMegaphoneStoryView) {
        if (quickPromotionMegaphoneStoryView.f1404g != null) {
            quickPromotionMegaphoneStoryView.f1404g.run();
        }
        quickPromotionMegaphoneStoryView.f1403f = true;
        quickPromotionMegaphoneStoryView.setVisibility(8);
    }
}
