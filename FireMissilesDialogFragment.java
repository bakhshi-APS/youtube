package com.example.google.androidalertdialogboxes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class FireMissilesDialogFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {




        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        builder.setMessage(R.string.fire_missile_title)
                .setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // When clicked on Fire button of alert dialog box



                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // When clicked on Cancel button of alert dialog box


            }
        });



        return builder.create();





    }
}
