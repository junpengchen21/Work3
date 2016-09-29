package cn.edu.gdmec.s07150705.work3;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int iNum1;
    private int iNum2;
    private  TextView tv1;
    private TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);
        tv1.setText(" in onCreate  mothed get value");
        tv2.setText("in onCreate  mothed get value");
        iNum1=0;
        iNum2=0;
        Toast.makeText(this,"onCreate",Toast.LENGTH_LONG);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tv1.setText(" start OnReStart,show view1");
        tv2.setText(" start OnReStart,show view2");
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        iNum1++;
        iNum2++;
        outState.putString("tv1","onSaveInstanceState serve num value is"+iNum1);
        outState.putString("tv2",String.valueOf(iNum2));
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tv1.setText(savedInstanceState.getString("tv1"));
        tv2.setText("onSavedInstanceState serve num value is："+savedInstanceState.getString("tv2"));
        iNum2=Integer.parseInt(savedInstanceState.getString("tv2"));
    }
}
