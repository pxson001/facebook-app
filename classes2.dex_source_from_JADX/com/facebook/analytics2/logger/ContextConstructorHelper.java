package com.facebook.analytics2.logger;

import android.content.Context;
import com.facebook.analytics.NewAnalyticsSamplingPolicyConfig;
import com.facebook.analytics2.uploader.fbhttp.FbHttpUploader;
import com.facebook.debug.log.BLog;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: tab_src_name */
class ContextConstructorHelper {
    private static ContextConstructorHelper f3349a;
    private final Context f3350b;
    private final ArrayList<SamplingPolicyConfig> f3351c = new ArrayList();
    private final ArrayList<HandlerThreadFactory> f3352d = new ArrayList();
    private final ArrayList<Uploader> f3353e = new ArrayList();

    public static synchronized ContextConstructorHelper m5559a(Context context) {
        ContextConstructorHelper contextConstructorHelper;
        synchronized (ContextConstructorHelper.class) {
            if (f3349a == null) {
                f3349a = new ContextConstructorHelper(context.getApplicationContext());
            }
            contextConstructorHelper = f3349a;
        }
        return contextConstructorHelper;
    }

    private ContextConstructorHelper(Context context) {
        this.f3350b = context;
    }

    public final NewAnalyticsSamplingPolicyConfig m5562a(String str) {
        return (NewAnalyticsSamplingPolicyConfig) m5561a(this.f3351c, str);
    }

    public final HandlerThreadFactory m5563b(String str) {
        return (HandlerThreadFactory) m5561a(this.f3352d, str);
    }

    public final FbHttpUploader m5564c(String str) {
        return (FbHttpUploader) m5561a(this.f3353e, str);
    }

    private synchronized <T> T m5560a(ArrayList<T> arrayList, Class<? extends T> cls) {
        T t;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            t = arrayList.get(i);
            if (t.getClass().equals(cls)) {
                break;
            }
        }
        t = cls.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.f3350b});
        arrayList.add(t);
        return t;
    }

    @Nullable
    private synchronized <T> T m5561a(ArrayList<T> arrayList, String str) {
        T a;
        try {
            a = m5560a((ArrayList) arrayList, Class.forName(str));
        } catch (Throwable e) {
            BLog.b("ContextConstructorHelper", e, "Cannot find class: %s", new Object[]{str});
            a = null;
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        } catch (Throwable e22) {
            throw new RuntimeException(e22);
        } catch (Throwable e222) {
            throw new RuntimeException(e222);
        } catch (Throwable e2222) {
            throw new RuntimeException(e2222);
        }
        return a;
    }
}
