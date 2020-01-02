package com.example.trainsearch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trainsearch.app.myApplication;
import com.example.trainsearch.bean.User;
import com.example.trainsearch.utilities.UserUtilities;

public class RegisterActivity extends AppCompatActivity {
    private EditText useridEditText;
    private EditText pwdEditText;
    private EditText usernameEditText;
    private ImageButton licensetypeButton;
    private TextView licensetypeTextview;
    private EditText licensenumberEditText;
    private ImageButton passengertypeButton;
    private TextView passengerTextview;
    private EditText phonenumberEditText;
    private Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        useridEditText=findViewById(R.id.userid_registerview_EditText);
        pwdEditText=findViewById(R.id.pwd_registerview_EditText);
        usernameEditText=findViewById(R.id.username_editview_EditText);
        licensetypeButton=findViewById(R.id.licensetype_registerview_button);
        licensetypeTextview=findViewById(R.id.licensetype_registerview_Textview);
        licensenumberEditText=findViewById(R.id.licensenumber_registerview_EditText);
        passengertypeButton=findViewById(R.id.passengertype_registerview_button);
        passengerTextview=findViewById(R.id.passengertype_registerview_Textview);
        phonenumberEditText=findViewById(R.id.phonenumber_registerview_EditText);
        registerButton=findViewById(R.id.register_button);

        licensetypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 工厂设计模式，得到创建对话框的工厂
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("证件类型：");
                final String[] items = {"身份证", "护照"};
                //第一个参数传入具体选项；
                //第二个参数，默认勾选；没有勾选，传入-1；
                //第三个参数传入 点击监听
                int checkedItem=-1;
                switch((String)licensetypeTextview.getText()){
                    case "身份证":
                        checkedItem=0;
                        break;
                    case "护照":
                        checkedItem=1;
                        break;
                    default:
                        checkedItem=-1;
                        break;
                }
                builder.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        licensetypeTextview.setText(items[which]);
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
        passengertypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 工厂设计模式，得到创建对话框的工厂
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("乘客类型：");
                final String[] items = {"学生", "成人","儿童"};
                //第一个参数传入具体选项；
                //第二个参数，默认勾选；没有勾选，传入-1；
                //第三个参数传入 点击监听
                int chechedItem;
                switch(passengerTextview.getText().toString()){
                    case "学生":
                        chechedItem=0;
                        break;
                    case "成人":
                        chechedItem=1;
                        break;
                    case "儿童":
                        chechedItem=2;
                        break;
                    default:
                        chechedItem=-1;
                        break;
                }
                builder.setSingleChoiceItems(items, chechedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        passengerTextview.setText(items[which]);
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user=new User();
                user.setUserid(useridEditText.getText().toString());
                user.setPwd(pwdEditText.getText().toString());
                user.setUsername(usernameEditText.getText().toString());
                user.setLicensetype(licensetypeTextview.getText().toString());
                user.setLicensenumber(licensenumberEditText.getText().toString());
                user.setPassengertype(passengerTextview.getText().toString());
                user.setPhonenumber(phonenumberEditText.getText().toString());
                if(user.getUserid().equals("")||user.getPwd().equals("")){
                    Toast.makeText(RegisterActivity.this, "用户名或密码为空", Toast.LENGTH_SHORT).show();
                }
                else {
                    SQLiteDatabase mdb = ((myApplication) getApplication()).getMdb();
                    if (UserUtilities.checkUserIfExist(user, mdb)) {
                        Toast.makeText(RegisterActivity.this, "用户已存在", Toast.LENGTH_SHORT).show();
                    } else {
                        UserUtilities.insertUser(user, mdb);
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
