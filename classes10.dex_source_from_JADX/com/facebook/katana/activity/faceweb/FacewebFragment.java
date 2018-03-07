package com.facebook.katana.activity.faceweb;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.InteractionLogger.ContentFlags;
import com.facebook.analytics.impression.ImpressionManager;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.bugreporter.activity.FragmentWithDebugInfo;
import com.facebook.common.activity.IFbMainTabActivity;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.config.server.NetworkLogUrl;
import com.facebook.confirmation.task.BackgroundConfirmationHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.asserts.Assert;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.growth.model.Contactpoint;
import com.facebook.growth.util.DeviceContactpointUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.SharePreview;
import com.facebook.ipc.composer.launch.ComposerIntentLauncher;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.katana.activity.FacebookActivity;
import com.facebook.katana.activity.faceweb.FacewebAssassin.AssassinFilter;
import com.facebook.katana.activity.faceweb.NegativeFeedbackFacewebController.C01351;
import com.facebook.katana.activity.faceweb.dialog.FacewebActionSheetDialogFragment;
import com.facebook.katana.activity.faceweb.dialog.FeedFilterPickerDialogFragment;
import com.facebook.katana.activity.profilelist.FriendMultiSelectorActivity;
import com.facebook.katana.constants.Constants.URL;
import com.facebook.katana.fragment.BaseFacebookFragment;
import com.facebook.katana.fragment.dialog.AlertDialogFragment;
import com.facebook.katana.login.LoginActivityHelper;
import com.facebook.katana.service.AppSession;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.katana.urimap.IntentHandlerUtil;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.webview.FacewebWebView;
import com.facebook.katana.webview.RefreshableFacewebWebViewContainer;
import com.facebook.katana.webview.RefreshableFacewebWebViewContainer.ContentState;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.photos.galleryutil.GlobalOnLayoutHelper;
import com.facebook.places.checkin.ipc.CheckinIntentCreator;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBar.OnActionButtonClickListener;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.ui.toaster.Toaster;
import com.facebook.universalfeedback.UniversalFeedbackController;
import com.facebook.webview.FacebookWebView;
import com.facebook.webview.FacebookWebView.FileChooser;
import com.facebook.webview.FacebookWebView.JsReturnHandler;
import com.facebook.webview.FacebookWebView.NativeCallHandler;
import com.facebook.webview.FacebookWebView.NativeUICallHandler;
import com.facebook.webview.FacewebPalCall;
import com.facebook.webview.handler.LaunchApplicationHandler;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: use_thread_transition */
public class FacewebFragment extends BaseFacebookFragment implements AnalyticsFragmentWithExtraData, FragmentWithDebugInfo {
    public static final Set<String> aV;
    public static final HashSet<String> aW = new HashSet();
    private static final Pattern f840c = Pattern.compile("/groups/[^/]+/?");
    @Inject
    public Lazy<Fb4aUriIntentMapper> f841a;
    private FeedFilterPickerHandler aA;
    public boolean aB;
    public boolean aC;
    private AppSession aD;
    public String aE;
    public String aF;
    public boolean aG;
    public String aH;
    public MonotonicClock aI;
    public boolean aJ;
    public InteractionLogger aK;
    public ImpressionManager aL;
    public Fb4aTitleBarSupplier aM;
    public ScheduledExecutorService aN;
    public BaseFbBroadcastManager aO;
    public ComposerIntentLauncher aP;
    public ComposerLauncher aQ;
    public NegativeFeedbackFacewebController aR;
    public JSONObject[] aS = null;
    private long aT = -1;
    public Map<String, String> aU = new HashMap();
    private PerformanceLogger aX;
    public View aY;
    private final ShowShareComposerHandler al = new ShowShareComposerHandler(this, this.f843d);
    public long am = -1;
    public FacewebWebView an;
    public AbstractFbErrorReporter ao;
    public ValueCallback<Uri> ap;
    public ValueCallback<Uri[]> aq;
    private String ar;
    private OnClickListener as;
    public RefreshableFacewebWebViewContainer at = null;
    private long au = -1;
    public long av = 0;
    public JsonFactory aw;
    public PrimaryActionDisplayType ax = PrimaryActionDisplayType.TITLE_BUTTON;
    public PrimaryActionMenuItem ay = null;
    public String az;
    @Inject
    public Lazy<SecureContextHelper> f842b;
    private final Handler f843d = new Handler();
    public int f844e = 0;
    public final SetBookmarksMenuButton f845f = new SetBookmarksMenuButton(this, this.f843d);
    public final SetToolbarSegmentsHandler f846g = new SetToolbarSegmentsHandler(this, this.f843d);
    public final ShowCommentPublisherHandler f847h = new ShowCommentPublisherHandler(this, this.f843d);
    public final ShowReplyPublisherHandler f848i = new ShowReplyPublisherHandler(this, this.f843d);

    /* compiled from: use_thread_transition */
    class C01111 implements AssassinFilter {
        final /* synthetic */ FacewebFragment f745a;

        C01111(FacewebFragment facewebFragment) {
            this.f745a = facewebFragment;
        }

        public final boolean mo27a(int i) {
            return i > 3;
        }

        public final boolean mo28a(long j) {
            return j > 35000;
        }
    }

    /* compiled from: use_thread_transition */
    public class C01122 {
        public final /* synthetic */ FacewebFragment f746a;

        C01122(FacewebFragment facewebFragment) {
            this.f746a = facewebFragment;
        }
    }

    /* compiled from: use_thread_transition */
    class C01133 extends TimerTask {
        final /* synthetic */ FacewebFragment f747a;

        C01133(FacewebFragment facewebFragment) {
            this.f747a = facewebFragment;
        }

        public void run() {
            this.f747a.ao.a("www_mobile_redirect", this.f747a.aE + " did not redirect to m web");
        }
    }

    /* compiled from: use_thread_transition */
    class C01155 implements NativeCallHandler {
        final /* synthetic */ FacewebFragment f751a;

        C01155(FacewebFragment facewebFragment) {
            this.f751a = facewebFragment;
        }

        public final void m757a(Context context, FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            this.f751a.aC = true;
        }
    }

    /* compiled from: use_thread_transition */
    public class C01209 implements FileChooser {
        final /* synthetic */ FacewebFragment f758a;

        public C01209(FacewebFragment facewebFragment) {
            this.f758a = facewebFragment;
        }

        public final void m760a(ValueCallback<Uri> valueCallback) {
            m763b(valueCallback, "");
        }

        public final void m761a(ValueCallback<Uri> valueCallback, String str) {
            m763b(valueCallback, str);
        }

        public final void m763b(ValueCallback<Uri> valueCallback, String str) {
            this.f758a.ap = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(str);
            this.f758a.a(Intent.createChooser(intent, this.f758a.b(2131236492)), 12);
        }

        public final boolean m762a(ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
            if (this.f758a.aq != null) {
                this.f758a.aq.onReceiveValue(null);
                this.f758a.aq = null;
            }
            this.f758a.aq = valueCallback;
            try {
                this.f758a.a(fileChooserParams.createIntent(), 13);
                return true;
            } catch (ActivityNotFoundException e) {
                this.f758a.aq = null;
                Toast.makeText(this.f758a.getContext(), "Cannot open file chooser", 1).show();
                return false;
            }
        }
    }

    /* compiled from: use_thread_transition */
    public class AddNativeEventListenerHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f759b;

        public final void m764a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            String a = facewebPalCall.a(facebookWebView.k, "callback");
            String a2 = facewebPalCall.a(facebookWebView.k, "event");
            if (a2 == null || a == null) {
                BLog.b(this.f759b.ar(), "Could not register native event listener: event=" + a2 + " callback=" + a);
            } else if (FacewebFragment.aV.contains(a2)) {
                this.f759b.aU.put(a2, a);
            } else {
                BLog.a(this.f759b.ar(), "Ignoring unknown event listener type " + a2);
            }
        }

        public AddNativeEventListenerHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f759b = facewebFragment;
            super(handler);
        }
    }

    /* compiled from: use_thread_transition */
    class BackgroundConfirmationAddPendingContactpointHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f760b;

        public BackgroundConfirmationAddPendingContactpointHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f760b = facewebFragment;
            super(handler);
        }

        public final void m765a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            Contactpoint contactpoint = null;
            try {
                contactpoint = (Contactpoint) ((ObjectMapper) FbObjectMapperMethodAutoProvider.a(this.f760b.an())).a(facewebPalCall.a(facebookWebView.getMobilePage(), "contactpoint"), Contactpoint.class);
            } catch (Exception e) {
                this.f760b.ao.a("fb4a_backgroundConfirmationAddPendingContactpoint", "Failed to parse argument contactpoint");
            }
            BackgroundConfirmationHelper.b(this.f760b.an()).a(contactpoint);
        }
    }

    /* compiled from: use_thread_transition */
    public class CallTextCellHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f761b;
        private final String f762c;
        private final String f763d;

        public final void m766a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            String a = facewebPalCall.a(facebookWebView.k, "target");
            if (a == null || a.length() <= 0) {
                BLog.b(this.f761b.ar(), "Empty phone number; text/call skipped.");
                return;
            }
            this.f761b.a(new Intent(this.f763d, Uri.parse(this.f762c + a)));
        }

        public CallTextCellHandler(FacewebFragment facewebFragment, Handler handler, String str, String str2) {
            this.f761b = facewebFragment;
            super(handler);
            this.f762c = str2;
            this.f763d = str;
        }
    }

    /* compiled from: use_thread_transition */
    public class CloseAndBackHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f764b;

        public CloseAndBackHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f764b = facewebFragment;
            super(handler);
        }

        public final void m767a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            Activity ao = this.f764b.ao();
            if (ao != null) {
                ao.onBackPressed();
            }
        }
    }

    /* compiled from: use_thread_transition */
    public class CloseFacewebHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f765b;

        public CloseFacewebHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f765b = facewebFragment;
            super(handler);
        }

        public final void m768a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            Activity ao = this.f765b.ao();
            if (ao != null && !(ao instanceof IFbMainTabActivity)) {
                this.f765b.ao.a("FacewebError", "Unknow hosting activity type for CloseFacewebHandler");
            }
        }
    }

    /* compiled from: use_thread_transition */
    public class DismissModalDialog extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f766b;

        public DismissModalDialog(FacewebFragment facewebFragment, Handler handler) {
            this.f766b = facewebFragment;
            super(handler);
        }

        public final void m769a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            Activity ao = this.f766b.ao();
            if (ao != null) {
                ao.onBackPressed();
            }
        }
    }

    /* compiled from: use_thread_transition */
    public class FeedFilterPickerHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f767b;

        public FeedFilterPickerHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f767b = facewebFragment;
            super(handler);
        }

        public final void m770a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            if (this.f767b.y()) {
                int parseInt;
                String a = facewebPalCall.a(facebookWebView.getMobilePage(), "options");
                String a2 = facewebPalCall.a(facebookWebView.getMobilePage(), "dismiss_script");
                try {
                    parseInt = Integer.parseInt(facewebPalCall.a(facebookWebView.getMobilePage(), "selected_index"));
                } catch (NumberFormatException e) {
                    this.f767b.ao.a("fb4a_displaying_faceweb_feedfilterpicker", "Failed to parse argument selected_index");
                    parseInt = 0;
                }
                FeedFilterPickerDialogFragment.m854a(a, a2, parseInt, this.f767b.aw, this.f767b.an).a(this.f767b.mv_(), "dialog");
            }
        }
    }

    /* compiled from: use_thread_transition */
    class GetDevicePhoneNumberHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f768b;

        public final void m771a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            Object a = facewebPalCall.a(facebookWebView.k, "callback");
            if (!StringUtil.c(a)) {
                Object a2 = DeviceContactpointUtil.b(this.f768b.an()).a();
                if (a2 == null) {
                    a2 = "";
                }
                List a3 = Lists.a();
                a3.add(a2);
                this.f768b.an.a(a, a3, null);
            }
        }

        public GetDevicePhoneNumberHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f768b = facewebFragment;
            super(handler);
        }
    }

    /* compiled from: use_thread_transition */
    public class GetEmailAddresses extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f769b;

        public final void m772a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            Object a = facewebPalCall.a(facebookWebView.k, "callback");
            if (!StringUtil.c(a)) {
                Object j = LoginActivityHelper.b(this.f769b.an()).j();
                if (j == null) {
                    j = Sets.d();
                    j.add("");
                }
                List a2 = Lists.a();
                a2.add(j.toString());
                this.f769b.an.a(a, a2, null);
            }
        }

        public GetEmailAddresses(FacewebFragment facewebFragment, Handler handler) {
            this.f769b = facewebFragment;
            super(handler);
        }
    }

    /* compiled from: use_thread_transition */
    public class GetInstallerDataHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f770b;

        public GetInstallerDataHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f770b = facewebFragment;
            super(handler);
        }

        public final void m773a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            Object a = facewebPalCall.a(facebookWebView.getMobilePage(), "callback");
            if (!StringUtil.c(a)) {
                boolean z;
                Context context = this.f770b.getContext();
                String packageName = context.getPackageName();
                Object installerPackageName = context.getPackageManager().getInstallerPackageName(packageName);
                if (StringUtil.c(installerPackageName)) {
                    installerPackageName = "UNKNOWN";
                }
                try {
                    z = Secure.getInt(context.getContentResolver(), "install_non_market_apps") == 1;
                } catch (Throwable e) {
                    BLog.b(this.f770b.ar(), e, "Error checking if install from unknown sources is allowed", new Object[0]);
                    z = false;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("package_name", packageName);
                    jSONObject.put("installer_package", installerPackageName);
                    jSONObject.put("unknown_sources_checked", z);
                } catch (Throwable e2) {
                    BLog.b(this.f770b.ar(), e2, "unexpected json error", new Object[0]);
                }
                facebookWebView.a(a, Lists.a(new Object[]{jSONObject}), null);
            }
        }
    }

    /* compiled from: use_thread_transition */
    class HideSoftKeyboardHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f771b;

        public HideSoftKeyboardHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f771b = facewebFragment;
            super(handler);
        }

        public final void m774a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            if (this.f771b.getContext() != null) {
                KeyboardUtils.a(this.f771b.ao());
            }
        }
    }

    /* compiled from: use_thread_transition */
    public class OpenInNewWebViewHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f772b;

        public final void m775a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            String a = facewebPalCall.a(facebookWebView.k, "url");
            if (!StringUtil.c(a)) {
                this.f772b.m838c(a);
            }
        }

        public OpenInNewWebViewHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f772b = facewebFragment;
            super(handler);
        }
    }

    /* compiled from: use_thread_transition */
    public enum PrimaryActionDisplayType {
        TITLE_BUTTON,
        OPTIONS_MENU,
        NONE
    }

    /* compiled from: use_thread_transition */
    public class PrimaryActionMenuItem {
        public int f773a;
        public String f774b;
        public String f775c;

        public PrimaryActionMenuItem(int i, String str, String str2) {
            this.f773a = i;
            this.f774b = str;
            this.f775c = str2;
        }
    }

    /* compiled from: use_thread_transition */
    public class SetActionMenuHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f776b;

        public SetActionMenuHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f776b = facewebFragment;
            super(handler);
        }

        private static int m776a(String str) {
            if (str.equals("mark_unread")) {
                return 2130840851;
            }
            if (str.equals("mark_spam")) {
                return 2130840849;
            }
            if (str.equals("archive")) {
                return 2130840845;
            }
            if (str.equals("unarchive")) {
                return 2130840850;
            }
            if (str.equals("move")) {
                return 2130840848;
            }
            if (str.equals("delete")) {
                return 2130840846;
            }
            if (str.equals("forward")) {
                return 2130840847;
            }
            return -1;
        }

        public final void m777a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            try {
                JSONArray jSONArray = new JSONArray(facewebPalCall.a(facebookWebView.getMobilePage(), "actions"));
                this.f776b.aS = new JSONObject[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    this.f776b.aS[i] = jSONObject;
                    if (jSONObject.has("type")) {
                        int a = m776a(jSONObject.optString("type"));
                        if (a > 0) {
                            jSONObject.put("icon", a);
                        }
                    }
                }
            } catch (Throwable e) {
                BLog.b(this.f776b.ar(), "Invalid JSON format", e);
                this.f776b.aS = null;
            }
        }
    }

    /* compiled from: use_thread_transition */
    public abstract class StatefulNativeUICallHandler implements NativeCallHandler {
        protected Handler f785f;
        protected FacewebPalCall f786g = null;

        public abstract void mo29a(Context context, FacebookWebView facebookWebView);

        public StatefulNativeUICallHandler(Handler handler) {
            this.f785f = handler;
        }

        public final void m783a(final Context context, final FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            this.f786g = facewebPalCall;
            mo30a(facebookWebView);
            HandlerDetour.a(this.f785f, new Runnable(this) {
                final /* synthetic */ StatefulNativeUICallHandler f837c;

                public void run() {
                    this.f837c.mo29a(context, facebookWebView);
                }
            }, 1439022562);
        }

        public void mo30a(FacebookWebView facebookWebView) {
        }
    }

    /* compiled from: use_thread_transition */
    public class SetBookmarksMenuButton extends StatefulNativeUICallHandler {
        public final /* synthetic */ FacewebFragment f787a;
        public String f788b;
        private int f789c = -1;
        private String f790d = null;
        private String f791e = null;
        private String f792h = null;
        private boolean f793i;

        /* compiled from: use_thread_transition */
        class C01233 implements OnActionButtonClickListener {
            final /* synthetic */ SetBookmarksMenuButton f782a;

            C01233(SetBookmarksMenuButton setBookmarksMenuButton) {
                this.f782a = setBookmarksMenuButton;
            }

            public final void m780a(View view) {
                if (this.f782a.f787a.an != null) {
                    this.f782a.f787a.an.a(this.f782a.f788b, null);
                }
            }
        }

        public SetBookmarksMenuButton(FacewebFragment facewebFragment, Handler handler) {
            this.f787a = facewebFragment;
            super(handler);
        }

        public static int m785c(String str) {
            if (str.equals("compose")) {
                return 2130841265;
            }
            if (str.equals("add")) {
                return 2130841260;
            }
            if (str.equals("action")) {
                return 2130837999;
            }
            if (str.equals("feed_filter_live")) {
                return 2130840372;
            }
            if (str.equals("feed_filter_h_chr")) {
                return 2130840368;
            }
            if (str.equals("feed_filter_status")) {
                return 2130840371;
            }
            if (str.equals("feed_filter_photos")) {
                return 2130840370;
            }
            if (str.equals("feed_filter_links")) {
                return 2130840367;
            }
            if (str.equals("feed_filter_pages")) {
                return 2130840369;
            }
            if (str.equals("feed_filter_events")) {
                return 2130840365;
            }
            if (str.equals("feed_filter_videos")) {
                return 2130840373;
            }
            if (str.equals("feed_filter_lists")) {
                return 2130840366;
            }
            if (str.equals("like")) {
                return 2130841264;
            }
            if (str.equals("unlike")) {
                return 2130841264;
            }
            if (str.equals("feed_find_friends")) {
                return 2130840375;
            }
            return -1;
        }

        public final void mo30a(FacebookWebView facebookWebView) {
            if ("right".equals(this.f786g.a(facebookWebView.k, "position"))) {
                String string;
                this.f788b = this.f786g.a(facebookWebView.k, "script");
                String a = this.f786g.a(facebookWebView.k, "title");
                String a2 = this.f786g.a(facebookWebView.k, "type");
                int c = m785c(a2);
                Context context = this.f787a.getContext();
                if (context != null) {
                    if (a2.equals("add")) {
                        string = context.getString(2131236496);
                    } else if (a2.equals("like")) {
                        string = context.getString(2131236484);
                    } else if (a2.equals("unlike")) {
                        string = context.getString(2131236495);
                    }
                    this.f792h = string;
                    this.f793i = Boolean.valueOf(this.f786g.a(facebookWebView.k, "isDisabled")).booleanValue();
                    if (c < 0) {
                        this.f789c = c;
                        this.f790d = null;
                        this.f791e = a2;
                    }
                    this.f789c = -1;
                    this.f790d = a;
                    this.f791e = null;
                    return;
                }
                string = null;
                this.f792h = string;
                this.f793i = Boolean.valueOf(this.f786g.a(facebookWebView.k, "isDisabled")).booleanValue();
                if (c < 0) {
                    this.f789c = -1;
                    this.f790d = a;
                    this.f791e = null;
                    return;
                }
                this.f789c = c;
                this.f790d = null;
                this.f791e = a2;
            }
        }

        public final void mo29a(Context context, FacebookWebView facebookWebView) {
            boolean z = true;
            final HasTitleBar hasTitleBar = (HasTitleBar) this.f787a.a(HasTitleBar.class);
            View view = this.f787a.T;
            if (this.f787a.mx_() && !this.f787a.K && view != null && view.getVisibility() == 0 && this.f787a.ao() != null) {
                final Fb4aTitleBar fb4aTitleBar = this.f787a.aM.a;
                if ((fb4aTitleBar != null || hasTitleBar != null) && this.f787a.ax != PrimaryActionDisplayType.NONE) {
                    if (this.f787a.ax != PrimaryActionDisplayType.OPTIONS_MENU) {
                        boolean z2;
                        if (this.f789c <= 0 || this.f789c != 2130841264 || StringUtil.a(this.f791e, "like")) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        Builder a;
                        if (this.f787a.s.getBoolean("titlebar_with_modal_done", false)) {
                            fb4aTitleBar.b();
                            fb4aTitleBar.setSearchButtonVisible(false);
                            a = TitleBarButtonSpec.a();
                            a.g = this.f787a.getContext().getString(2131230733);
                            TitleBarButtonSpec a2 = a.a();
                            final C01211 c01211 = new OnActionButtonClickListener(this) {
                                final /* synthetic */ SetBookmarksMenuButton f779c;

                                public final void m778a(View view) {
                                    if (hasTitleBar != null) {
                                        hasTitleBar.a(null);
                                        hasTitleBar.a(null);
                                    } else {
                                        fb4aTitleBar.setPrimaryButton(null);
                                        fb4aTitleBar.setActionButtonOnClickListener(null);
                                    }
                                    this.f779c.f787a.ao().onBackPressed();
                                }
                            };
                            if (hasTitleBar != null) {
                                hasTitleBar.a_("");
                                hasTitleBar.a(a2);
                                OnToolbarButtonListener c01222 = new OnToolbarButtonListener(this) {
                                    final /* synthetic */ SetBookmarksMenuButton f781b;

                                    public final void m779a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                                        c01211.a(null);
                                    }
                                };
                                if (FacewebFragment.aK(this.f787a)) {
                                    NegativeFeedbackFacewebController negativeFeedbackFacewebController = this.f787a.aR;
                                    negativeFeedbackFacewebController.f855f = c01222;
                                    c01222 = new C01351(negativeFeedbackFacewebController);
                                }
                                hasTitleBar.a(c01222);
                                return;
                            }
                            fb4aTitleBar.setTitle("");
                            fb4aTitleBar.setPrimaryButton(a2);
                            fb4aTitleBar.setActionButtonOnClickListener(c01211);
                        } else if (FacewebFragment.aI(this.f787a)) {
                            FacewebFragment.m824a(this.f787a, fb4aTitleBar, hasTitleBar);
                        } else if (FacewebFragment.aL(this.f787a)) {
                            fb4aTitleBar.setSearchButtonVisible(false);
                        } else {
                            OnActionButtonClickListener onActionButtonClickListener;
                            Builder a3 = TitleBarButtonSpec.a();
                            a3.i = this.f789c;
                            a3 = a3;
                            a3.g = this.f790d;
                            a3 = a3;
                            a3.j = this.f792h;
                            a3 = a3;
                            a3.k = z2;
                            a = a3;
                            if (this.f793i) {
                                z = false;
                            }
                            a.d = z;
                            TitleBarButtonSpec a4 = a.a();
                            if (this.f788b == null) {
                                onActionButtonClickListener = null;
                            } else {
                                onActionButtonClickListener = new C01233(this);
                            }
                            if (hasTitleBar != null) {
                                hasTitleBar.a(a4);
                                if (onActionButtonClickListener != null) {
                                    hasTitleBar.a(new OnToolbarButtonListener(this) {
                                        final /* synthetic */ SetBookmarksMenuButton f784b;

                                        public final void m781a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                                            onActionButtonClickListener.a(null);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            fb4aTitleBar.setPrimaryButton(a4);
                            if (onActionButtonClickListener != null) {
                                fb4aTitleBar.setActionButtonOnClickListener(onActionButtonClickListener);
                            }
                        }
                    } else if (this.f791e != null) {
                        int i;
                        FacewebFragment facewebFragment = this.f787a;
                        String str = this.f791e;
                        if (str.equals("feed_filter_live") || str.equals("feed_filter_h_chr")) {
                            i = 2130840364;
                        } else {
                            i = m785c(str);
                        }
                        int i2 = i;
                        String str2 = this.f791e;
                        String str3 = null;
                        if (str2.equals("feed_filter_live") || str2.equals("feed_filter_h_chr")) {
                            str3 = this.f787a.getContext().getString(2131236485);
                        }
                        facewebFragment.ay = new PrimaryActionMenuItem(i2, str3, this.f788b);
                    }
                }
            }
        }
    }

    /* compiled from: use_thread_transition */
    class SetBookmarksMenuHiddenHandler extends StatefulNativeUICallHandler {
        final /* synthetic */ FacewebFragment f794a;

        public SetBookmarksMenuHiddenHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f794a = facewebFragment;
            super(handler);
        }

        public final void mo30a(FacebookWebView facebookWebView) {
            int i;
            FacewebFragment facewebFragment = this.f794a;
            if (Boolean.valueOf(this.f786g.a(facebookWebView.k, "hidden")).booleanValue()) {
                i = 8;
            } else {
                i = 0;
            }
            facewebFragment.f844e = i;
        }

        public final void mo29a(Context context, FacebookWebView facebookWebView) {
            Activity ao = this.f794a.ao();
            if (ao != null) {
                View findViewById = ao.findViewById(2131558563);
                if (findViewById != null && findViewById.getVisibility() != this.f794a.f844e) {
                    findViewById.setVisibility(this.f794a.f844e);
                }
            }
        }
    }

    /* compiled from: use_thread_transition */
    public class SetToolbarSegmentsHandler extends StatefulNativeUICallHandler {
        public final /* synthetic */ FacewebFragment f796a;
        public String[] f797b;
        public int f798c = -1;
        public int f799d = -1;

        /* compiled from: use_thread_transition */
        class C01251 implements OnCheckedChangeListener {
            final /* synthetic */ SetToolbarSegmentsHandler f795a;

            C01251(SetToolbarSegmentsHandler setToolbarSegmentsHandler) {
                this.f795a = setToolbarSegmentsHandler;
            }

            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                SetToolbarSegmentsHandler setToolbarSegmentsHandler = this.f795a;
                if (setToolbarSegmentsHandler.f798c != i) {
                    setToolbarSegmentsHandler.f798c = i;
                    if (i >= 0 && i < setToolbarSegmentsHandler.f797b.length) {
                        setToolbarSegmentsHandler.f799d = i;
                        if (setToolbarSegmentsHandler.f796a.an != null) {
                            setToolbarSegmentsHandler.f796a.an.a(setToolbarSegmentsHandler.f797b[i], null);
                        }
                    }
                }
            }
        }

        public SetToolbarSegmentsHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f796a = facewebFragment;
            super(handler);
        }

        public final void mo29a(Context context, FacebookWebView facebookWebView) {
            View F = this.f796a.F();
            if (F != null && this.f786g != null) {
                try {
                    JSONArray jSONArray = new JSONArray(this.f786g.a(facebookWebView.getMobilePage(), "segments"));
                    RadioGroup radioGroup = (RadioGroup) F.findViewById(2131562149);
                    this.f797b = new String[jSONArray.length()];
                    radioGroup.removeAllViews();
                    radioGroup.clearCheck();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        String optString = jSONObject.optString("title");
                        String optString2 = jSONObject.optString("callback");
                        this.f797b[i] = optString2;
                        View a = m790a(i, optString);
                        a.setTag(optString2);
                        radioGroup.addView(a);
                        a.setLayoutParams(new LayoutParams(0, -1, 1.0f));
                    }
                    this.f798c = 0;
                    if (this.f799d == -1) {
                        String a2 = this.f786g.a(facebookWebView.getMobilePage(), "current_tab");
                        if (a2 != null) {
                            this.f798c = Integer.parseInt(a2);
                        }
                    } else {
                        this.f798c = this.f799d;
                    }
                    radioGroup.check(this.f798c);
                    radioGroup.setOnCheckedChangeListener(new C01251(this));
                    radioGroup.setVisibility(0);
                } catch (Throwable e) {
                    BLog.b(this.f796a.ar(), "Data format error", e);
                }
            }
        }

        private RadioButton m790a(int i, String str) {
            RadioButton radioButton = (RadioButton) this.f796a.ao().getLayoutInflater().inflate(2130907364, null);
            radioButton.setButtonDrawable(2130839459);
            radioButton.setId(i);
            radioButton.setText(str);
            radioButton.setSelected(true);
            return radioButton;
        }
    }

    /* compiled from: use_thread_transition */
    public class ShareHandler implements JsReturnHandler {
        final /* synthetic */ FacewebFragment f800a;

        public ShareHandler(FacewebFragment facewebFragment) {
            this.f800a = facewebFragment;
        }

        public final void m792a(FacebookWebView facebookWebView, String str, boolean z, String str2) {
            this.f800a.m821i(2);
            if (this.f800a.av != 0) {
                this.f800a.aK.a(this.f800a.aI.now() - this.f800a.av);
            }
            if (z) {
                Toaster.a(this.f800a.getContext(), 2131236494);
            }
        }
    }

    /* compiled from: use_thread_transition */
    public class ShowActionSheetHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f801b;

        public ShowActionSheetHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f801b = facewebFragment;
            super(handler);
        }

        public final void m793a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            if (this.f801b.y) {
                String a = facewebPalCall.a(facebookWebView.k, "buttons");
                boolean equals = "true".equals(facewebPalCall.a(facebookWebView.k, "hide_cancel_button"));
                JsonFactory jsonFactory = this.f801b.aw;
                FacewebWebView facewebWebView = this.f801b.an;
                FacewebActionSheetDialogFragment facewebActionSheetDialogFragment = new FacewebActionSheetDialogFragment(jsonFactory);
                facewebActionSheetDialogFragment.ao = facewebWebView;
                Bundle bundle = new Bundle();
                bundle.putString("action_sheet_buttons", a);
                bundle.getBoolean("action_sheet_hide_cancel", equals);
                facewebActionSheetDialogFragment.g(bundle);
                facewebActionSheetDialogFragment.a(this.f801b.D, "dialog");
            }
        }
    }

    /* compiled from: use_thread_transition */
    public class ShowAlertHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f806b;

        public ShowAlertHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f806b = facewebFragment;
            super(handler);
        }

        public final void m794a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            if (this.f806b.y) {
                Object a = facewebPalCall.a(facebookWebView.k, "alertID");
                if (!StringUtil.c(a)) {
                    if (FacewebFragment.aW.contains(a)) {
                        this.f806b.ar();
                        new StringBuilder("ignored previously-seen alert ").append(a);
                        return;
                    }
                    FacewebFragment.aW.add(a);
                }
                final String a2 = facewebPalCall.a(facebookWebView.k, "button0Url");
                final CharSequence a3 = facewebPalCall.a(facebookWebView.k, "button1Url");
                CharSequence a4 = facewebPalCall.a(facebookWebView.k, "message");
                CharSequence a5 = facewebPalCall.a(facebookWebView.k, "title");
                CharSequence a6 = facewebPalCall.a(facebookWebView.k, "button0Title");
                CharSequence a7 = facewebPalCall.a(facebookWebView.k, "button1Title");
                if (!StringUtil.c(a4)) {
                    AlertDialog.Builder b = new AlertDialog.Builder(this.f806b.getContext()).a(false).b(a4);
                    if (!StringUtil.c(a5)) {
                        b.a(a5);
                    }
                    DialogInterface.OnClickListener c01261 = new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ ShowAlertHandler f803b;

                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            if (!StringUtil.c(a2)) {
                                this.f803b.f806b.m838c(a2);
                            }
                        }
                    };
                    if (StringUtil.c(a6)) {
                        b.a(this.f806b.getContext().getString(2131230756), c01261);
                    } else {
                        b.a(a6, c01261);
                    }
                    DialogInterface.OnClickListener c01272 = new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ ShowAlertHandler f805b;

                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            if (!StringUtil.c(a3)) {
                                this.f805b.f806b.m838c(a3);
                            }
                        }
                    };
                    if (!StringUtil.c(a7)) {
                        b.b(a7, c01272);
                    } else if (!StringUtil.c(a3)) {
                        b.b(this.f806b.getContext().getString(2131237528), c01272);
                    }
                    b.a().show();
                }
            }
        }
    }

    /* compiled from: use_thread_transition */
    public class ShowCheckinComposerHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f807b;

        public ShowCheckinComposerHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f807b = facewebFragment;
            super(handler);
        }

        public final void m795a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            this.f807b.az = facewebPalCall.a(facebookWebView.k, "callback");
            ComposerConfiguration a = ComposerConfigurationFactory.c(ComposerSourceType.FACEWEB).setInitialTargetData(new ComposerTargetData.Builder(FacewebFragment.m827b(facewebPalCall.a(facebookWebView.k, "target")), TargetType.OTHER).a()).a();
            PlacePickerConfiguration.Builder newBuilder = PlacePickerConfiguration.newBuilder();
            newBuilder.p = SearchType.CHECKIN;
            newBuilder = newBuilder;
            newBuilder.i = true;
            newBuilder = newBuilder;
            newBuilder.c = a;
            this.f807b.aP.a(CheckinIntentCreator.a(this.f807b.getContext(), newBuilder.a()), 10, this.f807b.ao());
        }
    }

    /* compiled from: use_thread_transition */
    public abstract class ShowTextPublisherHandler extends StatefulNativeUICallHandler implements JsReturnHandler {
        protected boolean f808d = false;
        final /* synthetic */ FacewebFragment f809e;

        /* compiled from: use_thread_transition */
        class C01281 implements OnGlobalLayoutListener {
            final /* synthetic */ ShowTextPublisherHandler f824a;

            C01281(ShowTextPublisherHandler showTextPublisherHandler) {
                this.f824a = showTextPublisherHandler;
            }

            public void onGlobalLayout() {
                if (this.f824a.f809e.aY != null && this.f824a.f809e.aY.getHeight() < this.f824a.f809e.aY.getRootView().getHeight() / 2) {
                    this.f824a.f809e.an.pageDown(true);
                    GlobalOnLayoutHelper.b(this.f824a.f809e.aY, this);
                }
            }
        }

        /* compiled from: use_thread_transition */
        class C01303 implements OnFocusChangeListener {
            final /* synthetic */ ShowTextPublisherHandler f827a;

            C01303(ShowTextPublisherHandler showTextPublisherHandler) {
                this.f827a = showTextPublisherHandler;
            }

            public void onFocusChange(View view, boolean z) {
                KeyboardUtils.a(this.f827a.f809e.ao());
            }
        }

        /* compiled from: use_thread_transition */
        class C01336 implements Runnable {
            final /* synthetic */ ShowTextPublisherHandler f833a;

            C01336(ShowTextPublisherHandler showTextPublisherHandler) {
                this.f833a = showTextPublisherHandler;
            }

            public void run() {
                ((EditText) this.f833a.f809e.T.findViewById(2131562047)).setText("");
            }
        }

        public ShowTextPublisherHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f809e = facewebFragment;
            super(handler);
        }

        public void mo29a(Context context, final FacebookWebView facebookWebView) {
            boolean z = false;
            View view = this.f809e.T;
            if (view != null && this.f786g != null) {
                final Button button = (Button) view.findViewById(2131562049);
                view.findViewById(2131562046).setVisibility(0);
                GlobalOnLayoutHelper.a(this.f809e.aY, new C01281(this));
                final EditText editText = (EditText) view.findViewById(2131562047);
                if (this.f808d) {
                    editText.setHint(2131236487);
                } else {
                    editText.setHint(2131236491);
                }
                editText.setOnEditorActionListener(new OnEditorActionListener(this) {
                    final /* synthetic */ ShowTextPublisherHandler f826b;

                    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        if (i == 4) {
                            String trim = textView.getText().toString().trim();
                            if (this.f826b.f808d || !Strings.isNullOrEmpty(trim)) {
                                this.f826b.mo31a(facebookWebView, textView);
                                textView.setText(new char[0], 0, 0);
                                KeyboardUtils.a(this.f826b.f809e.ao());
                            }
                        }
                        return false;
                    }
                });
                editText.setOnFocusChangeListener(new C01303(this));
                if (this.f808d || editText.getText().length() > 0) {
                    z = true;
                }
                button.setEnabled(z);
                editText.addTextChangedListener(new TextWatcher(this) {
                    final /* synthetic */ ShowTextPublisherHandler f830c;

                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        Button button = button;
                        boolean z = this.f830c.f808d || editText.getText().length() > 0;
                        button.setEnabled(z);
                    }

                    public void afterTextChanged(Editable editable) {
                    }

                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }
                });
                button.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ ShowTextPublisherHandler f832b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1187747625);
                        TextView textView = (EditText) this.f832b.f809e.T.findViewById(2131562047);
                        String trim = textView.getText().toString().trim();
                        if (this.f832b.f808d || !Strings.isNullOrEmpty(trim)) {
                            this.f832b.mo31a(facebookWebView, textView);
                        }
                        Logger.a(2, EntryType.UI_INPUT_END, -1624625317, a);
                    }
                });
            }
        }

        protected void mo31a(FacebookWebView facebookWebView, TextView textView) {
            ((InputMethodManager) this.f809e.ao().getSystemService("input_method")).hideSoftInputFromWindow(textView.getWindowToken(), 0);
        }

        public void mo32a(FacebookWebView facebookWebView, String str, boolean z, String str2) {
            HandlerDetour.a(this.f785f, new C01336(this), -1802283847);
        }
    }

    /* compiled from: use_thread_transition */
    public class ShowCommentPublisherHandler extends ShowTextPublisherHandler {
        protected String f810a;
        protected String f811b;
        final /* synthetic */ FacewebFragment f812c;
        private long f813h = 0;

        public ShowCommentPublisherHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f812c = facewebFragment;
            super(facewebFragment, handler);
        }

        public final void mo30a(FacebookWebView facebookWebView) {
            this.f810a = this.f786g.a(facebookWebView.k, "callback");
            this.f811b = this.f786g.a(facebookWebView.k, "post_id");
            this.d = Boolean.parseBoolean(this.f786g.a(facebookWebView.k, "allow_empty_comment"));
        }

        public final void mo29a(Context context, FacebookWebView facebookWebView) {
            View view = this.f812c.T;
            if (view != null && this.f786g != null) {
                super.mo29a(context, facebookWebView);
                view.findViewById(2131562047);
            }
        }

        protected final void mo31a(FacebookWebView facebookWebView, TextView textView) {
            super.mo31a(facebookWebView, textView);
            String a = MentionsUtils.a(((EditText) textView).getEditableText());
            if (this.f808d || !Strings.isNullOrEmpty(a)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("text", a);
                    jSONObject.put("post_id", this.f811b);
                } catch (Throwable e) {
                    BLog.b(this.f812c.ar(), "inconceivable exception", e);
                }
                List arrayList = new ArrayList();
                arrayList.add(jSONObject);
                this.f812c.m820h(3);
                this.f813h = this.f812c.aI.now();
                this.f812c.aK.a(false);
                facebookWebView.a(this.f810a, arrayList, this);
            }
        }

        public final void mo32a(FacebookWebView facebookWebView, String str, boolean z, String str2) {
            this.f812c.m821i(3);
            if (this.f813h != 0) {
                this.f812c.aK.a(this.f812c.aI.now() - this.f813h);
                this.f813h = 0;
            }
            if (z) {
                Toaster.a(this.f812c.getContext(), 2131236486);
            } else {
                super.mo32a(facebookWebView, str, z, str2);
            }
        }
    }

    /* compiled from: use_thread_transition */
    public class ShowFriendPickerHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f814b;

        public ShowFriendPickerHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f814b = facewebFragment;
            super(handler);
        }

        public final void m806a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            Intent a = FriendMultiSelectorActivity.a(this.f814b.getContext(), m804b(facebookWebView, facewebPalCall), m805c(facebookWebView, facewebPalCall));
            this.f814b.az = facewebPalCall.a(facebookWebView.k, "callback");
            this.f814b.a(a, 40);
        }

        private Set<Long> m804b(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            return m803a(facebookWebView, facewebPalCall, "preselected_ids");
        }

        private Set<Long> m805c(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            return m803a(facebookWebView, facewebPalCall, "exclude_ids");
        }

        private Set<Long> m803a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall, String str) {
            Set a = Sets.a();
            Object a2 = facewebPalCall.a(facebookWebView.getMobilePage(), str);
            if (!StringUtil.a(a2)) {
                try {
                    JSONArray jSONArray = new JSONArray(a2);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        a.add(Long.valueOf(jSONArray.getLong(i)));
                    }
                } catch (Throwable e) {
                    BLog.b(this.f814b.ar(), "Invalid JSON format", e);
                }
            }
            return a;
        }
    }

    /* compiled from: use_thread_transition */
    public class ShowMessageComposerHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f815b;

        public final void m807a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            IntentHandlerUtil.m1246a(this.f815b.an()).m1254a(this.f815b.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.R, Long.valueOf(FacewebFragment.m827b(facewebPalCall.a(facebookWebView.k, "target")))));
        }

        public ShowMessageComposerHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f815b = facewebFragment;
            super(handler);
        }
    }

    /* compiled from: use_thread_transition */
    public class ShowReplyPublisherHandler extends ShowTextPublisherHandler {
        String f816a;
        final /* synthetic */ FacewebFragment f817b;
        private long f818c = 0;

        public ShowReplyPublisherHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f817b = facewebFragment;
            super(facewebFragment, handler);
        }

        public final void mo30a(FacebookWebView facebookWebView) {
            this.f816a = this.f786g.a(facebookWebView.k, "callback");
        }

        public final void mo29a(Context context, FacebookWebView facebookWebView) {
            View view = this.f817b.T;
            if (this.f786g != null && view != null) {
                super.mo29a(context, facebookWebView);
            }
        }

        protected final void mo31a(FacebookWebView facebookWebView, TextView textView) {
            super.mo31a(facebookWebView, textView);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("text", textView.getText().toString().trim());
            } catch (JSONException e) {
                BLog.b(this.f817b.ar(), "inconceivable exception " + e.toString());
            }
            List arrayList = new ArrayList();
            arrayList.add(jSONObject);
            this.f817b.m820h(4);
            this.f818c = this.f817b.aI.now();
            this.f817b.aK.a(false);
            facebookWebView.a(this.f816a, arrayList, this);
        }

        public final void mo32a(FacebookWebView facebookWebView, String str, boolean z, String str2) {
            this.f817b.m821i(4);
            if (this.f818c != 0) {
                this.f817b.aK.a(this.f817b.aI.now() - this.f818c);
                this.f818c = 0;
            }
            if (z) {
                Toaster.a(this.f817b.getContext(), 2131236486);
            } else {
                super.mo32a(facebookWebView, str, z, str2);
            }
        }
    }

    /* compiled from: use_thread_transition */
    public class ShowShareComposerHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f819b;
        private final String f820c = "ShowShareComposerHandler";
        private String f821d;
        private boolean f822e;

        public ShowShareComposerHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f819b = facewebFragment;
            super(handler);
        }

        public final void m813a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            String str = facebookWebView.k;
            this.f819b.az = facewebPalCall.a(str, "callback");
            String a = facewebPalCall.a(str, "fbid");
            Object a2 = facewebPalCall.a(str, "title");
            if (StringUtil.c(a)) {
                this.f819b.ao.b("ShowShareComposerHandler", "blank fbid");
            } else if (StringUtil.c(a2)) {
                this.f819b.ao.b("ShowShareComposerHandler", "blank title");
            } else if (this.f822e && a.equals(this.f821d)) {
                BLog.a("ShowShareComposerHandler", "duplicate onclick for share composer");
            } else {
                String a3 = facewebPalCall.a(str, "caption");
                String a4 = facewebPalCall.a(str, "preview_image_url");
                GraphQLEntity a5 = GraphQLHelper.a(a, new GraphQLObjectType(facewebPalCall.a(str, "object_type")));
                SharePreview.Builder builder = new SharePreview.Builder();
                builder.a = a2;
                SharePreview.Builder builder2 = builder;
                builder2.b = a3;
                builder2 = builder2;
                builder2.d = a4;
                SharePreview a6 = builder2.a();
                ComposerLauncher composerLauncher = this.f819b.aQ;
                ComposerSourceType composerSourceType = ComposerSourceType.FACEWEB;
                ComposerShareParams.Builder a7 = ComposerShareParams.Builder.a(a5);
                a7.d = a6;
                composerLauncher.a(null, ComposerConfigurationFactory.c(composerSourceType, a7.b()).setIsFireAndForget(true).a(), 11, this.f819b.ao());
                this.f821d = a;
                this.f822e = true;
            }
        }

        public final void m812a() {
            this.f822e = false;
            this.f821d = null;
        }
    }

    /* compiled from: use_thread_transition */
    public class ShowStatusComposerHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f823b;

        public ShowStatusComposerHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f823b = facewebFragment;
            super(handler);
        }

        public final void m814a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            boolean z = true;
            this.f823b.az = facewebPalCall.a(facebookWebView.k, "callback");
            long a = facewebPalCall.a(facebookWebView.k, "target", -1);
            String a2 = facewebPalCall.a(facebookWebView.k, "type", null);
            ComposerTargetData.Builder builder = new ComposerTargetData.Builder(a, a2 != null ? TargetType.fromString(a2) : TargetType.OTHER);
            boolean parseBoolean = Boolean.parseBoolean(facewebPalCall.a(facebookWebView.k, "acts_as_target", "false"));
            if (parseBoolean) {
                builder.f = parseBoolean;
                builder.d = facewebPalCall.a(facebookWebView.k, "actor_profile_pic_uri");
            }
            a2 = facewebPalCall.a(facebookWebView.k, "title");
            if (a2 == null) {
                a2 = "";
            }
            builder.c = a2;
            ComposerConfiguration.Builder initialTargetData = ComposerConfigurationFactory.a(ComposerSourceSurface.FACEWEB, "facewebStatusButton").setInitialTargetData(builder.a());
            a2 = facewebPalCall.a(facebookWebView.k, "enable_attach_to_album");
            if (a2 != null) {
                initialTargetData.setDisableAttachToAlbum(!Boolean.parseBoolean(a2));
            }
            a2 = facewebPalCall.a(facebookWebView.k, "enable_friend_tagging");
            if (a2 != null) {
                if (Boolean.parseBoolean(a2)) {
                    z = false;
                }
                initialTargetData.setDisableFriendTagging(z);
            }
            this.f823b.aQ.a(null, initialTargetData.a(), 10, this.f823b.ao());
        }
    }

    /* compiled from: use_thread_transition */
    public class ShowUploadPhotoHandler extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f834b;

        public ShowUploadPhotoHandler(FacewebFragment facewebFragment, Handler handler) {
            this.f834b = facewebFragment;
            super(handler);
        }

        public final void m815a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            String str;
            this.f834b.az = facewebPalCall.a(facebookWebView.k, "callback");
            if (this.f834b.an != null) {
                str = this.f834b.an.k;
            } else {
                str = null;
            }
            this.f834b.am = FacewebFragment.m827b(facewebPalCall.a(str, "target"));
            boolean a = StringUtil.a("true", facewebPalCall.a(str, "photosOnly"));
            SimplePickerLauncherConfiguration.Builder h = new SimplePickerLauncherConfiguration.Builder(SimplePickerSource.FACEWEB).h();
            ComposerConfiguration.Builder a2 = ComposerConfigurationFactory.a(ComposerSourceSurface.FACEWEB, "facewebPhotoButton");
            ComposerTargetData.Builder builder = new ComposerTargetData.Builder();
            builder.a = this.f834b.am;
            h.a = a2.setInitialTargetData(builder.a()).setIsFireAndForget(true).a();
            h = h;
            if (a) {
                h.i();
            }
            Intent a3 = SimplePickerIntent.a(this.f834b.getContext(), h);
            a3.putExtra("extra_source_activity", this.f834b.getClass().getSimpleName());
            this.f834b.a(a3, 50);
        }
    }

    /* compiled from: use_thread_transition */
    class UpdateNativeLoadingIndicator extends NativeUICallHandler {
        final /* synthetic */ FacewebFragment f838b;

        public UpdateNativeLoadingIndicator(FacewebFragment facewebFragment, Handler handler) {
            this.f838b = facewebFragment;
            super(handler);
        }

        public final void m817a(FacewebPalCall facewebPalCall) {
            this.f838b.aB = facewebPalCall.a().equals("pageLoading");
        }

        public final void m816a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
            this.f838b.aJ = this.f838b.aB;
            if (this.f838b.T != null) {
                Context ao = this.f838b.ao();
                Fb4aTitleBar fb4aTitleBar = this.f838b.aM.a;
                if (ao != null && fb4aTitleBar != null) {
                    this.f838b.aK.a(true);
                    this.f838b.aK.a(this.f838b.aB ? ContentFlags.LOCAL_DATA : ContentFlags.NETWORK_DATA, this.f838b.ar(), this.f838b.aL.b(ao));
                }
            }
        }
    }

    public static void m825a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FacewebFragment facewebFragment = (FacewebFragment) obj;
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 2436);
        Lazy b2 = IdBasedSingletonScopeProvider.b(fbInjector, 968);
        facewebFragment.f841a = b;
        facewebFragment.f842b = b2;
    }

    static {
        Set hashSet = new HashSet();
        aV = hashSet;
        hashSet.add("fw_photo_uploaded");
    }

    public static FacewebFragment m822a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, @Nullable String str3) {
        FacewebFragment facewebFragment = new FacewebFragment();
        Bundle bundle = new Bundle();
        bundle.putString("mobile_page", str);
        bundle.putString("first_party_bootstrap_js", str2);
        bundle.putBoolean("faceweb_modal", z);
        bundle.putBoolean("titlebar_with_modal_done", z2);
        bundle.putString("uri_unhandled_report_category_name", str3);
        bundle.putBoolean("arg_is_checkpoint", z3);
        bundle.putBoolean("arg_is_blocking_checkpoint", z4);
        bundle.putBoolean("faceweb_nfx", z5);
        facewebFragment.g(bundle);
        return facewebFragment;
    }

    public final void m837c(@Nullable Bundle bundle) {
        super.c(bundle);
        FbInjector an = an();
        this.ao = (AbstractFbErrorReporter) FbErrorReporterImpl.a(an);
        this.aX = (PerformanceLogger) DelegatingPerformanceLogger.a(an);
        this.aO = (BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(an);
        this.aX.c(new MarkerConfig(2359304, "FWFragmentCreate").a(new String[]{am_()}));
        this.aL = ImpressionManager.a(an);
        this.aM = Fb4aTitleBarSupplier.a(an);
        this.aN = ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(an);
        this.aP = ComposerIntentLauncher.b(an);
        this.aQ = (ComposerLauncher) ComposerLauncherImpl.a(an);
        this.aw = JsonFactoryMethodAutoProvider.a(an);
        this.aR = new NegativeFeedbackFacewebController(UniversalFeedbackController.b(an()));
        this.aX.b(655408, "NNF_PermalinkNotificationLoad");
        String string = this.s.getString("mobile_page");
        if (string != null && string.startsWith("/events/")) {
            this.aQ.a(1756, ao());
        }
    }

    public final View m834a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -526646274);
        Class cls = FacewebFragment.class;
        m825a((Object) this, getContext());
        View inflate = layoutInflater.inflate(2130904417, viewGroup, false);
        this.aY = inflate.findViewById(2131562147);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1447523226, a);
        return inflate;
    }

    public final void m839d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2029602018);
        super.d(bundle);
        this.aD = AppSession.a(getContext(), false);
        this.aK = InteractionLogger.a(an());
        this.aI = (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(an());
        if (bundle != null) {
            this.au = bundle.getLong("PROFILE_ID", -1);
            this.az = bundle.getString("publisher_callback");
            ArrayList stringArrayList = bundle.getStringArrayList("native_event_listener_keys");
            ArrayList stringArrayList2 = bundle.getStringArrayList("native_event_listener_values");
            if (!(stringArrayList == null || stringArrayList2 == null || stringArrayList2.size() != stringArrayList.size())) {
                for (int i = 0; i < stringArrayList.size(); i++) {
                    this.aU.put(stringArrayList.get(i), stringArrayList2.get(i));
                }
            }
        }
        Bundle bundle2 = this.s;
        this.aE = bundle2.getString("mobile_page");
        this.aF = bundle2.getString("first_party_bootstrap_js");
        this.aG = bundle2.getBoolean("parent_control_title_bar", false);
        this.aH = bundle2.getString("uri_unhandled_report_category_name");
        if (StringUtil.c(this.aE)) {
            this.aE = "/home.php";
        }
        this.aX.d(2359297, "FacewebChromeLoad." + this.aE);
        FacebookActivity aq = aq();
        if (bundle2.getBoolean("faceweb_modal", false) && aq != null) {
            this.f844e = 8;
        }
        if (bundle2.getBoolean("hide_drop_shadow", true)) {
            View view = this.T;
            if (view != null) {
                view.findViewById(2131562148).setVisibility(8);
            }
        }
        this.aA = new FeedFilterPickerHandler(this, this.f843d);
        this.aT = System.currentTimeMillis();
        FacewebAssassin.m747a(this.f843d, new C01111(this), 35000);
        LogUtils.f(-939630682, a);
    }

    public final void m831G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 267050313);
        super.G();
        if (BuildConstants.i) {
            this.ao.c("news_feed_implementation", "faceweb");
        }
        this.aX.c(2359304, "FWFragmentCreate");
        Context ao = ao();
        AppSession b = AppSession.b(ao, false);
        this.aD = b;
        if (b == null) {
            ao.finish();
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 985386543, a);
            return;
        }
        FacewebAssassin.m749b(this);
        az();
        Context ao2 = ao();
        Assert.a(ao2);
        View findViewById = ao2.findViewById(2131558563);
        if (!(findViewById == null || this.aG)) {
            if (findViewById.getVisibility() != this.f844e) {
                findViewById.setVisibility(this.f844e);
            }
            if (findViewById.getVisibility() == 0) {
                this.f845f.mo29a(ao2, this.an);
            }
        }
        this.f846g.mo29a(ao2, this.an);
        this.f847h.mo29a(ao2, this.an);
        this.f848i.mo29a(ao2, this.an);
        this.an.m1346f();
        if (VERSION.SDK_INT >= 11) {
            RefreshableFacewebWebViewContainer refreshableFacewebWebViewContainer = this.at;
            refreshableFacewebWebViewContainer.f1350m.getViewTreeObserver().addOnScrollChangedListener(refreshableFacewebWebViewContainer.f1340B);
            this.an.onResume();
        }
        if (this.aT > 0) {
            this.an.a(StringFormatUtil.formatStrLocaleSafe("(function() { if (window.fwDidEnterForeground) { fwDidEnterForeground(%d, %s); } })()", Long.valueOf((System.currentTimeMillis() - this.aT) / 1000), "true"), null);
        }
        ay();
        LogUtils.f(-242364457, a);
    }

    public static boolean aI(FacewebFragment facewebFragment) {
        return facewebFragment.s.getBoolean("arg_is_checkpoint", false);
    }

    public static boolean aK(FacewebFragment facewebFragment) {
        return facewebFragment.s.getBoolean("faceweb_nfx", false);
    }

    private void ay() {
        if (!this.s.getBoolean("no_title", false)) {
            Fb4aTitleBar fb4aTitleBar = this.aM.a;
            if (this.ar != null) {
                HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
                if (hasTitleBar != null) {
                    hasTitleBar.a_(this.ar);
                } else if (fb4aTitleBar != null) {
                    fb4aTitleBar.setTitle(this.ar);
                }
            }
        }
    }

    private void az() {
        boolean z;
        boolean z2;
        Object obj;
        AppSession appSession;
        Context applicationContext;
        Collection sessionCookies;
        String str;
        Object url;
        boolean z3 = false;
        boolean z4 = this.aT > 0 && System.currentTimeMillis() - this.aT > 300000;
        Activity ao = ao();
        if (this.at == null) {
            this.at = new RefreshableFacewebWebViewContainer(ao);
            this.at.f1354q = new C01122(this);
            z = true;
            z2 = false;
        } else {
            z = false;
            z2 = true;
        }
        View view = (ViewGroup) this.T.findViewById(2131562147);
        View view2 = (View) this.at.getParent();
        if (view2 == null) {
            view.addView(this.at, new LayoutParams(-1, -1));
        } else {
            Assert.a(view2 == view);
        }
        this.an = this.at.f1350m;
        if (this.aF != null) {
            this.an.f1284A = this.aF;
        }
        this.an.setFileChooserChromeClient(new C01209(this));
        if (!StringUtil.a(this.aH)) {
            this.an.f1288F = new Object(this) {
                final /* synthetic */ FacewebFragment f736a;

                {
                    this.f736a = r1;
                }

                public final void m750a(String str) {
                    this.f736a.ao.a(this.f736a.aH, str);
                }
            };
        }
        if (z) {
            m829b(ao);
            if (aK(this)) {
                NegativeFeedbackFacewebController negativeFeedbackFacewebController = this.aR;
                FragmentManager fragmentManager = this.D;
                FacewebWebView facewebWebView = this.an;
                negativeFeedbackFacewebController.f859j = fragmentManager;
                facewebWebView.a("addUniversalFeedbackToken", negativeFeedbackFacewebController);
            }
        }
        if (z2) {
            RefreshableFacewebWebViewContainer refreshableFacewebWebViewContainer = this.at;
            if (refreshableFacewebWebViewContainer.f1362y == ContentState.CONTENT_STATE_WEBVIEW || refreshableFacewebWebViewContainer.f1362y == ContentState.CONTENT_STATE_LOAD_COMPLETE) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                z2 = true;
                if (z || z4 || z2) {
                    z3 = true;
                }
                if (z3) {
                    if (z2) {
                        this.at.m1373a(ContentState.CONTENT_STATE_LOADING);
                        this.aK.a(true);
                    }
                    appSession = this.aD;
                    applicationContext = ao().getApplicationContext();
                    if (!(appSession == null || appSession.b() == null)) {
                        sessionCookies = appSession.b().getSessionCookies();
                        if (sessionCookies != null) {
                            FacebookWebView.a(applicationContext, NetworkLogUrl.a(applicationContext, "https://%s/"), sessionCookies);
                            appSession.b().m988b();
                        }
                    }
                    this.aX.c(2359297, "FacewebChromeLoad." + this.aE);
                    str = this.aE;
                    if (!Strings.isNullOrEmpty(str) || URL.a(str) || !URL.d(str) || URL.b(str)) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                    if (obj != null) {
                        final Timer timer = new Timer();
                        timer.schedule(new C01133(this), 10000);
                        final FragmentManager fragmentManager2 = this.D;
                        fragmentManager2.a(new OnBackStackChangedListener(this) {
                            final /* synthetic */ FacewebFragment f750c;

                            public final void le_() {
                                timer.cancel();
                                fragmentManager2.b(this);
                            }
                        });
                    }
                    if (this.aE.matches(".*home\\.php.*")) {
                        this.ao.a("fb4a_displaying_faceweb_feed", "href: " + this.aE + ", intent extras: " + aC());
                    }
                    this.an.m1342a(this.aE, true);
                } else if (this.an != null) {
                    url = this.an.getUrl();
                    if (!StringUtil.a(url)) {
                        str = StringUtils.a(url);
                        if (str != null) {
                            this.aX.e(2359302, "FacewebPageSession:" + str);
                        }
                    }
                }
            }
        }
        z2 = false;
        z3 = true;
        if (z3) {
            if (z2) {
                this.at.m1373a(ContentState.CONTENT_STATE_LOADING);
                this.aK.a(true);
            }
            appSession = this.aD;
            applicationContext = ao().getApplicationContext();
            sessionCookies = appSession.b().getSessionCookies();
            if (sessionCookies != null) {
                FacebookWebView.a(applicationContext, NetworkLogUrl.a(applicationContext, "https://%s/"), sessionCookies);
                appSession.b().m988b();
            }
            this.aX.c(2359297, "FacewebChromeLoad." + this.aE);
            str = this.aE;
            if (Strings.isNullOrEmpty(str)) {
            }
            obj = null;
            if (obj != null) {
                final Timer timer2 = new Timer();
                timer2.schedule(new C01133(this), 10000);
                final FragmentManager fragmentManager22 = this.D;
                fragmentManager22.a(/* anonymous class already generated */);
            }
            if (this.aE.matches(".*home\\.php.*")) {
                this.ao.a("fb4a_displaying_faceweb_feed", "href: " + this.aE + ", intent extras: " + aC());
            }
            this.an.m1342a(this.aE, true);
        } else if (this.an != null) {
            url = this.an.getUrl();
            if (!StringUtil.a(url)) {
                str = StringUtils.a(url);
                if (str != null) {
                    this.aX.e(2359302, "FacewebPageSession:" + str);
                }
            }
        }
    }

    public static void aA(FacewebFragment facewebFragment) {
        if (facewebFragment.an != null) {
            facewebFragment.ar = facewebFragment.an.getTitle();
            if (facewebFragment.y) {
                facewebFragment.ay();
            }
        }
    }

    private Intent aB() {
        Activity ao = ao();
        if (ao == null || ao.isFinishing()) {
            return null;
        }
        return ao.getIntent();
    }

    private String aC() {
        Intent aB = aB();
        if (aB == null || aB.getExtras() == null) {
            return "";
        }
        return aB.getExtras().toString();
    }

    private void m829b(final Activity activity) {
        this.an.a("setToolbarSegments", this.f846g);
        this.an.a("showCommentPublisher", this.f847h);
        this.an.a("showCheckinComposer", new ShowCheckinComposerHandler(this, this.f843d));
        this.an.a("showFriendPicker", new ShowFriendPickerHandler(this, this.f843d));
        this.an.a("addNativeEventListener", new AddNativeEventListenerHandler(this, this.f843d));
        this.an.a("showMsgComposer", new ShowMessageComposerHandler(this, this.f843d));
        this.an.a("callCell", new CallTextCellHandler(this, this.f843d, "android.intent.action.DIAL", "tel:"));
        this.an.a("callSMS", new CallTextCellHandler(this, this.f843d, "android.intent.action.VIEW", "sms:"));
        this.an.a("showActionSheet", new ShowActionSheetHandler(this, this.f843d));
        this.an.a("uploadPhoto", new ShowUploadPhotoHandler(this, this.f843d));
        this.an.a("showStatusComposer", new ShowStatusComposerHandler(this, this.f843d));
        this.an.a("showShareComposer", this.al);
        this.an.a("showMsgReplyPublisher", this.f848i);
        UpdateNativeLoadingIndicator updateNativeLoadingIndicator = new UpdateNativeLoadingIndicator(this, this.f843d);
        this.an.a("pageLoading", updateNativeLoadingIndicator);
        this.an.a("pageLoaded", updateNativeLoadingIndicator);
        this.an.a("setNavBarButton", this.f845f);
        this.an.a("setActionMenu", new SetActionMenuHandler(this, this.f843d));
        this.an.a("showPickerView", this.aA);
        this.an.a("enablePullToRefresh", new C01155(this));
        this.an.a("close", new CloseFacewebHandler(this, this.f843d));
        this.an.a("back", new CloseAndBackHandler(this, this.f843d));
        this.an.setScrollBarStyle(33554432);
        this.an.a("setNavBarHidden", new SetBookmarksMenuHiddenHandler(this, this.f843d));
        this.an.a("dismissModalDialog", new DismissModalDialog(this, this.f843d));
        this.an.a("showAlert", new ShowAlertHandler(this, this.f843d));
        this.an.a("openInNewWebView", new OpenInNewWebViewHandler(this, this.f843d));
        this.an.a("hideSoftKeyboard", new HideSoftKeyboardHandler(this, this.f843d));
        this.an.a("nativethirdparty", new LaunchApplicationHandler(this.f843d));
        this.an.a("getDevicePhoneNumber", new GetDevicePhoneNumberHandler(this, this.f843d));
        this.an.a("backgroundConfirmationAddPendingContactpoint", new BackgroundConfirmationAddPendingContactpointHandler(this, this.f843d));
        this.an.a("getEmailAddresses", new GetEmailAddresses(this, this.f843d));
        this.an.a("getInstallerData", new GetInstallerDataHandler(this, this.f843d));
        this.an.a("refreshZeroToken", new NativeUICallHandler(this, this.f843d) {
            final /* synthetic */ FacewebFragment f753b;

            /* compiled from: use_thread_transition */
            class C01161 implements Runnable {
                final /* synthetic */ C01176 f752a;

                C01161(C01176 c01176) {
                    this.f752a = c01176;
                }

                public void run() {
                    this.f752a.f753b.aO.a(new Intent("com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN").putExtra("zero_token_request_reason", TokenRequestReason.FACEWEB));
                }
            }

            public final void m758a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
                this.f753b.aN.schedule(new C01161(this), 10000, TimeUnit.MILLISECONDS);
            }
        });
        this.an.a("switchToDialtone", new NativeUICallHandler(this, this.f843d) {
            final /* synthetic */ FacewebFragment f755c;

            public final void m759a(FacebookWebView facebookWebView, FacewebPalCall facewebPalCall) {
                Intent intent;
                Intent a = ((Fb4aUriIntentMapper) this.f755c.f841a.get()).a(this.f755c.getContext(), "dialtone://switch_to_dialtone");
                if (a == null) {
                    a = new Intent();
                    a.setData(Uri.parse("dialtone://switch_to_dialtone"));
                    intent = a;
                } else {
                    intent = a;
                }
                intent.putExtra("ref", "dialtone_faceweb");
                ((SecureContextHelper) this.f755c.f842b.get()).a(intent, activity);
            }
        });
        this.an.m1347g();
    }

    public final void m832H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1219137741);
        if (BuildConstants.i) {
            this.ao.a("news_feed_implementation");
        }
        this.aX.a(2359304, "FWFragmentCreate");
        this.aT = System.currentTimeMillis();
        if (this.an != null) {
            if (!StringUtil.a(this.an.getUrl())) {
                String a2 = StringUtils.a(this.an.getUrl());
                if (a2 != null) {
                    this.aX.c(2359302, "FacewebPageSession:" + a2);
                }
            }
            this.an.stopLoading();
            if (VERSION.SDK_INT >= 11) {
                this.an.onPause();
                RefreshableFacewebWebViewContainer refreshableFacewebWebViewContainer = this.at;
                refreshableFacewebWebViewContainer.f1350m.getViewTreeObserver().removeOnScrollChangedListener(refreshableFacewebWebViewContainer.f1340B);
            }
            this.an.freeMemory();
        }
        FacewebAssassin.m748a(this);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2142975771, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1729108099);
        aD();
        this.aY = null;
        super.mY_();
        Fb4aTitleBar fb4aTitleBar = this.aM.a;
        if (fb4aTitleBar != null) {
            fb4aTitleBar.c();
            fb4aTitleBar.setPrimaryButton(null);
        }
        if (this.s.getBoolean("titlebar_with_modal_done", false)) {
            HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
            if (hasTitleBar != null) {
                hasTitleBar.kg_();
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 861493665, a);
    }

    public final void m833I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 976213494);
        FacewebAssassin.m749b(this);
        if (this.an != null) {
            if (this.f844e == 8) {
                Fb4aTitleBar fb4aTitleBar = this.aM.a;
                if (!(fb4aTitleBar == null || fb4aTitleBar.getVisibility() == 0)) {
                    fb4aTitleBar.setVisibility(0);
                }
            }
            final FacewebWebView facewebWebView = this.an;
            HandlerDetour.b(this.f843d, new Runnable(this) {
                final /* synthetic */ FacewebFragment f757b;

                public void run() {
                    if (facewebWebView != null) {
                        facewebWebView.destroy();
                    }
                }
            }, 30000, -1120151542);
            this.an.f1288F = null;
            this.an = null;
            aD();
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -998086741, a);
    }

    public final void m840e() {
        if (this.an != null) {
            this.an.m1344d();
        }
    }

    public final void m841e(Bundle bundle) {
        super.e(bundle);
        bundle.putLong("PROFILE_ID", this.au);
        bundle.putBoolean("save_active_state", true);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Entry entry : this.aU.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        bundle.putStringArrayList("native_event_listener_keys", arrayList);
        bundle.putStringArrayList("native_event_listener_values", arrayList2);
        bundle.putString("publisher_callback", this.az);
    }

    protected final void as() {
        aD();
        FacewebWebView facewebWebView = this.at.f1350m;
        if (facewebWebView != null) {
            facewebWebView.destroy();
        }
        this.at = null;
        this.an = null;
    }

    private void aD() {
        if (this.at != null) {
            ViewGroup viewGroup = (ViewGroup) this.at.getParent();
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
        }
    }

    public final DialogFragment mo33g(int i) {
        switch (i) {
            case 2:
            case 3:
            case 4:
                int i2 = -1;
                if (i == 2) {
                    i2 = 2131236490;
                } else if (i == 3) {
                    i2 = 2131236489;
                } else if (i == 4) {
                    i2 = 2131236488;
                }
                if (i == 2) {
                    this.aK.a(true);
                } else {
                    this.aK.a(false);
                }
                return ProgressDialogFragment.a(i2, true, false);
            case 5:
                AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("message_res_id", 2131236494);
                alertDialogFragment.g(bundle);
                return alertDialogFragment;
            default:
                return super.mo33g(i);
        }
    }

    public Map<String, String> getDebugInfo() {
        if (this.an != null) {
            return ImmutableBiMap.b("FacewebUrl", this.an.getUrl());
        }
        return RegularImmutableBiMap.a;
    }

    private void m823a(int i, Intent intent) {
        if (i == -1 && intent.hasExtra("profiles")) {
            long[] longArrayExtra = intent.getLongArrayExtra("profiles");
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject.put("action", "didPickFriends");
                for (long put : longArrayExtra) {
                    jSONArray.put(put);
                }
                jSONObject.put("pickedFriends", jSONArray);
            } catch (Throwable e) {
                BLog.b(ar(), "inconceivable exception", e);
            }
            List arrayList = new ArrayList();
            arrayList.add(jSONObject);
            if (this.az != null) {
                m820h(2);
                this.av = this.aI.now();
                this.aK.a(true);
                this.an.a(this.az, arrayList, new ShareHandler(this));
                return;
            }
            m820h(6);
            this.ao.b("FacewebError", "Invite friend callback unset.");
        }
    }

    public final void m835a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 != 0) {
            switch (i) {
                case 10:
                case 50:
                    if (!intent.getBooleanExtra("is_uploading_media", false)) {
                        m830b(intent);
                        return;
                    }
                    return;
                case 11:
                    if (intent.hasExtra("publishPostParams")) {
                        m830b(intent);
                    }
                    this.al.m812a();
                    return;
                case 12:
                    if (this.ap != null) {
                        Object data = (intent == null || i2 != -1) ? null : intent.getData();
                        this.ap.onReceiveValue(data);
                        this.ap = null;
                        return;
                    }
                    return;
                case 13:
                    if (this.aq != null) {
                        this.aq.onReceiveValue(FileChooserParams.parseResult(i2, intent));
                        this.aq = null;
                        return;
                    }
                    return;
                case 40:
                    m823a(i2, intent);
                    return;
                default:
                    return;
            }
        } else if (i == 11) {
            this.al.m812a();
        } else if (i == 12 && this.ap != null) {
            this.ap.onReceiveValue(null);
            this.ap = null;
        } else if (i == 13 && this.aq != null) {
            this.aq.onReceiveValue(null);
            this.aq = null;
        }
    }

    private void m830b(Intent intent) {
        DialogFragment g = mo33g(2);
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe("Cannot create dialog for %s. Check onCreateDialogFragment(int) method", Integer.valueOf(2));
        if (Assert.a()) {
            junit.framework.Assert.assertNotNull(formatStrLocaleSafe, g);
        }
        FragmentManager fragmentManager = this.D;
        FragmentTransaction a = fragmentManager.a();
        String k = BaseFacebookFragment.m818k(2);
        Fragment a2 = fragmentManager.a(k);
        if (a2 != null) {
            a.a(a2);
        }
        a.a(4097);
        g.a(a, k, true);
        this.av = this.aI.now();
        this.aK.a(true);
        DefaultAndroidThreadUtil.b(an()).a(ComposerPublishServiceHelper.b(an()).c(intent), new OperationResultFutureCallback(this) {
            final /* synthetic */ FacewebFragment f737a;

            {
                this.f737a = r1;
            }

            protected final void m752a(Object obj) {
                this.f737a.m821i(2);
                if (this.f737a.av != 0) {
                    this.f737a.aK.a(this.f737a.aI.now() - this.f737a.av);
                    this.f737a.av = 0;
                }
                if (this.f737a.an != null) {
                    this.f737a.an.m1343c();
                }
            }

            protected final void m751a(ServiceException serviceException) {
                this.f737a.m821i(2);
                if (this.f737a.av != 0) {
                    this.f737a.aK.a(this.f737a.aI.now() - this.f737a.av);
                    this.f737a.av = 0;
                }
            }
        });
    }

    public static void m824a(FacewebFragment facewebFragment, final Fb4aTitleBar fb4aTitleBar, final HasTitleBar hasTitleBar) {
        fb4aTitleBar.setSearchButtonVisible(false);
        fb4aTitleBar.e();
        if (!aJ(facewebFragment)) {
            if (facewebFragment.as != null) {
                aH(facewebFragment);
            } else {
                facewebFragment.as = new OnClickListener(facewebFragment) {
                    final /* synthetic */ FacewebFragment f740c;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1846998354);
                        if (hasTitleBar != null) {
                            hasTitleBar.a(null);
                            hasTitleBar.a(null);
                        } else {
                            fb4aTitleBar.setPrimaryButton(null);
                            fb4aTitleBar.setActionButtonOnClickListener(null);
                        }
                        this.f740c.ao().onBackPressed();
                        LogUtils.a(1160104023, a);
                    }
                };
                HandlerDetour.b(facewebFragment.f843d, new Runnable(facewebFragment) {
                    final /* synthetic */ FacewebFragment f741a;

                    {
                        this.f741a = r1;
                    }

                    public void run() {
                        FacewebFragment.aH(this.f741a);
                    }
                }, 3000, -1920382310);
            }
        }
        Builder a = TitleBarButtonSpec.a();
        a.i = 2130840077;
        TitleBarButtonSpec a2 = a.a();
        final AnonymousClass14 anonymousClass14 = new OnActionButtonClickListener(facewebFragment) {
            final /* synthetic */ FacewebFragment f742a;

            {
                this.f742a = r1;
            }

            public final void m753a(View view) {
                FacewebWebView facewebWebView = this.f742a.at.f1350m;
                if (facewebWebView != null) {
                    facewebWebView.m1343c();
                }
            }
        };
        if (hasTitleBar != null) {
            hasTitleBar.a_("");
            hasTitleBar.a(a2);
            hasTitleBar.a(new OnToolbarButtonListener(facewebFragment) {
                final /* synthetic */ FacewebFragment f744b;

                public final void m754a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                    anonymousClass14.a(null);
                }
            });
            return;
        }
        fb4aTitleBar.setTitle("");
        fb4aTitleBar.setPrimaryButton(a2);
        fb4aTitleBar.setActionButtonOnClickListener(anonymousClass14);
    }

    public static void aH(FacewebFragment facewebFragment) {
        Fb4aTitleBar fb4aTitleBar = facewebFragment.aM.a;
        if (fb4aTitleBar != null) {
            fb4aTitleBar.setTitlebarAsModal(facewebFragment.as);
        }
    }

    public static boolean aJ(FacewebFragment facewebFragment) {
        if (aI(facewebFragment) && facewebFragment.s.getBoolean("arg_is_blocking_checkpoint", false)) {
            return true;
        }
        return false;
    }

    public static boolean aL(FacewebFragment facewebFragment) {
        Intent aB = facewebFragment.aB();
        if (aB == null) {
            return false;
        }
        return aB.getBooleanExtra("faceweb_help_center", false);
    }

    protected static long m827b(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return -1;
        } catch (NullPointerException e2) {
            return -1;
        }
    }

    final void m838c(String str) {
        if (getContext() != null) {
            Intent a = Fb4aUriIntentMapper.a(an()).a(getContext(), str);
            if (a == null) {
                a = new Intent("android.intent.action.VIEW", Uri.parse(str));
                a.setFlags(524288);
            }
            NativeThirdPartyUriHelper.a(getContext(), a);
            a(a);
        }
    }

    public final String am_() {
        return "faceweb_view";
    }

    public final Map<String, Object> m836c() {
        Object obj = this.aE;
        if (obj == null) {
            obj = this.s.getString("mobile_page");
            if (StringUtil.c(obj)) {
                obj = "/home.php";
            }
        }
        return ImmutableBiMap.b("mobile_page", obj);
    }
}
