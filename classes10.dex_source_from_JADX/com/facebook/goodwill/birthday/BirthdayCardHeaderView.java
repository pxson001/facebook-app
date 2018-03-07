package com.facebook.goodwill.birthday;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: WEBVIEW_INTERSTITIAL_HORIZONTAL */
public class BirthdayCardHeaderView extends CustomLinearLayout {
    public static final CallerContext f21019b = CallerContext.a(BirthdayCardHeaderView.class, "birthday_card");
    @Inject
    public FbUriIntentHandler f21020a;
    private final int f21021c = 6;
    public TextView f21022d;
    public TextView f21023e;
    public FbDraweeView f21024f;
    public FbDraweeView f21025g;
    public TextView f21026h;
    public BirthdayCardResources f21027i;

    /* compiled from: WEBVIEW_INTERSTITIAL_HORIZONTAL */
    public class C29921 implements OnClickListener {
        final /* synthetic */ BirthdayCardHeaderView f21018a;

        public C29921(BirthdayCardHeaderView birthdayCardHeaderView) {
            this.f21018a = birthdayCardHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 576271628);
            this.f21018a.f21020a.a(this.f21018a.getContext(), this.f21018a.f21027i.f21049g);
            Logger.a(2, EntryType.UI_INPUT_END, 1857565681, a);
        }
    }

    public static void m22012a(Object obj, Context context) {
        ((BirthdayCardHeaderView) obj).f21020a = FbUriIntentHandler.a(FbInjector.get(context));
    }

    public BirthdayCardHeaderView(Context context) {
        super(context);
        Class cls = BirthdayCardHeaderView.class;
        m22012a(this, getContext());
        LayoutInflater.from(context).inflate(2130904606, this, true);
        setOrientation(1);
        setBackgroundDrawable(new ColorDrawable(getContext().getResources().getColor(2131361920)));
        this.f21022d = (TextView) a(2131558927);
        this.f21023e = (TextView) a(2131562573);
        this.f21025g = (FbDraweeView) a(2131562572);
        this.f21024f = (FbDraweeView) a(2131562571);
        this.f21026h = (TextView) a(2131560879);
        setVisibility(4);
    }

    protected void onMeasure(int i, int i2) {
        if (!(this.f21027i == null || this.f21027i.f21045c == null)) {
            LayoutParams layoutParams = this.f21024f.getLayoutParams();
            int size = MeasureSpec.getSize(i);
            layoutParams.width = -1;
            layoutParams.height = (size * this.f21027i.f21046d) / this.f21027i.f21047e;
        }
        super.onMeasure(i, i2);
    }
}
