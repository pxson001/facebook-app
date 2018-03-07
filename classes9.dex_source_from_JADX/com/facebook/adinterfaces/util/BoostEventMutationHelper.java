package com.facebook.adinterfaces.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.model.events.AdInterfacesBoostEventDataModel;
import com.facebook.adinterfaces.protocol.CreateBoostedComponentMethod;
import com.facebook.adinterfaces.protocol.DeleteBoostedComponentMethod;
import com.facebook.adinterfaces.protocol.EditBoostedComponentMethod;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Unknown MessengerPayHistoryMode provided  */
public class BoostEventMutationHelper implements BoostMutationHelper<AdInterfacesBoostEventDataModel> {
    private static BoostEventMutationHelper f23270d;
    private static final Object f23271e = new Object();
    public final DeleteBoostedComponentMethod f23272a;
    public final EditBoostedComponentMethod f23273b;
    public final CreateBoostedComponentMethod f23274c;

    /* compiled from: Unknown MessengerPayHistoryMode provided  */
    public class C27606 implements OnClickListener {
        final /* synthetic */ AdInterfacesBoostEventDataModel f23266a;
        final /* synthetic */ View f23267b;
        final /* synthetic */ BoostEventMutationHelper f23268c;

        public C27606(BoostEventMutationHelper boostEventMutationHelper, AdInterfacesBoostEventDataModel adInterfacesBoostEventDataModel, View view) {
            this.f23268c = boostEventMutationHelper;
            this.f23266a = adInterfacesBoostEventDataModel;
            this.f23267b = view;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f23268c.f23272a.m24065a(BoostEventComponentModelConversionUtil.m25240a(this.f23266a), this.f23267b.getContext());
        }
    }

    /* compiled from: Unknown MessengerPayHistoryMode provided  */
    public class C27617 implements OnClickListener {
        final /* synthetic */ BoostEventMutationHelper f23269a;

        public C27617(BoostEventMutationHelper boostEventMutationHelper) {
            this.f23269a = boostEventMutationHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    private static BoostEventMutationHelper m25247b(InjectorLike injectorLike) {
        return new BoostEventMutationHelper(DeleteBoostedComponentMethod.m24062a(injectorLike), EditBoostedComponentMethod.m24067a(injectorLike), CreateBoostedComponentMethod.m24054a(injectorLike));
    }

    public final View.OnClickListener mo1048a(Context context, AdInterfacesContext adInterfacesContext, AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel) {
        final AdInterfacesBoostEventDataModel adInterfacesBoostEventDataModel = (AdInterfacesBoostEventDataModel) adInterfacesBoostPostDataModel;
        return new View.OnClickListener(this) {
            final /* synthetic */ BoostEventMutationHelper f23265b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2075266720);
                adInterfacesBoostEventDataModel.f21748d = AdInterfacesStatus.PAUSED;
                this.f23265b.f23273b.m24070a(BoostEventComponentModelConversionUtil.m25240a(adInterfacesBoostEventDataModel), view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, -1704334033, a);
            }
        };
    }

    public final View.OnClickListener mo1049a(AdInterfacesContext adInterfacesContext, AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel) {
        final AdInterfacesBoostEventDataModel adInterfacesBoostEventDataModel = (AdInterfacesBoostEventDataModel) adInterfacesBoostPostDataModel;
        return new View.OnClickListener(this) {
            final /* synthetic */ BoostEventMutationHelper f23259b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1236154253);
                BoostEventMutationHelper boostEventMutationHelper = this.f23259b;
                AdInterfacesBoostEventDataModel adInterfacesBoostEventDataModel = adInterfacesBoostEventDataModel;
                FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(view.getContext());
                fbAlertDialogBuilder.a(2131233998);
                fbAlertDialogBuilder.b(2131233999);
                fbAlertDialogBuilder.a(2131233989, new C27606(boostEventMutationHelper, adInterfacesBoostEventDataModel, view));
                fbAlertDialogBuilder.b(2131233976, new C27617(boostEventMutationHelper));
                fbAlertDialogBuilder.a().show();
                Logger.a(2, EntryType.UI_INPUT_END, 1759115090, a);
            }
        };
    }

    public final View.OnClickListener mo1050b(Context context, AdInterfacesContext adInterfacesContext, AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel) {
        final AdInterfacesBoostEventDataModel adInterfacesBoostEventDataModel = (AdInterfacesBoostEventDataModel) adInterfacesBoostPostDataModel;
        return new View.OnClickListener(this) {
            final /* synthetic */ BoostEventMutationHelper f23263b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1909567873);
                adInterfacesBoostEventDataModel.f21748d = AdInterfacesStatus.ACTIVE;
                this.f23263b.f23273b.m24070a(BoostEventComponentModelConversionUtil.m25240a(adInterfacesBoostEventDataModel), view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 1321520451, a);
            }
        };
    }

    public final View.OnClickListener mo1051c(Context context, AdInterfacesContext adInterfacesContext, AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel) {
        final AdInterfacesBoostEventDataModel adInterfacesBoostEventDataModel = (AdInterfacesBoostEventDataModel) adInterfacesBoostPostDataModel;
        return new View.OnClickListener(this) {
            final /* synthetic */ BoostEventMutationHelper f23261b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1028246138);
                this.f23261b.f23273b.m24070a(BoostEventComponentModelConversionUtil.m25240a(adInterfacesBoostEventDataModel), view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, -1939605993, a);
            }
        };
    }

    public final View.OnClickListener mo1052d(Context context, final AdInterfacesContext adInterfacesContext, AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel) {
        final AdInterfacesBoostEventDataModel adInterfacesBoostEventDataModel = (AdInterfacesBoostEventDataModel) adInterfacesBoostPostDataModel;
        return new View.OnClickListener(this) {
            final /* synthetic */ BoostEventMutationHelper f23257c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1664902217);
                this.f23257c.f23274c.m24057a(adInterfacesContext, BoostEventComponentModelConversionUtil.m25240a(adInterfacesBoostEventDataModel), view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 1230891257, a);
            }
        };
    }

    @Inject
    public BoostEventMutationHelper(DeleteBoostedComponentMethod deleteBoostedComponentMethod, EditBoostedComponentMethod editBoostedComponentMethod, CreateBoostedComponentMethod createBoostedComponentMethod) {
        this.f23272a = deleteBoostedComponentMethod;
        this.f23273b = editBoostedComponentMethod;
        this.f23274c = createBoostedComponentMethod;
    }

    public static BoostEventMutationHelper m25246a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BoostEventMutationHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23271e) {
                BoostEventMutationHelper boostEventMutationHelper;
                if (a2 != null) {
                    boostEventMutationHelper = (BoostEventMutationHelper) a2.a(f23271e);
                } else {
                    boostEventMutationHelper = f23270d;
                }
                if (boostEventMutationHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25247b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23271e, b3);
                        } else {
                            f23270d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = boostEventMutationHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
