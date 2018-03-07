package com.facebook.megaphone.ui;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
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
import com.facebook.resources.ui.FbTextView;
import com.facebook.user.tiles.UserTileViewLogic;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.TextViewUtils;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: trending_query_id */
public class QuickPromotionBrandedMegaphoneStoryView extends CustomFrameLayout {
    @Inject
    public QuickPromotionViewHelperProvider f1376a;
    @Inject
    public QuickPromotionImageFetcher f1377b;
    @Inject
    public UserTileViewLogic f1378c;
    @Inject
    public AllCapsTransformationMethod f1379d;
    private final TextView f1380e;
    private final TextView f1381f;
    public final TextView f1382g;
    public final TextView f1383h;
    private final FbDraweeView f1384i;
    private final View f1385j;
    private final ImageView f1386k;
    private FacepileView f1387l;
    private FbTextView f1388m;
    private boolean f1389n;
    public QuickPromotionDefinition f1390o;
    public QuickPromotionViewHelper f1391p;
    public Runnable f1392q;
    private int f1393r;
    private boolean f1394s = false;

    /* compiled from: trending_query_id */
    class C01391 implements OnClickListener {
        final /* synthetic */ QuickPromotionBrandedMegaphoneStoryView f1373a;

        C01391(QuickPromotionBrandedMegaphoneStoryView quickPromotionBrandedMegaphoneStoryView) {
            this.f1373a = quickPromotionBrandedMegaphoneStoryView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1524194132);
            this.f1373a.f1391p.m4728b();
            if (this.f1373a.f1391p.m4730d()) {
                QuickPromotionBrandedMegaphoneStoryView.m1568b(this.f1373a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1597399381, a);
        }
    }

    /* compiled from: trending_query_id */
    class C01402 implements OnClickListener {
        final /* synthetic */ QuickPromotionBrandedMegaphoneStoryView f1374a;

        C01402(QuickPromotionBrandedMegaphoneStoryView quickPromotionBrandedMegaphoneStoryView) {
            this.f1374a = quickPromotionBrandedMegaphoneStoryView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1846381475);
            this.f1374a.f1391p.m4731e();
            if (this.f1374a.f1391p.m4733g()) {
                QuickPromotionBrandedMegaphoneStoryView.m1568b(this.f1374a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 240717109, a);
        }
    }

    /* compiled from: trending_query_id */
    class C01413 implements OnClickListener {
        final /* synthetic */ QuickPromotionBrandedMegaphoneStoryView f1375a;

        C01413(QuickPromotionBrandedMegaphoneStoryView quickPromotionBrandedMegaphoneStoryView) {
            this.f1375a = quickPromotionBrandedMegaphoneStoryView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1939146330);
            this.f1375a.f1391p.m4734h();
            if (this.f1375a.f1391p.m4735i()) {
                QuickPromotionBrandedMegaphoneStoryView.m1568b(this.f1375a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -744087743, a);
        }
    }

    public static void m1567a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        QuickPromotionBrandedMegaphoneStoryView quickPromotionBrandedMegaphoneStoryView = (QuickPromotionBrandedMegaphoneStoryView) obj;
        QuickPromotionViewHelperProvider quickPromotionViewHelperProvider = (QuickPromotionViewHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(QuickPromotionViewHelperProvider.class);
        QuickPromotionImageFetcher a = QuickPromotionImageFetcher.a(fbInjector);
        UserTileViewLogic a2 = UserTileViewLogic.a(fbInjector);
        AllCapsTransformationMethod b = AllCapsTransformationMethod.b(fbInjector);
        quickPromotionBrandedMegaphoneStoryView.f1376a = quickPromotionViewHelperProvider;
        quickPromotionBrandedMegaphoneStoryView.f1377b = a;
        quickPromotionBrandedMegaphoneStoryView.f1378c = a2;
        quickPromotionBrandedMegaphoneStoryView.f1379d = b;
    }

    public QuickPromotionBrandedMegaphoneStoryView(Context context) {
        super(context);
        Class cls = QuickPromotionBrandedMegaphoneStoryView.class;
        m1567a((Object) this, getContext());
        setContentView(2130903432);
        this.f1380e = (TextView) c(2131559980);
        this.f1381f = (TextView) c(2131559981);
        this.f1382g = (TextView) c(2131559987);
        this.f1383h = (TextView) c(2131559988);
        this.f1384i = (FbDraweeView) c(2131559979);
        this.f1386k = (ImageView) c(2131559982);
        this.f1385j = c(2131559989);
        this.f1388m = (FbTextView) c(2131559984);
        this.f1387l = (FacepileView) c(2131559983);
        this.f1393r = getResources().getDimensionPixelSize(2131427501);
        setBackgroundResource(2131361920);
    }

    public final void m1569a(QuickPromotionDefinition quickPromotionDefinition, String str) {
        if (this.f1390o != quickPromotionDefinition) {
            this.f1390o = quickPromotionDefinition;
            Creative c = this.f1390o.c();
            if (c == null) {
                m1568b(this);
                return;
            }
            this.f1391p = this.f1376a.a(this.f1390o, str, c, null);
            OnClickListener c01391 = new C01391(this);
            OnClickListener c01402 = new C01402(this);
            OnClickListener c01413 = new C01413(this);
            this.f1383h.setOnClickListener(c01391);
            this.f1382g.setOnClickListener(c01402);
            this.f1385j.setOnClickListener(c01413);
            this.f1380e.setText(c.title);
            this.f1381f.setText(c.content);
            ImageParameters b = QuickPromotionImageFetcher.b(c, QuickPromotionImageFetcher$ImageType.ANY);
            if (b != null) {
                String str2;
                FbDraweeView fbDraweeView = this.f1384i;
                if (c.templateParameters != null) {
                    str2 = (String) c.templateParameters.get("megaphone_image_resize_mode_option");
                } else {
                    str2 = null;
                }
                LayoutParams layoutParams = (LayoutParams) fbDraweeView.getLayoutParams();
                if (str2 == null || !str2.equals("cover")) {
                    layoutParams.width = this.f1377b.a(b, c);
                    layoutParams.height = this.f1377b.b(b, c);
                    layoutParams.setMargins(0, getResources().getDimensionPixelSize(2131432525), 0, 0);
                } else {
                    layoutParams.setMargins(0, 0, 0, 0);
                    layoutParams.width = -1;
                    layoutParams.height = -2;
                    fbDraweeView.setAspectRatio(((float) b.width) / ((float) b.height));
                }
                fbDraweeView.setImageURI(Uri.parse(b.uri));
            } else {
                this.f1384i.setImageURI(null);
            }
            if (c.brandingImageParams == null || c.brandingImageParams.uri == null) {
                this.f1386k.setImageURI(null);
            } else {
                m1566a(c.brandingImageParams, this.f1386k, c);
            }
            m1565a(c.primaryAction, this.f1383h);
            m1565a(c.secondaryAction, this.f1382g);
            setFacepileUrls(null);
            if (c.socialContext == null) {
                setSocialContext(null);
            } else {
                setSocialContext(c.socialContext.text);
                ImmutableList immutableList = c.socialContext.friendIds;
                if (!(immutableList == null || immutableList.isEmpty())) {
                    int dimensionPixelSize = getResources().getDimensionPixelSize(2131427501);
                    List b2 = Lists.b(6);
                    int i = 0;
                    while (i < immutableList.size() && i < 6) {
                        b2.add(this.f1378c.a((String) immutableList.get(i), dimensionPixelSize, dimensionPixelSize));
                        i++;
                    }
                    setFacepileUrls(b2);
                }
            }
            this.f1394s = true;
            this.f1389n = false;
            setVisibility(0);
        } else if (this.f1389n) {
            setVisibility(8);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f1394s) {
            this.f1394s = false;
            QuickPromotionLogger$LayoutInfo quickPromotionLogger$LayoutInfo = new QuickPromotionLogger$LayoutInfo();
            if (TextViewUtils.a(this.f1383h)) {
                quickPromotionLogger$LayoutInfo.f4748c = this.f1390o.primaryAction.title;
            }
            if (TextViewUtils.a(this.f1382g)) {
                quickPromotionLogger$LayoutInfo.f4749d = this.f1390o.secondaryAction.title;
            }
            this.f1391p.m4726a();
            this.f1391p.m4727a(quickPromotionLogger$LayoutInfo);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1389n) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(i, i2);
        }
    }

    public static void m1568b(QuickPromotionBrandedMegaphoneStoryView quickPromotionBrandedMegaphoneStoryView) {
        if (quickPromotionBrandedMegaphoneStoryView.f1392q != null) {
            quickPromotionBrandedMegaphoneStoryView.f1392q.run();
        }
        quickPromotionBrandedMegaphoneStoryView.f1389n = true;
        quickPromotionBrandedMegaphoneStoryView.setVisibility(8);
    }

    private void m1565a(Action action, TextView textView) {
        if (action == null || Strings.isNullOrEmpty(action.title)) {
            textView.setVisibility(8);
            return;
        }
        textView.setText(action.title);
        textView.setTransformationMethod(this.f1379d);
        textView.setVisibility(0);
    }

    private void m1566a(ImageParameters imageParameters, ImageView imageView, Creative creative) {
        LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
        layoutParams.width = this.f1377b.a(imageParameters, creative);
        layoutParams.height = this.f1377b.b(imageParameters, creative);
        imageView.setImageURI(Uri.parse(imageParameters.uri));
    }

    private void setFacepileUrls(List<Uri> list) {
        FacepileView facepileView = this.f1387l;
        int i = (list == null || list.isEmpty()) ? 8 : 0;
        facepileView.setVisibility(i);
        this.f1387l.setFaceSize(this.f1393r);
        this.f1387l.setFaceUrls(list);
    }

    private void setSocialContext(CharSequence charSequence) {
        this.f1388m.setText(charSequence);
        this.f1388m.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }
}
