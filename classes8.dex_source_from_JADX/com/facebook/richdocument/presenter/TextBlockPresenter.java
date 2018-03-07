package com.facebook.richdocument.presenter;

import com.facebook.richdocument.model.block.RichText.RichTextBuilder;
import com.facebook.richdocument.model.data.TextBlockData;
import com.facebook.richdocument.view.block.TextBlockView;

/* compiled from: photo/{#%s}/ */
public class TextBlockPresenter extends AbstractBlockPresenter<TextBlockView, TextBlockData> {
    public TextBlockPresenter(TextBlockView textBlockView) {
        super(textBlockView);
    }

    public void mo368a(TextBlockData textBlockData) {
        ((TextBlockView) this.f6382d).mo374a(null);
        ((TextBlockView) this.f6382d).mo384a(new RichTextBuilder(getContext()).m5445a(textBlockData.mo297f()).m5444a(textBlockData.mo298g()).m5446a());
        ((TextBlockView) this.f6382d).mo385b(textBlockData.mo296a());
    }
}
