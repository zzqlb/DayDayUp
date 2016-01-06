package org.cocos2dx.cpp;
import android.os.Handler;
import android.os.Message;

public class JniTestHelper
{
	private static Handler mHandler;
	public static void init(Handler handler)
	{
		JniTestHelper.mHandler = handler;
	}
	//c++��芥�帮��������native琛ㄧず��芥�颁�����java���锛�������澶����c/c++瀹���扮��
	public static native void setPackageName(String packageName);
	public static native void exitApp();

	private static void showTipDialog(final String title,final String text)
	{
		System.out.print("--------------");
		Message msg = mHandler.obtainMessage();
		msg.what = AppActivity.SHOW_DIALOG;
		DialogMessage dm = new DialogMessage();
		dm.title = title;
		dm.msg = text;
		msg.obj = dm;
		msg.sendToTarget();
	}
}