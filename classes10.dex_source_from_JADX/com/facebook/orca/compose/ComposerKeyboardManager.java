package com.facebook.orca.compose;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.facebook.analytics.NavigationLogger;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.BugReportCategory;
import com.facebook.bugreporter.BugReportOperationLogger;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.ui.keyboard.CustomKeyboardContainer;
import com.facebook.common.ui.keyboard.CustomKeyboardHelper;
import com.facebook.common.ui.keyboard.CustomKeyboardLayout;
import com.facebook.common.ui.keyboard.CustomKeyboardLayout.OnCoverListener;
import com.facebook.debug.activitytracer.ActivityTrace;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.messaging.analytics.navigation.MessagingAnalyticsLogger;
import com.facebook.messaging.business.agent.view.MQuickReplyKeyboard;
import com.facebook.messaging.business.agent.view.MQuickReplyKeyboardView;
import com.facebook.messaging.business.common.analytics.BusinessAnalyticsLogger;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.composershortcuts.ComposerShortcutParam;
import com.facebook.messaging.emoji.EmojiKeyboard;
import com.facebook.messaging.emoji.EmojiKeyboardView;
import com.facebook.messaging.emoji.EmojiKeyboardView.EmojiPickerListener;
import com.facebook.messaging.keyboard.AbstractComposerKeyboard;
import com.facebook.messaging.keyboard.ComposerKeyboard;
import com.facebook.messaging.media.mediapicker.dialog.PickMediaSource;
import com.facebook.messaging.media.mediatray.MediaTrayKeyboard;
import com.facebook.messaging.media.mediatray.MediaTrayKeyboardView;
import com.facebook.messaging.media.mediatray.MediaTrayKeyboardView.MediaEditCallback;
import com.facebook.messaging.media.mediatray.MediaTrayKeyboardView.MediaTrayKeyboardClickListener;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.quickcam.QuickCamKeyboard;
import com.facebook.messaging.quickcam.QuickCamKeyboardView;
import com.facebook.messaging.react.keyboardinterface.ReactInstanceLifecycleHelper;
import com.facebook.messaging.react.keyboardinterface.ReactInstanceLifecycleHelperStub;
import com.facebook.messaging.tincan.view.EphemeralKeyboard;
import com.facebook.messaging.tincan.view.EphemeralKeyboardView;
import com.facebook.orca.compose.ComposeFragment.C07586;
import com.facebook.orca.creation.CreateThreadActivity;
import com.facebook.orca.emoji.ClassicAttachmentKeyboard;
import com.facebook.orca.emoji.ClassicAttachmentKeyboardView;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.qe.api.QeAccessor;
import com.facebook.stickers.keyboard.StickerKeyboard;
import com.facebook.stickers.keyboard.StickerKeyboardView;
import com.facebook.stickers.keyboard.StickerKeyboardView.StickerKeyboardListener;
import com.facebook.stickers.model.Sticker;
import com.facebook.ui.emoji.model.Emoji;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.user.cache.UserCache;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: org.torproject.android.intent.action.STATUS */
public class ComposerKeyboardManager {
    public BugReportOperationLogger f5469A;
    public DataCache f5470B;
    private final ImmutableMap<String, KeyboardFactory> f5471a = ImmutableMap.builder().b("emoji", new EmojiKeyboardFactory(this)).b("stickers", new StickerKeyboardFactory(this)).b("camera", new QuickcamKeyboardFactory(this)).b("gallery", new MediaTrayKeyboardFactory(this)).b("voice_clip", new VoiceClipsKeyboardFactory(this)).b("react_sample", new ReactKeyboardFactory(this)).b("ephemeral", new EphemeralKeyboardFactory(this)).b("quick_reply", new MQuickReplyKeyboardFactory(this)).b("classic", new ClassicAttachmentKeyboardFactory(this)).b();
    private final FbSharedPreferences f5472b;
    private final CustomKeyboardHelper f5473c;
    public final InputMethodManager f5474d;
    public final MessagingAnalyticsLogger f5475e;
    public final Lazy<NavigationLogger> f5476f;
    private final Provider<Boolean> f5477g;
    private final Provider<Boolean> f5478h;
    private final Provider<Boolean> f5479i;
    public final FbFragment f5480j;
    private final ZeroDialogController f5481k;
    private final QeAccessor f5482l;
    public final Lazy<ReactKeyboard> f5483m;
    private final Lazy<BusinessAnalyticsLogger> f5484n;
    private final UserCache f5485o;
    private final ReactInstanceLifecycleHelperStub f5486p;
    public final Map<String, KeyboardHolder> f5487q;
    public LayoutInflater f5488r;
    public C07586 f5489s;
    public ThreadKey f5490t;
    public KeyboardHolder f5491u;
    public CustomKeyboardLayout f5492v;
    private boolean f5493w;
    private boolean f5494x;
    private KeyboardHolder f5495y;
    private KeyboardState f5496z;

    /* compiled from: org.torproject.android.intent.action.STATUS */
    class C07661 implements Listener {
        final /* synthetic */ ComposerKeyboardManager f5441a;

        C07661(ComposerKeyboardManager composerKeyboardManager) {
            this.f5441a = composerKeyboardManager;
        }

        public final void m5017a(Object obj) {
            ComposerKeyboardManager.m5077d(this.f5441a, ((ComposerShortcutParam) obj).a);
        }

        public final void m5016a() {
        }
    }

    /* compiled from: org.torproject.android.intent.action.STATUS */
    class C07672 implements OnCoverListener {
        final /* synthetic */ ComposerKeyboardManager f5442a;

        C07672(ComposerKeyboardManager composerKeyboardManager) {
            this.f5442a = composerKeyboardManager;
        }

        public final void m5018a() {
            if (this.f5442a.f5491u == null || !this.f5442a.f5491u.f5452c.j()) {
                this.f5442a.m5083C();
            }
        }
    }

    /* compiled from: org.torproject.android.intent.action.STATUS */
    abstract class KeyboardFactory<T extends ComposerKeyboard> {
        abstract String mo152a();

        abstract T mo154b();

        abstract void mo155b(T t);

        void mo153a(T t) {
        }
    }

    /* compiled from: org.torproject.android.intent.action.STATUS */
    public class ClassicAttachmentKeyboardFactory extends KeyboardFactory<ClassicAttachmentKeyboard> {
        public final /* synthetic */ ComposerKeyboardManager f5445a;

        /* compiled from: org.torproject.android.intent.action.STATUS */
        public class C07691 {
            public final /* synthetic */ ClassicAttachmentKeyboardFactory f5444a;

            C07691(ClassicAttachmentKeyboardFactory classicAttachmentKeyboardFactory) {
                this.f5444a = classicAttachmentKeyboardFactory;
            }

            public final void m5019a(Emoji emoji) {
                if (this.f5444a.f5445a.f5489s != null) {
                    this.f5444a.f5445a.f5489s.m4806a(emoji);
                }
            }

            public final void m5020b() {
                if (this.f5444a.f5445a.f5489s != null) {
                    this.f5444a.f5445a.f5489s.m4802a();
                }
            }
        }

        public ClassicAttachmentKeyboardFactory(ComposerKeyboardManager composerKeyboardManager) {
            this.f5445a = composerKeyboardManager;
        }

        final void mo153a(AbstractComposerKeyboard abstractComposerKeyboard) {
            ClassicAttachmentKeyboard classicAttachmentKeyboard = (ClassicAttachmentKeyboard) abstractComposerKeyboard;
            ComposerKeyboardManager composerKeyboardManager = this.f5445a;
            boolean z = composerKeyboardManager.f5489s != null && composerKeyboardManager.f5489s.m4814b();
            classicAttachmentKeyboard.m5897a(z);
        }

        final void mo155b(AbstractComposerKeyboard abstractComposerKeyboard) {
            ((ClassicAttachmentKeyboardView) ((ClassicAttachmentKeyboard) abstractComposerKeyboard).a).f6174j = new C07691(this);
        }

        final AbstractComposerKeyboard mo154b() {
            return new ClassicAttachmentKeyboard();
        }

        final String mo152a() {
            return "attachment_popup";
        }
    }

    /* compiled from: org.torproject.android.intent.action.STATUS */
    class EmojiKeyboardFactory extends KeyboardFactory<EmojiKeyboard> {
        final /* synthetic */ ComposerKeyboardManager f5447a;

        /* compiled from: org.torproject.android.intent.action.STATUS */
        class C07701 implements EmojiPickerListener {
            final /* synthetic */ EmojiKeyboardFactory f5446a;

            C07701(EmojiKeyboardFactory emojiKeyboardFactory) {
                this.f5446a = emojiKeyboardFactory;
            }

            public final void m5030a(Emoji emoji) {
                if (this.f5446a.f5447a.f5489s != null) {
                    this.f5446a.f5447a.f5489s.m4806a(emoji);
                }
            }

            public final void m5029a() {
                if (this.f5446a.f5447a.f5489s != null) {
                    this.f5446a.f5447a.f5489s.m4802a();
                }
            }
        }

        public EmojiKeyboardFactory(ComposerKeyboardManager composerKeyboardManager) {
            this.f5447a = composerKeyboardManager;
        }

        final void mo155b(AbstractComposerKeyboard abstractComposerKeyboard) {
            ((EmojiKeyboardView) ((EmojiKeyboard) abstractComposerKeyboard).a).l = new C07701(this);
        }

        final AbstractComposerKeyboard mo154b() {
            return new EmojiKeyboard();
        }

        final String mo152a() {
            return "emoji_popup";
        }
    }

    /* compiled from: org.torproject.android.intent.action.STATUS */
    class EphemeralKeyboardFactory extends KeyboardFactory<EphemeralKeyboard> {
        final /* synthetic */ ComposerKeyboardManager f5449a;

        /* compiled from: org.torproject.android.intent.action.STATUS */
        public class C07711 {
            final /* synthetic */ EphemeralKeyboardFactory f5448a;

            C07711(EphemeralKeyboardFactory ephemeralKeyboardFactory) {
                this.f5448a = ephemeralKeyboardFactory;
            }

            public final void m5034a(int i) {
                if (this.f5448a.f5449a.f5489s != null) {
                    this.f5448a.f5449a.f5489s.m4803a(i);
                }
            }
        }

        public EphemeralKeyboardFactory(ComposerKeyboardManager composerKeyboardManager) {
            this.f5449a = composerKeyboardManager;
        }

        final void mo155b(AbstractComposerKeyboard abstractComposerKeyboard) {
            ((EphemeralKeyboardView) ((EphemeralKeyboard) abstractComposerKeyboard).a).f4849d = new C07711(this);
        }

        final AbstractComposerKeyboard mo154b() {
            return new EphemeralKeyboard();
        }

        final String mo152a() {
            return "ephemeral_keyboard";
        }
    }

    /* compiled from: org.torproject.android.intent.action.STATUS */
    public class KeyboardHolder<T extends ComposerKeyboard> {
        final KeyboardFactory<T> f5450a;
        public final String f5451b;
        public final T f5452c;
        final String f5453d;
        View f5454e;
        public KeyboardState f5455f = KeyboardState.INIT;

        public KeyboardHolder(String str, KeyboardFactory<T> keyboardFactory, T t, String str2) {
            this.f5451b = str;
            this.f5450a = keyboardFactory;
            this.f5452c = t;
            this.f5453d = str2;
        }
    }

    /* compiled from: org.torproject.android.intent.action.STATUS */
    public enum KeyboardState {
        INIT,
        CREATED,
        OPENED,
        SHOWN
    }

    /* compiled from: org.torproject.android.intent.action.STATUS */
    public class MQuickReplyKeyboardFactory extends KeyboardFactory<MQuickReplyKeyboard> {
        public final /* synthetic */ ComposerKeyboardManager f5457a;

        /* compiled from: org.torproject.android.intent.action.STATUS */
        public class C07721 {
            public final /* synthetic */ MQuickReplyKeyboardFactory f5456a;

            C07721(MQuickReplyKeyboardFactory mQuickReplyKeyboardFactory) {
                this.f5456a = mQuickReplyKeyboardFactory;
            }
        }

        public MQuickReplyKeyboardFactory(ComposerKeyboardManager composerKeyboardManager) {
            this.f5457a = composerKeyboardManager;
        }

        final void mo155b(AbstractComposerKeyboard abstractComposerKeyboard) {
            ((MQuickReplyKeyboardView) ((MQuickReplyKeyboard) abstractComposerKeyboard).a).f1500h = new C07721(this);
        }

        final AbstractComposerKeyboard mo154b() {
            return new MQuickReplyKeyboard();
        }

        final String mo152a() {
            return "m_quick_reply";
        }
    }

    /* compiled from: org.torproject.android.intent.action.STATUS */
    class MediaTrayKeyboardFactory extends KeyboardFactory<MediaTrayKeyboard> {
        final /* synthetic */ ComposerKeyboardManager f5458a;

        public MediaTrayKeyboardFactory(ComposerKeyboardManager composerKeyboardManager) {
            this.f5458a = composerKeyboardManager;
        }

        final void mo155b(AbstractComposerKeyboard abstractComposerKeyboard) {
            ((MediaTrayKeyboardView) ((MediaTrayKeyboard) abstractComposerKeyboard).a).f3096C = new MediaTrayKeyboardListener(this.f5458a);
        }

        final AbstractComposerKeyboard mo154b() {
            return new MediaTrayKeyboard(this.f5458a.f5488r);
        }

        final String mo152a() {
            return "media_tray_popup";
        }
    }

    /* compiled from: org.torproject.android.intent.action.STATUS */
    class MediaTrayKeyboardListener implements MediaTrayKeyboardClickListener {
        final /* synthetic */ ComposerKeyboardManager f5459a;

        public MediaTrayKeyboardListener(ComposerKeyboardManager composerKeyboardManager) {
            this.f5459a = composerKeyboardManager;
        }

        public final void mo159a(List<MediaResource> list, boolean z) {
            if (this.f5459a.f5489s == null) {
                return;
            }
            if (z) {
                this.f5459a.f5489s.m4810a((List) list);
                return;
            }
            for (MediaResource b : list) {
                this.f5459a.f5489s.m4812b(b);
            }
        }

        public final void mo157a(MediaResource mediaResource) {
            if (this.f5459a.f5489s != null) {
                this.f5459a.f5489s.m4812b(mediaResource);
            }
        }

        public final void mo158a(MediaResource mediaResource, @Nullable MediaEditCallback mediaEditCallback) {
            if (this.f5459a.f5489s != null) {
                this.f5459a.f5489s.m4808a(mediaResource, mediaEditCallback);
            }
        }

        public final void mo156a() {
            this.f5459a.f5469A.a("Click on gallery button", BugReportCategory.MEDIA_TRAY);
            if (this.f5459a.f5489s != null) {
                this.f5459a.f5489s.m4804a(PickMediaSource.GALLERY);
            }
        }

        public final void mo160a(String[] strArr) {
            if (this.f5459a.f5489s != null) {
                this.f5459a.f5489s.m4811a(strArr);
            }
        }
    }

    /* compiled from: org.torproject.android.intent.action.STATUS */
    public class QuickcamKeyboardFactory extends KeyboardFactory<QuickCamKeyboard> {
        public final /* synthetic */ ComposerKeyboardManager f5461a;

        /* compiled from: org.torproject.android.intent.action.STATUS */
        public class C07731 {
            public final /* synthetic */ QuickcamKeyboardFactory f5460a;

            C07731(QuickcamKeyboardFactory quickcamKeyboardFactory) {
                this.f5460a = quickcamKeyboardFactory;
            }
        }

        public QuickcamKeyboardFactory(ComposerKeyboardManager composerKeyboardManager) {
            this.f5461a = composerKeyboardManager;
        }

        final void mo155b(AbstractComposerKeyboard abstractComposerKeyboard) {
            QuickCamKeyboard quickCamKeyboard = (QuickCamKeyboard) abstractComposerKeyboard;
            ((QuickCamKeyboardView) quickCamKeyboard.a).ar = new C07731(this);
            Activity ao = this.f5461a.f5480j.ao();
            if (ao != null && (ao instanceof CreateThreadActivity)) {
                ((QuickCamKeyboardView) quickCamKeyboard.a).aF = false;
            }
        }

        final AbstractComposerKeyboard mo154b() {
            return new QuickCamKeyboard(this.f5461a.f5480j.getContext());
        }

        final String mo152a() {
            return "quickcam_popup";
        }
    }

    /* compiled from: org.torproject.android.intent.action.STATUS */
    class ReactKeyboardFactory extends KeyboardFactory<ReactKeyboard> {
        final /* synthetic */ ComposerKeyboardManager f5463a;

        /* compiled from: org.torproject.android.intent.action.STATUS */
        class C07741 {
            final /* synthetic */ ReactKeyboardFactory f5462a;

            C07741(ReactKeyboardFactory reactKeyboardFactory) {
                this.f5462a = reactKeyboardFactory;
            }
        }

        public ReactKeyboardFactory(ComposerKeyboardManager composerKeyboardManager) {
            this.f5463a = composerKeyboardManager;
        }

        final void mo155b(AbstractComposerKeyboard abstractComposerKeyboard) {
            ReactKeyboard reactKeyboard = (ReactKeyboard) abstractComposerKeyboard;
            C07741 c07741 = new C07741(this);
        }

        final AbstractComposerKeyboard mo154b() {
            this.f5463a.f5480j.ao();
            return (ReactKeyboard) this.f5463a.f5483m.get();
        }

        final String mo152a() {
            return "react-keyboard";
        }
    }

    /* compiled from: org.torproject.android.intent.action.STATUS */
    class StickerKeyboardFactory extends KeyboardFactory<StickerKeyboard> {
        final /* synthetic */ ComposerKeyboardManager f5466a;

        /* compiled from: org.torproject.android.intent.action.STATUS */
        class C07751 implements StickerKeyboardListener {
            boolean f5464a;
            final /* synthetic */ StickerKeyboardFactory f5465b;

            C07751(StickerKeyboardFactory stickerKeyboardFactory) {
                this.f5465b = stickerKeyboardFactory;
            }

            public final void m5055a() {
                this.f5465b.f5466a.m5090d();
            }

            public final void m5058b() {
                String str;
                ActivityTrace activityTrace = this.f5465b.f5466a.f5475e.g.g;
                if (activityTrace != null) {
                    str = activityTrace.h;
                } else {
                    str = null;
                }
                if ("sticker_keyboard".equals(str)) {
                    this.f5465b.f5466a.f5475e.a("is_async_load", Boolean.valueOf(this.f5464a));
                    this.f5465b.f5466a.f5475e.c("sticker_keyboard");
                }
            }

            public final void m5059c() {
                this.f5464a = true;
            }

            public final void m5056a(Sticker sticker) {
                if (this.f5465b.f5466a.f5489s != null) {
                    this.f5465b.f5466a.f5489s.m4805a(sticker);
                }
            }

            public final void m5057a(String str) {
                this.f5465b.f5466a.f5489s.m4816c(str);
            }
        }

        public StickerKeyboardFactory(ComposerKeyboardManager composerKeyboardManager) {
            this.f5466a = composerKeyboardManager;
        }

        final void mo155b(AbstractComposerKeyboard abstractComposerKeyboard) {
            ((StickerKeyboardView) ((StickerKeyboard) abstractComposerKeyboard).a).f = new C07751(this);
        }

        final AbstractComposerKeyboard mo154b() {
            return new StickerKeyboard();
        }

        final String mo152a() {
            return "sticker_keyboard";
        }
    }

    /* compiled from: org.torproject.android.intent.action.STATUS */
    class VoiceClipsKeyboardFactory extends KeyboardFactory<VoiceClipKeyboard> {
        final /* synthetic */ ComposerKeyboardManager f5468a;

        /* compiled from: org.torproject.android.intent.action.STATUS */
        class C07761 implements VoiceClipKeyboardView.Listener {
            final /* synthetic */ VoiceClipsKeyboardFactory f5467a;

            C07761(VoiceClipsKeyboardFactory voiceClipsKeyboardFactory) {
                this.f5467a = voiceClipsKeyboardFactory;
            }

            public final void mo161a(MediaResource mediaResource, ThreadKey threadKey) {
                if (Objects.equal(threadKey, this.f5467a.f5468a.f5490t) && this.f5467a.f5468a.f5489s != null) {
                    this.f5467a.f5468a.f5489s.m4815c(mediaResource);
                }
            }

            public final void mo162a(String[] strArr) {
                if (this.f5467a.f5468a.f5489s != null) {
                    this.f5467a.f5468a.f5489s.m4811a(strArr);
                }
            }
        }

        public VoiceClipsKeyboardFactory(ComposerKeyboardManager composerKeyboardManager) {
            this.f5468a = composerKeyboardManager;
        }

        final void mo155b(AbstractComposerKeyboard abstractComposerKeyboard) {
            ((VoiceClipKeyboardView) ((VoiceClipKeyboard) abstractComposerKeyboard).a).f5693k = new C07761(this);
        }

        final AbstractComposerKeyboard mo154b() {
            return new VoiceClipKeyboard(this.f5468a.f5488r);
        }

        final String mo152a() {
            return "audio_popup";
        }
    }

    @Inject
    ComposerKeyboardManager(FbSharedPreferences fbSharedPreferences, CustomKeyboardHelper customKeyboardHelper, InputMethodManager inputMethodManager, MessagingAnalyticsLogger messagingAnalyticsLogger, Lazy<NavigationLogger> lazy, ZeroDialogController zeroDialogController, BugReportOperationLogger bugReportOperationLogger, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, ReactInstanceLifecycleHelper reactInstanceLifecycleHelper, @Assisted FbFragment fbFragment, QeAccessor qeAccessor, Lazy<ReactKeyboard> lazy2, Lazy<BusinessAnalyticsLogger> lazy3, UserCache userCache, DataCache dataCache) {
        this.f5472b = fbSharedPreferences;
        this.f5473c = customKeyboardHelper;
        this.f5474d = inputMethodManager;
        this.f5475e = messagingAnalyticsLogger;
        this.f5476f = lazy;
        this.f5477g = provider;
        this.f5478h = provider2;
        this.f5479i = provider3;
        this.f5480j = fbFragment;
        this.f5481k = zeroDialogController;
        this.f5485o = userCache;
        this.f5487q = Maps.c();
        this.f5469A = bugReportOperationLogger;
        this.f5482l = qeAccessor;
        this.f5483m = lazy2;
        this.f5484n = lazy3;
        this.f5486p = reactInstanceLifecycleHelper;
        this.f5470B = dataCache;
        m5070E();
    }

    private void m5070E() {
        Context context = this.f5480j.getContext();
        C07661 c07661 = new C07661(this);
        this.f5481k.a(ZeroFeatureKey.VIDEO_UPLOAD_INTERSTITIAL, context.getString(2131232931), c07661);
        this.f5481k.a(ZeroFeatureKey.ATTACHMENT_UPLOAD_INTERSTITIAL, context.getString(2131232935), c07661);
        this.f5481k.a(ZeroFeatureKey.AUDIO_UPLOAD_INTERSTITIAL, context.getString(2131232933), c07661);
        this.f5481k.a(ZeroFeatureKey.LOCATION_SERVICES_INTERSTITIAL, context.getString(2131232930), c07661);
    }

    public final StickerKeyboard m5088c() {
        m5077d(this, "stickers");
        return (StickerKeyboard) m5084a("stickers");
    }

    final void m5090d() {
        m5080f("stickers");
    }

    public final MQuickReplyKeyboard m5091e() {
        m5077d(this, "quick_reply");
        return (MQuickReplyKeyboard) m5084a("quick_reply");
    }

    final void m5092g() {
        m5080f("quick_reply");
    }

    @Nullable
    public final QuickCamKeyboard m5093h() {
        this.f5481k.a(ZeroFeatureKey.VIDEO_UPLOAD_INTERSTITIAL, this.f5480j.kO_(), new ComposerShortcutParam("camera"));
        return (QuickCamKeyboard) m5084a("camera");
    }

    public final void m5094i() {
        m5080f("camera");
    }

    @Nullable
    public final MediaTrayKeyboard m5095j() {
        this.f5481k.a(ZeroFeatureKey.VIDEO_UPLOAD_INTERSTITIAL, this.f5480j.kO_(), new ComposerShortcutParam("gallery"));
        return (MediaTrayKeyboard) m5084a("gallery");
    }

    final void m5096k() {
        m5080f("gallery");
    }

    public final EmojiKeyboard m5097l() {
        m5077d(this, "emoji");
        return (EmojiKeyboard) m5084a("emoji");
    }

    final void m5098m() {
        m5080f("emoji");
    }

    public final ClassicAttachmentKeyboard m5099n() {
        m5077d(this, "classic");
        return (ClassicAttachmentKeyboard) m5084a("classic");
    }

    final void m5100o() {
        m5080f("classic");
    }

    @Nullable
    public final VoiceClipKeyboard m5101p() {
        this.f5481k.a(ZeroFeatureKey.AUDIO_UPLOAD_INTERSTITIAL, this.f5480j.kO_(), new ComposerShortcutParam("voice_clip"));
        return (VoiceClipKeyboard) m5084a("voice_clip");
    }

    final void m5102q() {
        m5080f("voice_clip");
    }

    public final ReactKeyboard m5103r() {
        m5077d(this, "react_sample");
        return (ReactKeyboard) m5084a("react_sample");
    }

    final void m5104s() {
        m5080f("react_sample");
    }

    final void m5086a(boolean z) {
        this.f5494x = z;
        if (this.f5491u != null) {
            m5073a(this.f5491u, z ? KeyboardState.SHOWN : KeyboardState.OPENED);
        }
    }

    final void m5105u() {
        m5080f("ephemeral");
    }

    final void m5106v() {
        this.f5480j.ao();
    }

    final void m5107w() {
        Iterator it = this.f5471a.keySet().iterator();
        while (it.hasNext()) {
            m5082h((String) it.next());
        }
    }

    final boolean m5108x() {
        if (this.f5491u == null) {
            return false;
        }
        m5080f(this.f5491u.f5451b);
        return true;
    }

    final void m5109z() {
        m5071G().a();
    }

    public static void m5077d(ComposerKeyboardManager composerKeyboardManager, String str) {
        Object obj;
        if (composerKeyboardManager.f5480j.x || !composerKeyboardManager.f5480j.mx_() || composerKeyboardManager.f5480j.L) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            Object obj2;
            if (composerKeyboardManager.m5089c(str)) {
                KeyboardHolder keyboardHolder = (KeyboardHolder) composerKeyboardManager.f5487q.get(str);
                keyboardHolder.f5452c.f();
                Activity ao = composerKeyboardManager.f5480j.ao();
                if (ao != null) {
                    ao.getWindow().setSoftInputMode(keyboardHolder.f5452c.k());
                }
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                composerKeyboardManager.m5083C();
                composerKeyboardManager.f5475e.a("composer", ((KeyboardFactory) composerKeyboardManager.f5471a.get(str)).mo152a());
                composerKeyboardManager.m5081g(str);
                KeyboardHolder keyboardHolder2 = (KeyboardHolder) composerKeyboardManager.f5487q.get(str);
                composerKeyboardManager.m5073a(keyboardHolder2, composerKeyboardManager.f5494x ? KeyboardState.SHOWN : KeyboardState.OPENED);
                Activity ao2 = composerKeyboardManager.f5480j.ao();
                if (ao2 != null) {
                    ao2.getWindow().setSoftInputMode(keyboardHolder2.f5452c.k());
                }
            }
        }
    }

    private void m5080f(String str) {
        Activity ao = this.f5480j.ao();
        if (ao != null) {
            ao.getWindow().setSoftInputMode(16);
        }
        if (m5089c(str)) {
            m5073a((KeyboardHolder) this.f5487q.get(str), KeyboardState.CREATED);
        }
    }

    private void m5073a(KeyboardHolder keyboardHolder, KeyboardState keyboardState) {
        Preconditions.checkState(!this.f5493w, "Reentrancy in advanceState for keyboard %s", new Object[]{keyboardHolder.f5453d});
        this.f5493w = true;
        this.f5495y = keyboardHolder;
        this.f5496z = keyboardState;
        try {
            KeyboardState keyboardState2 = keyboardHolder.f5455f;
            if (keyboardState.ordinal() > keyboardHolder.f5455f.ordinal()) {
                while (keyboardHolder.f5455f != keyboardState) {
                    switch (keyboardHolder.f5455f) {
                        case CREATED:
                            m5075c(keyboardHolder);
                            break;
                        case OPENED:
                            m5078e(keyboardHolder);
                            break;
                        default:
                            throw new IllegalStateException(m5072a(keyboardHolder, keyboardState2, keyboardState));
                    }
                }
            }
            while (keyboardHolder.f5455f != keyboardState) {
                switch (keyboardHolder.f5455f) {
                    case CREATED:
                        m5074b(keyboardHolder);
                        break;
                    case OPENED:
                        m5076d(keyboardHolder);
                        break;
                    case SHOWN:
                        m5079f(keyboardHolder);
                        break;
                    default:
                        throw new IllegalStateException(m5072a(keyboardHolder, keyboardState2, keyboardState));
                }
            }
            this.f5493w = false;
            this.f5495y = null;
            this.f5496z = null;
        } catch (Throwable th) {
            this.f5493w = false;
            this.f5495y = null;
            this.f5496z = null;
        }
    }

    private static String m5072a(KeyboardHolder keyboardHolder, KeyboardState keyboardState, KeyboardState keyboardState2) {
        return StringFormatUtil.a("Unexpected state %s advancing from %s to %s for keyboard %s", new Object[]{keyboardHolder.f5455f, keyboardState, keyboardState2, keyboardHolder.f5453d});
    }

    private static <T extends ComposerKeyboard> void m5074b(KeyboardHolder<T> keyboardHolder) {
        Preconditions.checkArgument(keyboardHolder.f5455f == KeyboardState.CREATED);
        keyboardHolder.f5455f = KeyboardState.INIT;
    }

    private <T extends ComposerKeyboard> void m5075c(KeyboardHolder<T> keyboardHolder) {
        boolean z = true;
        Preconditions.checkArgument(keyboardHolder.f5455f == KeyboardState.CREATED);
        if (this.f5491u != null) {
            z = false;
        }
        Preconditions.checkState(z);
        keyboardHolder.f5454e.setVisibility(0);
        keyboardHolder.f5454e.requestFocus();
        keyboardHolder.f5455f = KeyboardState.OPENED;
        this.f5491u = keyboardHolder;
        String str = keyboardHolder.f5451b;
        if (this.f5489s != null) {
            this.f5489s.m4809a(str);
        }
        str = keyboardHolder.f5453d;
        if (((NavigationLogger) this.f5476f.get()).u == null) {
            ((NavigationLogger) this.f5476f.get()).a("tap_composer_list_item");
        }
        ((NavigationLogger) this.f5476f.get()).a(str, false, null);
        this.f5474d.hideSoftInputFromWindow(this.f5480j.T.getWindowToken(), 0);
        keyboardHolder.f5450a.mo153a(keyboardHolder.f5452c);
        keyboardHolder.f5452c.b();
    }

    private <T extends ComposerKeyboard> void m5076d(KeyboardHolder<T> keyboardHolder) {
        boolean z = true;
        Preconditions.checkState(this.f5491u == keyboardHolder);
        if (keyboardHolder.f5455f != KeyboardState.OPENED) {
            z = false;
        }
        Preconditions.checkArgument(z);
        keyboardHolder.f5454e.setVisibility(8);
        this.f5491u = null;
        keyboardHolder.f5455f = KeyboardState.CREATED;
        String str = keyboardHolder.f5451b;
        if (this.f5489s != null) {
            this.f5489s.m4813b(str);
        }
        str = keyboardHolder.f5453d;
        if (((NavigationLogger) this.f5476f.get()).u == null) {
            ((NavigationLogger) this.f5476f.get()).a("tap_composer_list_item");
        }
        ((NavigationLogger) this.f5476f.get()).a(str, null);
        keyboardHolder.f5452c.e();
    }

    private <T extends ComposerKeyboard> void m5078e(KeyboardHolder<T> keyboardHolder) {
        boolean z;
        boolean z2 = true;
        if (this.f5491u == keyboardHolder) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (keyboardHolder.f5455f != KeyboardState.OPENED) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        keyboardHolder.f5455f = KeyboardState.SHOWN;
        keyboardHolder.f5452c.c();
    }

    private <T extends ComposerKeyboard> void m5079f(KeyboardHolder<T> keyboardHolder) {
        boolean z;
        boolean z2 = true;
        if (this.f5491u == keyboardHolder) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (keyboardHolder.f5455f != KeyboardState.SHOWN) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        keyboardHolder.f5455f = KeyboardState.OPENED;
        keyboardHolder.f5452c.d();
    }

    private <T extends ComposerKeyboard> void m5081g(String str) {
        if (((KeyboardHolder) this.f5487q.get(str)) == null) {
            KeyboardFactory keyboardFactory = (KeyboardFactory) this.f5471a.get(str);
            AbstractComposerKeyboard b = keyboardFactory.mo154b();
            KeyboardHolder keyboardHolder = new KeyboardHolder(str, keyboardFactory, b, keyboardFactory.mo152a());
            Preconditions.checkArgument(keyboardHolder.f5455f == KeyboardState.INIT);
            keyboardHolder.f5455f = KeyboardState.CREATED;
            CustomKeyboardLayout G = m5071G();
            b.a = b.b(G);
            keyboardHolder.f5454e = b.a;
            b.a(this.f5490t);
            keyboardFactory.mo155b(b);
            this.f5487q.put(str, keyboardHolder);
            keyboardHolder.f5454e.setVisibility(8);
            G.addView(keyboardHolder.f5454e);
        }
    }

    private void m5082h(String str) {
        KeyboardHolder keyboardHolder = (KeyboardHolder) this.f5487q.remove(str);
        if (keyboardHolder != null) {
            m5073a(keyboardHolder, KeyboardState.INIT);
            ViewGroup viewGroup = (ViewGroup) keyboardHolder.f5454e.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(keyboardHolder.f5454e);
            }
        }
    }

    public final <T extends ComposerKeyboard> T m5084a(String str) {
        if (this.f5491u != null && Objects.equal(this.f5491u.f5451b, str)) {
            return this.f5491u.f5452c;
        }
        return null;
    }

    public final <T extends ComposerKeyboard> T m5087b(String str) {
        KeyboardHolder keyboardHolder = (KeyboardHolder) this.f5487q.get(str);
        return keyboardHolder != null ? keyboardHolder.f5452c : null;
    }

    public final boolean m5089c(String str) {
        return this.f5491u != null && Objects.equal(str, this.f5491u.f5451b);
    }

    final void m5083C() {
        if (this.f5491u != null) {
            m5080f(this.f5491u.f5451b);
        }
    }

    final void m5085a(int i) {
        m5071G().j = i;
    }

    private CustomKeyboardLayout m5071G() {
        if (this.f5492v == null) {
            CustomKeyboardLayout c;
            FbFragment fbFragment = this.f5480j;
            CustomKeyboardContainer customKeyboardContainer = (CustomKeyboardContainer) fbFragment.a(CustomKeyboardContainer.class);
            if (customKeyboardContainer != null) {
                c = customKeyboardContainer.c();
            } else {
                View rootView = fbFragment.T.getRootView();
                if (rootView instanceof CustomKeyboardContainer) {
                    c = ((CustomKeyboardContainer) rootView).c();
                } else {
                    c = (CustomKeyboardLayout) rootView.findViewById(2131560874);
                }
            }
            this.f5492v = c;
            this.f5492v.h = new C07672(this);
        }
        return this.f5492v;
    }
}
