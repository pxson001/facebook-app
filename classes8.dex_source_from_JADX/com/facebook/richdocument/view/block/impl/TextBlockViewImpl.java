package com.facebook.richdocument.view.block.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.presenter.TextBlockPresenter;
import com.facebook.richdocument.view.block.CustomBackgroundAware;
import com.facebook.richdocument.view.block.TextBlockView;
import com.facebook.richdocument.view.util.RichDocumentLayoutDirection;
import com.facebook.richdocument.view.widget.RichTextView;
import javax.inject.Inject;

/* compiled from: page_viewer_context */
public class TextBlockViewImpl extends AbstractBlockView<TextBlockPresenter> implements CustomBackgroundAware, TextBlockView {
    private int f6615a = 0;
    @Inject
    public RichDocumentLayoutDirection f6616c;
    protected final RichTextView f6617d;

    /* compiled from: page_viewer_context */
    public class C07651 {
        public final /* synthetic */ TextBlockViewImpl f6808a;

        C07651(TextBlockViewImpl textBlockViewImpl) {
            this.f6808a = textBlockViewImpl;
        }
    }

    public static void m6949a(Object obj, Context context) {
        ((TextBlockViewImpl) obj).f6616c = RichDocumentLayoutDirection.m7366a(FbInjector.get(context));
    }

    public TextBlockViewImpl(View view) {
        super(view);
        Class cls = TextBlockViewImpl.class;
        m6949a(this, getContext());
        this.f6617d = (RichTextView) view.findViewById(2131563266);
        this.f6617d.setEnableCopy(true);
        this.f6617d.f7398i = new C07651(this);
        if (!RichDocumentLayoutDirection.m7368c()) {
            return;
        }
        if (this.f6616c.m7369a()) {
            this.f6617d.f7393d.setGravity(5);
            if (RichDocumentLayoutDirection.m7368c()) {
                this.f6617d.f7393d.setLayoutDirection(1);
                this.f6617d.setLayoutDirection(1);
                iY_().setLayoutDirection(1);
                return;
            }
            return;
        }
        this.f6617d.f7393d.setGravity(3);
        if (RichDocumentLayoutDirection.m7368c()) {
            this.f6617d.f7393d.setLayoutDirection(0);
            this.f6617d.setLayoutDirection(0);
            iY_().setLayoutDirection(0);
        }
    }

    public final void mo374a(Bundle bundle) {
        super.mo374a(bundle);
        this.f6617d.f7393d.m7624a();
    }

    public final void mo384a(RichText richText) {
        this.f6617d.f7393d.setText(richText);
    }

    public final void mo385b(int i) {
        this.f6615a = i;
    }

    public int mo383a() {
        return this.f6615a;
    }
}
