package com.facebook.universalfeedback.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import javax.annotation.Nullable;

/* compiled from: edit_gallery_bitmap_width */
public class UniversalFeedbackSatisfactionQuestionView extends UniversalFeedbackPageView {
    public FbButton f15388a;
    public RatingListener f15389b;
    public ImageButton f15390c;
    private final OnClickListener f15391d = new C11601(this);

    /* compiled from: edit_gallery_bitmap_width */
    class C11601 implements OnClickListener {
        final /* synthetic */ UniversalFeedbackSatisfactionQuestionView f15385a;

        C11601(UniversalFeedbackSatisfactionQuestionView universalFeedbackSatisfactionQuestionView) {
            this.f15385a = universalFeedbackSatisfactionQuestionView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -834648066);
            ImageButton imageButton = (ImageButton) view;
            if (imageButton != this.f15385a.f15390c) {
                if (this.f15385a.f15390c != null) {
                    this.f15385a.f15390c.setSelected(false);
                }
                this.f15385a.f15390c = imageButton;
                imageButton.setSelected(true);
                this.f15385a.f15388a.setEnabled(true);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -321236845, a);
        }
    }

    /* compiled from: edit_gallery_bitmap_width */
    class C11612 implements OnClickListener {
        final /* synthetic */ UniversalFeedbackSatisfactionQuestionView f15386a;

        C11612(UniversalFeedbackSatisfactionQuestionView universalFeedbackSatisfactionQuestionView) {
            this.f15386a = universalFeedbackSatisfactionQuestionView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 499688408);
            if (this.f15386a.f15389b != null) {
                this.f15386a.f15389b.mo1192a(((Integer) this.f15386a.f15390c.getTag()).intValue());
            }
            this.f15386a.m19391b();
            Logger.a(2, EntryType.UI_INPUT_END, -1159237164, a);
        }
    }

    /* compiled from: edit_gallery_bitmap_width */
    class C11623 implements OnClickListener {
        final /* synthetic */ UniversalFeedbackSatisfactionQuestionView f15387a;

        C11623(UniversalFeedbackSatisfactionQuestionView universalFeedbackSatisfactionQuestionView) {
            this.f15387a = universalFeedbackSatisfactionQuestionView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1116116124);
            this.f15387a.m19392c();
            Logger.a(2, EntryType.UI_INPUT_END, 575804485, a);
        }
    }

    /* compiled from: edit_gallery_bitmap_width */
    public interface RatingListener {
        void mo1192a(int i);
    }

    public UniversalFeedbackSatisfactionQuestionView(Context context) {
        super(context);
        m19415a(context);
    }

    public UniversalFeedbackSatisfactionQuestionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m19415a(context);
    }

    public UniversalFeedbackSatisfactionQuestionView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19415a(context);
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m19415a(Context context) {
        int i = 0;
        Resources resources = getResources();
        View.inflate(context, 2130907598, this);
        FbButton fbButton = (FbButton) findViewById(2131568164);
        this.f15388a = (FbButton) findViewById(2131568165);
        this.f15388a.setText(resources.getString(2131237761));
        this.f15388a.setEnabled(false);
        this.f15388a.setOnClickListener(new C11612(this));
        fbButton.setText(resources.getString(2131237760));
        fbButton.setOnClickListener(new C11623(this));
        ViewGroup viewGroup = (ViewGroup) findViewById(2131568174);
        while (i < 5) {
            ImageButton imageButton = (ImageButton) viewGroup.getChildAt(i);
            imageButton.setOnClickListener(this.f15391d);
            imageButton.setTag(Integer.valueOf(i));
            i++;
        }
    }

    public void setRatingListener(RatingListener ratingListener) {
        this.f15389b = ratingListener;
    }

    public final void m19418a() {
        Resources resources = getResources();
        TypedArray obtainTypedArray = resources.obtainTypedArray(2131755076);
        TypedArray obtainTypedArray2 = resources.obtainTypedArray(2131755077);
        ViewGroup viewGroup = (ViewGroup) findViewById(2131568174);
        int[] iArr = new int[]{16842919};
        int[] iArr2 = new int[]{16842913};
        int[] iArr3 = new int[0];
        for (int i = 0; i < 5; i++) {
            ImageButton imageButton = (ImageButton) viewGroup.getChildAt(i);
            int resourceId = obtainTypedArray2.getResourceId(i, -1);
            Drawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(iArr, resources.getDrawable(resourceId));
            stateListDrawable.addState(iArr2, resources.getDrawable(resourceId));
            stateListDrawable.addState(iArr3, resources.getDrawable(obtainTypedArray.getResourceId(i, -1)));
            imageButton.setImageDrawable(stateListDrawable);
        }
        obtainTypedArray2.recycle();
        obtainTypedArray.recycle();
    }
}
