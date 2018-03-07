package com.facebook.feed.rows.sections.attachments.linkshare.components;

import com.facebook.components.Component;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: Verb */
public class CoverPhotoShareComponent$Builder extends Builder<CoverPhotoShareComponent> {
    public CoverPhotoShareComponent$State f21044a;
    final /* synthetic */ CoverPhotoShareComponent f21045b;
    private String[] f21046c = new String[]{"attachmentProps", "environment"};
    private int f21047d = 2;
    public BitSet f21048e = new BitSet(this.f21047d);

    public CoverPhotoShareComponent$Builder(CoverPhotoShareComponent coverPhotoShareComponent) {
        this.f21045b = coverPhotoShareComponent;
    }

    public static void m23931a(CoverPhotoShareComponent$Builder coverPhotoShareComponent$Builder, ComponentContext componentContext, int i, CoverPhotoShareComponent$State coverPhotoShareComponent$State) {
        super.a(componentContext, i, coverPhotoShareComponent$State);
        coverPhotoShareComponent$Builder.f21044a = coverPhotoShareComponent$State;
        coverPhotoShareComponent$Builder.f21048e.clear();
    }

    public final Component<CoverPhotoShareComponent> m23933d() {
        int i = 0;
        if (this.f21048e == null || this.f21048e.nextClearBit(0) >= this.f21047d) {
            CoverPhotoShareComponent$State coverPhotoShareComponent$State = this.f21044a;
            m23932a();
            return coverPhotoShareComponent$State;
        }
        List arrayList = new ArrayList();
        while (i < this.f21047d) {
            if (!this.f21048e.get(i)) {
                arrayList.add(this.f21046c[i]);
            }
            i++;
        }
        throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
    }

    protected final void m23932a() {
        super.a();
        this.f21044a = null;
        this.f21045b.c.a(this);
    }
}
