package com.facebook.megaphone.ui;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quickpromotion.asset.QuickPromotionImageFetcher;
import com.facebook.quickpromotion.asset.QuickPromotionImageFetcher$ImageType;
import com.facebook.quickpromotion.logger.QuickPromotionLogger$LayoutInfo;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Action;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ImageParameters;
import com.facebook.quickpromotion.ui.QuickPromotionViewHelper;
import com.facebook.quickpromotion.ui.QuickPromotionViewHelperProvider;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: trending_chaining_enabled */
public class QuickPromotionSurveyMegaphoneStoryView extends CustomFrameLayout {
    @Inject
    public QuickPromotionViewHelperProvider f1408a;
    @Inject
    public QuickPromotionImageFetcher f1409b;
    private final TextView f1410c;
    private final TextView f1411d;
    private final TextView f1412e;
    private final ImageView f1413f;
    private final ImageView f1414g;
    private final View f1415h;
    private boolean f1416i;
    private boolean f1417j = false;
    private QuickPromotionDefinition f1418k;
    public QuickPromotionViewHelper f1419l;
    public Runnable f1420m;

    /* compiled from: trending_chaining_enabled */
    class C01451 implements OnClickListener {
        final /* synthetic */ QuickPromotionSurveyMegaphoneStoryView f1406a;

        C01451(QuickPromotionSurveyMegaphoneStoryView quickPromotionSurveyMegaphoneStoryView) {
            this.f1406a = quickPromotionSurveyMegaphoneStoryView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1290098545);
            this.f1406a.f1419l.m4728b();
            if (this.f1406a.f1419l.m4730d()) {
                QuickPromotionSurveyMegaphoneStoryView.m1576b(this.f1406a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1911635062, a);
        }
    }

    /* compiled from: trending_chaining_enabled */
    class C01462 implements OnClickListener {
        final /* synthetic */ QuickPromotionSurveyMegaphoneStoryView f1407a;

        C01462(QuickPromotionSurveyMegaphoneStoryView quickPromotionSurveyMegaphoneStoryView) {
            this.f1407a = quickPromotionSurveyMegaphoneStoryView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1551782068);
            this.f1407a.f1419l.m4734h();
            if (this.f1407a.f1419l.m4735i()) {
                QuickPromotionSurveyMegaphoneStoryView.m1576b(this.f1407a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -449759022, a);
        }
    }

    public static void m1575a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        QuickPromotionSurveyMegaphoneStoryView quickPromotionSurveyMegaphoneStoryView = (QuickPromotionSurveyMegaphoneStoryView) obj;
        QuickPromotionViewHelperProvider quickPromotionViewHelperProvider = (QuickPromotionViewHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(QuickPromotionViewHelperProvider.class);
        QuickPromotionImageFetcher a = QuickPromotionImageFetcher.a(fbInjector);
        quickPromotionSurveyMegaphoneStoryView.f1408a = quickPromotionViewHelperProvider;
        quickPromotionSurveyMegaphoneStoryView.f1409b = a;
    }

    public QuickPromotionSurveyMegaphoneStoryView(Context context) {
        super(context);
        Class cls = QuickPromotionSurveyMegaphoneStoryView.class;
        m1575a((Object) this, getContext());
        setContentView(2130907339);
        this.f1410c = (TextView) c(2131567785);
        this.f1411d = (TextView) c(2131567786);
        this.f1412e = (TextView) c(2131567787);
        this.f1413f = (ImageView) c(2131567784);
        this.f1414g = (ImageView) c(2131567788);
        this.f1415h = c(2131567789);
        setBackgroundResource(2131361941);
    }

    public final void m1577a(QuickPromotionDefinition quickPromotionDefinition, String str) {
        if (this.f1418k != quickPromotionDefinition) {
            this.f1418k = quickPromotionDefinition;
            Creative c = this.f1418k.c();
            if (c == null) {
                m1576b(this);
                return;
            }
            this.f1419l = this.f1408a.a(this.f1418k, str, c, null);
            OnClickListener c01451 = new C01451(this);
            OnClickListener c01462 = new C01462(this);
            this.f1412e.setOnClickListener(c01451);
            this.f1415h.setOnClickListener(c01462);
            this.f1410c.setText(c.title);
            this.f1411d.setText(c.content);
            ImageParameters b = QuickPromotionImageFetcher.b(c, QuickPromotionImageFetcher$ImageType.ANY);
            if (b != null) {
                m1574a(b, this.f1413f, c);
            } else {
                this.f1413f.setImageURI(null);
            }
            if (c.brandingImageParams == null || c.brandingImageParams.uri == null) {
                this.f1414g.setImageURI(null);
            } else {
                m1574a(c.brandingImageParams, this.f1414g, c);
            }
            Action action = c.primaryAction;
            TextView textView = this.f1412e;
            if (action == null || Strings.isNullOrEmpty(action.title)) {
                textView.setVisibility(8);
            } else {
                textView.setText(action.title);
                textView.setVisibility(0);
            }
            this.f1417j = true;
            this.f1416i = false;
            setVisibility(0);
        } else if (this.f1416i) {
            setVisibility(8);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f1417j) {
            this.f1417j = false;
            QuickPromotionLogger$LayoutInfo quickPromotionLogger$LayoutInfo = new QuickPromotionLogger$LayoutInfo();
            this.f1419l.m4726a();
            this.f1419l.m4727a(quickPromotionLogger$LayoutInfo);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1416i) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(i, i2);
        }
    }

    public static void m1576b(QuickPromotionSurveyMegaphoneStoryView quickPromotionSurveyMegaphoneStoryView) {
        if (quickPromotionSurveyMegaphoneStoryView.f1420m != null) {
            quickPromotionSurveyMegaphoneStoryView.f1420m.run();
        }
        quickPromotionSurveyMegaphoneStoryView.f1416i = true;
        quickPromotionSurveyMegaphoneStoryView.setVisibility(8);
    }

    private void m1574a(ImageParameters imageParameters, ImageView imageView, Creative creative) {
        LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width = this.f1409b.a(imageParameters, creative);
        layoutParams.height = this.f1409b.b(imageParameters, creative);
        imageView.setImageURI(Uri.parse(imageParameters.uri));
    }
}
