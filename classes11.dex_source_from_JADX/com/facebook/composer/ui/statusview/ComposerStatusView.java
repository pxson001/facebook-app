package com.facebook.composer.ui.statusview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.metatext.MinutiaeIconMetaTextFormatter;
import com.facebook.composer.textstyle.ComposerDynamicTextStyleController;
import com.facebook.composer.ui.text.ComposerEditText;
import com.facebook.composer.ui.text.ComposerEditText.TextWithEntitiesChangedListener;
import com.facebook.composer.ui.text.ComposerMovementMethod;
import com.facebook.composer.ui.underwood.AttachmentsViewEventListener;
import com.facebook.composer.ui.underwood.TaggingController.TagsChangedListener;
import com.facebook.composer.ui.underwood.UnderwoodAttachmentViewController;
import com.facebook.composer.ui.underwood.UnderwoodController;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.friendsharing.text.abtest.ExperimentsForTextAbTestModule;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsComposerDrawn;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsMultimediaSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageParams;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.model.MentionSurface;
import com.facebook.ui.animations.AnimationUtil;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.LazyView;
import com.facebook.widget.LazyView.OnInflateRunner;
import com.facebook.widget.ScrollingAwareScrollView;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.NaturalOrdering;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: invitee_count */
public class ComposerStatusView extends CustomLinearLayout {
    private static final CallerContext f7187a = CallerContext.a(ComposerStatusView.class, "composer");
    public ViewStub f7188b;
    public ViewStub f7189c;
    private LazyView<EditText> f7190d;
    public LazyView<ComposerSellView> f7191e;
    private LazyView<FbDraweeView> f7192f;
    @Nullable
    public ComposerEditText f7193g;
    private CloseableImage f7194h;
    private Uri f7195i;
    private DraweeHolder<GenericDraweeHierarchy> f7196j;
    private MinutiaeIconMetaTextFormatter f7197k;
    public ViewStub f7198l;
    public ViewStub f7199m;
    @Inject
    public InputMethodManager f7200n;
    @Inject
    public Lazy<UnderwoodController> f7201o;
    @Inject
    private Lazy<ComposerDynamicTextStyleController> f7202p;
    @Inject
    private FbDraweeControllerBuilder f7203q;
    @Inject
    private AnimationUtil f7204r;
    @Inject
    private QeAccessor f7205s;
    public AfterFirstDrawListener f7206t;
    private boolean f7207u = true;
    private String f7208v;

    /* compiled from: invitee_count */
    public interface AfterFirstDrawListener {
        void mo182a();
    }

    /* compiled from: invitee_count */
    class C09111 implements OnInflateRunner<EditText> {
        final /* synthetic */ ComposerStatusView f7176a;

        C09111(ComposerStatusView composerStatusView) {
            this.f7176a = composerStatusView;
        }

        public final void m8391a(View view) {
            EditText editText = (EditText) view;
            editText.setMovementMethod(new ComposerMovementMethod());
            editText.setKeyListener(null);
        }
    }

    /* compiled from: invitee_count */
    class C09133 implements OnLongClickListener {
        final /* synthetic */ ComposerStatusView f7179a;

        C09133(ComposerStatusView composerStatusView) {
            this.f7179a = composerStatusView;
        }

        public boolean onLongClick(View view) {
            Preconditions.checkNotNull(this.f7179a.f7193g);
            return this.f7179a.f7193g.performLongClick();
        }
    }

    /* compiled from: invitee_count */
    class C09144 implements OnTouchListener {
        final /* synthetic */ ComposerStatusView f7180a;

        C09144(ComposerStatusView composerStatusView) {
            this.f7180a = composerStatusView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            Preconditions.checkNotNull(this.f7180a.f7193g);
            motionEvent.setLocation((float) this.f7180a.f7193g.getWidth(), motionEvent.getY() + ((float) this.f7180a.f7193g.getHeight()));
            this.f7180a.f7193g.onTouchEvent(motionEvent);
            return false;
        }
    }

    /* compiled from: invitee_count */
    class C09155 implements OnClickListener {
        final /* synthetic */ ComposerStatusView f7181a;

        C09155(ComposerStatusView composerStatusView) {
            this.f7181a = composerStatusView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1162157416);
            Preconditions.checkNotNull(this.f7181a.f7193g);
            if (this.f7181a.f7193g.getVisibility() != 8) {
                this.f7181a.f7193g.requestFocus();
                this.f7181a.m8421c();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -356404906, a);
        }
    }

    /* compiled from: invitee_count */
    class C09166 extends BaseControllerListener {
        final /* synthetic */ ComposerStatusView f7182a;

        C09166(ComposerStatusView composerStatusView) {
            this.f7182a = composerStatusView;
        }

        public final void m8393a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            this.f7182a.m8411a((CloseableImage) obj);
        }

        public final void m8394b(String str, Throwable th) {
        }
    }

    /* compiled from: invitee_count */
    class C09188 implements Runnable {
        final /* synthetic */ ComposerStatusView f7186a;

        C09188(ComposerStatusView composerStatusView) {
            this.f7186a = composerStatusView;
        }

        public void run() {
            if (!this.f7186a.f7200n.showSoftInput(this.f7186a.f7193g, 0)) {
                this.f7186a.m8424d();
                this.f7186a.f7200n.toggleSoftInput(0, 0);
                this.f7186a.f7200n.showSoftInput(this.f7186a.f7193g, 0);
            }
        }
    }

    private static <T extends View> void m8399a(Class<T> cls, T t) {
        m8400a((Object) t, t.getContext());
    }

    private static void m8400a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ComposerStatusView) obj).m8396a(InputMethodManagerMethodAutoProvider.b(fbInjector), IdBasedLazy.a(fbInjector, 5302), IdBasedLazy.a(fbInjector, 5291), FbDraweeControllerBuilder.b(fbInjector), AnimationUtil.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    private void m8396a(InputMethodManager inputMethodManager, Lazy<UnderwoodController> lazy, Lazy<ComposerDynamicTextStyleController> lazy2, FbDraweeControllerBuilder fbDraweeControllerBuilder, AnimationUtil animationUtil, QeAccessor qeAccessor) {
        this.f7200n = inputMethodManager;
        this.f7201o = lazy;
        this.f7202p = lazy2;
        this.f7203q = fbDraweeControllerBuilder;
        this.f7204r = animationUtil;
        this.f7205s = qeAccessor;
    }

    public ComposerStatusView(Context context) {
        super(context);
        m8403j();
    }

    public ComposerStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8403j();
    }

    private void m8403j() {
        m8399a(ComposerStatusView.class, (View) this);
        setContentView(2130903726);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131428032);
        setPadding(getPaddingLeft(), dimensionPixelSize, getPaddingRight(), dimensionPixelSize);
        this.f7190d = new LazyView((ViewStub) a(2131560631), new C09111(this));
        this.f7196j = DraweeHolder.a(new GenericDraweeHierarchyBuilder(getResources()).u(), getContext());
        this.f7188b = (ViewStub) a(2131560629);
        this.f7189c = (ViewStub) a(2131560634);
        this.f7191e = new LazyView((ViewStub) a(2131560632));
        this.f7197k = new MinutiaeIconMetaTextFormatter(getResources());
        this.f7198l = (ViewStub) findViewById(2131560635);
    }

    public final void m8416a(boolean z) {
        int i;
        this.f7189c.setLayoutResource(2130907231);
        this.f7193g = (ComposerEditText) this.f7189c.inflate().findViewById(2131563416);
        if (this.f7205s.a(ExperimentsForFeedUtilComposerAbtestModule.L, false)) {
            this.f7193g.setTextSize(0, getResources().getDimension(2131429630));
        }
        this.f7193g.f = this.f7205s.a(ExperimentsForComposerAbTestModule.s, false);
        boolean a = this.f7205s.a(ExperimentsForFeedUtilComposerAbtestModule.Z, false);
        this.f7193g.a(a(2131567643));
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131429662);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(2131429663);
        if (!z) {
            i = dimensionPixelSize2;
            boolean z2 = false;
        } else if (a) {
            i = resources.getDimensionPixelSize(2131427416);
            dimensionPixelSize2 = resources.getDimensionPixelSize(2131427418);
            dimensionPixelSize = i;
            i = dimensionPixelSize2;
        } else {
            dimensionPixelSize = 0;
            int i2 = dimensionPixelSize2;
            dimensionPixelSize2 = 0;
            i = i2;
        }
        this.f7193g.setPadding(dimensionPixelSize, i, dimensionPixelSize, dimensionPixelSize2);
        if (a) {
            this.f7193g.setBackgroundDrawable(new ColorDrawable(ContextCompat.b(getContext(), 2131362097)));
            ((MarginLayoutParams) this.f7193g.getLayoutParams()).topMargin = resources.getDimensionPixelSize(2131427417);
        }
        m8404k();
        m8405l();
        this.f7199m = (ViewStub) a(2131567644);
    }

    private void m8404k() {
        ViewStub viewStub = (ViewStub) a(2131567641);
        final int profileImageSize = getProfileImageSize();
        viewStub.getLayoutParams().width = profileImageSize;
        viewStub.getLayoutParams().height = profileImageSize;
        this.f7192f = new LazyView(viewStub, new OnInflateRunner<FbDraweeView>(this) {
            final /* synthetic */ ComposerStatusView f7178b;

            public final void m8392a(View view) {
                Preconditions.checkNotNull(this.f7178b.f7193g);
                Resources resources = this.f7178b.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(2131429633);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(2131429634);
                this.f7178b.f7193g.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, this.f7178b.f7193g.getPaddingBottom());
                this.f7178b.f7193g.setMinHeight(profileImageSize);
                this.f7178b.f7193g.setGravity(8388627);
                MarginLayoutParamsCompat.a((MarginLayoutParams) this.f7178b.f7193g.getLayoutParams(), profileImageSize + resources.getDimensionPixelSize(2131429635));
            }
        });
    }

    private void m8405l() {
        setOnLongClickListener(new C09133(this));
        setOnTouchListener(new C09144(this));
        setOnClickListener(new C09155(this));
    }

    private int getProfileImageSize() {
        return this.f7205s.a(ExperimentsForFeedUtilComposerAbtestModule.K, false) ? getResources().getDimensionPixelSize(2131429632) : getResources().getDimensionPixelSize(2131429631);
    }

    public void setMinutiaeUri(Uri uri) {
        this.f7195i = uri;
        this.f7196j.a(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f7203q.a(f7187a).b(this.f7196j.f)).b(uri).a(new C09166(this))).s());
        if (getVisibility() == 0) {
            this.f7196j.b();
        }
    }

    public void setMentionsTypeaheadDataSource(TagTypeaheadDataSource tagTypeaheadDataSource) {
        if (this.f7193g != null) {
            this.f7193g.setMentionsTypeaheadDataSource(tagTypeaheadDataSource);
        }
    }

    public void setAfterFirstDrawListener(AfterFirstDrawListener afterFirstDrawListener) {
        this.f7206t = afterFirstDrawListener;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f7207u) {
            this.f7207u = false;
            if (this.f7206t != null) {
                this.f7206t.mo182a();
            }
        }
    }

    public final <DataProvider extends ProvidesContentType> ComposerDynamicTextStyleController m8406a(DataProvider dataProvider) {
        ComposerDynamicTextStyleController composerDynamicTextStyleController = (ComposerDynamicTextStyleController) this.f7202p.get();
        ComposerEditText composerEditText = this.f7193g;
        if (composerEditText != null && composerDynamicTextStyleController.f6986b.a() && composerDynamicTextStyleController.f6987c.a(ExperimentsForTextAbTestModule.i, false)) {
            Preconditions.checkNotNull(dataProvider);
            if (((ProvidesConfiguration) dataProvider).o().getAllowDynamicTextStyle()) {
                composerDynamicTextStyleController.f6989e = dataProvider;
                composerDynamicTextStyleController.f6988d = new WeakReference(composerEditText);
                if (composerDynamicTextStyleController.f6990f == 0.0f) {
                    composerDynamicTextStyleController.f6990f = ((EditText) composerDynamicTextStyleController.f6988d.get()).getTextSize();
                }
                if ("grey".equals(composerDynamicTextStyleController.f6987c.a(ExperimentsForTextAbTestModule.d, null))) {
                    ((EditText) composerDynamicTextStyleController.f6988d.get()).setTextColor(composerDynamicTextStyleController.f6985a.getResources().getColor(2131361935));
                }
            }
        }
        return (ComposerDynamicTextStyleController) this.f7202p.get();
    }

    public final <DataProvider extends ProvidesAttachments & ProvidesIsComposerDrawn & ProvidesIsMultimediaSupported & ProvidesSessionId & ProvidesConfiguration & ProvidesTargetData> void m8412a(final ScrollingAwareScrollView scrollingAwareScrollView, ViewGroup viewGroup, boolean z, boolean z2, TagsChangedListener tagsChangedListener, DataProvider dataProvider) {
        ((UnderwoodController) this.f7201o.get()).a(viewGroup, scrollingAwareScrollView, (LinearLayout) findViewById(2131560638), z, z2, dataProvider);
        ((UnderwoodController) this.f7201o.get()).L = tagsChangedListener;
        scrollingAwareScrollView.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ComposerStatusView f7184b;
            private int f7185c = -1;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 1:
                        this.f7185c = -1;
                        break;
                    case 2:
                        if (this.f7185c == -1) {
                            this.f7185c = scrollingAwareScrollView.getScrollY();
                        }
                        if (this.f7185c != -1 && ((UnderwoodController) this.f7184b.f7201o.get()).b.size() > 0 && ((float) Math.abs(scrollingAwareScrollView.getScrollY() - this.f7185c)) > 20.0f * this.f7184b.getResources().getDisplayMetrics().density) {
                            scrollingAwareScrollView.requestFocus();
                            this.f7184b.m8424d();
                            break;
                        }
                }
                return false;
            }
        });
        CustomViewUtils.b(this, null);
    }

    public void setShowCaption(boolean z) {
        ((UnderwoodController) this.f7201o.get()).Q = z;
    }

    @Nullable
    public ImmutableMap<String, CreativeEditingUsageParams> getCreativeEditingUsageParameters() {
        return ImmutableMap.copyOf(((UnderwoodController) this.f7201o.get()).q);
    }

    public void setRemovedEditingLoggingParameters(ImmutableMap<String, CreativeEditingUsageParams> immutableMap) {
        ((UnderwoodController) this.f7201o.get()).a(immutableMap);
    }

    public final void m8407a() {
        UnderwoodController underwoodController = (UnderwoodController) this.f7201o.get();
        if (underwoodController.P) {
            for (UnderwoodAttachmentViewController j : underwoodController.b) {
                j.j();
            }
            underwoodController.b.clear();
            underwoodController.z.removeAllViews();
            underwoodController.F.a();
            underwoodController.P = false;
            underwoodController.w.getViewTreeObserver().removeGlobalOnLayoutListener(underwoodController.s);
        }
    }

    public ImmutableList<ComposerEventHandler> getEventHandlers() {
        Builder builder = ImmutableList.builder();
        builder.c(this.f7201o.get());
        return builder.b();
    }

    public float getMinAspectRatio() {
        if (((UnderwoodController) this.f7201o.get()).f().isEmpty()) {
            return -1.0f;
        }
        return ((Float) NaturalOrdering.a.a(((UnderwoodController) this.f7201o.get()).f())).floatValue();
    }

    public double getMaxScrolledPercent() {
        return ((UnderwoodController) this.f7201o.get()).S;
    }

    public final void m8417b() {
        if (this.f7193g != null) {
            this.f7193g.requestFocus();
        }
    }

    public final void m8421c() {
        if (this.f7193g != null) {
            postDelayed(new C09188(this), 100);
        }
    }

    public final void m8424d() {
        this.f7200n.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public void setHint(int i) {
        if (this.f7193g != null) {
            this.f7193g.setHint(i);
        }
    }

    public void setHint(String str) {
        if (this.f7193g != null) {
            this.f7193g.setHint(str);
            this.f7193g.c();
        }
    }

    public final void m8410a(TextWithEntitiesChangedListener textWithEntitiesChangedListener) {
        if (this.f7193g != null) {
            this.f7193g.a(textWithEntitiesChangedListener);
        }
    }

    public final void m8409a(TextWatcher textWatcher) {
        if (this.f7193g != null) {
            this.f7193g.addTextChangedListener(textWatcher);
        }
    }

    public final void m8418b(TextWatcher textWatcher) {
        if (this.f7191e.b()) {
            ((ComposerSellView) this.f7191e.a()).m8383a(textWatcher);
        }
    }

    public final void m8419b(TextWithEntitiesChangedListener textWithEntitiesChangedListener) {
        if (this.f7193g != null) {
            this.f7193g.b(textWithEntitiesChangedListener);
        }
    }

    public final void m8422c(TextWatcher textWatcher) {
        if (this.f7191e.b()) {
            ((ComposerSellView) this.f7191e.a()).m8388b(textWatcher);
        }
    }

    public void setOnCategoryClickedListener(OnClickListener onClickListener) {
        ((ComposerSellView) this.f7191e.a()).setOnCategoryClickedListener(onClickListener);
    }

    public void setOnLocationClickedListener(OnClickListener onClickListener) {
        ((ComposerSellView) this.f7191e.a()).setOnLocationClickedListener(onClickListener);
    }

    public void setOnPostToMarketplaceCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        ((ComposerSellView) this.f7191e.a()).setOnPostToMarketplaceCheckedChangeListener(onCheckedChangeListener);
    }

    public void setStatusText(CharSequence charSequence) {
        if (this.f7193g != null) {
            this.f7193g.setText(charSequence);
            int length = this.f7193g.getUserText().length();
            Selection.setSelection(this.f7193g.getText(), length, length);
        }
    }

    public final void m8425e() {
        if (this.f7193g != null) {
            this.f7193g.setAdapter(null);
        }
    }

    public void setFriendTaggingEnabled(boolean z) {
        if (this.f7193g != null) {
            this.f7193g.setIncludeFriends(z);
        }
    }

    public void setTaggingGroupId(long j) {
        if (this.f7193g != null) {
            this.f7193g.a(Long.valueOf(j), MentionSurface.COMPOSER);
        }
    }

    public final void m8408a(SpannedString spannedString, boolean z) {
        if (z) {
            ((EditText) this.f7190d.a()).setVisibility(0);
            ((EditText) this.f7190d.a()).setText(spannedString);
            if (this.f7194h != null) {
                m8397a((EditText) this.f7190d.a());
            }
        } else if (this.f7193g != null) {
            CharSequence spannableStringBuilder = new SpannableStringBuilder(this.f7193g.getUserText());
            spannableStringBuilder.append(spannedString);
            int selectionStart = this.f7193g.getSelectionStart();
            int selectionEnd = this.f7193g.getSelectionEnd();
            this.f7193g.setText(spannableStringBuilder);
            this.f7193g.setSelection(selectionStart, selectionEnd);
            if (this.f7194h != null) {
                m8397a(this.f7193g);
            }
        }
    }

    public final void m8411a(CloseableImage closeableImage) {
        this.f7194h = closeableImage;
        m8397a(this.f7193g);
        if (this.f7190d != null && this.f7190d.a() != null) {
            m8397a((EditText) this.f7190d.a());
        }
    }

    private void m8397a(EditText editText) {
        Preconditions.checkNotNull(this.f7194h);
        CharSequence a = MinutiaeIconMetaTextFormatter.a(((GenericDraweeHierarchy) this.f7196j.f()).a(), (SpannableStringBuilder) editText.getText(), this.f7194h, this.f7195i, editText.getPaint().getFontMetrics().ascent);
        ((GenericDraweeHierarchy) this.f7196j.f()).a().setCallback(editText);
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText(a);
        editText.setSelection(selectionStart, selectionEnd);
    }

    public void setIsAddMorePhotosAllowed(boolean z) {
        ((UnderwoodController) this.f7201o.get()).D = z;
        ((UnderwoodController) this.f7201o.get()).h();
    }

    public final void m8414a(ImmutableList<ComposerAttachment> immutableList, boolean z) {
        ((UnderwoodController) this.f7201o.get()).a(immutableList, z);
    }

    public final void m8413a(ImmutableList<PhotoItem> immutableList) {
        m8398a((ImmutableList) immutableList, TriState.UNSET);
    }

    public final void m8420b(ImmutableList<PhotoItem> immutableList) {
        m8398a((ImmutableList) immutableList, TriState.NO);
    }

    public final void m8423c(ImmutableList<PhotoItem> immutableList) {
        m8398a((ImmutableList) immutableList, TriState.YES);
    }

    private void m8398a(ImmutableList<PhotoItem> immutableList, TriState triState) {
        ((UnderwoodController) this.f7201o.get()).a(immutableList, triState);
    }

    public void setAttachmentsViewEventListener(AttachmentsViewEventListener attachmentsViewEventListener) {
        ((UnderwoodController) this.f7201o.get()).B = attachmentsViewEventListener;
    }

    public final void m8426f() {
        ((UnderwoodController) this.f7201o.get()).b(true);
    }

    public final void m8427g() {
        ((UnderwoodController) this.f7201o.get()).b(false);
        ((UnderwoodController) this.f7201o.get()).i();
    }

    public String getPayloadAttachmentFormats() {
        UnderwoodController underwoodController = (UnderwoodController) this.f7201o.get();
        StringBuilder stringBuilder = new StringBuilder();
        for (ComposerAttachment composerAttachment : underwoodController.a) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(',');
            }
            stringBuilder.append(ImageFormatChecker.a(composerAttachment.b().f().getPath()));
        }
        return stringBuilder.toString();
    }

    public String getPayloadAttachmentSources() {
        UnderwoodController underwoodController = (UnderwoodController) this.f7201o.get();
        StringBuilder stringBuilder = new StringBuilder();
        for (ComposerAttachment composerAttachment : underwoodController.a) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(',');
            }
            stringBuilder.append(composerAttachment.b().c());
        }
        return stringBuilder.toString();
    }

    public CharSequence getTitleText() {
        return ((ComposerSellView) this.f7191e.a()).getTitleText();
    }

    public void setTitleText(CharSequence charSequence) {
        ((ComposerSellView) this.f7191e.a()).setTitleText(charSequence);
    }

    public Optional<Long> getPrice() {
        return ((ComposerSellView) this.f7191e.a()).getPrice();
    }

    public final void m8415a(CharSequence charSequence, String str) {
        ((ComposerSellView) this.f7191e.a()).m8385a(charSequence, str);
    }

    public CharSequence getPickupDeliveryText() {
        return ((ComposerSellView) this.f7191e.a()).getZipcodeText();
    }

    public void setPickupDeliveryText(CharSequence charSequence) {
        ((ComposerSellView) this.f7191e.a()).setZipcodeText(charSequence);
    }

    public CharSequence getStructuredLocationText() {
        return ((ComposerSellView) this.f7191e.a()).getStructuredLocationText();
    }

    public void setStructuredLocationText(CharSequence charSequence) {
        ((ComposerSellView) this.f7191e.a()).setStructuredLocationText(charSequence);
    }

    public String getCategoryID() {
        return ((ComposerSellView) this.f7191e.a()).f7172m;
    }

    public final boolean m8428h() {
        return ((ComposerSellView) this.f7191e.a()).m8389b();
    }

    public CharSequence getDescriptionText() {
        return ((ComposerSellView) this.f7191e.a()).getDescriptionText();
    }

    public void setDescriptionText(CharSequence charSequence) {
        ((ComposerSellView) this.f7191e.a()).setDescriptionText(charSequence);
    }

    public void setIsPostToMarketplaceChecked(boolean z) {
        ((ComposerSellView) this.f7191e.a()).setIsPostToMarketplaceChecked(z);
    }

    public final void m8429i() {
        ((ComposerSellView) this.f7191e.a()).m8382a();
    }

    public void setCategoryID(String str) {
        ((ComposerSellView) this.f7191e.a()).setCategoryID(str);
    }

    public boolean getShouldPostToMarketplace() {
        return ((ComposerSellView) this.f7191e.a()).getShouldPostToMarketplace();
    }

    public void setProfilePicture(String str) {
        if (!StringUtil.a(str, this.f7208v)) {
            this.f7208v = str;
            ((FbDraweeView) this.f7192f.a()).a(Uri.parse(this.f7208v), f7187a);
        }
    }

    public ViewStub getPluginHeaderViewStub() {
        return this.f7188b;
    }

    public ViewStub getPluginStatusTextViewStub() {
        return this.f7189c;
    }

    public ViewStub getTopicPillViewStub() {
        return this.f7198l;
    }

    public ViewStub getTransliterationViewStub() {
        return this.f7199m;
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -600425574);
        super.onAttachedToWindow();
        if (this.f7196j != null) {
            this.f7196j.b();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1730690041, a);
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1135584620);
        super.onDetachedFromWindow();
        if (this.f7196j != null) {
            this.f7196j.d();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 194058659, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.f7196j != null) {
            this.f7196j.d();
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.f7196j != null) {
            this.f7196j.b();
        }
    }
}
