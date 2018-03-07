package com.facebook.richdocument;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.view.ContextThemeWrapper;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.propertybag.PropertyBagHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: profilePictureUri */
public class RichDocumentContextWrapper extends ContextThemeWrapper implements PropertyBag {
    @Inject
    public GatekeeperStoreImpl f5048a;
    private final PropertyBagHelper f5049b = new PropertyBagHelper();
    private ApplicationInfo f5050c = null;

    public static void m5022a(Object obj, Context context) {
        ((RichDocumentContextWrapper) obj).f5048a = GatekeeperStoreImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public RichDocumentContextWrapper(Context context) {
        super(context, 0);
        Class cls = RichDocumentContextWrapper.class;
        m5022a((Object) this, (Context) this);
        ApplicationInfo applicationInfo = super.getApplicationInfo();
        if (this.f5048a.a(104, false) && VERSION.SDK_INT >= 17 && (applicationInfo.flags & 4194304) == 0) {
            this.f5050c = new ApplicationInfo(applicationInfo);
            applicationInfo = this.f5050c;
            applicationInfo.flags |= 4194304;
        }
    }

    public final void m5025a(Object obj, Object obj2) {
        this.f5049b.a(obj, obj2);
    }

    public final Object m5024a(Object obj) {
        return this.f5049b.a(obj);
    }

    public ApplicationInfo getApplicationInfo() {
        if (this.f5050c != null) {
            return this.f5050c;
        }
        return super.getApplicationInfo();
    }

    public static String m5021a(Context context) {
        Class b = m5023b(context);
        if (b != null) {
            return b.getSimpleName();
        }
        return null;
    }

    public static Class m5023b(Context context) {
        if (context instanceof RichDocumentContextWrapper) {
            return (Class) ((RichDocumentContextWrapper) context).m5024a((Object) "loggingClass");
        }
        return null;
    }
}
