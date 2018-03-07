package com.facebook.messaging.bball;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.auth.module.User_LoggedInUserMethodAutoProvider;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.bball.BballGameAnalyticsLogger.FinishParams;
import com.facebook.messaging.bball.BballGameAnalyticsLogger.FinishParams.Builder;
import com.facebook.messaging.bball.BballView.Listener;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.chatheads.detect.ChatHeadsContextDetector;
import com.facebook.messaging.chatheads.ipc.ChatHeadsIntent;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadGameData;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.neue.activitybridge.NeueActivityBridge;
import com.facebook.messaging.neue.activitybridge.NeueActivityBridgeMethodAutoProvider;
import com.facebook.messaging.service.model.PostGameScoreParams;
import com.facebook.messaging.service.model.PostGameScoreParamsBuilder;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.User;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: openForRead */
public class BballActivity extends FbFragmentActivity {
    private static final String f8135v = (BballActivity.class.getName() + ".");
    private static final String f8136w = (f8135v + "THREAD_KEY");
    private static final String f8137x = (f8135v + "USE_CHAT_HEADS");
    private ThreadKey f8138A;
    private Builder f8139B;
    @Inject
    BballGameAnalyticsLogger f8140p;
    @Inject
    DataCache f8141q;
    @Inject
    NeueActivityBridge f8142r;
    @Inject
    PostGameScoreHelper f8143s;
    @Inject
    SecureContextHelper f8144t;
    @Inject
    @LoggedInUser
    User f8145u;
    private BballView f8146y;
    private int f8147z;

    /* compiled from: openForRead */
    class C09181 implements Listener {
        final /* synthetic */ BballActivity f8134a;

        C09181(BballActivity bballActivity) {
            this.f8134a = bballActivity;
        }

        public final void mo300a() {
            BballActivity.m8391i(this.f8134a);
        }
    }

    private static <T extends Context> void m8389a(Class<T> cls, T t) {
        m8390a((Object) t, (Context) t);
    }

    public static void m8390a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BballActivity) obj).m8388a(BballGameAnalyticsLogger.m8409b(fbInjector), DataCache.a(fbInjector), NeueActivityBridgeMethodAutoProvider.m13094a(fbInjector), new PostGameScoreHelper(DefaultBlueServiceOperationFactory.b(fbInjector)), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), User_LoggedInUserMethodAutoProvider.b(fbInjector));
    }

    private void m8388a(BballGameAnalyticsLogger bballGameAnalyticsLogger, DataCache dataCache, NeueActivityBridge neueActivityBridge, PostGameScoreHelper postGameScoreHelper, SecureContextHelper secureContextHelper, User user) {
        this.f8140p = bballGameAnalyticsLogger;
        this.f8141q = dataCache;
        this.f8142r = neueActivityBridge;
        this.f8143s = postGameScoreHelper;
        this.f8144t = secureContextHelper;
        this.f8145u = user;
    }

    public static Intent m8386a(Context context, ThreadKey threadKey) {
        Intent intent = new Intent(context, BballActivity.class);
        intent.putExtra(f8136w, threadKey);
        intent.putExtra(f8137x, ChatHeadsContextDetector.a(context));
        return intent;
    }

    protected final void m8393b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = BballActivity.class;
        m8390a((Object) this, (Context) this);
        setContentView(2130905310);
        this.f8146y = (BballView) a(2131563943);
        this.f8146y.f8214I = new C09181(this);
        this.f8138A = (ThreadKey) getIntent().getParcelableExtra(f8136w);
        ThreadSummary a = this.f8141q.a(this.f8138A);
        if (a == null) {
            finish();
            return;
        }
        Builder builder = new Builder();
        builder.f8156a = this.f8138A;
        this.f8139B = builder;
        ThreadGameData threadGameData = (ThreadGameData) a.N.get("basketball");
        if (threadGameData != null) {
            this.f8146y.m8471a(threadGameData.a, threadGameData.b);
            this.f8147z = threadGameData.b;
            this.f8139B.f8158c = this.f8145u.a.equals(threadGameData.a);
        }
        setVolumeControlStream(3);
    }

    public void onBackPressed() {
        m8391i(this);
    }

    public static void m8391i(BballActivity bballActivity) {
        boolean z;
        int i = bballActivity.f8146y.f8213H;
        int i2 = bballActivity.f8146y.m8472a() ? -Math.abs(i) : i;
        BballGameAnalyticsLogger bballGameAnalyticsLogger = bballActivity.f8140p;
        Builder builder = bballActivity.f8139B;
        builder.f8157b = i2;
        builder = builder;
        if (i > bballActivity.f8147z) {
            z = true;
        } else {
            z = false;
        }
        builder.f8159d = z;
        Builder builder2 = builder;
        builder2.f8160e = bballActivity.f8146y.getAttemptCount();
        FinishParams finishParams = new FinishParams(builder2);
        bballGameAnalyticsLogger.f8166a.a(BballGameAnalyticsLogger.m8407a("msgr_bball_end").b("thread_key", finishParams.f8161a.h()).a("best_score", finishParams.f8162b).a("had_high_score", finishParams.f8163c).a("beat_high_score", finishParams.f8164d).a("attempts", finishParams.f8165e));
        if (i > 0) {
            PostGameScoreHelper postGameScoreHelper = bballActivity.f8143s;
            PostGameScoreParamsBuilder postGameScoreParamsBuilder = new PostGameScoreParamsBuilder();
            postGameScoreParamsBuilder.f17261a = bballActivity.f8138A;
            postGameScoreParamsBuilder = postGameScoreParamsBuilder;
            postGameScoreParamsBuilder.f17263c = "basketball";
            postGameScoreParamsBuilder = postGameScoreParamsBuilder;
            postGameScoreParamsBuilder.f17264d = i;
            PostGameScoreParams postGameScoreParams = new PostGameScoreParams(postGameScoreParamsBuilder);
            Bundle bundle = new Bundle();
            bundle.putParcelable(PostGameScoreParams.f17256a, postGameScoreParams);
            BlueServiceOperationFactoryDetour.a(postGameScoreHelper.f8240b, "post_game_score", bundle, ErrorPropagation.BY_EXCEPTION, PostGameScoreHelper.f8239a, -2001255265).b();
        }
        if (bballActivity.getIntent().getBooleanExtra(f8137x, false)) {
            bballActivity.m8392j();
        }
        bballActivity.finish();
    }

    private void m8392j() {
        this.f8144t.c(this.f8142r.m13093a().setAction(ChatHeadsIntent.d).putExtra(ChatHeadsIntent.r, this.f8138A.toString()).putExtra(ChatHeadsIntent.o, "from_game").putExtra(ChatHeadsIntent.m, this.f8145u), this);
    }
}
