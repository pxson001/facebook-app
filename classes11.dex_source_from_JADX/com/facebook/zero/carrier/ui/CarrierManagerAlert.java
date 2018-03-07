package com.facebook.zero.carrier.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: music_error */
public class CarrierManagerAlert extends CustomRelativeLayout {
    public static final CallerContext f5323a = CallerContext.a(CarrierManagerAlert.class);
    public View f5324b = a(2131560242);
    public FbDraweeView f5325c = ((FbDraweeView) a(2131560240));
    public TextView f5326d = ((TextView) a(2131560241));

    /* compiled from: music_error */
    public class C06971 implements OnClickListener {
        final /* synthetic */ CarrierManagerAlert f5322a;

        public C06971(CarrierManagerAlert carrierManagerAlert) {
            this.f5322a = carrierManagerAlert;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -141027882);
            this.f5322a.setVisibility(8);
            Logger.a(2, EntryType.UI_INPUT_END, -809723336, a);
        }
    }

    public CarrierManagerAlert(Context context) {
        super(context);
        setContentView(2130903511);
        this.f5324b.setOnClickListener(new C06971(this));
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131434129));
        layoutParams.addRule(12);
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131363906)));
        setLayoutParams(layoutParams);
        setVisibility(8);
    }
}
