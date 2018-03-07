package com.facebook.pages.common.surface.calltoaction;

import com.google.common.base.Objects;
import com.google.common.base.Optional;

/* compiled from: creation */
public class PageCallToActionViewModel {

    /* compiled from: creation */
    public class BindModel {
        public final String f16648a;
        public final CallToActionIconState f16649b;
        public final Optional<String> f16650c;
        public final Optional<String> f16651d;
        public final CallToActionNuxState f16652e;
        public final CallToActionClickState f16653f;
        public final CallToActionDesignState f16654g;

        public BindModel(String str, CallToActionIconState callToActionIconState, Optional<String> optional, Optional<String> optional2, CallToActionNuxState callToActionNuxState, CallToActionClickState callToActionClickState, CallToActionDesignState callToActionDesignState) {
            this.f16648a = str;
            this.f16649b = callToActionIconState;
            this.f16650c = optional;
            this.f16651d = optional2;
            this.f16652e = callToActionNuxState;
            this.f16653f = callToActionClickState;
            this.f16654g = callToActionDesignState;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.f16648a, this.f16649b, this.f16650c, this.f16651d, this.f16652e, this.f16653f, this.f16654g});
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof BindModel)) {
                return false;
            }
            BindModel bindModel = (BindModel) obj;
            if (Objects.equal(this.f16648a, bindModel.f16648a) && Objects.equal(this.f16649b, bindModel.f16649b) && Objects.equal(this.f16650c, bindModel.f16650c) && Objects.equal(this.f16651d, bindModel.f16651d) && Objects.equal(this.f16652e, bindModel.f16652e) && Objects.equal(this.f16653f, bindModel.f16653f) && Objects.equal(this.f16654g, bindModel.f16654g)) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: creation */
    public enum CallToActionClickState {
        NOT_CLICKABLE,
        CLICKABLE
    }

    /* compiled from: creation */
    public enum CallToActionDesignState {
        WIDE,
        NARROW
    }

    /* compiled from: creation */
    public enum CallToActionIconState {
        HIDDEN,
        PENCIL,
        LEAVE_APP
    }

    /* compiled from: creation */
    public enum CallToActionNuxState {
        NONE,
        AUTO_PROVISION_SHOP_CTA,
        AUTO_PROVISION_CALL_CTA,
        AUTO_PROVISION_MESSENGER_CTA,
        CREATE_CTA,
        EDIT_CTA
    }
}
