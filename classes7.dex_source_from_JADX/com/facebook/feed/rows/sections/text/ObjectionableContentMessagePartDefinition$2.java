package com.facebook.feed.rows.sections.text;

import android.support.v4.content.ContextCompat;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.FeedProps;

/* compiled from: UNDO */
public class ObjectionableContentMessagePartDefinition$2 extends ClickableSpan {
    final /* synthetic */ FeedProps f21587a;
    final /* synthetic */ HasInvalidate f21588b;
    final /* synthetic */ ObjectionableContentMessagePartDefinition f21589c;

    public ObjectionableContentMessagePartDefinition$2(ObjectionableContentMessagePartDefinition objectionableContentMessagePartDefinition, FeedProps feedProps, HasInvalidate hasInvalidate) {
        this.f21589c = objectionableContentMessagePartDefinition;
        this.f21587a = feedProps;
        this.f21588b = hasInvalidate;
    }

    public void onClick(View view) {
        this.f21589c.c.b(ObjectionableContentMessagePartDefinition.b(this.f21589c, this.f21587a));
        this.f21588b.a(new FeedProps[]{this.f21587a});
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
        textPaint.setColor(ContextCompat.b(this.f21589c.f, 2131361924));
    }
}
