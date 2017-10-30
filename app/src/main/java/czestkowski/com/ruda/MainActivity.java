package czestkowski.com.ruda;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/*
1 zdjecie zeba 20zl
2 zdjecie zgryzowe 30zl
3 zdjecie zatok 30zl
4 pantomografia 65zl
5 cefalometria 65zl
6 stawow skroniowo-zuchwowych 65zl
7 panto plus cefalo komplet ort 120zl
8 tomografia odcinka / okolicy zeba 130zl
9 tomografia 1 luku zebowego 195zl
10 2 lukow 390zl
11 dodatkowa dokumentacja na kliszy lub plycie

UPDATE 01.2017

Orchidental
pantomografia 50
cefalometria 50
komplet 100
plyta 5

GoDent
panto 45
cefalo 45
komplet 90
plyta 5

Update2 03.2017

tk zatok 250
tk ucha 195
tk 2 uszu 390


update medicover 10.2017
zatoki 0
zatoki2 0
ucho 0
ucho2 0
*/
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Calendar cal = Calendar.getInstance();
    SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
    String data = df.format(cal.getTime());
    // formattedDate have current date/time


    int cenaG = 0;
    int cenaK = 0;
    String s1 = "Diagnodent Chelm\nUtarg z dnia dzisiejszego (" + data + ")";
    String s2 = "";
    String s = "";
    //Map<String, Integer> myMap = new HashMap<String, Integer>();

    int[] BUTTON_IDS = {
            R.id.button1G,
            R.id.button1K,
            R.id.button2G,
            R.id.button2K,
            R.id.button3G,
            R.id.button3K,
            R.id.button4G,
            R.id.button4K,
            R.id.button5G,
            R.id.button5K,
            R.id.button6G,
            R.id.button6K,
            R.id.button7G,
            R.id.button7K,
            R.id.button8G,
            R.id.button8K,
            R.id.button9G,
            R.id.button9K,
            R.id.button10G,
            R.id.button10K,
            R.id.button11G,
            R.id.button11K,
            // update
            R.id.button12G,
            R.id.button12K,
            R.id.button13G,
            R.id.button13K,

            R.id.button14G,
            R.id.button14K,
            R.id.button15G,
            R.id.button15K,

            R.id.button16G,
            R.id.button16K,
            R.id.button17G,
            R.id.button17K,

            R.id.button18G,
            R.id.button18K,
            //update 2
            R.id.button19G,
            R.id.button19K,

            R.id.button20G,
            R.id.button20K,

            R.id.button21G,
            R.id.button21K,

            R.id.button22G,
            R.id.button22K,

            R.id.button23G,
            R.id.button23K,

            //update medicover


    };
    Button buttons[] = new Button[BUTTON_IDS.length];

    List<String> l = new ArrayList<>();
    List<String> m = new ArrayList<>();

    int[] c = new int[BUTTON_IDS.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView29 = (TextView)findViewById(R.id.textView29);
        textView29.setRotation(-90);

        for (int i : c) {
            c[i] = 0;
        }

        int x = 0;
        for (int id : BUTTON_IDS) {
            Button button = (Button) findViewById(id);
            button.setOnClickListener(this);  // calling onClick() method
            buttons[x] = button;
            x++;
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement

        //GENERUJ
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.cash);
        mp.start();

        if (id == R.id.menu) {


            if (cenaG > 0 && cenaK > 0)
                s2 = s2.concat("\nrazem: " + cenaG + "zl gotowka +" + cenaK + "zl karta");
            else if (cenaG > 0) s2 = s2.concat("\nrazem: " + cenaG + "zl gotowka");
            else if (cenaK > 0) s2 = s2.concat("\nrazem: " + cenaK + "zl karta");
            else s2 = s2.concat("\n0zl");


            s2 = s2.concat("\npozdrawiam, Monika");
            s = s1+Generuj()+s2;

            // COPY TO CLIPBOARD
//            ClipboardManager clip =(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//                clip.setText(s);
//
//                Toast.makeText(getApplicationContext(), "skopiowano do schowka", Toast.LENGTH_SHORT).show();
//            }

            //READY
//            Uri uri = Uri.parse("smsto:"+Numer());
            //TESTING
            Uri uri = Uri.parse("smsto:123456789");
            Intent it = new Intent(Intent.ACTION_SENDTO, uri);
            it.putExtra("sms_body", s);
            startActivity(it);
        }


        //RESET
        else if (id == R.id.menu1) {

            l.clear();
            m.clear();

            cenaG = 0;
            cenaK = 0;
            s1 = "Diagnodent Chelm\nUtarg z dzisiaj (" + data + ")";
            s2 = "";
            s = "";

            for (int i = 0; i < c.length; i++) {
                c[i] = 0;
            }

            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setText("0");
            }

        }
        //INFO
        else if (id== R.id.menu2){
            Intent i = new Intent(MainActivity.this, Settings.class);
            startActivity(i);

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.typewriter);

        switch (v.getId()) {

            case R.id.button1G:
                cenaG += 20;
                c[0]++;
                buttons[0].setText(c[0] + "");
                l.add("zdjecie zeba");
                mp.start();
                break;

            case R.id.button1K:
                cenaK += 20;
                c[1]++;
                buttons[1].setText(c[1] + "");
                l.add("zdjecie zeba");
                mp.start();
                break;

            case R.id.button2G:
                cenaG += 30;
                c[2]++;
                buttons[2].setText(c[2] + "");
                l.add("zdjecie zgryzowe");
                mp.start();
                break;

            case R.id.button2K:
                cenaK += 30;
                c[3]++;
                buttons[3].setText(c[3] + "");
                l.add("zdjecie zgryzowe");
                mp.start();
                break;

            case R.id.button3G:
                cenaG += 65;
                c[4]++;
                buttons[4].setText(c[4] + "");
                l.add("zdjecie zatok");
                mp.start();
                break;

            case R.id.button3K:
                cenaK += 65;
                c[5]++;
                buttons[5].setText(c[5] + "");
                l.add("zdjecie zatok");
                mp.start();
                break;

            case R.id.button4G:
                cenaG += 65;
                c[6]++;
                buttons[6].setText(c[6] + "");
                l.add("pantomografia");
                mp.start();
                break;

            case R.id.button4K:
                cenaK += 65;
                c[7]++;
                buttons[7].setText(c[7] + "");
                l.add("pantomografia");
                mp.start();
                break;

            case R.id.button5G:
                cenaG += 65;
                c[8]++;
                buttons[8].setText(c[8] + "");
                l.add("cefalometria");
                mp.start();
                break;

            case R.id.button5K:
                cenaK += 65;
                c[9]++;
                buttons[9].setText(c[9] + "");
                l.add("cefalometria");
                mp.start();
                break;

            case R.id.button6G:
                cenaG += 65;
                c[10]++;
                buttons[10].setText(c[10] + "");
                l.add("zd. st. skroniowo-zuchwowych");
                mp.start();
                break;

            case R.id.button6K:
                cenaK += 65;
                c[11]++;
                buttons[11].setText(c[11] + "");
                l.add("zd. st. skroniowo-zuchwowych");
                mp.start();
                break;

            case R.id.button7G:
                cenaG += 120;
                c[12]++;
                buttons[12].setText(c[12] + "");
                l.add("komplet ort.");
                mp.start();
                break;

            case R.id.button7K:
                cenaK += 120;
                c[13]++;
                buttons[13].setText(c[13] + "");
                l.add("komplet ort.");
                mp.start();
                break;

            case R.id.button8G:
                cenaG += 130;
                c[14]++;
                buttons[14].setText(c[14] + "");
                l.add("tk odc/okolicy zeba");
                mp.start();
                break;

            case R.id.button8K:
                cenaK += 130;
                c[15]++;
                buttons[15].setText(c[15] + "");
                l.add("tk odc/okolicy zeba");
                mp.start();
                break;

            case R.id.button9G:
                cenaG += 195;
                c[16]++;
                buttons[16].setText(c[16] + "");
                l.add("tk 1 luku zebowego");
                mp.start();
                break;

            case R.id.button9K:
                cenaK += 195;
                c[17]++;
                buttons[17].setText(c[17] + "");
                l.add("tk 1 luku zebowego");
                mp.start();
                break;

            case R.id.button10G:
                cenaG += 390;
                c[18]++;
                buttons[18].setText(c[18] + "");
                l.add("tk 2 lukow zebowych");
                mp.start();
                break;

            case R.id.button10K:
                cenaK += 390;
                c[19]++;
                buttons[19].setText(c[19] + "");
                l.add("tk 2 lukow zebowych");
                mp.start();
                break;

            case R.id.button11G:
                cenaG += 10;
                c[20]++;
                buttons[20].setText(c[20] + "");
                l.add("CD+klisza");
                mp.start();
                break;

            case R.id.button11K:
                cenaK += 10;
                c[21]++;
                buttons[21].setText(c[21] + "");
                l.add("CD+klisza");
                mp.start();
                break;

            case R.id.button12G:
                cenaG += 50;
                c[22]++;
                buttons[22].setText(c[22] + "");
                l.add("pantomografia");
                mp.start();
                break;

            case R.id.button12K:
                cenaK += 50;
                c[23]++;
                buttons[23].setText(c[23] + "");
                l.add("pantomografia");
                mp.start();
                break;

            case R.id.button13G:
                cenaG += 45;
                c[24]++;
                buttons[24].setText(c[24] + "");
                l.add("pantomografia");
                mp.start();
                break;

            case R.id.button13K:
                cenaK += 45;
                c[25]++;
                buttons[25].setText(c[25] + "");
                l.add("pantomografia");
                mp.start();
                break;

            case R.id.button14G:
                cenaG += 50;
                c[26]++;
                buttons[26].setText(c[26] + "");
                l.add("cefalometria");
                mp.start();
                break;

            case R.id.button14K:
                cenaK += 50;
                c[27]++;
                buttons[27].setText(c[27] + "");
                l.add("cefalometria");
                mp.start();
                break;

            case R.id.button15G:
                cenaG += 45;
                c[28]++;
                buttons[28].setText(c[28] + "");
                l.add("cefalometria");
                mp.start();
                break;

            case R.id.button15K:
                cenaK += 45;
                c[29]++;
                buttons[29].setText(c[29] + "");
                l.add("cefalometria");
                mp.start();
                break;

            case R.id.button16G:
                cenaG += 100;
                c[30]++;
                buttons[30].setText(c[30] + "");
                l.add("komplet ort.");
                mp.start();
                break;

            case R.id.button16K:
                cenaK += 100;
                c[31]++;
                buttons[31].setText(c[31] + "");
                l.add("komplet ort.");
                mp.start();
                break;

            case R.id.button17G:
                cenaG += 90;
                c[32]++;
                buttons[32].setText(c[32] + "");
                l.add("komplet ort.");
                mp.start();
                break;

            case R.id.button17K:
                cenaK += 90;
                c[33]++;
                buttons[33].setText(c[33] + "");
                l.add("komplet ort.");
                mp.start();
                break;

            case R.id.button18G:
                cenaG += 5;
                c[34]++;
                buttons[34].setText(c[34] + "");
                l.add("CD+klisza");
                mp.start();
                break;

            case R.id.button18K:
                cenaK += 5;
                c[35]++;
                buttons[35].setText(c[35] + "");
                l.add("CD+klisza");
                mp.start();
                break;

            case R.id.button19G:
                cenaG += 250;
                c[36]++;
                buttons[36].setText(c[36] + "");
                l.add("tk 2 zatok");
                mp.start();
                break;

            case R.id.button19K:
                cenaK += 250;
                c[37]++;
                buttons[37].setText(c[37] + "");
                l.add("tk 2 zatok");
                mp.start();
                break;

            case R.id.button20G:
                cenaG += 195;
                c[38]++;
                buttons[38].setText(c[38] + "");
                l.add("tk ucha");
                mp.start();
                break;

            case R.id.button20K:
                cenaK += 195;
                c[39]++;
                buttons[39].setText(c[39] + "");
                l.add("tk ucha");
                mp.start();
                break;

            case R.id.button21G:
                cenaG += 390;
                c[40]++;
                buttons[40].setText(c[40] + "");
                l.add("tk 2 uszu");
                mp.start();
                break;

            case R.id.button21K:
                cenaK += 390;
                c[41]++;
                buttons[41].setText(c[41] + "");
                l.add("tk 2 uszu");
                mp.start();
                break;

            case R.id.button22G:
                cenaG += 50;
                c[42]++;
                buttons[42].setText(c[42] + "");
                l.add("zd. st. skroniowo-zuchwowych");
                mp.start();
                break;

            case R.id.button22K:
                cenaK += 50;
                c[43]++;
                buttons[43].setText(c[43] + "");
                l.add("zd. st. skroniowo-zuchwowych");
                mp.start();
                break;

            case R.id.button23G:
                cenaG += 195;
                c[44]++;
                buttons[44].setText(c[44] + "");
                l.add("TK zatoki");
                mp.start();
                break;

            case R.id.button23K:
                cenaK += 195;
                c[45]++;
                buttons[45].setText(c[45] + "");
                l.add("TK zatoki");
                mp.start();
                break;
        }


    }



    public String Generuj() {
        String generator = "";
        int x;

        while(l.size() > 0) {
            String someString=l.remove(0);
            x=1;
            for (int i = 0; i < l.size();) {
                if(l.get(i).equals(someString)){
                    x++;
                    l.remove(i);
                }else{
                    i++;
                }
            }
            m.add("\n" + x + "x " + someString);
        }
        for (int i = 0; i < m.size(); i++) {
            generator = generator.concat(m.get(i));
        }
        return generator;
    }


    //NOT WORKING YET
    public String Numer(){
//        String x =Settings.WezNumer();

        String x= "123456789";
//        String x= "600074124, 784468298";
        return x;
    }
}