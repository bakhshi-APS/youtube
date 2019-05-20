package com.example.google.androidalertdialogboxes;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import static android.widget.Toast.*;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    TextView result;
    RelativeLayout parent;

    FireMissilesDialogFragment fireMissilesDialogFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        result = (TextView) findViewById(R.id.result);
        parent = (RelativeLayout) findViewById(R.id.relative_parent);


        fireMissilesDialogFragment = new FireMissilesDialogFragment();


        Toast.makeText(this, "Changes have been committed", Toast.LENGTH_SHORT).show();



    }







    public void ShowAlertDialogBox(View view) {


        // Design an alert dialog box that display 3 radio buttons


        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.pick_a_color)
                .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        switch (which){

                            // When red is selected
                            case 0:
                                ChangeColor(R.color.red);
                                break;
                            case 1:
                                ChangeColor(R.color.green);
                                break;
                            case 2:
                                ChangeColor(R.color.blue);
                                break;

                        }

                    }
                });

        builder.show();

    }

    private void ChangeColor(int color) {


        Utils.darkenStatusBar(this,color);
        // Change the actionBar programmatically too


        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(color)));

        // Change the RelativeLayout/Parent of this activity

        parent.setBackgroundDrawable(new ColorDrawable(getResources().getColor(color)));


    }


    // Declared as Global
    ArrayList mSelectedItems;


    public void ShowItemsAlertDialog(View view) {


        mSelectedItems = new ArrayList();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.items_title)
                .setMultiChoiceItems(R.array.vegetables, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                        // which : the index of selected item

                        if(isChecked)
                        {
                            mSelectedItems.add(which);

                        }
                        else if(mSelectedItems.contains(which)){

                            // int to Integer(Object)
                            mSelectedItems.remove(Integer.valueOf(which));
                        }

                    }

                }).setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                // When okay button is clicked


                String[] values = getResources().getStringArray(R.array.vegetables);

                ArrayList<String> myList = new ArrayList<>();

                for(int i=0;i<mSelectedItems.size();i++){
                    String val = values[(int) mSelectedItems.get(i)];
                    myList.add(val);
                }


                result.setText(myList.toString());




            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // When cancel button is clicked


            }
        });


        builder.show();













    }

    public void FireMissileAlertDialog(View view) {


        // When fire Button is clicked




        fireMissilesDialogFragment.show(getFragmentManager(),"firemissiles");









    }

    public void Login(View view) {


        AlertDialog.Builder builder  = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();


        final View dialogView = inflater.inflate(R.layout.dialog_signin,null);
        builder.setView(dialogView);


        final EditText username = (EditText) dialogView.findViewById(R.id.username);
        final EditText password = (EditText) dialogView.findViewById(R.id.password);


        builder.setTitle("Login").setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                String vals = "Username : "+username.getText()+"\n"+"Password : "+password.getText();
                result.setText(vals);


            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {




            }
        });



        AlertDialog alertDialog = builder.create();
        alertDialog.show();








    }
}
