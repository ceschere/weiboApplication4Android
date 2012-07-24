package org.cesc.weibo_application.ui;

import org.cesc.weibo_application.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 主屏幕类
 * 
 * @author cesc
 * 
 */
public class MainPageActivity extends Activity implements OnClickListener, AnimationListener {

	//	设置微博按钮
	private Button setSinaWeiboButton, setTencetWeiboButton;

	private LinearLayout tipsAreaLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.content_main_layout);

		initViews();

		registerEvents();
	}

	private void initViews() {
		// TODO Auto-generated method stub

		setSinaWeiboButton = (Button) this
				.findViewById(R.id.button_set_sina_weibo_button);
		
		setTencetWeiboButton = ( Button )this.findViewById(R.id.button_set_tencent_weibo_button);

		tipsAreaLayout = (LinearLayout) this
				.findViewById(R.id.tips_area_layout);
	}

	private void registerEvents() {
		// TODO Auto-generated method stub

		setSinaWeiboButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button_set_sina_weibo_button:

			setSinaWeiboLogic();

			break;

		default:
			break;
		}

	}

	private void setSinaWeiboLogic() {

		tipsAreaLayout.setVisibility(View.VISIBLE);
		tipsAreaLayout.startAnimation(AnimationUtils.loadAnimation(this,
				R.anim.tip_anim_to_show));

	}

	
	/**
	 * 按下后退键逻辑
	 */
	private void onBackLogic(){
		
		if( tipsAreaLayout.getVisibility() == View.VISIBLE ){
			
			tipsAreaLayout.setVisibility( View.GONE );
			
			Animation anim = AnimationUtils.loadAnimation( this , R.anim.tip_anim_to_hide );
			
			anim.setAnimationListener( this );
			
			tipsAreaLayout.startAnimation( anim );
			
			
		}else{
			
			System.exit( 0 );
		}
		
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub

		switch (keyCode) {

		case KeyEvent.KEYCODE_BACK:
			
			onBackLogic();
			
			break;

		default:
			break;
		}

		return true;
	}

	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub
		
		tipsAreaLayout.setVisibility( View.GONE );
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	
	
}
