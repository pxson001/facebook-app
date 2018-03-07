package com.facebook.nearby.v2.intent.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: payments_pay_fail */
public class NearbyPlacesLocationServicesView extends CustomLinearLayout {
    private FbButton f5153a;
    private FbTextView f5154b;
    public OnClickListener f5155c;
    private final OnClickListener f5156d;

    /* compiled from: payments_pay_fail */
    class C07171 implements OnClickListener {
        final /* synthetic */ NearbyPlacesLocationServicesView f5152a;

        C07171(NearbyPlacesLocationServicesView nearbyPlacesLocationServicesView) {
            this.f5152a = nearbyPlacesLocationServicesView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1178364746);
            if (this.f5152a.f5155c != null) {
                this.f5152a.f5155c.onClick(view);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1510658436, a);
        }
    }

    public NearbyPlacesLocationServicesView(Context context) {
        this(context, null);
    }

    private NearbyPlacesLocationServicesView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private NearbyPlacesLocationServicesView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5155c = null;
        this.f5156d = new C07171(this);
        setContentView(2130905395);
        this.f5153a = (FbButton) findViewById(2131564121);
        this.f5153a.setOnClickListener(this.f5156d);
        this.f5154b = (FbTextView) findViewById(2131564120);
    }

    public void setTitle(CharSequence charSequence) {
        this.f5154b.setText(charSequence);
    }

    public void setPrimaryButtonText(CharSequence charSequence) {
        this.f5153a.setText(charSequence);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f5155c = onClickListener;
    }
}
