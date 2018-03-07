package com.facebook.privacy.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLPrivacyEducationInfo;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.nux.PrivacyEducationBannerController;
import com.facebook.privacy.nux.PrivacyEducationBannerController$EducationInfo;
import com.facebook.privacy.nux.PrivacyEducationBannerController$EducationType;
import com.facebook.privacy.service.PrivacyAnalyticsLogger;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: farRight */
public class PrivacyEducationBannerView extends CustomFrameLayout {
    public PrivacyEducationBannerController f15308a;
    public SecureContextHelper f15309b;
    public final View f15310c = c(2131561150);
    private final View f15311d = c(2131561144);
    public final View f15312e = c(2131561149);
    public final TextView f15313f = ((TextView) c(2131561152));
    private final TextView f15314g = ((TextView) c(2131561146));
    private final TextView f15315h = ((TextView) c(2131561147));
    public final TextView f15316i = ((TextView) c(2131561148));
    private final ImageView f15317j = ((ImageView) c(2131561151));
    private final ImageView f15318k = ((ImageView) c(2131561145));
    public String f15319l;
    private String f15320m;

    /* compiled from: farRight */
    public class C10693 implements OnClickListener {
        final /* synthetic */ PrivacyEducationBannerView f15307a;

        public C10693(PrivacyEducationBannerView privacyEducationBannerView) {
            this.f15307a = privacyEducationBannerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 280441675);
            PrivacyEducationBannerView privacyEducationBannerView = this.f15307a;
            Intent intent = new Intent();
            intent.setData(Uri.parse(privacyEducationBannerView.f15319l));
            privacyEducationBannerView.f15309b.a(intent, privacyEducationBannerView.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, 1252405437, a);
        }
    }

    public static void m22952a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PrivacyEducationBannerView privacyEducationBannerView = (PrivacyEducationBannerView) obj;
        PrivacyEducationBannerController a = PrivacyEducationBannerController.a(fbInjector);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        privacyEducationBannerView.f15308a = a;
        privacyEducationBannerView.f15309b = secureContextHelper;
    }

    public PrivacyEducationBannerView(Context context) {
        super(context);
        setContentView(2130903962);
        Class cls = PrivacyEducationBannerView.class;
        m22952a((Object) this, getContext());
    }

    public final void m22953a(GraphQLPrivacyEducationInfo graphQLPrivacyEducationInfo, String str) {
        PrivacyEducationBannerController$EducationInfo a = this.f15308a.a(graphQLPrivacyEducationInfo);
        setBannerExpanded(this, a.f15124f);
        this.f15313f.setText(a.f15120b);
        this.f15314g.setText(a.f15120b);
        this.f15315h.setText(a.f15121c);
        this.f15319l = a.f15123e;
        this.f15316i.setText(a.f15122d);
        this.f15317j.setImageDrawable(a.f15126h);
        this.f15318k.setImageDrawable(a.f15125g);
        if (!TextUtils.equals(str, this.f15320m)) {
            this.f15308a.b(a.f15119a, a.f15124f);
        }
        this.f15320m = str;
        final PrivacyEducationBannerController$EducationType privacyEducationBannerController$EducationType = a.f15119a;
        this.f15310c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PrivacyEducationBannerView f15304b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -2144284641);
                PrivacyEducationBannerView.setBannerExpanded(this.f15304b, true);
                ((PrivacyAnalyticsLogger) this.f15304b.f15308a.e.get()).a("permalink", privacyEducationBannerController$EducationType.toString());
                Logger.a(2, EntryType.UI_INPUT_END, 376967878, a);
            }
        });
        this.f15312e.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PrivacyEducationBannerView f15306b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2009843423);
                PrivacyEducationBannerView.setBannerExpanded(this.f15306b, false);
                this.f15306b.f15308a.a(privacyEducationBannerController$EducationType, false);
                Logger.a(2, EntryType.UI_INPUT_END, -1737602748, a);
            }
        });
        this.f15316i.setOnClickListener(new C10693(this));
    }

    public static void setBannerExpanded(PrivacyEducationBannerView privacyEducationBannerView, boolean z) {
        int i;
        int i2 = 0;
        View view = privacyEducationBannerView.f15310c;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        view.setVisibility(i);
        View view2 = privacyEducationBannerView.f15311d;
        if (!z) {
            i2 = 8;
        }
        view2.setVisibility(i2);
    }
}
