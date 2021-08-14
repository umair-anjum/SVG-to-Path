package com.example.svgpathsetting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;



public class MoveViewTouchListener
        implements View.OnTouchListener {

    public boolean isMoveAble = true;
    public EditTextCallBacks callBacks = null;
    boolean doubleTapped = false;
    float dX, dY;
    private GestureDetector mGestureDetector;
    private View mView;
    private Context mContext;
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 100f;
    public int mode;
    final int zoom = 2;
    final int move = 1;
    Resources r;
    float px;
    View doubleView;

    private Float parentWidth = 0f, parentHeight = 0f;

    private GestureDetector.OnGestureListener mGestureListener = new GestureDetector.SimpleOnGestureListener() {

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        // event when double tap occurs
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean onDoubleTap(MotionEvent e) {

            return true;
        }
    };

    public MoveViewTouchListener(Context context, View view) {

        mGestureDetector = new GestureDetector(context, mGestureListener);
        mContext = context;
        mView = view;
        mode = move;
        doubleView = view;
        mScaleGestureDetector = new ScaleGestureDetector(context, new ScaleListener());
        //mScaleFactor = view.getTextSize();

        // Converts  dip into its equivalent px
        float dip = 409.50f;
        r = mContext.getResources();
        px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dip,
                r.getDisplayMetrics()
        );


    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        mGestureDetector.onTouchEvent(event);
        mScaleGestureDetector.onTouchEvent(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                // Log.e("load", "" + parentHeight + "/" + parentWidth);

                mode = move;
                mScaleGestureDetector = new ScaleGestureDetector(mContext, new ScaleListener());
                dX = mView.getX() - event.getRawX();
                dY = mView.getY() - event.getRawY();

                //mView.setCursorVisible(false);
                break;
            case MotionEvent.ACTION_MOVE:

                if (isMoveAble) {

                    if (mode == move) {

                        /*if (mView.getX() > 0 - (mView.getWidth() / 2)
                                && mView.getX() < ((EditingView) mContext).getLayoutMove().getWidth()- (mView.getWidth() / 2)
                                && mView.getY() > 0 - (mView.getHeight() / 2)
                                && mView.getY() < ((EditingView) mContext).getLayoutMove().getHeight() - (mView.getHeight() / 2)) {
                            mView.animate()
                                    .x(event.getRawX() + dX)
                                    .y(event.getRawY() + dY)
                                    .setDuration(0)
                                    .start();
                        }
                        else {
                            if (mView.getX() < 0 - (mView.getWidth() / 2)) {
                                mView.setX(mView.getX() + 10);
                                Log.e("textTouch", "ACTION_UP: " + doubleTapped);
                            }
                            if (mView.getX() > ((EditingView) mContext).getLayoutMove().getWidth() - (mView.getWidth() / 2)) {
                                mView.setX(mView.getX() - 10);
                            }
                            if (mView.getY() < 0 - (mView.getHeight() / 2)) {
                                mView.setY(mView.getY() + 10);
                            }
                            if (mView.getY() > ((EditingView) mContext).getLayoutMove().getHeight() - (mView.getHeight() / 2)) {
                                mView.setY(mView.getY() - 10);
                            }
                        }*/

                       /* mView.animate()
                                .x(event.getRawX() + dX)
                                .y(event.getRawY() + dY)
                                .setDuration(0)
                                .start();*/

                       /* if (mView.getX() > 0 - (mView.getWidth() / 2)
                                && mView.getX() < (((EditingView) mContext).parentView.getWidth() - mView.getWidth()) + (mView.getWidth() / 2)) {
                            mView.animate()
                                    .x(event.getRawX() + dX)
                                    .y(event.getRawY() + dY)
                                    .setDuration(0)
                                    .start();
                        }*/

                        if (mView.getX() > 0 - (mView.getWidth() / 2) && mView.getX() < parentWidth - (mView.getWidth() / 2)
                                && mView.getY() > 0 - (mView.getHeight() / 2) && mView.getY() < parentHeight - (mView.getHeight() / 2)) {
                            mView.animate()
                                    .x(event.getRawX() + dX)
                                    .y(event.getRawY() + dY)
                                    .setDuration(0)
                                    .start();
                        }

                       /* if (mView.getX() > 0 - (mView.getWidth() / 2) && mView.getX() < parentWidth - (mView.getWidth() / 2)
                                && mView.getY() > 0 - (mView.getHeight() / 2) && mView.getY() < parentHeight - (mView.getHeight() / 2)) {
                            mView.animate()
                                    .x(event.getRawX() + dX)
                                    .y(event.getRawY() + dY)
                                    .setDuration(0)
                                    .start();
                        }
                        else {

                            if (mView.getX() < 0 - (mView.getWidth() / 2)) {
                                mView.setX(mView.getX() + 10);
                                Log.e("textTouch", "ACTION_UP: " + doubleTapped);
                            }

                            if (mView.getX() > parentWidth - (mView.getWidth() / 2)) {
                                mView.setX(mView.getX() - 10);
                            }

                            if (mView.getY() < 0 - (mView.getHeight() / 2)) {
                                mView.setY(mView.getY() + 10);
                            }

                            if (mView.getY() > parentHeight - (mView.getHeight() / 2)) {
                                mView.setY(mView.getY() - 10);
                            }

                        }*/


                    }
                }

                Log.e("textTouch", "ACTION_MOVE");
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                mode = zoom;
            case MotionEvent.ACTION_UP:

                if (mView.getX() < 0 - (mView.getWidth() / 2)) {
                    mView.setX(mView.getX() + 10);
                    Log.e("textTouch", "ACTION_UP: " + doubleTapped);
                }

                if (mView.getX() > parentWidth - (mView.getWidth() / 2)) {
                    mView.setX(mView.getX() - 10);
                }

                if (mView.getY() < 0 - (mView.getHeight() / 2)) {
                    mView.setY(mView.getY() + 10);
                }

                if (mView.getY() > parentHeight - (mView.getHeight() / 2)) {
                    mView.setY(mView.getY() - 10);
                }

                break;
            default:
                return false;
        }
        return true;
    }

    private void showTextToolTip(int visible) {
        Log.e("texttooltip", "texttooltip visiblity" + visible);
    }

    public interface EditTextCallBacks {
        void showTextControls();

    }

    public class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            Log.e("scale", "Before: " + scaleGestureDetector.getScaleFactor());
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(49f, Math.min(mScaleFactor, 299f));
            Log.e("scale", "After: " + mScaleFactor);
            if (mode == zoom) {
                if (isMoveAble) {
                    if (mScaleFactor > 50 && mScaleFactor < 300) {
                       /* if (mContext instanceof EditingActivity) {
                            //((EditingActivity) mContext).onTextSize(Math.round(mScaleFactor));

                        }*/
                    }
                }
            }
            return true;

        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            mode = zoom;
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            // Intentionally empty
        }
    }


}

