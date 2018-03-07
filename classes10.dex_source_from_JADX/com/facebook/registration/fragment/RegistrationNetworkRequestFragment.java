package com.facebook.registration.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.registration.model.RegError;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: last_geofence_flushed_server_request_sent */
public abstract class RegistrationNetworkRequestFragment extends RegistrationFragment {
    @Nullable
    public SelfRegistrableReceiverImpl al;
    @Inject
    public TasksManager ap;
    @Inject
    public FbNetworkManager aq;
    @Inject
    public NetworkMonitor ar;
    @Inject
    public Lazy<FbObjectMapper> as;
    private TextView f8806b;
    private TextView f8807c;
    private TextView f8808d;
    private TextView f8809e;
    private View f8810f;
    private View f8811g;
    public int f8812h = 0;
    public boolean f8813i = false;

    /* compiled from: last_geofence_flushed_server_request_sent */
    class C13441 implements OnClickListener {
        final /* synthetic */ RegistrationNetworkRequestFragment f8863a;

        C13441(RegistrationNetworkRequestFragment registrationNetworkRequestFragment) {
            this.f8863a = registrationNetworkRequestFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1679535517);
            this.f8863a.at();
            Logger.a(2, EntryType.UI_INPUT_END, 700963398, a);
        }
    }

    /* compiled from: last_geofence_flushed_server_request_sent */
    class C13452 implements OnClickListener {
        final /* synthetic */ RegistrationNetworkRequestFragment f8864a;

        C13452(RegistrationNetworkRequestFragment registrationNetworkRequestFragment) {
            this.f8864a = registrationNetworkRequestFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -795218854);
            this.f8864a.ay();
            RegistrationNetworkRequestFragment registrationNetworkRequestFragment = this.f8864a;
            registrationNetworkRequestFragment.f8812h++;
            Logger.a(2, EntryType.UI_INPUT_END, -1117942414, a);
        }
    }

    /* compiled from: last_geofence_flushed_server_request_sent */
    class C13463 extends TypeReference<Map<String, String>> {
        final /* synthetic */ RegistrationNetworkRequestFragment f8865b;

        C13463(RegistrationNetworkRequestFragment registrationNetworkRequestFragment) {
            this.f8865b = registrationNetworkRequestFragment;
        }
    }

    /* compiled from: last_geofence_flushed_server_request_sent */
    public class C13474 implements Runnable {
        final /* synthetic */ RegistrationNetworkRequestFragment f8866a;

        public C13474(RegistrationNetworkRequestFragment registrationNetworkRequestFragment) {
            this.f8866a = registrationNetworkRequestFragment;
        }

        public void run() {
            if (this.f8866a.f8813i) {
                this.f8866a.ay();
            }
        }
    }

    public static void m8803a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RegistrationNetworkRequestFragment registrationNetworkRequestFragment = (RegistrationNetworkRequestFragment) obj;
        TasksManager b = TasksManager.b(fbInjector);
        FbNetworkManager a = FbNetworkManager.a(fbInjector);
        NetworkMonitor a2 = NetworkMonitor.a(fbInjector);
        Lazy b2 = IdBasedSingletonScopeProvider.b(fbInjector, 572);
        registrationNetworkRequestFragment.ap = b;
        registrationNetworkRequestFragment.aq = a;
        registrationNetworkRequestFragment.ar = a2;
        registrationNetworkRequestFragment.as = b2;
    }

    protected abstract int as();

    protected abstract void at();

    protected abstract void au();

    public void mo403c(Bundle bundle) {
        super.c(bundle);
        Class cls = RegistrationNetworkRequestFragment.class;
        m8803a((Object) this, getContext());
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 540394663);
        this.ap.c();
        m8807b(false);
        if (this.al != null) {
            this.al.c();
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1613647852, a);
    }

    protected final void mo383b(View view, Bundle bundle) {
        KeyboardUtils.a(getContext(), view);
        this.f8806b = (TextView) FindViewUtil.b(view, 2131559631);
        this.f8807c = (TextView) FindViewUtil.b(view, 2131564175);
        this.f8809e = (TextView) FindViewUtil.b(view, 2131566935);
        this.f8810f = FindViewUtil.b(view, 2131560576);
        this.f8808d = (TextView) FindViewUtil.b(view, 2131566936);
        this.f8811g = FindViewUtil.b(view, 2131566934);
        this.f8809e.setText(as());
        this.f8808d.setText(2131239848);
        this.f8808d.setOnClickListener(new C13441(this));
        FindViewUtil.b(view, 2131563533).setOnClickListener(new C13452(this));
        this.al = this.ar.a(State.CONNECTED, new C13474(this));
        ay();
    }

    protected final int aq() {
        return 2130906811;
    }

    @Nullable
    protected final RegError m8808a(ServiceException serviceException) {
        ApiErrorResult b = m8806b(serviceException);
        if (b == null) {
            return null;
        }
        String c;
        Map map = (Map) m8809a(new C13463(this), serviceException);
        if (map == null || !map.containsKey("error_message")) {
            c = b.c();
        } else {
            c = (String) map.get("error_message");
        }
        return new RegError(b.a(), c);
    }

    @Nullable
    private static ApiErrorResult m8806b(ServiceException serviceException) {
        OperationResult operationResult = serviceException.result;
        if (operationResult == null) {
            return null;
        }
        Bundle bundle = operationResult.d;
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get("result");
        if (obj instanceof ApiErrorResult) {
            return (ApiErrorResult) obj;
        }
        return null;
    }

    @Nullable
    protected final <T> T m8809a(TypeReference<T> typeReference, ServiceException serviceException) {
        ApiErrorResult b = m8806b(serviceException);
        if (b == null) {
            return null;
        }
        Object d = b.d();
        if (StringUtil.a(d)) {
            return null;
        }
        try {
            return ((FbObjectMapper) this.as.get()).a(d, typeReference);
        } catch (IOException e) {
            return null;
        }
    }

    protected final void av() {
        if (this.aq.d()) {
            m8801a(2131230761, 2131230759);
        } else {
            m8801a(2131230763, 2131230759);
        }
    }

    private void m8801a(int i, int i2) {
        m8804a(b(i), b(i2));
    }

    private void m8804a(String str, String str2) {
        m8805a(true);
        this.f8807c.setText(str);
        this.f8806b.setText(str2);
    }

    private void ay() {
        m8805a(false);
        au();
    }

    private void m8805a(boolean z) {
        if (z) {
            m8807b(false);
            this.f8810f.setVisibility(0);
            this.f8811g.setVisibility(8);
            this.f8813i = true;
            if (this.f8812h > 0) {
                this.f8808d.setVisibility(0);
                return;
            } else {
                this.f8808d.setVisibility(4);
                return;
            }
        }
        m8807b(true);
        this.f8810f.setVisibility(8);
        this.f8811g.setVisibility(0);
        this.f8813i = false;
    }

    private void m8807b(boolean z) {
        if (z) {
            o().getWindow().addFlags(128);
        } else {
            o().getWindow().clearFlags(128);
        }
    }
}
