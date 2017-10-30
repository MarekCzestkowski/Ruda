package czestkowski.com.ruda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


public class Settings extends Activity {
//    TextView textView = (TextView) findViewById(R.id.textView21);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);


        // NOT WORKING YET

//        textView.setText("600074124, 784468298");



//        Intent i = new Intent(this, MainActivity.class);
//        i.putExtra ("numbers", numery);

    }
//    public static String WezNumer() {
//        String x= ZmienNumer();
//        return x;
//    }
//    public static String ZmienNumer() {
//        EditText editText = (EditText) findViewById(R.id.editText);
//        String x= "123456789";
////        String x= "600074124, 784468298";
//        x= editText.getText().toString();
//        editText.getText().toString() ;
//
//        return x;
//    }
}
