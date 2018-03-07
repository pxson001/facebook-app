package com.facebook.negativefeedback.ui.messagecomposer;

import android.content.Context;
import android.text.Annotation;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.negativefeedback.ui.messagecomposer.MessageRecipientAutoCompleteController.C06521;
import com.facebook.negativefeedback.ui.messagecomposer.MessageRecipientAutoCompleteController.C06532;
import com.facebook.resources.ui.FbAutoCompleteTextView;
import javax.inject.Inject;

/* compiled from: no_of_items_returned */
public class MessageRecipientAutoCompleteTextView extends FbAutoCompleteTextView {
    public MessageRecipientTypeaheadAdapter f8113b;

    private static <T extends View> void m9768a(Class<T> cls, T t) {
        m9769a((Object) t, t.getContext());
    }

    private static void m9769a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MessageRecipientAutoCompleteTextView) obj).f8113b = new MessageRecipientTypeaheadAdapter((Context) injectorLike.getInstance(Context.class), new MessageRecipientTypeaheadFilter(DefaultAndroidThreadUtil.b(injectorLike), ContactsDbMessageRecipientDataSource.m9761a(injectorLike)));
    }

    public MessageRecipientAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9768a(MessageRecipientAutoCompleteTextView.class, (View) this);
        MessageRecipientAutoCompleteController messageRecipientAutoCompleteController = new MessageRecipientAutoCompleteController(this);
        setOnItemClickListener(new C06521(messageRecipientAutoCompleteController));
        addTextChangedListener(new C06532(messageRecipientAutoCompleteController));
        setAdapter(this.f8113b);
    }

    @Inject
    private void m9767a(MessageRecipientTypeaheadAdapter messageRecipientTypeaheadAdapter) {
        this.f8113b = messageRecipientTypeaheadAdapter;
    }

    public String getSelectedProfileId() {
        Editable text = getText();
        Annotation[] annotationArr = (Annotation[]) text.getSpans(0, text.length(), Annotation.class);
        if (annotationArr.length != 1) {
            return "";
        }
        String value = annotationArr[0].getValue();
        if (value == null) {
            return "";
        }
        return value;
    }
}
