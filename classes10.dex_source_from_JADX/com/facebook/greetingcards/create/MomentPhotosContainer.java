package com.facebook.greetingcards.create;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.greetingcards.model.CardPhoto;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: {campaign_id none} */
public class MomentPhotosContainer extends SquareLinearLayout {
    public Listener f126a;
    private int f127b = getResources().getDimensionPixelSize(2131434014);

    /* compiled from: {campaign_id none} */
    public interface Listener {
        void mo3a(int i);

        void mo4b(int i);
    }

    public MomentPhotosContainer(Context context) {
        super(context);
        setOrientation(1);
    }

    public MomentPhotosContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
    }

    public void setListener(Listener listener) {
        this.f126a = listener;
    }

    public final void m140a(List<CardPhoto> list) {
        Preconditions.checkNotNull(list);
        removeAllViews();
        MomentPhotoView a;
        View a2;
        switch (list.size()) {
            case 0:
                a = m137a(null, 0);
                a.setLayoutParams(new LayoutParams(-1, -1));
                addView(a);
                return;
            case 1:
                a = m137a((CardPhoto) list.get(0), 0);
                a.setLayoutParams(new LayoutParams(-1, -1));
                addView(a);
                return;
            case 2:
                a = m137a((CardPhoto) list.get(0), 0);
                a.setLayoutParams(m135a());
                addView(a);
                a = m137a((CardPhoto) list.get(1), 1);
                a.setLayoutParams(m139b());
                addView(a);
                return;
            case 3:
                a = m137a((CardPhoto) list.get(0), 0);
                a.setLayoutParams(m135a());
                addView(a);
                a2 = m136a(m137a((CardPhoto) list.get(1), 1), m137a((CardPhoto) list.get(2), 2));
                a2.setLayoutParams(m139b());
                addView(a2);
                return;
            default:
                a2 = m136a(m137a((CardPhoto) list.get(0), 0), m137a((CardPhoto) list.get(1), 1));
                a2.setLayoutParams(m135a());
                addView(a2);
                a2 = m136a(m137a((CardPhoto) list.get(2), 2), m137a((CardPhoto) list.get(3), 3));
                a2.setLayoutParams(m139b());
                addView(a2);
                return;
        }
    }

    private LinearLayout m136a(MomentPhotoView momentPhotoView, MomentPhotoView momentPhotoView2) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(0, 0, this.f127b, 0);
        momentPhotoView.setLayoutParams(layoutParams);
        linearLayout.addView(momentPhotoView);
        layoutParams = new LayoutParams(0, -1, 1.0f);
        layoutParams.setMargins(this.f127b, 0, 0, 0);
        momentPhotoView2.setLayoutParams(layoutParams);
        linearLayout.addView(momentPhotoView2);
        return linearLayout;
    }

    private LayoutParams m135a() {
        LayoutParams layoutParams = new LayoutParams(-1, 0, 1.0f);
        layoutParams.setMargins(0, 0, 0, this.f127b);
        return layoutParams;
    }

    private LayoutParams m139b() {
        LayoutParams layoutParams = new LayoutParams(-1, 0, 1.0f);
        layoutParams.setMargins(0, this.f127b, 0, 0);
        return layoutParams;
    }

    private MomentPhotoView m137a(@Nullable CardPhoto cardPhoto, final int i) {
        MomentPhotoView momentPhotoView = new MomentPhotoView(getContext());
        momentPhotoView.f123e = new Object(this) {
            final /* synthetic */ MomentPhotosContainer f125b;

            public final void m131a() {
                if (this.f125b.f126a != null) {
                    this.f125b.f126a.mo3a(i);
                }
            }

            public final void m132b() {
                if (this.f125b.f126a != null) {
                    this.f125b.f126a.mo4b(i);
                }
            }
        };
        if (cardPhoto == null) {
            momentPhotoView.f122d.setVisibility(8);
        } else {
            momentPhotoView.f122d.setVisibility(0);
            momentPhotoView.f121c.a(cardPhoto.a, MomentPhotoView.f119a);
            if (cardPhoto.e != null) {
                GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(momentPhotoView.getResources());
                genericDraweeHierarchyBuilder.p = cardPhoto.e;
                momentPhotoView.f121c.setHierarchy(genericDraweeHierarchyBuilder.e(ScaleType.h).u());
            }
        }
        return momentPhotoView;
    }
}
