package com.example.informe;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;


public class Tofragme extends DialogFragment {


    public static final String ARGUMENTO_TITLE = "TITLE";
    public static final String ARGUMENTO_FULL_SNIPPET = "FULL_SNIPPET";

    private String title;
    private String fullsnippet;


    public static Tofragme newInstance(String title, String fullSnippet) {
        Tofragme fragme = new Tofragme();
        Bundle b = new Bundle();
        b.putString(ARGUMENTO_TITLE, title);
        b.putString(ARGUMENTO_FULL_SNIPPET, fullSnippet);
        fragme.setArguments(b);
        return fragme;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arg = getArguments();

        title = arg.getString(ARGUMENTO_TITLE);
        fullsnippet = arg.getString(ARGUMENTO_FULL_SNIPPET);

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(fullsnippet)
                .create();
        return dialog;
    }
}
