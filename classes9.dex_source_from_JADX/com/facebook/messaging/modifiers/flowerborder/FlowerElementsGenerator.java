package com.facebook.messaging.modifiers.flowerborder;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.common.util.SizeUtil;
import com.facebook.messaging.modifiers.flowerborder.Element.Builder;
import com.facebook.ultralight.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

/* compiled from: ji */
public class FlowerElementsGenerator {
    public final Random f12285a = new Random();
    private final Resources f12286b;
    public final ElementStyle f12287c;
    public final ElementStyle f12288d;
    public final ElementStyle f12289e;
    public final List<Paint> f12290f;

    /* compiled from: ji */
    public class ElementProducer {
        final /* synthetic */ FlowerElementsGenerator f12282a;
        private final Queue<ElementStyle> f12283b;
        private final Queue<Paint> f12284c;

        ElementProducer(FlowerElementsGenerator flowerElementsGenerator) {
            this.f12282a = flowerElementsGenerator;
            Object linkedList = new LinkedList();
            linkedList.add(flowerElementsGenerator.f12288d);
            linkedList.add(flowerElementsGenerator.f12289e);
            linkedList.add(flowerElementsGenerator.f12285a.nextBoolean() ? flowerElementsGenerator.f12288d : flowerElementsGenerator.f12289e);
            Collections.shuffle(linkedList);
            Object linkedList2 = new LinkedList(flowerElementsGenerator.f12290f);
            Collections.shuffle(linkedList2);
            this.f12283b = linkedList;
            this.f12284c = linkedList2;
        }

        public final Builder m12744a(float f, float f2) {
            Builder a = Element.m12731a().m12728a(FlowerElementsGenerator.m12746a(this.f12282a, f), FlowerElementsGenerator.m12746a(this.f12282a, f2));
            a.f12245f = (ElementStyle) this.f12283b.poll();
            a = a;
            a.f12246g = (Paint) this.f12284c.poll();
            Builder builder = a;
            builder.f12243d = (float) this.f12282a.f12285a.nextInt(360);
            return builder;
        }

        public final Builder m12745b(float f, float f2) {
            Builder a = Element.m12731a().m12728a(FlowerElementsGenerator.m12746a(this.f12282a, f), FlowerElementsGenerator.m12746a(this.f12282a, f2));
            a.f12245f = this.f12282a.f12287c;
            return a;
        }
    }

    @Inject
    public FlowerElementsGenerator(Resources resources) {
        this.f12286b = resources;
        ElementStyle.Builder a = ElementStyle.m12734a();
        a.f12258a = m12748a(2130841318);
        a = a;
        a.f12259b = 0.5f;
        this.f12287c = a.m12732a(1.0f, 1.0f).m12733a();
        a = ElementStyle.m12734a();
        a.f12258a = m12748a(2130841319);
        a = a;
        a.f12259b = 1.0f;
        this.f12288d = a.m12732a(0.5f, 0.5f).m12733a();
        a = ElementStyle.m12734a();
        a.f12258a = m12748a(2130841320);
        a = a;
        a.f12259b = 1.0f;
        this.f12289e = a.m12732a(0.5f, 0.5f).m12733a();
        Paint a2 = m12747a(-41068, -27673);
        Paint a3 = m12747a(-4481805, -8990985);
        Paint a4 = m12747a(-16104, -131305);
        this.f12290f = Arrays.asList(new Paint[]{a2, a3, a4});
    }

    private BitmapDrawable m12748a(int i) {
        return (BitmapDrawable) this.f12286b.getDrawable(i);
    }

    private static Paint m12747a(int i, int i2) {
        Paint paint = new Paint(2);
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        int red2 = Color.red(i2);
        int green2 = Color.green(i2);
        int blue2 = Color.blue(i2);
        paint.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{((float) (red2 - red)) / 255.0f, 0.0f, 0.0f, 0.0f, (float) red, ((float) (green2 - green)) / 255.0f, 0.0f, 0.0f, 0.0f, (float) green, ((float) (blue2 - blue)) / 255.0f, 0.0f, 0.0f, 0.0f, (float) blue, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f})));
        return paint;
    }

    public final List<Element> m12751a() {
        List<Element> asList;
        ElementProducer elementProducer = new ElementProducer(this);
        if (this.f12285a.nextBoolean()) {
            r6 = new Element[5];
            Builder a = elementProducer.m12744a(23.5f, 12.0f);
            a.f12242c = 0.6f;
            a = a;
            a.f12244e = -70.0f;
            r6[0] = m12749a(a, 2);
            a = elementProducer.m12745b(10.0f, 29.0f);
            a.f12242c = 0.45f;
            a = a;
            a.f12243d = -80.0f;
            a = a;
            a.f12244e = -60.0f;
            r6[1] = m12749a(a, 4);
            Builder a2 = elementProducer.m12744a(12.0f, 28.5f);
            a2.f12242c = 0.65f;
            a2 = a2;
            a2.f12244e = -70.0f;
            r6[2] = m12749a(a2, 3);
            a2 = elementProducer.m12745b(18.0f, 13.5f);
            a2.f12242c = 0.7f;
            a2 = a2;
            a2.f12243d = 35.0f;
            a2 = a2;
            a2.f12244e = 50.0f;
            r6[3] = m12749a(a2, 1);
            a2 = elementProducer.m12744a(14.5f, 16.5f);
            a2.f12244e = 50.0f;
            r6[4] = m12749a(a2, 0);
            asList = Arrays.asList(r6);
        } else {
            asList = m12750b(elementProducer);
        }
        if (!this.f12285a.nextBoolean()) {
            return asList;
        }
        List<Element> arrayList = new ArrayList();
        for (Element element : asList) {
            Builder a3 = Element.m12731a().m12729a(element).m12728a(element.f12250b, element.f12249a);
            a3.f12243d = -element.f12252d;
            a3 = a3;
            a3.f12244e = -element.f12253e;
            arrayList.add(a3.m12730a());
        }
        return arrayList;
    }

    private static List<Element> m12750b(ElementProducer elementProducer) {
        Element[] elementArr = new Element[5];
        Builder b = elementProducer.m12745b(10.5f, 24.5f);
        b.f12242c = 0.45f;
        b = b;
        b.f12243d = -115.0f;
        b = b;
        b.f12244e = -70.0f;
        elementArr[0] = m12749a(b, 2);
        b = elementProducer.m12744a(10.0f, 17.0f);
        b.f12242c = 0.68f;
        b = b;
        b.f12244e = -60.0f;
        elementArr[1] = m12749a(b, 3);
        Builder a = elementProducer.m12744a(14.0f, 23.0f);
        a.f12242c = 0.67f;
        a = a;
        a.f12244e = -70.0f;
        elementArr[2] = m12749a(a, 4);
        a = elementProducer.m12745b(20.5f, 11.0f);
        a.f12242c = 0.85f;
        a = a;
        a.f12243d = 110.0f;
        a = a;
        a.f12244e = 50.0f;
        elementArr[3] = m12749a(a, 1);
        a = elementProducer.m12744a(19.0f, 11.0f);
        a.f12242c = 0.95f;
        a = a;
        a.f12244e = 50.0f;
        elementArr[4] = m12749a(a, 0);
        return Arrays.asList(elementArr);
    }

    public static Element m12749a(Builder builder, int i) {
        long j = ((long) i) * 80;
        long j2 = 1200 + j;
        builder.f12247h = j;
        builder.f12248i = j2;
        return builder.m12730a();
    }

    public static float m12746a(FlowerElementsGenerator flowerElementsGenerator, float f) {
        return (float) SizeUtil.a(flowerElementsGenerator.f12286b, f);
    }
}
