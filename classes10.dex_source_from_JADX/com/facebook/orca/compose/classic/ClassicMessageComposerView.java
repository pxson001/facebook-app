package com.facebook.orca.compose.classic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.ui.util.CompoundTouchDelegate;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.annotations.IsSendOnEnterEnabled;
import com.facebook.messaging.composer.edit.MessageComposerEditor;
import com.facebook.messaging.composer.edit.MessageComposerEditorProvider;
import com.facebook.messaging.composer.triggers.ContentSearchType;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.quickpromotion.QuickPromotionBannerView.ComposerPointerLocation;
import com.facebook.messaging.sms.abtest.SmsGatekeepers;
import com.facebook.orca.compose.AttachmentContainer;
import com.facebook.orca.compose.AttachmentContainer.Callback;
import com.facebook.orca.compose.ComposeFragment.AnonymousClass32;
import com.facebook.orca.compose.ComposeMode;
import com.facebook.orca.compose.ContentSearchParams;
import com.facebook.orca.compose.MessageComposer;
import com.facebook.orca.compose.classic.ClassicSendButton.ButtonMode;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ultralight.Inject;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterEditTextView;
import com.facebook.widget.touch.TouchDelegateUtils;
import javax.annotation.Nullable;

/* compiled from: openDialogWebview */
public class ClassicMessageComposerView extends CustomLinearLayout implements AttachmentContainer, MessageComposer {
    @Inject
    private Product f5746a;
    @Inject
    private InputMethodManager f5747b;
    @Inject
    @IsSendOnEnterEnabled
    private TriState f5748c;
    @Inject
    private MessageComposerEditorProvider f5749d;
    @Inject
    private SmsGatekeepers f5750e;
    private ClassicComposeEditContainerView f5751f;
    private final BetterEditTextView f5752g;
    public final View f5753h;
    public final View f5754i;
    public final ClassicSendButton f5755j;
    private final TextView f5756k;
    private final ClassicComposeAttachmentContainer f5757l;
    public final MessageComposerEditor f5758m;
    @Nullable
    public ThreadKey f5759n;
    private int f5760o;
    private TouchDelegate f5761p;
    private TouchDelegate f5762q;
    private ComposeMode f5763r;
    public AnonymousClass32 f5764s;
    public Callback f5765t;
    private boolean f5766u;
    private boolean f5767v;
    private boolean f5768w;
    public boolean f5769x;

    /* compiled from: openDialogWebview */
    class C08271 implements OnClickListener {
        final /* synthetic */ ClassicMessageComposerView f5738a;

        C08271(ClassicMessageComposerView classicMessageComposerView) {
            this.f5738a = classicMessageComposerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1888084045);
            boolean z = !this.f5738a.f5753h.isSelected();
            this.f5738a.f5753h.setSelected(z);
            if (z) {
                this.f5738a.f5764s.m4768d();
            } else {
                this.f5738a.f5764s.m4769e();
            }
            LogUtils.a(1974322279, a);
        }
    }

    /* compiled from: openDialogWebview */
    class C08282 implements OnTouchListener {
        final /* synthetic */ ClassicMessageComposerView f5739a;

        C08282(ClassicMessageComposerView classicMessageComposerView) {
            this.f5739a = classicMessageComposerView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f5739a.f5764s.m4765b();
            this.f5739a.f5753h.setSelected(false);
            this.f5739a.f5754i.setSelected(false);
            this.f5739a.f5764s.m4777m();
            this.f5739a.f5764s.m4769e();
            return false;
        }
    }

    /* compiled from: openDialogWebview */
    class C08293 implements TextWatcher {
        final /* synthetic */ ClassicMessageComposerView f5740a;

        C08293(ClassicMessageComposerView classicMessageComposerView) {
            this.f5740a = classicMessageComposerView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ClassicMessageComposerView.m5430m(this.f5740a);
            if (i3 > 0) {
                this.f5740a.f5758m.a(i, i3);
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: openDialogWebview */
    class C08304 implements OnEditorActionListener {
        final /* synthetic */ ClassicMessageComposerView f5741a;

        C08304(ClassicMessageComposerView classicMessageComposerView) {
            this.f5741a = classicMessageComposerView;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 4 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
                return false;
            }
            this.f5741a.f5764s.m4780p();
            return true;
        }
    }

    /* compiled from: openDialogWebview */
    class C08315 implements OnClickListener {
        final /* synthetic */ ClassicMessageComposerView f5742a;

        C08315(ClassicMessageComposerView classicMessageComposerView) {
            this.f5742a = classicMessageComposerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1327623667);
            boolean z = !this.f5742a.f5754i.isSelected();
            this.f5742a.f5754i.setSelected(z);
            if (z) {
                this.f5742a.f5764s.m4774j();
            } else {
                this.f5742a.f5764s.m4778n();
            }
            LogUtils.a(207701858, a);
        }
    }

    /* compiled from: openDialogWebview */
    class C08326 implements OnClickListener {
        final /* synthetic */ ClassicMessageComposerView f5743a;

        C08326(ClassicMessageComposerView classicMessageComposerView) {
            this.f5743a = classicMessageComposerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2051149685);
            if (m5412a()) {
                this.f5743a.f5764s.m4784t();
            } else {
                this.f5743a.f5764s.m4780p();
            }
            LogUtils.a(-1648474748, a);
        }

        private boolean m5412a() {
            if ((this.f5743a.f5769x || ThreadKey.g(this.f5743a.f5759n)) && this.f5743a.f5755j.f5772c == ButtonMode.LIKE_BUTTON) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: openDialogWebview */
    class C08337 implements OnTouchListener {
        final /* synthetic */ ClassicMessageComposerView f5744a;

        C08337(ClassicMessageComposerView classicMessageComposerView) {
            this.f5744a = classicMessageComposerView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f5744a.f5755j.f5772c == ButtonMode.LIKE_BUTTON) {
                return this.f5744a.f5764s.m4764a(view, motionEvent);
            }
            return false;
        }
    }

    /* compiled from: openDialogWebview */
    class C08348 implements Callback {
        final /* synthetic */ ClassicMessageComposerView f5745a;

        C08348(ClassicMessageComposerView classicMessageComposerView) {
            this.f5745a = classicMessageComposerView;
        }

        public final void mo142a(MediaResource mediaResource) {
            this.f5745a.f5765t.mo142a(mediaResource);
        }

        public final void mo143b(MediaResource mediaResource) {
            this.f5745a.f5765t.mo143b(mediaResource);
        }
    }

    private static <T extends View> void m5417a(Class<T> cls, T t) {
        m5418a((Object) t, t.getContext());
    }

    private static void m5418a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ClassicMessageComposerView) obj).m5416a(ProductMethodAutoProvider.b(fbInjector), InputMethodManagerMethodAutoProvider.b(fbInjector), GatekeeperStoreImplMethodAutoProvider.a(fbInjector).a(966), (MessageComposerEditorProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(MessageComposerEditorProvider.class), SmsGatekeepers.b(fbInjector));
    }

    public ClassicMessageComposerView(Context context) {
        this(context, null, 0);
    }

    public ClassicMessageComposerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void m5416a(Product product, InputMethodManager inputMethodManager, TriState triState, MessageComposerEditorProvider messageComposerEditorProvider, SmsGatekeepers smsGatekeepers) {
        this.f5746a = product;
        this.f5747b = inputMethodManager;
        this.f5748c = triState;
        this.f5749d = messageComposerEditorProvider;
        this.f5750e = smsGatekeepers;
    }

    public ClassicMessageComposerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5759n = null;
        this.f5766u = true;
        this.f5769x = false;
        m5417a(ClassicMessageComposerView.class, (View) this);
        setOrientation(1);
        setContentView(2130905590);
        setFocusable(true);
        this.f5751f = (ClassicComposeEditContainerView) a(2131564521);
        this.f5752g = (BetterEditTextView) a(2131564522);
        this.f5753h = a(2131564519);
        this.f5754i = a(2131564523);
        this.f5756k = (TextView) a(2131564524);
        this.f5757l = (ClassicComposeAttachmentContainer) a(2131564518);
        ((ViewStub) findViewById(2131564525)).inflate();
        this.f5755j = (ClassicSendButton) a(2131564526);
        this.f5753h.setOnClickListener(new C08271(this));
        this.f5752g.setOnTouchListener(new C08282(this));
        this.f5752g.addTextChangedListener(new C08293(this));
        this.f5758m = this.f5749d.a(this.f5752g);
        if (this.f5748c.asBoolean(false)) {
            this.f5752g.setImeOptions(33554436);
            this.f5752g.setOnEditorActionListener(new C08304(this));
        }
        this.f5754i.setOnClickListener(new C08315(this));
        if (this.f5746a == Product.MESSENGER) {
            this.f5755j.setSoundEffectsEnabled(false);
        }
        this.f5755j.setOnClickListener(new C08326(this));
        this.f5755j.setOnTouchListener(new C08337(this));
        this.f5757l.setAttachmentContainerCallback(new C08348(this));
    }

    public void setTextLengthLimit(int i) {
        this.f5760o = i;
    }

    public final void mo181d() {
    }

    public final void mo182e() {
    }

    public final void mo183f() {
    }

    public final void mo184g() {
    }

    public void setMessageComposerCallback(AnonymousClass32 anonymousClass32) {
        this.f5764s = anonymousClass32;
    }

    public String getUnsentMessageText() {
        return getEditor().a().toString();
    }

    public MessageComposerEditor getEditor() {
        return this.f5758m;
    }

    public void setComposeMode(ComposeMode composeMode) {
        this.f5763r = composeMode;
    }

    public final void mo178b() {
        int i;
        Object obj;
        int i2 = 8;
        boolean z = !ThreadKey.g(this.f5759n);
        if (z && this.f5769x) {
            z = this.f5750e.a();
        }
        View view = this.f5754i;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        if (this.f5769x || ThreadKey.g(this.f5759n)) {
            obj = 1;
        } else {
            obj = null;
        }
        View view2 = this.f5753h;
        if (obj == null) {
            i2 = 0;
        }
        view2.setVisibility(i2);
    }

    public void setThreadKey(@Nullable ThreadKey threadKey) {
        this.f5759n = threadKey;
    }

    public void setLikeIconIdOverride(int i) {
    }

    public void setComposerButtonActiveColorFilterOverride(int i) {
    }

    public void setCreateThreadPickedUsersCount(int i) {
    }

    public void setIsSmsThread(boolean z) {
        this.f5769x = z;
    }

    public void setCanSendStickers(boolean z) {
        if (this.f5766u != z) {
            this.f5766u = z;
            this.f5754i.setVisibility(z ? 0 : 8);
        }
    }

    public void setIsLikeEnabled(boolean z) {
        this.f5767v = z;
        if (z) {
            this.f5755j.m5452b();
            this.f5755j.setEnabled(true);
        } else {
            this.f5755j.m5451a();
            this.f5755j.setEnabled(this.f5768w);
        }
        m5429l();
    }

    public void setIsSendEnabled(boolean z) {
        this.f5768w = z;
        if (!this.f5767v) {
            this.f5755j.setEnabled(this.f5768w);
        }
    }

    public final boolean mo190h() {
        return false;
    }

    public void setIsFlowerBorderModeActive(boolean z) {
    }

    public final void mo177a(boolean z, @Nullable String str) {
    }

    public final void mo175a(ContentSearchType contentSearchType, String str, boolean z, String str2) {
    }

    public final boolean mo191i() {
        return false;
    }

    public ContentSearchParams getContentSearchParams() {
        return null;
    }

    public void setIsSecretMode(boolean z) {
    }

    public void setIsEphemeralModeActive(boolean z) {
    }

    public final void mo180c() {
        this.f5752g.requestFocus();
        this.f5747b.showSoftInput(this.f5752g, 1);
    }

    public final boolean mo192j() {
        return false;
    }

    public final void mo176a(String str) {
        boolean z = true;
        switch (str.hashCode()) {
            case -1515361731:
                if (str.equals("voice_clip")) {
                    z = true;
                    break;
                }
                break;
            case 96632902:
                if (str.equals("emoji")) {
                    z = false;
                    break;
                }
                break;
            case 1531715286:
                if (str.equals("stickers")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                this.f5753h.setSelected(true);
                return;
            case true:
                setVisibility(8);
                return;
            case true:
                this.f5754i.setSelected(true);
                return;
            default:
                return;
        }
    }

    public final void mo179b(String str) {
        boolean z = true;
        switch (str.hashCode()) {
            case -1515361731:
                if (str.equals("voice_clip")) {
                    z = true;
                    break;
                }
                break;
            case 96632902:
                if (str.equals("emoji")) {
                    z = false;
                    break;
                }
                break;
            case 1531715286:
                if (str.equals("stickers")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                this.f5753h.setSelected(false);
                return;
            case true:
                setVisibility(0);
                return;
            case true:
                this.f5754i.setSelected(false);
                return;
            default:
                return;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m5421b(i2, i4);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 331148451);
        if (this.f5763r == ComposeMode.SHRUNK) {
            if (!(motionEvent.getActionMasked() != 1 || m5419a(this.f5753h, motionEvent) || m5419a(this.f5754i, motionEvent))) {
                this.f5752g.requestFocusFromTouch();
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.f5752g, 0);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 507020981, a);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(-478244318, a);
        return onTouchEvent;
    }

    private static boolean m5419a(View view, MotionEvent motionEvent) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.offset(iArr[0], iArr[1]);
        return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
    }

    private void m5421b(int i, int i2) {
        this.f5761p = TouchDelegateUtils.a(this.f5753h, 0, i2 - i, 5);
        this.f5762q = TouchDelegateUtils.a(this.f5754i, 0, i2 - i, 35);
        TouchDelegate a = TouchDelegateUtils.a(this.f5754i, 5);
        TouchDelegate a2 = TouchDelegateUtils.a(this.f5752g, 0, i2 - i);
        setTouchDelegate(new CompoundTouchDelegate(this, new TouchDelegate[]{this.f5761p, this.f5762q, a, a2}));
    }

    private void setComposeEditContainerRightPadding(int i) {
        this.f5751f.setPadding(this.f5751f.getPaddingLeft(), this.f5751f.getPaddingTop(), i, this.f5751f.getPaddingBottom());
    }

    private void m5429l() {
        int i;
        if (this.f5767v || !this.f5748c.asBoolean(false)) {
            this.f5755j.setVisibility(0);
            i = 2130773081;
        } else {
            this.f5755j.setVisibility(8);
            i = 2130773082;
        }
        setComposeEditContainerRightPadding(ContextUtils.e(getContext(), i, 0));
    }

    public static void m5430m(ClassicMessageComposerView classicMessageComposerView) {
        int length = classicMessageComposerView.f5752g.getText().length();
        if (length > classicMessageComposerView.f5760o - 50) {
            if (length > classicMessageComposerView.f5760o - 20) {
                classicMessageComposerView.f5756k.setTextColor(classicMessageComposerView.getResources().getColor(2131362298));
            } else {
                classicMessageComposerView.f5756k.setTextColor(classicMessageComposerView.getResources().getColor(2131361856));
            }
            classicMessageComposerView.f5756k.setText(Integer.toString(classicMessageComposerView.f5760o - length));
            classicMessageComposerView.f5756k.setVisibility(0);
            return;
        }
        classicMessageComposerView.f5756k.setText("");
        classicMessageComposerView.f5756k.setVisibility(8);
    }

    public void setAttachmentContainerCallback(Callback callback) {
        this.f5765t = callback;
    }

    public final void mo210a(MediaResource mediaResource) {
        this.f5757l.mo210a(mediaResource);
    }

    public final void mo209a(Intent intent) {
        this.f5757l.mo209a(intent);
    }

    public final void mo211b(MediaResource mediaResource) {
        this.f5757l.mo211b(mediaResource);
    }

    public final void mo208a() {
        this.f5757l.mo208a();
    }

    public int getOverlapY() {
        return 0;
    }

    public final void mo193k() {
    }

    public final void mo174a(int i, int i2) {
    }

    public final int mo173a(ComposerPointerLocation composerPointerLocation, boolean z) {
        return -1;
    }

    public int getAdditionalKeyboardHeight() {
        return 0;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
    }
}
