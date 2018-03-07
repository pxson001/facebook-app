package com.facebook.messaging.xma.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.R;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.actionlinks.ActionLinkHandler;
import com.facebook.messaging.actionlinks.AutoComposeBroadcastActionLinkHandler;
import com.facebook.messaging.actionlinks.AutoComposeIntentActionLinkHandler;
import com.facebook.messaging.actionlinks.DefaultActionLinkHandler;
import com.facebook.messaging.actionlinks.KeyboardBroadcastActionLinkHandler;
import com.facebook.messaging.actionlinks.MessagingActionLinkModule;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel.ActionLinksModel;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: throwback_settings_edit */
public class ActionLinkButton extends CustomFrameLayout {
    @Inject
    public ActionLinkHandler f1600a;
    private FbTextView f1601b;

    private static <T extends View> void m1789a(Class<T> cls, T t) {
        m1790a((Object) t, t.getContext());
    }

    private static void m1790a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ActionLinkButton) obj).f1600a = MessagingActionLinkModule.m1589a(KeyboardBroadcastActionLinkHandler.m1587b(fbInjector), AutoComposeBroadcastActionLinkHandler.m1580b(fbInjector), AutoComposeIntentActionLinkHandler.m1582b(fbInjector), DefaultActionLinkHandler.m1585b(fbInjector));
    }

    public ActionLinkButton(Context context) {
        super(context);
        m1787a(context);
    }

    public ActionLinkButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m1787a(context);
        if (attributeSet != null) {
            setupAttributes(attributeSet);
        }
    }

    public ActionLinkButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1787a(context);
        if (attributeSet != null) {
            setupAttributes(attributeSet);
        }
    }

    private void m1787a(Context context) {
        m1789a(ActionLinkButton.class, (View) this);
        LayoutInflater.from(context).inflate(2130907801, this);
        this.f1601b = (FbTextView) c(2131560151);
    }

    private void m1788a(ActionLinkHandler actionLinkHandler) {
        this.f1600a = actionLinkHandler;
    }

    public void setText(String str) {
        this.f1601b.setText(str);
    }

    public void setOnClickUri(final Uri uri) {
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ActionLinkButton f1599b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1358506544);
                this.f1599b.f1600a.mo64a(uri);
                Logger.a(2, EntryType.UI_INPUT_END, -395996072, a);
            }
        });
    }

    public void setActionLink(ActionLinksModel actionLinksModel) {
        Preconditions.checkNotNull(actionLinksModel.b());
        setText(actionLinksModel.b());
        setOnClickUri(Uri.parse(actionLinksModel.c()));
    }

    private void setupAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.ActionLinkButton, 0, 0);
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                setText(string);
            }
            string = obtainStyledAttributes.getString(1);
            if (string != null) {
                setOnClickUri(Uri.parse(string));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }
}
