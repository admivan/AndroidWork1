package ru.dolgov.androidwork1;


import static android.graphics.Color.parseColor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttontext;
    private Button button2;
    private Button buttonwork2;
    private TextView textView;
    private EditText editText;
    private Switch colorSwitch;
    private ToggleButton toggleTheme;

    /**
     * Не претендую на самое лучшее делал все из головы
     * Не знаю как сохранять возможность нажатия при переключение layout по этому были
     * сделаны 2 глупых метода что бы не сбрасывал возможности OnClick
     * Так же не понятно почему не весь текст курсивом в TextView
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onInitializationViewOne(); //Вызов метода
    }

    /**
     * Метод выполнения кликом на кнопки
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                if (editText.length() == 0) {
                    textView.setText("Вы не ввели текст"); //Вывод сообщения если текст не введет
                } else {
                    textView.setText(editText.getText());//Вывод текста и з едет в текствиев
                }
                break;
            case R.id.button2:
                setContentView(R.layout.activity_main);// Переход между layout2 на  layout
                onInitializationViewOne();
                break;
            case R.id.buttonwork2:
                setContentView(R.layout.my_new_activity);// Переход между layout на layout2
                onInitializationViewTo();
                break;
            case R.id.color_switch:
                /**
                 *  Смена фона текствиев
                 */
                if (colorSwitch.isChecked()) {
                    textView.setBackgroundColor(parseColor("#FFFFFF"));
                } else {
                    textView.setBackgroundColor(parseColor("#EA56C0"));
                }
                break;
            case R.id.theme:
                /**
                 * Вкл выкл с выводом сообщения
                 */
                if (toggleTheme.isChecked()) {
                    textView.setText("ToggleButton включен");
                } else {
                    textView.setText("ToggleButton выключен");
                }
                break;
        }
    }

    /**
     * Так как не умею хранить состояние еще сделал метод для постоянной инициализации кнопок
     */
    public void onInitializationViewOne() {
        buttonwork2 = findViewById(R.id.buttonwork2);
        buttonwork2.setOnClickListener(this);
        buttontext = findViewById(R.id.button);
        buttontext.setOnClickListener(this);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.edit_text);
        colorSwitch = findViewById(R.id.color_switch);
        colorSwitch.setOnClickListener(this);
        toggleTheme = findViewById(R.id.theme);
        toggleTheme.setOnClickListener(this);
    }

    /**
     * Так как не умею хранить состояние еще сделал метод для постоянной инициализации кнопок
     */
    public void onInitializationViewTo() {
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }
}