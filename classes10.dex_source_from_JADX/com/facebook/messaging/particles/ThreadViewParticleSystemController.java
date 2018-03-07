package com.facebook.messaging.particles;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.particles.ParticleStyle;
import com.facebook.particles.ParticleSystemView;
import com.facebook.particles.SimpleParticleStyle;
import com.facebook.particles.suppliers.Constant;
import com.facebook.particles.suppliers.FloatSupplier;
import com.facebook.particles.suppliers.GaussianInRange;
import com.facebook.particles.suppliers.RandomInRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* compiled from: rerequest */
public class ThreadViewParticleSystemController {
    private final ParticleSystemView f3437a;
    private final FloatSupplier f3438b;
    private SimpleParticleStyle f3439c;
    private SimpleParticleStyle f3440d;
    private SimpleParticleStyle f3441e;
    private List<ParticleStyle> f3442f;

    public ThreadViewParticleSystemController(ParticleSystemView particleSystemView) {
        this.f3437a = particleSystemView;
        Resources resources = particleSystemView.getResources();
        this.f3438b = new RandomInRange(resources.getDimension(2131433881), resources.getDimension(2131433882));
    }

    public final void m3329a(int i) {
        int i2 = i / 100;
        int i3 = i % 100;
        if (i2 > 0) {
            m3323c();
        }
        if (i3 > 0) {
            m3324d();
        }
        int min = Math.min(i2, 200);
        int min2 = Math.min(10, (int) (((float) min) * 0.25f));
        int min3 = Math.min(20, (int) (((float) i3) * 0.75f));
        i2 = min;
        min = 0;
        while (min < min2) {
            this.f3437a.a(this.f3439c);
            min++;
            i2--;
        }
        Object linkedList = new LinkedList();
        while (i2 > 0) {
            linkedList.add(this.f3439c);
            i2--;
        }
        while (i3 > min3) {
            linkedList.add(this.f3440d);
            i3--;
        }
        Collections.shuffle(linkedList);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            this.f3437a.a((SimpleParticleStyle) it.next());
        }
        for (i2 = i3; i2 > 0; i2--) {
            this.f3437a.a(this.f3440d);
        }
    }

    public final void m3328a() {
        m3326f();
        Random random = new Random();
        int size = this.f3442f.size();
        for (int i = 0; i < 50; i++) {
            this.f3437a.a((SimpleParticleStyle) this.f3442f.get(random.nextInt(size)));
        }
    }

    public final void m3330b() {
        m3325e();
        for (int i = 0; i < 30; i++) {
            this.f3437a.a(this.f3441e);
        }
    }

    private void m3323c() {
        if (this.f3439c == null) {
            SimpleParticleStyle simpleParticleStyle = new SimpleParticleStyle(m3322b(2131755088));
            simpleParticleStyle.b = this.f3438b;
            SimpleParticleStyle simpleParticleStyle2 = simpleParticleStyle;
            simpleParticleStyle2.e = new Constant(m3327g(), 2131433877);
            simpleParticleStyle2 = simpleParticleStyle2;
            simpleParticleStyle2.f = RandomInRange.b;
            simpleParticleStyle2 = simpleParticleStyle2;
            simpleParticleStyle2.g = new RandomInRange(45.0f, 135.0f);
            simpleParticleStyle2 = simpleParticleStyle2;
            simpleParticleStyle2.i = 1600;
            simpleParticleStyle2 = simpleParticleStyle2;
            simpleParticleStyle2.j = RandomInRange.a;
            this.f3439c = simpleParticleStyle2;
        }
    }

    private void m3324d() {
        if (this.f3440d == null) {
            SimpleParticleStyle simpleParticleStyle = new SimpleParticleStyle(m3322b(2131755089));
            simpleParticleStyle.b = this.f3438b;
            SimpleParticleStyle simpleParticleStyle2 = simpleParticleStyle;
            simpleParticleStyle2.e = new Constant(m3327g(), 2131433878);
            simpleParticleStyle2 = simpleParticleStyle2;
            simpleParticleStyle2.f = RandomInRange.b;
            simpleParticleStyle2 = simpleParticleStyle2;
            simpleParticleStyle2.g = new RandomInRange(45.0f, 135.0f);
            simpleParticleStyle2 = simpleParticleStyle2;
            simpleParticleStyle2.i = 1000;
            simpleParticleStyle2 = simpleParticleStyle2;
            simpleParticleStyle2.j = RandomInRange.a;
            this.f3440d = simpleParticleStyle2;
        }
    }

    private void m3325e() {
        if (this.f3441e == null) {
            Resources g = m3327g();
            Bitmap decodeResource = BitmapFactory.decodeResource(g, 2130841505);
            float dimension = g.getDimension(2131433879);
            float dimension2 = g.getDimension(2131433880);
            SimpleParticleStyle simpleParticleStyle = new SimpleParticleStyle(decodeResource);
            simpleParticleStyle.b = this.f3438b;
            SimpleParticleStyle simpleParticleStyle2 = simpleParticleStyle;
            simpleParticleStyle2.e = new RandomInRange(dimension, dimension2);
            SimpleParticleStyle simpleParticleStyle3 = simpleParticleStyle2;
            simpleParticleStyle3.f = new GaussianInRange(-15.0f, 15.0f);
            simpleParticleStyle3 = simpleParticleStyle3;
            simpleParticleStyle3.h = new RandomInRange(0.5f, 1.0f);
            this.f3441e = simpleParticleStyle3;
        }
    }

    private void m3326f() {
        if (this.f3442f == null) {
            Resources g = m3327g();
            RandomInRange randomInRange = new RandomInRange(g.getDimension(2131433883), g.getDimension(2131433884));
            RandomInRange randomInRange2 = new RandomInRange(g.getDimension(2131433885), g.getDimension(2131433886));
            RandomInRange randomInRange3 = new RandomInRange(g.getDimension(2131433887), g.getDimension(2131433888));
            GaussianInRange gaussianInRange = new GaussianInRange(-120.0f, 120.0f);
            RandomInRange randomInRange4 = new RandomInRange(0.23f, 1.0f);
            RandomInRange randomInRange5 = RandomInRange.b;
            this.f3442f = new ArrayList();
            for (Bitmap bitmap : m3322b(2131755090)) {
                List list = this.f3442f;
                SimpleParticleStyle simpleParticleStyle = new SimpleParticleStyle(bitmap);
                simpleParticleStyle.b = randomInRange;
                SimpleParticleStyle simpleParticleStyle2 = simpleParticleStyle;
                simpleParticleStyle2.c = randomInRange2;
                simpleParticleStyle2 = simpleParticleStyle2;
                simpleParticleStyle2.d = true;
                simpleParticleStyle2 = simpleParticleStyle2;
                simpleParticleStyle2.e = randomInRange3;
                simpleParticleStyle2 = simpleParticleStyle2;
                simpleParticleStyle2.f = randomInRange5;
                simpleParticleStyle2 = simpleParticleStyle2;
                simpleParticleStyle2.g = gaussianInRange;
                simpleParticleStyle2 = simpleParticleStyle2;
                simpleParticleStyle2.h = randomInRange4;
                list.add(simpleParticleStyle2);
            }
        }
    }

    private Resources m3327g() {
        return this.f3437a.getResources();
    }

    private List<Bitmap> m3322b(int i) {
        List<Bitmap> arrayList = new ArrayList();
        TypedArray obtainTypedArray = m3327g().obtainTypedArray(i);
        for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
            arrayList.add(((BitmapDrawable) obtainTypedArray.getDrawable(i2)).getBitmap());
        }
        obtainTypedArray.recycle();
        return arrayList;
    }
}
