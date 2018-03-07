package com.facebook.events.create.ui;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import com.facebook.events.create.EventCompositionModel;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLTextWithEntities.Builder;
import com.facebook.tagging.graphql.utils.MentionsUtils.MentionChangeListener;
import com.facebook.tagging.ui.MentionsAutoCompleteTextView;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import com.google.common.collect.ImmutableList;

/* compiled from: config_refresh */
public class EventDescriptionText extends MentionsAutoCompleteTextView {
    private EventCompositionModel f16359b;

    /* compiled from: config_refresh */
    class C22831 implements MentionChangeListener {
        final /* synthetic */ EventDescriptionText f16357a;

        C22831(EventDescriptionText eventDescriptionText) {
            this.f16357a = eventDescriptionText;
        }

        public final void m16826a() {
            this.f16357a.m16827a();
        }
    }

    /* compiled from: config_refresh */
    class C22842 extends BaseTextWatcher {
        final /* synthetic */ EventDescriptionText f16358a;

        C22842(EventDescriptionText eventDescriptionText) {
            this.f16358a = eventDescriptionText;
        }

        public void afterTextChanged(Editable editable) {
            this.f16358a.m16827a();
        }
    }

    public EventDescriptionText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setSaveEnabled(false);
    }

    public final void m16829a(EventCompositionModel eventCompositionModel) {
        this.f16359b = eventCompositionModel;
        this.b = new C22831(this);
        addTextChangedListener(new C22842(this));
        setText(this.f16359b.f16046d);
    }

    private void m16827a() {
        this.f16359b.f16046d = getEncodedText();
    }

    public GraphQLTextWithEntities getDescriptionAsTextWithEntities() {
        Builder builder = new Builder();
        builder.i = getText().toString();
        builder = builder;
        builder.h = ImmutableList.copyOf(getMentionsEntityRanges());
        return builder.a();
    }
}
