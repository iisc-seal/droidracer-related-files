package abc.abcclientapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.util.Log;

public class ModelCheckingClient implements Runnable {

	private static final int FLAG_ERROR = 0;
	private static final int FLAG_NO_ERROR = 1;
	private static final int FLAG_STOP = 2;
	

	private String packageName = "";
	String errorFlag = "";
	long traceGenerationTime = 0;
	long raceDetectionTime = 0;
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
	int abcPort = 0;
	String command;

	public ModelCheckingClient(int flag, String packageName,
			long traceGenerationTime, long raceDetectionTime, int traceLength,
			int threadCount, int mqCount, int asyncCount, int eventDepth,
			int fieldCount, int multiRaceCount, int asyncRaceCount,
			int delayPostRaceCount, int crossPostRaceCount, int uiRacecount,
			int nonUiRaceCount, int abcPort) {
		Log.e("ABC", "package sent on socket: " + packageName);
		switch (flag) {
		case FLAG_ERROR:
			this.errorFlag = "logError";
			break;
		case FLAG_NO_ERROR:
			this.errorFlag = "backtrack";
			break;
		case FLAG_STOP:
			this.errorFlag = "stopABC";
			break;
		default:
			Log.e("Android-Bug-Checker",
					"error code did not match pre-defined codes");
		}

		this.packageName = packageName;
		this.traceGenerationTime = traceGenerationTime;
		this.raceDetectionTime = raceDetectionTime;
		this.traceLength = traceLength;
		this.threadCount = threadCount;
		this.mqCount = mqCount;
		this.asyncCount = asyncCount;
		this.eventDepth = eventDepth;
		this.fieldCount = fieldCount;
		this.multiRaceCount = multiRaceCount;
		this.asyncRaceCount = asyncRaceCount;
		this.delayPostRaceCount = delayPostRaceCount;
		this.crossPostRaceCount = crossPostRaceCount;
		this.uiRacecount = uiRacecount;
		this.nonUiRaceCount = nonUiRaceCount;
		this.abcPort = abcPort;
	}

	public void run() {
		Socket socket = null;
		DataOutputStream dataOutputStream = null;
		DataInputStream dataInputStream = null;

		try {
			socket = new Socket("10.0.2.2", abcPort);

			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());
			
				dataOutputStream.writeUTF(errorFlag + ":" + packageName + ":"
						+ String.valueOf(traceGenerationTime) + ":"
						+ String.valueOf(raceDetectionTime) + ":"
						+ String.valueOf(traceLength) + ":"
						+ String.valueOf(threadCount) + ":"
						+ String.valueOf(mqCount) + ":"
						+ String.valueOf(asyncCount) + ":"
						+ String.valueOf(eventDepth) + ":"
						+ String.valueOf(fieldCount) + ":"
						+ String.valueOf(multiRaceCount) + ":"
						+ String.valueOf(asyncRaceCount) + ":"
						+ String.valueOf(delayPostRaceCount) + ":"
						+ String.valueOf(crossPostRaceCount) + ":"
						+ String.valueOf(uiRacecount) + ":"
						+ String.valueOf(nonUiRaceCount));
				Log.i("abcClient", "err:" + errorFlag + " package:"
						+ packageName + " traceTime:" + traceGenerationTime
						+ " raceTime:" + raceDetectionTime);
				Log.i("abcClient", "trace:" + traceLength + " threads:"
						+ threadCount + " mq:" + mqCount + " async:"
						+ asyncCount + " cb:" + eventDepth + " field:"
						+ fieldCount + " multi-races:" + multiRaceCount
						+ " async-races:" + asyncRaceCount
						+ " delay-post-races:" + delayPostRaceCount
						+ " cross-post-races:" + crossPostRaceCount
						+ " ui-races:" + uiRacecount + " non-ui-races:"
						+ nonUiRaceCount);
			
		} catch (UnknownHostException e) {
			// if specified ip address is not found in the network
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					// close socket connection after using it otherwise next
					// time when u reconnect on the same port
					// it will throw error if you dont close it

					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (dataOutputStream != null) {
				try {
					dataOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (dataInputStream != null) {
				try {
					// close inputsteam
					dataInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
