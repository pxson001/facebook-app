package com.facebook.composer.metatext;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.composer.metatext.MetaTextBuilder.Params;
import com.facebook.composer.metatext.MetaTextBuilder.ParamsBuilder;
import com.facebook.composer.metatext.MetaTextBuilder.StyleParams;
import com.facebook.composer.metatext.MetaTextBuilder.TagClickListener;
import com.facebook.composer.metatext.MetaTextModel.Builder;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.widget.text.SpanSafeTextView;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: transform */
public class TagsTextViewContainer extends FrameLayout {
    private static final CallerContext f1332c = CallerContext.a(TagsTextViewContainer.class, "composer");
    @Inject
    MetaTextBuilderDelegate f1333a;
    @Inject
    FbDraweeControllerBuilder f1334b;
    public TextView f1335d;
    public MetaTextModel f1336e;
    public boolean f1337f = false;
    public StyleParams f1338g;
    public MinutiaeIconMetaTextFormatter f1339h;
    public DraweeHolder<GenericDraweeHierarchy> f1340i;
    public SeeMoreClickSpanListener f1341j;

    /* compiled from: transform */
    public interface SeeMoreClickSpanListener {
        void m1397a();
    }

    /* compiled from: transform */
    class SeeMoreClickableSpan extends ClickableSpan {
        final /* synthetic */ TagsTextViewContainer f1329a;
        private MetaTextModel f1330b;
        private TagClickListener f1331c;

        public SeeMoreClickableSpan(TagsTextViewContainer tagsTextViewContainer, MetaTextModel metaTextModel, TagClickListener tagClickListener) {
            this.f1329a = tagsTextViewContainer;
            this.f1330b = metaTextModel;
            this.f1331c = tagClickListener;
        }

        public void onClick(View view) {
            if (this.f1329a.f1341j != null) {
                this.f1329a.f1336e;
                this.f1329a.m1402a(this.f1330b, this.f1331c, 0);
                this.f1329a.f1341j.m1397a();
            }
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(this.f1329a.getResources().getColor(2131361974));
        }
    }

    private static <T extends View> void m1405a(Class<T> cls, T t) {
        m1406a((Object) t, t.getContext());
    }

    private static void m1406a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((TagsTextViewContainer) obj).m1401a(MetaTextBuilderDelegate.m1381b(fbInjector), FbDraweeControllerBuilder.b(fbInjector));
    }

    public TagsTextViewContainer(Context context) {
        super(context);
        m1399a(context, null);
    }

    public TagsTextViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1399a(context, attributeSet);
    }

    public TagsTextViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1399a(context, attributeSet);
    }

    private void m1399a(Context context, AttributeSet attributeSet) {
        m1405a(TagsTextViewContainer.class, (View) this);
        this.f1336e = new Builder().m1384a();
        this.f1339h = new MinutiaeIconMetaTextFormatter(getContext().getResources());
        this.f1340i = new DraweeHolder(new GenericDraweeHierarchyBuilder(getResources()).u());
        this.f1335d = new SpanSafeTextView(context);
        addView(this.f1335d, new LayoutParams(-1, -1));
        this.f1335d.setLinksClickable(false);
        if (attributeSet != null) {
            m1408b(context, attributeSet);
        }
    }

    private void m1408b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MinutiaeTextView);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f1335d.setMaxLines(obtainStyledAttributes.getInt(3, Integer.MAX_VALUE));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(1);
            if (colorStateList != null) {
                this.f1335d.setTextColor(colorStateList);
            }
        }
        if (obtainStyledAttributes.hasValue(0)) {
            this.f1335d.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(0, getResources().getDimensionPixelSize(2131427400)));
        }
        obtainStyledAttributes.recycle();
    }

    public void setSuffixStyleParams(StyleParams styleParams) {
        this.f1338g = styleParams;
    }

    public void setSeeMoreClickSpanListener(@Nullable SeeMoreClickSpanListener seeMoreClickSpanListener) {
        this.f1341j = seeMoreClickSpanListener;
    }

    public final void m1415a(MetaTextModel metaTextModel, TagClickListener tagClickListener, boolean z) {
        m1402a(metaTextModel, tagClickListener, z ? 0 : 140);
    }

    private void m1402a(MetaTextModel metaTextModel, TagClickListener tagClickListener, int i) {
        if (!metaTextModel.m1385a(this.f1336e) || (!this.f1337f && this.f1336e.f1315b != null)) {
            SpannableStringBuilder spannableStringBuilder;
            SpannableStringBuilder spannableStringBuilder2;
            this.f1336e = metaTextModel;
            this.f1337f = false;
            CharSequence charSequence = metaTextModel.f1314a;
            MinutiaeObject minutiaeObject = metaTextModel.f1315b;
            ImmutableList immutableList = metaTextModel.f1316c;
            CheckinPlaceModel checkinPlaceModel = metaTextModel.f1317d;
            if (charSequence == null) {
                spannableStringBuilder = new SpannableStringBuilder();
            } else {
                spannableStringBuilder = new SpannableStringBuilder(charSequence);
            }
            if (!(minutiaeObject == null && ((immutableList == null || immutableList.isEmpty()) && checkinPlaceModel == null))) {
                ParamsBuilder paramsBuilder = new ParamsBuilder();
                paramsBuilder.f1297f = true;
                paramsBuilder = paramsBuilder;
                paramsBuilder.f1298g = true;
                ParamsBuilder paramsBuilder2 = paramsBuilder;
                if (minutiaeObject != null) {
                    paramsBuilder2.f1292a = minutiaeObject;
                }
                if (!(immutableList == null || immutableList.isEmpty())) {
                    if (immutableList.size() == 2) {
                        ImmutableList.Builder builder = ImmutableList.builder();
                        for (int i2 = 0; i2 < 2; i2++) {
                            builder.c(((FacebookProfile) immutableList.get(i2)).mDisplayName);
                        }
                        paramsBuilder2.m1372a(builder.b());
                    } else {
                        paramsBuilder2.m1373b(((FacebookProfile) immutableList.get(0)).mDisplayName);
                    }
                    paramsBuilder2.f1296e = immutableList.size();
                    paramsBuilder2.f1300i = tagClickListener;
                }
                if (checkinPlaceModel != null) {
                    paramsBuilder2.f1293b = checkinPlaceModel;
                }
                Params a = paramsBuilder2.m1371a();
                spannableStringBuilder.append(this.f1338g == null ? this.f1333a.mo56a(a) : this.f1333a.m1383a(a, this.f1338g));
            }
            if (i == 0 || spannableStringBuilder.length() <= i || this.f1341j == null) {
                spannableStringBuilder2 = spannableStringBuilder;
            } else {
                spannableStringBuilder2 = (SpannableStringBuilder) spannableStringBuilder.subSequence(0, i);
                Object string = getResources().getString(2131237839);
                spannableStringBuilder2.append("... ").append(string);
                spannableStringBuilder2.setSpan(new SeeMoreClickableSpan(this, metaTextModel, tagClickListener), (i + 4) - 1, string.length() + (i + 4), 33);
            }
            this.f1335d.setText(spannableStringBuilder2);
            if (minutiaeObject != null) {
                m1400a(spannableStringBuilder2, metaTextModel);
            }
        }
    }

    private void m1400a(final SpannableStringBuilder spannableStringBuilder, final MetaTextModel metaTextModel) {
        if (metaTextModel.f1315b != null) {
            this.f1340i.a(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f1334b.a(f1332c).b(this.f1340i.f)).b(metaTextModel.f1315b.a()).a(new BaseControllerListener(this) {
                final /* synthetic */ TagsTextViewContainer f1328c;

                public final void m1395a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
                    CloseableImage closeableImage = (CloseableImage) obj;
                    if (metaTextModel.m1385a(this.f1328c.f1336e) && !this.f1328c.f1337f) {
                        TextView textView = this.f1328c.f1335d;
                        MinutiaeIconMetaTextFormatter minutiaeIconMetaTextFormatter = this.f1328c.f1339h;
                        textView.setText(MinutiaeIconMetaTextFormatter.m1386a(this.f1328c.f1340i.h(), spannableStringBuilder, closeableImage, metaTextModel.f1315b.a(), this.f1328c.f1335d.getPaint().getFontMetrics().ascent));
                        this.f1328c.f1337f = true;
                    }
                }

                public final void m1396b(String str, Throwable th) {
                }
            })).s());
            if (getVisibility() == 0) {
                this.f1340i.b();
            }
        }
    }

    public void setMovementMethod(MovementMethod movementMethod) {
        this.f1335d.setMovementMethod(movementMethod);
    }

    public void setHighlightColor(int i) {
        this.f1335d.setHighlightColor(i);
    }

    public void setMaxLines(int i) {
        this.f1335d.setMaxLines(i);
    }

    public void setMaxHeight(int i) {
        this.f1335d.setMaxHeight(i);
    }

    public int getLayoutHeight() {
        return this.f1335d.getLayout().getHeight();
    }

    public boolean canScrollHorizontally(int i) {
        return true;
    }

    public boolean canScrollVertically(int i) {
        return true;
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1964621523);
        super.onAttachedToWindow();
        this.f1340i.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 720060921, a);
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1974983097);
        this.f1340i.d();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -314686590, a);
    }

    public void onStartTemporaryDetach() {
        this.f1340i.d();
        super.onStartTemporaryDetach();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f1340i.b();
    }

    private void m1401a(MetaTextBuilderDelegate metaTextBuilderDelegate, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f1333a = metaTextBuilderDelegate;
        this.f1334b = fbDraweeControllerBuilder;
    }

    public static void m1403a(TagsTextViewContainer tagsTextViewContainer) {
        tagsTextViewContainer.f1337f = false;
        tagsTextViewContainer.f1336e = null;
    }

    @VisibleForTesting
    public void setTextView(TextView textView) {
        this.f1335d = textView;
    }

    @VisibleForTesting
    public TextView getTextView() {
        return this.f1335d;
    }

    @VisibleForTesting
    public MetaTextModel getMetaTextModel() {
        return this.f1336e;
    }

    @VisibleForTesting
    public DraweeController getMinutiaeController() {
        return this.f1340i.f;
    }
}
