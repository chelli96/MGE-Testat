import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ben_d.minipro.R;

import service.Callback;
import service.LibraryService;

/**
 * Created by kelle on 18.10.2017.
 */

public class LoginActivity extends AppCompatActivity {


    private boolean isLoginOnProgress = false;

    private EditText Mail;
    private EditText Password;
    private Button   SignIn;
    private TextView Registration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LibraryService.setServerAddress("http://mge8.dev.ifs.hsr.ch/public");
       setContentView(R.layout.loginscreen);

        Mail = (EditText)findViewById(R.id.email);
        Password = (EditText)findViewById(R.id.password);

        SignIn = (Button)findViewById(R.id.login);

        setContentView(Registration);
        Registration = (TextView) findViewById(R.id.registrieren);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), RegistrationActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
    }