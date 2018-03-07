package com.facebook.vault.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.photos.base.photos.Photo;
import com.facebook.photos.base.photos.VaultLocalPhoto;
import com.facebook.vault.provider.VaultImageProviderRow;
import com.facebook.vault.service.VaultTable;

/* compiled from: text/vnd.wap.wmlscript */
public class VaultGridItemController {
    public FbDraweeView f1997a;
    public ProgressBar f1998b;
    public ProgressBar f1999c;
    public ImageView f2000d;
    private VaultTable f2001e;
    private Photo f2002f;

    /* compiled from: text/vnd.wap.wmlscript */
    class ViewHolder {
        FbDraweeView f1993a;
        ProgressBar f1994b;
        ProgressBar f1995c;
        ImageView f1996d;

        ViewHolder() {
        }
    }

    public VaultGridItemController(Context context, Photo photo) {
        this.f2001e = VaultTable.a(FbInjector.get(context));
        this.f2002f = photo;
    }

    public final void m2035a(View view) {
        if (view.getTag() instanceof ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) view.getTag();
            this.f1997a = viewHolder.f1993a;
            this.f1998b = viewHolder.f1994b;
            this.f1999c = viewHolder.f1995c;
            this.f2000d = viewHolder.f1996d;
        } else {
            ViewHolder viewHolder2 = new ViewHolder();
            this.f1997a = (FbDraweeView) view.findViewById(2131568256);
            this.f1998b = (ProgressBar) view.findViewById(2131568258);
            this.f1999c = (ProgressBar) view.findViewById(2131568259);
            this.f2000d = (ImageView) view.findViewById(2131568257);
            viewHolder2.f1993a = this.f1997a;
            viewHolder2.f1994b = this.f1998b;
            viewHolder2.f1995c = this.f1999c;
            viewHolder2.f1996d = this.f2000d;
            view.setTag(viewHolder2);
        }
        this.f1998b.setMax(100);
    }

    public final void m2034a() {
        if (this.f2002f instanceof VaultLocalPhoto) {
            VaultImageProviderRow a = this.f2001e.a(((VaultLocalPhoto) this.f2002f).f);
            if (a != null) {
                if (a.f1879f != 7) {
                    if (a.f1879f == 0 || a.f1879f == 1) {
                        m2033b(255);
                        this.f2002f.a = a.f1875b;
                    } else {
                        m2033b(75);
                    }
                    if (a.m1957a()) {
                        this.f2000d.setVisibility(0);
                    } else {
                        this.f2000d.setVisibility(8);
                    }
                }
                this.f1998b.setVisibility(8);
                this.f1999c.setVisibility(8);
            }
        }
    }

    private void m2033b(int i) {
        this.f1997a.setAlpha(i);
    }
}
