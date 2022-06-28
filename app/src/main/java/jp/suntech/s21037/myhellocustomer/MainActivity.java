package jp.suntech.s21037.myhellocustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btClick=findViewById(R.id.btClick);
        HelloListener listener=new HelloListener();//リスナのインスタンス
        btClick.setOnClickListener(listener);//ボタンにリスナを組み込む

        Button btClearname = findViewById(R.id.btClearname);
        btClearname.setOnClickListener(listener);
        Button btClearjyusho = findViewById(R.id.btClearjyusho);
        btClearjyusho.setOnClickListener(listener);
    }

    //リスナクラス<=イベントの監視
    private  class  HelloListener implements View.OnClickListener{
        @Override
        //イベントハンドラ<=イベント発生時の処理
        public void onClick(View view){
            TextView output = findViewById(R.id.tvOutput);
            EditText inputjyusho =findViewById(R.id.etjyusho);
            EditText inputname =findViewById(R.id.etName);

            int id=view.getId();

            String inputStr = inputname.getText().toString();
            String inputStrjyusho = inputjyusho.getText().toString();

            switch (id){
                case R.id.btClick:

                    output.setText(inputStrjyusho+"にお住まいの"+inputStr+"さん、こんにちは！");
                    break;

                case R.id.btClearname:
                    inputname.setText("");
                    inputStr="";
                    output.setText("名前と住所を入力してください");
                    break;

                case R.id.btClearjyusho:
                    inputjyusho.setText("");
                    inputStrjyusho="";
                    output.setText("名前と住所を入力してください");
                    break;

            }

        }
    }

}