package com.facebook.richdocument.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.fetcher.Retryable;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: onViewerContextFetchFailed() */
public abstract class RichDocumentRetryViewGroup extends CustomFrameLayout {

    /* compiled from: onViewerContextFetchFailed() */
    public class C08391 implements OnClickListener {
        final /* synthetic */ Retryable f7343a;
        final /* synthetic */ RichDocumentRetryViewGroup f7344b;

        public C08391(RichDocumentRetryViewGroup richDocumentRetryViewGroup, Retryable retryable) {
            this.f7344b = richDocumentRetryViewGroup;
            this.f7343a = retryable;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1707461100);
            if (this.f7343a != null) {
                this.f7343a.m5048a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1175970767, a);
        }
    }

    public abstract View getRetryButton();

    public RichDocumentRetryViewGroup(Context context) {
        this(context, null);
    }

    public RichDocumentRetryViewGroup(Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public RichDocumentRetryViewGroup(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void mo457a() {
        setVisibility(8);
    }

    public void mo458b() {
        setVisibility(0);
    }
}
