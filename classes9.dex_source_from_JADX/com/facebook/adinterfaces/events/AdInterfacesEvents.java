package com.facebook.adinterfaces.events;

import android.content.Intent;
import android.location.Location;
import android.support.v4.app.DialogFragment;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.external.events.AdInterfacesEvent;
import com.facebook.adinterfaces.external.events.AdInterfacesEventSubscriber;
import com.facebook.adinterfaces.model.AdInterfacesTargetingData;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentAudienceModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentValidationMessageModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: acceptMessageRequests */
public class AdInterfacesEvents {

    /* compiled from: acceptMessageRequests */
    public abstract class DataValidationEventSubscriber extends AdInterfacesEventSubscriber<DataValidationEvent> {
        public final Class<DataValidationEvent> m22449a() {
            return DataValidationEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class InvalidateEventSubscriber extends AdInterfacesEventSubscriber<InvalidateEvent> {
        public final Class<InvalidateEvent> m22451a() {
            return InvalidateEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class IntentEventSubscriber extends AdInterfacesEventSubscriber<IntentEvent> {
        public final Class<IntentEvent> m22453a() {
            return IntentEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class DialogEventSubscriber extends AdInterfacesEventSubscriber<DialogEvent> {
        public final Class<DialogEvent> m22455a() {
            return DialogEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class ErrorDialogEventSubscriber extends AdInterfacesEventSubscriber<ErrorDialogEvent> {
        public final Class<ErrorDialogEvent> m22457a() {
            return ErrorDialogEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class ValidationEvent extends AdInterfacesEvent {
        public BoostedComponentValidationMessageModel f21655a;

        public ValidationEvent(BoostedComponentValidationMessageModel boostedComponentValidationMessageModel) {
            this.f21655a = boostedComponentValidationMessageModel;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class AccountValidationEvent extends ValidationEvent {
        public AccountValidationEvent(BoostedComponentValidationMessageModel boostedComponentValidationMessageModel) {
            super(boostedComponentValidationMessageModel);
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class AccountValidationEventSubscriber extends AdInterfacesEventSubscriber<AccountValidationEvent> {
        public final Class<AccountValidationEvent> m22731a() {
            return AccountValidationEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class AudienceChangedEvent extends AdInterfacesEvent {
        public GraphQLBoostedPostAudienceOption f21656a;

        public AudienceChangedEvent(GraphQLBoostedPostAudienceOption graphQLBoostedPostAudienceOption) {
            this.f21656a = graphQLBoostedPostAudienceOption;
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class AudienceChangedSubscriber extends AdInterfacesEventSubscriber<AudienceChangedEvent> {
        public final Class<AudienceChangedEvent> m22732a() {
            return AudienceChangedEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class BudgetValidationEvent extends ValidationEvent {
        public BudgetValidationEvent(BoostedComponentValidationMessageModel boostedComponentValidationMessageModel) {
            super(boostedComponentValidationMessageModel);
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class BudgetValidationEventSubscriber extends AdInterfacesEventSubscriber<BudgetValidationEvent> {
        public final Class<BudgetValidationEvent> m22733a() {
            return BudgetValidationEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class CallToActionChangedEvent extends AdInterfacesEvent {
        public final GraphQLCallToActionType f21657a;

        public CallToActionChangedEvent(GraphQLCallToActionType graphQLCallToActionType) {
            this.f21657a = graphQLCallToActionType;
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class CallToActionSubscriber extends AdInterfacesEventSubscriber<CallToActionChangedEvent> {
        public final Class<CallToActionChangedEvent> m22734a() {
            return CallToActionChangedEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class CreativeChangedEvent extends AdInterfacesEvent {
    }

    /* compiled from: acceptMessageRequests */
    public abstract class CreativeChangedEventSubscriber extends AdInterfacesEventSubscriber<CreativeChangedEvent> {
        public final Class<CreativeChangedEvent> m22735a() {
            return CreativeChangedEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class CreativeValidationEvent extends ValidationEvent {
        public CreativeValidationEvent(BoostedComponentValidationMessageModel boostedComponentValidationMessageModel) {
            super(boostedComponentValidationMessageModel);
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class CreativeValidationEventSubscriber extends AdInterfacesEventSubscriber<CreativeValidationEvent> {
        public final Class<CreativeValidationEvent> m22736a() {
            return CreativeValidationEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class DataValidationEvent extends AdInterfacesEvent {
        public boolean f21658a;

        public DataValidationEvent(boolean z) {
            this.f21658a = z;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class DialogEvent extends AdInterfacesEvent {
        public DialogFragment f21659a;
        public String f21660b;
    }

    /* compiled from: acceptMessageRequests */
    public class DurationChangeEvent extends AdInterfacesEvent {
        private final int f21661a;

        public DurationChangeEvent(int i) {
            this.f21661a = i;
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class DurationChangeEventSubscriber extends AdInterfacesEventSubscriber<DurationChangeEvent> {
        public final Class<DurationChangeEvent> m22737a() {
            return DurationChangeEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class ErrorDialogEvent extends AdInterfacesEvent {
        @Nullable
        public String f21662a;
        @Nullable
        public String f21663b;

        public ErrorDialogEvent(String str, String str2) {
            this.f21662a = str;
            this.f21663b = str2;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class ErrorMessageEvent extends AdInterfacesEvent {
        public final String f21664a;

        public ErrorMessageEvent(String str) {
            this.f21664a = str;
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class ErrorMessageEventSubscriber extends AdInterfacesEventSubscriber<ErrorMessageEvent> {
        public final Class<ErrorMessageEvent> m22738a() {
            return ErrorMessageEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class IntentEvent extends AdInterfacesEvent {
        public Intent f21665a;
        public Integer f21666b;
        public boolean f21667c = true;
        public boolean f21668d;

        /* compiled from: acceptMessageRequests */
        public interface IntentHandler {
            void mo980a(int i, Intent intent);
        }

        public IntentEvent(Intent intent) {
            this.f21665a = intent;
        }

        public IntentEvent(Intent intent, boolean z) {
            this.f21665a = intent;
            this.f21668d = z;
        }

        public IntentEvent(Intent intent, int i) {
            this.f21665a = intent;
            this.f21666b = Integer.valueOf(i);
        }

        public IntentEvent(Intent intent, int i, boolean z) {
            this.f21665a = intent;
            this.f21666b = Integer.valueOf(i);
            this.f21667c = z;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class InvalidateAccountEvent extends AdInterfacesEvent {
        public final String f21669a;

        public InvalidateAccountEvent(String str) {
            this.f21669a = str;
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class InvalidateAccountsSubscriber extends AdInterfacesEventSubscriber<InvalidateAccountEvent> {
        public final Class<InvalidateAccountEvent> m22740a() {
            return InvalidateAccountEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class InvalidateEvent extends AdInterfacesEvent {
        public DialogBasedProgressIndicator f21670a;
        public ComponentType f21671b;

        public InvalidateEvent(DialogBasedProgressIndicator dialogBasedProgressIndicator) {
            this.f21670a = dialogBasedProgressIndicator;
        }

        public InvalidateEvent(DialogBasedProgressIndicator dialogBasedProgressIndicator, ComponentType componentType) {
            this.f21670a = dialogBasedProgressIndicator;
            this.f21671b = componentType;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class InvalidatePreviewEvent extends AdInterfacesEvent {
    }

    /* compiled from: acceptMessageRequests */
    public abstract class InvalidatePreviewEventSubscriber extends AdInterfacesEventSubscriber<InvalidatePreviewEvent> {
        public final Class<InvalidatePreviewEvent> m22741a() {
            return InvalidatePreviewEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class LocationTargetingChangedEvent extends AdInterfacesEvent {
        public Location f21672a;
        public double f21673b;

        public LocationTargetingChangedEvent(Location location, double d) {
            this.f21672a = location;
            this.f21673b = d;
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class LocationTargetingChangedSubscriber extends AdInterfacesEventSubscriber<LocationTargetingChangedEvent> {
        public final Class<LocationTargetingChangedEvent> m22742a() {
            return LocationTargetingChangedEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class ScheduleValidationEvent extends ValidationEvent {
        public ScheduleValidationEvent(BoostedComponentValidationMessageModel boostedComponentValidationMessageModel) {
            super(boostedComponentValidationMessageModel);
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class ScheduleValidationEventSubscriber extends AdInterfacesEventSubscriber<ScheduleValidationEvent> {
        public final Class<ScheduleValidationEvent> m22743a() {
            return ScheduleValidationEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class ScrollEvent extends AdInterfacesEvent {
    }

    /* compiled from: acceptMessageRequests */
    public abstract class ScrollEventSubscriber extends AdInterfacesEventSubscriber<ScrollEvent> {
        public final Class<ScrollEvent> m22744a() {
            return ScrollEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class SelectedAdAccountChangeEvent extends AdInterfacesEvent {
        public final String f21674a;
        public final String f21675b;

        public SelectedAdAccountChangeEvent(String str, String str2) {
            this.f21675b = str;
            this.f21674a = str2;
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class SelectedAdAccountChangeEventSubscriber extends AdInterfacesEventSubscriber<SelectedAdAccountChangeEvent> {
        public final Class<SelectedAdAccountChangeEvent> m22745a() {
            return SelectedAdAccountChangeEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class SelectedBudgetChangeEvent extends AdInterfacesEvent {
        public final CurrencyQuantityModel f21676a;

        public SelectedBudgetChangeEvent(CurrencyQuantityModel currencyQuantityModel) {
            this.f21676a = currencyQuantityModel;
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class SelectedBudgetChangeEventSubscriber extends AdInterfacesEventSubscriber<SelectedBudgetChangeEvent> {
        public final Class<SelectedBudgetChangeEvent> m22746a() {
            return SelectedBudgetChangeEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class ServerValidationEvent extends AdInterfacesEvent {
        public final ImmutableList<BoostedComponentValidationMessageModel> f21677a;

        public ServerValidationEvent(List<BoostedComponentValidationMessageModel> list) {
            this.f21677a = ImmutableList.copyOf(list);
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class ServerValidationEventSubscriber extends AdInterfacesEventSubscriber<ServerValidationEvent> {
        public final Class<ServerValidationEvent> m22747a() {
            return ServerValidationEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class ServerValidationRequestEvent extends AdInterfacesEvent {
    }

    /* compiled from: acceptMessageRequests */
    public abstract class ServerValidationRequestEventSubscriber extends AdInterfacesEventSubscriber<ServerValidationRequestEvent> {
        public final Class<ServerValidationRequestEvent> m22748a() {
            return ServerValidationRequestEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class TargetingChangedEvent extends AdInterfacesEvent {
        AdInterfacesTargetingData f21678a;

        public TargetingChangedEvent(AdInterfacesTargetingData adInterfacesTargetingData) {
            this.f21678a = adInterfacesTargetingData;
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class TargetingChangedSubscriber extends AdInterfacesEventSubscriber<TargetingChangedEvent> {
        public final Class<TargetingChangedEvent> m22749a() {
            return TargetingChangedEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class TargetingValidationEvent extends ValidationEvent {
        public TargetingValidationEvent(BoostedComponentValidationMessageModel boostedComponentValidationMessageModel) {
            super(boostedComponentValidationMessageModel);
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class TargetingValidationEventSubscriber extends AdInterfacesEventSubscriber<TargetingValidationEvent> {
        public final Class<TargetingValidationEvent> m22750a() {
            return TargetingValidationEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class UnifiedAudienceChangedEvent extends AdInterfacesEvent {
        public BoostedComponentAudienceModel f21679a;

        public UnifiedAudienceChangedEvent(BoostedComponentAudienceModel boostedComponentAudienceModel) {
            this.f21679a = boostedComponentAudienceModel;
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class UnifiedAudienceChangedSubscriber extends AdInterfacesEventSubscriber<UnifiedAudienceChangedEvent> {
        public final Class<UnifiedAudienceChangedEvent> m22751a() {
            return UnifiedAudienceChangedEvent.class;
        }
    }

    /* compiled from: acceptMessageRequests */
    public class UrlVisibilityEvent extends AdInterfacesEvent {
        public final boolean f21680a;

        public UrlVisibilityEvent(boolean z) {
            this.f21680a = z;
        }
    }

    /* compiled from: acceptMessageRequests */
    public abstract class UrlVisibilitySubscriber extends AdInterfacesEventSubscriber<UrlVisibilityEvent> {
        public final Class<UrlVisibilityEvent> m22752a() {
            return UrlVisibilityEvent.class;
        }
    }
}
