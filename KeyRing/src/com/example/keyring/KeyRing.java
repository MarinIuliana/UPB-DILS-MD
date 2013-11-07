package com.example.keyring;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;

public class KeyRing extends Activity {
	
	String password;
	
	public void showDialog(){
    	final EditText input = new EditText(this);
    	input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        
		Builder passDialog = new AlertDialog.Builder(KeyRing.this);
		passDialog.setTitle("Enter your password:");
        //passDialog.setMessage("Hello")
        passDialog.setView(input);
        passDialog.setCancelable(false);
        passDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            	password = input.getText().toString();
            	if(password.equals("1232"))
            	{
            		Log.d(password, "success");
                }
                else
                {
                    Log.d(password, "fail");
                    String message = "The password you have entered is incorrect." + " \n \n" + "Please try again!";
                    AlertDialog.Builder builder = new AlertDialog.Builder(KeyRing.this);
                    builder.setTitle("Incorrect password");
                    builder.setMessage(message);
                    builder.setCancelable(false);
                    builder.setNegativeButton("Retry", new DialogInterface.OnClickListener() {
	                    @Override
	                    public void onClick(DialogInterface dialog, int id) 
	                    {
	                    	showDialog();
	                    }
                    });
                    builder.create().show();
                }
            	
            }
        });
        passDialog.show();		
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        showDialog();

    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_ring);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.key_ring, menu);
        return true;
    }
    
}
