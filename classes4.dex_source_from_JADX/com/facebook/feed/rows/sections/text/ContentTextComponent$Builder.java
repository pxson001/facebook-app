package com.facebook.feed.rows.sections.text;

import android.graphics.Typeface;
import android.text.Layout.Alignment;
import com.facebook.components.Component;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: encrypted_cookie_sync_data */
public class ContentTextComponent$Builder extends Builder<ContentTextComponent> {
    public ContentTextComponent$State f13071a;
    final /* synthetic */ ContentTextComponent f13072b;
    private String[] f13073c = new String[]{"storyProps", "environment"};
    private int f13074d = 2;
    private BitSet f13075e = new BitSet(this.f13074d);

    public ContentTextComponent$Builder(ContentTextComponent contentTextComponent) {
        this.f13072b = contentTextComponent;
    }

    public static void m13913a(ContentTextComponent$Builder contentTextComponent$Builder, ComponentContext componentContext, int i, ContentTextComponent$State contentTextComponent$State) {
        super.a(componentContext, i, contentTextComponent$State);
        contentTextComponent$Builder.f13071a = contentTextComponent$State;
        contentTextComponent$Builder.f13075e.clear();
    }

    public final ContentTextComponent$Builder m13917a(FeedProps<GraphQLStory> feedProps) {
        this.f13071a.f13062a = feedProps;
        this.f13075e.set(0);
        return this;
    }

    public final ContentTextComponent$Builder m13916a(E e) {
        this.f13071a.f13063b = e;
        this.f13075e.set(1);
        return this;
    }

    public final ContentTextComponent$Builder m13920h(int i) {
        this.f13071a.f13064c = i;
        return this;
    }

    public final ContentTextComponent$Builder m13914a(Typeface typeface) {
        this.f13071a.f13066e = typeface;
        return this;
    }

    public final ContentTextComponent$Builder m13915a(Alignment alignment) {
        this.f13071a.f13067f = alignment;
        return this;
    }

    public final Component<ContentTextComponent> m13919d() {
        int i = 0;
        if (this.f13075e == null || this.f13075e.nextClearBit(0) >= this.f13074d) {
            ContentTextComponent$State contentTextComponent$State = this.f13071a;
            m13918a();
            return contentTextComponent$State;
        }
        List arrayList = new ArrayList();
        while (i < this.f13074d) {
            if (!this.f13075e.get(i)) {
                arrayList.add(this.f13073c[i]);
            }
            i++;
        }
        throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
    }

    protected final void m13918a() {
        super.a();
        this.f13071a = null;
        this.f13072b.c.a(this);
    }
}
