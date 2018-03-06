package io.jeffchang.buttondemo.ui.common;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import io.jeffchang.buttondemo.R;

/**
 * Displays a view that represents an error if the results are empty.
 */

public class ErrorView extends RelativeLayout {

    public ErrorView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ErrorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ErrorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, 0);
    }

    public void init(Context context, AttributeSet attrs, int defStyleAttr) {
        View view = inflate(context, R.layout.view_error, this);
        TextView descriptionTextView =
                view.findViewById(R.id.error_view_error_description_textview);

        // Creating an underline under the text.
        SpannableString tryAgainSpan = new SpannableString(descriptionTextView.getText());
        tryAgainSpan.setSpan(new UnderlineSpan(),0, tryAgainSpan.length(), 0);
        descriptionTextView.setText(tryAgainSpan);
    }
}
