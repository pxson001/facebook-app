package com.facebook.messaging.photos.editing;

import android.view.ViewGroup;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.springs.SpringSystem;

/* compiled from: did_tap_view_receipt_button */
public class PhotoEditingControllerProvider extends AbstractAssistedProvider<PhotoEditingController> {
    public final PhotoEditingController m16266a(PhotoEditingConfig photoEditingConfig, ViewGroup viewGroup, LayerGroupLayout layerGroupLayout, PhotoEditingControlsLayout photoEditingControlsLayout, TextStylesLayout textStylesLayout, ImageWithTextView imageWithTextView) {
        return new PhotoEditingController(photoEditingConfig, viewGroup, layerGroupLayout, photoEditingControlsLayout, textStylesLayout, imageWithTextView, ArtRenderer.m16167b(this), SpringSystem.b(this));
    }
}
