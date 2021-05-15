package food.app.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FoodDetailActivity extends AppCompatActivity {

    ImageView food_back;
    TextView food_name, food_price;
    ImageView food_image;
    TextView ordernow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        food_back = findViewById(R.id.food_back);
        food_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();

        food_name = findViewById(R.id.food_name);
        food_price = findViewById(R.id.food_price);
        food_image = findViewById(R.id.food_image);

        food_name.setText(intent.getStringExtra("food_name"));
        food_price.setText(intent.getStringExtra("food_price"));
        food_image.setImageResource(intent.getIntExtra("food_image", R.drawable.food_img_1));

        ordernow = findViewById(R.id.food_order);
        ordernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orderFood = new Intent(Intent.ACTION_SENDTO);
                orderFood.setData(Uri.parse("mailto:"));
                String[] email = {"YourEmail@gmail.com", "", ""};
                String subject = "New Order for " + intent.getStringExtra("food_name" + "!");
                String text = "Order Details \n\n " + "Food Name: " + intent.getStringExtra("food_name" + "\nFood Price: " + intent.getStringExtra("food_price")
                        + "Address: ");
                orderFood.putExtra(Intent.EXTRA_EMAIL, email);
                orderFood.putExtra(Intent.EXTRA_SUBJECT, subject);
                orderFood.putExtra(Intent.EXTRA_TEXT, text);
                if (orderFood.resolveActivity(getApplicationContext().getPackageManager()) != null) {
                    startActivity(orderFood);
                }
            }
        });

    }
}