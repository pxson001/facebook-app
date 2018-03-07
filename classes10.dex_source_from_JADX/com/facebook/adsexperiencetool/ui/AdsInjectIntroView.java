package com.facebook.adsexperiencetool.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: error parse categories */
public class AdsInjectIntroView extends CustomLinearLayout {
    private static final CallerContext f14471a = CallerContext.a(AdsInjectIntroView.class);
    public AdsInjectIntroViewListener f14472b;
    private TextView f14473c;
    private TextView f14474d;
    private FbDraweeView f14475e;
    private Button f14476f;
    private Button f14477g;
    private Button f14478h;

    /* compiled from: error parse categories */
    public interface AdsInjectIntroViewListener {
        void mo747a();

        void mo748b();

        void mo749c();
    }

    /* compiled from: error parse categories */
    class C20181 implements OnClickListener {
        final /* synthetic */ AdsInjectIntroView f14468a;

        C20181(AdsInjectIntroView adsInjectIntroView) {
            this.f14468a = adsInjectIntroView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 372534854);
            if (this.f14468a.f14472b != null) {
                this.f14468a.f14472b.mo748b();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1194880609, a);
        }
    }

    /* compiled from: error parse categories */
    class C20192 implements OnClickListener {
        final /* synthetic */ AdsInjectIntroView f14469a;

        C20192(AdsInjectIntroView adsInjectIntroView) {
            this.f14469a = adsInjectIntroView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1294163305);
            if (this.f14469a.f14472b != null) {
                this.f14469a.f14472b.mo747a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1878644965, a);
        }
    }

    /* compiled from: error parse categories */
    class C20203 implements OnClickListener {
        final /* synthetic */ AdsInjectIntroView f14470a;

        C20203(AdsInjectIntroView adsInjectIntroView) {
            this.f14470a = adsInjectIntroView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1248799600);
            if (this.f14470a.f14472b != null) {
                this.f14470a.f14472b.mo749c();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1250728148, a);
        }
    }

    public AdsInjectIntroView(Context context) {
        this(context, null);
    }

    public AdsInjectIntroView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdsInjectIntroView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14656a();
    }

    private void m14656a() {
        setContentView(2130903195);
        this.f14473c = (TextView) a(2131559451);
        this.f14474d = (TextView) a(2131559452);
        this.f14475e = (FbDraweeView) a(2131559450);
        this.f14477g = (Button) a(2131559453);
        this.f14478h = (Button) a(2131559454);
        this.f14476f = (Button) a(2131559455);
        m14657b();
    }

    public void setConfirmationTextForActiveSharedAds(String str) {
        CharSequence spannableString = new SpannableString(StringLocaleUtil.a(getResources().getString(2131241786), new Object[]{str}));
        spannableString.setSpan(new TextAppearanceSpan(getContext(), 2131626561), 0, str.length(), 0);
        this.f14473c.setText(spannableString);
        this.f14474d.setText(getResources().getString(2131241788));
        this.f14474d.setVisibility(0);
        this.f14477g.setVisibility(0);
        this.f14478h.setVisibility(0);
        this.f14476f.setVisibility(8);
    }

    public void setConfirmationTextForInactiveSharedAds(String str) {
        String a = StringLocaleUtil.a(getResources().getString(2131241787), new Object[]{str});
        CharSequence spannableString = new SpannableString(a);
        spannableString.setSpan(new TextAppearanceSpan(getContext(), 2131626561), a.lastIndexOf(str), a.lastIndexOf(str) + str.length(), 0);
        this.f14473c.setText(spannableString);
        this.f14474d.setVisibility(4);
        this.f14477g.setVisibility(8);
        this.f14478h.setVisibility(8);
        this.f14476f.setVisibility(0);
    }

    public void setProfilePicture(Uri uri) {
        this.f14475e.a(uri, f14471a);
    }

    public void setAdsInjectIntroViewListener(AdsInjectIntroViewListener adsInjectIntroViewListener) {
        this.f14472b = adsInjectIntroViewListener;
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m14657b() {
        this.f14477g.setOnClickListener(new C20181(this));
        this.f14478h.setOnClickListener(new C20192(this));
        this.f14476f.setOnClickListener(new C20203(this));
    }
}
