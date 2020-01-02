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

public class UsrEditActivity extends AppCompatActivity {
    private TextView useridTextview;
    private EditText usernameEditText;
    private TextView licensetypeTextview;
    private EditText licensenumberEditText;
    private TextView passengertypeTextview;
    private TextView phonenumberTextview;
    private ImageButton licensetypeButton;
    private ImageButton passengertypeButton;
    private Button saveConfigButton;

    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usr_edit);

        useridTextview=findViewById(R.id.userid_editview_Textview);
        usernameEditText=findViewById(R.id.username_editview_EditText);
        licensetypeTextview=findViewById(R.id.licensetype_editview_Textview);
        licensenumberEditText=findViewById(R.id.licensenumber_editview_EditText);
        passengertypeTextview=findViewById(R.id.passengertype_editview_Textview);
        phonenumberTextview=findViewById(R.id.phonenumber_editview_Textview);
        licensetypeButton=findViewById(R.id.licensetype_editview_button);
        passengertypeButton=findViewById(R.id.passengertype_editview_button);
        saveConfigButton=findViewById(R.id.save_config_button);

        user=((myApplication)getApplication()).getUser();

        useridTextview.setText(user.getUserid());
        usernameEditText.setText(user.getUsername());
        licensetypeTextview.setText(user.getLicensetype());
        licensenumberEditText.setText(user.getLicensenumber());
        passengertypeTextview.setText(user.getPassengertype());
        phonenumberTextview.setText(user.getPhonenumber());

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
                int chechedItem=-1;
                switch(passengertypeTextview.getText().toString()){
                    case "学生":
                        chechedItem=0;
                        break;
                    case "成人":
                        chechedItem=1;
                        break;
                    case "儿童":
                        chechedItem=2;
                        break;
                }
                builder.setSingleChoiceItems(items, chechedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        passengertypeTextview.setText(items[which]);
                        dialog.dismiss();
                    }
                });
                builder.show();
            }
        });
        saveConfigButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setUserid(useridTextview.getText().toString());
                user.setUsername(usernameEditText.getText().toString());
                user.setLicensetype(licensetypeTextview.getText().toString());
                user.setLicensenumber(licensenumberEditText.getText().toString());
                user.setPassengertype(passengertypeTextview.getText().toString());
                user.setPhonenumber(phonenumberTextview.getText().toString());


                SQLiteDatabase mdb=((myApplication) getApplication()).getMdb();
                if(UserUtilities.updateUser(user,mdb)){
                    Toast.makeText(UsrEditActivity.this, "更新成功", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(UsrEditActivity.this, "更新失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
