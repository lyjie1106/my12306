package com.example.trainsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trainsearch.app.myApplication;
import com.example.trainsearch.bean.User;
import com.example.trainsearch.data.TestUtil;
import com.example.trainsearch.data.UserListDbHelper;
import com.example.trainsearch.utilities.UserUtilities;

public class LoginActivity extends AppCompatActivity {
    private EditText usrEditText;
    private EditText pwdEditText;
    private Button loginButton;
    private SQLiteDatabase mdb;
    private TextView registerText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usrEditText=findViewById(R.id.login_usrEditText);
        pwdEditText=findViewById(R.id.login_pwdEditText);
        loginButton=findViewById(R.id.login_loginButton);
        registerText=findViewById(R.id.register_Textview);

        //DB
        UserListDbHelper dbHelper=new UserListDbHelper(this);
        mdb=dbHelper.getWritableDatabase();
        ((myApplication)getApplication()).setMdb(mdb);





        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usr=usrEditText.getText().toString();
                String pwd=pwdEditText.getText().toString();

                SQLiteDatabase db=((myApplication)getApplication()).getMdb();

                if(usr.equals("")||pwd.equals("")){
                    Toast toast=Toast.makeText(LoginActivity.this,"用户名或密码为空",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(UserUtilities.check(usr,pwd,db)){
                    Context context = LoginActivity.this;
                    Class destinationActivity = SearchActivity.class;

                    User user=UserUtilities.getUser(usr,pwd,db);
                    ((myApplication) getApplication()).setUser(user);

                    Intent startLoginInActivityIntent = new Intent(context, destinationActivity);
                    startActivity(startLoginInActivityIntent);
                }
                else if(usr.equals("init")&&pwd.equals("root")){
                    TestUtil.insertFakeData(mdb);
                    Toast toast=Toast.makeText(LoginActivity.this,"初始化用户数据",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    Toast toast=Toast.makeText(LoginActivity.this,"密码错误",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = LoginActivity.this;
                Class destinationActivity = RegisterActivity.class;

                Intent startRegisterActivityIntent =new Intent(context,destinationActivity);
                startActivity(startRegisterActivityIntent);
            }
        });
    }


}
