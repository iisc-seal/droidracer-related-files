import java.io.BufferedReader;
import java.io.DataInputStream;  
import java.io.DataOutputStream;  
import java.io.IOException;  
import java.io.InputStreamReader;
import java.net.BindException;  
import java.net.ServerSocket;  
import java.net.Socket;  
import java.util.HashMap;
  
  
public class ABCServer {  
  
    /** 
     * This is server class which accepts all request through device and search for it..... 
     * @param args 
     */  
    private static boolean flag=true;  
  
    public static void main(String[] args) throws IOException, InterruptedException{  
    	long avgTraceGenerationTime = 0;
    	long avgRaceDetectionTime = 0;
    	int traceLength = 0;
    	int threadCount = 0;
    	int mqCount = 0;
    	int asyncCount = 0;
    	int eventDepth = 0;
    	int fieldCount = 0;
    	int multiRaceCount = 0;
    	int asyncRaceCount = 0;
    	int delayPostRaceCount = 0;
    	int crossPostRaceCount = 0;
    	int uiRacecount = 0;
    	int nonUiRaceCount = 0;
    	
    	int traceLimit = 500;
    	int port = 0;
    	int emulatorId = 5554;
    	
        ServerSocket serverSocket = null;  
        Socket socket = null;  
        DataInputStream dataInputStream = null;  
        DataOutputStream dataOutputStream = null;  
        int socketConnectionCount = 1;
       	    
	    
	intentAppMap.put("com.example.appreceivecall", "com.example.appreceivecall/.EntryActivity");
	intentAppMap.put("com.android.mms", "com.android.mms/.ui.ConversationList");
	intentAppMap.put("org.tomdroid", "org.tomdroid/.ui.Tomdroid");
	intentAppMap.put("aarddict.android", "aarddict.android/.LookupActivity");
	intentAppMap.put("com.facebook.katana", "com.facebook.katana/.LoginActivity");
	intentAppMap.put("com.twitter.android", "com.twitter.android/com.twitter.applib.StartActivity");
	intentAppMap.put("com.whatsapp", "com.whatsapp/.Main");
	intentAppMap.put("org.wikipedia", "org.wikipedia/.WikipediaActivity");
	intentAppMap.put("com.android.browser", "com.android.browser/.BrowserActivity");
	intentAppMap.put("com.android.music", "com.android.music/.MusicBrowserActivity");
	intentAppMap.put("bbc.mobile.news.ww", "bbc.mobile.news.ww/.HomeWwActivity");
	intentAppMap.put("com.imdb.mobile", "com.imdb.mobile/.HomeActivity");
	intentAppMap.put("com.bt.bms", "com.bt.bms/.activity.SplashActivity");
	intentAppMap.put("com.adobe.reader", "com.adobe.reader/.AdobeReader");
	intentAppMap.put("com.shanefulmer.algebratutor", "com.shanefulmer.algebratutor/.main.MainActivity");
	intentAppMap.put("com.google.android.maps.mytracks", 
	    		"com.google.android.maps.mytracks/com.google.android.apps.mytracks.TrackListActivity");
	intentAppMap.put("cz.romario.opensudoku", "cz.romario.opensudoku/.gui.FolderListActivity");
	intentAppMap.put("com.fsck.k9", "com.fsck.k9/.activity.Accounts");
	intentAppMap.put("name.boyle.chris.sgtpuzzles", "name.boyle.chris.sgtpuzzles/.SGTPuzzles");
	intentAppMap.put("org.geometerplus.zlibrary.ui.android", 
	    		"org.geometerplus.zlibrary.ui.android/org.geometerplus.android.fbreader.FBReader");
	intentAppMap.put("com.flipkart.android", "com.flipkart.android/.SplashActivity");
	intentAppMap.put("com.appsrox.remindme", "com.appsrox.remindme/.MainActivity");
	    
	    if(args.length == 3){
	    	port = Integer.valueOf(args[1]);
            emulatorId = Integer.valueOf(args[2]);
	        String[] cmd = { "bash", "-c", 
        		"<path-to-eclipse-workspace>/ModelCheckingServer/abcStartScript.sh" + " "+
        		intentAppMap.get(args[0]) + " " + emulatorId};
            Process pr1 = Runtime.getRuntime().exec(cmd);
            pr1.waitFor();            
	    }else{
	    	System.out.println("Give package name and port number for the app to be tested");
	    	System.exit(0);
	    }
	    
        try {  
            serverSocket = new ServerSocket(port); //port number  
            System.out.println("Listening :on port " + port);  
        }catch (BindException e ) {  
            System.out.println("port " + port +" is already used by some other program");  
            flag=false;  
        }   
        catch (IOException e) {  
            flag=false;  
            e.printStackTrace();  
        }  
        
        while(flag){  
            try {  
            	System.out.println("waiting for connection from emulator");
	                socket = serverSocket.accept(); //accept client connection  
	                dataInputStream = new DataInputStream(socket.getInputStream()); //read from client through inputstream  
	                dataOutputStream = new DataOutputStream(socket.getOutputStream());//write to stream through putputstream  
	                System.out.println("ip: " + socket.getInetAddress());  //ip of client   
	                
	                String input = dataInputStream.readUTF();
	                String[] inputArr = input.split(":");
	                
	                String packagePath = ""; //dummy
	                String startIntent = intentAppMap.get(inputArr[1]);
	                
	                System.out.println(inputArr[0] + " " + inputArr[1] + " " +
	                    inputArr[2] + " " + inputArr[3] + " " + inputArr[4] + " "
	                    + inputArr[5] + " " + inputArr[6] + " " + inputArr[7] 
	                    + " " + inputArr[8] + " "+ inputArr[9] + " " + inputArr[10]
	                    + " " + inputArr[11] + " " + inputArr[12] + " " + inputArr[13] 
	                    + " " + inputArr[14]);
	                
	                long tmpTraceGenTime = Long.valueOf(inputArr[2]).longValue();
	                long tmpRaceDetectTime = Long.valueOf(inputArr[3]).longValue();
	                int tmpTraceLength = Integer.valueOf(inputArr[4]).intValue();
	                int tmpMqCount = Integer.valueOf(inputArr[6]).intValue();
	                int tmpThreadCount = Integer.valueOf(inputArr[5]).intValue() - tmpMqCount;
	                int tmpAsyncCount = Integer.valueOf(inputArr[7]).intValue();
	                int tmpEventDepth = Integer.valueOf(inputArr[8]).intValue();
	                int tmpFieldCount = Integer.valueOf(inputArr[9]).intValue();
	                int tmpMultiRace = Integer.valueOf(inputArr[10]).intValue();
	                int tmpAsyncRace = Integer.valueOf(inputArr[11]).intValue();
	                int tmpDelayPost = Integer.valueOf(inputArr[12]).intValue();
	                int tmpCrossPost = Integer.valueOf(inputArr[13]).intValue();
	                int tmpUiRace = Integer.valueOf(inputArr[14]).intValue();
	                int tmpNonUiRace = Integer.valueOf(inputArr[15]);
	                
	                avgTraceGenerationTime += tmpTraceGenTime;
	                avgRaceDetectionTime += tmpRaceDetectTime;
	                traceLength += tmpTraceLength;
	                mqCount += tmpMqCount;
	                threadCount += tmpThreadCount;
	                asyncCount += tmpAsyncCount;
	                eventDepth += tmpEventDepth;
	                fieldCount += tmpFieldCount;
	                multiRaceCount += tmpMultiRace;
	                asyncRaceCount += tmpAsyncRace;
	                delayPostRaceCount += tmpDelayPost;
	                crossPostRaceCount += tmpCrossPost;
	                uiRacecount += tmpUiRace;
	                nonUiRaceCount += tmpNonUiRace;
	                		
	                
	                String line;
	                
	                int errCode = -1;
	                if(inputArr[0].equals("backtrack")){
	                	errCode = 0;
	                }else if(inputArr[0].equals("logError")){
	                	errCode = 1;
	                }else
	                	errCode = 2;
	               
	                if(errCode != 2){
	                String[] cmd = { "bash", "-c", 
	                		"<path-to-eclipse-workspace>/ModelCheckingServer/abc.sh" + " "+
	                        inputArr[1] + " " + packagePath + " " + startIntent + " " +
	                				String.valueOf(socketConnectionCount) + " " +
	                                String.valueOf(errCode) + " " +
	                				String.valueOf(tmpTraceGenTime) + " " + 
	                                String.valueOf(tmpRaceDetectTime) + " " +
	                                String.valueOf(tmpTraceLength) + " " + 
	                                String.valueOf(tmpThreadCount) + " " +
	                				String.valueOf(tmpMqCount) + " " + 
	                                String.valueOf(tmpAsyncCount) + " " +
	                                String.valueOf(tmpEventDepth) + " " + 
	                                String.valueOf(tmpFieldCount) + " " +
	                				String.valueOf(tmpMultiRace) + " " + 
	                                String.valueOf(tmpAsyncRace) + " " +
	                                String.valueOf(tmpDelayPost) + " " + 
	                                String.valueOf(tmpCrossPost) + " " +
	                                String.valueOf(tmpUiRace) + " " +
	                                String.valueOf(tmpNonUiRace) + " " +
	                                String.valueOf(emulatorId)};
	                Process pr = Runtime.getRuntime().exec(cmd);
	                
	                pr.waitFor();
	                BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
	                while ((line=buf.readLine())!=null) {
	                     System.out.println(line);
	                
	                }
	                }else{
	                	//race detection related stats
	                    traceLength = (int) Math.ceil((double)traceLength / socketConnectionCount); 
	                	threadCount = (int) Math.ceil((double)threadCount / socketConnectionCount);
	                	mqCount = (int) Math.ceil((double)mqCount / socketConnectionCount);
	                	asyncCount = (int) Math.ceil((double)asyncCount / socketConnectionCount);
	                	eventDepth = (int) Math.ceil((double)eventDepth / socketConnectionCount);
	                	fieldCount = (int) Math.ceil((double)fieldCount / socketConnectionCount);
	                	multiRaceCount = (int) Math.ceil((double)multiRaceCount / socketConnectionCount);
	                	asyncRaceCount = (int) Math.ceil((double)asyncRaceCount / socketConnectionCount);
	                	delayPostRaceCount = (int) Math.ceil((double)delayPostRaceCount / socketConnectionCount);
	                	crossPostRaceCount = (int) Math.ceil((double)crossPostRaceCount / socketConnectionCount);
	                	uiRacecount = (int) Math.ceil((double)uiRacecount / socketConnectionCount);
	                	nonUiRaceCount = (int) Math.ceil((double)nonUiRaceCount / socketConnectionCount);
	                	
	                	avgTraceGenerationTime = avgTraceGenerationTime / socketConnectionCount;
	                	avgRaceDetectionTime = avgRaceDetectionTime / socketConnectionCount;
	                	
	                	String[] cmd = { "bash", "-c", 
	                    		"<path-to-eclipse-workspace>/ModelCheckingServer/abcStopScript.sh"
	                			+ " " + String.valueOf(socketConnectionCount) + " "
	                    	    + String.valueOf(traceLength) + " "
	                			+ String.valueOf(threadCount) + " "
	                			+ String.valueOf(mqCount) + " "
	                			+ String.valueOf(asyncCount) + " "
	                			+ String.valueOf(eventDepth) + " "
	                			+ String.valueOf(fieldCount) + " "
	                			+ String.valueOf(avgTraceGenerationTime) + " "
	                			+ String.valueOf(avgRaceDetectionTime) + " "
	                			+ String.valueOf(multiRaceCount) + " "
	                			+ String.valueOf(asyncRaceCount) + " "
	                			+ String.valueOf(delayPostRaceCount) + " "
	                			+ String.valueOf(crossPostRaceCount) + " "
	                			+ String.valueOf(uiRacecount) + " "
	                			+ String.valueOf(nonUiRaceCount) + " "
	                			+ inputArr[1]};
	                    Process pr1 = Runtime.getRuntime().exec(cmd);
	                    pr1.waitFor();   
	                    
	                    break;
	                }
	                if(socketConnectionCount >= traceLimit){
	                	//race detection related stats
	                	traceLength = (int) Math.ceil((double)traceLength / socketConnectionCount); 
	                	threadCount = (int) Math.ceil((double)threadCount / socketConnectionCount);
	                	mqCount = (int) Math.ceil((double)mqCount / socketConnectionCount);
	                	asyncCount = (int) Math.ceil((double)asyncCount / socketConnectionCount);
	                	eventDepth = (int) Math.ceil((double)eventDepth / socketConnectionCount);
	                	fieldCount = (int) Math.ceil((double)fieldCount / socketConnectionCount);
	                	multiRaceCount = (int) Math.ceil((double)multiRaceCount / socketConnectionCount);
	                	asyncRaceCount = (int) Math.ceil((double)asyncRaceCount / socketConnectionCount);
	                	delayPostRaceCount = (int) Math.ceil((double)delayPostRaceCount / socketConnectionCount);
	                	crossPostRaceCount = (int) Math.ceil((double)crossPostRaceCount / socketConnectionCount);
	                	uiRacecount = (int) Math.ceil((double)uiRacecount / socketConnectionCount);
	                	nonUiRaceCount = (int) Math.ceil((double)nonUiRaceCount / socketConnectionCount);
	             
	                	avgTraceGenerationTime = avgTraceGenerationTime / traceLimit;
	                	avgRaceDetectionTime = avgRaceDetectionTime / traceLimit;
	                	
	                	String[] cmd = { "bash", "-c", 
	                    		"<path-to-eclipse-workspace>/ModelCheckingServer/abcStopScript.sh"
	                			+ " " + String.valueOf(socketConnectionCount) + " "
	                    	    + String.valueOf(traceLength) + " "
	                			+ String.valueOf(threadCount) + " "
	                			+ String.valueOf(mqCount) + " "
	                			+ String.valueOf(asyncCount) + " "
	                			+ String.valueOf(eventDepth) + " "
	                			+ String.valueOf(fieldCount) + " "
	                			+ String.valueOf(avgTraceGenerationTime) + " "
	                			+ String.valueOf(avgRaceDetectionTime) + " "
	                			+ String.valueOf(multiRaceCount) + " "
	                			+ String.valueOf(asyncRaceCount) + " "
	                			+ String.valueOf(delayPostRaceCount) + " "
	                			+ String.valueOf(crossPostRaceCount) + " "
	                			+ String.valueOf(uiRacecount) + " "
	                			+ String.valueOf(nonUiRaceCount) + " "
	                			+ inputArr[1] + " "
	                			+ String.valueOf(emulatorId)};
	                    Process pr2 = Runtime.getRuntime().exec(cmd);
	                    pr2.waitFor();
	                    
	                	break;
	                }
	                
	                System.out.println("Sequence count:" + String.valueOf(socketConnectionCount++));
	               
                } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
            finally{  
                if( socket!= null){  
                    try {  
                        //close socket connection after using it otherwise next time when u reconnect on  the same port  
                        // it will throw error if you dont close it   
                        socket.close();  
                    } catch (IOException e) {  
                        // TODO Auto-generated catch block  
                        e.printStackTrace();  
                    }  
                }  
  
                if( dataInputStream!= null){  
                    try {  
                        //close inputsteam  
                        dataInputStream.close();  
                    } catch (IOException e) {  
                        // TODO Auto-generated catch block  
                        e.printStackTrace();  
                    }  
                }  
  
                if( dataOutputStream!= null){  
                    try {  
                        //close outputstream  
                        dataOutputStream.close();  
                    } catch (IOException e) {
                        e.printStackTrace();  
                    }  
                }  
            }  
        }  
    }  
  
}  
