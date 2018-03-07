package com.facebook.neko.util;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.resources.ui.FbTextView;
import java.util.Arrays;

/* compiled from: tooltip_body */
public class AppUnit extends AbstractUnit {
    private LinearLayout f874a = ((LinearLayout) LayoutInflater.from(getContext()).inflate(2130903267, this));
    private ImageView f875b;
    private ImageView f876c;
    private FbTextView f877d;
    private FbTextView f878e;
    private FbTextView f879f;
    private FbTextView f880g;
    private FbTextView f881h;

    public AppUnit(Context context) {
        super(context);
        setBackground(new ColorDrawable(getResources().getColor(2131363178)));
        setOrientation(1);
        this.f875b = (ImageView) this.f874a.findViewById(2131559625);
        this.f876c = (ImageView) this.f874a.findViewById(2131559122);
        this.f877d = (FbTextView) this.f874a.findViewById(2131558927);
        this.f878e = (FbTextView) this.f874a.findViewById(2131558926);
        this.f879f = (FbTextView) this.f874a.findViewById(2131559626);
        this.f880g = (FbTextView) this.f874a.findViewById(2131559627);
        this.f881h = (FbTextView) this.f874a.findViewById(2131559628);
    }

    public final void mo11a(NativeAd nativeAd) {
        m1111a(this.f875b);
        NativeAd.a(nativeAd.a(), this.f876c);
        NativeAd.a(nativeAd.b(), this.f875b);
        this.f877d.setText(nativeAd.c());
        String d = nativeAd.d();
        AdExtras h = nativeAd.h();
        if (h == null) {
            int i = 0;
        } else {
            boolean z = h.a;
        }
        String string = getResources().getString(2131242252);
        Object obj;
        if (i != 0) {
            obj = d;
        } else if (d == null || d.isEmpty()) {
            obj = string;
        } else {
            CharSequence format = String.format("%s %s %s", new Object[]{string, getResources().getString(2131242238), d});
        }
        this.f878e.setVisibility(8);
        if (!(format == null || format.isEmpty())) {
            this.f878e.setText(format);
            this.f878e.setVisibility(0);
        }
        this.f879f.setText(nativeAd.f());
        this.f880g.setText(nativeAd.e());
        this.f881h.setText(getContext().getResources().getString(2131242257));
        nativeAd.a(this.f874a, Arrays.asList(new View[]{this.f874a}));
    }
}
