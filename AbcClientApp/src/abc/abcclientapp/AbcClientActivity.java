/*
 * Copyright (C) 2013, Indian Institute of Science
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* 
 * Author: Pallavi Maiya
 */

package abc.abcclientapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class AbcClientActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_abc_client);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_abc_client, menu);
		return true;
	}
	
	 @Override()
	    protected void onResume(){
	    	super.onResume();  
	    	
	    	Intent intent = getIntent();
	    	String packageName = intent.getStringExtra("package");
	    	int errCode = intent.getIntExtra("errCode", -1);
	    	long traceGenerationTime = intent.getLongExtra("traceGenerationTime", 0);
	    	long raceDetectionTime = intent.getLongExtra("raceDetectionTime", 0);
	    	int traceLength = intent.getIntExtra("traceLength", 0);
	    	int threadCount = intent.getIntExtra("threadCount", 0);
	    	int mqCount = intent.getIntExtra("mqCount", 0);
	    	int asyncCount = intent.getIntExtra("asyncCount", 0);
	    	int eventDepth = intent.getIntExtra("eventDepth", 0);
	    	int fieldCount = intent.getIntExtra("fieldCount", 0);
	    	int multiRaceCount = intent.getIntExtra("multiRaceCount", 0);
	    	int asyncRaceCount = intent.getIntExtra("asyncRaceCount", 0);
	    	int delayPostRaceCount = intent.getIntExtra("delayPostRaceCount", 0);
	    	int crossPostRaceCount = intent.getIntExtra("crossPostRaceCount", 0);
	    	int uiRacecount = intent.getIntExtra("uiRacecount", 0);
	    	int nonUiRaceCount = intent.getIntExtra("nonUiRaceCount", 0);
	    	int abcPort = intent.getIntExtra("abcPort", 8888);	    	
	    	
	    	Thread worker = new Thread(new ModelCheckingClient(errCode, packageName,
	    			traceGenerationTime, raceDetectionTime, traceLength, threadCount,
	    			mqCount, asyncCount, eventDepth, fieldCount, multiRaceCount, 
	    			asyncRaceCount, delayPostRaceCount, crossPostRaceCount, uiRacecount,
	    			nonUiRaceCount, abcPort)); 
	    	
			worker.start();
			
	 }
}
