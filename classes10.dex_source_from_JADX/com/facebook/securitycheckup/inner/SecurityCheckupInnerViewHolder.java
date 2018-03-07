package com.facebook.securitycheckup.inner;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.securitycheckup.inner.SecurityCheckupInnerController.C14537;
import com.facebook.securitycheckup.inner.SecurityCheckupInnerController.SecurityCheckupInnerItemSelectionStateListener;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: image_overlay */
public class SecurityCheckupInnerViewHolder extends ViewHolder implements OnClickListener {
    public final FbTextView f9781l;
    public final FbTextView f9782m;
    public final ImageView f9783n;
    public final FbDraweeView f9784o;
    public final InertCheckBox f9785p;
    public SecurityCheckupInnerItemSelectionStateListener f9786q;
    public SecurityCheckupInnerItem f9787r;
    public Context f9788s;
    public int f9789t;

    public SecurityCheckupInnerViewHolder(View view, Context context) {
        super(view);
        view.setOnClickListener(this);
        this.f9781l = (FbTextView) view.findViewById(2131567326);
        this.f9782m = (FbTextView) view.findViewById(2131567327);
        this.f9783n = (ImageView) view.findViewById(2131567322);
        this.f9784o = (FbDraweeView) view.findViewById(2131567323);
        this.f9785p = (InertCheckBox) view.findViewById(2131567325);
        this.f9788s = context;
    }

    public void onClick(View view) {
        boolean z;
        int a = Logger.a(2, EntryType.UI_INPUT_START, 661011116);
        SecurityCheckupInnerItem securityCheckupInnerItem = this.f9787r;
        if (this.f9787r.f9779e) {
            z = false;
        } else {
            z = true;
        }
        securityCheckupInnerItem.f9779e = z;
        this.f9785p.setChecked(this.f9787r.f9779e);
        if (this.f9787r.f9779e) {
            SecurityCheckupInnerItemSelectionStateListener securityCheckupInnerItemSelectionStateListener = this.f9786q;
            switch (C14537.f9749a[securityCheckupInnerItemSelectionStateListener.f9750a.f9761k.ordinal()]) {
                case 1:
                    int d = securityCheckupInnerItemSelectionStateListener.f9750a.f9769s.m10002d();
                    securityCheckupInnerItemSelectionStateListener.f9750a.f9756f.setEnabled(true);
                    if (securityCheckupInnerItemSelectionStateListener.f9750a.f9769s.aZ_() != 1 && d != 1) {
                        if (d != securityCheckupInnerItemSelectionStateListener.f9750a.f9769s.aZ_()) {
                            if (d > 1) {
                                securityCheckupInnerItemSelectionStateListener.f9750a.f9756f.setText(securityCheckupInnerItemSelectionStateListener.f9750a.f9759i.getString(2131241606, new Object[]{Integer.valueOf(d)}));
                                break;
                            }
                        }
                        securityCheckupInnerItemSelectionStateListener.f9750a.f9756f.setText(securityCheckupInnerItemSelectionStateListener.f9750a.f9759i.getString(2131241603));
                        securityCheckupInnerItemSelectionStateListener.f9750a.f9768r = true;
                        securityCheckupInnerItemSelectionStateListener.f9750a.f9767q.setChecked(true);
                        break;
                    }
                    securityCheckupInnerItemSelectionStateListener.f9750a.f9756f.setText(securityCheckupInnerItemSelectionStateListener.f9750a.f9759i.getString(2131241604));
                    break;
                    break;
                case 2:
                    if (securityCheckupInnerItemSelectionStateListener.f9750a.f9769s.m10002d() == 1) {
                        securityCheckupInnerItemSelectionStateListener.f9750a.f9756f.setVisibility(4);
                        securityCheckupInnerItemSelectionStateListener.f9750a.f9757g.setVisibility(0);
                        break;
                    }
                    break;
            }
        }
        this.f9786q.m10004b();
        LogUtils.a(53310158, a);
    }
}
