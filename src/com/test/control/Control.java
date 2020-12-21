package com.test.control;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import com.test.model.Model;
import com.test.model.intf.ModelListener;
import com.test.view.App;
import com.test.view.intf.AppListener;

public class Control implements AppListener,ModelListener {

	private static Control INSTANCE;
	
	private final App app=new App();
	private final Model model=new Model();
	
	private final ExecutorService taskQueue=Executors.newSingleThreadExecutor(new ThreadFactory() {
		
		@Override
		public Thread newThread(Runnable r) {
			// TODO Auto-generated method stub
			Thread thread=new Thread(r);
			thread.setDaemon(true);
			
			return thread;
		}
	});
	
	private Control() {
		// TODO Auto-generated constructor stub
		registerListener();
	}
	
	public static Control getInstance()
	{
		if(INSTANCE==null)
		{
			INSTANCE=new Control();
		}
		
		return INSTANCE;
	}
	
	private void registerListener()
	{
		app.addListener(this);
	}
	
	public void start()
	{
		app.initChooseRowAndColumn();
	}
}
