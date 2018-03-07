package com.facebook.maps;

import android.content.Context;
import android.content.pm.PackageManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.inject.Inject;

/* compiled from: wifiInfo */
public class GoogleMapsV1Util {
    private static final String f222a = GoogleMapsV1Util.class.getSimpleName();
    private final Context f223b;
    private final AbstractFbErrorReporter f224c;

    public static GoogleMapsV1Util m213b(InjectorLike injectorLike) {
        return new GoogleMapsV1Util((Context) injectorLike.getInstance(Context.class, ForAppContext.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public GoogleMapsV1Util(@ForAppContext Context context, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f223b = context;
        this.f224c = abstractFbErrorReporter;
    }

    public final boolean m214a() {
        try {
            if (Class.forName("com.google.android.maps.MapActivity") == null) {
                return false;
            }
            Method declaredMethod = Class.forName("com.google.android.maps.KeyHelper").getDeclaredMethod("getSignatureFingerprint", new Class[]{PackageManager.class, String.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[]{this.f223b.getPackageManager(), this.f223b.getPackageName()});
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        } catch (Throwable e2) {
            this.f224c.a(f222a, "getSignatureFingerprint() does not exist in KeyHelper. This should never happen.", e2);
            return false;
        } catch (Throwable e22) {
            this.f224c.a(f222a, "No privilege to invoke KeyHelper.getSignatureFingerprint(). This should never happen.", e22);
            return false;
        } catch (InvocationTargetException e3) {
            if (!(e3.getCause() instanceof NoClassDefFoundError)) {
                return false;
            }
            this.f224c.a(f222a, StringFormatUtil.formatStrLocaleSafe("NoClassDefFoundError is expected. But %s is caught", e3.getCause().getClass().getName()), e3.getCause());
            return false;
        }
    }
}
