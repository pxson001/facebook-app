package com.facebook.fbreact.privacy;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.enums.GraphQLEditablePrivacyScopeType;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.privacy.checkup.manager.IDBackedPrivacyCheckupManager;
import com.facebook.privacy.protocol.EditObjectsPrivacyParams.ObjectPrivacyEdit;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: error_info */
public class PrivacyCheckupReactModule extends ReactContextBaseJavaModule {
    public final IDBackedPrivacyCheckupManager f7468a;
    private final ViewerContext f7469b;
    private final Clock f7470c;
    private final ComposerLauncher f7471d;

    @Inject
    public PrivacyCheckupReactModule(ViewerContext viewerContext, IDBackedPrivacyCheckupManager iDBackedPrivacyCheckupManager, Clock clock, ComposerLauncher composerLauncher, @Assisted ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.f7469b = viewerContext;
        this.f7468a = iDBackedPrivacyCheckupManager;
        this.f7470c = clock;
        this.f7471d = composerLauncher;
    }

    public String getName() {
        return "PrivacyCheckupReactModule";
    }

    public final Map<String, Object> m8643a() {
        return new HashMap();
    }

    @ReactMethod
    public void sendPrivacyEdits(ReadableArray readableArray, final Callback callback, final Callback callback2) {
        Builder builder = new Builder();
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap b = readableArray.b(i);
            String string = b.getString("legacy_graph_api_privacy_json");
            builder.c(new ObjectPrivacyEdit(b.getString("fbid"), this.f7470c.a(), GraphQLEditablePrivacyScopeType.fromString(b.getString("fbid_type")), string));
        }
        final ImmutableList b2 = builder.b();
        this.a.a(new Runnable(this) {
            final /* synthetic */ PrivacyCheckupReactModule f7467d;

            /* compiled from: error_info */
            class C09421 extends AbstractDisposableFutureCallback<OperationResult> {
                final /* synthetic */ C09431 f7463a;

                C09421(C09431 c09431) {
                    this.f7463a = c09431;
                }

                protected final void m8640a(Object obj) {
                    callback.a(new Object[]{"SUCCESS"});
                }

                protected final void m8641a(Throwable th) {
                    callback2.a(new Object[]{"FAILURE"});
                }
            }

            public void run() {
                this.f7467d.f7468a.m11324a("id_backed_privacy_checkup", b2, new C09421(this));
            }
        });
    }

    @ReactMethod
    public void share(String str) {
        this.f7471d.a(null, ComposerConfigurationFactory.a(ComposerSourceType.STORY_CALL_TO_ACTION, ComposerShareParams.Builder.a(str).b()).setIsEditTagEnabled(false).setDisableFriendTagging(true).setDisableMentions(true).a(), 1756, q());
    }
}
