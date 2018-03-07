package com.facebook.ui.toaster;

import android.content.Context;
import android.widget.Toast;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: successful_results */
public class Toaster {
    private ToastLogger f3874a;
    private Context f3875b;

    public static Toaster m6454b(InjectorLike injectorLike) {
        return new Toaster((Context) injectorLike.getInstance(Context.class), ToastLogger.m6457a(injectorLike));
    }

    @Inject
    public Toaster(Context context, ToastLogger toastLogger) {
        this.f3874a = toastLogger;
        this.f3875b = context;
    }

    public final ToastProperties m6455a(ToastBuilder toastBuilder) {
        return m6448a(toastBuilder, false);
    }

    public final ToastProperties m6456b(ToastBuilder toastBuilder) {
        return m6448a(toastBuilder, true);
    }

    public static Toaster m6449a(InjectorLike injectorLike) {
        return m6454b(injectorLike);
    }

    @Deprecated
    public static void m6451a(Context context, int i) {
        m6453a(context, context.getString(i), 0, null, null, m6450a());
    }

    @Deprecated
    public static void m6452a(Context context, CharSequence charSequence) {
        m6453a(context, charSequence, 0, null, null, m6450a());
    }

    @Deprecated
    public static void m6453a(Context context, CharSequence charSequence, int i, String str, String str2, String str3) {
        int i2;
        if (charSequence.length() > 60) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        ToastLogger a = ToastLogger.m6457a(FbInjector.get(context));
        Toast makeText = Toast.makeText(context, charSequence, i2);
        if (i != 0) {
            makeText.setGravity(i, 0, 0);
        }
        makeText.show();
        a.m6459a(charSequence, str2, str, str3, false);
    }

    private ToastProperties m6448a(ToastBuilder toastBuilder, boolean z) {
        CharSequence charSequence;
        if (toastBuilder.a != null) {
            charSequence = toastBuilder.a;
        } else if (toastBuilder.d != null) {
            charSequence = this.f3875b.getString(toastBuilder.c, toastBuilder.d);
        } else {
            charSequence = this.f3875b.getString(toastBuilder.c);
        }
        Toast makeText = Toast.makeText(this.f3875b, charSequence, charSequence.length() > 60 ? 1 : 0);
        if (toastBuilder.b != 0) {
            makeText.setGravity(toastBuilder.b, 0, 0);
        }
        makeText.show();
        if (z) {
            String a;
            ToastLogger toastLogger = this.f3874a;
            String str = toastBuilder.f;
            String str2 = toastBuilder.e;
            if (toastBuilder.g == null) {
                a = m6450a();
            } else {
                a = toastBuilder.g;
            }
            toastLogger.m6459a(charSequence, str, str2, a, toastBuilder.h);
        }
        return new ToastProperties(makeText);
    }

    public static String m6450a() {
        return new Throwable().getStackTrace()[2].getClassName();
    }
}
