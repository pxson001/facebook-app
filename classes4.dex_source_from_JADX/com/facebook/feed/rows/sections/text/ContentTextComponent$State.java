package com.facebook.feed.rows.sections.text;

import android.graphics.Typeface;
import android.text.Layout.Alignment;
import com.facebook.components.Component;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.spannable.PersistentSpannableInput;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: encrypted_cookie_sync_data */
public class ContentTextComponent$State extends Component<ContentTextComponent> implements Cloneable {
    FeedProps<GraphQLStory> f13062a;
    E f13063b;
    int f13064c = ContentTextComponentSpec.a;
    public int f13065d = -1;
    Typeface f13066e = ContentTextComponentSpec.b;
    Alignment f13067f = ContentTextComponentSpec.c;
    public boolean f13068g = true;
    public PersistentSpannableInput f13069h;
    final /* synthetic */ ContentTextComponent f13070i;

    public ContentTextComponent$State(ContentTextComponent contentTextComponent) {
        this.f13070i = contentTextComponent;
        super(contentTextComponent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ContentTextComponent$State contentTextComponent$State = (ContentTextComponent$State) obj;
        if (this.b == contentTextComponent$State.b) {
            return true;
        }
        if (this.f13062a == null ? contentTextComponent$State.f13062a != null : !this.f13062a.equals(contentTextComponent$State.f13062a)) {
            return false;
        }
        if (this.f13063b == null ? contentTextComponent$State.f13063b != null : !this.f13063b.equals(contentTextComponent$State.f13063b)) {
            return false;
        }
        if (this.f13064c != contentTextComponent$State.f13064c) {
            return false;
        }
        if (this.f13065d != contentTextComponent$State.f13065d) {
            return false;
        }
        if (this.f13066e == null ? contentTextComponent$State.f13066e != null : !this.f13066e.equals(contentTextComponent$State.f13066e)) {
            return false;
        }
        if (this.f13067f == null ? contentTextComponent$State.f13067f != null : !this.f13067f.equals(contentTextComponent$State.f13067f)) {
            return false;
        }
        if (this.f13068g != contentTextComponent$State.f13068g) {
            return false;
        }
        if (this.f13069h != null) {
            if (this.f13069h.equals(contentTextComponent$State.f13069h)) {
                return true;
            }
        } else if (contentTextComponent$State.f13069h == null) {
            return true;
        }
        return false;
    }
}
