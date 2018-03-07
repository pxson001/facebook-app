package com.facebook.platform.composer.composer;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.invariants.Invariants;
import com.facebook.composer.metatext.MetaTextSpan;
import com.facebook.composer.metatext.MinutiaeIconMetaTextFormatter;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.facebook.tagging.graphql.utils.MentionsUtils.MentionChangeListener;
import com.facebook.tagging.ui.MentionsAutoCompleteTextView;
import com.google.common.base.Preconditions;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: rich_document_parse */
public class PlatformComposerEditText extends MentionsAutoCompleteTextView implements MentionChangeListener {
    private static final CallerContext f4053c = CallerContext.a(PlatformComposerEditText.class, "platform_native_share");
    @Inject
    public FbDraweeControllerBuilder f4054b;
    public boolean f4055d;
    public final Set<TextWithEntitiesChangedListener> f4056e = new HashSet();
    private final TextWatcher f4057f;
    private CloseableImage f4058g;
    private Uri f4059h;
    private MinutiaeIconMetaTextFormatter f4060i;
    private DraweeHolder<GenericDraweeHierarchy> f4061j;
    private View f4062k;

    /* compiled from: rich_document_parse */
    class C05191 implements TextWatcher {
        final /* synthetic */ PlatformComposerEditText f4049a;

        C05191(PlatformComposerEditText platformComposerEditText) {
            this.f4049a = platformComposerEditText;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            GraphQLTextWithEntities textWithEntities = PlatformComposerEditText.getTextWithEntities(this.f4049a);
            for (TextWithEntitiesChangedListener textWithEntitiesChangedListener : this.f4049a.f4056e) {
                boolean z = this.f4049a.f4055d;
                textWithEntitiesChangedListener.mo197a(textWithEntities);
            }
            this.f4049a.f4055d = false;
        }
    }

    /* compiled from: rich_document_parse */
    class C05213 extends BaseControllerListener {
        final /* synthetic */ PlatformComposerEditText f4052a;

        C05213(PlatformComposerEditText platformComposerEditText) {
            this.f4052a = platformComposerEditText;
        }

        public final void m3981a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            this.f4052a.m3997a((CloseableImage) obj);
        }

        public final void m3982b(String str, Throwable th) {
        }
    }

    /* compiled from: rich_document_parse */
    public interface TextWithEntitiesChangedListener {
        void mo197a(GraphQLTextWithEntities graphQLTextWithEntities);

        void mo198b(GraphQLTextWithEntities graphQLTextWithEntities);
    }

    private static <T extends View> void m3988a(Class<T> cls, T t) {
        m3989a((Object) t, t.getContext());
    }

    private static void m3989a(Object obj, Context context) {
        ((PlatformComposerEditText) obj).f4054b = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    private void m3987a(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f4054b = fbDraweeControllerBuilder;
    }

    public PlatformComposerEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3988a(PlatformComposerEditText.class, (View) this);
        this.f4057f = new C05191(this);
        this.f4060i = new MinutiaeIconMetaTextFormatter(getResources());
        this.f4061j = DraweeHolder.a(new GenericDraweeHierarchyBuilder(getResources()).u(), getContext());
        addTextChangedListener(this.f4057f);
        this.b = this;
    }

    public final void m3995a() {
        GraphQLTextWithEntities textWithEntities = getTextWithEntities(this);
        for (TextWithEntitiesChangedListener b : this.f4056e) {
            b.mo198b(textWithEntities);
        }
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 342127805);
        super.onAttachedToWindow();
        m3992c();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -303026567, a);
    }

    private void m3992c() {
        final ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ PlatformComposerEditText f4051b;

            public void onGlobalLayout() {
                ViewParent parent = this.f4051b.getParent();
                while (parent != null && !(parent instanceof ScrollView)) {
                    parent = parent.getParent();
                }
                Invariants.a(parent instanceof ScrollView, "The wrapper of ComposerTextEdit must be put in a ScrollView");
                if (VERSION.SDK_INT >= 16) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        });
    }

    private int getEndIndex() {
        Editable text = getText();
        MetaTextSpan[] metaTextSpanArr = (MetaTextSpan[]) getText().getSpans(0, text.length(), MetaTextSpan.class);
        int length = text.length();
        int length2 = metaTextSpanArr.length;
        int i = 0;
        while (i < length2) {
            int spanStart = text.getSpanStart(metaTextSpanArr[i]);
            if (spanStart == -1 || spanStart >= length) {
                spanStart = length;
            }
            i++;
            length = spanStart;
        }
        return Math.max(0, length);
    }

    public CharSequence getUserText() {
        return getText().subSequence(0, getEndIndex());
    }

    public void setSelection(int i) {
        super.setSelection(Math.min(i, getEndIndex()));
    }

    public void setSelection(int i, int i2) {
        int endIndex = getEndIndex();
        super.setSelection(Math.min(Math.max(0, i), endIndex), Math.min(Math.max(0, i2), endIndex));
    }

    public void extendSelection(int i) {
        super.extendSelection(Math.min(i, getEndIndex()));
    }

    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        int endIndex = getEndIndex();
        if (i2 < 0 || i2 > endIndex || i < 0 || i > endIndex) {
            setSelection(i, i2);
        }
    }

    private void m3994d() {
        if (isShown() && !isPopupShowing() && this.f4062k != null) {
            int selectionStart = getSelectionStart();
            Layout layout = getLayout();
            if (layout != null) {
                selectionStart = layout.getLineForOffset(selectionStart);
                selectionStart = layout.getLineAscent(selectionStart) + layout.getLineBaseline(selectionStart);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getLineHeight() + getPaddingTop());
                layoutParams.topMargin = selectionStart;
                this.f4062k.setLayoutParams(layoutParams);
            }
        }
    }

    protected void performFiltering(CharSequence charSequence, int i) {
        m3994d();
        super.performFiltering(charSequence, i);
    }

    public final void m3998a(TextWithEntitiesChangedListener textWithEntitiesChangedListener) {
        this.f4056e.add(textWithEntitiesChangedListener);
    }

    public boolean onTextContextMenuItem(int i) {
        this.f4055d = 16908322 == i;
        return super.onTextContextMenuItem(i);
    }

    public static GraphQLTextWithEntities getTextWithEntities(PlatformComposerEditText platformComposerEditText) {
        CharSequence userText = platformComposerEditText.getUserText();
        return GraphQLHelper.a(userText.toString(), MentionsUtils.b(new SpannableStringBuilder(userText)), null, null);
    }

    public final void m3996a(SpannableStringBuilder spannableStringBuilder) {
        CharSequence spannableStringBuilder2 = new SpannableStringBuilder(getUserText());
        spannableStringBuilder2.append(spannableStringBuilder);
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        setText(spannableStringBuilder2);
        setSelection(selectionStart, selectionEnd);
        if (this.f4058g != null) {
            m3986a((EditText) this);
        }
    }

    private void m3986a(EditText editText) {
        Preconditions.checkNotNull(this.f4058g);
        CharSequence a = MinutiaeIconMetaTextFormatter.a(((GenericDraweeHierarchy) this.f4061j.f()).a(), (SpannableStringBuilder) editText.getText(), this.f4058g, this.f4059h, editText.getPaint().getFontMetrics().ascent);
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText(a);
        editText.setSelection(selectionStart, selectionEnd);
    }

    public final void m3997a(CloseableImage closeableImage) {
        this.f4058g = closeableImage;
        m3986a((EditText) this);
    }

    public void setMinutiaeUri(Uri uri) {
        this.f4059h = uri;
        this.f4061j.a(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f4054b.a(f4053c).b(this.f4061j.f)).b(uri).a(new C05213(this))).s());
        if (getVisibility() == 0) {
            this.f4061j.b();
        }
    }
}
