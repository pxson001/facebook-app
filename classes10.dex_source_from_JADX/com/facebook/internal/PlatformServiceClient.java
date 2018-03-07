package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.login.GetTokenLoginMethodHandler;
import com.facebook.login.GetTokenLoginMethodHandler.1;
import com.facebook.login.GetTokenLoginMethodHandler.2;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginClient.Request;
import com.facebook.tools.dextr.runtime.detour.ServiceConnectionDetour;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: SEND_PING */
public abstract class PlatformServiceClient implements ServiceConnection {
    public final Context f24019a;
    private final Handler f24020b;
    public 1 f24021c;
    public boolean f24022d;
    private Messenger f24023e;
    private int f24024f;
    private int f24025g;
    private final String f24026h;
    public final int f24027i;

    /* compiled from: SEND_PING */
    class C34511 extends Handler {
        final /* synthetic */ PlatformServiceClient f24018a;

        C34511(PlatformServiceClient platformServiceClient) {
            this.f24018a = platformServiceClient;
        }

        public void handleMessage(Message message) {
            this.f24018a.m25306a(message);
        }
    }

    public PlatformServiceClient(Context context, int i, int i2, int i3, String str) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.f24019a = context;
        this.f24024f = i;
        this.f24025g = i2;
        this.f24026h = str;
        this.f24027i = i3;
        this.f24020b = new C34511(this);
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f24023e = new Messenger(iBinder);
        m25305c();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f24023e = null;
        try {
            ServiceConnectionDetour.a(this.f24019a, this, 1564995868);
        } catch (IllegalArgumentException e) {
        }
        m25304a(null);
    }

    private void m25305c() {
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.extra.APPLICATION_ID", this.f24026h);
        Message obtain = Message.obtain(null, this.f24024f);
        obtain.arg1 = this.f24027i;
        obtain.setData(bundle);
        obtain.replyTo = new Messenger(this.f24020b);
        try {
            this.f24023e.send(obtain);
        } catch (RemoteException e) {
            m25304a(null);
        }
    }

    protected final void m25306a(Message message) {
        if (message.what == this.f24025g) {
            Bundle data = message.getData();
            if (data.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                m25304a(null);
            } else {
                m25304a(data);
            }
            ServiceConnectionDetour.a(this.f24019a, this, 647742214);
        }
    }

    private void m25304a(Bundle bundle) {
        if (this.f24022d) {
            this.f24022d = false;
            1 1 = this.f24021c;
            if (1 != null) {
                GetTokenLoginMethodHandler getTokenLoginMethodHandler = 1.b;
                Request request = 1.a;
                if (getTokenLoginMethodHandler.c != null) {
                    getTokenLoginMethodHandler.c.f24021c = null;
                }
                getTokenLoginMethodHandler.c = null;
                LoginClient loginClient = getTokenLoginMethodHandler.b;
                if (loginClient.e != null) {
                    loginClient.e.a.findViewById(2131560415).setVisibility(8);
                }
                if (bundle != null) {
                    ArrayList stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
                    Set<String> set = request.b;
                    if (stringArrayList == null || !(set == null || stringArrayList.containsAll(set))) {
                        Object hashSet = new HashSet();
                        for (String str : set) {
                            if (!stringArrayList.contains(str)) {
                                hashSet.add(str);
                            }
                        }
                        if (!hashSet.isEmpty()) {
                            getTokenLoginMethodHandler.a("new_permissions", TextUtils.join(",", hashSet));
                        }
                        Validate.m25366a(hashSet, "permissions");
                        request.b = hashSet;
                    } else {
                        String string = bundle.getString("com.facebook.platform.extra.USER_ID");
                        if (string == null || string.isEmpty()) {
                            getTokenLoginMethodHandler.b.h();
                            Utility.m25337a(bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN"), new 2(getTokenLoginMethodHandler, bundle, request));
                        } else {
                            getTokenLoginMethodHandler.b(request, bundle);
                        }
                    }
                }
                getTokenLoginMethodHandler.b.g();
            }
        }
    }
}
