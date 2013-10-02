package com.adrian.droidcraft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.androidquery.AQuery;

public class MainActivity extends Activity {
	private AQuery aq;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		aq = new AQuery(this);
		aq.id(R.id.btn_display).clicked(this,"displayButtonClicked");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void displayButtonClicked(View button) {
		String realm = aq.id(R.id.et_realm).getText().toString();
		String guild = aq.id(R.id.et_guild).getText().toString();
		
		//TODO Verify that this text values are not null before sending.

		Intent guildLevelChart = new Intent(this,GuildLevelChartActivity.class);
		guildLevelChart.putExtra("realm", realm);
		guildLevelChart.putExtra("guild", guild);
		
		startActivity(guildLevelChart);
	}

}
