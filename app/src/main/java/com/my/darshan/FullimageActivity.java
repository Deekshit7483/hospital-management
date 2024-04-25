package com.my.darshan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.LinearLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class FullimageActivity extends AppCompatActivity {
	
	private LinearLayout linear1;
	private ImageView imageview2;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.fullimage);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
	}
	
	private void initializeLogic() {
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("image"))).into(imageview2);
		_initSlideActivity();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _initSlideActivity () {
		getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
		ViewConfiguration vc = ViewConfiguration.get(this);
		MIN_DISTANCE = vc.getScaledTouchSlop();
		
		rootView =(ViewGroup)getWindow().findViewById(Window.ID_ANDROID_CONTENT);
		//converts percent to 0-225 range .
		maxAlpha =(int) ((225.0d/100.0d)* MAX_SCRIM_ALPHA); 
		try{
			convertFromTranslucent = Activity.class.getDeclaredMethod("convertFromTranslucent");         convertFromTranslucent.setAccessible(true);
			java.lang.reflect.Method getActivityOptions = Activity.class.getDeclaredMethod("getActivityOptions"); 	getActivityOptions.setAccessible(true);
			options = getActivityOptions.invoke(this);
				Class<?>[] classes = Activity.class.getDeclaredClasses();
			 Class<?> translucentConversionListenerClazz = null;
				for (Class clazz : classes) {
						if (clazz.getSimpleName().contains("TranslucentConversionListener")) {
								translucentConversionListenerClazz = clazz; 
						} 
				} 
				 convertToTranslucent = Activity.class.getDeclaredMethod("convertToTranslucent", translucentConversionListenerClazz, ActivityOptions.class);
				convertToTranslucent.setAccessible(true);
		} catch (Exception e) {
			showMessage(e.toString());
			 }
	}
	// Custom Variables
	//You can change it to color of your choice 
	private static final int SCRIM_COLOR = 0xFF000000;
	//Alpha is not taken into consideration while calculating scrim color  so it dosent matter .
	
	private static final int  SCRIM_R = Color.red(SCRIM_COLOR);
	private static final int SCRIM_G = Color.green(SCRIM_COLOR);
	private static final int  SCRIM_B = Color.blue(SCRIM_COLOR);
	private static final int MAX_SCRIM_ALPHA= 80;
	//in percentage
	private ViewGroup rootView ;
	private boolean enableSwipe= false;
	private boolean lockSwipe = false;
	private float downX;
	private float downY;
	private float MIN_DISTANCE ;
	private int maxAlpha;
	private java.lang.reflect.Method convertFromTranslucent;
	private java.lang.reflect.Method getActivityOptions;
	
	private Object options;
	
	private java.lang.reflect.Method convertToTranslucent;
	// Detect touch Events
	 @Override public boolean dispatchTouchEvent(MotionEvent event) { 
		switch(event.getAction()) { 
			case MotionEvent.ACTION_DOWN: 
			downX = event.getRawX();
			downY =event.getRawY();
			enableSwipe = false;
			lockSwipe = false;
			//convert activity to transparent
			try {
					convertToTranslucent.invoke(this, null, options); 
			} catch (Throwable t) {
			}
			break; 
			case MotionEvent.ACTION_MOVE: 
			if (!lockSwipe){
				if(enableSwipe){
					float translation = event.getRawX() -downX - MIN_DISTANCE;
					if (translation >= rootView.getWidth() || translation<= 0){
						rootView.setTranslationX(0);
					}else{
						rootView.setTranslationX(translation);
						//calculate distance scrolled in percentage
						int distanceInPercentage =(int)( ((double)translation/(double)rootView.getWidth())*100);
						
						//calculate alpha from distance in range 0 - maxAlpha
						
						int alpha =(int) ( ((double)maxAlpha/100.0d)*distanceInPercentage);
						
						//alpha will be greater when it is scrolled more this we do not need this but we need the inverse of it so subtract it from maxAlpha
						alpha = maxAlpha - alpha;
						
						int scrimColor = Color.argb(alpha,SCRIM_R,SCRIM_G,SCRIM_B);
						
						getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(scrimColor));
					}
				}else{
					if(Math.abs(event.getRawY() - downY) >= MIN_DISTANCE){
						enableSwipe = false;
						lockSwipe = true;
					}else{
						enableSwipe = event.getRawX() -downX >= MIN_DISTANCE;
					}
				}
			}
			break; 
			case MotionEvent.ACTION_UP: 
			if(rootView.getTranslationX() > rootView.getWidth() / 5){
				rootView.animate() 
				.translationX(rootView.getWidth())
				.setListener(
				new AnimatorListenerAdapter() { 
							@Override public void onAnimationEnd(Animator animation) { 
						
							super.onAnimationEnd(animation);
						finish();
						overridePendingTransition(0, 0);
						
					} });
			}else{
				rootView.animate() 
				.translationX(0)
				.setListener(
				new AnimatorListenerAdapter() { 
							@Override public void onAnimationEnd(Animator animation) { 
						super.onAnimationEnd(animation);
						// convert activity back to normal
						try {
							 convertFromTranslucent.invoke(this);
							        } catch (Throwable t) {}
					} });
				enableSwipe =false;
				lockSwipe = false;
			}
			break; 
			default:
			enableSwipe =false;
			lockSwipe = false;
			break; 
		}
		if (enableSwipe){
			event.setAction(MotionEvent.ACTION_CANCEL);
		}
		return super.dispatchTouchEvent(event);
	}
	
	{
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}