package com.utkarsh.dialogbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button simple = findViewById(R.id.normal);
        final Button checkbox = findViewById(R.id.checkbox);
        Button radio = findViewById(R.id.radiobutton);

        final int[] check = {-1};
        final String[] list = {"Option 1","Option 2","Option 3"};
        final boolean[] checked = {false,false,false};

        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Simple Dialog")
                        .setCancelable(false)
                        .setIcon(R.drawable.ic_launcher_foreground)
                        .setMessage("Example Dialog Box...")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"Positive Button",Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"Negative Button",Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"Neutral Button",Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });
        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("CheckBox Dialog")
                        .setCancelable(false)
                        .setIcon(R.drawable.ic_launcher_foreground)
                        .setMultiChoiceItems(list, checked, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checked[which] = isChecked;
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(checked[0]) {
                                    if(checked[1]) {
                                        if(checked[2]) {
                                            Toast.makeText(MainActivity.this,"All Checkboxes are checked...",Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            Toast.makeText(MainActivity.this,"Checkbox 1 and 2 are checked...",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    else {
                                        if(checked[2]) {
                                            Toast.makeText(MainActivity.this,"Checkbox 1 and 3 are checked...",Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            Toast.makeText(MainActivity.this,"Checkbox 1 is checked...",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else {
                                    if(checked[1]) {
                                        if(checked[2]) {
                                            Toast.makeText(MainActivity.this,"Checkbox 2 and 3 are checked...",Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            Toast.makeText(MainActivity.this,"Checkbox 2 is checked...",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    else {
                                        if(checked[2]) {
                                            Toast.makeText(MainActivity.this,"Checkbox 3 is checked...",Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            Toast.makeText(MainActivity.this,"No Checkboxes are checked...",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                dialog.dismiss();
                            }
                        })
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"You cancelled it.",Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .show();
                checked[0] = checked[1] = checked[2] = false;
            }
        });
        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Radio Button Dialog")
                        .setCancelable(false)
                        .setIcon(R.drawable.ic_launcher_foreground)
                        .setSingleChoiceItems(list, check[0], new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                check[0] = which+1;
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(check[0] != -1) {
                                    Toast.makeText(MainActivity.this,"You clicked on RadioButton - "+check[0],Toast.LENGTH_SHORT).show();
                                }
                                dialog.dismiss();
                            }
                        })
                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"You cancelled it.",Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .show();
                check[0] = -1;
            }
        });
    }
}
