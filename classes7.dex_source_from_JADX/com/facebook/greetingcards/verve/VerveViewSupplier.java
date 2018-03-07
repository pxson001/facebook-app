package com.facebook.greetingcards.verve;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.facebook.greetingcards.verve.model.VMSlide;
import com.facebook.greetingcards.verve.model.VMView;
import com.facebook.greetingcards.verve.render.VerveVideoContainer;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;

/* compiled from: PushNotifID */
public interface VerveViewSupplier {

    /* compiled from: PushNotifID */
    public interface RecyclerType {
    }

    ImageView mo1608a(Context context, VMView vMView);

    <T extends Enum & RecyclerType> ImmutableSet<T> mo1604a();

    @Nullable
    <T extends Enum & RecyclerType> T mo1605a(VMView vMView);

    void mo1609a(VMView vMView, VMSlide vMSlide, ImmutableMap<String, String> immutableMap, @Nullable Drawable drawable, ImageView imageView);

    void mo1606a(VMView vMView, ImmutableMap<String, String> immutableMap, VerveVideoContainer verveVideoContainer);

    <T extends View & VerveVideoContainer> T mo1607b(Context context, VMView vMView);

    Button mo1610c(Context context, VMView vMView);
}
