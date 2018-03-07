package com.facebook.tagging.ui;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Editable.Factory;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.checkin.PlacePickerFragment.2;
import com.facebook.resources.ui.FbAutoCompleteTextView;
import com.facebook.tagging.adapter.BaseTagTypeaheadAdapter;
import com.facebook.tagging.autocomplete.AutoCompleteBehaviorFactory;
import com.facebook.tagging.autocomplete.AutoCompleteBehaviorFactoryProvider;
import com.facebook.tagging.autocomplete.MentionsAutoCompleteBehavior;
import com.facebook.tagging.autocomplete.MentionsAutoCompleteBehaviorProvider;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.data.TaggingProfiles;
import com.facebook.tagging.graphql.utils.MentionsSpannableStringBuilder;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.facebook.tagging.graphql.utils.MentionsUtils.MentionChangeListener;
import com.facebook.tagging.logging.MentionsAutoCompleteAnalyticHelper;
import com.facebook.tagging.logging.MentionsTypeaheadAnalyticHelper;
import com.facebook.tagging.model.MentionSpan;
import com.facebook.tagging.model.MentionSurface;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tagging.ui.utils.MentionsTokenUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: deltaNewMessage */
public class MentionsAutoCompleteTextView extends FbAutoCompleteTextView {
    public MentionChangeListener f17579b;
    private 2 f17580c;
    private MentionsTokenUtils f17581d;
    public TaggingProfiles f17582e;
    private AutoCompleteBehaviorFactoryProvider f17583f;
    private AutoCompleteBehaviorFactory f17584g;
    private MentionsAutoCompleteBehavior f17585h;
    private FunnelLoggerImpl f17586i;
    private MentionsAutoCompleteAnalyticHelper f17587j;
    private boolean f17588k = false;
    public boolean f17589l = false;
    private FunnelEvent f17590m = FunnelEvent.OTHER;
    private int f17591n;
    private WeakReference<MentionSpan> f17592o = new WeakReference(null);
    private final C12821 f17593p = new C12821(this);
    private final OnClickListener f17594q = new C12832(this);

    /* compiled from: deltaNewMessage */
    public class C12821 {
        final /* synthetic */ MentionsAutoCompleteTextView f17575a;

        C12821(MentionsAutoCompleteTextView mentionsAutoCompleteTextView) {
            this.f17575a = mentionsAutoCompleteTextView;
        }

        public final MentionsSpannableStringBuilder m25566a() {
            return (MentionsSpannableStringBuilder) this.f17575a.getEditableText();
        }
    }

    /* compiled from: deltaNewMessage */
    class C12832 implements OnClickListener {
        final /* synthetic */ MentionsAutoCompleteTextView f17576a;

        C12832(MentionsAutoCompleteTextView mentionsAutoCompleteTextView) {
            this.f17576a = mentionsAutoCompleteTextView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -454947202);
            this.f17576a.f17589l = true;
            this.f17576a.replaceText(this.f17576a.convertSelectionToString(view.getTag()));
            this.f17576a.f17589l = false;
            this.f17576a.dismissDropDown();
            Logger.a(2, EntryType.UI_INPUT_END, 586376911, a);
        }
    }

    /* compiled from: deltaNewMessage */
    enum FunnelEvent {
        SCROLL,
        UPDATE,
        OTHER
    }

    /* compiled from: deltaNewMessage */
    class MentionsSpannableFactory extends Factory {
        final /* synthetic */ MentionsAutoCompleteTextView f17578a;

        /* compiled from: deltaNewMessage */
        class C12841 implements MentionChangeListener {
            final /* synthetic */ MentionsSpannableFactory f17577a;

            C12841(MentionsSpannableFactory mentionsSpannableFactory) {
                this.f17577a = mentionsSpannableFactory;
            }

            public final void mo1325a() {
                if (this.f17577a.f17578a.f17579b != null) {
                    this.f17577a.f17578a.f17579b.mo1325a();
                }
            }
        }

        public MentionsSpannableFactory(MentionsAutoCompleteTextView mentionsAutoCompleteTextView) {
            this.f17578a = mentionsAutoCompleteTextView;
        }

        public Editable newEditable(CharSequence charSequence) {
            return MentionsSpannableStringBuilder.m25490a(charSequence, this.f17578a.getResources(), this.f17578a.f17582e, new C12841(this));
        }
    }

    private static <T extends View> void m25572a(Class<T> cls, T t) {
        m25573a((Object) t, t.getContext());
    }

    private static void m25573a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MentionsAutoCompleteTextView) obj).m25571a(MentionsTokenUtils.m25580b(injectorLike), TaggingProfiles.m25203b(injectorLike), (AutoCompleteBehaviorFactoryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AutoCompleteBehaviorFactoryProvider.class), new MentionsAutoCompleteAnalyticHelper(AnalyticsLoggerMethodAutoProvider.a(injectorLike)), FunnelLoggerImpl.a(injectorLike));
    }

    public MentionsAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25572a(MentionsAutoCompleteTextView.class, (View) this);
        setInputType(getInputType() & -65537);
        setEditableFactory(new MentionsSpannableFactory(this));
        this.f17585h = this.f17584g.f17360b;
        setAdapter(this.f17585h.f17366e);
        setThreshold(this.f17585h.f17369h);
        addTextChangedListener(new HashtagHighlighter(this));
    }

    @Inject
    private void m25571a(MentionsTokenUtils mentionsTokenUtils, TaggingProfiles taggingProfiles, AutoCompleteBehaviorFactoryProvider autoCompleteBehaviorFactoryProvider, MentionsAutoCompleteAnalyticHelper mentionsAutoCompleteAnalyticHelper, FunnelLoggerImpl funnelLoggerImpl) {
        this.f17581d = mentionsTokenUtils;
        this.f17582e = taggingProfiles;
        this.f17583f = autoCompleteBehaviorFactoryProvider;
        this.f17587j = mentionsAutoCompleteAnalyticHelper;
        this.f17586i = funnelLoggerImpl;
        this.f17584g = new AutoCompleteBehaviorFactory(this.f17593p, (MentionsAutoCompleteBehaviorProvider) this.f17583f.getOnDemandAssistedProviderForStaticDi(MentionsAutoCompleteBehaviorProvider.class));
    }

    public void setExtraDataSource(TagTypeaheadDataSource tagTypeaheadDataSource) {
        this.f17584g.f17360b.f17366e.mo1307b(tagTypeaheadDataSource);
    }

    public final void m25577a(@Nullable Long l, MentionSurface mentionSurface) {
        this.f17584g.m25186a(l, mentionSurface);
    }

    public void setMentionsTypeaheadDataSource(TagTypeaheadDataSource tagTypeaheadDataSource) {
        this.f17584g.f17360b.f17366e.m25175a(tagTypeaheadDataSource);
    }

    public String getEncodedText() {
        return MentionsUtils.m25500a(getEditableText());
    }

    public List<GraphQLEntityAtRange> getMentionsEntityRanges() {
        return MentionsUtils.m25503b(getEditableText());
    }

    public void setIncludeFriends(boolean z) {
        this.f17584g.f17360b.f17370i = z;
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1657444209);
        super.onDetachedFromWindow();
        this.f17584g.f17360b.f17366e.f17321b.f17341f = null;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2099475562, a);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void performFiltering(java.lang.CharSequence r11, int r12) {
        /*
        r10 = this;
        r0 = r10.f17589l;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r1 = r10.getSelectionStart();
        r0 = r11.length();
        if (r1 <= r0) goto L_0x0015;
    L_0x000f:
        r0 = r10.f17585h;
        r0.m25189b();
        goto L_0x0004;
    L_0x0015:
        r0 = r10.getEditableText();
        r0 = (com.facebook.tagging.graphql.utils.MentionsSpannableStringBuilder) r0;
        r5 = r1 + -1;
    L_0x001d:
        if (r5 < 0) goto L_0x00e1;
    L_0x001f:
        r6 = r0.charAt(r5);
        switch(r6) {
            case 10: goto L_0x0029;
            case 32: goto L_0x0029;
            case 64: goto L_0x002f;
            default: goto L_0x0026;
        };
    L_0x0026:
        r5 = r5 + -1;
        goto L_0x001d;
    L_0x0029:
        r6 = r5 + 1;
        if (r6 >= r1) goto L_0x0026;
    L_0x002d:
        r5 = r5 + 1;
    L_0x002f:
        r2 = r5;
        r3 = r10.f17581d;
        r3 = r3.m25582a(r0, r2, r1);
        r1 = r10.f17584g;
        r5 = r3.toString();
        r6 = "_";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x00e5;
    L_0x0044:
        r7 = com.google.common.base.Absent.INSTANCE;
        r5 = r7;
    L_0x0047:
        r1 = r5;
        r4 = r1.isPresent();
        if (r4 != 0) goto L_0x0063;
    L_0x004e:
        r0 = r0.charAt(r2);
        r1 = 64;
        if (r0 != r1) goto L_0x005a;
    L_0x0056:
        r10.showDropDown();
        goto L_0x0004;
    L_0x005a:
        r10.dismissDropDown();
        r0 = r10.f17585h;
        r0.m25189b();
        goto L_0x0004;
    L_0x0063:
        r1 = r1.get();
        r1 = (com.facebook.tagging.autocomplete.MentionsAutoCompleteBehavior) r1;
        r10.f17585h = r1;
        r1 = r10.f17585h;
        r5 = r1.f17366e;
        r1 = r5;
        r10.setAdapter(r1);
        r1 = r10.f17585h;
        r8 = 1;
        r7 = 0;
        r5 = "";
        r1.f17371j = r5;
        r5 = r1.f17366e;
        r6 = r1.f17370i;
        r9 = r5.f17321b;
        r9.f17337b = r6;
        r5 = r5;
        r5 = r5.m25160c(r7);
        r5.m25161d(r7);
        r5 = r0.charAt(r2);
        r6 = 64;
        if (r5 != r6) goto L_0x00a9;
    L_0x0093:
        r5 = r1.f17366e;
        r5.m25161d(r8);
        r5 = r3.length();
        r6 = r1.f17368g;
        if (r5 < r6) goto L_0x00a5;
    L_0x00a0:
        r5 = r1.f17366e;
        r5.m25160c(r8);
    L_0x00a5:
        r5 = "@";
        r1.f17371j = r5;
    L_0x00a9:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = r1.f17371j;
        r5 = r5.append(r6);
        r6 = r3.toString();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r1.f17371j = r5;
        r5 = r1.f17366e;
        r6 = r1.f17371j;
        r9 = 0;
        r5.mo1306a(r3, r6, r9);
        r5 = r1.f17366e;
        r0 = r10.f17590m;
        r1 = com.facebook.tagging.ui.MentionsAutoCompleteTextView.FunnelEvent.UPDATE;
        if (r0 == r1) goto L_0x0004;
    L_0x00d2:
        r0 = r10.f17586i;
        r1 = com.facebook.funnellogger.FunnelRegistry.n;
        r2 = "mention_list_update";
        r0.b(r1, r2);
        r0 = com.facebook.tagging.ui.MentionsAutoCompleteTextView.FunnelEvent.UPDATE;
        r10.f17590m = r0;
        goto L_0x0004;
    L_0x00e1:
        r5 = 0;
        goto L_0x002f;
    L_0x00e5:
        r5 = r0.charAt(r2);
        r6 = 35;
        if (r5 == r6) goto L_0x00f5;
    L_0x00ed:
        r5 = r1.f17360b;
        r5 = com.google.common.base.Optional.of(r5);
        goto L_0x0047;
    L_0x00f5:
        r7 = com.google.common.base.Absent.INSTANCE;
        r5 = r7;
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.tagging.ui.MentionsAutoCompleteTextView.performFiltering(java.lang.CharSequence, int):void");
    }

    public void showDropDown() {
        if (getWindowVisibility() != 8) {
            if (!isPopupShowing()) {
                MentionsAutoCompleteBehavior mentionsAutoCompleteBehavior = this.f17585h;
                mentionsAutoCompleteBehavior.f17367f.m25509a(mentionsAutoCompleteBehavior.f17371j, mentionsAutoCompleteBehavior.f17373l, mentionsAutoCompleteBehavior.f17374m);
            }
            this.f17586i.a(FunnelRegistry.n);
            super.showDropDown();
            this.f17586i.a(FunnelRegistry.n, "old_ui");
        }
    }

    public void dismissDropDown() {
        if (isPopupShowing()) {
            MentionsAutoCompleteBehavior mentionsAutoCompleteBehavior = this.f17585h;
            mentionsAutoCompleteBehavior.f17367f.m25510b("", mentionsAutoCompleteBehavior.f17373l, mentionsAutoCompleteBehavior.f17374m);
            super.dismissDropDown();
            this.f17586i.b(FunnelRegistry.n);
        }
    }

    protected CharSequence convertSelectionToString(Object obj) {
        return this.f17585h.m25188a(obj);
    }

    protected void replaceText(CharSequence charSequence) {
        this.f17586i.b(FunnelRegistry.n, "insert_mentions");
        this.f17590m = FunnelEvent.OTHER;
        if (charSequence != null) {
            MentionsSpannableStringBuilder mentionsSpannableStringBuilder = (MentionsSpannableStringBuilder) getEditableText();
            if (mentionsSpannableStringBuilder == null) {
                throw new IllegalStateException("not editable text");
            }
            int selectionStart = getSelectionStart();
            MentionsAutoCompleteBehavior mentionsAutoCompleteBehavior = this.f17585h;
            int a = mentionsAutoCompleteBehavior.f17364c.m25581a(mentionsSpannableStringBuilder, selectionStart, mentionsAutoCompleteBehavior.f17372k.f17538a);
            if (mentionsAutoCompleteBehavior.f17364c.m25583a(mentionsSpannableStringBuilder, selectionStart, a, charSequence)) {
                mentionsSpannableStringBuilder.m25494a(a, selectionStart, mentionsAutoCompleteBehavior.f17372k, mentionsAutoCompleteBehavior.f17362a.getResources());
                MentionsTypeaheadAnalyticHelper mentionsTypeaheadAnalyticHelper = mentionsAutoCompleteBehavior.f17367f;
                TaggingProfile taggingProfile = mentionsAutoCompleteBehavior.f17372k;
                BaseTagTypeaheadAdapter baseTagTypeaheadAdapter = mentionsAutoCompleteBehavior.f17366e;
                mentionsTypeaheadAnalyticHelper.m25508a(taggingProfile, baseTagTypeaheadAdapter.f17316e.indexOf(mentionsAutoCompleteBehavior.f17372k), mentionsAutoCompleteBehavior.f17371j, mentionsAutoCompleteBehavior.f17373l, mentionsAutoCompleteBehavior.f17374m);
                mentionsAutoCompleteBehavior.f17366e.mo1305a();
            }
        }
    }

    public void setOnSoftKeyboardVisibleListener(2 2) {
        this.f17580c = 2;
    }

    public void setMentionChangeListener(MentionChangeListener mentionChangeListener) {
        this.f17579b = mentionChangeListener;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (this.f17580c == null) {
            return super.onKeyPreIme(i, keyEvent);
        }
        if (i == 4 && this.f17588k) {
            this.f17580c.b();
            this.f17588k = !this.f17588k;
            clearFocus();
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    protected void onFocusChanged(boolean z, int i, @Nullable Rect rect) {
        boolean z2 = true;
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1228826699);
        if (this.f17580c == null) {
            super.onFocusChanged(z, i, rect);
            Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1226674024, a);
            return;
        }
        if (z && !this.f17588k) {
            this.f17580c.a();
            if (this.f17588k) {
                z2 = false;
            }
            this.f17588k = z2;
        } else if (!z && this.f17588k) {
            this.f17580c.b();
            if (this.f17588k) {
                z2 = false;
            }
            this.f17588k = z2;
        }
        super.onFocusChanged(z, i, rect);
        LogUtils.g(1154597398, a);
    }

    public CharSequence getUserText() {
        return getEditableText();
    }

    public boolean onTextContextMenuItem(int i) {
        if (i != 16908322 || VERSION.SDK_INT < 11) {
            return super.onTextContextMenuItem(i);
        }
        ClipData a = m25568a();
        boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
        m25570a(a);
        return onTextContextMenuItem;
    }

    public final void m25576a(TaggingProfile taggingProfile) {
        MentionsSpannableStringBuilder mentionsSpannableStringBuilder = (MentionsSpannableStringBuilder) getEditableText();
        if (mentionsSpannableStringBuilder.length() == 0) {
            mentionsSpannableStringBuilder.m25494a(0, 0, taggingProfile, getContext().getResources());
            mentionsSpannableStringBuilder.insert(mentionsSpannableStringBuilder.length(), " ");
            MentionSpan[] mentionSpanArr = (MentionSpan[]) mentionsSpannableStringBuilder.getSpans(0, mentionsSpannableStringBuilder.length(), MentionSpan.class);
            this.f17591n = mentionSpanArr[0].m25524d();
            this.f17592o = new WeakReference(mentionSpanArr[0]);
            this.f17587j.m25505a();
        }
    }

    @TargetApi(11)
    private ClipData m25568a() {
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        if (!clipboardManager.hasPrimaryClip()) {
            return null;
        }
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, primaryClip.getItemAt(0).coerceToText(getContext())));
        return primaryClip;
    }

    @TargetApi(11)
    private void m25570a(ClipData clipData) {
        if (clipData != null) {
            ((ClipboardManager) getContext().getSystemService("clipboard")).setPrimaryClip(clipData);
        }
    }

    public final void m25578b() {
        MentionSpan mentionSpan = (MentionSpan) this.f17592o.get();
        if (mentionSpan != null && mentionSpan.m25524d() > 0) {
            this.f17587j.m25506a(this.f17591n > mentionSpan.m25524d());
            this.f17592o.clear();
        }
    }
}
