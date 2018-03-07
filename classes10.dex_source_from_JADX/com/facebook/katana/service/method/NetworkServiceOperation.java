package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.debug.asserts.Assert;
import com.facebook.debug.log.BLog;
import com.facebook.katana.model.FacebookApiException;
import com.facebook.katana.net.HttpOperation;
import com.facebook.katana.net.HttpOperation.ResponseInputStream;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import javax.annotation.Nullable;

/* compiled from: tokens */
public abstract class NetworkServiceOperation extends ServiceOperation {
    public boolean f1190a = true;
    protected final String f1191d;
    protected HttpOperation f1192e;
    protected NetworkServiceOperationHttpListener f1193f;

    /* compiled from: tokens */
    public class NetworkServiceOperationHttpListener {
        final /* synthetic */ NetworkServiceOperation f1205a;

        protected NetworkServiceOperationHttpListener(NetworkServiceOperation networkServiceOperation) {
            this.f1205a = networkServiceOperation;
        }

        public final void m1228a(int i, String str, ResponseInputStream responseInputStream, Exception exception) {
            if (i == 200 && exception == null) {
                Assert.a(responseInputStream);
                try {
                    this.f1205a.mo47a(responseInputStream);
                } catch (FacebookApiException e) {
                    exception = e;
                    BLog.b("NetworkServiceOperationHttpListener.onHttpOperationComplete", "FacebookApiException: " + exception.m982a() + "/" + exception.m983b());
                    str = null;
                    i = 0;
                } catch (Exception e2) {
                    exception = e2;
                    exception.printStackTrace();
                    str = null;
                    i = 0;
                }
            } else {
                BLog.b(NetworkServiceOperation.class.getSimpleName(), "There was an error in the NetworkService operation: " + str);
            }
            this.f1205a.m1214a(i, str, exception);
        }
    }

    protected abstract void mo47a(ResponseInputStream responseInputStream);

    public NetworkServiceOperation(Context context, @Nullable Intent intent, String str, @Nullable ServiceOperationListener serviceOperationListener) {
        super(context, intent, serviceOperationListener);
        this.f1191d = str;
    }

    protected final void m1214a(final int i, final String str, @Nullable final Exception exception) {
        if (this.f1189j == null) {
            return;
        }
        if (this.f1190a) {
            HandlerDetour.a(ServiceOperation.f1186g, new Runnable(this) {
                final /* synthetic */ NetworkServiceOperation f1204d;

                public void run() {
                    if (this.f1204d.f1192e != null) {
                        this.f1204d.f1192e = null;
                        this.f1204d.mo48a(this.f1204d, i, str, exception);
                    }
                }
            }, -1714299786);
        } else if (this.f1192e != null) {
            this.f1192e = null;
            mo48a(this, i, str, exception);
        }
    }
}
