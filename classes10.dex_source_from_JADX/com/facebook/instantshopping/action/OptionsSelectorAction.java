package com.facebook.instantshopping.action;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.instantshopping.action.bottomsheet.InstantShoppingBottomSheetAdapter;
import com.facebook.instantshopping.event.InstantShoppingEvents.ExecuteActionEvent;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingActionFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingOptionsActionFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingSelectorOptionsFragmentModel;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SingleFragment */
public class OptionsSelectorAction {
    private static OptionsSelectorAction f23511b;
    private static final Object f23512c = new Object();
    public final RichDocumentEventBus f23513a;

    /* compiled from: SingleFragment */
    public class OptionController {
        private final InstantShoppingSelectorOptionsFragmentModel f23506a;
        final /* synthetic */ OptionsSelectorAction f23507c;

        public OptionController(OptionsSelectorAction optionsSelectorAction, InstantShoppingSelectorOptionsFragmentModel instantShoppingSelectorOptionsFragmentModel) {
            this.f23507c = optionsSelectorAction;
            this.f23506a = instantShoppingSelectorOptionsFragmentModel;
        }

        public String mo996a() {
            return this.f23506a.c();
        }

        public InstantShoppingOptionsActionFragmentModel mo997b() {
            return this.f23506a.a();
        }

        public boolean mo998c() {
            return this.f23506a.b();
        }
    }

    /* compiled from: SingleFragment */
    public class HeaderOptionController extends OptionController {
        private String f23508a;
        final /* synthetic */ OptionsSelectorAction f23509b;

        public HeaderOptionController(OptionsSelectorAction optionsSelectorAction, String str) {
            this.f23509b = optionsSelectorAction;
            super(optionsSelectorAction, null);
            this.f23508a = str;
        }

        public String mo996a() {
            return this.f23508a;
        }

        public final InstantShoppingOptionsActionFragmentModel mo997b() {
            return null;
        }

        public final boolean mo998c() {
            return true;
        }
    }

    /* compiled from: SingleFragment */
    public class DividerOptionController extends HeaderOptionController {
        final /* synthetic */ OptionsSelectorAction f23510a;

        public DividerOptionController(OptionsSelectorAction optionsSelectorAction) {
            this.f23510a = optionsSelectorAction;
            super(optionsSelectorAction, null);
        }

        public final String mo996a() {
            return "";
        }
    }

    private static OptionsSelectorAction m24814b(InjectorLike injectorLike) {
        return new OptionsSelectorAction(RichDocumentEventBus.a(injectorLike));
    }

    public static OptionsSelectorAction m24813a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OptionsSelectorAction b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23512c) {
                OptionsSelectorAction optionsSelectorAction;
                if (a2 != null) {
                    optionsSelectorAction = (OptionsSelectorAction) a2.a(f23512c);
                } else {
                    optionsSelectorAction = f23511b;
                }
                if (optionsSelectorAction == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24814b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23512c, b3);
                        } else {
                            f23511b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = optionsSelectorAction;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public OptionsSelectorAction(RichDocumentEventBus richDocumentEventBus) {
        this.f23513a = richDocumentEventBus;
    }

    public final void m24815a(Context context, InstantShoppingActionFragmentModel instantShoppingActionFragmentModel) {
        String g = instantShoppingActionFragmentModel.g();
        ImmutableList b = instantShoppingActionFragmentModel.b();
        List arrayList = new ArrayList();
        arrayList.add(new HeaderOptionController(this, g));
        arrayList.add(new DividerOptionController(this));
        int size = b.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new OptionController(this, (InstantShoppingSelectorOptionsFragmentModel) b.get(i)));
        }
        List<OptionController> list = arrayList;
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        InstantShoppingBottomSheetAdapter instantShoppingBottomSheetAdapter = new InstantShoppingBottomSheetAdapter(context);
        for (final OptionController optionController : list) {
            instantShoppingBottomSheetAdapter.a(optionController.mo996a()).setCheckable(true).setCheckable(!optionController.mo998c()).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ OptionsSelectorAction f23505b;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    if (optionController.mo998c() && optionController.mo997b() != null) {
                        this.f23505b.f23513a.a(new ExecuteActionEvent(optionController.mo997b()));
                    }
                    return true;
                }
            });
        }
        bottomSheetDialog.a(instantShoppingBottomSheetAdapter);
        bottomSheetDialog.show();
    }
}
