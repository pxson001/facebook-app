package com.facebook.today.ui.components.view;

import android.content.Context;
import android.text.style.TextAppearanceSpan;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: transfer_option_id */
public class EventDescriptionComponentView extends CustomLinearLayout {
    public ContentView f1362a = ((ContentView) a(2131561277));
    public FbTextView f1363b = ((FbTextView) a(2131561276));
    public TextAppearanceSpan f1364c;
    public TextAppearanceSpan f1365d;

    public EventDescriptionComponentView(Context context) {
        super(context);
        setContentView(2130904028);
        this.f1364c = new TextAppearanceSpan(context, 2131626275);
        this.f1365d = new TextAppearanceSpan(context, 2131626276);
    }
}
