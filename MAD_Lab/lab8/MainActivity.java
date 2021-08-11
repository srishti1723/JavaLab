package com.example.callandsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;


public class MainActivity extends AppCompatActivity {
    private com.example.callandsave.databinding.ActivityMainBinding binding;

    EditText editTextDialer;
    Button call,one,two,three,four,five,six,seven,eight,nine,zero,star,hutch,save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //setContentView(R.layout.activity_main);
        EditText call=findViewById(R.id.DialerScreen);

        PhoneNumberUtils.formatNumber(call.getText().toString());

        binding.button0.setOnClickListener(v -> binding.DialerScreen.setText(binding.DialerScreen.getText()+"0"));
        binding.button1.setOnClickListener(v -> binding.DialerScreen.setText(binding.DialerScreen.getText()+"1"));
        binding.button2.setOnClickListener(v -> binding.DialerScreen.setText(binding.DialerScreen.getText()+"2"));
        binding.button3.setOnClickListener(v -> binding.DialerScreen.setText(binding.DialerScreen.getText()+"3"));
        binding.button4.setOnClickListener(v -> binding.DialerScreen.setText(binding.DialerScreen.getText()+"4"));
        binding.button5.setOnClickListener(v -> binding.DialerScreen.setText(binding.DialerScreen.getText()+"5"));
        binding.button6.setOnClickListener(v -> binding.DialerScreen.setText(binding.DialerScreen.getText()+"6"));
        binding.button7.setOnClickListener(v -> binding.DialerScreen.setText(binding.DialerScreen.getText()+"7"));
        binding.button8.setOnClickListener(v -> binding.DialerScreen.setText(binding.DialerScreen.getText()+"8"));
        binding.button9.setOnClickListener(v -> binding.DialerScreen.setText(binding.DialerScreen.getText()+"9"));
        binding.buttonstar.setOnClickListener(v -> binding.DialerScreen.setText(binding.DialerScreen.getText()+"*"));
        binding.buttonhutch.setOnClickListener(v -> binding.DialerScreen.setText(binding.DialerScreen.getText()+"#"));

        String phonenumber=binding.DialerScreen.getText().toString();

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.DialerScreen.getText().length() > 0) {
                    CharSequence currentText = binding.DialerScreen.getText();
                    binding.DialerScreen.setText(currentText.subSequence(0, currentText.length()-1));
                }
                else {
                    binding.DialerScreen.setText("");

                }
            }
        });

        binding.buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!binding.DialerScreen.getText().toString().isEmpty())
                {
                    String ph_no=binding.DialerScreen.getText().toString();
                    Intent intent=new Intent(Intent.ACTION_INSERT);

                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                    intent.putExtra(ContactsContract.Intents.Insert.PHONE,ph_no);

                    startActivity(intent);

                }
            }
        });

        binding.buttoncall.setOnClickListener(v -> {
            if(binding.DialerScreen.getText().toString().length()>0)
            {
                String Phstr="tel:"+binding.DialerScreen.getText().toString();
                makePhoneCall(Phstr);
            }else
            {
                Toast.makeText(getApplicationContext(),"Unable to call",Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void makePhoneCall(String Phstr)
    {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            String phone=binding.DialerScreen.getText().toString();
            Intent phoneintent=new Intent(Intent.ACTION_CALL);

            phoneintent.setData(Uri.parse("tel:"+phone));

            startActivity(phoneintent);
        }
    }
}