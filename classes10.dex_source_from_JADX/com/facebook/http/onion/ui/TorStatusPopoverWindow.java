package com.facebook.http.onion.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.http.onion.TorProxy;
import com.facebook.http.onion.TorProxy.ConnectionState;
import com.facebook.http.onion.TorProxy.State;
import com.facebook.http.onion.TorProxy.TorListener;
import com.facebook.http.onion.TorProxyMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: viewer_latitude */
public class TorStatusPopoverWindow extends PopoverWindow implements TorListener, InjectableComponentWithContext {
    @Inject
    public TorProxy f374a;
    public TextView f375l;
    public TextView f376m;
    public View f377n;

    /* compiled from: viewer_latitude */
    public class C00651 implements OnClickListener {
        final /* synthetic */ TorStatusPopoverWindow f373a;

        public C00651(TorStatusPopoverWindow torStatusPopoverWindow) {
            this.f373a = torStatusPopoverWindow;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1034220110);
            this.f373a.l();
            Logger.a(2, EntryType.UI_INPUT_END, 1363792104, a);
        }
    }

    public static void m508a(Object obj, Context context) {
        ((TorStatusPopoverWindow) obj).f374a = TorProxyMethodAutoProvider.b(FbInjector.get(context));
    }

    public TorStatusPopoverWindow(Context context) {
        super(context);
        Class cls = TorStatusPopoverWindow.class;
        m508a((Object) this, getContext());
        View inflate = LayoutInflater.from(getContext()).inflate(2130904264, null, false);
        d(inflate);
        this.f375l = (TextView) inflate.findViewById(2131561816);
        this.f376m = (TextView) inflate.findViewById(2131561817);
        this.f377n = inflate.findViewById(2131559623);
        inflate.findViewById(2131561818).setOnClickListener(new C00651(this));
        a(Position.CENTER);
        d(true);
        this.w = false;
        this.x = false;
        this.f374a.a(this);
    }

    public final void m511l() {
        super.l();
        this.f374a.b(this);
    }

    public final void m509a() {
    }

    public final void m510a(State state, ConnectionState connectionState) {
        int i = 0;
        int i2 = 2131233715;
        if (state != null) {
            i2 = state.resId;
        }
        int i3 = 2131233715;
        if (connectionState != null) {
            i3 = connectionState.resId;
        }
        Context context = getContext();
        this.f375l.setText("Orbot: " + context.getString(i2));
        this.f376m.setText("Tor: " + context.getString(i3));
        if (state.isComplete() && (connectionState == null || connectionState.isComplete())) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        View view = this.f377n;
        if (i2 != 0) {
            i = 8;
        }
        view.setVisibility(i);
    }
}
