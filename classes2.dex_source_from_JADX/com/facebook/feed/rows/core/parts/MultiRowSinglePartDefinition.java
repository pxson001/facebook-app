package com.facebook.feed.rows.core.parts;

import android.view.View;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SinglePartDefinitionWithViewTypeAndIsNeeded;

/* compiled from: native_permalink */
public abstract class MultiRowSinglePartDefinition<Props, State, Environment extends AnyEnvironment, V extends View> extends BaseSinglePartDefinition<Props, State, Environment, V> implements PartWithViewType<Props>, SinglePartDefinitionWithViewTypeAndIsNeeded<Props, State, Environment, V>, SinglePartDefinitionWithViewType {
}
