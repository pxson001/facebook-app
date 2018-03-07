package com.facebook.richdocument.view.widget;

import android.content.Context;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.richdocument.ham.HamDimensions;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: offer_location */
public class SimpleRichDocumentBlockHeightPredictor implements InjectableComponentWithContext {
    @Inject
    public HamDimensions f7486a;
    public final Context f7487b;
    public final Map<Integer, Integer> f7488c = new HashMap();
    public final int f7489d;

    public static void m7694a(Object obj, Context context) {
        ((SimpleRichDocumentBlockHeightPredictor) obj).f7486a = HamDimensions.m5268a(FbInjector.get(context));
    }

    public SimpleRichDocumentBlockHeightPredictor(Context context) {
        this.f7487b = context;
        Class cls = SimpleRichDocumentBlockHeightPredictor.class;
        m7694a(this, getContext());
        this.f7489d = this.f7486a.m5276b(2131558726) + this.f7486a.m5276b(2131558650);
        this.f7488c.put(Integer.valueOf(1), Integer.valueOf(this.f7489d));
        this.f7488c.put(Integer.valueOf(17), Integer.valueOf(this.f7489d * 2));
        this.f7488c.put(Integer.valueOf(18), Integer.valueOf(this.f7489d * 2));
        this.f7488c.put(Integer.valueOf(14), Integer.valueOf(this.f7489d));
        this.f7488c.put(Integer.valueOf(16), Integer.valueOf(this.f7489d / 2));
        this.f7488c.put(Integer.valueOf(11), Integer.valueOf((int) this.f7487b.getResources().getDimension(2131431838)));
        this.f7488c.put(Integer.valueOf(12), Integer.valueOf(this.f7489d));
        this.f7488c.put(Integer.valueOf(19), Integer.valueOf(this.f7489d / 2));
        this.f7488c.put(Integer.valueOf(20), Integer.valueOf(this.f7489d / 2));
        this.f7488c.put(Integer.valueOf(21), Integer.valueOf(this.f7489d / 2));
        this.f7488c.put(Integer.valueOf(9), Integer.valueOf(this.f7489d));
        this.f7488c.put(Integer.valueOf(7), Integer.valueOf(this.f7489d * 2));
        this.f7488c.put(Integer.valueOf(4), Integer.valueOf(this.f7489d * 2));
        this.f7488c.put(Integer.valueOf(2), Integer.valueOf(this.f7489d * 3));
        this.f7488c.put(Integer.valueOf(22), Integer.valueOf(this.f7489d * 2));
        this.f7488c.put(Integer.valueOf(3), Integer.valueOf(this.f7489d * 2));
        this.f7488c.put(Integer.valueOf(6), Integer.valueOf(this.f7489d * 2));
        this.f7488c.put(Integer.valueOf(5), Integer.valueOf(this.f7489d * 2));
        this.f7488c.put(Integer.valueOf(8), Integer.valueOf(this.f7489d * 2));
        this.f7488c.put(Integer.valueOf(23), Integer.valueOf(this.f7489d * 2));
    }

    public Context getContext() {
        return this.f7487b;
    }
}
