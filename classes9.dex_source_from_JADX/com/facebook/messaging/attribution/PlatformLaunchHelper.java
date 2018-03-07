package com.facebook.messaging.attribution;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.backgroundtasks.BackgroundTaskManager;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.graphql.calls.ActionInputAction;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attribution.GQLAppAttributionQueryHelper.C08632;
import com.facebook.messaging.attribution.PlatformLaunchDialogHelper.AppScopedIdsDialogVisibility;
import com.facebook.messaging.attribution.PlatformLaunchIntentHelper.Origin;
import com.facebook.messaging.attribution.ReplyTokenHelper.ReplyTokenData;
import com.facebook.messaging.chatheads.detect.ChatHeadsContextDetector;
import com.facebook.messaging.graphql.threads.AppVisibilityQueries.AttributionVisibilityString;
import com.facebook.messaging.model.attribution.AttributionVisibility;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.attribution.ContentAppAttributionFactory;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.platform.MessengerPlatformConfigManager;
import com.facebook.messaging.sharing.mediapreview.MediaCheckHelper;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.ui.dialogs.DialogWindowUtils;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.ui.media.attachments.MediaResourceHelper;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: outbox/# */
public class PlatformLaunchHelper {
    public static final String f7884a = PlatformLaunchHelper.class.toString();
    private final C08791 f7885b = new C08791(this);
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ContentAppAttributionFactory> f7886c = UltralightRuntime.b();
    private final Context f7887d;
    private final GooglePlayIntentHelper f7888e;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<MediaCheckHelper> f7889f = UltralightRuntime.b();
    private final MediaResourceHelper f7890g;
    private final PlatformAttributionLogging f7891h;
    private final MessengerPlatformConfigManager f7892i;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<PlatformLaunchDialogHelper> f7893j = UltralightRuntime.b();
    private final PlatformLaunchIntentHelper f7894k;
    private final PlatformProtocolHelper f7895l;
    private final ReplyTokenHelper f7896m;
    private final Resources f7897n;
    private final SecureContextHelper f7898o;
    private final BackgroundTaskManager f7899p;
    private final PlatformAttributionCounters f7900q;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GQLAppAttributionQueryHelper> f7901r = UltralightRuntime.b();
    private final ErrorDialogs f7902s;
    private final Executor f7903t;
    private final Provider<Boolean> f7904u;
    @Nullable
    public Listener f7905v;

    /* compiled from: outbox/# */
    public class C08791 {
        final /* synthetic */ PlatformLaunchHelper f7874a;

        C08791(PlatformLaunchHelper platformLaunchHelper) {
            this.f7874a = platformLaunchHelper;
        }

        public final void m8095a(MediaResource mediaResource, Intent intent, String str, ThreadKey threadKey, @Nullable ContentAppAttribution contentAppAttribution) {
            if (this.f7874a.f7905v != null) {
                if (contentAppAttribution == null) {
                    contentAppAttribution = ((ContentAppAttributionFactory) this.f7874a.f7886c.get()).a(intent, str);
                }
                this.f7874a.f7905v.m8096a(threadKey, "", ImmutableList.of(mediaResource), contentAppAttribution);
            }
        }
    }

    /* compiled from: outbox/# */
    public interface Listener {
        void m8096a(@Nullable ThreadKey threadKey, String str, List<MediaResource> list, ContentAppAttribution contentAppAttribution);
    }

    private static PlatformLaunchHelper m8103b(InjectorLike injectorLike) {
        PlatformLaunchHelper platformLaunchHelper = new PlatformLaunchHelper(BackgroundTaskManager.a(injectorLike), (Context) injectorLike.getInstance(Context.class), ErrorDialogs.a(injectorLike), GooglePlayIntentHelper.a(injectorLike), MediaResourceHelper.a(injectorLike), MessengerPlatformConfigManager.a(injectorLike), PlatformAttributionCounters.m8075a(injectorLike), PlatformAttributionLogging.m8077a(injectorLike), PlatformLaunchIntentHelper.m8114a(injectorLike), PlatformProtocolHelper.m8118a(injectorLike), ReplyTokenHelper.m8124a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4082));
        platformLaunchHelper.m8101a(IdBasedLazy.a(injectorLike, 7970), IdBasedLazy.a(injectorLike, 8436), IdBasedLazy.a(injectorLike, 7529), IdBasedSingletonScopeProvider.b(injectorLike, 7526));
        return platformLaunchHelper;
    }

    public static PlatformLaunchHelper m8099a(InjectorLike injectorLike) {
        return m8103b(injectorLike);
    }

    @Inject
    public PlatformLaunchHelper(BackgroundTaskManager backgroundTaskManager, Context context, ErrorDialogs errorDialogs, GooglePlayIntentHelper googlePlayIntentHelper, MediaResourceHelper mediaResourceHelper, MessengerPlatformConfigManager messengerPlatformConfigManager, PlatformAttributionCounters platformAttributionCounters, PlatformAttributionLogging platformAttributionLogging, PlatformLaunchIntentHelper platformLaunchIntentHelper, PlatformProtocolHelper platformProtocolHelper, ReplyTokenHelper replyTokenHelper, Resources resources, SecureContextHelper secureContextHelper, Executor executor, Provider<Boolean> provider) {
        this.f7899p = backgroundTaskManager;
        this.f7887d = context;
        this.f7902s = errorDialogs;
        this.f7888e = googlePlayIntentHelper;
        this.f7890g = mediaResourceHelper;
        this.f7892i = messengerPlatformConfigManager;
        this.f7900q = platformAttributionCounters;
        this.f7891h = platformAttributionLogging;
        this.f7894k = platformLaunchIntentHelper;
        this.f7895l = platformProtocolHelper;
        this.f7896m = replyTokenHelper;
        this.f7897n = resources;
        this.f7898o = secureContextHelper;
        this.f7903t = executor;
        this.f7904u = provider;
    }

    public final void m8112a(final String str, final String str2) {
        GQLAppAttributionQueryHelper gQLAppAttributionQueryHelper = (GQLAppAttributionQueryHelper) this.f7901r.get();
        GraphQlQueryString attributionVisibilityString = new AttributionVisibilityString();
        attributionVisibilityString.a("appid", str);
        attributionVisibilityString.a("action", ActionInputAction.INSTALL.toString());
        ListenableFuture a = Futures.a(gQLAppAttributionQueryHelper.f7814a.a(GraphQLRequest.a(attributionVisibilityString).a(GraphQLCachePolicy.c)), new C08632(gQLAppAttributionQueryHelper));
        if (((Boolean) this.f7904u.get()).booleanValue()) {
            ProgressDialog progressDialog = new ProgressDialog(((PlatformLaunchDialogHelper) this.f7893j.get()).f7869c);
            progressDialog.d = 1;
            progressDialog.a(true);
            progressDialog.setCancelable(false);
            progressDialog.a(null);
            progressDialog.a(null);
            DialogWindowUtils.a(progressDialog);
            progressDialog.show();
            final Dialog dialog = progressDialog;
            DialogWindowUtils.a(dialog);
            Futures.a(a, new FutureCallback<AttributionVisibility>(this) {
                final /* synthetic */ PlatformLaunchHelper f7878d;

                public void onSuccess(@Nullable Object obj) {
                    AttributionVisibility attributionVisibility = (AttributionVisibility) obj;
                    dialog.hide();
                    if (attributionVisibility.e) {
                        ((PlatformLaunchDialogHelper) this.f7878d.f7893j.get()).m8093a();
                    } else {
                        PlatformLaunchHelper.m8106b(this.f7878d, str, str2);
                    }
                }

                public void onFailure(Throwable th) {
                    dialog.hide();
                    BLog.b(PlatformLaunchHelper.f7884a, "Fetching app attribution failed.");
                    ((PlatformLaunchDialogHelper) this.f7878d.f7893j.get()).m8093a();
                }
            }, this.f7903t);
            return;
        }
        m8106b(this, str, str2);
    }

    public static void m8106b(PlatformLaunchHelper platformLaunchHelper, String str, String str2) {
        platformLaunchHelper.f7888e.a(platformLaunchHelper.f7887d, str2);
        PlatformAttributionCounters platformAttributionCounters = platformLaunchHelper.f7900q;
        long a = platformAttributionCounters.f7846e.a();
        platformAttributionCounters.f7845d.edit().a(PlatformAttributionCounters.m8076b(str), platformAttributionCounters.f7845d.a(PlatformAttributionCounters.m8076b(str), 0) + 1).a((PrefKey) ((PrefKey) ((PrefKey) PlatformAttributionCounters.f7844c.a(str)).a("/install_launch/")).a("timestamp"), a).a(PlatformAttributionCounters.f7843b, a).commit();
        platformLaunchHelper.f7899p.a();
    }

    public final void m8110a(Message message, Fragment fragment, @Nullable ThreadSummary threadSummary) {
        m8102a(Origin.REPLY_FLOW, message.b, threadSummary, message.a, message.F.b, message.F.e, message.F.f, message.F.g, fragment);
    }

    public final void m8111a(@Nullable ThreadKey threadKey, @Nullable ThreadSummary threadSummary, String str, String str2, String str3, Map<String, String> map, Fragment fragment) {
        m8102a(Origin.COMPOSE_FLOW, threadKey, threadSummary, null, str, str2, str3, map, fragment);
    }

    private void m8102a(Origin origin, ThreadKey threadKey, ThreadSummary threadSummary, @Nullable String str, String str2, String str3, String str4, Map<String, String> map, Fragment fragment) {
        String a = m8100a((Map) map, threadSummary);
        AppScopedIdsDialogVisibility a2 = ((PlatformLaunchDialogHelper) this.f7893j.get()).m8092a(a);
        Intent a3 = m8098a(origin, threadKey, str2, str3, str4, a);
        Intent a4 = m8098a(origin, threadKey, str2, str3, str4, "");
        if (a3 == null || a4 == null) {
            m8112a(str2, str3);
            return;
        }
        m8104b(a4);
        switch (a2) {
            case MUST_SHOW:
                ((PlatformLaunchDialogHelper) this.f7893j.get()).m8094a(m8107c(a3, threadKey, fragment), m8107c(a4, threadKey, fragment), str2, str, fragment);
                return;
            case HIDE_FOR_NOW:
                m8105b(this, a4, threadKey, fragment);
                return;
            case DONT_SHOW:
                m8105b(this, a3, threadKey, fragment);
                return;
            default:
                return;
        }
    }

    public static void m8105b(PlatformLaunchHelper platformLaunchHelper, Intent intent, ThreadKey threadKey, Fragment fragment) {
        try {
            if (intent.hasCategory("android.intent.category.LAUNCHER")) {
                platformLaunchHelper.f7898o.b(intent, platformLaunchHelper.f7887d);
            } else if (ChatHeadsContextDetector.a(platformLaunchHelper.f7887d)) {
                platformLaunchHelper.f7898o.a(platformLaunchHelper.m8097a(intent, threadKey), platformLaunchHelper.f7887d);
            } else {
                platformLaunchHelper.f7898o.b(intent, 1003, fragment);
            }
        } catch (ActivityNotFoundException e) {
            BLog.b(f7884a, "Activity not found for %s", new Object[]{intent});
        }
    }

    @VisibleForTesting
    private static String m8100a(Map<String, String> map, @Nullable ThreadSummary threadSummary) {
        if (threadSummary == null || map.isEmpty()) {
            return "";
        }
        Builder builder = ImmutableSet.builder();
        ImmutableList immutableList = threadSummary.h;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String b = ((ThreadParticipant) immutableList.get(i)).b().b();
            if (b != null) {
                builder.c(b);
            }
        }
        ImmutableSet b2 = builder.b();
        builder = ImmutableSet.builder();
        for (String b3 : map.keySet()) {
            if (b2.contains(b3)) {
                builder.c((String) map.get(b3));
            }
        }
        return Joiner.on(",").join(builder.b());
    }

    public final void m8108a(@Nullable Intent intent, @Nullable ThreadKey threadKey, Fragment fragment) {
        if (intent != null) {
            if (intent.hasExtra("com.facebook.orca.extra.PROTOCOL_VERSION")) {
                String stringExtra;
                switch (intent.getIntExtra("com.facebook.orca.extra.PROTOCOL_VERSION", -1)) {
                    case 20141218:
                        stringExtra = intent.getStringExtra("com.facebook.orca.extra.REPLY_TOKEN");
                        break;
                    case 20150311:
                    case 20150314:
                        stringExtra = intent.getStringExtra("com.facebook.orca.extra.THREAD_TOKEN");
                        break;
                    default:
                        BLog.b(f7884a, "Unsupported protocol version %d", new Object[]{Integer.valueOf(intent.getIntExtra("com.facebook.orca.extra.PROTOCOL_VERSION", -1))});
                        return;
                }
                ReplyTokenData a = this.f7896m.m8129a(stringExtra, intent.getStringExtra("com.facebook.orca.extra.APPLICATION_ID"), threadKey);
                if (a == null) {
                    BLog.b(f7884a, "Failed to verify reply token");
                    return;
                }
                Uri data;
                if (intent.getData() != null) {
                    data = intent.getData();
                } else {
                    data = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
                }
                Uri uri = data;
                if (uri == null) {
                    BLog.b(f7884a, "Missing or malformed uri on reply intent");
                    return;
                }
                String type = intent.getType();
                if (type == null && this.f7890g.a(uri) == null) {
                    BLog.b(f7884a, "Could not get mimeType for %s", new Object[]{uri});
                    return;
                }
                boolean z;
                MediaResourceBuilder a2 = ((MediaCheckHelper) this.f7889f.get()).m17377a(uri, (Uri) intent.getParcelableExtra("com.facebook.orca.extra.EXTERNAL_URI"), type);
                if (a2.b == Type.PHOTO && intent.getBooleanExtra("com.facebook.orca.extra.RENDER_AS_STICKER", false)) {
                    z = true;
                } else {
                    z = false;
                }
                a2.z = z;
                MediaResource C = a2.C();
                if (C == null) {
                    BLog.b(f7884a, "Could not get media resource for uri %s", new Object[]{uri});
                    this.f7902s.a(ErrorDialogParams.a(this.f7897n).a(2131240034).b(2131240035).l());
                    return;
                }
                String str = a.f7913b;
                String str2 = a.f7914c;
                InlineReplyFragment inlineReplyFragment = new InlineReplyFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("media_resource", C);
                bundle.putString("app_id", str);
                bundle.putString("app_package", str2);
                bundle.putParcelable("reply_intent", intent);
                bundle.putParcelable("thread_key", threadKey);
                bundle.putBoolean("is_platform_instance", true);
                inlineReplyFragment.g(bundle);
                Fragment fragment2 = inlineReplyFragment;
                fragment.D.a().a(fragment2, "inline_reply_fragment").c();
                fragment2.aM = this.f7885b;
                this.f7891h.m8082a(a.f7913b);
                return;
            }
            BLog.b(f7884a, "Couldn't find protocol version in reply intent");
        }
    }

    private void m8101a(com.facebook.inject.Lazy<ContentAppAttributionFactory> lazy, com.facebook.inject.Lazy<MediaCheckHelper> lazy2, com.facebook.inject.Lazy<PlatformLaunchDialogHelper> lazy3, com.facebook.inject.Lazy<GQLAppAttributionQueryHelper> lazy4) {
        this.f7886c = lazy;
        this.f7889f = lazy2;
        this.f7893j = lazy3;
        this.f7901r = lazy4;
    }

    private OnClickListener m8107c(final Intent intent, final ThreadKey threadKey, final Fragment fragment) {
        return new OnClickListener(this) {
            final /* synthetic */ PlatformLaunchHelper f7882d;

            public void onClick(DialogInterface dialogInterface, int i) {
                PlatformLaunchHelper.m8105b(this.f7882d, intent, threadKey, fragment);
            }
        };
    }

    @Nullable
    private Intent m8098a(Origin origin, @Nullable ThreadKey threadKey, String str, String str2, String str3, String str4) {
        if (this.f7892i.a(20150314) && this.f7895l.m8121a(str2)) {
            return this.f7894k.m8117b(origin, threadKey, str, str2, str3, str4);
        }
        if (this.f7892i.a(20150311) && this.f7895l.m8122b(str2)) {
            return this.f7894k.m8115a(origin, threadKey, str, str2, str3, str4);
        }
        if (this.f7892i.a(20141218) && this.f7895l.m8123c(str2)) {
            return this.f7894k.m8116a(threadKey, str, str2, str3, str4);
        }
        Intent launchIntentForPackage = this.f7894k.f7907a.getPackageManager().getLaunchIntentForPackage(str2);
        if (launchIntentForPackage == null) {
            launchIntentForPackage = null;
        } else {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        return launchIntentForPackage;
    }

    private Intent m8097a(Intent intent, ThreadKey threadKey) {
        Preconditions.checkState(ChatHeadsContextDetector.a(this.f7887d));
        Intent intent2 = new Intent(this.f7887d, ChatHeadsReplyFlowHandlerActivity.class);
        intent2.putExtra("external_intent", intent);
        intent2.putExtra("thread_key", threadKey);
        return intent2;
    }

    private static void m8104b(Intent intent) {
        if (intent.hasExtra("al_applink_data")) {
            Preconditions.checkState(Strings.isNullOrEmpty(intent.getBundleExtra("al_applink_data").getBundle("extras").getString("com.facebook.orca.extra.PARTICIPANTS")));
        }
    }

    public final void m8109a(Fragment fragment) {
        InlineReplyFragment inlineReplyFragment = (InlineReplyFragment) fragment.D.a("inline_reply_fragment");
        if (inlineReplyFragment != null) {
            inlineReplyFragment.aM = this.f7885b;
        }
    }
}
