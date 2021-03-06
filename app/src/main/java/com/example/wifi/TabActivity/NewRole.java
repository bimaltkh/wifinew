package com.example.wifi.TabActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.wifi.R;

import java.util.Calendar;

public class NewRole extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    DatePickerDialog picker;
    boolean isNewRole = false;
  /*  RoleDatabase roleDatabase;
    DaoAccess daoAccess;
    Role updateRole;*/
    String[] role = {"Role1","Role2","Role3","Role4"};
    EditText rolename,expirydate;
    Spinner parentrole;
    Button create;
    CheckBox viewsitelist,
    addsite,
    viewsitedetails,
    editsite,
    deletesite,
    viewsiteparams,
    viewalarms,
    viewalarmshistory,
    viewsitesettings,
    initializesettings,
    viewsiteidrequests,
    editsitesettings,
  controlsection,
    sendOTP,
    energylevels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newrole);
        //roleDatabase = Room.databaseBuilder(getApplicationContext(), RoleDatabase.class, RoleDatabase.DB_NAME).build();
       int role_id=getIntent().getIntExtra("id",-100);
        if (role_id == -100)
            isNewRole = true;

        if (!isNewRole) {

            //button
            create = findViewById(R.id.create);
            //edittext
            rolename = findViewById(R.id.rolenameaddrole);
            expirydate = findViewById(R.id.expirydateaddrole);
            expirydate.setInputType(InputType.TYPE_NULL);
            //spinner
            parentrole = findViewById(R.id.parentspiner);
            //checkboxes
            viewsitelist = findViewById(R.id.viewsite);
            addsite = findViewById(R.id.addsite);
            viewsitedetails = findViewById(R.id.viewsitedetail);
            editsite = findViewById(R.id.editsite);
            deletesite = findViewById(R.id.deletesite);
            viewsiteparams = findViewById(R.id.viewsiteparams);
            viewalarms = findViewById(R.id.viewalarm);
            viewalarmshistory = findViewById(R.id.alarmhistory);
            viewsitesettings = findViewById(R.id.viewsitesetting);
            initializesettings = findViewById(R.id.initializesettings);
            viewsiteidrequests = findViewById(R.id.viewSiteidRequest);
            editsitesettings = findViewById(R.id.editsitesetting);
            controlsection = findViewById(R.id.controlsection);
            sendOTP = findViewById(R.id.sendotp);
            energylevels = findViewById(R.id.energylevels);
            parentrole.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) NewRole.this);

            //Creating the ArrayAdapter instance having the country list
            ArrayAdapter aa = new ArrayAdapter(NewRole.this, android.R.layout.simple_spinner_item, role);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            parentrole.setAdapter(aa);
            expirydate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Calendar cldr = Calendar.getInstance();
                    int day = cldr.get(Calendar.DAY_OF_MONTH);
                    int month = cldr.get(Calendar.MONTH);
                    int year = cldr.get(Calendar.YEAR);
                    // date picker dialog
                    picker = new DatePickerDialog(NewRole.this,
                            new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                    expirydate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                }
                            }, year, month, day);
                    picker.show();
                }
            });

            create.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

    /*    String msg="";


        // Concatenation of the checked options in if

        // isChecked() is used to check whether
        // the CheckBox is in true state or not.

        if(viewsitelist.isChecked())
            msg = msg + " Painting ";
        if(addsite.isChecked())
            msg = msg + " Reading ";
        if(viewsitedetails.isChecked())
            msg = msg + " Singing ";
        if(viewsitelist.isChecked())
            msg = msg + " Cooking ";
     //   viewsitelist.setVisibility(View.INVISIBLE);
        viewsitelist.setEnabled(false);

        // Toast is created to display the
        // message using show() method.
        Toast.makeText(NewRole.this, msg + "are selected",
                Toast.LENGTH_LONG).show();
*/
     //  if(!( rolename.getText().toString().isEmpty() || expirydate.getText().toString().isEmpty())) {
            final String spin=parentrole.getSelectedItem().toString();

/*
                    if (isNewRole) {
                        Role role = new Role();
                        role.rolename = rolename.getText().toString();
                        role.expirydate = expirydate.getText().toString();
                        role.roletype = spin;
                        insertRow(role);

                    } else {

                        updateRole.rolename = rolename.getText().toString();
                        updateRole.expirydate = expirydate.getText().toString();
                        updateRole.roletype = spin;

                        updateRow(updateRole);
                    }*/
                }
     /*   else
        {
            Toast.makeText(NewRole.this, "enter values correctly", Toast.LENGTH_LONG).show();

        }*/

            });
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
   /* @SuppressLint("StaticFieldLeak")
    private void insertRow(Role role) {
        new AsyncTask<Role, Void, Long>() {
            @Override
            protected Long doInBackground(Role... params) {
                return roleDatabase.daoAccess().insertRole(params[0]);
            }

            @Override
            protected void onPostExecute(Long id) {
                super.onPostExecute(id);

                Intent intent = getIntent();
                intent.putExtra("isNew", true).putExtra("id", id);
                setResult(RESULT_OK, intent);
                finish();
            }
        }.execute(role);

    }
    @SuppressLint("StaticFieldLeak")
    private void updateRow(Role role) {
        new AsyncTask<Role, Void, Integer>() {
            @Override
            protected Integer doInBackground(Role... params) {
                return roleDatabase.daoAccess().updateRole(params[0]);
            }

            @Override
            protected void onPostExecute(Integer number) {
                super.onPostExecute(number);

                Intent intent = getIntent();
                intent.putExtra("isNew", false).putExtra("number", number);
                setResult(RESULT_OK, intent);
                finish();
            }
        }.execute(role);
*/
   // }

}