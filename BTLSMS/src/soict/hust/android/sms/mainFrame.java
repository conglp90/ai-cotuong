package soict.hust.android.sms;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@TargetApi(16)
public class mainFrame extends Activity implements OnClickListener{
	Button b_contacts,b_search,b_exit,b_setting,b_sms,b_about;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        b_contacts = (Button) findViewById(R.id.contacts);
        b_exit = (Button) findViewById(R.id.exit);
        b_sms = (Button) findViewById(R.id.message);
        b_about=(Button) findViewById(R.id.about);
        b_exit.setOnClickListener(this);
        b_sms.setOnClickListener(this);
        b_contacts.setOnClickListener(this);
        b_about.setOnClickListener(this);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.main, menu);
        return true;
    }


	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.contacts:
				Intent i = new Intent(this, contactMain.class);
	            startActivity(i);
	            break;
			case R.id.message:
				Intent i1 = new Intent(this, smsMain.class);
	            startActivity(i1);
	            break;
			case R.id.about:
				Intent i2=new Intent(this,About.class);
				startActivity(i2);
				break;
			case R.id.exit:
			 	finish();
			 	break;
		}
		
	}
}
