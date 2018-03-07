package com.facebook.fbui.drawable;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.AttributeSet;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.inject.Lazy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: valueEquivalence */
public class DrawableLoader {
    private static final SparseArray<WeakReference<ConstantState>> f1347a = new SparseArray(0);
    private Executor f1348b;
    private Provider<ImagePipeline> f1349c;
    private Lazy<FbErrorReporter> f1350d;
    public int[] f1351e = null;

    @Inject
    public DrawableLoader(Provider<ImagePipeline> provider, Executor executor, Lazy<FbErrorReporter> lazy) {
        this.f1349c = provider;
        this.f1348b = executor;
        this.f1350d = lazy;
        try {
            Field declaredField = Class.forName("com.facebook.R").getDeclaredField("custom_drawables");
            declaredField.setAccessible(true);
            this.f1351e = (int[]) declaredField.get(null);
            Arrays.sort(this.f1351e);
        } catch (Exception e) {
            this.f1351e = null;
        }
    }

    public final Drawable m2596a(int i, Resources resources) {
        WeakReference weakReference = (WeakReference) f1347a.get(i);
        if (weakReference != null) {
            ConstantState constantState = (ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(resources);
            }
            f1347a.delete(i);
        }
        try {
            Drawable a = m2594a(resources, resources.getXml(i), i);
            f1347a.put(i, new WeakReference(a.getConstantState()));
            return a;
        } catch (Throwable e) {
            throw new RuntimeException("Failed to load XML for resource: " + resources.getResourceEntryName(i), e);
        } catch (Throwable e2) {
            throw new RuntimeException("Failed to load XML for resource: " + resources.getResourceEntryName(i), e2);
        }
    }

    private Drawable m2594a(Resources resources, XmlResourceParser xmlResourceParser, int i) {
        int next;
        do {
            next = xmlResourceParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return m2595a(resources, xmlResourceParser, xmlResourceParser, i);
        }
        throw new XmlPullParserException("No start tag found");
    }

    private Drawable m2595a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, int i) {
        Drawable textureRegionDrawable;
        String name = xmlPullParser.getName();
        if (name.equals("app-region")) {
            textureRegionDrawable = new TextureRegionDrawable();
        } else if (name.equals("app-tint")) {
            textureRegionDrawable = new TintDrawable();
        } else if (name.equals("app-network")) {
            textureRegionDrawable = new NetworkDrawable((ImagePipeline) this.f1349c.get(), this.f1348b, i, this.f1350d);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid drawable tag " + name);
        }
        textureRegionDrawable.inflate(resources, xmlPullParser, attributeSet);
        return textureRegionDrawable;
    }

    public final boolean m2598a(int i) {
        if (this.f1351e == null || Arrays.binarySearch(this.f1351e, i) < 0) {
            return false;
        }
        return true;
    }

    public final void m2597a(Resources resources) {
        try {
            Field declaredField = Resources.class.getDeclaredField("sPreloadedDrawables");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj instanceof LongSparseArray) {
                if (!(obj instanceof CustomDrawablesCache)) {
                    declaredField.set(null, new CustomDrawablesCache((LongSparseArray) obj, this, resources));
                }
            } else if (obj instanceof LongSparseArray[]) {
                LongSparseArray[] longSparseArrayArr = (LongSparseArray[]) obj;
                for (int i = 0; i < longSparseArrayArr.length; i++) {
                    if (!(longSparseArrayArr[i] instanceof CustomDrawablesCache)) {
                        longSparseArrayArr[i] = new CustomDrawablesCache(longSparseArrayArr[i], this, resources);
                    }
                }
            }
        } catch (Exception e) {
            Exception exception = e;
            ((AbstractFbErrorReporter) this.f1350d.get()).m2343a(DrawableLoader.class.getSimpleName(), exception.getMessage(), exception.getCause());
        }
        try {
            Field declaredField2 = AssetManager.class.getDeclaredField("mThemeCookies");
            declaredField2.setAccessible(true);
            ((ArrayList) declaredField2.get(resources.getAssets())).clear();
        } catch (Exception e2) {
        }
    }
}
