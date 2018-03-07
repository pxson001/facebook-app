package com.facebook.messaging.payment.prefs;

import android.content.Context;
import android.preference.Preference;
import android.view.View;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PageInfo;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PageInfoModel;
import com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil;
import com.facebook.resources.ui.FbSwitch;
import com.facebook.resources.ui.FbTextView;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: group_conversations */
public class ProtectConversationPayPreference extends Preference implements InjectableComponentWithoutContext {
    @Inject
    public PaymentPinProtocolUtil f13840a;
    @Inject
    @ForUiThread
    public Executor f13841b;
    public View f13842c;
    private FbSwitch f13843d;
    public final String f13844e;
    public boolean f13845f;
    public ListenableFuture<PageInfo> f13846g;

    public static void m14387a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ProtectConversationPayPreference protectConversationPayPreference = (ProtectConversationPayPreference) obj;
        PaymentPinProtocolUtil a = PaymentPinProtocolUtil.m14279a(injectorLike);
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike);
        protectConversationPayPreference.f13840a = a;
        protectConversationPayPreference.f13841b = executor;
    }

    public ProtectConversationPayPreference(Context context, String str, boolean z) {
        super(context);
        Class cls = ProtectConversationPayPreference.class;
        m14387a(this, context);
        setLayoutResource(2130906499);
        this.f13844e = str;
        this.f13845f = z;
    }

    protected void onBindView(View view) {
        Object obj;
        super.onBindView(view);
        this.f13842c = view;
        ((UserTileView) this.f13842c.findViewById(2131561876)).setParams(UserTileViewParams.a(new UserKey(Type.FACEBOOK, this.f13844e), TileBadge.MESSENGER));
        if (this.f13846g == null || this.f13846g.isDone()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            final FbTextView fbTextView = (FbTextView) this.f13842c.findViewById(2131566124);
            this.f13846g = this.f13840a.m14288a(this.f13844e);
            Futures.a(this.f13846g, new FutureCallback<PageInfo>(this) {
                final /* synthetic */ ProtectConversationPayPreference f13839b;

                public void onSuccess(Object obj) {
                    fbTextView.setText(((PageInfoModel) obj).m13680a());
                }

                public void onFailure(Throwable th) {
                }
            }, this.f13841b);
        }
        m14389f();
    }

    private void m14389f() {
        this.f13843d = (FbSwitch) this.f13842c.findViewById(2131566435);
        m14390g();
    }

    public final void m14391c() {
        m14388a(!this.f13845f);
    }

    private void m14388a(boolean z) {
        this.f13845f = z;
        m14390g();
    }

    private void m14390g() {
        this.f13843d.setChecked(this.f13845f);
    }
}
