package com.facebook.profile.inforequest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelUuid;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.graphql.enums.GraphQLInfoRequestFieldType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.profile.inforequest.event.InfoRequestEventBus;
import com.facebook.profile.inforequest.event.InfoRequestEvents.InfoRequestSentNavigationEvent;
import com.facebook.profile.inforequest.services.InfoRequestHelper;
import com.facebook.profile.inforequest.services.InfoRequestHelper.Callback;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Strings;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: localsell_composer */
public class InfoRequestFragment extends FbFragment {
    @Inject
    public DefaultBlueServiceOperationFactory f8558a;
    public Handler al = new Handler();
    public Runnable am = new C12711(this);
    public Callback an = new C12722(this);
    @Inject
    public InfoRequestEventBus f8559b;
    @Inject
    public InputMethodManager f8560c;
    @Inject
    @ForUiThread
    public Executor f8561d;
    public TextView f8562e;
    public View f8563f;
    public View f8564g;
    public EditText f8565h;
    public ParcelUuid f8566i;

    /* compiled from: localsell_composer */
    class C12711 implements Runnable {
        final /* synthetic */ InfoRequestFragment f8549a;

        C12711(InfoRequestFragment infoRequestFragment) {
            this.f8549a = infoRequestFragment;
        }

        public void run() {
            Activity ao = this.f8549a.ao();
            if (ao != null) {
                this.f8549a.f8560c.hideSoftInputFromWindow(this.f8549a.f8565h.getWindowToken(), 0);
                ao.onBackPressed();
            }
        }
    }

    /* compiled from: localsell_composer */
    class C12722 implements Callback {
        final /* synthetic */ InfoRequestFragment f8550a;

        C12722(InfoRequestFragment infoRequestFragment) {
            this.f8550a = infoRequestFragment;
        }

        public final void mo375a() {
            m8467a(2131241378);
            HandlerDetour.b(this.f8550a.al, this.f8550a.am, 1000, -561112230);
        }

        public final void mo376b() {
            if (this.f8550a.f8566i != null) {
                this.f8550a.f8559b.a(new InfoRequestSentNavigationEvent(this.f8550a.f8566i));
            }
            m8467a(2131241377);
            HandlerDetour.b(this.f8550a.al, this.f8550a.am, 1000, -215324164);
        }

        private void m8467a(int i) {
            Context context = this.f8550a.getContext();
            if (context != null) {
                this.f8550a.f8564g.setVisibility(8);
                this.f8550a.f8562e.setText(context.getResources().getString(i));
                this.f8550a.f8562e.setTypeface(null, 1);
            }
        }
    }

    private static <T extends InjectableComponentWithContext> void m8470a(Class<T> cls, T t) {
        m8471a((Object) t, t.getContext());
    }

    private static void m8471a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        InfoRequestFragment infoRequestFragment = (InfoRequestFragment) obj;
        DefaultBlueServiceOperationFactory b = DefaultBlueServiceOperationFactory.b(fbInjector);
        InfoRequestEventBus a = InfoRequestEventBus.m8477a(fbInjector);
        InputMethodManager b2 = InputMethodManagerMethodAutoProvider.b(fbInjector);
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector);
        infoRequestFragment.f8558a = b;
        infoRequestFragment.f8559b = a;
        infoRequestFragment.f8560c = b2;
        infoRequestFragment.f8561d = executor;
    }

    public final View m8472a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 620099424);
        Bundle mt_ = mt_();
        m8470a(InfoRequestFragment.class, (InjectableComponentWithContext) this);
        View inflate = layoutInflater.inflate(2130904896, viewGroup, false);
        final String string = mt_.getString("profile_id");
        final GraphQLInfoRequestFieldType graphQLInfoRequestFieldType = (GraphQLInfoRequestFieldType) mt_.getSerializable("info_request_type");
        String string2 = mt_.getString("profile_name");
        this.f8566i = (ParcelUuid) mt_.getParcelable("arg_parent_fragment_id");
        TextView textView = (TextView) inflate.findViewById(2131563124);
        this.f8565h = (EditText) inflate.findViewById(2131563125);
        final Button button = (Button) inflate.findViewById(2131563126);
        TextView textView2 = (TextView) inflate.findViewById(2131563130);
        this.f8562e = (TextView) inflate.findViewById(2131563129);
        this.f8563f = inflate.findViewById(2131563127);
        this.f8564g = inflate.findViewById(2131563128);
        if (Strings.isNullOrEmpty(string2)) {
            textView.setText(jW_().getString(2131241372));
        } else {
            textView.setText(StringLocaleUtil.a(jW_().getString(2131241373), new Object[]{string2}));
        }
        this.f8565h.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ InfoRequestFragment f8552b;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                button.setEnabled(charSequence.length() > 0);
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        final String string3 = jW_().getString(2131241376);
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ InfoRequestFragment f8557e;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1317333260);
                InfoRequestHelper.m8494a(graphQLInfoRequestFieldType, string, this.f8557e.f8565h.getText().toString(), this.f8557e.f8558a, this.f8557e.an, this.f8557e.f8561d);
                this.f8557e.f8565h.setEnabled(false);
                this.f8557e.f8565h.setFocusable(false);
                button.setVisibility(8);
                this.f8557e.f8563f.setVisibility(0);
                this.f8557e.f8562e.setText(string3);
                Logger.a(2, EntryType.UI_INPUT_END, -158701897, a);
            }
        });
        if (Strings.isNullOrEmpty(string2)) {
            textView2.setText(jW_().getString(2131241379));
        } else {
            textView2.setText(StringLocaleUtil.a(jW_().getString(2131241380), new Object[]{string2}));
        }
        LogUtils.f(-751461913, a);
        return inflate;
    }
}
