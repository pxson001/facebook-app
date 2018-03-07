package com.facebook.browser.liteclient;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.ClipboardUtil;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams.Builder;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.messaging.business.subscription.common.utils.BusinessSubscriptionMutationHelper;
import com.facebook.messaging.sharing.sendasmessage.SendAsMessageUtil;
import com.facebook.saved.common.protocol.UpdateSavedStateUtils;
import com.facebook.sequencelogger.Sequence;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.ui.browser.logging.BrowserSequences;
import com.facebook.ui.browser.widget.BrowserShareMenuController;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: max_num_steps */
public class BrowserLiteMenuItemHandler {
    public BrowserShareMenuController f5527a;
    public BackgroundMenuTaskHandler f5528b = new BackgroundMenuTaskHandler(this, Looper.getMainLooper());
    public UpdateSavedStateUtils f5529c;
    public Toaster f5530d;
    private BusinessSubscriptionMutationHelper f5531e;

    /* compiled from: max_num_steps */
    public class BackgroundMenuTaskHandler extends Handler {
        public final /* synthetic */ BrowserLiteMenuItemHandler f5525a;
        public OperationResultFutureCallback f5526b;

        public BackgroundMenuTaskHandler(final BrowserLiteMenuItemHandler browserLiteMenuItemHandler, Looper looper) {
            this.f5525a = browserLiteMenuItemHandler;
            super(looper);
            this.f5526b = new OperationResultFutureCallback(this) {
                final /* synthetic */ BackgroundMenuTaskHandler f5524b;

                protected final void m6757a(ServiceException serviceException) {
                    this.f5524b.f5525a.f5530d.b(new ToastBuilder(2131236856));
                }

                protected final void m6758a(Object obj) {
                    this.f5524b.f5525a.f5530d.b(new ToastBuilder(2131236854));
                }
            };
        }

        public void handleMessage(Message message) {
            String str = (String) message.obj;
            switch (message.what) {
                case 0:
                    this.f5525a.f5529c.e(str, CurationSurface.NATIVE_WEB_VIEW, CurationMechanism.SAVED_ADD, this.f5526b);
                    return;
                case 1:
                    BrowserShareMenuController browserShareMenuController = this.f5525a.f5527a;
                    if (null != null) {
                        Sequence e = browserShareMenuController.c.e(BrowserSequences.a);
                        if (e != null) {
                            SequenceLoggerDetour.e(e, "menu_copy_to_clipboard_press", -2137557971);
                        }
                    }
                    ClipboardUtil.a(browserShareMenuController.a, str);
                    ((Toaster) browserShareMenuController.k.get()).b(new ToastBuilder(2131236853));
                    return;
                default:
                    throw new IllegalStateException("Illegal action specified.");
            }
        }
    }

    public static BrowserLiteMenuItemHandler m6759a(InjectorLike injectorLike) {
        return new BrowserLiteMenuItemHandler(BrowserShareMenuController.b(injectorLike), UpdateSavedStateUtils.a(injectorLike), Toaster.b(injectorLike), BusinessSubscriptionMutationHelper.b(injectorLike));
    }

    @Inject
    public BrowserLiteMenuItemHandler(BrowserShareMenuController browserShareMenuController, UpdateSavedStateUtils updateSavedStateUtils, Toaster toaster, BusinessSubscriptionMutationHelper businessSubscriptionMutationHelper) {
        this.f5527a = browserShareMenuController;
        this.f5529c = updateSavedStateUtils;
        this.f5530d = toaster;
        this.f5531e = businessSubscriptionMutationHelper;
    }

    public final boolean m6761a(Map map) {
        if (!map.containsKey("action") || !map.containsKey("url") || !(map.get("url") instanceof String)) {
            return false;
        }
        Object obj = map.get("action");
        String str = (String) map.get("url");
        if ("SHARE_MESSENGER".equals(obj)) {
            BrowserShareMenuController browserShareMenuController = this.f5527a;
            ((SendAsMessageUtil) browserShareMenuController.j.get()).a(browserShareMenuController.a, str, true, true, "browser");
            return true;
        } else if ("SHARE_TIMELINE".equals(obj)) {
            m6760b(str);
            return true;
        } else if ("SAVE_LINK".equals(obj)) {
            r5 = this.f5528b;
            r5.sendMessage(r5.obtainMessage(0, str));
            return true;
        } else if ("COPY_LINK".equals(obj)) {
            r5 = this.f5528b;
            r5.sendMessage(r5.obtainMessage(1, str));
            return true;
        } else if (!"MESSENGER_CONTENT_SUBSCRIBE".equals(obj)) {
            return false;
        } else {
            if (!map.containsKey("id")) {
                return false;
            }
            this.f5531e.a("browser", (String) map.get("id"), null);
            return true;
        }
    }

    private void m6760b(String str) {
        BrowserShareMenuController browserShareMenuController = this.f5527a;
        String uuid = SafeUUIDGenerator.a().toString();
        if (null != null) {
            Sequence e = browserShareMenuController.c.e(BrowserSequences.a);
            if (e != null) {
                SequenceLoggerDetour.e(e, "menu_share_new_post_press", 431211066);
            }
        }
        ((NavigationLogger) browserShareMenuController.e.get()).a("tap_share");
        browserShareMenuController.g.a(uuid, ComposerConfigurationFactory.a(ComposerSourceType.WEB_VIEW, Builder.a(str).b()).setIsFireAndForget(true).setInitialTargetData(ComposerTargetData.a).a(), browserShareMenuController.a);
    }
}
