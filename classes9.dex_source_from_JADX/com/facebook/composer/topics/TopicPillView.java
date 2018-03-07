package com.facebook.composer.topics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView.BufferType;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.resources.ui.FbTextView;
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.widget.text.ExpandedTouchLinkMovementMethod;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: Trying  */
public class TopicPillView extends FbTextView {
    @DrawableRes
    private int f23936a;
    private String f23937b;
    public OnImageClickListener f23938c;
    private Drawable f23939d;

    /* compiled from: Trying  */
    public interface OnImageClickListener {
        void mo1102a();
    }

    /* compiled from: Trying  */
    class C29051 extends ClickableSpan {
        final /* synthetic */ TopicPillView f23935a;

        C29051(TopicPillView topicPillView) {
            this.f23935a = topicPillView;
        }

        public void onClick(View view) {
            if (this.f23935a.f23938c != null) {
                this.f23935a.f23938c.mo1102a();
            }
        }
    }

    public TopicPillView(Context context) {
        super(context);
        m25895a();
    }

    public TopicPillView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m25895a();
    }

    public TopicPillView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25895a();
    }

    private void m25895a() {
        this.f23939d = getCompoundDrawables()[0];
        if (this.f23939d != null) {
            this.f23939d.mutate().setColorFilter(new PorterDuffColorFilter(getCurrentTextColor(), Mode.SRC_IN));
        }
        Resources resources = getResources();
        setPadding(resources.getDimensionPixelSize(2131429686), resources.getDimensionPixelSize(2131429687), resources.getDimensionPixelSize(2131429686), resources.getDimensionPixelSize(2131429687));
    }

    public void setTopics(@Nullable List<GraphQLExploreFeed> list) {
        if (list == null || list.isEmpty()) {
            setText(getContext().getString(2131234283));
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (GraphQLExploreFeed graphQLExploreFeed : list) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(graphQLExploreFeed.q());
        }
        this.f23937b = stringBuilder.toString();
        setText(this.f23937b);
    }

    public void setTopic(GraphQLExploreFeed graphQLExploreFeed) {
        this.f23937b = graphQLExploreFeed.q();
        setText(this.f23937b);
    }

    public void setImage(@DrawableRes int i) {
        if (i != this.f23936a) {
            m25896a(i);
        }
        this.f23936a = i;
    }

    public void setOnImageClickListener(OnImageClickListener onImageClickListener) {
        if (this.f23938c != onImageClickListener) {
            this.f23938c = onImageClickListener;
            m25896a(this.f23936a);
            return;
        }
        this.f23938c = onImageClickListener;
    }

    private void m25896a(@DrawableRes int i) {
        if (this.f23938c == null || i <= 0) {
            setText(this.f23937b);
            setDrawableRight(i);
            return;
        }
        setMovementMethod(ExpandedTouchLinkMovementMethod.b);
        setText(m25893a(getText(), i), BufferType.SPANNABLE);
        setDrawableRight(0);
    }

    private void setDrawableRight(@DrawableRes int i) {
        Drawable drawable;
        if (i > 0) {
            drawable = getResources().getDrawable(i);
        } else {
            drawable = null;
        }
        TextViewUtils.a(this, this.f23939d, null, drawable, null);
    }

    private Spannable m25893a(CharSequence charSequence, @DrawableRes int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        Drawable drawable = getResources().getDrawable(i);
        if (drawable != null) {
            spannableStringBuilder.append(" ");
            drawable.mutate().setColorFilter(new PorterDuffColorFilter(getCurrentTextColor(), Mode.SRC_IN));
            int dimensionPixelSize = getResources().getDimensionPixelSize(2131429688);
            int textSize = (int) getTextSize();
            drawable.setBounds(dimensionPixelSize, 0, dimensionPixelSize + textSize, textSize);
            spannableStringBuilder.setSpan(new ImageSpan(drawable, 1), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            spannableStringBuilder.setSpan(new C29051(this), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        }
        return spannableStringBuilder;
    }
}
