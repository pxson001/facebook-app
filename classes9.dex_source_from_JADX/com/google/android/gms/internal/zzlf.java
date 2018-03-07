package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzld.zza;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class zzlf extends zzle {
    public static final List<String> f3687c = Collections.singletonList("email");
    private Class<?> f3688d;
    private Class<?> f3689e;
    private Object f3690f;
    private Object f3691g;

    class C03321 implements InvocationHandler {
        final /* synthetic */ zzlf f3684a;

        C03321(zzlf com_google_android_gms_internal_zzlf) {
            this.f3684a = com_google_android_gms_internal_zzlf;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            Class cls = Class.forName("com.facebook.login.LoginResult");
            Class cls2 = Class.forName("com.facebook.FacebookException");
            Class[] parameterTypes = method.getParameterTypes();
            if (method.getName().equals("onSuccess") && parameterTypes.length == 1 && objArr[0].getClass() == cls) {
                this.f3684a.f3683e.mo99a(this.f3684a.m3413a(IdpTokenType.f3662a, (String) Class.forName("com.facebook.AccessToken").getMethod("getToken", new Class[0]).invoke(cls.getDeclaredMethod("getAccessToken", new Class[0]).invoke(objArr[0], new Object[0]), new Object[0]), this.f3684a.f3682d));
            } else if (method.getName().equals("onCancel") && parameterTypes.length == 0) {
                this.f3684a.f3683e.mo98a();
            } else if (method.getName().equals("onError") && parameterTypes.length == 1 && parameterTypes[0] == cls2) {
                Log.e("AuthSignInClient", "facebook login error!", (Exception) objArr[0]);
                this.f3684a.f3683e.mo100a((Exception) objArr[0]);
            } else {
                throw new ExceptionInInitializerError("Method not supported!");
            }
            return null;
        }
    }

    public zzlf(Activity activity, List<String> list) {
        super(activity, f3687c, list);
    }

    public static void m3416b(Context context) {
        Class cls;
        Throwable e;
        zzx.a(context);
        try {
            try {
                Class.forName("com.facebook.FacebookSdk").getDeclaredMethod("sdkInitialize", new Class[]{Context.class, Integer.TYPE}).invoke(null, new Object[]{context.getApplicationContext(), Integer.valueOf(64206)});
                cls = Class.forName("com.facebook.login.LoginManager");
                cls.getDeclaredMethod("logOut", new Class[0]).invoke(cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
                return;
            } catch (NoSuchMethodException e2) {
                e = e2;
            } catch (IllegalAccessException e3) {
                e = e3;
            } catch (InvocationTargetException e4) {
                e = e4;
            }
            Log.e("AuthSignInClient", "Facebook logout error.", e);
            throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
        } catch (ClassNotFoundException e5) {
            try {
                cls = Class.forName("com.facebook.Session");
                Object invoke = cls.getDeclaredMethod("getActiveSession", new Class[0]).invoke(null, new Object[0]);
                if (invoke != null) {
                    cls.getDeclaredMethod("closeAndClearTokenInformation", new Class[0]).invoke(invoke, new Object[0]);
                }
            } catch (ClassNotFoundException e6) {
                e = e6;
                Log.e("AuthSignInClient", "Facebook logout error.", e);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            } catch (NoSuchMethodException e7) {
                e = e7;
                Log.e("AuthSignInClient", "Facebook logout error.", e);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            } catch (IllegalAccessException e8) {
                e = e8;
                Log.e("AuthSignInClient", "Facebook logout error.", e);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            } catch (InvocationTargetException e9) {
                e = e9;
                Log.e("AuthSignInClient", "Facebook logout error.", e);
                throw new IllegalStateException("No supported Facebook SDK version found to use Facebook logout.");
            }
        }
    }

    private void m3417e() {
        if (this.f3691g != null) {
            Class.forName("com.facebook.login.LoginManager").getDeclaredMethod("logInWithReadPermissions", new Class[]{Activity.class, Collection.class}).invoke(this.f3691g, new Object[]{this.f3679a, new ArrayList(this.f3680b)});
            return;
        }
        Class cls = Class.forName("com.facebook.Session$OpenRequest");
        Object newInstance = cls.getConstructor(new Class[]{Activity.class}).newInstance(new Object[]{this.f3679a});
        cls.getDeclaredMethod("setPermissions", new Class[]{List.class}).invoke(newInstance, new Object[]{new ArrayList(this.f3680b)});
        cls.getDeclaredMethod("setRequestCode", new Class[]{Integer.TYPE}).invoke(newInstance, new Object[]{Integer.valueOf(64206)});
        Class cls2 = Class.forName("com.facebook.Session");
        Method declaredMethod = cls.getDeclaredMethod("setCallback", new Class[]{Class.forName("com.facebook.Session$StatusCallback")});
        Object[] objArr = new Object[1];
        final Class cls3 = Class.forName("com.facebook.Session");
        objArr[0] = Proxy.newProxyInstance(Class.forName("com.facebook.Session$StatusCallback").getClassLoader(), new Class[]{r10}, new InvocationHandler(this) {
            final /* synthetic */ zzlf f3686b;

            public Object invoke(Object obj, Method method, Object[] objArr) {
                Class cls = Class.forName("com.facebook.SessionState");
                Class[] parameterTypes = method.getParameterTypes();
                if (method.getName().equals("call") && parameterTypes.length == 3 && parameterTypes[0] == cls3 && parameterTypes[1] == cls && parameterTypes[2] == Exception.class) {
                    if (((Boolean) cls3.getDeclaredMethod("isOpened", new Class[0]).invoke(objArr[0], new Object[0])).booleanValue()) {
                        this.f3686b.f3683e.mo99a(this.f3686b.m3413a(IdpTokenType.f3662a, (String) cls3.getDeclaredMethod("getAccessToken", new Class[0]).invoke(objArr[0], new Object[0]), this.f3686b.f3682d));
                    }
                    return null;
                }
                throw new ExceptionInInitializerError("Method not supported!");
            }
        });
        declaredMethod.invoke(newInstance, objArr);
        Object newInstance2 = cls2.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.f3679a});
        cls2.getDeclaredMethod("setActiveSession", new Class[]{cls2}).invoke(null, new Object[]{newInstance2});
        cls2.getDeclaredMethod("openForRead", new Class[]{cls}).invoke(newInstance2, new Object[]{newInstance});
    }

    private Object m3418f() {
        return Proxy.newProxyInstance(Class.forName("com.facebook.FacebookCallback").getClassLoader(), new Class[]{r0}, new C03321(this));
    }

    public final zze mo101a() {
        return zze.zzVK;
    }

    public final void m3420a(Context context) {
        zzx.a(context);
        try {
            Throwable e;
            this.f3688d = Class.forName("com.facebook.FacebookSdk");
            try {
                this.f3688d.getDeclaredMethod("sdkInitialize", new Class[]{Context.class, Integer.TYPE}).invoke(null, new Object[]{context.getApplicationContext(), Integer.valueOf(64206)});
                this.f3690f = Class.forName("com.facebook.CallbackManager$Factory").getDeclaredMethod("create", new Class[0]).invoke(null, new Object[0]);
                Class cls = Class.forName("com.facebook.login.LoginManager");
                this.f3691g = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                this.f3689e = Class.forName("com.facebook.CallbackManager");
                Class cls2 = Class.forName("com.facebook.FacebookCallback");
                cls.getDeclaredMethod("registerCallback", new Class[]{this.f3689e, cls2}).invoke(this.f3691g, new Object[]{this.f3690f, m3418f()});
                return;
            } catch (ClassNotFoundException e2) {
                e = e2;
            } catch (NoSuchMethodException e3) {
                e = e3;
            } catch (IllegalAccessException e4) {
                e = e4;
            } catch (InvocationTargetException e5) {
                e = e5;
            }
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e6) {
            try {
                Class.forName("com.facebook.Session");
            } catch (ClassNotFoundException e7) {
                throw new RuntimeException("No supported Facebook sdk found.");
            }
        }
    }

    public final void mo102a(zza com_google_android_gms_internal_zzld_zza) {
        Throwable e;
        m3415b(null, null, (zza) zzx.a(com_google_android_gms_internal_zzld_zza));
        try {
            m3417e();
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new RuntimeException(e);
        } catch (InstantiationException e6) {
            e = e6;
            throw new RuntimeException(e);
        }
    }

    public final void mo103a(String str, zza com_google_android_gms_internal_zzld_zza) {
        Throwable e;
        m3415b((String) zzx.a(str), null, (zza) zzx.a(com_google_android_gms_internal_zzld_zza));
        try {
            m3417e();
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new RuntimeException(e);
        } catch (InstantiationException e6) {
            e = e6;
            throw new RuntimeException(e);
        }
    }

    public final void mo104a(String str, String str2, zza com_google_android_gms_internal_zzld_zza) {
        Throwable e;
        m3415b((String) zzx.a(str), (String) zzx.a(str2), (zza) zzx.a(com_google_android_gms_internal_zzld_zza));
        try {
            m3417e();
        } catch (ClassNotFoundException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new RuntimeException(e);
        } catch (InstantiationException e6) {
            e = e6;
            throw new RuntimeException(e);
        }
    }

    public final boolean mo105a(int i, int i2, Intent intent, zza com_google_android_gms_internal_zzld_zza) {
        Throwable e;
        m3414b(com_google_android_gms_internal_zzld_zza);
        if (i != 64206 && this.f3688d == null) {
            return false;
        }
        if (this.f3688d == null || this.f3689e == null || this.f3690f == null) {
            try {
                Class cls = Class.forName("com.facebook.Session");
                Object invoke = cls.getDeclaredMethod("getActiveSession", new Class[0]).invoke(null, new Object[0]);
                Method declaredMethod = cls.getDeclaredMethod("onActivityResult", new Class[]{Activity.class, Integer.TYPE, Integer.TYPE, Intent.class});
                if (invoke == null) {
                    return false;
                }
                return ((Boolean) declaredMethod.invoke(invoke, new Object[]{this.f3679a, Integer.valueOf(i), Integer.valueOf(i2), intent})).booleanValue();
            } catch (ClassNotFoundException e2) {
                e = e2;
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e3) {
                e = e3;
                throw new RuntimeException(e);
            } catch (IllegalAccessException e4) {
                e = e4;
                throw new RuntimeException(e);
            } catch (InvocationTargetException e5) {
                e = e5;
                throw new RuntimeException(e);
            }
        }
        try {
            if (!((Boolean) this.f3688d.getDeclaredMethod("isFacebookRequestCode", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(i)})).booleanValue()) {
                return false;
            }
            return ((Boolean) this.f3689e.getDeclaredMethod("onActivityResult", new Class[]{Integer.TYPE, Integer.TYPE, Intent.class}).invoke(this.f3690f, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent})).booleanValue();
        } catch (NoSuchMethodException e6) {
            e = e6;
            throw new RuntimeException(e);
        } catch (IllegalAccessException e7) {
            e = e7;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e8) {
            e = e8;
            throw new RuntimeException(e);
        }
    }
}
