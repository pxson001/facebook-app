package com.facebook.search.results.rows.sections.composer;

import android.content.Context;
import android.widget.ImageView;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: REACTION_HEADER_INTERACTION */
public class SearchComposerView extends CustomLinearLayout {
    public boolean f24068a;
    public BetterTextView f24069b = ((BetterTextView) a(2131558966));
    public FbDraweeView f24070c = ((FbDraweeView) a(2131559671));
    public ImageView f24071d = ((ImageView) a(2131564232));

    public SearchComposerView(Context context) {
        super(context);
        Class cls = SearchComposerView.class;
        FbInjector.get(getContext());
        setContentView(2130905446);
    }
}
